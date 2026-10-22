package com.bytedance.ai.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/api/AppletBottomSheetButtonRole;", "", "<init>", "(Ljava/lang/String;I)V", "AGREE_MAIN", "AGREE_SUB", "REJECT", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletBottomSheetButtonRole extends Enum<AppletBottomSheetButtonRole> {
    public static final AppletBottomSheetButtonRole AGREE_MAIN = null;
    public static final AppletBottomSheetButtonRole AGREE_SUB = null;
    public static final AppletBottomSheetButtonRole REJECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppletBottomSheetButtonRole[] f33957a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f33958b = null;

    public static EnumEntries<AppletBottomSheetButtonRole> getEntries() {
        return f33958b;
    }

    static {
        AppletBottomSheetButtonRole r100 = new AppletBottomSheetButtonRole("AGREE_MAIN", 0);
        AGREE_MAIN = r100;
        AppletBottomSheetButtonRole r101 = new AppletBottomSheetButtonRole("AGREE_SUB", 1);
        AGREE_SUB = r101;
        AppletBottomSheetButtonRole r102 = new AppletBottomSheetButtonRole("REJECT", 2);
        REJECT = r102;
        AppletBottomSheetButtonRole[] r103 = {r100, r101, r102};
        f33957a = r103;
        f33958b = EnumEntriesKt.enumEntries(r103);
    }

    public static AppletBottomSheetButtonRole[] values() {
        return (AppletBottomSheetButtonRole[]) f33957a.clone();
    }

    public static AppletBottomSheetButtonRole valueOf(String r100) {
        return (AppletBottomSheetButtonRole) r27.a.a(AppletBottomSheetButtonRole.class, r100);
    }

    public AppletBottomSheetButtonRole(String r100, int r101) {
        super(r100, r101);
    }
}
