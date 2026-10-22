package f2;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f8673d;

    /* renamed from: e, reason: collision with root package name */
    public final Parcel f8674e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8675f;

    /* renamed from: g, reason: collision with root package name */
    public final int f8676g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public int f8677i;

    /* renamed from: j, reason: collision with root package name */
    public int f8678j;

    /* renamed from: k, reason: collision with root package name */
    public int f8679k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new p.a(), new p.a(), new p.a());
    }

    @Override // f2.a
    public final b a() {
        Parcel parcel = this.f8674e;
        int iDataPosition = parcel.dataPosition();
        int i10 = this.f8678j;
        if (i10 == this.f8675f) {
            i10 = this.f8676g;
        }
        return new b(parcel, iDataPosition, i10, ai.onnxruntime.a.o(new StringBuilder(), this.h, "  "), this.f8670a, this.f8671b, this.f8672c);
    }

    @Override // f2.a
    public final boolean e() {
        return this.f8674e.readInt() != 0;
    }

    @Override // f2.a
    public final byte[] f() {
        Parcel parcel = this.f8674e;
        int i10 = parcel.readInt();
        if (i10 < 0) {
            return null;
        }
        byte[] bArr = new byte[i10];
        parcel.readByteArray(bArr);
        return bArr;
    }

    @Override // f2.a
    public final CharSequence g() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f8674e);
    }

    @Override // f2.a
    public final boolean h(int i10) {
        while (this.f8678j < this.f8676g) {
            int i11 = this.f8679k;
            if (i11 == i10) {
                return true;
            }
            if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                return false;
            }
            int i12 = this.f8678j;
            Parcel parcel = this.f8674e;
            parcel.setDataPosition(i12);
            int i13 = parcel.readInt();
            this.f8679k = parcel.readInt();
            this.f8678j += i13;
        }
        return this.f8679k == i10;
    }

    @Override // f2.a
    public final int i() {
        return this.f8674e.readInt();
    }

    @Override // f2.a
    public final <T extends Parcelable> T j() {
        return (T) this.f8674e.readParcelable(b.class.getClassLoader());
    }

    @Override // f2.a
    public final String k() {
        return this.f8674e.readString();
    }

    @Override // f2.a
    public final void m(int i10) {
        u();
        this.f8677i = i10;
        this.f8673d.put(i10, this.f8674e.dataPosition());
        q(0);
        q(i10);
    }

    @Override // f2.a
    public final void n(boolean z) {
        this.f8674e.writeInt(z ? 1 : 0);
    }

    @Override // f2.a
    public final void o(byte[] bArr) {
        Parcel parcel = this.f8674e;
        if (bArr == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr);
        }
    }

    @Override // f2.a
    public final void p(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f8674e, 0);
    }

    @Override // f2.a
    public final void q(int i10) {
        this.f8674e.writeInt(i10);
    }

    @Override // f2.a
    public final void r(Parcelable parcelable) {
        this.f8674e.writeParcelable(parcelable, 0);
    }

    @Override // f2.a
    public final void s(String str) {
        this.f8674e.writeString(str);
    }

    public final void u() {
        int i10 = this.f8677i;
        if (i10 >= 0) {
            int i11 = this.f8673d.get(i10);
            Parcel parcel = this.f8674e;
            int iDataPosition = parcel.dataPosition();
            parcel.setDataPosition(i11);
            parcel.writeInt(iDataPosition - i11);
            parcel.setDataPosition(iDataPosition);
        }
    }

    public b(Parcel parcel, int i10, int i11, String str, p.a<String, Method> aVar, p.a<String, Method> aVar2, p.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f8673d = new SparseIntArray();
        this.f8677i = -1;
        this.f8679k = -1;
        this.f8674e = parcel;
        this.f8675f = i10;
        this.f8676g = i11;
        this.f8678j = i10;
        this.h = str;
    }
}
