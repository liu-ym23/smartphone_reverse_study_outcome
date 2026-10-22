package ai.onnxruntime;

import ai.onnxruntime.OnnxValue;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class OnnxSequence implements OnnxValue {
    private static final Logger logger = Logger.getLogger(OnnxSequence.class.getName());
    private final long allocatorHandle;
    private boolean closed = false;
    private final SequenceInfo info;
    final long nativeHandle;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: ai.onnxruntime.OnnxSequence$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ai$onnxruntime$OnnxJavaType;

        static {
            int[] iArr = new int[OnnxJavaType.values().length];
            $SwitchMap$ai$onnxruntime$OnnxJavaType = iArr;
            try {
                iArr[OnnxJavaType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT64.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.BOOL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.UINT8.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT8.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT16.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.UNKNOWN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    static {
        try {
            OnnxRuntime.init();
        } catch (IOException e10) {
            throw new RuntimeException("Failed to load onnx-runtime library", e10);
        }
    }

    public OnnxSequence(long j10, long j11, SequenceInfo sequenceInfo) {
        this.nativeHandle = j10;
        this.allocatorHandle = j11;
        this.info = sequenceInfo;
    }

    private native void close(long j10, long j11);

    private native OnnxMap[] getMaps(long j10, long j11, long j12);

    private native OnnxTensor[] getTensors(long j10, long j11, long j12);

    public void checkClosed() {
        if (this.closed) {
            throw new IllegalStateException("Trying to use a closed OnnxValue");
        }
    }

    @Override // ai.onnxruntime.OnnxValue, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.closed) {
                logger.warning("Closing an already closed sequence.");
            } else {
                close(OnnxRuntime.ortApiHandle, this.nativeHandle);
                this.closed = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ai.onnxruntime.OnnxValue
    public OnnxValue.OnnxValueType getType() {
        return OnnxValue.OnnxValueType.ONNX_TYPE_SEQUENCE;
    }

    @Override // ai.onnxruntime.OnnxValue
    public synchronized boolean isClosed() {
        return this.closed;
    }

    public String toString() {
        return "OnnxSequence(info=" + this.info.toString() + ")";
    }

    @Override // ai.onnxruntime.OnnxValue
    public SequenceInfo getInfo() {
        return this.info;
    }

    @Override // ai.onnxruntime.OnnxValue
    public List<? extends OnnxValue> getValue() throws OrtException {
        checkClosed();
        SequenceInfo sequenceInfo = this.info;
        if (sequenceInfo.sequenceOfMaps) {
            return Collections.unmodifiableList(Arrays.asList(getMaps(OnnxRuntime.ortApiHandle, this.nativeHandle, this.allocatorHandle)));
        }
        int i10 = AnonymousClass1.$SwitchMap$ai$onnxruntime$OnnxJavaType[sequenceInfo.sequenceType.ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) {
            return Collections.unmodifiableList(Arrays.asList(getTensors(OnnxRuntime.ortApiHandle, this.nativeHandle, this.allocatorHandle)));
        }
        throw new OrtException("Unsupported type in a sequence, found " + this.info.sequenceType);
    }
}
