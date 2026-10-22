package com.bytedance.android.shopping.card_list.utils;

import android.app.Activity;
import com.bytedance.android.ec.sdk.helper.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f171922a = 0;

    static {
    }

    public static void a(Activity r100, String r101, final Function0 r102, final Function0 r110) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        Intrinsics.checkNotNullParameter("card_list_router", "enterMethod");
        Intrinsics.checkNotNullParameter(r102, "successCallBack");
        Intrinsics.checkNotNullParameter(r110, "errorCallBack");
        r r103 = r.f48132a;
        if (r103.isLogin() == false) goto L5;
        r102.invoke();
        return;
    L5:
        r103.d(r100, r101, "card_list_router", "", new CardListLoginUtil$checkLogin$1(r102), new CardListLoginUtil$checkLogin$2(r110));
    }
}
