package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.linkpanel.contract.VideoTalkDialogContract$View;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/ApplyPermissionSwitchFragment;", "Lcom/bytedance/android/live/liveinteract/linkpanel/contract/VideoTalkDialogContract$View;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ApplyPermissionSwitchFragment extends VideoTalkDialogContract$View {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f74455o = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<Integer, View> f74456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f74457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f74458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public IRoom f74459j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f74460k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CompositeDisposable f74461l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f74462m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f74463n;

    public static final class a {
        @JvmStatic
        public static ApplyPermissionSwitchFragment a(yf0.g r100, IRoom r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "dialog");
            Intrinsics.checkNotNullParameter(r101, "room");
            ApplyPermissionSwitchFragment r103 = new ApplyPermissionSwitchFragment();
            r103.f74347d = r100;
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            r103.f74459j = r101;
            r103.f74460k = r102;
            return r103;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final float T90() {
        return 432.0f;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final String W90() {
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final ViewGroup X90() {
        ViewGroup r100 = this.f74458i;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L5:
        return r100;
    }

    public final boolean ca0() {
        if (((Boolean) vm2.d.M0.getValue(null, vm2.d.f555776a[88])).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f74460k == 3) goto L7;
        return true;
    }

    public final void ea0() {
        if (this.f74463n == false) goto L11;
        View r100 = this.f74457h;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L7:
        ((ImageView) r100.findViewById(R.id.iv_need_apply)).setVisibility(0);
        View r101 = this.f74457h;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L10:
        ((ImageView) r101.findViewById(R.id.iv_no_need_apply)).setVisibility(8);
        return;
    L11:
        View r102 = this.f74457h;
        if (r102 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L14:
        ((ImageView) r102.findViewById(R.id.iv_need_apply)).setVisibility(8);
        View r103 = this.f74457h;
        if (r103 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L17:
        ((ImageView) r103.findViewById(R.id.iv_no_need_apply)).setVisibility(0);
    }

    public ApplyPermissionSwitchFragment() {
        this.f74456g = new LinkedHashMap();
        this.f74461l = new CompositeDisposable();
        this.f74462m = true;
    }

    public final void da0() {
        if (ca0() == true) goto L5;
    L19:
        this.f74462m = true;
        View r100 = this.f74457h;
        if (r100 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L22:
        ((FrameLayout) r100.findViewById(R.id.fl_no_need_apply)).setAlpha(1.0f);
        View r101 = this.f74457h;
        if (r101 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L25:
        ((FrameLayout) r101.findViewById(R.id.fl_need_apply)).setAlpha(1.0f);
        ea0();
        return;
    L5:
        if (com.bytedance.android.livesdk.sharedpref.c.f158304s1.getValue().booleanValue() == false) goto L19;
        this.f74462m = false;
        View r102 = this.f74457h;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L9:
        ((FrameLayout) r102.findViewById(R.id.fl_no_need_apply)).setAlpha(0.4f);
        View r103 = this.f74457h;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L12:
        ((FrameLayout) r103.findViewById(R.id.fl_need_apply)).setAlpha(0.4f);
        View r104 = this.f74457h;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L15:
        ((ImageView) r104.findViewById(R.id.iv_need_apply)).setVisibility(8);
        View r105 = this.f74457h;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L18:
        ((ImageView) r105.findViewById(R.id.iv_no_need_apply)).setVisibility(8);
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.f74456g).clear();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        this.f74461l.dispose();
    }

    public final View aa0(int r100) {
        if (this.f74456g != null) goto L5;
        this.f74456g = new LinkedHashMap();
    L5:
        Map<Integer, View> r101 = this.f74456g;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        View r103 = (View) r102.get(Integer.valueOf(R.id.switch_only_accept_follower));
        if (r103 != null) goto L14;
        View r104 = getView();
        if (r104 == null) goto L12;
        View r105 = r104.findViewById(R.id.switch_only_accept_follower);
        if (r105 == null) goto L12;
        this.f74456g.put(Integer.valueOf(R.id.switch_only_accept_follower), r105);
        return r105;
    L12:
        return null;
    L14:
        return r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.HashMap] */
    public static final void ba0(ApplyPermissionSwitchFragment r100, boolean r101) {
        if (r100.f74462m == false) goto L17;
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        ?? r103 = new HashMap();
        r102.element = r103;
        r103.put("scene", Integer.valueOf(r100.f74460k));
        int r104 = r100.f74460k;
        if (r104 != 1) goto L8;
        ((HashMap) r102.element).put("big_party_accept_need_verified", Boolean.valueOf(r101));
        ((HashMap) r102.element).put("big_party_only_accept_follower_apply", Boolean.valueOf(((Switch) r100.aa0(R.id.switch_only_accept_follower)).isChecked()));
    L12:
        LinkApi r105 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r106 = r100.f74459j;
        if (r106 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L15:
        Disposable r107 = r105.updateSetting(r106.getId(), (HashMap) r102.element).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(r100, r102, r101));
        r100.f74461l.add(r107);
        return;
    L8:
        if (r104 != 3) goto L12;
        ((HashMap) r102.element).put("audio_chat_accept_need_verified", Boolean.valueOf(r101));
        ((HashMap) r102.element).put("audio_chat_only_accept_follower_apply", Boolean.valueOf(((Switch) r100.aa0(R.id.switch_only_accept_follower)).isChecked()));
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        int r103 = 0;
        this.f74457h = r100.inflate(R.layout.ttlive_dialog_interact_permission_setting, r101, false);
        View r104 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_multi_link_common_top_view, null);
        if (r104 == null) goto L56;
        ViewGroup r105 = (ViewGroup) r104;
        this.f74458i = r105;
        ((ImageView) r105.findViewById(R.id.back_view)).setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new ApplyPermissionSwitchFragment$initTopView$1(this)));
        ViewGroup r106 = this.f74458i;
        if (r106 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L7:
        ((TextView) r106.findViewById(R.id.title_tv)).setText(com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_interact_link_permission));
        int r107 = this.f74460k;
        boolean r108 = true;
        if (r107 != 1) goto L10;
        View r109 = this.f74457h;
        if (r109 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L19:
        ((Switch) r109.findViewById(R.id.switch_only_accept_follower)).setChecked(com.bytedance.android.livesdk.sharedpref.c.f158295p1.getValue().booleanValue());
        this.f74463n = com.bytedance.android.livesdk.sharedpref.c.f158307t1.getValue().booleanValue();
        ea0();
    L20:
        View r110 = this.f74457h;
        if (r110 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L23:
        ((Switch) r110.findViewById(R.id.switch_only_accept_follower)).setOnCheckedChangeListener(new b(this));
        View r111 = this.f74457h;
        if (r111 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L26:
        ((FrameLayout) r111.findViewById(R.id.fl_no_need_apply)).setOnClickListener(new c(this));
        View r112 = this.f74457h;
        if (r112 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L29:
        ((FrameLayout) r112.findViewById(R.id.fl_need_apply)).setOnClickListener(new d(this));
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.D() == false) goto L32;
    L35:
        if (r108 == false) goto L51;
        View r113 = this.f74457h;
        if (r113 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L40:
        FrameLayout r114 = (FrameLayout) r113.findViewById(R.id.fl_switch_only_join_through_invitation);
        if (ca0() == true) goto L44;
        r103 = 8;
    L44:
        r114.setVisibility(r103);
        View r115 = this.f74457h;
        if (r115 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L47:
        ((Switch) r115.findViewById(R.id.switch_only_join_through_invitation)).setChecked(com.bytedance.android.livesdk.sharedpref.c.f158304s1.getValue().booleanValue());
        View r116 = this.f74457h;
        if (r116 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L50:
        ((Switch) r116.findViewById(R.id.switch_only_join_through_invitation)).setOnCheckedChangeListener(new com.bytedance.android.live.liveinteract.linkpanel.fragment.a(this));
    L51:
        da0();
        View r117 = this.f74457h;
        if (r117 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L54:
        return r117;
    L32:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.C() == true) goto L35;
        r108 = false;
        goto L35
    L10:
        if (r107 != 3) goto L20;
        View r118 = this.f74457h;
        if (r118 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L15:
        ((Switch) r118.findViewById(R.id.switch_only_accept_follower)).setChecked(com.bytedance.android.livesdk.sharedpref.c.M0.getValue().booleanValue());
        this.f74463n = com.bytedance.android.livesdk.sharedpref.c.L0.getValue().booleanValue();
        ea0();
        goto L20
    L56:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
