package androidx.compose.runtime;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class ParcelableSnapshotMutableLongState extends l implements Parcelable {
    public static final b Companion = new b();
    public static final Parcelable.Creator<ParcelableSnapshotMutableLongState> CREATOR = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<ParcelableSnapshotMutableLongState> {
        @Override // android.os.Parcelable.Creator
        public final ParcelableSnapshotMutableLongState createFromParcel(Parcel parcel) {
            return new ParcelableSnapshotMutableLongState(parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final ParcelableSnapshotMutableLongState[] newArray(int i10) {
            return new ParcelableSnapshotMutableLongState[i10];
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {
    }

    public ParcelableSnapshotMutableLongState(long j10) {
        super(j10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // androidx.compose.runtime.d
    public /* bridge */ /* synthetic */ Long getValue() {
        return super.getValue();
    }

    @Override // androidx.compose.runtime.d
    public /* bridge */ /* synthetic */ void setValue(Object obj) {
        super.setValue(obj);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(getLongValue());
    }

    /* renamed from: getValue, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3getValue() {
        return getValue();
    }

    @Override // androidx.compose.runtime.d
    public void setValue(long j10) {
        setLongValue(j10);
    }
}
