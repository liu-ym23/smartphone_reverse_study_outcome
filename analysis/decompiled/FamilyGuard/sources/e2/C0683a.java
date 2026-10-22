package e2;

import android.os.Parcel;
import android.os.Parcelable;
import f2.C0711p;

/* renamed from: e2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0683a implements Parcelable {
    public static final Parcelable.Creator<C0683a> CREATOR = new C0210a();

    /* renamed from: a, reason: collision with root package name */
    public String f16648a;

    /* renamed from: b, reason: collision with root package name */
    public long f16649b;

    /* renamed from: c, reason: collision with root package name */
    public b f16650c;

    /* renamed from: e2.a$a, reason: collision with other inner class name */
    class C0210a implements Parcelable.Creator<C0683a> {
        C0210a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0683a createFromParcel(Parcel parcel) {
            return new C0683a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0683a[] newArray(int i5) {
            return new C0683a[i5];
        }
    }

    /* renamed from: e2.a$b */
    public enum b {
        START,
        STOP,
        DAY_START,
        DAY_END,
        QUERY_END
    }

    public C0683a(String str, long j5, b bVar) {
        this.f16648a = str;
        this.f16649b = j5;
        this.f16650c = bVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "Event{packageName ='" + this.f16648a + "', timeStamp = " + this.f16649b + " : " + C0711p.F(this.f16649b) + ", type=" + this.f16650c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.f16648a);
        parcel.writeLong(this.f16649b);
    }

    protected C0683a(Parcel parcel) {
        this.f16648a = parcel.readString();
        this.f16649b = parcel.readLong();
    }
}
