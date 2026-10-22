package android.os.collector;

import android.os.SystemClock;
import android.os.collector.base.StepOSBaseEntity;
import android.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class StepOSCollectEvent {
    public static final int BOOLEAN_SIZE = 1;
    public static final int ERROR_ANNOTATION_DOES_NOT_FOLLOW_FIELD = 32;
    public static final int ERROR_ANNOTATION_ID_TOO_LARGE = 128;
    public static final int ERROR_ATOM_ID_INVALID_POSITION = 8192;
    public static final int ERROR_ATTRIBUTION_CHAIN_TOO_LONG = 8;
    public static final int ERROR_ATTRIBUTION_UIDS_TAGS_SIZES_NOT_EQUAL = 4096;
    public static final int ERROR_INVALID_ANNOTATION_ID = 64;
    public static final int ERROR_LIST_TOO_LONG = 16384;
    public static final int ERROR_NO_ATOM_ID = 2;
    public static final int ERROR_NO_TIMESTAMP = 1;
    public static final int ERROR_OVERFLOW = 4;
    public static final int ERROR_TOO_MANY_ANNOTATIONS = 256;
    public static final int ERROR_TOO_MANY_ARRAY_MAP = 17;
    public static final int ERROR_TOO_MANY_FIELDS = 512;
    public static final int ERROR_TOO_MANY_KEY_VALUE_PAIRS = 16;
    public static final int FLOAT_SIZE = 4;
    public static final int INT_SIZE = 4;
    private static final int LOGGER_ENTRY_MAX_PAYLOAD = 4068;
    public static final int LONG_SIZE = 8;
    public static final int MAX_ANNOTATION_COUNT = 15;
    public static final int MAX_ARRAY_MAP_SIZE = 20;
    public static final int MAX_ATTRIBUTION_NODES = 127;
    public static final int MAX_KEY_VALUE_PAIRS = 127;
    public static final int MAX_NUM_ELEMENTS = 127;
    private static final int MAX_PULL_PAYLOAD_SIZE = 51200;
    private static final int MAX_PUSH_PAYLOAD_SIZE = 4064;
    private static final String TAG = "StepOSCollectEvent";
    public static final byte TYPE_ATTRIBUTION_CHAIN = 9;
    public static final byte TYPE_BOOLEAN = 5;
    public static final byte TYPE_BYTE_ARRAY = 6;
    public static final byte TYPE_ERRORS = 15;
    public static final byte TYPE_FLOAT = 4;
    public static final byte TYPE_INT = 0;
    public static final byte TYPE_KEY_VALUE_PAIRS = 8;
    public static final byte TYPE_LIST = 3;
    public static final byte TYPE_LONG = 1;
    public static final byte TYPE_MAP = 10;
    public static final byte TYPE_MESSAGE = 11;
    public static final byte TYPE_OBJECT = 7;
    public static final int TYPE_SIZE = 1;
    public static final byte TYPE_STRING = 2;
    private int mAtomId;
    private Buffer mBuffer;
    private StepOSBaseEntity mEntity;
    private boolean mIsValid;
    private int mNumBytes;
    private byte[] mPayload;

    private StepOSCollectEvent(int atomId, Buffer buffer, byte[] payload, int numBytes) {
        this.mAtomId = atomId;
        this.mBuffer = buffer;
        this.mPayload = payload;
        this.mNumBytes = numBytes;
        this.mEntity = null;
        this.mIsValid = true;
    }

    public StepOSCollectEvent() {
        this.mIsValid = false;
        this.mEntity = null;
    }

    public void setBytes(byte[] buffer) {
        this.mPayload = buffer;
        this.mNumBytes = buffer.length;
    }

    public boolean parseBuffer() {
        if (this.mPayload == null || this.mNumBytes < 11) {
            Log.e(TAG, "parseBuffer: Invalid buffer data. NumBytes=" + this.mNumBytes);
            return false;
        }
        this.mAtomId = ((this.mPayload[15] & 255) << 24) | ((this.mPayload[14] & 255) << 16) | ((this.mPayload[13] & 255) << 8) | (this.mPayload[12] & 255);
        if (!parseEntity()) {
            Log.e(TAG, "parseBuffer: Failed to parse entity for atomId=" + this.mAtomId);
            return false;
        }
        this.mIsValid = true;
        return true;
    }

    private boolean parseEntity() {
        StepOSBaseEntity instance = StepOSEntityRegistry.create(this.mAtomId);
        if (instance == null) {
            Log.d(TAG, "parseEntity: no factory for atomId=0x" + Integer.toHexString(this.mAtomId));
            return false;
        }
        this.mEntity = instance.parseBufferGeneric(this.mPayload, 11);
        return this.mEntity != null;
    }

    public StepOSBaseEntity getEntity() {
        return this.mEntity;
    }

    public boolean isValid() {
        return this.mIsValid;
    }

    public static Builder newBuilder() {
        return new Builder(Buffer.obtain());
    }

    public int getAtomId() {
        return this.mAtomId;
    }

    public byte[] getBytes() {
        return this.mPayload;
    }

    public int getNumBytes() {
        return this.mNumBytes;
    }

    public void release() {
        if (this.mBuffer != null) {
            this.mBuffer.release();
            this.mBuffer = null;
        }
    }

    public static final class Builder {
        private static final int POS_ATOM_ID = 11;
        private static final int POS_NUM_ELEMENTS = 1;
        private static final int POS_TIMESTAMP_NS = 2;
        private int mAtomId;
        private final Buffer mBuffer;
        private byte mCurrentAnnotationCount;
        private int mErrorMask;
        private byte mLastType;
        private final ArrayDeque<Integer> mLenPlaceholderStack;
        private int mNumElements;
        private final ArrayDeque<Integer> mNumElementsStack;
        private int mPendingMessageListElements;
        private int mPos;
        private int mPosLastField;
        private long mTimestampNs;
        private boolean mUsePooledBuffer;

        private Builder(Buffer buffer) {
            this.mLenPlaceholderStack = new ArrayDeque<>();
            this.mNumElementsStack = new ArrayDeque<>();
            this.mUsePooledBuffer = false;
            this.mBuffer = buffer;
            this.mCurrentAnnotationCount = (byte) 0;
            this.mAtomId = 0;
            this.mTimestampNs = SystemClock.elapsedRealtimeNanos();
            this.mNumElements = 0;
            this.mPendingMessageListElements = 0;
            this.mNumElementsStack.clear();
            this.mPos = 0;
            writeTypeId((byte) 7);
            this.mPos = 2;
            writeLong(this.mTimestampNs);
        }

        public Builder setAtomId(int atomId) {
            if (this.mAtomId == 0) {
                this.mAtomId = atomId;
                if (1 == this.mNumElements) {
                    writeInt(atomId);
                } else {
                    this.mErrorMask |= 8192;
                }
            }
            return this;
        }

        public Builder writeBoolean(boolean value) {
            writeTypeId((byte) 5);
            this.mPos += this.mBuffer.putBoolean(this.mPos, value);
            this.mNumElements++;
            return this;
        }

        public Builder writeInt(int value) {
            writeTypeId((byte) 0);
            this.mPos += this.mBuffer.putInt(this.mPos, value);
            this.mNumElements++;
            return this;
        }

        public Builder writeLong(long value) {
            writeTypeId((byte) 1);
            this.mPos += this.mBuffer.putLong(this.mPos, value);
            this.mNumElements++;
            return this;
        }

        public Builder writeFloat(float value) {
            writeTypeId((byte) 4);
            this.mPos += this.mBuffer.putFloat(this.mPos, value);
            this.mNumElements++;
            return this;
        }

        public Builder writeString(String value) {
            byte[] valueBytes = stringToBytes(value);
            writeByteArray(valueBytes, (byte) 2);
            return this;
        }

        public Builder writeByteArray(byte[] value) {
            writeByteArray(value, (byte) 6);
            return this;
        }

        private void writeByteArray(byte[] value, byte typeId) {
            writeTypeId(typeId);
            int numBytes = value.length;
            this.mPos += this.mBuffer.putInt(this.mPos, numBytes);
            this.mPos += this.mBuffer.putByteArray(this.mPos, value);
            this.mNumElements++;
        }

        public Builder writeAttributionChain(int[] uids, String[] tags) {
            byte numUids = (byte) uids.length;
            byte numTags = (byte) tags.length;
            if (numUids != numTags) {
                this.mErrorMask |= 4096;
            } else if (numUids > 127) {
                this.mErrorMask |= 8;
            } else {
                writeTypeId((byte) 9);
                this.mPos += this.mBuffer.putByte(this.mPos, numUids);
                for (int i = 0; i < numUids; i++) {
                    this.mPos += this.mBuffer.putInt(this.mPos, uids[i]);
                    byte[] tagBytes = stringToBytes(tags[i]);
                    this.mPos += this.mBuffer.putInt(this.mPos, tagBytes.length);
                    this.mPos += this.mBuffer.putByteArray(this.mPos, tagBytes);
                }
                int i2 = this.mNumElements;
                this.mNumElements = i2 + 1;
            }
            return this;
        }

        public Builder writeKeyValuePairs(SparseIntArray intMap, SparseLongArray longMap, SparseArray<String> stringMap, SparseArray<Float> floatMap) {
            int intMapSize = intMap == null ? 0 : intMap.size();
            int longMapSize = longMap == null ? 0 : longMap.size();
            int stringMapSize = stringMap == null ? 0 : stringMap.size();
            int floatMapSize = floatMap == null ? 0 : floatMap.size();
            int totalCount = intMapSize + longMapSize + stringMapSize + floatMapSize;
            if (totalCount > 127) {
                this.mErrorMask |= 16;
            } else {
                writeTypeId((byte) 8);
                this.mPos += this.mBuffer.putByte(this.mPos, (byte) totalCount);
                for (int i = 0; i < intMapSize; i++) {
                    int key = intMap.keyAt(i);
                    int value = intMap.valueAt(i);
                    this.mPos += this.mBuffer.putInt(this.mPos, key);
                    writeTypeId((byte) 0);
                    this.mPos += this.mBuffer.putInt(this.mPos, value);
                }
                for (int i2 = 0; i2 < longMapSize; i2++) {
                    int key2 = longMap.keyAt(i2);
                    long value2 = longMap.valueAt(i2);
                    this.mPos += this.mBuffer.putInt(this.mPos, key2);
                    writeTypeId((byte) 1);
                    this.mPos += this.mBuffer.putLong(this.mPos, value2);
                }
                int i3 = 0;
                while (i3 < stringMapSize) {
                    int key3 = stringMap.keyAt(i3);
                    String value3 = stringMap.valueAt(i3);
                    this.mPos += this.mBuffer.putInt(this.mPos, key3);
                    writeTypeId((byte) 2);
                    byte[] valueBytes = stringToBytes(value3);
                    int i4 = this.mPos;
                    Buffer buffer = this.mBuffer;
                    int i5 = this.mPos;
                    int i6 = i3;
                    int i7 = valueBytes.length;
                    this.mPos = i4 + buffer.putInt(i5, i7);
                    this.mPos += this.mBuffer.putByteArray(this.mPos, valueBytes);
                    i3 = i6 + 1;
                }
                for (int i8 = 0; i8 < floatMapSize; i8++) {
                    int key4 = floatMap.keyAt(i8);
                    float value4 = floatMap.valueAt(i8).floatValue();
                    this.mPos += this.mBuffer.putInt(this.mPos, key4);
                    writeTypeId((byte) 4);
                    this.mPos += this.mBuffer.putFloat(this.mPos, value4);
                }
                int i9 = this.mNumElements;
                this.mNumElements = i9 + 1;
            }
            return this;
        }

        public Builder writeBooleanArray(boolean[] elements) {
            byte numElements = (byte) elements.length;
            if (writeArrayInfo(numElements, (byte) 5)) {
                for (int i = 0; i < numElements; i++) {
                    this.mPos += this.mBuffer.putBoolean(this.mPos, elements[i]);
                }
                int i2 = this.mNumElements;
                this.mNumElements = i2 + 1;
            }
            return this;
        }

        public Builder writeIntArray(int[] elements) {
            byte numElements = (byte) elements.length;
            if (writeArrayInfo(numElements, (byte) 0)) {
                for (int i = 0; i < numElements; i++) {
                    this.mPos += this.mBuffer.putInt(this.mPos, elements[i]);
                }
                int i2 = this.mNumElements;
                this.mNumElements = i2 + 1;
            }
            return this;
        }

        public Builder writeLongArray(long[] elements) {
            byte numElements = (byte) elements.length;
            if (writeArrayInfo(numElements, (byte) 1)) {
                for (int i = 0; i < numElements; i++) {
                    this.mPos += this.mBuffer.putLong(this.mPos, elements[i]);
                }
                int i2 = this.mNumElements;
                this.mNumElements = i2 + 1;
            }
            return this;
        }

        public Builder writeFloatArray(float[] elements) {
            byte numElements = (byte) elements.length;
            if (writeArrayInfo(numElements, (byte) 4)) {
                for (int i = 0; i < numElements; i++) {
                    this.mPos += this.mBuffer.putFloat(this.mPos, elements[i]);
                }
                int i2 = this.mNumElements;
                this.mNumElements = i2 + 1;
            }
            return this;
        }

        public Builder writeStringArray(String[] elements) {
            byte numElements = (byte) elements.length;
            if (writeArrayInfo(numElements, (byte) 2)) {
                for (int i = 0; i < numElements; i++) {
                    byte[] elementBytes = stringToBytes(elements[i]);
                    this.mPos += this.mBuffer.putInt(this.mPos, elementBytes.length);
                    this.mPos += this.mBuffer.putByteArray(this.mPos, elementBytes);
                }
                int i2 = this.mNumElements;
                this.mNumElements = i2 + 1;
            }
            return this;
        }

        public Builder addBooleanAnnotation(byte annotationId, boolean value) {
            if (this.mNumElements < 2) {
                this.mErrorMask |= 32;
            } else if (this.mCurrentAnnotationCount >= 15) {
                this.mErrorMask |= 256;
            } else {
                this.mPos += this.mBuffer.putByte(this.mPos, annotationId);
                this.mPos += this.mBuffer.putByte(this.mPos, (byte) 5);
                this.mPos += this.mBuffer.putBoolean(this.mPos, value);
                this.mCurrentAnnotationCount = (byte) (this.mCurrentAnnotationCount + 1);
                writeAnnotationCount();
            }
            return this;
        }

        public Builder addIntAnnotation(byte annotationId, int value) {
            if (this.mNumElements < 2) {
                this.mErrorMask |= 32;
            } else if (this.mCurrentAnnotationCount >= 15) {
                this.mErrorMask |= 256;
            } else {
                this.mPos += this.mBuffer.putByte(this.mPos, annotationId);
                this.mPos += this.mBuffer.putByte(this.mPos, (byte) 0);
                this.mPos += this.mBuffer.putInt(this.mPos, value);
                this.mCurrentAnnotationCount = (byte) (this.mCurrentAnnotationCount + 1);
                writeAnnotationCount();
            }
            return this;
        }

        public Builder usePooledBuffer() {
            this.mUsePooledBuffer = true;
            this.mBuffer.setMaxSize(StepOSCollectEvent.MAX_PUSH_PAYLOAD_SIZE, this.mPos);
            return this;
        }

        public StepOSCollectEvent build() {
            if (0 == this.mTimestampNs) {
                this.mErrorMask |= 1;
            }
            if (this.mAtomId == 0) {
                this.mErrorMask |= 2;
            }
            if (this.mBuffer.hasOverflowed()) {
                this.mErrorMask |= 4;
            }
            if (this.mNumElements > 127) {
                this.mErrorMask |= 512;
            }
            if (this.mErrorMask == 0) {
                this.mBuffer.putByte(1, (byte) this.mNumElements);
            } else {
                this.mPos = 11;
                this.mPos += this.mBuffer.putByte(this.mPos, (byte) 0);
                this.mPos += this.mBuffer.putInt(this.mPos, this.mAtomId);
                this.mPos += this.mBuffer.putByte(this.mPos, StepOSCollectEvent.TYPE_ERRORS);
                this.mPos += this.mBuffer.putInt(this.mPos, this.mErrorMask);
                this.mBuffer.putByte(1, (byte) 3);
            }
            int size = this.mPos;
            if (this.mUsePooledBuffer) {
                return new StepOSCollectEvent(this.mAtomId, this.mBuffer, this.mBuffer.getBytes(), size);
            }
            byte[] payload = new byte[size];
            System.arraycopy(this.mBuffer.getBytes(), 0, payload, 0, size);
            this.mBuffer.release();
            return new StepOSCollectEvent(this.mAtomId, null, payload, size);
        }

        private void writeTypeId(byte typeId) {
            this.mPosLastField = this.mPos;
            this.mLastType = typeId;
            this.mCurrentAnnotationCount = (byte) 0;
            byte encodedId = (byte) (typeId & StepOSCollectEvent.TYPE_ERRORS);
            this.mPos += this.mBuffer.putByte(this.mPos, encodedId);
        }

        private void writeAnnotationCount() {
            byte encodedId = (byte) ((this.mCurrentAnnotationCount << 4) | (this.mLastType & StepOSCollectEvent.TYPE_ERRORS));
            this.mBuffer.putByte(this.mPosLastField, encodedId);
        }

        private static byte[] stringToBytes(String value) {
            return (value == null ? "" : value).getBytes(StandardCharsets.UTF_8);
        }

        public Builder writeArrayMap(ArrayMap<String, Object> map) {
            if (map == null) {
                return this;
            }
            int size = map.size();
            if (size > 20) {
                this.mErrorMask |= 17;
            } else {
                writeTypeId((byte) 10);
                this.mPos += this.mBuffer.putByte(this.mPos, (byte) size);
                for (int i = 0; i < size; i++) {
                    String key = map.keyAt(i);
                    Object value = map.valueAt(i);
                    writeTypeId((byte) 2);
                    byte[] valueBytes = stringToBytes(key);
                    this.mPos += this.mBuffer.putInt(this.mPos, valueBytes.length);
                    this.mPos += this.mBuffer.putByteArray(this.mPos, valueBytes);
                    if (value instanceof Integer) {
                        writeTypeId((byte) 0);
                        int intValue = ((Integer) value).intValue();
                        this.mPos += this.mBuffer.putInt(this.mPos, intValue);
                    } else if (value instanceof Long) {
                        writeTypeId((byte) 1);
                        long longValue = ((Long) value).longValue();
                        this.mPos += this.mBuffer.putLong(this.mPos, longValue);
                    } else if (value instanceof Boolean) {
                        writeTypeId((byte) 5);
                        boolean bValue = ((Boolean) value).booleanValue();
                        this.mPos += this.mBuffer.putBoolean(this.mPos, bValue);
                    } else if (value instanceof String) {
                        writeTypeId((byte) 2);
                        String sValue = (String) value;
                        byte[] svalueBytes = stringToBytes(sValue);
                        this.mPos += this.mBuffer.putInt(this.mPos, svalueBytes.length);
                        this.mPos += this.mBuffer.putByteArray(this.mPos, svalueBytes);
                    } else if (value instanceof Float) {
                        writeTypeId((byte) 4);
                        float floatValue = ((Float) value).floatValue();
                        this.mPos += this.mBuffer.putFloat(this.mPos, floatValue);
                    }
                }
                int i2 = this.mNumElements;
                this.mNumElements = i2 + 1;
            }
            return this;
        }

        public Builder writeMessageBegin() {
            this.mNumElementsStack.push(Integer.valueOf(this.mNumElements));
            writeTypeId(StepOSCollectEvent.TYPE_MESSAGE);
            this.mLenPlaceholderStack.push(Integer.valueOf(this.mPos));
            this.mPos += 4;
            return this;
        }

        public Builder writeMessageEnd() {
            int placeholderPos = this.mLenPlaceholderStack.pop().intValue();
            int nestedLen = (this.mPos - placeholderPos) - 4;
            this.mBuffer.putByte(placeholderPos, (byte) nestedLen);
            this.mBuffer.putByte(placeholderPos + 1, (byte) (nestedLen >> 8));
            this.mBuffer.putByte(placeholderPos + 2, (byte) (nestedLen >> 16));
            this.mBuffer.putByte(placeholderPos + 3, (byte) (nestedLen >> 24));
            int beforeMessage = this.mNumElementsStack.pop().intValue();
            if (this.mPendingMessageListElements > 0) {
                this.mPendingMessageListElements--;
                this.mNumElements = beforeMessage;
            } else {
                this.mNumElements = beforeMessage + 1;
            }
            return this;
        }

        public Builder writeMessageListBegin(int count) {
            writeTypeId((byte) 3);
            this.mPos += this.mBuffer.putByte(this.mPos, (byte) count);
            this.mPos += this.mBuffer.putByte(this.mPos, StepOSCollectEvent.TYPE_MESSAGE);
            this.mNumElements++;
            this.mPendingMessageListElements = count;
            return this;
        }

        private boolean writeArrayInfo(byte numElements, byte elementTypeId) {
            if (numElements > 127) {
                this.mErrorMask |= 16384;
                return false;
            }
            writeTypeId((byte) 3);
            this.mPos += this.mBuffer.putByte(this.mPos, numElements);
            byte encodedId = (byte) (elementTypeId & StepOSCollectEvent.TYPE_ERRORS);
            this.mPos += this.mBuffer.putByte(this.mPos, encodedId);
            return true;
        }
    }

    private static final class Buffer {
        private static Object sLock = new Object();
        private static Buffer sPool;
        private byte[] mBytes;
        private boolean mOverflow = false;
        private int mMaxSize = StepOSCollectEvent.MAX_PULL_PAYLOAD_SIZE;

        /* JADX INFO: Access modifiers changed from: private */
        public static Buffer obtain() {
            Buffer buffer;
            synchronized (sLock) {
                buffer = sPool == null ? new Buffer() : sPool;
                sPool = null;
            }
            buffer.reset();
            return buffer;
        }

        private Buffer() {
            ByteBuffer tempBuffer = ByteBuffer.allocateDirect(StepOSCollectEvent.MAX_PUSH_PAYLOAD_SIZE);
            this.mBytes = tempBuffer.hasArray() ? tempBuffer.array() : new byte[StepOSCollectEvent.MAX_PUSH_PAYLOAD_SIZE];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte[] getBytes() {
            return this.mBytes;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void release() {
            if (this.mMaxSize <= StepOSCollectEvent.MAX_PUSH_PAYLOAD_SIZE) {
                synchronized (sLock) {
                    if (sPool == null) {
                        sPool = this;
                    }
                }
            }
        }

        private void reset() {
            this.mOverflow = false;
            this.mMaxSize = StepOSCollectEvent.MAX_PULL_PAYLOAD_SIZE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMaxSize(int maxSize, int numBytesWritten) {
            this.mMaxSize = maxSize;
            if (numBytesWritten > maxSize) {
                this.mOverflow = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasOverflowed() {
            return this.mOverflow;
        }

        private boolean hasEnoughSpace(int index, int numBytes) {
            int totalBytesNeeded = index + numBytes;
            if (totalBytesNeeded > this.mMaxSize) {
                this.mOverflow = true;
                return false;
            }
            if (this.mBytes.length < this.mMaxSize && totalBytesNeeded > this.mBytes.length) {
                int newSize = this.mBytes.length;
                do {
                    newSize *= 2;
                } while (newSize <= totalBytesNeeded);
                if (newSize > this.mMaxSize) {
                    newSize = this.mMaxSize;
                }
                this.mBytes = Arrays.copyOf(this.mBytes, newSize);
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int putByte(int index, byte value) {
            if (hasEnoughSpace(index, 1)) {
                this.mBytes[index] = value;
                return 1;
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int putBoolean(int i, boolean z) {
            return putByte(i, z ? (byte) 1 : (byte) 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int putInt(int index, int value) {
            if (hasEnoughSpace(index, 4)) {
                this.mBytes[index] = (byte) value;
                this.mBytes[index + 1] = (byte) (value >> 8);
                this.mBytes[index + 2] = (byte) (value >> 16);
                this.mBytes[index + 3] = (byte) (value >> 24);
                return 4;
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int putLong(int index, long value) {
            if (hasEnoughSpace(index, 8)) {
                this.mBytes[index] = (byte) value;
                this.mBytes[index + 1] = (byte) (value >> 8);
                this.mBytes[index + 2] = (byte) (value >> 16);
                this.mBytes[index + 3] = (byte) (value >> 24);
                this.mBytes[index + 4] = (byte) (value >> 32);
                this.mBytes[index + 5] = (byte) (value >> 40);
                this.mBytes[index + 6] = (byte) (value >> 48);
                this.mBytes[index + 7] = (byte) (value >> 56);
                return 8;
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int putFloat(int index, float value) {
            return putInt(index, Float.floatToIntBits(value));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int putByteArray(int index, byte[] value) {
            int numBytes = value.length;
            if (!hasEnoughSpace(index, numBytes)) {
                return 0;
            }
            System.arraycopy(value, 0, this.mBytes, index, numBytes);
            return numBytes;
        }
    }
}
