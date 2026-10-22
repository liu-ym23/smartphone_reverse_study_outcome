package com.stepos.core.common.atomic;

import com.stepos.core.download.ModelFlowMeta;
import com.stepos.core.ota.d;
import h0.e;
import kotlin.jvm.internal.g;
import sb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AtomicDispatchResult {
    private final long elapsedMs;
    private final int errorCode;
    private final String errorMsg;
    private final String executor;
    private final String resultJson;
    private final Status status;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Status {
        private static final /* synthetic */ a $ENTRIES;
        private static final /* synthetic */ Status[] $VALUES;
        public static final Status DISPATCHED = new Status("DISPATCHED", 0);
        public static final Status SUCCESS = new Status("SUCCESS", 1);
        public static final Status FAILED = new Status("FAILED", 2);
        public static final Status UNAVAILABLE = new Status(ModelFlowMeta.PLAN_UNAVAILABLE, 3);
        public static final Status NOT_DISPATCHED = new Status("NOT_DISPATCHED", 4);

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{DISPATCHED, SUCCESS, FAILED, UNAVAILABLE, NOT_DISPATCHED};
        }

        static {
            Status[] statusArr$values = $values();
            $VALUES = statusArr$values;
            $ENTRIES = kotlin.enums.a.a(statusArr$values);
        }

        private Status(String str, int i10) {
        }

        public static a<Status> getEntries() {
            return $ENTRIES;
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }
    }

    public AtomicDispatchResult(String executor, Status status, int i10, String str, String str2, long j10) {
        g.f(executor, "executor");
        g.f(status, "status");
        this.executor = executor;
        this.status = status;
        this.errorCode = i10;
        this.errorMsg = str;
        this.resultJson = str2;
        this.elapsedMs = j10;
    }

    public static /* synthetic */ AtomicDispatchResult copy$default(AtomicDispatchResult atomicDispatchResult, String str, Status status, int i10, String str2, String str3, long j10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = atomicDispatchResult.executor;
        }
        if ((i11 & 2) != 0) {
            status = atomicDispatchResult.status;
        }
        if ((i11 & 4) != 0) {
            i10 = atomicDispatchResult.errorCode;
        }
        if ((i11 & 8) != 0) {
            str2 = atomicDispatchResult.errorMsg;
        }
        if ((i11 & 16) != 0) {
            str3 = atomicDispatchResult.resultJson;
        }
        if ((i11 & 32) != 0) {
            j10 = atomicDispatchResult.elapsedMs;
        }
        long j11 = j10;
        String str4 = str3;
        int i12 = i10;
        return atomicDispatchResult.copy(str, status, i12, str2, str4, j11);
    }

    public final String component1() {
        return this.executor;
    }

    public final Status component2() {
        return this.status;
    }

    public final int component3() {
        return this.errorCode;
    }

    public final String component4() {
        return this.errorMsg;
    }

    public final String component5() {
        return this.resultJson;
    }

    public final long component6() {
        return this.elapsedMs;
    }

    public final AtomicDispatchResult copy(String executor, Status status, int i10, String str, String str2, long j10) {
        g.f(executor, "executor");
        g.f(status, "status");
        return new AtomicDispatchResult(executor, status, i10, str, str2, j10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AtomicDispatchResult)) {
            return false;
        }
        AtomicDispatchResult atomicDispatchResult = (AtomicDispatchResult) obj;
        return g.b(this.executor, atomicDispatchResult.executor) && this.status == atomicDispatchResult.status && this.errorCode == atomicDispatchResult.errorCode && g.b(this.errorMsg, atomicDispatchResult.errorMsg) && g.b(this.resultJson, atomicDispatchResult.resultJson) && this.elapsedMs == atomicDispatchResult.elapsedMs;
    }

    public final long getElapsedMs() {
        return this.elapsedMs;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final String getExecutor() {
        return this.executor;
    }

    public final String getResultJson() {
        return this.resultJson;
    }

    public final Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        int iD = ai.onnxruntime.a.d(this.errorCode, (this.status.hashCode() + (this.executor.hashCode() * 31)) * 31, 31);
        String str = this.errorMsg;
        int iHashCode = (iD + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.resultJson;
        return Long.hashCode(this.elapsedMs) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public String toString() {
        String str = this.executor;
        Status status = this.status;
        int i10 = this.errorCode;
        String str2 = this.errorMsg;
        String str3 = this.resultJson;
        long j10 = this.elapsedMs;
        StringBuilder sb2 = new StringBuilder("AtomicDispatchResult(executor=");
        sb2.append(str);
        sb2.append(", status=");
        sb2.append(status);
        sb2.append(", errorCode=");
        e.h(i10, ", errorMsg=", str2, ", resultJson=", sb2);
        d.p(j10, str3, ", elapsedMs=", sb2);
        sb2.append(")");
        return sb2.toString();
    }

    public /* synthetic */ AtomicDispatchResult(String str, Status status, int i10, String str2, String str3, long j10, int i11, kotlin.jvm.internal.e eVar) {
        this(str, status, (i11 & 4) != 0 ? 0 : i10, (i11 & 8) != 0 ? null : str2, (i11 & 16) != 0 ? null : str3, (i11 & 32) != 0 ? 0L : j10);
    }
}
