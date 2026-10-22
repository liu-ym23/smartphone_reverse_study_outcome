package x;

import android.content.Context;
import android.view.ViewGroup;
import com.stepos.agentbus.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class l extends ViewGroup {

    /* renamed from: f, reason: collision with root package name */
    public final int f11032f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f11033g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f11034h;

    /* renamed from: i, reason: collision with root package name */
    public final nb.f f11035i;

    /* renamed from: j, reason: collision with root package name */
    public int f11036j;

    public l(Context context) {
        super(context);
        this.f11032f = 5;
        ArrayList arrayList = new ArrayList();
        this.f11033g = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f11034h = arrayList2;
        this.f11035i = new nb.f(14);
        setClipChildren(false);
        n nVar = new n(context);
        addView(nVar);
        arrayList.add(nVar);
        arrayList2.add(nVar);
        this.f11036j = 1;
        setTag(R.id.hide_in_inspector_tag, Boolean.TRUE);
    }

    public final n a(m mVar) {
        nb.f fVar = this.f11035i;
        LinkedHashMap linkedHashMap = (LinkedHashMap) fVar.f6947g;
        LinkedHashMap linkedHashMap2 = (LinkedHashMap) fVar.f6947g;
        LinkedHashMap linkedHashMap3 = (LinkedHashMap) fVar.f6948h;
        n nVar = (n) linkedHashMap.get(mVar);
        if (nVar != null) {
            return nVar;
        }
        ArrayList arrayList = this.f11034h;
        q7.k.e(arrayList, "<this>");
        n nVar2 = (n) (arrayList.isEmpty() ? null : arrayList.remove(0));
        if (nVar2 == null) {
            int i2 = this.f11036j;
            ArrayList arrayList2 = this.f11033g;
            if (i2 > d7.s.t0(arrayList2)) {
                nVar2 = new n(getContext());
                addView(nVar2);
                arrayList2.add(nVar2);
            } else {
                nVar2 = (n) arrayList2.get(this.f11036j);
                m mVar2 = (m) linkedHashMap3.get(nVar2);
                if (mVar2 != null) {
                    mVar2.P();
                    n nVar3 = (n) linkedHashMap2.get(mVar2);
                    if (nVar3 != null) {
                    }
                    linkedHashMap2.remove(mVar2);
                    nVar2.c();
                }
            }
            int i10 = this.f11036j;
            if (i10 < this.f11032f - 1) {
                this.f11036j = i10 + 1;
            } else {
                this.f11036j = 0;
            }
        }
        linkedHashMap2.put(mVar, nVar2);
        linkedHashMap3.put(nVar2, mVar);
        return nVar2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i2, int i10, int i11, int i12) {
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i10) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
    }
}
