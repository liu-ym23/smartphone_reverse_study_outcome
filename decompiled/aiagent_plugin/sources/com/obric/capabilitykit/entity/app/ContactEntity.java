package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.GenderEnum;
import com.obric.capabilitykit.entity.meta.MetaAddress;
import com.obric.capabilitykit.entity.meta.MetaAnniversary;
import com.obric.capabilitykit.entity.meta.MetaCredentialNumber;
import com.obric.capabilitykit.entity.meta.MetaEmailAddress;
import com.obric.capabilitykit.entity.meta.MetaInstantMessaging;
import com.obric.capabilitykit.entity.meta.MetaRelationship;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ContactEntity extends AppEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 6;
    private static final int RELATED_VERSION = 1;
    private List<MetaAddress> addresses;
    private List<MetaAnniversary> anniversaries;
    private FileEntity avatar;
    private String company;
    private List<MetaCredentialNumber> credentialNumbers;
    private String department;
    private List<MetaEmailAddress> emails;
    private GenderEnum gender;
    private List<MetaInstantMessaging> instantMessagings;
    private String jobTitle;
    private MetaTelephone lastUsedTelephone;
    private Long lastUsedTelephoneTimeStamp;
    private String name;
    private String note;
    private List<MetaRelationship> relationShips;
    private String subNote;
    private List<MetaTelephone> telephones;
    private String voip;
    private List<String> websites;

    public static final class CREATOR implements Parcelable.Creator<ContactEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContactEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.ContactEntity");
            return (ContactEntity) ZeusTransformUtils.preCheckCast(r1, ContactEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 7;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContactEntity[] newArray(int r1) {
            return new ContactEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    public static final class a extends p implements b<MetaTelephone, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f32090a = null;

        static {
            f32090a = new a();
        }

        public a() {
            super(1);
        }

        public final CharSequence a(MetaTelephone r1) {
            o.e(r1, "it");
            return r1.getTelephone();
        }

        @Override // d.h.a.b
        public /* synthetic */ CharSequence invoke(MetaTelephone r3) {
            return a((MetaTelephone) ZeusTransformUtils.preCheckCast(r3, MetaTelephone.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public ContactEntity(Parcel r10) {
        o.e(r10, "parcel");
        this(EntityExtKt.a(r10), r10.readLong(), r10.readLong(), EntityExtKt.a(r10), r10.createTypedArrayList(MetaTelephone.CREATOR));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r10);
        int r0 = r10.readInt();
        this.avatar = (FileEntity) ZeusTransformUtils.preCheckCast(r10.readParcelable(FileEntity.class.getClassLoader()), FileEntity.class, "com.obric.aiagent.plugin");
        this.note = r10.readString();
        this.gender = GenderEnum.Companion.a(r10.readString());
        this.credentialNumbers = r10.createTypedArrayList(MetaCredentialNumber.CREATOR);
        this.emails = r10.createTypedArrayList(MetaEmailAddress.CREATOR);
        this.addresses = r10.createTypedArrayList(MetaAddress.CREATOR);
        this.company = r10.readString();
        this.instantMessagings = r10.createTypedArrayList(MetaInstantMessaging.CREATOR);
        this.anniversaries = r10.createTypedArrayList(MetaAnniversary.CREATOR);
        this.voip = r10.readString();
        this.relationShips = r10.createTypedArrayList(MetaRelationship.CREATOR);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r10, 6, r0);
    }

    public ContactEntity(String r9, long r10, long r12, String r14, List<MetaTelephone> r15) {
        List<MetaTelephone> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        o.e(r9, DbHelper.COL_ID);
        o.e(r14, "name");
        super(r9, r10, r12, 201);
        this.name = r14;
        this.telephones = r16;
    }

    public /* synthetic */ ContactEntity(String r10, long r11, long r13, String r15, List r16, int r17, h r18) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        if ((r17 & 16) == 0) goto L5;
        r0 = null;
    L5:
        this(r10, r11, r13, r15, r0);
    }

    public final List<MetaAddress> getAddresses() {
        return this.addresses;
    }

    public final List<MetaAnniversary> getAnniversaries() {
        return this.anniversaries;
    }

    public final FileEntity getAvatar() {
        return this.avatar;
    }

    public final String getCompany() {
        return this.company;
    }

    public final List<MetaCredentialNumber> getCredentialNumbers() {
        return this.credentialNumbers;
    }

    public final String getDepartment() {
        return this.department;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public DisplayRepresentation getDisplayRepresentation() {
        List<MetaTelephone> r0 = this.telephones;
        Uri r9 = null;
        if (r0 == null) goto L5;
        String r4 = d.a.p.a(r0, "\n", null, null, 0, null, a.f32090a, 30, null);
    L6:
        FileEntity r1 = this.avatar;
        if (r1 == null) goto L10;
        r9 = r1.getContentUrl();
    L10:
        return new DisplayRepresentation(r9, this.name, r4, getLastModifiedTime());
    L5:
        r4 = null;
        goto L6
    }

    public final List<MetaEmailAddress> getEmails() {
        return this.emails;
    }

    public final GenderEnum getGender() {
        return this.gender;
    }

    public final List<MetaInstantMessaging> getInstantMessagings() {
        return this.instantMessagings;
    }

    public final String getJobTitle() {
        return this.jobTitle;
    }

    public final MetaTelephone getLastUsedTelephone() {
        return this.lastUsedTelephone;
    }

    public final Long getLastUsedTelephoneTimeStamp() {
        return this.lastUsedTelephoneTimeStamp;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNote() {
        return this.note;
    }

    public final List<MetaRelationship> getRelationShips() {
        return this.relationShips;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        FileEntity r0 = this.avatar;
        if (r0 == null) goto L7;
        List<Uri> r1 = r0.getSharedUris();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return d.a.p.b();
    }

    public final String getSubNote() {
        return this.subNote;
    }

    public final List<MetaTelephone> getTelephones() {
        return this.telephones;
    }

    public final String getVoip() {
        return this.voip;
    }

    public final List<String> getWebsites() {
        return this.websites;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r2, ClassLoader r3, int r4) {
        o.e(r2, "parcel");
        switch(r4) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L17;
        };
    L5:
        this.lastUsedTelephoneTimeStamp = (Long) ZeusTransformUtils.preCheckCast(r2.readValue(r3), Long.class, "com.obric.aiagent.plugin");
        return;
    L6:
        this.lastUsedTelephone = (MetaTelephone) ZeusTransformUtils.preCheckCast(r2.readValue(r3), MetaTelephone.class, "com.obric.aiagent.plugin");
        return;
    L7:
        this.websites = (List) ZeusTransformUtils.preCheckCast(r2.readValue(r3), List.class, "com.obric.aiagent.plugin");
        return;
    L8:
        this.subNote = (String) ZeusTransformUtils.preCheckCast(r2.readValue(r3), String.class, "com.obric.aiagent.plugin");
        return;
    L9:
        this.department = (String) ZeusTransformUtils.preCheckCast(r2.readValue(r3), String.class, "com.obric.aiagent.plugin");
        return;
    L10:
        this.jobTitle = (String) ZeusTransformUtils.preCheckCast(r2.readValue(r3), String.class, "com.obric.aiagent.plugin");
        return;
    }

    public final void setAddresses(List<MetaAddress> r3) {
        this.addresses = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setAnniversaries(List<MetaAnniversary> r3) {
        this.anniversaries = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setAvatar(FileEntity r1) {
        this.avatar = r1;
    }

    public final void setCompany(String r1) {
        this.company = r1;
    }

    public final void setCredentialNumbers(List<MetaCredentialNumber> r3) {
        this.credentialNumbers = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setDepartment(String r1) {
        this.department = r1;
    }

    public final void setEmails(List<MetaEmailAddress> r3) {
        this.emails = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setGender(GenderEnum r1) {
        this.gender = r1;
    }

    public final void setInstantMessagings(List<MetaInstantMessaging> r3) {
        this.instantMessagings = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setJobTitle(String r1) {
        this.jobTitle = r1;
    }

    public final void setLastUsedTelephone(MetaTelephone r1) {
        this.lastUsedTelephone = r1;
    }

    public final void setLastUsedTelephoneTimeStamp(Long r1) {
        this.lastUsedTelephoneTimeStamp = r1;
    }

    public final void setName(String r2) {
        o.e(r2, "<set-?>");
        this.name = r2;
    }

    public final void setNote(String r1) {
        this.note = r1;
    }

    public final void setRelationShips(List<MetaRelationship> r3) {
        this.relationShips = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setSubNote(String r1) {
        this.subNote = r1;
    }

    public final void setTelephones(List<MetaTelephone> r3) {
        this.telephones = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setVoip(String r1) {
        this.voip = r1;
    }

    public final void setWebsites(List<String> r3) {
        this.websites = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.name);
        r2.writeTypedList(this.telephones);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeInt(6);
        r2.writeParcelable(this.avatar, r3);
        r2.writeString(this.note);
        GenderEnum r4 = this.gender;
        if (r4 == null) goto L5;
        String r5 = r4.name();
    L6:
        r2.writeString(r5);
        r2.writeTypedList(this.credentialNumbers);
        r2.writeTypedList(this.emails);
        r2.writeTypedList(this.addresses);
        r2.writeString(this.company);
        r2.writeTypedList(this.instantMessagings);
        r2.writeTypedList(this.anniversaries);
        r2.writeString(this.voip);
        r2.writeTypedList(this.relationShips);
        r2.writeValue(this.jobTitle);
        r2.writeValue(this.department);
        r2.writeValue(this.subNote);
        r2.writeValue(this.websites);
        r2.writeValue(this.lastUsedTelephone);
        r2.writeValue(this.lastUsedTelephoneTimeStamp);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
