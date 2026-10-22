package com.android.contacts.calllog.v2;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallLogUiState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\nHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogUiState;", "", "items", "", "Lcom/android/contacts/calllog/v2/CallLogItem;", "isLoading", "", "currentTab", "Lcom/android/contacts/calllog/v2/CallLogTab;", "editMode", "Lcom/android/contacts/calllog/v2/EditModeState;", "(Ljava/util/List;ZLcom/android/contacts/calllog/v2/CallLogTab;Lcom/android/contacts/calllog/v2/EditModeState;)V", "getCurrentTab", "()Lcom/android/contacts/calllog/v2/CallLogTab;", "getEditMode", "()Lcom/android/contacts/calllog/v2/EditModeState;", "()Z", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallLogUiState {
    private final CallLogTab currentTab;
    private final EditModeState editMode;
    private final boolean isLoading;
    private final List<CallLogItem> items;

    public CallLogUiState() {
        this(null, false, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallLogUiState copy$default(CallLogUiState r0, List r1, boolean r2, CallLogTab r3, EditModeState r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.items;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.isLoading;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.currentTab;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.editMode;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final List<CallLogItem> component1() {
        return this.items;
    }

    public final boolean component2() {
        return this.isLoading;
    }

    public final CallLogTab component3() {
        return this.currentTab;
    }

    public final EditModeState component4() {
        return this.editMode;
    }

    public final CallLogUiState copy(List<CallLogItem> r1, boolean r2, CallLogTab r3, EditModeState r4) {
        Intrinsics.checkNotNullParameter(r1, "items");
        Intrinsics.checkNotNullParameter(r3, "currentTab");
        Intrinsics.checkNotNullParameter(r4, "editMode");
        return new CallLogUiState(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CallLogUiState) == true) goto L8;
        return false;
    L8:
        CallLogUiState r6 = (CallLogUiState) r5;
        if (Intrinsics.areEqual(this.items, r6.items) == true) goto L12;
        return false;
    L12:
        if (this.isLoading == r6.isLoading) goto L15;
        return false;
    L15:
        if (this.currentTab == r6.currentTab) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.editMode, r6.editMode) == true) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int r0 = this.items.hashCode() * 31;
        boolean r1 = this.isLoading;
        ?? r2 = r1;
        if (r1 == false) goto L6;
        r2 = 1;
    L6:
        return ((((r0 + r2) * 31) + this.currentTab.hashCode()) * 31) + this.editMode.hashCode();
    }

    public String toString() {
        return "CallLogUiState(items=" + this.items + ", isLoading=" + this.isLoading + ", currentTab=" + this.currentTab + ", editMode=" + this.editMode + ')';
    }

    public CallLogUiState(List<CallLogItem> r2, boolean r3, CallLogTab r4, EditModeState r5) {
        Intrinsics.checkNotNullParameter(r2, "items");
        Intrinsics.checkNotNullParameter(r4, "currentTab");
        Intrinsics.checkNotNullParameter(r5, "editMode");
        this.items = r2;
        this.isLoading = r3;
        this.currentTab = r4;
        this.editMode = r5;
    }

    public /* synthetic */ CallLogUiState(List r1, boolean r2, CallLogTab r3, EditModeState r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = true;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = CallLogTab.ALL;
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = EditModeState.Companion.getINACTIVE();
    L14:
        this(r1, r2, r3, r4);
    }

    public final List<CallLogItem> getItems() {
        return this.items;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final CallLogTab getCurrentTab() {
        return this.currentTab;
    }

    public final EditModeState getEditMode() {
        return this.editMode;
    }
}
