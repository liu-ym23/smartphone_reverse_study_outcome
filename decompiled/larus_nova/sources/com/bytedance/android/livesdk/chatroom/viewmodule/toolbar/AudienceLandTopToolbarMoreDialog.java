package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.android.livesdk.config.m50;
import com.bytedance.android.livesdk.config.nt;
import com.bytedance.android.livesdk.widget.CustomShaderRectView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/AudienceLandTopToolbarMoreDialog;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/AbsAudienceToolbarButtonMoreDialog;", "Lcom/bytedance/android/live/matchroom/b;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceLandTopToolbarMoreDialog extends AbsAudienceToolbarButtonMoreDialog implements com.bytedance.android.live.matchroom.b {
    public final String Q;
    public CustomShaderRectView R;
    public GridLayout S;
    public GridLayout T;
    public boolean U;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b2
    public final Fragment W() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog
    public final x3 b1() {
        c0 r100 = y3.i(this.F);
        if (r100 == null) goto L7;
        return (x3) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog, com.bytedance.android.livesdk.widget.LiveStandardSheetDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (this.U == true) goto L5;
        MatchRoomLandScapeAnimUtil.E.j("AudienceLandTopToolbarMoreDialog");
    L9:
        this.U = false;
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(this);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r101 == null) goto L23;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L23
    L12:
        if (Looper.myLooper() == r100.getLooper()) goto L14;
        r100.post(DialogLancet.createDismissRunnable(this));
        return;
    L5:
        boolean r102 = MatchRoomLandScapeAnimUtil.f82832a;
        Intrinsics.checkNotNullParameter("AudienceLandTopToolbarMoreDialog", "key");
        if (MatchRoomLandScapeAnimUtil.f82833b.get("AudienceLandTopToolbarMoreDialog") == null) goto L8;
        MatchRoomLandScapeAnimUtil.f82833b.remove("AudienceLandTopToolbarMoreDialog");
    L8:
        ALogger.i("MatchRoomAnimUtil", "---- releaseDialogWithKey: remove [AudienceLandTopToolbarMoreDialog], now size:" + MatchRoomLandScapeAnimUtil.f82833b.size() + " ---- ");
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog
    public final void g1() {
        if (this.S != null) goto L5;
    L35:
        Iterator<Pair<ViewGroup, Integer>> r100 = this.G.iterator();
    L36:
        int r101 = 8;
        if (r100.hasNext() == false) goto L42;
        Pair<ViewGroup, Integer> r102 = r100.next();
        ViewGroup r103 = r102.getFirst();
        if (r102.getFirst().getChildCount() <= 0) goto L41;
        r101 = 0;
    L41:
        UIUtils.setViewVisibility(r103, r101);
        goto L36
    L42:
        CustomShaderRectView r104 = this.R;
        if (r104 == null) goto L45;
        r104.post(new g(this));
    L45:
        CustomShaderRectView r105 = this.R;
        GridLayout r106 = this.T;
        if (r106 == null) goto L48;
        r101 = r106.getVisibility();
    L48:
        UIUtils.setViewVisibility(r105, r101);
        return;
    L5:
        if (j1() == true) goto L35;
        GridLayout r107 = this.S;
        ViewGroup.LayoutParams r108 = null;
        if (r107 == null) goto L10;
        ViewGroup.LayoutParams r109 = r107.getLayoutParams();
    L12:
        if ((r109 instanceof ViewGroup.MarginLayoutParams) == false) goto L21;
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r109;
        int r111 = Z0();
        if (r111 == 1) goto L17;
        if (r111 == 2) goto L17;
        r110.rightMargin = UtilityKotlinExtentionsKt.i(20);
    L18:
        GridLayout r112 = this.S;
        if (r112 == null) goto L29;
        r112.setLayoutParams(r109);
    L29:
        GridLayout r113 = this.T;
        if (r113 == null) goto L35;
        GridLayout r114 = this.S;
        if (r114 == null) goto L34;
        r108 = r114.getLayoutParams();
    L34:
        r113.setLayoutParams(r108);
    L17:
        r110.rightMargin = UtilityKotlinExtentionsKt.i(45);
        goto L18
    L21:
        ViewGroup.MarginLayoutParams r115 = new ViewGroup.MarginLayoutParams(r109);
        int r116 = Z0();
        if (r116 == 1) goto L25;
        if (r116 == 2) goto L25;
        r115.rightMargin = UtilityKotlinExtentionsKt.i(20);
    L26:
        GridLayout r117 = this.S;
        if (r117 == null) goto L29;
        r117.setLayoutParams(r115);
    L25:
        r115.rightMargin = UtilityKotlinExtentionsKt.i(45);
        goto L26
    L10:
        r109 = null;
        goto L12
    }

    @Override // com.bytedance.android.live.matchroom.b
    public final int getActualContentWidth() {
        return UtilityKotlinExtentionsKt.i(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
    }

    public final boolean j1() {
        Room r100 = null;
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r101 == null) goto L8;
        com.bytedance.live.datacontext.m<Room> r102 = r101.getRoom();
        if (r102 == null) goto L8;
        r100 = r102.getValue();
    L8:
        if (r100 != null) goto L10;
    L13:
        m50 r103 = m50.f120732a;
        if (r103.getValue().n() == true) goto L16;
    L18:
        return false;
    L16:
        if (r103.getValue().l() == false) goto L18;
        return true;
    L10:
        if (r100.isMergeVSRoom() != true) goto L13;
        return nt.f120858a.getValue().booleanValue();
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final int getLayoutId() {
        if (j1() == false) goto L6;
        return R.layout.ttlive_dialog_new_landscape_more_player_scale;
    L6:
        return R.layout.ttlive_dialog_new_landscape_more;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog
    public final void h1() {
        View r100 = findViewById(R.id.container);
        if (r100 == null) goto L11;
        int r101 = Z0();
        if (r101 == 1) goto L9;
        if (r101 == 2) goto L8;
        int r102 = R.drawable.ttlive_bg_more_many_icon_dialog_gradient;
    L10:
        r100.setBackgroundResource(r102);
        com.bytedance.android.live.core.utils.a1.k(r100, Math.min(com.bytedance.android.live.core.utils.s1.w(), com.bytedance.android.live.core.utils.s1.y()));
        r100.setOnClickListener(new h(this));
        goto L11
    L8:
        r102 = R.drawable.ttlive_bg_more_two_icon_dialog_gradient;
        goto L10
    L9:
        r102 = R.drawable.ttlive_bg_more_single_icon_dialog_gradient;
    L11:
        Window r103 = getWindow();
        if (r103 == null) goto L18;
        r103.setDimAmount(0.0f);
        if (j1() == false) goto L16;
        r103.setLayout(UtilityKotlinExtentionsKt.i(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS), -1);
    L17:
        r103.setGravity(VideoPlayDataContext.PLAYING_GRAVITY);
        goto L18
    L16:
        r103.setLayout(-2, -1);
    L18:
        TextView r104 = (TextView) findViewById(R.id.more_dialog_title);
        if (r104 == null) goto L21;
        UtilityKotlinExtentionsKt.t(r104);
    L21:
        this.R = (CustomShaderRectView) findViewById(R.id.divider);
        GridLayout r105 = (GridLayout) findViewById(R.id.temp_area_button_list);
        GridLayout r106 = null;
        if (r105 == null) goto L24;
        this.G.add(TuplesKt.to(r105, 1));
        Unit r107 = Unit.INSTANCE;
    L25:
        this.T = r105;
        GridLayout r108 = (GridLayout) findViewById(R.id.stable_area_button_list);
        if (r108 == null) goto L28;
        this.G.add(TuplesKt.to(r108, 2));
        r108.setPadding(r108.getPaddingLeft(), com.bytedance.android.live.core.utils.s1.f(26.0f), r108.getPaddingRight(), r108.getPaddingBottom());
        Unit r109 = Unit.INSTANCE;
        r106 = r108;
    L28:
        this.S = r106;
        return;
    L24:
        r105 = null;
        goto L25
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog, com.bytedance.android.livesdk.widget.LiveStandardSheetDialog, android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        DataCenter r100 = this.F;
        if (r100 == null) goto L14;
        r100.put("data_predictor_more_entrance_shwo", Boolean.TRUE);
        return;
    L14:
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public AudienceLandTopToolbarMoreDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, true, false);
        this.Q = "AudienceLandTopToolbarMoreDialog";
    }

    @Override // com.bytedance.android.livesdk.widget.LiveStandardSheetDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog
    public final void M0(View r100) {
        DataCenter r101 = this.F;
        if (r101 != null) goto L5;
    L8:
        DataCenter r102 = this.F;
        if (r102 != null) goto L11;
    L15:
        super.M0(r100);
        return;
    L11:
        if (com.bytedance.android.live.core.utils.z.l(r102) == true) goto L15;
        if (m50.f120732a.getValue().k() == false) goto L15;
    L14:
        boolean r103 = MatchRoomLandScapeAnimUtil.f82832a;
        MatchRoomLandScapeAnimUtil.x(this.Q, this, -1);
        goto L15
    L5:
        if (com.bytedance.android.live.core.utils.z.l(r101) != true) goto L8;
        if (nt.f120858a.getValue().booleanValue() == true) goto L14;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog, android.view.View.OnClickListener
    public final void onClick(View r100) {
        ExtendedToolbarButton r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getTag();
    L7:
        if ((r102 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) == true) goto L9;
        r102 = null;
    L9:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r103 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r102;
        if (r103 == null) goto L12;
        r101 = r103.f115921m;
    L12:
        if (r101 != null) goto L14;
    L18:
        super.onClick(r100);
        return;
    L14:
        if (Intrinsics.areEqual(r101.f(), ToolbarButton.PREDICTOR_GUESS.name()) == false) goto L18;
        if (j1() == false) goto L18;
        this.U = true;
        goto L18
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog
    public final void X0(ExtendedToolbarButton r100, c0.b r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "behavior");
        b4.c.f115769a.b(r100.f());
        y3.i(this.F).b(ToolbarButton.MORE, new pp1.j(false));
        if ((r101 instanceof com.bytedance.android.livesdk.room.placeholder.behavior.p) == true) goto L21;
        Handler r102 = DialogLancet.resolveDialogHandler(this);
        if (r102 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(this);
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r103 == null) goto L18;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L7:
        if (Looper.myLooper() == r102.getLooper()) goto L9;
        r102.post(DialogLancet.createDismissRunnable(this));
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s
    public final View x(ViewGroup r100, float r101, com.bytedance.android.livesdk.chatroom.e r102) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_landscape_more_action_item, r100, false);
        com.bytedance.android.live.core.utils.a1.m(r103, UtilityKotlinExtentionsKt.i(10));
        return r103;
    }
}
