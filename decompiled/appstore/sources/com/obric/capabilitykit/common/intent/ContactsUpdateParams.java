package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.versionedparcelable.VersionedParcelable;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u008f\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0013J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0016\u00105\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u00106\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0098\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010=J\t\u0010>\u001a\u00020?HÖ\u0001J\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\u0010\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010C0EH\u0016J\t\u0010F\u001a\u00020?HÖ\u0001J\b\u0010G\u001a\u00020AH\u0016J\u0012\u0010H\u001a\u00020\u00012\b\u0010I\u001a\u0004\u0018\u00010CH\u0016J\t\u0010J\u001a\u00020\u0007HÖ\u0001J\u0019\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020?HÖ\u0001R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006P"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ContactsUpdateParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "target", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "name", "", "telephones", "", "Lcom/obric/capabilitykit/common/intent/Telephone;", "company", "note", "email", "identifyCard", "gender", "birthday", "relationship", "address", "(Lcom/obric/capabilitykit/entity/app/ContactEntity;Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Telephone;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getBirthday", "setBirthday", "getCompany", "setCompany", "getEmail", "setEmail", "getGender", "setGender", "getIdentifyCard", "setIdentifyCard", "getName", "setName", "getNote", "setNote", "getRelationship", "setRelationship", "getTarget", "()Lcom/obric/capabilitykit/entity/app/ContactEntity;", "setTarget", "(Lcom/obric/capabilitykit/entity/app/ContactEntity;)V", "getTelephones", "()[Lcom/obric/capabilitykit/common/intent/Telephone;", "setTelephones", "([Lcom/obric/capabilitykit/common/intent/Telephone;)V", "[Lcom/obric/capabilitykit/common/intent/Telephone;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/obric/capabilitykit/entity/app/ContactEntity;Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Telephone;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/ContactsUpdateParams;", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class ContactsUpdateParams implements IntentParams, Parcelable, IUriSharableParams {

    @NotNull
    public static final Parcelable.Creator<ContactsUpdateParams> CREATOR = null;

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
    private ContactEntity target;

    @Nullable
    private Telephone[] telephones;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ContactsUpdateParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactsUpdateParams createFromParcel(@NotNull Parcel r15) {
            int r14 = r15.readInt();
            q.g(r15, "parcel");
            ContactEntity r10 = (ContactEntity) r15.readParcelable(ContactsUpdateParams.class.getClassLoader());
            String r11 = r15.readString();
            if (r15.readInt() != 0) goto L5;
            Telephone[] r12 = null;
        L9:
            ContactsUpdateParams r13 = new ContactsUpdateParams(r10, r11, r12, r15.readString(), r15.readString(), r15.readString(), r15.readString(), r15.readString(), r15.readString(), r15.readString(), r15.readString());
            int r16 = Math.min(r14, 0);
            ClassLoader r17 = Creator.class.getClassLoader();
            int r18 = 1;
        L10:
            if (r18 > r16) goto L12;
            r18 = r18 + 1;
        L12:
            if (r18 > r14) goto L14;
            a.d(r15, r17);
            r18 = r18 + 1;
            goto L12
        L14:
            return r13;
        L5:
            int r19 = r15.readInt();
            Telephone[] r20 = new Telephone[r19];
            int r21 = 0;
        L6:
            if (r21 == r19) goto L8;
            r20[r21] = Telephone.CREATOR.createFromParcel(r15);
            r21 = r21 + 1;
            goto L6
        L8:
            r12 = r20;
            goto L9
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactsUpdateParams[] newArray(int r10) {
            return new ContactsUpdateParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsUpdateParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsUpdateParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public ContactsUpdateParams() {
        ContactEntity r10 = null;
        String r11 = null;
        Telephone[] r12 = null;
        String r13 = null;
        String r14 = null;
        String r15 = null;
        String r16 = null;
        String r17 = null;
        String r18 = null;
        String r19 = null;
        String r110 = null;
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, 2047, null);
    }

    public static /* synthetic */ ContactsUpdateParams copy$default(ContactsUpdateParams r12, ContactEntity r13, String r14, Telephone[] r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        ContactEntity r10 = r12.target;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r11 = r12.name;
    L11:
        if ((r24 & 4) == 0) goto L13;
        Telephone[] r26 = r12.telephones;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r27 = r12.company;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r28 = r12.note;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r29 = r12.email;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r30 = r12.identifyCard;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r31 = r12.gender;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r110 = r12.birthday;
    L39:
        if ((r24 & 512) == 0) goto L41;
        String r111 = r12.relationship;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        String r32 = r12.address;
    L47:
        return r12.copy(r10, r11, r26, r27, r28, r29, r30, r31, r110, r111, r32);
    L45:
        r32 = r23;
        goto L47
    L41:
        r111 = r22;
        goto L43
    L37:
        r110 = r21;
        goto L39
    L33:
        r31 = r20;
        goto L35
    L29:
        r30 = r19;
        goto L31
    L25:
        r29 = r18;
        goto L27
    L21:
        r28 = r17;
        goto L23
    L17:
        r27 = r16;
        goto L19
    L13:
        r26 = r15;
        goto L15
    L9:
        r11 = r14;
        goto L11
    L5:
        r10 = r13;
        goto L7
    }

    @Nullable
    public final ContactEntity component1() {
        return this.target;
    }

    @Nullable
    public final String component10() {
        return this.relationship;
    }

    @Nullable
    public final String component11() {
        return this.address;
    }

    @Nullable
    public final String component2() {
        return this.name;
    }

    @Nullable
    public final Telephone[] component3() {
        return this.telephones;
    }

    @Nullable
    public final String component4() {
        return this.company;
    }

    @Nullable
    public final String component5() {
        return this.note;
    }

    @Nullable
    public final String component6() {
        return this.email;
    }

    @Nullable
    public final String component7() {
        return this.identifyCard;
    }

    @Nullable
    public final String component8() {
        return this.gender;
    }

    @Nullable
    public final String component9() {
        return this.birthday;
    }

    @NotNull
    public final ContactsUpdateParams copy(@Nullable ContactEntity r14, @Nullable String r15, @Nullable Telephone[] r16, @Nullable String r17, @Nullable String r18, @Nullable String r19, @Nullable String r20, @Nullable String r21, @Nullable String r22, @Nullable String r23, @Nullable String r24) {
        return new ContactsUpdateParams(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ContactsUpdateParams) == true) goto L8;
        return false;
    L8:
        ContactsUpdateParams r11 = (ContactsUpdateParams) r10;
        if (q.b(this.target, r11.target) == true) goto L12;
        return false;
    L12:
        if (q.b(this.name, r11.name) == true) goto L15;
        return false;
    L15:
        if (q.b(this.telephones, r11.telephones) == true) goto L18;
        return false;
    L18:
        if (q.b(this.company, r11.company) == true) goto L21;
        return false;
    L21:
        if (q.b(this.note, r11.note) == true) goto L24;
        return false;
    L24:
        if (q.b(this.email, r11.email) == true) goto L27;
        return false;
    L27:
        if (q.b(this.identifyCard, r11.identifyCard) == true) goto L30;
        return false;
    L30:
        if (q.b(this.gender, r11.gender) == true) goto L33;
        return false;
    L33:
        if (q.b(this.birthday, r11.birthday) == true) goto L36;
        return false;
    L36:
        if (q.b(this.relationship, r11.relationship) == true) goto L39;
        return false;
    L39:
        if (q.b(this.address, r11.address) == true) goto L41;
        return false;
    L41:
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
    public final ContactEntity getTarget() {
        return this.target;
    }

    @Nullable
    public final Telephone[] getTelephones() {
        return this.telephones;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    @NotNull
    public List<Object> getUriSharableParams() {
        return s.e(this.target);
    }

    public int hashCode() {
        ContactEntity r10 = this.target;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.name;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        Telephone[] r17 = this.telephones;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.company;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String r23 = this.note;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 31;
        String r26 = this.email;
        if (r26 != null) goto L25;
        int r27 = 0;
    L26:
        int r28 = (r25 + r27) * 31;
        String r29 = this.identifyCard;
        if (r29 != null) goto L29;
        int r30 = 0;
    L30:
        int r31 = (r28 + r30) * 31;
        String r32 = this.gender;
        if (r32 != null) goto L33;
        int r33 = 0;
    L34:
        int r34 = (r31 + r33) * 31;
        String r35 = this.birthday;
        if (r35 != null) goto L37;
        int r36 = 0;
    L38:
        int r37 = (r34 + r36) * 31;
        String r38 = this.relationship;
        if (r38 != null) goto L41;
        int r39 = 0;
    L42:
        int r40 = (r37 + r39) * 31;
        String r41 = this.address;
        if (r41 == null) goto L47;
        r11 = r41.hashCode();
    L47:
        return r40 + r11;
    L41:
        r39 = r38.hashCode();
        goto L42
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
        r18 = Arrays.hashCode(r17);
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
        if (this.target == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r14) {
        if ((r14 instanceof ContactsUpdateParams) == true) goto L5;
        return this;
    L5:
        ContactEntity r10 = this.target;
        if (r10 != null) goto L8;
        r10 = ((ContactsUpdateParams) r14).target;
    L8:
        ContactEntity r11 = r10;
        String r12 = this.name;
        if (r12 != null) goto L11;
        r12 = ((ContactsUpdateParams) r14).name;
    L11:
        String r13 = r12;
        Telephone[] r15 = this.telephones;
        if (r15 != null) goto L14;
        r15 = ((ContactsUpdateParams) r14).telephones;
    L14:
        Telephone[] r16 = r15;
        String r17 = this.company;
        if (r17 != null) goto L17;
        r17 = ((ContactsUpdateParams) r14).company;
    L17:
        String r18 = r17;
        String r19 = this.note;
        if (r19 != null) goto L20;
        r19 = ((ContactsUpdateParams) r14).note;
    L20:
        String r20 = r19;
        String r21 = this.email;
        if (r21 != null) goto L23;
        r21 = ((ContactsUpdateParams) r14).email;
    L23:
        String r22 = r21;
        String r23 = this.identifyCard;
        if (r23 != null) goto L26;
        r23 = ((ContactsUpdateParams) r14).identifyCard;
    L26:
        String r24 = r23;
        String r25 = this.gender;
        if (r25 != null) goto L29;
        r25 = ((ContactsUpdateParams) r14).gender;
    L29:
        String r26 = r25;
        String r27 = this.birthday;
        if (r27 != null) goto L32;
        r27 = ((ContactsUpdateParams) r14).birthday;
    L32:
        String r110 = r27;
        String r28 = this.relationship;
        if (r28 != null) goto L35;
        r28 = ((ContactsUpdateParams) r14).relationship;
    L35:
        String r111 = r28;
        String r112 = this.address;
        if (r112 != null) goto L39;
        r112 = ((ContactsUpdateParams) r14).address;
    L39:
        return new ContactsUpdateParams(r11, r13, r16, r18, r20, r22, r24, r26, r110, r111, r112);
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

    public final void setTarget(@Nullable ContactEntity r10) {
        this.target = r10;
    }

    public final void setTelephones(@Nullable Telephone[] r10) {
        this.telephones = r10;
    }

    @NotNull
    public String toString() {
        return "ContactsUpdateParams(target=" + this.target + ", name=" + this.name + ", telephones=" + Arrays.toString(this.telephones) + ", company=" + this.company + ", note=" + this.note + ", email=" + this.email + ", identifyCard=" + this.identifyCard + ", gender=" + this.gender + ", birthday=" + this.birthday + ", relationship=" + this.relationship + ", address=" + this.address + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        int r12 = 0;
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeParcelable(this.target, r11);
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

    public ContactsUpdateParams(@Nullable ContactEntity r10, @Nullable String r11, @Nullable Telephone[] r12, @Nullable String r13, @Nullable String r14, @Nullable String r15, @Nullable String r16, @Nullable String r17, @Nullable String r18, @Nullable String r19, @Nullable String r110) {
        this.target = r10;
        this.name = r11;
        this.telephones = r12;
        this.company = r13;
        this.note = r14;
        this.email = r15;
        this.identifyCard = r16;
        this.gender = r17;
        this.birthday = r18;
        this.relationship = r19;
        this.address = r110;
    }

    public /* synthetic */ ContactsUpdateParams(ContactEntity r10, String r11, Telephone[] r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r111 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r111 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r111 & 8) == 0) goto L15;
        r13 = null;
    L15:
        if ((r111 & 16) == 0) goto L18;
        r14 = null;
    L18:
        if ((r111 & 32) == 0) goto L21;
        r15 = null;
    L21:
        if ((r111 & 64) == 0) goto L24;
        r16 = null;
    L24:
        if ((r111 & 128) == 0) goto L27;
        r17 = null;
    L27:
        if ((r111 & 256) == 0) goto L30;
        r18 = null;
    L30:
        if ((r111 & 512) == 0) goto L33;
        r19 = null;
    L33:
        if ((r111 & 1024) == 0) goto L35;
        r110 = null;
    L35:
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110);
    }
}
