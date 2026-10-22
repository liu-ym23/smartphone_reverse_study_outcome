package com.bytedance.android.ec.hybrid.card.impl;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/hybrid/card/impl/ECLynxLoadType;", "", "DEFAULT", "PRE_CREATE_VIEW", "PRE_LOAD", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECLynxLoadType extends Enum<ECLynxLoadType> {
    public static final ECLynxLoadType DEFAULT = null;
    public static final ECLynxLoadType PRE_CREATE_VIEW = null;
    public static final ECLynxLoadType PRE_LOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECLynxLoadType[] f46519a = null;

    static {
        ECLynxLoadType r100 = new ECLynxLoadType("DEFAULT", 0);
        DEFAULT = r100;
        ECLynxLoadType r101 = new ECLynxLoadType("PRE_CREATE_VIEW", 1);
        PRE_CREATE_VIEW = r101;
        ECLynxLoadType r102 = new ECLynxLoadType("PRE_LOAD", 2);
        PRE_LOAD = r102;
        f46519a = new ECLynxLoadType[]{r100, r101, r102};
    }

    public static ECLynxLoadType valueOf(String r100) {
        return (ECLynxLoadType) r27.a.a(ECLynxLoadType.class, r100);
    }

    public static ECLynxLoadType[] values() {
        return (ECLynxLoadType[]) f46519a.clone();
    }

    public ECLynxLoadType(String r100, int r101) {
        super(r100, r101);
    }
}
