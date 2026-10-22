package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/PkMuteCheckDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkMuteCheckDialogFragment extends LiveDialogFragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f95435m = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f95436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f95437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f95438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f95439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AppCompatRadioButton f95440h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f95441i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f95442j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Boolean f95443k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View.OnClickListener f95444l;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkMuteCheckDialogFragment f95445a;

        public b(PkMuteCheckDialogFragment r100) {
            this.f95445a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            PkMuteCheckDialogFragment r101 = this.f95445a;
            int r102 = PkMuteCheckDialogFragment.f95435m;
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

    public PkMuteCheckDialogFragment() {
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        Intrinsics.checkNotNull(r101);
        Window r102 = r101.getWindow();
        if (r102 == null) goto L10;
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r103.width = -1;
        b03.a r104 = b03.a.f16857a;
        if (PadConfigUtils.a() == false) goto L7;
        int r105 = -2;
    L8:
        r103.height = r105;
        r102.setAttributes(r103);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.setGravity(80);
        return;
    L7:
        r105 = s1.f(180.0f);
        goto L8
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_live_interact_dialog);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.setOnCancelListener(new b(this));
        r101.setCanceledOnTouchOutside(true);
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = getView();
        Intrinsics.checkNotNull(r102);
        this.f95436d = r102.findViewById(R.id.ttlive_cancel);
        this.f95438f = r102.findViewById(R.id.ttlive_end);
        this.f95437e = r102.findViewById(R.id.ttlive_close_icon);
        this.f95439g = r102.findViewById(R.id.rb_layout);
        this.f95440h = (AppCompatRadioButton) r102.findViewById(R.id.rb);
        this.f95441i = (TextView) r102.findViewById(R.id.tv_title);
        View r103 = this.f95436d;
        if (r103 == null) goto L5;
        r103.setOnClickListener(new f(this));
    L5:
        View.OnClickListener r104 = this.f95444l;
        if (r104 == null) goto L10;
        View r105 = this.f95438f;
        if (r105 == null) goto L10;
        r105.setOnClickListener(r104);
    L10:
        View r106 = this.f95437e;
        if (r106 == null) goto L13;
        r106.setOnClickListener(new g(this));
    L13:
        View r107 = this.f95439g;
        if (r107 == null) goto L16;
        r107.setOnClickListener(new h(this));
    L16:
        View r108 = this.f95437e;
        if (r108 == null) goto L19;
        r108.setVisibility(8);
    L19:
        TextView r109 = this.f95441i;
        if (r109 == null) goto L22;
        r109.setText(s1.C(R.string.ttlive_interact_link_mute_confirm_dialog_top_tip, new Object[]{this.f95442j}));
    L22:
        Boolean r110 = this.f95443k;
        Boolean r111 = Boolean.TRUE;
        if (Intrinsics.areEqual(r110, r111) == false) goto L27;
        TextView r112 = this.f95441i;
        if (r112 == null) goto L27;
        com.bytedance.live.kmp.util.c r113 = com.bytedance.live.kmp.util.c.f255167a;
        int r114 = w11.a.f557889a;
        r112.setText(com.bytedance.live.kmp.util.c.a(R.string.ttlive_interact_link_mute_confirm_dialog_top_tip_all, new Object[0]));
    L27:
        HashMap r115 = new HashMap();
        r115.put("action_type", "show");
        d31.d r116 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r116 == null) goto L30;
        String r117 = r116.c();
    L31:
        r115.put("connection_type", r117);
        r115.put("anchor_cnt", ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).getLinkAnchorCount());
        r115.put("is_mention_again", "0");
        long r118 = 0;
        LinkCrossRoomDataHolder r119 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r119 == null) goto L40;
        if (r119.i() != 0) goto L40;
        LinkCrossRoomDataHolder r120 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r120 == null) goto L38;
        r118 = r120.f();
        goto L40
    L38:
        r118 = 0;
    L40:
        if (Intrinsics.areEqual(this.f95443k, r111) == false) goto L42;
        String r121 = "livesdk_connection_mute_all_window";
    L43:
        mz0.n r122 = new mz0.n();
        Map<String, String> r123 = r122.f516447a;
        Intrinsics.checkNotNullParameter(r123, "map");
        Intrinsics.checkNotNullParameter(r115, "map");
        r123.putAll(r115);
        mz0.m r124 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.h r125 = ((kr2.a) vh6.c.b(kr2.a.class)).be();
        Intrinsics.checkNotNullParameter(r125, "linkInfoLog");
        r125.c(r118);
        ((ArrayList) r124.f516446a).add(r125.f157175a);
        LinkCrossRoomDataHolder.a r126 = LinkCrossRoomDataHolder.f92004c;
        com.bytedance.android.live.revlink.impl.a.b(r124);
        r124.b(LogCommon.ROOM);
        ((ArrayList) r122.f516448b).addAll(r124.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r127 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r128 = com.bytedance.android.scope.m.b(r127).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r128);
        ((mz0.i) ((f80.a) r128)).w3(r121, r122.f516447a, r122.f516448b);
        return;
    L42:
        r121 = "livesdk_connection_mute_window";
        goto L43
    L30:
        r117 = "";
        goto L31
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_interact_pk_mute_check, r101, false);
    }
}
