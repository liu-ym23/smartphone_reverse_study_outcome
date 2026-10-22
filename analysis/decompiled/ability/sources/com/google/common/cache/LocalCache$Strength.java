package com.google.common.cache;

import l3.m;
import l3.q;
import l3.r;
import l3.w;
import l3.y;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
abstract class LocalCache$Strength {

    /* renamed from: a, reason: collision with root package name */
    public static final AnonymousClass1 f2732a;
    public static final AnonymousClass3 b;
    public static final /* synthetic */ LocalCache$Strength[] c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.cache.LocalCache$Strength$1] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.common.cache.LocalCache$Strength$3] */
    static {
        ?? r02 = new LocalCache$Strength() { // from class: com.google.common.cache.LocalCache$Strength.1
            @Override // com.google.common.cache.LocalCache$Strength
            public final com.google.common.base.a a() {
                return com.google.common.base.a.c();
            }

            @Override // com.google.common.cache.LocalCache$Strength
            public final r b(LocalCache$Segment localCache$Segment, y yVar, Object obj) {
                return new q(obj);
            }
        };
        f2732a = r02;
        LocalCache$Strength localCache$Strength = new LocalCache$Strength() { // from class: com.google.common.cache.LocalCache$Strength.2
            @Override // com.google.common.cache.LocalCache$Strength
            public final com.google.common.base.a a() {
                return com.google.common.base.a.e();
            }

            @Override // com.google.common.cache.LocalCache$Strength
            public final r b(LocalCache$Segment localCache$Segment, y yVar, Object obj) {
                return new m(localCache$Segment.i, obj, yVar);
            }
        };
        ?? r22 = new LocalCache$Strength() { // from class: com.google.common.cache.LocalCache$Strength.3
            @Override // com.google.common.cache.LocalCache$Strength
            public final com.google.common.base.a a() {
                return com.google.common.base.a.e();
            }

            @Override // com.google.common.cache.LocalCache$Strength
            public final r b(LocalCache$Segment localCache$Segment, y yVar, Object obj) {
                return new w(localCache$Segment.i, obj, yVar);
            }
        };
        b = r22;
        c = new LocalCache$Strength[]{r02, localCache$Strength, r22};
    }

    public static LocalCache$Strength valueOf(String str) {
        return (LocalCache$Strength) Enum.valueOf(LocalCache$Strength.class, str);
    }

    public static LocalCache$Strength[] values() {
        return (LocalCache$Strength[]) c.clone();
    }

    public abstract com.google.common.base.a a();

    public abstract r b(LocalCache$Segment localCache$Segment, y yVar, Object obj);
}
