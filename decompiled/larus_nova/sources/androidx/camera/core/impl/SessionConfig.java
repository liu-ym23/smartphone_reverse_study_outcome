package androidx.camera.core.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.internal.compat.workaround.SurfaceSorter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class SessionConfig {
    public static final int DEFAULT_SESSION_TYPE = 0;
    private static final List<Integer> SUPPORTED_TEMPLATE_PRIORITY = null;
    private final List<CameraDevice.StateCallback> mDeviceStateCallbacks;
    private final ErrorListener mErrorListener;
    private InputConfiguration mInputConfiguration;
    private final List<OutputConfig> mOutputConfigs;
    private final OutputConfig mPostviewOutputConfig;
    private final CaptureConfig mRepeatingCaptureConfig;
    private final List<CameraCaptureSession.StateCallback> mSessionStateCallbacks;
    private final int mSessionType;
    private final List<CameraCaptureCallback> mSingleCameraCaptureCallbacks;

    public static class BaseBuilder {
        final CaptureConfig.Builder mCaptureConfigBuilder;
        final List<CameraDevice.StateCallback> mDeviceStateCallbacks;
        ErrorListener mErrorListener;
        InputConfiguration mInputConfiguration;
        final Set<OutputConfig> mOutputConfigs;
        OutputConfig mPostviewOutputConfig;
        final List<CameraCaptureSession.StateCallback> mSessionStateCallbacks;
        int mSessionType;
        final List<CameraCaptureCallback> mSingleCameraCaptureCallbacks;

        public BaseBuilder() {
            this.mOutputConfigs = new LinkedHashSet();
            this.mCaptureConfigBuilder = new CaptureConfig.Builder();
            this.mDeviceStateCallbacks = new ArrayList();
            this.mSessionStateCallbacks = new ArrayList();
            this.mSingleCameraCaptureCallbacks = new ArrayList();
            this.mSessionType = 0;
        }
    }

    public static class Builder extends BaseBuilder {
        public SessionConfig build() {
            return new SessionConfig(new ArrayList(this.mOutputConfigs), new ArrayList(this.mDeviceStateCallbacks), new ArrayList(this.mSessionStateCallbacks), new ArrayList(this.mSingleCameraCaptureCallbacks), this.mCaptureConfigBuilder.build(), this.mErrorListener, this.mInputConfiguration, this.mSessionType, this.mPostviewOutputConfig);
        }

        public Builder clearSurfaces() {
            this.mOutputConfigs.clear();
            this.mCaptureConfigBuilder.clearSurfaces();
            return this;
        }

        public List<CameraCaptureCallback> getSingleCameraCaptureCallbacks() {
            return Collections.unmodifiableList(this.mSingleCameraCaptureCallbacks);
        }

        public Builder() {
        }

        public Builder addAllCameraCaptureCallbacks(Collection<CameraCaptureCallback> r100) {
            Iterator<CameraCaptureCallback> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            CameraCaptureCallback r102 = r101.next();
            this.mCaptureConfigBuilder.addCameraCaptureCallback(r102);
            if (this.mSingleCameraCaptureCallbacks.contains(r102) == true) goto L4;
            this.mSingleCameraCaptureCallbacks.add(r102);
            goto L4
        L8:
            return this;
        }

        public Builder addAllDeviceStateCallbacks(Collection<CameraDevice.StateCallback> r100) {
            Iterator<CameraDevice.StateCallback> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            addDeviceStateCallback(r101.next());
            goto L4
        L6:
            return this;
        }

        public Builder addAllRepeatingCameraCaptureCallbacks(Collection<CameraCaptureCallback> r100) {
            this.mCaptureConfigBuilder.addAllCameraCaptureCallbacks(r100);
            return this;
        }

        public Builder addAllSessionStateCallbacks(List<CameraCaptureSession.StateCallback> r100) {
            Iterator<CameraCaptureSession.StateCallback> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            addSessionStateCallback(r101.next());
            goto L4
        L6:
            return this;
        }

        public Builder addCameraCaptureCallback(CameraCaptureCallback r100) {
            this.mCaptureConfigBuilder.addCameraCaptureCallback(r100);
            if (this.mSingleCameraCaptureCallbacks.contains(r100) == true) goto L5;
            this.mSingleCameraCaptureCallbacks.add(r100);
        L5:
            return this;
        }

        public Builder addDeviceStateCallback(CameraDevice.StateCallback r100) {
            if (this.mDeviceStateCallbacks.contains(r100) == false) goto L5;
            return this;
        L5:
            this.mDeviceStateCallbacks.add(r100);
            return this;
        }

        public Builder addImplementationOptions(Config r100) {
            this.mCaptureConfigBuilder.addImplementationOptions(r100);
            return this;
        }

        public Builder addNonRepeatingSurface(DeferrableSurface r100) {
            return addNonRepeatingSurface(r100, DynamicRange.SDR);
        }

        public Builder addOutputConfig(OutputConfig r100) {
            this.mOutputConfigs.add(r100);
            this.mCaptureConfigBuilder.addSurface(r100.getSurface());
            Iterator<DeferrableSurface> r101 = r100.getSharedSurfaces().iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            DeferrableSurface r102 = r101.next();
            this.mCaptureConfigBuilder.addSurface(r102);
            goto L4
        L6:
            return this;
        }

        public Builder addRepeatingCameraCaptureCallback(CameraCaptureCallback r100) {
            this.mCaptureConfigBuilder.addCameraCaptureCallback(r100);
            return this;
        }

        public Builder addSessionStateCallback(CameraCaptureSession.StateCallback r100) {
            if (this.mSessionStateCallbacks.contains(r100) == false) goto L5;
            return this;
        L5:
            this.mSessionStateCallbacks.add(r100);
            return this;
        }

        public Builder addSurface(DeferrableSurface r100) {
            return addSurface(r100, DynamicRange.SDR, null, -1);
        }

        public boolean removeCameraCaptureCallback(CameraCaptureCallback r100) {
            boolean r101 = this.mCaptureConfigBuilder.removeCameraCaptureCallback(r100);
            boolean r102 = this.mSingleCameraCaptureCallbacks.remove(r100);
            if (r101 == true) goto L7;
            if (r102 == true) goto L7;
            return false;
        L7:
            return true;
        }

        public Builder removeSurface(DeferrableSurface r100) {
            Iterator<OutputConfig> r101 = this.mOutputConfigs.iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            OutputConfig r102 = r101.next();
            if (r102.getSurface().equals(r100) == false) goto L4;
        L9:
            if (r102 == null) goto L11;
            this.mOutputConfigs.remove(r102);
        L11:
            this.mCaptureConfigBuilder.removeSurface(r100);
            return this;
        L8:
            r102 = null;
            goto L9
        }

        public Builder setErrorListener(ErrorListener r100) {
            this.mErrorListener = r100;
            return this;
        }

        public Builder setExpectedFrameRateRange(Range<Integer> r100) {
            this.mCaptureConfigBuilder.setExpectedFrameRateRange(r100);
            return this;
        }

        public Builder setImplementationOptions(Config r100) {
            this.mCaptureConfigBuilder.setImplementationOptions(r100);
            return this;
        }

        public Builder setInputConfiguration(InputConfiguration r100) {
            this.mInputConfiguration = r100;
            return this;
        }

        public Builder setPostviewSurface(DeferrableSurface r100) {
            this.mPostviewOutputConfig = OutputConfig.builder(r100).build();
            return this;
        }

        public Builder setPreviewStabilization(int r100) {
            if (r100 == 0) goto L4;
            this.mCaptureConfigBuilder.setPreviewStabilization(r100);
        L4:
            return this;
        }

        public Builder setSessionType(int r100) {
            this.mSessionType = r100;
            return this;
        }

        public Builder setTemplateType(int r100) {
            this.mCaptureConfigBuilder.setTemplateType(r100);
            return this;
        }

        public Builder setVideoStabilization(int r100) {
            if (r100 == 0) goto L4;
            this.mCaptureConfigBuilder.setVideoStabilization(r100);
        L4:
            return this;
        }

        public static Builder createFrom(UseCaseConfig<?> r100, Size r101) {
            OptionUnpacker r102 = r100.getSessionOptionUnpacker(null);
            if (r102 == null) goto L7;
            Builder r103 = new Builder();
            r102.unpack(r101, r100, r103);
            return r103;
        L7:
            throw new IllegalStateException("Implementation is missing option unpacker for " + r100.getTargetName(r100.toString()));
        }

        public Builder addNonRepeatingSurface(DeferrableSurface r100, DynamicRange r101) {
            OutputConfig r102 = OutputConfig.builder(r100).setDynamicRange(r101).build();
            this.mOutputConfigs.add(r102);
            return this;
        }

        public Builder addTag(String r100, Object r101) {
            this.mCaptureConfigBuilder.addTag(r100, r101);
            return this;
        }

        public Builder addSurface(DeferrableSurface r100, DynamicRange r101, String r102, int r103) {
            OutputConfig r104 = OutputConfig.builder(r100).setPhysicalCameraId(r102).setDynamicRange(r101).setMirrorMode(r103).build();
            this.mOutputConfigs.add(r104);
            this.mCaptureConfigBuilder.addSurface(r100);
            return this;
        }
    }

    public static final class CloseableErrorListener implements ErrorListener {
        private final ErrorListener mErrorListener;
        private final AtomicBoolean mIsClosed;

        public void close() {
            this.mIsClosed.set(true);
        }

        public CloseableErrorListener(ErrorListener r100) {
            this.mIsClosed = new AtomicBoolean(false);
            this.mErrorListener = r100;
        }

        @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
        public void onError(SessionConfig r100, SessionError r101) {
            if (this.mIsClosed.get() == true) goto L6;
            this.mErrorListener.onError(r100, r101);
            return;
        }
    }

    public interface ErrorListener {
        void onError(SessionConfig r100, SessionError r101);
    }

    public interface OptionUnpacker {
        void unpack(Size r100, UseCaseConfig<?> r101, Builder r102);
    }

    public static abstract class OutputConfig {
        public static final int SURFACE_GROUP_ID_NONE = -1;

        public static abstract class Builder {
            public Builder() {
            }

            public abstract OutputConfig build();

            public abstract Builder setDynamicRange(DynamicRange r100);

            public abstract Builder setMirrorMode(int r100);

            public abstract Builder setPhysicalCameraId(String r100);

            public abstract Builder setSharedSurfaces(List<DeferrableSurface> r100);

            public abstract Builder setSurface(DeferrableSurface r100);

            public abstract Builder setSurfaceGroupId(int r100);
        }

        public OutputConfig() {
        }

        public abstract DynamicRange getDynamicRange();

        public abstract int getMirrorMode();

        public abstract String getPhysicalCameraId();

        public abstract List<DeferrableSurface> getSharedSurfaces();

        public abstract DeferrableSurface getSurface();

        public abstract int getSurfaceGroupId();

        public static Builder builder(DeferrableSurface r100) {
            return new AutoValue_SessionConfig_OutputConfig.Builder().setSurface(r100).setSharedSurfaces(Collections.emptyList()).setPhysicalCameraId(null).setMirrorMode(-1).setSurfaceGroupId(-1).setDynamicRange(DynamicRange.SDR);
        }
    }

    public static final enum SessionError extends Enum<SessionError> {
        private static final /* synthetic */ SessionError[] $VALUES = null;
        public static final SessionError SESSION_ERROR_SURFACE_NEEDS_RESET = null;
        public static final SessionError SESSION_ERROR_UNKNOWN = null;

        private static /* synthetic */ SessionError[] $values() {
            return new SessionError[]{SESSION_ERROR_SURFACE_NEEDS_RESET, SESSION_ERROR_UNKNOWN};
        }

        static {
            SESSION_ERROR_SURFACE_NEEDS_RESET = new SessionError("SESSION_ERROR_SURFACE_NEEDS_RESET", 0);
            SESSION_ERROR_UNKNOWN = new SessionError("SESSION_ERROR_UNKNOWN", 1);
            $VALUES = $values();
        }

        public static SessionError[] values() {
            return (SessionError[]) $VALUES.clone();
        }

        public static SessionError valueOf(String r100) {
            return (SessionError) r27.a.a(SessionError.class, r100);
        }

        private SessionError(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class ValidatingBuilder extends BaseBuilder {
        private static final String TAG = "ValidatingBuilder";
        private List<ErrorListener> mErrorListeners;
        private final SurfaceSorter mSurfaceSorter;
        private boolean mTemplateSet;
        private boolean mValid;

        public static /* synthetic */ void a(ValidatingBuilder r100, SessionConfig r101, SessionError r102) {
            r100.lambda$build$0(r101, r102);
        }

        private List<DeferrableSurface> getSurfaces() {
            ArrayList r100 = new ArrayList();
            Iterator<OutputConfig> r101 = this.mOutputConfigs.iterator();
        L4:
            if (r101.hasNext() == false) goto L9;
            OutputConfig r102 = r101.next();
            r100.add(r102.getSurface());
            Iterator<DeferrableSurface> r103 = r102.getSharedSurfaces().iterator();
        L7:
            if (r103.hasNext() == false) goto L4;
            r100.add(r103.next());
            goto L7
        L9:
            return r100;
        }

        public SessionConfig build() {
            if (this.mValid == false) goto L11;
            ArrayList r100 = new ArrayList(this.mOutputConfigs);
            this.mSurfaceSorter.sort(r100);
            if (this.mErrorListeners.isEmpty() == true) goto L7;
            ErrorListener r101 = new u(this);
        L8:
            ArrayList r102 = new ArrayList(this.mDeviceStateCallbacks);
            ArrayList r103 = new ArrayList(this.mSessionStateCallbacks);
            ArrayList r104 = new ArrayList(this.mSingleCameraCaptureCallbacks);
            CaptureConfig r105 = this.mCaptureConfigBuilder.build();
            return new SessionConfig(r100, r102, r103, r104, r105, r101, this.mInputConfiguration, this.mSessionType, this.mPostviewOutputConfig);
        L7:
            r101 = null;
            goto L8
        L11:
            throw new IllegalArgumentException("Unsupported session configuration combination");
        }

        public void clearSurfaces() {
            this.mOutputConfigs.clear();
            this.mCaptureConfigBuilder.clearSurfaces();
        }

        public boolean isValid() {
            if (this.mTemplateSet == true) goto L5;
        L7:
            return false;
        L5:
            if (this.mValid == false) goto L7;
            return true;
        }

        public ValidatingBuilder() {
            this.mSurfaceSorter = new SurfaceSorter();
            this.mValid = true;
            this.mTemplateSet = false;
            this.mErrorListeners = new ArrayList();
        }

        private void setOrVerifyExpectFrameRateRange(Range<Integer> r100) {
            Range<Integer> r101 = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
            if (r100.equals(r101) == false) goto L6;
            return;
        L6:
            if (this.mCaptureConfigBuilder.getExpectedFrameRateRange().equals(r101) == false) goto L10;
            this.mCaptureConfigBuilder.setExpectedFrameRateRange(r100);
            return;
        L10:
            if (this.mCaptureConfigBuilder.getExpectedFrameRateRange().equals(r100) == true) goto L13;
            this.mValid = false;
            Logger.d(TAG, "Different ExpectedFrameRateRange values");
            return;
        }

        private void setPreviewStabilizationMode(int r100) {
            if (r100 == 0) goto L5;
            this.mCaptureConfigBuilder.setPreviewStabilization(r100);
            return;
        }

        private void setVideoStabilizationMode(int r100) {
            if (r100 == 0) goto L5;
            this.mCaptureConfigBuilder.setVideoStabilization(r100);
            return;
        }

        public void add(SessionConfig r100) {
            CaptureConfig r101 = r100.getRepeatingCaptureConfig();
            if (r101.getTemplateType() == (-1)) goto L5;
            this.mTemplateSet = true;
            this.mCaptureConfigBuilder.setTemplateType(SessionConfig.getHigherPriorityTemplateType(r101.getTemplateType(), this.mCaptureConfigBuilder.getTemplateType()));
        L5:
            setOrVerifyExpectFrameRateRange(r101.getExpectedFrameRateRange());
            setPreviewStabilizationMode(r101.getPreviewStabilizationMode());
            setVideoStabilizationMode(r101.getVideoStabilizationMode());
            TagBundle r102 = r100.getRepeatingCaptureConfig().getTagBundle();
            this.mCaptureConfigBuilder.addAllTags(r102);
            this.mDeviceStateCallbacks.addAll(r100.getDeviceStateCallbacks());
            this.mSessionStateCallbacks.addAll(r100.getSessionStateCallbacks());
            this.mCaptureConfigBuilder.addAllCameraCaptureCallbacks(r100.getRepeatingCameraCaptureCallbacks());
            this.mSingleCameraCaptureCallbacks.addAll(r100.getSingleCameraCaptureCallbacks());
            if (r100.getErrorListener() == null) goto L9;
            this.mErrorListeners.add(r100.getErrorListener());
        L9:
            if (r100.getInputConfiguration() == null) goto L11;
            this.mInputConfiguration = r100.getInputConfiguration();
        L11:
            this.mOutputConfigs.addAll(r100.getOutputConfigs());
            this.mCaptureConfigBuilder.getSurfaces().addAll(r101.getSurfaces());
            if (getSurfaces().containsAll(this.mCaptureConfigBuilder.getSurfaces()) == true) goto L15;
            Logger.d(TAG, "Invalid configuration due to capture request surfaces are not a subset of surfaces");
            this.mValid = false;
        L15:
            if (r100.getSessionType() == this.mSessionType) goto L22;
            if (r100.getSessionType() == 0) goto L22;
            if (this.mSessionType == 0) goto L22;
            Logger.d(TAG, "Invalid configuration due to that two non-default session types are set");
            this.mValid = false;
        L25:
            if (SessionConfig.access$000(r100) != null) goto L27;
        L32:
            this.mCaptureConfigBuilder.addImplementationOptions(r101.getImplementationOptions());
            return;
        L27:
            if (this.mPostviewOutputConfig != SessionConfig.access$000(r100)) goto L29;
        L31:
            this.mPostviewOutputConfig = SessionConfig.access$000(r100);
            goto L32
        L29:
            if (this.mPostviewOutputConfig == null) goto L31;
            Logger.d(TAG, "Invalid configuration due to that two different postview output configs are set");
            this.mValid = false;
        L22:
            if (r100.getSessionType() == 0) goto L25;
            this.mSessionType = r100.getSessionType();
            goto L25
        }

        private /* synthetic */ void lambda$build$0(SessionConfig r100, SessionError r101) {
            Iterator<ErrorListener> r102 = this.mErrorListeners.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r102.next().onError(r100, r101);
            goto L4
        }

        public <T> void addImplementationOption(Config.Option<T> r100, T r101) {
            this.mCaptureConfigBuilder.addImplementationOption(r100, r101);
        }
    }

    static {
        SUPPORTED_TEMPLATE_PRIORITY = Arrays.asList(new Integer[]{1, 5, 3});
    }

    public static SessionConfig defaultEmptySessionConfig() {
        return new SessionConfig(new ArrayList(), new ArrayList(0), new ArrayList(0), new ArrayList(0), new CaptureConfig.Builder().build(), null, null, 0, null);
    }

    public Range<Integer> getExpectedFrameRateRange() {
        return this.mRepeatingCaptureConfig.getExpectedFrameRateRange();
    }

    public Config getImplementationOptions() {
        return this.mRepeatingCaptureConfig.getImplementationOptions();
    }

    public List<CameraCaptureCallback> getRepeatingCameraCaptureCallbacks() {
        return this.mRepeatingCaptureConfig.getCameraCaptureCallbacks();
    }

    public List<DeferrableSurface> getSurfaces() {
        ArrayList r100 = new ArrayList();
        Iterator<OutputConfig> r101 = this.mOutputConfigs.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        OutputConfig r102 = r101.next();
        r100.add(r102.getSurface());
        Iterator<DeferrableSurface> r103 = r102.getSharedSurfaces().iterator();
    L7:
        if (r103.hasNext() == false) goto L4;
        r100.add(r103.next());
        goto L7
    L10:
        return Collections.unmodifiableList(r100);
    }

    public int getTemplateType() {
        return this.mRepeatingCaptureConfig.getTemplateType();
    }

    public List<CameraDevice.StateCallback> getDeviceStateCallbacks() {
        return this.mDeviceStateCallbacks;
    }

    public ErrorListener getErrorListener() {
        return this.mErrorListener;
    }

    public InputConfiguration getInputConfiguration() {
        return this.mInputConfiguration;
    }

    public List<OutputConfig> getOutputConfigs() {
        return this.mOutputConfigs;
    }

    public OutputConfig getPostviewOutputConfig() {
        return this.mPostviewOutputConfig;
    }

    public CaptureConfig getRepeatingCaptureConfig() {
        return this.mRepeatingCaptureConfig;
    }

    public List<CameraCaptureSession.StateCallback> getSessionStateCallbacks() {
        return this.mSessionStateCallbacks;
    }

    public int getSessionType() {
        return this.mSessionType;
    }

    public List<CameraCaptureCallback> getSingleCameraCaptureCallbacks() {
        return this.mSingleCameraCaptureCallbacks;
    }

    public static /* synthetic */ OutputConfig access$000(SessionConfig r100) {
        return r100.mPostviewOutputConfig;
    }

    public static int getHigherPriorityTemplateType(int r100, int r101) {
        List<Integer> r102 = SUPPORTED_TEMPLATE_PRIORITY;
        if (r102.indexOf(Integer.valueOf(r100)) < r102.indexOf(Integer.valueOf(r101))) goto L6;
        return r100;
    L6:
        return r101;
    }

    public SessionConfig(List<OutputConfig> r100, List<CameraDevice.StateCallback> r101, List<CameraCaptureSession.StateCallback> r102, List<CameraCaptureCallback> r103, CaptureConfig r104, ErrorListener r105, InputConfiguration r106, int r107, OutputConfig r108) {
        this.mOutputConfigs = r100;
        this.mDeviceStateCallbacks = Collections.unmodifiableList(r101);
        this.mSessionStateCallbacks = Collections.unmodifiableList(r102);
        this.mSingleCameraCaptureCallbacks = Collections.unmodifiableList(r103);
        this.mErrorListener = r105;
        this.mRepeatingCaptureConfig = r104;
        this.mInputConfiguration = r106;
        this.mSessionType = r107;
        this.mPostviewOutputConfig = r108;
    }
}
