package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: Params.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ContactListTarget implements Parcelable {
    public static final Parcelable.Creator<ContactListTarget> CREATOR = null;
    private final ContactEntity[] contact;
    private final String[] telephone;

    /* JADX INFO: compiled from: Params.kt */
    public static final class Creator implements Parcelable.Creator<ContactListTarget> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContactListTarget createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            o.e(r10, "parcel");
            String[] r1 = r10.createStringArray();
            if (r10.readInt() != 0) goto L5;
            ContactEntity[] r2 = null;
        L9:
            ContactListTarget r4 = new ContactListTarget(r1, r2);
            int r3 = Math.min(r0, 0);
            ClassLoader r9 = getClass().getClassLoader();
            int r5 = 1;
        L10:
            if (r5 > r3) goto L12;
            r5 = r5 + 1;
        L12:
            if (r5 > r0) goto L14;
            a.a(r10, r9);
            r5 = r5 + 1;
            goto L12
        L14:
            return r4;
        L5:
            int r6 = r10.readInt();
            ContactEntity[] r7 = new ContactEntity[r6];
            int r8 = 0;
        L6:
            if (r8 == r6) goto L8;
            r7[r8] = (ContactEntity) ZeusTransformUtils.preCheckCast(r10.readParcelable(ContactListTarget.class.getClassLoader()), ContactEntity.class, "com.obric.aiagent.plugin");
            r8 = r8 + 1;
            goto L6
        L8:
            r2 = r7;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactListTarget createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContactListTarget[] newArray(int r1) {
            return new ContactListTarget[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactListTarget[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ ContactListTarget copy$default(ContactListTarget r0, String[] r1, ContactEntity[] r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.telephone;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.contact;
    L9:
        return r0.copy(r1, r2);
    }

    public final String[] component1() {
        return this.telephone;
    }

    public final ContactEntity[] component2() {
        return this.contact;
    }

    public final ContactListTarget copy(String[] r1, ContactEntity[] r2) {
        return new ContactListTarget(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ContactListTarget.class) == true) goto L8;
        return false;
    L8:
        ContactListTarget r6 = (ContactListTarget) ZeusTransformUtils.preCheckCast(r5, ContactListTarget.class, "com.obric.aiagent.plugin");
        if (o.a(this.telephone, r6.telephone) == true) goto L12;
        return false;
    L12:
        if (o.a(this.contact, r6.contact) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String[] r0 = this.telephone;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ContactEntity[] r4 = this.contact;
        if (r4 == null) goto L11;
        r1 = Arrays.hashCode(r4);
    L11:
        return r3 + r1;
    L5:
        r2 = Arrays.hashCode(r0);
        goto L6
    }

    public String toString() {
        return "ContactListTarget(telephone=" + Arrays.toString(this.telephone) + ", contact=" + Arrays.toString(this.contact) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r6, int r7) {
        int r0 = 0;
        r6.writeInt(0);
        o.e(r6, "out");
        r6.writeStringArray(this.telephone);
        ContactEntity[] r5 = this.contact;
        if (r5 != null) goto L5;
        r6.writeInt(0);
        return;
    L5:
        r6.writeInt(1);
        int r1 = r5.length;
        r6.writeInt(r1);
    L6:
        if (r0 == r1) goto L10;
        r6.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r5[r0], Parcelable.class, "com.obric.aiagent.plugin"), r7);
        r0 = r0 + 1;
        goto L6
    }

    public ContactListTarget(String[] r1, ContactEntity[] r2) {
        this.telephone = r1;
        this.contact = r2;
    }

    public final String[] getTelephone() {
        return this.telephone;
    }

    public final ContactEntity[] getContact() {
        return this.contact;
    }
}
