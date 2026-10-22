package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes17.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = null;
    private final VersionedParcelable mParcel;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public <T extends VersionedParcelable> T getVersionedParcel() {
        return (T) this.mParcel;
    }

    public ParcelImpl(Parcel r100) {
        this.mParcel = new VersionedParcelParcel(r100).readVersionedParcelable();
    }

    public ParcelImpl(VersionedParcelable r100) {
        this.mParcel = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        new VersionedParcelParcel(r100).writeVersionedParcelable(this.mParcel);
    }
}
