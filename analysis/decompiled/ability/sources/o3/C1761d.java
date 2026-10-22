package o3;

import java.io.File;

/* renamed from: o3.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1761d {

    /* renamed from: a, reason: collision with root package name */
    public final String f5420a;
    public final long[] b;
    public boolean c;
    public R5.b d;
    public final /* synthetic */ f e;

    public C1761d(f fVar, String str) {
        this.e = fVar;
        this.f5420a = str;
        this.b = new long[fVar.g];
    }

    public final File a(int i) {
        return new File(this.e.f5422a, this.f5420a + "." + i);
    }

    public final File b(int i) {
        return new File(this.e.f5422a, this.f5420a + "." + i + ".tmp");
    }

    public final String c() {
        StringBuilder sb = new StringBuilder();
        for (long j5 : this.b) {
            sb.append(' ');
            sb.append(j5);
        }
        return sb.toString();
    }
}
