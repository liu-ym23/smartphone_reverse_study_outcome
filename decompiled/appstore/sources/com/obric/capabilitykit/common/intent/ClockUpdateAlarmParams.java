package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.versionedparcelable.VersionedParcelable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BS\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000eJ\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010)\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\\\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010,J\t\u0010-\u001a\u00020\nHÖ\u0001J\u0013\u0010.\u001a\u00020\f2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\nHÖ\u0001J\u0012\u00102\u001a\u00020\u00012\b\u00103\u001a\u0004\u0018\u000100H\u0016J\t\u00104\u001a\u00020\u0006HÖ\u0001J\u0019\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\nHÖ\u0001R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017¨\u0006:"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ClockUpdateAlarmParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "target", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "time", "", "date", "repeatDayOfWeek", "", "", "closeInHoliday", "", "name", "(Lcom/obric/capabilitykit/entity/app/AlarmEntity;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;)V", "getCloseInHoliday", "()Ljava/lang/Boolean;", "setCloseInHoliday", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getName", "setName", "getRepeatDayOfWeek", "()[Ljava/lang/Integer;", "setRepeatDayOfWeek", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "getTarget", "()Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "setTarget", "(Lcom/obric/capabilitykit/entity/app/AlarmEntity;)V", "getTime", "setTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/obric/capabilitykit/entity/app/AlarmEntity;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/ClockUpdateAlarmParams;", "describeContents", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class ClockUpdateAlarmParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<ClockUpdateAlarmParams> CREATOR = null;

    @Nullable
    private Boolean closeInHoliday;

    @Nullable
    private String date;

    @Nullable
    private String name;

    @Nullable
    private Integer[] repeatDayOfWeek;

    @Nullable
    private AlarmEntity target;

    @Nullable
    private String time;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ClockUpdateAlarmParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ClockUpdateAlarmParams createFromParcel(@NotNull Parcel r11) {
            int r10 = r11.readInt();
            q.g(r11, "parcel");
            AlarmEntity r12 = (AlarmEntity) r11.readParcelable(ClockUpdateAlarmParams.class.getClassLoader());
            String r13 = r11.readString();
            String r14 = r11.readString();
            if (r11.readInt() != 0) goto L5;
            Integer[] r15 = null;
        L8:
            int r16 = 1;
            if (r11.readInt() != 0) goto L12;
            Boolean r17 = null;
        L16:
            ClockUpdateAlarmParams r18 = new ClockUpdateAlarmParams(r12, r13, r14, r15, r17, r11.readString());
            int r19 = Math.min(r10, 0);
            ClassLoader r20 = Creator.class.getClassLoader();
        L17:
            if (r16 > r19) goto L19;
            r16 = r16 + 1;
        L19:
            if (r16 > r10) goto L21;
            a.d(r11, r20);
            r16 = r16 + 1;
            goto L19
        L21:
            return r18;
        L12:
            if (r11.readInt() == 0) goto L14;
            boolean r21 = true;
        L15:
            r17 = Boolean.valueOf(r21);
            goto L16
        L14:
            r21 = false;
            goto L15
        L5:
            int r22 = r11.readInt();
            r15 = new Integer[r22];
            int r23 = 0;
        L6:
            if (r23 == r22) goto L8;
            r15[r23] = Integer.valueOf(r11.readInt());
            r23 = r23 + 1;
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ClockUpdateAlarmParams[] newArray(int r10) {
            return new ClockUpdateAlarmParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockUpdateAlarmParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockUpdateAlarmParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public ClockUpdateAlarmParams() {
        AlarmEntity r10 = null;
        String r11 = null;
        String r12 = null;
        Integer[] r13 = null;
        Boolean r14 = null;
        String r15 = null;
        this(r10, r11, r12, r13, r14, r15, 63, null);
    }

    public static /* synthetic */ ClockUpdateAlarmParams copy$default(ClockUpdateAlarmParams r10, AlarmEntity r11, String r12, String r13, Integer[] r14, Boolean r15, String r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L6;
        r11 = r10.target;
    L6:
        if ((r17 & 2) == 0) goto L8;
        r12 = r10.time;
    L8:
        String r19 = r12;
        if ((r17 & 4) == 0) goto L11;
        r13 = r10.date;
    L11:
        String r20 = r13;
        if ((r17 & 8) == 0) goto L14;
        r14 = r10.repeatDayOfWeek;
    L14:
        Integer[] r21 = r14;
        if ((r17 & 16) == 0) goto L17;
        r15 = r10.closeInHoliday;
    L17:
        Boolean r22 = r15;
        if ((r17 & 32) == 0) goto L20;
        r16 = r10.name;
    L20:
        AlarmEntity r23 = r11;
        return r10.copy(r23, r19, r20, r21, r22, r16);
    }

    @Nullable
    public final AlarmEntity component1() {
        return this.target;
    }

    @Nullable
    public final String component2() {
        return this.time;
    }

    @Nullable
    public final String component3() {
        return this.date;
    }

    @Nullable
    public final Integer[] component4() {
        return this.repeatDayOfWeek;
    }

    @Nullable
    public final Boolean component5() {
        return this.closeInHoliday;
    }

    @Nullable
    public final String component6() {
        return this.name;
    }

    @NotNull
    public final ClockUpdateAlarmParams copy(@Nullable AlarmEntity r10, @Nullable String r11, @Nullable String r12, @Nullable Integer[] r13, @Nullable Boolean r14, @Nullable String r15) {
        return new ClockUpdateAlarmParams(r10, r11, r12, r13, r14, r15);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ClockUpdateAlarmParams) == true) goto L8;
        return false;
    L8:
        ClockUpdateAlarmParams r11 = (ClockUpdateAlarmParams) r10;
        if (q.b(this.target, r11.target) == true) goto L12;
        return false;
    L12:
        if (q.b(this.time, r11.time) == true) goto L15;
        return false;
    L15:
        if (q.b(this.date, r11.date) == true) goto L18;
        return false;
    L18:
        if (q.b(this.repeatDayOfWeek, r11.repeatDayOfWeek) == true) goto L21;
        return false;
    L21:
        if (q.b(this.closeInHoliday, r11.closeInHoliday) == true) goto L24;
        return false;
    L24:
        if (q.b(this.name, r11.name) == true) goto L26;
        return false;
    L26:
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
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final AlarmEntity getTarget() {
        return this.target;
    }

    @Nullable
    public final String getTime() {
        return this.time;
    }

    public int hashCode() {
        AlarmEntity r10 = this.target;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.time;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.date;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        Integer[] r20 = this.repeatDayOfWeek;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        Boolean r23 = this.closeInHoliday;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 31;
        String r26 = this.name;
        if (r26 == null) goto L27;
        r11 = r26.hashCode();
    L27:
        return r25 + r11;
    L21:
        r24 = r23.hashCode();
        goto L22
    L17:
        r21 = Arrays.hashCode(r20);
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
        if ((r10 instanceof ClockUpdateAlarmParams) == true) goto L5;
        return this;
    L5:
        AlarmEntity r11 = this.target;
        if (r11 != null) goto L8;
        r11 = ((ClockUpdateAlarmParams) r10).target;
    L8:
        AlarmEntity r12 = r11;
        String r13 = this.time;
        if (r13 != null) goto L11;
        r13 = ((ClockUpdateAlarmParams) r10).time;
    L11:
        String r14 = r13;
        String r15 = this.date;
        if (r15 != null) goto L14;
        r15 = ((ClockUpdateAlarmParams) r10).date;
    L14:
        String r16 = r15;
        Integer[] r17 = this.repeatDayOfWeek;
        if (r17 != null) goto L17;
        r17 = ((ClockUpdateAlarmParams) r10).repeatDayOfWeek;
    L17:
        Integer[] r18 = r17;
        Boolean r19 = this.closeInHoliday;
        if (r19 != null) goto L20;
        r19 = ((ClockUpdateAlarmParams) r10).closeInHoliday;
    L20:
        Boolean r20 = r19;
        String r21 = this.name;
        if (r21 != null) goto L24;
        r21 = ((ClockUpdateAlarmParams) r10).name;
    L24:
        return new ClockUpdateAlarmParams(r12, r14, r16, r18, r20, r21);
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

    public final void setTarget(@Nullable AlarmEntity r10) {
        this.target = r10;
    }

    public final void setTime(@Nullable String r10) {
        this.time = r10;
    }

    @NotNull
    public String toString() {
        return "ClockUpdateAlarmParams(target=" + this.target + ", time=" + this.time + ", date=" + this.date + ", repeatDayOfWeek=" + Arrays.toString(this.repeatDayOfWeek) + ", closeInHoliday=" + this.closeInHoliday + ", name=" + this.name + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeParcelable(this.target, r11);
        r10.writeString(this.time);
        r10.writeString(this.date);
        Integer[] r12 = this.repeatDayOfWeek;
        if (r12 != null) goto L5;
        r10.writeInt(0);
    L8:
        Boolean r13 = this.closeInHoliday;
        if (r13 != null) goto L11;
        r10.writeInt(0);
    L12:
        r10.writeString(this.name);
        return;
    L11:
        r10.writeInt(1);
        r10.writeInt(r13.booleanValue() ? 1 : 0);
        goto L12
    L5:
        r10.writeInt(1);
        int r14 = r12.length;
        r10.writeInt(r14);
        int r15 = 0;
    L6:
        if (r15 == r14) goto L8;
        r10.writeInt(r12[r15].intValue());
        r15 = r15 + 1;
        goto L6
    }

    public ClockUpdateAlarmParams(@Nullable AlarmEntity r10, @Nullable String r11, @Nullable String r12, @Nullable Integer[] r13, @Nullable Boolean r14, @Nullable String r15) {
        this.target = r10;
        this.time = r11;
        this.date = r12;
        this.repeatDayOfWeek = r13;
        this.closeInHoliday = r14;
        this.name = r15;
    }

    public /* synthetic */ ClockUpdateAlarmParams(AlarmEntity r10, String r11, String r12, Integer[] r13, Boolean r14, String r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r16 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r16 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r16 & 8) == 0) goto L15;
        r13 = null;
    L15:
        if ((r16 & 16) == 0) goto L18;
        r14 = null;
    L18:
        if ((r16 & 32) == 0) goto L20;
        r15 = null;
    L20:
        this(r10, r11, r12, r13, r14, r15);
    }
}
