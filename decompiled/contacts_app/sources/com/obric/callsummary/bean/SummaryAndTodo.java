package com.obric.callsummary.bean;

import com.google.gson.annotations.SerializedName;
import com.obric.callsummary.widget.CallSummaryWidget;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SummaryData.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/obric/callsummary/bean/SummaryAndTodo;", "", CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY, "", "title", "tasks", "", "Lcom/obric/callsummary/bean/SummaryTodo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getSummary", "()Ljava/lang/String;", "getTasks", "()Ljava/util/List;", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SummaryAndTodo {

    @SerializedName(CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY)
    private final String summary;

    @SerializedName("tasks")
    private final List<SummaryTodo> tasks;

    @SerializedName("title")
    private final String title;

    public SummaryAndTodo() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SummaryAndTodo copy$default(SummaryAndTodo r0, String r1, String r2, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.summary;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.title;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.tasks;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.summary;
    }

    public final String component2() {
        return this.title;
    }

    public final List<SummaryTodo> component3() {
        return this.tasks;
    }

    public final SummaryAndTodo copy(String r1, String r2, List<SummaryTodo> r3) {
        Intrinsics.checkNotNullParameter(r1, CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY);
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "tasks");
        return new SummaryAndTodo(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SummaryAndTodo) == true) goto L8;
        return false;
    L8:
        SummaryAndTodo r6 = (SummaryAndTodo) r5;
        if (Intrinsics.areEqual(this.summary, r6.summary) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tasks, r6.tasks) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.summary.hashCode() * 31) + this.title.hashCode()) * 31) + this.tasks.hashCode();
    }

    public String toString() {
        return "SummaryAndTodo(summary=" + this.summary + ", title=" + this.title + ", tasks=" + this.tasks + ')';
    }

    public SummaryAndTodo(String r2, String r3, List<SummaryTodo> r4) {
        Intrinsics.checkNotNullParameter(r2, CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY);
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "tasks");
        this.summary = r2;
        this.title = r3;
        this.tasks = r4;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getTitle() {
        return this.title;
    }

    public /* synthetic */ SummaryAndTodo(String r2, String r3, List r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = CollectionsKt.emptyList();
    L11:
        this(r2, r3, r4);
    }

    public final List<SummaryTodo> getTasks() {
        return this.tasks;
    }
}
