package androidx.constraintlayout.a.b;

import androidx.constraintlayout.a.c.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: WidgetFrame.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static float n = Float.NaN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f688e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float o;
    public float p;
    public float q;
    public float r;
    public int s;
    public final HashMap<String, androidx.constraintlayout.a.a.a> t;
    public String u;

    static {
    }

    public a() {
        this.f684a = null;
        this.f685b = 0;
        this.f686c = 0;
        this.f687d = 0;
        this.f688e = 0;
        this.f = Float.NaN;
        this.g = Float.NaN;
        this.h = Float.NaN;
        this.i = Float.NaN;
        this.j = Float.NaN;
        this.k = Float.NaN;
        this.l = Float.NaN;
        this.m = Float.NaN;
        this.o = Float.NaN;
        this.p = Float.NaN;
        this.q = Float.NaN;
        this.r = Float.NaN;
        this.s = 0;
        this.t = new HashMap();
        this.u = null;
    }

    public a(e r4) {
        this.f684a = null;
        this.f685b = 0;
        this.f686c = 0;
        this.f687d = 0;
        this.f688e = 0;
        this.f = Float.NaN;
        this.g = Float.NaN;
        this.h = Float.NaN;
        this.i = Float.NaN;
        this.j = Float.NaN;
        this.k = Float.NaN;
        this.l = Float.NaN;
        this.m = Float.NaN;
        this.o = Float.NaN;
        this.p = Float.NaN;
        this.q = Float.NaN;
        this.r = Float.NaN;
        this.s = 0;
        this.t = new HashMap();
        this.u = null;
        this.f684a = r4;
    }

    public void a(a r4) {
        this.f = r4.f;
        this.g = r4.g;
        this.h = r4.h;
        this.i = r4.i;
        this.j = r4.j;
        this.k = r4.k;
        this.l = r4.l;
        this.m = r4.m;
        this.o = r4.o;
        this.p = r4.p;
        this.q = r4.q;
        this.s = r4.s;
        this.t.clear();
        if (r4 == null) goto L8;
        Iterator<androidx.constraintlayout.a.a.a> r5 = r4.t.values().iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        androidx.constraintlayout.a.a.a r0 = (androidx.constraintlayout.a.a.a) ZeusTransformUtils.preCheckCast(r5.next(), androidx.constraintlayout.a.a.a.class, "com.obric.aiagent.plugin");
        this.t.put(r0.b(), r0.a());
        goto L6
    L10:
        return;
    }

    public a update() {
        e r0 = this.f684a;
        if (r0 == null) goto L5;
        this.f685b = r0.J();
        this.f686c = this.f684a.K();
        this.f687d = this.f684a.L();
        this.f688e = this.f684a.M();
        a(this.f684a.j);
    L5:
        return this;
    }

    public a update(e r1) {
        if (r1 != null) goto L4;
        return this;
    L4:
        this.f684a = r1;
        update();
        return this;
    }
}
