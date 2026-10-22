package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.versionedparcelable.VersionedParcelable;
import com.ttnet.org.chromium.net.PrivateKeyType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Be\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0019Jn\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010,J\t\u0010-\u001a\u00020\fHÖ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\fHÖ\u0001J\u0012\u00103\u001a\u00020\u00012\b\u00104\u001a\u0004\u0018\u000101H\u0016J\t\u00105\u001a\u00020\u0004HÖ\u0001J\u0019\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\fHÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011¨\u0006;"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ContactsSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "query", "", "contactName", "telephone", "telephoneType", "company", "email", ServerElements.CONTENT, "maxCount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getCompany", "()Ljava/lang/String;", "setCompany", "(Ljava/lang/String;)V", "getContactName", "setContactName", "getContent", "setContent", "getEmail", "setEmail", "getMaxCount", "()Ljava/lang/Integer;", "setMaxCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getQuery", "setQuery", "getTelephone", "setTelephone", "getTelephoneType", "setTelephoneType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/ContactsSearchParams;", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class ContactsSearchParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<ContactsSearchParams> CREATOR = null;

    @Nullable
    private String company;

    @Nullable
    private String contactName;

    @Nullable
    private String content;

    @Nullable
    private String email;

    @Nullable
    private Integer maxCount;

    @Nullable
    private String query;

    @Nullable
    private String telephone;

    @Nullable
    private String telephoneType;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ContactsSearchParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactsSearchParams createFromParcel(@NotNull Parcel r11) {
            int r10 = r11.readInt();
            q.g(r11, "parcel");
            String r12 = r11.readString();
            String r13 = r11.readString();
            String r14 = r11.readString();
            String r15 = r11.readString();
            String r16 = r11.readString();
            String r17 = r11.readString();
            String r18 = r11.readString();
            if (r11.readInt() != 0) goto L6;
            Integer r19 = null;
        L7:
            ContactsSearchParams r20 = new ContactsSearchParams(r12, r13, r14, r15, r16, r17, r18, r19);
            int r21 = Math.min(r10, 0);
            ClassLoader r22 = Creator.class.getClassLoader();
            int r23 = 1;
        L8:
            if (r23 > r21) goto L10;
            r23 = r23 + 1;
        L10:
            if (r23 > r10) goto L12;
            a.d(r11, r22);
            r23 = r23 + 1;
            goto L10
        L12:
            return r20;
        L6:
            r19 = Integer.valueOf(r11.readInt());
            goto L7
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactsSearchParams[] newArray(int r10) {
            return new ContactsSearchParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsSearchParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsSearchParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public ContactsSearchParams() {
        String r10 = null;
        String r11 = null;
        String r12 = null;
        String r13 = null;
        String r14 = null;
        String r15 = null;
        String r16 = null;
        Integer r17 = null;
        this(r10, r11, r12, r13, r14, r15, r16, r17, PrivateKeyType.INVALID, null);
    }

    public static /* synthetic */ ContactsSearchParams copy$default(ContactsSearchParams r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, Integer r18, int r19, Object r110) {
        if ((r19 & 1) == 0) goto L5;
        String r20 = r10.query;
    L7:
        if ((r19 & 2) == 0) goto L9;
        String r21 = r10.contactName;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r22 = r10.telephone;
    L15:
        if ((r19 & 8) == 0) goto L17;
        String r23 = r10.telephoneType;
    L19:
        if ((r19 & 16) == 0) goto L21;
        String r24 = r10.company;
    L23:
        if ((r19 & 32) == 0) goto L25;
        String r25 = r10.email;
    L27:
        if ((r19 & 64) == 0) goto L29;
        String r26 = r10.content;
    L31:
        if ((r19 & 128) == 0) goto L33;
        Integer r27 = r10.maxCount;
    L35:
        return r10.copy(r20, r21, r22, r23, r24, r25, r26, r27);
    L33:
        r27 = r18;
        goto L35
    L29:
        r26 = r17;
        goto L31
    L25:
        r25 = r16;
        goto L27
    L21:
        r24 = r15;
        goto L23
    L17:
        r23 = r14;
        goto L19
    L13:
        r22 = r13;
        goto L15
    L9:
        r21 = r12;
        goto L11
    L5:
        r20 = r11;
        goto L7
    }

    @Nullable
    public final String component1() {
        return this.query;
    }

    @Nullable
    public final String component2() {
        return this.contactName;
    }

    @Nullable
    public final String component3() {
        return this.telephone;
    }

    @Nullable
    public final String component4() {
        return this.telephoneType;
    }

    @Nullable
    public final String component5() {
        return this.company;
    }

    @Nullable
    public final String component6() {
        return this.email;
    }

    @Nullable
    public final String component7() {
        return this.content;
    }

    @Nullable
    public final Integer component8() {
        return this.maxCount;
    }

    @NotNull
    public final ContactsSearchParams copy(@Nullable String r11, @Nullable String r12, @Nullable String r13, @Nullable String r14, @Nullable String r15, @Nullable String r16, @Nullable String r17, @Nullable Integer r18) {
        return new ContactsSearchParams(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ContactsSearchParams) == true) goto L8;
        return false;
    L8:
        ContactsSearchParams r11 = (ContactsSearchParams) r10;
        if (q.b(this.query, r11.query) == true) goto L12;
        return false;
    L12:
        if (q.b(this.contactName, r11.contactName) == true) goto L15;
        return false;
    L15:
        if (q.b(this.telephone, r11.telephone) == true) goto L18;
        return false;
    L18:
        if (q.b(this.telephoneType, r11.telephoneType) == true) goto L21;
        return false;
    L21:
        if (q.b(this.company, r11.company) == true) goto L24;
        return false;
    L24:
        if (q.b(this.email, r11.email) == true) goto L27;
        return false;
    L27:
        if (q.b(this.content, r11.content) == true) goto L30;
        return false;
    L30:
        if (q.b(this.maxCount, r11.maxCount) == true) goto L32;
        return false;
    L32:
        return true;
    }

    @Nullable
    public final String getCompany() {
        return this.company;
    }

    @Nullable
    public final String getContactName() {
        return this.contactName;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final String getEmail() {
        return this.email;
    }

    @Nullable
    public final Integer getMaxCount() {
        return this.maxCount;
    }

    @Nullable
    public final String getQuery() {
        return this.query;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final String getTelephone() {
        return this.telephone;
    }

    @Nullable
    public final String getTelephoneType() {
        return this.telephoneType;
    }

    public int hashCode() {
        String r10 = this.query;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.contactName;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.telephone;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.telephoneType;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String r23 = this.company;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 31;
        String r26 = this.email;
        if (r26 != null) goto L25;
        int r27 = 0;
    L26:
        int r28 = (r25 + r27) * 31;
        String r29 = this.content;
        if (r29 != null) goto L29;
        int r30 = 0;
    L30:
        int r31 = (r28 + r30) * 31;
        Integer r32 = this.maxCount;
        if (r32 == null) goto L35;
        r11 = r32.hashCode();
    L35:
        return r31 + r11;
    L29:
        r30 = r29.hashCode();
        goto L30
    L25:
        r27 = r26.hashCode();
        goto L26
    L21:
        r24 = r23.hashCode();
        goto L22
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r11) {
        if ((r11 instanceof ContactsSearchParams) == true) goto L5;
        return this;
    L5:
        String r10 = this.query;
        if (r10 != null) goto L8;
        r10 = ((ContactsSearchParams) r11).query;
    L8:
        String r12 = r10;
        String r13 = this.contactName;
        if (r13 != null) goto L11;
        r13 = ((ContactsSearchParams) r11).contactName;
    L11:
        String r14 = r13;
        String r15 = this.telephone;
        if (r15 != null) goto L14;
        r15 = ((ContactsSearchParams) r11).telephone;
    L14:
        String r16 = r15;
        String r17 = this.telephoneType;
        if (r17 != null) goto L17;
        r17 = ((ContactsSearchParams) r11).telephoneType;
    L17:
        String r18 = r17;
        String r19 = this.company;
        if (r19 != null) goto L20;
        r19 = ((ContactsSearchParams) r11).company;
    L20:
        String r20 = r19;
        String r21 = this.email;
        if (r21 != null) goto L23;
        r21 = ((ContactsSearchParams) r11).email;
    L23:
        String r22 = r21;
        String r23 = this.content;
        if (r23 != null) goto L26;
        r23 = ((ContactsSearchParams) r11).content;
    L26:
        String r24 = r23;
        Integer r110 = this.maxCount;
        if (r110 != null) goto L30;
        r110 = ((ContactsSearchParams) r11).maxCount;
    L30:
        return new ContactsSearchParams(r12, r14, r16, r18, r20, r22, r24, r110);
    }

    public final void setCompany(@Nullable String r10) {
        this.company = r10;
    }

    public final void setContactName(@Nullable String r10) {
        this.contactName = r10;
    }

    public final void setContent(@Nullable String r10) {
        this.content = r10;
    }

    public final void setEmail(@Nullable String r10) {
        this.email = r10;
    }

    public final void setMaxCount(@Nullable Integer r10) {
        this.maxCount = r10;
    }

    public final void setQuery(@Nullable String r10) {
        this.query = r10;
    }

    public final void setTelephone(@Nullable String r10) {
        this.telephone = r10;
    }

    public final void setTelephoneType(@Nullable String r10) {
        this.telephoneType = r10;
    }

    @NotNull
    public String toString() {
        return "ContactsSearchParams(query=" + this.query + ", contactName=" + this.contactName + ", telephone=" + this.telephone + ", telephoneType=" + this.telephoneType + ", company=" + this.company + ", email=" + this.email + ", content=" + this.content + ", maxCount=" + this.maxCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.query);
        r10.writeString(this.contactName);
        r10.writeString(this.telephone);
        r10.writeString(this.telephoneType);
        r10.writeString(this.company);
        r10.writeString(this.email);
        r10.writeString(this.content);
        Integer r12 = this.maxCount;
        if (r12 != null) goto L5;
        r10.writeInt(0);
        return;
    L5:
        r10.writeInt(1);
        r10.writeInt(r12.intValue());
    }

    public ContactsSearchParams(@Nullable String r10, @Nullable String r11, @Nullable String r12, @Nullable String r13, @Nullable String r14, @Nullable String r15, @Nullable String r16, @Nullable Integer r17) {
        this.query = r10;
        this.contactName = r11;
        this.telephone = r12;
        this.telephoneType = r13;
        this.company = r14;
        this.email = r15;
        this.content = r16;
        this.maxCount = r17;
    }

    public /* synthetic */ ContactsSearchParams(String r10, String r11, String r12, String r13, String r14, String r15, String r16, Integer r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r18 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r18 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r18 & 8) == 0) goto L15;
        r13 = null;
    L15:
        if ((r18 & 16) == 0) goto L18;
        r14 = null;
    L18:
        if ((r18 & 32) == 0) goto L21;
        r15 = null;
    L21:
        if ((r18 & 64) == 0) goto L24;
        r16 = null;
    L24:
        if ((r18 & 128) == 0) goto L26;
        r17 = null;
    L26:
        this(r10, r11, r12, r13, r14, r15, r16, r17);
    }
}
