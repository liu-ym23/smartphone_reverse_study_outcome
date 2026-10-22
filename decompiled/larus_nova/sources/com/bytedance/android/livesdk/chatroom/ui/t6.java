package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.m50;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class t6 extends Dialog implements com.bytedance.android.live.matchroom.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f114179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f114180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f114181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout f114182d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f114183e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f114184f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f114185g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f114186h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f114187i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f114188j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f114189k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f114190l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function1<Integer, Unit> f114191m;

    public static final class a {
    }

    static {
    }

    public final void b() {
        LinearLayout r100 = this.f114181c;
        Intrinsics.checkNotNull(r100);
        r100.setBackgroundResource(0);
        ImageView r101 = this.f114184f;
        Intrinsics.checkNotNull(r101);
        r101.setBackgroundResource(0);
        TextView r102 = this.f114188j;
        Intrinsics.checkNotNull(r102);
        r102.setTextColor(getContext().getResources().getColor(R.color.ttlive_color_90_opacity_FFFFFF));
    }

    public final void c() {
        LinearLayout r100 = this.f114183e;
        Intrinsics.checkNotNull(r100);
        r100.setBackgroundResource(0);
        ImageView r101 = this.f114186h;
        Intrinsics.checkNotNull(r101);
        r101.setBackgroundResource(0);
        TextView r102 = this.f114190l;
        Intrinsics.checkNotNull(r102);
        r102.setTextColor(getContext().getResources().getColor(R.color.ttlive_color_90_opacity_FFFFFF));
    }

    public final void d() {
        LinearLayout r100 = this.f114182d;
        Intrinsics.checkNotNull(r100);
        r100.setBackgroundResource(0);
        ImageView r101 = this.f114185g;
        Intrinsics.checkNotNull(r101);
        r101.setBackgroundResource(0);
        TextView r102 = this.f114189k;
        Intrinsics.checkNotNull(r102);
        r102.setTextColor(getContext().getResources().getColor(R.color.ttlive_color_90_opacity_FFFFFF));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        m50 r100 = m50.f120732a;
        if (r100.getValue().n() == true) goto L5;
    L9:
        this.f114187i = false;
        boolean r101 = MatchRoomLandScapeAnimUtil.f82832a;
        MatchRoomLandScapeAnimUtil.q("LandscapePicTypeSettingDialog");
        MatchRoomLandScapeAnimUtil.u(0);
        Handler r102 = DialogLancet.resolveDialogHandler(this);
        if (r102 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(this);
        return;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r103 == null) goto L23;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L12:
        if (Looper.myLooper() == r102.getLooper()) goto L14;
        r102.post(DialogLancet.createDismissRunnable(this));
        return;
    L5:
        if (this.f114187i == true) goto L9;
        if (r100.getValue().m() == false) goto L9;
        MatchRoomLandScapeAnimUtil.E.j("LandscapePicTypeSettingDialog");
        goto L9
    }

    @Override // com.bytedance.android.live.matchroom.b
    public final int getActualContentWidth() {
        return UtilityKotlinExtentionsKt.i(252);
    }

    @Override // android.app.Dialog
    public final void show() {
        m50 r100 = m50.f120732a;
        if (r100.getValue().j() == false) goto L13;
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L24;
        DialogLancet.handleBlockedDialogShow(this);
    L10:
        if (m50.f120732a.getValue().n() == false) goto L20;
        boolean r101 = MatchRoomLandScapeAnimUtil.f82832a;
        MatchRoomLandScapeAnimUtil.x("LandscapePicTypeSettingDialog", this, -1);
    L20:
        LinearLayout r102 = this.f114181c;
        Intrinsics.checkNotNull(r102);
        r102.setOnClickListener(new u6(this));
        LinearLayout r103 = this.f114182d;
        Intrinsics.checkNotNull(r103);
        r103.setOnClickListener(new v6(this));
        LinearLayout r104 = this.f114183e;
        Intrinsics.checkNotNull(r104);
        r104.setOnClickListener(new w6(this));
        return;
    L24:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22
    L8:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L10
    L13:
        if (r100.getValue().n() == false) goto L16;
        boolean r105 = MatchRoomLandScapeAnimUtil.f82832a;
        MatchRoomLandScapeAnimUtil.x("LandscapePicTypeSettingDialog", this, -1);
    L16:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L26;
        DialogLancet.handleBlockedDialogShow(this);
        goto L20
    L26:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L19:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L20
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        requestWindowFeature(1);
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_layout_pic_type_setting_dialog, null);
        this.f114179a = r101;
        if (Build.VERSION.SDK_INT <= 23) goto L5;
        Intrinsics.checkNotNull(r101);
        r101.setBackgroundResource(R.drawable.ttlive_pic_type_setting_bg);
    L6:
        View r102 = this.f114179a;
        Intrinsics.checkNotNull(r102);
        setContentView(r102);
        int r103 = this.f114180b;
        Window r104 = getWindow();
        if (r104 == null) goto L14;
        r104.setBackgroundDrawable(new ColorDrawable(0));
        View r105 = r104.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L13;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r106 = ThreadMethodProxy.currentThread();
        if (r106 == com.larus.home.impl.utils.c.f346341a) goto L13;
        com.larus.home.impl.utils.c.a(r106, "getDecorView");
    L13:
        com.bytedance.android.live.core.utils.statusbar.a.C1098a r107 = com.bytedance.android.live.core.utils.statusbar.a.f66401b;
        r107.a();
        r107.a();
        r105.setSystemUiVisibility(1280);
        r107.a();
        r104.addFlags(Integer.MIN_VALUE);
        r104.setLayout((int) UIUtils.dip2Px(getContext(), r103), -1);
        r104.setGravity(GravityCompat.END);
    L14:
        com.bytedance.android.livesdk.x8.b(this);
        View r108 = this.f114179a;
        Intrinsics.checkNotNull(r108);
        this.f114181c = (LinearLayout) r108.findViewById(R.id.ll_auto);
        View r109 = this.f114179a;
        Intrinsics.checkNotNull(r109);
        this.f114182d = (LinearLayout) r109.findViewById(R.id.ll_stretch);
        View r110 = this.f114179a;
        Intrinsics.checkNotNull(r110);
        this.f114183e = (LinearLayout) r110.findViewById(R.id.ll_enlarge);
        View r111 = this.f114179a;
        Intrinsics.checkNotNull(r111);
        this.f114184f = (ImageView) r111.findViewById(R.id.iv_auto_indicator);
        View r112 = this.f114179a;
        Intrinsics.checkNotNull(r112);
        this.f114185g = (ImageView) r112.findViewById(R.id.iv_stretch_indicator);
        View r113 = this.f114179a;
        Intrinsics.checkNotNull(r113);
        this.f114186h = (ImageView) r113.findViewById(R.id.iv_enlarge_indicator);
        View r114 = this.f114179a;
        Intrinsics.checkNotNull(r114);
        this.f114188j = (TextView) r114.findViewById(R.id.tv_auto_text);
        View r115 = this.f114179a;
        Intrinsics.checkNotNull(r115);
        this.f114189k = (TextView) r115.findViewById(R.id.tv_stretch_text);
        View r116 = this.f114179a;
        Intrinsics.checkNotNull(r116);
        this.f114190l = (TextView) r116.findViewById(R.id.tv_enlarge_text);
        int r117 = x6.f114300a;
        a(x6.f114300a, false);
        return;
    L5:
        Intrinsics.checkNotNull(r101);
        r101.setBackgroundResource(R.drawable.ttlive_bg_more_many_icon_dialog_gradient);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t6(Context r100, Function1<? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onClick);
        super(r100, R.style.ttlive_barrage_setting_dialog);
        this.f114191m = r101;
        this.f114180b = 200;
    }

    public final void a(int r100, boolean r101) {
        if (r101 == false) goto L39;
        this.f114191m.invoke(Integer.valueOf(r100));
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 == null) goto L10;
        com.bytedance.live.datacontext.m<Boolean> r103 = r102.isRestoreSandwich();
        if (r103 == null) goto L10;
        r103.setValue(Boolean.TRUE);
    L10:
        if (r100 == x6.f114300a) goto L12;
    L16:
        ALogger.d("SandwichBorderInfo", "LandscapePicTypeSettingManager setCurrentPicType " + r100 + " , lastPicType  " + x6.f114300a);
        xs2.b.a().post(new do1.a(x6.f114300a, r100, x6.f() ? 1 : 0));
        x6.f114300a = r100;
        if (r100 == 0) goto L20;
        x6.f114302c = false;
    L20:
        if (m50.f120732a.getValue().m() == false) goto L39;
        this.f114187i = true;
        Handler r104 = DialogLancet.resolveDialogHandler(this);
        if (r104 != null) goto L24;
    L26:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L29 Exception -> L31
    L35:
        DialogLancet.afterDialogDismiss(this);
        goto L39
    L31:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L29
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L29
        if (r105 == null) goto L35;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L24:
        if (Looper.myLooper() == r104.getLooper()) goto L26;
        r104.post(DialogLancet.createDismissRunnable(this));
        goto L39
    L12:
        if (x6.f114304e == true) goto L16;
        if (MatchRoomLandScapeAnimUtil.f82832a == true) goto L16;
        ALogger.d("SandwichBorderInfo", "LandscapePicTypeSettingManager setCurrentPicType " + r100 + " not need reset");
    L39:
        if (r100 == 0) goto L46;
        if (r100 != 1) goto L42;
        LinearLayout r106 = this.f114182d;
        Intrinsics.checkNotNull(r106);
        r106.setBackgroundResource(R.drawable.ttlive_bg_black_radius100);
        ImageView r107 = this.f114185g;
        Intrinsics.checkNotNull(r107);
        r107.setBackgroundResource(R.drawable.ttlive_ic_yellow_point);
        TextView r108 = this.f114189k;
        Intrinsics.checkNotNull(r108);
        r108.setTextColor(getContext().getResources().getColor(R.color.ttlive_color_FECB00));
        b();
        c();
        return;
    L42:
        if (r100 != 2) goto L53;
        LinearLayout r109 = this.f114183e;
        Intrinsics.checkNotNull(r109);
        r109.setBackgroundResource(R.drawable.ttlive_bg_black_radius100);
        ImageView r110 = this.f114186h;
        Intrinsics.checkNotNull(r110);
        r110.setBackgroundResource(R.drawable.ttlive_ic_yellow_point);
        TextView r111 = this.f114190l;
        Intrinsics.checkNotNull(r111);
        r111.setTextColor(getContext().getResources().getColor(R.color.ttlive_color_FECB00));
        b();
        d();
        return;
    L53:
        return;
    L46:
        LinearLayout r112 = this.f114181c;
        Intrinsics.checkNotNull(r112);
        r112.setBackgroundResource(R.drawable.ttlive_bg_black_radius100);
        ImageView r113 = this.f114184f;
        Intrinsics.checkNotNull(r113);
        r113.setBackgroundResource(R.drawable.ttlive_ic_yellow_point);
        TextView r114 = this.f114188j;
        Intrinsics.checkNotNull(r114);
        r114.setTextColor(getContext().getResources().getColor(R.color.ttlive_color_FECB00));
        c();
        d();
    }
}
