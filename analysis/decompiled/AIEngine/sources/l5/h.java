package l5;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f10265a;

    /* renamed from: b, reason: collision with root package name */
    public final g f10266b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10267c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10268d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f10269e;

    /* renamed from: f, reason: collision with root package name */
    public String f10270f;

    /* renamed from: g, reason: collision with root package name */
    public int f10271g;
    public final AtomicReference<d> h = new AtomicReference<>();

    public h(String str, g gVar, int i10, boolean z) {
        this.f10265a = str;
        this.f10266b = gVar;
        this.f10268d = i10;
        int i11 = gVar.f10263c;
        int i12 = 0;
        while (true) {
            c cVar = gVar.f10261a[i11];
            int i13 = cVar.f10239a;
            if (i13 != 3) {
                if (i13 == 4) {
                    i12 |= cVar.f10241c;
                } else if (i13 == 5) {
                    i12 = -1;
                    break;
                } else if (i13 != 7) {
                    break;
                }
            }
            i11 = cVar.f10240b;
        }
        this.f10267c = i12;
        this.f10269e = z;
    }

    public final String toString() {
        return this.f10265a;
    }
}
