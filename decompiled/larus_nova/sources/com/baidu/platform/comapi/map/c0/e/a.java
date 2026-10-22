package com.baidu.platform.comapi.map.c0.e;

import android.graphics.Point;
import android.view.MotionEvent;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.v;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f33193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f33194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.baidu.platform.comapi.map.c0.a.C0664a f33195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MapController f33196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private InterfaceC0665a f33197e;

    /* JADX INFO: renamed from: com.baidu.platform.comapi.map.c0.e.a$a, reason: collision with other inner class name */
    public interface InterfaceC0665a {
        boolean a(a r100);
    }

    private void a() {
        this.f33194b = false;
        this.f33195c = null;
        this.f33193a = 0;
    }

    private void a(MotionEvent r100) {
        if (r100.getPointerCount() == 2) goto L5;
        return;
    L5:
        if (this.f33195c == null) goto L45;
        com.baidu.platform.comapi.map.c0.a.C0664a r101 = com.baidu.platform.comapi.map.c0.a.C0664a.a(r100);
        com.baidu.platform.comapi.map.c0.a.C0664a r102 = new com.baidu.platform.comapi.map.c0.a.C0664a(this.f33195c.f33162a, r101.f33162a);
        com.baidu.platform.comapi.map.c0.a.C0664a r103 = new com.baidu.platform.comapi.map.c0.a.C0664a(this.f33195c.f33163b, r101.f33163b);
        int r104 = 0;
        if (Math.abs(r102.b()) < 20.0d) goto L10;
    L12:
        boolean r105 = false;
    L14:
        if ((System.currentTimeMillis() - this.f33193a) >= 200) goto L16;
        boolean r106 = true;
    L18:
        if (this.f33196d == null) goto L41;
        float r107 = r100.getX(1) - r100.getX(0);
        float r108 = r100.getY(1) - r100.getY();
        Point r109 = new Point((int) r100.getRawX(), (int) r100.getRawY());
        Point r110 = new Point((int) (r100.getRawX() + r107), (int) (r100.getRawY() + r108));
        this.f33196d.getMapView();
        if (r105 == false) goto L42;
        if (r106 == true) goto L23;
        return;
    L23:
        if (this.f33194b == false) goto L44;
        List<v> r111 = this.f33196d.getListeners();
        s r112 = this.f33196d.getMapStatusInner();
        if (r111 != null) goto L27;
    L34:
        this.f33197e.a(this);
        return;
    L27:
        if (r104 >= r111.size()) goto L34;
        v r113 = (v) ListProtector.get(r111, r104);
        if (r113 == null) goto L33;
        if (r113.a(r109, r110, r112) == false) goto L33;
        return;
    L33:
        r104 = r104 + 1;
        goto L27
    L44:
        return;
    L42:
        return;
    L41:
        return;
    L16:
        r106 = false;
        goto L18
    L10:
        if (Math.abs(r103.b()) >= 20.0d) goto L12;
        r105 = true;
        goto L14
    }

    private void c(MotionEvent r100) {
        if (r100.getPointerCount() == 2) goto L5;
        return;
    L5:
        this.f33195c = com.baidu.platform.comapi.map.c0.a.C0664a.a(r100);
        this.f33194b = true;
    }

    public void b(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 != 0) goto L5;
        this.f33193a = System.currentTimeMillis();
        return;
    L5:
        if (r101 != 5) goto L7;
    L14:
        c(r100);
        return;
    L7:
        if (r101 != 6) goto L9;
    L13:
        a(r100);
        a();
        return;
    L9:
        if (r101 == 261) goto L14;
        if (r101 == 262) goto L13;
    }

    public a(InterfaceC0665a r100, MapController r101) {
        this.f33193a = 0;
        this.f33194b = false;
        this.f33197e = r100;
        this.f33196d = r101;
    }
}
