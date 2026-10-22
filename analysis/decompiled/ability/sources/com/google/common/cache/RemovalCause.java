package com.google.common.cache;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public abstract class RemovalCause {

    /* renamed from: a, reason: collision with root package name */
    public static final RemovalCause f2733a;
    public static final RemovalCause b;
    public static final RemovalCause c;
    public static final RemovalCause d;
    public static final RemovalCause e;
    public static final /* synthetic */ RemovalCause[] f;

    static {
        RemovalCause removalCause = new RemovalCause() { // from class: com.google.common.cache.RemovalCause.1
            @Override // com.google.common.cache.RemovalCause
            public final boolean a() {
                return false;
            }
        };
        f2733a = removalCause;
        RemovalCause removalCause2 = new RemovalCause() { // from class: com.google.common.cache.RemovalCause.2
            @Override // com.google.common.cache.RemovalCause
            public final boolean a() {
                return false;
            }
        };
        b = removalCause2;
        RemovalCause removalCause3 = new RemovalCause() { // from class: com.google.common.cache.RemovalCause.3
            @Override // com.google.common.cache.RemovalCause
            public final boolean a() {
                return true;
            }
        };
        c = removalCause3;
        RemovalCause removalCause4 = new RemovalCause() { // from class: com.google.common.cache.RemovalCause.4
            @Override // com.google.common.cache.RemovalCause
            public final boolean a() {
                return true;
            }
        };
        d = removalCause4;
        RemovalCause removalCause5 = new RemovalCause() { // from class: com.google.common.cache.RemovalCause.5
            @Override // com.google.common.cache.RemovalCause
            public final boolean a() {
                return true;
            }
        };
        e = removalCause5;
        f = new RemovalCause[]{removalCause, removalCause2, removalCause3, removalCause4, removalCause5};
    }

    public static RemovalCause valueOf(String str) {
        return (RemovalCause) Enum.valueOf(RemovalCause.class, str);
    }

    public static RemovalCause[] values() {
        return (RemovalCause[]) f.clone();
    }

    public abstract boolean a();
}
