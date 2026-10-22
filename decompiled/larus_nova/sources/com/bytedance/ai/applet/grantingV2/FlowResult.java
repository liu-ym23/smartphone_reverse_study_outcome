package com.bytedance.ai.applet.grantingV2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/applet/grantingV2/FlowResult;", "", "<init>", "(Ljava/lang/String;I)V", "REQUIRES_CONFIRMATION", "CONTINUE_NEXT", "STOP_FLOW", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowResult extends Enum<FlowResult> {
    public static final FlowResult CONTINUE_NEXT = null;
    public static final FlowResult REQUIRES_CONFIRMATION = null;
    public static final FlowResult STOP_FLOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowResult[] f34639a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34640b = null;

    public static EnumEntries<FlowResult> getEntries() {
        return f34640b;
    }

    static {
        FlowResult r100 = new FlowResult("REQUIRES_CONFIRMATION", 0);
        REQUIRES_CONFIRMATION = r100;
        FlowResult r101 = new FlowResult("CONTINUE_NEXT", 1);
        CONTINUE_NEXT = r101;
        FlowResult r102 = new FlowResult("STOP_FLOW", 2);
        STOP_FLOW = r102;
        FlowResult[] r103 = {r100, r101, r102};
        f34639a = r103;
        f34640b = EnumEntriesKt.enumEntries(r103);
    }

    public static FlowResult[] values() {
        return (FlowResult[]) f34639a.clone();
    }

    public static FlowResult valueOf(String r100) {
        return (FlowResult) r27.a.a(FlowResult.class, r100);
    }

    public FlowResult(String r100, int r101) {
        super(r100, r101);
    }
}
