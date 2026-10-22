package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Build;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class SessionConfigurationCompat {
    public static final int SESSION_HIGH_SPEED = 1;
    public static final int SESSION_REGULAR = 0;
    private final SessionConfigurationCompatImpl mImpl;

    public static final class SessionConfigurationCompatApi28Impl implements SessionConfigurationCompatImpl {
        private final SessionConfiguration mObject;
        private final List<OutputConfigurationCompat> mOutputConfigurations;

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public Executor getExecutor() {
            return this.mObject.getExecutor();
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public InputConfigurationCompat getInputConfiguration() {
            return InputConfigurationCompat.wrap(this.mObject.getInputConfiguration());
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public CaptureRequest getSessionParameters() {
            return this.mObject.getSessionParameters();
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public int getSessionType() {
            return this.mObject.getSessionType();
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public CameraCaptureSession.StateCallback getStateCallback() {
            return this.mObject.getStateCallback();
        }

        public int hashCode() {
            return this.mObject.hashCode();
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public List<OutputConfigurationCompat> getOutputConfigurations() {
            return this.mOutputConfigurations;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public Object getSessionConfiguration() {
            return this.mObject;
        }

        public SessionConfigurationCompatApi28Impl(Object r100) {
            SessionConfiguration r101 = (SessionConfiguration) r100;
            this.mObject = r101;
            this.mOutputConfigurations = Collections.unmodifiableList(SessionConfigurationCompat.transformToCompat(r101.getOutputConfigurations()));
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof SessionConfigurationCompatApi28Impl) == true) goto L7;
            return false;
        L7:
            return Objects.equals(this.mObject, ((SessionConfigurationCompatApi28Impl) r100).mObject);
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public void setInputConfiguration(InputConfigurationCompat r100) {
            this.mObject.setInputConfiguration((InputConfiguration) r100.unwrap());
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public void setSessionParameters(CaptureRequest r100) {
            this.mObject.setSessionParameters(r100);
        }

        public SessionConfigurationCompatApi28Impl(int r100, List<OutputConfigurationCompat> r101, Executor r102, CameraCaptureSession.StateCallback r103) {
            this(new SessionConfiguration(r100, SessionConfigurationCompat.transformFromCompat(r101), r102, r103));
        }
    }

    public static final class SessionConfigurationCompatBaseImpl implements SessionConfigurationCompatImpl {
        private final Executor mExecutor;
        private InputConfigurationCompat mInputConfig;
        private final List<OutputConfigurationCompat> mOutputConfigurations;
        private CaptureRequest mSessionParameters;
        private final int mSessionType;
        private final CameraCaptureSession.StateCallback mStateCallback;

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public Object getSessionConfiguration() {
            return null;
        }

        public int hashCode() {
            int r100 = this.mOutputConfigurations.hashCode() ^ 31;
            int r101 = (r100 << 5) - r100;
            InputConfigurationCompat r102 = this.mInputConfig;
            if (r102 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = r103 ^ r101;
            int r105 = (r104 << 5) - r104;
            return this.mSessionType ^ r105;
        L5:
            r103 = r102.hashCode();
            goto L6
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public Executor getExecutor() {
            return this.mExecutor;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public InputConfigurationCompat getInputConfiguration() {
            return this.mInputConfig;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public List<OutputConfigurationCompat> getOutputConfigurations() {
            return this.mOutputConfigurations;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public CaptureRequest getSessionParameters() {
            return this.mSessionParameters;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public int getSessionType() {
            return this.mSessionType;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public CameraCaptureSession.StateCallback getStateCallback() {
            return this.mStateCallback;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof SessionConfigurationCompatBaseImpl) == false) goto L22;
            SessionConfigurationCompatBaseImpl r101 = (SessionConfigurationCompatBaseImpl) r100;
            if (Objects.equals(this.mInputConfig, r101.mInputConfig) == false) goto L22;
            if (this.mSessionType != r101.mSessionType) goto L22;
            if (this.mOutputConfigurations.size() != r101.mOutputConfigurations.size()) goto L22;
            int r102 = 0;
        L16:
            if (r102 >= this.mOutputConfigurations.size()) goto L21;
            if (((OutputConfigurationCompat) ListProtector.get(this.mOutputConfigurations, r102)).equals(ListProtector.get(r101.mOutputConfigurations, r102)) == false) goto L19;
            r102 = r102 + 1;
            goto L16
        L19:
            return false;
        L21:
            return true;
        L22:
            return false;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public void setInputConfiguration(InputConfigurationCompat r100) {
            if (this.mSessionType == 1) goto L7;
            this.mInputConfig = r100;
            return;
        L7:
            throw new UnsupportedOperationException("Method not supported for high speed session types");
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public void setSessionParameters(CaptureRequest r100) {
            this.mSessionParameters = r100;
        }

        public SessionConfigurationCompatBaseImpl(int r100, List<OutputConfigurationCompat> r101, Executor r102, CameraCaptureSession.StateCallback r103) {
            this.mInputConfig = null;
            this.mSessionParameters = null;
            this.mSessionType = r100;
            this.mOutputConfigurations = Collections.unmodifiableList(new ArrayList(r101));
            this.mStateCallback = r103;
            this.mExecutor = r102;
        }
    }

    public interface SessionConfigurationCompatImpl {
        Executor getExecutor();

        InputConfigurationCompat getInputConfiguration();

        List<OutputConfigurationCompat> getOutputConfigurations();

        Object getSessionConfiguration();

        CaptureRequest getSessionParameters();

        int getSessionType();

        CameraCaptureSession.StateCallback getStateCallback();

        void setInputConfiguration(InputConfigurationCompat r100);

        void setSessionParameters(CaptureRequest r100);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SessionMode {
    }

    public Executor getExecutor() {
        return this.mImpl.getExecutor();
    }

    public InputConfigurationCompat getInputConfiguration() {
        return this.mImpl.getInputConfiguration();
    }

    public List<OutputConfigurationCompat> getOutputConfigurations() {
        return this.mImpl.getOutputConfigurations();
    }

    public CaptureRequest getSessionParameters() {
        return this.mImpl.getSessionParameters();
    }

    public int getSessionType() {
        return this.mImpl.getSessionType();
    }

    public CameraCaptureSession.StateCallback getStateCallback() {
        return this.mImpl.getStateCallback();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public Object unwrap() {
        return this.mImpl.getSessionConfiguration();
    }

    private SessionConfigurationCompat(SessionConfigurationCompatImpl r100) {
        this.mImpl = r100;
    }

    public static List<OutputConfiguration> transformFromCompat(List<OutputConfigurationCompat> r100) {
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<OutputConfigurationCompat> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add((OutputConfiguration) r102.next().unwrap());
        goto L4
    L6:
        return r101;
    }

    public static List<OutputConfigurationCompat> transformToCompat(List<OutputConfiguration> r100) {
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<OutputConfiguration> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(OutputConfigurationCompat.wrap(r102.next()));
        goto L4
    L6:
        return r101;
    }

    public static SessionConfigurationCompat wrap(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT >= 28) goto L9;
        return null;
    L9:
        return new SessionConfigurationCompat(new SessionConfigurationCompatApi28Impl(r100));
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof SessionConfigurationCompat) == true) goto L7;
        return false;
    L7:
        return this.mImpl.equals(((SessionConfigurationCompat) r100).mImpl);
    }

    public void setInputConfiguration(InputConfigurationCompat r100) {
        this.mImpl.setInputConfiguration(r100);
    }

    public void setSessionParameters(CaptureRequest r100) {
        this.mImpl.setSessionParameters(r100);
    }

    public SessionConfigurationCompat(int r100, List<OutputConfigurationCompat> r101, Executor r102, CameraCaptureSession.StateCallback r103) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        this.mImpl = new SessionConfigurationCompatBaseImpl(r100, r101, r102, r103);
        return;
    L5:
        this.mImpl = new SessionConfigurationCompatApi28Impl(r100, r101, r102, r103);
    }
}
