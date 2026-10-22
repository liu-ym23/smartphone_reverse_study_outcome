package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.versionedparcelable.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClockSearchCountdownParams.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0012JJ\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010$J\t\u0010%\u001a\u00020\nHÖ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\nHÖ\u0001J\u0012\u0010+\u001a\u00020\u00012\b\u0010,\u001a\u0004\u0018\u00010)H\u0016J\t\u0010-\u001a\u00020\u0004HÖ\u0001J\u0019\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\nHÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f¨\u00063"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ClockSearchCountdownParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "query", "", "startTimestamp", "", "endTimestamp", "name", "maxCount", "", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)V", "getEndTimestamp", "()Ljava/lang/Long;", "setEndTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMaxCount", "()Ljava/lang/Integer;", "setMaxCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getQuery", "setQuery", "getStartTimestamp", "setStartTimestamp", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/ClockSearchCountdownParams;", "describeContents", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ClockSearchCountdownParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<ClockSearchCountdownParams> CREATOR = null;
    private Long endTimestamp;
    private Integer maxCount;
    private String name;
    private String query;
    private Long startTimestamp;

    /* JADX INFO: compiled from: ClockSearchCountdownParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ClockSearchCountdownParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ClockSearchCountdownParams createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            Intrinsics.checkNotNullParameter(r10, "parcel");
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
            ParcelUtils.skipValueSafely(r10, r9);
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
        CREATOR = new Creator();
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
        if ((r5 instanceof ClockSearchCountdownParams) == true) goto L8;
        return false;
    L8:
        ClockSearchCountdownParams r6 = (ClockSearchCountdownParams) r5;
        if (Intrinsics.areEqual(this.query, r6.query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.startTimestamp, r6.startTimestamp) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.endTimestamp, r6.endTimestamp) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.maxCount, r6.maxCount) == true) goto L23;
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
        Intrinsics.checkNotNullParameter(r5, "out");
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
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ ClockSearchCountdownParams(String r2, Long r3, Long r4, String r5, Integer r6, int r7, DefaultConstructorMarker r8) {
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
    public IntentParams mergeParams(Object r8) {
        if ((r8 instanceof ClockSearchCountdownParams) == false) goto L5;
        String r0 = this.query;
        if (r0 != null) goto L9;
        r0 = ((ClockSearchCountdownParams) r8).query;
    L9:
        String r2 = r0;
        Long r1 = this.startTimestamp;
        if (r1 != null) goto L12;
        r1 = ((ClockSearchCountdownParams) r8).startTimestamp;
    L12:
        Long r3 = r1;
        Long r4 = this.endTimestamp;
        if (r4 != null) goto L15;
        r4 = ((ClockSearchCountdownParams) r8).endTimestamp;
    L15:
        Long r5 = r4;
        String r6 = this.name;
        if (r6 != null) goto L18;
        r6 = ((ClockSearchCountdownParams) r8).name;
    L18:
        String r7 = r6;
        Integer r9 = this.maxCount;
        if (r9 != null) goto L22;
        r9 = ((ClockSearchCountdownParams) r8).maxCount;
    L22:
        return new ClockSearchCountdownParams(r2, r3, r5, r7, r9);
    L5:
        return this;
    }
}
