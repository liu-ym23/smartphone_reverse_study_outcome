package com.stepos.familyguard.ui.usage;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.digitalwellbeing.server.data.CategoryLimitInfo;
import com.stepos.digitalwellbeing.server.data.PackageLimitInfo;
import com.stepos.digitalwellbeing.server.data.PeriodLimitInfo;
import com.stepos.digitalwellbeing.server.data.WhitelistAppInfo;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private final PackageLimitInfo[] f15155a;

    /* renamed from: b, reason: collision with root package name */
    private final CategoryLimitInfo[] f15156b;

    /* renamed from: c, reason: collision with root package name */
    private final PeriodLimitInfo[] f15157c;

    /* renamed from: d, reason: collision with root package name */
    private final PeriodLimitInfo[] f15158d;

    /* renamed from: e, reason: collision with root package name */
    private final List<WhitelistAppInfo> f15159e;

    /* renamed from: f, reason: collision with root package name */
    private final List<PackageUtils.AppInfo> f15160f;

    public static class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new C0186a();

        /* renamed from: a, reason: collision with root package name */
        public int f15161a;

        /* renamed from: b, reason: collision with root package name */
        public String f15162b;

        /* renamed from: c, reason: collision with root package name */
        public int f15163c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f15164d;

        /* renamed from: com.stepos.familyguard.ui.usage.x$a$a, reason: collision with other inner class name */
        class C0186a implements Parcelable.Creator<a> {
            C0186a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i5) {
                return new a[i5];
            }
        }

        public a() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            parcel.writeInt(this.f15161a);
            parcel.writeString(this.f15162b);
            parcel.writeInt(this.f15163c);
            parcel.writeByte(this.f15164d ? (byte) 1 : (byte) 0);
        }

        protected a(Parcel parcel) {
            this.f15161a = parcel.readInt();
            this.f15162b = parcel.readString();
            this.f15163c = parcel.readInt();
            this.f15164d = parcel.readByte() != 0;
        }
    }

    public static class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public String f15165a;

        /* renamed from: b, reason: collision with root package name */
        public String f15166b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f15167c;

        class a implements Parcelable.Creator<b> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i5) {
                return new b[i5];
            }
        }

        public b() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            parcel.writeString(this.f15165a);
            parcel.writeString(this.f15166b);
            parcel.writeByte(this.f15167c ? (byte) 1 : (byte) 0);
        }

        protected b(Parcel parcel) {
            this.f15165a = parcel.readString();
            this.f15166b = parcel.readString();
            this.f15167c = parcel.readByte() != 0;
        }
    }

    public x(PackageLimitInfo[] packageLimitInfoArr, CategoryLimitInfo[] categoryLimitInfoArr, PeriodLimitInfo[] periodLimitInfoArr, PeriodLimitInfo[] periodLimitInfoArr2, List<PackageUtils.AppInfo> list, List<WhitelistAppInfo> list2) {
        this.f15155a = packageLimitInfoArr;
        this.f15156b = categoryLimitInfoArr;
        this.f15157c = periodLimitInfoArr;
        this.f15158d = periodLimitInfoArr2;
        this.f15159e = list2;
        this.f15160f = list;
    }

    public List<PackageUtils.AppInfo> a() {
        return this.f15160f;
    }

    public List<a> b() {
        a aVar;
        HashMap map = new HashMap();
        for (int i5 : W1.a.d()) {
            a aVar2 = new a();
            aVar2.f15161a = i5;
            aVar2.f15162b = P1.a.a().getString(W1.c.m(i5));
            aVar2.f15163c = W1.c.l(i5);
            map.put(Integer.valueOf(i5), aVar2);
        }
        for (CategoryLimitInfo categoryLimitInfo : c()) {
            int categoryId = categoryLimitInfo.getCategoryId();
            a aVar3 = (a) map.get(Integer.valueOf(categoryId));
            if (categoryLimitInfo.isLimitable() && categoryLimitInfo.isEnable() && map.containsKey(Integer.valueOf(categoryId)) && aVar3 != null) {
                aVar3.f15164d = true;
            }
        }
        for (PeriodLimitInfo periodLimitInfo : d()) {
            if (periodLimitInfo.isEnable() && periodLimitInfo.getType() == 1 && (aVar = (a) map.get(Integer.valueOf((int) periodLimitInfo.getCategoryId()))) != null) {
                aVar.f15164d = true;
            }
        }
        return new ArrayList(map.values());
    }

    public CategoryLimitInfo[] c() {
        return this.f15156b;
    }

    public PeriodLimitInfo[] d() {
        return this.f15158d;
    }

    public List<b> e() {
        b bVar;
        b bVar2;
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (PackageUtils.AppInfo appInfo : this.f15160f) {
            b bVar3 = new b();
            bVar3.f15165a = appInfo.packageName;
            bVar3.f15166b = appInfo.label;
            arrayList.add(bVar3);
            map.put(bVar3.f15165a, bVar3);
        }
        for (PackageLimitInfo packageLimitInfo : this.f15155a) {
            String packageName = packageLimitInfo.getPackageName();
            if (packageLimitInfo.isLimitable() && packageLimitInfo.isEnable() && map.containsKey(packageName) && (bVar2 = (b) map.get(packageName)) != null) {
                bVar2.f15167c = true;
            }
        }
        for (PeriodLimitInfo periodLimitInfo : this.f15157c) {
            if (periodLimitInfo.isEnable() && periodLimitInfo.getType() == 0 && (bVar = (b) map.get(periodLimitInfo.getPackageName())) != null) {
                bVar.f15167c = true;
            }
        }
        return new ArrayList(arrayList);
    }

    public PackageLimitInfo[] f() {
        return this.f15155a;
    }

    public PeriodLimitInfo[] g() {
        return this.f15157c;
    }

    public List<WhitelistAppInfo> h() {
        return this.f15159e;
    }
}
