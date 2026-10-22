package K;

import android.os.Handler;
import java.util.concurrent.Executor;

/* renamed from: K.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0879e extends O {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f3956a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f3957b;

    public C0879e(Executor executor, Handler handler) {
        if (executor == null) {
            throw new NullPointerException("Null cameraExecutor");
        }
        this.f3956a = executor;
        if (handler == null) {
            throw new NullPointerException("Null schedulerHandler");
        }
        this.f3957b = handler;
    }

    @Override // K.O
    public Executor b() {
        return this.f3956a;
    }

    @Override // K.O
    public Handler c() {
        return this.f3957b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof O) {
            O o10 = (O) obj;
            if (this.f3956a.equals(o10.b()) && this.f3957b.equals(o10.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f3957b.hashCode() ^ ((this.f3956a.hashCode() ^ 1000003) * 1000003);
    }

    public String toString() {
        return "CameraThreadConfig{cameraExecutor=" + this.f3956a + ", schedulerHandler=" + this.f3957b + "}";
    }
}
