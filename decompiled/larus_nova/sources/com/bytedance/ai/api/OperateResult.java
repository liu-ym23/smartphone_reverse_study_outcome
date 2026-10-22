package com.bytedance.ai.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/api/OperateResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "REJECT", "CANCEL", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OperateResult extends Enum<OperateResult> {
    public static final OperateResult CANCEL = null;
    public static final OperateResult REJECT = null;
    public static final OperateResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OperateResult[] f33976a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f33977b = null;

    public static EnumEntries<OperateResult> getEntries() {
        return f33977b;
    }

    static {
        OperateResult r100 = new OperateResult("SUCCESS", 0);
        SUCCESS = r100;
        OperateResult r101 = new OperateResult("REJECT", 1);
        REJECT = r101;
        OperateResult r102 = new OperateResult("CANCEL", 2);
        CANCEL = r102;
        OperateResult[] r103 = {r100, r101, r102};
        f33976a = r103;
        f33977b = EnumEntriesKt.enumEntries(r103);
    }

    public static OperateResult[] values() {
        return (OperateResult[]) f33976a.clone();
    }

    public static OperateResult valueOf(String r100) {
        return (OperateResult) r27.a.a(OperateResult.class, r100);
    }

    public OperateResult(String r100, int r101) {
        super(r100, r101);
    }
}
