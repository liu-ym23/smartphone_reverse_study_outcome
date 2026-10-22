package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: ContactsCreateParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ContactsCreateParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<ContactsCreateParams> CREATOR = null;
    private String address;
    private String birthday;
    private String company;
    private String email;
    private String gender;
    private String identifyCard;
    private String name;
    private String note;
    private String relationship;
    private Telephone[] telephones;

    /* JADX INFO: compiled from: ContactsCreateParams.kt */
    public static final class Creator implements Parcelable.Creator<ContactsCreateParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContactsCreateParams createFromParcel(Parcel r15) {
            int r0 = r15.readInt();
            o.e(r15, "parcel");
            String r3 = r15.readString();
            if (r15.readInt() != 0) goto L5;
            Telephone[] r4 = null;
        L9:
            ContactsCreateParams r1 = new ContactsCreateParams(r3, r4, r15.readString(), r15.readString(), r15.readString(), r15.readString(), r15.readString(), r15.readString(), r15.readString(), r15.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r14 = getClass().getClassLoader();
            int r5 = 1;
        L10:
            if (r5 > r2) goto L12;
            r5 = r5 + 1;
        L12:
            if (r5 > r0) goto L14;
            a.a(r15, r14);
            r5 = r5 + 1;
            goto L12
        L14:
            return r1;
        L5:
            int r6 = r15.readInt();
            Telephone[] r7 = new Telephone[r6];
            int r8 = 0;
        L6:
            if (r8 == r6) goto L8;
            r7[r8] = (Telephone) ZeusTransformUtils.preCheckCast(Telephone.CREATOR.createFromParcel(r15), Telephone.class, "com.obric.aiagent.plugin");
            r8 = r8 + 1;
            goto L6
        L8:
            r4 = r7;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsCreateParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContactsCreateParams[] newArray(int r1) {
            return new ContactsCreateParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsCreateParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public ContactsCreateParams() {
        this(null, null, null, null, null, null, null, null, null, null, DownloadErrorCode.ERROR_IO, null);
    }

    public static /* synthetic */ ContactsCreateParams copy$default(ContactsCreateParams r11, String r12, Telephone[] r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r2 = r11.name;
    L7:
        if ((r22 & 2) == 0) goto L9;
        Telephone[] r3 = r11.telephones;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = r11.company;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = r11.note;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = r11.email;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = r11.identifyCard;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r8 = r11.gender;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = r11.birthday;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r10 = r11.relationship;
    L39:
        if ((r22 & 512) == 0) goto L41;
        String r1 = r11.address;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final String component1() {
        return this.name;
    }

    public final String component10() {
        return this.address;
    }

    public final Telephone[] component2() {
        return this.telephones;
    }

    public final String component3() {
        return this.company;
    }

    public final String component4() {
        return this.note;
    }

    public final String component5() {
        return this.email;
    }

    public final String component6() {
        return this.identifyCard;
    }

    public final String component7() {
        return this.gender;
    }

    public final String component8() {
        return this.birthday;
    }

    public final String component9() {
        return this.relationship;
    }

    public final ContactsCreateParams copy(String r13, Telephone[] r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22) {
        return new ContactsCreateParams(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ContactsCreateParams.class) == true) goto L8;
        return false;
    L8:
        ContactsCreateParams r6 = (ContactsCreateParams) ZeusTransformUtils.preCheckCast(r5, ContactsCreateParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (o.a(this.telephones, r6.telephones) == true) goto L15;
        return false;
    L15:
        if (o.a(this.company, r6.company) == true) goto L18;
        return false;
    L18:
        if (o.a(this.note, r6.note) == true) goto L21;
        return false;
    L21:
        if (o.a(this.email, r6.email) == true) goto L24;
        return false;
    L24:
        if (o.a(this.identifyCard, r6.identifyCard) == true) goto L27;
        return false;
    L27:
        if (o.a(this.gender, r6.gender) == true) goto L30;
        return false;
    L30:
        if (o.a(this.birthday, r6.birthday) == true) goto L33;
        return false;
    L33:
        if (o.a(this.relationship, r6.relationship) == true) goto L36;
        return false;
    L36:
        if (o.a(this.address, r6.address) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Telephone[] r4 = this.telephones;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.company;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.note;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.email;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.identifyCard;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.gender;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.birthday;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.relationship;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.address;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
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
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = Arrays.hashCode(r4);
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ContactsCreateParams(name=" + this.name + ", telephones=" + Arrays.toString(this.telephones) + ", company=" + this.company + ", note=" + this.note + ", email=" + this.email + ", identifyCard=" + this.identifyCard + ", gender=" + this.gender + ", birthday=" + this.birthday + ", relationship=" + this.relationship + ", address=" + this.address + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        int r0 = 0;
        r5.writeInt(0);
        o.e(r5, "out");
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

    public ContactsCreateParams(String r1, Telephone[] r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10) {
        this.name = r1;
        this.telephones = r2;
        this.company = r3;
        this.note = r4;
        this.email = r5;
        this.identifyCard = r6;
        this.gender = r7;
        this.birthday = r8;
        this.relationship = r9;
        this.address = r10;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ ContactsCreateParams(String r2, Telephone[] r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, int r12, h r13) {
        if ((r12 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r12 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r12 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r12 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r12 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r12 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r12 & 256) == 0) goto L30;
        r10 = null;
    L30:
        if ((r12 & 512) == 0) goto L32;
        r11 = null;
    L32:
        this(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
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
    public IntentParams mergeParams(Object r15) {
        if (ZeusTransformUtils.instanceOf(r15, ContactsCreateParams.class) == false) goto L5;
        String r1 = this.name;
        if (r1 != null) goto L9;
        r1 = ((ContactsCreateParams) ZeusTransformUtils.preCheckCast(r15, ContactsCreateParams.class, "com.obric.aiagent.plugin")).name;
    L9:
        String r4 = r1;
        Telephone[] r2 = this.telephones;
        if (r2 != null) goto L12;
        r2 = ((ContactsCreateParams) ZeusTransformUtils.preCheckCast(r15, ContactsCreateParams.class, "com.obric.aiagent.plugin")).telephones;
    L12:
        Telephone[] r5 = r2;
        String r3 = this.company;
        if (r3 != null) goto L15;
        r3 = ((ContactsCreateParams) ZeusTransformUtils.preCheckCast(r15, ContactsCreateParams.class, "com.obric.aiagent.plugin")).company;
    L15:
        String r6 = r3;
        String r7 = this.note;
        if (r7 != null) goto L18;
        r7 = ((ContactsCreateParams) ZeusTransformUtils.preCheckCast(r15, ContactsCreateParams.class, "com.obric.aiagent.plugin")).note;
    L18:
        String r8 = r7;
        String r9 = this.email;
        if (r9 != null) goto L21;
        r9 = ((ContactsCreateParams) ZeusTransformUtils.preCheckCast(r15, ContactsCreateParams.class, "com.obric.aiagent.plugin")).email;
    L21:
        String r10 = r9;
        String r11 = this.identifyCard;
        if (r11 != null) goto L24;
        r11 = ((ContactsCreateParams) ZeusTransformUtils.preCheckCast(r15, ContactsCreateParams.class, "com.obric.aiagent.plugin")).identifyCard;
    L24:
        String r12 = r11;
        String r13 = this.gender;
        if (r13 != null) goto L27;
        r13 = ((ContactsCreateParams) ZeusTransformUtils.preCheckCast(r15, ContactsCreateParams.class, "com.obric.aiagent.plugin")).gender;
    L27:
        String r14 = r13;
        String r16 = this.birthday;
        if (r16 != null) goto L30;
        r16 = ((ContactsCreateParams) ZeusTransformUtils.preCheckCast(r15, ContactsCreateParams.class, "com.obric.aiagent.plugin")).birthday;
    L30:
        String r17 = r16;
        String r18 = this.relationship;
        if (r18 != null) goto L33;
        r18 = ((ContactsCreateParams) ZeusTransformUtils.preCheckCast(r15, ContactsCreateParams.class, "com.obric.aiagent.plugin")).relationship;
    L33:
        String r19 = r18;
        String r110 = this.address;
        if (r110 != null) goto L37;
        r110 = ((ContactsCreateParams) ZeusTransformUtils.preCheckCast(r15, ContactsCreateParams.class, "com.obric.aiagent.plugin")).address;
    L37:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new ContactsCreateParams(r4, r5, r6, r8, r10, r12, r14, r17, r19, r110), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
