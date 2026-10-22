package com.obric.callsummary.bean;

import android.content.Context;
import com.android.contacts.R;
import com.obric.callsummary.widget.CallSummaryWidget;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CallSummary.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0001,B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JA\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010 \u001a\u00020\nJ\u0006\u0010!\u001a\u00020\u0003J\u0006\u0010\"\u001a\u00020\u0003J\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005J\t\u0010$\u001a\u00020\nHÖ\u0001J\u0006\u0010%\u001a\u00020\u001eJ\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(H\u0002J\u000e\u0010)\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(J\u0006\u0010*\u001a\u00020\u001eJ\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006-"}, d2 = {"Lcom/obric/callsummary/bean/CallSummary;", "", CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY, "", "items", "", "callAssignment", "Lcom/obric/callsummary/bean/CallAssignment;", "title", AccountConst.KEY_ERROR_CODE, "", "(Ljava/lang/String;Ljava/util/List;Lcom/obric/callsummary/bean/CallAssignment;Ljava/lang/String;I)V", "getCallAssignment", "()Lcom/obric/callsummary/bean/CallAssignment;", "setCallAssignment", "(Lcom/obric/callsummary/bean/CallAssignment;)V", "getErrorCode", "()I", "getItems", "()Ljava/util/List;", "getSummary", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "getLength", "getSummaryClipboardStr", "getSummaryStr", "getTodoListStr", "hashCode", "isEmpty", "isLegacyUnableToSummarize", "context", "Landroid/content/Context;", "isUnableToSummarize", "summaryAndAssignmentIsEmpty", "toString", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallSummary {
    public static final Companion Companion = null;
    public static final int ERR_CODE_UNABLE_TO_SUMMARIZE = 2001;
    public static final int NO_ERROR = 0;
    private CallAssignment callAssignment;
    private final int errorCode;
    private final List<String> items;
    private final String summary;
    private final String title;

    /* JADX INFO: compiled from: CallSummary.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/callsummary/bean/CallSummary$Companion;", "", "()V", "ERR_CODE_UNABLE_TO_SUMMARIZE", "", "NO_ERROR", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CallSummary() {
        this(null, null, null, null, 0, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallSummary copy$default(CallSummary r3, String r4, List r5, CallAssignment r6, String r7, int r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.summary;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.items;
    L8:
        List r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.callAssignment;
    L11:
        CallAssignment r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.title;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.errorCode;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.summary;
    }

    public final List<String> component2() {
        return this.items;
    }

    public final CallAssignment component3() {
        return this.callAssignment;
    }

    public final String component4() {
        return this.title;
    }

    public final int component5() {
        return this.errorCode;
    }

    public final CallSummary copy(String r7, List<String> r8, CallAssignment r9, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r7, CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY);
        Intrinsics.checkNotNullParameter(r8, "items");
        Intrinsics.checkNotNullParameter(r9, "callAssignment");
        Intrinsics.checkNotNullParameter(r10, "title");
        return new CallSummary(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CallSummary) == true) goto L8;
        return false;
    L8:
        CallSummary r6 = (CallSummary) r5;
        if (Intrinsics.areEqual(this.summary, r6.summary) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.items, r6.items) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.callAssignment, r6.callAssignment) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L21;
        return false;
    L21:
        if (this.errorCode == r6.errorCode) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.summary.hashCode() * 31) + this.items.hashCode()) * 31) + this.callAssignment.hashCode()) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.errorCode);
    }

    public String toString() {
        return "CallSummary(summary=" + this.summary + ", items=" + this.items + ", callAssignment=" + this.callAssignment + ", title=" + this.title + ", errorCode=" + this.errorCode + ')';
    }

    public CallSummary(String r2, List<String> r3, CallAssignment r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY);
        Intrinsics.checkNotNullParameter(r3, "items");
        Intrinsics.checkNotNullParameter(r4, "callAssignment");
        Intrinsics.checkNotNullParameter(r5, "title");
        this.summary = r2;
        this.items = r3;
        this.callAssignment = r4;
        this.title = r5;
        this.errorCode = r6;
    }

    public final String getSummary() {
        return this.summary;
    }

    public /* synthetic */ CallSummary(String r3, List r4, CallAssignment r5, String r6, int r7, int r8, DefaultConstructorMarker r9) {
        if ((r8 & 1) == 0) goto L6;
        r3 = "";
    L6:
        if ((r8 & 2) == 0) goto L9;
        r4 = CollectionsKt.emptyList();
    L9:
        if ((r8 & 4) == 0) goto L12;
        r5 = new CallAssignment(null, 1, null);
    L12:
        if ((r8 & 8) == 0) goto L15;
        r6 = "";
    L15:
        if ((r8 & 16) == 0) goto L17;
        r7 = 0;
    L17:
        this(r3, r4, r5, r6, r7);
    }

    public final List<String> getItems() {
        return this.items;
    }

    public final CallAssignment getCallAssignment() {
        return this.callAssignment;
    }

    public final void setCallAssignment(CallAssignment r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.callAssignment = r2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final boolean isEmpty() {
        if (this.summary.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L13;
        if (this.items.isEmpty() == false) goto L13;
        if (this.errorCode == 2001) goto L13;
        return true;
    L13:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean summaryAndAssignmentIsEmpty() {
        if (this.summary.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        if (this.items.isEmpty() == false) goto L15;
        if (this.callAssignment.isEmpty() == false) goto L15;
        if (this.errorCode == 2001) goto L15;
        return true;
    L15:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean isUnableToSummarize(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (this.errorCode != 2001) goto L5;
    L8:
        return true;
    L5:
        if (isLegacyUnableToSummarize(r3) == true) goto L8;
        return false;
    }

    private final boolean isLegacyUnableToSummarize(Context r4) {
        if (this.errorCode == 0) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(this.summary, r4.getString(R.string.unable_to_summarize)) == true) goto L7;
        return false;
    L7:
        if (this.items.isEmpty() == true) goto L9;
        return false;
    L9:
        if (this.callAssignment.isEmpty() == true) goto L11;
        return false;
    L11:
        if (this.title.length() != 0) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == true) goto L16;
        return false;
    L16:
        return true;
    L13:
        r3 = false;
        goto L14
    }

    public final int getLength() {
        int r0 = this.summary.length();
        Iterator<T> r1 = this.items.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0 = r0 + ((String) r1.next()).length();
        goto L4
    L6:
        Iterator<T> r3 = this.callAssignment.getList().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        r0 = r0 + ((CallAssignmentData) r3.next()).getSummary().length();
        goto L8
    L10:
        return r0;
    }

    public final String getSummaryStr() {
        String r0 = this.summary;
        Iterator<T> r5 = this.items.iterator();
        int r2 = 1;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = r0 + '\n' + r2 + '.' + ((String) r5.next());
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public final List<String> getTodoListStr() {
        List<CallAssignmentData> r2 = this.callAssignment.getList();
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        r0.add(((CallAssignmentData) r3.next()).getSummary());
        goto L4
    L7:
        return r0;
    }

    public final String getSummaryClipboardStr() {
        int r4 = 0;
        if (StringsKt.startsWith$default(this.summary, "总结", false, 2, null) == false) goto L5;
        StringBuilder r0 = new StringBuilder();
    L6:
        String r1 = r0.append(this.summary).append('\n').toString();
        Iterator<T> r2 = this.items.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r1 = r1 + ((String) r2.next()) + '\n';
        goto L8
    L10:
        Iterator<T> r6 = this.callAssignment.getList().iterator();
    L12:
        if (r6.hasNext() == false) goto L17;
        CallAssignmentData r3 = (CallAssignmentData) r6.next();
        if (r4 != 0) goto L16;
        r1 = r1 + "待办: \n";
    L16:
        r1 = r1 + r3.getSummary() + '\n';
        r4 = r4 + 1;
        goto L12
    L17:
        return r1;
    L5:
        r0 = new StringBuilder("总结：");
        goto L6
    }
}
