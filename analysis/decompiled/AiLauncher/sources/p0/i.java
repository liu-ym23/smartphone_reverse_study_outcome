package p0;

import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class i {

    /* renamed from: h, reason: collision with root package name */
    public static int f38037h;

    /* renamed from: c, reason: collision with root package name */
    public WidgetRun f38040c;

    /* renamed from: d, reason: collision with root package name */
    public WidgetRun f38041d;

    /* renamed from: f, reason: collision with root package name */
    public int f38043f;

    /* renamed from: g, reason: collision with root package name */
    public int f38044g;

    /* renamed from: a, reason: collision with root package name */
    public int f38038a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f38039b = false;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<WidgetRun> f38042e = new ArrayList<>();

    public i(WidgetRun widgetRun, int i10) {
        this.f38040c = null;
        this.f38041d = null;
        int i11 = f38037h;
        this.f38043f = i11;
        f38037h = i11 + 1;
        this.f38040c = widgetRun;
        this.f38041d = widgetRun;
        this.f38044g = i10;
    }

    public void a(WidgetRun widgetRun) {
        this.f38042e.add(widgetRun);
        this.f38041d = widgetRun;
    }

    public long b(androidx.constraintlayout.core.widgets.d dVar, int i10) {
        WidgetRun widgetRun = this.f38040c;
        if (widgetRun instanceof C5035c) {
            if (((C5035c) widgetRun).f12052f != i10) {
                return 0L;
            }
        } else if (i10 == 0) {
            if (!(widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.c)) {
                return 0L;
            }
        } else if (!(widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.d)) {
            return 0L;
        }
        DependencyNode dependencyNode = (i10 == 0 ? dVar.f11986e : dVar.f11988f).f12054h;
        DependencyNode dependencyNode2 = (i10 == 0 ? dVar.f11986e : dVar.f11988f).f12055i;
        boolean zContains = widgetRun.f12054h.f12046l.contains(dependencyNode);
        boolean zContains2 = this.f38040c.f12055i.f12046l.contains(dependencyNode2);
        long j10 = this.f38040c.j();
        if (!zContains || !zContains2) {
            if (zContains) {
                return Math.max(d(this.f38040c.f12054h, r12.f12040f), this.f38040c.f12054h.f12040f + j10);
            }
            if (!zContains2) {
                return (r12.f12054h.f12040f + this.f38040c.j()) - this.f38040c.f12055i.f12040f;
            }
            return Math.max(-c(this.f38040c.f12055i, r12.f12040f), (-this.f38040c.f12055i.f12040f) + j10);
        }
        long jD = d(this.f38040c.f12054h, 0L);
        long jC = c(this.f38040c.f12055i, 0L);
        long j11 = jD - j10;
        WidgetRun widgetRun2 = this.f38040c;
        int i11 = widgetRun2.f12055i.f12040f;
        if (j11 >= (-i11)) {
            j11 += i11;
        }
        int i12 = widgetRun2.f12054h.f12040f;
        long j12 = ((-jC) - j10) - i12;
        if (j12 >= i12) {
            j12 -= i12;
        }
        float fS = widgetRun2.f12048b.s(i10);
        float f10 = fS > 0.0f ? (long) ((j12 / fS) + (j11 / (1.0f - fS))) : 0L;
        long j13 = ((long) ((f10 * fS) + 0.5f)) + j10 + ((long) ((f10 * (1.0f - fS)) + 0.5f));
        WidgetRun widgetRun3 = this.f38040c;
        return (widgetRun3.f12054h.f12040f + j13) - widgetRun3.f12055i.f12040f;
    }

    public final long c(DependencyNode dependencyNode, long j10) {
        WidgetRun widgetRun = dependencyNode.f12038d;
        if (widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.b) {
            return j10;
        }
        int size = dependencyNode.f12045k.size();
        long jMin = j10;
        for (int i10 = 0; i10 < size; i10++) {
            InterfaceC5036d interfaceC5036d = dependencyNode.f12045k.get(i10);
            if (interfaceC5036d instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) interfaceC5036d;
                if (dependencyNode2.f12038d != widgetRun) {
                    jMin = Math.min(jMin, c(dependencyNode2, dependencyNode2.f12040f + j10));
                }
            }
        }
        if (dependencyNode != widgetRun.f12055i) {
            return jMin;
        }
        long j11 = j10 - widgetRun.j();
        return Math.min(Math.min(jMin, c(widgetRun.f12054h, j11)), j11 - widgetRun.f12054h.f12040f);
    }

    public final long d(DependencyNode dependencyNode, long j10) {
        WidgetRun widgetRun = dependencyNode.f12038d;
        if (widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.b) {
            return j10;
        }
        int size = dependencyNode.f12045k.size();
        long jMax = j10;
        for (int i10 = 0; i10 < size; i10++) {
            InterfaceC5036d interfaceC5036d = dependencyNode.f12045k.get(i10);
            if (interfaceC5036d instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) interfaceC5036d;
                if (dependencyNode2.f12038d != widgetRun) {
                    jMax = Math.max(jMax, d(dependencyNode2, dependencyNode2.f12040f + j10));
                }
            }
        }
        if (dependencyNode != widgetRun.f12054h) {
            return jMax;
        }
        long j11 = j10 + widgetRun.j();
        return Math.max(Math.max(jMax, d(widgetRun.f12055i, j11)), j11 - widgetRun.f12055i.f12040f);
    }
}
