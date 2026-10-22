package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f169207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f169208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f169209c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f169210d = false;

    static {
        boolean r100 = true;
        if (a() == false) goto L5;
    L12:
        boolean r101 = true;
    L13:
        f169209c = r101;
        if (com.bytedance.android.shopping.anchorv4.experiment.h.a() == false) goto L17;
        if (r101 == false) goto L17;
    L20:
        f169210d = r100;
        return;
    L17:
        if (com.bytedance.android.ec.core.abtest.d.a() == true) goto L20;
        r100 = false;
        goto L20
    L5:
        if (ECSettingKeys.H0() == false) goto L9;
        if (com.bytedance.android.shopping.anchorv4.experiment.h.a() == true) goto L12;
    L9:
        if (com.bytedance.android.ec.core.abtest.d.a() == true) goto L12;
        r101 = false;
        goto L13
    }

    public static boolean a() {
        cl.d r100 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r100 == null) goto L5;
        r100.q();
    L5:
        BtmHostDependManager.F.c();
        return com.bytedance.android.ec.core.abtest.d.o();
    }
}
