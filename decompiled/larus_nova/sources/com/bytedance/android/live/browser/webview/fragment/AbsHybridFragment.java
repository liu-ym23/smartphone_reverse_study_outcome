package com.bytedance.android.live.browser.webview.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.browser.container.HybridContainerManager;
import com.bytedance.android.live.browser.utils.LiveImmersedStatusBarUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.statusbar.IESStatusBarUtil;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdkapi.base.ILiveBrowserActivity;
import com.bytedance.android.livesdkapi.base.ILiveWebCommonApi;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import zg1.h1;

/* JADX INFO: loaded from: classes45.dex */
public abstract class AbsHybridFragment extends BaseFragment implements v40.c, ILiveWebCommonApi, com.bytedance.android.live.browser.jsbridge.f {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f64318w = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f64319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f64320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f64321f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f64322g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f64323h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f64324i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BaseHybridParamVo f64325j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f64326k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f64327l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f64328m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f64329n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f64330o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f64331p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f64332q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f64333r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f64334s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f64335t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f64336u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f64337v;

    public void U90() {
    }

    @Override // com.bytedance.android.live.browser.jsbridge.f
    public <T> void sendJsEvent(String r100, T r101) {
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer
    public final void close() {
        BaseHybridParamVo r100 = this.f64325j;
        if (r100.f100527i == false) goto L8;
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L23;
        r101.finish();
        return;
    L23:
        return;
    L8:
        if (r100.f100525g == true) goto L10;
        return;
    L10:
        if (getParentFragment() != null) goto L12;
        return;
    L12:
        if ((getParentFragment() instanceof DialogFragment) == true) goto L21;
        return;
    L21:
        ((DialogFragment) getParentFragment()).dismissAllowingStateLoss();     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L28;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public AbsHybridFragment() {
        this.f64319d = false;
        this.f64320e = false;
        this.f64322g = 0;
        Lazy r100 = HybridContainerManager.f62592a;
        this.f64337v = UUID.randomUUID().toString();
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer
    public final Activity getCurrentActivity() {
        return getActivity();
    }

    public final boolean isFullScreen() {
        if ((getActivity() instanceof ILiveBrowserActivity) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f64325j.f100525g == false) goto L8;
        return false;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        int r100 = t20.a.f544219a;
        xm0.a r101 = new xm0.a(this.f64323h, this.f64337v);
        ALogger.i("HybridEvent", r101.toString());
        xs2.b.a().post(r101);
        xs2.b.a().post(new h1(48));
        Lazy r102 = HybridContainerManager.f62592a;
        String r103 = this.f64337v;
        Intrinsics.checkNotNullParameter(r103, "containerId");
        ((HashMap) HybridContainerManager.f62592a.getValue()).remove(r103);
        ((ArrayList) p20.e.f527363b).clear();
        ((ArrayList) p20.e.f527364c).clear();
        p20.e.f527362a = "";
        ALogger.i("DebugHybridTools", "finishRecord");
        this.f64319d = false;
        View r104 = this.f64336u;
        if (r104 == null) goto L8;
        g r105 = this.f64321f;
        if (r105 == null) goto L9;
        r104.removeOnLayoutChangeListener(r105);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer
    public final String getContainerId() {
        return this.f64337v;
    }

    public void T90(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        BaseHybridParamVo r101 = (BaseHybridParamVo) r100.getParcelable("hybrid_pop_vo");
        this.f64325j = r101;
        if (r101 != null) goto L7;
        return;
    L7:
        this.f64324i = r101.f100533o;
        String r102 = r101.z();
        this.f64323h = r102;
        Uri r103 = UriProtector.parse(r102);
        UriProtector.parse(this.f64324i);
        String r104 = this.f64325j.D();
        int r105 = this.f64325j.f100530l;
        int r106 = ColorProtector.parseColor("#00FFFFFF");
        if (r105 != (-1)) goto L11;
        r105 = r106;
    L11:
        if (r103 != null) goto L29;
    L26:
        r106 = r105;
    L27:
        this.f64322g = r106;
        return;
    L29:
    L24:
        e = move-exception;
        ALogger.e("AbsHybridParamHelper", e);
        goto L27
    L13:
        if (TextUtils.isEmpty(r104) == true) goto L26;
        if (r104 != null) goto L16;
    L22:
        r106 = Color.parseColor(r104);     // Catch: Exception -> L24
        goto L27
    L16:
        if (r104.startsWith("#") == true) goto L22;
        if ("white".equals(r104) == true) goto L22;
        if ("black".equals(r104) == true) goto L22;
        r104 = "#".concat(r104);     // Catch: Exception -> L24
        goto L22
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        View r101 = getView();
        if (r101 == null) goto L72;
        this.f64326k = r101.findViewById(R.id.transparent_title_bar);
        this.f64328m = r101.findViewById(R.id.ttlive_activity_back);
        this.f64329n = r101.findViewById(R.id.ttlive_activity_close);
        this.f64330o = r101.findViewById(R.id.ttlive_activity_share);
        this.f64327l = r101.findViewById(R.id.title_bar);
        this.f64332q = r101.findViewById(R.id.back);
        this.f64331p = (TextView) r101.findViewById(R.id.title);
        this.f64333r = r101.findViewById(R.id.btn_share);
        this.f64335t = r101.findViewById(R.id.pull_down_close_indicator);
        this.f64334s = r101.findViewById(R.id.pull_down_close_indicator_container);
        if (this.f64331p == null) goto L10;
        TextView r102 = (TextView) this.f64327l.findViewById(R.id.title);
        this.f64331p = r102;
        r102.setText(null);
        String r103 = this.f64325j.s();
        TextView r104 = this.f64331p;
        if (r104 == null) goto L10;
        r104.setText(r103);
    L10:
        View r105 = this.f64328m;
        if (r105 == null) goto L15;
        UIUtils.setViewVisibility(r105, 8);
        this.f64328m.setOnClickListener(new a(this));
        if (isFullScreen() == false) goto L15;
        UIUtils.updateLayoutMargin(this.f64328m, -3, (int) UIUtils.dip2Px(getContext(), 30.0f), -3, -3);
    L15:
        View r106 = this.f64332q;
        if (r106 == null) goto L18;
        r106.setOnClickListener(new b(this));
    L18:
        View r107 = this.f64329n;
        if (r107 != null) goto L21;
    L25:
        View r108 = this.f64330o;
        if (r108 != null) goto L28;
    L34:
        View r109 = this.f64333r;
        if (r109 == null) goto L38;
        r109.setOnClickListener(new d(this));
    L38:
        if (this.f64335t == null) goto L55;
        if (this.f64334s == null) goto L55;
        if (this.f64325j.i() == false) goto L45;
    L53:
        this.f64334s.setVisibility(8);
        goto L55
    L45:
        if (this.f64325j.h() == false) goto L53;
        this.f64334s.setVisibility(0);
        if ("white".equals(this.f64325j.g()) == false) goto L50;
        this.f64335t.setBackgroundResource(R.drawable.ttlive_bg_pull_down_close_indicator_light);
        goto L55
    L50:
        if ("dark".equals(this.f64325j.g()) == false) goto L52;
        this.f64335t.setBackgroundResource(R.drawable.ttlive_bg_pull_down_close_indicator_dark);
        goto L55
    L52:
        this.f64335t.setBackgroundResource(R.drawable.ttlive_bg_pull_down_close_indicator_light);
    L55:
        if (this.f64327l != null) goto L57;
    L61:
        View r110 = this.f64326k;
        if (r110 == null) goto L64;
        r110.setVisibility(8);
    L64:
        isFullScreen();
        if (h.a(this.f64323h) == false) goto L72;
        if (fm3.d.b() == false) goto L72;
        this.f64327l.setBackgroundResource(R.drawable.ttlive_bg_titlebar_white);
        this.f64331p.setTextColor(-16777216);
        View r111 = this.f64332q;
        if ((r111 instanceof TextView) == false) goto L71;
        ((TextView) this.f64332q).setCompoundDrawables(getContext().getResources().getDrawable(R.drawable.ttlive_bg_black_return_selector), null, null, null);
        goto L72
    L71:
        r111.setBackgroundResource(R.drawable.ttlive_bg_black_return_selector);
        goto L72
    L57:
        if (this.f64331p == null) goto L61;
        if (this.f64325j.d() == false) goto L61;
        this.f64327l.setVisibility(8);
        this.f64331p.setVisibility(8);
        goto L61
    L28:
        if (this.f64325j.a() == false) goto L30;
        int r112 = 0;
    L31:
        UIUtils.setViewVisibility(r108, r112);
        this.f64330o.setOnClickListener(new c(this));
        if (isFullScreen() == false) goto L34;
        UIUtils.updateLayoutMargin(this.f64330o, -3, (int) UIUtils.dip2Px(getContext(), 30.0f), -3, -3);
        goto L34
    L30:
        r112 = 8;
        goto L31
    L21:
        if (this.f64325j.k() == false) goto L23;
        int r113 = 0;
    L24:
        UIUtils.setViewVisibility(r107, r113);
        this.f64329n.setOnClickListener(new e(this));
        goto L25
    L23:
        r113 = 8;
    L72:
        setCloseByGesture(!this.f64325j.b());
        this.f64319d = true;
        View r114 = getView();
        this.f64336u = r114;
        if (r114 == null) goto L80;
        this.f64321f = new g(this);
        if ((r114.getParent() instanceof ViewGroup) == false) goto L79;
        ((ViewGroup) this.f64336u.getParent()).addOnLayoutChangeListener(this.f64321f);
        return;
    L79:
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r110) {
        super.onCreate(r110);
        T90(getArguments());
        FragmentActivity r111 = getActivity();
        if (r111 == null) goto L67;
        String r100 = "#FFFFFFFF";
        if (this.f64325j.r() == false) goto L26;
        boolean r101 = fm3.d.b();
        BaseHybridParamVo r102 = this.f64325j;
        if (r101 == false) goto L9;
        String r103 = "black";
    L10:
        r102.R(r103);
        BaseHybridParamVo r104 = this.f64325j;
        if (r101 == false) goto L13;
        String r105 = "white";
    L14:
        r104.O(r105);
        if (r101 == true) goto L18;
        r100 = "#00000000";
    L18:
        this.f64322g = ColorProtector.parseColor(r100);
        if ("white".equals(this.f64325j.q()) == false) goto L22;
        LiveImmersedStatusBarUtils.f(r111);
    L24:
        LiveImmersedStatusBarUtils.c(r111);
        h.b(r111, this.f64325j.o());
    L44:
        BaseHybridParamVo r106 = this.f64325j;
        if (r106.f100527i == true) goto L47;
    L57:
        BaseHybridParamVo r107 = this.f64325j;
        if (r107.f100527i == false) goto L67;
        if (r107.t() == false) goto L67;
        String r108 = this.f64325j.q();
        IESStatusBarUtil.transparencyBar(r111);
        if ("white".equals(r108) == false) goto L65;
        LiveImmersedStatusBarUtils.f(r111);
        goto L67
    L65:
        if ("black".equals(r108) == false) goto L67;
        LiveImmersedStatusBarUtils.g(r111);
        goto L67
    L47:
        if (r106.e() == false) goto L57;
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(getActivity(), false, false) == false) goto L56;
        String r109 = this.f64325j.q();
        IESStatusBarUtil.transparencyBar(r111);
        if ("white".equals(r109) == false) goto L54;
        LiveImmersedStatusBarUtils.f(r111);
        goto L67
    L54:
        if ("black".equals(r109) == false) goto L67;
        LiveImmersedStatusBarUtils.g(r111);
        goto L67
    L56:
        StatusBarUtil.hideStatusBar(getActivity());
        goto L67
    L22:
        if ("black".equals(this.f64325j.q()) == false) goto L24;
        LiveImmersedStatusBarUtils.g(r111);
        goto L24
    L13:
        r105 = "black";
        goto L14
    L9:
        r103 = "white";
        goto L10
    L26:
        if (h.a(this.f64323h) == true) goto L28;
    L30:
        boolean r112 = false;
    L31:
        String r113 = this.f64325j.q();
        String r114 = this.f64325j.o();
        boolean r115 = this.f64325j.e();
        boolean r116 = this.f64325j.t();
        if (r112 == false) goto L35;
        LiveImmersedStatusBarUtils.g(r111);
        LiveImmersedStatusBarUtils.c(r111);
        h.b(r111, "#FFFFFFFF");
        goto L44
    L35:
        if ("white".equals(r113) == false) goto L38;
        LiveImmersedStatusBarUtils.f(r111);
        LiveImmersedStatusBarUtils.c(r111);
    L43:
        h.b(r111, r114);
        goto L44
    L38:
        if ("black".equals(r113) == false) goto L43;
        LiveImmersedStatusBarUtils.g(r111);
        if (r115 == true) goto L43;
        if (r116 == true) goto L43;
        LiveImmersedStatusBarUtils.c(r111);
        goto L43
    L28:
        if (fm3.d.b() == false) goto L30;
        r112 = true;
    L67:
        Lazy r117 = HybridContainerManager.f62592a;
        String r118 = this.f64337v;
        Intrinsics.checkNotNullParameter(r118, "containerId");
        Intrinsics.checkNotNullParameter(this, KtvSubElement.CONTAINER);
        Lazy r119 = HybridContainerManager.f62592a;
        if (((HashMap) r119.getValue()).containsKey(r118) == true) goto L71;
        ((HashMap) r119.getValue()).put(r118, new WeakReference(this));
        return;
    }

    @Override // v40.a
    public final void setCloseByGesture(final boolean r100) {
        View r101 = getView();
        if (r101 == null) goto L6;
        r101.setFocusableInTouchMode(true);
        r101.requestFocus();
        r101.setOnKeyListener(new f(r100));
        return;
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer
    public final void setHybridTitle(String r100) {
        TextView r101 = this.f64331p;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public static void S90(AbsHybridFragment r100, boolean r101) {
        r100.getClass();
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L5
        r102.put("visible", r101);     // Catch: JSONException -> L5
        r100.sendJsEvent("H5_keyboardStatusChange", r102);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        b0 r103 = b0.o();
        StringBuilder r104 = new StringBuilder("sendKeyboardJsEvent error: ");
        if (TextUtils.isEmpty(e.getMessage()) == true) goto L9;
        String r105 = e.getMessage();
    L10:
        r104.append(r105);
        String r106 = r104.toString();
        r103.getClass();
        com.bytedance.android.live.core.log.g.a("AbsHybridFragment", r106);
        return;
    L9:
        r105 = "";
        goto L10
    }
}
