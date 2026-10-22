package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f127437a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(long r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "receiverID");
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        return false;
    L12:
        return !Intrinsics.areEqual((String) ((HashMap) com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.v.f127895b.getValue(null, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.v.f127894a[0])).get(String.valueOf(r100) + r101), r102);
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
