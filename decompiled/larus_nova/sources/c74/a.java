package c74;

import com.bytedance.badger.t.n;
import com.bytedance.badger.t.o;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f22641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f22642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f22643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f22644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f22645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f22646g;

    public a(int r100, long r101, long r102, long r103, boolean r104, boolean r105, boolean r110) {
        this.f22640a = r100;
        this.f22641b = r101;
        this.f22642c = r102;
        this.f22643d = r103;
        this.f22644e = r104;
        this.f22645f = r105;
        this.f22646g = r110;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L43:
        return true;
    L5:
        if ((r100 instanceof a) == false) goto L42;
        a r101 = (a) r100;
        if (this.f22640a != r101.f22640a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L42;
        if (this.f22641b != r101.f22641b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L42;
        if (this.f22642c != r101.f22642c) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L42;
        if (this.f22643d != r101.f22643d) goto L24;
        boolean r105 = true;
    L25:
        if (r105 == false) goto L42;
        if (this.f22644e != r101.f22644e) goto L29;
        boolean r106 = true;
    L30:
        if (r106 == false) goto L42;
        if (this.f22645f != r101.f22645f) goto L34;
        boolean r107 = true;
    L35:
        if (r107 == false) goto L42;
        if (this.f22646g != r101.f22646g) goto L39;
        boolean r108 = true;
    L40:
        if (r108 == false) goto L42;
    L39:
        r108 = false;
        goto L40
    L34:
        r107 = false;
        goto L35
    L29:
        r106 = false;
        goto L30
    L24:
        r105 = false;
        goto L25
    L19:
        r104 = false;
        goto L20
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L42:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    public final int hashCode() {
        int r100 = this.f22640a * 31;
        long r101 = this.f22641b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f22642c;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f22643d;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        boolean r107 = this.f22644e;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L5;
        r109 = 1;
    L5:
        int r110 = (r106 + r109) * 31;
        boolean r111 = this.f22645f;
        ?? r112 = r111;
        if (r111 == false) goto L8;
        r112 = 1;
    L8:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.f22646g;
        if (r114 == true) goto L13;
        r108 = r114;
    L13:
        return r113 + r108;
    }

    public final String toString() {
        return "FeatureMetrics(featureId=" + this.f22640a + ", totalTimeMs=" + this.f22641b + ", queueWaitTimeMs=" + this.f22642c + ", collectTimeMs=" + this.f22643d + ", hasError=" + this.f22644e + ", isFromStore=" + this.f22645f + ", isFromAsync=" + this.f22646g + ")";
    }

    @Override // com.bytedance.badger.t.n
    public final void a(o r100) {
        r100.f199208a.write(16);
        r100.a(this.f22640a);
        r100.b(this.f22641b);
        r100.b(this.f22642c);
        r100.b(this.f22643d);
        boolean r101 = this.f22644e;
        r100.f199208a.write(5);
        r100.f199208a.write(r101 ? 1 : 0);
        boolean r102 = this.f22645f;
        r100.f199208a.write(5);
        r100.f199208a.write(r102 ? 1 : 0);
        boolean r103 = this.f22646g;
        r100.f199208a.write(5);
        r100.f199208a.write(r103 ? 1 : 0);
        r100.f199208a.write(17);
    }
}
