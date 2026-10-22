package bp5;

import android.R;
import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements a {
    public g() {
    }

    @Override // bp5.a
    public final void a(Window r100, int r101) {
        if (r100 == null) goto L8;
        int r102 = r100.getAttributes().flags;
        if ((((-67108865) & r102) | 0) == r102) goto L8;
        r100.clearFlags(67108864);
    L8:
        d.a(r100, Integer.MIN_VALUE);
        if (r100 == null) goto L23;
        if (r100.getStatusBarColor() == r101) goto L23;
        r100.setStatusBarColor(r101);
    L23:
        View r103 = r100.findViewById(R.id.content);     // Catch: Throwable -> L20
        if (r103 != null) goto L17;
        return;
    L17:
        if (r103.getForeground() == null) goto L26;
        r103.setForeground(null);     // Catch: Throwable -> L20
        return;
    L26:
        return;
    L20:
        th = move-exception;
        tt5.a.f("StatusBarMImpl", th, false);
    }
}
