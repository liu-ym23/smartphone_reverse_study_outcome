package b3;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import u0.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends t3.b {
    public static final Parcelable.Creator<e> CREATOR = new p(1);

    /* renamed from: c, reason: collision with root package name */
    public SparseArray f1894c;

    public e(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i = parcel.readInt();
        int[] iArr = new int[i];
        parcel.readIntArray(iArr);
        Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
        this.f1894c = new SparseArray(i);
        for (int i3 = 0; i3 < i; i3++) {
            this.f1894c.append(iArr[i3], parcelableArray[i3]);
        }
    }

    @Override // t3.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        SparseArray sparseArray = this.f1894c;
        int size = sparseArray != null ? sparseArray.size() : 0;
        parcel.writeInt(size);
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = this.f1894c.keyAt(i3);
            parcelableArr[i3] = (Parcelable) this.f1894c.valueAt(i3);
        }
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i);
    }
}
