package t0;

import android.view.Choreographer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class h {
    public static void a(Runnable runnable) {
        Choreographer.getInstance().postFrameCallback(new n0.b(runnable, 1));
    }
}
