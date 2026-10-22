package A1;

import B0.g;
import android.os.Handler;
import android.os.Message;

/* loaded from: classes.dex */
public final class e implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t.d f55a;

    public e(t.d dVar) {
        this.f55a = dVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        t.d dVar = this.f55a;
        g.y(message.obj);
        synchronized (dVar.f15273a) {
            g.y(dVar.f15275c);
            throw null;
        }
    }
}
