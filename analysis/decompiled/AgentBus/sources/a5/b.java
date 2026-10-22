package a5;

import a4.p;
import android.view.View;
import b0.j2;
import c7.r;
import com.google.protobuf.a1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import d5.l;
import d5.m;
import d5.z;
import i5.u;
import ia.b0;
import ia.d0;
import j1.q1;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import la.s0;
import m4.u0;
import ma.w;
import o4.a2;
import o4.b2;
import o4.f1;
import o4.i0;
import o4.t1;
import o4.t2;
import p7.n;
import w7.e0;

/* loaded from: classes.dex */
public final class b extends i7.i implements n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f210f;

    /* renamed from: g, reason: collision with root package name */
    public int f211g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f212h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f213i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Object obj, g7.d dVar, int i2) {
        super(2, dVar);
        this.f210f = i2;
        this.f213i = obj;
    }

    private final Object d(Object obj) {
        String str = (String) this.f213i;
        t2 t2Var = (t2) this.f212h;
        h7.a aVar = h7.a.f4212f;
        int i2 = this.f211g;
        r rVar = r.f1986a;
        if (i2 == 0) {
            e0.N(obj);
            this.f211g = 1;
            if (d0.g(60000L, this) != aVar) {
            }
            return aVar;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e0.N(obj);
            return rVar;
        }
        e0.N(obj);
        ConcurrentHashMap concurrentHashMap = b2.f7283a;
        if (b2.a(str)) {
            this.f211g = 2;
            CopyOnWriteArrayList copyOnWriteArrayList = t2.f7599m;
            if (t2Var.g(str, "delivery_ack_timeout", this) == aVar) {
                return aVar;
            }
        }
        return rVar;
    }

    private final Object i(Object obj) {
        b0 b0Var;
        u0 u0Var = (u0) this.f213i;
        h7.a aVar = h7.a.f4212f;
        int i2 = this.f211g;
        if (i2 == 0) {
            e0.N(obj);
            b0Var = (b0) this.f212h;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b0Var = (b0) this.f212h;
            e0.N(obj);
        }
        while (d0.q(b0Var)) {
            l lVar = (l) u0Var.f6341a;
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) u0Var.f6345e;
            Iterator it = lVar.a(m.CHANNEL).iterator();
            while (it.hasNext()) {
                d5.e eVar = (d5.e) it.next();
                if (!concurrentHashMap.containsKey(eVar.getId())) {
                    concurrentHashMap.put(eVar.getId(), d0.s((na.d) u0Var.f6343c, null, null, new b(u0Var, eVar, null, 27), 3));
                }
            }
            this.f212h = b0Var;
            this.f211g = 1;
            if (d0.g(2000L, this) == aVar) {
                return aVar;
            }
        }
        return r.f1986a;
    }

    private final Object k(Object obj) {
        h7.a aVar = h7.a.f4212f;
        int i2 = this.f211g;
        if (i2 == 0) {
            e0.N(obj);
            u0 u0Var = (u0) this.f212h;
            d5.e eVar = (d5.e) this.f213i;
            this.f211g = 1;
            if (u0.a(u0Var, eVar, this) == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e0.N(obj);
        }
        return r.f1986a;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f210f) {
            case 0:
                return new b((i5.f) this.f212h, (y5.a) this.f213i, dVar, 0);
            case 1:
                return new b((h) this.f212h, (y5.b) this.f213i, dVar, 1);
            case 2:
                b bVar = new b((i5.l) this.f213i, dVar, 2);
                bVar.f212h = obj;
                return bVar;
            case 3:
                b bVar2 = new b((p) this.f213i, dVar, 3);
                bVar2.f212h = obj;
                return bVar2;
            case 4:
                return new b((c6.c) this.f212h, (c6.h) this.f213i, dVar, 4);
            case 5:
                b bVar3 = new b((c6.h) this.f213i, dVar, 5);
                bVar3.f212h = obj;
                return bVar3;
            case 6:
                return new b((c6.l) this.f212h, (z) this.f213i, dVar, 6);
            case 7:
                b bVar4 = new b((h5.g) this.f213i, dVar, 7);
                bVar4.f212h = obj;
                return bVar4;
            case 8:
                return new b((List) this.f212h, (u) this.f213i, dVar, 8);
            case 9:
                return new b((j2) this.f212h, (View) this.f213i, dVar, 9);
            case 10:
                return new b((s0) this.f212h, (q1) this.f213i, dVar, 10);
            case 11:
                b bVar5 = new b((w) this.f213i, dVar, 11);
                bVar5.f212h = obj;
                return bVar5;
            case 12:
                b bVar6 = new b((h4.a) this.f213i, dVar, 12);
                bVar6.f212h = obj;
                return bVar6;
            case 13:
                b bVar7 = new b((ma.e) this.f213i, dVar, 13);
                bVar7.f212h = obj;
                return bVar7;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                b bVar8 = new b((ma.f) this.f213i, dVar, 14);
                bVar8.f212h = obj;
                return bVar8;
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                b bVar9 = new b((la.k) this.f213i, dVar, 15);
                bVar9.f212h = obj;
                return bVar9;
            case 16:
                return new b((q.i) this.f212h, (q.f) this.f213i, dVar, 16);
            case 17:
                return new b((q.i) this.f212h, (q.g) this.f213i, dVar, 17);
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                b bVar10 = new b((o.r) this.f213i, dVar, 18);
                bVar10.f212h = obj;
                return bVar10;
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                b bVar11 = new b((o.g) this.f213i, dVar, 19);
                bVar11.f212h = obj;
                return bVar11;
            case 20:
                return new b((o1.d) this.f212h, (Runnable) this.f213i, dVar, 20);
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                return new b((f1) this.f212h, (i0) this.f213i, dVar, 21);
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                b bVar12 = new b((t1) this.f213i, dVar, 22);
                bVar12.f212h = obj;
                return bVar12;
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                return new b((t1) this.f212h, (i0) this.f213i, dVar, 23);
            case 24:
                return new b((t2) this.f212h, (a2) this.f213i, dVar, 24);
            case 25:
                return new b((t2) this.f212h, (o4.g) this.f213i, dVar, 25);
            case 26:
                return new b((t2) this.f212h, (String) this.f213i, dVar, 26);
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                return new b((u0) this.f212h, (d5.e) this.f213i, dVar, 27);
            case 28:
                b bVar13 = new b((u0) this.f213i, dVar, 28);
                bVar13.f212h = obj;
                return bVar13;
            default:
                return new b((o5.e) this.f212h, (o5.f) this.f213i, dVar, 29);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        switch (this.f210f) {
            case 10:
                ((b) create((b0) obj, (g7.d) obj2)).invokeSuspend(r.f1986a);
                break;
            case 11:
                ((b) create((la.k) obj, (g7.d) obj2)).invokeSuspend(r.f1986a);
                break;
        }
        return ((b) create((b0) obj, (g7.d) obj2)).invokeSuspend(r.f1986a);
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0526  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x064f  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:608:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:620:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:625:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:147:0x02c2 -> B:149:0x02c6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:285:0x0523 -> B:279:0x0508). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:361:0x0664 -> B:355:0x0649). Please report as a decompilation issue!!! */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2716
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.b.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Object obj, Object obj2, g7.d dVar, int i2) {
        super(2, dVar);
        this.f210f = i2;
        this.f212h = obj;
        this.f213i = obj2;
    }
}
