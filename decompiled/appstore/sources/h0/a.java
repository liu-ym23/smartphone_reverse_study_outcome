package h0;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
public class a extends VersionedParcel {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseIntArray f20147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Parcel f20148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f20149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f20150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f20151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f20152i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f20153j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f20154k;

    public a(Parcel r10) {
        this(r10, r10.dataPosition(), r10.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void A(byte[] r10) {
        if (r10 == null) goto L4;
        this.f20148e.writeInt(r10.length);
        this.f20148e.writeByteArray(r10);
        return;
    L4:
        this.f20148e.writeInt(-1);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void C(CharSequence r10) {
        TextUtils.writeToParcel(r10, this.f20148e, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void E(int r10) {
        this.f20148e.writeInt(r10);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void G(Parcelable r10) {
        this.f20148e.writeParcelable(r10, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void I(String r10) {
        this.f20148e.writeString(r10);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a() {
        int r10 = this.f20152i;
        if (r10 < 0) goto L6;
        int r11 = this.f20147d.get(r10);
        int r12 = this.f20148e.dataPosition();
        int r13 = r12 - r11;
        this.f20148e.setDataPosition(r11);
        this.f20148e.writeInt(r13);
        this.f20148e.setDataPosition(r12);
        return;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public VersionedParcel b() {
        Parcel r10 = this.f20148e;
        int r11 = r10.dataPosition();
        int r12 = this.f20153j;
        if (r12 != this.f20149f) goto L6;
        r12 = this.f20150g;
    L6:
        return new a(r10, r11, r12, this.f20151h + "  ", this.f5107a, this.f5108b, this.f5109c);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean g() {
        if (this.f20148e.readInt() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] i() {
        int r10 = this.f20148e.readInt();
        if (r10 >= 0) goto L6;
        return null;
    L6:
        byte[] r11 = new byte[r10];
        this.f20148e.readByteArray(r11);
        return r11;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f20148e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean m(int r10) {
    L3:
        if (this.f20153j >= this.f20150g) goto L12;
        int r11 = this.f20154k;
        if (r11 == r10) goto L6;
        if (String.valueOf(r11).compareTo(String.valueOf(r10)) > 0) goto L9;
        this.f20148e.setDataPosition(this.f20153j);
        int r12 = this.f20148e.readInt();
        this.f20154k = this.f20148e.readInt();
        this.f20153j += r12;
        goto L3
    L9:
        return false;
    L6:
        return true;
    L12:
        if (this.f20154k == r10) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int o() {
        return this.f20148e.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Parcelable q() {
        return this.f20148e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String s() {
        return this.f20148e.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void w(int r10) {
        a();
        this.f20152i = r10;
        this.f20147d.put(r10, this.f20148e.dataPosition());
        E(0);
        E(r10);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void y(boolean r10) {
        this.f20148e.writeInt(r10 ? 1 : 0);
    }

    public a(Parcel r10, int r11, int r12, String r13, ArrayMap r14, ArrayMap r15, ArrayMap r16) {
        super(r14, r15, r16);
        this.f20147d = new SparseIntArray();
        this.f20152i = -1;
        this.f20154k = -1;
        this.f20148e = r10;
        this.f20149f = r11;
        this.f20150g = r12;
        this.f20153j = r11;
        this.f20151h = r13;
    }
}
