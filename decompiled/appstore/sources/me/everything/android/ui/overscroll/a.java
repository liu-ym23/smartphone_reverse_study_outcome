package me.everything.android.ui.overscroll;

import android.view.MotionEvent;
import android.view.View;
import me.everything.android.ui.overscroll.adapters.IOverScrollDecoratorAdapter;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends OverScrollBounceEffectDecoratorBase {

    /* JADX INFO: renamed from: me.everything.android.ui.overscroll.a$a, reason: collision with other inner class name */
    public static class C0318a extends OverScrollBounceEffectDecoratorBase.AnimationAttributes {
        public C0318a() {
            this.f22277a = View.TRANSLATION_X;
        }

        @Override // me.everything.android.ui.overscroll.OverScrollBounceEffectDecoratorBase.AnimationAttributes
        public void a(View r10) {
            this.f22278b = r10.getTranslationX();
            this.f22279c = r10.getWidth();
        }
    }

    public static class b extends OverScrollBounceEffectDecoratorBase.MotionAttributes {
        public b() {
        }

        @Override // me.everything.android.ui.overscroll.OverScrollBounceEffectDecoratorBase.MotionAttributes
        public boolean a(View r10, MotionEvent r11) {
            boolean r12 = false;
            if (r11.getHistorySize() != 0) goto L5;
            return false;
        L5:
            float r13 = r11.getY(0) - r11.getHistoricalY(0, 0);
            float r14 = r11.getX(0) - r11.getHistoricalX(0, 0);
            if (Math.abs(r14) >= Math.abs(r13)) goto L8;
            return false;
        L8:
            this.f22287a = r10.getTranslationX();
            this.f22288b = r14;
            if (r14 <= 0.0f) goto L11;
            r12 = true;
        L11:
            this.f22289c = r12;
            return true;
        }
    }

    public a(IOverScrollDecoratorAdapter r10) {
        this(r10, 3.0f, 1.0f, -2.0f);
    }

    @Override // me.everything.android.ui.overscroll.OverScrollBounceEffectDecoratorBase
    public OverScrollBounceEffectDecoratorBase.AnimationAttributes createAnimationAttributes() {
        return new C0318a();
    }

    @Override // me.everything.android.ui.overscroll.OverScrollBounceEffectDecoratorBase
    public OverScrollBounceEffectDecoratorBase.MotionAttributes createMotionAttributes() {
        return new b();
    }

    @Override // me.everything.android.ui.overscroll.OverScrollBounceEffectDecoratorBase
    public void translateView(View r10, float r11) {
        r10.setTranslationX(r11);
    }

    @Override // me.everything.android.ui.overscroll.OverScrollBounceEffectDecoratorBase
    public void translateViewAndEvent(View r10, float r11, MotionEvent r12) {
        r10.setTranslationX(r11);
        r12.offsetLocation(r11 - r12.getX(0), 0.0f);
    }

    public a(IOverScrollDecoratorAdapter r10, float r11, float r12, float r13) {
        super(r10, r13, r11, r12);
    }
}
