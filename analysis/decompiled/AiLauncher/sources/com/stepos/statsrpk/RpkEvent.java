package com.stepos.statsrpk;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;

/* loaded from: classes2.dex */
public class RpkEvent implements Parcelable {
    public static final Parcelable.Creator<RpkEvent> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f31006a;

    /* renamed from: b, reason: collision with root package name */
    public String f31007b;

    /* renamed from: c, reason: collision with root package name */
    public String f31008c;

    /* renamed from: d, reason: collision with root package name */
    public Map f31009d;

    /* renamed from: e, reason: collision with root package name */
    public String f31010e;

    public class a implements Parcelable.Creator<RpkEvent> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RpkEvent createFromParcel(Parcel parcel) {
            return new RpkEvent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RpkEvent[] newArray(int i10) {
            return new RpkEvent[i10];
        }
    }

    public RpkEvent() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "[" + this.f31006a + Const.STR_MART_COMMA + this.f31007b + Const.STR_MART_COMMA + this.f31008c + Const.STR_MART_COMMA + this.f31009d + Const.STR_MART_COMMA + this.f31010e + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f31006a);
        parcel.writeString(this.f31007b);
        parcel.writeString(this.f31008c);
        parcel.writeMap(this.f31009d);
        parcel.writeString(this.f31010e);
    }

    public RpkEvent(Parcel parcel) {
        this.f31006a = parcel.readString();
        this.f31007b = parcel.readString();
        this.f31008c = parcel.readString();
        this.f31009d = parcel.readHashMap(String.class.getClassLoader());
        this.f31010e = parcel.readString();
    }
}
