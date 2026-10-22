package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.message.model.jl;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/anchorsetting/XiaoAnSettingDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class XiaoAnSettingDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f132837j = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f132838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public jl f132839e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DataCenter f132840f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Integer, Integer> f132841g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<Integer, Integer> f132842h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f132843i;

    public static final class a {
        public static void a(XiaoAnSettingDialog r100, FragmentManager r101) {
            LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, "PrivilegeSettingDialog", r102);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
            return;
        L9:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r100.showNow(r101, "PrivilegeSettingDialog");
        }

        @JvmStatic
        public static void b(DataCenter r100, Context r101, jl r102) {
            Intrinsics.checkNotNullParameter(r100, "dataCenter");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            if ((r101 instanceof FragmentActivity) == false) goto L24;
            FragmentManager r103 = ((FragmentActivity) r101).getSupportFragmentManager();
            if ((r103.findFragmentByTag("PrivilegeSettingDialog") instanceof XiaoAnSettingDialog) == false) goto L14;
            Fragment r104 = r103.findFragmentByTag("PrivilegeSettingDialog");
            if (r104 == null) goto L13;
            XiaoAnSettingDialog r105 = (XiaoAnSettingDialog) r104;
            r105.setAnimationType("right");
            r105.setShouldUseNewPanel(true);
            r105.f132839e = r102;
            r105.f132840f = r100;
            if (r105.isAdded() == false) goto L11;
            return;
        L11:
            a(r105, r103);
        L15:
            com.bytedance.android.livesdk.log.g r106 = com.bytedance.android.livesdk.log.u.l();
            HashMap r107 = new HashMap();
            IUserService r108 = (IUserService) jc1.k.f(IUserService.class);
            if (r108 == null) goto L21;
            com.bytedance.android.livesdk.user.f r109 = r108.user();
            if (r109 == null) goto L21;
            String r110 = r109.n();
            if (r110 == null) goto L21;
        L22:
            r107.put("anchor_id", r110);
            Unit r111 = Unit.INSTANCE;
            r106.sendLog("livesdk_anchor_setting_revenue_function_page_show", r107, new Object[0]);
            return;
        L21:
            r110 = "0";
            goto L22
        L13:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.api.anchorsetting.XiaoAnSettingDialog");
        L14:
            XiaoAnSettingDialog r112 = new XiaoAnSettingDialog();
            r112.f132839e = r102;
            r112.f132840f = r100;
            a(r112, r103);
            goto L15
        }
    }

    static {
    }

    public XiaoAnSettingDialog() {
        this.f132838d = new LinkedHashMap();
        Integer r100 = Integer.valueOf(R.id.radio_1);
        Integer r101 = Integer.valueOf(R.id.radio_2);
        Integer r102 = Integer.valueOf(R.id.radio_3);
        this.f132841g = MapsKt.mapOf(new Pair[]{TuplesKt.to(r100, 3), TuplesKt.to(r101, 5), TuplesKt.to(r102, 1)});
        this.f132842h = MapsKt.mapOf(new Pair[]{TuplesKt.to(1, r102), TuplesKt.to(3, r100), TuplesKt.to(5, r101)});
        this.f132843i = 3;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.f132838d).clear();
    }

    public final View S90(int r100) {
        if (this.f132838d != null) goto L5;
        this.f132838d = new LinkedHashMap();
    L5:
        View r101 = this.f132838d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f132838d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_CommonRightDialogWithNotFullScreen);
        setAnimationType("bottom");
        setShouldUseNewPanel(true);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Dialog r102 = getDialog();
        if (r102 == null) goto L5;
        r102.setCancelable(false);
    L5:
        Dialog r103 = getDialog();
        if (r103 == null) goto L8;
        r103.setCanceledOnTouchOutside(false);
    L8:
        ((RadioGroup) S90(R.id.radio_group)).check(R.id.radio_1);
        ((RadioGroup) S90(R.id.radio_group)).setOnCheckedChangeListener(new z(this));
        if (this.f132839e == null) goto L32;
        View r104 = S90(R.id.xiaoan_setting_head);
        if (r104 == null) goto L31;
        HSImageView r105 = (HSImageView) r104;
        jl r106 = this.f132839e;
        String r107 = null;
        if (r106 == null) goto L16;
        py.k r108 = r106.getTitleImage();
    L17:
        ImageLoader.bindImage(r105, r108);
        TextView r109 = (TextView) S90(R.id.xiaoan_setting_title);
        jl r110 = this.f132839e;
        if (r110 == null) goto L20;
        String r111 = r110.getTitle();
    L21:
        r109.setText(r111);
        TextView r112 = (TextView) S90(R.id.xiaoan_setting_top_tips);
        jl r113 = this.f132839e;
        if (r113 == null) goto L24;
        String r114 = r113.getTopTip();
    L25:
        r112.setText(r114);
        TextView r115 = (TextView) S90(R.id.xiaoan_setting_bottom_tips);
        jl r116 = this.f132839e;
        if (r116 == null) goto L28;
        r107 = r116.getBottomTip();
    L28:
        r115.setText(r107);
        ((ImageView) S90(R.id.xiaoan_setting_close)).setOnClickListener(new a0(this));
        ((Button) S90(R.id.btn_cancel)).setOnClickListener(new b0(this));
        ((Button) S90(R.id.btn_set)).setOnClickListener(new c0(this));
        return;
    L24:
        r114 = null;
        goto L25
    L20:
        r111 = null;
        goto L21
    L16:
        r108 = null;
        goto L17
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.widget.HSImageView");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_xiaoan_setting, r101, false);
    }
}
