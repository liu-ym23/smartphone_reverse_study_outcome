package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ClockSearchCountdownParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ClockSearchCountdownParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<ClockSearchCountdownParams> CREATOR = null;
    private Long endTimestamp;
    private Integer maxCount;
    private String name;
    private String query;
    private Long startTimestamp;

    /* JADX INFO: compiled from: ClockSearchCountdownParams.kt */
    public static final class Creator implements Parcelable.Creator<ClockSearchCountdownParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ClockSearchCountdownParams createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            o.e(r10, "parcel");
            String r3 = r10.readString();
            if (r10.readInt() != 0) goto L5;
            Long r5 = null;
        L7:
            if (r10.readInt() != 0) goto L9;
            Long r6 = null;
        L10:
            String r7 = r10.readString();
            if (r10.readInt() != 0) goto L13;
            Integer r8 = null;
        L14:
            ClockSearchCountdownParams r1 = new ClockSearchCountdownParams(r3, r5, r6, r7, r8);
            int r2 = Math.min(r0, 0);
            ClassLoader r9 = getClass().getClassLoader();
            int r4 = 1;
        L15:
            if (r4 > r2) goto L17;
            r4 = r4 + 1;
        L17:
            if (r4 > r0) goto L19;
            a.a(r10, r9);
            r4 = r4 + 1;
            goto L17
        L19:
            return r1;
        L13:
            r8 = Integer.valueOf(r10.readInt());
            goto L14
        L9:
            r6 = Long.valueOf(r10.readLong());
            goto L10
        L5:
            r5 = Long.valueOf(r10.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockSearchCountdownParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ClockSearchCountdownParams[] newArray(int r1) {
            return new ClockSearchCountdownParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockSearchCountdownParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public ClockSearchCountdownParams() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ClockSearchCountdownParams copy$default(ClockSearchCountdownParams r3, String r4, Long r5, Long r6, String r7, Integer r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.query;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.startTimestamp;
    L8:
        Long r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.endTimestamp;
    L11:
        Long r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.name;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.maxCount;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.query;
    }

    public final Long component2() {
        return this.startTimestamp;
    }

    public final Long component3() {
        return this.endTimestamp;
    }

    public final String component4() {
        return this.name;
    }

    public final Integer component5() {
        return this.maxCount;
    }

    public final ClockSearchCountdownParams copy(String r7, Long r8, Long r9, String r10, Integer r11) {
        return new ClockSearchCountdownParams(r7, r8, r9, r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ClockSearchCountdownParams.class) == true) goto L8;
        return false;
    L8:
        ClockSearchCountdownParams r6 = (ClockSearchCountdownParams) ZeusTransformUtils.preCheckCast(r5, ClockSearchCountdownParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.query, r6.query) == true) goto L12;
        return false;
    L12:
        if (o.a(this.startTimestamp, r6.startTimestamp) == true) goto L15;
        return false;
    L15:
        if (o.a(this.endTimestamp, r6.endTimestamp) == true) goto L18;
        return false;
    L18:
        if (o.a(this.name, r6.name) == true) goto L21;
        return false;
    L21:
        if (o.a(this.maxCount, r6.maxCount) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.query;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.startTimestamp;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.endTimestamp;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.name;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.maxCount;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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
        return "ClockSearchCountdownParams(query=" + this.query + ", startTimestamp=" + this.startTimestamp + ", endTimestamp=" + this.endTimestamp + ", name=" + this.name + ", maxCount=" + this.maxCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        r5.writeInt(0);
        o.e(r5, "out");
        r5.writeString(this.query);
        Long r0 = this.startTimestamp;
        if (r0 != null) goto L5;
        r5.writeInt(0);
    L6:
        Long r1 = this.endTimestamp;
        if (r1 != null) goto L9;
        r5.writeInt(0);
    L10:
        r5.writeString(this.name);
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

    public ClockSearchCountdownParams(String r1, Long r2, Long r3, String r4, Integer r5) {
        this.query = r1;
        this.startTimestamp = r2;
        this.endTimestamp = r3;
        this.name = r4;
        this.maxCount = r5;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ ClockSearchCountdownParams(String r2, Long r3, Long r4, String r5, Integer r6, int r7, h r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = null;
    L17:
        this(r2, r3, r4, r5, r6);
    }

    public final String getQuery() {
        return this.query;
    }

    public final void setQuery(String r1) {
        this.query = r1;
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

    public final String getName() {
        return this.name;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final Integer getMaxCount() {
        return this.maxCount;
    }

    public final void setMaxCount(Integer r1) {
        this.maxCount = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r10) {
        if (ZeusTransformUtils.instanceOf(r10, ClockSearchCountdownParams.class) == false) goto L5;
        String r1 = this.query;
        if (r1 != null) goto L9;
        r1 = ((ClockSearchCountdownParams) ZeusTransformUtils.preCheckCast(r10, ClockSearchCountdownParams.class, "com.obric.aiagent.plugin")).query;
    L9:
        String r4 = r1;
        Long r2 = this.startTimestamp;
        if (r2 != null) goto L12;
        r2 = ((ClockSearchCountdownParams) ZeusTransformUtils.preCheckCast(r10, ClockSearchCountdownParams.class, "com.obric.aiagent.plugin")).startTimestamp;
    L12:
        Long r5 = r2;
        Long r3 = this.endTimestamp;
        if (r3 != null) goto L15;
        r3 = ((ClockSearchCountdownParams) ZeusTransformUtils.preCheckCast(r10, ClockSearchCountdownParams.class, "com.obric.aiagent.plugin")).endTimestamp;
    L15:
        Long r6 = r3;
        String r7 = this.name;
        if (r7 != null) goto L18;
        r7 = ((ClockSearchCountdownParams) ZeusTransformUtils.preCheckCast(r10, ClockSearchCountdownParams.class, "com.obric.aiagent.plugin")).name;
    L18:
        String r8 = r7;
        Integer r9 = this.maxCount;
        if (r9 != null) goto L22;
        r9 = ((ClockSearchCountdownParams) ZeusTransformUtils.preCheckCast(r10, ClockSearchCountdownParams.class, "com.obric.aiagent.plugin")).maxCount;
    L22:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new ClockSearchCountdownParams(r4, r5, r6, r8, r9), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
