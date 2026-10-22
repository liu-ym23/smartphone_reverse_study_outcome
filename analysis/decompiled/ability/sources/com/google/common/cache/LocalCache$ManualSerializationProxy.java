package com.google.common.cache;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import k3.AbstractC1622a;
import l3.InterfaceC1656A;
import l3.InterfaceC1657a;
import l3.z;

/* loaded from: classes3.dex */
class LocalCache$ManualSerializationProxy<K, V> extends b implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final LocalCache$Strength f2727a;
    public final LocalCache$Strength b;
    public final com.google.common.base.a c;
    public final com.google.common.base.a d;
    public final long e;
    public final long f;
    public final long g;
    public final InterfaceC1656A h;
    public final int i;

    /* renamed from: j, reason: collision with root package name */
    public final z f2728j;
    public final k3.e k;
    public final s6.e l;
    public transient InterfaceC1657a m;

    public LocalCache$ManualSerializationProxy(e eVar) {
        LocalCache$Strength localCache$Strength = eVar.g;
        LocalCache$Strength localCache$Strength2 = eVar.h;
        com.google.common.base.a aVar = eVar.e;
        com.google.common.base.a aVar2 = eVar.f;
        long j5 = eVar.l;
        long j6 = eVar.k;
        long j10 = eVar.i;
        InterfaceC1656A interfaceC1656A = eVar.f2741j;
        int i = eVar.d;
        z zVar = eVar.n;
        k3.e eVar2 = eVar.o;
        s6.e eVar3 = eVar.f2742q;
        this.f2727a = localCache$Strength;
        this.b = localCache$Strength2;
        this.c = aVar;
        this.d = aVar2;
        this.e = j5;
        this.f = j6;
        this.g = j10;
        this.h = interfaceC1656A;
        this.i = i;
        this.f2728j = zVar;
        this.k = (eVar2 == k3.e.f4794a || eVar2 == a.p) ? null : eVar2;
        this.l = eVar3;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        a aVarB = b();
        aVarB.b();
        this.m = new LocalCache$LocalManualCache(new e(aVarB, null));
    }

    private Object readResolve() {
        return this.m;
    }

    public final a b() {
        a aVarE = a.e();
        LocalCache$Strength localCache$Strength = aVarE.f;
        AbstractC1622a.f("Key strength was already set to %s", localCache$Strength == null, localCache$Strength);
        LocalCache$Strength localCache$Strength2 = this.f2727a;
        localCache$Strength2.getClass();
        aVarE.f = localCache$Strength2;
        LocalCache$Strength localCache$Strength3 = aVarE.g;
        AbstractC1622a.f("Value strength was already set to %s", localCache$Strength3 == null, localCache$Strength3);
        LocalCache$Strength localCache$Strength4 = this.b;
        localCache$Strength4.getClass();
        aVarE.g = localCache$Strength4;
        com.google.common.base.a aVar = aVarE.f2735j;
        AbstractC1622a.f("key equivalence was already set to %s", aVar == null, aVar);
        com.google.common.base.a aVar2 = this.c;
        aVar2.getClass();
        aVarE.f2735j = aVar2;
        com.google.common.base.a aVar3 = aVarE.k;
        AbstractC1622a.f("value equivalence was already set to %s", aVar3 == null, aVar3);
        com.google.common.base.a aVar4 = this.d;
        aVar4.getClass();
        aVarE.k = aVar4;
        int i = aVarE.b;
        if (!(i == -1)) {
            throw new IllegalStateException(AbstractC1622a.h("concurrency level was already set to %s", Integer.valueOf(i)));
        }
        int i6 = this.i;
        if (!(i6 > 0)) {
            throw new IllegalArgumentException();
        }
        aVarE.b = i6;
        if (aVarE.l != null) {
            throw new IllegalStateException();
        }
        z zVar = this.f2728j;
        zVar.getClass();
        aVarE.l = zVar;
        aVarE.f2734a = false;
        long j5 = this.e;
        if (j5 > 0) {
            aVarE.c(j5, TimeUnit.NANOSECONDS);
        }
        long j6 = this.f;
        if (j6 > 0) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            long j10 = aVarE.i;
            AbstractC1622a.e(j10, "expireAfterAccess was already set to %s ns", j10 == -1);
            if (!(j6 >= 0)) {
                throw new IllegalArgumentException(AbstractC1622a.h("duration cannot be negative: %s %s", Long.valueOf(j6), timeUnit));
            }
            aVarE.i = timeUnit.toNanos(j6);
        }
        CacheBuilder$OneWeigher cacheBuilder$OneWeigher = CacheBuilder$OneWeigher.f2724a;
        long j11 = this.g;
        InterfaceC1656A interfaceC1656A = this.h;
        if (interfaceC1656A != cacheBuilder$OneWeigher) {
            if (aVarE.e != null) {
                throw new IllegalStateException();
            }
            if (aVarE.f2734a) {
                long j12 = aVarE.c;
                AbstractC1622a.e(j12, "weigher can not be combined with maximum size (%s provided)", j12 == -1);
            }
            interfaceC1656A.getClass();
            aVarE.e = interfaceC1656A;
            if (j11 != -1) {
                long j13 = aVarE.d;
                AbstractC1622a.e(j13, "maximum weight was already set to %s", j13 == -1);
                long j14 = aVarE.c;
                AbstractC1622a.e(j14, "maximum size was already set to %s", j14 == -1);
                if (!(j11 >= 0)) {
                    throw new IllegalArgumentException("maximum weight must not be negative");
                }
                aVarE.d = j11;
            }
        } else if (j11 != -1) {
            aVarE.d(j11);
        }
        k3.e eVar = this.k;
        if (eVar == null) {
            return aVarE;
        }
        if (aVarE.m != null) {
            throw new IllegalStateException();
        }
        aVarE.m = eVar;
        return aVarE;
    }
}
