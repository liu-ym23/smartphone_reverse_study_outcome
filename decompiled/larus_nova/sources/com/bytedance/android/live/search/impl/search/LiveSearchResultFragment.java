package com.bytedance.android.live.search.impl.search;

import am2.x;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.search.impl.search.adapter.LiveSearchResultAdapter;
import com.bytedance.android.live.search.impl.search.model.LiveSearchResultParam;
import com.bytedance.android.live.search.impl.search.viewmodel.LiveSearchIntermediateViewModel;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.dr0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/LiveSearchResultFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lpa1/a;", "Lcom/bytedance/android/live/search/impl/search/LiveSearchIntermediateView$c;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchResultFragment extends BaseFragment implements pa1.a, LiveSearchIntermediateView.c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static int f100627x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static String f100628y;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LiveSearchIntermediateView f100629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LiveSearchContainerFragment f100630e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f100631f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EditText f100632g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f100633h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f100634i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f100635j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f100636k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ViewGroup f100637l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f100638m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f100639n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f100640o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LiveSearchIntermediateViewModel f100641p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f100642q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public pa1.d f100643r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public k f100644s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f100645t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f100646u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f100647v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ViewGroup f100648w;

    public static final class a {
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, tw2.b
    public final String getSpm() {
        return "a100.a218";
    }

    @Override // pa1.a
    public final void iV(long r100) {
    }

    static {
        f100627x = -1;
        f100628y = "";
    }

    public static String S90() {
        String[] r100 = dr0.f120059a.getValue();
        if (r100 != null) goto L5;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == false) goto L16;
        f100627x = -1;
        String r102 = s1.B(R.string.ttlive_please_input_search_keyword);
        f100628y = r102;
        return r102;
    L16:
        if (f100627x >= 0) goto L19;
        f100627x = (int) (System.currentTimeMillis() % ((long) r100.length));
    L19:
        if (f100627x < r100.length) goto L21;
        f100627x = 0;
    L21:
        int r103 = f100627x;
        String r104 = r100[r103];
        f100628y = r104;
        f100627x = r103 + 1;
        return r104;
    L5:
        if (r100.length != 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L11;
        r101 = false;
        goto L12
    L7:
        r105 = false;
        goto L8
    }

    public final void W90() {
        LiveSearchIntermediateView r100 = this.f100629d;
        if (r100 == null) goto L20;
        LiveSearchIntermediateViewModel r101 = r100.f100619a;
        if (r101 == null) goto L9;
        NextLiveData<Integer> r102 = r101.getIntermediateState();
        if (r102 == null) goto L9;
        Integer r103 = r102.getValue();
    L10:
        if (r103 == null) goto L15;
        boolean r104 = true;
        if (r103.intValue() != 1) goto L15;
    L16:
        if (r104 == true) goto L20;
        r100.a();
        LiveSearchIntermediateViewModel r105 = r100.f100619a;
        if (r105 == null) goto L20;
        r105.openSearchSquare();
    L15:
        r104 = false;
    L9:
        r103 = null;
    L20:
        this.f100638m = 2;
        com.bytedance.android.live.search.impl.search.a.f100685e = 2;
        if (U90() == false) goto L31;
        LiveSearchContainerFragment r106 = this.f100630e;
        if (r106 == null) goto L32;
        LiveSearchResultAdapter r107 = r106.f100587f;
        if (r107 == null) goto L27;
        r107.y2(new ArrayList(), "");
    L27:
        LiveSearchResultAdapter r108 = r106.f100587f;
        if (r108 == null) goto L33;
        r108.notifyDataSetChanged();
        return;
    L33:
        return;
    L32:
        return;
    }

    public final void X90() {
        LiveSearchIntermediateView r100 = this.f100629d;
        if (r100 == null) goto L14;
        EditText r101 = this.f100632g;
        if (r101 == null) goto L10;
        Editable r102 = r101.getText();
        if (r102 == null) goto L10;
        String r103 = r102.toString();
        if (r103 == null) goto L10;
    L11:
        Intrinsics.checkNotNullParameter(r103, "keyword");
        r100.a();
        LiveSearchIntermediateViewModel r104 = r100.f100619a;
        if (r104 == null) goto L14;
        r104.openSearchSug(r103);
    L10:
        r103 = "";
    L14:
        this.f100638m = 2;
        com.bytedance.android.live.search.impl.search.a.f100685e = 2;
        if (U90() == false) goto L25;
        LiveSearchContainerFragment r105 = this.f100630e;
        if (r105 == null) goto L26;
        LiveSearchResultAdapter r106 = r105.f100587f;
        if (r106 == null) goto L21;
        r106.y2(new ArrayList(), "");
    L21:
        LiveSearchResultAdapter r107 = r105.f100587f;
        if (r107 == null) goto L27;
        r107.notifyDataSetChanged();
        return;
    L27:
        return;
    L26:
        return;
    }

    @Override // pa1.a
    public final void tl() {
        TextView r100 = this.f100636k;
        if (r100 == null) goto L5;
        r100.setText(S90());
    L5:
        int r101 = g.f100753a;
        g.a(f100628y, "search_bar_outer");
    }

    public LiveSearchResultFragment() {
        this.f100638m = 2;
        this.f100640o = "";
        this.f100647v = "live_merge";
    }

    public final boolean U90() {
        if (com.bytedance.android.livesdk.utils.landscape.b.b() == true) goto L7;
        return false;
    L7:
        return e5.n();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        int r100 = com.bytedance.android.live.search.impl.search.helper.a.f100772a;
        com.bytedance.android.live.search.impl.search.helper.a.a(this.f100632g);
        this.f100645t = false;
        LiveSearchIntermediateView r101 = this.f100629d;
        if (r101 == null) goto L7;
        LiveSearchIntermediateViewModel r102 = r101.f100619a;
        if (r102 == null) goto L7;
        r102.hideIntermediate();
    L7:
        this.f100640o = "";
        if (this.f100642q == true) goto L10;
        return;
    L10:
        if (this.f100638m != 1) goto L20;
        LiveSearchContainerFragment r103 = this.f100630e;
        if (r103 == null) goto L21;
        String r104 = com.bytedance.android.live.search.impl.search.a.f100681a;
        com.bytedance.android.live.search.impl.search.a.f100686f = r103.f100590i.f100761g;
        RecyclerView r105 = r103.f100585d;
        if (r105 == null) goto L16;
        RecyclerView.LayoutManager r106 = r105.getLayoutManager();
    L17:
        b90.b.b(r106);
        return;
    L16:
        r106 = null;
        goto L17
    L21:
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        int r100 = com.bytedance.android.live.search.impl.search.helper.a.f100772a;
        com.bytedance.android.live.search.impl.search.helper.a.a(this.f100632g);
    }

    @Override // pa1.a
    public final void Bp(boolean r100) {
        this.f100642q = r100;
        View r101 = this.f100635j;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        goto L9
    L6:
        r102 = 8;
    L9:
        if (this.f100642q == true) goto L12;
        com.bytedance.android.live.search.impl.search.a.f100686f = null;
        com.bytedance.android.live.search.impl.search.a.f100685e = 0;
        com.bytedance.android.live.search.impl.search.a.f100681a = "";
        com.bytedance.android.live.search.impl.search.a.f100682b = 0;
        com.bytedance.android.live.search.impl.search.a.f100683c = "";
        com.bytedance.android.live.search.impl.search.a.f100684d = 0;
        return;
    }

    @Override // pa1.a
    public final void OC(boolean r100) {
        S90();
        T90(!r100);
    }

    public final void T90(boolean r100) {
        if (this.f100642q == true) goto L10;
        Z90(true, !r100);
        int r101 = g.f100753a;
        HashMap r102 = new HashMap();
        r102.put("enter_from", "live_square");
        com.bytedance.android.livesdk.log.u.l().e("enter_search", r102, new Object[0]);
        HashMap r103 = new HashMap();
        if (e5.n() == false) goto L7;
        String r104 = "landscape";
    L8:
        r103.put("screen_direction", r104);
        r103.put("user_id", ((IUserService) jc1.k.n(IUserService.class)).user().n());
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_drawer_search_click", r103, new Object[]{Room.class});
        goto L10
    L7:
        r104 = "portrait";
    L10:
        if (this.f100645t == true) goto L12;
        this.f100644s = new k(this);
        return;
    L12:
        EditText r105 = this.f100632g;
        if (r105 == null) goto L15;
        r105.setCursorVisible(true);
    L15:
        EditText r106 = this.f100632g;
        if (r106 == null) goto L20;
        Editable r107 = r106.getText();
        if (r107 == null) goto L20;
        String r108 = r107.toString();
    L22:
        if (TextUtils.isEmpty(r108) == true) goto L24;
        X90();
        return;
    L24:
        W90();
        return;
    L20:
        r108 = null;
        goto L22
    }

    public final void Y90(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "inputContainer");
        this.f100631f = r100;
        this.f100632g = (EditText) r100.findViewById(R.id.et_search_kw);
        this.f100639n = r100.findViewById(R.id.btn_clear);
        this.f100635j = r100.findViewById(R.id.tv_search_textview);
        this.f100633h = r100.findViewById(R.id.iv_search);
        this.f100634i = r100.findViewById(R.id.lv_search_container);
        TextView r101 = (TextView) r100.findViewById(R.id.tv_search_tip);
        this.f100636k = r101;
        if (r101 == null) goto L5;
        r101.setImportantForAccessibility(4);
    L5:
        this.f100637l = (ViewGroup) r100.findViewById(R.id.fl_intput_hint_container);
        EditText r102 = this.f100632g;
        if (r102 == null) goto L8;
        r102.addTextChangedListener(new l(this));
    L8:
        EditText r103 = this.f100632g;
        if (r103 == null) goto L11;
        ViewCompat.setAccessibilityDelegate(r103, new LiveSearchResultFragment$initInputView$$inlined$let$lambda$1(this));
    L11:
        EditText r104 = this.f100632g;
        if (r104 == null) goto L14;
        r104.setOnTouchListener(new m(this));
    L14:
        View r105 = this.f100639n;
        if (r105 == null) goto L17;
        r105.setOnClickListener(new n(this));
    L17:
        View r106 = this.f100635j;
        if (r106 == null) goto L20;
        r106.setOnClickListener(new o(this));
    L20:
        EditText r107 = this.f100632g;
        if (r107 == null) goto L23;
        r107.setOnEditorActionListener(new p(this));
    L23:
        r3.a(this.f100639n, s1.B(R.string.ttlive_a11y_clear));
    }

    @Override // com.bytedance.android.live.search.impl.search.LiveSearchIntermediateView.c
    public final void d50(LiveSearchResultParam r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        if (this.f100642q == false) goto L6;
        V90(r100, false);
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L5;
        this.f100641p = (LiveSearchIntermediateViewModel) ViewModelProviders.of(r101).get(LiveSearchIntermediateViewModel.class);
        String r102 = com.bytedance.android.live.search.impl.search.a.f100681a;
        com.bytedance.android.live.search.impl.search.a.f100684d = r101.hashCode();
    L5:
        com.bytedance.android.livesdk.log.filter.o r103 = com.bytedance.android.livesdk.log.u.l().c(x.class);
        String r104 = com.bytedance.android.live.search.impl.search.a.f100681a;
        if (r103 == null) goto L12;
        Map<String, String> r105 = r103.getMap();
        if (r105 == null) goto L12;
        if (r105.containsKey("enter_from_merge") != true) goto L12;
        String r106 = r103.getMap().get("enter_from_merge");
    L13:
        com.bytedance.android.live.search.impl.search.a.f100683c = r106;
        Bundle r107 = getArguments();
        if (r107 == null) goto L16;
        r107.getString("search_init_keyword");
        this.f100646u = r107.getBoolean("home_refresh");
    L16:
        String r108 = "live_merge";
        if (TextUtils.isEmpty(com.bytedance.android.live.search.impl.search.a.f100683c) == false) goto L19;
        String r109 = "live_merge";
    L20:
        if (r109 == null) goto L23;
        r108 = r109;
    L23:
        this.f100647v = r108;
        return;
    L19:
        r109 = com.bytedance.android.live.search.impl.search.a.f100683c;
    L12:
        r106 = "";
        goto L13
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        k r101 = this.f100644s;
        if (r101 == null) goto L6;
        r101.run();
        return;
    }

    public final void V90(LiveSearchResultParam r110, boolean r111) {
        String r100 = r110.getKeyword();
        if (TextUtils.isEmpty(r110.getRealSearchWord()) == true) goto L5;
        r100 = r110.getRealSearchWord();
    L5:
        int r101 = com.bytedance.android.live.search.impl.search.helper.b.f100773a;
        if (TextUtils.isEmpty(r100) == false) goto L8;
        boolean r102 = true;
    L28:
        if (r102 == false) goto L30;
        r100 = null;
    L41:
        String r103 = "";
        if (TextUtils.isEmpty(r100) == false) goto L47;
        EditText r112 = this.f100632g;
        if (r112 == null) goto L91;
        r112.setText("");
        return;
    L91:
        return;
    L47:
        String r104 = r110.getKeyword();
        r110.setKeyword(r100);
        String r105 = com.bytedance.android.live.search.impl.search.a.f100681a;
        String r106 = r110.getKeyword();
        if (r106 == null) goto L51;
        r103 = r106;
    L51:
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        com.bytedance.android.live.search.impl.search.a.f100681a = r103;
        if (this.f100630e != null) goto L58;
        LiveSearchContainerFragment r107 = new LiveSearchContainerFragment();
        b r108 = new b();
        r108.f100719a = this.f100643r;
        String r109 = this.f100647v;
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r108.f100724f = r109;
        Unit r113 = Unit.INSTANCE;
        r107.f100592k = r108;
        r107.f100595n = this.f100646u;
        this.f100630e = r107;
        FragmentTransaction r114 = getChildFragmentManager().beginTransaction();
        LiveSearchContainerFragment r115 = this.f100630e;
        Intrinsics.checkNotNull(r115);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r114, r115, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, KtvSubElement.CONTAINER, R.id.fragment_container) == true) goto L57;
        r114 = r114.replace(R.id.fragment_container, r115, KtvSubElement.CONTAINER);
    L57:
        r114.commitAllowingStateLoss();
    L58:
        this.f100638m = 1;
        com.bytedance.android.live.search.impl.search.a.f100685e = 1;
        LiveSearchIntermediateView r116 = this.f100629d;
        if (r116 == null) goto L63;
        LiveSearchIntermediateViewModel r117 = r116.f100619a;
        if (r117 == null) goto L63;
        r117.hideIntermediate();
    L63:
        EditText r118 = this.f100632g;
        if (r118 == null) goto L66;
        r118.setText(r104);
    L66:
        View r119 = this.f100639n;
        if (r119 == null) goto L69;
        r119.setVisibility(0);
    L69:
        EditText r120 = this.f100632g;
        if (r120 == null) goto L72;
        r120.setCursorVisible(false);
    L72:
        int r121 = com.bytedance.android.live.search.impl.search.helper.a.f100772a;
        com.bytedance.android.live.search.impl.search.helper.a.a(this.f100632g);
        LiveSearchContainerFragment r122 = this.f100630e;
        if (r122 == null) goto L92;
        String r123 = r110.getKeyword();
        Intrinsics.checkNotNull(r123);
        r122.T90(r123, r111);
        return;
    L92:
        return;
    L30:
        if (r100 == null) goto L41;
        f r124 = f.f100749d;
        ra1.c r125 = new ra1.c(r100);
        r124.getClass();
        Intrinsics.checkNotNullParameter(r125, "history");
        List r126 = f.a();
        ArrayList r127 = new ArrayList();
        Iterator r128 = r126.iterator();
    L33:
        if (r128.hasNext() == false) goto L37;
        Object r129 = r128.next();
        if ((!TextUtils.equals(r125.a(), ((ra1.c) r129).a())) == false) goto L33;
        r127.add(r129);
        goto L33
    L37:
        List r130 = CollectionsKt.toMutableList(r127);
        ListProtector.add(r130, 0, r125);
        if (r130.size() <= 20) goto L40;
        r130 = r130.subList(0, 20);
    L40:
        f.b(r130);
        goto L41
    L8:
        if (r100 == null) goto L26;
        int r131 = r100.length() - 1;
        int r132 = 0;
        boolean r133 = false;
    L10:
        if (r132 > r131) goto L25;
        if (r133 == true) goto L13;
        int r134 = r132;
    L15:
        if (Intrinsics.compare(r100.charAt(r134), 32) > 0) goto L17;
        boolean r135 = true;
    L18:
        if (r133 == false) goto L19;
        if (r135 == false) goto L25;
        r131 = r131 - 1;
        goto L10
    L19:
        if (r135 == false) goto L20;
        r132 = r132 + 1;
        goto L10
    L20:
        r133 = true;
        goto L10
    L17:
        r135 = false;
        goto L18
    L13:
        r134 = r131;
    L25:
        String r136 = r100.subSequence(r132, r131 + 1).toString();
    L27:
        r102 = TextUtils.isEmpty(r136);
        goto L28
    L26:
        r136 = null;
        goto L27
    }

    public final void Z90(boolean r100, boolean r101) {
        pa1.d r102 = this.f100643r;
        if (r102 == null) goto L6;
        r102.a(r100);
    L6:
        if (r100 == false) goto L18;
        EditText r103 = this.f100632g;
        if (r103 == null) goto L10;
        r103.setHint(f100628y);
    L10:
        View r104 = this.f100633h;
        if (r104 == null) goto L13;
        r104.setVisibility(0);
    L13:
        View r105 = this.f100634i;
        if (r105 == null) goto L16;
        r105.setVisibility(8);
    L16:
        if (r101 == false) goto L33;
        int r106 = g.f100753a;
        g.a(f100628y, "search_bar_inner");
        return;
    L33:
        return;
    L18:
        EditText r107 = this.f100632g;
        if (r107 == null) goto L21;
        r107.setHint("");
    L21:
        TextView r108 = this.f100636k;
        if (r108 == null) goto L24;
        r108.setText(f100628y);
    L24:
        View r109 = this.f100633h;
        if (r109 == null) goto L27;
        r109.setVisibility(8);
    L27:
        View r110 = this.f100634i;
        if (r110 == null) goto L30;
        r110.setVisibility(0);
    L30:
        if (r101 == false) goto L35;
        int r111 = g.f100753a;
        g.a(f100628y, "search_bar_outer");
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ttlive_search_fragment_result_layout, r101, false);
        LiveSearchIntermediateView r104 = (LiveSearchIntermediateView) r103.findViewById(R.id.search_intermediate);
        this.f100629d = r104;
        if (r104 == null) goto L11;
        Intrinsics.checkNotNullParameter(this, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(this, "responder");
        FragmentActivity r105 = getActivity();
        r104.f100620b = this;
        r104.f100621c = getChildFragmentManager();
        if (r105 == null) goto L11;
        LiveSearchIntermediateViewModel r106 = (LiveSearchIntermediateViewModel) ViewModelProviders.of(r105).get(LiveSearchIntermediateViewModel.class);
        r104.f100619a = r106;
        if (r106 == null) goto L11;
        NextLiveData<Integer> r107 = r106.getIntermediateState();
        if (r107 == null) goto L11;
        r107.observe(this, r104.f100624f);
    L11:
        LiveSearchIntermediateView r108 = this.f100629d;
        if (r108 == null) goto L14;
        r108.setOnDispatchTouchEventListener(new q(this));
    L14:
        LiveSearchIntermediateViewModel r109 = this.f100641p;
        if (r109 == null) goto L19;
        NextLiveData<String> r110 = r109.getInputValue();
        if (r110 == null) goto L19;
        r110.observe(this, new r(this));
    L19:
        this.f100645t = true;
        Bundle r111 = getArguments();
        if (r111 != null) goto L22;
    L24:
        ViewGroup r112 = this.f100631f;
        ViewGroup.LayoutParams r113 = null;
        if (r112 == null) goto L27;
        View r114 = r112.getChildAt(0);
    L28:
        if (r114 != null) goto L30;
    L32:
        EditText r115 = this.f100632g;
        if (r115 == null) goto L36;
        r115.setImeOptions(268435459);
    L36:
        if (U90() == false) goto L41;
        View r116 = this.f100635j;
        if (r116 == null) goto L41;
        r116.setPadding(s1.f(16.0f), 0, 0, 0);
    L41:
        if ("V2005A".equals(Build.MODEL) == true) goto L43;
    L52:
        k r117 = this.f100644s;
        if (r117 == null) goto L55;
        r117.run();
    L55:
        return r103;
    L43:
        if (puc.a.isVivoDevice() == false) goto L52;
        ViewGroup r118 = this.f100648w;
        if (r118 == null) goto L48;
        r113 = r118.getLayoutParams();
    L48:
        if ((r113 instanceof RelativeLayout.LayoutParams) == false) goto L52;
        ((RelativeLayout.LayoutParams) r113).topMargin = s1.f(25.0f);
        ViewGroup r119 = this.f100648w;
        if (r119 == null) goto L52;
        r119.setLayoutParams(r113);
        goto L52
    L30:
        if (U90() == false) goto L32;
        r114.setBackgroundResource(R.drawable.ttlive_search_input_bg_landscape);
        goto L32
    L27:
        r114 = null;
        goto L28
    L22:
        if (r111.getBoolean("bundle_need_show_input_container_inside", false) == false) goto L24;
        ViewGroup r120 = (ViewGroup) r103.findViewById(R.id.live_search_input_container);
        r120.setVisibility(0);
        View r121 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_search_input_layout, r120, false);
        r120.removeAllViews();
        r120.addView(r121);
        Y90(r120);
        this.f100648w = r120;
        goto L24
    }
}
