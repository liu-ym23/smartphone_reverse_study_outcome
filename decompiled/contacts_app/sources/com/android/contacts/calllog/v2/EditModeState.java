package com.android.contacts.calllog.v2;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallLogUiState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/android/contacts/calllog/v2/EditModeState;", "", "isActive", "", "selectedIds", "", "", "selectAllChecked", "(ZLjava/util/Set;Z)V", "()Z", "getSelectAllChecked", "getSelectedIds", "()Ljava/util/Set;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EditModeState {
    public static final Companion Companion = null;
    private static final EditModeState INACTIVE = null;
    private final boolean isActive;
    private final boolean selectAllChecked;
    private final Set<Long> selectedIds;

    /* JADX INFO: compiled from: CallLogUiState.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/contacts/calllog/v2/EditModeState$Companion;", "", "()V", "INACTIVE", "Lcom/android/contacts/calllog/v2/EditModeState;", "getINACTIVE", "()Lcom/android/contacts/calllog/v2/EditModeState;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final EditModeState getINACTIVE() {
            return EditModeState.access$getINACTIVE$cp();
        }
    }

    public EditModeState() {
        this(false, null, false, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EditModeState copy$default(EditModeState r0, boolean r1, Set r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.isActive;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.selectedIds;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.selectAllChecked;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.isActive;
    }

    public final Set<Long> component2() {
        return this.selectedIds;
    }

    public final boolean component3() {
        return this.selectAllChecked;
    }

    public final EditModeState copy(boolean r1, Set<Long> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "selectedIds");
        return new EditModeState(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof EditModeState) == true) goto L8;
        return false;
    L8:
        EditModeState r6 = (EditModeState) r5;
        if (this.isActive == r6.isActive) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.selectedIds, r6.selectedIds) == true) goto L15;
        return false;
    L15:
        if (this.selectAllChecked == r6.selectAllChecked) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean r0 = this.isActive;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = ((r2 * 31) + this.selectedIds.hashCode()) * 31;
        boolean r4 = this.selectAllChecked;
        if (r4 == true) goto L10;
        r1 = r4;
    L10:
        return r3 + r1;
    }

    public String toString() {
        return "EditModeState(isActive=" + this.isActive + ", selectedIds=" + this.selectedIds + ", selectAllChecked=" + this.selectAllChecked + ')';
    }

    public EditModeState(boolean r2, Set<Long> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "selectedIds");
        this.isActive = r2;
        this.selectedIds = r3;
        this.selectAllChecked = r4;
    }

    public static final /* synthetic */ EditModeState access$getINACTIVE$cp() {
        return INACTIVE;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public /* synthetic */ EditModeState(boolean r2, Set r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = SetsKt.emptySet();
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = false;
    L11:
        this(r2, r3, r4);
    }

    public final Set<Long> getSelectedIds() {
        return this.selectedIds;
    }

    public final boolean getSelectAllChecked() {
        return this.selectAllChecked;
    }

    static {
        Companion = new Companion(null);
        INACTIVE = new EditModeState(false, null, false, 7, null);
    }
}
