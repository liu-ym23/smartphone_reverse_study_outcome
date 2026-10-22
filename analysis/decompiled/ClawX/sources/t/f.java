package t;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import g.c2;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f extends h0.b {
    public static final Parcelable.Creator<f> CREATOR = new c2(5);

    /* renamed from: c, reason: collision with root package name */
    public SparseArray f5404c;

    public f(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i8 = parcel.readInt();
        int[] iArr = new int[i8];
        parcel.readIntArray(iArr);
        Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
        this.f5404c = new SparseArray(i8);
        for (int i9 = 0; i9 < i8; i9++) {
            this.f5404c.append(iArr[i9], parcelableArray[i9]);
        }
    }

    @Override // h0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        super.writeToParcel(parcel, i8);
        SparseArray sparseArray = this.f5404c;
        int size = sparseArray != null ? sparseArray.size() : 0;
        parcel.writeInt(size);
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        for (int i9 = 0; i9 < size; i9++) {
            iArr[i9] = this.f5404c.keyAt(i9);
            parcelableArr[i9] = (Parcelable) this.f5404c.valueAt(i9);
        }
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i8);
    }
}
