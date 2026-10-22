package v1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import q.i;

/* renamed from: v1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1181a extends androidx.customview.view.a {
    public static final Parcelable.Creator<C1181a> CREATOR = new C0252a();

    /* renamed from: a, reason: collision with root package name */
    public final i<String, Bundle> f23309a;

    /* renamed from: v1.a$a, reason: collision with other inner class name */
    class C0252a implements Parcelable.ClassLoaderCreator<C1181a> {
        C0252a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C1181a createFromParcel(Parcel parcel) {
            return new C1181a(parcel, null, 0 == true ? 1 : 0);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C1181a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new C1181a(parcel, classLoader, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public C1181a[] newArray(int i5) {
            return new C1181a[i5];
        }
    }

    /* synthetic */ C1181a(Parcel parcel, ClassLoader classLoader, C0252a c0252a) {
        this(parcel, classLoader);
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f23309a + "}";
    }

    @Override // androidx.customview.view.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        int size = this.f23309a.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i6 = 0; i6 < size; i6++) {
            strArr[i6] = this.f23309a.f(i6);
            bundleArr[i6] = this.f23309a.j(i6);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public C1181a(Parcelable parcelable) {
        super(parcelable);
        this.f23309a = new i<>();
    }

    private C1181a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i5 = parcel.readInt();
        String[] strArr = new String[i5];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[i5];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f23309a = new i<>(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            this.f23309a.put(strArr[i6], bundleArr[i6]);
        }
    }
}
