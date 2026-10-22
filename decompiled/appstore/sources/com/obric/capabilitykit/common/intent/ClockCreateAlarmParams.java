package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.versionedparcelable.VersionedParcelable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.n;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\fJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003JP\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010%J\t\u0010&\u001a\u00020\bHÖ\u0001J\u0013\u0010'\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\n\u0010*\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u0010+\u001a\u00020\bHÖ\u0001J\u0012\u0010,\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010)H\u0016J\t\u0010.\u001a\u00020\u0004HÖ\u0001J\u0019\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\bHÖ\u0001R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015¨\u00064"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ClockCreateAlarmParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "time", "", "date", "repeatDayOfWeek", "", "", "closeInHoliday", "", "name", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;)V", "getCloseInHoliday", "()Ljava/lang/Boolean;", "setCloseInHoliday", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getName", "setName", "getRepeatDayOfWeek", "()[Ljava/lang/Integer;", "setRepeatDayOfWeek", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "getTime", "setTime", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/ClockCreateAlarmParams;", "describeContents", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getSubActionValue", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class ClockCreateAlarmParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<ClockCreateAlarmParams> CREATOR = null;

    @Nullable
    private Boolean closeInHoliday;

    @Nullable
    private String date;

    @Nullable
    private String name;

    @Nullable
    private Integer[] repeatDayOfWeek;

    @Nullable
    private String time;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ClockCreateAlarmParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ClockCreateAlarmParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            String r12 = r10.readString();
            String r13 = r10.readString();
            if (r10.readInt() != 0) goto L5;
            Integer[] r14 = null;
        L8:
            int r15 = 1;
            if (r10.readInt() != 0) goto L12;
            Boolean r16 = null;
        L16:
            ClockCreateAlarmParams r17 = new ClockCreateAlarmParams(r12, r13, r14, r16, r10.readString());
            int r18 = Math.min(r11, 0);
            ClassLoader r19 = Creator.class.getClassLoader();
        L17:
            if (r15 > r18) goto L19;
            r15 = r15 + 1;
        L19:
            if (r15 > r11) goto L21;
            a.d(r10, r19);
            r15 = r15 + 1;
            goto L19
        L21:
            return r17;
        L12:
            if (r10.readInt() == 0) goto L14;
            boolean r20 = true;
        L15:
            r16 = Boolean.valueOf(r20);
            goto L16
        L14:
            r20 = false;
            goto L15
        L5:
            int r21 = r10.readInt();
            r14 = new Integer[r21];
            int r22 = 0;
        L6:
            if (r22 == r21) goto L8;
            r14[r22] = Integer.valueOf(r10.readInt());
            r22 = r22 + 1;
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ClockCreateAlarmParams[] newArray(int r10) {
            return new ClockCreateAlarmParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockCreateAlarmParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockCreateAlarmParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public ClockCreateAlarmParams() {
        String r10 = null;
        String r11 = null;
        Integer[] r12 = null;
        Boolean r13 = null;
        String r14 = null;
        this(r10, r11, r12, r13, r14, 31, null);
    }

    public static /* synthetic */ ClockCreateAlarmParams copy$default(ClockCreateAlarmParams r10, String r11, String r12, Integer[] r13, Boolean r14, String r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.time;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.date;
    L8:
        String r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.repeatDayOfWeek;
    L11:
        Integer[] r19 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.closeInHoliday;
    L14:
        Boolean r20 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.name;
    L17:
        String r21 = r11;
        return r10.copy(r21, r18, r19, r20, r15);
    }

    @Nullable
    public final String component1() {
        return this.time;
    }

    @Nullable
    public final String component2() {
        return this.date;
    }

    @Nullable
    public final Integer[] component3() {
        return this.repeatDayOfWeek;
    }

    @Nullable
    public final Boolean component4() {
        return this.closeInHoliday;
    }

    @Nullable
    public final String component5() {
        return this.name;
    }

    @NotNull
    public final ClockCreateAlarmParams copy(@Nullable String r10, @Nullable String r11, @Nullable Integer[] r12, @Nullable Boolean r13, @Nullable String r14) {
        return new ClockCreateAlarmParams(r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ClockCreateAlarmParams) == true) goto L8;
        return false;
    L8:
        ClockCreateAlarmParams r11 = (ClockCreateAlarmParams) r10;
        if (q.b(this.time, r11.time) == true) goto L12;
        return false;
    L12:
        if (q.b(this.date, r11.date) == true) goto L15;
        return false;
    L15:
        if (q.b(this.repeatDayOfWeek, r11.repeatDayOfWeek) == true) goto L18;
        return false;
    L18:
        if (q.b(this.closeInHoliday, r11.closeInHoliday) == true) goto L21;
        return false;
    L21:
        if (q.b(this.name, r11.name) == true) goto L23;
        return false;
    L23:
        return true;
    }

    @Nullable
    public final Boolean getCloseInHoliday() {
        return this.closeInHoliday;
    }

    @Nullable
    public final String getDate() {
        return this.date;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Integer[] getRepeatDayOfWeek() {
        return this.repeatDayOfWeek;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        StringBuilder r10 = new StringBuilder();
        String r11 = this.time;
        String r12 = null;
        if (r11 == null) goto L5;
        String r13 = r11.toString();
    L6:
        r10.append(r13);
        r10.append('|');
        String r14 = this.date;
        if (r14 == null) goto L9;
        String r15 = r14.toString();
    L10:
        r10.append(r15);
        r10.append('|');
        Integer[] r16 = this.repeatDayOfWeek;
        if (r16 == null) goto L13;
        r12 = n.C(r16, null, null, null, 0, null, null, 63, null);
    L13:
        r10.append(r12);
        return r10.toString();
    L9:
        r15 = null;
        goto L10
    L5:
        r13 = null;
        goto L6
    }

    @Nullable
    public final String getTime() {
        return this.time;
    }

    public int hashCode() {
        String r10 = this.time;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.date;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        Integer[] r17 = this.repeatDayOfWeek;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        Boolean r20 = this.closeInHoliday;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String r23 = this.name;
        if (r23 == null) goto L23;
        r11 = r23.hashCode();
    L23:
        return r22 + r11;
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = Arrays.hashCode(r17);
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
        if ((r10 instanceof ClockCreateAlarmParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.time;
        if (r11 != null) goto L8;
        r11 = ((ClockCreateAlarmParams) r10).time;
    L8:
        String r12 = r11;
        String r13 = this.date;
        if (r13 != null) goto L11;
        r13 = ((ClockCreateAlarmParams) r10).date;
    L11:
        String r14 = r13;
        Integer[] r15 = this.repeatDayOfWeek;
        if (r15 != null) goto L14;
        r15 = ((ClockCreateAlarmParams) r10).repeatDayOfWeek;
    L14:
        Integer[] r16 = r15;
        Boolean r17 = this.closeInHoliday;
        if (r17 != null) goto L17;
        r17 = ((ClockCreateAlarmParams) r10).closeInHoliday;
    L17:
        Boolean r18 = r17;
        String r19 = this.name;
        if (r19 != null) goto L21;
        r19 = ((ClockCreateAlarmParams) r10).name;
    L21:
        return new ClockCreateAlarmParams(r12, r14, r16, r18, r19);
    }

    public final void setCloseInHoliday(@Nullable Boolean r10) {
        this.closeInHoliday = r10;
    }

    public final void setDate(@Nullable String r10) {
        this.date = r10;
    }

    public final void setName(@Nullable String r10) {
        this.name = r10;
    }

    public final void setRepeatDayOfWeek(@Nullable Integer[] r10) {
        this.repeatDayOfWeek = r10;
    }

    public final void setTime(@Nullable String r10) {
        this.time = r10;
    }

    @NotNull
    public String toString() {
        return "ClockCreateAlarmParams(time=" + this.time + ", date=" + this.date + ", repeatDayOfWeek=" + Arrays.toString(this.repeatDayOfWeek) + ", closeInHoliday=" + this.closeInHoliday + ", name=" + this.name + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v3, types: [int] */
    /* JADX WARN: Type inference failed for: r7v4 */
    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        ?? r12 = 0;
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.time);
        r10.writeString(this.date);
        Integer[] r13 = this.repeatDayOfWeek;
        if (r13 != null) goto L5;
        r10.writeInt(0);
    L8:
        Boolean r14 = this.closeInHoliday;
        if (r14 != null) goto L11;
    L10:
        r10.writeInt(r12);
        r10.writeString(this.name);
        return;
    L11:
        r10.writeInt(1);
        r12 = r14.booleanValue();
        goto L10
    L5:
        r10.writeInt(1);
        int r15 = r13.length;
        r10.writeInt(r15);
        int r16 = 0;
    L6:
        if (r16 == r15) goto L8;
        r10.writeInt(r13[r16].intValue());
        r16 = r16 + 1;
        goto L6
    }

    public ClockCreateAlarmParams(@Nullable String r10, @Nullable String r11, @Nullable Integer[] r12, @Nullable Boolean r13, @Nullable String r14) {
        this.time = r10;
        this.date = r11;
        this.repeatDayOfWeek = r12;
        this.closeInHoliday = r13;
        this.name = r14;
    }

    public /* synthetic */ ClockCreateAlarmParams(String r10, String r11, Integer[] r12, Boolean r13, String r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r13 = null;
    L15:
        if ((r15 & 16) == 0) goto L17;
        r14 = null;
    L17:
        this(r10, r11, r12, r13, r14);
    }
}
