package com.android.contacts.calllog.v2;

import android.net.Uri;
import com.android.contacts.DSUtils;
import com.android.vcard.VCardConfig;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallLogItem.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\bF\b\u0086\b\u0018\u00002\u00020\u0001Bó\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u001e\u001a\u00020\u001a\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\b\b\u0002\u0010 \u001a\u00020\u000b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\"J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u000bHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u000bHÆ\u0003J\u000f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u000bHÆ\u0003J\t\u0010I\u001a\u00020\u000bHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u001aHÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010O\u001a\u00020\u001aHÆ\u0003J\t\u0010P\u001a\u00020\u001aHÆ\u0003J\t\u0010Q\u001a\u00020\u001aHÆ\u0003J\t\u0010R\u001a\u00020\u000bHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010W\u001a\u00020\u000bHÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u000bHÆ\u0003J§\u0002\u0010[\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u001a2\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020\u001a2\b\b\u0002\u0010 \u001a\u00020\u000b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\\\u001a\u00020\u001a2\b\u0010]\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010^\u001a\u00020\u000bHÖ\u0001J\t\u0010_\u001a\u00020\u0005HÖ\u0001R\u0013\u0010!\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b+\u0010$R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0011\u0010 \u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010*R\u0011\u0010\u0012\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b2\u0010&R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010.R\u0011\u0010\u001f\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u00104R\u0011\u0010\u001d\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u00104R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010*R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010*R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010*R\u0011\u0010\u0016\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b9\u0010&R\u0011\u0010\u0017\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b:\u0010&R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010*R\u0011\u0010\u001e\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b<\u00104R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010*R\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b>\u0010&R\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b?\u0010&R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b@\u0010*¨\u0006`"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogItem;", "", "id", "", "number", "", "formattedNumber", "contactName", "contactPhotoUri", "Landroid/net/Uri;", "callType", "", "date", "duration", "simSlot", DSUtils.SUBSCRIPTION_KEY, "simId", "voicemailUri", "groupSize", "childIds", "", "numberLabel", "numberType", "presentation", "countryIso", "hasRecording", "", BatteryTypeInf.BATTERY_LOC_API, "recordUri", "isMarked", "showSimIcon", "isBlocked", "features", "cachedLookupUri", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;IJJIILjava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;IILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZZZILandroid/net/Uri;)V", "getCachedLookupUri", "()Landroid/net/Uri;", "getCallType", "()I", "getChildIds", "()Ljava/util/List;", "getContactName", "()Ljava/lang/String;", "getContactPhotoUri", "getCountryIso", "getDate", "()J", "getDuration", "getFeatures", "getFormattedNumber", "getGroupSize", "getHasRecording", "()Z", "getId", "getLocation", "getNumber", "getNumberLabel", "getNumberType", "getPresentation", "getRecordUri", "getShowSimIcon", "getSimId", "getSimSlot", "getSubscription", "getVoicemailUri", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallLogItem {
    private final Uri cachedLookupUri;
    private final int callType;
    private final List<Long> childIds;
    private final String contactName;
    private final Uri contactPhotoUri;
    private final String countryIso;
    private final long date;
    private final long duration;
    private final int features;
    private final String formattedNumber;
    private final int groupSize;
    private final boolean hasRecording;
    private final long id;
    private final boolean isBlocked;
    private final boolean isMarked;
    private final String location;
    private final String number;
    private final String numberLabel;
    private final int numberType;
    private final int presentation;
    private final String recordUri;
    private final boolean showSimIcon;
    private final String simId;
    private final int simSlot;
    private final int subscription;
    private final String voicemailUri;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallLogItem copy$default(CallLogItem r17, long r18, String r20, String r21, String r22, Uri r23, int r24, long r25, long r27, int r29, int r30, String r31, String r32, int r33, List r34, String r35, int r36, int r37, String r38, boolean r39, String r40, String r41, boolean r42, boolean r43, boolean r44, int r45, Uri r46, int r47, Object r48) {
        if ((r47 & 1) == 0) goto L5;
        long r2 = r17.id;
    L7:
        if ((r47 & 2) == 0) goto L9;
        String r4 = r17.number;
    L11:
        if ((r47 & 4) == 0) goto L13;
        String r5 = r17.formattedNumber;
    L15:
        if ((r47 & 8) == 0) goto L17;
        String r6 = r17.contactName;
    L19:
        if ((r47 & 16) == 0) goto L21;
        Uri r7 = r17.contactPhotoUri;
    L23:
        if ((r47 & 32) == 0) goto L25;
        int r8 = r17.callType;
    L27:
        if ((r47 & 64) == 0) goto L29;
        long r9 = r17.date;
    L31:
        if ((r47 & 128) == 0) goto L33;
        long r11 = r17.duration;
    L35:
        if ((r47 & 256) == 0) goto L37;
        int r13 = r17.simSlot;
    L39:
        if ((r47 & 512) == 0) goto L41;
        int r14 = r17.subscription;
    L43:
        if ((r47 & 1024) == 0) goto L45;
        String r15 = r17.simId;
    L46:
        String r310 = r15;
        if ((r47 & 2048) == 0) goto L49;
        String r16 = r17.voicemailUri;
    L50:
        String r311 = r16;
        if ((r47 & 4096) == 0) goto L53;
        int r19 = r17.groupSize;
    L54:
        int r312 = r19;
        if ((r47 & 8192) == 0) goto L57;
        List r110 = r17.childIds;
    L58:
        List r313 = r110;
        if ((r47 & 16384) == 0) goto L61;
        String r111 = r17.numberLabel;
    L62:
        String r314 = r111;
        if ((r47 & 32768) == 0) goto L65;
        int r112 = r17.numberType;
    L66:
        int r315 = r112;
        if ((r47 & 65536) == 0) goto L69;
        int r113 = r17.presentation;
    L70:
        int r316 = r113;
        if ((r47 & 131072) == 0) goto L73;
        String r114 = r17.countryIso;
    L74:
        String r317 = r114;
        if ((r47 & 262144) == 0) goto L77;
        boolean r115 = r17.hasRecording;
    L78:
        boolean r318 = r115;
        if ((r47 & 524288) == 0) goto L81;
        String r116 = r17.location;
    L82:
        String r49 = r116;
        if ((r47 & 1048576) == 0) goto L85;
        String r117 = r17.recordUri;
    L86:
        String r410 = r117;
        if ((r47 & 2097152) == 0) goto L89;
        boolean r118 = r17.isMarked;
    L90:
        boolean r411 = r118;
        if ((r47 & 4194304) == 0) goto L93;
        boolean r119 = r17.showSimIcon;
    L94:
        boolean r412 = r119;
        if ((r47 & 8388608) == 0) goto L97;
        boolean r120 = r17.isBlocked;
    L98:
        boolean r413 = r120;
        if ((r47 & 16777216) == 0) goto L101;
        int r121 = r17.features;
    L103:
        if ((r47 & VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING) == 0) goto L105;
        Uri r1 = r17.cachedLookupUri;
    L107:
        return r17.copy(r2, r4, r5, r6, r7, r8, r9, r11, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r49, r410, r411, r412, r413, r121, r1);
    L105:
        r1 = r46;
        goto L107
    L101:
        r121 = r45;
        goto L103
    L97:
        r120 = r44;
        goto L98
    L93:
        r119 = r43;
        goto L94
    L89:
        r118 = r42;
        goto L90
    L85:
        r117 = r41;
        goto L86
    L81:
        r116 = r40;
        goto L82
    L77:
        r115 = r39;
        goto L78
    L73:
        r114 = r38;
        goto L74
    L69:
        r113 = r37;
        goto L70
    L65:
        r112 = r36;
        goto L66
    L61:
        r111 = r35;
        goto L62
    L57:
        r110 = r34;
        goto L58
    L53:
        r19 = r33;
        goto L54
    L49:
        r16 = r32;
        goto L50
    L45:
        r15 = r31;
        goto L46
    L41:
        r14 = r30;
        goto L43
    L37:
        r13 = r29;
        goto L39
    L33:
        r11 = r27;
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

    public final int component10() {
        return this.subscription;
    }

    public final String component11() {
        return this.simId;
    }

    public final String component12() {
        return this.voicemailUri;
    }

    public final int component13() {
        return this.groupSize;
    }

    public final List<Long> component14() {
        return this.childIds;
    }

    public final String component15() {
        return this.numberLabel;
    }

    public final int component16() {
        return this.numberType;
    }

    public final int component17() {
        return this.presentation;
    }

    public final String component18() {
        return this.countryIso;
    }

    public final boolean component19() {
        return this.hasRecording;
    }

    public final String component2() {
        return this.number;
    }

    public final String component20() {
        return this.location;
    }

    public final String component21() {
        return this.recordUri;
    }

    public final boolean component22() {
        return this.isMarked;
    }

    public final boolean component23() {
        return this.showSimIcon;
    }

    public final boolean component24() {
        return this.isBlocked;
    }

    public final int component25() {
        return this.features;
    }

    public final Uri component26() {
        return this.cachedLookupUri;
    }

    public final String component3() {
        return this.formattedNumber;
    }

    public final String component4() {
        return this.contactName;
    }

    public final Uri component5() {
        return this.contactPhotoUri;
    }

    public final int component6() {
        return this.callType;
    }

    public final long component7() {
        return this.date;
    }

    public final long component8() {
        return this.duration;
    }

    public final int component9() {
        return this.simSlot;
    }

    public final CallLogItem copy(long r32, String r34, String r35, String r36, Uri r37, int r38, long r39, long r41, int r43, int r44, String r45, String r46, int r47, List<Long> r48, String r49, int r50, int r51, String r52, boolean r53, String r54, String r55, boolean r56, boolean r57, boolean r58, int r59, Uri r60) {
        Intrinsics.checkNotNullParameter(r34, "number");
        Intrinsics.checkNotNullParameter(r48, "childIds");
        return new CallLogItem(r32, r34, r35, r36, r37, r38, r39, r41, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof CallLogItem) == true) goto L8;
        return false;
    L8:
        CallLogItem r9 = (CallLogItem) r8;
        if (this.id == r9.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.number, r9.number) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.formattedNumber, r9.formattedNumber) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.contactName, r9.contactName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.contactPhotoUri, r9.contactPhotoUri) == true) goto L24;
        return false;
    L24:
        if (this.callType == r9.callType) goto L27;
        return false;
    L27:
        if (this.date == r9.date) goto L30;
        return false;
    L30:
        if (this.duration == r9.duration) goto L33;
        return false;
    L33:
        if (this.simSlot == r9.simSlot) goto L36;
        return false;
    L36:
        if (this.subscription == r9.subscription) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.simId, r9.simId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.voicemailUri, r9.voicemailUri) == true) goto L45;
        return false;
    L45:
        if (this.groupSize == r9.groupSize) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.childIds, r9.childIds) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.numberLabel, r9.numberLabel) == true) goto L54;
        return false;
    L54:
        if (this.numberType == r9.numberType) goto L57;
        return false;
    L57:
        if (this.presentation == r9.presentation) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.countryIso, r9.countryIso) == true) goto L63;
        return false;
    L63:
        if (this.hasRecording == r9.hasRecording) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.location, r9.location) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.recordUri, r9.recordUri) == true) goto L72;
        return false;
    L72:
        if (this.isMarked == r9.isMarked) goto L75;
        return false;
    L75:
        if (this.showSimIcon == r9.showSimIcon) goto L78;
        return false;
    L78:
        if (this.isBlocked == r9.isBlocked) goto L81;
        return false;
    L81:
        if (this.features == r9.features) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.cachedLookupUri, r9.cachedLookupUri) == true) goto L86;
        return false;
    L86:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v37, types: [int] */
    /* JADX WARN: Type inference failed for: r1v40, types: [int] */
    /* JADX WARN: Type inference failed for: r1v48, types: [int] */
    /* JADX WARN: Type inference failed for: r1v50, types: [int] */
    /* JADX WARN: Type inference failed for: r1v54 */
    /* JADX WARN: Type inference failed for: r1v55 */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r1v66 */
    /* JADX WARN: Type inference failed for: r1v67 */
    /* JADX WARN: Type inference failed for: r1v68 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        int r0 = ((Long.hashCode(this.id) * 31) + this.number.hashCode()) * 31;
        String r1 = this.formattedNumber;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.contactName;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Uri r8 = this.contactPhotoUri;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((((((((((r7 + r9) * 31) + Integer.hashCode(this.callType)) * 31) + Long.hashCode(this.date)) * 31) + Long.hashCode(this.duration)) * 31) + Integer.hashCode(this.simSlot)) * 31) + Integer.hashCode(this.subscription)) * 31;
        String r11 = this.simId;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.voicemailUri;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (((((r13 + r15) * 31) + Integer.hashCode(this.groupSize)) * 31) + this.childIds.hashCode()) * 31;
        String r17 = this.numberLabel;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (((((r16 + r18) * 31) + Integer.hashCode(this.numberType)) * 31) + Integer.hashCode(this.presentation)) * 31;
        String r20 = this.countryIso;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        boolean r23 = this.hasRecording;
        ?? r24 = 1;
        ?? r25 = r23;
        if (r23 == false) goto L33;
        r25 = 1;
    L33:
        int r26 = (r22 + r25) * 31;
        String r27 = this.location;
        if (r27 != null) goto L36;
        int r28 = 0;
    L37:
        int r29 = (r26 + r28) * 31;
        String r30 = this.recordUri;
        if (r30 != null) goto L40;
        int r31 = 0;
    L41:
        int r32 = (r29 + r31) * 31;
        boolean r33 = this.isMarked;
        ?? r34 = r33;
        if (r33 == false) goto L44;
        r34 = 1;
    L44:
        int r35 = (r32 + r34) * 31;
        boolean r36 = this.showSimIcon;
        ?? r37 = r36;
        if (r36 == false) goto L47;
        r37 = 1;
    L47:
        int r38 = (r35 + r37) * 31;
        boolean r39 = this.isBlocked;
        if (r39 == true) goto L51;
        r24 = r39;
    L51:
        int r40 = (((r38 + r24) * 31) + Integer.hashCode(this.features)) * 31;
        Uri r41 = this.cachedLookupUri;
        if (r41 == null) goto L56;
        r2 = r41.hashCode();
    L56:
        return r40 + r2;
    L40:
        r31 = r30.hashCode();
        goto L41
    L36:
        r28 = r27.hashCode();
        goto L37
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("CallLogItem(id=");
        r0.append(this.id).append(", number=").append(this.number).append(", formattedNumber=").append(this.formattedNumber).append(", contactName=").append(this.contactName).append(", contactPhotoUri=").append(this.contactPhotoUri).append(", callType=").append(this.callType).append(", date=").append(this.date).append(", duration=").append(this.duration).append(", simSlot=").append(this.simSlot).append(", subscription=").append(this.subscription).append(", simId=").append(this.simId).append(", voicemailUri=");
        r0.append(this.voicemailUri).append(", groupSize=").append(this.groupSize).append(", childIds=").append(this.childIds).append(", numberLabel=").append(this.numberLabel).append(", numberType=").append(this.numberType).append(", presentation=").append(this.presentation).append(", countryIso=").append(this.countryIso).append(", hasRecording=").append(this.hasRecording).append(", location=").append(this.location).append(", recordUri=").append(this.recordUri).append(", isMarked=").append(this.isMarked).append(", showSimIcon=").append(this.showSimIcon);
        r0.append(", isBlocked=").append(this.isBlocked).append(", features=").append(this.features).append(", cachedLookupUri=").append(this.cachedLookupUri).append(')');
        return r0.toString();
    }

    public CallLogItem(long r6, String r8, String r9, String r10, Uri r11, int r12, long r13, long r15, int r17, int r18, String r19, String r20, int r21, List<Long> r22, String r23, int r24, int r25, String r26, boolean r27, String r28, String r29, boolean r30, boolean r31, boolean r32, int r33, Uri r34) {
        Intrinsics.checkNotNullParameter(r8, "number");
        Intrinsics.checkNotNullParameter(r22, "childIds");
        this.id = r6;
        this.number = r8;
        this.formattedNumber = r9;
        this.contactName = r10;
        this.contactPhotoUri = r11;
        this.callType = r12;
        this.date = r13;
        this.duration = r15;
        this.simSlot = r17;
        this.subscription = r18;
        this.simId = r19;
        this.voicemailUri = r20;
        this.groupSize = r21;
        this.childIds = r22;
        this.numberLabel = r23;
        this.numberType = r24;
        this.presentation = r25;
        this.countryIso = r26;
        this.hasRecording = r27;
        this.location = r28;
        this.recordUri = r29;
        this.isMarked = r30;
        this.showSimIcon = r31;
        this.isBlocked = r32;
        this.features = r33;
        this.cachedLookupUri = r34;
    }

    public /* synthetic */ CallLogItem(long r32, String r34, String r35, String r36, Uri r37, int r38, long r39, long r41, int r43, int r44, String r45, String r46, int r47, List r48, String r49, int r50, int r51, String r52, boolean r53, String r54, String r55, boolean r56, boolean r57, boolean r58, int r59, Uri r60, int r61, DefaultConstructorMarker r62) {
        if ((r61 & 16777216) == 0) goto L5;
        int r29 = 0;
    L7:
        if ((r61 & VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING) == 0) goto L9;
        Uri r30 = null;
    L10:
        this(r32, r34, r35, r36, r37, r38, r39, r41, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r29, r30);
        return;
    L9:
        r30 = r60;
        goto L10
    L5:
        r29 = r59;
        goto L7
    }

    public final long getId() {
        return this.id;
    }

    public final String getNumber() {
        return this.number;
    }

    public final String getFormattedNumber() {
        return this.formattedNumber;
    }

    public final String getContactName() {
        return this.contactName;
    }

    public final Uri getContactPhotoUri() {
        return this.contactPhotoUri;
    }

    public final int getCallType() {
        return this.callType;
    }

    public final long getDate() {
        return this.date;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getSimSlot() {
        return this.simSlot;
    }

    public final int getSubscription() {
        return this.subscription;
    }

    public final String getSimId() {
        return this.simId;
    }

    public final String getVoicemailUri() {
        return this.voicemailUri;
    }

    public final int getGroupSize() {
        return this.groupSize;
    }

    public final List<Long> getChildIds() {
        return this.childIds;
    }

    public final String getNumberLabel() {
        return this.numberLabel;
    }

    public final int getNumberType() {
        return this.numberType;
    }

    public final int getPresentation() {
        return this.presentation;
    }

    public final String getCountryIso() {
        return this.countryIso;
    }

    public final boolean getHasRecording() {
        return this.hasRecording;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getRecordUri() {
        return this.recordUri;
    }

    public final boolean isMarked() {
        return this.isMarked;
    }

    public final boolean getShowSimIcon() {
        return this.showSimIcon;
    }

    public final boolean isBlocked() {
        return this.isBlocked;
    }

    public final int getFeatures() {
        return this.features;
    }

    public final Uri getCachedLookupUri() {
        return this.cachedLookupUri;
    }
}
