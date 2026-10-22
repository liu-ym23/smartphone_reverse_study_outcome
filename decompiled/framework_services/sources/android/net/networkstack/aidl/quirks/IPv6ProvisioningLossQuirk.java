package android.net.networkstack.aidl.quirks;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class IPv6ProvisioningLossQuirk {
    public final int mDetectionCount;
    public final long mQuirkExpiry;

    public IPv6ProvisioningLossQuirk(int count, long expiry) {
        this.mDetectionCount = count;
        this.mQuirkExpiry = expiry;
    }

    public IPv6ProvisioningLossQuirkParcelable toStableParcelable() {
        IPv6ProvisioningLossQuirkParcelable p = new IPv6ProvisioningLossQuirkParcelable();
        p.detectionCount = this.mDetectionCount;
        p.quirkExpiry = this.mQuirkExpiry;
        return p;
    }

    public static IPv6ProvisioningLossQuirk fromStableParcelable(IPv6ProvisioningLossQuirkParcelable p) {
        if (p != null) goto L6;
        return null;
    L6:
        return new IPv6ProvisioningLossQuirk(p.detectionCount, p.quirkExpiry);
    }

    public boolean equals(Object obj) {
        if (obj != null) goto L5;
    L13:
        return false;
    L5:
        if (getClass() != obj.getClass()) goto L13;
        IPv6ProvisioningLossQuirk other = (IPv6ProvisioningLossQuirk) obj;
        if (this.mDetectionCount == other.mDetectionCount) goto L10;
        return false;
    L10:
        if (this.mQuirkExpiry != other.mQuirkExpiry) goto L15;
        return true;
    L15:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.mDetectionCount), Long.valueOf(this.mQuirkExpiry)});
    }

    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("detection count: ");
        str.append(this.mDetectionCount);
        str.append(", quirk expiry: ");
        str.append(this.mQuirkExpiry);
        return str.toString();
    }
}
