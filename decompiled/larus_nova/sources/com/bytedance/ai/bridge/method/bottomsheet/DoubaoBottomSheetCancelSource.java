package com.bytedance.ai.bridge.method.bottomsheet;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/bridge/method/bottomsheet/DoubaoBottomSheetCancelSource;", "", "<init>", "(Ljava/lang/String;I)V", "MASK", "GESTURE", "HOST_UNAVAILABLE", "UNKNOWN", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoubaoBottomSheetCancelSource extends Enum<DoubaoBottomSheetCancelSource> {
    public static final DoubaoBottomSheetCancelSource GESTURE = null;
    public static final DoubaoBottomSheetCancelSource HOST_UNAVAILABLE = null;
    public static final DoubaoBottomSheetCancelSource MASK = null;
    public static final DoubaoBottomSheetCancelSource UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoubaoBottomSheetCancelSource[] f35360a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f35361b = null;

    public static EnumEntries<DoubaoBottomSheetCancelSource> getEntries() {
        return f35361b;
    }

    static {
        DoubaoBottomSheetCancelSource r100 = new DoubaoBottomSheetCancelSource("MASK", 0);
        MASK = r100;
        DoubaoBottomSheetCancelSource r101 = new DoubaoBottomSheetCancelSource("GESTURE", 1);
        GESTURE = r101;
        DoubaoBottomSheetCancelSource r102 = new DoubaoBottomSheetCancelSource("HOST_UNAVAILABLE", 2);
        HOST_UNAVAILABLE = r102;
        DoubaoBottomSheetCancelSource r103 = new DoubaoBottomSheetCancelSource("UNKNOWN", 3);
        UNKNOWN = r103;
        DoubaoBottomSheetCancelSource[] r104 = {r100, r101, r102, r103};
        f35360a = r104;
        f35361b = EnumEntriesKt.enumEntries(r104);
    }

    public static DoubaoBottomSheetCancelSource[] values() {
        return (DoubaoBottomSheetCancelSource[]) f35360a.clone();
    }

    public static DoubaoBottomSheetCancelSource valueOf(String r100) {
        return (DoubaoBottomSheetCancelSource) r27.a.a(DoubaoBottomSheetCancelSource.class, r100);
    }

    public DoubaoBottomSheetCancelSource(String r100, int r101) {
        super(r100, r101);
    }
}
