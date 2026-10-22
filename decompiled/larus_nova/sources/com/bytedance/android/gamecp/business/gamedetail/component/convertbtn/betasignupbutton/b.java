package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betasignupbutton;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f54094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NewBetaApplySignUpEffect.d f54095b;

    public b(String r100, NewBetaApplySignUpEffect.d r101) {
        this.f54094a = r100;
        this.f54095b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Pair r111 = (Pair) r110;
        NewBetaApplySignUpEffect r100 = this.f54095b.f54073a;
        if (((Boolean) r111.getFirst()).booleanValue() == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        r100.f54069e = r101;
        if (Intrinsics.areEqual("native_bottom_signup_btn", this.f54094a) == false) goto L27;
        NewBetaApplySignUpEffect.d r102 = this.f54095b;
        k r103 = (k) r102.f54074b;
        if (r103.f54142l == false) goto L18;
        Map<String, String> r112 = r102.f54073a.h();
        NewBetaApplySignUpEffect.d r104 = this.f54095b;
        String r105 = ((k) r104.f54074b).f54140j;
        if (r104.f54073a.f54069e == true) goto L15;
    L17:
        int r106 = com.bytedance.android.gamecp.business.hybrid.a.f55974a;
        com.bytedance.android.gamecp.business.hybrid.a.b(((k) this.f54095b.f54074b).f54131a, r105, r112);
        return;
    L15:
        if (TextUtils.isEmpty(r105) == true) goto L17;
        r105 = UriProtector.parse(((k) this.f54095b.f54074b).f54140j).buildUpon().appendQueryParameter("show_reserved_info", String.valueOf(true)).toString();
        goto L17
    L18:
        NewBetaApplySignUpEffect r107 = r102.f54073a;
        Context r108 = r103.f54131a;
        String r109 = r103.f54140j;
        if (((Boolean) r111.getFirst()).booleanValue() == false) goto L21;
        String r113 = "1";
    L22:
        k r114 = (k) this.f54095b.f54074b;
        String r115 = r114.f54136f;
        String r116 = r114.f54138h;
        int r117 = r114.f54141k;
        Map<String, String> r118 = r107.h();
        r118.put("show_reverved_info", String.valueOf(true));
        r118.put("reserved_status", r113);
        if (r115 != null) goto L25;
        r115 = "";
    L25:
        r118.put("plan_id", r115);
        r118.put("test_plan_open_type", String.valueOf(1));
        r118.put("test_qualification_type", String.valueOf(0));
        r118.put("activation_code", "");
        r118.put("recruitment_test_result", String.valueOf(r116));
        r118.put("beta_game_stage", String.valueOf(r117));
        com.bytedance.android.gamecp.business.hybrid.a.d(r108, r109, r118);
        return;
    L21:
        r113 = "0";
        goto L22
    L27:
        return;
    L5:
        if ((!Intrinsics.areEqual((String) r111.getSecond(), "onFail_4014137")) == false) goto L7;
        r101 = true;
        goto L8
    }
}
