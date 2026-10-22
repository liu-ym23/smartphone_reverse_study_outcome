package b2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/* JADX INFO: loaded from: classes39.dex */
public final class a {
    public a() {
    }

    public static View a(Context r100, int r101) {
        if (d.f16978b == false) goto L26;
    L11:
        b r102 = c.f16976a.get(r101);
        if (r102 != null) goto L24;
        Integer.toHexString(r101);
        return LayoutInflater.from(r100).inflate(r101, null, false);
    L24:
        return r102.a();
    L16:
        th = move-exception;
        if (d.f16977a == false) goto L20;
        th.getMessage();
        throw new IllegalStateException(th);
    L20:
        return LayoutInflater.from(r100).inflate(r101, null, false);
    L26:
        if ((r100.getApplicationInfo().flags & 2) == 0) goto L9;
        boolean r103 = true;
    L10:
        d.f16977a = r103;
        d.f16978b = true;
    L9:
        r103 = false;
        goto L10
    }
}
