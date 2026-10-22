package H0;

import L0.k;
import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.AbstractC0398c;
import f1.AbstractC0557a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class h extends b {

    /* renamed from: g, reason: collision with root package name */
    public final k f701g;

    /* renamed from: h, reason: collision with root package name */
    public final Path f702h;

    public h(List list) {
        super(list);
        this.f701g = new k();
        this.f702h = new Path();
    }

    @Override // H0.b
    public final Object f(Q0.a aVar, float f4) {
        k kVar = (k) aVar.f1627b;
        k kVar2 = (k) aVar.f1628c;
        k kVar3 = this.f701g;
        if (kVar3.f1191b == null) {
            kVar3.f1191b = new PointF();
        }
        kVar3.f1192c = kVar.f1192c || kVar2.f1192c;
        ArrayList arrayList = kVar.f1190a;
        int size = arrayList.size();
        int size2 = kVar2.f1190a.size();
        ArrayList arrayList2 = kVar2.f1190a;
        if (size != size2) {
            AbstractC0398c.b("Curves must have the same number of control points. Shape 1: " + arrayList.size() + "\tShape 2: " + arrayList2.size());
        }
        ArrayList arrayList3 = kVar3.f1190a;
        if (arrayList3.isEmpty()) {
            int iMin = Math.min(arrayList.size(), arrayList2.size());
            for (int i4 = 0; i4 < iMin; i4++) {
                arrayList3.add(new J0.a());
            }
        }
        PointF pointF = kVar.f1191b;
        PointF pointF2 = kVar2.f1191b;
        float fM = AbstractC0557a.M(pointF.x, pointF2.x, f4);
        float fM2 = AbstractC0557a.M(pointF.y, pointF2.y, f4);
        if (kVar3.f1191b == null) {
            kVar3.f1191b = new PointF();
        }
        kVar3.f1191b.set(fM, fM2);
        for (int size3 = arrayList3.size() - 1; size3 >= 0; size3--) {
            J0.a aVar2 = (J0.a) arrayList.get(size3);
            J0.a aVar3 = (J0.a) arrayList2.get(size3);
            PointF pointF3 = aVar2.f851a;
            PointF pointF4 = aVar3.f851a;
            ((J0.a) arrayList3.get(size3)).f851a.set(AbstractC0557a.M(pointF3.x, pointF4.x, f4), AbstractC0557a.M(pointF3.y, pointF4.y, f4));
            J0.a aVar4 = (J0.a) arrayList3.get(size3);
            PointF pointF5 = aVar2.f852b;
            float f5 = pointF5.x;
            PointF pointF6 = aVar3.f852b;
            aVar4.f852b.set(AbstractC0557a.M(f5, pointF6.x, f4), AbstractC0557a.M(pointF5.y, pointF6.y, f4));
            J0.a aVar5 = (J0.a) arrayList3.get(size3);
            PointF pointF7 = aVar2.f853c;
            float f6 = pointF7.x;
            PointF pointF8 = aVar3.f853c;
            aVar5.f853c.set(AbstractC0557a.M(f6, pointF8.x, f4), AbstractC0557a.M(pointF7.y, pointF8.y, f4));
        }
        Path path = this.f702h;
        path.reset();
        PointF pointF9 = kVar3.f1191b;
        path.moveTo(pointF9.x, pointF9.y);
        PointF pointF10 = new PointF(pointF9.x, pointF9.y);
        for (int i5 = 0; i5 < arrayList3.size(); i5++) {
            J0.a aVar6 = (J0.a) arrayList3.get(i5);
            PointF pointF11 = aVar6.f851a;
            boolean zEquals = pointF11.equals(pointF10);
            PointF pointF12 = aVar6.f852b;
            PointF pointF13 = aVar6.f853c;
            if (zEquals && pointF12.equals(pointF13)) {
                path.lineTo(pointF13.x, pointF13.y);
            } else {
                path.cubicTo(pointF11.x, pointF11.y, pointF12.x, pointF12.y, pointF13.x, pointF13.y);
            }
            pointF10.set(pointF13.x, pointF13.y);
        }
        if (kVar3.f1192c) {
            path.close();
        }
        return path;
    }
}
