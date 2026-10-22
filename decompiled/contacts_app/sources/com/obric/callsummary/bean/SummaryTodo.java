package com.obric.callsummary.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SummaryData.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/callsummary/bean/SummaryTodo;", "", "task", "", "(Ljava/lang/String;)V", "getTask", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SummaryTodo {

    @SerializedName("task")
    private final String task;

    /* JADX WARN: Multi-variable type inference failed */
    public SummaryTodo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SummaryTodo copy$default(SummaryTodo r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.task;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.task;
    }

    public final SummaryTodo copy(String r1) {
        Intrinsics.checkNotNullParameter(r1, "task");
        return new SummaryTodo(r1);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof SummaryTodo) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.task, ((SummaryTodo) r4).task) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.task.hashCode();
    }

    public String toString() {
        return "SummaryTodo(task=" + this.task + ')';
    }

    public SummaryTodo(String r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
        this.task = r2;
    }

    public /* synthetic */ SummaryTodo(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "";
    L5:
        this(r1);
    }

    public final String getTask() {
        return this.task;
    }
}
