package com.obric.oui.orecyclerview.widget;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BatchingListUpdateCallback.java */
/* JADX INFO: loaded from: classes4.dex */
public class e implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final q f35728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f35729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f35730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f35731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Object f35732e;

    public e(q r3) {
        q r4 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
        this.f35729b = 0;
        this.f35730c = -1;
        this.f35731d = -1;
        this.f35732e = null;
        this.f35728a = r4;
    }

    public void a() {
        int r0 = this.f35729b;
        if (r0 != 0) goto L6;
        return;
    L6:
        if (r0 != 1) goto L8;
        this.f35728a.a(this.f35730c, this.f35731d);
    L15:
        this.f35732e = null;
        this.f35729b = 0;
        return;
    L8:
        if (r0 != 2) goto L10;
        this.f35728a.b(this.f35730c, this.f35731d);
        goto L15
    L10:
        if (r0 != 3) goto L15;
        this.f35728a.a(this.f35730c, this.f35731d, this.f35732e);
        goto L15
    }

    @Override // com.obric.oui.orecyclerview.widget.q
    public void a(int r5, int r6) {
        if (this.f35729b != 1) goto L10;
        int r0 = this.f35730c;
        if (r5 < r0) goto L10;
        int r2 = this.f35731d;
        if (r5 > (r0 + r2)) goto L10;
        this.f35731d = r2 + r6;
        this.f35730c = Math.min(r5, r0);
        return;
    L10:
        a();
        this.f35730c = r5;
        this.f35731d = r6;
        this.f35729b = 1;
    }

    @Override // com.obric.oui.orecyclerview.widget.q
    public void b(int r4, int r5) {
        if (this.f35729b != 2) goto L10;
        int r0 = this.f35730c;
        if (r0 < r4) goto L10;
        if (r0 > (r4 + r5)) goto L10;
        this.f35731d += r5;
        this.f35730c = r4;
        return;
    L10:
        a();
        this.f35730c = r4;
        this.f35731d = r5;
        this.f35729b = 2;
    }

    @Override // com.obric.oui.orecyclerview.widget.q
    public void c(int r1, int r2) {
        a();
        this.f35728a.c(r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.q
    public void a(int r6, int r7, Object r8) {
        if (this.f35729b != 3) goto L12;
        int r0 = this.f35730c;
        int r2 = this.f35731d;
        if (r6 > (r0 + r2)) goto L12;
        int r3 = r6 + r7;
        if (r3 < r0) goto L12;
        if (this.f35732e != r8) goto L12;
        this.f35730c = Math.min(r6, r0);
        this.f35731d = Math.max(r2 + r0, r3) - this.f35730c;
        return;
    L12:
        a();
        this.f35730c = r6;
        this.f35731d = r7;
        this.f35732e = r8;
        this.f35729b = 3;
    }
}
