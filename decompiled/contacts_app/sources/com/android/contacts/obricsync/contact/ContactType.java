package com.android.contacts.obricsync.contact;

import com.android.contacts.interactions.GroupDeletionDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/android/contacts/obricsync/contact/ContactType;", "", "value", "", "type", "", GroupDeletionDialogFragment.ARG_LABEL, "(Ljava/lang/String;ILjava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "getValue", "setValue", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactType {
    private String label;
    private int type;
    private String value;

    public ContactType() {
        this(null, 0, null, 7, null);
    }

    public static /* synthetic */ ContactType copy$default(ContactType r0, String r1, int r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.value;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.type;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.label;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.value;
    }

    public final int component2() {
        return this.type;
    }

    public final String component3() {
        return this.label;
    }

    public final ContactType copy(String r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "value");
        return new ContactType(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ContactType) == true) goto L8;
        return false;
    L8:
        ContactType r6 = (ContactType) r5;
        if (Intrinsics.areEqual(this.value, r6.value) == true) goto L12;
        return false;
    L12:
        if (this.type == r6.type) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.label, r6.label) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.value.hashCode() * 31) + Integer.hashCode(this.type)) * 31;
        String r2 = this.label;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "ContactType(value=" + this.value + ", type=" + this.type + ", label=" + this.label + ')';
    }

    public ContactType(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.value = r2;
        this.type = r3;
        this.label = r4;
    }

    public /* synthetic */ ContactType(String r1, int r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = 1;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = null;
    L11:
        this(r1, r2, r3);
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.value = r2;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    public final String getLabel() {
        return this.label;
    }

    public final void setLabel(String r1) {
        this.label = r1;
    }
}
