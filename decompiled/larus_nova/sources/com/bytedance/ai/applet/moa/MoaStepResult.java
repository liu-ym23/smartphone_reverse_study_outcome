package com.bytedance.ai.applet.moa;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/applet/moa/MoaStepResult;", "", "<init>", "(Ljava/lang/String;I)V", "CONTINUE", "REFUSED", "FAILED", "REQUIRES_CONFIRMATION", "WAITING_ACTION", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MoaStepResult extends Enum<MoaStepResult> {
    public static final MoaStepResult CONTINUE = null;
    public static final MoaStepResult FAILED = null;
    public static final MoaStepResult REFUSED = null;
    public static final MoaStepResult REQUIRES_CONFIRMATION = null;
    public static final MoaStepResult WAITING_ACTION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MoaStepResult[] f34831a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34832b = null;

    public static EnumEntries<MoaStepResult> getEntries() {
        return f34832b;
    }

    static {
        MoaStepResult r100 = new MoaStepResult("CONTINUE", 0);
        CONTINUE = r100;
        MoaStepResult r101 = new MoaStepResult("REFUSED", 1);
        REFUSED = r101;
        MoaStepResult r102 = new MoaStepResult("FAILED", 2);
        FAILED = r102;
        MoaStepResult r103 = new MoaStepResult("REQUIRES_CONFIRMATION", 3);
        REQUIRES_CONFIRMATION = r103;
        MoaStepResult r104 = new MoaStepResult("WAITING_ACTION", 4);
        WAITING_ACTION = r104;
        MoaStepResult[] r105 = {r100, r101, r102, r103, r104};
        f34831a = r105;
        f34832b = EnumEntriesKt.enumEntries(r105);
    }

    public static MoaStepResult[] values() {
        return (MoaStepResult[]) f34831a.clone();
    }

    public static MoaStepResult valueOf(String r100) {
        return (MoaStepResult) r27.a.a(MoaStepResult.class, r100);
    }

    public MoaStepResult(String r100, int r101) {
        super(r100, r101);
    }
}
