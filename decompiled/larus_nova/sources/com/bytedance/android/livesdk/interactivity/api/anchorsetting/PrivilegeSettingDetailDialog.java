package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.broadcast.api.LivePrivilegeSettingApi;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.utils.b1;
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

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/anchorsetting/PrivilegeSettingDetailDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PrivilegeSettingDetailDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f132828l = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f132829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Integer, Integer> f132830e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Integer, Integer> f132831f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Integer, Integer> f132832g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<Integer, Integer> f132833h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<Integer, Integer> f132834i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<Integer, Integer> f132835j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f132836k;

    public static final class a {
        public static void a(PrivilegeSettingDetailDialog r100, FragmentManager r101) {
            LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, "PrivilegeSettingDetailDialog", r102);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
            return;
        L9:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r100.showNow(r101, "PrivilegeSettingDetailDialog");
        }
    }

    static {
    }

    public PrivilegeSettingDetailDialog() {
        this.f132829d = new LinkedHashMap();
        Integer r100 = Integer.valueOf(R.id.follow_no);
        Integer r101 = Integer.valueOf(R.id.follow_only);
        Integer r102 = Integer.valueOf(R.id.followed_only);
        Integer r110 = Integer.valueOf(R.id.follow_three);
        Integer r111 = Integer.valueOf(R.id.follow_seven);
        Integer r112 = Integer.valueOf(R.id.follow_thirty);
        this.f132830e = MapsKt.mapOf(new Pair[]{TuplesKt.to(r100, 0), TuplesKt.to(r101, 1), TuplesKt.to(r102, 2), TuplesKt.to(r110, 3), TuplesKt.to(r111, 7), TuplesKt.to(r112, 30)});
        Integer r113 = Integer.valueOf(R.id.live_no);
        Integer r103 = Integer.valueOf(R.id.live_live);
        this.f132831f = MapsKt.mapOf(new Pair[]{TuplesKt.to(r113, 0), TuplesKt.to(r103, 1)});
        Integer r104 = Integer.valueOf(R.id.fans_no);
        this.f132832g = MapsKt.mapOf(new Pair[]{TuplesKt.to(r104, 0), TuplesKt.to(Integer.valueOf(R.id.fans_1), 1), TuplesKt.to(Integer.valueOf(R.id.fans_3), 3), TuplesKt.to(Integer.valueOf(R.id.fans_5), 5), TuplesKt.to(Integer.valueOf(R.id.fans_9), 9), TuplesKt.to(Integer.valueOf(R.id.fans_12), 12), TuplesKt.to(Integer.valueOf(R.id.fans_15), 15), TuplesKt.to(Integer.valueOf(R.id.fans_17), 17), TuplesKt.to(Integer.valueOf(R.id.fans_20), 20)});
        this.f132833h = MapsKt.mapOf(new Pair[]{TuplesKt.to(0, r100), TuplesKt.to(1, r101), TuplesKt.to(2, r102), TuplesKt.to(3, r110), TuplesKt.to(7, r111), TuplesKt.to(30, r112)});
        this.f132834i = MapsKt.mapOf(new Pair[]{TuplesKt.to(0, r113), TuplesKt.to(1, r103)});
        this.f132835j = MapsKt.mapOf(new Pair[]{TuplesKt.to(0, r104), TuplesKt.to(1, Integer.valueOf(R.id.fans_1)), TuplesKt.to(3, Integer.valueOf(R.id.fans_3)), TuplesKt.to(5, Integer.valueOf(R.id.fans_5)), TuplesKt.to(9, Integer.valueOf(R.id.fans_9)), TuplesKt.to(12, Integer.valueOf(R.id.fans_12)), TuplesKt.to(15, Integer.valueOf(R.id.fans_15)), TuplesKt.to(17, Integer.valueOf(R.id.fans_17)), TuplesKt.to(20, Integer.valueOf(R.id.fans_20))});
        setNoTitleAndCancelOutside(true);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.f132829d).clear();
    }

    public static final void T90(PrivilegeSettingDetailDialog r100) {
        r100.getClass();
        Integer r101 = com.bytedance.android.livesdk.sharedpref.b.f158144f1.getValue();
        Integer r102 = com.bytedance.android.livesdk.sharedpref.b.f158154h1.getValue();
        Integer r103 = com.bytedance.android.livesdk.sharedpref.b.f158149g1.getValue();
        ((LivePrivilegeSettingApi) com.bytedance.android.live.network.c.b().e(LivePrivilegeSettingApi.class)).setPrivilegeBarrageSetting(true, r101.intValue(), r102.intValue(), r103.intValue()).compose(RxUtil.rxSchedulerHelper()).subscribe(x.f132875a, y.f132876a);
    }

    public final View S90(int r100) {
        if (this.f132829d != null) goto L5;
        this.f132829d = new LinkedHashMap();
    L5:
        View r101 = this.f132829d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f132829d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_CommonRightDialogWithNotFullScreen);
        setAnimationType("right");
        setShouldUseNewPanel(true);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        return super.onCreateDialog(r100);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r100);     // Catch: Throwable -> L5
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
    public final void onViewCreated(final View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        int r102 = b1.f158888a;
        b1.b(true, new PrivilegeSettingDetailDialog$initDialogUI$1(this, r100));
        ((LivePrivilegeSettingApi) com.bytedance.android.live.network.c.b().e(LivePrivilegeSettingApi.class)).getPrivilegeBarrageSetting().compose(RxUtil.rxSchedulerHelper()).subscribe(new q(this), r.f132869a);
        ((RadioGroup) S90(R.id.group_follow)).setOnCheckedChangeListener(new s(this));
        ((RadioGroup) S90(R.id.group_live)).setOnCheckedChangeListener(new t(this));
        ((RadioGroup) S90(R.id.group_fans)).setOnCheckedChangeListener(new u(this));
        ((ImageView) S90(R.id.iv_active_desc)).setOnClickListener(v.f132873a);
        ((ImageView) S90(R.id.privilege_detail_setting_back)).setOnClickListener(new w(this));
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ttlive_dialog_privilege_detail_setting_interactivity, r101, false);
        this.f132836k = r103;
        return r103;
    }
}
