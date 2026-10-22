package p0;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Map;
import o0.C0888a;
import o0.C0895h;
import o0.C0896i;
import o0.InterfaceC0890c;
import u0.C1154d;

/* renamed from: p0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0916c extends l {

    /* renamed from: c, reason: collision with root package name */
    private final Type f19292c;

    /* renamed from: d, reason: collision with root package name */
    private int f19293d;

    /* renamed from: e, reason: collision with root package name */
    private t f19294e;

    public C0916c(C0896i c0896i, Class<?> cls, C1154d c1154d) {
        super(cls, c1154d);
        Type type = c1154d.f22735f;
        if (!(type instanceof ParameterizedType)) {
            this.f19292c = Object.class;
            return;
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
            if (upperBounds.length == 1) {
                type2 = upperBounds[0];
            }
        }
        this.f19292c = type2;
    }

    @Override // p0.l
    public int b() {
        return 14;
    }

    @Override // p0.l
    public void d(C0888a c0888a, Object obj, Type type, Map<String, Object> map) {
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        int iU = interfaceC0890c.U();
        if (iU == 8 || (iU == 4 && interfaceC0890c.N().length() == 0)) {
            if (obj == null) {
                map.put(this.f19303a.f22730a, null);
                return;
            } else {
                i(obj, null);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        C0895h c0895hV = c0888a.v();
        c0888a.w0(c0895hV, obj, this.f19303a.f22730a);
        k(c0888a, type, arrayList);
        c0888a.z0(c0895hV);
        if (obj == null) {
            map.put(this.f19303a.f22730a, arrayList);
        } else {
            h(obj, arrayList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(o0.C0888a r13, java.lang.reflect.Type r14, java.util.Collection r15) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.C0916c.k(o0.a, java.lang.reflect.Type, java.util.Collection):void");
    }
}
