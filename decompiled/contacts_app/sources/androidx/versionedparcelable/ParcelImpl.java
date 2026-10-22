package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = null;
    private final VersionedParcelable mParcel;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ParcelImpl(VersionedParcelable r1) {
        this.mParcel = r1;
    }

    protected ParcelImpl(Parcel r2) {
        this.mParcel = new VersionedParcelParcel(r2).readVersionedParcelable();
    }

    public <T extends VersionedParcelable> T getVersionedParcel() {
        return (T) this.mParcel;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        new VersionedParcelParcel(r1).writeVersionedParcelable(this.mParcel);
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
