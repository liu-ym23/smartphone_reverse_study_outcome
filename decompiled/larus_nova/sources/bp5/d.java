package bp5;

import android.view.Window;

/* JADX INFO: loaded from: classes18.dex */
public final class d {
    public static void a(Window r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r102 = r100.getAttributes().flags;
        if ((((~r101) & r102) | (r101 & r101)) == r102) goto L8;
        r100.addFlags(r101);
        return;
    }
}
