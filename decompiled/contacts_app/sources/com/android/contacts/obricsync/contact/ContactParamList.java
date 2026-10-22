package com.android.contacts.obricsync.contact;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/android/contacts/obricsync/contact/ContactParamList;", "", "list", "", "Lcom/android/contacts/obricsync/contact/ContactType;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "setList", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactParamList {
    private List<ContactType> list;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContactParamList copy$default(ContactParamList r0, List r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.list;
    L6:
        return r0.copy(r1);
    }

    public final List<ContactType> component1() {
        return this.list;
    }

    public final ContactParamList copy(List<ContactType> r1) {
        Intrinsics.checkNotNullParameter(r1, "list");
        return new ContactParamList(r1);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ContactParamList) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.list, ((ContactParamList) r4).list) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    public String toString() {
        return "ContactParamList(list=" + this.list + ')';
    }

    public ContactParamList(List<ContactType> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        this.list = r2;
    }

    public final List<ContactType> getList() {
        return this.list;
    }

    public final void setList(List<ContactType> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.list = r2;
    }
}
