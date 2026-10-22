package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: ContactsUpdateParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ContactsUpdateParams implements Parcelable, IUriSharableParams, IntentParams {
    public static final Parcelable.Creator<ContactsUpdateParams> CREATOR = null;
    private String address;
    private String birthday;
    private String company;
    private String email;
    private String gender;
    private String identifyCard;
    private String name;
    private String note;
    private String relationship;
    private ContactEntity target;
    private Telephone[] telephones;

    /* JADX INFO: compiled from: ContactsUpdateParams.kt */
    public static final class Creator implements Parcelable.Creator<ContactsUpdateParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContactsUpdateParams createFromParcel(Parcel r18) {
            int r1 = r18.readInt();
            o.e(r18, "parcel");
            ContactEntity r6 = (ContactEntity) ZeusTransformUtils.preCheckCast(r18.readParcelable(ContactsUpdateParams.class.getClassLoader()), ContactEntity.class, "com.obric.aiagent.plugin");
            String r7 = r18.readString();
            if (r18.readInt() != 0) goto L5;
            Telephone[] r8 = null;
        L9:
            ContactsUpdateParams r2 = new ContactsUpdateParams(r6, r7, r8, r18.readString(), r18.readString(), r18.readString(), r18.readString(), r18.readString(), r18.readString(), r18.readString(), r18.readString());
            int r3 = Math.min(r1, 0);
            ClassLoader r4 = getClass().getClassLoader();
            int r5 = 1;
        L10:
            if (r5 > r3) goto L12;
            r5 = r5 + 1;
        L12:
            if (r5 > r1) goto L14;
            a.a(r18, r4);
            r5 = r5 + 1;
            goto L12
        L14:
            return r2;
        L5:
            int r9 = r18.readInt();
            Telephone[] r10 = new Telephone[r9];
            int r11 = 0;
        L6:
            if (r11 == r9) goto L8;
            r10[r11] = (Telephone) ZeusTransformUtils.preCheckCast(Telephone.CREATOR.createFromParcel(r18), Telephone.class, "com.obric.aiagent.plugin");
            r11 = r11 + 1;
            goto L6
        L8:
            r8 = r10;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsUpdateParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContactsUpdateParams[] newArray(int r1) {
            return new ContactsUpdateParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsUpdateParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public ContactsUpdateParams() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ ContactsUpdateParams copy$default(ContactsUpdateParams r12, ContactEntity r13, String r14, Telephone[] r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        ContactEntity r2 = r12.target;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r3 = r12.name;
    L11:
        if ((r24 & 4) == 0) goto L13;
        Telephone[] r4 = r12.telephones;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r5 = r12.company;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = r12.note;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r7 = r12.email;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r8 = r12.identifyCard;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r9 = r12.gender;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r10 = r12.birthday;
    L39:
        if ((r24 & 512) == 0) goto L41;
        String r11 = r12.relationship;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        String r1 = r12.address;
    L47:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
    L45:
        r1 = r23;
        goto L47
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final ContactEntity component1() {
        return this.target;
    }

    public final String component10() {
        return this.relationship;
    }

    public final String component11() {
        return this.address;
    }

    public final String component2() {
        return this.name;
    }

    public final Telephone[] component3() {
        return this.telephones;
    }

    public final String component4() {
        return this.company;
    }

    public final String component5() {
        return this.note;
    }

    public final String component6() {
        return this.email;
    }

    public final String component7() {
        return this.identifyCard;
    }

    public final String component8() {
        return this.gender;
    }

    public final String component9() {
        return this.birthday;
    }

    public final ContactsUpdateParams copy(ContactEntity r14, String r15, Telephone[] r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24) {
        return new ContactsUpdateParams(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ContactsUpdateParams.class) == true) goto L8;
        return false;
    L8:
        ContactsUpdateParams r6 = (ContactsUpdateParams) ZeusTransformUtils.preCheckCast(r5, ContactsUpdateParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.target, r6.target) == true) goto L12;
        return false;
    L12:
        if (o.a(this.name, r6.name) == true) goto L15;
        return false;
    L15:
        if (o.a(this.telephones, r6.telephones) == true) goto L18;
        return false;
    L18:
        if (o.a(this.company, r6.company) == true) goto L21;
        return false;
    L21:
        if (o.a(this.note, r6.note) == true) goto L24;
        return false;
    L24:
        if (o.a(this.email, r6.email) == true) goto L27;
        return false;
    L27:
        if (o.a(this.identifyCard, r6.identifyCard) == true) goto L30;
        return false;
    L30:
        if (o.a(this.gender, r6.gender) == true) goto L33;
        return false;
    L33:
        if (o.a(this.birthday, r6.birthday) == true) goto L36;
        return false;
    L36:
        if (o.a(this.relationship, r6.relationship) == true) goto L39;
        return false;
    L39:
        if (o.a(this.address, r6.address) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        ContactEntity r0 = this.target;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.name;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Telephone[] r7 = this.telephones;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.company;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.note;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.email;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.identifyCard;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.gender;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.birthday;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.relationship;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.address;
        if (r31 == null) goto L47;
        r1 = r31.hashCode();
    L47:
        return r30 + r1;
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = Arrays.hashCode(r7);
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("ContactsUpdateParams(target=").append(this.target).append(", name=").append(this.name).append(", telephones=").append(Arrays.toString(this.telephones)).append(", company=").append(this.company).append(", note=").append(this.note).append(", email=").append(this.email).append(", identifyCard=").append(this.identifyCard).append(", gender=").append(this.gender).append(", birthday=").append(this.birthday).append(", relationship=").append(this.relationship).append(", address=").append(this.address).append(')');
        return r0.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        int r0 = 0;
        r5.writeInt(0);
        o.e(r5, "out");
        r5.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.target, Parcelable.class, "com.obric.aiagent.plugin"), r6);
        r5.writeString(this.name);
        Telephone[] r1 = this.telephones;
        if (r1 != null) goto L5;
        r5.writeInt(0);
    L8:
        r5.writeString(this.company);
        r5.writeString(this.note);
        r5.writeString(this.email);
        r5.writeString(this.identifyCard);
        r5.writeString(this.gender);
        r5.writeString(this.birthday);
        r5.writeString(this.relationship);
        r5.writeString(this.address);
        return;
    L5:
        r5.writeInt(1);
        int r2 = r1.length;
        r5.writeInt(r2);
    L6:
        if (r0 == r2) goto L8;
        r1[r0].writeToParcel(r5, r6);
        r0 = r0 + 1;
        goto L6
    }

    public ContactsUpdateParams(ContactEntity r1, String r2, Telephone[] r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11) {
        this.target = r1;
        this.name = r2;
        this.telephones = r3;
        this.company = r4;
        this.note = r5;
        this.email = r6;
        this.identifyCard = r7;
        this.gender = r8;
        this.birthday = r9;
        this.relationship = r10;
        this.address = r11;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ ContactsUpdateParams(ContactEntity r2, String r3, Telephone[] r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, int r13, h r14) {
        if ((r13 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r13 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r13 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r13 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r13 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r13 & 256) == 0) goto L30;
        r10 = null;
    L30:
        if ((r13 & 512) == 0) goto L33;
        r11 = null;
    L33:
        if ((r13 & 1024) == 0) goto L35;
        r12 = null;
    L35:
        this(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public final ContactEntity getTarget() {
        return this.target;
    }

    public final void setTarget(ContactEntity r1) {
        this.target = r1;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final Telephone[] getTelephones() {
        return this.telephones;
    }

    public final void setTelephones(Telephone[] r1) {
        this.telephones = r1;
    }

    public final String getCompany() {
        return this.company;
    }

    public final void setCompany(String r1) {
        this.company = r1;
    }

    public final String getNote() {
        return this.note;
    }

    public final void setNote(String r1) {
        this.note = r1;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String r1) {
        this.email = r1;
    }

    public final String getIdentifyCard() {
        return this.identifyCard;
    }

    public final void setIdentifyCard(String r1) {
        this.identifyCard = r1;
    }

    public final String getGender() {
        return this.gender;
    }

    public final void setGender(String r1) {
        this.gender = r1;
    }

    public final String getBirthday() {
        return this.birthday;
    }

    public final void setBirthday(String r1) {
        this.birthday = r1;
    }

    public final String getRelationship() {
        return this.relationship;
    }

    public final void setRelationship(String r1) {
        this.relationship = r1;
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String r1) {
        this.address = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.target == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r18) {
        if (ZeusTransformUtils.instanceOf(r18, ContactsUpdateParams.class) == false) goto L5;
        ContactEntity r3 = this.target;
        if (r3 != null) goto L9;
        r3 = ((ContactsUpdateParams) ZeusTransformUtils.preCheckCast(r18, ContactsUpdateParams.class, "com.obric.aiagent.plugin")).target;
    L9:
        ContactEntity r6 = r3;
        String r4 = this.name;
        if (r4 != null) goto L12;
        r4 = ((ContactsUpdateParams) ZeusTransformUtils.preCheckCast(r18, ContactsUpdateParams.class, "com.obric.aiagent.plugin")).name;
    L12:
        String r7 = r4;
        Telephone[] r5 = this.telephones;
        if (r5 != null) goto L15;
        r5 = ((ContactsUpdateParams) ZeusTransformUtils.preCheckCast(r18, ContactsUpdateParams.class, "com.obric.aiagent.plugin")).telephones;
    L15:
        Telephone[] r8 = r5;
        String r9 = this.company;
        if (r9 != null) goto L18;
        r9 = ((ContactsUpdateParams) ZeusTransformUtils.preCheckCast(r18, ContactsUpdateParams.class, "com.obric.aiagent.plugin")).company;
    L18:
        String r10 = r9;
        String r11 = this.note;
        if (r11 != null) goto L21;
        r11 = ((ContactsUpdateParams) ZeusTransformUtils.preCheckCast(r18, ContactsUpdateParams.class, "com.obric.aiagent.plugin")).note;
    L21:
        String r12 = r11;
        String r13 = this.email;
        if (r13 != null) goto L24;
        r13 = ((ContactsUpdateParams) ZeusTransformUtils.preCheckCast(r18, ContactsUpdateParams.class, "com.obric.aiagent.plugin")).email;
    L24:
        String r14 = r13;
        String r15 = this.identifyCard;
        if (r15 != null) goto L27;
        r15 = ((ContactsUpdateParams) ZeusTransformUtils.preCheckCast(r18, ContactsUpdateParams.class, "com.obric.aiagent.plugin")).identifyCard;
    L27:
        String r16 = r15;
        String r17 = this.gender;
        if (r17 != null) goto L30;
        r17 = ((ContactsUpdateParams) ZeusTransformUtils.preCheckCast(r18, ContactsUpdateParams.class, "com.obric.aiagent.plugin")).gender;
    L30:
        String r19 = r17;
        String r20 = this.birthday;
        if (r20 != null) goto L33;
        r20 = ((ContactsUpdateParams) ZeusTransformUtils.preCheckCast(r18, ContactsUpdateParams.class, "com.obric.aiagent.plugin")).birthday;
    L33:
        String r110 = r20;
        String r21 = this.relationship;
        if (r21 != null) goto L36;
        r21 = ((ContactsUpdateParams) ZeusTransformUtils.preCheckCast(r18, ContactsUpdateParams.class, "com.obric.aiagent.plugin")).relationship;
    L36:
        String r111 = r21;
        String r0 = this.address;
        if (r0 != null) goto L40;
        r0 = ((ContactsUpdateParams) ZeusTransformUtils.preCheckCast(r18, ContactsUpdateParams.class, "com.obric.aiagent.plugin")).address;
    L40:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new ContactsUpdateParams(r6, r7, r8, r10, r12, r14, r16, r19, r110, r111, r0), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return p.a(this.target);
    }
}
