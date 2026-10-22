package l2;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class m implements Parcelable {
    public static final Parcelable.Creator<m> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f18243a;

    /* renamed from: b, reason: collision with root package name */
    public String f18244b;

    /* renamed from: c, reason: collision with root package name */
    public String f18245c;

    /* renamed from: d, reason: collision with root package name */
    public String f18246d;

    /* renamed from: e, reason: collision with root package name */
    public long f18247e;

    /* renamed from: f, reason: collision with root package name */
    public long f18248f;

    /* renamed from: g, reason: collision with root package name */
    public long f18249g;

    /* renamed from: h, reason: collision with root package name */
    public String f18250h;

    /* renamed from: i, reason: collision with root package name */
    public String f18251i;

    /* renamed from: j, reason: collision with root package name */
    public String f18252j;

    /* renamed from: k, reason: collision with root package name */
    public int f18253k;

    /* renamed from: l, reason: collision with root package name */
    public int f18254l;

    /* renamed from: m, reason: collision with root package name */
    public int f18255m;

    /* renamed from: n, reason: collision with root package name */
    public int f18256n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f18257o;

    /* renamed from: p, reason: collision with root package name */
    public int f18258p;

    /* renamed from: q, reason: collision with root package name */
    public int f18259q;

    /* renamed from: r, reason: collision with root package name */
    public int f18260r;

    /* renamed from: s, reason: collision with root package name */
    public String f18261s;

    /* renamed from: t, reason: collision with root package name */
    public String f18262t;

    class a implements Parcelable.Creator<m> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public m createFromParcel(Parcel parcel) {
            return new m(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public m[] newArray(int i5) {
            return new m[i5];
        }
    }

    public m() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "RelationUser{ id=" + this.f18247e + ", role=" + this.f18243a + ", mImsi='" + this.f18244b + "', mImei='" + this.f18245c + "', mPhone='" + this.f18246d + "', lmodify=" + this.f18248f + ", postTime=" + this.f18249g + ", rImsi='" + this.f18250h + "', rImei='" + this.f18251i + "', rPhone='" + this.f18252j + "', mark=" + this.f18253k + ", status=" + this.f18254l + ", watchDays=" + this.f18255m + ", type=" + this.f18256n + ", isTrack=" + this.f18257o + ", rAppVersion=" + this.f18258p + ", rLastAppVersion=" + this.f18259q + ", masterRoleType=" + this.f18260r + ", masterRoleName='" + this.f18261s + "', slaveRoleName='" + this.f18262t + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f18243a);
        parcel.writeString(this.f18244b);
        parcel.writeString(this.f18245c);
        parcel.writeString(this.f18246d);
        parcel.writeLong(this.f18247e);
        parcel.writeLong(this.f18248f);
        parcel.writeLong(this.f18249g);
        parcel.writeString(this.f18250h);
        parcel.writeString(this.f18251i);
        parcel.writeString(this.f18252j);
        parcel.writeInt(this.f18253k);
        parcel.writeInt(this.f18254l);
        parcel.writeInt(this.f18255m);
        parcel.writeInt(this.f18256n);
        parcel.writeByte(this.f18257o ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f18258p);
        parcel.writeInt(this.f18259q);
        parcel.writeInt(this.f18260r);
        parcel.writeString(this.f18261s);
        parcel.writeString(this.f18262t);
    }

    protected m(Parcel parcel) {
        this.f18243a = parcel.readInt();
        this.f18244b = parcel.readString();
        this.f18245c = parcel.readString();
        this.f18246d = parcel.readString();
        this.f18247e = parcel.readLong();
        this.f18248f = parcel.readLong();
        this.f18249g = parcel.readLong();
        this.f18250h = parcel.readString();
        this.f18251i = parcel.readString();
        this.f18252j = parcel.readString();
        this.f18253k = parcel.readInt();
        this.f18254l = parcel.readInt();
        this.f18255m = parcel.readInt();
        this.f18256n = parcel.readInt();
        this.f18257o = parcel.readByte() != 0;
        this.f18258p = parcel.readInt();
        this.f18259q = parcel.readInt();
        this.f18260r = parcel.readInt();
        this.f18261s = parcel.readString();
        this.f18262t = parcel.readString();
    }
}
