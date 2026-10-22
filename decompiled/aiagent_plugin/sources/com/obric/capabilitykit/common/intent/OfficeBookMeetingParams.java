package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: OfficeBookMeetingParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OfficeBookMeetingParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<OfficeBookMeetingParams> CREATOR = null;
    private String agenda;
    private String endTime;
    private String[] participants;
    String[] participantsId;
    private String room;
    private String startTime;
    Integer version;

    /* JADX INFO: compiled from: OfficeBookMeetingParams.kt */
    public static final class Creator implements Parcelable.Creator<OfficeBookMeetingParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OfficeBookMeetingParams createFromParcel(Parcel r13) {
            int r0 = r13.readInt();
            o.e(r13, "parcel");
            OfficeBookMeetingParams r1 = new OfficeBookMeetingParams(r13.readString(), r13.readString(), r13.readString(), r13.createStringArray(), r13.readString(), null, null, 96, null);
            int r3 = Math.min(r0, 2);
            ClassLoader r12 = getClass().getClassLoader();
            int r5 = 1;
        L3:
            if (r5 > r3) goto L14;
            if (r5 != 1) goto L9;
            Object r7 = a.b(r13, r12);
            if (r7 == null) goto L13;
            r1.participantsId = (String[]) ZeusTransformUtils.preCheckCast(r7, String[].class, "com.obric.aiagent.plugin");
        L13:
            r5 = r5 + 1;
            goto L3
        L9:
            if (r5 != 2) goto L13;
            Object r8 = a.b(r13, r12);
            if (r8 == null) goto L13;
            r1.version = (Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.aiagent.plugin");
        L14:
            if (r5 > r0) goto L16;
            a.a(r13, r12);
            r5 = r5 + 1;
            goto L14
        L16:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeBookMeetingParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OfficeBookMeetingParams[] newArray(int r1) {
            return new OfficeBookMeetingParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeBookMeetingParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public OfficeBookMeetingParams() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ OfficeBookMeetingParams copy$default(OfficeBookMeetingParams r5, String r6, String r7, String r8, String[] r9, String r10, String[] r11, Integer r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.startTime;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.endTime;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.room;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.participants;
    L14:
        String[] r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.agenda;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.participantsId;
    L20:
        String[] r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.version;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
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
        return this.room;
    }

    public final String[] component4() {
        return this.participants;
    }

    public final String component5() {
        return this.agenda;
    }

    public final String[] component6() {
        return this.participantsId;
    }

    public final Integer component7() {
        return this.version;
    }

    public final OfficeBookMeetingParams copy(String r9, String r10, String r11, String[] r12, String r13, String[] r14, Integer r15) {
        return new OfficeBookMeetingParams(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OfficeBookMeetingParams.class) == true) goto L8;
        return false;
    L8:
        OfficeBookMeetingParams r6 = (OfficeBookMeetingParams) ZeusTransformUtils.preCheckCast(r5, OfficeBookMeetingParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.startTime, r6.startTime) == true) goto L12;
        return false;
    L12:
        if (o.a(this.endTime, r6.endTime) == true) goto L15;
        return false;
    L15:
        if (o.a(this.room, r6.room) == true) goto L18;
        return false;
    L18:
        if (o.a(this.participants, r6.participants) == true) goto L21;
        return false;
    L21:
        if (o.a(this.agenda, r6.agenda) == true) goto L24;
        return false;
    L24:
        if (o.a(this.participantsId, r6.participantsId) == true) goto L27;
        return false;
    L27:
        if (o.a(this.version, r6.version) == true) goto L29;
        return false;
    L29:
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
        String r7 = this.room;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String[] r10 = this.participants;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.agenda;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String[] r16 = this.participantsId;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.version;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
    L25:
        r17 = Arrays.hashCode(r16);
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = Arrays.hashCode(r10);
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
        return "OfficeBookMeetingParams(startTime=" + this.startTime + ", endTime=" + this.endTime + ", room=" + this.room + ", participants=" + Arrays.toString(this.participants) + ", agenda=" + this.agenda + ", participantsId=" + Arrays.toString(this.participantsId) + ", version=" + this.version + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(2);
        o.e(r1, "out");
        r1.writeString(this.startTime);
        r1.writeString(this.endTime);
        r1.writeString(this.room);
        r1.writeStringArray(this.participants);
        r1.writeString(this.agenda);
        r1.writeValue(this.participantsId);
        r1.writeValue(this.version);
    }

    public OfficeBookMeetingParams(String r1, String r2, String r3, String[] r4, String r5, String[] r6, Integer r7) {
        this.startTime = r1;
        this.endTime = r2;
        this.room = r3;
        this.participants = r4;
        this.agenda = r5;
        this.participantsId = r6;
        this.version = r7;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ OfficeBookMeetingParams(String r2, String r3, String r4, String[] r5, String r6, String[] r7, Integer r8, int r9, h r10) {
        if ((r9 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r9 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r9 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r9 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r9 & 64) == 0) goto L23;
        r8 = null;
    L23:
        this(r2, r3, r4, r5, r6, r7, r8);
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
    public IntentParams mergeParams(Object r12) {
        if (ZeusTransformUtils.instanceOf(r12, OfficeBookMeetingParams.class) == false) goto L5;
        String r1 = this.startTime;
        if (r1 != null) goto L9;
        r1 = ((OfficeBookMeetingParams) ZeusTransformUtils.preCheckCast(r12, OfficeBookMeetingParams.class, "com.obric.aiagent.plugin")).startTime;
    L9:
        String r4 = r1;
        String r2 = this.endTime;
        if (r2 != null) goto L12;
        r2 = ((OfficeBookMeetingParams) ZeusTransformUtils.preCheckCast(r12, OfficeBookMeetingParams.class, "com.obric.aiagent.plugin")).endTime;
    L12:
        String r5 = r2;
        String r3 = this.room;
        if (r3 != null) goto L15;
        r3 = ((OfficeBookMeetingParams) ZeusTransformUtils.preCheckCast(r12, OfficeBookMeetingParams.class, "com.obric.aiagent.plugin")).room;
    L15:
        String r6 = r3;
        String[] r7 = this.participants;
        if (r7 != null) goto L18;
        r7 = ((OfficeBookMeetingParams) ZeusTransformUtils.preCheckCast(r12, OfficeBookMeetingParams.class, "com.obric.aiagent.plugin")).participants;
    L18:
        String[] r8 = r7;
        String r9 = this.agenda;
        if (r9 != null) goto L21;
        r9 = ((OfficeBookMeetingParams) ZeusTransformUtils.preCheckCast(r12, OfficeBookMeetingParams.class, "com.obric.aiagent.plugin")).agenda;
    L21:
        String r10 = r9;
        String[] r11 = this.participantsId;
        if (r11 != null) goto L24;
        r11 = ((OfficeBookMeetingParams) ZeusTransformUtils.preCheckCast(r12, OfficeBookMeetingParams.class, "com.obric.aiagent.plugin")).participantsId;
    L24:
        String[] r13 = r11;
        Integer r14 = this.version;
        if (r14 != null) goto L28;
        r14 = ((OfficeBookMeetingParams) ZeusTransformUtils.preCheckCast(r12, OfficeBookMeetingParams.class, "com.obric.aiagent.plugin")).version;
    L28:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new OfficeBookMeetingParams(r4, r5, r6, r8, r10, r13, r14), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
