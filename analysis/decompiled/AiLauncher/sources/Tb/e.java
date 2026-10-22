package Tb;

import Yb.z;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final z f5931a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5932b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f5933c;

    /* renamed from: d, reason: collision with root package name */
    public final e f5934d;

    /* renamed from: e, reason: collision with root package name */
    public final f f5935e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5936f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5937g = false;

    public e(z zVar, int i10, e eVar, f fVar, boolean z10) {
        this.f5931a = zVar;
        this.f5932b = i10;
        this.f5933c = z10;
        this.f5934d = eVar;
        this.f5935e = fVar;
    }

    public static e a(z zVar, int i10, e eVar, f fVar) {
        return new e(zVar, i10, eVar, fVar, true);
    }

    public static e b(z zVar, int i10, e eVar, f fVar) {
        return new e(zVar, i10, eVar, fVar, false);
    }
}
