package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.versionedparcelable.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemGetAppLatestVersionParams.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\u0012\u0010\u0012\u001a\u00020\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0016J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fHÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001a"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemGetAppLatestVersionParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "packageName", "", "(Ljava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "setPackageName", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemGetAppLatestVersionParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemGetAppLatestVersionParams> CREATOR = null;
    private String packageName;

    /* JADX INFO: compiled from: SystemGetAppLatestVersionParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemGetAppLatestVersionParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemGetAppLatestVersionParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            Intrinsics.checkNotNullParameter(r5, "parcel");
            SystemGetAppLatestVersionParams r1 = new SystemGetAppLatestVersionParams(r5.readString());
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
        public /* bridge */ /* synthetic */ SystemGetAppLatestVersionParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemGetAppLatestVersionParams[] newArray(int r1) {
            return new SystemGetAppLatestVersionParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemGetAppLatestVersionParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemGetAppLatestVersionParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemGetAppLatestVersionParams copy$default(SystemGetAppLatestVersionParams r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.packageName;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.packageName;
    }

    public final SystemGetAppLatestVersionParams copy(String r1) {
        return new SystemGetAppLatestVersionParams(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof SystemGetAppLatestVersionParams) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.packageName, ((SystemGetAppLatestVersionParams) r4).packageName) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r0 = this.packageName;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "SystemGetAppLatestVersionParams(packageName=" + this.packageName + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.packageName);
    }

    public SystemGetAppLatestVersionParams(String r1) {
        this.packageName = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ SystemGetAppLatestVersionParams(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final void setPackageName(String r1) {
        this.packageName = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r2) {
        if ((r2 instanceof SystemGetAppLatestVersionParams) == false) goto L5;
        String r1 = this.packageName;
        if (r1 != null) goto L10;
        r1 = ((SystemGetAppLatestVersionParams) r2).packageName;
    L10:
        return new SystemGetAppLatestVersionParams(r1);
    L5:
        return this;
    }
}
