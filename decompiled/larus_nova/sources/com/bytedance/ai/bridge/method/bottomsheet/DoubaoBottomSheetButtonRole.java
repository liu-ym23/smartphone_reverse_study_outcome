package com.bytedance.ai.bridge.method.bottomsheet;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/method/bottomsheet/DoubaoBottomSheetButtonRole;", "", "<init>", "(Ljava/lang/String;I)V", "AGREE_MAIN", "AGREE_SUB", "REJECT", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoubaoBottomSheetButtonRole extends Enum<DoubaoBottomSheetButtonRole> {
    public static final DoubaoBottomSheetButtonRole AGREE_MAIN = null;
    public static final DoubaoBottomSheetButtonRole AGREE_SUB = null;
    public static final DoubaoBottomSheetButtonRole REJECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoubaoBottomSheetButtonRole[] f35358a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f35359b = null;

    public static EnumEntries<DoubaoBottomSheetButtonRole> getEntries() {
        return f35359b;
    }

    static {
        DoubaoBottomSheetButtonRole r100 = new DoubaoBottomSheetButtonRole("AGREE_MAIN", 0);
        AGREE_MAIN = r100;
        DoubaoBottomSheetButtonRole r101 = new DoubaoBottomSheetButtonRole("AGREE_SUB", 1);
        AGREE_SUB = r101;
        DoubaoBottomSheetButtonRole r102 = new DoubaoBottomSheetButtonRole("REJECT", 2);
        REJECT = r102;
        DoubaoBottomSheetButtonRole[] r103 = {r100, r101, r102};
        f35358a = r103;
        f35359b = EnumEntriesKt.enumEntries(r103);
    }

    public static DoubaoBottomSheetButtonRole[] values() {
        return (DoubaoBottomSheetButtonRole[]) f35358a.clone();
    }

    public static DoubaoBottomSheetButtonRole valueOf(String r100) {
        return (DoubaoBottomSheetButtonRole) r27.a.a(DoubaoBottomSheetButtonRole.class, r100);
    }

    public DoubaoBottomSheetButtonRole(String r100, int r101) {
        super(r100, r101);
    }
}
