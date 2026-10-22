package h7;

import android.os.Handler;
import android.os.Message;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ b f5397a;

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        b bVar = this.f5397a;
        if (message.obj != null) {
            f.j();
            return false;
        }
        synchronized (bVar.f5399a) {
            throw null;
        }
    }
}
