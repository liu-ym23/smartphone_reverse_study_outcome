package r1;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class b extends AbstractC5197a {

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f38743d;

    /* renamed from: e, reason: collision with root package name */
    public final Parcel f38744e;

    /* renamed from: f, reason: collision with root package name */
    public final int f38745f;

    /* renamed from: g, reason: collision with root package name */
    public final int f38746g;

    /* renamed from: h, reason: collision with root package name */
    public final String f38747h;

    /* renamed from: i, reason: collision with root package name */
    public int f38748i;

    /* renamed from: j, reason: collision with root package name */
    public int f38749j;

    /* renamed from: k, reason: collision with root package name */
    public int f38750k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new androidx.collection.a(), new androidx.collection.a(), new androidx.collection.a());
    }

    @Override // r1.AbstractC5197a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f38744e.writeInt(-1);
        } else {
            this.f38744e.writeInt(bArr.length);
            this.f38744e.writeByteArray(bArr);
        }
    }

    @Override // r1.AbstractC5197a
    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f38744e, 0);
    }

    @Override // r1.AbstractC5197a
    public void E(int i10) {
        this.f38744e.writeInt(i10);
    }

    @Override // r1.AbstractC5197a
    public void G(Parcelable parcelable) {
        this.f38744e.writeParcelable(parcelable, 0);
    }

    @Override // r1.AbstractC5197a
    public void I(String str) {
        this.f38744e.writeString(str);
    }

    @Override // r1.AbstractC5197a
    public void a() {
        int i10 = this.f38748i;
        if (i10 >= 0) {
            int i11 = this.f38743d.get(i10);
            int iDataPosition = this.f38744e.dataPosition();
            this.f38744e.setDataPosition(i11);
            this.f38744e.writeInt(iDataPosition - i11);
            this.f38744e.setDataPosition(iDataPosition);
        }
    }

    @Override // r1.AbstractC5197a
    public AbstractC5197a b() {
        Parcel parcel = this.f38744e;
        int iDataPosition = parcel.dataPosition();
        int i10 = this.f38749j;
        if (i10 == this.f38745f) {
            i10 = this.f38746g;
        }
        return new b(parcel, iDataPosition, i10, this.f38747h + "  ", this.f38740a, this.f38741b, this.f38742c);
    }

    @Override // r1.AbstractC5197a
    public boolean g() {
        return this.f38744e.readInt() != 0;
    }

    @Override // r1.AbstractC5197a
    public byte[] i() {
        int i10 = this.f38744e.readInt();
        if (i10 < 0) {
            return null;
        }
        byte[] bArr = new byte[i10];
        this.f38744e.readByteArray(bArr);
        return bArr;
    }

    @Override // r1.AbstractC5197a
    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f38744e);
    }

    @Override // r1.AbstractC5197a
    public boolean m(int i10) {
        while (this.f38749j < this.f38746g) {
            int i11 = this.f38750k;
            if (i11 == i10) {
                return true;
            }
            if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                return false;
            }
            this.f38744e.setDataPosition(this.f38749j);
            int i12 = this.f38744e.readInt();
            this.f38750k = this.f38744e.readInt();
            this.f38749j += i12;
        }
        return this.f38750k == i10;
    }

    @Override // r1.AbstractC5197a
    public int o() {
        return this.f38744e.readInt();
    }

    @Override // r1.AbstractC5197a
    public <T extends Parcelable> T q() {
        return (T) this.f38744e.readParcelable(getClass().getClassLoader());
    }

    @Override // r1.AbstractC5197a
    public String s() {
        return this.f38744e.readString();
    }

    @Override // r1.AbstractC5197a
    public void w(int i10) {
        a();
        this.f38748i = i10;
        this.f38743d.put(i10, this.f38744e.dataPosition());
        E(0);
        E(i10);
    }

    @Override // r1.AbstractC5197a
    public void y(boolean z10) {
        this.f38744e.writeInt(z10 ? 1 : 0);
    }

    public b(Parcel parcel, int i10, int i11, String str, androidx.collection.a<String, Method> aVar, androidx.collection.a<String, Method> aVar2, androidx.collection.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f38743d = new SparseIntArray();
        this.f38748i = -1;
        this.f38750k = -1;
        this.f38744e = parcel;
        this.f38745f = i10;
        this.f38746g = i11;
        this.f38749j = i10;
        this.f38747h = str;
    }
}
