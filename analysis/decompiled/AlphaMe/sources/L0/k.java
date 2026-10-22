package L0;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1190a;

    /* renamed from: b, reason: collision with root package name */
    public PointF f1191b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1192c;

    public k(PointF pointF, boolean z4, List list) {
        ArrayList arrayList = new ArrayList();
        this.f1190a = arrayList;
        this.f1191b = pointF;
        this.f1192c = z4;
        arrayList.addAll(list);
    }

    public final String toString() {
        return "ShapeData{numCurves=" + this.f1190a.size() + "closed=" + this.f1192c + '}';
    }

    public k() {
        this.f1190a = new ArrayList();
    }
}
