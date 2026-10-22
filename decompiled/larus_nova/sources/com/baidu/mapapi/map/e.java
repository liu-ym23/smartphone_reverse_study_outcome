package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.map.e.a;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
class e<T extends a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f31591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f31592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<T> f31593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<e<T>> f31594d;

    public static abstract class a {
        public abstract Point getPoint();

        public a() {
        }
    }

    private void a() {
        ArrayList r100 = new ArrayList(4);
        this.f31594d = r100;
        c r101 = this.f31591a;
        r100.add(new e(r101.f31585a, r101.f31589e, r101.f31586b, r101.f31590f, this.f31592b + 1));
        List<e<T>> r102 = this.f31594d;
        c r103 = this.f31591a;
        r102.add(new e(r103.f31589e, r103.f31587c, r103.f31586b, r103.f31590f, this.f31592b + 1));
        List<e<T>> r104 = this.f31594d;
        c r105 = this.f31591a;
        r104.add(new e(r105.f31585a, r105.f31589e, r105.f31590f, r105.f31588d, this.f31592b + 1));
        List<e<T>> r106 = this.f31594d;
        c r107 = this.f31591a;
        r106.add(new e(r107.f31589e, r107.f31587c, r107.f31590f, r107.f31588d, this.f31592b + 1));
        List<T> r108 = this.f31593c;
        this.f31593c = null;
        Iterator<T> r109 = r108.iterator();
    L4:
        if (r109.hasNext() == false) goto L6;
        T r110 = r109.next();
        a(r110.getPoint().x, r110.getPoint().y, r110);
        goto L4
    }

    public e(c r100) {
        this(r100, 0);
    }

    public void a(T r100) {
        Point r101 = r100.getPoint();
        if (this.f31591a.a(r101.x, r101.y) == false) goto L6;
        a(r101.x, r101.y, r100);
        return;
    }

    private e(c r100, int r101) {
        this.f31594d = null;
        this.f31591a = r100;
        this.f31592b = r101;
    }

    private void a(double r100, double r110, T r111) {
        List<e<T>> r101 = this.f31594d;
        if (r101 == null) goto L16;
        c r102 = this.f31591a;
        if (r110 >= r102.f31590f) goto L11;
        if (r100 >= r102.f31589e) goto L9;
        ((e) ListProtector.get(r101, 0)).a(r100, r110, r111);
        return;
    L9:
        ((e) ListProtector.get(r101, 1)).a(r100, r110, r111);
        return;
    L11:
        if (r100 >= r102.f31589e) goto L13;
        ((e) ListProtector.get(r101, 2)).a(r100, r110, r111);
        return;
    L13:
        ((e) ListProtector.get(r101, 3)).a(r100, r110, r111);
        return;
    L16:
        if (this.f31593c != null) goto L18;
        this.f31593c = new ArrayList();
    L18:
        this.f31593c.add(r111);
        if (this.f31593c.size() > 40) goto L21;
        return;
    L21:
        if (this.f31592b >= 40) goto L28;
        a();
        return;
    }

    private e(double r110, double r111, double r112, double r113, int r114) {
        this(new c(r110, r111, r112, r113), r114);
    }
}
