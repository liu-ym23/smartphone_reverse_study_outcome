package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.collections.t;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0001hB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B7\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0002\u0010\u000fJ\b\u0010\\\u001a\u00020]H\u0016J\u000e\u0010^\u001a\b\u0012\u0004\u0012\u00020_0\rH\u0016J\"\u0010`\u001a\u00020a2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010d\u001a\u00020eH\u0016J\u0018\u0010f\u001a\u00020a2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010g\u001a\u00020eH\u0016R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010\u0015R\u001c\u0010)\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\"\"\u0004\b+\u0010$R\"\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0013\"\u0004\b9\u0010\u0015R\u001c\u0010:\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\"\"\u0004\b<\u0010$R\u001c\u0010=\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001e\u0010B\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\"\"\u0004\bI\u0010$R\u001c\u0010J\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\"\"\u0004\bL\u0010$R\"\u0010M\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0013\"\u0004\bP\u0010\u0015R\u001c\u0010Q\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\"\"\u0004\bS\u0010$R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0013\"\u0004\bU\u0010\u0015R\u001c\u0010V\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\"\"\u0004\bX\u0010$R\"\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0013\"\u0004\b[\u0010\u0015¨\u0006i"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ContactEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "name", "telephones", "", "Lcom/obric/capabilitykit/entity/meta/MetaTelephone;", "(Ljava/lang/String;JJLjava/lang/String;Ljava/util/List;)V", "addresses", "Lcom/obric/capabilitykit/entity/meta/MetaAddress;", "getAddresses", "()Ljava/util/List;", "setAddresses", "(Ljava/util/List;)V", "anniversaries", "Lcom/obric/capabilitykit/entity/meta/MetaAnniversary;", "getAnniversaries", "setAnniversaries", "avatar", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "getAvatar", "()Lcom/obric/capabilitykit/entity/app/FileEntity;", "setAvatar", "(Lcom/obric/capabilitykit/entity/app/FileEntity;)V", "company", "getCompany", "()Ljava/lang/String;", "setCompany", "(Ljava/lang/String;)V", "credentialNumbers", "Lcom/obric/capabilitykit/entity/meta/MetaCredentialNumber;", "getCredentialNumbers", "setCredentialNumbers", "department", "getDepartment", "setDepartment", "emails", "Lcom/obric/capabilitykit/entity/meta/MetaEmailAddress;", "getEmails", "setEmails", "gender", "Lcom/obric/capabilitykit/entity/enums/GenderEnum;", "getGender", "()Lcom/obric/capabilitykit/entity/enums/GenderEnum;", "setGender", "(Lcom/obric/capabilitykit/entity/enums/GenderEnum;)V", "instantMessagings", "Lcom/obric/capabilitykit/entity/meta/MetaInstantMessaging;", "getInstantMessagings", "setInstantMessagings", "jobTitle", "getJobTitle", "setJobTitle", "lastUsedTelephone", "getLastUsedTelephone", "()Lcom/obric/capabilitykit/entity/meta/MetaTelephone;", "setLastUsedTelephone", "(Lcom/obric/capabilitykit/entity/meta/MetaTelephone;)V", "lastUsedTelephoneTimeStamp", "getLastUsedTelephoneTimeStamp", "()Ljava/lang/Long;", "setLastUsedTelephoneTimeStamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getName", "setName", "note", "getNote", "setNote", "relationShips", "Lcom/obric/capabilitykit/entity/meta/MetaRelationship;", "getRelationShips", "setRelationShips", "subNote", "getSubNote", "setSubNote", "getTelephones", "setTelephones", "voip", "getVoip", "setVoip", "websites", "getWebsites", "setWebsites", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ContactEntity extends AppEntity implements IUriSharerEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 6;
    private static final int RELATED_VERSION = 1;

    @Nullable
    private List<MetaAddress> addresses;

    @Nullable
    private List<MetaAnniversary> anniversaries;

    @Nullable
    private FileEntity avatar;

    @Nullable
    private String company;

    @Nullable
    private List<MetaCredentialNumber> credentialNumbers;

    @Nullable
    private String department;

    @Nullable
    private List<MetaEmailAddress> emails;

    @Nullable
    private GenderEnum gender;

    @Nullable
    private List<MetaInstantMessaging> instantMessagings;

    @Nullable
    private String jobTitle;

    @Nullable
    private MetaTelephone lastUsedTelephone;

    @Nullable
    private Long lastUsedTelephoneTimeStamp;

    @NotNull
    private String name;

    @Nullable
    private String note;

    @Nullable
    private List<MetaRelationship> relationShips;

    @Nullable
    private String subNote;

    @Nullable
    private List<MetaTelephone> telephones;

    @Nullable
    private String voip;

    @Nullable
    private List<String> websites;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ContactEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/ContactEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<ContactEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ContactEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.ContactEntity");
            return (ContactEntity) r11;
        }

        public final int getVersion() {
            return 7;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ContactEntity[] newArray(int r10) {
            return new ContactEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/entity/meta/MetaTelephone;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function1<MetaTelephone, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11323a = null;

        static {
            f11323a = new a();
        }

        public a() {
            super(1);
        }

        @NotNull
        public final CharSequence a(@NotNull MetaTelephone r10) {
            q.g(r10, "it");
            return r10.getTelephone();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(MetaTelephone r10) {
            return a(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public ContactEntity(@NotNull Parcel r10) {
        q.g(r10, "parcel");
        this(EntityExtKt.f(r10), r10.readLong(), r10.readLong(), EntityExtKt.f(r10), r10.createTypedArrayList(MetaTelephone.CREATOR));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r10);
        int r11 = r10.readInt();
        this.avatar = (FileEntity) r10.readParcelable(FileEntity.class.getClassLoader());
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
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r10, 6, r11);
    }

    @Nullable
    public final List<MetaAddress> getAddresses() {
        return this.addresses;
    }

    @Nullable
    public final List<MetaAnniversary> getAnniversaries() {
        return this.anniversaries;
    }

    @Nullable
    public final FileEntity getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getCompany() {
        return this.company;
    }

    @Nullable
    public final List<MetaCredentialNumber> getCredentialNumbers() {
        return this.credentialNumbers;
    }

    @Nullable
    public final String getDepartment() {
        return this.department;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    @NotNull
    public DisplayRepresentation getDisplayRepresentation() {
        List<MetaTelephone> r10 = this.telephones;
        Uri r11 = null;
        if (r10 == null) goto L5;
        String r12 = b0.h0(r10, "\n", null, null, 0, null, a.f11323a, 30, null);
    L6:
        FileEntity r13 = this.avatar;
        if (r13 == null) goto L10;
        r11 = r13.getContentUrl();
    L10:
        return new DisplayRepresentation(r11, this.name, r12, getLastModifiedTime());
    L5:
        r12 = null;
        goto L6
    }

    @Nullable
    public final List<MetaEmailAddress> getEmails() {
        return this.emails;
    }

    @Nullable
    public final GenderEnum getGender() {
        return this.gender;
    }

    @Nullable
    public final List<MetaInstantMessaging> getInstantMessagings() {
        return this.instantMessagings;
    }

    @Nullable
    public final String getJobTitle() {
        return this.jobTitle;
    }

    @Nullable
    public final MetaTelephone getLastUsedTelephone() {
        return this.lastUsedTelephone;
    }

    @Nullable
    public final Long getLastUsedTelephoneTimeStamp() {
        return this.lastUsedTelephoneTimeStamp;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getNote() {
        return this.note;
    }

    @Nullable
    public final List<MetaRelationship> getRelationShips() {
        return this.relationShips;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    @NotNull
    public List<Uri> getSharedUris() {
        FileEntity r10 = this.avatar;
        if (r10 == null) goto L7;
        List<Uri> r11 = r10.getSharedUris();
        if (r11 == null) goto L7;
        return r11;
    L7:
        return t.i();
    }

    @Nullable
    public final String getSubNote() {
        return this.subNote;
    }

    @Nullable
    public final List<MetaTelephone> getTelephones() {
        return this.telephones;
    }

    @Nullable
    public final String getVoip() {
        return this.voip;
    }

    @Nullable
    public final List<String> getWebsites() {
        return this.websites;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
        switch(r12) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L17;
        };
    L5:
        this.lastUsedTelephoneTimeStamp = (Long) r10.readValue(r11);
        return;
    L6:
        this.lastUsedTelephone = (MetaTelephone) r10.readValue(r11);
        return;
    L7:
        this.websites = (List) r10.readValue(r11);
        return;
    L8:
        this.subNote = (String) r10.readValue(r11);
        return;
    L9:
        this.department = (String) r10.readValue(r11);
        return;
    L10:
        this.jobTitle = (String) r10.readValue(r11);
        return;
    }

    public final void setAddresses(@Nullable List<MetaAddress> r10) {
        this.addresses = r10;
    }

    public final void setAnniversaries(@Nullable List<MetaAnniversary> r10) {
        this.anniversaries = r10;
    }

    public final void setAvatar(@Nullable FileEntity r10) {
        this.avatar = r10;
    }

    public final void setCompany(@Nullable String r10) {
        this.company = r10;
    }

    public final void setCredentialNumbers(@Nullable List<MetaCredentialNumber> r10) {
        this.credentialNumbers = r10;
    }

    public final void setDepartment(@Nullable String r10) {
        this.department = r10;
    }

    public final void setEmails(@Nullable List<MetaEmailAddress> r10) {
        this.emails = r10;
    }

    public final void setGender(@Nullable GenderEnum r10) {
        this.gender = r10;
    }

    public final void setInstantMessagings(@Nullable List<MetaInstantMessaging> r10) {
        this.instantMessagings = r10;
    }

    public final void setJobTitle(@Nullable String r10) {
        this.jobTitle = r10;
    }

    public final void setLastUsedTelephone(@Nullable MetaTelephone r10) {
        this.lastUsedTelephone = r10;
    }

    public final void setLastUsedTelephoneTimeStamp(@Nullable Long r10) {
        this.lastUsedTelephoneTimeStamp = r10;
    }

    public final void setName(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.name = r10;
    }

    public final void setNote(@Nullable String r10) {
        this.note = r10;
    }

    public final void setRelationShips(@Nullable List<MetaRelationship> r10) {
        this.relationShips = r10;
    }

    public final void setSubNote(@Nullable String r10) {
        this.subNote = r10;
    }

    public final void setTelephones(@Nullable List<MetaTelephone> r10) {
        this.telephones = r10;
    }

    public final void setVoip(@Nullable String r10) {
        this.voip = r10;
    }

    public final void setWebsites(@Nullable List<String> r10) {
        this.websites = r10;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeString(this.name);
        r10.writeTypedList(this.telephones);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeInt(6);
        r10.writeParcelable(this.avatar, r11);
        r10.writeString(this.note);
        GenderEnum r12 = this.gender;
        if (r12 == null) goto L5;
        String r13 = r12.name();
    L6:
        r10.writeString(r13);
        r10.writeTypedList(this.credentialNumbers);
        r10.writeTypedList(this.emails);
        r10.writeTypedList(this.addresses);
        r10.writeString(this.company);
        r10.writeTypedList(this.instantMessagings);
        r10.writeTypedList(this.anniversaries);
        r10.writeString(this.voip);
        r10.writeTypedList(this.relationShips);
        r10.writeValue(this.jobTitle);
        r10.writeValue(this.department);
        r10.writeValue(this.subNote);
        r10.writeValue(this.websites);
        r10.writeValue(this.lastUsedTelephone);
        r10.writeValue(this.lastUsedTelephoneTimeStamp);
        return;
    L5:
        r13 = null;
        goto L6
    }

    public ContactEntity(@NotNull String r10, long r11, long r12, @NotNull String r14, @Nullable List<MetaTelephone> r15) {
        q.g(r10, "id");
        q.g(r14, "name");
        super(r10, r11, r12, 201);
        this.name = r14;
        this.telephones = r15;
    }

    public /* synthetic */ ContactEntity(String r10, long r11, long r13, String r15, List r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 16) == 0) goto L5;
        List r12 = null;
    L6:
        this(r10, r11, r13, r15, r12);
        return;
    L5:
        r12 = r16;
        goto L6
    }
}
