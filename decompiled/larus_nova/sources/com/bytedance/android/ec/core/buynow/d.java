package com.bytedance.android.ec.core.buynow;

import android.net.Uri;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f43913a = 0;

    static {
    }

    public static String a(Uri r100) {
        if (r100 == null) goto L7;
        String r101 = UriProtector.getQueryParameter(r100, "url");
        if (r101 == null) goto L7;
        Boolean r102 = Boolean.valueOf(StringsKt.contains$default(r101, "ecommerce_buynow_yata/html/index.html", false, 2, null));
    L9:
        if (k.i(r102) == false) goto L12;
        return "yata_h5";
    L12:
        if (r100 == null) goto L14;
        String r103 = r100.getHost();
    L16:
        if (Intrinsics.areEqual(r103, "buy_now") == false) goto L19;
        return "yata_android";
    L19:
        return null;
    L14:
        r103 = null;
    L7:
        r102 = null;
        goto L9
    }

    public static void b(IOrderSchema r100) {
        Boolean r101 = null;
        if (r100 == null) goto L5;
        Boolean r102 = Boolean.valueOf(r100.Q0());
    L7:
        if (k.i(r102) == true) goto L13;
        if (r100 == null) goto L11;
        r101 = Boolean.valueOf(r100.u());
    L11:
        k.i(r101);
        return;
    L13:
        return;
    L5:
        r102 = null;
        goto L7
    }
}
