package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.g0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0258g0 implements V {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0247b f3476a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3477b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f3478c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3479d;

    public C0258g0(A a4, String str, Object[] objArr) {
        this.f3476a = a4;
        this.f3477b = str;
        this.f3478c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f3479d = cCharAt;
            return;
        }
        int i4 = cCharAt & 8191;
        int i5 = 1;
        int i6 = 13;
        while (true) {
            int i7 = i5 + 1;
            char cCharAt2 = str.charAt(i5);
            if (cCharAt2 < 55296) {
                this.f3479d = i4 | (cCharAt2 << i6);
                return;
            } else {
                i4 |= (cCharAt2 & 8191) << i6;
                i6 += 13;
                i5 = i7;
            }
        }
    }

    public final AbstractC0247b a() {
        return this.f3476a;
    }

    public final Object[] b() {
        return this.f3478c;
    }

    public final String c() {
        return this.f3477b;
    }

    public final int d() {
        return (this.f3479d & 1) == 1 ? 1 : 2;
    }
}
