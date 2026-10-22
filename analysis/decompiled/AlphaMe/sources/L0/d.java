package L0;

import android.graphics.Path;
import com.airbnb.lottie.v;

/* loaded from: classes.dex */
public final class d implements b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1153a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1154b;

    /* renamed from: c, reason: collision with root package name */
    public final K0.b f1155c;

    /* renamed from: d, reason: collision with root package name */
    public final K0.b f1156d;

    /* renamed from: e, reason: collision with root package name */
    public final Enum f1157e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f1158f;

    /* renamed from: g, reason: collision with root package name */
    public final I.h f1159g;

    /* renamed from: h, reason: collision with root package name */
    public final I.h f1160h;

    /* renamed from: i, reason: collision with root package name */
    public final I.h f1161i;

    /* renamed from: j, reason: collision with root package name */
    public final I.h f1162j;

    public d(String str, f fVar, Path.FillType fillType, K0.a aVar, K0.a aVar2, K0.a aVar3, K0.a aVar4) {
        this.f1153a = 0;
        this.f1157e = fVar;
        this.f1158f = fillType;
        this.f1159g = aVar;
        this.f1160h = aVar2;
        this.f1161i = aVar3;
        this.f1162j = aVar4;
        this.f1154b = str;
        this.f1155c = null;
        this.f1156d = null;
    }

    @Override // L0.b
    public final G0.c a(v vVar, M0.b bVar) {
        switch (this.f1153a) {
            case 0:
                return new G0.h(vVar, bVar, this);
            default:
                return new G0.n(vVar, bVar, this);
        }
    }

    public d(String str, i iVar, K0.b bVar, K0.d dVar, K0.b bVar2, K0.b bVar3, K0.b bVar4, K0.b bVar5, K0.b bVar6) {
        this.f1153a = 1;
        this.f1154b = str;
        this.f1157e = iVar;
        this.f1155c = bVar;
        this.f1158f = dVar;
        this.f1156d = bVar2;
        this.f1159g = bVar3;
        this.f1160h = bVar4;
        this.f1161i = bVar5;
        this.f1162j = bVar6;
    }
}
