package com.bytedance.android.ec.store.repository.vo;

import com.bytedance.android.shopping.store.repository.vo.ShopRemoteStruct;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class r implements QModel {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f48479t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f48480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f48481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f48482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f48483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f48484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super r, Unit> f48485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f48486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ShopRemoteStruct f48487h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f48488i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.ec.store.repository.dto.e f48489j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f48490k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f48491l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f48492m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<r> f48493n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f48494o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f48495p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f48496q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Map<String, String> f48497r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.bytedance.android.ec.store.repository.dto.c f48498s;

    public static final class a {
        public static r a(com.bytedance.android.ec.store.repository.dto.m r100) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            r r101 = new r();
            r101.f48480a = r100.e();
            String r102 = r100.g();
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r101.f48481b = r102;
            r101.f48489j = r100.f();
            r101.f48490k = r100.l();
            r101.f48491l = r100.k();
            r101.f48492m = r100.h();
            List<com.bytedance.android.ec.store.repository.dto.m> r103 = r100.m();
            ShopRemoteStruct r104 = null;
            if (r103 == null) goto L9;
            List<com.bytedance.android.ec.store.repository.dto.m> r105 = r103;
            ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
            Iterator<T> r107 = r105.iterator();
        L6:
            if (r107.hasNext() == false) goto L8;
            com.bytedance.android.ec.store.repository.dto.m r108 = (com.bytedance.android.ec.store.repository.dto.m) r107.next();
            int r109 = r.f48479t;
            r106.add(a(r108));
            goto L6
        L8:
            ArrayList r110 = new ArrayList(r106);
        L10:
            r101.f48493n = r110;
            r101.f48496q = r100.j();
            r101.f48495p = r100.o();
            r101.f48498s = r100.i();
            r101.f48497r = r100.d();
            r101.f48482c = r100.n();
            r101.f48483d = r100.b();
            r101.f48484e = r100.c();
            com.bytedance.android.ec.store.repository.dto.a r111 = r100.a();
            if (r111 == null) goto L15;
            Boolean r112 = r111.b();
            if (r112 == null) goto L15;
            boolean r113 = r112.booleanValue();
        L16:
            r101.f48486g = r113;
            com.bytedance.android.ec.store.repository.dto.a r114 = r100.a();
            if (r114 == null) goto L19;
            String r115 = r114.c();
        L20:
            r101.f48488i = r115;
            Gson r116 = new Gson();     // Catch: Exception -> L27
            com.bytedance.android.ec.store.repository.dto.a r117 = r100.a();     // Catch: Exception -> L27
            if (r117 == null) goto L24;
            String r118 = r117.a();     // Catch: Exception -> L27
        L25:
            r104 = (ShopRemoteStruct) r116.fromJson(r118, ShopRemoteStruct.class);     // Catch: Exception -> L27
        L28:
            r101.f48487h = r104;
            return r101;
        L24:
            r118 = null;
        L27:
            EnsureManager.ensureNotReachHere("e");
            goto L28
        L19:
            r115 = null;
        L15:
            r113 = false;
            goto L16
        L9:
            r110 = null;
            goto L10
        }
    }

    static {
    }

    public final void g() {
        boolean r100 = false;
        this.f48482c = false;
        List<r> r101 = this.f48493n;
        List<r> r102 = r101;
        if (r102 != null) goto L5;
    L6:
        r100 = true;
    L7:
        if (r100 == false) goto L9;
        return;
    L9:
        Iterator<r> r103 = r101.iterator();
    L11:
        if (r103.hasNext() == false) goto L13;
        r103.next().g();
        goto L11
    L13:
        return;
    L5:
        if (r102.isEmpty() == false) goto L7;
        goto L6
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return 100;
    }

    public final r b() {
        r r100 = new r();
        r100.f48480a = this.f48480a;
        r100.f48481b = this.f48481b;
        r100.f48482c = this.f48482c;
        r100.f48483d = this.f48483d;
        r100.f48484e = this.f48484e;
        ArrayList r101 = null;
        r100.f48485f = null;
        r100.f48486g = this.f48486g;
        r100.f48487h = this.f48487h;
        r100.f48488i = this.f48488i;
        r100.f48489j = this.f48489j;
        r100.f48490k = this.f48490k;
        r100.f48491l = this.f48491l;
        r100.f48492m = this.f48492m;
        List<r> r102 = this.f48493n;
        if (r102 == null) goto L9;
        List<r> r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L6:
        if (r105.hasNext() == false) goto L8;
        r104.add(((r) r105.next()).b());
        goto L6
    L8:
        r101 = new ArrayList(r104);
    L9:
        r100.f48493n = r101;
        r100.f48494o = this.f48494o;
        r100.f48495p = this.f48495p;
        r100.f48496q = this.f48496q;
        r100.f48497r = this.f48497r;
        r100.f48498s = this.f48498s;
        return r100;
    }

    public final boolean e() {
        List<r> r100 = this.f48493n;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        return !r101;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L10
    }

    public final boolean f() {
        if (this.f48482c == false) goto L5;
        return true;
    L5:
        List<r> r100 = this.f48493n;
        List<r> r101 = r100;
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        return false;
    L14:
        Iterator<r> r103 = r100.iterator();
    L16:
        if (r103.hasNext() == false) goto L20;
        if (r103.next().f() == false) goto L16;
        return true;
    L20:
        return false;
    L8:
        if (r101.isEmpty() == true) goto L11;
        r102 = false;
        goto L12
    }

    public r() {
        this.f48481b = "";
        this.f48496q = "";
    }

    public final int getType() {
        return this.f48494o;
    }

    public static void d(r r100) {
        boolean r101 = true;
        r100.f48494o = 1;
        List<r> r102 = r100.f48493n;
        List<r> r103 = r102;
        if (r103 != null) goto L5;
    L8:
        if (r101 == true) goto L13;
        Iterator<r> r104 = r102.iterator();
    L11:
        if (r104.hasNext() == false) goto L15;
        d(r104.next());
        goto L11
    L15:
        return;
    L13:
        return;
    L5:
        if (r103.isEmpty() == true) goto L8;
        r101 = false;
        goto L8
    }

    public static void c(r r100, Function1 r101) {
        r100.f48485f = r101;
        List<r> r102 = r100.f48493n;
        List<r> r103 = r102;
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L14;
        Iterator<r> r105 = r102.iterator();
    L12:
        if (r105.hasNext() == false) goto L16;
        c(r105.next(), r101);
        goto L12
    L16:
        return;
    L14:
        return;
    L5:
        if (r103.isEmpty() == true) goto L8;
        r104 = false;
        goto L9
    }
}
