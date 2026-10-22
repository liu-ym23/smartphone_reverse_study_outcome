package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.x;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class z implements Parcelable {
    public static final Parcelable.Creator<z> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    ArrayList<String> f10785a;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<String> f10786b;

    /* renamed from: c, reason: collision with root package name */
    C0507b[] f10787c;

    /* renamed from: d, reason: collision with root package name */
    int f10788d;

    /* renamed from: e, reason: collision with root package name */
    String f10789e;

    /* renamed from: f, reason: collision with root package name */
    ArrayList<String> f10790f;

    /* renamed from: g, reason: collision with root package name */
    ArrayList<C0508c> f10791g;

    /* renamed from: h, reason: collision with root package name */
    ArrayList<x.k> f10792h;

    class a implements Parcelable.Creator<z> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public z createFromParcel(Parcel parcel) {
            return new z(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public z[] newArray(int i5) {
            return new z[i5];
        }
    }

    public z() {
        this.f10789e = null;
        this.f10790f = new ArrayList<>();
        this.f10791g = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeStringList(this.f10785a);
        parcel.writeStringList(this.f10786b);
        parcel.writeTypedArray(this.f10787c, i5);
        parcel.writeInt(this.f10788d);
        parcel.writeString(this.f10789e);
        parcel.writeStringList(this.f10790f);
        parcel.writeTypedList(this.f10791g);
        parcel.writeTypedList(this.f10792h);
    }

    public z(Parcel parcel) {
        this.f10789e = null;
        this.f10790f = new ArrayList<>();
        this.f10791g = new ArrayList<>();
        this.f10785a = parcel.createStringArrayList();
        this.f10786b = parcel.createStringArrayList();
        this.f10787c = (C0507b[]) parcel.createTypedArray(C0507b.CREATOR);
        this.f10788d = parcel.readInt();
        this.f10789e = parcel.readString();
        this.f10790f = parcel.createStringArrayList();
        this.f10791g = parcel.createTypedArrayList(C0508c.CREATOR);
        this.f10792h = parcel.createTypedArrayList(x.k.CREATOR);
    }
}
