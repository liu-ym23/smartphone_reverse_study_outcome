package com.bytedance.android.live.browser.webview.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.android.live.browser.di.H5Module_ProvideWebDialogFragmentFactory;
import com.bytedance.android.live.browser.t;
import com.bytedance.android.live.schema.convert.HybridType;
import com.bytedance.android.live.schema.convert.HybridUiType;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.live.schema.vo.LynxHybridParamVo;
import com.bytedance.android.live.schema.vo.PopupHybridParamVo;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import javax.inject.Provider;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class o implements n {
    public boolean A;
    public boolean B;
    public final int C;
    public BaseHybridParamVo.HybridType D;
    public final String E;
    public final JSONObject F;
    public final String G;
    public int H;
    public final boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f64385J;
    public boolean K;
    public boolean L;
    public String M;
    public Provider<BaseWebDialogFragment> N;
    public final String O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f64386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f64387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f64388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f64389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f64390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f64391f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f64392g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f64393h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f64394i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f64395j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f64396k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f64397l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f64398m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f64399n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f64400o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f64401p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f64402q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f64403r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public t f64404s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f64405t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f64406u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f64407v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f64408w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f64409x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f64410y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f64411z;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.n
    public final BaseWebDialogFragment build() {
        Provider<BaseWebDialogFragment> r100 = this.N;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dialogProvider");
    L5:
        BaseWebDialogFragment r101 = r100.get();
        Bundle r102 = new Bundle();
        String r103 = this.O;
        String r104 = this.M;
        int r105 = com.bytedance.android.live.schema.helper.a.f100513a;
        Parcelable r106 = ka1.b.a(new ia1.b(r103, UriProtector.parse(r104), null, null), new ia1.a(HybridType.COMMON, HybridUiType.FULLSCREEN), false);     // Catch: Exception -> L11
        if ((r106 instanceof BaseHybridParamVo) == true) goto L9;
        r106 = null;
    L9:
        BaseHybridParamVo r107 = (BaseHybridParamVo) r106;     // Catch: Exception -> L11
    L13:
        if (r107 == null) goto L15;
        r107.F();
    L15:
        if (r107 == null) goto L17;
        BaseHybridParamVo.HybridType r108 = this.D;
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r107.f100519a = r108;
    L17:
        if (r107 == null) goto L19;
        r107.f100520b = null;
    L19:
        if (r107 == null) goto L21;
        r107.f100521c = this.f64396k;
    L21:
        if (r107 == null) goto L23;
        r107.J(this.B);
    L23:
        if (r107 == null) goto L25;
        r107.K(this.f64409x);
    L25:
        if (r107 == null) goto L27;
        r107.L(this.f64408w);
    L27:
        if (r107 == null) goto L29;
        r107.I(this.f64411z);
    L29:
        if (r107 == null) goto L31;
        r107.E();
    L31:
        if (r107 == null) goto L33;
        r107.N(this.f64410y);
    L33:
        if (r107 == null) goto L35;
        r107.M(this.A);
    L35:
        if (r107 == null) goto L37;
        r107.f100522d = this.f64395j;
    L37:
        if (r107 == null) goto L43;
        Integer r109 = this.f64395j;
        if (r109 == null) goto L41;
        int r110 = r109.intValue();
    L42:
        r107.f100530l = r110;
        goto L43
    L41:
        r110 = -1;
    L43:
        if (r107 == null) goto L45;
        r107.S(this.O);
    L45:
        if (r107 == null) goto L47;
        r107.f100533o = this.M;
    L47:
        LynxHybridParamVo r410 = new LynxHybridParamVo(this.E, this.H, this.L, this.K, false, null, 104);
        int r111 = this.f64386a;
        int r112 = this.f64387b;
        int r113 = this.f64388c;
        int r114 = this.f64389d;
        int r115 = this.f64390e;
        int r116 = this.f64391f;
        int r117 = this.f64392g;
        int r118 = this.f64393h;
        int r119 = this.f64394i;
        boolean r120 = this.f64397l;
        boolean r121 = this.f64398m;
        boolean r122 = this.f64399n;
        boolean r123 = this.f64400o;
        boolean r124 = this.f64401p;
        boolean r125 = this.f64402q;
        boolean r126 = this.f64403r;
        int r127 = this.f64405t;
        int r128 = this.f64406u;
        int r129 = this.f64407v;
        int r130 = this.C;
        JSONObject r131 = this.F;
        if (r131 == null) goto L50;
        String r310 = r131.toString();
    L51:
        PopupHybridParamVo r132 = new PopupHybridParamVo(r111, r112, 0, 0, 0, 0, r113, r114, 0, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, false, r130, 0, null, r310, this.G, this.I, this.f64385J, this.K, 0.0f, 0, false, 0, r410, r107, false, null, 403177776, 3072);
        r102.putString("arg_url", this.O);
        r102.putString("arg_original_scheme", this.M);
        r102.putBoolean(AppConstants.ARG_ABANDON_COORDINATE, this.K);
        r102.putParcelable("hybrid_pop_vo", r132);
        Unit r133 = Unit.INSTANCE;
        r101.setArguments(r102);
        r101.T90(this.f64404s);
        return r101;
    L50:
        r310 = null;
    L11:
        e = move-exception;
        com.bytedance.android.live.schema.api.utils.a.c("HybridParamHelper", e);
        r107 = null;
        goto L13
    }

    public o(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.O = r100;
        this.f64396k = "";
        this.f64401p = true;
        this.f64403r = true;
        this.f64407v = -1;
        this.f64408w = true;
        this.C = -1;
        this.D = BaseHybridParamVo.HybridType.H5;
        this.E = "";
        this.G = "";
        this.I = true;
        this.f64385J = true;
        this.M = "";
        BrowserServiceImpl.Companion.getClass();
        H5Module_ProvideWebDialogFragmentFactory r101 = ((s20.b) BrowserServiceImpl.access$getDiComponent$cp()).f540219l;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.N = r101;
    }

    public final o a(int r100) {
        this.f64395j = Integer.valueOf(r100);
        return this;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.n
    public final o c(boolean r100) {
        this.K = r100;
        return this;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.n
    public final o d(int r100) {
        this.f64389d = r100;
        this.f64390e = 0;
        this.f64391f = 0;
        this.f64392g = 0;
        this.f64393h = 0;
        return this;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.n
    public final BaseWebDialogFragment e(PopupHybridParamVo r100) {
        Provider<BaseWebDialogFragment> r101 = this.N;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dialogProvider");
    L5:
        BaseWebDialogFragment r102 = r101.get();
        Bundle r103 = new Bundle();
        r103.putParcelable("hybrid_pop_vo", r100);
        r103.putString("arg_url", this.O);
        r103.putString("arg_original_scheme", this.M);
        r103.putBoolean(AppConstants.ARG_ABANDON_COORDINATE, this.K);
        Unit r104 = Unit.INSTANCE;
        r102.setArguments(r103);
        return r102;
    }

    public final o f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fromLabel");
        this.f64396k = r100;
        return this;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.n
    public final o setHeight(int r100) {
        this.f64387b = r100;
        return this;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.n
    public final o setWidth(int r100) {
        this.f64386a = r100;
        return this;
    }

    public o(String r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this(r100);
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.E = r101;
        this.F = r102;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.n
    public final o b(int r100, int r101, int r102, int r103) {
        this.f64390e = r100;
        this.f64391f = r101;
        this.f64392g = r102;
        this.f64393h = r103;
        return this;
    }
}
