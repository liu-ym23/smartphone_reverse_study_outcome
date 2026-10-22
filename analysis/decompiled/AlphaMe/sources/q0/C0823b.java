package q0;

import B0.g;
import android.os.Parcel;
import android.util.SparseIntArray;
import q.f;

/* renamed from: q0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0823b extends AbstractC0822a {

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f13978d;

    /* renamed from: e, reason: collision with root package name */
    public final Parcel f13979e;

    /* renamed from: f, reason: collision with root package name */
    public final int f13980f;

    /* renamed from: g, reason: collision with root package name */
    public final int f13981g;

    /* renamed from: h, reason: collision with root package name */
    public final String f13982h;

    /* renamed from: i, reason: collision with root package name */
    public int f13983i;

    /* renamed from: j, reason: collision with root package name */
    public int f13984j;

    /* renamed from: k, reason: collision with root package name */
    public int f13985k;

    public C0823b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new f(), new f(), new f());
    }

    @Override // q0.AbstractC0822a
    public final C0823b a() {
        Parcel parcel = this.f13979e;
        int iDataPosition = parcel.dataPosition();
        int i4 = this.f13984j;
        if (i4 == this.f13980f) {
            i4 = this.f13981g;
        }
        return new C0823b(parcel, iDataPosition, i4, g.r(new StringBuilder(), this.f13982h, "  "), this.f13975a, this.f13976b, this.f13977c);
    }

    @Override // q0.AbstractC0822a
    public final boolean e(int i4) {
        while (this.f13984j < this.f13981g) {
            int i5 = this.f13985k;
            if (i5 == i4) {
                return true;
            }
            if (String.valueOf(i5).compareTo(String.valueOf(i4)) > 0) {
                return false;
            }
            int i6 = this.f13984j;
            Parcel parcel = this.f13979e;
            parcel.setDataPosition(i6);
            int i7 = parcel.readInt();
            this.f13985k = parcel.readInt();
            this.f13984j += i7;
        }
        return this.f13985k == i4;
    }

    @Override // q0.AbstractC0822a
    public final void i(int i4) {
        int i5 = this.f13983i;
        SparseIntArray sparseIntArray = this.f13978d;
        Parcel parcel = this.f13979e;
        if (i5 >= 0) {
            int i6 = sparseIntArray.get(i5);
            int iDataPosition = parcel.dataPosition();
            parcel.setDataPosition(i6);
            parcel.writeInt(iDataPosition - i6);
            parcel.setDataPosition(iDataPosition);
        }
        this.f13983i = i4;
        sparseIntArray.put(i4, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i4);
    }

    public C0823b(Parcel parcel, int i4, int i5, String str, f fVar, f fVar2, f fVar3) {
        super(fVar, fVar2, fVar3);
        this.f13978d = new SparseIntArray();
        this.f13983i = -1;
        this.f13985k = -1;
        this.f13979e = parcel;
        this.f13980f = i4;
        this.f13981g = i5;
        this.f13984j = i4;
        this.f13982h = str;
    }
}
