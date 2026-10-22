package a1;

import android.view.ViewGroup;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class x {
    public static int a(ViewGroup viewGroup, int i8) {
        return viewGroup.getChildDrawingOrder(i8);
    }

    public static void b(ViewGroup viewGroup, boolean z) {
        viewGroup.suppressLayout(z);
    }
}
