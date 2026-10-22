package com.bytedance.android.shopping.feedbackpanel.enums;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/feedbackpanel/enums/WhereType;", "", "GROUP_TOP", "GROUP_MID", "GROUP_BOTTOM", "GROUP_ONLY_ONE", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WhereType extends Enum<WhereType> {
    public static final WhereType GROUP_BOTTOM = null;
    public static final WhereType GROUP_MID = null;
    public static final WhereType GROUP_ONLY_ONE = null;
    public static final WhereType GROUP_TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WhereType[] f176099a = null;

    static {
        WhereType r100 = new WhereType("GROUP_TOP", 0);
        GROUP_TOP = r100;
        WhereType r101 = new WhereType("GROUP_MID", 1);
        GROUP_MID = r101;
        WhereType r102 = new WhereType("GROUP_BOTTOM", 2);
        GROUP_BOTTOM = r102;
        WhereType r103 = new WhereType("GROUP_ONLY_ONE", 3);
        GROUP_ONLY_ONE = r103;
        f176099a = new WhereType[]{r100, r101, r102, r103};
    }

    public static WhereType valueOf(String r100) {
        return (WhereType) a.a(WhereType.class, r100);
    }

    public static WhereType[] values() {
        return (WhereType[]) f176099a.clone();
    }

    public WhereType(String r100, int r101) {
        super(r100, r101);
    }
}
