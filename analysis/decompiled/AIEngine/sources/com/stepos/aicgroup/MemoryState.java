package com.stepos.aicgroup;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MemoryState {
    public static final MemoryState LOW;
    public static final MemoryState MODERATE;
    public static final MemoryState NORMAL;
    public static final MemoryState ULTRA_LOW;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ MemoryState[] f5648b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ sb.a f5649c;

    /* renamed from: a, reason: collision with root package name */
    public final int f5650a;

    static {
        MemoryState memoryState = new MemoryState("NORMAL", 0, 0);
        NORMAL = memoryState;
        MemoryState memoryState2 = new MemoryState("MODERATE", 1, 1);
        MODERATE = memoryState2;
        MemoryState memoryState3 = new MemoryState("LOW", 2, 2);
        LOW = memoryState3;
        MemoryState memoryState4 = new MemoryState("ULTRA_LOW", 3, 3);
        ULTRA_LOW = memoryState4;
        MemoryState[] memoryStateArr = {memoryState, memoryState2, memoryState3, memoryState4};
        f5648b = memoryStateArr;
        f5649c = kotlin.enums.a.a(memoryStateArr);
    }

    public MemoryState(String str, int i10, int i11) {
        this.f5650a = i11;
    }

    public static sb.a<MemoryState> getEntries() {
        return f5649c;
    }

    public static MemoryState valueOf(String str) {
        return (MemoryState) Enum.valueOf(MemoryState.class, str);
    }

    public static MemoryState[] values() {
        return (MemoryState[]) f5648b.clone();
    }

    public final int getLevel() {
        return this.f5650a;
    }
}
