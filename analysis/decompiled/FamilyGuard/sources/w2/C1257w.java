package w2;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.digitalwellbeing.server.data.CategoryLimitInfo;
import com.stepos.digitalwellbeing.server.data.CategoryUsingTimeStats;
import com.stepos.digitalwellbeing.server.data.PeriodLimitInfo;

/* renamed from: w2.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1257w implements Parcelable {
    public static final Parcelable.Creator<C1257w> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final int f23676a;

    /* renamed from: b, reason: collision with root package name */
    private CategoryUsingTimeStats f23677b;

    /* renamed from: c, reason: collision with root package name */
    private CategoryLimitInfo f23678c;

    /* renamed from: d, reason: collision with root package name */
    private PeriodLimitInfo f23679d;

    /* renamed from: w2.w$a */
    class a implements Parcelable.Creator<C1257w> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C1257w createFromParcel(Parcel parcel) {
            return new C1257w(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C1257w[] newArray(int i5) {
            return new C1257w[i5];
        }
    }

    public C1257w(int i5, CategoryUsingTimeStats categoryUsingTimeStats) {
        this.f23676a = i5;
        this.f23677b = categoryUsingTimeStats;
    }

    public PeriodLimitInfo A() {
        return this.f23679d;
    }

    public void B(CategoryLimitInfo categoryLimitInfo) {
        this.f23678c = categoryLimitInfo;
    }

    public void D(PeriodLimitInfo periodLimitInfo) {
        this.f23679d = periodLimitInfo;
    }

    public int a() {
        return this.f23676a;
    }

    public CategoryLimitInfo c() {
        return this.f23678c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CategoryUsingTimeStats f() {
        return this.f23677b;
    }

    public String toString() {
        return "CategoryUsageLimitData{mCategoryId=" + this.f23676a + ", mCategoryUsingTimeStats=" + this.f23677b + ", mCategoryLimitInfo=" + this.f23678c + ", mPeriodLimitInfo=" + this.f23679d + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f23676a);
        parcel.writeParcelable(this.f23677b, i5);
        parcel.writeParcelable(this.f23678c, i5);
        parcel.writeParcelable(this.f23679d, i5);
    }

    protected C1257w(Parcel parcel) {
        this.f23676a = parcel.readInt();
        this.f23677b = (CategoryUsingTimeStats) parcel.readParcelable(CategoryUsingTimeStats.class.getClassLoader());
        this.f23678c = (CategoryLimitInfo) parcel.readParcelable(CategoryLimitInfo.class.getClassLoader());
        this.f23679d = (PeriodLimitInfo) parcel.readParcelable(PeriodLimitInfo.class.getClassLoader());
    }
}
