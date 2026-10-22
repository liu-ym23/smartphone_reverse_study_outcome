package androidx.constraintlayout.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DependencyNode.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    p f712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    a f713e;
    int f;
    public int g;
    int h;
    g i;
    public boolean j;
    List<d> k;
    List<f> l;

    /* JADX INFO: compiled from: DependencyNode.java */
    static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f714a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f715b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f716c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f717d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f718e = null;
        public static final a f = null;
        public static final a g = null;
        public static final a h = null;
        private static final /* synthetic */ a[] i = null;

        static {
            a r0 = new a("UNKNOWN", 0);
            f714a = r0;
            a r1 = new a("HORIZONTAL_DIMENSION", 1);
            f715b = r1;
            a r3 = new a("VERTICAL_DIMENSION", 2);
            f716c = r3;
            a r5 = new a("LEFT", 3);
            f717d = r5;
            a r7 = new a("RIGHT", 4);
            f718e = r7;
            a r9 = new a("TOP", 5);
            f = r9;
            a r11 = new a("BOTTOM", 6);
            g = r11;
            a r13 = new a("BASELINE", 7);
            h = r13;
            i = new a[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(i.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    public f(p r4) {
        this.f709a = null;
        this.f710b = false;
        this.f711c = false;
        this.f713e = a.f714a;
        this.h = 1;
        this.i = null;
        this.j = false;
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.f712d = r4;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append(this.f712d.f743d.C()).append(":").append(this.f713e).append("(");
        if (this.j == false) goto L5;
        Object r1 = Integer.valueOf(this.g);
    L7:
        return r0.append(r1).append(") <t=").append(this.l.size()).append(":d=").append(this.k.size()).append(">").toString();
    L5:
        r1 = "unresolved";
        goto L7
    }

    public void a(int r3) {
        if (this.j == false) goto L5;
        return;
    L5:
        this.j = true;
        this.g = r3;
        Iterator<d> r2 = this.k.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r2.next(), d.class, "com.obric.aiagent.plugin");
        r4.update(r4);
        goto L7
    }

    @Override // androidx.constraintlayout.a.c.a.d
    public void update(d r8) {
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r8, d.class, "com.obric.aiagent.plugin");
        Iterator<f> r10 = this.l.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        if (((f) ZeusTransformUtils.preCheckCast(r10.next(), f.class, "com.obric.aiagent.plugin")).j == true) goto L4;
        return;
    L8:
        this.f711c = true;
        d r1 = this.f709a;
        if (r1 == null) goto L12;
        r1.update(this);
    L12:
        if (this.f710b == false) goto L15;
        this.f712d.update(this);
        return;
    L15:
        f r2 = null;
        int r3 = 0;
        Iterator<f> r4 = this.l.iterator();
    L17:
        if (r4.hasNext() == false) goto L22;
        f r5 = (f) ZeusTransformUtils.preCheckCast(r4.next(), f.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L17;
        r3 = r3 + 1;
        r2 = r5;
        goto L17
    L22:
        if (r2 == null) goto L33;
        if (r3 != 1) goto L33;
        if (r2.j == false) goto L33;
        g r11 = this.i;
        if (r11 != null) goto L29;
    L32:
        a(r2.g + this.f);
        goto L33
    L29:
        if (r11.j == false) goto L31;
        this.f = this.h * this.i.g;
        goto L32
    L31:
        return;
    L33:
        d r12 = this.f709a;
        if (r12 == null) goto L45;
        r12.update(this);
        return;
    }

    public void a(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        this.k.add(r4);
        if (this.j == false) goto L6;
        r4.update(r4);
        return;
    }

    public void a() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.g = 0;
        this.f711c = false;
        this.f710b = false;
    }
}
