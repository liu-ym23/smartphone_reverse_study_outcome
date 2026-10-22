package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.widget.WheelPicker;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.AnchorInteractSettingContract$View;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/InteractPKTimeDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractPKTimeDialogFragment extends LiveDialogFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f95672o = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WheelPicker f95673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f95674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f95675f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f95676g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f95677h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AnchorInteractSettingContract$View f95678i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f95679j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f95680k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public x31.k f95681l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f95682m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f95683n;

    public static final class a {
    }

    public interface b {
        void cS(int r100, int r101);
    }

    public static final class c implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractPKTimeDialogFragment f95684a;

        public c(InteractPKTimeDialogFragment r100) {
            this.f95684a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            InteractPKTimeDialogFragment r101 = this.f95684a;
            int r102 = InteractPKTimeDialogFragment.f95672o;
            Dialog r103 = r101.getDialog();
            Context r104 = r101.getContext();
            if (r103 == null) goto L16;
            if (r104 == null) goto L19;
            Dialog r105 = r101.getDialog();
            Intrinsics.checkNotNull(r105);
            View r106 = r105.getCurrentFocus();
            if (r106 == null) goto L20;
            Object r107 = r104.getSystemService("input_method");
            if (r107 == null) goto L15;
            InputMethodManager r108 = (InputMethodManager) r107;
            if (r108.isActive() == false) goto L17;
            r108.hideSoftInputFromWindow(r106.getWindowToken(), 0);
            return;
        L17:
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        L20:
            return;
        L19:
            return;
        }
    }

    static {
    }

    public InteractPKTimeDialogFragment() {
        this.f95674e = new int[]{120, 300, 600, 900};
        v41.a r100 = v41.a.f553041m;
        r100.getClass();
        if (((Boolean) v41.a.f553039k.getValue(r100, v41.a.f553029a[9])).booleanValue() == false) goto L6;
        this.f95674e = new int[]{10, 30, 60, 90, 120, 180, 300, 600, 900};
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        Intrinsics.checkNotNull(r101);
        Window r102 = r101.getWindow();
        if (r102 == null) goto L11;
        View r103 = r102.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L9:
        r103.setPadding(0, 0, 0, 0);
        r102.setLayout(-1, -1);
        r102.setGravity(80);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.setSoftInputMode(48);
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_live_pk_time_choose_dialog);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.setOnCancelListener(new c(this));
        r101.setCanceledOnTouchOutside(true);
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = getView();
        View r103 = null;
        if (r102 == null) goto L5;
        View r104 = r102.findViewById(R.id.time_choose_cancel);
    L6:
        this.f95676g = r104;
        if (r102 == null) goto L9;
        r103 = r102.findViewById(R.id.time_choose_confirm);
    L9:
        this.f95677h = r103;
        View r105 = this.f95676g;
        if (r105 == null) goto L12;
        r105.setOnClickListener(new g(this));
    L12:
        View r106 = this.f95677h;
        if (r106 == null) goto L15;
        r106.setOnClickListener(new h(this));
    L15:
        HashMap r107 = new HashMap();
        if (this.f95680k == false) goto L19;
        String r108 = "hint_bar";
    L22:
        r107.put("request_page", r108);
        mz0.n r109 = new mz0.n();
        Map<String, String> r110 = r109.f516447a;
        Intrinsics.checkNotNullParameter(r110, "map");
        Intrinsics.checkNotNullParameter(r107, "map");
        r110.putAll(r107);
        mz0.m r111 = new mz0.m();
        r111.b(LogCommon.ROOM);
        ((ArrayList) r109.f516448b).addAll(r111.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r112 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r113 = com.bytedance.android.scope.m.b(r112).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r113);
        ((mz0.i) ((f80.a) r113)).w3("livesdk_pk_time_setting_panel_show", r109.f516447a, r109.f516448b);
        return;
    L19:
        if (this.f95683n == false) goto L21;
        r108 = "playmode_panel_setting";
        goto L22
    L21:
        r108 = "set_panel";
        goto L22
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        ArrayList r111 = new ArrayList();
        int[] r102 = this.f95674e;
        int r103 = r102.length;
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L10;
        int r105 = r102[r104];
        if (r105 >= 60) goto L8;
        String r106 = s1.C(R.string.ttlive_interact_pk_duration_xxx_secs, new Object[]{Integer.valueOf(r105)});
    L9:
        r111.add(r106);
        r104 = r104 + 1;
        goto L4
    L8:
        r106 = s1.C(R.string.ttlive_interact_pk_duration_xxx_mins, new Object[]{Integer.valueOf(r105 / 60)});
        goto L9
    L10:
        int r107 = this.f95675f;
        if (r107 >= 0) goto L13;
    L14:
        this.f95675f = 1;
    L15:
        View r108 = r100.inflate(R.layout.ttlive_dialog_pk_time_choose, r101, false);
        WheelPicker r109 = new WheelPicker(getContext());
        this.f95673d = r109;
        Intrinsics.checkNotNull(r109);
        r109.setData(r111);
        WheelPicker r112 = this.f95673d;
        Intrinsics.checkNotNull(r112);
        r112.setIndicator(true);
        WheelPicker r113 = this.f95673d;
        Intrinsics.checkNotNull(r113);
        r113.setIndicatorSize(3);
        WheelPicker r114 = this.f95673d;
        Intrinsics.checkNotNull(r114);
        r114.setItemTextSize((int) UIUtils.dip2Px(getContext(), 16));
        WheelPicker r115 = this.f95673d;
        Intrinsics.checkNotNull(r115);
        r115.setSelectItemTextSize((int) UIUtils.dip2Px(getContext(), 18));
        WheelPicker r116 = this.f95673d;
        Intrinsics.checkNotNull(r116);
        r116.setItemTextColor(ColorProtector.parseColor("#a0404040"));
        WheelPicker r117 = this.f95673d;
        Intrinsics.checkNotNull(r117);
        r117.setSelectedItemTextColor(ColorProtector.parseColor("#161823"));
        WheelPicker r118 = this.f95673d;
        Intrinsics.checkNotNull(r118);
        r118.setBackgroundColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
        WheelPicker r119 = this.f95673d;
        Intrinsics.checkNotNull(r119);
        r119.g(this.f95675f, false);
        WheelPicker r120 = this.f95673d;
        Intrinsics.checkNotNull(r120);
        r120.setItemSpace(27);
        View r121 = r108.findViewById(R.id.wheelpicker_container);
        if (r121 == null) goto L20;
        ((FrameLayout) r121).addView(this.f95673d);
        return r108;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    L13:
        if (r107 < r111.size()) goto L15;
        goto L14
    }
}
