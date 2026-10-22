package com.bytedance.android.ec.hybrid.list.entity;

import android.text.TextUtils;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemAction;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.list.util.ECHybridGsonUtil;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class ECHybridListItemVO implements Cloneable {
    public static final boolean H0 = false;
    public static final boolean L0 = false;
    public static final boolean P0 = false;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final boolean f47024p0 = false;
    public String A;
    public Long B;
    public Long C;
    public com.bytedance.android.ec.hybrid.list.entity.dto.a D;
    public final HashMap<String, Object> E;
    public Boolean F;
    public final Lazy G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f47025J;
    public boolean K;
    public e L;
    public long M;
    public long N;
    public boolean O;
    public Long P;
    public final String Q;
    public volatile ECHybridShrinkDataHolder R;
    public volatile String S;
    public transient Object T;
    public transient boolean U;
    public transient Map<String, Object> V;
    public transient Integer W;
    public List<ECHybridListItemAction> X;
    public volatile Object Y;
    public volatile boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f47026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f47027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f47028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f47029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ECHybridShrinkDataHolder f47030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Boolean f47031f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f47032g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ECHybridShrinkDataHolder f47033h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f47034i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Object f47035j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f47036k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f47037k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f47038l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f47039m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f47040n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public n f47041o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ECItemOperationType f47042p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List<String> f47043q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f47044r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<String> f47045s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ECHybridShrinkDataHolder f47046t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ECNAMallCardExtra f47047u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public com.bytedance.android.ec.hybrid.card.api.c f47048v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f47049w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f47050x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Integer f47051y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Integer f47052z;

    public static final class a {
    }

    public final List<String> e() {
        return (List) this.G.getValue();
    }

    static {
        ECHybridItemDataShrinkHelper.f47018h.getClass();
        f47024p0 = ECHybridItemDataShrinkHelper.a.d("recommendInfo");
        H0 = ECHybridItemDataShrinkHelper.a.d("rawItemData");
        L0 = ECHybridItemDataShrinkHelper.a.d("itemData");
        P0 = ECHybridItemDataShrinkHelper.a.d("extra");
    }

    public final ECHybridListItemVO a() {
        ECHybridListItemVO r100 = new ECHybridListItemVO();
        r100.f47026a = i();
        r100.f47027b = this.f47027b;
        r100.f47028c = this.f47028c;
        r100.f47029d = this.f47029d;
        r100.f47036k = this.f47036k;
        r100.p(g());
        r100.o(d());
        r100.f47038l = this.f47038l;
        r100.f47040n = this.f47040n;
        n r101 = this.f47041o;
        e r102 = null;
        if (r101 == null) goto L5;
        n r103 = r101.a();
    L6:
        r100.f47041o = r103;
        if (r103 == null) goto L20;
        List<c> r104 = r103.f47141c;
        if (r104 == null) goto L14;
        Iterator<T> r105 = r104.iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        c r106 = (c) r105.next();
        r106.getClass();
        Intrinsics.checkNotNullParameter(r100, "itemVO");
        r106.f47075e = r100;
    L14:
        List<c> r107 = r103.f47143e;
        if (r107 == null) goto L20;
        Iterator<T> r108 = r107.iterator();
    L18:
        if (r108.hasNext() == false) goto L20;
        c r109 = (c) r108.next();
        r109.getClass();
        Intrinsics.checkNotNullParameter(r100, "itemVO");
        r109.f47075e = r100;
    L20:
        r100.f47042p = this.f47042p;
        r100.f47043q = this.f47043q;
        ((ArrayList) r100.f47045s).addAll(this.f47045s);
        r100.n((ECNAMallCardExtra) GsonProtectorUtils.fromJson(ECHybridGsonUtil.a(), com.bytedance.android.ec.hybrid.list.util.k.d(c()), ECNAMallCardExtra.class));
        r100.f47048v = (com.bytedance.android.ec.hybrid.card.api.c) GsonProtectorUtils.fromJson(ECHybridGsonUtil.a(), com.bytedance.android.ec.hybrid.list.util.k.d(this.f47048v), com.bytedance.android.ec.hybrid.card.api.c.class);
        r100.f47049w = this.f47049w;
        r100.f47050x = this.f47050x;
        r100.f47051y = this.f47051y;
        r100.f47052z = this.f47052z;
        r100.A = this.A;
        r100.B = this.B;
        r100.C = this.C;
        com.bytedance.android.ec.hybrid.list.entity.dto.a r110 = this.D;
        if (r110 == null) goto L23;
        com.bytedance.android.ec.hybrid.list.entity.dto.a r111 = r110.a();
    L24:
        r100.D = r111;
        Iterator<Map.Entry<String, Object>> r112 = this.E.entrySet().iterator();
    L26:
        if (r112.hasNext() == false) goto L28;
        Map.Entry<String, Object> r113 = r112.next();
        r100.E.put(r113.getKey(), r113.getValue());
        goto L26
    L28:
        r100.F = this.F;
        Iterator<T> r114 = e().iterator();
    L30:
        if (r114.hasNext() == false) goto L32;
        r100.e().add((String) r114.next());
        goto L30
    L32:
        r100.H = this.H;
        r100.f47025J = this.f47025J;
        r100.K = this.K;
        e r115 = this.L;
        if (r115 == null) goto L35;
        r102 = r115.a();
    L35:
        r100.L = r102;
        r100.M = this.M;
        r100.N = this.N;
        r100.P = this.P;
        r100.f47038l = this.f47038l;
        r100.f47039m = this.f47039m;
        return r100;
    L23:
        r111 = null;
        goto L24
    L5:
        r103 = null;
        goto L6
    }

    public final String b() {
        boolean r100 = f47024p0;
        JSONObject r101 = null;
        boolean r102 = true;
        if (r100 == false) goto L15;
        String r103 = h();
        if (r103 == null) goto L15;
        if (r103.length() <= 0) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == true) goto L13;
        r103 = null;
    L13:
        if (r103 == null) goto L15;
        return r103;
    L9:
        r104 = false;
    L15:
        ECNAMallCardExtra r105 = c();
        if (r105 == null) goto L27;
        String r106 = r105.getRecommendInfo();
        if (r106 == null) goto L27;
        if (r106.length() > 0) goto L23;
        r102 = false;
    L23:
        if (r102 == false) goto L27;
        if (r100 == false) goto L26;
        q(r106);
    L26:
        return r106;
    L27:
        String r107 = h();
        if (r107 == null) goto L43;
        return r107;
    L43:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L39
        String r109 = g();     // Catch: Throwable -> L39
        if (r109 == null) goto L37;
        r101 = new JSONObject(r109);     // Catch: Throwable -> L39
        JSONObject r110 = r101.optJSONObject("extra");     // Catch: Throwable -> L39
        if (r110 == null) goto L37;
        String r111 = r110.optString(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO);     // Catch: Throwable -> L39
        if (r111 == null) goto L37;
        q(r111);     // Catch: Throwable -> L39
    L37:
        Result.m9449constructorimpl(r101);     // Catch: Throwable -> L39
    L42:
        return h();
    L39:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L42
    }

    public final ECNAMallCardExtra c() {
        if (P0 == false) goto L16;
        ECHybridShrinkDataHolder r100 = this.f47046t;
        Object r101 = null;
        if (r100 == null) goto L7;
        Object r102 = r100.a();
    L9:
        if ((r102 instanceof ECNAMallCardExtra) == false) goto L12;
        r101 = r102;
    L12:
        ECNAMallCardExtra r103 = (ECNAMallCardExtra) r101;
        if (r103 == null) goto L18;
        return r103;
    L18:
        return this.f47047u;
    L7:
        r102 = null;
        goto L9
    L16:
        return this.f47047u;
    }

    public final Object d() {
        if (L0 == false) goto L10;
        ECHybridShrinkDataHolder r100 = this.f47033h;
        if (r100 == null) goto L12;
        Object r101 = r100.a();
        if (r101 == null) goto L12;
        return r101;
    L12:
        return this.f47035j;
    L10:
        return this.f47035j;
    }

    public final String f() {
        if (this.f47036k != null) goto L9;
        int r100 = qj.c.f533273e;
        String r101 = this.f47029d;
        if (r101 != null) goto L7;
        String r102 = UUID.randomUUID().toString();
    L8:
        this.f47036k = r102;
        goto L9
    L7:
        r102 = UUID.randomUUID() + '@' + r101;
    L9:
        String r103 = this.f47036k;
        if (r103 != null) goto L13;
        return "";
    L13:
        return r103;
    }

    public final String g() {
        if (H0 == false) goto L16;
        ECHybridShrinkDataHolder r100 = this.f47030e;
        Object r101 = null;
        if (r100 == null) goto L7;
        Object r102 = r100.a();
    L9:
        if ((r102 instanceof String) == false) goto L12;
        r101 = r102;
    L12:
        String r103 = (String) r101;
        if (r103 == null) goto L18;
        return r103;
    L18:
        return this.f47032g;
    L7:
        r102 = null;
        goto L9
    L16:
        return this.f47032g;
    }

    public final String h() {
        if (f47024p0 == false) goto L16;
        ECHybridShrinkDataHolder r100 = this.R;
        Object r101 = null;
        if (r100 == null) goto L7;
        Object r102 = r100.a();
    L9:
        if ((r102 instanceof String) == false) goto L12;
        r101 = r102;
    L12:
        String r103 = (String) r101;
        if (r103 == null) goto L18;
        return r103;
    L18:
        return this.S;
    L7:
        r102 = null;
        goto L9
    L16:
        return this.S;
    }

    public final Integer i() {
        Integer r100 = this.f47026a;
        if (r100 == null) goto L9;
        Intrinsics.checkNotNull(r100);
        if (r100.intValue() <= 0) goto L9;
        return this.f47026a;
    L9:
        return 1;
    }

    public final boolean j() {
        Long r100 = this.P;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.longValue() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean k() {
        ECHybridShrinkDataHolder r100 = this.f47030e;
        if (r100 != null) goto L5;
    L6:
        ECHybridShrinkDataHolder r101 = this.f47033h;
        if (r101 != null) goto L9;
    L10:
        ECHybridShrinkDataHolder r102 = this.R;
        if (r102 != null) goto L13;
    L14:
        ECHybridShrinkDataHolder r103 = this.f47046t;
        if (r103 != null) goto L17;
    L20:
        return true;
    L17:
        if (r103.b() == true) goto L20;
    L19:
        return false;
    L13:
        if (r102.b() == false) goto L19;
    L9:
        if (r101.b() == false) goto L19;
    L5:
        if (r100.b() == false) goto L19;
        goto L6
    }

    public final boolean l() {
        Boolean r100 = this.f47031f;
        if (r100 == null) goto L14;
        if (this.f47034i == null) goto L14;
        Intrinsics.checkNotNull(r100);
        if (r100.booleanValue() == false) goto L11;
        Boolean r101 = this.f47034i;
        Intrinsics.checkNotNull(r101);
        if (r101.booleanValue() == false) goto L11;
        return true;
    L11:
        return false;
    L14:
        if (TextUtils.isEmpty(g()) == true) goto L16;
    L18:
        return false;
    L16:
        if (d() != null) goto L18;
        return true;
    }

    public ECHybridListItemVO() {
        this.f47042p = ECItemOperationType.NONE;
        this.f47045s = new ArrayList();
        this.E = new HashMap();
        this.F = Boolean.FALSE;
        this.G = LazyKt.lazy(ECHybridListItemVO$itemExtraStringData$2.INSTANCE);
        this.K = true;
        this.Q = UUID.randomUUID().toString();
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return a();
    }

    public final void m() {
        this.M = System.currentTimeMillis();
        this.f47025J++;
    }

    public final void n(ECNAMallCardExtra r100) {
        if (P0 == false) goto L8;
        ECHybridShrinkDataHolder r101 = this.f47046t;
        if (r101 != null) goto L7;
        this.f47046t = new ECHybridShrinkDataHolder(r100, new ECHybridListItemVO$keyProviderOf$1(this, "extra"), null, null);
        return;
    L7:
        r101.c(r100);
        return;
    L8:
        this.f47047u = r100;
    }

    public final void o(Object r100) {
        if (L0 == false) goto L12;
        ECHybridShrinkDataHolder r101 = this.f47033h;
        if (r101 != null) goto L7;
        this.f47033h = new ECHybridShrinkDataHolder(r100, new ECHybridListItemVO$keyProviderOf$1(this, "itemData"), null, null);
    L8:
        if (r100 != null) goto L10;
        boolean r102 = true;
    L11:
        this.f47034i = Boolean.valueOf(r102);
        return;
    L10:
        r102 = false;
        goto L11
    L7:
        r101.c(r100);
        goto L8
    L12:
        this.f47035j = r100;
    }

    public final void p(String r100) {
        if (H0 == false) goto L15;
        ECHybridShrinkDataHolder r101 = this.f47030e;
        if (r101 != null) goto L7;
        this.f47030e = new ECHybridShrinkDataHolder(r100, new ECHybridListItemVO$keyProviderOf$1(this, "rawItemData"), null, null);
    L8:
        if (r100 != null) goto L10;
    L13:
        boolean r102 = true;
    L14:
        this.f47031f = Boolean.valueOf(r102);
        return;
    L10:
        if (r100.length() == 0) goto L13;
        r102 = false;
        goto L14
    L7:
        r101.c(r100);
        goto L8
    L15:
        this.f47032g = r100;
    }

    public final void q(String r100) {
        if (f47024p0 == true) goto L5;
        this.S = r100;
        return;
    L5:
        if (this.R != null) goto L7;
        this.R = new ECHybridShrinkDataHolder(r100, new ECHybridListItemVO$keyProviderOf$1(this, "recommendInfo"), new ECHybridListItemVO$recommendInfo$1(this), new ECHybridListItemVO$recommendInfo$2(this));
        return;
    L7:
        ECHybridShrinkDataHolder r101 = this.R;
        if (r101 == null) goto L13;
        r101.c(r100);
        return;
    }

    public final void r(ECHybridItemDataShrinkHelper r100) {
        Intrinsics.checkNotNullParameter(r100, "helper");
        ECHybridShrinkDataHolder r101 = this.f47030e;
        if (r101 == null) goto L5;
        r101.d(r100);
    L5:
        ECHybridShrinkDataHolder r102 = this.f47033h;
        if (r102 == null) goto L8;
        r102.d(r100);
    L8:
        ECHybridShrinkDataHolder r103 = this.R;
        if (r103 == null) goto L11;
        r103.d(r100);
    L11:
        ECHybridShrinkDataHolder r104 = this.f47046t;
        if (r104 == null) goto L15;
        r104.d(r100);
        return;
    }
}
