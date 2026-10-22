package bp5;

import android.view.Window;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements a {
    public f() {
    }

    @Override // bp5.a
    public final void a(Window r100, int r101) {
        if (r100 == null) goto L7;
        int r102 = r100.getAttributes().flags;
        if ((((-67108865) & r102) | 0) == r102) goto L7;
        r100.clearFlags(67108864);
    L7:
        d.a(r100, Integer.MIN_VALUE);
        if (r100 != null) goto L10;
        return;
    L10:
        if (r100.getStatusBarColor() == r101) goto L14;
        r100.setStatusBarColor(r101);
        return;
    }
}
