package com.android.contacts.obricsync.contact;

import com.android.contacts.obricsync.SyncContractKt;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\bF\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BÉ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010T\u001a\u00020\u0018HÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\t\u0010V\u001a\u00020\u0005HÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\t\u0010X\u001a\u00020\u0005HÆ\u0003J\t\u0010Y\u001a\u00020\u0005HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010\\\u001a\u00020\u0005HÆ\u0003JÍ\u0001\u0010]\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u0018HÆ\u0001J\u0013\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010a\u001a\u00020\u0018H\u0016J\b\u0010b\u001a\u00020\u0005H\u0016R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010%\"\u0004\b.\u0010'R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001b\"\u0004\b8\u0010\u001dR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001b\"\u0004\b:\u0010\u001dR\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010%\"\u0004\b<\u0010'R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010%\"\u0004\b>\u0010'R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010%\"\u0004\b@\u0010'R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010%\"\u0004\bB\u0010'R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010%\"\u0004\bD\u0010'R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001b\"\u0004\bF\u0010\u001dR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001b\"\u0004\bH\u0010\u001dR\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010%\"\u0004\bJ\u0010'¨\u0006c"}, d2 = {"Lcom/android/contacts/obricsync/contact/ContactSync;", "", "id", "", "name", "", "firstName", "lastName", SyncContractKt.COLUMN_COMPANY, SyncContractKt.COLUMN_NOTE, "phoneNumber", "Lcom/android/contacts/obricsync/contact/ContactParamList;", "email", "nickname", "idCards", SyncContractKt.COLUMN_AVATAR, "", SyncContractKt.COLUMN_IM, SyncContractKt.COLUMN_WEBSITE, "birthdayData", SyncContractKt.COLUMN_ADDRESS, "intelAddress", SyncContractKt.COLUMN_RELATION, "genderCode", "", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/android/contacts/obricsync/contact/ContactParamList;Lcom/android/contacts/obricsync/contact/ContactParamList;Ljava/lang/String;Lcom/android/contacts/obricsync/contact/ContactParamList;[BLcom/android/contacts/obricsync/contact/ContactParamList;Ljava/lang/String;Lcom/android/contacts/obricsync/contact/ContactParamList;Lcom/android/contacts/obricsync/contact/ContactParamList;Ljava/lang/String;Lcom/android/contacts/obricsync/contact/ContactParamList;I)V", "getAddress", "()Lcom/android/contacts/obricsync/contact/ContactParamList;", "setAddress", "(Lcom/android/contacts/obricsync/contact/ContactParamList;)V", "getAvatar", "()[B", "setAvatar", "([B)V", "getBirthdayData", "setBirthdayData", "getCompany", "()Ljava/lang/String;", "setCompany", "(Ljava/lang/String;)V", "displayName", "getDisplayName", "setDisplayName", "getEmail", "setEmail", "getFirstName", "setFirstName", "getGenderCode", "()I", "setGenderCode", "(I)V", "getId", "()J", "setId", "(J)V", "getIdCards", "setIdCards", "getIm", "setIm", "getIntelAddress", "setIntelAddress", "getLastName", "setLastName", "getName", "setName", "getNickname", "setNickname", "getNote", "setNote", "getPhoneNumber", "setPhoneNumber", "getRelation", "setRelation", "getWebsite", "setWebsite", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactSync {
    private ContactParamList address;
    private byte[] avatar;
    private ContactParamList birthdayData;
    private String company;
    private String displayName;
    private ContactParamList email;
    private String firstName;
    private int genderCode;
    private long id;
    private ContactParamList idCards;
    private ContactParamList im;
    private String intelAddress;
    private String lastName;
    private String name;
    private String nickname;
    private String note;
    private ContactParamList phoneNumber;
    private ContactParamList relation;
    private String website;

    public ContactSync() {
        this(0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 262143, null);
    }

    public static /* synthetic */ ContactSync copy$default(ContactSync r17, long r18, String r20, String r21, String r22, String r23, String r24, ContactParamList r25, ContactParamList r26, String r27, ContactParamList r28, byte[] r29, ContactParamList r30, String r31, ContactParamList r32, ContactParamList r33, String r34, ContactParamList r35, int r36, int r37, Object r38) {
        if ((r37 & 1) == 0) goto L5;
        long r2 = r17.id;
    L7:
        if ((r37 & 2) == 0) goto L9;
        String r4 = r17.name;
    L11:
        if ((r37 & 4) == 0) goto L13;
        String r5 = r17.firstName;
    L15:
        if ((r37 & 8) == 0) goto L17;
        String r6 = r17.lastName;
    L19:
        if ((r37 & 16) == 0) goto L21;
        String r7 = r17.company;
    L23:
        if ((r37 & 32) == 0) goto L25;
        String r8 = r17.note;
    L27:
        if ((r37 & 64) == 0) goto L29;
        ContactParamList r9 = r17.phoneNumber;
    L31:
        if ((r37 & 128) == 0) goto L33;
        ContactParamList r10 = r17.email;
    L35:
        if ((r37 & 256) == 0) goto L37;
        String r11 = r17.nickname;
    L39:
        if ((r37 & 512) == 0) goto L41;
        ContactParamList r12 = r17.idCards;
    L43:
        if ((r37 & 1024) == 0) goto L45;
        byte[] r13 = r17.avatar;
    L47:
        if ((r37 & 2048) == 0) goto L49;
        ContactParamList r14 = r17.im;
    L51:
        if ((r37 & 4096) == 0) goto L53;
        String r15 = r17.website;
    L54:
        String r39 = r15;
        if ((r37 & 8192) == 0) goto L57;
        ContactParamList r16 = r17.birthdayData;
    L58:
        ContactParamList r310 = r16;
        if ((r37 & 16384) == 0) goto L61;
        ContactParamList r19 = r17.address;
    L62:
        ContactParamList r311 = r19;
        if ((r37 & 32768) == 0) goto L65;
        String r110 = r17.intelAddress;
    L66:
        String r312 = r110;
        if ((r37 & 65536) == 0) goto L69;
        ContactParamList r111 = r17.relation;
    L71:
        if ((r37 & 131072) == 0) goto L73;
        int r1 = r17.genderCode;
    L75:
        return r17.copy(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r39, r310, r311, r312, r111, r1);
    L73:
        r1 = r36;
        goto L75
    L69:
        r111 = r35;
        goto L71
    L65:
        r110 = r34;
        goto L66
    L61:
        r19 = r33;
        goto L62
    L57:
        r16 = r32;
        goto L58
    L53:
        r15 = r31;
        goto L54
    L49:
        r14 = r30;
        goto L51
    L45:
        r13 = r29;
        goto L47
    L41:
        r12 = r28;
        goto L43
    L37:
        r11 = r27;
        goto L39
    L33:
        r10 = r26;
        goto L35
    L29:
        r9 = r25;
        goto L31
    L25:
        r8 = r24;
        goto L27
    L21:
        r7 = r23;
        goto L23
    L17:
        r6 = r22;
        goto L19
    L13:
        r5 = r21;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final ContactParamList component10() {
        return this.idCards;
    }

    public final byte[] component11() {
        return this.avatar;
    }

    public final ContactParamList component12() {
        return this.im;
    }

    public final String component13() {
        return this.website;
    }

    public final ContactParamList component14() {
        return this.birthdayData;
    }

    public final ContactParamList component15() {
        return this.address;
    }

    public final String component16() {
        return this.intelAddress;
    }

    public final ContactParamList component17() {
        return this.relation;
    }

    public final int component18() {
        return this.genderCode;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.firstName;
    }

    public final String component4() {
        return this.lastName;
    }

    public final String component5() {
        return this.company;
    }

    public final String component6() {
        return this.note;
    }

    public final ContactParamList component7() {
        return this.phoneNumber;
    }

    public final ContactParamList component8() {
        return this.email;
    }

    public final String component9() {
        return this.nickname;
    }

    public final ContactSync copy(long r22, String r24, String r25, String r26, String r27, String r28, ContactParamList r29, ContactParamList r30, String r31, ContactParamList r32, byte[] r33, ContactParamList r34, String r35, ContactParamList r36, ContactParamList r37, String r38, ContactParamList r39, int r40) {
        Intrinsics.checkNotNullParameter(r24, "name");
        Intrinsics.checkNotNullParameter(r25, "firstName");
        Intrinsics.checkNotNullParameter(r26, "lastName");
        Intrinsics.checkNotNullParameter(r27, SyncContractKt.COLUMN_COMPANY);
        Intrinsics.checkNotNullParameter(r28, SyncContractKt.COLUMN_NOTE);
        Intrinsics.checkNotNullParameter(r31, "nickname");
        Intrinsics.checkNotNullParameter(r35, SyncContractKt.COLUMN_WEBSITE);
        Intrinsics.checkNotNullParameter(r38, "intelAddress");
        return new ContactSync(r22, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40);
    }

    public ContactSync(long r12, String r14, String r15, String r16, String r17, String r18, ContactParamList r19, ContactParamList r20, String r21, ContactParamList r22, byte[] r23, ContactParamList r24, String r25, ContactParamList r26, ContactParamList r27, String r28, ContactParamList r29, int r30) {
        Intrinsics.checkNotNullParameter(r14, "name");
        Intrinsics.checkNotNullParameter(r15, "firstName");
        Intrinsics.checkNotNullParameter(r16, "lastName");
        Intrinsics.checkNotNullParameter(r17, SyncContractKt.COLUMN_COMPANY);
        Intrinsics.checkNotNullParameter(r18, SyncContractKt.COLUMN_NOTE);
        Intrinsics.checkNotNullParameter(r21, "nickname");
        Intrinsics.checkNotNullParameter(r25, SyncContractKt.COLUMN_WEBSITE);
        Intrinsics.checkNotNullParameter(r28, "intelAddress");
        this.id = r12;
        this.name = r14;
        this.firstName = r15;
        this.lastName = r16;
        this.company = r17;
        this.note = r18;
        this.phoneNumber = r19;
        this.email = r20;
        this.nickname = r21;
        this.idCards = r22;
        this.avatar = r23;
        this.im = r24;
        this.website = r25;
        this.birthdayData = r26;
        this.address = r27;
        this.intelAddress = r28;
        this.relation = r29;
        this.genderCode = r30;
        String r1 = r14;
        if (r1.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        r1 = this.firstName + this.lastName;
    L8:
        this.displayName = r1;
        return;
    L5:
        r2 = false;
        goto L6
    }

    public /* synthetic */ ContactSync(long r20, String r22, String r23, String r24, String r25, String r26, ContactParamList r27, ContactParamList r28, String r29, ContactParamList r30, byte[] r31, ContactParamList r32, String r33, ContactParamList r34, ContactParamList r35, String r36, ContactParamList r37, int r38, int r39, DefaultConstructorMarker r40) {
        if ((r39 & 1) == 0) goto L5;
        long r1 = -1;
    L7:
        if ((r39 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r39 & 4) == 0) goto L13;
        String r5 = "";
    L15:
        if ((r39 & 8) == 0) goto L17;
        String r6 = "";
    L19:
        if ((r39 & 16) == 0) goto L21;
        String r7 = "";
    L23:
        if ((r39 & 32) == 0) goto L25;
        String r8 = "";
    L27:
        if ((r39 & 64) == 0) goto L29;
        ContactParamList r9 = null;
    L31:
        if ((r39 & 128) == 0) goto L33;
        ContactParamList r11 = null;
    L35:
        if ((r39 & 256) == 0) goto L37;
        String r12 = "";
    L39:
        if ((r39 & 512) == 0) goto L41;
        ContactParamList r13 = null;
    L43:
        if ((r39 & 1024) == 0) goto L45;
        byte[] r14 = null;
    L47:
        if ((r39 & 2048) == 0) goto L49;
        ContactParamList r15 = null;
    L51:
        if ((r39 & 4096) == 0) goto L53;
        String r10 = "";
    L55:
        if ((r39 & 8192) == 0) goto L57;
        ContactParamList r4 = null;
    L58:
        ContactParamList r310 = r4;
        if ((r39 & 16384) == 0) goto L61;
        ContactParamList r16 = null;
    L63:
        if ((r39 & 32768) == 0) goto L65;
        String r17 = "";
    L67:
        if ((r39 & 65536) == 0) goto L69;
        ContactParamList r18 = null;
    L71:
        if ((r39 & 131072) == 0) goto L73;
        int r0 = 0;
    L74:
        this(r1, r3, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r10, r310, r16, r17, r18, r0);
        return;
    L73:
        r0 = r38;
        goto L74
    L69:
        r18 = r37;
        goto L71
    L65:
        r17 = r36;
        goto L67
    L61:
        r16 = r35;
        goto L63
    L57:
        r4 = r34;
        goto L58
    L53:
        r10 = r33;
        goto L55
    L49:
        r15 = r32;
        goto L51
    L45:
        r14 = r31;
        goto L47
    L41:
        r13 = r30;
        goto L43
    L37:
        r12 = r29;
        goto L39
    L33:
        r11 = r28;
        goto L35
    L29:
        r9 = r27;
        goto L31
    L25:
        r8 = r26;
        goto L27
    L21:
        r7 = r25;
        goto L23
    L17:
        r6 = r24;
        goto L19
    L13:
        r5 = r23;
        goto L15
    L9:
        r3 = r22;
        goto L11
    L5:
        r1 = r20;
        goto L7
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long r1) {
        this.id = r1;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.name = r2;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final void setFirstName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.firstName = r2;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final void setLastName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.lastName = r2;
    }

    public final String getCompany() {
        return this.company;
    }

    public final void setCompany(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.company = r2;
    }

    public final String getNote() {
        return this.note;
    }

    public final void setNote(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.note = r2;
    }

    public final ContactParamList getPhoneNumber() {
        return this.phoneNumber;
    }

    public final void setPhoneNumber(ContactParamList r1) {
        this.phoneNumber = r1;
    }

    public final ContactParamList getEmail() {
        return this.email;
    }

    public final void setEmail(ContactParamList r1) {
        this.email = r1;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final void setNickname(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.nickname = r2;
    }

    public final ContactParamList getIdCards() {
        return this.idCards;
    }

    public final void setIdCards(ContactParamList r1) {
        this.idCards = r1;
    }

    public final byte[] getAvatar() {
        return this.avatar;
    }

    public final void setAvatar(byte[] r1) {
        this.avatar = r1;
    }

    public final ContactParamList getIm() {
        return this.im;
    }

    public final void setIm(ContactParamList r1) {
        this.im = r1;
    }

    public final String getWebsite() {
        return this.website;
    }

    public final void setWebsite(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.website = r2;
    }

    public final ContactParamList getBirthdayData() {
        return this.birthdayData;
    }

    public final void setBirthdayData(ContactParamList r1) {
        this.birthdayData = r1;
    }

    public final ContactParamList getAddress() {
        return this.address;
    }

    public final void setAddress(ContactParamList r1) {
        this.address = r1;
    }

    public final String getIntelAddress() {
        return this.intelAddress;
    }

    public final void setIntelAddress(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.intelAddress = r2;
    }

    public final ContactParamList getRelation() {
        return this.relation;
    }

    public final void setRelation(ContactParamList r1) {
        this.relation = r1;
    }

    public final int getGenderCode() {
        return this.genderCode;
    }

    public final void setGenderCode(int r1) {
        this.genderCode = r1;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final void setDisplayName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.displayName = r2;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L5;
        return true;
    L5:
        Class<?> r1 = getClass();
        if (r8 == null) goto L8;
        Class<?> r2 = r8.getClass();
    L10:
        if (Intrinsics.areEqual(r1, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.android.contacts.obricsync.contact.ContactSync");
        ContactSync r9 = (ContactSync) r8;
        if (this.id == r9.id) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.name, r9.name) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.firstName, r9.firstName) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.lastName, r9.lastName) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.company, r9.company) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.note, r9.note) == true) goto L31;
        return false;
    L31:
        if (Intrinsics.areEqual(this.phoneNumber, r9.phoneNumber) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.email, r9.email) == true) goto L37;
        return false;
    L37:
        if (Intrinsics.areEqual(this.nickname, r9.nickname) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.idCards, r9.idCards) == true) goto L42;
        return false;
    L42:
        byte[] r3 = this.avatar;
        if (r3 == null) goto L51;
        byte[] r4 = r9.avatar;
        if (r4 != null) goto L48;
        return false;
    L48:
        if (Arrays.equals(r3, r4) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.im, r9.im) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.website, r9.website) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.birthdayData, r9.birthdayData) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.address, r9.address) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.intelAddress, r9.intelAddress) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.relation, r9.relation) == true) goto L72;
        return false;
    L72:
        if (this.genderCode == r9.genderCode) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.displayName, r9.displayName) == true) goto L77;
        return false;
    L77:
        return true;
    L51:
        if (r9.avatar == null) goto L54;
        return false;
    L8:
        r2 = null;
        goto L10
    }

    public int hashCode() {
        int r0 = ((((((((((Long.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + this.firstName.hashCode()) * 31) + this.lastName.hashCode()) * 31) + this.company.hashCode()) * 31) + this.note.hashCode()) * 31;
        ContactParamList r1 = this.phoneNumber;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        ContactParamList r5 = this.email;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (((r4 + r6) * 31) + this.nickname.hashCode()) * 31;
        ContactParamList r8 = this.idCards;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        byte[] r11 = this.avatar;
        if (r11 == null) goto L17;
        int r12 = Arrays.hashCode(r11);
    L18:
        int r13 = (r10 + r12) * 31;
        ContactParamList r14 = this.im;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (((r13 + r15) * 31) + this.website.hashCode()) * 31;
        ContactParamList r17 = this.birthdayData;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        ContactParamList r20 = this.address;
        if (r20 == null) goto L29;
        int r21 = r20.hashCode();
    L30:
        int r22 = (((r19 + r21) * 31) + this.intelAddress.hashCode()) * 31;
        ContactParamList r23 = this.relation;
        if (r23 == null) goto L34;
        r2 = r23.hashCode();
    L34:
        return ((((r22 + r2) * 31) + this.genderCode) * 31) + this.displayName.hashCode();
    L29:
        r21 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("ContactSync(id=");
        StringBuilder r1 = r0.append(this.id).append(", name='").append(this.name.length()).append("', firstName='").append(this.firstName.length()).append("', lastName='").append(this.lastName.length()).append("', company='").append(this.company.length()).append("', note='").append(this.note.length()).append("', phoneNumber=");
        ContactParamList r2 = this.phoneNumber;
        Integer r3 = null;
        if (r2 == null) goto L7;
        List<ContactType> r4 = r2.getList();
        if (r4 == null) goto L7;
        Integer r5 = Integer.valueOf(r4.size());
    L8:
        StringBuilder r6 = r1.append(r5).append(", email=");
        ContactParamList r7 = this.email;
        if (r7 == null) goto L13;
        List<ContactType> r8 = r7.getList();
        if (r8 == null) goto L13;
        Integer r9 = Integer.valueOf(r8.size());
    L14:
        StringBuilder r10 = r6.append(r9).append(", nickname='").append(this.nickname.length()).append("', idCards=");
        ContactParamList r11 = this.idCards;
        if (r11 == null) goto L19;
        List<ContactType> r12 = r11.getList();
        if (r12 == null) goto L19;
        Integer r13 = Integer.valueOf(r12.size());
    L20:
        StringBuilder r14 = r10.append(r13).append(", avatar=");
        byte[] r15 = this.avatar;
        if (r15 == null) goto L23;
        Integer r16 = Integer.valueOf(Arrays.hashCode(r15));
    L24:
        r14.append(r16).append(", im=");
        ContactParamList r17 = this.im;
        if (r17 == null) goto L29;
        List<ContactType> r18 = r17.getList();
        if (r18 == null) goto L29;
        Integer r19 = Integer.valueOf(r18.size());
    L30:
        StringBuilder r20 = r0.append(r19).append(", website='").append(this.website.length()).append("', birthdayData=");
        ContactParamList r21 = this.birthdayData;
        if (r21 == null) goto L35;
        List<ContactType> r22 = r21.getList();
        if (r22 == null) goto L35;
        Integer r23 = Integer.valueOf(r22.size());
    L36:
        StringBuilder r24 = r20.append(r23).append(", address=");
        ContactParamList r25 = this.address;
        if (r25 == null) goto L41;
        List<ContactType> r26 = r25.getList();
        if (r26 == null) goto L41;
        Integer r27 = Integer.valueOf(r26.size());
    L42:
        StringBuilder r28 = r24.append(r27).append(", intelAddress='").append(this.intelAddress.length()).append("', relation=");
        ContactParamList r29 = this.relation;
        if (r29 == null) goto L47;
        List<ContactType> r30 = r29.getList();
        if (r30 == null) goto L47;
        r3 = Integer.valueOf(r30.size());
    L47:
        r28.append(r3).append(", genderCode=").append(this.genderCode).append(", displayName='").append(this.displayName.length()).append("')");
        return r0.toString();
    L41:
        r27 = null;
    L35:
        r23 = null;
    L29:
        r19 = null;
        goto L30
    L23:
        r16 = null;
    L19:
        r13 = null;
    L13:
        r9 = null;
    L7:
        r5 = null;
        goto L8
    }
}
