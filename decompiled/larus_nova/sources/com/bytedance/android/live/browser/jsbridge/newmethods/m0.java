package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.browser.jsbridge.base.AlertResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "alert")
public final class m0 extends w20.h<w20.m7, AlertResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f63550a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onDestroy() {
        super.onDestroy();
        this.f63550a = true;
    }

    public m0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.m7 r102 = (w20.m7) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (TextUtils.isEmpty(r102.a()) == false) goto L5;
    L7:
        int r103 = 1;
    L8:
        Context r104 = r101.getContext();
        if (com.bytedance.android.live.b.f58796b.getValue().booleanValue() == true) goto L11;
    L17:
        com.bytedance.android.livesdk.chatroom.ui.c9.b r105 = new com.bytedance.android.livesdk.chatroom.ui.c9.b();
        r105.f112681a = r104;
        r105.f112682b = r103;
        r105.f112687g = 17;
        r105.f112696p = false;
        if (TextUtils.isEmpty(r102.d()) == true) goto L21;
        r105.f112685e = r102.d();
    L21:
        if (TextUtils.isEmpty(r102.c()) == true) goto L24;
        r105.f112686f = r102.c();
    L24:
        if (TextUtils.isEmpty(r102.a()) == true) goto L37;
        if (TextUtils.isEmpty(r102.b()) == true) goto L37;
        if (TextUtils.isEmpty(r102.b()) == false) goto L30;
        String r106 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_cancel);
    L31:
        i0 r107 = new i0(this);
        r105.f112690j = r106;
        r105.f112691k = r107;
        if (TextUtils.isEmpty(r102.a()) == false) goto L34;
        String r108 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_ok);
    L35:
        j0 r109 = new j0(this);
        r105.f112692l = r108;
        r105.f112693m = r109;
        r105.f112699s = R.style.ttlive_live_notice_dialog_confirm_button;
    L50:
        com.bytedance.android.livesdk.chatroom.ui.c9 r110 = new com.bytedance.android.livesdk.chatroom.ui.c9(r105.f112681a, r105);
        if (DialogLancet.shouldBlockDialogShow(r110) == false) goto L57;
        DialogLancet.handleBlockedDialogShow(r110);
        return;
    L57:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L56
    L54:
        DialogLancet.beforeDialogShow(r110);
        r110.show();
        DialogLancet.afterDialogShow(r110);
        return;
    L34:
        r108 = r102.a();
        goto L35
    L30:
        r106 = r102.b();
    L37:
        if (TextUtils.isEmpty(r102.a()) == true) goto L44;
        if (TextUtils.isEmpty(r102.a()) == false) goto L41;
        String r111 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_i_know);
    L42:
        k0 r112 = new k0(this);
        r105.f112688h = r111;
        r105.f112689i = r112;
        goto L50
    L41:
        r111 = r102.a();
        goto L42
    L44:
        if (TextUtils.isEmpty(r102.b()) == true) goto L50;
        if (TextUtils.isEmpty(r102.b()) == false) goto L48;
        String r113 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_i_know);
    L49:
        l0 r114 = new l0(this);
        r105.f112688h = r113;
        r105.f112689i = r114;
        goto L50
    L48:
        r113 = r102.b();
        goto L49
    L11:
        if ((r104 instanceof Activity) == true) goto L17;
        WeakReference<Activity> r115 = com.bytedance.android.live.core.utils.a.f66107a;
        if (r115 == null) goto L17;
        Activity r116 = r115.get();
        if (r116 == null) goto L17;
        r104 = r116;
        goto L17
    L5:
        if (TextUtils.isEmpty(r102.b()) == true) goto L7;
        r103 = 2;
        goto L8
    }
}
