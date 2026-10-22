package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: Params.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ContactTarget implements Parcelable {
    public static final Parcelable.Creator<ContactTarget> CREATOR = null;
    private final ContactEntity contact;
    private final String telephone;

    /* JADX INFO: compiled from: Params.kt */
    public static final class Creator implements Parcelable.Creator<ContactTarget> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContactTarget createFromParcel(Parcel r7) {
            int r0 = r7.readInt();
            o.e(r7, "parcel");
            ContactTarget r1 = new ContactTarget(r7.readString(), (ContactEntity) ZeusTransformUtils.preCheckCast(r7.readParcelable(ContactTarget.class.getClassLoader()), ContactEntity.class, "com.obric.aiagent.plugin"));
            int r2 = Math.min(r0, 0);
            ClassLoader r6 = getClass().getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r2) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r0) goto L7;
            a.a(r7, r6);
            r3 = r3 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactTarget createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContactTarget[] newArray(int r1) {
            return new ContactTarget[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactTarget[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ ContactTarget copy$default(ContactTarget r0, String r1, ContactEntity r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.telephone;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.contact;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.telephone;
    }

    public final ContactEntity component2() {
        return this.contact;
    }

    public final ContactTarget copy(String r1, ContactEntity r2) {
        return new ContactTarget(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ContactTarget.class) == true) goto L8;
        return false;
    L8:
        ContactTarget r6 = (ContactTarget) ZeusTransformUtils.preCheckCast(r5, ContactTarget.class, "com.obric.aiagent.plugin");
        if (o.a(this.telephone, r6.telephone) == true) goto L12;
        return false;
    L12:
        if (o.a(this.contact, r6.contact) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.telephone;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ContactEntity r4 = this.contact;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ContactTarget(telephone=" + this.telephone + ", contact=" + this.contact + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        o.e(r3, "out");
        r3.writeString(this.telephone);
        r3.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.contact, Parcelable.class, "com.obric.aiagent.plugin"), r4);
    }

    public ContactTarget(String r1, ContactEntity r2) {
        this.telephone = r1;
        this.contact = r2;
    }

    public final String getTelephone() {
        return this.telephone;
    }

    public final ContactEntity getContact() {
        return this.contact;
    }
}
