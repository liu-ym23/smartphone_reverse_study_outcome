package ai.onnxruntime;

import ai.onnxruntime.OrtSession;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OrtTrainingSession implements AutoCloseable {
    private final OrtAllocator allocator;
    private final OrtCheckpointState checkpoint;
    private boolean closed;
    private final Set<String> evalInputNames;
    private final Set<String> evalOutputNames;
    private final String evalPath;
    private final long nativeHandle;
    private final String optimizerPath;
    private final Set<String> trainInputNames;
    private final Set<String> trainOutputNames;
    private final String trainPath;

    static {
        try {
            OnnxRuntime.init();
        } catch (IOException e10) {
            throw new RuntimeException("Failed to load onnx-runtime library", e10);
        }
    }

    public OrtTrainingSession(OrtEnvironment ortEnvironment, OrtAllocator ortAllocator, OrtSession.SessionOptions sessionOptions, OrtCheckpointState ortCheckpointState, String str, String str2, String str3) {
        this(createTrainingSession(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, ortEnvironment.getNativeHandle(), sessionOptions.getNativeHandle(), ortCheckpointState.nativeHandle, str, str2, str3), ortAllocator, ortCheckpointState, str, str2, str3);
    }

    private void checkClosed() {
        if (this.closed) {
            throw new IllegalStateException("Trying to use a closed OrtTrainingSession");
        }
    }

    private native void closeSession(long j10, long j11);

    private static native long createTrainingSession(long j10, long j11, long j12, long j13, long j14, String str, String str2, String str3);

    private native boolean[] evalStep(long j10, long j11, long j12, long j13, String[] strArr, long[] jArr, long j14, String[] strArr2, long j15, OnnxValue[] onnxValueArr, long[] jArr2, long j16);

    private native void exportModelForInference(long j10, long j11, long j12, String str, long j13, String[] strArr);

    private native String[] getEvalInputNames(long j10, long j11, long j12, long j13);

    private native String[] getEvalOutputNames(long j10, long j11, long j12, long j13);

    private native float getLearningRate(long j10, long j11, long j12);

    private native String[] getTrainInputNames(long j10, long j11, long j12, long j13);

    private native String[] getTrainOutputNames(long j10, long j11, long j12, long j13);

    private native void lazyResetGrad(long j10, long j11, long j12);

    private native void optimizerStep(long j10, long j11, long j12, long j13);

    private native void registerLinearLRScheduler(long j10, long j11, long j12, long j13, long j14, float f8);

    private native void schedulerStep(long j10, long j11, long j12);

    private native void setLearningRate(long j10, long j11, long j12, float f8);

    public static void setSeed(long j10) {
        setSeed(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, j10);
    }

    private static native void setSeed(long j10, long j11, long j12);

    private native boolean[] trainStep(long j10, long j11, long j12, long j13, String[] strArr, long[] jArr, long j14, String[] strArr2, long j15, OnnxValue[] onnxValueArr, long[] jArr2, long j16);

    public void addProperty(String str, float f8) {
        this.checkpoint.addProperty(str, f8);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            throw new IllegalStateException("Trying to close an already closed OrtSession.");
        }
        closeSession(OnnxRuntime.ortTrainingApiHandle, this.nativeHandle);
        this.checkpoint.close();
        this.closed = true;
    }

    public OrtSession.Result evalStep(Map<String, ? extends OnnxTensorLike> map) {
        return evalStep(map, this.evalOutputNames, Collections.EMPTY_MAP, null);
    }

    public void exportModelForInference(Path path, String[] strArr) {
        checkClosed();
        if (strArr.length == 0) {
            throw new IllegalArgumentException("Requires at least one output name");
        }
        exportModelForInference(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, this.nativeHandle, path.toString(), strArr.length, strArr);
    }

    public Set<String> getEvalInputNames() {
        return this.evalInputNames;
    }

    public Set<String> getEvalOutputNames() {
        return this.evalOutputNames;
    }

    public float getFloatProperty(String str) {
        return this.checkpoint.getFloatProperty(this.allocator, str);
    }

    public int getIntProperty(String str) {
        return this.checkpoint.getIntProperty(this.allocator, str);
    }

    public float getLearningRate() {
        checkClosed();
        return getLearningRate(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, this.nativeHandle);
    }

    public String getStringProperty(String str) {
        return this.checkpoint.getStringProperty(this.allocator, str);
    }

    public Set<String> getTrainInputNames() {
        return this.trainInputNames;
    }

    public Set<String> getTrainOutputNames() {
        return this.trainOutputNames;
    }

    public void lazyResetGrad() {
        checkClosed();
        lazyResetGrad(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, this.nativeHandle);
    }

    public void optimizerStep() {
        optimizerStep(null);
    }

    public void registerLinearLRScheduler(long j10, long j11, float f8) {
        registerLinearLRScheduler(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, this.nativeHandle, j10, j11, f8);
    }

    public void saveCheckpoint(Path path, boolean z) {
        checkClosed();
        this.checkpoint.saveCheckpoint(path, z);
    }

    public void schedulerStep() {
        checkClosed();
        schedulerStep(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, this.nativeHandle);
    }

    public void setLearningRate(float f8) {
        checkClosed();
        setLearningRate(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, this.nativeHandle, f8);
    }

    public OrtSession.Result trainStep(Map<String, ? extends OnnxTensorLike> map) {
        return trainStep(map, this.trainOutputNames, Collections.EMPTY_MAP, null);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class OrtCheckpointState implements AutoCloseable {
        private static final Logger logger = Logger.getLogger(OrtCheckpointState.class.getName());
        private boolean closed = false;
        final long nativeHandle;

        public OrtCheckpointState(long j10) {
            this.nativeHandle = j10;
        }

        private native void addProperty(long j10, long j11, long j12, String str, float f8);

        private native void addProperty(long j10, long j11, long j12, String str, int i10);

        private native void addProperty(long j10, long j11, long j12, String str, String str2);

        private void checkClosed() {
            if (this.closed) {
                throw new IllegalStateException("Trying to use a closed OrtCheckpointState");
            }
        }

        private native void close(long j10, long j11);

        private native float getFloatProperty(long j10, long j11, long j12, long j13, String str);

        private native int getIntProperty(long j10, long j11, long j12, long j13, String str);

        private native String getStringProperty(long j10, long j11, long j12, long j13, String str);

        private static native long loadCheckpoint(long j10, long j11, String str);

        public static OrtCheckpointState loadCheckpoint(Path path) {
            return loadCheckpoint(path.toString());
        }

        private native void saveCheckpoint(long j10, long j11, long j12, String str, boolean z);

        public void addProperty(String str, float f8) {
            checkClosed();
            addProperty(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, this.nativeHandle, str, f8);
        }

        @Override // java.lang.AutoCloseable
        public synchronized void close() {
            try {
                if (this.closed) {
                    logger.warning("Closing a checkpoint twice");
                } else {
                    close(OnnxRuntime.ortTrainingApiHandle, this.nativeHandle);
                    this.closed = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        public float getFloatProperty(OrtAllocator ortAllocator, String str) {
            checkClosed();
            return getFloatProperty(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, this.nativeHandle, ortAllocator.handle, str);
        }

        public int getIntProperty(OrtAllocator ortAllocator, String str) {
            checkClosed();
            return getIntProperty(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, this.nativeHandle, ortAllocator.handle, str);
        }

        public String getStringProperty(OrtAllocator ortAllocator, String str) {
            checkClosed();
            return getStringProperty(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, this.nativeHandle, ortAllocator.handle, str);
        }

        public synchronized boolean isClosed() {
            return this.closed;
        }

        public void saveCheckpoint(Path path, boolean z) {
            checkClosed();
            Objects.requireNonNull(path, "checkpoint path must not be null");
            saveCheckpoint(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, this.nativeHandle, path.toString(), z);
        }

        public static OrtCheckpointState loadCheckpoint(String str) {
            if (OnnxRuntime.trainingEnabled) {
                Objects.requireNonNull(str, "checkpoint path must not be null");
                return new OrtCheckpointState(loadCheckpoint(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, str));
            }
            throw new IllegalStateException("Training is not enabled in this build of ONNX Runtime.");
        }

        public void addProperty(String str, int i10) {
            checkClosed();
            addProperty(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, this.nativeHandle, str, i10);
        }

        public void addProperty(String str, String str2) {
            checkClosed();
            addProperty(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, this.nativeHandle, str, str2);
        }
    }

    public void addProperty(String str, int i10) {
        this.checkpoint.addProperty(str, i10);
    }

    public OrtSession.Result evalStep(Map<String, ? extends OnnxTensorLike> map, OrtSession.RunOptions runOptions) {
        return evalStep(map, this.evalOutputNames, Collections.EMPTY_MAP, runOptions);
    }

    public void optimizerStep(OrtSession.RunOptions runOptions) {
        checkClosed();
        optimizerStep(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, this.nativeHandle, runOptions == null ? 0L : runOptions.getNativeHandle());
    }

    public OrtSession.Result trainStep(Map<String, ? extends OnnxTensorLike> map, OrtSession.RunOptions runOptions) {
        return trainStep(map, this.trainOutputNames, Collections.EMPTY_MAP, runOptions);
    }

    public void addProperty(String str, String str2) {
        this.checkpoint.addProperty(str, str2);
    }

    public OrtSession.Result evalStep(Map<String, ? extends OnnxTensorLike> map, Set<String> set) {
        return evalStep(map, set, Collections.EMPTY_MAP, null);
    }

    public OrtSession.Result trainStep(Map<String, ? extends OnnxTensorLike> map, Set<String> set) {
        return trainStep(map, set, Collections.EMPTY_MAP, null);
    }

    public OrtSession.Result evalStep(Map<String, ? extends OnnxTensorLike> map, Map<String, ? extends OnnxValue> map2) {
        return evalStep(map, Collections.EMPTY_SET, map2, null);
    }

    public OrtSession.Result trainStep(Map<String, ? extends OnnxTensorLike> map, Map<String, ? extends OnnxValue> map2) {
        return trainStep(map, Collections.EMPTY_SET, map2, null);
    }

    public OrtSession.Result evalStep(Map<String, ? extends OnnxTensorLike> map, Set<String> set, Map<String, ? extends OnnxValue> map2, OrtSession.RunOptions runOptions) throws OrtException {
        checkClosed();
        if ((!map.isEmpty() || this.evalInputNames.size() == 0) && map.size() <= this.evalInputNames.size()) {
            int size = this.evalOutputNames.size();
            int size2 = map2.size() + set.size();
            if (size2 != 0 && size2 <= size) {
                int size3 = map.size();
                String[] strArr = new String[size3];
                long[] jArr = new long[map.size()];
                int i10 = 0;
                int i11 = 0;
                for (Map.Entry<String, ? extends OnnxTensorLike> entry : map.entrySet()) {
                    if (this.evalInputNames.contains(entry.getKey())) {
                        strArr[i11] = entry.getKey();
                        jArr[i11] = entry.getValue().getNativeHandle();
                        i11++;
                    } else {
                        throw new OrtException("Unknown input name " + entry.getKey() + ", expected one of " + this.evalInputNames.toString());
                    }
                }
                int size4 = map2.size() + set.size();
                String[] strArr2 = new String[size4];
                OnnxValue[] onnxValueArr = new OnnxValue[size4];
                long[] jArr2 = new long[size4];
                for (Map.Entry<String, ? extends OnnxValue> entry2 : map2.entrySet()) {
                    if (this.evalOutputNames.contains(entry2.getKey())) {
                        strArr2[i10] = entry2.getKey();
                        onnxValueArr[i10] = entry2.getValue();
                        jArr2[i10] = OrtSession.getHandle(entry2.getValue());
                        i10++;
                    } else {
                        throw new OrtException("Unknown output name " + entry2.getKey() + ", expected one of " + this.evalOutputNames.toString());
                    }
                }
                for (String str : set) {
                    if (this.evalOutputNames.contains(str)) {
                        if (!map2.containsKey(str)) {
                            strArr2[i10] = str;
                            i10++;
                        } else {
                            throw new OrtException(a0.a.k("Output '", str, "' was found in both the requested outputs and the pinned outputs"));
                        }
                    } else {
                        StringBuilder sbQ = a0.a.q("Unknown output name ", str, ", expected one of ");
                        sbQ.append(this.evalOutputNames.toString());
                        throw new OrtException(sbQ.toString());
                    }
                }
                return new OrtSession.Result(strArr2, onnxValueArr, evalStep(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, this.nativeHandle, this.allocator.handle, strArr, jArr, size3, strArr2, size4, onnxValueArr, jArr2, runOptions == null ? 0L : runOptions.getNativeHandle()));
            }
            throw new OrtException(a0.a.f("Unexpected number of requestedOutputs & pinnedOutputs, expected [1,", size, size2, ") found "));
        }
        throw new OrtException("Unexpected number of inputs, expected [1," + this.evalInputNames.size() + ") found " + map.size());
    }

    public OrtSession.Result trainStep(Map<String, ? extends OnnxTensorLike> map, Set<String> set, Map<String, ? extends OnnxValue> map2, OrtSession.RunOptions runOptions) throws OrtException {
        checkClosed();
        if ((!map.isEmpty() || this.trainInputNames.size() == 0) && map.size() <= this.trainInputNames.size()) {
            int size = this.trainOutputNames.size();
            int size2 = map2.size() + set.size();
            if (size2 != 0 && size2 <= size) {
                int size3 = map.size();
                String[] strArr = new String[size3];
                long[] jArr = new long[map.size()];
                int i10 = 0;
                int i11 = 0;
                for (Map.Entry<String, ? extends OnnxTensorLike> entry : map.entrySet()) {
                    if (this.trainInputNames.contains(entry.getKey())) {
                        strArr[i11] = entry.getKey();
                        jArr[i11] = entry.getValue().getNativeHandle();
                        i11++;
                    } else {
                        throw new OrtException("Unknown input name " + entry.getKey() + ", expected one of " + this.trainInputNames);
                    }
                }
                int size4 = map2.size() + set.size();
                String[] strArr2 = new String[size4];
                OnnxValue[] onnxValueArr = new OnnxValue[size4];
                long[] jArr2 = new long[size4];
                for (Map.Entry<String, ? extends OnnxValue> entry2 : map2.entrySet()) {
                    if (this.trainOutputNames.contains(entry2.getKey())) {
                        strArr2[i10] = entry2.getKey();
                        onnxValueArr[i10] = entry2.getValue();
                        jArr2[i10] = OrtSession.getHandle(entry2.getValue());
                        i10++;
                    } else {
                        throw new OrtException("Unknown output name " + entry2.getKey() + ", expected one of " + this.trainOutputNames.toString());
                    }
                }
                for (String str : set) {
                    if (this.trainOutputNames.contains(str)) {
                        if (!map2.containsKey(str)) {
                            strArr2[i10] = str;
                            i10++;
                        } else {
                            throw new OrtException(a0.a.k("Output '", str, "' was found in both the requested outputs and the pinned outputs"));
                        }
                    } else {
                        StringBuilder sbQ = a0.a.q("Unknown output name ", str, ", expected one of ");
                        sbQ.append(this.trainOutputNames.toString());
                        throw new OrtException(sbQ.toString());
                    }
                }
                return new OrtSession.Result(strArr2, onnxValueArr, trainStep(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, this.nativeHandle, this.allocator.handle, strArr, jArr, size3, strArr2, size4, onnxValueArr, jArr2, runOptions == null ? 0L : runOptions.getNativeHandle()));
            }
            throw new OrtException(a0.a.f("Unexpected number of requestedOutputs & pinnedOutputs, expected [1,", size, size2, ") found "));
        }
        throw new OrtException("Unexpected number of inputs, expected [1," + this.trainInputNames.size() + ") found " + map.size());
    }

    private OrtTrainingSession(long j10, OrtAllocator ortAllocator, OrtCheckpointState ortCheckpointState, String str, String str2, String str3) {
        this.closed = false;
        this.nativeHandle = j10;
        this.allocator = ortAllocator;
        this.checkpoint = ortCheckpointState;
        this.trainPath = str;
        this.evalPath = str2;
        this.optimizerPath = str3;
        this.trainInputNames = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList(getTrainInputNames(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, j10, ortAllocator.handle))));
        this.trainOutputNames = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList(getTrainOutputNames(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, j10, ortAllocator.handle))));
        this.evalInputNames = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList(getEvalInputNames(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, j10, ortAllocator.handle))));
        this.evalOutputNames = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList(getEvalOutputNames(OnnxRuntime.ortApiHandle, OnnxRuntime.ortTrainingApiHandle, j10, ortAllocator.handle))));
    }
}
