package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.stepos.alphame.utils.Consts;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class PoiFilter implements Parcelable {

    /* renamed from: b, reason: collision with root package name */
    private String f7405b;

    /* renamed from: c, reason: collision with root package name */
    private String f7406c;

    /* renamed from: d, reason: collision with root package name */
    private String f7407d;

    /* renamed from: e, reason: collision with root package name */
    private String f7408e;

    /* renamed from: f, reason: collision with root package name */
    private String f7409f;

    /* renamed from: a, reason: collision with root package name */
    private static Map<SortName, String> f7404a = new HashMap();
    public static final Parcelable.Creator<PoiFilter> CREATOR = new a();

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f7410a;

        /* renamed from: b, reason: collision with root package name */
        private String f7411b;

        /* renamed from: c, reason: collision with root package name */
        private String f7412c;

        /* renamed from: d, reason: collision with root package name */
        private String f7413d;

        /* renamed from: e, reason: collision with root package name */
        private String f7414e;

        public Builder() {
            PoiFilter.f7404a.put(SortName.HotelSortName.DEFAULT, "default");
            PoiFilter.f7404a.put(SortName.HotelSortName.HOTEL_LEVEL, "level");
            PoiFilter.f7404a.put(SortName.HotelSortName.HOTEL_PRICE, "price");
            PoiFilter.f7404a.put(SortName.HotelSortName.HOTEL_DISTANCE, "distance");
            PoiFilter.f7404a.put(SortName.HotelSortName.HOTEL_HEALTH_SCORE, "health_score");
            PoiFilter.f7404a.put(SortName.HotelSortName.HOTEL_TOTAL_SCORE, "total_score");
            PoiFilter.f7404a.put(SortName.CaterSortName.DEFAULT, "default");
            PoiFilter.f7404a.put(SortName.CaterSortName.CATER_DISTANCE, "distance");
            PoiFilter.f7404a.put(SortName.CaterSortName.CATER_PRICE, "price");
            PoiFilter.f7404a.put(SortName.CaterSortName.CATER_OVERALL_RATING, "overall_rating");
            PoiFilter.f7404a.put(SortName.CaterSortName.CATER_SERVICE_RATING, "service_rating");
            PoiFilter.f7404a.put(SortName.CaterSortName.CATER_TASTE_RATING, "taste_rating");
            PoiFilter.f7404a.put(SortName.LifeSortName.DEFAULT, "default");
            PoiFilter.f7404a.put(SortName.LifeSortName.PRICE, "price");
            PoiFilter.f7404a.put(SortName.LifeSortName.LIFE_COMMENT_RATING, "comment_num");
            PoiFilter.f7404a.put(SortName.LifeSortName.LIFE_OVERALL_RATING, "overall_rating");
            PoiFilter.f7404a.put(SortName.LifeSortName.DISTANCE, "distance");
        }

        public PoiFilter build() {
            return new PoiFilter(this.f7410a, this.f7411b, this.f7412c, this.f7414e, this.f7413d);
        }

        public Builder industryType(IndustryType industryType) {
            int i4 = b.f7419a[industryType.ordinal()];
            if (i4 == 1) {
                this.f7410a = "hotel";
            } else if (i4 == 2) {
                this.f7410a = "cater";
            } else if (i4 != 3) {
                this.f7410a = "";
            } else {
                this.f7410a = "life";
            }
            return this;
        }

        public Builder isDiscount(boolean z4) {
            if (z4) {
                this.f7414e = "1";
            } else {
                this.f7414e = "0";
            }
            return this;
        }

        public Builder isGroupon(boolean z4) {
            if (z4) {
                this.f7413d = "1";
            } else {
                this.f7413d = "0";
            }
            return this;
        }

        public Builder sortName(SortName sortName) {
            if (sortName != null) {
                this.f7411b = (String) PoiFilter.f7404a.get(sortName);
            }
            return this;
        }

        public Builder sortRule(int i4) {
            this.f7412c = i4 + "";
            return this;
        }
    }

    public enum IndustryType {
        HOTEL,
        CATER,
        LIFE
    }

    public interface SortName {

        public enum CaterSortName implements SortName {
            DEFAULT,
            CATER_PRICE,
            CATER_DISTANCE,
            CATER_TASTE_RATING,
            CATER_OVERALL_RATING,
            CATER_SERVICE_RATING
        }

        public enum HotelSortName implements SortName {
            DEFAULT,
            HOTEL_PRICE,
            HOTEL_DISTANCE,
            HOTEL_TOTAL_SCORE,
            HOTEL_LEVEL,
            HOTEL_HEALTH_SCORE
        }

        public enum LifeSortName implements SortName {
            DEFAULT,
            PRICE,
            DISTANCE,
            LIFE_OVERALL_RATING,
            LIFE_COMMENT_RATING
        }
    }

    public static class a implements Parcelable.Creator<PoiFilter> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoiFilter createFromParcel(Parcel parcel) {
            return new PoiFilter(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoiFilter[] newArray(int i4) {
            return new PoiFilter[i4];
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7419a;

        static {
            int[] iArr = new int[IndustryType.values().length];
            f7419a = iArr;
            try {
                iArr[IndustryType.HOTEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7419a[IndustryType.CATER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7419a[IndustryType.LIFE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public PoiFilter(String str, String str2, String str3, String str4, String str5) {
        this.f7405b = str;
        this.f7406c = str2;
        this.f7407d = str3;
        this.f7409f = str4;
        this.f7408e = str5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.f7405b)) {
            sb.append("industry_type:");
            sb.append(this.f7405b);
            sb.append(Consts.SPLITTER_DETAIL);
        }
        if (!TextUtils.isEmpty(this.f7406c)) {
            sb.append("sort_name:");
            sb.append(this.f7406c);
            sb.append(Consts.SPLITTER_DETAIL);
        }
        if (!TextUtils.isEmpty(this.f7407d)) {
            sb.append("sort_rule:");
            sb.append(this.f7407d);
            sb.append(Consts.SPLITTER_DETAIL);
        }
        if (!TextUtils.isEmpty(this.f7409f)) {
            sb.append("discount:");
            sb.append(this.f7409f);
            sb.append(Consts.SPLITTER_DETAIL);
        }
        if (!TextUtils.isEmpty(this.f7408e)) {
            sb.append("groupon:");
            sb.append(this.f7408e);
            sb.append(Consts.SPLITTER_DETAIL);
        }
        if (!TextUtils.isEmpty(sb.toString())) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f7405b);
        parcel.writeString(this.f7406c);
        parcel.writeString(this.f7407d);
        parcel.writeString(this.f7409f);
        parcel.writeString(this.f7408e);
    }

    public PoiFilter(Parcel parcel) {
        this.f7405b = "";
        this.f7406c = "";
        this.f7407d = "";
        this.f7408e = "";
        this.f7409f = "";
        this.f7405b = parcel.readString();
        this.f7406c = parcel.readString();
        this.f7407d = parcel.readString();
        this.f7409f = parcel.readString();
        this.f7408e = parcel.readString();
    }
}
