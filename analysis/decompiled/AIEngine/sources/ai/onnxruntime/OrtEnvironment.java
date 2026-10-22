package ai.onnxruntime;

import ai.onnxruntime.OrtSession;
import ai.onnxruntime.OrtTrainingSession;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Objects;
import java.util.logging.Logger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OrtEnvironment implements AutoCloseable {
    public static final String DEFAULT_NAME = "ort-java";
    private static volatile OrtEnvironment INSTANCE;
    private static volatile OrtLoggingLevel curLogLevel;
    private static volatile String curLoggingName;
    private static final Logger logger = Logger.getLogger(OrtEnvironment.class.getName());
    final OrtAllocator defaultAllocator;
    final long nativeHandle;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class OrtEnvCloser implements Runnable {
        private final long apiHandle;
        private final long nativeHandle;

        public OrtEnvCloser(long j10, long j11) {
            this.apiHandle = j10;
            this.nativeHandle = j11;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                OrtEnvironment.close(this.apiHandle, this.nativeHandle);
            } catch (OrtException e10) {
                System.err.println("Error closing OrtEnvironment, " + e10);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ThreadingOptions implements AutoCloseable {
        private boolean closed = false;
        private final long nativeHandle = createThreadingOptions(OnnxRuntime.ortApiHandle);

        static {
            try {
                OnnxRuntime.init();
            } catch (IOException e10) {
                throw new RuntimeException("Failed to load onnx-runtime library", e10);
            }
        }

        private void checkClosed() {
            if (this.closed) {
                throw new IllegalStateException("Trying to use a closed ThreadingOptions");
            }
        }

        private native void closeThreadingOptions(long j10, long j11);

        private static native long createThreadingOptions(long j10);

        private native void setGlobalDenormalAsZero(long j10, long j11);

        private native void setGlobalInterOpNumThreads(long j10, long j11, int i10);

        private native void setGlobalIntraOpNumThreads(long j10, long j11, int i10);

        private native void setGlobalSpinControl(long j10, long j11, int i10);

        @Override // java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                throw new IllegalStateException("Trying to close a closed ThreadingOptions.");
            }
            closeThreadingOptions(OnnxRuntime.ortApiHandle, this.nativeHandle);
            this.closed = true;
        }

        public void setGlobalDenormalAsZero() {
            checkClosed();
            setGlobalDenormalAsZero(OnnxRuntime.ortApiHandle, this.nativeHandle);
        }

        public void setGlobalInterOpNumThreads(int i10) {
            checkClosed();
            if (i10 < 0) {
                throw new IllegalArgumentException("Number of threads must be non-negative.");
            }
            setGlobalInterOpNumThreads(OnnxRuntime.ortApiHandle, this.nativeHandle, i10);
        }

        public void setGlobalIntraOpNumThreads(int i10) {
            checkClosed();
            if (i10 < 0) {
                throw new IllegalArgumentException("Number of threads must be non-negative.");
            }
            setGlobalIntraOpNumThreads(OnnxRuntime.ortApiHandle, this.nativeHandle, i10);
        }

        public void setGlobalSpinControl(boolean z) {
            checkClosed();
            setGlobalSpinControl(OnnxRuntime.ortApiHandle, this.nativeHandle, z ? 1 : 0);
        }
    }

    static {
        try {
            OnnxRuntime.init();
        } catch (IOException e10) {
            throw new RuntimeException("Failed to load onnx-runtime library", e10);
        }
    }

    private OrtEnvironment() {
        this(OrtLoggingLevel.ORT_LOGGING_LEVEL_WARNING, "java-default");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void close(long j10, long j11);

    private static native long createHandle(long j10, int i10, String str);

    private static native long createHandle(long j10, int i10, String str, long j11);

    public static EnumSet<OrtProvider> getAvailableProviders() {
        return OnnxRuntime.providers.clone();
    }

    private static native long getDefaultAllocator(long j10);

    public static synchronized OrtEnvironment getEnvironment() {
        if (INSTANCE == null) {
            return getEnvironment(OrtLoggingLevel.ORT_LOGGING_LEVEL_WARNING, DEFAULT_NAME);
        }
        return INSTANCE;
    }

    private static native void setTelemetry(long j10, long j11, boolean z);

    @Override // java.lang.AutoCloseable
    public void close() {
    }

    public OrtSession createSession(String str) {
        return createSession(str, new OrtSession.SessionOptions());
    }

    public OrtTrainingSession createTrainingSession(String str, String str2, String str3, String str4) {
        return createTrainingSession(str, str2, str3, str4, new OrtSession.SessionOptions());
    }

    public long getNativeHandle() {
        return this.nativeHandle;
    }

    public String getVersion() {
        return OnnxRuntime.version();
    }

    public boolean isTrainingEnabled() {
        return OnnxRuntime.trainingEnabled;
    }

    public void setTelemetry(boolean z) {
        setTelemetry(OnnxRuntime.ortApiHandle, this.nativeHandle, z);
    }

    public String toString() {
        return "OrtEnvironment(name=" + curLoggingName + ",logLevel=" + curLogLevel + ",version=" + getVersion() + ")";
    }

    private OrtEnvironment(OrtLoggingLevel ortLoggingLevel, String str) {
        long jCreateHandle = createHandle(OnnxRuntime.ortApiHandle, ortLoggingLevel.getValue(), str);
        this.nativeHandle = jCreateHandle;
        this.defaultAllocator = new OrtAllocator(getDefaultAllocator(OnnxRuntime.ortApiHandle), true);
        Runtime.getRuntime().addShutdownHook(new Thread(new OrtEnvCloser(OnnxRuntime.ortApiHandle, jCreateHandle)));
    }

    public OrtSession createSession(String str, OrtSession.SessionOptions sessionOptions) {
        return createSession(str, this.defaultAllocator, sessionOptions);
    }

    public OrtTrainingSession createTrainingSession(String str, String str2, String str3, String str4, OrtSession.SessionOptions sessionOptions) {
        return createTrainingSession(str, str2, str3, str4, this.defaultAllocator, sessionOptions);
    }

    public OrtSession createSession(String str, OrtAllocator ortAllocator, OrtSession.SessionOptions sessionOptions) {
        Objects.requireNonNull(str, "model path must not be null");
        return new OrtSession(this, str, ortAllocator, sessionOptions);
    }

    public OrtTrainingSession createTrainingSession(String str, String str2, String str3, String str4, OrtAllocator ortAllocator, OrtSession.SessionOptions sessionOptions) {
        if (OnnxRuntime.trainingEnabled) {
            Objects.requireNonNull(str2, "train path must not be null");
            return new OrtTrainingSession(this, ortAllocator, sessionOptions, OrtTrainingSession.OrtCheckpointState.loadCheckpoint(str), str2, str3, str4);
        }
        throw new IllegalStateException("Training is not enabled in this build of ONNX Runtime.");
    }

    public static OrtEnvironment getEnvironment(String str) {
        return getEnvironment(OrtLoggingLevel.ORT_LOGGING_LEVEL_WARNING, str);
    }

    public static OrtEnvironment getEnvironment(OrtLoggingLevel ortLoggingLevel) {
        return getEnvironment(ortLoggingLevel, DEFAULT_NAME);
    }

    public OrtSession createSession(byte[] bArr, OrtSession.SessionOptions sessionOptions) {
        return createSession(bArr, this.defaultAllocator, sessionOptions);
    }

    public static synchronized OrtEnvironment getEnvironment(OrtLoggingLevel ortLoggingLevel, String str) {
        if (INSTANCE == null) {
            try {
                INSTANCE = new OrtEnvironment(ortLoggingLevel, str);
                curLogLevel = ortLoggingLevel;
                curLoggingName = str;
            } catch (OrtException e10) {
                throw new IllegalStateException("Failed to create OrtEnvironment", e10);
            }
        } else if (ortLoggingLevel.getValue() != curLogLevel.getValue() || !str.equals(curLoggingName)) {
            logger.warning("Tried to change OrtEnvironment's logging level or name while a reference exists.");
        }
        return INSTANCE;
    }

    public OrtSession createSession(byte[] bArr) {
        return createSession(bArr, new OrtSession.SessionOptions());
    }

    private OrtEnvironment(OrtLoggingLevel ortLoggingLevel, String str, ThreadingOptions threadingOptions) {
        long jCreateHandle = createHandle(OnnxRuntime.ortApiHandle, ortLoggingLevel.getValue(), str, threadingOptions.nativeHandle);
        this.nativeHandle = jCreateHandle;
        this.defaultAllocator = new OrtAllocator(getDefaultAllocator(OnnxRuntime.ortApiHandle), true);
        Runtime.getRuntime().addShutdownHook(new Thread(new OrtEnvCloser(OnnxRuntime.ortApiHandle, jCreateHandle)));
    }

    public OrtSession createSession(byte[] bArr, OrtAllocator ortAllocator, OrtSession.SessionOptions sessionOptions) {
        Objects.requireNonNull(bArr, "model array must not be null");
        return new OrtSession(this, bArr, ortAllocator, sessionOptions);
    }

    public static synchronized OrtEnvironment getEnvironment(OrtLoggingLevel ortLoggingLevel, String str, ThreadingOptions threadingOptions) {
        if (INSTANCE == null) {
            try {
                INSTANCE = new OrtEnvironment(ortLoggingLevel, str, threadingOptions);
                curLogLevel = ortLoggingLevel;
                curLoggingName = str;
            } catch (OrtException e10) {
                throw new IllegalStateException("Failed to create OrtEnvironment", e10);
            }
        } else {
            throw new IllegalStateException("Tried to specify the thread pool when creating an OrtEnvironment, but one already exists.");
        }
        return INSTANCE;
    }
}
