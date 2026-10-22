package androidx.camera.core;

/* loaded from: classes.dex */
public abstract class CameraState {

    public enum Type {
        PENDING_OPEN,
        OPENING,
        OPEN,
        CLOSING,
        CLOSED
    }

    public static abstract class a {
        public static a a(int i10) {
            return b(i10, null);
        }

        public static a b(int i10, Throwable th) {
            return new c(i10, th);
        }

        public abstract Throwable c();

        public abstract int d();
    }

    public static CameraState a(Type type, a aVar) {
        return new b(type, aVar);
    }

    public abstract a b();

    public abstract Type c();
}
