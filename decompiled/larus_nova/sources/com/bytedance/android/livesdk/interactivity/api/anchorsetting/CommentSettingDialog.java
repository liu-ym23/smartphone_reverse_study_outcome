package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.config.ol;
import com.bytedance.android.livesdk.utils.b1;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import r52.d2;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/anchorsetting/CommentSettingDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentSettingDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f132806t = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f132807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f132808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f132809f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DataCenter f132810g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f132811h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ListDialogAbility f132812i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f132813j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f132814k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f132815l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, String> f132816m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<Integer, Integer> f132817n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<Integer, Integer> f132818o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f132819p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f132820q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f132821r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f132822s;

    public static final class a {
        public static void a(CommentSettingDialog r100, FragmentManager r101) {
            LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, "CommentSettingDialog", r102);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
            return;
        L9:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r100.showNow(r101, "CommentSettingDialog");
        }
    }

    static {
    }

    public CommentSettingDialog() {
        this.f132807d = new LinkedHashMap();
        this.f132815l = "";
        this.f132816m = new LinkedHashMap();
        Integer r100 = Integer.valueOf(R.id.follow_no);
        Integer r101 = Integer.valueOf(R.id.follow_only);
        Integer r102 = Integer.valueOf(R.id.follow_three);
        this.f132817n = MapsKt.mapOf(new Pair[]{TuplesKt.to(r100, 9), TuplesKt.to(r101, 3), TuplesKt.to(r102, 5)});
        this.f132818o = MapsKt.mapOf(new Pair[]{TuplesKt.to(9, r100), TuplesKt.to(3, r101), TuplesKt.to(5, r102)});
        com.bytedance.android.livesdk.sharedpref.e<Integer> r103 = com.bytedance.android.livesdk.sharedpref.b.W0;
        this.f132819p = r103.getValue().intValue();
        this.f132820q = r103.getValue().intValue();
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f132807d.clear();
    }

    public final View S90(int r100) {
        if (this.f132807d != null) goto L5;
        this.f132807d = new LinkedHashMap();
    L5:
        View r101 = this.f132807d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f132807d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    public final void T90(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onDismiss(r100);
        Ref.IntRef r101 = new Ref.IntRef();
        int r102 = this.f132820q;
        r101.element = r102;
        if (r102 != this.f132819p) goto L5;
        return;
    L5:
        if (this.f132822s == true) goto L10;
        this.f132822s = true;
        AudioCommentApi.a.a((AudioCommentApi) com.bytedance.android.live.network.c.b().e(AudioCommentApi.class), this.f132811h, 46, r101.element).compose(RxUtil.rxSchedulerHelper()).subscribe(new l(this, r101), m.f132865a);
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_CommonRightDialogWithNotFullScreen);
        setAnimationType("right");
        setShouldUseNewPanel(true);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        T90(r100);     // Catch: Throwable -> L5
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
    public final void onViewCreated(final View r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r110);
        int r111 = b1.f158888a;
        b1.b(true, new CommentSettingDialog$initDialogUI$1(r100));
        ConstraintLayout r112 = (ConstraintLayout) S90(R.id.paid_live_comment_setting_layout);
        int r101 = 0;
        if (this.f132813j == false) goto L5;
        int r102 = 0;
    L6:
        r112.setVisibility(r102);
        ((LiveSwitchButton) S90(R.id.paid_live_comment_setting_switch)).setChecked(com.bytedance.android.livesdk.sharedpref.b.f158124b1.getValue().booleanValue());
        ((LiveSwitchButton) S90(R.id.paid_live_comment_setting_switch)).setOnCheckedChangeListener(new d(this));
        ((TextView) S90(R.id.pre_setting_info_title)).setVisibility(0);
        ((ConstraintLayout) S90(R.id.comment_setting_comment_layout)).setVisibility(0);
        ((RadioGroup) S90(R.id.group_follow)).setVisibility(0);
        LiveSwitchButton r103 = (LiveSwitchButton) S90(R.id.comment_setting_switch);
        com.bytedance.android.livesdk.sharedpref.e<Integer> r104 = com.bytedance.android.livesdk.sharedpref.b.W0;
        Integer r105 = r104.getValue();
        if (r105 != null) goto L10;
    L11:
        boolean r106 = true;
    L13:
        r103.setChecked(r106);
        LinearLayout r107 = (LinearLayout) S90(R.id.comment_setting_detail);
        Integer r108 = r104.getValue();
        if (r108 != null) goto L17;
    L18:
        int r109 = 0;
    L20:
        r107.setVisibility(r109);
        ((LiveSwitchButton) S90(R.id.comment_setting_switch)).setOnCheckedChangeListener(new e(this));
        Integer r113 = r104.getValue();
        if (r113 != null) goto L24;
    L25:
        Integer r114 = this.f132818o.get(r104.getValue());
        if (r114 == null) goto L28;
        ((RadioGroup) S90(R.id.group_follow)).check(r114.intValue());
    L28:
        ((RadioGroup) S90(R.id.group_follow)).setOnCheckedChangeListener(new f(this));
        com.bytedance.android.livesdk.sharedpref.e<Integer> r115 = com.bytedance.android.livesdk.sharedpref.b.f158129c1;
        Integer r116 = r115.getValue();
        if (r116 != null) goto L32;
    L33:
        ((ConstraintLayout) S90(R.id.room_channel_setting_layout)).setVisibility(0);
        ((TextView) S90(R.id.room_channel_info_title)).setVisibility(0);
        S90(R.id.room_channel_divider).setVisibility(0);
    L35:
        LiveSwitchButton r117 = (LiveSwitchButton) S90(R.id.room_channel_switch);
        Integer r118 = r115.getValue();
        if (r118 != null) goto L39;
    L41:
        boolean r119 = false;
    L42:
        r117.setChecked(r119);
        ((LiveSwitchButton) S90(R.id.room_channel_switch)).setOnCheckedChangeListener(new g(this));
        DataCenter r120 = this.f132810g;
        if (this.f132809f == false) goto L45;
        boolean r121 = com.bytedance.android.livesdk.sharedpref.b.Y0.getValue().booleanValue();
        ((LiveSwitchButton) S90(R.id.audio_setting_switch)).setChecked(r121);
        ((LiveSwitchButton) S90(R.id.audio_auto_setting_switch)).setChecked(com.bytedance.android.livesdk.sharedpref.b.Z0.getValue().booleanValue());
    L57:
        ((LiveSwitchButton) S90(R.id.audio_setting_switch)).setOnCheckedChangeListener(new h(this, r120));
        ConstraintLayout r122 = (ConstraintLayout) S90(R.id.comment_setting_audio_auto_layout);
        if (r121 == false) goto L60;
        int r123 = 0;
    L61:
        r122.setVisibility(r123);
        ((LiveSwitchButton) S90(R.id.audio_auto_setting_switch)).setOnCheckedChangeListener(new i(this, r120));
        if (ol.f120914a.getValue().intValue() <= 1) goto L73;
        S90(R.id.pre_setting_info_video_title_divider).setVisibility(0);
        ((TextView) S90(R.id.pre_setting_video_title)).setVisibility(0);
        ((ConstraintLayout) S90(R.id.comment_setting_video_layout)).setVisibility(0);
        if (this.f132809f == false) goto L66;
        ((LiveSwitchButton) S90(R.id.video_setting_switch)).setChecked(com.bytedance.android.livesdk.sharedpref.b.f158119a1.getValue().booleanValue());
    L72:
        ((LiveSwitchButton) S90(R.id.video_setting_switch)).setOnCheckedChangeListener(new j(this, r120));
    L74:
        ConstraintLayout r124 = (ConstraintLayout) S90(R.id.goto_privilege_setting_paid_layout);
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r125 = com.bytedance.android.livesdk.sharedpref.b.f158139e1;
        if (r125.getValue().booleanValue() == true) goto L78;
        r101 = 8;
    L78:
        r124.setVisibility(r101);
        d2 r126 = d2.f536166a;
        if ((!Intrinsics.areEqual(r126.getValue(), Boolean.TRUE)) == false) goto L81;
    L82:
        S90(R.id.pre_setting_info_title_divider).setVisibility(8);
        ((ConstraintLayout) S90(R.id.privilege_barrage_setting_layout)).setVisibility(8);
        ((TextView) S90(R.id.pre_setting_function_title)).setVisibility(8);
        ((ConstraintLayout) S90(R.id.goto_privilege_setting_paid_layout)).setVisibility(8);
    L84:
        if (r126.getValue().booleanValue() == false) goto L88;
        ((LiveSwitchButton) S90(R.id.privilege_barrage_switch)).setChecked(r125.getValue().booleanValue());
        ((LiveSwitchButton) S90(R.id.privilege_barrage_switch)).setOnCheckedChangeListener(new k(this));
        TextView r127 = (TextView) S90(R.id.anchor_backtrack_setting_tips_tv);
        if (r127 == null) goto L88;
        r127.setSelected(true);
    L88:
        ((ConstraintLayout) S90(R.id.goto_privilege_setting_paid_layout)).setOnClickListener(new c(this));
        return;
    L81:
        if (this.f132808e == false) goto L84;
    L66:
        if (r120 == null) goto L70;
        Boolean r128 = (Boolean) r120.get("data_room_video_comment_share_enable", Boolean.TRUE);
        if (r128 == null) goto L70;
        boolean r129 = r128.booleanValue();
    L71:
        ((LiveSwitchButton) S90(R.id.video_setting_switch)).setChecked(r129);
    L70:
        r129 = true;
        goto L71
    L73:
        S90(R.id.pre_setting_info_video_title_divider).setVisibility(8);
        ((TextView) S90(R.id.pre_setting_video_title)).setVisibility(8);
        ((ConstraintLayout) S90(R.id.comment_setting_video_layout)).setVisibility(8);
        goto L74
    L60:
        r123 = 8;
        goto L61
    L45:
        if (r120 == null) goto L49;
        Boolean r130 = (Boolean) r120.get("data_room_audio_comment_enable", Boolean.TRUE);
        if (r130 == null) goto L49;
        r121 = r130.booleanValue();
    L50:
        ((LiveSwitchButton) S90(R.id.audio_setting_switch)).setChecked(r121);
        LiveSwitchButton r131 = (LiveSwitchButton) S90(R.id.audio_auto_setting_switch);
        if (r120 == null) goto L55;
        Boolean r132 = (Boolean) r120.get("data_room_audio_comment_auto_play", Boolean.TRUE);
        if (r132 == null) goto L55;
        boolean r133 = r132.booleanValue();
    L56:
        r131.setChecked(r133);
    L55:
        r133 = true;
    L49:
        r121 = true;
        goto L50
    L39:
        if (r118.intValue() != 1) goto L41;
        r119 = true;
        goto L42
    L32:
        if (r116.intValue() != 0) goto L33;
        ((ConstraintLayout) S90(R.id.room_channel_setting_layout)).setVisibility(8);
        ((TextView) S90(R.id.room_channel_info_title)).setVisibility(8);
        S90(R.id.room_channel_divider).setVisibility(8);
        goto L35
    L24:
        if (r113.intValue() == 1) goto L28;
    L17:
        if (r108.intValue() != 1) goto L18;
        r109 = 8;
        goto L20
    L10:
        if (r105.intValue() != 1) goto L11;
        r106 = false;
        goto L13
    L5:
        r102 = 8;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_comment_setting, r101, false);
    }
}
