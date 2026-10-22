package K;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import java.util.Iterator;

/* loaded from: classes.dex */
public final /* synthetic */ class c0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f951a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f952b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f953c;

    public /* synthetic */ c0(int i4, Object obj, Object obj2) {
        this.f951a = i4;
        this.f952b = obj;
        this.f953c = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i4 = this.f951a;
        Object obj = this.f952b;
        switch (i4) {
            case 0:
                ((g0) obj).l();
                return;
            default:
                com.google.android.material.appbar.h hVar = (com.google.android.material.appbar.h) obj;
                y1.j jVar = (y1.j) this.f953c;
                int i5 = com.google.android.material.appbar.h.f10293B;
                hVar.getClass();
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                jVar.n(fFloatValue);
                Drawable drawable = hVar.f10318x;
                if (drawable instanceof y1.j) {
                    ((y1.j) drawable).n(fFloatValue);
                }
                Iterator it = hVar.f10312r.iterator();
                if (it.hasNext()) {
                    B0.g.y(it.next());
                    throw null;
                }
                Iterator it2 = hVar.f10313s.iterator();
                if (it2.hasNext()) {
                    B0.g.y(it2.next());
                    throw null;
                }
                return;
        }
    }
}
