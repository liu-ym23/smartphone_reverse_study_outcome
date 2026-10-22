package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedQueryParam;
import com.bytedance.android.shopping.deepfeed.data.api.DeepFeedImpressionApi;
import com.bytedance.android.shopping.deepfeed.viewmodel.DeepFeedProductViewModel;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.jedi.ext.adapter.JediSimpleViewHolder;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import he3.e1;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/vh/AbsDeepFeedProductVH;", "Lcom/bytedance/jedi/ext/adapter/JediSimpleViewHolder;", "Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductV2;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsDeepFeedProductVH extends JediSimpleViewHolder<InFeedProductV2> {
    public String A;
    public String B;
    public String C;
    public String D;
    public JSONArray E;
    public Long F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public com.bytedance.android.shopping.deepfeed.ui.vh.d f173749J;
    public final b K;
    public final f L;
    public Function0<Unit> M;
    public final LifecycleOwner N;
    public final View O;
    public final com.bytedance.android.shopping.deepfeed.action.h P;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f173750l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public InFeedProductV2 f173751m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<String> f173752n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f173753o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Handler f173754p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f173755q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f173756r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f173757s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f173758t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f173759u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f173760v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f173761w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f173762x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f173763y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f173764z;

    public static final class a {
    }

    public static final class b implements ti.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsDeepFeedProductVH f173765a;

        public b(AbsDeepFeedProductVH r100) {
            this.f173765a = r100;
        }

        @Override // ti.j
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            JSONObject r101 = com.bytedance.android.shopping.extensions.k.w(r100.optString("response", SliceInitService.DEFAULT_SWITCH));
            String r102 = null;
            if (r101 == null) goto L5;
            Integer r103 = Integer.valueOf(r101.optInt("status_code", -1));
        L7:
            if (r101 == null) goto L10;
            r102 = r101.optString("status_msg", "");
        L10:
            if (r103 != null) goto L13;
        L17:
            AbsDeepFeedProductVH r104 = this.f173765a;
            if (r104.f173753o == false) goto L32;
            com.bytedance.android.ec.sdk.helper.i r105 = com.bytedance.android.ec.sdk.helper.i.f48124a;
            Context r106 = r104.itemView.getContext();
            if (r102 != null) goto L22;
        L25:
            boolean r107 = true;
        L26:
            if (r107 == false) goto L28;
            r102 = "当前商品无法加购";
        L28:
            r105.e(r106, r102, false, false);
            return;
        L22:
            if (r102.length() == 0) goto L25;
            r107 = false;
            goto L26
        L32:
            return;
        L13:
            if (r103.intValue() != 0) goto L17;
            if (Intrinsics.areEqual(r100.optString("sku_session_id", ""), this.f173765a.C) == false) goto L30;
            com.bytedance.android.ec.sdk.helper.i.f48124a.e(this.f173765a.itemView.getContext(), "添加成功，在购物车等你", false, false);
            tc3.f.b();
            return;
        L30:
            return;
        L5:
            r103 = null;
            goto L7
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f173766a = null;

        static {
            f173766a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            CommerceBaseResponse r101 = (CommerceBaseResponse) r100;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f173767a = null;

        static {
            f173767a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f173768a;

        public e(Runnable r100) {
            this.f173768a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f173768a.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements ti.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsDeepFeedProductVH f173769a;

        public f(AbsDeepFeedProductVH r100) {
            this.f173769a = r100;
        }

        @Override // ti.j
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            String r101 = r100.optString("sku_session_id", "");
            if (Intrinsics.areEqual(r101, this.f173769a.C) == false) goto L5;
        L6:
            AbsDeepFeedProductVH r102 = this.f173769a;
            r102.E = r100.optJSONArray("select_spec_ids");
            AbsDeepFeedProductVH r103 = this.f173769a;
            r103.F = Long.valueOf(r100.optLong("combo_num", 1));
            return;
        L5:
            if (Intrinsics.areEqual(r101, this.f173769a.D) == true) goto L6;
        }
    }

    static {
    }

    public abstract void c4(int r100);

    public abstract void d4();

    public abstract void e4();

    public abstract void f4();

    public abstract void g4();

    public abstract boolean l4();

    public boolean m4() {
        return false;
    }

    public void s4(String r100) {
        Intrinsics.checkNotNullParameter(r100, "finishMethod");
    }

    public abstract void u4(boolean r100);

    public abstract void v4();

    @Deprecated(message = "在 slice 场景不需要这个方法了")
    public abstract void w4(int r100);

    public abstract void y4(he3.l r100, com.bytedance.android.shopping.deepfeed.action.h r101);

    public final DeepFeedProductViewModel i4() {
        return (DeepFeedProductViewModel) this.f173750l.getValue();
    L5:
        return new DeepFeedProductViewModel();
    }

    public final void j4() {
        uc3.e r100 = new uc3.e(0);
        InFeedProductV2 r101 = this.f173751m;
        String r102 = null;
        if (r101 == null) goto L7;
        e1 r103 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r101);
        if (r103 == null) goto L7;
        String r104 = r103.a();
    L8:
        r100.a(r104);
        r100.b(2);
        ArrayList r105 = new ArrayList();
        ListProtector.add(r105, 0, r100);
        InFeedProductV2 r106 = this.f173751m;
        if (r106 == null) goto L23;
        e1 r107 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r106);
        if (r107 == null) goto L23;
        String r108 = r107.c();
        if (r108 == null) goto L23;
        if (com.bytedance.android.shopping.extensions.k.c(r108) != true) goto L23;
        uc3.e r109 = new uc3.e(0);
        InFeedProductV2 r110 = this.f173751m;
        if (r110 == null) goto L21;
        e1 r111 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r110);
        if (r111 == null) goto L21;
        String r112 = r111.c();
    L22:
        r109.a(r112);
        r109.b(1);
        ListProtector.add(r105, 0, r109);
    L21:
        r112 = null;
    L23:
        DeepFeedImpressionApi.f173089a.getClass();
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L32
        DeepFeedImpressionApi r114 = (DeepFeedImpressionApi) com.bytedance.android.ec.sdk.helper.n.f48128a.create("https://ecom.snssdk.com", DeepFeedImpressionApi.class);     // Catch: Throwable -> L32
        if (r114 != null) goto L30;
        int r115 = com.bytedance.android.shopping.monitor.b.f178663a;     // Catch: Throwable -> L32
        Intrinsics.checkNotNullParameter("deep_feed_impression_api", "apiName");     // Catch: Throwable -> L32
        int r116 = com.bytedance.android.ec.core.monitor.d.f45144a;     // Catch: Throwable -> L32
        HashMap r117 = new HashMap();     // Catch: Throwable -> L32
        r117.put("api_name", "deep_feed_impression_api");     // Catch: Throwable -> L32
        Unit r118 = Unit.INSTANCE;     // Catch: Throwable -> L32
        Intrinsics.checkNotNullParameter("mall_api_init_failed", "event");     // Catch: Throwable -> L32
        Intrinsics.checkNotNullParameter(r117, "params");     // Catch: Throwable -> L32
        if (com.bytedance.android.ec.core.opt.ab.t.a() != 1) goto L30;
        com.bytedance.android.ec.core.monitor.d.f("mall_api_init_failed");     // Catch: Throwable -> L32
        com.bytedance.android.ec.core.monitor.d.e("mall_api_init_failed", r117);     // Catch: Throwable -> L32
    L30:
        Object r119 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L32
    L35:
        if (Result.m9455isFailureimpl(r119) == false) goto L37;
        r119 = null;
    L37:
        DeepFeedImpressionApi r120 = (DeepFeedImpressionApi) r119;
        if (r120 == null) goto L54;
        DeepFeedQueryParam r121 = i4().getFeedParam();
        if (r121 == null) goto L42;
        String r122 = r121.getBizCode();
    L43:
        DeepFeedQueryParam r123 = i4().getFeedParam();
        if (r123 == null) goto L46;
        r102 = r123.getSceneCode();
    L46:
        Single<CommerceBaseResponse> r124 = r120.impressionReport(new uc3.d(new uc3.b(r122, r102), r105));
        if (r124 == null) goto L55;
        Single r125 = bg4.b.c(r124);
        if (r125 == null) goto L56;
        r125.subscribe(c.f173766a, d.f173767a);
        return;
    L56:
        return;
    L55:
        return;
    L42:
        r122 = null;
        goto L43
    L54:
        return;
    L32:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r104 = null;
        goto L8
    }

    @Override // com.bytedance.jedi.ext.adapter.JediViewHolder
    public final void onPause() {
        if (this.H == false) goto L6;
        this.H = false;
        ECLiveHybridUtil.p("ecom.sku.add.cart", this.K);
    L6:
        if (this.I == false) goto L9;
        this.I = false;
        ECLiveHybridUtil.p("ecom.sku.spec.change", this.L);
        return;
    }

    @Override // com.bytedance.jedi.ext.adapter.JediViewHolder
    public void onResume() {
        if (this.H == false) goto L5;
        this.H = false;
        ECLiveHybridUtil.p("ecom.sku.add.cart", this.K);
    L5:
        this.H = true;
        ECLiveHybridUtil.m("ecom.sku.add.cart", this.K);
        if (this.I == false) goto L8;
        this.I = false;
        ECLiveHybridUtil.p("ecom.sku.spec.change", this.L);
    L8:
        this.I = true;
        ECLiveHybridUtil.m("ecom.sku.spec.change", this.L);
    }

    public void q4() {
        if (this.N.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        com.bytedance.android.shopping.deepfeed.ui.vh.d r100 = this.f173749J;
        if (r100 == null) goto L9;
        i4().removeCouponListener(r100);
        return;
    }

    public final boolean k4() {
        if (getAdapterPosition() < i4().curNoFullScreenCount()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void r4() {
        com.bytedance.android.shopping.deepfeed.data.repo.l r100 = i4().getResp();
        if (r100 == null) goto L14;
        uc3.f r101 = r100.g();
        long r102 = System.currentTimeMillis();
        if (getAdapterPosition() != 0) goto L10;
        if (getItem().isCacheData() == false) goto L10;
        ((com.bytedance.android.shopping.deepfeed.data.repo.j) r101).f173211l = r102;
        return;
    L10:
        if (getAdapterPosition() != 0) goto L12;
        ((com.bytedance.android.shopping.deepfeed.data.repo.j) r101).f173212m = r102;
        return;
    L12:
        ((com.bytedance.android.shopping.deepfeed.data.repo.j) r101).f173213n = r102;
        return;
    }

    public static String h4(String r100) {
        Intrinsics.checkNotNullParameter(r100, "link");
        JSONObject r101 = com.bytedance.android.shopping.extensions.k.w(UriProtector.getQueryParameter(UriProtector.parse(r100), "client_params"));
        String r102 = "";
        if (r101 == null) goto L5;
        String r103 = r101.optString("sku_session_id", "");
    L6:
        if (r103 == null) goto L10;
        r102 = r103;
    L10:
        if (r102.length() != 0) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == true) goto L15;
    L18:
        return r102;
    L15:
        if (StringsKt.startsWith$default(r100, "sslocal://buy_now", false, 2, null) == false) goto L18;
        return UUID.randomUUID().toString();
    L12:
        r104 = false;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    public void n4(boolean r100) {
        com.bytedance.android.shopping.deepfeed.utlis.f.f173979b = r100;
        com.bytedance.android.shopping.deepfeed.utlis.f.f173981d = Boolean.valueOf(r100);
        int r101 = tc3.f.f545400a;
        Integer r102 = tc3.a.a().l();
        if (r102 != null) goto L6;
    L8:
        boolean r103 = false;
    L9:
        if (r103 == false) goto L12;
        int r104 = ed3.b.f472197a;
        Intrinsics.checkNotNullParameter("deep_feed_manual_mute_status", "key");
        return;
    L12:
        return;
    L6:
        if (r102.intValue() != 2) goto L8;
        r103 = true;
        goto L9
    }

    public final void t4(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        this.itemView.post(new e(r100));
    }

    public AbsDeepFeedProductVH(LifecycleOwner r100, View r101, com.bytedance.android.shopping.deepfeed.action.h r102) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "vhView");
        Intrinsics.checkNotNullParameter(r102, "deepFeedContext");
        super(r101);
        this.N = r100;
        this.O = r101;
        this.P = r102;
        final KClass r103 = Reflection.getOrCreateKotlinClass(DeepFeedProductViewModel.class);
        this.f173750l = LazyKt.lazy(new AbsDeepFeedProductVH$$special$$inlined$hostViewModel$1(this, r103, r103));
        this.f173752n = new ArrayList();
        this.f173754p = new Handler(Looper.getMainLooper());
        this.C = "";
        this.D = "";
        this.K = new b(this);
        this.L = new f(this);
    }
}
