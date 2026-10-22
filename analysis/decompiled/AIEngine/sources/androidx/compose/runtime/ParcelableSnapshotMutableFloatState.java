package androidx.compose.runtime;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class ParcelableSnapshotMutableFloatState extends j implements Parcelable {
    public static final b Companion = new b();
    public static final Parcelable.Creator<ParcelableSnapshotMutableFloatState> CREATOR = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<ParcelableSnapshotMutableFloatState> {
        @Override // android.os.Parcelable.Creator
        public final ParcelableSnapshotMutableFloatState createFromParcel(Parcel parcel) {
            return new ParcelableSnapshotMutableFloatState(parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        public final ParcelableSnapshotMutableFloatState[] newArray(int i10) {
            return new ParcelableSnapshotMutableFloatState[i10];
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {
    }

    public ParcelableSnapshotMutableFloatState(float f8) {
        super(f8);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // androidx.compose.runtime.b
    public /* bridge */ /* synthetic */ Float getValue() {
        return super.getValue();
    }

    @Override // androidx.compose.runtime.b
    public /* bridge */ /* synthetic */ void setValue(Object obj) {
        super.setValue(obj);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(getFloatValue());
    }

    /* renamed from: getValue, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1getValue() {
        return getValue();
    }

    @Override // androidx.compose.runtime.b
    public void setValue(float f8) {
        setFloatValue(f8);
    }
}
