package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.versionedparcelable.ParcelUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClockUpdateAlarmParams.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BS\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000eJ\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010)\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\\\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010,J\t\u0010-\u001a\u00020\nHÖ\u0001J\u0013\u0010.\u001a\u00020\f2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\nHÖ\u0001J\u0012\u00102\u001a\u00020\u00012\b\u00103\u001a\u0004\u0018\u000100H\u0016J\t\u00104\u001a\u00020\u0006HÖ\u0001J\u0019\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\nHÖ\u0001R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017¨\u0006:"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ClockUpdateAlarmParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "target", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", DBHelper.COL_TIME, "", "date", "repeatDayOfWeek", "", "", "closeInHoliday", "", "name", "(Lcom/obric/capabilitykit/entity/app/AlarmEntity;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;)V", "getCloseInHoliday", "()Ljava/lang/Boolean;", "setCloseInHoliday", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getName", "setName", "getRepeatDayOfWeek", "()[Ljava/lang/Integer;", "setRepeatDayOfWeek", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "getTarget", "()Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "setTarget", "(Lcom/obric/capabilitykit/entity/app/AlarmEntity;)V", "getTime", "setTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/obric/capabilitykit/entity/app/AlarmEntity;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/ClockUpdateAlarmParams;", "describeContents", "equals", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ClockUpdateAlarmParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<ClockUpdateAlarmParams> CREATOR = null;
    private Boolean closeInHoliday;
    private String date;
    private String name;
    private Integer[] repeatDayOfWeek;
    private AlarmEntity target;
    private String time;

    /* JADX INFO: compiled from: ClockUpdateAlarmParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ClockUpdateAlarmParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ClockUpdateAlarmParams createFromParcel(Parcel r12) {
            int r0 = r12.readInt();
            Intrinsics.checkNotNullParameter(r12, "parcel");
            AlarmEntity r3 = (AlarmEntity) r12.readParcelable(ClockUpdateAlarmParams.class.getClassLoader());
            String r4 = r12.readString();
            String r5 = r12.readString();
            if (r12.readInt() != 0) goto L5;
            Integer[] r6 = null;
        L8:
            int r10 = 1;
            if (r12.readInt() != 0) goto L12;
            Boolean r7 = null;
        L16:
            ClockUpdateAlarmParams r1 = new ClockUpdateAlarmParams(r3, r4, r5, r6, r7, r12.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r11 = getClass().getClassLoader();
        L17:
            if (r10 > r2) goto L19;
            r10 = r10 + 1;
        L19:
            if (r10 > r0) goto L21;
            ParcelUtils.skipValueSafely(r12, r11);
            r10 = r10 + 1;
            goto L19
        L21:
            return r1;
        L12:
            if (r12.readInt() == 0) goto L14;
            boolean r8 = true;
        L15:
            r7 = Boolean.valueOf(r8);
            goto L16
        L14:
            r8 = false;
            goto L15
        L5:
            int r9 = r12.readInt();
            r6 = new Integer[r9];
            int r13 = 0;
        L6:
            if (r13 == r9) goto L8;
            r6[r13] = Integer.valueOf(r12.readInt());
            r13 = r13 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockUpdateAlarmParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ClockUpdateAlarmParams[] newArray(int r1) {
            return new ClockUpdateAlarmParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockUpdateAlarmParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public ClockUpdateAlarmParams() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ ClockUpdateAlarmParams copy$default(ClockUpdateAlarmParams r4, AlarmEntity r5, String r6, String r7, Integer[] r8, Boolean r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.target;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.time;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.date;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.repeatDayOfWeek;
    L14:
        Integer[] r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.closeInHoliday;
    L17:
        Boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.name;
    L20:
        AlarmEntity r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final AlarmEntity component1() {
        return this.target;
    }

    public final String component2() {
        return this.time;
    }

    public final String component3() {
        return this.date;
    }

    public final Integer[] component4() {
        return this.repeatDayOfWeek;
    }

    public final Boolean component5() {
        return this.closeInHoliday;
    }

    public final String component6() {
        return this.name;
    }

    public final ClockUpdateAlarmParams copy(AlarmEntity r8, String r9, String r10, Integer[] r11, Boolean r12, String r13) {
        return new ClockUpdateAlarmParams(r8, r9, r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ClockUpdateAlarmParams) == true) goto L8;
        return false;
    L8:
        ClockUpdateAlarmParams r6 = (ClockUpdateAlarmParams) r5;
        if (Intrinsics.areEqual(this.target, r6.target) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.time, r6.time) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.date, r6.date) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.repeatDayOfWeek, r6.repeatDayOfWeek) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.closeInHoliday, r6.closeInHoliday) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        AlarmEntity r0 = this.target;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.time;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.date;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer[] r10 = this.repeatDayOfWeek;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.closeInHoliday;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.name;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
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
        return "ClockUpdateAlarmParams(target=" + this.target + ", time=" + this.time + ", date=" + this.date + ", repeatDayOfWeek=" + Arrays.toString(this.repeatDayOfWeek) + ", closeInHoliday=" + this.closeInHoliday + ", name=" + this.name + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r6, int r7) {
        r6.writeInt(0);
        Intrinsics.checkNotNullParameter(r6, "out");
        r6.writeParcelable(this.target, r7);
        r6.writeString(this.time);
        r6.writeString(this.date);
        Integer[] r8 = this.repeatDayOfWeek;
        if (r8 != null) goto L5;
        r6.writeInt(0);
    L8:
        Boolean r9 = this.closeInHoliday;
        if (r9 != null) goto L11;
        r6.writeInt(0);
    L12:
        r6.writeString(this.name);
        return;
    L11:
        r6.writeInt(1);
        r6.writeInt(r9.booleanValue() ? 1 : 0);
        goto L12
    L5:
        r6.writeInt(1);
        int r2 = r8.length;
        r6.writeInt(r2);
        int r3 = 0;
    L6:
        if (r3 == r2) goto L8;
        r6.writeInt(r8[r3].intValue());
        r3 = r3 + 1;
        goto L6
    }

    public ClockUpdateAlarmParams(AlarmEntity r1, String r2, String r3, Integer[] r4, Boolean r5, String r6) {
        this.target = r1;
        this.time = r2;
        this.date = r3;
        this.repeatDayOfWeek = r4;
        this.closeInHoliday = r5;
        this.name = r6;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ ClockUpdateAlarmParams(AlarmEntity r2, String r3, String r4, Integer[] r5, Boolean r6, String r7, int r8, DefaultConstructorMarker r9) {
        if ((r8 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r8 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r8 & 32) == 0) goto L20;
        r7 = null;
    L20:
        this(r2, r3, r4, r5, r6, r7);
    }

    public final AlarmEntity getTarget() {
        return this.target;
    }

    public final void setTarget(AlarmEntity r1) {
        this.target = r1;
    }

    public final String getTime() {
        return this.time;
    }

    public final void setTime(String r1) {
        this.time = r1;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String r1) {
        this.date = r1;
    }

    public final Integer[] getRepeatDayOfWeek() {
        return this.repeatDayOfWeek;
    }

    public final void setRepeatDayOfWeek(Integer[] r1) {
        this.repeatDayOfWeek = r1;
    }

    public final Boolean getCloseInHoliday() {
        return this.closeInHoliday;
    }

    public final void setCloseInHoliday(Boolean r1) {
        this.closeInHoliday = r1;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r9) {
        if ((r9 instanceof ClockUpdateAlarmParams) == false) goto L5;
        AlarmEntity r0 = this.target;
        if (r0 != null) goto L9;
        r0 = ((ClockUpdateAlarmParams) r9).target;
    L9:
        AlarmEntity r2 = r0;
        String r1 = this.time;
        if (r1 != null) goto L12;
        r1 = ((ClockUpdateAlarmParams) r9).time;
    L12:
        String r3 = r1;
        String r4 = this.date;
        if (r4 != null) goto L15;
        r4 = ((ClockUpdateAlarmParams) r9).date;
    L15:
        String r5 = r4;
        Integer[] r6 = this.repeatDayOfWeek;
        if (r6 != null) goto L18;
        r6 = ((ClockUpdateAlarmParams) r9).repeatDayOfWeek;
    L18:
        Integer[] r7 = r6;
        Boolean r8 = this.closeInHoliday;
        if (r8 != null) goto L21;
        r8 = ((ClockUpdateAlarmParams) r9).closeInHoliday;
    L21:
        Boolean r10 = r8;
        String r11 = this.name;
        if (r11 != null) goto L25;
        r11 = ((ClockUpdateAlarmParams) r9).name;
    L25:
        return new ClockUpdateAlarmParams(r2, r3, r5, r7, r10, r11);
    L5:
        return this;
    }
}
