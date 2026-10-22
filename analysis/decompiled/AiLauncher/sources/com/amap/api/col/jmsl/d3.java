package com.amap.api.col.jmsl;

import com.stepos.aiengine.algorithm.asr.AsrSseStreamParamKeys;

/* loaded from: classes.dex */
public final class d3 extends AbstractC1619w1 {

    /* renamed from: b, reason: collision with root package name */
    public long f16584b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16585c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16586d;

    /* renamed from: e, reason: collision with root package name */
    public int f16587e;

    /* renamed from: f, reason: collision with root package name */
    public long f16588f;

    public d3(boolean z10, AbstractC1619w1 abstractC1619w1, long j10, int i10) {
        super(abstractC1619w1);
        this.f16586d = false;
        this.f16585c = z10;
        this.f16588f = j10;
        this.f16587e = i10;
    }

    @Override // com.amap.api.col.jmsl.AbstractC1619w1
    public final int a() {
        return 320000;
    }

    @Override // com.amap.api.col.jmsl.AbstractC1619w1
    public final boolean e() {
        if (this.f16586d && this.f16588f <= this.f16587e) {
            return true;
        }
        if (!this.f16585c || this.f16588f >= this.f16587e) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f16584b < AsrSseStreamParamKeys.MAX_STREAM_MAX_DURATION_MS) {
            return false;
        }
        this.f16584b = jCurrentTimeMillis;
        return true;
    }

    public final void f(int i10) {
        if (i10 <= 0) {
            return;
        }
        this.f16588f += i10;
    }

    public final void g(boolean z10) {
        this.f16586d = z10;
    }

    public final long h() {
        return this.f16588f;
    }
}
