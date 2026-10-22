package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ g f2325a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ ColorStateList f2326b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ f7.i f2327c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Integer f2328d;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Integer num;
        g gVar = this.f2325a;
        ColorStateList colorStateList = this.f2326b;
        f7.i iVar = this.f2327c;
        Integer num2 = this.f2328d;
        LinkedHashSet linkedHashSet = gVar.f2362w;
        ArrayList arrayList = gVar.f2361v;
        int iM = t1.e.m(gVar.A, ((Float) valueAnimator.getAnimatedValue()).floatValue(), colorStateList.getDefaultColor());
        iVar.j(ColorStateList.valueOf(iM));
        if (gVar.B != null && (num = gVar.C) != null && num.equals(num2)) {
            gVar.B.setTint(iM);
        }
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                if (obj != null) {
                    od.f.j();
                    return;
                } else if (iVar.f3954f.f3939d != null) {
                    throw null;
                }
            }
        }
        if (linkedHashSet.isEmpty()) {
            return;
        }
        Iterator it = linkedHashSet.iterator();
        if (it.hasNext()) {
            throw androidx.activity.b.g(it);
        }
    }
}
