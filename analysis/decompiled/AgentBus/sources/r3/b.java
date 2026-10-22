package r3;

import android.os.Parcel;
import android.util.SparseIntArray;
import k.e;

/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f8973d;

    /* renamed from: e, reason: collision with root package name */
    public final Parcel f8974e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8975f;

    /* renamed from: g, reason: collision with root package name */
    public final int f8976g;

    /* renamed from: h, reason: collision with root package name */
    public final String f8977h;

    /* renamed from: i, reason: collision with root package name */
    public int f8978i;

    /* renamed from: j, reason: collision with root package name */
    public int f8979j;

    /* renamed from: k, reason: collision with root package name */
    public int f8980k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new e(), new e(), new e());
    }

    @Override // r3.a
    public final b a() {
        Parcel parcel = this.f8974e;
        int iDataPosition = parcel.dataPosition();
        int i2 = this.f8979j;
        if (i2 == this.f8975f) {
            i2 = this.f8976g;
        }
        return new b(parcel, iDataPosition, i2, a1.a.m(new StringBuilder(), this.f8977h, "  "), this.f8970a, this.f8971b, this.f8972c);
    }

    @Override // r3.a
    public final boolean e(int i2) {
        while (this.f8979j < this.f8976g) {
            int i10 = this.f8980k;
            if (i10 == i2) {
                return true;
            }
            if (String.valueOf(i10).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            int i11 = this.f8979j;
            Parcel parcel = this.f8974e;
            parcel.setDataPosition(i11);
            int i12 = parcel.readInt();
            this.f8980k = parcel.readInt();
            this.f8979j += i12;
        }
        return this.f8980k == i2;
    }

    @Override // r3.a
    public final void h(int i2) {
        int i10 = this.f8978i;
        SparseIntArray sparseIntArray = this.f8973d;
        Parcel parcel = this.f8974e;
        if (i10 >= 0) {
            int i11 = sparseIntArray.get(i10);
            int iDataPosition = parcel.dataPosition();
            parcel.setDataPosition(i11);
            parcel.writeInt(iDataPosition - i11);
            parcel.setDataPosition(iDataPosition);
        }
        this.f8978i = i2;
        sparseIntArray.put(i2, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i2);
    }

    public b(Parcel parcel, int i2, int i10, String str, e eVar, e eVar2, e eVar3) {
        super(eVar, eVar2, eVar3);
        this.f8973d = new SparseIntArray();
        this.f8978i = -1;
        this.f8980k = -1;
        this.f8974e = parcel;
        this.f8975f = i2;
        this.f8976g = i10;
        this.f8979j = i2;
        this.f8977h = str;
    }
}
