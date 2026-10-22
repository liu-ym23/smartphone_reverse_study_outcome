package com.obric.contactprovider.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallSummaryASRMessageBean.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/contactprovider/bean/CallSummaryASRMessageBean;", "", "asrText", "", "name", "durationMs", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "getAsrText", "()Ljava/lang/String;", "getDurationMs", "()J", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallSummaryASRMessageBean {
    private final String asrText;
    private final long durationMs;
    private final String name;

    public static /* synthetic */ CallSummaryASRMessageBean copy$default(CallSummaryASRMessageBean r0, String r1, String r2, long r3, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.asrText;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.name;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.durationMs;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.asrText;
    }

    public final String component2() {
        return this.name;
    }

    public final long component3() {
        return this.durationMs;
    }

    public final CallSummaryASRMessageBean copy(String r1, String r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "asrText");
        Intrinsics.checkNotNullParameter(r2, "name");
        return new CallSummaryASRMessageBean(r1, r2, r3);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if ((r6 instanceof CallSummaryASRMessageBean) == true) goto L8;
        return false;
    L8:
        CallSummaryASRMessageBean r7 = (CallSummaryASRMessageBean) r6;
        if (Intrinsics.areEqual(this.asrText, r7.asrText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r7.name) == true) goto L15;
        return false;
    L15:
        if (this.durationMs == r7.durationMs) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.asrText.hashCode() * 31) + this.name.hashCode()) * 31) + Long.hashCode(this.durationMs);
    }

    public String toString() {
        return "CallSummaryASRMessageBean(asrText=" + this.asrText + ", name=" + this.name + ", durationMs=" + this.durationMs + ')';
    }

    public CallSummaryASRMessageBean(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "asrText");
        Intrinsics.checkNotNullParameter(r3, "name");
        this.asrText = r2;
        this.name = r3;
        this.durationMs = r4;
    }

    public /* synthetic */ CallSummaryASRMessageBean(String r1, String r2, long r3, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L5;
        r3 = 0;
    L5:
        this(r1, r2, r3);
    }

    public final String getAsrText() {
        return this.asrText;
    }

    public final String getName() {
        return this.name;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }
}
