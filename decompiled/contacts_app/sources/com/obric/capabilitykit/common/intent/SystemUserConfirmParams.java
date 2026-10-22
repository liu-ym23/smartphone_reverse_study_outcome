package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.versionedparcelable.ParcelUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemUserConfirmParams.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J,\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\u0012\u0010\u001c\u001a\u00020\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001aH\u0016J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0016HÖ\u0001R$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemUserConfirmParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "candidates", "", "", "confirmIntent", "([Ljava/lang/String;Ljava/lang/String;)V", "getCandidates", "()[Ljava/lang/String;", "setCandidates", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getConfirmIntent", "()Ljava/lang/String;", "setConfirmIntent", "(Ljava/lang/String;)V", "component1", "component2", "copy", "([Ljava/lang/String;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/SystemUserConfirmParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemUserConfirmParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemUserConfirmParams> CREATOR = null;
    private String[] candidates;
    private String confirmIntent;

    /* JADX INFO: compiled from: SystemUserConfirmParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemUserConfirmParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemUserConfirmParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            Intrinsics.checkNotNullParameter(r5, "parcel");
            SystemUserConfirmParams r1 = new SystemUserConfirmParams(r5.createStringArray(), r5.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r4 = getClass().getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r2) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r0) goto L7;
            ParcelUtils.skipValueSafely(r5, r4);
            r3 = r3 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemUserConfirmParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemUserConfirmParams[] newArray(int r1) {
            return new SystemUserConfirmParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemUserConfirmParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemUserConfirmParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemUserConfirmParams copy$default(SystemUserConfirmParams r0, String[] r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.candidates;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.confirmIntent;
    L9:
        return r0.copy(r1, r2);
    }

    public final String[] component1() {
        return this.candidates;
    }

    public final String component2() {
        return this.confirmIntent;
    }

    public final SystemUserConfirmParams copy(String[] r1, String r2) {
        return new SystemUserConfirmParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SystemUserConfirmParams) == true) goto L8;
        return false;
    L8:
        SystemUserConfirmParams r6 = (SystemUserConfirmParams) r5;
        if (Intrinsics.areEqual(this.candidates, r6.candidates) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.confirmIntent, r6.confirmIntent) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String[] r0 = this.candidates;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.confirmIntent;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = Arrays.hashCode(r0);
        goto L6
    }

    public String toString() {
        return "SystemUserConfirmParams(candidates=" + Arrays.toString(this.candidates) + ", confirmIntent=" + this.confirmIntent + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeStringArray(this.candidates);
        r1.writeString(this.confirmIntent);
    }

    public SystemUserConfirmParams(String[] r1, String r2) {
        this.candidates = r1;
        this.confirmIntent = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ SystemUserConfirmParams(String[] r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String[] getCandidates() {
        return this.candidates;
    }

    public final void setCandidates(String[] r1) {
        this.candidates = r1;
    }

    public final String getConfirmIntent() {
        return this.confirmIntent;
    }

    public final void setConfirmIntent(String r1) {
        this.confirmIntent = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r2) {
        if ((r2 instanceof SystemUserConfirmParams) == false) goto L5;
        String[] r0 = this.candidates;
        if (r0 != null) goto L9;
        r0 = ((SystemUserConfirmParams) r2).candidates;
    L9:
        String r1 = this.confirmIntent;
        if (r1 != null) goto L13;
        r1 = ((SystemUserConfirmParams) r2).confirmIntent;
    L13:
        return new SystemUserConfirmParams(r0, r1);
    L5:
        return this;
    }
}
