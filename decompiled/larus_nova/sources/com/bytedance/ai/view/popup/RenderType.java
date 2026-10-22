package com.bytedance.ai.view.popup;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/view/popup/RenderType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "WEB", "LYNX", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RenderType extends Enum<RenderType> {
    public static final RenderType LYNX = null;
    public static final RenderType UNKNOWN = null;
    public static final RenderType WEB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RenderType[] f37823a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f37824b = null;

    public static EnumEntries<RenderType> getEntries() {
        return f37824b;
    }

    static {
        RenderType r100 = new RenderType("UNKNOWN", 0);
        UNKNOWN = r100;
        RenderType r101 = new RenderType("WEB", 1);
        WEB = r101;
        RenderType r102 = new RenderType("LYNX", 2);
        LYNX = r102;
        RenderType[] r103 = {r100, r101, r102};
        f37823a = r103;
        f37824b = EnumEntriesKt.enumEntries(r103);
    }

    public static RenderType[] values() {
        return (RenderType[]) f37823a.clone();
    }

    public static RenderType valueOf(String r100) {
        return (RenderType) r27.a.a(RenderType.class, r100);
    }

    public RenderType(String r100, int r101) {
        super(r100, r101);
    }
}
