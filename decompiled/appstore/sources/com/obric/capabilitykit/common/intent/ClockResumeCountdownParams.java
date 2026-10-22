package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.entity.app.CountdownEntity;
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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ,\u0010\u0015\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0018HÖ\u0001J\u0012\u0010\u001d\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0016J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0018HÖ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006&"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ClockResumeCountdownParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "targets", "", "Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "resumeAll", "", "([Lcom/obric/capabilitykit/entity/app/CountdownEntity;Ljava/lang/Boolean;)V", "getResumeAll", "()Ljava/lang/Boolean;", "setResumeAll", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTargets", "()[Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "setTargets", "([Lcom/obric/capabilitykit/entity/app/CountdownEntity;)V", "[Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "component1", "component2", "copy", "([Lcom/obric/capabilitykit/entity/app/CountdownEntity;Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/ClockResumeCountdownParams;", "describeContents", "", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class ClockResumeCountdownParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<ClockResumeCountdownParams> CREATOR = null;

    @Nullable
    private Boolean resumeAll;

    @Nullable
    private CountdownEntity[] targets;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ClockResumeCountdownParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ClockResumeCountdownParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            Boolean r12 = null;
            if (r10.readInt() != 0) goto L5;
            CountdownEntity[] r13 = null;
        L8:
            int r14 = 1;
            if (r10.readInt() != 0) goto L12;
        L16:
            ClockResumeCountdownParams r15 = new ClockResumeCountdownParams(r13, r12);
            int r16 = Math.min(r11, 0);
            ClassLoader r17 = Creator.class.getClassLoader();
        L17:
            if (r14 > r16) goto L19;
            r14 = r14 + 1;
        L19:
            if (r14 > r11) goto L21;
            a.d(r10, r17);
            r14 = r14 + 1;
            goto L19
        L21:
            return r15;
        L12:
            if (r10.readInt() == 0) goto L14;
            boolean r18 = true;
        L15:
            r12 = Boolean.valueOf(r18);
            goto L16
        L14:
            r18 = false;
            goto L15
        L5:
            int r19 = r10.readInt();
            r13 = new CountdownEntity[r19];
            int r20 = 0;
        L6:
            if (r20 == r19) goto L8;
            r13[r20] = (CountdownEntity) r10.readParcelable(ClockResumeCountdownParams.class.getClassLoader());
            r20 = r20 + 1;
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ClockResumeCountdownParams[] newArray(int r10) {
            return new ClockResumeCountdownParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockResumeCountdownParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockResumeCountdownParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ClockResumeCountdownParams() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ClockResumeCountdownParams copy$default(ClockResumeCountdownParams r10, CountdownEntity[] r11, Boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.targets;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.resumeAll;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final CountdownEntity[] component1() {
        return this.targets;
    }

    @Nullable
    public final Boolean component2() {
        return this.resumeAll;
    }

    @NotNull
    public final ClockResumeCountdownParams copy(@Nullable CountdownEntity[] r10, @Nullable Boolean r11) {
        return new ClockResumeCountdownParams(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ClockResumeCountdownParams) == true) goto L8;
        return false;
    L8:
        ClockResumeCountdownParams r11 = (ClockResumeCountdownParams) r10;
        if (q.b(this.targets, r11.targets) == true) goto L12;
        return false;
    L12:
        if (q.b(this.resumeAll, r11.resumeAll) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final Boolean getResumeAll() {
        return this.resumeAll;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final CountdownEntity[] getTargets() {
        return this.targets;
    }

    public int hashCode() {
        CountdownEntity[] r10 = this.targets;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        Boolean r14 = this.resumeAll;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
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
        if ((r10 instanceof ClockResumeCountdownParams) == true) goto L5;
        return this;
    L5:
        CountdownEntity[] r11 = this.targets;
        if (r11 != null) goto L8;
        r11 = ((ClockResumeCountdownParams) r10).targets;
    L8:
        Boolean r12 = this.resumeAll;
        if (r12 != null) goto L12;
        r12 = ((ClockResumeCountdownParams) r10).resumeAll;
    L12:
        return new ClockResumeCountdownParams(r11, r12);
    }

    public final void setResumeAll(@Nullable Boolean r10) {
        this.resumeAll = r10;
    }

    public final void setTargets(@Nullable CountdownEntity[] r10) {
        this.targets = r10;
    }

    @NotNull
    public String toString() {
        return "ClockResumeCountdownParams(targets=" + Arrays.toString(this.targets) + ", resumeAll=" + this.resumeAll + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        CountdownEntity[] r12 = this.targets;
        if (r12 != null) goto L5;
        r10.writeInt(0);
    L8:
        Boolean r13 = this.resumeAll;
        if (r13 != null) goto L11;
        r10.writeInt(0);
        return;
    L11:
        r10.writeInt(1);
        r10.writeInt(r13.booleanValue() ? 1 : 0);
        return;
    L5:
        r10.writeInt(1);
        int r14 = r12.length;
        r10.writeInt(r14);
        int r15 = 0;
    L6:
        if (r15 == r14) goto L8;
        r10.writeParcelable(r12[r15], r11);
        r15 = r15 + 1;
        goto L6
    }

    public ClockResumeCountdownParams(@Nullable CountdownEntity[] r10, @Nullable Boolean r11) {
        this.targets = r10;
        this.resumeAll = r11;
    }

    public /* synthetic */ ClockResumeCountdownParams(CountdownEntity[] r10, Boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
