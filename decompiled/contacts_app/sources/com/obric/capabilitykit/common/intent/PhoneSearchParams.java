package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.versionedparcelable.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PhoneSearchParams.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Bq\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010 Jz\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u00104J\t\u00105\u001a\u00020\u000eHÖ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\u000eHÖ\u0001J\u0012\u0010;\u001a\u00020\u00012\b\u0010<\u001a\u0004\u0018\u000109H\u0016J\t\u0010=\u001a\u00020\u0004HÖ\u0001J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u000eHÖ\u0001R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001e\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0013¨\u0006C"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhoneSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "query", "", "contactName", "telephone", "startTimestamp", "", "endTimestamp", "callType", "callConnectionType", Params.CONTENT, "maxCount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getCallConnectionType", "()Ljava/lang/String;", "setCallConnectionType", "(Ljava/lang/String;)V", "getCallType", "setCallType", "getContactName", "setContactName", "getContent", "setContent", "getEndTimestamp", "()Ljava/lang/Long;", "setEndTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMaxCount", "()Ljava/lang/Integer;", "setMaxCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getQuery", "setQuery", "getStartTimestamp", "setStartTimestamp", "getTelephone", "setTelephone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/PhoneSearchParams;", "describeContents", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhoneSearchParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<PhoneSearchParams> CREATOR = null;
    private String callConnectionType;
    private String callType;
    private String contactName;
    private String content;
    private Long endTimestamp;
    private Integer maxCount;
    private String query;
    private Long startTimestamp;
    private String telephone;

    /* JADX INFO: compiled from: PhoneSearchParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PhoneSearchParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhoneSearchParams createFromParcel(Parcel r14) {
            int r0 = r14.readInt();
            Intrinsics.checkNotNullParameter(r14, "parcel");
            String r3 = r14.readString();
            String r4 = r14.readString();
            String r5 = r14.readString();
            if (r14.readInt() != 0) goto L5;
            Long r7 = null;
        L7:
            if (r14.readInt() != 0) goto L9;
            Long r8 = null;
        L10:
            String r9 = r14.readString();
            String r10 = r14.readString();
            String r11 = r14.readString();
            if (r14.readInt() != 0) goto L13;
            Integer r12 = null;
        L14:
            PhoneSearchParams r1 = new PhoneSearchParams(r3, r4, r5, r7, r8, r9, r10, r11, r12);
            int r2 = Math.min(r0, 0);
            ClassLoader r13 = getClass().getClassLoader();
            int r6 = 1;
        L15:
            if (r6 > r2) goto L17;
            r6 = r6 + 1;
        L17:
            if (r6 > r0) goto L19;
            ParcelUtils.skipValueSafely(r14, r13);
            r6 = r6 + 1;
            goto L17
        L19:
            return r1;
        L13:
            r12 = Integer.valueOf(r14.readInt());
            goto L14
        L9:
            r8 = Long.valueOf(r14.readLong());
            goto L10
        L5:
            r7 = Long.valueOf(r14.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhoneSearchParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhoneSearchParams[] newArray(int r1) {
            return new PhoneSearchParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhoneSearchParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public PhoneSearchParams() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ PhoneSearchParams copy$default(PhoneSearchParams r10, String r11, String r12, String r13, Long r14, Long r15, String r16, String r17, String r18, Integer r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r2 = r10.query;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.contactName;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = r10.telephone;
    L15:
        if ((r20 & 8) == 0) goto L17;
        Long r5 = r10.startTimestamp;
    L19:
        if ((r20 & 16) == 0) goto L21;
        Long r6 = r10.endTimestamp;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = r10.callType;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = r10.callConnectionType;
    L31:
        if ((r20 & 128) == 0) goto L33;
        String r9 = r10.content;
    L35:
        if ((r20 & 256) == 0) goto L37;
        Integer r1 = r10.maxCount;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
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

    public final Long component4() {
        return this.startTimestamp;
    }

    public final Long component5() {
        return this.endTimestamp;
    }

    public final String component6() {
        return this.callType;
    }

    public final String component7() {
        return this.callConnectionType;
    }

    public final String component8() {
        return this.content;
    }

    public final Integer component9() {
        return this.maxCount;
    }

    public final PhoneSearchParams copy(String r12, String r13, String r14, Long r15, Long r16, String r17, String r18, String r19, Integer r20) {
        return new PhoneSearchParams(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PhoneSearchParams) == true) goto L8;
        return false;
    L8:
        PhoneSearchParams r6 = (PhoneSearchParams) r5;
        if (Intrinsics.areEqual(this.query, r6.query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.contactName, r6.contactName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.telephone, r6.telephone) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.startTimestamp, r6.startTimestamp) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.endTimestamp, r6.endTimestamp) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.callType, r6.callType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.callConnectionType, r6.callConnectionType) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.maxCount, r6.maxCount) == true) goto L35;
        return false;
    L35:
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
        Long r10 = this.startTimestamp;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.endTimestamp;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.callType;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.callConnectionType;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.content;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.maxCount;
        if (r25 == null) goto L39;
        r1 = r25.hashCode();
    L39:
        return r24 + r1;
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
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PhoneSearchParams(query=" + this.query + ", contactName=" + this.contactName + ", telephone=" + this.telephone + ", startTimestamp=" + this.startTimestamp + ", endTimestamp=" + this.endTimestamp + ", callType=" + this.callType + ", callConnectionType=" + this.callConnectionType + ", content=" + this.content + ", maxCount=" + this.maxCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        r5.writeInt(0);
        Intrinsics.checkNotNullParameter(r5, "out");
        r5.writeString(this.query);
        r5.writeString(this.contactName);
        r5.writeString(this.telephone);
        Long r0 = this.startTimestamp;
        if (r0 != null) goto L5;
        r5.writeInt(0);
    L6:
        Long r1 = this.endTimestamp;
        if (r1 != null) goto L9;
        r5.writeInt(0);
    L10:
        r5.writeString(this.callType);
        r5.writeString(this.callConnectionType);
        r5.writeString(this.content);
        Integer r4 = this.maxCount;
        if (r4 != null) goto L13;
        r5.writeInt(0);
        return;
    L13:
        r5.writeInt(1);
        r5.writeInt(r4.intValue());
        return;
    L9:
        r5.writeInt(1);
        r5.writeLong(r1.longValue());
        goto L10
    L5:
        r5.writeInt(1);
        r5.writeLong(r0.longValue());
        goto L6
    }

    public PhoneSearchParams(String r1, String r2, String r3, Long r4, Long r5, String r6, String r7, String r8, Integer r9) {
        this.query = r1;
        this.contactName = r2;
        this.telephone = r3;
        this.startTimestamp = r4;
        this.endTimestamp = r5;
        this.callType = r6;
        this.callConnectionType = r7;
        this.content = r8;
        this.maxCount = r9;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ PhoneSearchParams(String r2, String r3, String r4, Long r5, Long r6, String r7, String r8, String r9, Integer r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r11 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r11 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r11 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r11 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r11 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r11 & 256) == 0) goto L29;
        r10 = null;
    L29:
        this(r2, r3, r4, r5, r6, r7, r8, r9, r10);
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

    public final Long getStartTimestamp() {
        return this.startTimestamp;
    }

    public final void setStartTimestamp(Long r1) {
        this.startTimestamp = r1;
    }

    public final Long getEndTimestamp() {
        return this.endTimestamp;
    }

    public final void setEndTimestamp(Long r1) {
        this.endTimestamp = r1;
    }

    public final String getCallType() {
        return this.callType;
    }

    public final void setCallType(String r1) {
        this.callType = r1;
    }

    public final String getCallConnectionType() {
        return this.callConnectionType;
    }

    public final void setCallConnectionType(String r1) {
        this.callConnectionType = r1;
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
    public IntentParams mergeParams(Object r12) {
        if ((r12 instanceof PhoneSearchParams) == false) goto L5;
        String r0 = this.query;
        if (r0 != null) goto L9;
        r0 = ((PhoneSearchParams) r12).query;
    L9:
        String r2 = r0;
        String r1 = this.contactName;
        if (r1 != null) goto L12;
        r1 = ((PhoneSearchParams) r12).contactName;
    L12:
        String r3 = r1;
        String r4 = this.telephone;
        if (r4 != null) goto L15;
        r4 = ((PhoneSearchParams) r12).telephone;
    L15:
        String r5 = r4;
        Long r6 = this.startTimestamp;
        if (r6 != null) goto L18;
        r6 = ((PhoneSearchParams) r12).startTimestamp;
    L18:
        Long r7 = r6;
        Long r8 = this.endTimestamp;
        if (r8 != null) goto L21;
        r8 = ((PhoneSearchParams) r12).endTimestamp;
    L21:
        Long r9 = r8;
        String r10 = this.callType;
        if (r10 != null) goto L24;
        r10 = ((PhoneSearchParams) r12).callType;
    L24:
        String r11 = r10;
        String r13 = this.callConnectionType;
        if (r13 != null) goto L27;
        r13 = ((PhoneSearchParams) r12).callConnectionType;
    L27:
        String r14 = r13;
        String r15 = this.content;
        if (r15 != null) goto L30;
        r15 = ((PhoneSearchParams) r12).content;
    L30:
        String r16 = r15;
        Integer r17 = this.maxCount;
        if (r17 != null) goto L34;
        r17 = ((PhoneSearchParams) r12).maxCount;
    L34:
        return new PhoneSearchParams(r2, r3, r5, r7, r9, r11, r14, r16, r17);
    L5:
        return this;
    }
}
