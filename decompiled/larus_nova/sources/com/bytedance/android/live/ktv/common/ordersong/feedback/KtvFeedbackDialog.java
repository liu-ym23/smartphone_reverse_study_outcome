package com.bytedance.android.live.ktv.common.ordersong.feedback;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/ktv/common/ordersong/feedback/KtvFeedbackDialog;", "Lcom/bytedance/android/live/ktv/common/view/BaseKtvDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvFeedbackDialog extends BaseKtvDialogFragment {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f70132u = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<Integer, View> f70133g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f70134h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public p f70135i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f70136j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f70137k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f70138l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f70139m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f70140n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public fd2.c f70141o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f70142p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f70143q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f70144r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f70145s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f70146t;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment
    public final String S90() {
        return "KtvFeedbackDialog";
    }

    @Override // com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_ktv_feedback;
    }

    public final void Z90() {
        if (this.f70146t == false) goto L16;
        TextView r100 = (TextView) X90(R.id.ktv_feedback_finish);
        if (r100 != null) goto L7;
        return;
    L7:
        if (mz.c.b(this.f70138l) == false) goto L9;
    L13:
        String r101 = s1.B(R.string.ttlive_ktv_feedback_confirm_close);
    L14:
        r100.setText(r101);
        return;
    L9:
        if (mz.c.b(this.f70139m) == true) goto L11;
    L12:
        r101 = s1.B(R.string.ttlive_ktv_feedback_confirm_close_and_sub);
        goto L14
    L11:
        if (mz.c.b(this.f70140n) == true) goto L13;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        p r100 = this.f70135i;
        if (r100 == null) goto L5;
        r100.f70176a.clear();
    L5:
        super.onDestroyView();
        ((LinkedHashMap) this.f70133g).clear();
    }

    public KtvFeedbackDialog() {
        this.f70133g = new LinkedHashMap();
        this.f70134h = "";
        this.f70137k = "ksong";
        this.f70140n = "";
        this.f70146t = ((Boolean) vm2.h.f556209p6.getValue(null, vm2.h.f556082a[378(0x17a, float:5.3E-43)])).booleanValue();
    }

    public static final void Y90(KtvFeedbackDialog r110) {
        if ((!((KtvFeedbackComponentView) r110.X90(R.id.feedback_categories)).getSelectedSet().isEmpty()) == false) goto L58;
        Iterator<String> r100 = ((KtvFeedbackComponentView) r110.X90(R.id.feedback_categories)).getSelectedSet().iterator();
        String r101 = "";
        String r102 = "";
    L6:
        if (r100.hasNext() == false) goto L9;
        r102 = r102 + r100.next() + ',';
        goto L6
    L9:
        if (StringsKt.endsWith$default(r102, ",", false, 2, null) == false) goto L11;
        r102 = r102.substring(0, r102.length() - 1);
    L11:
        String r111 = r102;
        Editable r112 = ((EditText) r110.X90(R.id.issue_detail)).getText();
        if (r112 == null) goto L14;
        String r113 = r112.toString();
    L15:
        if (r113 != null) goto L17;
    L20:
        boolean r114 = true;
    L21:
        if (r114 == false) goto L29;
        Iterator<String> r103 = ((KtvFeedbackComponentView) r110.X90(R.id.feedback_issues)).getSelectedSet().iterator();
    L24:
        if (r103.hasNext() == false) goto L27;
        r101 = r101 + r103.next() + ',';
        goto L24
    L27:
        if (StringsKt.endsWith$default(r101, ",", false, 2, null) == false) goto L35;
        String r115 = r101.substring(0, r101.length() - 1);
    L37:
        if (r110.f70146t == true) goto L39;
    L46:
        p r116 = r110.f70135i;
        if (r116 == null) goto L64;
        r116.a("", r110.f70136j, r110.f70137k, "", "", r111, r115);
        return;
    L64:
        return;
    L39:
        if (mz.c.b(r115) == false) goto L46;
        r110.dismiss();     // Catch: Exception -> L42
        return;
    L42:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r104 = DialogFragmentLancet.sLastShowStack;
        if (r104 == null) goto L62;
        com.bytedance.crash.d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L62:
        return;
    L35:
        r115 = r101;
        goto L37
    L29:
        Editable r105 = ((EditText) r110.X90(R.id.issue_detail)).getText();
        if (r105 == null) goto L35;
        String r106 = r105.toString();
        if (r106 == null) goto L35;
        r101 = r106;
        goto L35
    L17:
        if (r113.length() == 0) goto L20;
        r114 = false;
        goto L21
    L14:
        r113 = null;
        goto L15
    L58:
        r110.dismiss();     // Catch: Exception -> L51
        return;
    L51:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r107 = DialogFragmentLancet.sLastShowStack;
        if (r107 == null) goto L66;
        com.bytedance.crash.d.d(r107, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final View X90(int r100) {
        if (this.f70133g != null) goto L5;
        this.f70133g = new LinkedHashMap();
    L5:
        View r101 = this.f70133g.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f70133g.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        Window r102 = r101.getWindow();
        if (r102 == null) goto L5;
        r102.setSoftInputMode(32);
    L5:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        ViewGroup.LayoutParams r100 = null;
        if (this.f70142p == false) goto L6;
        ((TextView) X90(R.id.ktv_feedback_title1)).setText(R.string.ttlive_ksong_turn_off_confirm_title);
        ((TextView) X90(R.id.ktv_feedback_title2)).setText(R.string.ttlive_ksong_turn_off_tips);
    L45:
        ((KtvFeedbackComponentView) X90(R.id.feedback_categories)).setOnIssueSelectListener(new KtvFeedbackDialog$initView$1(this));
        ((KtvFeedbackComponentView) X90(R.id.feedback_issues)).setOnIssueSelectListener(new KtvFeedbackDialog$initView$2(this));
        ((TextView) X90(R.id.ktv_feedback_finish)).setOnClickListener(x0.a(new KtvFeedbackDialog$initView$3(this)));
        ((TextView) X90(R.id.ktv_feedback_cancel)).setOnClickListener(x0.a(new KtvFeedbackDialog$initView$4(this)));
        TextView r101 = (TextView) X90(R.id.ktv_feedback_finish);
        if (r101 == null) goto L57;
        TextView r112 = (TextView) X90(R.id.ktv_feedback_finish);
        if (r112 == null) goto L55;
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if (r113 == null) goto L55;
        if (com.bytedance.android.livesdk.m.c() == false) goto L54;
        r113.width = (int) (r113.width / com.bytedance.android.livesdk.m.b());
        r113.height = (int) (r113.height / com.bytedance.android.livesdk.m.b());
    L54:
        Unit r102 = Unit.INSTANCE;
    L56:
        r101.setLayoutParams(r113);
    L55:
        r113 = null;
    L57:
        TextView r114 = (TextView) X90(R.id.ktv_feedback_cancel);
        if (r114 == null) goto L68;
        TextView r103 = (TextView) X90(R.id.ktv_feedback_cancel);
        if (r103 == null) goto L67;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L67;
        if (com.bytedance.android.livesdk.m.c() == false) goto L66;
        r104.width = (int) (r104.width / com.bytedance.android.livesdk.m.b());
        r104.height = (int) (r104.height / com.bytedance.android.livesdk.m.b());
    L66:
        Unit r105 = Unit.INSTANCE;
        r100 = r104;
    L67:
        r114.setLayoutParams(r100);
    L68:
        X90(R.id.close_mask).setOnClickListener(new f(this));
        ((EditText) X90(R.id.issue_detail)).addTextChangedListener(new g(this));
        if (this.f70145s == false) goto L86;
        TextView r106 = (TextView) X90(R.id.ktv_feedback_title1);
        if (r106 == null) goto L73;
        r106.setText(s1.B(R.string.ttlive_ktv_feedback_dialog_title));
    L73:
        ((TextView) X90(R.id.ktv_feedback_title2)).setText(R.string.ttlive_ktv_guest_disconnect_feedback_confirm_info);
        LinearLayout r107 = (LinearLayout) X90(R.id.ktv_feedback_finish_container);
        if (r107 == null) goto L76;
        r107.setVisibility(8);
    L76:
        Button r108 = (Button) X90(R.id.ttlive_submit);
        if (r108 == null) goto L79;
        r108.setVisibility(0);
    L79:
        Button r109 = (Button) X90(R.id.ttlive_submit);
        if (r109 == null) goto L82;
        r109.setAlpha(0.34f);
    L82:
        Button r115 = (Button) X90(R.id.ttlive_submit);
        if (r115 == null) goto L88;
        r115.setOnClickListener(new c(this));
    L88:
        p r116 = new p();
        this.f70135i = r116;
        NextLiveData<List<com.bytedance.android.livesdk.rank.model.b>> r117 = r116.f70177b;
        if (r117 == null) goto L91;
        r117.observe(this, new d(this));
    L91:
        p r118 = this.f70135i;
        if (r118 == null) goto L94;
        r118.b(this.f70136j, this.f70137k);
    L94:
        p r119 = this.f70135i;
        if (r119 == null) goto L99;
        NextLiveData<Boolean> r120 = r119.f70178c;
        if (r120 == null) goto L99;
        r120.observe(this, new e(this));
    L99:
        pb0.a r121 = pb0.b.f528406a;
        boolean r122 = this.f70142p;
        pb0.a r123 = pb0.b.f528406a;
        if (r123 == null) goto L102;
        r123.w(r122);
    L102:
        ViewGroup r124 = (ViewGroup) r110.findViewById(R.id.container);
        TextView r125 = (TextView) r110.findViewById(R.id.ktv_feedback_title1);
        TextView r126 = (TextView) r110.findViewById(R.id.ktv_feedback_title2);
        KtvOrderSongThemeManager.b(r124, 1);
        if (r125 == null) goto L105;
        KtvOrderSongThemeManager.d(r125, 10);
    L105:
        if (r126 == null) goto L107;
        KtvOrderSongThemeManager.d(r126, KtvOrderSongThemeManager.f70192a);
    L107:
        KtvOrderSongThemeManager.c(X90(R.id.issue_detail), KtvOrderSongThemeManager.f70195d);
        ((EditText) X90(R.id.issue_detail)).setHintTextColor(KtvOrderSongThemeManager.a(KtvOrderSongThemeManager.f70194c));
        ((EditText) X90(R.id.issue_detail)).setTextColor(KtvOrderSongThemeManager.a(10));
        return;
    L86:
        if (this.f70146t == false) goto L88;
        ((TextView) X90(R.id.tv_feedback_exhibition)).setVisibility(0);
        ((TextView) X90(R.id.tv_feedback_exhibition)).setOnClickListener(new b(this));
        goto L88
    L6:
        if (this.f70144r == false) goto L26;
        com.bytedance.android.livesdk.chatroom.o r127 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r127 == null) goto L10;
        Boolean r128 = r127.isAnchor();
    L12:
        if (Intrinsics.areEqual(r128, Boolean.TRUE) == true) goto L14;
        ((TextView) X90(R.id.ktv_feedback_title1)).setText(R.string.ttlive_real_time_chorus_room_feedback_title_for_guest);
        ((TextView) X90(R.id.ktv_feedback_title2)).setText(R.string.ttlive_real_time_chorus_guest_disconnect_feedback_confirm_info);
        goto L45
    L14:
        if (Intrinsics.areEqual(this.f70134h, "scene_panel") == false) goto L16;
    L19:
        boolean r129 = true;
    L21:
        if (r129 == false) goto L23;
        ((TextView) X90(R.id.ktv_feedback_title1)).setText(R.string.ttlive_real_time_chorus_switch_to_radio_hint);
        ((TextView) X90(R.id.ktv_feedback_title2)).setText(R.string.ttlive_real_time_chorus_turn_off_tips);
        goto L45
    L23:
        ((TextView) X90(R.id.ktv_feedback_title1)).setText(R.string.ttlive_real_time_chorus_turn_off_confirm_title);
        ((TextView) X90(R.id.ktv_feedback_title2)).setText(R.string.ttlive_real_time_chorus_turn_off_tips);
        goto L45
    L16:
        if (Intrinsics.areEqual(this.f70134h, "link_panel") == true) goto L19;
        r129 = false;
        goto L21
    L10:
        r128 = null;
        goto L12
    L26:
        if (this.f70143q == false) goto L45;
        com.bytedance.android.livesdk.chatroom.o r130 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r130 == null) goto L30;
        Boolean r131 = r130.isAnchor();
    L32:
        if (Intrinsics.areEqual(r131, Boolean.TRUE) == true) goto L34;
        ((TextView) X90(R.id.ktv_feedback_title1)).setText(R.string.ttlive_ktv_room_feedback_title_for_guest);
        ((TextView) X90(R.id.ktv_feedback_title2)).setText(R.string.ttlive_ktv_guest_disconnect_feedback_confirm_info);
        goto L45
    L34:
        if (Intrinsics.areEqual(this.f70134h, "scene_panel") == false) goto L36;
    L39:
        boolean r132 = true;
    L41:
        if (r132 == false) goto L43;
        ((TextView) X90(R.id.ktv_feedback_title1)).setText(R.string.ttlive_ktv_switch_to_radio_hint);
        ((TextView) X90(R.id.ktv_feedback_title2)).setText(R.string.ttlive_ktv_turn_off_tips);
        goto L45
    L43:
        ((TextView) X90(R.id.ktv_feedback_title1)).setText(R.string.ttlive_ktv_turn_off_confirm_title);
        ((TextView) X90(R.id.ktv_feedback_title2)).setText(R.string.ttlive_ktv_turn_off_tips);
        goto L45
    L36:
        if (Intrinsics.areEqual(this.f70134h, "link_panel") == true) goto L39;
        r132 = false;
        goto L41
    L30:
        r131 = null;
        goto L32
    }
}
