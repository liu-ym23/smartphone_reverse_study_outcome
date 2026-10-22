package e5;

import android.os.Parcel;
import android.util.SparseIntArray;
import p.e;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f3499d;

    /* renamed from: e, reason: collision with root package name */
    public final Parcel f3500e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3501f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3502g;

    /* renamed from: h, reason: collision with root package name */
    public final String f3503h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f3504j;

    /* renamed from: k, reason: collision with root package name */
    public int f3505k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new e(0), new e(0), new e(0));
    }

    @Override // e5.a
    public final b a() {
        Parcel parcel = this.f3500e;
        int iDataPosition = parcel.dataPosition();
        int i = this.f3504j;
        if (i == this.f3501f) {
            i = this.f3502g;
        }
        return new b(parcel, iDataPosition, i, androidx.activity.b.n(new StringBuilder(), this.f3503h, "  "), this.f3496a, this.f3497b, this.f3498c);
    }

    @Override // e5.a
    public final boolean e(int i) {
        while (true) {
            int i3 = this.f3504j;
            int i10 = this.f3505k;
            if (i3 >= this.f3502g) {
                return i10 == i;
            }
            if (i10 == i) {
                return true;
            }
            if (String.valueOf(i10).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            int i11 = this.f3504j;
            Parcel parcel = this.f3500e;
            parcel.setDataPosition(i11);
            int i12 = parcel.readInt();
            this.f3505k = parcel.readInt();
            this.f3504j += i12;
        }
    }

    @Override // e5.a
    public final void h(int i) {
        int i3 = this.i;
        SparseIntArray sparseIntArray = this.f3499d;
        Parcel parcel = this.f3500e;
        if (i3 >= 0) {
            int i10 = sparseIntArray.get(i3);
            int iDataPosition = parcel.dataPosition();
            parcel.setDataPosition(i10);
            parcel.writeInt(iDataPosition - i10);
            parcel.setDataPosition(iDataPosition);
        }
        this.i = i;
        sparseIntArray.put(i, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i);
    }

    public b(Parcel parcel, int i, int i3, String str, e eVar, e eVar2, e eVar3) {
        this.f3496a = eVar;
        this.f3497b = eVar2;
        this.f3498c = eVar3;
        this.f3499d = new SparseIntArray();
        this.i = -1;
        this.f3505k = -1;
        this.f3500e = parcel;
        this.f3501f = i;
        this.f3502g = i3;
        this.f3504j = i;
        this.f3503h = str;
    }
}
