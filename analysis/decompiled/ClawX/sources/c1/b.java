package c1;

import android.os.Parcel;
import android.util.SparseIntArray;
import com.stepos.stepclaw.SecurePrefs;
import j.e;
import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends a {
    public final SparseIntArray d;

    /* renamed from: e, reason: collision with root package name */
    public final Parcel f1054e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1055f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1056g;

    /* renamed from: h, reason: collision with root package name */
    public final String f1057h;

    /* renamed from: i, reason: collision with root package name */
    public int f1058i;

    /* renamed from: j, reason: collision with root package name */
    public int f1059j;

    /* renamed from: k, reason: collision with root package name */
    public int f1060k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, new e(0), new e(0), new e(0));
    }

    @Override // c1.a
    public final b a() {
        Parcel parcel = this.f1054e;
        int iDataPosition = parcel.dataPosition();
        int i8 = this.f1059j;
        if (i8 == this.f1055f) {
            i8 = this.f1056g;
        }
        return new b(parcel, iDataPosition, i8, f.f(new StringBuilder(), this.f1057h, "  "), this.f1051a, this.f1052b, this.f1053c);
    }

    @Override // c1.a
    public final boolean e(int i8) {
        while (this.f1059j < this.f1056g) {
            int i9 = this.f1060k;
            if (i9 == i8) {
                return true;
            }
            if (String.valueOf(i9).compareTo(String.valueOf(i8)) > 0) {
                return false;
            }
            int i10 = this.f1059j;
            Parcel parcel = this.f1054e;
            parcel.setDataPosition(i10);
            int i11 = parcel.readInt();
            this.f1060k = parcel.readInt();
            this.f1059j += i11;
        }
        return this.f1060k == i8;
    }

    @Override // c1.a
    public final void h(int i8) {
        int i9 = this.f1058i;
        SparseIntArray sparseIntArray = this.d;
        Parcel parcel = this.f1054e;
        if (i9 >= 0) {
            int i10 = sparseIntArray.get(i9);
            int iDataPosition = parcel.dataPosition();
            parcel.setDataPosition(i10);
            parcel.writeInt(iDataPosition - i10);
            parcel.setDataPosition(iDataPosition);
        }
        this.f1058i = i8;
        sparseIntArray.put(i8, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i8);
    }

    public b(Parcel parcel, int i8, int i9, String str, e eVar, e eVar2, e eVar3) {
        super(eVar, eVar2, eVar3);
        this.d = new SparseIntArray();
        this.f1058i = -1;
        this.f1060k = -1;
        this.f1054e = parcel;
        this.f1055f = i8;
        this.f1056g = i9;
        this.f1059j = i8;
        this.f1057h = str;
    }
}
