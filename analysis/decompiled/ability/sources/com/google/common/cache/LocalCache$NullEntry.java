package com.google.common.cache;

import l3.r;
import l3.y;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
final class LocalCache$NullEntry implements y {

    /* renamed from: a, reason: collision with root package name */
    public static final LocalCache$NullEntry f2729a;
    public static final /* synthetic */ LocalCache$NullEntry[] b;

    static {
        LocalCache$NullEntry localCache$NullEntry = new LocalCache$NullEntry("INSTANCE", 0);
        f2729a = localCache$NullEntry;
        b = new LocalCache$NullEntry[]{localCache$NullEntry};
    }

    public static LocalCache$NullEntry valueOf(String str) {
        return (LocalCache$NullEntry) Enum.valueOf(LocalCache$NullEntry.class, str);
    }

    public static LocalCache$NullEntry[] values() {
        return (LocalCache$NullEntry[]) b.clone();
    }

    @Override // l3.y
    public final void a(y yVar) {
    }

    @Override // l3.y
    public final y b() {
        return this;
    }

    @Override // l3.y
    public final y c() {
        return this;
    }

    @Override // l3.y
    public final r d() {
        return null;
    }

    @Override // l3.y
    public final y e() {
        return this;
    }

    @Override // l3.y
    public final y f() {
        return this;
    }

    @Override // l3.y
    public final int g() {
        return 0;
    }

    @Override // l3.y
    public final Object getKey() {
        return null;
    }

    @Override // l3.y
    public final y getNext() {
        return null;
    }

    @Override // l3.y
    public final long h() {
        return 0L;
    }

    @Override // l3.y
    public final void i(y yVar) {
    }

    @Override // l3.y
    public final void j(long j5) {
    }

    @Override // l3.y
    public final void k(r rVar) {
    }

    @Override // l3.y
    public final long l() {
        return 0L;
    }

    @Override // l3.y
    public final void m(long j5) {
    }

    @Override // l3.y
    public final void n(y yVar) {
    }

    @Override // l3.y
    public final void o(y yVar) {
    }
}
