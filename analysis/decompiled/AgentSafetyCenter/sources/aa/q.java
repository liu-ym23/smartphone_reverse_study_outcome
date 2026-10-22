package aa;

import android.util.Log;
import jb.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class q implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f356c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ f f357f;

    public /* synthetic */ q(int i) {
        this.f356c = i;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f356c;
        v vVar = v.f6774a;
        f fVar = this.f357f;
        switch (i) {
            case 0:
                z9.g gVar = (z9.g) obj;
                gVar.getClass();
                gVar.f16531a = fVar.f315c;
                gVar.f16533c = 2;
                gVar.f16534d = fVar.f316d;
                gVar.f16535e = fVar.f317e;
                if (!(fVar instanceof p)) {
                    gVar.f16537g = 0;
                    gVar.f16538h = 0.0f;
                    gVar.i = 0;
                    gVar.f16539j = 0;
                    gVar.f16540k = 0;
                    gVar.f16541l = 0.5f;
                    gVar.f16542m = 0;
                    break;
                } else {
                    p pVar = (p) fVar;
                    gVar.f16537g = pVar.f350f.f314c;
                    gVar.f16538h = pVar.f351g;
                    gVar.i = pVar.f352h;
                    gVar.f16539j = pVar.i;
                    gVar.f16540k = pVar.f353j;
                    gVar.f16541l = pVar.f354k;
                    gVar.f16542m = p5.f.f(pVar);
                    break;
                }
            default:
                obj.getClass();
                z9.f fVar2 = z9.f.f16523a;
                Class cls = z9.f.f16529g;
                z9.f.b(obj, "setBlurRadius", new Class[]{cls}, Integer.valueOf((int) fVar.f315c));
                z9.f.b(obj, "setColor", new Class[]{cls}, 16777215);
                Class cls2 = z9.f.f16530h;
                z9.f.b(obj, "setFrost", new Class[]{cls2}, Float.valueOf(fVar.f317e));
                z9.f.b(obj, "setDodge", new Class[]{cls2}, Float.valueOf(fVar.f316d));
                if (!(fVar instanceof p)) {
                    z9.f.b(obj, "setBlurGradient", new Class[]{cls, cls}, 0, 0);
                    z9.f.b(obj, "setColorGradient", new Class[]{cls, cls, cls, cls2, cls}, 0, 0, 0, Float.valueOf(0.5f), 0);
                    break;
                } else {
                    p pVar2 = (p) fVar;
                    Log.d("MotionKitGradientBlur", "reflect setBlurGradient mode=" + pVar2.f350f.f314c + " scale=" + pVar2.f351g);
                    z9.f.b(obj, "setBlurGradient", new Class[]{cls, cls}, Integer.valueOf(pVar2.f350f.f314c), Integer.valueOf(pVar2.f351g));
                    z9.f.b(obj, "setColorGradient", new Class[]{cls, cls, cls, cls2, cls}, Integer.valueOf(pVar2.f352h), Integer.valueOf(pVar2.i), Integer.valueOf(pVar2.f353j), Float.valueOf(pVar2.f354k), Integer.valueOf(p5.f.f(pVar2)));
                    break;
                }
        }
        return vVar;
    }
}
