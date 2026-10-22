package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.versionedparcelable.VersionedParcelable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0083\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0010J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010&J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u008c\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u00105J\t\u00106\u001a\u000207HÖ\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u000207HÖ\u0001J\u0012\u0010=\u001a\u00020\u00012\b\u0010>\u001a\u0004\u0018\u00010;H\u0016J\t\u0010?\u001a\u00020\u0004HÖ\u0001J\u0019\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u000207HÖ\u0001R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006E"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ContactsCreateParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "name", "", "telephones", "", "Lcom/obric/capabilitykit/common/intent/Telephone;", "company", "note", "email", "identifyCard", "gender", "birthday", "relationship", "address", "(Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Telephone;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getBirthday", "setBirthday", "getCompany", "setCompany", "getEmail", "setEmail", "getGender", "setGender", "getIdentifyCard", "setIdentifyCard", "getName", "setName", "getNote", "setNote", "getRelationship", "setRelationship", "getTelephones", "()[Lcom/obric/capabilitykit/common/intent/Telephone;", "setTelephones", "([Lcom/obric/capabilitykit/common/intent/Telephone;)V", "[Lcom/obric/capabilitykit/common/intent/Telephone;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Telephone;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/ContactsCreateParams;", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class ContactsCreateParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<ContactsCreateParams> CREATOR = null;

    @Nullable
    private String address;

    @Nullable
    private String birthday;

    @Nullable
    private String company;

    @Nullable
    private String email;

    @Nullable
    private String gender;

    @Nullable
    private String identifyCard;

    @Nullable
    private String name;

    @Nullable
    private String note;

    @Nullable
    private String relationship;

    @Nullable
    private Telephone[] telephones;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ContactsCreateParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactsCreateParams createFromParcel(@NotNull Parcel r14) {
            int r13 = r14.readInt();
            q.g(r14, "parcel");
            String r10 = r14.readString();
            if (r14.readInt() != 0) goto L5;
            Telephone[] r11 = null;
        L9:
            ContactsCreateParams r12 = new ContactsCreateParams(r10, r11, r14.readString(), r14.readString(), r14.readString(), r14.readString(), r14.readString(), r14.readString(), r14.readString(), r14.readString());
            int r15 = Math.min(r13, 0);
            ClassLoader r16 = Creator.class.getClassLoader();
            int r17 = 1;
        L10:
            if (r17 > r15) goto L12;
            r17 = r17 + 1;
        L12:
            if (r17 > r13) goto L14;
            a.d(r14, r16);
            r17 = r17 + 1;
            goto L12
        L14:
            return r12;
        L5:
            int r18 = r14.readInt();
            Telephone[] r19 = new Telephone[r18];
            int r20 = 0;
        L6:
            if (r20 == r18) goto L8;
            r19[r20] = Telephone.CREATOR.createFromParcel(r14);
            r20 = r20 + 1;
            goto L6
        L8:
            r11 = r19;
            goto L9
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactsCreateParams[] newArray(int r10) {
            return new ContactsCreateParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsCreateParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsCreateParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public ContactsCreateParams() {
        String r10 = null;
        Telephone[] r11 = null;
        String r12 = null;
        String r13 = null;
        String r14 = null;
        String r15 = null;
        String r16 = null;
        String r17 = null;
        String r18 = null;
        String r19 = null;
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, 1023, null);
    }

    public static /* synthetic */ ContactsCreateParams copy$default(ContactsCreateParams r11, String r12, Telephone[] r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r10 = r11.name;
    L7:
        if ((r22 & 2) == 0) goto L9;
        Telephone[] r24 = r11.telephones;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r25 = r11.company;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r26 = r11.note;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r27 = r11.email;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r28 = r11.identifyCard;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r29 = r11.gender;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r30 = r11.birthday;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r110 = r11.relationship;
    L39:
        if ((r22 & 512) == 0) goto L41;
        String r31 = r11.address;
    L43:
        return r11.copy(r10, r24, r25, r26, r27, r28, r29, r30, r110, r31);
    L41:
        r31 = r21;
        goto L43
    L37:
        r110 = r20;
        goto L39
    L33:
        r30 = r19;
        goto L35
    L29:
        r29 = r18;
        goto L31
    L25:
        r28 = r17;
        goto L27
    L21:
        r27 = r16;
        goto L23
    L17:
        r26 = r15;
        goto L19
    L13:
        r25 = r14;
        goto L15
    L9:
        r24 = r13;
        goto L11
    L5:
        r10 = r12;
        goto L7
    }

    @Nullable
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final String component10() {
        return this.address;
    }

    @Nullable
    public final Telephone[] component2() {
        return this.telephones;
    }

    @Nullable
    public final String component3() {
        return this.company;
    }

    @Nullable
    public final String component4() {
        return this.note;
    }

    @Nullable
    public final String component5() {
        return this.email;
    }

    @Nullable
    public final String component6() {
        return this.identifyCard;
    }

    @Nullable
    public final String component7() {
        return this.gender;
    }

    @Nullable
    public final String component8() {
        return this.birthday;
    }

    @Nullable
    public final String component9() {
        return this.relationship;
    }

    @NotNull
    public final ContactsCreateParams copy(@Nullable String r13, @Nullable Telephone[] r14, @Nullable String r15, @Nullable String r16, @Nullable String r17, @Nullable String r18, @Nullable String r19, @Nullable String r20, @Nullable String r21, @Nullable String r22) {
        return new ContactsCreateParams(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ContactsCreateParams) == true) goto L8;
        return false;
    L8:
        ContactsCreateParams r11 = (ContactsCreateParams) r10;
        if (q.b(this.name, r11.name) == true) goto L12;
        return false;
    L12:
        if (q.b(this.telephones, r11.telephones) == true) goto L15;
        return false;
    L15:
        if (q.b(this.company, r11.company) == true) goto L18;
        return false;
    L18:
        if (q.b(this.note, r11.note) == true) goto L21;
        return false;
    L21:
        if (q.b(this.email, r11.email) == true) goto L24;
        return false;
    L24:
        if (q.b(this.identifyCard, r11.identifyCard) == true) goto L27;
        return false;
    L27:
        if (q.b(this.gender, r11.gender) == true) goto L30;
        return false;
    L30:
        if (q.b(this.birthday, r11.birthday) == true) goto L33;
        return false;
    L33:
        if (q.b(this.relationship, r11.relationship) == true) goto L36;
        return false;
    L36:
        if (q.b(this.address, r11.address) == true) goto L38;
        return false;
    L38:
        return true;
    }

    @Nullable
    public final String getAddress() {
        return this.address;
    }

    @Nullable
    public final String getBirthday() {
        return this.birthday;
    }

    @Nullable
    public final String getCompany() {
        return this.company;
    }

    @Nullable
    public final String getEmail() {
        return this.email;
    }

    @Nullable
    public final String getGender() {
        return this.gender;
    }

    @Nullable
    public final String getIdentifyCard() {
        return this.identifyCard;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getNote() {
        return this.note;
    }

    @Nullable
    public final String getRelationship() {
        return this.relationship;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final Telephone[] getTelephones() {
        return this.telephones;
    }

    public int hashCode() {
        String r10 = this.name;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        Telephone[] r14 = this.telephones;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.company;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.note;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String r23 = this.email;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 31;
        String r26 = this.identifyCard;
        if (r26 != null) goto L25;
        int r27 = 0;
    L26:
        int r28 = (r25 + r27) * 31;
        String r29 = this.gender;
        if (r29 != null) goto L29;
        int r30 = 0;
    L30:
        int r31 = (r28 + r30) * 31;
        String r32 = this.birthday;
        if (r32 != null) goto L33;
        int r33 = 0;
    L34:
        int r34 = (r31 + r33) * 31;
        String r35 = this.relationship;
        if (r35 != null) goto L37;
        int r36 = 0;
    L38:
        int r37 = (r34 + r36) * 31;
        String r38 = this.address;
        if (r38 == null) goto L43;
        r11 = r38.hashCode();
    L43:
        return r37 + r11;
    L37:
        r36 = r35.hashCode();
        goto L38
    L33:
        r33 = r32.hashCode();
        goto L34
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
        r15 = Arrays.hashCode(r14);
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
    public IntentParams mergeParams(@Nullable Object r13) {
        if ((r13 instanceof ContactsCreateParams) == true) goto L5;
        return this;
    L5:
        String r10 = this.name;
        if (r10 != null) goto L8;
        r10 = ((ContactsCreateParams) r13).name;
    L8:
        String r11 = r10;
        Telephone[] r12 = this.telephones;
        if (r12 != null) goto L11;
        r12 = ((ContactsCreateParams) r13).telephones;
    L11:
        Telephone[] r14 = r12;
        String r15 = this.company;
        if (r15 != null) goto L14;
        r15 = ((ContactsCreateParams) r13).company;
    L14:
        String r16 = r15;
        String r17 = this.note;
        if (r17 != null) goto L17;
        r17 = ((ContactsCreateParams) r13).note;
    L17:
        String r18 = r17;
        String r19 = this.email;
        if (r19 != null) goto L20;
        r19 = ((ContactsCreateParams) r13).email;
    L20:
        String r20 = r19;
        String r21 = this.identifyCard;
        if (r21 != null) goto L23;
        r21 = ((ContactsCreateParams) r13).identifyCard;
    L23:
        String r22 = r21;
        String r23 = this.gender;
        if (r23 != null) goto L26;
        r23 = ((ContactsCreateParams) r13).gender;
    L26:
        String r24 = r23;
        String r25 = this.birthday;
        if (r25 != null) goto L29;
        r25 = ((ContactsCreateParams) r13).birthday;
    L29:
        String r26 = r25;
        String r27 = this.relationship;
        if (r27 != null) goto L32;
        r27 = ((ContactsCreateParams) r13).relationship;
    L32:
        String r110 = r27;
        String r111 = this.address;
        if (r111 != null) goto L36;
        r111 = ((ContactsCreateParams) r13).address;
    L36:
        return new ContactsCreateParams(r11, r14, r16, r18, r20, r22, r24, r26, r110, r111);
    }

    public final void setAddress(@Nullable String r10) {
        this.address = r10;
    }

    public final void setBirthday(@Nullable String r10) {
        this.birthday = r10;
    }

    public final void setCompany(@Nullable String r10) {
        this.company = r10;
    }

    public final void setEmail(@Nullable String r10) {
        this.email = r10;
    }

    public final void setGender(@Nullable String r10) {
        this.gender = r10;
    }

    public final void setIdentifyCard(@Nullable String r10) {
        this.identifyCard = r10;
    }

    public final void setName(@Nullable String r10) {
        this.name = r10;
    }

    public final void setNote(@Nullable String r10) {
        this.note = r10;
    }

    public final void setRelationship(@Nullable String r10) {
        this.relationship = r10;
    }

    public final void setTelephones(@Nullable Telephone[] r10) {
        this.telephones = r10;
    }

    @NotNull
    public String toString() {
        return "ContactsCreateParams(name=" + this.name + ", telephones=" + Arrays.toString(this.telephones) + ", company=" + this.company + ", note=" + this.note + ", email=" + this.email + ", identifyCard=" + this.identifyCard + ", gender=" + this.gender + ", birthday=" + this.birthday + ", relationship=" + this.relationship + ", address=" + this.address + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        int r12 = 0;
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.name);
        Telephone[] r13 = this.telephones;
        if (r13 != null) goto L5;
        r10.writeInt(0);
    L8:
        r10.writeString(this.company);
        r10.writeString(this.note);
        r10.writeString(this.email);
        r10.writeString(this.identifyCard);
        r10.writeString(this.gender);
        r10.writeString(this.birthday);
        r10.writeString(this.relationship);
        r10.writeString(this.address);
        return;
    L5:
        r10.writeInt(1);
        int r14 = r13.length;
        r10.writeInt(r14);
    L6:
        if (r12 == r14) goto L8;
        r13[r12].writeToParcel(r10, r11);
        r12 = r12 + 1;
        goto L6
    }

    public ContactsCreateParams(@Nullable String r10, @Nullable Telephone[] r11, @Nullable String r12, @Nullable String r13, @Nullable String r14, @Nullable String r15, @Nullable String r16, @Nullable String r17, @Nullable String r18, @Nullable String r19) {
        this.name = r10;
        this.telephones = r11;
        this.company = r12;
        this.note = r13;
        this.email = r14;
        this.identifyCard = r15;
        this.gender = r16;
        this.birthday = r17;
        this.relationship = r18;
        this.address = r19;
    }

    public /* synthetic */ ContactsCreateParams(String r10, Telephone[] r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r110 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r110 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r110 & 8) == 0) goto L15;
        r13 = null;
    L15:
        if ((r110 & 16) == 0) goto L18;
        r14 = null;
    L18:
        if ((r110 & 32) == 0) goto L21;
        r15 = null;
    L21:
        if ((r110 & 64) == 0) goto L24;
        r16 = null;
    L24:
        if ((r110 & 128) == 0) goto L27;
        r17 = null;
    L27:
        if ((r110 & 256) == 0) goto L30;
        r18 = null;
    L30:
        if ((r110 & 512) == 0) goto L32;
        r19 = null;
    L32:
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }
}
