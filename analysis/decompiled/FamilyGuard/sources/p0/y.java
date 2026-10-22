package p0;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import l0.C0823b;
import o0.C0888a;

/* loaded from: classes.dex */
public final class y extends l {

    /* renamed from: c, reason: collision with root package name */
    private final int f19342c;

    /* renamed from: d, reason: collision with root package name */
    private final List f19343d;

    /* renamed from: e, reason: collision with root package name */
    private final C0888a f19344e;

    /* renamed from: f, reason: collision with root package name */
    private final Object f19345f;

    /* renamed from: g, reason: collision with root package name */
    private final Map f19346g;

    /* renamed from: h, reason: collision with root package name */
    private final Collection f19347h;

    public y(C0888a c0888a, List list, int i5) {
        super(null, null);
        this.f19344e = c0888a;
        this.f19342c = i5;
        this.f19343d = list;
        this.f19345f = null;
        this.f19346g = null;
        this.f19347h = null;
    }

    @Override // p0.l
    public void d(C0888a c0888a, Object obj, Type type, Map<String, Object> map) {
    }

    @Override // p0.l
    public void h(Object obj, Object obj2) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        C0823b c0823b;
        Object objO;
        Map map = this.f19346g;
        if (map != null) {
            map.put(this.f19345f, obj2);
            return;
        }
        Collection collection = this.f19347h;
        if (collection != null) {
            collection.add(obj2);
            return;
        }
        this.f19343d.set(this.f19342c, obj2);
        List list = this.f19343d;
        if (!(list instanceof C0823b) || (objO = (c0823b = (C0823b) list).O()) == null || Array.getLength(objO) <= this.f19342c) {
            return;
        }
        if (c0823b.L() != null) {
            obj2 = u0.o.h(obj2, c0823b.L(), this.f19344e.u());
        }
        Array.set(objO, this.f19342c, obj2);
    }

    public y(Map map, Object obj) {
        super(null, null);
        this.f19344e = null;
        this.f19342c = -1;
        this.f19343d = null;
        this.f19345f = obj;
        this.f19346g = map;
        this.f19347h = null;
    }

    public y(Collection collection) {
        super(null, null);
        this.f19344e = null;
        this.f19342c = -1;
        this.f19343d = null;
        this.f19345f = null;
        this.f19346g = null;
        this.f19347h = collection;
    }
}
