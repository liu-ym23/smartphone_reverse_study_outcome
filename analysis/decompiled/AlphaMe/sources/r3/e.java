package r3;

import androidx.appcompat.widget.C0238z;
import org.tensorflow.Session;

/* loaded from: classes2.dex */
public final class e implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0238z f14093a;

    public e(C0238z c0238z) {
        this.f14093a = c0238z;
        synchronized (((Session) c0238z.f3217f).f13821c) {
            try {
                Object obj = c0238z.f3217f;
                if (((Session) obj).f13822d == 0) {
                    throw new IllegalStateException("run() cannot be called on the Session after close()");
                }
                ((Session) obj).f13823e++;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        synchronized (((Session) this.f14093a.f3217f).f13821c) {
            try {
                Object obj = this.f14093a.f3217f;
                if (((Session) obj).f13822d == 0) {
                    return;
                }
                Session session = (Session) obj;
                int i4 = session.f13823e - 1;
                session.f13823e = i4;
                if (i4 == 0) {
                    ((Session) obj).f13821c.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
