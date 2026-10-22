package com.google.common.cache;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import k3.AbstractC1622a;
import l3.AbstractC1660d;
import l3.C1658b;
import l3.C1659c;
import l3.InterfaceC1656A;
import l3.InterfaceC1661e;
import l3.z;

/* loaded from: classes3.dex */
public final class a {
    public static final k3.c o = com.google.common.base.b.a(new C1658b());
    public static final C1659c p = new C1659c();

    /* renamed from: a, reason: collision with root package name */
    public boolean f2734a;
    public int b;
    public long c;
    public long d;
    public InterfaceC1656A e;
    public LocalCache$Strength f;
    public LocalCache$Strength g;
    public long h;
    public long i;

    /* renamed from: j, reason: collision with root package name */
    public com.google.common.base.a f2735j;
    public com.google.common.base.a k;
    public z l;
    public k3.e m;
    public k3.c n;

    public static a e() {
        a aVar = new a();
        aVar.f2734a = true;
        aVar.b = -1;
        aVar.c = -1L;
        aVar.d = -1L;
        aVar.h = -1L;
        aVar.i = -1L;
        aVar.n = o;
        return aVar;
    }

    public final InterfaceC1661e a(s6.e eVar) {
        b();
        eVar.getClass();
        return new LocalCache$LocalLoadingCache(new e(this, eVar));
    }

    public final void b() {
        if (this.e == null) {
            if (!(this.d == -1)) {
                throw new IllegalStateException("maximumWeight requires weigher");
            }
        } else if (this.f2734a) {
            if (!(this.d != -1)) {
                throw new IllegalStateException("weigher requires maximumWeight");
            }
        } else if (this.d == -1) {
            AbstractC1660d.f5273a.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    public final void c(long j5, TimeUnit timeUnit) {
        long j6 = this.h;
        AbstractC1622a.e(j6, "expireAfterWrite was already set to %s ns", j6 == -1);
        if (!(j5 >= 0)) {
            throw new IllegalArgumentException(AbstractC1622a.h("duration cannot be negative: %s %s", Long.valueOf(j5), timeUnit));
        }
        this.h = timeUnit.toNanos(j5);
    }

    public final void d(long j5) {
        long j6 = this.c;
        AbstractC1622a.e(j6, "maximum size was already set to %s", j6 == -1);
        long j10 = this.d;
        AbstractC1622a.e(j10, "maximum weight was already set to %s", j10 == -1);
        if (!(this.e == null)) {
            throw new IllegalStateException("maximum size can not be combined with weigher");
        }
        if (!(j5 >= 0)) {
            throw new IllegalArgumentException("maximum size must not be negative");
        }
        this.c = j5;
    }

    public final String toString() {
        A5.c cVar = new A5.c(a.class.getSimpleName());
        int i = this.b;
        if (i != -1) {
            String strValueOf = String.valueOf(i);
            k3.b bVar = new k3.b(12);
            ((A5.c) cVar.d).d = bVar;
            cVar.d = bVar;
            bVar.c = strValueOf;
            bVar.b = "concurrencyLevel";
        }
        long j5 = this.c;
        if (j5 != -1) {
            String strValueOf2 = String.valueOf(j5);
            k3.b bVar2 = new k3.b(12);
            ((A5.c) cVar.d).d = bVar2;
            cVar.d = bVar2;
            bVar2.c = strValueOf2;
            bVar2.b = "maximumSize";
        }
        long j6 = this.d;
        if (j6 != -1) {
            String strValueOf3 = String.valueOf(j6);
            k3.b bVar3 = new k3.b(12);
            ((A5.c) cVar.d).d = bVar3;
            cVar.d = bVar3;
            bVar3.c = strValueOf3;
            bVar3.b = "maximumWeight";
        }
        if (this.h != -1) {
            String strE = androidx.constraintlayout.core.dsl.a.e(this.h, "ns", new StringBuilder());
            A5.c cVar2 = new A5.c(12);
            ((A5.c) cVar.d).d = cVar2;
            cVar.d = cVar2;
            cVar2.c = strE;
            cVar2.b = "expireAfterWrite";
        }
        if (this.i != -1) {
            String strE2 = androidx.constraintlayout.core.dsl.a.e(this.i, "ns", new StringBuilder());
            A5.c cVar3 = new A5.c(12);
            ((A5.c) cVar.d).d = cVar3;
            cVar.d = cVar3;
            cVar3.c = strE2;
            cVar3.b = "expireAfterAccess";
        }
        LocalCache$Strength localCache$Strength = this.f;
        if (localCache$Strength != null) {
            String strI = AbstractC1622a.i(localCache$Strength.toString());
            A5.c cVar4 = new A5.c(12);
            ((A5.c) cVar.d).d = cVar4;
            cVar.d = cVar4;
            cVar4.c = strI;
            cVar4.b = "keyStrength";
        }
        LocalCache$Strength localCache$Strength2 = this.g;
        if (localCache$Strength2 != null) {
            String strI2 = AbstractC1622a.i(localCache$Strength2.toString());
            A5.c cVar5 = new A5.c(12);
            ((A5.c) cVar.d).d = cVar5;
            cVar.d = cVar5;
            cVar5.c = strI2;
            cVar5.b = "valueStrength";
        }
        if (this.f2735j != null) {
            A5.c cVar6 = new A5.c(12);
            ((A5.c) cVar.d).d = cVar6;
            cVar.d = cVar6;
            cVar6.c = "keyEquivalence";
        }
        if (this.k != null) {
            A5.c cVar7 = new A5.c(12);
            ((A5.c) cVar.d).d = cVar7;
            cVar.d = cVar7;
            cVar7.c = "valueEquivalence";
        }
        if (this.l != null) {
            A5.c cVar8 = new A5.c(12);
            ((A5.c) cVar.d).d = cVar8;
            cVar.d = cVar8;
            cVar8.c = "removalListener";
        }
        return cVar.toString();
    }
}
