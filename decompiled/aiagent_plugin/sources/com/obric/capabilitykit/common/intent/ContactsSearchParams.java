package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ContactsSearchParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ContactsSearchParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<ContactsSearchParams> CREATOR = null;
    private String company;
    private String contactName;
    private String content;
    private String email;
    private Integer maxCount;
    private String query;
    private String telephone;
    private String telephoneType;

    /* JADX INFO: compiled from: ContactsSearchParams.kt */
    public static final class Creator implements Parcelable.Creator<ContactsSearchParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContactsSearchParams createFromParcel(Parcel r12) {
            int r0 = r12.readInt();
            o.e(r12, "parcel");
            String r3 = r12.readString();
            String r4 = r12.readString();
            String r5 = r12.readString();
            String r6 = r12.readString();
            String r7 = r12.readString();
            String r8 = r12.readString();
            String r9 = r12.readString();
            if (r12.readInt() != 0) goto L5;
            Integer r2 = null;
        L6:
            ContactsSearchParams r1 = new ContactsSearchParams(r3, r4, r5, r6, r7, r8, r9, r2);
            int r10 = Math.min(r0, 0);
            ClassLoader r11 = getClass().getClassLoader();
            int r13 = 1;
        L7:
            if (r13 > r10) goto L9;
            r13 = r13 + 1;
        L9:
            if (r13 > r0) goto L11;
            a.a(r12, r11);
            r13 = r13 + 1;
            goto L9
        L11:
            return r1;
        L5:
            r2 = Integer.valueOf(r12.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsSearchParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContactsSearchParams[] newArray(int r1) {
            return new ContactsSearchParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsSearchParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public ContactsSearchParams() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ ContactsSearchParams copy$default(ContactsSearchParams r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, Integer r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.query;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.contactName;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.telephone;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.telephoneType;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.company;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.email;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.content;
    L31:
        if ((r18 & 128) == 0) goto L33;
        Integer r1 = r9.maxCount;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.query;
    }

    public final String component2() {
        return this.contactName;
    }

    public final String component3() {
        return this.telephone;
    }

    public final String component4() {
        return this.telephoneType;
    }

    public final String component5() {
        return this.company;
    }

    public final String component6() {
        return this.email;
    }

    public final String component7() {
        return this.content;
    }

    public final Integer component8() {
        return this.maxCount;
    }

    public final ContactsSearchParams copy(String r11, String r12, String r13, String r14, String r15, String r16, String r17, Integer r18) {
        return new ContactsSearchParams(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ContactsSearchParams.class) == true) goto L8;
        return false;
    L8:
        ContactsSearchParams r6 = (ContactsSearchParams) ZeusTransformUtils.preCheckCast(r5, ContactsSearchParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.query, r6.query) == true) goto L12;
        return false;
    L12:
        if (o.a(this.contactName, r6.contactName) == true) goto L15;
        return false;
    L15:
        if (o.a(this.telephone, r6.telephone) == true) goto L18;
        return false;
    L18:
        if (o.a(this.telephoneType, r6.telephoneType) == true) goto L21;
        return false;
    L21:
        if (o.a(this.company, r6.company) == true) goto L24;
        return false;
    L24:
        if (o.a(this.email, r6.email) == true) goto L27;
        return false;
    L27:
        if (o.a(this.content, r6.content) == true) goto L30;
        return false;
    L30:
        if (o.a(this.maxCount, r6.maxCount) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r0 = this.query;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.contactName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.telephone;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.telephoneType;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.company;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.email;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.content;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.maxCount;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
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
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ContactsSearchParams(query=" + this.query + ", contactName=" + this.contactName + ", telephone=" + this.telephone + ", telephoneType=" + this.telephoneType + ", company=" + this.company + ", email=" + this.email + ", content=" + this.content + ", maxCount=" + this.maxCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(0);
        o.e(r2, "out");
        r2.writeString(this.query);
        r2.writeString(this.contactName);
        r2.writeString(this.telephone);
        r2.writeString(this.telephoneType);
        r2.writeString(this.company);
        r2.writeString(this.email);
        r2.writeString(this.content);
        Integer r1 = this.maxCount;
        if (r1 != null) goto L5;
        r2.writeInt(0);
        return;
    L5:
        r2.writeInt(1);
        r2.writeInt(r1.intValue());
    }

    public ContactsSearchParams(String r1, String r2, String r3, String r4, String r5, String r6, String r7, Integer r8) {
        this.query = r1;
        this.contactName = r2;
        this.telephone = r3;
        this.telephoneType = r4;
        this.company = r5;
        this.email = r6;
        this.content = r7;
        this.maxCount = r8;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ ContactsSearchParams(String r2, String r3, String r4, String r5, String r6, String r7, String r8, Integer r9, int r10, h r11) {
        if ((r10 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r10 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r10 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r10 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r10 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r10 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r10 & 128) == 0) goto L26;
        r9 = null;
    L26:
        this(r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public final String getQuery() {
        return this.query;
    }

    public final void setQuery(String r1) {
        this.query = r1;
    }

    public final String getContactName() {
        return this.contactName;
    }

    public final void setContactName(String r1) {
        this.contactName = r1;
    }

    public final String getTelephone() {
        return this.telephone;
    }

    public final void setTelephone(String r1) {
        this.telephone = r1;
    }

    public final String getTelephoneType() {
        return this.telephoneType;
    }

    public final void setTelephoneType(String r1) {
        this.telephoneType = r1;
    }

    public final String getCompany() {
        return this.company;
    }

    public final void setCompany(String r1) {
        this.company = r1;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String r1) {
        this.email = r1;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String r1) {
        this.content = r1;
    }

    public final Integer getMaxCount() {
        return this.maxCount;
    }

    public final void setMaxCount(Integer r1) {
        this.maxCount = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r13) {
        if (ZeusTransformUtils.instanceOf(r13, ContactsSearchParams.class) == false) goto L5;
        String r1 = this.query;
        if (r1 != null) goto L9;
        r1 = ((ContactsSearchParams) ZeusTransformUtils.preCheckCast(r13, ContactsSearchParams.class, "com.obric.aiagent.plugin")).query;
    L9:
        String r4 = r1;
        String r2 = this.contactName;
        if (r2 != null) goto L12;
        r2 = ((ContactsSearchParams) ZeusTransformUtils.preCheckCast(r13, ContactsSearchParams.class, "com.obric.aiagent.plugin")).contactName;
    L12:
        String r5 = r2;
        String r3 = this.telephone;
        if (r3 != null) goto L15;
        r3 = ((ContactsSearchParams) ZeusTransformUtils.preCheckCast(r13, ContactsSearchParams.class, "com.obric.aiagent.plugin")).telephone;
    L15:
        String r6 = r3;
        String r7 = this.telephoneType;
        if (r7 != null) goto L18;
        r7 = ((ContactsSearchParams) ZeusTransformUtils.preCheckCast(r13, ContactsSearchParams.class, "com.obric.aiagent.plugin")).telephoneType;
    L18:
        String r8 = r7;
        String r9 = this.company;
        if (r9 != null) goto L21;
        r9 = ((ContactsSearchParams) ZeusTransformUtils.preCheckCast(r13, ContactsSearchParams.class, "com.obric.aiagent.plugin")).company;
    L21:
        String r10 = r9;
        String r11 = this.email;
        if (r11 != null) goto L24;
        r11 = ((ContactsSearchParams) ZeusTransformUtils.preCheckCast(r13, ContactsSearchParams.class, "com.obric.aiagent.plugin")).email;
    L24:
        String r12 = r11;
        String r14 = this.content;
        if (r14 != null) goto L27;
        r14 = ((ContactsSearchParams) ZeusTransformUtils.preCheckCast(r13, ContactsSearchParams.class, "com.obric.aiagent.plugin")).content;
    L27:
        String r15 = r14;
        Integer r16 = this.maxCount;
        if (r16 != null) goto L31;
        r16 = ((ContactsSearchParams) ZeusTransformUtils.preCheckCast(r13, ContactsSearchParams.class, "com.obric.aiagent.plugin")).maxCount;
    L31:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new ContactsSearchParams(r4, r5, r6, r8, r10, r12, r15, r16), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
