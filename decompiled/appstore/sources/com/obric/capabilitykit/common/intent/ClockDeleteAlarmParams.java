package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.entity.app.AlarmEntity;
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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0016HÖ\u0001J\u0012\u0010\u001b\u001a\u00020\u00012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ClockDeleteAlarmParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "target", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "deleteAll", "", "(Lcom/obric/capabilitykit/entity/app/AlarmEntity;Ljava/lang/Boolean;)V", "getDeleteAll", "()Ljava/lang/Boolean;", "setDeleteAll", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTarget", "()Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "setTarget", "(Lcom/obric/capabilitykit/entity/app/AlarmEntity;)V", "component1", "component2", "copy", "(Lcom/obric/capabilitykit/entity/app/AlarmEntity;Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/ClockDeleteAlarmParams;", "describeContents", "", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class ClockDeleteAlarmParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<ClockDeleteAlarmParams> CREATOR = null;

    @Nullable
    private Boolean deleteAll;

    @Nullable
    private AlarmEntity target;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ClockDeleteAlarmParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ClockDeleteAlarmParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            AlarmEntity r12 = (AlarmEntity) r10.readParcelable(ClockDeleteAlarmParams.class.getClassLoader());
            int r13 = 1;
            if (r10.readInt() != 0) goto L6;
            Boolean r14 = null;
        L10:
            ClockDeleteAlarmParams r15 = new ClockDeleteAlarmParams(r12, r14);
            int r16 = Math.min(r11, 0);
            ClassLoader r17 = Creator.class.getClassLoader();
        L11:
            if (r13 > r16) goto L13;
            r13 = r13 + 1;
        L13:
            if (r13 > r11) goto L15;
            a.d(r10, r17);
            r13 = r13 + 1;
            goto L13
        L15:
            return r15;
        L6:
            if (r10.readInt() == 0) goto L8;
            boolean r18 = true;
        L9:
            r14 = Boolean.valueOf(r18);
            goto L10
        L8:
            r18 = false;
            goto L9
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ClockDeleteAlarmParams[] newArray(int r10) {
            return new ClockDeleteAlarmParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockDeleteAlarmParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockDeleteAlarmParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ClockDeleteAlarmParams() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ClockDeleteAlarmParams copy$default(ClockDeleteAlarmParams r10, AlarmEntity r11, Boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.target;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.deleteAll;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final AlarmEntity component1() {
        return this.target;
    }

    @Nullable
    public final Boolean component2() {
        return this.deleteAll;
    }

    @NotNull
    public final ClockDeleteAlarmParams copy(@Nullable AlarmEntity r10, @Nullable Boolean r11) {
        return new ClockDeleteAlarmParams(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ClockDeleteAlarmParams) == true) goto L8;
        return false;
    L8:
        ClockDeleteAlarmParams r11 = (ClockDeleteAlarmParams) r10;
        if (q.b(this.target, r11.target) == true) goto L12;
        return false;
    L12:
        if (q.b(this.deleteAll, r11.deleteAll) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final Boolean getDeleteAll() {
        return this.deleteAll;
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

    public int hashCode() {
        AlarmEntity r10 = this.target;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        Boolean r14 = this.deleteAll;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
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
        if ((r10 instanceof ClockDeleteAlarmParams) == true) goto L5;
        return this;
    L5:
        AlarmEntity r11 = this.target;
        if (r11 != null) goto L8;
        r11 = ((ClockDeleteAlarmParams) r10).target;
    L8:
        Boolean r12 = this.deleteAll;
        if (r12 != null) goto L12;
        r12 = ((ClockDeleteAlarmParams) r10).deleteAll;
    L12:
        return new ClockDeleteAlarmParams(r11, r12);
    }

    public final void setDeleteAll(@Nullable Boolean r10) {
        this.deleteAll = r10;
    }

    public final void setTarget(@Nullable AlarmEntity r10) {
        this.target = r10;
    }

    @NotNull
    public String toString() {
        return "ClockDeleteAlarmParams(target=" + this.target + ", deleteAll=" + this.deleteAll + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeParcelable(this.target, r11);
        Boolean r12 = this.deleteAll;
        if (r12 != null) goto L5;
        r10.writeInt(0);
        return;
    L5:
        r10.writeInt(1);
        r10.writeInt(r12.booleanValue() ? 1 : 0);
    }

    public ClockDeleteAlarmParams(@Nullable AlarmEntity r10, @Nullable Boolean r11) {
        this.target = r10;
        this.deleteAll = r11;
    }

    public /* synthetic */ ClockDeleteAlarmParams(AlarmEntity r10, Boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
