package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: androidx.fragment.app.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0291m extends r0 {
    public static void j(q0 q0Var) {
        B0.g.a(q0Var.f3801a, q0Var.f3803c.mView);
    }

    public static void k(ArrayList arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (K.W.b(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if (childAt.getVisibility() == 0) {
                k(arrayList, childAt);
            }
        }
    }

    public static void l(q.f fVar, View view) {
        WeakHashMap weakHashMap = K.S.f939a;
        String strK = K.J.k(view);
        if (strK != null) {
            fVar.put(strK, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = viewGroup.getChildAt(i4);
                if (childAt.getVisibility() == 0) {
                    l(fVar, childAt);
                }
            }
        }
    }

    public static void m(q.f fVar, Collection collection) {
        Iterator it = fVar.entrySet().iterator();
        while (it.hasNext()) {
            View view = (View) ((Map.Entry) it.next()).getValue();
            WeakHashMap weakHashMap = K.S.f939a;
            if (!collection.contains(K.J.k(view))) {
                it.remove();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x04bf  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x04d3  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x06c0  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x077d  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0833 A[LOOP:7: B:270:0x082d->B:272:0x0833, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0847  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:363:? A[RETURN, SYNTHETIC] */
    @Override // androidx.fragment.app.r0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.util.ArrayList r38, boolean r39) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 2149
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0291m.b(java.util.ArrayList, boolean):void");
    }
}
