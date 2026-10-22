package ba2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements b<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<b<e>> f18398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f18399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Integer> f18400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f18401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f18402e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f18403f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f18404g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f18405h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f18406i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f18407j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f18408k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f18409l;

    public static final class a {
    }

    static {
    }

    public e() {
        this.f18398a = new LinkedList();
        d r100 = new d();
        this.f18399b = r100;
        this.f18400c = new ArrayList();
        this.f18401d = 1.0f;
        this.f18408k = 1.0f;
        r100.f18397j = this;
    }

    @Override // ba2.b
    public final void onGestureBegin(d r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        Iterator<T> r101 = this.f18398a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((b) r101.next()).onGestureBegin(this);
        goto L4
    }

    @Override // ba2.b
    public final void onGestureEnd(d r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        Iterator<T> r101 = this.f18398a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((b) r101.next()).onGestureEnd(this);
        goto L4
    L6:
        this.f18401d = 1.0f;
        this.f18402e = 0.0f;
        this.f18403f = 0.0f;
        this.f18404g = 0.0f;
        this.f18405h = 0.0f;
        this.f18406i = 0.0f;
        this.f18407j = 0.0f;
        this.f18408k = 1.0f;
        this.f18409l = 0;
    }

    @Override // ba2.b
    public final void onGestureUpdate(d r110) {
        d r111 = r110;
        Intrinsics.checkNotNullParameter(r111, "detector");
        if (this.f18399b.f18388a != 1) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        float[] r101 = r111.f18391d;
        float r102 = r101[1] - r101[0];
        float[] r103 = r111.f18392e;
        float r104 = r103[1] - r103[0];
        float[] r105 = r111.f18393f;
        float r106 = r105[1] - r105[0];
        float[] r107 = r111.f18394g;
        float r108 = r107[1] - r107[0];
        float r109 = (float) Math.hypot(r102, r104);
        float r112 = (float) Math.hypot(r106, r108);
        float r113 = this.f18401d;
        float r114 = r112 / r109;
        this.f18401d = r114;
        this.f18408k = r114 / r113;
        this.f18404g = a(r111.f18393f, r111.f18388a);
        this.f18405h = a(r111.f18394g, r111.f18388a);
    L9:
        float r115 = a(r111.f18393f, r111.f18388a) - a(r111.f18395h, r111.f18388a);
        this.f18406i = r115;
        this.f18402e += r115;
        float r116 = a(r111.f18394g, r111.f18388a) - a(r111.f18396i, r111.f18388a);
        this.f18407j = r116;
        this.f18403f += r116;
        if (this.f18399b.f18388a != 1) goto L12;
        boolean r117 = true;
    L13:
        if (r117 == true) goto L15;
        this.f18409l = -1;
    L39:
        Iterator<T> r118 = this.f18398a.iterator();
    L41:
        if (r118.hasNext() == false) goto L43;
        ((b) r118.next()).onGestureUpdate(this);
        goto L41
    L43:
        return;
    L15:
        if (this.f18409l != 0) goto L39;
        if ((Math.abs(this.f18402e) - Math.abs(this.f18403f)) < 0) goto L29;
        if (this.f18402e >= (-10)) goto L24;
        if (this.f18400c.contains(1) == true) goto L24;
        this.f18409l = 1;
    L24:
        if (this.f18402e <= 10) goto L39;
        if (this.f18400c.contains(3) == true) goto L39;
        this.f18409l = 3;
        goto L39
    L29:
        if (this.f18403f >= (-10)) goto L34;
        if (this.f18400c.contains(2) == true) goto L34;
        this.f18409l = 2;
    L34:
        if (this.f18403f <= 10) goto L39;
        if (this.f18400c.contains(4) == true) goto L39;
        this.f18409l = 4;
        goto L39
    L12:
        r117 = false;
        goto L13
    L8:
        this.f18401d = 1.0f;
        this.f18408k = 1.0f;
        goto L9
    L5:
        r100 = false;
        goto L6
    }

    public static float a(float[] r100, int r101) {
        int r102 = 0;
        float r103 = 0.0f;
    L3:
        if (r102 >= r101) goto L5;
        r103 = r103 + r100[r102];
        r102 = r102 + 1;
        goto L3
    L5:
        if (r101 > 0) goto L7;
        return 0.0f;
    L7:
        return r103 / r101;
    }
}
