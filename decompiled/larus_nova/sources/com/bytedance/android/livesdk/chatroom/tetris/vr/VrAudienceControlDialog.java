package com.bytedance.android.livesdk.chatroom.tetris.vr;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.utils.SettingKeyUtils;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerImageView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.optimize.statistics.FrescoMonitorConst;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/tetris/vr/VrAudienceControlDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VrAudienceControlDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int M = 0;
    public com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a B;
    public DataCenter C;
    public View D;
    public View E;
    public RoundCornerImageView F;
    public View G;
    public ImageView H;
    public TextView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public View f111852J;
    public View K;
    public View L;

    public final void Z0() {
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r100 = this.B;
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.m<? extends Boolean> r101 = r100.isVrSensorOpen();
        if (r101 == null) goto L9;
        boolean r102 = true;
        if (r101.getValue().booleanValue() != true) goto L9;
    L10:
        Y0(r102);
        return;
    L9:
        r102 = false;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final int getLayoutId() {
        if (SettingKeyUtils.d() == true) goto L5;
    L7:
        return R.layout.ttlive_dialog_vr_mode_setting;
    L5:
        if (SettingKeyUtils.e() == false) goto L7;
        return R.layout.ttlive_dialog_vr_mode_setting_new;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Z0();
    }

    @Override // com.bytedance.android.livesdk.pannel.SheetBaseDialog, android.app.Dialog
    public final void onStart() {
        super.onStart();
        Z0();
    }

    public VrAudienceControlDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100, false);
    }

    @Override // com.bytedance.android.livesdk.widget.LiveStandardSheetDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog
    public final void M0(View r100) {
        super.M0(r100);
        this.f111852J = r100;
    }

    public final void Y0(boolean r100) {
        if (r100 == false) goto L22;
        if (SettingKeyUtils.d() == true) goto L6;
    L8:
        int r101 = R.drawable.ttlive_ic_vr_sensor_open_nobg;
    L10:
        if (SettingKeyUtils.d() == true) goto L12;
    L14:
        String r102 = "陀螺仪开启";
    L15:
        ImageView r103 = this.H;
        if (r103 == null) goto L18;
        r103.setImageResource(r101);
    L18:
        TextView r104 = this.I;
        if (r104 == null) goto L40;
        r104.setText(r102);
        return;
    L40:
        return;
    L12:
        if (SettingKeyUtils.e() == false) goto L14;
        r102 = "固定视角";
        goto L15
    L6:
        if (SettingKeyUtils.e() == false) goto L8;
        r101 = R.drawable.ttlive_vr_view_fixed_large;
        goto L10
    L22:
        if (SettingKeyUtils.d() == true) goto L24;
    L26:
        int r105 = R.drawable.ttlive_ic_vr_sensor_close_nobg;
    L28:
        if (SettingKeyUtils.d() == true) goto L30;
    L32:
        String r106 = "陀螺仪关闭";
    L33:
        ImageView r107 = this.H;
        if (r107 == null) goto L36;
        r107.setImageResource(r105);
    L36:
        TextView r108 = this.I;
        if (r108 == null) goto L42;
        r108.setText(r106);
        return;
    L42:
        return;
    L30:
        if (SettingKeyUtils.e() == false) goto L32;
        r106 = "旋转视角";
        goto L33
    L24:
        if (SettingKeyUtils.e() == false) goto L26;
        r105 = R.drawable.ttlive_vr_view_not_fixed_large;
        goto L28
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Z0();
        DataCenter r101 = this.C;
        TextView r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.get("cmd_current_sub_camera_state");
    L7:
        if ((r103 instanceof es0.a) == true) goto L9;
        r103 = null;
    L9:
        es0.a r104 = (es0.a) r103;
        boolean r105 = false;
        if (r104 == null) goto L12;
        boolean r106 = r104.f473677b;
    L13:
        View r107 = this.f111852J;
        if (r107 == null) goto L16;
        View r108 = r107.findViewById(R.id.vr_sensor_container);
    L17:
        this.D = r108;
        if (r108 == null) goto L20;
        r108.setOnClickListener(new d(this, r106));
    L20:
        View r109 = this.f111852J;
        if (r109 == null) goto L23;
        View r110 = r109.findViewById(R.id.vr_clear_container);
    L24:
        this.E = r110;
        if (r110 == null) goto L27;
        r110.setOnClickListener(new e(this, r106));
    L27:
        View r111 = this.f111852J;
        if (r111 == null) goto L30;
        View r112 = r111.findViewById(R.id.vr_mode_container);
    L31:
        this.G = r112;
        if (r112 == null) goto L34;
        r112.setOnClickListener(new f(this, r106));
    L34:
        View r113 = this.f111852J;
        if (r113 == null) goto L37;
        View r114 = r113.findViewById(R.id.vr_change_screen_orientation_container);
    L38:
        this.K = r114;
        if (r114 == null) goto L41;
        r114.setOnClickListener(new g(this, r106));
    L41:
        View r115 = this.f111852J;
        if (r115 == null) goto L44;
        View r116 = r115.findViewById(R.id.vr_camera_back);
    L45:
        this.L = r116;
        if (r116 == null) goto L49;
        r116.setOnClickListener(new h(this, r106));
    L49:
        if (VrUtils.B() == true) goto L60;
        View r117 = this.K;
        if (r117 == null) goto L54;
        r117.setVisibility(8);
    L54:
        if (SettingKeyUtils.d() == false) goto L60;
        if (SettingKeyUtils.e() == false) goto L60;
        View r118 = this.D;
        if (r118 == null) goto L60;
        UIUtils.updateLayoutMargin(r118, (int) UIUtils.dip2Px(getContext(), 50.0f), -3, -3, -3);
    L60:
        if (r106 == true) goto L64;
        View r119 = this.L;
        if (r119 == null) goto L64;
        r119.setVisibility(8);
    L64:
        View r120 = this.f111852J;
        if (r120 == null) goto L67;
        RoundCornerImageView r121 = (RoundCornerImageView) r120.findViewById(R.id.vr_clear_container_bg);
    L68:
        this.F = r121;
        View r122 = this.f111852J;
        if (r122 == null) goto L71;
        ImageView r123 = (ImageView) r122.findViewById(R.id.img_vr_sensor);
    L72:
        this.H = r123;
        View r124 = this.f111852J;
        if (r124 == null) goto L75;
        r102 = (TextView) r124.findViewById(R.id.text_vr_sensor);
    L75:
        this.I = r102;
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r125 = this.B;
        if (r125 == null) goto L78;
        r125.isVrSensorOpen().a().subscribe(new c(this));
    L78:
        VrUtils.f114389e.getClass();
        if (VrUtils.f114388d != 0) goto L81;
        r105 = true;
    L81:
        Y0(r105);
        return;
    L71:
        r123 = null;
        goto L72
    L67:
        r121 = null;
        goto L68
    L44:
        r116 = null;
        goto L45
    L37:
        r114 = null;
        goto L38
    L30:
        r112 = null;
        goto L31
    L23:
        r110 = null;
        goto L24
    L16:
        r108 = null;
        goto L17
    L12:
        r106 = false;
        goto L13
    L5:
        r103 = null;
        goto L7
    }

    public static /* synthetic */ void X0(VrAudienceControlDialog r100, String r101, boolean r102) {
        r100.W0(r101, r102, MapsKt.emptyMap());
    }

    public final void W0(String r100, boolean r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "iconType");
        Intrinsics.checkNotNullParameter(r102, FrescoMonitorConst.IMAGEX_CUSTOM_PARAM);
        HashMap r103 = new HashMap();
        int r104 = r.f111945b;
        r.a(this.C, r103, true);
        r103.put("vr_icon_type", r100);
        if (r101 == false) goto L5;
        String r105 = "1";
    L6:
        r103.put("is_original_vr", r105);
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r106 = this.B;
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
}
