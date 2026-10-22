package com.bytedance.android.livesdk.interactivity.barrage.setting.vs;

import a62.g;
import a62.h;
import a62.i;
import a62.j;
import a62.k;
import am2.x;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.matchroom.MatchLandFullShadowLinearLayout;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.live.matchroom.b;
import com.bytedance.android.livesdk.castscreen.AdaptiveDialogFragment;
import com.bytedance.android.livesdk.f;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.android.livesdk.interactivity.api.settings.config.a1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.larus.nova.R;
import com.lynx.canvas.KryptonCamera;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n22.c;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/setting/vs/VSLiveLandscapeBarrageSettingDialog;", "Lcom/bytedance/android/livesdk/castscreen/AdaptiveDialogFragment;", "Lcom/bytedance/android/live/matchroom/b;", "Ln22/c;", "Lcom/bytedance/android/livesdk/interactivity/barrage/setting/vs/AbsBarrageSettingWidget$a;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSLiveLandscapeBarrageSettingDialog extends AdaptiveDialogFragment implements b, c, AbsBarrageSettingWidget.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f133948m = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f133949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DataCenter f133950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f133951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BarrageSetting f133952h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BarrageSettingArea f133953i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BarrageSetting f133954j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f133955k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public WidgetManager f133956l;

    public static final class a {
        public static void a(VSLiveLandscapeBarrageSettingDialog r100, FragmentManager r101) {
            LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, "VSLandscapeBarrageSettingDialog", r102);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
            return;
        L9:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r100.showNow(r101, "VSLandscapeBarrageSettingDialog");
        }

        public static void b(Context r100, DataCenter r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            FragmentActivity r103 = ContextUtil.contextToFragmentActivity(r100);
            if (r103 == null) goto L13;
            FragmentManager r104 = r103.getSupportFragmentManager();
            if ((r104.findFragmentByTag("VSLandscapeBarrageSettingDialog") instanceof VSLiveLandscapeBarrageSettingDialog) == false) goto L11;
            Fragment r105 = r104.findFragmentByTag("VSLandscapeBarrageSettingDialog");
            if (r105 == null) goto L10;
            VSLiveLandscapeBarrageSettingDialog r106 = (VSLiveLandscapeBarrageSettingDialog) r105;
            r106.f133950f = r101;
            r106.f133955k = r102;
            a(r106, r104);
            return;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.barrage.setting.vs.VSLiveLandscapeBarrageSettingDialog");
        L11:
            VSLiveLandscapeBarrageSettingDialog r107 = new VSLiveLandscapeBarrageSettingDialog();
            r107.f133950f = r101;
            r107.f133955k = r102;
            a(r107, r104);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment
    public final void dismiss() {
        View r100 = this.f133951g;
        if (r100 == null) goto L5;
        r100.setOnClickListener(null);
    L5:
        this.f133956l = null;
        MatchRoomLandScapeAnimUtil.E.j("VSLandscapeBarrageSettingDialog");
        super.dismiss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L15;
        d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismissAllowingStateLoss() {
        View r100 = this.f133951g;
        if (r100 == null) goto L5;
        r100.setOnClickListener(null);
    L5:
        this.f133956l = null;
        MatchRoomLandScapeAnimUtil.E.j("VSLandscapeBarrageSettingDialog");
        super.dismissAllowingStateLoss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L15;
        d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.live.matchroom.b
    public final int getActualContentWidth() {
        return UtilityKotlinExtentionsKt.i(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        BarrageSetting r100 = this.f133952h;
        if (r100 == null) goto L48;
        HashMap r101 = new HashMap();
        BarrageSettingArea r102 = r100.getBarrageArea();
        String r103 = "null";
        String r104 = "close";
        if (r102 == null) goto L13;
        int r105 = g.f1945a[r102.ordinal()];
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L16;
        if (r105 != 3) goto L12;
        String r106 = "top";
    L18:
        r101.put("barrage_position", r106);
        BarrageSettingFont r107 = r100.getFontSize();
        if (r107 == null) goto L29;
        int r108 = g.f1946b[r107.ordinal()];
        if (r108 == 1) goto L28;
        if (r108 == 2) goto L27;
        if (r108 != 3) goto L29;
        r103 = "small";
        goto L29
    L27:
        r103 = KryptonCamera.Config.RESOLUTION_MEDIUM;
        goto L29
    L28:
        r103 = "big";
    L29:
        r101.put("barrage_size", r103);
        StringBuilder r109 = new StringBuilder();
        r109.append(String.valueOf((int) r100.getAlpha()));
        String r110 = "";
        r109.append("");
        r101.put(GXTemplateKey.STYLE_OPACITY, r109.toString());
        if (r100.isGiftOpen() == false) goto L32;
        Object r111 = "open";
    L33:
        r101.put("gift_message", r111);
        int r112 = a1.f133760a;
        if (a1.a.a().d() == false) goto L40;
        if (r100.isCarnivalBarrageOpen() == false) goto L38;
        r104 = "open";
    L38:
        r101.put("carnival_message", r104);
    L40:
        if ((!S90(r100, this.f133954j)) == false) goto L42;
        String r113 = "1";
    L43:
        r101.put("is_change", r113);
        String r114 = this.f133955k;
        if (r114 == null) goto L47;
        r110 = r114;
    L47:
        r101.put("request_page", r110);
        j0.l().sendLog("livesdk_landscape_barrage_settings_change", r101, new Object[]{new x(), IRoom.class});
        X50(r100);
        goto L48
    L42:
        r113 = "0";
        goto L43
    L32:
        r111 = "close";
        goto L33
    L12:
        if (r105 != 4) goto L13;
        r106 = "close";
        goto L18
    L16:
        r106 = "half";
        goto L18
    L17:
        r106 = "full_screen";
    L13:
        r106 = "null";
    L48:
        this.f133953i = null;
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        f.d().f123395d = false;
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        f.d().f123395d = true;
        super.onResume();
    }

    public VSLiveLandscapeBarrageSettingDialog() {
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment
    public final boolean isVertical() {
        return this.f133949e;
    }

    @Override // com.bytedance.android.livesdk.interactivity.barrage.setting.vs.AbsBarrageSettingWidget.a
    public final void X50(BarrageSetting r100) {
        Intrinsics.checkNotNullParameter(r100, "barrageSetting");
        if (r100.isNeedRollback() == false) goto L7;
        BarrageSettingArea r101 = this.f133953i;
        if (r101 == null) goto L7;
        r100.setBarrageArea(r101);
    L7:
        e<BarrageSetting> r102 = l42.a.f507317d;
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r100);
    }

    @Override // com.bytedance.android.livesdk.castscreen.AdaptiveDialogFragment, com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        View r101 = getView();
        ViewGroup.LayoutParams r102 = null;
        if (r101 == null) goto L5;
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
    L7:
        if ((r103 instanceof FrameLayout.LayoutParams) == true) goto L9;
        r103 = null;
    L9:
        FrameLayout.LayoutParams r104 = (FrameLayout.LayoutParams) r103;
        if (r104 == null) goto L14;
        r104.width = UtilityKotlinExtentionsKt.i(600);
        r104.gravity = GravityCompat.END;
        r104.height = s1.s(getActivity());
        View r105 = getView();
        if (r105 == null) goto L14;
        r105.setLayoutParams(r104);
    L14:
        Dialog r106 = getDialog();
        if ((r106 instanceof LiveBottomSheetDialog) == true) goto L17;
        r106 = null;
    L17:
        LiveBottomSheetDialog r107 = (LiveBottomSheetDialog) r106;
        if (r107 == null) goto L20;
        View r108 = r107.getBottomSheetView();
    L21:
        if (r108 == null) goto L23;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
    L25:
        if ((r109 instanceof CoordinatorLayout.LayoutParams) == false) goto L28;
        r102 = r109;
    L28:
        CoordinatorLayout.LayoutParams r110 = (CoordinatorLayout.LayoutParams) r102;
        if (r110 == null) goto L32;
        ((ViewGroup.MarginLayoutParams) r110).width = UtilityKotlinExtentionsKt.i(600);
        r110.gravity = GravityCompat.END;
        ((ViewGroup.MarginLayoutParams) r110).height = s1.s(getActivity());
        r108.setLayoutParams(r110);
        return;
    L32:
        return;
    L23:
        r109 = null;
        goto L25
    L20:
        r108 = null;
        goto L21
    L5:
        r103 = null;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L12;
        d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.livesdk.castscreen.AdaptiveDialogFragment, com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment
    public final void setVertical(boolean r100) {
        this.f133949e = r100;
    }

    public static boolean S90(BarrageSetting r100, BarrageSetting r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r100.getBarrageArea() == r101.getBarrageArea()) goto L10;
        return false;
    L10:
        if (r100.getFontSize() == r101.getFontSize()) goto L12;
        return false;
    L12:
        if (r100.getAlpha() == r101.getAlpha()) goto L14;
        return false;
    L14:
        if (r100.isGiftOpen() == r101.isGiftOpen()) goto L16;
        return false;
    L16:
        if (r100.isCarnivalBarrageOpen() != r101.isCarnivalBarrageOpen()) goto L23;
        return true;
    L23:
        return false;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        boolean r102 = MatchRoomLandScapeAnimUtil.f82832a;
        MatchRoomLandScapeAnimUtil.y("VSLandscapeBarrageSettingDialog", this, -1);
        super.onViewCreated(r100, r101);
        BarrageSetting r103 = l42.a.f507317d.getValue();
        this.f133952h = r103;
        View r104 = null;
        if (r103 != null) goto L5;
    L11:
        this.f133952h = BarrageSetting.getDefaultVSLiveSetting();
    L12:
        BarrageSetting r105 = this.f133952h;
        if (r105 == null) goto L16;
        BarrageSetting r106 = new BarrageSetting();
        r106.setBarrageArea(r105.getBarrageArea());
        r106.setFontSize(r105.getFontSize());
        r106.setAlpha(r105.getAlpha());
        r106.setGiftOpen(r105.isGiftOpen());
        r106.setNeedRollback(r105.isNeedRollback());
        this.f133954j = r106;
    L16:
        if (l42.a.f507320g.getValue().booleanValue() == false) goto L24;
        BarrageSetting r107 = this.f133952h;
        if (r107 == null) goto L20;
        BarrageSettingArea r108 = r107.getBarrageArea();
    L21:
        this.f133953i = r108;
        BarrageSetting r109 = this.f133952h;
        if (r109 == null) goto L34;
        r109.setBarrageArea(BarrageSettingArea.CLOSE);
    L34:
        if ((r100 instanceof MatchLandFullShadowLinearLayout) == true) goto L36;
        View r110 = null;
    L37:
        MatchLandFullShadowLinearLayout r111 = (MatchLandFullShadowLinearLayout) r110;
        if (r111 == null) goto L40;
        r111.setEnableShader(false);
    L40:
        r100.setBackgroundResource(R.drawable.ttlive_bg_vs_action_sheet_600);
        r100.findViewById(R.id.touch_outside).setOnClickListener(new h(this));
        WidgetManager r112 = WidgetManager.of(this, getView());
        this.f133956l = r112;
        if (r112 == null) goto L43;
        r112.setDataCenter(this.f133950f);
    L43:
        BarrageSetting r113 = this.f133952h;
        if (r113 == null) goto L57;
        WidgetManager r114 = this.f133956l;
        if (r114 == null) goto L48;
        r114.load(R.id.font_size_container, new BarrageSettingFontSizeWidget(r113, this), false);
    L48:
        WidgetManager r115 = this.f133956l;
        if (r115 == null) goto L51;
        r115.load(R.id.alpha_container, new BarrageSettingAlphaWidget(r113, this), false);
    L51:
        WidgetManager r116 = this.f133956l;
        if (r116 == null) goto L54;
        r116.load(R.id.area_container, new BarrageSettingAreaWidget(r113, this), false);
    L54:
        WidgetManager r117 = this.f133956l;
        if (r117 == null) goto L57;
        r117.load(R.id.block_container, new BarrageSettingBlockWidget(r113, this), false);
    L57:
        View r118 = getView();
        if (r118 == null) goto L60;
        r104 = r118.findViewById(R.id.live_barrage_setting_default);
    L60:
        this.f133951g = r104;
        if (r104 == null) goto L63;
        r104.setOnClickListener(new i(this));
    L63:
        boolean r119 = S90(this.f133952h, BarrageSetting.getDefaultVSLiveSetting());
        View r120 = this.f133951g;
        if (r120 == null) goto L69;
        if (r119 == false) goto L67;
        float r121 = 0.5f;
    L68:
        r120.setAlpha(r121);
        goto L69
    L67:
        r121 = 1.0f;
    L69:
        View r122 = this.f133951g;
        if (r122 == null) goto L72;
        r122.setClickable(!r119);
    L72:
        ((ObservableSubscribeProxy) xs2.b.a().b(q22.b.class).as(AutoDispose.bind(this))).subscribe(new j(this));
        r100.post(new k(this));
        return;
    L36:
        r110 = r100;
        goto L37
    L20:
        r108 = null;
        goto L21
    L24:
        BarrageSetting r123 = this.f133952h;
        if (r123 == null) goto L27;
        BarrageSettingArea r124 = r123.getBarrageArea();
    L29:
        if (r124 != BarrageSettingArea.CLOSE) goto L34;
        BarrageSetting r125 = this.f133952h;
        if (r125 == null) goto L34;
        r125.setBarrageArea(BarrageSettingArea.TOP);
        goto L34
    L27:
        r124 = null;
        goto L29
    L5:
        if (r103.getBarrageArea() == null) goto L11;
        BarrageSetting r126 = this.f133952h;
        if (r126 == null) goto L9;
        BarrageSettingFont r127 = r126.getFontSize();
    L10:
        if (r127 != null) goto L12;
    L9:
        r127 = null;
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_layout_vs_live_barrage_setting_dialog, r101, false);
    }
}
