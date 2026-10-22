package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SystemHeartBeatParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SystemHeartBeatParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<SystemHeartBeatParams> CREATOR = null;
    private Long expiryTimestamp;
    private String ext;
    private String questionId;
    private Long timeUntilNextHeartbeat;

    /* JADX INFO: compiled from: SystemHeartBeatParams.kt */
    public static final class Creator implements Parcelable.Creator<SystemHeartBeatParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemHeartBeatParams createFromParcel(Parcel r8) {
            int r0 = r8.readInt();
            o.e(r8, "parcel");
            String r2 = r8.readString();
            Long r4 = null;
            if (r8.readInt() != 0) goto L5;
            Long r3 = null;
        L7:
            if (r8.readInt() == 0) goto L10;
            r4 = Long.valueOf(r8.readLong());
        L10:
            SystemHeartBeatParams r1 = new SystemHeartBeatParams(r2, r3, r4, r8.readString());
            int r5 = Math.min(r0, 0);
            ClassLoader r7 = getClass().getClassLoader();
            int r6 = 1;
        L11:
            if (r6 > r5) goto L13;
            r6 = r6 + 1;
        L13:
            if (r6 > r0) goto L15;
            a.a(r8, r7);
            r6 = r6 + 1;
            goto L13
        L15:
            return r1;
        L5:
            r3 = Long.valueOf(r8.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemHeartBeatParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemHeartBeatParams[] newArray(int r1) {
            return new SystemHeartBeatParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemHeartBeatParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public SystemHeartBeatParams() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SystemHeartBeatParams copy$default(SystemHeartBeatParams r0, String r1, Long r2, Long r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.questionId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.expiryTimestamp;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.timeUntilNextHeartbeat;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.ext;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.questionId;
    }

    public final Long component2() {
        return this.expiryTimestamp;
    }

    public final Long component3() {
        return this.timeUntilNextHeartbeat;
    }

    public final String component4() {
        return this.ext;
    }

    public final SystemHeartBeatParams copy(String r1, Long r2, Long r3, String r4) {
        return new SystemHeartBeatParams(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SystemHeartBeatParams.class) == true) goto L8;
        return false;
    L8:
        SystemHeartBeatParams r6 = (SystemHeartBeatParams) ZeusTransformUtils.preCheckCast(r5, SystemHeartBeatParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.questionId, r6.questionId) == true) goto L12;
        return false;
    L12:
        if (o.a(this.expiryTimestamp, r6.expiryTimestamp) == true) goto L15;
        return false;
    L15:
        if (o.a(this.timeUntilNextHeartbeat, r6.timeUntilNextHeartbeat) == true) goto L18;
        return false;
    L18:
        if (o.a(this.ext, r6.ext) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.questionId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.expiryTimestamp;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.timeUntilNextHeartbeat;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.ext;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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
        return "SystemHeartBeatParams(questionId=" + this.questionId + ", expiryTimestamp=" + this.expiryTimestamp + ", timeUntilNextHeartbeat=" + this.timeUntilNextHeartbeat + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        r5.writeInt(0);
        o.e(r5, "out");
        r5.writeString(this.questionId);
        Long r0 = this.expiryTimestamp;
        if (r0 != null) goto L5;
        r5.writeInt(0);
    L6:
        Long r1 = this.timeUntilNextHeartbeat;
        if (r1 != null) goto L9;
        r5.writeInt(0);
    L10:
        r5.writeString(this.ext);
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

    public SystemHeartBeatParams(String r1, Long r2, Long r3, String r4) {
        this.questionId = r1;
        this.expiryTimestamp = r2;
        this.timeUntilNextHeartbeat = r3;
        this.ext = r4;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ SystemHeartBeatParams(String r2, Long r3, Long r4, String r5, int r6, h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }

    public final String getQuestionId() {
        return this.questionId;
    }

    public final void setQuestionId(String r1) {
        this.questionId = r1;
    }

    public final Long getExpiryTimestamp() {
        return this.expiryTimestamp;
    }

    public final void setExpiryTimestamp(Long r1) {
        this.expiryTimestamp = r1;
    }

    public final Long getTimeUntilNextHeartbeat() {
        return this.timeUntilNextHeartbeat;
    }

    public final void setTimeUntilNextHeartbeat(Long r1) {
        this.timeUntilNextHeartbeat = r1;
    }

    public final String getExt() {
        return this.ext;
    }

    public final void setExt(String r1) {
        this.ext = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.expiryTimestamp != null) goto L5;
    L7:
        return false;
    L5:
        if (this.timeUntilNextHeartbeat == null) goto L7;
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, SystemHeartBeatParams.class) == false) goto L5;
        String r1 = this.questionId;
        if (r1 != null) goto L9;
        r1 = ((SystemHeartBeatParams) ZeusTransformUtils.preCheckCast(r6, SystemHeartBeatParams.class, "com.obric.aiagent.plugin")).questionId;
    L9:
        Long r3 = this.expiryTimestamp;
        if (r3 != null) goto L12;
        r3 = ((SystemHeartBeatParams) ZeusTransformUtils.preCheckCast(r6, SystemHeartBeatParams.class, "com.obric.aiagent.plugin")).expiryTimestamp;
    L12:
        Long r4 = this.timeUntilNextHeartbeat;
        if (r4 != null) goto L15;
        r4 = ((SystemHeartBeatParams) ZeusTransformUtils.preCheckCast(r6, SystemHeartBeatParams.class, "com.obric.aiagent.plugin")).timeUntilNextHeartbeat;
    L15:
        String r5 = this.ext;
        if (r5 != null) goto L19;
        r5 = ((SystemHeartBeatParams) ZeusTransformUtils.preCheckCast(r6, SystemHeartBeatParams.class, "com.obric.aiagent.plugin")).ext;
    L19:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new SystemHeartBeatParams(r1, r3, r4, r5), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
