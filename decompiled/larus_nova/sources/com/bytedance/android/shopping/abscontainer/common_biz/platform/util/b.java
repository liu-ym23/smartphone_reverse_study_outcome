package com.bytedance.android.shopping.abscontainer.common_biz.platform.util;

import android.app.Activity;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.shopping.utils.p;
import com.bytedance.android.shopping.yata.business.function.common.TTPay;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.tencent.open.SocialConstants;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import l33.c;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f164354a = null;

    public b() {
    }

    static {
        f164354a = new b();
    }

    public static void b() {
        ECSettingKeys.f43625j.getClass();
        if (((Boolean) ECSettingKeys.f43624i.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        int r100 = p.f187156a;
    }

    public static void c() {
        Intrinsics.checkNotNullParameter(PriorityModule.SCENE_EC, "scene");
        Intrinsics.checkNotNullParameter("enter_buy_now", "triggerAction");
        p.a();
    }

    public static void d(c r100, Map r101, Function2 r102) {
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        int r103 = TTPay.f187579a;
        if (r100 == null) goto L5;
        Activity r104 = r100.getContainerContext();
    L6:
        TTPay.a(r104, k.b(r101), r102);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final void a(String r100, String r101, long r110) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
        TTCJPayUtils.Companion.getInstance().externalBizReport(r100, "ecommerce_pay_desk", r110, "", null);
    }
}
