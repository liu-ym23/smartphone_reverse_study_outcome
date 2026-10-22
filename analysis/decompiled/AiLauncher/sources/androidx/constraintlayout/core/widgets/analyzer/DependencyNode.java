package androidx.constraintlayout.core.widgets.analyzer;

import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p0.InterfaceC5036d;

/* loaded from: classes.dex */
public class DependencyNode implements InterfaceC5036d {

    /* renamed from: d, reason: collision with root package name */
    public WidgetRun f12038d;

    /* renamed from: f, reason: collision with root package name */
    public int f12040f;

    /* renamed from: g, reason: collision with root package name */
    public int f12041g;

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC5036d f12035a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12036b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12037c = false;

    /* renamed from: e, reason: collision with root package name */
    public Type f12039e = Type.UNKNOWN;

    /* renamed from: h, reason: collision with root package name */
    public int f12042h = 1;

    /* renamed from: i, reason: collision with root package name */
    public a f12043i = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f12044j = false;

    /* renamed from: k, reason: collision with root package name */
    public List<InterfaceC5036d> f12045k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public List<DependencyNode> f12046l = new ArrayList();

    public enum Type {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.f12038d = widgetRun;
    }

    @Override // p0.InterfaceC5036d
    public void a(InterfaceC5036d interfaceC5036d) {
        Iterator<DependencyNode> it = this.f12046l.iterator();
        while (it.hasNext()) {
            if (!it.next().f12044j) {
                return;
            }
        }
        this.f12037c = true;
        InterfaceC5036d interfaceC5036d2 = this.f12035a;
        if (interfaceC5036d2 != null) {
            interfaceC5036d2.a(this);
        }
        if (this.f12036b) {
            this.f12038d.a(this);
            return;
        }
        DependencyNode dependencyNode = null;
        int i10 = 0;
        for (DependencyNode dependencyNode2 : this.f12046l) {
            if (!(dependencyNode2 instanceof a)) {
                i10++;
                dependencyNode = dependencyNode2;
            }
        }
        if (dependencyNode != null && i10 == 1 && dependencyNode.f12044j) {
            a aVar = this.f12043i;
            if (aVar != null) {
                if (!aVar.f12044j) {
                    return;
                } else {
                    this.f12040f = this.f12042h * aVar.f12041g;
                }
            }
            d(dependencyNode.f12041g + this.f12040f);
        }
        InterfaceC5036d interfaceC5036d3 = this.f12035a;
        if (interfaceC5036d3 != null) {
            interfaceC5036d3.a(this);
        }
    }

    public void b(InterfaceC5036d interfaceC5036d) {
        this.f12045k.add(interfaceC5036d);
        if (this.f12044j) {
            interfaceC5036d.a(interfaceC5036d);
        }
    }

    public void c() {
        this.f12046l.clear();
        this.f12045k.clear();
        this.f12044j = false;
        this.f12041g = 0;
        this.f12037c = false;
        this.f12036b = false;
    }

    public void d(int i10) {
        if (this.f12044j) {
            return;
        }
        this.f12044j = true;
        this.f12041g = i10;
        for (InterfaceC5036d interfaceC5036d : this.f12045k) {
            interfaceC5036d.a(interfaceC5036d);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f12038d.f12048b.v());
        sb2.append(ServerSentEventKt.COLON);
        sb2.append(this.f12039e);
        sb2.append("(");
        sb2.append(this.f12044j ? Integer.valueOf(this.f12041g) : "unresolved");
        sb2.append(") <t=");
        sb2.append(this.f12046l.size());
        sb2.append(":d=");
        sb2.append(this.f12045k.size());
        sb2.append(">");
        return sb2.toString();
    }
}
