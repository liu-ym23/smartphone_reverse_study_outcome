package v1;

import android.os.Handler;
import android.os.Message;
import r6.x;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f5957a;

    public e(x xVar) {
        this.f5957a = xVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        x xVar = this.f5957a;
        if (message.obj != null) {
            throw new ClassCastException();
        }
        synchronized (xVar.f5220a) {
            throw null;
        }
    }
}
