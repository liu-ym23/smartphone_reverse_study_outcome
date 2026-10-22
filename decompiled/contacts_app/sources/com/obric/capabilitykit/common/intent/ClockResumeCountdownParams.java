package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import com.obric.versionedparcelable.ParcelUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClockResumeCountdownParams.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ,\u0010\u0015\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0018HÖ\u0001J\u0012\u0010\u001d\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0016J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0018HÖ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006&"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ClockResumeCountdownParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "targets", "", "Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "resumeAll", "", "([Lcom/obric/capabilitykit/entity/app/CountdownEntity;Ljava/lang/Boolean;)V", "getResumeAll", "()Ljava/lang/Boolean;", "setResumeAll", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTargets", "()[Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "setTargets", "([Lcom/obric/capabilitykit/entity/app/CountdownEntity;)V", "[Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "component1", "component2", "copy", "([Lcom/obric/capabilitykit/entity/app/CountdownEntity;Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/ClockResumeCountdownParams;", "describeContents", "", "equals", "other", "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ClockResumeCountdownParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<ClockResumeCountdownParams> CREATOR = null;
    private Boolean resumeAll;
    private CountdownEntity[] targets;

    /* JADX INFO: compiled from: ClockResumeCountdownParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ClockResumeCountdownParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ClockResumeCountdownParams createFromParcel(Parcel r8) {
            int r0 = r8.readInt();
            Intrinsics.checkNotNullParameter(r8, "parcel");
            Boolean r2 = null;
            if (r8.readInt() != 0) goto L5;
            CountdownEntity[] r4 = null;
        L8:
            int r5 = 1;
            if (r8.readInt() != 0) goto L12;
        L16:
            ClockResumeCountdownParams r1 = new ClockResumeCountdownParams(r4, r2);
            int r3 = Math.min(r0, 0);
            ClassLoader r7 = getClass().getClassLoader();
        L17:
            if (r5 > r3) goto L19;
            r5 = r5 + 1;
        L19:
            if (r5 > r0) goto L21;
            ParcelUtils.skipValueSafely(r8, r7);
            r5 = r5 + 1;
            goto L19
        L21:
            return r1;
        L12:
            if (r8.readInt() == 0) goto L14;
            boolean r6 = true;
        L15:
            r2 = Boolean.valueOf(r6);
            goto L16
        L14:
            r6 = false;
            goto L15
        L5:
            int r9 = r8.readInt();
            r4 = new CountdownEntity[r9];
            int r10 = 0;
        L6:
            if (r10 == r9) goto L8;
            r4[r10] = (CountdownEntity) r8.readParcelable(ClockResumeCountdownParams.class.getClassLoader());
            r10 = r10 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockResumeCountdownParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ClockResumeCountdownParams[] newArray(int r1) {
            return new ClockResumeCountdownParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockResumeCountdownParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ClockResumeCountdownParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ClockResumeCountdownParams copy$default(ClockResumeCountdownParams r0, CountdownEntity[] r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.targets;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.resumeAll;
    L9:
        return r0.copy(r1, r2);
    }

    public final CountdownEntity[] component1() {
        return this.targets;
    }

    public final Boolean component2() {
        return this.resumeAll;
    }

    public final ClockResumeCountdownParams copy(CountdownEntity[] r1, Boolean r2) {
        return new ClockResumeCountdownParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ClockResumeCountdownParams) == true) goto L8;
        return false;
    L8:
        ClockResumeCountdownParams r6 = (ClockResumeCountdownParams) r5;
        if (Intrinsics.areEqual(this.targets, r6.targets) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.resumeAll, r6.resumeAll) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        CountdownEntity[] r0 = this.targets;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.resumeAll;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = Arrays.hashCode(r0);
        goto L6
    }

    public String toString() {
        return "ClockResumeCountdownParams(targets=" + Arrays.toString(this.targets) + ", resumeAll=" + this.resumeAll + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r7, int r8) {
        r7.writeInt(0);
        Intrinsics.checkNotNullParameter(r7, "out");
        CountdownEntity[] r1 = this.targets;
        if (r1 != null) goto L5;
        r7.writeInt(0);
    L8:
        Boolean r6 = this.resumeAll;
        if (r6 != null) goto L11;
        r7.writeInt(0);
        return;
    L11:
        r7.writeInt(1);
        r7.writeInt(r6.booleanValue() ? 1 : 0);
        return;
    L5:
        r7.writeInt(1);
        int r3 = r1.length;
        r7.writeInt(r3);
        int r4 = 0;
    L6:
        if (r4 == r3) goto L8;
        r7.writeParcelable(r1[r4], r8);
        r4 = r4 + 1;
        goto L6
    }

    public ClockResumeCountdownParams(CountdownEntity[] r1, Boolean r2) {
        this.targets = r1;
        this.resumeAll = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ ClockResumeCountdownParams(CountdownEntity[] r2, Boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final CountdownEntity[] getTargets() {
        return this.targets;
    }

    public final void setTargets(CountdownEntity[] r1) {
        this.targets = r1;
    }

    public final Boolean getResumeAll() {
        return this.resumeAll;
    }

    public final void setResumeAll(Boolean r1) {
        this.resumeAll = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r2) {
        if ((r2 instanceof ClockResumeCountdownParams) == false) goto L5;
        CountdownEntity[] r0 = this.targets;
        if (r0 != null) goto L9;
        r0 = ((ClockResumeCountdownParams) r2).targets;
    L9:
        Boolean r1 = this.resumeAll;
        if (r1 != null) goto L13;
        r1 = ((ClockResumeCountdownParams) r2).resumeAll;
    L13:
        return new ClockResumeCountdownParams(r0, r1);
    L5:
        return this;
    }
}
