package t0;

import android.os.Handler;
import android.os.Looper;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class i {
    public static Handler a(Looper looper) {
        return Handler.createAsync(looper);
    }
}
