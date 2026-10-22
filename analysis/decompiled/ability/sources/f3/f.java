package f3;

import android.os.Handler;
import android.os.Message;
import u1.C2031a;

/* loaded from: classes3.dex */
public final class f implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2031a f4437a;

    public f(C2031a c2031a) {
        this.f4437a = c2031a;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        C2031a c2031a = this.f4437a;
        if (message.obj != null) {
            throw new ClassCastException();
        }
        synchronized (c2031a.f6686a) {
            throw null;
        }
    }
}
