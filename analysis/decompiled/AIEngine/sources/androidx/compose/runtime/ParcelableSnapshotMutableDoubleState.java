package androidx.compose.runtime;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class ParcelableSnapshotMutableDoubleState extends h implements Parcelable {
    public static final b Companion = new b();
    public static final Parcelable.Creator<ParcelableSnapshotMutableDoubleState> CREATOR = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<ParcelableSnapshotMutableDoubleState> {
        @Override // android.os.Parcelable.Creator
        public final ParcelableSnapshotMutableDoubleState createFromParcel(Parcel parcel) {
            return new ParcelableSnapshotMutableDoubleState(parcel.readDouble());
        }

        @Override // android.os.Parcelable.Creator
        public final ParcelableSnapshotMutableDoubleState[] newArray(int i10) {
            return new ParcelableSnapshotMutableDoubleState[i10];
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {
    }

    public ParcelableSnapshotMutableDoubleState(double d8) {
        super(d8);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // androidx.compose.runtime.a
    public /* bridge */ /* synthetic */ Double getValue() {
        return super.getValue();
    }

    @Override // androidx.compose.runtime.a
    public /* bridge */ /* synthetic */ void setValue(Object obj) {
        super.setValue(obj);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeDouble(getDoubleValue());
    }

    /* renamed from: getValue, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m0getValue() {
        return getValue();
    }

    @Override // androidx.compose.runtime.a
    public void setValue(double d8) {
        setDoubleValue(d8);
    }
}
