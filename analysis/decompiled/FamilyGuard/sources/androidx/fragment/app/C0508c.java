package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: androidx.fragment.app.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0508c implements Parcelable {
    public static final Parcelable.Creator<C0508c> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    final List<String> f10534a;

    /* renamed from: b, reason: collision with root package name */
    final List<C0507b> f10535b;

    /* renamed from: androidx.fragment.app.c$a */
    class a implements Parcelable.Creator<C0508c> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0508c createFromParcel(Parcel parcel) {
            return new C0508c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0508c[] newArray(int i5) {
            return new C0508c[i5];
        }
    }

    C0508c(Parcel parcel) {
        this.f10534a = parcel.createStringArrayList();
        this.f10535b = parcel.createTypedArrayList(C0507b.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeStringList(this.f10534a);
        parcel.writeTypedList(this.f10535b);
    }
}
