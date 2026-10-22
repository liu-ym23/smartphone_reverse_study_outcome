package com.bytedance.android.livesdk.chatroom.tetris.vr;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerImageView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.livesdkapi.view.SurfaceRenderView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/tetris/vr/VrAudienceControlDialogLandscape;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/live/matchroom/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VrAudienceControlDialogLandscape extends LiveDialogFragment implements com.bytedance.android.live.matchroom.b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f111853o = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a f111854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DataCenter f111855e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f111856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f111857g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RoundCornerImageView f111858h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f111859i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f111860j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f111861k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f111862l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f111863m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f111864n;

    public static final class a {
    }

    static {
    }

    public final void S90() {
        RoomContext.a r100 = RoomContext.Companion;
        ViewParent r101 = null;
        RoomContext r102 = RoomContext.a.c(r100, null, 0, 3);
        if (r102 == null) goto L9;
        com.bytedance.live.datacontext.m<Room> r103 = r102.getRoom();
        if (r103 == null) goto L9;
        Room r104 = r103.getValue();
        if (r104 == null) goto L9;
        long r105 = r104.f162599id;
    L10:
        as0.a r106 = LivePlatformPlayerManager.e(r105, false);
        if (r106 == null) goto L15;
        LivePlayerView r107 = r106.getLivePlayerView();
        if (r107 == null) goto L15;
        IRenderView r108 = r107.getRenderView();
    L17:
        if ((r108 instanceof SurfaceRenderView) == true) goto L19;
        r108 = null;
    L19:
        SurfaceRenderView r109 = (SurfaceRenderView) r108;
        RoomContext r110 = RoomContext.a.c(r100, null, 0, 3);
        if (r110 == null) goto L27;
        com.bytedance.live.datacontext.m<Room> r111 = r110.getRoom();
        if (r111 == null) goto L27;
        Room r112 = r111.getValue();
        if (r112 == null) goto L27;
        if (r112.isMediaRoom() != true) goto L27;
        return;
    L27:
        if (r109 == null) goto L47;
        ViewParent r113 = r109.getParent();
        if ((r113 instanceof FrameLayout) == false) goto L32;
        r101 = r113;
    L32:
        FrameLayout r114 = (FrameLayout) r101;
        if (r114 == null) goto L48;
        float r115 = r114.getWidth();
        float r116 = r114.getHeight();
        ALogger.i("VrAudienceControlDialogLandscape", "ensureSurfaceRenderViewPosition(), parentWidth is " + r115 + ", parentHeight is " + r116);
        float r117 = (float) 2;
        float r118 = r115 / r117;
        if (Math.abs(r109.getPivotX() - r118) <= 1.0f) goto L37;
    L38:
        ALogger.i("VrAudienceControlDialogLandscape", "ensureSurfaceRenderViewPosition(), pivotX and pivotY are set to half of parent size.");
        r109.setPivotX(r118);
        r109.setPivotY(r116 / r117);
    L39:
        float r119 = 0;
        if (Math.abs(r109.getTranslationX() - r119) <= 1.0f) goto L43;
        ALogger.i("VrAudienceControlDialogLandscape", "ensureSurfaceRenderViewPosition(), translationX is set to 0.");
        r109.setTranslationX(0.0f);
    L43:
        if (Math.abs(r109.getTranslationY() - r119) <= 1.0f) goto L49;
        ALogger.i("VrAudienceControlDialogLandscape", "ensureSurfaceRenderViewPosition(), translationY is set to 0.");
        r109.setTranslationY(0.0f);
        return;
    L49:
        return;
    L37:
        if (Math.abs(r109.getPivotY() - (r116 / r117)) <= 1.0f) goto L39;
    L48:
        return;
    L47:
        return;
    L15:
        r108 = null;
    L9:
        r105 = 0;
        goto L10
    }

    public final void W90() {
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r100 = this.f111854d;
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.m<? extends Boolean> r101 = r100.isVrSensorOpen();
        if (r101 == null) goto L9;
        boolean r102 = true;
        if (r101.getValue().booleanValue() != true) goto L9;
    L10:
        V90(r102);
        return;
    L9:
        r102 = false;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment
    public final void dismiss() {
        MatchRoomLandScapeAnimUtil.E.k("VrAudienceControlDialogLandscape", true, new AnonymousClass1(this));
        super.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L12;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.live.matchroom.b
    public final int getActualContentWidth() {
        return UtilityKotlinExtentionsKt.i(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
    }

    @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        W90();
    }

    public VrAudienceControlDialogLandscape(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
    }

    public final void V90(boolean r100) {
        if (r100 == false) goto L9;
        ImageView r101 = this.f111860j;
        if (r101 == null) goto L6;
        r101.setImageResource(R.drawable.ttlive_vr_view_fixed_immersed_large);
    L6:
        TextView r102 = this.f111861k;
        if (r102 == null) goto L16;
        r102.setText("固定视角");
        return;
    L16:
        return;
    L9:
        ImageView r103 = this.f111860j;
        if (r103 == null) goto L12;
        r103.setImageResource(R.drawable.ttlive_vr_view_not_fixed_landscape);
    L12:
        TextView r104 = this.f111861k;
        if (r104 == null) goto L18;
        r104.setText("旋转视角");
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        Dialog r101 = getDialog();     // Catch: Exception -> L8
        if (r101 == null) goto L13;
        Window r102 = r101.getWindow();     // Catch: Exception -> L8
        if (r102 == null) goto L13;
        r102.setDimAmount(0.0f);     // Catch: Exception -> L8
    L13:
        super.onActivityCreated(r100);
        Dialog r103 = getDialog();
        if (r103 == null) goto L34;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L35;
        r104.setLayout(-1, -1);
        View r105 = getView();
        ViewGroup.LayoutParams r106 = null;
        if (r105 == null) goto L20;
        ViewGroup.LayoutParams r107 = r105.getLayoutParams();
    L22:
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L36;
        View r108 = getView();
        if (r108 == null) goto L26;
        r106 = r108.getLayoutParams();
    L26:
        if (r106 == null) goto L28;
        r106.height = s1.s(getActivity());
    L28:
        View r109 = getView();
        if (r109 == null) goto L37;
        r109.setLayoutParams(r106);
        return;
    L37:
        return;
    L36:
        return;
    L20:
        r107 = null;
        goto L22
    L35:
        return;
    L34:
        return;
    L8:
        e = move-exception;
        String r110 = e.getMessage();
        if (r110 != null) goto L12;
        r110 = "";
    L12:
        ALogger.e("VrAudienceControlDialogLandscape", r110);
        goto L13
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_vr_control_dialog_landscape);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r100);     // Catch: Throwable -> L5
        S90();     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        S90();
        boolean r102 = MatchRoomLandScapeAnimUtil.f82832a;
        MatchRoomLandScapeAnimUtil.y("VrAudienceControlDialogLandscape", this, -1);
        W90();
    }

    public static /* synthetic */ void U90(VrAudienceControlDialogLandscape r100, String r101, boolean r102) {
        r100.T90(r101, r102, MapsKt.emptyMap());
    }

    public final void T90(String r100, boolean r101, Map<String, String> r102) {
        HashMap r103 = new HashMap();
        int r104 = r.f111945b;
        r.a(this.f111855e, r103, true);
        r103.put("vr_icon_type", r100);
        if (r101 == false) goto L5;
        String r105 = "1";
    L6:
        r103.put("is_original_vr", r105);
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r106 = this.f111854d;
        if (r106 == null) goto L13;
        com.bytedance.live.datacontext.m<? extends Boolean> r107 = r106.isVrSensorOpen();
        if (r107 == null) goto L13;
        if (r107.getValue().booleanValue() != true) goto L13;
        String r108 = "on";
    L14:
        r103.put("gyroscope_state", r108);
        r103.putAll(r102);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_vrmodel_toolbar_click", r103, new Object[0]);
        return;
    L13:
        r108 = "off";
        goto L14
    L5:
        r105 = "0";
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        boolean r103 = false;
        View r104 = r100.inflate(R.layout.ttlive_dialog_vr_mode_setting_land, r101, false);
        this.f111862l = r104;
        W90();
        DataCenter r105 = this.f111855e;
        TextView r106 = null;
        if (r105 == null) goto L5;
        Object r107 = r105.get("cmd_current_sub_camera_state");
    L7:
        if ((r107 instanceof es0.a) == true) goto L9;
        r107 = null;
    L9:
        es0.a r108 = (es0.a) r107;
        if (r108 == null) goto L12;
        boolean r109 = r108.f473677b;
    L13:
        View r110 = this.f111862l;
        if (r110 == null) goto L16;
        View r111 = r110.findViewById(R.id.vr_sensor_container);
    L17:
        this.f111856f = r111;
        if (r111 == null) goto L20;
        r111.setOnClickListener(new k(this, r109));
    L20:
        View r112 = this.f111862l;
        if (r112 == null) goto L25;
        FrameLayout r113 = (FrameLayout) r112.findViewById(R.id.close_view);
        if (r113 == null) goto L25;
        r113.setOnClickListener(new i(this));
    L25:
        View r114 = this.f111862l;
        if (r114 == null) goto L28;
        View r115 = r114.findViewById(R.id.vr_clear_container);
    L29:
        this.f111857g = r115;
        if (r115 == null) goto L32;
        r115.setOnClickListener(new l(this, r109));
    L32:
        View r116 = this.f111862l;
        if (r116 == null) goto L35;
        View r117 = r116.findViewById(R.id.vr_mode_container);
    L36:
        this.f111859i = r117;
        if (r117 == null) goto L39;
        r117.setOnClickListener(new m(this, r109));
    L39:
        View r118 = this.f111862l;
        if (r118 == null) goto L42;
        View r119 = r118.findViewById(R.id.vr_change_screen_orientation_container);
    L43:
        this.f111863m = r119;
        if (r119 == null) goto L46;
        r119.setOnClickListener(new n(this, r109));
    L46:
        View r120 = this.f111862l;
        if (r120 == null) goto L49;
        RoundCornerImageView r121 = (RoundCornerImageView) r120.findViewById(R.id.vr_clear_container_bg);
    L50:
        this.f111858h = r121;
        View r122 = this.f111862l;
        if (r122 == null) goto L53;
        ImageView r123 = (ImageView) r122.findViewById(R.id.img_vr_sensor);
    L54:
        this.f111860j = r123;
        View r124 = this.f111862l;
        if (r124 == null) goto L57;
        r106 = (TextView) r124.findViewById(R.id.text_vr_sensor);
    L57:
        this.f111861k = r106;
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r125 = this.f111854d;
        if (r125 == null) goto L60;
        r125.isVrSensorOpen().a().subscribe(new j(this));
    L60:
        VrUtils.f114389e.getClass();
        if (VrUtils.f114388d != 0) goto L63;
        r103 = true;
    L63:
        V90(r103);
        return r104;
    L53:
        r123 = null;
        goto L54
    L49:
        r121 = null;
        goto L50
    L42:
        r119 = null;
        goto L43
    L35:
        r117 = null;
        goto L36
    L28:
        r115 = null;
        goto L29
    L16:
        r111 = null;
        goto L17
    L12:
        r109 = false;
        goto L13
    L5:
        r107 = null;
        goto L7
    }
}
