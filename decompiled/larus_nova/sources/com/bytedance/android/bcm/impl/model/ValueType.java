package com.bytedance.android.bcm.impl.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/bcm/impl/model/ValueType;", "", "", "value", "I", "getValue", "()I", "UNDEFINED", "INT", "STRING", "bcm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final enum ValueType extends Enum<ValueType> {
    public static final ValueType INT = null;
    public static final ValueType STRING = null;
    public static final ValueType UNDEFINED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ValueType[] f41817a = null;
    private final int value;

    static {
        ValueType r100 = new ValueType("UNDEFINED", 0, 0);
        UNDEFINED = r100;
        ValueType r101 = new ValueType("INT", 1, 1);
        INT = r101;
        ValueType r102 = new ValueType("STRING", 2, 2);
        STRING = r102;
        f41817a = new ValueType[]{r100, r101, r102};
    }

    public static ValueType valueOf(String r100) {
        return (ValueType) r27.a.a(ValueType.class, r100);
    }

    public static ValueType[] values() {
        return (ValueType[]) f41817a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ValueType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
