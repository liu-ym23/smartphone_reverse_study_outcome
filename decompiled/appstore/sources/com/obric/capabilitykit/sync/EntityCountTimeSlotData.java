package com.obric.capabilitykit.sync;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedanceos.common.model.AppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 22\u00020\u0001:\u00012B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J;\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\b\u0010'\u001a\u00020\tH\u0016J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\tHÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001J\u0018\u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00101\u001a\u00020\tH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014¨\u00063"}, d2 = {"Lcom/obric/capabilitykit/sync/EntityCountTimeSlotData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "startTime", "", "endTimeLong", "count", "", "leftTimeArrayIndex", "rightTimeArrayIndex", "(JJIII)V", "getCount", "()I", "setCount", "(I)V", "getEndTimeLong", "()J", "setEndTimeLong", "(J)V", "leftIndex", "getLeftIndex", "setLeftIndex", "getLeftTimeArrayIndex", "setLeftTimeArrayIndex", "rightIndex", "getRightIndex", "setRightIndex", "getRightTimeArrayIndex", "setRightTimeArrayIndex", "getStartTime", "setStartTime", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "", "writeToParcel", "", "flags", "CREATOR", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityCountTimeSlotData implements Parcelable {

    @NotNull
    public static final a CREATOR = null;
    private int count;
    private long endTimeLong;
    private int leftIndex;
    private int leftTimeArrayIndex;
    private int rightIndex;
    private int rightTimeArrayIndex;
    private long startTime;

    public static final class a implements Parcelable.Creator {
        public a() {
        }

        public EntityCountTimeSlotData a(Parcel r10) {
            q.g(r10, "parcel");
            return new EntityCountTimeSlotData(r10);
        }

        public EntityCountTimeSlotData[] b(int r10) {
            return new EntityCountTimeSlotData[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        CREATOR = new a(null);
    }

    public EntityCountTimeSlotData(long r10, long r11, int r12, int r13, int r14) {
        this.startTime = r10;
        this.endTimeLong = r11;
        this.count = r12;
        this.leftTimeArrayIndex = r13;
        this.rightTimeArrayIndex = r14;
        this.leftIndex = -1;
        this.rightIndex = -1;
    }

    public static /* synthetic */ EntityCountTimeSlotData copy$default(EntityCountTimeSlotData r10, long r11, long r12, int r13, int r14, int r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L5;
        long r18 = r10.startTime;
    L7:
        if ((r16 & 2) == 0) goto L9;
        long r19 = r10.endTimeLong;
    L11:
        if ((r16 & 4) == 0) goto L13;
        int r20 = r10.count;
    L15:
        if ((r16 & 8) == 0) goto L17;
        int r21 = r10.leftTimeArrayIndex;
    L19:
        if ((r16 & 16) == 0) goto L21;
        int r22 = r10.rightTimeArrayIndex;
    L23:
        return r10.copy(r18, r19, r20, r21, r22);
    L21:
        r22 = r15;
        goto L23
    L17:
        r21 = r14;
        goto L19
    L13:
        r20 = r13;
        goto L15
    L9:
        r19 = r12;
        goto L11
    L5:
        r18 = r11;
        goto L7
    }

    public final long component1() {
        return this.startTime;
    }

    public final long component2() {
        return this.endTimeLong;
    }

    public final int component3() {
        return this.count;
    }

    public final int component4() {
        return this.leftTimeArrayIndex;
    }

    public final int component5() {
        return this.rightTimeArrayIndex;
    }

    @NotNull
    public final EntityCountTimeSlotData copy(long r10, long r11, int r13, int r14, int r15) {
        return new EntityCountTimeSlotData(r10, r11, r13, r14, r15);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof EntityCountTimeSlotData) == true) goto L8;
        return false;
    L8:
        EntityCountTimeSlotData r11 = (EntityCountTimeSlotData) r10;
        if (this.startTime == r11.startTime) goto L12;
        return false;
    L12:
        if (this.endTimeLong == r11.endTimeLong) goto L15;
        return false;
    L15:
        if (this.count == r11.count) goto L18;
        return false;
    L18:
        if (this.leftTimeArrayIndex == r11.leftTimeArrayIndex) goto L21;
        return false;
    L21:
        if (this.rightTimeArrayIndex == r11.rightTimeArrayIndex) goto L23;
        return false;
    L23:
        return true;
    }

    public final int getCount() {
        return this.count;
    }

    public final long getEndTimeLong() {
        return this.endTimeLong;
    }

    public final int getLeftIndex() {
        return this.leftIndex;
    }

    public final int getLeftTimeArrayIndex() {
        return this.leftTimeArrayIndex;
    }

    public final int getRightIndex() {
        return this.rightIndex;
    }

    public final int getRightTimeArrayIndex() {
        return this.rightTimeArrayIndex;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.startTime) * 31) + Long.hashCode(this.endTimeLong)) * 31) + Integer.hashCode(this.count)) * 31) + Integer.hashCode(this.leftTimeArrayIndex)) * 31) + Integer.hashCode(this.rightTimeArrayIndex);
    }

    public final void setCount(int r10) {
        this.count = r10;
    }

    public final void setEndTimeLong(long r10) {
        this.endTimeLong = r10;
    }

    public final void setLeftIndex(int r10) {
        this.leftIndex = r10;
    }

    public final void setLeftTimeArrayIndex(int r10) {
        this.leftTimeArrayIndex = r10;
    }

    public final void setRightIndex(int r10) {
        this.rightIndex = r10;
    }

    public final void setRightTimeArrayIndex(int r10) {
        this.rightTimeArrayIndex = r10;
    }

    public final void setStartTime(long r10) {
        this.startTime = r10;
    }

    @NotNull
    public String toString() {
        return "EntityCountTimeSlotData(startTime=" + this.startTime + ", endTimeLong=" + this.endTimeLong + ", count=" + this.count + ", leftTimeArrayIndex=" + this.leftTimeArrayIndex + ", rightTimeArrayIndex=" + this.rightTimeArrayIndex + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        r10.writeValue(Long.valueOf(this.startTime));
        r10.writeValue(Long.valueOf(this.endTimeLong));
        r10.writeInt(this.count);
        r10.writeInt(this.leftTimeArrayIndex);
        r10.writeInt(this.rightTimeArrayIndex);
        r10.writeValue(Integer.valueOf(this.leftIndex));
        r10.writeValue(Integer.valueOf(this.rightIndex));
    }

    public EntityCountTimeSlotData(@NotNull Parcel r12) {
        q.g(r12, "parcel");
        Class r10 = Long.TYPE;
        Object r11 = r12.readValue(r10.getClassLoader());
        q.e(r11, "null cannot be cast to non-null type kotlin.Long");
        long r13 = ((Long) r11).longValue();
        Object r14 = r12.readValue(r10.getClassLoader());
        q.e(r14, "null cannot be cast to non-null type kotlin.Long");
        this(r13, ((Long) r14).longValue(), r12.readInt(), r12.readInt(), r12.readInt());
        Class r15 = Integer.TYPE;
        Object r16 = r12.readValue(r15.getClassLoader());
        q.e(r16, "null cannot be cast to non-null type kotlin.Int");
        this.leftIndex = ((Integer) r16).intValue();
        Object r17 = r12.readValue(r15.getClassLoader());
        q.e(r17, "null cannot be cast to non-null type kotlin.Int");
        this.rightIndex = ((Integer) r17).intValue();
    }
}
