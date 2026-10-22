package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import androidx.collection.LongSparseArray;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class f0 implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.configmodel.n2 f131529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f131530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f131531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Long, Long> f131532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f131533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f131534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f1 f131535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o3 f131536h;

    public static final class a implements wp2.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<f0> f131537a;

        public a(WeakReference<f0> r100) {
            Intrinsics.checkNotNullParameter(r100, "serviceRef");
            this.f131537a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // wp2.i
        public final void a(wp2.d r100) {
            f0 r101 = this.f131537a.get();
            if (r101 != null) goto L5;
            return;
        L5:
            if (r100.f560560a == true) goto L7;
            return;
        L7:
            if ((r100 instanceof wp2.p) == false) goto L12;
            wp2.p r102 = (wp2.p) r100;
            r101.f131531c += 0;
            return;
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a() {
        if (this.f131529a.c() == true) goto L6;
        return;
    L6:
        if ((System.currentTimeMillis() - this.f131533e) >= this.f131534f) goto L8;
        return;
    L8:
        JSONObject r100 = new JSONObject();
        JSONObject r101 = new JSONObject();
        if (this.f131529a.e() == true) goto L11;
        this.f131536h.a(r101);
        this.f131536h.c(r101);
        r101.put("use_feature_center", 0);
    L12:
        r101.put("count", this.f131529a.b());
        this.f131530b++;
        JSONArray r102 = new JSONArray();
        Iterator<Map.Entry<Integer, LongSparseArray<com.bytedance.android.livesdk.gift.platform.core.model.o>>> r103 = this.f131535g.f131540c.entrySet().iterator();
    L14:
        if (r103.hasNext() == false) goto L36;
        Map.Entry<Integer, LongSparseArray<com.bytedance.android.livesdk.gift.platform.core.model.o>> r104 = r103.next();
        JSONObject r105 = new JSONObject();
        JSONArray r106 = new JSONArray();
        r105.put("tabId", r104.getKey().intValue());
        LongSparseArray<com.bytedance.android.livesdk.gift.platform.core.model.o> r107 = r104.getValue();
        int r110 = r107.size();
        if (r110 <= 0) goto L35;
        int r111 = 0;
    L18:
        if (r111 >= r110) goto L35;
        com.bytedance.android.livesdk.gift.platform.core.model.o r112 = r107.valueAt(r111);
        if (r112 == null) goto L33;
        Iterator<Map.Entry<Integer, LongSparseArray<com.bytedance.android.livesdk.gift.platform.core.model.o>>> r113 = r103;
        if (this.f131535g.f131542e != r112.f130920b) goto L34;
        int r108 = r112.f130919a;
        if (r108 == 1) goto L34;
        if (r108 == 3) goto L34;
        if (r108 == 4) goto L34;
        JSONObject r109 = new JSONObject();
        r109.put("id", r112.b());
        r109.put("price", r112.d());
        r109.put("index", r112.c());
        if (r112.a() == 0) goto L32;
        r109.put("force_insert", r112.a());
    L32:
        r109.put("sort_extra", r112.e());
        r106.put(r109);
    L34:
        r111 = r111 + 1;
        r103 = r113;
        goto L18
    L33:
        r113 = r103;
    L35:
        r105.put("gifts", r106);
        r102.put(r105);
        r103 = r103;
        goto L14
    L36:
        r101.put("tabs", r102);
        r100.put("custom_feat_dict", r101);
        wp2.o r114 = new wp2.o(r100, new a(new WeakReference(this)));
        this.f131533e = System.currentTimeMillis();
        ((rq2.a) vh6.c.b(rq2.a.class)).yc(r114);
        return;
    L11:
        r101.put("use_feature_center", 1);
        goto L12
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        int r100 = this.f131530b;
        if (r100 <= 0) goto L5;
    L6:
        Map<? extends String, ? extends String> r101 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("trigger_count", String.valueOf(r100)), TuplesKt.to("predict_count", String.valueOf(this.f131531c))});
        String r102 = com.bytedance.android.livesdk.gift.platform.core.utils.h.f132038a;
        Intrinsics.checkNotNullParameter(r101, "param");
        mz0.n r103 = new mz0.n();
        Map<String, String> r104 = r103.f516447a;
        Intrinsics.checkNotNullParameter(r104, "map");
        Intrinsics.checkNotNullParameter(r101, "map");
        r104.putAll(r101);
        mz0.m r105 = new mz0.m();
        r105.b(LogCommon.LIVE_SHARE_LOG);
        r105.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r106 = ((kr2.a) vh6.c.b(kr2.a.class)).ud();
        Intrinsics.checkNotNullParameter(r106, "pageSourceLog");
        ((ArrayList) r105.f516446a).add(r106.f157176a);
        ((ArrayList) r103.f516448b).addAll(r105.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r107 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r108 = com.bytedance.android.scope.m.b(r107).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r108);
        ((mz0.i) ((f80.a) r108)).w3("livesdk_send_gift_predict", r103.f516447a, r103.f516448b);
        return;
    L5:
        if (this.f131531c > 0) goto L6;
    }

    public f0(f1 r100, o3 r101) {
        Intrinsics.checkNotNullParameter(r100, "giftListSortService");
        Intrinsics.checkNotNullParameter(r101, "featureCenterService");
        this.f131535g = r100;
        this.f131536h = r101;
        this.f131529a = (com.bytedance.android.livesdk.gift.configmodel.n2) com.bytedance.android.livesdk.gift.platform.core.h.f130656i0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.f130639a[59]);
        this.f131532d = new LinkedHashMap();
        this.f131534f = 30000;
    }
}
