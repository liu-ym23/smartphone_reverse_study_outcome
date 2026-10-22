package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.SwitchResolutionDialogConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class y6 extends Dialog implements com.bytedance.android.live.matchroom.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LandscapeVideoQualityAdapter f114315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f114316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f114317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SwitchResolutionDialogConfig f114318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f114319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Room f114320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DataCenter f114321g;

    public static final class a {
    }

    static {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        MatchRoomLandScapeAnimUtil.E.j("LandscapeSwitchVideoQualityDialog");
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, this.f114321g, 0, 2);
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.m<Boolean> r101 = r100.getLandscapeVideoQualityDialogShow();
        if (r101 == null) goto L7;
        r101.setValue(Boolean.FALSE);
    L7:
        Handler r102 = DialogLancet.resolveDialogHandler(this);
        if (r102 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(this);
    L22:
        com.bytedance.android.livesdk.f.d().f();
        return;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r103 == null) goto L21;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L10:
        if (Looper.myLooper() == r102.getLooper()) goto L12;
        r102.post(DialogLancet.createDismissRunnable(this));
        goto L22
    }

    @Override // com.bytedance.android.live.matchroom.b
    public final int getActualContentWidth() {
        return (int) UtilityKotlinExtentionsKt.h(this.f114316b);
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        com.bytedance.android.livesdk.f.d().a();
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, this.f114321g, 0, 2);
        if (r100 == null) goto L12;
        com.bytedance.live.datacontext.m<Boolean> r101 = r100.getLandscapeVideoQualityDialogShow();
        if (r101 == null) goto L12;
        r101.setValue(Boolean.TRUE);
    L12:
        boolean r102 = MatchRoomLandScapeAnimUtil.f82832a;
        MatchRoomLandScapeAnimUtil.x("LandscapeSwitchVideoQualityDialog", this, -1);
        int r103 = AudienceVideoResolutionManager.f110411a;
        AudienceVideoResolutionManager.r(AudienceVideoResolutionManager.f110413c, "dialog_show");
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        View r101 = LayoutInflater.from(getContext()).inflate(this.f114319e, null);
        setContentView(r101);
        Window r102 = getWindow();
        if (r102 == null) goto L8;
        r102.setDimAmount(0.0f);
        r102.setLayout((int) UIUtils.dip2Px(r102.getContext(), this.f114317c), -1);
        r102.setGravity(GravityCompat.END);
        if (PadConfigUtils.c() == true) goto L8;
        com.bytedance.android.livesdk.t8.d(r102);
    L8:
        if (MatchRoomLandScapeAnimUtil.f82832a == false) goto L10;
        r101.setBackgroundResource(0);
    L11:
        Context r103 = getContext();
        Room r104 = this.f114320f;
        DataCenter r105 = this.f114321g;
        LiveCoreSDKData.Quality r106 = AudienceVideoResolutionManager.c();
        if (r106 == null) goto L14;
        r106.getName();
    L14:
        this.f114315a = new LandscapeVideoQualityAdapter(r103, r104, r105, new LandscapeSwitchVideoQualityDialog$initView$1(this), new LandscapeSwitchVideoQualityDialog$initView$2(this));
        View r107 = findViewById(R.id.quality_empty_view);
        r107.setVisibility(0);
        com.bytedance.android.livesdk.r3.c(r107, "关闭", true);
        r107.setOnClickListener(new z6(this));
        ((RecyclerView) findViewById(R.id.rv_quality)).setBackground(com.bytedance.android.live.core.utils.s1.m(R.drawable.ttlive_bg_more_many_icon_dialog_gradient));
        RecyclerView r108 = (RecyclerView) findViewById(R.id.rv_quality);
        LandscapeVideoQualityAdapter r109 = this.f114315a;
        if (r109 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L17:
        r108.setAdapter(r109);
        ((RecyclerView) findViewById(R.id.rv_quality)).setLayoutManager(new LinearLayoutManager(getContext()));
        ((RecyclerView) findViewById(R.id.rv_quality)).addItemDecoration(new LandscapeSwitchVideoQualityDialog$initView$4(this));
        if (this.f114318d.landscapeDialogUseNewStyle() == true) goto L26;
        LandscapeVideoQualityAdapter r110 = this.f114315a;
        if (r110 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L23:
        if (r110.getItemCount() <= 5) goto L27;
        UIUtils.updateLayoutMargin(findViewById(R.id.rv_quality), -3, (int) UtilityKotlinExtentionsKt.h(20.0f), -3, (int) UtilityKotlinExtentionsKt.h(20.0f));
        return;
    L27:
        return;
    L26:
        return;
    L10:
        r101.setBackgroundResource(R.drawable.ttlive_bg_video_quality_new);
        goto L11
    }

    public y6(Context r100, Room r101, DataCenter r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "room");
        super(r100, R.style.ttlive_CommonRightDialog);
        this.f114320f = r101;
        this.f114321g = r102;
        if (r102 == null) goto L7;
        Boolean r103 = (Boolean) r102.get("data_is_portrait", Boolean.TRUE);
        if (r103 == null) goto L7;
        r103.booleanValue();
    L7:
        this.f114316b = 244.0f;
        this.f114317c = 600.0f;
        SwitchResolutionDialogConfig r104 = com.bytedance.android.livesdk.f3.f123401a.getValue();
        this.f114318d = r104;
        if (r104.landscapeDialogUseNewStyle() == false) goto L10;
        int r105 = R.layout.ttlive_dialog_switch_video_quality_new_position;
    L11:
        this.f114319e = r105;
        return;
    L10:
        r105 = R.layout.ttlive_dialog_switch_video_quality_new;
        goto L11
    }
}
