package com.bytedance.android.shopping.utils;

import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f187156a = 0;

    @JvmStatic
    public static final void a() {
        Intrinsics.checkNotNullParameter(PriorityModule.SCENE_EC, "scene");
        Intrinsics.checkNotNullParameter("enter_buy_now", "triggerAction");
    }

    public static String b() {
        return TTCJPayUtils.Companion.getInstance().getSDKVersion();
    }

    static {
    }
}
