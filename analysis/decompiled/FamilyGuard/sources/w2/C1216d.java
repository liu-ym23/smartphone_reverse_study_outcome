package w2;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.digitalwellbeing.server.data.PackageLimitInfo;
import com.stepos.digitalwellbeing.server.data.PackageUsingTimeStats;
import com.stepos.digitalwellbeing.server.data.PeriodLimitInfo;

/* renamed from: w2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1216d implements Parcelable {
    public static final Parcelable.Creator<C1216d> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f23603a;

    /* renamed from: b, reason: collision with root package name */
    private String f23604b;

    /* renamed from: c, reason: collision with root package name */
    private PackageUsingTimeStats f23605c;

    /* renamed from: d, reason: collision with root package name */
    private PackageLimitInfo f23606d;

    /* renamed from: e, reason: collision with root package name */
    private PeriodLimitInfo f23607e;

    /* renamed from: w2.d$a */
    class a implements Parcelable.Creator<C1216d> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C1216d createFromParcel(Parcel parcel) {
            return new C1216d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C1216d[] newArray(int i5) {
            return new C1216d[i5];
        }
    }

    public C1216d(String str, String str2) {
        this.f23603a = str;
        this.f23604b = str2;
    }

    public PackageUsingTimeStats A() {
        return this.f23605c;
    }

    public PeriodLimitInfo B() {
        return this.f23607e;
    }

    public void D(PackageLimitInfo packageLimitInfo) {
        this.f23606d = packageLimitInfo;
    }

    public void F(PackageUsingTimeStats packageUsingTimeStats) {
        this.f23605c = packageUsingTimeStats;
    }

    public void G(PeriodLimitInfo periodLimitInfo) {
        this.f23607e = periodLimitInfo;
    }

    public String a() {
        return this.f23604b;
    }

    public PackageLimitInfo c() {
        return this.f23606d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String f() {
        return this.f23603a;
    }

    public String toString() {
        return "AppUsageLimitData{mPackageName='" + this.f23603a + "', mLabel='" + this.f23604b + "', mPackageUsingTimeStats=" + this.f23605c + ", mPackageLimitInfo=" + this.f23606d + ", mPeriodLimitInfo=" + this.f23607e + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.f23603a);
        parcel.writeString(this.f23604b);
        parcel.writeParcelable(this.f23605c, i5);
        parcel.writeParcelable(this.f23606d, i5);
        parcel.writeParcelable(this.f23607e, i5);
    }

    protected C1216d(Parcel parcel) {
        this.f23603a = parcel.readString();
        this.f23604b = parcel.readString();
        this.f23605c = (PackageUsingTimeStats) parcel.readParcelable(PackageUsingTimeStats.class.getClassLoader());
        this.f23606d = (PackageLimitInfo) parcel.readParcelable(PackageLimitInfo.class.getClassLoader());
        this.f23607e = (PeriodLimitInfo) parcel.readParcelable(PeriodLimitInfo.class.getClassLoader());
    }
}
