package com.android.server.alwaysonrecord;

import android.os.SystemProperties;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class AlwaysOnRecordDataParser {
    private static final int DATA_OFFSET_OFFSET = 24;
    private static final int DATA_SIZE_OFFSET = 28;
    private static final String DUMP_DATA_PACKING_PROP = "persist.alwaysonrecord.dump_data_packing";
    private static final boolean DUMP_DATA_PACKING_PROP_DEFAULT_VALUE = false;
    private static final int DURATION_OFFSET = 20;
    private static final int HEADER_DATA_OFFSET_OFFSET = 12;
    private static final int HEADER_DATA_SIZE_OFFSET = 16;
    private static final int HEADER_PARAM_COUNT_OFFSET = 4;
    private static final int HEADER_SIZE = 20;
    private static final int HEADER_TOTAL_SIZE_OFFSET = 8;
    private static final int HEADER_VERSION_OFFSET = 0;
    private static final int PARAM_BASE_SIZE = 12;
    private static final int PARAM_ID_OFFSET = 0;
    private static final int PARAM_SIZE_OFFSET = 8;
    private static final int PARAM_VERSION_OFFSET = 4;
    private static final int SEGMENT_SIZE = 32;
    private static final String TAG = "AlwaysOnRecordDataParser";
    private static final int TIMESTAMP_OFFSET = 12;

    public class AudioDataParameter {
        public final int id;
        public final int size;
        public final int version;

        public AudioDataParameter(AlwaysOnRecordDataParser this$0, int id, int version, int size) {
            this.id = id;
            this.version = version;
            this.size = size;
        }

        public String toString() {
            return "AudioDataParameter{id=" + this.id + ", version=" + this.version + ", size=" + this.size + "}";
        }
    }

    public interface AudioDataParserListener {
        void onAudioDataSegmentParsed(AudioDataSegmentParameter r1);
    }

    public class AudioDataSegmentParameter extends AudioDataParameter {
        public final ByteBuffer buffer;
        public final int duration;
        public final long timestamp;

        public AudioDataSegmentParameter(AlwaysOnRecordDataParser this$0, int id, int version, int size, long timestamp, int duration, ByteBuffer buffer) {
            super(this$0, id, version, size);
            this.timestamp = timestamp;
            this.duration = duration;
            this.buffer = buffer;
        }

        @Override // com.android.server.alwaysonrecord.AlwaysOnRecordDataParser.AudioDataParameter
        public String toString() {
            return "AudioDataSegmentParameter{id=" + this.id + ", version=" + this.version + ", size=" + this.size + ", timestamp=" + this.timestamp + ", duration=" + this.duration + ", dataSize=" + this.buffer.limit() + "}";
        }
    }

    private static final enum AudioParameterId extends Enum<AudioParameterId> {
        private static final /* synthetic */ AudioParameterId[] $VALUES = null;
        public static final AudioParameterId AUDIO_PARAMETER_ID_AUDIO_DATA_SEGMENT = null;
        private final int mValue;

        private static /* synthetic */ AudioParameterId[] $values() {
            return new AudioParameterId[]{AUDIO_PARAMETER_ID_AUDIO_DATA_SEGMENT};
        }

        public static AudioParameterId valueOf(String name) {
            return (AudioParameterId) Enum.valueOf(AudioParameterId.class, name);
        }

        public static AudioParameterId[] values() {
            return (AudioParameterId[]) $VALUES.clone();
        }

        static {
            AUDIO_PARAMETER_ID_AUDIO_DATA_SEGMENT = new AudioParameterId("AUDIO_PARAMETER_ID_AUDIO_DATA_SEGMENT", 0, 1);
            $VALUES = $values();
        }

        private AudioParameterId(String r1, int r2, int value) {
            super(r1, r2);
            this.mValue = value;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public static class HeaderInfo {
        public final int dataOffset;
        public final int dataSize;
        public final int paramCount;
        public int totalSize;
        public final int version;

        public HeaderInfo(int version, int paramCount, int totalSize, int dataOffset, int dataSize) {
            this.version = version;
            this.paramCount = paramCount;
            this.totalSize = totalSize;
            this.dataOffset = dataOffset;
            this.dataSize = dataSize;
        }

        public String toString() {
            return "HeaderInfo{version=" + this.version + ", paramCount=" + this.paramCount + ", totalSize=" + this.totalSize + ", dataOffset=" + this.dataOffset + ", dataSize=" + this.dataSize + "}";
        }
    }

    public AlwaysOnRecordDataParser() {
    }

    private HeaderInfo parseHeaderInfo(ByteBuffer buffer) {
        if (buffer != null) goto L5;
    L22:
        Log.e(TAG, "Buffer too small, cannot contain valid header during parsing header info");
        return null;
    L5:
        if (buffer.limit() < 20) goto L22;
        int version = buffer.getInt(0);     // Catch: IndexOutOfBoundsException -> L14
        int paramCount = buffer.getInt(4);     // Catch: IndexOutOfBoundsException -> L14
        int totalSize = buffer.getInt(8);     // Catch: IndexOutOfBoundsException -> L14
        int dataOffset = buffer.getInt(12);     // Catch: IndexOutOfBoundsException -> L14
        int dataSize = buffer.getInt(16);     // Catch: IndexOutOfBoundsException -> L14
        if ((dataOffset + dataSize) <= totalSize) goto L17;
        Log.e(TAG, "Data offset and size exceed total size, offset: " + dataOffset + ", data size: " + dataSize + " vs total " + totalSize);     // Catch: IndexOutOfBoundsException -> L14
        if (dataOffset <= totalSize) goto L16;
        Log.e(TAG, "Data offset exceed total size");     // Catch: IndexOutOfBoundsException -> L14
        return null;
    L16:
        int dataSize2 = totalSize - dataOffset;     // Catch: IndexOutOfBoundsException -> L14
        Log.e(TAG, "only partial data is extracted:" + dataSize2);     // Catch: IndexOutOfBoundsException -> L14
        int dataSize3 = dataSize2;
    L19:
        return new HeaderInfo(version, paramCount, totalSize, dataOffset, dataSize3);
    L17:
        dataSize3 = dataSize;
    L14:
        e = move-exception;
        Log.e(TAG, "Error parsing header: " + e.getMessage());
        return null;
    }

    private AudioDataParameter parseParameterFromBuffer(ByteBuffer buffer, int offset) {
        int paramId = buffer.getInt(offset + 0);     // Catch: IndexOutOfBoundsException -> L5
        int paramVersion = buffer.getInt(offset + 4);     // Catch: IndexOutOfBoundsException -> L5
        int paramSize = buffer.getInt(offset + 8);     // Catch: IndexOutOfBoundsException -> L5
        return new AudioDataParameter(this, paramId, paramVersion, paramSize);
    L5:
        e = move-exception;
        Log.e(TAG, "Error parsing AudioDataParameter: " + e.getMessage());
        return null;
    }

    private AudioDataSegmentParameter parseDataSegmentFromBuffer(ByteBuffer buffer, int paramOffset, int dataPartitionOffset) {
        int paramId = buffer.getInt(paramOffset + 0);     // Catch: IndexOutOfBoundsException -> L9
        int paramVersion = buffer.getInt(paramOffset + 4);     // Catch: IndexOutOfBoundsException -> L9
        int paramSize = buffer.getInt(paramOffset + 8);     // Catch: IndexOutOfBoundsException -> L9
        long timestamp = buffer.getLong(paramOffset + 12);     // Catch: IndexOutOfBoundsException -> L9
        int duration = buffer.getInt(paramOffset + 20);     // Catch: IndexOutOfBoundsException -> L9
        int dataOffset = buffer.getInt(paramOffset + 24);     // Catch: IndexOutOfBoundsException -> L9
        int dataSize = buffer.getInt(paramOffset + 28);     // Catch: IndexOutOfBoundsException -> L9
        if (((dataPartitionOffset + dataOffset) + dataSize) <= buffer.limit()) goto L12;
        Log.w(TAG, "Buffer overflow: data partition offset " + dataPartitionOffset + " + dataOffset " + dataOffset + ", data size " + dataSize + " vs data length " + buffer.limit());     // Catch: IndexOutOfBoundsException -> L9
        if (dataOffset <= buffer.limit()) goto L11;
        Log.e(TAG, "No data available for offset " + dataOffset + ", data size " + buffer.limit());     // Catch: IndexOutOfBoundsException -> L9
        return null;
    L11:
        int dataSize2 = (buffer.limit() - dataPartitionOffset) - dataOffset;     // Catch: IndexOutOfBoundsException -> L9
        Log.w(TAG, "Only extract partial data:" + dataSize2);     // Catch: IndexOutOfBoundsException -> L9
        int dataSize3 = dataSize2;
    L13:
        ByteBuffer dataBuffer = createDataBuffer(buffer, dataPartitionOffset + dataOffset, dataSize3);     // Catch: IndexOutOfBoundsException -> L9
        return new AudioDataSegmentParameter(this, paramId, paramVersion, paramSize, timestamp, duration, dataBuffer);
    L12:
        dataSize3 = dataSize;
    L9:
        e = move-exception;
        Log.e(TAG, "Error parsing AudioDataSegmentParameter: " + e.getMessage());
        return null;
    }

    public int parse(ByteBuffer buffer, AudioDataParserListener listener) {
        AlwaysOnRecordDataParser r1 = this;
        ByteBuffer r9 = buffer;
        AudioDataParserListener r10 = listener;
        int r2 = -1;
        if (r9 == null) goto L83;
        if (r10 == null) goto L83;
        if (r9.limit() >= 20) goto L85;
        Log.w(TAG, "Buffer too small, cannot contain valid header");
        return -1;
    L85:
        r9.order(ByteOrder.nativeOrder());     // Catch: IndexOutOfBoundsException -> L79
        HeaderInfo headerInfo = parseHeaderInfo(buffer);
        if (headerInfo != null) goto L16;
        Log.w(TAG, "Failed to parse header information");
        return -1;
    L16:
        if (r1.shouldDumpDataPacking() == false) goto L19;
        Log.v(TAG, "Parsing header:" + headerInfo.toString());
    L19:
        if (r9.limit() != headerInfo.totalSize) goto L21;
    L25:
        String r4 = "Failed to create data buffer";
        if (headerInfo.paramCount != 0) goto L33;
        Log.d(TAG, "No parameter, fallback to store data as whole segment");
        ByteBuffer dataBuffer = r1.createDataBuffer(r9, headerInfo.dataOffset, headerInfo.dataSize);
        if (dataBuffer != null) goto L31;
        Log.e(TAG, "Failed to create data buffer");
        return -1;
    L31:
        r10.onAudioDataSegmentParsed(new AudioDataSegmentParameter(r1, AudioParameterId.AUDIO_PARAMETER_ID_AUDIO_DATA_SEGMENT.getValue(), 1, headerInfo.dataSize, System.currentTimeMillis(), 0, dataBuffer));
        return 1;
    L33:
        int currentParamOffset = 20;
        int parsedDataSize = 0;
        long lastSegmentDuration = 0;
        long lastSegmentDuration2 = 0;
        int i = 0;
    L35:
        if (i >= headerInfo.paramCount) goto L60;
        AudioDataParameter baseParam = r1.parseParameterFromBuffer(r9, currentParamOffset);
        if (baseParam == null) goto L38;
        int r16 = r2;
        if (r1.shouldDumpDataPacking() == false) goto L44;
        Log.v(TAG, "Parsing parameter " + i + ": " + baseParam.toString());
    L44:
        if (baseParam.id != AudioParameterId.AUDIO_PARAMETER_ID_AUDIO_DATA_SEGMENT.getValue()) goto L55;
        AudioDataSegmentParameter segmentParam = r1.parseDataSegmentFromBuffer(r9, currentParamOffset, headerInfo.dataOffset);
        if (segmentParam == null) goto L47;
        if (segmentParam.timestamp >= (lastSegmentDuration + lastSegmentDuration2)) goto L51;
        Log.w(TAG, "Timestamp is not increasing: " + segmentParam.timestamp + " vs last " + lastSegmentDuration + " + last duration " + lastSegmentDuration2);
    L51:
        long lastSegmentTimestamp = segmentParam.timestamp;
        long lastSegmentDuration3 = segmentParam.duration;
        int parsedDataSize2 = parsedDataSize + segmentParam.buffer.limit();
        if (shouldDumpDataPacking() == false) goto L54;
        Log.v(TAG, "Parsing parameter " + i + ": " + segmentParam.toString());
    L54:
        r10 = listener;
        r10.onAudioDataSegmentParsed(segmentParam);
        lastSegmentDuration2 = lastSegmentDuration3;
        parsedDataSize = parsedDataSize2;
        lastSegmentDuration = lastSegmentTimestamp;
    L56:
        currentParamOffset = baseParam.size + currentParamOffset;
        if (currentParamOffset > headerInfo.dataOffset) goto L58;
        i = i + 1;
        r1 = this;
        r9 = buffer;
        r2 = r16;
        parsedDataSize = parsedDataSize;
        r4 = r4;
        goto L35
    L58:
        Log.d(TAG, "Parsed partial paramters, actual " + (i + 1) + " vs total " + headerInfo.paramCount);
        int parsedDataSize3 = parsedDataSize;
    L62:
        int currentParamOffset2 = headerInfo.dataSize;
        if (parsedDataSize3 >= currentParamOffset2) goto L71;
        Log.d(TAG, "Unparsed data is considered as one segment: parsed  " + parsedDataSize3 + ", total " + headerInfo.dataSize);
        ByteBuffer dataBuffer2 = createDataBuffer(buffer, headerInfo.dataOffset + parsedDataSize3, headerInfo.dataSize - parsedDataSize3);
        if (dataBuffer2 != null) goto L68;
        Log.e(TAG, r4);
        return r16;
    L68:
        r10.onAudioDataSegmentParsed(new AudioDataSegmentParameter(this, AudioParameterId.AUDIO_PARAMETER_ID_AUDIO_DATA_SEGMENT.getValue(), 1, headerInfo.dataSize, System.currentTimeMillis(), 0, dataBuffer2));
    L73:
        int r0 = headerInfo.paramCount;
        if (parsedDataSize3 >= headerInfo.dataSize) goto L76;
        int r17 = 1;
    L78:
        return r0 + r17;
    L76:
        r17 = 0;
        goto L78
    L71:
        if (parsedDataSize3 <= headerInfo.dataSize) goto L73;
        Log.w(TAG, "Too much data is parsed: parsed  " + parsedDataSize3 + ", total " + headerInfo.dataSize);
        goto L73
    L47:
        Log.w(TAG, "Failed to parse parameter " + i);
    L61:
        parsedDataSize3 = parsedDataSize;
        goto L62
    L55:
        Log.d(TAG, "Skipping parameter with ID: " + baseParam.id);
        goto L56
    L38:
        r16 = r2;
        Log.w(TAG, "Failed to parse base parameter " + i + ", stop parsing");
        r4 = r4;
        parsedDataSize = parsedDataSize;
        goto L61
    L60:
        r16 = r2;
        r4 = r4;
        parsedDataSize = parsedDataSize;
        goto L61
    L21:
        if (headerInfo.dataOffset <= r9.limit()) goto L24;
        Log.e(TAG, "Data offset exceeds buffer size, not able to workaround" + headerInfo.dataOffset + " vs rawbuffer length " + r9.limit());
        return -1;
    L24:
        Log.w(TAG, "Buffer size mismatch: expected " + headerInfo.totalSize + ", got " + r9.limit());
        headerInfo.totalSize = Math.min(headerInfo.totalSize, r9.limit());
    L79:
        e = move-exception;
        Log.e(TAG, "Error to set buffer endian: " + e.getMessage(), e);
        return -1;
    L83:
        Log.w(TAG, "Invalid input: rawBuffer or listener is null");
        return -1;
    }

    private ByteBuffer createDataBuffer(ByteBuffer originalBuffer, int offset, int size) {
        if (originalBuffer != null) goto L7;
        Log.w(TAG, "createDataBuffer: null originalBuffer");
        return null;
    L7:
        if ((offset + size) <= originalBuffer.limit()) goto L10;
        Log.w(TAG, "createDataBuffer: invalid offset or size");
        return null;
    L10:
        int originalLimit = originalBuffer.limit();
        ByteBuffer dataBuffer = ByteBuffer.allocateDirect(size);
        originalBuffer.position(offset);
        originalBuffer.limit(offset + size);
        dataBuffer.put(originalBuffer.slice());
        dataBuffer.flip();
        originalBuffer.limit(originalLimit);
        return dataBuffer;
    }

    private boolean shouldDumpDataPacking() {
        return SystemProperties.getBoolean(DUMP_DATA_PACKING_PROP, false);
    }
}
