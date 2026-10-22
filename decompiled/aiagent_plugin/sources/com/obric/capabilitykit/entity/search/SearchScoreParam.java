package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class SearchScoreParam implements Parcelable {
    public static final a CREATOR = null;
    private final String type;
    private final double value;

    public static final class a implements Parcelable.Creator<SearchScoreParam> {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        public SearchScoreParam a(Parcel r1) {
            o.e(r1, "parcel");
            return new SearchScoreParam(r1);
        }

        public SearchScoreParam[] a(int r1) {
            return new SearchScoreParam[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ SearchScoreParam createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ SearchScoreParam[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public SearchScoreParam() {
        this(0.0d, null, 3, null);
    }

    public SearchScoreParam(double r2, String r4) {
        o.e(r4, "type");
        this.value = r2;
        this.type = r4;
    }

    public /* synthetic */ SearchScoreParam(double r1, String r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0.0d;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = "";
    L8:
        this(r1, r3);
    }

    public SearchScoreParam(Parcel r3) {
        o.e(r3, "parcel");
        double r0 = r3.readDouble();
        String r4 = r3.readString();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        this(r0, r4);
    }

    public static /* synthetic */ SearchScoreParam copy$default(SearchScoreParam r0, double r1, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.value;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r0.type;
    L9:
        return r0.copy(r1, r3);
    }

    public final double component1() {
        return this.value;
    }

    public final String component2() {
        return this.type;
    }

    public final SearchScoreParam copy(double r1, String r3) {
        o.e(r3, "type");
        return new SearchScoreParam(r1, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, SearchScoreParam.class) == true) goto L8;
        return false;
    L8:
        SearchScoreParam r10 = (SearchScoreParam) ZeusTransformUtils.preCheckCast(r9, SearchScoreParam.class, "com.obric.aiagent.plugin");
        if (Double.compare(this.value, r10.value) == 0) goto L12;
        return false;
    L12:
        if (o.a(this.type, r10.type) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getType() {
        return this.type;
    }

    public final double getValue() {
        return this.value;
    }

    public int hashCode() {
        return (Double.hashCode(this.value) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "SearchScoreParam(value=" + this.value + ", type=" + this.type + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "parcel");
        r3.writeDouble(this.value);
        r3.writeString(this.type);
    }
}
