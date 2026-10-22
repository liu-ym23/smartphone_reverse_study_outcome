package androidx.constraintlayout.core.widgets.analyzer;

import com.stepos.core.common.telemetry.FailStage;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class DependencyNode implements h0.d {

    /* renamed from: d, reason: collision with root package name */
    public final WidgetRun f1148d;

    /* renamed from: f, reason: collision with root package name */
    public int f1150f;

    /* renamed from: g, reason: collision with root package name */
    public int f1151g;

    /* renamed from: a, reason: collision with root package name */
    public WidgetRun f1145a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1146b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1147c = false;

    /* renamed from: e, reason: collision with root package name */
    public Type f1149e = Type.f1156a;
    public int h = 1;

    /* renamed from: i, reason: collision with root package name */
    public a f1152i = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1153j = false;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f1154k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f1155l = new ArrayList();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Type {

        /* renamed from: a, reason: collision with root package name */
        public static final Type f1156a;

        /* renamed from: b, reason: collision with root package name */
        public static final Type f1157b;

        /* renamed from: c, reason: collision with root package name */
        public static final Type f1158c;

        /* renamed from: d, reason: collision with root package name */
        public static final Type f1159d;

        /* renamed from: e, reason: collision with root package name */
        public static final Type f1160e;
        public static final Type h;

        /* renamed from: j, reason: collision with root package name */
        public static final Type f1161j;

        /* renamed from: k, reason: collision with root package name */
        public static final Type f1162k;

        /* renamed from: l, reason: collision with root package name */
        public static final /* synthetic */ Type[] f1163l;

        static {
            Type type = new Type(FailStage.UNKNOWN, 0);
            f1156a = type;
            Type type2 = new Type("HORIZONTAL_DIMENSION", 1);
            f1157b = type2;
            Type type3 = new Type("VERTICAL_DIMENSION", 2);
            f1158c = type3;
            Type type4 = new Type("LEFT", 3);
            f1159d = type4;
            Type type5 = new Type("RIGHT", 4);
            f1160e = type5;
            Type type6 = new Type("TOP", 5);
            h = type6;
            Type type7 = new Type("BOTTOM", 6);
            f1161j = type7;
            Type type8 = new Type("BASELINE", 7);
            f1162k = type8;
            f1163l = new Type[]{type, type2, type3, type4, type5, type6, type7, type8};
        }

        public Type() {
            throw null;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f1163l.clone();
        }
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.f1148d = widgetRun;
    }

    @Override // h0.d
    public final void a(h0.d dVar) {
        ArrayList arrayList = this.f1155l;
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            if (!((DependencyNode) obj).f1153j) {
                return;
            }
        }
        this.f1147c = true;
        WidgetRun widgetRun = this.f1145a;
        if (widgetRun != null) {
            widgetRun.a(this);
        }
        if (this.f1146b) {
            this.f1148d.a(this);
            return;
        }
        int size2 = arrayList.size();
        DependencyNode dependencyNode = null;
        int i12 = 0;
        while (i12 < size2) {
            Object obj2 = arrayList.get(i12);
            i12++;
            DependencyNode dependencyNode2 = (DependencyNode) obj2;
            if (!(dependencyNode2 instanceof a)) {
                i10++;
                dependencyNode = dependencyNode2;
            }
        }
        if (dependencyNode != null && i10 == 1 && dependencyNode.f1153j) {
            a aVar = this.f1152i;
            if (aVar != null) {
                if (!aVar.f1153j) {
                    return;
                } else {
                    this.f1150f = this.h * aVar.f1151g;
                }
            }
            d(dependencyNode.f1151g + this.f1150f);
        }
        WidgetRun widgetRun2 = this.f1145a;
        if (widgetRun2 != null) {
            widgetRun2.a(this);
        }
    }

    public final void b(WidgetRun widgetRun) {
        this.f1154k.add(widgetRun);
        if (this.f1153j) {
            widgetRun.a(widgetRun);
        }
    }

    public final void c() {
        this.f1155l.clear();
        this.f1154k.clear();
        this.f1153j = false;
        this.f1151g = 0;
        this.f1147c = false;
        this.f1146b = false;
    }

    public void d(int i10) {
        if (this.f1153j) {
            return;
        }
        this.f1153j = true;
        this.f1151g = i10;
        ArrayList arrayList = this.f1154k;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            h0.d dVar = (h0.d) obj;
            dVar.a(dVar);
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f1148d.f1165b.f1115j0);
        sb2.append(":");
        sb2.append(this.f1149e);
        sb2.append("(");
        sb2.append(this.f1153j ? Integer.valueOf(this.f1151g) : "unresolved");
        sb2.append(") <t=");
        sb2.append(this.f1155l.size());
        sb2.append(":d=");
        sb2.append(this.f1154k.size());
        sb2.append(">");
        return sb2.toString();
    }
}
