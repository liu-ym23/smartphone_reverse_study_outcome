package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.versionedparcelable.VersionedParcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BY\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0018Jb\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010,J\t\u0010-\u001a\u00020\fHÖ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\fHÖ\u0001J\u0012\u00103\u001a\u00020\u00012\b\u00104\u001a\u0004\u0018\u000101H\u0016J\t\u00105\u001a\u00020\u0004HÖ\u0001J\u0019\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\fHÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011¨\u0006;"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ClockSearchAlarmParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "query", "", "startTimestamp", "", "endTimestamp", "alarmTime", "name", "switchStatus", "maxCount", "", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAlarmTime", "()Ljava/lang/String;", "setAlarmTime", "(Ljava/lang/String;)V", "getEndTimestamp", "()Ljava/lang/Long;", "setEndTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMaxCount", "()Ljava/lang/Integer;", "setMaxCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getName", "setName", "getQuery", "setQuery", "getStartTimestamp", "setStartTimestamp", "getSwitchStatus", "setSwitchStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/ClockSearchAlarmParams;", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class ClockSearchAlarmParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<ClockSearchAlarmParams> CREATOR = null;

    @Nullable
    private String alarmTime;

    @Nullable
    private Long endTimestamp;

    @Nullable
    private Integer maxCount;

    @Nullable
    private String name;

    @Nullable
    private String query;

    @Nullable
    private Long startTimestamp;

    @Nullable
    private String switchStatus;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ClockSearchAlarmParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ClockSearchAlarmParams createFromParcel(@NotNull Parcel r11) {
            int r10 = r11.readInt();
            q.g(r11, "parcel");
            String r12 = r11.readString();
            if (r11.readInt() != 0) goto L5;
            Long r13 = null;
        L7:
            if (r11.readInt() != 0) goto L9;
            Long r14 = null;
        L10:
            String r15 = r11.readString();
            String r16 = r11.readString();
            String r17 = r11.readString();
            if (r11.readInt() != 0) goto L13;
            Integer r18 = null;
        L14:
            ClockSearchAlarmParams r19 = new ClockSearchAlarmParams(r12, r13, r14, r15, r16, r17, r18);
            int r20 = Math.min(r10, 0);
            ClassLoader r21 = Creator.class.getClassLoader();
            int r22 = 1;
        L15:
            if (r22 > r20) goto L17;
            r22 = r22 + 1;
        L17:
            if (r22 > r10) goto L19;
            a.d(r11, r21);
            r22 = r22 + 1;
            goto L17
        L19:
            return r19;
        L13:
            r18 = Integer.valueOf(r11.readInt());
            goto L14
        L9:
            r14 = Long.valueOf(r11.readLong());
            goto L10
        L5:
            r13 = Long.valueOf(r11.readLong());
            goto L7
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ClockSearchAlarmParams[] newArray(int r10) {
            return new ClockSearchAlarmParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockSearchAlarmParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockSearchAlarmParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public ClockSearchAlarmParams() {
        String r10 = null;
        Long r11 = null;
        Long r12 = null;
        String r13 = null;
        String r14 = null;
        String r15 = null;
        Integer r16 = null;
        this(r10, r11, r12, r13, r14, r15, r16, 127, null);
    }

    public static /* synthetic */ ClockSearchAlarmParams copy$default(ClockSearchAlarmParams r10, String r11, Long r12, Long r13, String r14, String r15, String r16, Integer r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L6;
        r11 = r10.query;
    L6:
        if ((r18 & 2) == 0) goto L8;
        r12 = r10.startTimestamp;
    L8:
        Long r110 = r12;
        if ((r18 & 4) == 0) goto L11;
        r13 = r10.endTimestamp;
    L11:
        Long r20 = r13;
        if ((r18 & 8) == 0) goto L14;
        r14 = r10.alarmTime;
    L14:
        String r21 = r14;
        if ((r18 & 16) == 0) goto L17;
        r15 = r10.name;
    L17:
        String r22 = r15;
        if ((r18 & 32) == 0) goto L20;
        r16 = r10.switchStatus;
    L20:
        String r23 = r16;
        if ((r18 & 64) == 0) goto L23;
        r17 = r10.maxCount;
    L23:
        String r24 = r11;
        return r10.copy(r24, r110, r20, r21, r22, r23, r17);
    }

    @Nullable
    public final String component1() {
        return this.query;
    }

    @Nullable
    public final Long component2() {
        return this.startTimestamp;
    }

    @Nullable
    public final Long component3() {
        return this.endTimestamp;
    }

    @Nullable
    public final String component4() {
        return this.alarmTime;
    }

    @Nullable
    public final String component5() {
        return this.name;
    }

    @Nullable
    public final String component6() {
        return this.switchStatus;
    }

    @Nullable
    public final Integer component7() {
        return this.maxCount;
    }

    @NotNull
    public final ClockSearchAlarmParams copy(@Nullable String r10, @Nullable Long r11, @Nullable Long r12, @Nullable String r13, @Nullable String r14, @Nullable String r15, @Nullable Integer r16) {
        return new ClockSearchAlarmParams(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ClockSearchAlarmParams) == true) goto L8;
        return false;
    L8:
        ClockSearchAlarmParams r11 = (ClockSearchAlarmParams) r10;
        if (q.b(this.query, r11.query) == true) goto L12;
        return false;
    L12:
        if (q.b(this.startTimestamp, r11.startTimestamp) == true) goto L15;
        return false;
    L15:
        if (q.b(this.endTimestamp, r11.endTimestamp) == true) goto L18;
        return false;
    L18:
        if (q.b(this.alarmTime, r11.alarmTime) == true) goto L21;
        return false;
    L21:
        if (q.b(this.name, r11.name) == true) goto L24;
        return false;
    L24:
        if (q.b(this.switchStatus, r11.switchStatus) == true) goto L27;
        return false;
    L27:
        if (q.b(this.maxCount, r11.maxCount) == true) goto L29;
        return false;
    L29:
        return true;
    }

    @Nullable
    public final String getAlarmTime() {
        return this.alarmTime;
    }

    @Nullable
    public final Long getEndTimestamp() {
        return this.endTimestamp;
    }

    @Nullable
    public final Integer getMaxCount() {
        return this.maxCount;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getQuery() {
        return this.query;
    }

    @Nullable
    public final Long getStartTimestamp() {
        return this.startTimestamp;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final String getSwitchStatus() {
        return this.switchStatus;
    }

    public int hashCode() {
        String r10 = this.query;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        Long r14 = this.startTimestamp;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        Long r17 = this.endTimestamp;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.alarmTime;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String r23 = this.name;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 31;
        String r26 = this.switchStatus;
        if (r26 != null) goto L25;
        int r27 = 0;
    L26:
        int r28 = (r25 + r27) * 31;
        Integer r29 = this.maxCount;
        if (r29 == null) goto L31;
        r11 = r29.hashCode();
    L31:
        return r28 + r11;
    L25:
        r27 = r26.hashCode();
        goto L26
    L21:
        r24 = r23.hashCode();
        goto L22
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof ClockSearchAlarmParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.query;
        if (r11 != null) goto L8;
        r11 = ((ClockSearchAlarmParams) r10).query;
    L8:
        String r12 = r11;
        Long r13 = this.startTimestamp;
        if (r13 != null) goto L11;
        r13 = ((ClockSearchAlarmParams) r10).startTimestamp;
    L11:
        Long r14 = r13;
        Long r15 = this.endTimestamp;
        if (r15 != null) goto L14;
        r15 = ((ClockSearchAlarmParams) r10).endTimestamp;
    L14:
        Long r16 = r15;
        String r17 = this.alarmTime;
        if (r17 != null) goto L17;
        r17 = ((ClockSearchAlarmParams) r10).alarmTime;
    L17:
        String r18 = r17;
        String r19 = this.name;
        if (r19 != null) goto L20;
        r19 = ((ClockSearchAlarmParams) r10).name;
    L20:
        String r20 = r19;
        String r21 = this.switchStatus;
        if (r21 != null) goto L23;
        r21 = ((ClockSearchAlarmParams) r10).switchStatus;
    L23:
        String r22 = r21;
        Integer r23 = this.maxCount;
        if (r23 != null) goto L27;
        r23 = ((ClockSearchAlarmParams) r10).maxCount;
    L27:
        return new ClockSearchAlarmParams(r12, r14, r16, r18, r20, r22, r23);
    }

    public final void setAlarmTime(@Nullable String r10) {
        this.alarmTime = r10;
    }

    public final void setEndTimestamp(@Nullable Long r10) {
        this.endTimestamp = r10;
    }

    public final void setMaxCount(@Nullable Integer r10) {
        this.maxCount = r10;
    }

    public final void setName(@Nullable String r10) {
        this.name = r10;
    }

    public final void setQuery(@Nullable String r10) {
        this.query = r10;
    }

    public final void setStartTimestamp(@Nullable Long r10) {
        this.startTimestamp = r10;
    }

    public final void setSwitchStatus(@Nullable String r10) {
        this.switchStatus = r10;
    }

    @NotNull
    public String toString() {
        return "ClockSearchAlarmParams(query=" + this.query + ", startTimestamp=" + this.startTimestamp + ", endTimestamp=" + this.endTimestamp + ", alarmTime=" + this.alarmTime + ", name=" + this.name + ", switchStatus=" + this.switchStatus + ", maxCount=" + this.maxCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.query);
        Long r12 = this.startTimestamp;
        if (r12 != null) goto L5;
        r10.writeInt(0);
    L6:
        Long r13 = this.endTimestamp;
        if (r13 != null) goto L9;
        r10.writeInt(0);
    L10:
        r10.writeString(this.alarmTime);
        r10.writeString(this.name);
        r10.writeString(this.switchStatus);
        Integer r14 = this.maxCount;
        if (r14 != null) goto L13;
        r10.writeInt(0);
        return;
    L13:
        r10.writeInt(1);
        r10.writeInt(r14.intValue());
        return;
    L9:
        r10.writeInt(1);
        r10.writeLong(r13.longValue());
        goto L10
    L5:
        r10.writeInt(1);
        r10.writeLong(r12.longValue());
        goto L6
    }

    public ClockSearchAlarmParams(@Nullable String r10, @Nullable Long r11, @Nullable Long r12, @Nullable String r13, @Nullable String r14, @Nullable String r15, @Nullable Integer r16) {
        this.query = r10;
        this.startTimestamp = r11;
        this.endTimestamp = r12;
        this.alarmTime = r13;
        this.name = r14;
        this.switchStatus = r15;
        this.maxCount = r16;
    }

    public /* synthetic */ ClockSearchAlarmParams(String r10, Long r11, Long r12, String r13, String r14, String r15, Integer r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r17 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r17 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r17 & 8) == 0) goto L15;
        r13 = null;
    L15:
        if ((r17 & 16) == 0) goto L18;
        r14 = null;
    L18:
        if ((r17 & 32) == 0) goto L21;
        r15 = null;
    L21:
        if ((r17 & 64) == 0) goto L23;
        r16 = null;
    L23:
        this(r10, r11, r12, r13, r14, r15, r16);
    }
}
