package com.stepos.renderfilter.platform;

import A.e;
import android.view.View;
import android.view.ViewTreeObserver;
import com.stepos.renderfilter.annotation.Keep;
import com.stepos.renderfilter.functor.FunctorApi31Impl;
import k.ViewOnAttachStateChangeListenerC0652f;
import r2.C0830b;
import r2.d;

/* loaded from: classes.dex */
public final class BackdropBlurHelper {
    @Keep
    public static C0830b apply(View view, float f4, int i4, int i5) {
        C0830b c0830b = new C0830b(12, f4, 0.25f);
        d dVar = c0830b.f14077a;
        dVar.f14084d.f14234j = i4;
        c0830b.f14079c = i4;
        c0830b.invalidateSelf();
        dVar.f14084d.f14233i = i5;
        c0830b.f14078b.setColor(i5);
        c0830b.invalidateSelf();
        dVar.f14084d.f14236l = 1.0f;
        c0830b.invalidateSelf();
        c0830b.setAlpha(255);
        if (view != null) {
            view.setBackground(c0830b);
            ViewTreeObserver.OnPreDrawListener eVar = new e(2, c0830b);
            if (view.isAttachedToWindow()) {
                try {
                    view.getViewTreeObserver().addOnPreDrawListener(eVar);
                } catch (Exception unused) {
                }
            }
            view.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0652f(5, eVar));
        }
        return c0830b;
    }

    @Keep
    public static boolean isVulkanHwui() {
        return FunctorApi31Impl.isVulkanMode();
    }
}
