package androidx.recyclerview.widget;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BatchingListUpdateCallback.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final r f2474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f2477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Object f2478e;

    public e(r r3) {
        r r4 = (r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.aiagent.plugin");
        this.f2475b = 0;
        this.f2476c = -1;
        this.f2477d = -1;
        this.f2478e = null;
        this.f2474a = r4;
    }

    public void a() {
        int r0 = this.f2475b;
        if (r0 != 0) goto L6;
        return;
    L6:
        if (r0 != 1) goto L8;
        this.f2474a.a(this.f2476c, this.f2477d);
    L15:
        this.f2478e = null;
        this.f2475b = 0;
        return;
    L8:
        if (r0 != 2) goto L10;
        this.f2474a.b(this.f2476c, this.f2477d);
        goto L15
    L10:
        if (r0 != 3) goto L15;
        this.f2474a.a(this.f2476c, this.f2477d, this.f2478e);
        goto L15
    }

    @Override // androidx.recyclerview.widget.r
    public void a(int r5, int r6) {
        if (this.f2475b != 1) goto L10;
        int r0 = this.f2476c;
        if (r5 < r0) goto L10;
        int r2 = this.f2477d;
        if (r5 > (r0 + r2)) goto L10;
        this.f2477d = r2 + r6;
        this.f2476c = Math.min(r5, r0);
        return;
    L10:
        a();
        this.f2476c = r5;
        this.f2477d = r6;
        this.f2475b = 1;
    }

    @Override // androidx.recyclerview.widget.r
    public void b(int r4, int r5) {
        if (this.f2475b != 2) goto L10;
        int r0 = this.f2476c;
        if (r0 < r4) goto L10;
        if (r0 > (r4 + r5)) goto L10;
        this.f2477d += r5;
        this.f2476c = r4;
        return;
    L10:
        a();
        this.f2476c = r4;
        this.f2477d = r5;
        this.f2475b = 2;
    }

    @Override // androidx.recyclerview.widget.r
    public void c(int r1, int r2) {
        a();
        this.f2474a.c(r1, r2);
    }

    @Override // androidx.recyclerview.widget.r
    public void a(int r6, int r7, Object r8) {
        if (this.f2475b != 3) goto L12;
        int r0 = this.f2476c;
        int r2 = this.f2477d;
        if (r6 > (r0 + r2)) goto L12;
        int r3 = r6 + r7;
        if (r3 < r0) goto L12;
        if (this.f2478e != r8) goto L12;
        this.f2476c = Math.min(r6, r0);
        this.f2477d = Math.max(r2 + r0, r3) - this.f2476c;
        return;
    L12:
        a();
        this.f2476c = r6;
        this.f2477d = r7;
        this.f2478e = r8;
        this.f2475b = 3;
    }
}
