package com.bytedance.android.livesdk.log.filter;

/* JADX INFO: loaded from: classes10.dex */
public final class b0 extends a<am2.o> implements r<am2.o> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public am2.o f153293c;

    public b0() {
    }

    public final void J(long r100) {
        am2.o r101 = this.f153293c;
        if (r101 != null) goto L5;
    L6:
        this.f153291b.clear();
        return;
    L5:
        if (r101.f4321a != r100) goto L6;
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void setData(Object r100) {
        this.f153293c = (am2.o) r100;
    }
}
