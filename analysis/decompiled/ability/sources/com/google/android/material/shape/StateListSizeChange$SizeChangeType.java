package com.google.android.material.shape;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class StateListSizeChange$SizeChangeType {

    /* renamed from: a, reason: collision with root package name */
    public static final StateListSizeChange$SizeChangeType f2508a;
    public static final StateListSizeChange$SizeChangeType b;
    public static final /* synthetic */ StateListSizeChange$SizeChangeType[] c;

    static {
        StateListSizeChange$SizeChangeType stateListSizeChange$SizeChangeType = new StateListSizeChange$SizeChangeType("PERCENT", 0);
        f2508a = stateListSizeChange$SizeChangeType;
        StateListSizeChange$SizeChangeType stateListSizeChange$SizeChangeType2 = new StateListSizeChange$SizeChangeType("PIXELS", 1);
        b = stateListSizeChange$SizeChangeType2;
        c = new StateListSizeChange$SizeChangeType[]{stateListSizeChange$SizeChangeType, stateListSizeChange$SizeChangeType2};
    }

    public static StateListSizeChange$SizeChangeType valueOf(String str) {
        return (StateListSizeChange$SizeChangeType) Enum.valueOf(StateListSizeChange$SizeChangeType.class, str);
    }

    public static StateListSizeChange$SizeChangeType[] values() {
        return (StateListSizeChange$SizeChangeType[]) c.clone();
    }
}
