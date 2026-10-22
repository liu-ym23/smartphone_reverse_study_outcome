package com.bytedance.ai.monitor.timeline;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/monitor/timeline/CallFrom;", "", "status", "", "<init>", "(Ljava/lang/String;II)V", "getStatus", "()I", "FROM_WORKER", "FROM_WORKER_FALLBACK", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CallFrom extends Enum<CallFrom> {
    public static final CallFrom FROM_WORKER = null;
    public static final CallFrom FROM_WORKER_FALLBACK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CallFrom[] f37203a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f37204b = null;
    private final int status;

    public static EnumEntries<CallFrom> getEntries() {
        return f37204b;
    }

    static {
        CallFrom r100 = new CallFrom("FROM_WORKER", 0, 1);
        FROM_WORKER = r100;
        CallFrom r101 = new CallFrom("FROM_WORKER_FALLBACK", 1, 2);
        FROM_WORKER_FALLBACK = r101;
        CallFrom[] r102 = {r100, r101};
        f37203a = r102;
        f37204b = EnumEntriesKt.enumEntries(r102);
    }

    public static CallFrom[] values() {
        return (CallFrom[]) f37203a.clone();
    }

    public final int getStatus() {
        return this.status;
    }

    public static CallFrom valueOf(String r100) {
        return (CallFrom) a.a(CallFrom.class, r100);
    }

    public CallFrom(String r100, int r101, int r102) {
        super(r100, r101);
        this.status = r102;
    }
}
