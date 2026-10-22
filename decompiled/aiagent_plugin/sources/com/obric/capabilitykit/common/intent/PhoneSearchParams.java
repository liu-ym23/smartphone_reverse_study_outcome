package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: PhoneSearchParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PhoneSearchParams implements Parcelable, IntentParams {
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
    public static final class Creator implements Parcelable.Creator<PhoneSearchParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhoneSearchParams createFromParcel(Parcel r14) {
            int r0 = r14.readInt();
            o.e(r14, "parcel");
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
            a.a(r14, r13);
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
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
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
        if (ZeusTransformUtils.instanceOf(r5, PhoneSearchParams.class) == true) goto L8;
        return false;
    L8:
        PhoneSearchParams r6 = (PhoneSearchParams) ZeusTransformUtils.preCheckCast(r5, PhoneSearchParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.query, r6.query) == true) goto L12;
        return false;
    L12:
        if (o.a(this.contactName, r6.contactName) == true) goto L15;
        return false;
    L15:
        if (o.a(this.telephone, r6.telephone) == true) goto L18;
        return false;
    L18:
        if (o.a(this.startTimestamp, r6.startTimestamp) == true) goto L21;
        return false;
    L21:
        if (o.a(this.endTimestamp, r6.endTimestamp) == true) goto L24;
        return false;
    L24:
        if (o.a(this.callType, r6.callType) == true) goto L27;
        return false;
    L27:
        if (o.a(this.callConnectionType, r6.callConnectionType) == true) goto L30;
        return false;
    L30:
        if (o.a(this.content, r6.content) == true) goto L33;
        return false;
    L33:
        if (o.a(this.maxCount, r6.maxCount) == true) goto L35;
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
        o.e(r5, "out");
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
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ PhoneSearchParams(String r2, String r3, String r4, Long r5, Long r6, String r7, String r8, String r9, Integer r10, int r11, h r12) {
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
    public IntentParams mergeParams(Object r14) {
        if (ZeusTransformUtils.instanceOf(r14, PhoneSearchParams.class) == false) goto L5;
        String r1 = this.query;
        if (r1 != null) goto L9;
        r1 = ((PhoneSearchParams) ZeusTransformUtils.preCheckCast(r14, PhoneSearchParams.class, "com.obric.aiagent.plugin")).query;
    L9:
        String r4 = r1;
        String r2 = this.contactName;
        if (r2 != null) goto L12;
        r2 = ((PhoneSearchParams) ZeusTransformUtils.preCheckCast(r14, PhoneSearchParams.class, "com.obric.aiagent.plugin")).contactName;
    L12:
        String r5 = r2;
        String r3 = this.telephone;
        if (r3 != null) goto L15;
        r3 = ((PhoneSearchParams) ZeusTransformUtils.preCheckCast(r14, PhoneSearchParams.class, "com.obric.aiagent.plugin")).telephone;
    L15:
        String r6 = r3;
        Long r7 = this.startTimestamp;
        if (r7 != null) goto L18;
        r7 = ((PhoneSearchParams) ZeusTransformUtils.preCheckCast(r14, PhoneSearchParams.class, "com.obric.aiagent.plugin")).startTimestamp;
    L18:
        Long r8 = r7;
        Long r9 = this.endTimestamp;
        if (r9 != null) goto L21;
        r9 = ((PhoneSearchParams) ZeusTransformUtils.preCheckCast(r14, PhoneSearchParams.class, "com.obric.aiagent.plugin")).endTimestamp;
    L21:
        Long r10 = r9;
        String r11 = this.callType;
        if (r11 != null) goto L24;
        r11 = ((PhoneSearchParams) ZeusTransformUtils.preCheckCast(r14, PhoneSearchParams.class, "com.obric.aiagent.plugin")).callType;
    L24:
        String r12 = r11;
        String r13 = this.callConnectionType;
        if (r13 != null) goto L27;
        r13 = ((PhoneSearchParams) ZeusTransformUtils.preCheckCast(r14, PhoneSearchParams.class, "com.obric.aiagent.plugin")).callConnectionType;
    L27:
        String r15 = r13;
        String r16 = this.content;
        if (r16 != null) goto L30;
        r16 = ((PhoneSearchParams) ZeusTransformUtils.preCheckCast(r14, PhoneSearchParams.class, "com.obric.aiagent.plugin")).content;
    L30:
        String r17 = r16;
        Integer r18 = this.maxCount;
        if (r18 != null) goto L34;
        r18 = ((PhoneSearchParams) ZeusTransformUtils.preCheckCast(r14, PhoneSearchParams.class, "com.obric.aiagent.plugin")).maxCount;
    L34:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new PhoneSearchParams(r4, r5, r6, r8, r10, r12, r15, r17, r18), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
