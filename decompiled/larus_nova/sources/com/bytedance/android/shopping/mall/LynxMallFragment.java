package com.bytedance.android.shopping.mall;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.host.api.core.api.IECBulletService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.shopping.api.mall.p;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.LynxView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qf3.g;
import qf3.h;
import qf3.i;
import qf3.j;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/mall/LynxMallFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LynxMallFragment extends Fragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f176494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f176495e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f176496f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f176497g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f176498h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f176499i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f176500j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ti.d f176501k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.shopping.mall.b f176502l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<p> f176503m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final h f176504n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LynxView f176505o;

    public static final class a extends com.bytedance.android.shopping.mall.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LynxMallFragment f176506b;

        public a(LynxMallFragment r100) {
            this.f176506b = r100;
        }

        @Override // com.bytedance.android.shopping.mall.a, ti.e
        public final void onLoadSuccess(View r100) {
            int r101 = e.f176515a;
            e.a(this.f176506b.f176494d, "on template load success");
            this.f176506b.getClass();
            if ((r100 instanceof LynxView) == false) goto L5;
            this.f176506b.f176505o = (LynxView) r100;
        L5:
            LynxMallFragment r102 = this.f176506b;
            r102.getClass();
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L18
            LynxView r104 = r102.f176505o;     // Catch: Throwable -> L18
            Unit r105 = null;
            if (r104 == null) goto L9;
            View r106 = r104.findViewByName("list");     // Catch: Throwable -> L18
        L11:
            if ((r106 instanceof RecyclerView) == true) goto L14;
            r106 = null;
        L14:
            if (((RecyclerView) r106) == null) goto L16;
            r105 = Unit.INSTANCE;     // Catch: Throwable -> L18
        L16:
            Result.m9449constructorimpl(r105);     // Catch: Throwable -> L18
        L20:
            this.f176506b.S90(true, "");
            ti.d r107 = this.f176506b.f176501k;
            if (r107 == null) goto L32;
            int r108 = rf3.a.f537611a;
            JSONObject r109 = new JSONObject();     // Catch: JSONException -> L25
            r109.put("visible", false);     // Catch: JSONException -> L25
            r107.a(r109);     // Catch: JSONException -> L25
            return;
        L25:
            e = move-exception;
            e.toString();
            return;
        L32:
            return;
        L9:
            r106 = null;
        L18:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L20
        }

        @Override // com.bytedance.android.shopping.mall.a, ti.e
        public final void onFallback(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "errorMessage");
            int r102 = e.f176515a;
            e.a(this.f176506b.f176494d, "onFallback errorCode=" + r100 + " errorMessage=" + r101);
            this.f176506b.S90(false, "onFallback errorCode=" + r100 + " errorMessage=" + r101);
        }

        @Override // com.bytedance.android.shopping.mall.a, ti.e
        public final void onLoadStart(View r100, final boolean r101) {
            int r102 = e.f176515a;
            e.a(this.f176506b.f176494d, "on template load start");
            final d r103 = (d) this.f176506b.f176500j.getValue();
            r103.getClass();
            Function1<pi.b, Unit> r104 = new ECMallMonitor$reportTemplateLoadEvent$1(r103, r101);
            if (r103.f176512a != null) goto L5;
            int r105 = ECSdk.f48106a;
            r103.f176512a = (pi.b) ECSdk.a(pi.b.class);
        L5:
            pi.b r106 = r103.f176512a;
            if (r106 == null) goto L9;
            r104.invoke(r106);
            return;
        }

        @Override // com.bytedance.android.shopping.mall.a, ti.e
        public final void onContainerError(View r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "errorMessage");
            int r103 = e.f176515a;
            e.a(this.f176506b.f176494d, "onContainerError: msg" + r102);
            this.f176506b.S90(false, "container error errorCode" + r101 + " msg=" + r102);
        }

        @Override // com.bytedance.android.shopping.mall.a, ti.e
        public final void onLoadFail(View r100, String r101, String r102) {
            int r103 = e.f176515a;
            String r104 = this.f176506b.f176494d;
            StringBuilder r105 = new StringBuilder("on template load failed url=");
            String r106 = "null";
            if (r101 != null) goto L5;
            r101 = "null";
        L5:
            r105.append(r101);
            r105.append(" reason=");
            if (r102 == null) goto L9;
            r106 = r102;
        L9:
            r105.append(r106);
            e.a(r104, r105.toString());
            this.f176506b.getClass();
            final d r107 = (d) this.f176506b.f176500j.getValue();
            if (r102 != null) goto L12;
            final String r108 = "";
        L13:
            if (r102 != null) goto L15;
            final String r109 = "";
        L16:
            r107.getClass();
            Intrinsics.checkNotNullParameter(r108, "error");
            Intrinsics.checkNotNullParameter(r109, "errorDesc");
            Function1<pi.b, Unit> r110 = new ECMallMonitor$reportLynxErrorEvent$1(r107, r109, r108);
            if (r107.f176512a != null) goto L19;
            int r111 = ECSdk.f48106a;
            r107.f176512a = (pi.b) ECSdk.a(pi.b.class);
        L19:
            pi.b r112 = r107.f176512a;
            if (r112 == null) goto L22;
            r110.invoke(r112);
        L22:
            LynxMallFragment r113 = this.f176506b;
            if (r102 != null) goto L25;
            r102 = "";
        L25:
            r113.S90(false, r102);
            return;
        L15:
            r109 = r102;
            goto L16
        L12:
            r108 = r102;
            goto L13
        }
    }

    public static final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxMallFragment f176507a;

        public b(LynxMallFragment r100) {
            this.f176507a = r100;
        }

        @Override // qf3.g
        public final void a(j r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Iterator r101 = ((ArrayList) this.f176507a.f176503m).iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((p) r101.next()).b();
            goto L4
        }
    }

    public LynxMallFragment() {
        this.f176494d = kg.a.a("LynxMallFragment");
        this.f176496f = "";
        this.f176497g = new LinkedHashMap();
        this.f176498h = "LynxMall";
        this.f176499i = LazyKt.lazy(LynxMallFragment$fpsMonitor$2.INSTANCE);
        this.f176500j = LazyKt.lazy(new LynxMallFragment$lynxMonitor$2(this));
        this.f176502l = new com.bytedance.android.shopping.mall.b(new a(this));
        this.f176503m = new ArrayList();
        this.f176504n = new h(new b(this));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f176502l.f176509b = null;
        this.f176504n.f532726a = null;
        ti.d r100 = this.f176501k;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    public final void S90(boolean r100, String r101) {
        if (r100 == false) goto L7;
        Iterator r102 = ((ArrayList) this.f176503m).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        ((p) r102.next()).c();
        goto L5
    L11:
        return;
    L7:
        Iterator r103 = ((ArrayList) this.f176503m).iterator();
    L9:
        if (r103.hasNext() == false) goto L14;
        ((p) r103.next()).a();
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        int r112 = e.f176515a;
        e.a(this.f176494d, "tryLoadLynxTemplate url=" + this.f176496f);
        if (this.f176496f.length() <= 0) goto L5;
        boolean r113 = true;
    L6:
        if (r113 == false) goto L81;
        FrameLayout r114 = this.f176495e;
        if (r114 == null) goto L95;
        r114.removeAllViews();
        ti.d r100 = this.f176501k;
        if (r100 == null) goto L12;
        r100.release();
    L12:
        int r101 = ECSdk.f48106a;
        IECBulletService r102 = (IECBulletService) ECSdk.a(IECBulletService.class);
        Unit r103 = null;
        if (r102 == null) goto L15;
        ti.d r104 = r102.createLiveAnnieComponent(r114.getContext(), this.f176496f, this.f176502l);
    L16:
        this.f176501k = r104;
        if (r104 == null) goto L19;
        View r105 = r104.getHybridView();
    L20:
        String r106 = this.f176494d;
        StringBuilder r107 = new StringBuilder("create hybrid card result service=");
        Object r108 = "null";
        Object r109 = r102;
        if (r102 != null) goto L23;
        r109 = "null";
    L23:
        r107.append(r109);
        r107.append(" annie component=");
        ti.d r115 = this.f176501k;
        if (r115 == null) goto L27;
        r108 = r115;
    L27:
        r107.append(r108);
        r107.append(" hybrid card=");
        r107.append(r105);
        e.a(r106, r107.toString());
        if (r105 != null) goto L84;
        S90(false, "cannot find HybridCard");
        return;
    L84:
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L31
        r114.addView(r105, new ViewGroup.LayoutParams(-1, -1));     // Catch: Throwable -> L31
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Uri r117 = UriProtector.parse(this.f176496f);
        String r118 = StringsKt.replace$default(this.f176496f, "?" + r117.getQuery(), "", false, 4, null);
        int r119 = e.f176515a;
        e.a(this.f176494d, "load final url " + r118);
        ti.d r120 = this.f176501k;
        if (r120 == null) goto L77;
        LinkedHashMap r121 = new LinkedHashMap();
        r121.put("enter_from", this.f176498h);
        r121.putAll(this.f176497g);
        Context r122 = getContext();
        if (r122 == null) goto L38;
        SharedPreferences r123 = r122.getSharedPreferences("js_kv_methods_20191113", 0);
    L39:
        if (r123 == null) goto L76;
        ArrayList r124 = new ArrayList();
        Lazy r125 = ECSettingKeys.f43616a;     // Catch: Throwable -> L65
        int r126 = com.bytedance.android.ec.core.opt.ab.p.f45243a;     // Catch: Throwable -> L65
        Object r127 = SliceInitService.DEFAULT_SWITCH;
        jj4.b r128 = jj4.b.f499326b;     // Catch: Throwable -> L46
        Object r129 = jj4.a.a("iesec_saas_mall_config", String.class, SliceInitService.DEFAULT_SWITCH, false);     // Catch: Throwable -> L46
        if (r129 != null) goto L52;
        Intrinsics.throwNpe();     // Catch: Throwable -> L46
    L52:
        JSONArray r130 = com.bytedance.commerce.base.json.b.a((String) r129).optJSONArray("tt_storage_keys");     // Catch: Throwable -> L65
        if (r130 == null) goto L63;
        Iterator r131 = ((ArrayList) com.bytedance.android.shopping.hybrid.a.a(r130)).iterator();     // Catch: Throwable -> L65
    L56:
        if (r131.hasNext() == false) goto L62;
        Object r132 = r131.next();     // Catch: Throwable -> L65
        if (r132 == null) goto L61;
        r124.add((String) r132);     // Catch: Throwable -> L65
        goto L56
    L61:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L65
    L62:
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L65
    L63:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L65
    L67:
        LinkedHashMap r133 = new LinkedHashMap();
        Iterator r134 = r124.iterator();
    L69:
        if (r134.hasNext() == false) goto L74;
        String r135 = (String) r134.next();
        String r136 = r123.getString(r135, "");
        if (r136 == null) goto L69;
        r133.put(r135, r136);
        goto L69
    L74:
        if ((true ^ r133.isEmpty()) == false) goto L76;
        r121.put("storageInitData", r133);
    L46:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L65
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L65
        if (Result.m9455isFailureimpl(r138) == true) goto L51;
        r127 = r138;
    L51:
        r129 = r127;
    L65:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L76:
        r120.load(r118, r121);
        goto L77
    L38:
        r123 = null;
    L77:
        ti.d r140 = this.f176501k;
        if (r140 == null) goto L96;
        int r141 = qf3.f.f532725a;
        h r142 = this.f176504n;
        Intrinsics.checkNotNullParameter(r140, "component");
        Intrinsics.checkNotNullParameter(r142, "stateChangedHandler");
        r140.b(new i(r142));
        return;
    L96:
        return;
    L31:
        th = move-exception;
        Result.Companion r143 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L33
    L19:
        r105 = null;
        goto L20
    L15:
        r104 = null;
        goto L16
    L95:
        return;
    L81:
        S90(false, "lynx template url is null");
        return;
    L5:
        r113 = false;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        FrameLayout r103 = new FrameLayout(r100.getContext());
        r103.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Unit r104 = Unit.INSTANCE;
        this.f176495e = r103;
        return r103;
    }
}
