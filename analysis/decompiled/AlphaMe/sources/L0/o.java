package L0;

import G0.r;
import com.airbnb.lottie.v;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class o implements b {

    /* renamed from: a, reason: collision with root package name */
    public final String f1203a;

    /* renamed from: b, reason: collision with root package name */
    public final K0.b f1204b;

    /* renamed from: c, reason: collision with root package name */
    public final List f1205c;

    /* renamed from: d, reason: collision with root package name */
    public final K0.a f1206d;

    /* renamed from: e, reason: collision with root package name */
    public final K0.a f1207e;

    /* renamed from: f, reason: collision with root package name */
    public final K0.b f1208f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1209g;

    /* renamed from: h, reason: collision with root package name */
    public final int f1210h;

    /* renamed from: i, reason: collision with root package name */
    public final float f1211i;

    public o(String str, K0.b bVar, ArrayList arrayList, K0.a aVar, K0.a aVar2, K0.b bVar2, int i4, int i5, float f4) {
        this.f1203a = str;
        this.f1204b = bVar;
        this.f1205c = arrayList;
        this.f1206d = aVar;
        this.f1207e = aVar2;
        this.f1208f = bVar2;
        this.f1209g = i4;
        this.f1210h = i5;
        this.f1211i = f4;
    }

    @Override // L0.b
    public final G0.c a(v vVar, M0.b bVar) {
        return new r(vVar, bVar, this);
    }
}
