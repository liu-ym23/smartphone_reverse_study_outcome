package com.amap.api.col.jmsl;

import android.os.Looper;

/* loaded from: classes.dex */
public final class T1 extends AbstractRunnableC1545d2 {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C1569j2 f16356d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f16357e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C1541c2 f16358f;

    public T1(C1541c2 c1541c2, C1569j2 c1569j2, boolean z10) {
        this.f16358f = c1541c2;
        this.f16356d = c1569j2;
        this.f16357e = z10;
    }

    @Override // com.amap.api.col.jmsl.AbstractRunnableC1545d2
    public final void runTask() {
        try {
            synchronized (Looper.getMainLooper()) {
                D1.d(this.f16356d);
            }
            if (this.f16357e) {
                C1573k2.a(this.f16358f.f16548d);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
