package com.bytedance.ai.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/api/AppletBottomSheetAction;", "", "<init>", "(Ljava/lang/String;I)V", "BUTTON_CLICK", "CANCEL", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletBottomSheetAction extends Enum<AppletBottomSheetAction> {
    public static final AppletBottomSheetAction BUTTON_CLICK = null;
    public static final AppletBottomSheetAction CANCEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppletBottomSheetAction[] f33955a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f33956b = null;

    public static EnumEntries<AppletBottomSheetAction> getEntries() {
        return f33956b;
    }

    static {
        AppletBottomSheetAction r100 = new AppletBottomSheetAction("BUTTON_CLICK", 0);
        BUTTON_CLICK = r100;
        AppletBottomSheetAction r101 = new AppletBottomSheetAction("CANCEL", 1);
        CANCEL = r101;
        AppletBottomSheetAction[] r102 = {r100, r101};
        f33955a = r102;
        f33956b = EnumEntriesKt.enumEntries(r102);
    }

    public static AppletBottomSheetAction[] values() {
        return (AppletBottomSheetAction[]) f33955a.clone();
    }

    public static AppletBottomSheetAction valueOf(String r100) {
        return (AppletBottomSheetAction) r27.a.a(AppletBottomSheetAction.class, r100);
    }

    public AppletBottomSheetAction(String r100, int r101) {
        super(r100, r101);
    }
}
