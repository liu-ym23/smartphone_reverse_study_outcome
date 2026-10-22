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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ8\u0010\u0019\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\u0012\u0010!\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u001fH\u0016J\t\u0010#\u001a\u00020$HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001cHÖ\u0001R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ClockTurnOffAlarmParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "targets", "", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "turnOffAll", "", "always", "([Lcom/obric/capabilitykit/entity/app/AlarmEntity;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAlways", "()Ljava/lang/Boolean;", "setAlways", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTargets", "()[Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "setTargets", "([Lcom/obric/capabilitykit/entity/app/AlarmEntity;)V", "[Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "getTurnOffAll", "setTurnOffAll", "component1", "component2", "component3", "copy", "([Lcom/obric/capabilitykit/entity/app/AlarmEntity;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/ClockTurnOffAlarmParams;", "describeContents", "", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class ClockTurnOffAlarmParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<ClockTurnOffAlarmParams> CREATOR = null;

    @Nullable
    private Boolean always;

    @Nullable
    private AlarmEntity[] targets;

    @Nullable
    private Boolean turnOffAll;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ClockTurnOffAlarmParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ClockTurnOffAlarmParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            Boolean r12 = null;
            if (r10.readInt() != 0) goto L5;
            AlarmEntity[] r13 = null;
        L8:
            int r14 = 1;
            if (r10.readInt() != 0) goto L12;
            Boolean r15 = null;
        L17:
            if (r10.readInt() != 0) goto L20;
        L24:
            ClockTurnOffAlarmParams r16 = new ClockTurnOffAlarmParams(r13, r15, r12);
            int r17 = Math.min(r11, 0);
            ClassLoader r18 = Creator.class.getClassLoader();
        L25:
            if (r14 > r17) goto L27;
            r14 = r14 + 1;
        L27:
            if (r14 > r11) goto L29;
            a.d(r10, r18);
            r14 = r14 + 1;
            goto L27
        L29:
            return r16;
        L20:
            if (r10.readInt() == 0) goto L22;
            boolean r19 = true;
        L23:
            r12 = Boolean.valueOf(r19);
            goto L24
        L22:
            r19 = false;
            goto L23
        L12:
            if (r10.readInt() == 0) goto L14;
            boolean r20 = true;
        L15:
            r15 = Boolean.valueOf(r20);
            goto L17
        L14:
            r20 = false;
            goto L15
        L5:
            int r21 = r10.readInt();
            r13 = new AlarmEntity[r21];
            int r22 = 0;
        L6:
            if (r22 == r21) goto L8;
            r13[r22] = (AlarmEntity) r10.readParcelable(ClockTurnOffAlarmParams.class.getClassLoader());
            r22 = r22 + 1;
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ClockTurnOffAlarmParams[] newArray(int r10) {
            return new ClockTurnOffAlarmParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockTurnOffAlarmParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockTurnOffAlarmParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public ClockTurnOffAlarmParams() {
        AlarmEntity[] r10 = null;
        Boolean r11 = null;
        Boolean r12 = null;
        this(r10, r11, r12, 7, null);
    }

    public static /* synthetic */ ClockTurnOffAlarmParams copy$default(ClockTurnOffAlarmParams r10, AlarmEntity[] r11, Boolean r12, Boolean r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.targets;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.turnOffAll;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.always;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @Nullable
    public final AlarmEntity[] component1() {
        return this.targets;
    }

    @Nullable
    public final Boolean component2() {
        return this.turnOffAll;
    }

    @Nullable
    public final Boolean component3() {
        return this.always;
    }

    @NotNull
    public final ClockTurnOffAlarmParams copy(@Nullable AlarmEntity[] r10, @Nullable Boolean r11, @Nullable Boolean r12) {
        return new ClockTurnOffAlarmParams(r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ClockTurnOffAlarmParams) == true) goto L8;
        return false;
    L8:
        ClockTurnOffAlarmParams r11 = (ClockTurnOffAlarmParams) r10;
        if (q.b(this.targets, r11.targets) == true) goto L12;
        return false;
    L12:
        if (q.b(this.turnOffAll, r11.turnOffAll) == true) goto L15;
        return false;
    L15:
        if (q.b(this.always, r11.always) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Nullable
    public final Boolean getAlways() {
        return this.always;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final AlarmEntity[] getTargets() {
        return this.targets;
    }

    @Nullable
    public final Boolean getTurnOffAll() {
        return this.turnOffAll;
    }

    public int hashCode() {
        AlarmEntity[] r10 = this.targets;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        Boolean r14 = this.turnOffAll;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        Boolean r17 = this.always;
        if (r17 == null) goto L15;
        r11 = r17.hashCode();
    L15:
        return r16 + r11;
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = Arrays.hashCode(r10);
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof ClockTurnOffAlarmParams) == true) goto L5;
        return this;
    L5:
        AlarmEntity[] r11 = this.targets;
        if (r11 != null) goto L8;
        r11 = ((ClockTurnOffAlarmParams) r10).targets;
    L8:
        Boolean r12 = this.turnOffAll;
        if (r12 != null) goto L11;
        r12 = ((ClockTurnOffAlarmParams) r10).turnOffAll;
    L11:
        Boolean r13 = this.always;
        if (r13 != null) goto L15;
        r13 = ((ClockTurnOffAlarmParams) r10).always;
    L15:
        return new ClockTurnOffAlarmParams(r11, r12, r13);
    }

    public final void setAlways(@Nullable Boolean r10) {
        this.always = r10;
    }

    public final void setTargets(@Nullable AlarmEntity[] r10) {
        this.targets = r10;
    }

    public final void setTurnOffAll(@Nullable Boolean r10) {
        this.turnOffAll = r10;
    }

    @NotNull
    public String toString() {
        return "ClockTurnOffAlarmParams(targets=" + Arrays.toString(this.targets) + ", turnOffAll=" + this.turnOffAll + ", always=" + this.always + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        AlarmEntity[] r12 = this.targets;
        if (r12 != null) goto L5;
        r10.writeInt(0);
    L8:
        Boolean r13 = this.turnOffAll;
        if (r13 != null) goto L11;
        r10.writeInt(0);
    L12:
        Boolean r14 = this.always;
        if (r14 != null) goto L15;
        r10.writeInt(0);
        return;
    L15:
        r10.writeInt(1);
        r10.writeInt(r14.booleanValue() ? 1 : 0);
        return;
    L11:
        r10.writeInt(1);
        r10.writeInt(r13.booleanValue() ? 1 : 0);
        goto L12
    L5:
        r10.writeInt(1);
        int r15 = r12.length;
        r10.writeInt(r15);
        int r16 = 0;
    L6:
        if (r16 == r15) goto L8;
        r10.writeParcelable(r12[r16], r11);
        r16 = r16 + 1;
        goto L6
    }

    public ClockTurnOffAlarmParams(@Nullable AlarmEntity[] r10, @Nullable Boolean r11, @Nullable Boolean r12) {
        this.targets = r10;
        this.turnOffAll = r11;
        this.always = r12;
    }

    public /* synthetic */ ClockTurnOffAlarmParams(AlarmEntity[] r10, Boolean r11, Boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }
}
