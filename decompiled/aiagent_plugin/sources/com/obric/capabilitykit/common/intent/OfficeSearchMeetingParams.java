package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: OfficeSearchMeetingParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OfficeSearchMeetingParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<OfficeSearchMeetingParams> CREATOR = null;
    private String agenda;
    private String endTime;
    private String[] participants;
    String[] participantsId;
    private String room;
    private String startTime;
    private String timeType;
    Integer version;

    /* JADX INFO: compiled from: OfficeSearchMeetingParams.kt */
    public static final class Creator implements Parcelable.Creator<OfficeSearchMeetingParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OfficeSearchMeetingParams createFromParcel(Parcel r14) {
            int r0 = r14.readInt();
            o.e(r14, "parcel");
            OfficeSearchMeetingParams r1 = new OfficeSearchMeetingParams(r14.readString(), r14.readString(), r14.readString(), r14.readString(), r14.createStringArray(), r14.readString(), null, null, 192, null);
            int r3 = Math.min(r0, 2);
            ClassLoader r13 = getClass().getClassLoader();
            int r5 = 1;
        L3:
            if (r5 > r3) goto L14;
            if (r5 != 1) goto L9;
            Object r7 = a.b(r14, r13);
            if (r7 == null) goto L13;
            r1.participantsId = (String[]) ZeusTransformUtils.preCheckCast(r7, String[].class, "com.obric.aiagent.plugin");
        L13:
            r5 = r5 + 1;
            goto L3
        L9:
            if (r5 != 2) goto L13;
            Object r8 = a.b(r14, r13);
            if (r8 == null) goto L13;
            r1.version = (Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.aiagent.plugin");
        L14:
            if (r5 > r0) goto L16;
            a.a(r14, r13);
            r5 = r5 + 1;
            goto L14
        L16:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeSearchMeetingParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OfficeSearchMeetingParams[] newArray(int r1) {
            return new OfficeSearchMeetingParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeSearchMeetingParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public OfficeSearchMeetingParams() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ OfficeSearchMeetingParams copy$default(OfficeSearchMeetingParams r9, String r10, String r11, String r12, String r13, String[] r14, String r15, String[] r16, Integer r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.startTime;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.endTime;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.timeType;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.room;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String[] r6 = r9.participants;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.agenda;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String[] r8 = r9.participantsId;
    L31:
        if ((r18 & 128) == 0) goto L33;
        Integer r1 = r9.version;
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

    public static /* synthetic */ void getParticipantsId$annotations() {
    }

    public static /* synthetic */ void getVersion$annotations() {
    }

    public final String component1() {
        return this.startTime;
    }

    public final String component2() {
        return this.endTime;
    }

    public final String component3() {
        return this.timeType;
    }

    public final String component4() {
        return this.room;
    }

    public final String[] component5() {
        return this.participants;
    }

    public final String component6() {
        return this.agenda;
    }

    public final String[] component7() {
        return this.participantsId;
    }

    public final Integer component8() {
        return this.version;
    }

    public final OfficeSearchMeetingParams copy(String r11, String r12, String r13, String r14, String[] r15, String r16, String[] r17, Integer r18) {
        return new OfficeSearchMeetingParams(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OfficeSearchMeetingParams.class) == true) goto L8;
        return false;
    L8:
        OfficeSearchMeetingParams r6 = (OfficeSearchMeetingParams) ZeusTransformUtils.preCheckCast(r5, OfficeSearchMeetingParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.startTime, r6.startTime) == true) goto L12;
        return false;
    L12:
        if (o.a(this.endTime, r6.endTime) == true) goto L15;
        return false;
    L15:
        if (o.a(this.timeType, r6.timeType) == true) goto L18;
        return false;
    L18:
        if (o.a(this.room, r6.room) == true) goto L21;
        return false;
    L21:
        if (o.a(this.participants, r6.participants) == true) goto L24;
        return false;
    L24:
        if (o.a(this.agenda, r6.agenda) == true) goto L27;
        return false;
    L27:
        if (o.a(this.participantsId, r6.participantsId) == true) goto L30;
        return false;
    L30:
        if (o.a(this.version, r6.version) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r0 = this.startTime;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.endTime;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.timeType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.room;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String[] r13 = this.participants;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.agenda;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String[] r19 = this.participantsId;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.version;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
    L29:
        r20 = Arrays.hashCode(r19);
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = Arrays.hashCode(r13);
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
        return "OfficeSearchMeetingParams(startTime=" + this.startTime + ", endTime=" + this.endTime + ", timeType=" + this.timeType + ", room=" + this.room + ", participants=" + Arrays.toString(this.participants) + ", agenda=" + this.agenda + ", participantsId=" + Arrays.toString(this.participantsId) + ", version=" + this.version + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(2);
        o.e(r1, "out");
        r1.writeString(this.startTime);
        r1.writeString(this.endTime);
        r1.writeString(this.timeType);
        r1.writeString(this.room);
        r1.writeStringArray(this.participants);
        r1.writeString(this.agenda);
        r1.writeValue(this.participantsId);
        r1.writeValue(this.version);
    }

    public OfficeSearchMeetingParams(String r1, String r2, String r3, String r4, String[] r5, String r6, String[] r7, Integer r8) {
        this.startTime = r1;
        this.endTime = r2;
        this.timeType = r3;
        this.room = r4;
        this.participants = r5;
        this.agenda = r6;
        this.participantsId = r7;
        this.version = r8;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ OfficeSearchMeetingParams(String r2, String r3, String r4, String r5, String[] r6, String r7, String[] r8, Integer r9, int r10, h r11) {
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

    public final String getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(String r1) {
        this.startTime = r1;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(String r1) {
        this.endTime = r1;
    }

    public final String getTimeType() {
        return this.timeType;
    }

    public final void setTimeType(String r1) {
        this.timeType = r1;
    }

    public final String getRoom() {
        return this.room;
    }

    public final void setRoom(String r1) {
        this.room = r1;
    }

    public final String[] getParticipants() {
        return this.participants;
    }

    public final void setParticipants(String[] r1) {
        this.participants = r1;
    }

    public final String getAgenda() {
        return this.agenda;
    }

    public final void setAgenda(String r1) {
        this.agenda = r1;
    }

    public final String[] getParticipantsId() {
        return this.participantsId;
    }

    public final void setParticipantsId(String[] r1) {
        this.participantsId = r1;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public final void setVersion(Integer r1) {
        this.version = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r13) {
        if (ZeusTransformUtils.instanceOf(r13, OfficeSearchMeetingParams.class) == false) goto L5;
        String r1 = this.startTime;
        if (r1 != null) goto L9;
        r1 = ((OfficeSearchMeetingParams) ZeusTransformUtils.preCheckCast(r13, OfficeSearchMeetingParams.class, "com.obric.aiagent.plugin")).startTime;
    L9:
        String r4 = r1;
        String r2 = this.endTime;
        if (r2 != null) goto L12;
        r2 = ((OfficeSearchMeetingParams) ZeusTransformUtils.preCheckCast(r13, OfficeSearchMeetingParams.class, "com.obric.aiagent.plugin")).endTime;
    L12:
        String r5 = r2;
        String r3 = this.timeType;
        if (r3 != null) goto L15;
        r3 = ((OfficeSearchMeetingParams) ZeusTransformUtils.preCheckCast(r13, OfficeSearchMeetingParams.class, "com.obric.aiagent.plugin")).timeType;
    L15:
        String r6 = r3;
        String r7 = this.room;
        if (r7 != null) goto L18;
        r7 = ((OfficeSearchMeetingParams) ZeusTransformUtils.preCheckCast(r13, OfficeSearchMeetingParams.class, "com.obric.aiagent.plugin")).room;
    L18:
        String r8 = r7;
        String[] r9 = this.participants;
        if (r9 != null) goto L21;
        r9 = ((OfficeSearchMeetingParams) ZeusTransformUtils.preCheckCast(r13, OfficeSearchMeetingParams.class, "com.obric.aiagent.plugin")).participants;
    L21:
        String[] r10 = r9;
        String r11 = this.agenda;
        if (r11 != null) goto L24;
        r11 = ((OfficeSearchMeetingParams) ZeusTransformUtils.preCheckCast(r13, OfficeSearchMeetingParams.class, "com.obric.aiagent.plugin")).agenda;
    L24:
        String r12 = r11;
        String[] r14 = this.participantsId;
        if (r14 != null) goto L27;
        r14 = ((OfficeSearchMeetingParams) ZeusTransformUtils.preCheckCast(r13, OfficeSearchMeetingParams.class, "com.obric.aiagent.plugin")).participantsId;
    L27:
        String[] r15 = r14;
        Integer r16 = this.version;
        if (r16 != null) goto L31;
        r16 = ((OfficeSearchMeetingParams) ZeusTransformUtils.preCheckCast(r13, OfficeSearchMeetingParams.class, "com.obric.aiagent.plugin")).version;
    L31:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new OfficeSearchMeetingParams(r4, r5, r6, r8, r10, r12, r15, r16), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
