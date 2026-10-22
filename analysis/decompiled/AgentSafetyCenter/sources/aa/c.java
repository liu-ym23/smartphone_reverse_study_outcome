package aa;

import jb.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f308c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ u f309f;

    public /* synthetic */ c(int i) {
        this.f308c = i;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f308c;
        v vVar = v.f6774a;
        u uVar = this.f309f;
        switch (i) {
            case 0:
                z9.g gVar = (z9.g) obj;
                gVar.getClass();
                uVar.getClass();
                gVar.f16543n = true;
                gVar.f16544o = uVar.f367c;
                gVar.f16545p = uVar.f368d;
                gVar.f16546q = uVar.f369e;
                gVar.f16547r = uVar.f370f;
                gVar.f16548s = -1;
                gVar.f16549t = uVar.f371g;
                gVar.f16550u = uVar.f372h;
                gVar.f16551v = uVar.i;
                gVar.f16552w = uVar.f373j;
                gVar.f16553x = uVar.f374k;
                gVar.f16554y = uVar.f375l;
                gVar.f16555z = uVar.f376m;
                gVar.A = uVar.f377n;
                gVar.B = 1.0f;
                gVar.C = 1.0f;
                break;
            case 1:
                obj.getClass();
                z9.f fVar = z9.f.f16523a;
                Class cls = z9.f.i;
                Class cls2 = z9.f.f16530h;
                Class cls3 = z9.f.f16529g;
                uVar.getClass();
                z9.f.b(obj, "setGlassStroke", new Class[]{cls, cls2, cls2, cls2, cls3}, Boolean.TRUE, Float.valueOf(uVar.f367c), Float.valueOf(uVar.f368d), Float.valueOf(uVar.f369e), -1);
                z9.f.b(obj, "setStrokeSpread", new Class[]{cls2}, Float.valueOf(uVar.f370f));
                z9.f.b(obj, "setLightDirs", new Class[]{cls2, cls2, cls2, cls2}, Float.valueOf(uVar.f371g), Float.valueOf(uVar.f372h), Float.valueOf(uVar.i), Float.valueOf(uVar.f373j));
                z9.f.b(obj, "setAmbient", new Class[]{cls2}, Float.valueOf(uVar.f374k));
                z9.f.b(obj, "setAnisoRim", new Class[]{cls}, Boolean.valueOf(uVar.f375l));
                z9.f.b(obj, "setEdgeColors", new Class[]{cls3, cls3}, Integer.valueOf(uVar.f376m), Integer.valueOf(uVar.f377n));
                Float fValueOf = Float.valueOf(1.0f);
                z9.f.b(obj, "setDarkWidth", new Class[]{cls2}, fValueOf);
                z9.f.b(obj, "setEdgeWidth", new Class[]{cls2}, fValueOf);
                break;
            default:
                u uVar2 = (u) obj;
                uVar2.getClass();
                uVar2.f367c = uVar.f367c;
                uVar2.f368d = uVar.f368d;
                uVar2.f369e = uVar.f369e;
                uVar2.f370f = uVar.f370f;
                uVar2.f371g = uVar.f371g;
                uVar2.f372h = uVar.f372h;
                uVar2.i = uVar.i;
                uVar2.f373j = uVar.f373j;
                uVar2.f374k = uVar.f374k;
                uVar2.f375l = uVar.f375l;
                uVar2.f376m = uVar.f376m;
                uVar2.f377n = uVar.f377n;
                break;
        }
        return vVar;
    }
}
