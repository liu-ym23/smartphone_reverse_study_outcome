package androidx.camera.core.impl.utils;

import android.os.Build;
import android.util.CloseGuard;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
public final class CloseGuardHelper {
    private final CloseGuardImpl mImpl;

    public static final class CloseGuardApi30Impl implements CloseGuardImpl {
        private final CloseGuard mPlatformImpl;

        @Override // androidx.camera.core.impl.utils.CloseGuardHelper.CloseGuardImpl
        public void close() {
            this.mPlatformImpl.close();
        }

        @Override // androidx.camera.core.impl.utils.CloseGuardHelper.CloseGuardImpl
        public void warnIfOpen() {
            this.mPlatformImpl.warnIfOpen();
        }

        public CloseGuardApi30Impl() {
            this.mPlatformImpl = new CloseGuard();
        }

        @Override // androidx.camera.core.impl.utils.CloseGuardHelper.CloseGuardImpl
        public void open(String r100) {
            this.mPlatformImpl.open(r100);
        }
    }

    public interface CloseGuardImpl {
        void close();

        void open(String r100);

        void warnIfOpen();
    }

    public static final class CloseGuardNoOpImpl implements CloseGuardImpl {
        public CloseGuardNoOpImpl() {
        }

        @Override // androidx.camera.core.impl.utils.CloseGuardHelper.CloseGuardImpl
        public void close() {
        }

        @Override // androidx.camera.core.impl.utils.CloseGuardHelper.CloseGuardImpl
        public void warnIfOpen() {
        }

        @Override // androidx.camera.core.impl.utils.CloseGuardHelper.CloseGuardImpl
        public void open(String r100) {
            Preconditions.checkNotNull(r100, "CloseMethodName must not be null.");
        }
    }

    public static CloseGuardHelper create() {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return new CloseGuardHelper(new CloseGuardApi30Impl());
    L7:
        return new CloseGuardHelper(new CloseGuardNoOpImpl());
    }

    public void close() {
        this.mImpl.close();
    }

    public void warnIfOpen() {
        this.mImpl.warnIfOpen();
    }

    private CloseGuardHelper(CloseGuardImpl r100) {
        this.mImpl = r100;
    }

    public void open(String r100) {
        this.mImpl.open(r100);
    }
}
