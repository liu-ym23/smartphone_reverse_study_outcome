package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.InputConfiguration;
import android.os.Build;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class InputConfigurationCompat {
    private final InputConfigurationCompatImpl mImpl;

    public static class InputConfigurationCompatApi23Impl implements InputConfigurationCompatImpl {
        private final InputConfiguration mObject;

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public boolean isMultiResolution() {
            return false;
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public int getFormat() {
            return this.mObject.getFormat();
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public int getHeight() {
            return this.mObject.getHeight();
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public int getWidth() {
            return this.mObject.getWidth();
        }

        public int hashCode() {
            return this.mObject.hashCode();
        }

        public String toString() {
            return this.mObject.toString();
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public Object getInputConfiguration() {
            return this.mObject;
        }

        public InputConfigurationCompatApi23Impl(Object r100) {
            this.mObject = (InputConfiguration) r100;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof InputConfigurationCompatImpl) == true) goto L7;
            return false;
        L7:
            return Objects.equals(this.mObject, ((InputConfigurationCompatImpl) r100).getInputConfiguration());
        }

        public InputConfigurationCompatApi23Impl(int r100, int r101, int r102) {
            this(new InputConfiguration(r100, r101, r102));
        }
    }

    public static final class InputConfigurationCompatApi31Impl extends InputConfigurationCompatApi23Impl {
        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatApi23Impl, androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public boolean isMultiResolution() {
            return ((InputConfiguration) getInputConfiguration()).isMultiResolution();
        }

        public InputConfigurationCompatApi31Impl(Object r100) {
            super(r100);
        }

        public InputConfigurationCompatApi31Impl(int r100, int r101, int r102) {
            super(r100, r101, r102);
        }
    }

    public static final class InputConfigurationCompatBaseImpl implements InputConfigurationCompatImpl {
        private final int mFormat;
        private final int mHeight;
        private final int mWidth;

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public Object getInputConfiguration() {
            return null;
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public boolean isMultiResolution() {
            return false;
        }

        public String toString() {
            return String.format("InputConfiguration(w:%d, h:%d, format:%d)", new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.mFormat)});
        }

        public int hashCode() {
            int r100 = 31 ^ this.mWidth;
            int r101 = (r100 << 5) - r100;
            int r102 = this.mHeight ^ r101;
            int r103 = (r102 << 5) - r102;
            return this.mFormat ^ r103;
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public int getFormat() {
            return this.mFormat;
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public int getHeight() {
            return this.mHeight;
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public int getWidth() {
            return this.mWidth;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof InputConfigurationCompatBaseImpl) == true) goto L5;
            return false;
        L5:
            InputConfigurationCompatBaseImpl r101 = (InputConfigurationCompatBaseImpl) r100;
            if (r101.getWidth() == this.mWidth) goto L8;
            return false;
        L8:
            if (r101.getHeight() == this.mHeight) goto L10;
            return false;
        L10:
            if (r101.getFormat() != this.mFormat) goto L15;
            return true;
        L15:
            return false;
        }

        public InputConfigurationCompatBaseImpl(int r100, int r101, int r102) {
            this.mWidth = r100;
            this.mHeight = r101;
            this.mFormat = r102;
        }
    }

    public interface InputConfigurationCompatImpl {
        int getFormat();

        int getHeight();

        Object getInputConfiguration();

        int getWidth();

        boolean isMultiResolution();
    }

    public int getFormat() {
        return this.mImpl.getFormat();
    }

    public int getHeight() {
        return this.mImpl.getHeight();
    }

    public int getWidth() {
        return this.mImpl.getWidth();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public boolean isMultiResolution() {
        return this.mImpl.isMultiResolution();
    }

    public String toString() {
        return this.mImpl.toString();
    }

    public Object unwrap() {
        return this.mImpl.getInputConfiguration();
    }

    private InputConfigurationCompat(InputConfigurationCompatImpl r100) {
        this.mImpl = r100;
    }

    public static InputConfigurationCompat wrap(Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 23) goto L9;
        return null;
    L9:
        if (r101 < 31) goto L13;
        return new InputConfigurationCompat(new InputConfigurationCompatApi31Impl(r100));
    L13:
        return new InputConfigurationCompat(new InputConfigurationCompatApi23Impl(r100));
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof InputConfigurationCompat) == true) goto L7;
        return false;
    L7:
        return this.mImpl.equals(((InputConfigurationCompat) r100).mImpl);
    }

    public InputConfigurationCompat(int r100, int r101, int r102) {
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 31) goto L6;
        this.mImpl = new InputConfigurationCompatApi31Impl(r100, r101, r102);
        return;
    L6:
        if (r103 < 23) goto L8;
        this.mImpl = new InputConfigurationCompatApi23Impl(r100, r101, r102);
        return;
    L8:
        this.mImpl = new InputConfigurationCompatBaseImpl(r100, r101, r102);
    }
}
