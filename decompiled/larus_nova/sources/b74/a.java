package b74;

import com.bytedance.badger.monitor.TriggerStage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f17938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f17939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z64.c f17940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TriggerStage f17941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f17942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f17944g;

    public a(z64.c r100, TriggerStage r101, boolean r102, int r103, long r104) {
        this.f17938a = false;
        this.f17939b = false;
        this.f17940c = r100;
        this.f17941d = r101;
        this.f17942e = r102;
        this.f17943f = r103;
        this.f17944g = r104;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L37:
        return true;
    L5:
        if ((r100 instanceof a) == false) goto L36;
        a r101 = (a) r100;
        if (this.f17938a != r101.f17938a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L36;
        if (this.f17939b != r101.f17939b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L36;
        if (Intrinsics.areEqual(this.f17940c, r101.f17940c) == false) goto L36;
        if (Intrinsics.areEqual(this.f17941d, r101.f17941d) == false) goto L36;
        if (this.f17942e != r101.f17942e) goto L23;
        boolean r104 = true;
    L24:
        if (r104 == false) goto L36;
        if (this.f17943f != r101.f17943f) goto L28;
        boolean r105 = true;
    L29:
        if (r105 == false) goto L36;
        if (this.f17944g != r101.f17944g) goto L33;
        boolean r106 = true;
    L34:
        if (r106 == false) goto L36;
    L33:
        r106 = false;
        goto L34
    L28:
        r105 = false;
        goto L29
    L23:
        r104 = false;
        goto L24
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L36:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        boolean r100 = this.f17938a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f17939b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        z64.c r107 = this.f17940c;
        int r108 = 0;
        if (r107 == null) goto L11;
        int r109 = r107.hashCode();
    L12:
        int r110 = (r106 + r109) * 31;
        TriggerStage r111 = this.f17941d;
        if (r111 == null) goto L15;
        r108 = r111.hashCode();
    L15:
        int r112 = (r110 + r108) * 31;
        boolean r113 = this.f17942e;
        if (r113 == true) goto L19;
        r101 = r113;
    L19:
        int r114 = (((r112 + r101) * 31) + this.f17943f) * 31;
        long r115 = this.f17944g;
        return r114 + ((int) (r115 ^ (r115 >>> 32)));
    L11:
        r109 = 0;
        goto L12
    }

    public final String toString() {
        return "CompTask(finished=" + this.f17938a + ", inProgress=" + this.f17939b + ", request=" + this.f17940c + ", triggerStage=" + this.f17941d + ", isFirstReport=" + this.f17942e + ", cause=" + this.f17943f + ", createTime=" + this.f17944g + ")";
    }
}
