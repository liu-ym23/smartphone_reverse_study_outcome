package ah0;

import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3406a = 0;

    static {
    }

    public static m a(LayoutConfigModel r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutConfigModel");
        m r101 = new m();
        r101.z(r100.k());
        r101.F(r100.q());
        r101.w(r100.g());
        r101.x(r100.h());
        r101.D(r100.o());
        r101.C(r100.n());
        r101.B(r100.m());
        r101.E(new m.f());
        m.f r102 = r101.t();
        int r103 = 0;
        if (r102 == null) goto L21;
        LayoutConfigModel.g r104 = r100.p();
        if (r104 == null) goto L7;
        int r105 = r104.c();
    L8:
        r102.g(r105);
        LayoutConfigModel.g r106 = r100.p();
        if (r106 == null) goto L11;
        int r107 = r106.e();
    L12:
        r102.i(r107);
        LayoutConfigModel.g r108 = r100.p();
        if (r108 == null) goto L15;
        int r109 = r108.d();
    L16:
        r102.h(r109);
        LayoutConfigModel.g r110 = r100.p();
        if (r110 == null) goto L19;
        int r111 = r110.b();
    L20:
        r102.f(r111);
        goto L21
    L19:
        r111 = 0;
        goto L20
    L15:
        r109 = 0;
        goto L16
    L11:
        r107 = 0;
        goto L12
    L7:
        r105 = 0;
    L21:
        r101.u(new m.a());
        m.a r112 = r101.c();
        if (r112 == null) goto L37;
        LayoutConfigModel.b r113 = r100.e();
        if (r113 == null) goto L26;
        int r114 = r113.d();
    L27:
        r112.k(r114);
        LayoutConfigModel.b r115 = r100.e();
        if (r115 == null) goto L30;
        int r116 = r115.c();
    L31:
        r112.i(r116);
        r112.j(r100.j());
        r112.g(r100.d());
        LayoutConfigModel.b r117 = r100.e();
        if (r117 == null) goto L35;
        String r118 = r117.b();
        if (r118 == null) goto L35;
    L36:
        r112.h(r118);
    L35:
        r118 = "#322542";
        goto L36
    L30:
        r116 = 0;
        goto L31
    L26:
        r114 = 0;
    L37:
        r101.v(new m.c());
        m.c r119 = r101.d();
        if (r119 == null) goto L55;
        LayoutConfigModel.d r120 = r100.f();
        if (r120 == null) goto L42;
        int r121 = (int) r120.d();
    L43:
        r119.h(r121);
        LayoutConfigModel.d r122 = r100.f();
        if (r122 == null) goto L46;
        int r123 = (int) r122.e();
    L47:
        r119.i(r123);
        LayoutConfigModel.d r124 = r100.f();
        if (r124 == null) goto L50;
        int r125 = r124.c();
    L51:
        r119.g(r125);
        LayoutConfigModel.d r126 = r100.f();
        if (r126 == null) goto L54;
        r103 = r126.b();
    L54:
        r119.f(r103);
        goto L55
    L50:
        r125 = 0;
        goto L51
    L46:
        r123 = 0;
        goto L47
    L42:
        r121 = 0;
    L55:
        List<LayoutConfigModel.e> r127 = r100.i();
        ArrayList r128 = null;
        if (r127 == null) goto L61;
        List<LayoutConfigModel.e> r129 = r127;
        ArrayList r130 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r129, 10));
        Iterator<T> r131 = r129.iterator();
    L59:
        if (r131.hasNext() == false) goto L62;
        LayoutConfigModel.e r132 = (LayoutConfigModel.e) r131.next();
        m.d r133 = new m.d();
        r133.m(r132.g());
        r133.i(r132.c());
        r133.k(r132.e());
        r133.l(r132.f());
        r133.j(r132.d());
        r133.h(r132.b());
        r130.add(r133);
    L62:
        r101.y(r130);
        List<LayoutConfigModel.f> r134 = r100.l();
        if (r134 == null) goto L68;
        List<LayoutConfigModel.f> r135 = r134;
        r128 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r135, 10));
        Iterator<T> r136 = r135.iterator();
    L66:
        if (r136.hasNext() == false) goto L68;
        LayoutConfigModel.f r137 = (LayoutConfigModel.f) r136.next();
        m.e r138 = new m.e();
        r138.m(r137.g());
        r138.i(r137.c());
        r138.k(r137.e());
        r138.l(r137.f());
        r138.j(r137.d());
        r138.h(r137.b());
        r128.add(r138);
    L68:
        r101.A(r128);
        return r101;
    L61:
        r130 = null;
        goto L62
    }
}
