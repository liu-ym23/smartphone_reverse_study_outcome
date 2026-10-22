package com.amap.api.col.jmsl;

/* renamed from: com.amap.api.col.jmsl.w1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1619w1 {

    /* renamed from: a, reason: collision with root package name */
    public AbstractC1619w1 f17018a;

    public AbstractC1619w1() {
    }

    public int a() {
        AbstractC1619w1 abstractC1619w1 = this.f17018a;
        return Math.min(Integer.MAX_VALUE, abstractC1619w1 != null ? abstractC1619w1.a() : Integer.MAX_VALUE);
    }

    public void b(int i10) {
        AbstractC1619w1 abstractC1619w1 = this.f17018a;
        if (abstractC1619w1 != null) {
            abstractC1619w1.b(i10);
        }
    }

    public void c(boolean z10) {
        AbstractC1619w1 abstractC1619w1 = this.f17018a;
        if (abstractC1619w1 != null) {
            abstractC1619w1.c(z10);
        }
    }

    public boolean d() {
        AbstractC1619w1 abstractC1619w1 = this.f17018a;
        if (abstractC1619w1 != null ? abstractC1619w1.d() : true) {
            return e();
        }
        return false;
    }

    public abstract boolean e();

    public AbstractC1619w1(AbstractC1619w1 abstractC1619w1) {
        this.f17018a = abstractC1619w1;
    }
}
