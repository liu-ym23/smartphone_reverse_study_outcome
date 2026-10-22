package com.bytedance.android.live.wallet.pay.iap;

import com.bytedance.android.live.recharge.utils.j;
import com.bytedance.android.livesdk.utils.r2;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f102695a = null;

    static {
        f102695a = (e) j.f90487x.getValue(null, j.f90464a[21]);
    }

    public static boolean a() {
        String r100 = ((wh6.a) vh6.c.b(wh6.a.class)).getChannel();
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        if (r2.a(r100) == false) goto L12;
        List<String> r101 = f102695a.a();
        if (r101 == null) goto L12;
        if (r101.contains(r100) != true) goto L12;
        return true;
    L12:
        return false;
    }
}
