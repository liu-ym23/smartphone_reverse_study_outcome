package l5;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public c[] f10261a;

    /* renamed from: b, reason: collision with root package name */
    public int f10262b;

    /* renamed from: c, reason: collision with root package name */
    public int f10263c;

    /* renamed from: d, reason: collision with root package name */
    public int f10264d;

    public final int a(int i10, int i11) {
        c cVar;
        int i12;
        if (i10 == 0) {
            return i11;
        }
        if (i11 == 0) {
            return i10;
        }
        int i13 = i10;
        while (true) {
            cVar = this.f10261a[i13 >> 1];
            i12 = i13 & 1;
            int i14 = i12 == 0 ? cVar.f10240b : cVar.f10241c;
            if (i14 == 0) {
                break;
            }
            i13 = i14;
        }
        if (i12 == 0) {
            cVar.f10240b = i11;
            return i10;
        }
        cVar.f10241c = i11;
        return i10;
    }

    public final void b(int i10, int i11) {
        while (i10 != 0) {
            c cVar = this.f10261a[i10 >> 1];
            if ((i10 & 1) == 0) {
                i10 = cVar.f10240b;
                cVar.f10240b = i11;
            } else {
                i10 = cVar.f10241c;
                cVar.f10241c = i11;
            }
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < this.f10262b; i10++) {
            int length = sb2.length();
            sb2.append(i10);
            if (i10 == this.f10263c) {
                sb2.append('*');
            }
            sb2.append("        ".substring(sb2.length() - length));
            sb2.append(this.f10261a[i10]);
            sb2.append('\n');
        }
        return sb2.toString();
    }
}
