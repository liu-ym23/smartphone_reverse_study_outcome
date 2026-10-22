package androidx.lifecycle;

import android.app.Activity;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class a0 {
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Activity activity, l event) {
        t tVarD;
        kotlin.jvm.internal.p.e(event, "event");
        if (!(activity instanceof r) || (tVarD = ((r) activity).d()) == null) {
            return;
        }
        tVarD.d(event);
    }
}
