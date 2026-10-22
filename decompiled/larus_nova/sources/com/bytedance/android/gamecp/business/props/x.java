package com.bytedance.android.gamecp.business.props;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.gamecp.business.GamePromoteTrack;
import com.bytedance.android.gamecp.business.p0;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.android.gamecp.host_api.GameCpTargetUtils;
import com.bytedance.android.livesdkapi.depend.log.LogFilterName;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class x extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f56400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f56401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p0<String> f56402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f56403d;

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        com.bytedance.android.gamecp.common.ui.f.a().b();
        com.bytedance.android.gamecp.common.utils.m r101 = com.bytedance.android.gamecp.common.utils.m.a();
        r101.getClass();
        com.bytedance.android.gamecp.common.utils.m.f57238c--;
        if (com.bytedance.android.gamecp.common.utils.m.f57238c >= 0) goto L21;
        com.bytedance.android.gamecp.common.utils.m.f57238c = 0;
    L21:
        if (com.bytedance.android.gamecp.common.utils.m.f57238c != 0) goto L23;
        r101.b();
    L23:
        c r102 = this.f56403d;
        if (r102 == null) goto L26;
        r102.a(this.f56400a);
    L26:
        HashMap<String, String> r103 = GamecpTracker.f56755a;
        GamecpTracker.o(this);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r104 == null) goto L16;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        Window r100 = getWindow();
        if (r100 == null) goto L5;
        r100.setGravity(17);
    L5:
        setContentView(R.layout.gamecp_dialog_game_promote_prop_usage);
        if (GameCpTargetUtils.f() == false) goto L8;
        String r101 = y0.i(R.string.ttlive_game_promote_prop_usage_huoshan);
    L9:
        SpannableStringBuilder r102 = new SpannableStringBuilder(r101);
        r102.setSpan(new com.bytedance.android.gamecp.common.ui.e(ColorProtector.parseColor("#04498D"), new PropUsageDialog$initView$$inlined$apply$lambda$1(this)), 6, 14, 33);
        r102.setSpan(new com.bytedance.android.gamecp.common.ui.e(ColorProtector.parseColor("#04498D"), new PropUsageDialog$initView$$inlined$apply$lambda$2(this)), 15, 23, 33);
        ((TextView) findViewById(R.id.tv_content)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView) findViewById(R.id.tv_content)).setText(r102);
        ((ImageView) findViewById(R.id.iv_close)).setOnClickListener(new v(this));
        ((TextView) findViewById(R.id.tv_agree)).setOnClickListener(new w(this));
        int r103 = GamePromoteTrack.f51759a;
        Map r104 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("game_id", (String) this.f56401b.get("game_id")), TuplesKt.to(EventConstants.ExtraJson.GAME_NAME, (String) this.f56401b.get(EventConstants.ExtraJson.GAME_NAME)), TuplesKt.to("prop_id", (String) this.f56401b.get("prop_id")), TuplesKt.to("prop_name", (String) this.f56401b.get("prop_name"))});
        int r105 = com.bytedance.android.gamecp.common.track.b.f56775a;
        com.bytedance.android.gamecp.common.track.b.g("livesdk_gcome_user_purchase_confirm_show", r104, new String[]{LogFilterName.ROOM, LogFilterName.PAGE_SOURCE_LOG});
        Window r106 = getWindow();
        if (r106 == null) goto L18;
        View r107 = r106.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L16;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r108 = ThreadMethodProxy.currentThread();
        if (r108 == com.larus.home.impl.utils.c.f346341a) goto L16;
        com.larus.home.impl.utils.c.a(r108, "getDecorView");
    L16:
        if (r107 == null) goto L18;
        HashMap<String, String> r109 = GamecpTracker.f56755a;
        GamecpTracker.x(this, r107, "prop_contract", MapsKt.emptyMap(), MapsKt.emptyMap(), true, false, 192);
    L18:
        HashMap<String, String> r110 = GamecpTracker.f56755a;
        GamecpTracker.r(findViewById(R.id.tv_agree), "prop_contract_agree", MapsKt.emptyMap(), new u(), false, 112);
        return;
    L8:
        r101 = y0.i(R.string.ttlive_game_promote_prop_usage);
        goto L9
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        com.bytedance.android.gamecp.common.ui.f r100 = com.bytedance.android.gamecp.common.ui.f.a();
        r100.getClass();
        com.bytedance.android.gamecp.common.ui.f.f56987c++;
        r100.f56988a.postValue(Boolean.TRUE);
        com.bytedance.android.gamecp.common.utils.m r101 = com.bytedance.android.gamecp.common.utils.m.a();
        r101.getClass();
        com.bytedance.android.gamecp.common.utils.m.f57238c++;
        r101.b();
        HashMap<String, String> r102 = GamecpTracker.f56755a;
        GamecpTracker.p(this);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public x(Context r100, Map r101, y.a r102, com.bytedance.android.gamecp.business.q r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        super(r100, R.style.gamecp_live_dialog);
        this.f56401b = r101;
        this.f56402c = r102;
        this.f56403d = r103;
    }
}
