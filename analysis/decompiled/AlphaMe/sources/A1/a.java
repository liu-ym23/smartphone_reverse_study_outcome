package A1;

import B0.g;
import android.os.Handler;
import android.os.Message;

/* loaded from: classes.dex */
public final class a implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i4 = message.what;
        if (i4 == 0) {
            g.y(message.obj);
            throw null;
        }
        if (i4 != 1) {
            return false;
        }
        g.y(message.obj);
        throw null;
    }
}
