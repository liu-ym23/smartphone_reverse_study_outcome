package com.bytedance.applet.impl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.service.AppletPayType;
import com.bytedance.ai.bridge.service.IHostPaymentDepend;
import com.bytedance.ai.bridge.service.OnPayOrderResultCallback;
import com.bytedance.router.SmartRouter;
import com.larus.login.api.CommonDouYinLoginKV;
import com.larus.login.api.CommonDouYinLoginUtil;
import com.larus.login.api.DouYinBindStatus;
import com.larus.login.api.TouristManager;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class g0 implements IHostPaymentDepend {

    public static final class a {
    }

    public static final class b extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f191936a;

        public b(Context r100) {
            this.f191936a = r100;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            com.bytedance.router.i r101 = SmartRouter.buildRoute(this.f191936a, "//flow/webview");
            Bundle r102 = new Bundle();
            Lazy r103 = com.larus.platform.service.l0.f365759a;
            IFlowSdkDepend r104 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r104 == null) goto L5;
            r104.M();
            String r105 = "https://lf9-cdn-tos.draftstatic.com/obj/ies-hotsoon-draft/grace_legal/Shopping-Payment-FAQ.html";
        L6:
            if (r105 != null) goto L8;
            r105 = "";
        L8:
            r102.putString("link_url", r105);
            r101.f267554c.putExtras(r102);
            r101.d();
            return;
        L5:
            r105 = null;
            goto L6
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "ds");
            r100.setUnderlineText(false);
            Context r101 = this.f191936a;
            r100.setColor(ContextCompat.getColor(r101, v19.c.b(R.attr.larus_neutral_100, r101, R.color.larus_neutral_100)));
        }
    }

    public static final class c implements com.larus.login.api.b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f191937a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super Boolean, Unit> r100) {
            this.f191937a = r100;
        }

        @Override // com.larus.login.api.b0
        public final void a(DouYinBindStatus r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "status");
            if (r100 != DouYinBindStatus.ALREADY_BOUND) goto L5;
        L8:
            this.f191937a.invoke(Boolean.TRUE);
            return;
        L5:
            if (r100 == DouYinBindStatus.SUCCESS) goto L8;
            this.f191937a.invoke(Boolean.FALSE);
        }
    }

    static {
    }

    public g0() {
    }

    public static SpannableStringBuilder a(Context r100, String r101) {
        String r102 = ContextCompat.getString(r100, R.string.larus_learn_more);
        SpannableString r103 = new SpannableString(r102);
        r103.setSpan(new b(r100), 0, r102.length(), 33);
        r103.setSpan(new StyleSpan(1), 0, r102.length(), 33);
        SpannableStringBuilder r104 = new SpannableStringBuilder();
        r104.append(r101);
        r104.append(r103);
        return r104;
    }

    @Override // com.bytedance.ai.bridge.service.IHostPaymentDepend
    public final void openDyPay(final FragmentActivity r100, final String r101, final OnPayOrderResultCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "callback");
        new Handler(Looper.getMainLooper()).post(new c0(r100, r101, r102));
    }

    @Override // com.bytedance.ai.bridge.service.IHostPaymentDepend
    public final void preparePaymentAuthorization(FragmentActivity r210, Bundle r211, Map<String, ? extends Object> r212, Function1<? super Boolean, Unit> r213) {
        Intrinsics.checkNotNullParameter(r210, "activity");
        Intrinsics.checkNotNullParameter(r212, "traceInfo");
        Intrinsics.checkNotNullParameter(r213, "callback");
        if (TouristManager.f357001a.f() == false) goto L6;
        r213.invoke(Boolean.FALSE);
        return;
    L6:
        Lazy r100 = CommonDouYinLoginKV.f356938a;
        if (CommonDouYinLoginKV.b() == true) goto L9;
        com.larus.login.api.i r101 = new com.larus.login.api.i(Integer.valueOf(R.drawable.larus_binder_doubao), Integer.valueOf(R.drawable.larus_binder_douyin), ContextCompat.getString(r210, R.string.larus_settings_bottomsheet_title_buy_cn), a(r210, ContextCompat.getString(r210, R.string.larus_settings_bottomsheet_desc_buy_cn)), ContextCompat.getString(r210, R.string.larus_settings_bottomsheet_btn_confirm_cn), null, false, null, null, false, 32672);
    L10:
        com.larus.login.api.i r110 = r101;
        com.larus.login.api.i r214 = new com.larus.login.api.i(Integer.valueOf(R.drawable.larus_binder_douyin), null, ContextCompat.getString(r210, R.string.larus_settings_bottomsheet_title_douyin_account_cn), a(r210, ContextCompat.getString(r210, R.string.larus_settings_bottomsheet_desc_douyin_account_cn)), ContextCompat.getString(r210, R.string.larus_settings_bottomsheet_btn_link_douyin_cn), ContextCompat.getString(r210, R.string.larus_settings_bottomsheet_btn_later_cn), false, null, null, false, 32706);
        CommonDouYinLoginUtil r215 = CommonDouYinLoginUtil.f356945a;
        if (r212.containsKey("widgetId") == false) goto L13;
        String r102 = "chat";
    L14:
        c r103 = new c(r213);
        if (r211 != null) goto L17;
        Bundle r104 = new Bundle();
    L18:
        com.larus.login.api.k0 r216 = new com.larus.login.api.k0(r210, r102, "doubao_apps_pay", null, false, false, r103, r212, r104, r110, r214, 500, new com.larus.login.api.d(false, 3), null, null, null, null, 122888);
        r215.getClass();
        CommonDouYinLoginUtil.s(r216);
        return;
    L17:
        r104 = r211;
        goto L18
    L13:
        r102 = "doubao_apps_detail";
        goto L14
    L9:
        r101 = null;
        goto L10
    }

    @Override // com.bytedance.ai.bridge.service.IHostPaymentDepend
    public final void createPayOrder(final FragmentActivity r110, final String r210, final AppletPayType r211, Map<String, ? extends Object> r212, final OnPayOrderResultCallback r213) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r210, "data");
        Intrinsics.checkNotNullParameter(r211, "type");
        Intrinsics.checkNotNullParameter(r212, "traceInfo");
        Intrinsics.checkNotNullParameter(r213, "callback");
        Lazy r100 = CommonDouYinLoginKV.f356938a;
        if (CommonDouYinLoginKV.b() == true) goto L5;
        com.larus.login.api.i r101 = new com.larus.login.api.i(Integer.valueOf(R.drawable.larus_binder_doubao), Integer.valueOf(R.drawable.larus_binder_douyin), ContextCompat.getString(r110, R.string.larus_settings_bottomsheet_title_buy_cn), a(r110, ContextCompat.getString(r110, R.string.larus_settings_bottomsheet_desc_buy_cn)), ContextCompat.getString(r110, R.string.larus_settings_bottomsheet_btn_confirm_cn), null, false, null, null, false, 32672);
    L6:
        final com.larus.login.api.i r102 = r101;
        new Handler(Looper.getMainLooper()).post(new d0(r102, r213, r110, r210, r211));
        return;
    L5:
        r101 = null;
        goto L6
    }
}
