package com.obric.database.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecordASRMessageEntity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0084\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0007HÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u000e\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001e\u0010\u0017R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014¨\u00064"}, d2 = {"Lcom/obric/database/entity/RecordASRMessageEntity;", "", "callCreateTime", "", "asrText", "", "owner", "", "phoneNumber", "partId", "partStartTime", "partDuration", "startTime", "duration", "isConference", "id", "(JLjava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;JJLjava/lang/Integer;J)V", "getAsrText", "()Ljava/lang/String;", "getCallCreateTime", "()J", "getDuration", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOwner", "()I", "getPartDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPartId", "getPartStartTime", "getPhoneNumber", "getStartTime", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;JJLjava/lang/Integer;J)Lcom/obric/database/entity/RecordASRMessageEntity;", "equals", "", "other", "hashCode", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RecordASRMessageEntity {
    private final String asrText;
    private final long callCreateTime;
    private final long duration;
    private final long id;
    private final Integer isConference;
    private final int owner;
    private final Long partDuration;
    private final Integer partId;
    private final Long partStartTime;
    private final String phoneNumber;
    private final long startTime;

    public static /* synthetic */ RecordASRMessageEntity copy$default(RecordASRMessageEntity r16, long r17, String r19, int r20, String r21, Integer r22, Long r23, Long r24, long r25, long r27, Integer r29, long r30, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        long r2 = r16.callCreateTime;
    L7:
        if ((r32 & 2) == 0) goto L9;
        String r4 = r16.asrText;
    L11:
        if ((r32 & 4) == 0) goto L13;
        int r5 = r16.owner;
    L15:
        if ((r32 & 8) == 0) goto L17;
        String r6 = r16.phoneNumber;
    L19:
        if ((r32 & 16) == 0) goto L21;
        Integer r7 = r16.partId;
    L23:
        if ((r32 & 32) == 0) goto L25;
        Long r8 = r16.partStartTime;
    L27:
        if ((r32 & 64) == 0) goto L29;
        Long r9 = r16.partDuration;
    L31:
        if ((r32 & 128) == 0) goto L33;
        long r10 = r16.startTime;
    L35:
        if ((r32 & 256) == 0) goto L37;
        long r12 = r16.duration;
    L39:
        if ((r32 & 512) == 0) goto L41;
        Integer r14 = r16.isConference;
    L42:
        Integer r210 = r14;
        if ((r32 & 1024) == 0) goto L45;
        long r15 = r16.id;
    L47:
        return r16.copy(r2, r4, r5, r6, r7, r8, r9, r10, r12, r210, r15);
    L45:
        r15 = r30;
        goto L47
    L41:
        r14 = r29;
        goto L42
    L37:
        r12 = r27;
        goto L39
    L33:
        r10 = r25;
        goto L35
    L29:
        r9 = r24;
        goto L31
    L25:
        r8 = r23;
        goto L27
    L21:
        r7 = r22;
        goto L23
    L17:
        r6 = r21;
        goto L19
    L13:
        r5 = r20;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final long component1() {
        return this.callCreateTime;
    }

    public final Integer component10() {
        return this.isConference;
    }

    public final long component11() {
        return this.id;
    }

    public final String component2() {
        return this.asrText;
    }

    public final int component3() {
        return this.owner;
    }

    public final String component4() {
        return this.phoneNumber;
    }

    public final Integer component5() {
        return this.partId;
    }

    public final Long component6() {
        return this.partStartTime;
    }

    public final Long component7() {
        return this.partDuration;
    }

    public final long component8() {
        return this.startTime;
    }

    public final long component9() {
        return this.duration;
    }

    public final RecordASRMessageEntity copy(long r18, String r20, int r21, String r22, Integer r23, Long r24, Long r25, long r26, long r28, Integer r30, long r31) {
        Intrinsics.checkNotNullParameter(r20, "asrText");
        Intrinsics.checkNotNullParameter(r22, "phoneNumber");
        return new RecordASRMessageEntity(r18, r20, r21, r22, r23, r24, r25, r26, r28, r30, r31);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof RecordASRMessageEntity) == true) goto L8;
        return false;
    L8:
        RecordASRMessageEntity r9 = (RecordASRMessageEntity) r8;
        if (this.callCreateTime == r9.callCreateTime) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.asrText, r9.asrText) == true) goto L15;
        return false;
    L15:
        if (this.owner == r9.owner) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.phoneNumber, r9.phoneNumber) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.partId, r9.partId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.partStartTime, r9.partStartTime) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.partDuration, r9.partDuration) == true) goto L30;
        return false;
    L30:
        if (this.startTime == r9.startTime) goto L33;
        return false;
    L33:
        if (this.duration == r9.duration) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.isConference, r9.isConference) == true) goto L39;
        return false;
    L39:
        if (this.id == r9.id) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((Long.hashCode(this.callCreateTime) * 31) + this.asrText.hashCode()) * 31) + Integer.hashCode(this.owner)) * 31) + this.phoneNumber.hashCode()) * 31;
        Integer r1 = this.partId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.partStartTime;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.partDuration;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((((r7 + r9) * 31) + Long.hashCode(this.startTime)) * 31) + Long.hashCode(this.duration)) * 31;
        Integer r11 = this.isConference;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return ((r10 + r2) * 31) + Long.hashCode(this.id);
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
        StringBuilder r0 = new StringBuilder("RecordASRMessageEntity(callCreateTime=");
        r0.append(this.callCreateTime).append(", asrText=").append(this.asrText).append(", owner=").append(this.owner).append(", phoneNumber=").append(this.phoneNumber).append(", partId=").append(this.partId).append(", partStartTime=").append(this.partStartTime).append(", partDuration=").append(this.partDuration).append(", startTime=").append(this.startTime).append(", duration=").append(this.duration).append(", isConference=").append(this.isConference).append(", id=").append(this.id).append(')');
        return r0.toString();
    }

    public RecordASRMessageEntity(long r6, String r8, int r9, String r10, Integer r11, Long r12, Long r13, long r14, long r16, Integer r18, long r19) {
        Intrinsics.checkNotNullParameter(r8, "asrText");
        Intrinsics.checkNotNullParameter(r10, "phoneNumber");
        this.callCreateTime = r6;
        this.asrText = r8;
        this.owner = r9;
        this.phoneNumber = r10;
        this.partId = r11;
        this.partStartTime = r12;
        this.partDuration = r13;
        this.startTime = r14;
        this.duration = r16;
        this.isConference = r18;
        this.id = r19;
    }

    public /* synthetic */ RecordASRMessageEntity(long r19, String r21, int r22, String r23, Integer r24, Long r25, Long r26, long r27, long r29, Integer r31, long r32, int r34, DefaultConstructorMarker r35) {
        if ((r34 & 1024) == 0) goto L5;
        long r16 = 0;
    L6:
        this(r19, r21, r22, r23, r24, r25, r26, r27, r29, r31, r16);
        return;
    L5:
        r16 = r32;
        goto L6
    }

    public final long getCallCreateTime() {
        return this.callCreateTime;
    }

    public final String getAsrText() {
        return this.asrText;
    }

    public final int getOwner() {
        return this.owner;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final Integer getPartId() {
        return this.partId;
    }

    public final Long getPartStartTime() {
        return this.partStartTime;
    }

    public final Long getPartDuration() {
        return this.partDuration;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final Integer isConference() {
        return this.isConference;
    }

    public final long getId() {
        return this.id;
    }
}
