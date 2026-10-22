package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: VersionedParcelParcel.java */
/* JADX INFO: loaded from: classes.dex */
class b extends a {
    private static final String TAG = "VersionedParcelParcel";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseIntArray f2901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Parcel f2902e;
    private final int f;
    private final int g;
    private final String h;
    private int i;
    private int j;
    private int k;

    b(Parcel r9) {
        this(r9, r9.dataPosition(), r9.dataSize(), "", new androidx.b.a(), new androidx.b.a(), new androidx.b.a());
    }

    private b(Parcel r1, int r2, int r3, String r4, androidx.b.a<String, Method> r5, androidx.b.a<String, Method> r6, androidx.b.a<String, Class> r7) {
        super(r5, r6, r7);
        this.f2901d = new SparseIntArray();
        this.i = -1;
        this.j = 0;
        this.k = -1;
        this.f2902e = r1;
        this.f = r2;
        this.g = r3;
        this.j = r2;
        this.h = r4;
    }

    @Override // androidx.versionedparcelable.a
    public boolean b(int r5) {
    L3:
        if (this.j >= this.g) goto L12;
        int r0 = this.k;
        if (r0 == r5) goto L6;
        if (String.valueOf(r0).compareTo(String.valueOf(r5)) > 0) goto L9;
        this.f2902e.setDataPosition(this.j);
        int r1 = this.f2902e.readInt();
        this.k = this.f2902e.readInt();
        this.j += r1;
        goto L3
    L9:
        return false;
    L6:
        return true;
    L12:
        if (this.k != r5) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // androidx.versionedparcelable.a
    public void c(int r3) {
        b();
        this.i = r3;
        this.f2901d.put(r3, this.f2902e.dataPosition());
        a(0);
        a(r3);
    }

    @Override // androidx.versionedparcelable.a
    public void b() {
        int r0 = this.i;
        if (r0 < 0) goto L6;
        int r1 = this.f2901d.get(r0);
        int r2 = this.f2902e.dataPosition();
        int r3 = r2 - r1;
        this.f2902e.setDataPosition(r1);
        this.f2902e.writeInt(r3);
        this.f2902e.setDataPosition(r2);
        return;
    }

    @Override // androidx.versionedparcelable.a
    public a c() {
        Parcel r1 = this.f2902e;
        int r2 = r1.dataPosition();
        int r0 = this.j;
        if (r0 != this.f) goto L6;
        r0 = this.g;
    L6:
        return new b(r1, r2, r0, this.h + "  ", this.f2898a, this.f2899b, this.f2900c);
    }

    @Override // androidx.versionedparcelable.a
    public void a(byte[] r3) {
        if (r3 == null) goto L4;
        this.f2902e.writeInt(r3.length);
        this.f2902e.writeByteArray(r3);
        return;
    L4:
        this.f2902e.writeInt(-1);
    }

    @Override // androidx.versionedparcelable.a
    public void a(int r1) {
        this.f2902e.writeInt(r1);
    }

    @Override // androidx.versionedparcelable.a
    public void a(String r1) {
        this.f2902e.writeString(r1);
    }

    @Override // androidx.versionedparcelable.a
    public void a(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        this.f2902e.writeParcelable(r4, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void a(boolean r1) {
        this.f2902e.writeInt(r1 ? 1 : 0);
    }

    @Override // androidx.versionedparcelable.a
    public void a(CharSequence r3) {
        TextUtils.writeToParcel((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"), this.f2902e, 0);
    }

    @Override // androidx.versionedparcelable.a
    public CharSequence g() {
        return (CharSequence) ZeusTransformUtils.preCheckCast(TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f2902e), CharSequence.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.versionedparcelable.a
    public int d() {
        return this.f2902e.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public String e() {
        return this.f2902e.readString();
    }

    @Override // androidx.versionedparcelable.a
    public byte[] f() {
        int r0 = this.f2902e.readInt();
        if (r0 >= 0) goto L6;
        return null;
    L6:
        byte[] r1 = new byte[r0];
        this.f2902e.readByteArray(r1);
        return r1;
    }

    @Override // androidx.versionedparcelable.a
    public <T extends Parcelable> T h() {
        return (T) this.f2902e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public boolean i() {
        if (this.f2902e.readInt() == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
