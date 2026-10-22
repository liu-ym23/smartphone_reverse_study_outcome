package com.bytedance.android.live.ktv.common.karaokestation.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/model/SecondLevelTabViewSelectedType;", "", "", "value", "I", "getValue", "()I", "Default", "CLICK", "SLIDE", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SecondLevelTabViewSelectedType extends Enum<SecondLevelTabViewSelectedType> {
    public static final SecondLevelTabViewSelectedType CLICK = null;
    public static final SecondLevelTabViewSelectedType Default = null;
    public static final SecondLevelTabViewSelectedType SLIDE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SecondLevelTabViewSelectedType[] f69493a = null;
    private final int value;

    static {
        SecondLevelTabViewSelectedType r100 = new SecondLevelTabViewSelectedType("Default", 0, 0);
        Default = r100;
        SecondLevelTabViewSelectedType r101 = new SecondLevelTabViewSelectedType("CLICK", 1, 1);
        CLICK = r101;
        SecondLevelTabViewSelectedType r102 = new SecondLevelTabViewSelectedType("SLIDE", 2, 2);
        SLIDE = r102;
        f69493a = new SecondLevelTabViewSelectedType[]{r100, r101, r102};
    }

    public static SecondLevelTabViewSelectedType valueOf(String r100) {
        return (SecondLevelTabViewSelectedType) r27.a.a(SecondLevelTabViewSelectedType.class, r100);
    }

    public static SecondLevelTabViewSelectedType[] values() {
        return (SecondLevelTabViewSelectedType[]) f69493a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public SecondLevelTabViewSelectedType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
