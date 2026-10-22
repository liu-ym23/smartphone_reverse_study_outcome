package C0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
class y {

    /* renamed from: a, reason: collision with root package name */
    private boolean f510a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f511b = new Handler(Looper.getMainLooper(), new a());

    private static final class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((v) message.obj).b();
            return true;
        }
    }

    y() {
    }

    synchronized void a(v<?> vVar) {
        try {
            if (this.f510a) {
                this.f511b.obtainMessage(1, vVar).sendToTarget();
            } else {
                this.f510a = true;
                vVar.b();
                this.f510a = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
