package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.map.e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class e<T extends a> {

    /* renamed from: a, reason: collision with root package name */
    private final c f7156a;

    /* renamed from: b, reason: collision with root package name */
    private final int f7157b;

    /* renamed from: c, reason: collision with root package name */
    private List<T> f7158c;

    /* renamed from: d, reason: collision with root package name */
    private List<e<T>> f7159d;

    public static abstract class a {
        public abstract Point getPoint();
    }

    public e(c cVar) {
        this(cVar, 0);
    }

    public void a(T t4) {
        Point point = t4.getPoint();
        if (this.f7156a.a(point.x, point.y)) {
            a(point.x, point.y, t4);
        }
    }

    private e(double d4, double d5, double d6, double d7, int i4) {
        this(new c(d4, d5, d6, d7), i4);
    }

    private e(c cVar, int i4) {
        this.f7159d = null;
        this.f7156a = cVar;
        this.f7157b = i4;
    }

    private void a(double d4, double d5, T t4) {
        List<e<T>> list = this.f7159d;
        if (list != null) {
            c cVar = this.f7156a;
            if (d5 < cVar.f7155f) {
                if (d4 < cVar.f7154e) {
                    list.get(0).a(d4, d5, t4);
                    return;
                } else {
                    list.get(1).a(d4, d5, t4);
                    return;
                }
            }
            if (d4 < cVar.f7154e) {
                list.get(2).a(d4, d5, t4);
                return;
            } else {
                list.get(3).a(d4, d5, t4);
                return;
            }
        }
        if (this.f7158c == null) {
            this.f7158c = new ArrayList();
        }
        this.f7158c.add(t4);
        if (this.f7158c.size() <= 40 || this.f7157b >= 40) {
            return;
        }
        a();
    }

    private void a() {
        ArrayList arrayList = new ArrayList(4);
        this.f7159d = arrayList;
        c cVar = this.f7156a;
        arrayList.add(new e(cVar.f7150a, cVar.f7154e, cVar.f7151b, cVar.f7155f, this.f7157b + 1));
        List<e<T>> list = this.f7159d;
        c cVar2 = this.f7156a;
        list.add(new e<>(cVar2.f7154e, cVar2.f7152c, cVar2.f7151b, cVar2.f7155f, this.f7157b + 1));
        List<e<T>> list2 = this.f7159d;
        c cVar3 = this.f7156a;
        list2.add(new e<>(cVar3.f7150a, cVar3.f7154e, cVar3.f7155f, cVar3.f7153d, this.f7157b + 1));
        List<e<T>> list3 = this.f7159d;
        c cVar4 = this.f7156a;
        list3.add(new e<>(cVar4.f7154e, cVar4.f7152c, cVar4.f7155f, cVar4.f7153d, this.f7157b + 1));
        List<T> list4 = this.f7158c;
        this.f7158c = null;
        Iterator<T> it = list4.iterator();
        while (it.hasNext()) {
            a(r7.getPoint().x, r7.getPoint().y, it.next());
        }
    }
}
