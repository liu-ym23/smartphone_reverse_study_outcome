package f3;

import android.os.Handler;
import android.os.Message;

/* renamed from: f3.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1432a implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            message.obj.getClass();
            throw new ClassCastException();
        }
        if (i != 1) {
            return false;
        }
        message.obj.getClass();
        throw new ClassCastException();
    }
}
