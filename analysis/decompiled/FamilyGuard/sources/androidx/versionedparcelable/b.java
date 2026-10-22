package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;
import org.libpag.BuildConfig;
import q.C0933a;

/* loaded from: classes.dex */
class b extends a {

    /* renamed from: d, reason: collision with root package name */
    private final SparseIntArray f11605d;

    /* renamed from: e, reason: collision with root package name */
    private final Parcel f11606e;

    /* renamed from: f, reason: collision with root package name */
    private final int f11607f;

    /* renamed from: g, reason: collision with root package name */
    private final int f11608g;

    /* renamed from: h, reason: collision with root package name */
    private final String f11609h;

    /* renamed from: i, reason: collision with root package name */
    private int f11610i;

    /* renamed from: j, reason: collision with root package name */
    private int f11611j;

    /* renamed from: k, reason: collision with root package name */
    private int f11612k;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), BuildConfig.FLAVOR, new C0933a(), new C0933a(), new C0933a());
    }

    @Override // androidx.versionedparcelable.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f11606e.writeInt(-1);
        } else {
            this.f11606e.writeInt(bArr.length);
            this.f11606e.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f11606e, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void E(int i5) {
        this.f11606e.writeInt(i5);
    }

    @Override // androidx.versionedparcelable.a
    public void G(Parcelable parcelable) {
        this.f11606e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void I(String str) {
        this.f11606e.writeString(str);
    }

    @Override // androidx.versionedparcelable.a
    public void a() {
        int i5 = this.f11610i;
        if (i5 >= 0) {
            int i6 = this.f11605d.get(i5);
            int iDataPosition = this.f11606e.dataPosition();
            this.f11606e.setDataPosition(i6);
            this.f11606e.writeInt(iDataPosition - i6);
            this.f11606e.setDataPosition(iDataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected a b() {
        Parcel parcel = this.f11606e;
        int iDataPosition = parcel.dataPosition();
        int i5 = this.f11611j;
        if (i5 == this.f11607f) {
            i5 = this.f11608g;
        }
        return new b(parcel, iDataPosition, i5, this.f11609h + "  ", this.f11602a, this.f11603b, this.f11604c);
    }

    @Override // androidx.versionedparcelable.a
    public boolean g() {
        return this.f11606e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.a
    public byte[] i() {
        int i5 = this.f11606e.readInt();
        if (i5 < 0) {
            return null;
        }
        byte[] bArr = new byte[i5];
        this.f11606e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f11606e);
    }

    @Override // androidx.versionedparcelable.a
    public boolean m(int i5) {
        while (this.f11611j < this.f11608g) {
            int i6 = this.f11612k;
            if (i6 == i5) {
                return true;
            }
            if (String.valueOf(i6).compareTo(String.valueOf(i5)) > 0) {
                return false;
            }
            this.f11606e.setDataPosition(this.f11611j);
            int i7 = this.f11606e.readInt();
            this.f11612k = this.f11606e.readInt();
            this.f11611j += i7;
        }
        return this.f11612k == i5;
    }

    @Override // androidx.versionedparcelable.a
    public int o() {
        return this.f11606e.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public <T extends Parcelable> T q() {
        return (T) this.f11606e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public String s() {
        return this.f11606e.readString();
    }

    @Override // androidx.versionedparcelable.a
    public void w(int i5) {
        a();
        this.f11610i = i5;
        this.f11605d.put(i5, this.f11606e.dataPosition());
        E(0);
        E(i5);
    }

    @Override // androidx.versionedparcelable.a
    public void y(boolean z5) {
        this.f11606e.writeInt(z5 ? 1 : 0);
    }

    private b(Parcel parcel, int i5, int i6, String str, C0933a<String, Method> c0933a, C0933a<String, Method> c0933a2, C0933a<String, Class> c0933a3) {
        super(c0933a, c0933a2, c0933a3);
        this.f11605d = new SparseIntArray();
        this.f11610i = -1;
        this.f11612k = -1;
        this.f11606e = parcel;
        this.f11607f = i5;
        this.f11608g = i6;
        this.f11611j = i5;
        this.f11609h = str;
    }
}
