package v1;

import android.os.Handler;
import android.os.Message;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i8 = message.what;
        if (i8 == 0) {
            message.obj.getClass();
            throw new ClassCastException();
        }
        if (i8 != 1) {
            return false;
        }
        message.obj.getClass();
        throw new ClassCastException();
    }
}
