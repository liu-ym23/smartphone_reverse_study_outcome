package v2;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public int f13375a;

    /* renamed from: b, reason: collision with root package name */
    public int f13376b = -1;

    public b(int i10) {
        this.f13375a = i10;
    }

    public abstract String a();

    public abstract Object b();

    public abstract b c();

    public final boolean d() {
        return this.f13375a == 1;
    }

    public final boolean e() {
        return this.f13375a == 2;
    }

    public final boolean f() {
        return this.f13375a == 0;
    }

    public abstract void g(Object obj);

    public final String h() {
        int i10 = this.f13375a;
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? "?" : "Object" : "Array" : "root";
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        int i10 = this.f13375a;
        if (i10 != 0) {
            if (i10 != 1) {
                sb2.append('{');
                String strA = a();
                if (strA != null) {
                    sb2.append('\"');
                    int[] iArr = x2.a.h;
                    int length = iArr.length;
                    int length2 = strA.length();
                    while (i < length2) {
                        char cCharAt = strA.charAt(i);
                        if (cCharAt >= length || iArr[cCharAt] == 0) {
                            sb2.append(cCharAt);
                        } else {
                            sb2.append('\\');
                            int i11 = iArr[cCharAt];
                            if (i11 < 0) {
                                sb2.append("u00");
                                char[] cArr = x2.a.f13703a;
                                sb2.append(cArr[cCharAt >> 4]);
                                sb2.append(cArr[cCharAt & 15]);
                            } else {
                                sb2.append((char) i11);
                            }
                        }
                        i++;
                    }
                    sb2.append('\"');
                } else {
                    sb2.append('?');
                }
                sb2.append('}');
            } else {
                sb2.append('[');
                int i12 = this.f13376b;
                sb2.append(i12 >= 0 ? i12 : 0);
                sb2.append(']');
            }
        } else {
            sb2.append("/");
        }
        return sb2.toString();
    }
}
