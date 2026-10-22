package com.bytedance.ai.model.worker;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/model/worker/WorkerType;", "", "<init>", "(Ljava/lang/String;I)V", "JAVASCRIPT", "LYNX", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WorkerType extends Enum<WorkerType> {
    public static final WorkerType JAVASCRIPT = null;
    public static final WorkerType LYNX = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WorkerType[] f37109a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f37110b = null;

    public static EnumEntries<WorkerType> getEntries() {
        return f37110b;
    }

    static {
        WorkerType r100 = new WorkerType("JAVASCRIPT", 0);
        JAVASCRIPT = r100;
        WorkerType r101 = new WorkerType("LYNX", 1);
        LYNX = r101;
        WorkerType[] r102 = {r100, r101};
        f37109a = r102;
        f37110b = EnumEntriesKt.enumEntries(r102);
    }

    public static WorkerType[] values() {
        return (WorkerType[]) f37109a.clone();
    }

    public static WorkerType valueOf(String r100) {
        return (WorkerType) a.a(WorkerType.class, r100);
    }

    public WorkerType(String r100, int r101) {
        super(r100, r101);
    }
}
