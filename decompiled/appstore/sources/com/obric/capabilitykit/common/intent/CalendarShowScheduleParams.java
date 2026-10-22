package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fHÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/obric/capabilitykit/common/intent/CalendarShowScheduleParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "target", "Lcom/obric/capabilitykit/entity/app/ScheduleEntity;", "(Lcom/obric/capabilitykit/entity/app/ScheduleEntity;)V", "getTarget", "()Lcom/obric/capabilitykit/entity/app/ScheduleEntity;", "setTarget", "component1", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class CalendarShowScheduleParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<CalendarShowScheduleParams> CREATOR = null;

    @Nullable
    private ScheduleEntity target;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CalendarShowScheduleParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CalendarShowScheduleParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            CalendarShowScheduleParams r12 = new CalendarShowScheduleParams((ScheduleEntity) r10.readParcelable(CalendarShowScheduleParams.class.getClassLoader()));
            int r13 = Math.min(r11, 0);
            ClassLoader r14 = Creator.class.getClassLoader();
            int r15 = 1;
        L3:
            if (r15 > r13) goto L5;
            r15 = r15 + 1;
        L5:
            if (r15 > r11) goto L7;
            a.d(r10, r14);
            r15 = r15 + 1;
            goto L5
        L7:
            return r12;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CalendarShowScheduleParams[] newArray(int r10) {
            return new CalendarShowScheduleParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CalendarShowScheduleParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CalendarShowScheduleParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CalendarShowScheduleParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CalendarShowScheduleParams copy$default(CalendarShowScheduleParams r10, ScheduleEntity r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = r10.target;
    L6:
        return r10.copy(r11);
    }

    @Nullable
    public final ScheduleEntity component1() {
        return this.target;
    }

    @NotNull
    public final CalendarShowScheduleParams copy(@Nullable ScheduleEntity r10) {
        return new CalendarShowScheduleParams(r10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof CalendarShowScheduleParams) == true) goto L9;
        return false;
    L9:
        if (q.b(this.target, ((CalendarShowScheduleParams) r10).target) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final ScheduleEntity getTarget() {
        return this.target;
    }

    public int hashCode() {
        ScheduleEntity r10 = this.target;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.target == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof CalendarShowScheduleParams) == true) goto L5;
        return this;
    L5:
        ScheduleEntity r11 = this.target;
        if (r11 != null) goto L9;
        r11 = ((CalendarShowScheduleParams) r10).target;
    L9:
        return new CalendarShowScheduleParams(r11);
    }

    public final void setTarget(@Nullable ScheduleEntity r10) {
        this.target = r10;
    }

    @NotNull
    public String toString() {
        return "CalendarShowScheduleParams(target=" + this.target + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeParcelable(this.target, r11);
    }

    public CalendarShowScheduleParams(@Nullable ScheduleEntity r10) {
        this.target = r10;
    }

    public /* synthetic */ CalendarShowScheduleParams(ScheduleEntity r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = null;
    L5:
        this(r10);
    }
}
