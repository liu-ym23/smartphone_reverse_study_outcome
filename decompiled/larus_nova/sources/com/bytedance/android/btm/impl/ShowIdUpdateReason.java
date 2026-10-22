package com.bytedance.android.btm.impl;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/btm/impl/ShowIdUpdateReason;", "", "(Ljava/lang/String;I)V", "ActivityPreStart", "ActivityPreResume", "ManualPageShow", "PageInfoResume", "btm-impl_cnRelease"}, k = 1, mv = {1, 1, 16})
public final enum ShowIdUpdateReason extends Enum<ShowIdUpdateReason> {
    private static final /* synthetic */ ShowIdUpdateReason[] $VALUES = null;
    public static final ShowIdUpdateReason ActivityPreResume = null;
    public static final ShowIdUpdateReason ActivityPreStart = null;
    public static final ShowIdUpdateReason ManualPageShow = null;
    public static final ShowIdUpdateReason PageInfoResume = null;

    static {
        ShowIdUpdateReason r100 = new ShowIdUpdateReason("ActivityPreStart", 0);
        ActivityPreStart = r100;
        ShowIdUpdateReason r101 = new ShowIdUpdateReason("ActivityPreResume", 1);
        ActivityPreResume = r101;
        ShowIdUpdateReason r102 = new ShowIdUpdateReason("ManualPageShow", 2);
        ManualPageShow = r102;
        ShowIdUpdateReason r103 = new ShowIdUpdateReason("PageInfoResume", 3);
        PageInfoResume = r103;
        $VALUES = new ShowIdUpdateReason[]{r100, r101, r102, r103};
    }

    public static ShowIdUpdateReason valueOf(String r100) {
        return (ShowIdUpdateReason) r27.a.a(ShowIdUpdateReason.class, r100);
    }

    public static ShowIdUpdateReason[] values() {
        return (ShowIdUpdateReason[]) $VALUES.clone();
    }

    private ShowIdUpdateReason(String r100, int r101) {
        super(r100, r101);
    }
}
