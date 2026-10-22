package Tb;

import Yb.z;
import bc.InterfaceC1478b;

/* loaded from: classes5.dex */
public class f implements InterfaceC1478b {

    /* renamed from: a, reason: collision with root package name */
    public final z f5938a;

    /* renamed from: b, reason: collision with root package name */
    public final char f5939b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f5940c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f5941d;

    /* renamed from: e, reason: collision with root package name */
    public f f5942e;

    /* renamed from: f, reason: collision with root package name */
    public f f5943f;

    /* renamed from: g, reason: collision with root package name */
    public int f5944g = 1;

    /* renamed from: h, reason: collision with root package name */
    public int f5945h = 1;

    public f(z zVar, char c10, boolean z10, boolean z11, f fVar) {
        this.f5938a = zVar;
        this.f5939b = c10;
        this.f5940c = z10;
        this.f5941d = z11;
        this.f5942e = fVar;
    }

    @Override // bc.InterfaceC1478b
    public boolean a() {
        return this.f5941d;
    }

    @Override // bc.InterfaceC1478b
    public int b() {
        return this.f5945h;
    }

    @Override // bc.InterfaceC1478b
    public boolean c() {
        return this.f5940c;
    }

    @Override // bc.InterfaceC1478b
    public int length() {
        return this.f5944g;
    }
}
