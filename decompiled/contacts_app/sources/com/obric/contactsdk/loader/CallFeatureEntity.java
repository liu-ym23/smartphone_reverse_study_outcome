package com.obric.contactsdk.loader;

import com.obric.callsummary.widget.CallSummaryWidget;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallFeatureEntityUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/obric/contactsdk/loader/CallFeatureEntity;", "", "hasSummary", "", CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY, "", "todoList", "", "title", "(ZLjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getHasSummary", "()Z", "getSummary", "()Ljava/lang/String;", "setSummary", "(Ljava/lang/String;)V", "getTitle", "setTitle", "getTodoList", "()Ljava/util/List;", "setTodoList", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "contactsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallFeatureEntity {
    private final boolean hasSummary;
    private String summary;
    private String title;
    private List<String> todoList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallFeatureEntity copy$default(CallFeatureEntity r0, boolean r1, String r2, List r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.hasSummary;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.summary;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.todoList;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.title;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final boolean component1() {
        return this.hasSummary;
    }

    public final String component2() {
        return this.summary;
    }

    public final List<String> component3() {
        return this.todoList;
    }

    public final String component4() {
        return this.title;
    }

    public final CallFeatureEntity copy(boolean r1, String r2, List<String> r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "todoList");
        return new CallFeatureEntity(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CallFeatureEntity) == true) goto L8;
        return false;
    L8:
        CallFeatureEntity r6 = (CallFeatureEntity) r5;
        if (this.hasSummary == r6.hasSummary) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.summary, r6.summary) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.todoList, r6.todoList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean r0 = this.hasSummary;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        String r3 = this.summary;
        int r4 = 0;
        if (r3 != null) goto L8;
        int r5 = 0;
    L9:
        int r6 = (((r2 + r5) * 31) + this.todoList.hashCode()) * 31;
        String r7 = this.title;
        if (r7 == null) goto L14;
        r4 = r7.hashCode();
    L14:
        return r6 + r4;
    L8:
        r5 = r3.hashCode();
        goto L9
    }

    public String toString() {
        return "CallFeatureEntity(hasSummary=" + this.hasSummary + ", summary=" + this.summary + ", todoList=" + this.todoList + ", title=" + this.title + ')';
    }

    public CallFeatureEntity(boolean r2, String r3, List<String> r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "todoList");
        this.hasSummary = r2;
        this.summary = r3;
        this.todoList = r4;
        this.title = r5;
    }

    public final boolean getHasSummary() {
        return this.hasSummary;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final void setSummary(String r1) {
        this.summary = r1;
    }

    public /* synthetic */ CallFeatureEntity(boolean r1, String r2, List r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = CollectionsKt.emptyList();
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = null;
    L8:
        this(r1, r2, r3, r4);
    }

    public final List<String> getTodoList() {
        return this.todoList;
    }

    public final void setTodoList(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.todoList = r2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }
}
