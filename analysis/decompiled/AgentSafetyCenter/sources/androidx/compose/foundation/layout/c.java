package androidx.compose.foundation.layout;

import b0.s;
import java.lang.invoke.VarHandle;
import w.j;
import w0.e;
import w0.m;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final FillElement f902a = new FillElement(2, 1.0f);

    /* renamed from: b, reason: collision with root package name */
    public static final FillElement f903b = new FillElement(1, 1.0f);

    /* renamed from: c, reason: collision with root package name */
    public static final FillElement f904c = new FillElement(3, 1.0f);

    /* renamed from: d, reason: collision with root package name */
    public static final WrapContentElement f905d;

    /* renamed from: e, reason: collision with root package name */
    public static final WrapContentElement f906e;

    /* renamed from: f, reason: collision with root package name */
    public static final WrapContentElement f907f;

    /* renamed from: g, reason: collision with root package name */
    public static final WrapContentElement f908g;

    static {
        w0.c cVar = w0.b.f15101r;
        int i = 1;
        f905d = new WrapContentElement(2, new j(cVar, i), cVar);
        w0.c cVar2 = w0.b.f15100q;
        f906e = new WrapContentElement(2, new j(cVar2, i), cVar2);
        e eVar = w0.b.i;
        int i3 = 7;
        f907f = new WrapContentElement(3, new s(eVar, i3), eVar);
        e eVar2 = w0.b.f15089c;
        f908g = new WrapContentElement(3, new s(eVar2, i3), eVar2);
    }

    public static final m a(float f5, float f10) {
        UnspecifiedConstraintsElement unspecifiedConstraintsElement = new UnspecifiedConstraintsElement();
        unspecifiedConstraintsElement.f895c = f5;
        unspecifiedConstraintsElement.f896f = f10;
        VarHandle.storeStoreFence();
        return unspecifiedConstraintsElement;
    }

    public static final m b(m mVar, float f5) {
        return mVar.d(f5 == 1.0f ? f902a : new FillElement(2, f5));
    }

    public static final m c(m mVar, float f5) {
        return mVar.d(new SizeElement(0.0f, f5, 0.0f, f5, 5));
    }

    public static m d(m mVar, float f5, float f10, int i) {
        return mVar.d(new SizeElement(0.0f, (i & 1) != 0 ? Float.NaN : f5, 0.0f, (i & 2) != 0 ? Float.NaN : f10, 5));
    }

    public static final m e(m mVar, float f5) {
        return mVar.d(new SizeElement(f5, f5, f5, f5, false));
    }

    public static final m f(m mVar, float f5) {
        return mVar.d(new SizeElement(f5, f5, f5, f5, true));
    }

    public static m g(m mVar) {
        return mVar.d(new SizeElement(h0.m.f5059a, Float.NaN, h0.m.f5060b, Float.NaN, true));
    }

    public static final m h(m mVar, float f5) {
        return mVar.d(new SizeElement(f5, 0.0f, f5, 0.0f, 10));
    }

    public static m i(m mVar, float f5, float f10, int i) {
        return mVar.d(new SizeElement((i & 1) != 0 ? Float.NaN : f5, 0.0f, (i & 2) != 0 ? Float.NaN : f10, 0.0f, 10));
    }

    public static m j(m mVar) {
        e eVar = w0.b.i;
        return mVar.d(k.a(eVar, eVar) ? f907f : k.a(eVar, w0.b.f15089c) ? f908g : new WrapContentElement(3, new s(eVar, 7), eVar));
    }

    public static m k() {
        w0.c cVar = w0.b.f15102s;
        return cVar.equals(w0.b.f15101r) ? f905d : cVar.equals(w0.b.f15100q) ? f906e : new WrapContentElement(2, new j(cVar, 1), cVar);
    }
}
