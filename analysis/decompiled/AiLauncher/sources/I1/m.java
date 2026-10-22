package I1;

import com.alibaba.fastjson.JSONArray;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class m extends J1.d {

    /* renamed from: e, reason: collision with root package name */
    public final int f3336e;

    /* renamed from: f, reason: collision with root package name */
    public final List f3337f;

    /* renamed from: g, reason: collision with root package name */
    public final b f3338g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f3339h;

    /* renamed from: i, reason: collision with root package name */
    public final Map f3340i;

    /* renamed from: j, reason: collision with root package name */
    public final Collection f3341j;

    public m(b bVar, List list, int i10) {
        super(null, null, 0);
        this.f3338g = bVar;
        this.f3336e = i10;
        this.f3337f = list;
        this.f3339h = null;
        this.f3340i = null;
        this.f3341j = null;
    }

    @Override // J1.d
    public void b(b bVar, Object obj, Type type, Map<String, Object> map) {
    }

    @Override // J1.d
    public void g(Object obj, Object obj2) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        JSONArray jSONArray;
        Object objR;
        Map map = this.f3340i;
        if (map != null) {
            map.put(this.f3339h, obj2);
            return;
        }
        Collection collection = this.f3341j;
        if (collection != null) {
            collection.add(obj2);
            return;
        }
        this.f3337f.set(this.f3336e, obj2);
        List list = this.f3337f;
        if (!(list instanceof JSONArray) || (objR = (jSONArray = (JSONArray) list).R()) == null || Array.getLength(objR) <= this.f3336e) {
            return;
        }
        if (jSONArray.P() != null) {
            obj2 = L1.d.c(obj2, jSONArray.P(), this.f3338g.f3255b);
        }
        Array.set(objR, this.f3336e, obj2);
    }

    public m(Map map, Object obj) {
        super(null, null, 0);
        this.f3338g = null;
        this.f3336e = -1;
        this.f3337f = null;
        this.f3339h = obj;
        this.f3340i = map;
        this.f3341j = null;
    }

    public m(Collection collection) {
        super(null, null, 0);
        this.f3338g = null;
        this.f3336e = -1;
        this.f3337f = null;
        this.f3339h = null;
        this.f3340i = null;
        this.f3341j = collection;
    }
}
