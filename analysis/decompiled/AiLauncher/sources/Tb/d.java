package Tb;

import ac.AbstractC1285f;
import ac.InterfaceC1283d;

/* loaded from: classes5.dex */
public class d extends AbstractC1285f {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1283d[] f5927a;

    /* renamed from: b, reason: collision with root package name */
    public int f5928b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f5929c = -1;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5930d = false;

    public d(InterfaceC1283d... interfaceC1283dArr) {
        this.f5927a = interfaceC1283dArr;
    }

    @Override // ac.AbstractC1285f
    public AbstractC1285f a(int i10) {
        this.f5929c = i10;
        return this;
    }

    @Override // ac.AbstractC1285f
    public AbstractC1285f b(int i10) {
        this.f5928b = i10;
        return this;
    }

    @Override // ac.AbstractC1285f
    public AbstractC1285f e() {
        this.f5930d = true;
        return this;
    }

    public InterfaceC1283d[] f() {
        return this.f5927a;
    }

    public int g() {
        return this.f5929c;
    }

    public int h() {
        return this.f5928b;
    }

    public boolean i() {
        return this.f5930d;
    }
}
