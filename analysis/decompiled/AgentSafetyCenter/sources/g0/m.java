package g0;

import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends ViewGroup {

    /* renamed from: c, reason: collision with root package name */
    public int f4167c;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f4168f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f4169g;

    /* renamed from: h, reason: collision with root package name */
    public p5.l f4170h;
    public int i;

    public final o a(n nVar) {
        ArrayList arrayList = this.f4168f;
        p5.l lVar = this.f4170h;
        LinkedHashMap linkedHashMap = (LinkedHashMap) lVar.f9738c;
        LinkedHashMap linkedHashMap2 = (LinkedHashMap) lVar.f9738c;
        LinkedHashMap linkedHashMap3 = (LinkedHashMap) lVar.f9739f;
        o oVar = (o) linkedHashMap.get(nVar);
        if (oVar != null) {
            return oVar;
        }
        ArrayList arrayList2 = this.f4169g;
        arrayList2.getClass();
        o oVar2 = (o) (arrayList2.isEmpty() ? null : arrayList2.remove(0));
        if (oVar2 == null) {
            if (this.i > ac.a.x(arrayList)) {
                oVar2 = new o(getContext());
                addView(oVar2);
                arrayList.add(oVar2);
            } else {
                o oVar3 = (o) arrayList.get(this.i);
                n nVar2 = (n) linkedHashMap3.get(oVar3);
                if (nVar2 != null) {
                    nVar2.D();
                    o oVar4 = (o) linkedHashMap2.get(nVar2);
                    if (oVar4 != null) {
                    }
                    linkedHashMap2.remove(nVar2);
                    oVar3.c();
                }
                oVar2 = oVar3;
            }
            int i = this.i;
            if (i < this.f4167c - 1) {
                this.i = i + 1;
            } else {
                this.i = 0;
            }
        }
        linkedHashMap2.put(nVar, oVar2);
        linkedHashMap3.put(oVar2, nVar);
        return oVar2;
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
    }
}
