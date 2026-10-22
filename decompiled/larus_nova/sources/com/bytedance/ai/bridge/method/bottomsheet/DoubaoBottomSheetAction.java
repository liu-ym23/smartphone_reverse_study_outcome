package com.bytedance.ai.bridge.method.bottomsheet;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/bridge/method/bottomsheet/DoubaoBottomSheetAction;", "", "<init>", "(Ljava/lang/String;I)V", "BUTTON_CLICK", "CANCEL", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoubaoBottomSheetAction extends Enum<DoubaoBottomSheetAction> {
    public static final DoubaoBottomSheetAction BUTTON_CLICK = null;
    public static final DoubaoBottomSheetAction CANCEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoubaoBottomSheetAction[] f35356a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f35357b = null;

    public static EnumEntries<DoubaoBottomSheetAction> getEntries() {
        return f35357b;
    }

    static {
        DoubaoBottomSheetAction r100 = new DoubaoBottomSheetAction("BUTTON_CLICK", 0);
        BUTTON_CLICK = r100;
        DoubaoBottomSheetAction r101 = new DoubaoBottomSheetAction("CANCEL", 1);
        CANCEL = r101;
        DoubaoBottomSheetAction[] r102 = {r100, r101};
        f35356a = r102;
        f35357b = EnumEntriesKt.enumEntries(r102);
    }

    public static DoubaoBottomSheetAction[] values() {
        return (DoubaoBottomSheetAction[]) f35356a.clone();
    }

    public static DoubaoBottomSheetAction valueOf(String r100) {
        return (DoubaoBottomSheetAction) r27.a.a(DoubaoBottomSheetAction.class, r100);
    }

    public DoubaoBottomSheetAction(String r100, int r101) {
        super(r100, r101);
    }
}
