package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.i2;
import com.bytedance.android.livesdk.gift.platform.core.ui.configuration.viewmodel.GiftEffectConfigurationViewModelForAnchor;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/ui/configuration/GiftEffectConfigurationDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftEffectConfigurationDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f131931p = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f131932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public GiftEffectConfigurationViewModelForAnchor f131933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f131934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f131935g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f131936h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f131937i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ListView f131938j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f131939k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final GiftEffectConfigurationDialog$adapter$1 f131940l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Context f131941m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f131942n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f131943o;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        setBottomSheetSlideProcessor(new g());
        Dialog r101 = getDialog();
        if (r101 == null) goto L7;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L7;
        r102.setGravity(80);
        r102.setLayout(-1, -1);
        r102.setBackgroundDrawable(new ColorDrawable(0));
    L7:
        View r103 = this.f131934f;
        if (r103 == null) goto L10;
        LinearLayout r104 = (LinearLayout) r103.findViewById(R.id.gift_effect_config_container);
    L11:
        this.f131935g = r104;
        View r105 = this.f131934f;
        if (r105 == null) goto L14;
        TextView r106 = (TextView) r105.findViewById(R.id.gift_effect_config_title);
    L15:
        this.f131936h = r106;
        View r107 = this.f131934f;
        if (r107 == null) goto L18;
        ImageView r108 = (ImageView) r107.findViewById(R.id.back);
    L19:
        this.f131937i = r108;
        View r109 = this.f131934f;
        if (r109 == null) goto L22;
        ListView r110 = (ListView) r109.findViewById(R.id.gift_effect_config_list);
    L23:
        this.f131938j = r110;
        LinearLayout r111 = this.f131935g;
        if (r111 == null) goto L26;
        a1.k(r111, (int) fm3.e.a(this.f131941m, this.f131939k));
        r111.setBackground(s1.m(R.drawable.ttlive_dialog_standard_bg));
    L26:
        TextView r112 = this.f131936h;
        if (r112 == null) goto L29;
        r112.setTextColor(s1.h(R.color.ttlive_dialog_main_text));
        r112.setTextSize(0, s1.j(R.dimen.ttlive_dialog_title_text_size));
        r112.setText(R.string.ttlive_gift_effect_config_title);
    L29:
        ImageView r113 = this.f131937i;
        if (r113 == null) goto L32;
        r113.setOnClickListener(new h(this));
    L32:
        ListView r114 = this.f131938j;
        if (r114 == null) goto L36;
        r114.setDivider(null);
        r114.setClickable(false);
        r114.setOnItemClickListener(null);
        r114.setAdapter(this.f131940l);
        return;
    L36:
        return;
    L22:
        r110 = null;
        goto L23
    L18:
        r108 = null;
        goto L19
    L14:
        r106 = null;
        goto L15
    L10:
        r104 = null;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_common_bottom_dialog);
    }

    public GiftEffectConfigurationDialog(Context r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "hostContext");
        this.f131941m = r100;
        this.f131942n = r101;
        this.f131943o = r102;
        if (r101 == false) goto L5;
        n r103 = new GiftEffectConfigurationItemForAnchor(r100);
    L6:
        this.f131932d = r103;
        this.f131939k = 321.0f;
        this.f131940l = new GiftEffectConfigurationDialog$adapter$1(this);
        return;
    L5:
        r103 = new GiftEffectConfigurationItemForAudience(r100);
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        this.f131934f = r100.inflate(R.layout.ttlive_base_gift_effect_config_dialog, r101, false);
        if (this.f131942n == false) goto L5;
        this.f131933e = (GiftEffectConfigurationViewModelForAnchor) ViewModelProviders.of(this).get(GiftEffectConfigurationViewModelForAnchor.class);
    L28:
        GiftEffectConfigurationViewModelForAnchor r102 = this.f131933e;
        if (r102 == null) goto L31;
        r102.setIsBeforeLive(this.f131943o);
    L31:
        this.f131932d.b(this.f131933e);
        if (this.f131942n == false) goto L48;
        GiftEffectConfigurationViewModelForAnchor r103 = this.f131933e;
        if (r103 == null) goto L37;
        r103.updateStickerEffectStatus();
    L37:
        if (this.f131943o == true) goto L41;
        GiftEffectConfigurationViewModelForAnchor r104 = this.f131933e;
        if (r104 == null) goto L41;
        r104.getGameEffectSwitch();
    L41:
        GiftEffectConfigurationViewModelForAnchor r105 = this.f131933e;
        if (r105 == null) goto L44;
        r105.getRoleSkillEffectSwitch();
    L44:
        GiftEffectConfigurationViewModelForAnchor r106 = this.f131933e;
        if (r106 == null) goto L48;
        GiftEffectConfigurationViewModelForAnchor.logAnchorConfigDialogShow$default(r106, null, null, 3, null);
    L48:
        return this.f131934f;
    L5:
        i12.e r107 = i12.o.b();
        if (r107 == null) goto L8;
        Object r108 = com.bytedance.android.scope.m.f163449e.d(r107, i2.class);
    L9:
        i2 r109 = (i2) r108;
        int r111 = p.f131989a;
        boolean r112 = true;
        if (r109 == null) goto L12;
        boolean r113 = i2.d();
    L13:
        if (r109 == null) goto L15;
        r112 = r109.c();
    L15:
        mz0.n r114 = new mz0.n();
        p.a(r114);
        Map<String, String> r115 = r114.f516447a;
        Intrinsics.checkNotNullParameter(r115, "map");
        String r116 = "open";
        if (r113 == false) goto L18;
        String r117 = "open";
    L19:
        Intrinsics.checkNotNullParameter("gift_effect_status", "key");
        Intrinsics.checkNotNullParameter(r117, "value");
        r115.put("gift_effect_status", r117);
        if (r112 == true) goto L23;
        r116 = "close";
    L23:
        Intrinsics.checkNotNullParameter("gift_voice_status", "key");
        Intrinsics.checkNotNullParameter(r116, "value");
        r115.put("gift_voice_status", r116);
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h() == false) goto L26;
        String r118 = "1";
    L27:
        Intrinsics.checkNotNullParameter(IPerformanceManager.Params.is_anchor, "key");
        Intrinsics.checkNotNullParameter(r118, "value");
        r115.put(IPerformanceManager.Params.is_anchor, r118);
        cy0.e.f465759a.getClass();
        cy0.j r119 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r120 = com.bytedance.android.scope.m.b(r119).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r120);
        ((mz0.i) ((f80.a) r120)).w3("livesdk_audience_gift_effects_setting_popup_show", r114.f516447a, r114.f516448b);
        goto L28
    L26:
        r118 = "0";
        goto L27
    L18:
        r117 = "close";
        goto L19
    L12:
        r113 = true;
        goto L13
    L8:
        r108 = null;
        goto L9
    }
}
