package com.google.common.cache;

import java.util.logging.Logger;
import l3.n;
import l3.o;
import l3.p;
import l3.t;
import l3.u;
import l3.v;
import l3.y;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
abstract class LocalCache$EntryFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final LocalCache$EntryFactory[] f2725a;
    public static final /* synthetic */ LocalCache$EntryFactory[] b;

    /* JADX INFO: Fake field, exist only in values array */
    LocalCache$EntryFactory EF0;

    static {
        LocalCache$EntryFactory localCache$EntryFactory = new LocalCache$EntryFactory() { // from class: com.google.common.cache.LocalCache$EntryFactory.1
            @Override // com.google.common.cache.LocalCache$EntryFactory
            public final y d(LocalCache$Segment localCache$Segment, Object obj, int i, y yVar) {
                return new p(obj, i, yVar);
            }
        };
        LocalCache$EntryFactory localCache$EntryFactory2 = new LocalCache$EntryFactory() { // from class: com.google.common.cache.LocalCache$EntryFactory.2
            @Override // com.google.common.cache.LocalCache$EntryFactory
            public final y b(LocalCache$Segment localCache$Segment, y yVar, y yVar2, Object obj) {
                y yVarB = super.b(localCache$Segment, yVar, yVar2, obj);
                LocalCache$EntryFactory.a(yVar, yVarB);
                return yVarB;
            }

            @Override // com.google.common.cache.LocalCache$EntryFactory
            public final y d(LocalCache$Segment localCache$Segment, Object obj, int i, y yVar) {
                n nVar = new n(obj, i, yVar, 0);
                nVar.f = Long.MAX_VALUE;
                Logger logger = e.u;
                LocalCache$NullEntry localCache$NullEntry = LocalCache$NullEntry.f2729a;
                nVar.g = localCache$NullEntry;
                nVar.h = localCache$NullEntry;
                return nVar;
            }
        };
        LocalCache$EntryFactory localCache$EntryFactory3 = new LocalCache$EntryFactory() { // from class: com.google.common.cache.LocalCache$EntryFactory.3
            @Override // com.google.common.cache.LocalCache$EntryFactory
            public final y b(LocalCache$Segment localCache$Segment, y yVar, y yVar2, Object obj) {
                y yVarB = super.b(localCache$Segment, yVar, yVar2, obj);
                LocalCache$EntryFactory.c(yVar, yVarB);
                return yVarB;
            }

            @Override // com.google.common.cache.LocalCache$EntryFactory
            public final y d(LocalCache$Segment localCache$Segment, Object obj, int i, y yVar) {
                n nVar = new n(obj, i, yVar, 1);
                nVar.f = Long.MAX_VALUE;
                Logger logger = e.u;
                LocalCache$NullEntry localCache$NullEntry = LocalCache$NullEntry.f2729a;
                nVar.g = localCache$NullEntry;
                nVar.h = localCache$NullEntry;
                return nVar;
            }
        };
        LocalCache$EntryFactory localCache$EntryFactory4 = new LocalCache$EntryFactory() { // from class: com.google.common.cache.LocalCache$EntryFactory.4
            @Override // com.google.common.cache.LocalCache$EntryFactory
            public final y b(LocalCache$Segment localCache$Segment, y yVar, y yVar2, Object obj) {
                y yVarB = super.b(localCache$Segment, yVar, yVar2, obj);
                LocalCache$EntryFactory.a(yVar, yVarB);
                LocalCache$EntryFactory.c(yVar, yVarB);
                return yVarB;
            }

            @Override // com.google.common.cache.LocalCache$EntryFactory
            public final y d(LocalCache$Segment localCache$Segment, Object obj, int i, y yVar) {
                o oVar = new o(obj, i, yVar);
                oVar.e = Long.MAX_VALUE;
                Logger logger = e.u;
                LocalCache$NullEntry localCache$NullEntry = LocalCache$NullEntry.f2729a;
                oVar.f = localCache$NullEntry;
                oVar.g = localCache$NullEntry;
                oVar.h = Long.MAX_VALUE;
                oVar.i = localCache$NullEntry;
                oVar.f5278j = localCache$NullEntry;
                return oVar;
            }
        };
        LocalCache$EntryFactory localCache$EntryFactory5 = new LocalCache$EntryFactory() { // from class: com.google.common.cache.LocalCache$EntryFactory.5
            @Override // com.google.common.cache.LocalCache$EntryFactory
            public final y d(LocalCache$Segment localCache$Segment, Object obj, int i, y yVar) {
                return new v(localCache$Segment.h, obj, i, yVar);
            }
        };
        LocalCache$EntryFactory localCache$EntryFactory6 = new LocalCache$EntryFactory() { // from class: com.google.common.cache.LocalCache$EntryFactory.6
            @Override // com.google.common.cache.LocalCache$EntryFactory
            public final y b(LocalCache$Segment localCache$Segment, y yVar, y yVar2, Object obj) {
                y yVarB = super.b(localCache$Segment, yVar, yVar2, obj);
                LocalCache$EntryFactory.a(yVar, yVarB);
                return yVarB;
            }

            @Override // com.google.common.cache.LocalCache$EntryFactory
            public final y d(LocalCache$Segment localCache$Segment, Object obj, int i, y yVar) {
                t tVar = new t(localCache$Segment.h, obj, i, yVar, 0);
                tVar.e = Long.MAX_VALUE;
                Logger logger = e.u;
                LocalCache$NullEntry localCache$NullEntry = LocalCache$NullEntry.f2729a;
                tVar.f = localCache$NullEntry;
                tVar.g = localCache$NullEntry;
                return tVar;
            }
        };
        LocalCache$EntryFactory localCache$EntryFactory7 = new LocalCache$EntryFactory() { // from class: com.google.common.cache.LocalCache$EntryFactory.7
            @Override // com.google.common.cache.LocalCache$EntryFactory
            public final y b(LocalCache$Segment localCache$Segment, y yVar, y yVar2, Object obj) {
                y yVarB = super.b(localCache$Segment, yVar, yVar2, obj);
                LocalCache$EntryFactory.c(yVar, yVarB);
                return yVarB;
            }

            @Override // com.google.common.cache.LocalCache$EntryFactory
            public final y d(LocalCache$Segment localCache$Segment, Object obj, int i, y yVar) {
                t tVar = new t(localCache$Segment.h, obj, i, yVar, 1);
                tVar.e = Long.MAX_VALUE;
                Logger logger = e.u;
                LocalCache$NullEntry localCache$NullEntry = LocalCache$NullEntry.f2729a;
                tVar.f = localCache$NullEntry;
                tVar.g = localCache$NullEntry;
                return tVar;
            }
        };
        LocalCache$EntryFactory localCache$EntryFactory8 = new LocalCache$EntryFactory() { // from class: com.google.common.cache.LocalCache$EntryFactory.8
            @Override // com.google.common.cache.LocalCache$EntryFactory
            public final y b(LocalCache$Segment localCache$Segment, y yVar, y yVar2, Object obj) {
                y yVarB = super.b(localCache$Segment, yVar, yVar2, obj);
                LocalCache$EntryFactory.a(yVar, yVarB);
                LocalCache$EntryFactory.c(yVar, yVarB);
                return yVarB;
            }

            @Override // com.google.common.cache.LocalCache$EntryFactory
            public final y d(LocalCache$Segment localCache$Segment, Object obj, int i, y yVar) {
                u uVar = new u(localCache$Segment.h, obj, i, yVar);
                uVar.d = Long.MAX_VALUE;
                Logger logger = e.u;
                LocalCache$NullEntry localCache$NullEntry = LocalCache$NullEntry.f2729a;
                uVar.e = localCache$NullEntry;
                uVar.f = localCache$NullEntry;
                uVar.g = Long.MAX_VALUE;
                uVar.h = localCache$NullEntry;
                uVar.i = localCache$NullEntry;
                return uVar;
            }
        };
        b = new LocalCache$EntryFactory[]{localCache$EntryFactory, localCache$EntryFactory2, localCache$EntryFactory3, localCache$EntryFactory4, localCache$EntryFactory5, localCache$EntryFactory6, localCache$EntryFactory7, localCache$EntryFactory8};
        f2725a = new LocalCache$EntryFactory[]{localCache$EntryFactory, localCache$EntryFactory2, localCache$EntryFactory3, localCache$EntryFactory4, localCache$EntryFactory5, localCache$EntryFactory6, localCache$EntryFactory7, localCache$EntryFactory8};
    }

    public static void a(y yVar, y yVar2) {
        yVar2.j(yVar.l());
        y yVarB = yVar.b();
        Logger logger = e.u;
        yVarB.i(yVar2);
        yVar2.a(yVarB);
        y yVarE = yVar.e();
        yVar2.i(yVarE);
        yVarE.a(yVar2);
        LocalCache$NullEntry localCache$NullEntry = LocalCache$NullEntry.f2729a;
        yVar.i(localCache$NullEntry);
        yVar.a(localCache$NullEntry);
    }

    public static void c(y yVar, y yVar2) {
        yVar2.m(yVar.h());
        y yVarF = yVar.f();
        Logger logger = e.u;
        yVarF.o(yVar2);
        yVar2.n(yVarF);
        y yVarC = yVar.c();
        yVar2.o(yVarC);
        yVarC.n(yVar2);
        LocalCache$NullEntry localCache$NullEntry = LocalCache$NullEntry.f2729a;
        yVar.o(localCache$NullEntry);
        yVar.n(localCache$NullEntry);
    }

    public static LocalCache$EntryFactory valueOf(String str) {
        return (LocalCache$EntryFactory) Enum.valueOf(LocalCache$EntryFactory.class, str);
    }

    public static LocalCache$EntryFactory[] values() {
        return (LocalCache$EntryFactory[]) b.clone();
    }

    public y b(LocalCache$Segment localCache$Segment, y yVar, y yVar2, Object obj) {
        return d(localCache$Segment, obj, yVar.g(), yVar2);
    }

    public abstract y d(LocalCache$Segment localCache$Segment, Object obj, int i, y yVar);
}
