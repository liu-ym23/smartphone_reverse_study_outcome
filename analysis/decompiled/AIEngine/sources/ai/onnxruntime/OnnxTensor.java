package ai.onnxruntime;

import ai.onnxruntime.OnnxValue;
import ai.onnxruntime.OrtUtil;
import ai.onnxruntime.TensorInfo;
import ai.onnxruntime.platform.Fp16Conversions;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Optional;
import java.util.logging.Logger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class OnnxTensor extends OnnxTensorLike {
    private static final Logger logger = Logger.getLogger(OnnxTensor.class.getName());
    private final Buffer buffer;
    private final boolean ownsBuffer;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: ai.onnxruntime.OnnxTensor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ai$onnxruntime$OnnxJavaType;

        static {
            int[] iArr = new int[OnnxJavaType.values().length];
            $SwitchMap$ai$onnxruntime$OnnxJavaType = iArr;
            try {
                iArr[OnnxJavaType.FLOAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.UINT8.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT16.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.FLOAT16.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.BFLOAT16.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.UNKNOWN.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public OnnxTensor(long j10, long j11, TensorInfo tensorInfo) {
        this(j10, j11, tensorInfo, null, false);
    }

    private native void close(long j10, long j11);

    private static native long createString(long j10, long j11, String str);

    private static native long createStringTensor(long j10, long j11, Object[] objArr, long[] jArr);

    private static native long createTensor(long j10, long j11, Object obj, long[] jArr, int i10);

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, Object obj) {
        return createTensor(ortEnvironment, ortEnvironment.defaultAllocator, obj);
    }

    private static native long createTensorFromBuffer(long j10, long j11, Buffer buffer, int i10, long j12, long[] jArr, int i11);

    private native void getArray(long j10, long j11, Object obj);

    private native boolean getBool(long j10, long j11);

    private ByteBuffer getBuffer() {
        return getBuffer(OnnxRuntime.ortApiHandle, this.nativeHandle).order(ByteOrder.nativeOrder());
    }

    private native ByteBuffer getBuffer(long j10, long j11);

    private native byte getByte(long j10, long j11, int i10);

    private native double getDouble(long j10, long j11);

    private native float getFloat(long j10, long j11, int i10);

    private native int getInt(long j10, long j11, int i10);

    private native long getLong(long j10, long j11, int i10);

    private native short getShort(long j10, long j11, int i10);

    private native String getString(long j10, long j11);

    @Override // ai.onnxruntime.OnnxValue, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.closed) {
                logger.warning("Closing an already closed tensor.");
            } else {
                close(OnnxRuntime.ortApiHandle, this.nativeHandle);
                this.closed = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public Optional<Buffer> getBufferRef() {
        return Optional.ofNullable(this.buffer);
    }

    public ByteBuffer getByteBuffer() {
        checkClosed();
        if (this.info.type == OnnxJavaType.STRING) {
            return null;
        }
        ByteBuffer buffer = getBuffer(OnnxRuntime.ortApiHandle, this.nativeHandle);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(buffer.capacity());
        byteBufferAllocate.put(buffer);
        byteBufferAllocate.rewind();
        return byteBufferAllocate;
    }

    public DoubleBuffer getDoubleBuffer() {
        checkClosed();
        if (this.info.type != OnnxJavaType.DOUBLE) {
            return null;
        }
        DoubleBuffer doubleBufferAsDoubleBuffer = getBuffer().asDoubleBuffer();
        DoubleBuffer doubleBufferAllocate = DoubleBuffer.allocate(doubleBufferAsDoubleBuffer.capacity());
        doubleBufferAllocate.put(doubleBufferAsDoubleBuffer);
        doubleBufferAllocate.rewind();
        return doubleBufferAllocate;
    }

    public FloatBuffer getFloatBuffer() {
        checkClosed();
        OnnxJavaType onnxJavaType = this.info.type;
        if (onnxJavaType == OnnxJavaType.FLOAT) {
            FloatBuffer floatBufferAsFloatBuffer = getBuffer().asFloatBuffer();
            FloatBuffer floatBufferAllocate = FloatBuffer.allocate(floatBufferAsFloatBuffer.capacity());
            floatBufferAllocate.put(floatBufferAsFloatBuffer);
            floatBufferAllocate.rewind();
            return floatBufferAllocate;
        }
        if (onnxJavaType == OnnxJavaType.FLOAT16) {
            return Fp16Conversions.convertFp16BufferToFloatBuffer(getBuffer().asShortBuffer());
        }
        if (onnxJavaType == OnnxJavaType.BFLOAT16) {
            return Fp16Conversions.convertBf16BufferToFloatBuffer(getBuffer().asShortBuffer());
        }
        return null;
    }

    public IntBuffer getIntBuffer() {
        checkClosed();
        if (this.info.type != OnnxJavaType.INT32) {
            return null;
        }
        IntBuffer intBufferAsIntBuffer = getBuffer().asIntBuffer();
        IntBuffer intBufferAllocate = IntBuffer.allocate(intBufferAsIntBuffer.capacity());
        intBufferAllocate.put(intBufferAsIntBuffer);
        intBufferAllocate.rewind();
        return intBufferAllocate;
    }

    public LongBuffer getLongBuffer() {
        checkClosed();
        if (this.info.type != OnnxJavaType.INT64) {
            return null;
        }
        LongBuffer longBufferAsLongBuffer = getBuffer().asLongBuffer();
        LongBuffer longBufferAllocate = LongBuffer.allocate(longBufferAsLongBuffer.capacity());
        longBufferAllocate.put(longBufferAsLongBuffer);
        longBufferAllocate.rewind();
        return longBufferAllocate;
    }

    public ShortBuffer getShortBuffer() {
        checkClosed();
        OnnxJavaType onnxJavaType = this.info.type;
        if (onnxJavaType != OnnxJavaType.INT16 && onnxJavaType != OnnxJavaType.FLOAT16 && onnxJavaType != OnnxJavaType.BFLOAT16) {
            return null;
        }
        ShortBuffer shortBufferAsShortBuffer = getBuffer().asShortBuffer();
        ShortBuffer shortBufferAllocate = ShortBuffer.allocate(shortBufferAsShortBuffer.capacity());
        shortBufferAllocate.put(shortBufferAsShortBuffer);
        shortBufferAllocate.rewind();
        return shortBufferAllocate;
    }

    @Override // ai.onnxruntime.OnnxValue
    public OnnxValue.OnnxValueType getType() {
        return OnnxValue.OnnxValueType.ONNX_TYPE_TENSOR;
    }

    @Override // ai.onnxruntime.OnnxValue
    public Object getValue() throws OrtException {
        checkClosed();
        if (!this.info.isScalar()) {
            Object objMakeCarrier = this.info.makeCarrier();
            if (this.info.getNumElements() > 0) {
                getArray(OnnxRuntime.ortApiHandle, this.nativeHandle, objMakeCarrier);
            }
            TensorInfo tensorInfo = this.info;
            if (tensorInfo.type == OnnxJavaType.STRING) {
                long[] jArr = tensorInfo.shape;
                if (jArr.length != 1) {
                    return OrtUtil.reshape((String[]) objMakeCarrier, jArr);
                }
            }
            return objMakeCarrier;
        }
        switch (AnonymousClass1.$SwitchMap$ai$onnxruntime$OnnxJavaType[this.info.type.ordinal()]) {
            case 1:
                return Float.valueOf(getFloat(OnnxRuntime.ortApiHandle, this.nativeHandle, this.info.onnxType.value));
            case 2:
                return Double.valueOf(getDouble(OnnxRuntime.ortApiHandle, this.nativeHandle));
            case 3:
            case 4:
                return Byte.valueOf(getByte(OnnxRuntime.ortApiHandle, this.nativeHandle, this.info.onnxType.value));
            case 5:
                return Short.valueOf(getShort(OnnxRuntime.ortApiHandle, this.nativeHandle, this.info.onnxType.value));
            case 6:
                return Integer.valueOf(getInt(OnnxRuntime.ortApiHandle, this.nativeHandle, this.info.onnxType.value));
            case 7:
                return Long.valueOf(getLong(OnnxRuntime.ortApiHandle, this.nativeHandle, this.info.onnxType.value));
            case 8:
                return Boolean.valueOf(getBool(OnnxRuntime.ortApiHandle, this.nativeHandle));
            case 9:
                return getString(OnnxRuntime.ortApiHandle, this.nativeHandle);
            case 10:
                return Float.valueOf(Fp16Conversions.fp16ToFloat(getShort(OnnxRuntime.ortApiHandle, this.nativeHandle, this.info.onnxType.value)));
            case 11:
                return Float.valueOf(Fp16Conversions.bf16ToFloat(getShort(OnnxRuntime.ortApiHandle, this.nativeHandle, this.info.onnxType.value)));
            default:
                throw new OrtException("Extracting the value of an invalid Tensor.");
        }
    }

    public boolean ownsBuffer() {
        return this.ownsBuffer;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("OnnxTensor(info=");
        sb2.append(this.info.toString());
        sb2.append(",closed=");
        return a0.a.m(sb2, this.closed, ")");
    }

    public OnnxTensor(long j10, long j11, TensorInfo tensorInfo, Buffer buffer, boolean z) {
        super(j10, j11, tensorInfo);
        this.buffer = buffer;
        this.ownsBuffer = z;
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, OrtAllocator ortAllocator, Object obj) throws OrtException {
        if (ortAllocator.isClosed()) {
            throw new IllegalStateException("Trying to create an OnnxTensor with a closed OrtAllocator.");
        }
        TensorInfo tensorInfoConstructFromJavaArray = TensorInfo.constructFromJavaArray(obj);
        OnnxJavaType onnxJavaType = tensorInfoConstructFromJavaArray.type;
        if (onnxJavaType == OnnxJavaType.STRING) {
            return tensorInfoConstructFromJavaArray.shape.length == 0 ? new OnnxTensor(createString(OnnxRuntime.ortApiHandle, ortAllocator.handle, (String) obj), ortAllocator.handle, tensorInfoConstructFromJavaArray) : new OnnxTensor(createStringTensor(OnnxRuntime.ortApiHandle, ortAllocator.handle, OrtUtil.flattenString(obj), tensorInfoConstructFromJavaArray.shape), ortAllocator.handle, tensorInfoConstructFromJavaArray);
        }
        if (tensorInfoConstructFromJavaArray.shape.length != 0 || (obj = OrtUtil.convertBoxedPrimitiveToArray(onnxJavaType, obj)) != null) {
            return new OnnxTensor(createTensor(OnnxRuntime.ortApiHandle, ortAllocator.handle, obj, tensorInfoConstructFromJavaArray.shape, tensorInfoConstructFromJavaArray.onnxType.value), ortAllocator.handle, tensorInfoConstructFromJavaArray);
        }
        throw new OrtException("Failed to convert a boxed primitive to an array, this is an error with the ORT Java API, please report this message & stack trace. JavaType = " + tensorInfoConstructFromJavaArray.type + ", object = " + obj);
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, String[] strArr, long[] jArr) {
        return createTensor(ortEnvironment, ortEnvironment.defaultAllocator, strArr, jArr);
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, OrtAllocator ortAllocator, String[] strArr, long[] jArr) {
        if (!ortAllocator.isClosed()) {
            return new OnnxTensor(createStringTensor(OnnxRuntime.ortApiHandle, ortAllocator.handle, strArr, jArr), ortAllocator.handle, new TensorInfo(jArr, OnnxJavaType.STRING, TensorInfo.OnnxTensorType.ONNX_TENSOR_ELEMENT_DATA_TYPE_STRING));
        }
        throw new IllegalStateException("Trying to create an OnnxTensor on a closed OrtAllocator.");
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, FloatBuffer floatBuffer, long[] jArr) {
        return createTensor(ortEnvironment, ortEnvironment.defaultAllocator, floatBuffer, jArr);
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, OrtAllocator ortAllocator, FloatBuffer floatBuffer, long[] jArr) {
        if (!ortAllocator.isClosed()) {
            return createTensor(OnnxJavaType.FLOAT, ortAllocator, floatBuffer, jArr);
        }
        throw new IllegalStateException("Trying to create an OnnxTensor on a closed OrtAllocator.");
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, DoubleBuffer doubleBuffer, long[] jArr) {
        return createTensor(ortEnvironment, ortEnvironment.defaultAllocator, doubleBuffer, jArr);
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, OrtAllocator ortAllocator, DoubleBuffer doubleBuffer, long[] jArr) {
        if (!ortAllocator.isClosed()) {
            return createTensor(OnnxJavaType.DOUBLE, ortAllocator, doubleBuffer, jArr);
        }
        throw new IllegalStateException("Trying to create an OnnxTensor on a closed OrtAllocator.");
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, ByteBuffer byteBuffer, long[] jArr) {
        return createTensor(ortEnvironment, ortEnvironment.defaultAllocator, byteBuffer, jArr);
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, OrtAllocator ortAllocator, ByteBuffer byteBuffer, long[] jArr) {
        return createTensor(ortEnvironment, ortAllocator, byteBuffer, jArr, OnnxJavaType.INT8);
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, ByteBuffer byteBuffer, long[] jArr, OnnxJavaType onnxJavaType) {
        return createTensor(ortEnvironment, ortEnvironment.defaultAllocator, byteBuffer, jArr, onnxJavaType);
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, OrtAllocator ortAllocator, ByteBuffer byteBuffer, long[] jArr, OnnxJavaType onnxJavaType) {
        if (!ortAllocator.isClosed()) {
            return createTensor(onnxJavaType, ortAllocator, byteBuffer, jArr);
        }
        throw new IllegalStateException("Trying to create an OnnxTensor on a closed OrtAllocator.");
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, ShortBuffer shortBuffer, long[] jArr) {
        return createTensor(ortEnvironment, ortEnvironment.defaultAllocator, shortBuffer, jArr);
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, OrtAllocator ortAllocator, ShortBuffer shortBuffer, long[] jArr) {
        if (!ortAllocator.isClosed()) {
            return createTensor(OnnxJavaType.INT16, ortAllocator, shortBuffer, jArr);
        }
        throw new IllegalStateException("Trying to create an OnnxTensor on a closed OrtAllocator.");
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, IntBuffer intBuffer, long[] jArr) {
        return createTensor(ortEnvironment, ortEnvironment.defaultAllocator, intBuffer, jArr);
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, OrtAllocator ortAllocator, IntBuffer intBuffer, long[] jArr) {
        if (!ortAllocator.isClosed()) {
            return createTensor(OnnxJavaType.INT32, ortAllocator, intBuffer, jArr);
        }
        throw new IllegalStateException("Trying to create an OnnxTensor on a closed OrtAllocator.");
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, LongBuffer longBuffer, long[] jArr) {
        return createTensor(ortEnvironment, ortEnvironment.defaultAllocator, longBuffer, jArr);
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, OrtAllocator ortAllocator, LongBuffer longBuffer, long[] jArr) {
        if (!ortAllocator.isClosed()) {
            return createTensor(OnnxJavaType.INT64, ortAllocator, longBuffer, jArr);
        }
        throw new IllegalStateException("Trying to create an OnnxTensor on a closed OrtAllocator.");
    }

    private static OnnxTensor createTensor(OnnxJavaType onnxJavaType, OrtAllocator ortAllocator, Buffer buffer, long[] jArr) throws OrtException {
        OrtUtil.BufferTuple bufferTuplePrepareBuffer = OrtUtil.prepareBuffer(buffer, onnxJavaType);
        TensorInfo tensorInfoConstructFromBuffer = TensorInfo.constructFromBuffer(bufferTuplePrepareBuffer.data, jArr, onnxJavaType);
        return new OnnxTensor(createTensorFromBuffer(OnnxRuntime.ortApiHandle, ortAllocator.handle, bufferTuplePrepareBuffer.data, bufferTuplePrepareBuffer.pos, bufferTuplePrepareBuffer.byteSize, jArr, tensorInfoConstructFromBuffer.onnxType.value), ortAllocator.handle, tensorInfoConstructFromBuffer, bufferTuplePrepareBuffer.data, bufferTuplePrepareBuffer.isCopy);
    }
}
