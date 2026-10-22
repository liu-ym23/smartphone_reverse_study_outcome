package com.bytedance.android.btm.impl.page.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/btm/impl/page/model/Flag;", "", "NOT_SURE", "FORWARD", "BACK", "BACKGROUND", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final enum Flag extends Enum<Flag> {
    public static final Flag BACK = null;
    public static final Flag BACKGROUND = null;
    public static final Flag FORWARD = null;
    public static final Flag NOT_SURE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Flag[] f42322a = null;

    static {
        Flag r100 = new Flag("NOT_SURE", 0);
        NOT_SURE = r100;
        Flag r101 = new Flag("FORWARD", 1);
        FORWARD = r101;
        Flag r102 = new Flag("BACK", 2);
        BACK = r102;
        Flag r103 = new Flag("BACKGROUND", 3);
        BACKGROUND = r103;
        f42322a = new Flag[]{r100, r101, r102, r103};
    }

    public static Flag valueOf(String r100) {
        return (Flag) r27.a.a(Flag.class, r100);
    }

    public static Flag[] values() {
        return (Flag[]) f42322a.clone();
    }

    public Flag(String r100, int r101) {
        super(r100, r101);
    }
}
