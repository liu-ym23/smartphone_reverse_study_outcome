package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f1569h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WidgetRun f1572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WidgetRun f1573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f1574e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1575f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1576g;

    public j(WidgetRun r10, int r11) {
        this.f1570a = 0;
        this.f1571b = false;
        this.f1572c = null;
        this.f1573d = null;
        this.f1574e = new ArrayList();
        int r12 = f1569h;
        this.f1575f = r12;
        f1569h = r12 + 1;
        this.f1572c = r10;
        this.f1573d = r10;
        this.f1576g = r11;
    }

    public void a(WidgetRun r10) {
        this.f1574e.add(r10);
        this.f1573d = r10;
    }

    public long b(ConstraintWidgetContainer r12, int r13) {
        WidgetRun r10 = this.f1572c;
        long r11 = 0;
        if ((r10 instanceof b) == true) goto L5;
        if (r13 != 0) goto L12;
        if ((r10 instanceof i) == true) goto L14;
        return 0;
    L14:
        if (r13 != 0) goto L17;
        WidgetRun r14 = r12.f1440e;
    L16:
        DependencyNode r15 = r14.f1548h;
        if (r13 != 0) goto L21;
        WidgetRun r16 = r12.f1440e;
    L20:
        DependencyNode r17 = r16.f1549i;
        boolean r18 = r10.f1548h.f1540l.contains(r15);
        boolean r19 = this.f1572c.f1549i.f1540l.contains(r17);
        long r20 = this.f1572c.i();
        if (r18 == false) goto L35;
        if (r19 == false) goto L35;
        long r21 = d(this.f1572c.f1548h, 0);
        long r22 = c(this.f1572c.f1549i, 0);
        long r23 = r21 - r20;
        WidgetRun r110 = this.f1572c;
        int r24 = r110.f1549i.f1534f;
        if (r23 < (-r24)) goto L28;
        r23 = r23 + ((long) r24);
    L28:
        int r25 = r110.f1548h.f1534f;
        long r26 = ((-r22) - r20) - ((long) r25);
        if (r26 < r25) goto L31;
        r26 = r26 - ((long) r25);
    L31:
        float r111 = r110.f1542b.p(r13);
        if (r111 <= 0.0f) goto L34;
        r11 = (long) ((r26 / r111) + (r23 / (1.0f - r111)));
    L34:
        float r112 = r11;
        long r27 = (((long) ((r112 * r111) + 0.5f)) + r20) + ((long) ((r112 * (1.0f - r111)) + 0.5f));
        WidgetRun r113 = this.f1572c;
        return (((long) r113.f1548h.f1534f) + r27) - ((long) r113.f1549i.f1534f);
    L35:
        if (r18 == false) goto L37;
        DependencyNode r114 = this.f1572c.f1548h;
        return Math.max(d(r114, r114.f1534f), ((long) this.f1572c.f1548h.f1534f) + r20);
    L37:
        if (r19 == false) goto L39;
        DependencyNode r115 = this.f1572c.f1549i;
        long r116 = c(r115, r115.f1534f);
        return Math.max(-r116, ((long) (-this.f1572c.f1549i.f1534f)) + r20);
    L39:
        WidgetRun r117 = this.f1572c;
        return (((long) r117.f1548h.f1534f) + r117.i()) - ((long) this.f1572c.f1549i.f1534f);
    L21:
        r16 = r12.f1442f;
        goto L20
    L17:
        r14 = r12.f1442f;
        goto L16
    L12:
        if ((r10 instanceof k) == true) goto L14;
        return 0;
    L5:
        if (((b) r10).f1546f == r13) goto L14;
        return 0;
    }

    public final long c(DependencyNode r10, long r11) {
        WidgetRun r12 = r10.f1532d;
        if ((r12 instanceof h) == false) goto L5;
        return r11;
    L5:
        int r13 = r10.f1539k.size();
        int r14 = 0;
        long r15 = r11;
    L6:
        if (r14 >= r13) goto L15;
        Dependency r16 = (Dependency) r10.f1539k.get(r14);
        if ((r16 instanceof DependencyNode) == false) goto L13;
        DependencyNode r17 = (DependencyNode) r16;
        if (r17.f1532d == r12) goto L13;
        r15 = Math.min(r15, c(r17, ((long) r17.f1534f) + r11));
    L13:
        r14 = r14 + 1;
        goto L6
    L15:
        if (r10 != r12.f1549i) goto L22;
        long r18 = r12.i();
        long r19 = r11 - r18;
        return Math.min(Math.min(r15, c(r12.f1548h, r19)), r19 - ((long) r12.f1548h.f1534f));
    L22:
        return r15;
    }

    public final long d(DependencyNode r10, long r11) {
        WidgetRun r12 = r10.f1532d;
        if ((r12 instanceof h) == false) goto L5;
        return r11;
    L5:
        int r13 = r10.f1539k.size();
        int r14 = 0;
        long r15 = r11;
    L6:
        if (r14 >= r13) goto L15;
        Dependency r16 = (Dependency) r10.f1539k.get(r14);
        if ((r16 instanceof DependencyNode) == false) goto L13;
        DependencyNode r17 = (DependencyNode) r16;
        if (r17.f1532d == r12) goto L13;
        r15 = Math.max(r15, d(r17, ((long) r17.f1534f) + r11));
    L13:
        r14 = r14 + 1;
        goto L6
    L15:
        if (r10 != r12.f1548h) goto L22;
        long r18 = r12.i();
        long r19 = r11 + r18;
        return Math.max(Math.max(r15, d(r12.f1549i, r19)), r19 - ((long) r12.f1549i.f1534f));
    L22:
        return r15;
    }
}
