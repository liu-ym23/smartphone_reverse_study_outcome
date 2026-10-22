package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import h0.InterfaceC0745a;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0745a f11601a;

    static class a implements Parcelable.Creator<ParcelImpl> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelImpl[] newArray(int i5) {
            return new ParcelImpl[i5];
        }
    }

    protected ParcelImpl(Parcel parcel) {
        this.f11601a = new b(parcel).u();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        new b(parcel).L(this.f11601a);
    }
}
