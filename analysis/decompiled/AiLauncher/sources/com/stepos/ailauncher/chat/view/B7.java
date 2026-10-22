package com.stepos.ailauncher.chat.view;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/chat/view/B7;", "", "<init>", "()V", "Landroid/view/View;", "button", "", "crossWindow", "Ly7/E;", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;Z)Ly7/E;", "handle", "LY8/t;", Const.INTENT_KEY_UMID, "(Ly7/E;)V", "", "FALLBACK_CORNER_DP", "F", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class B7 {
    private static final float FALLBACK_CORNER_DP = 20.0f;
    public static final B7 INSTANCE = new B7();

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/view/B7$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends ViewOutlineProvider {
        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(outline, "outline");
            outline.setOval(0, 0, view.getWidth(), view.getHeight());
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/chat/view/B7$b", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "()Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ View $button;
        final /* synthetic */ float $density;
        final /* synthetic */ y7.E $handle;

        public b(View view, y7.E e10, float f10) {
            this.$button = view;
            this.$handle = e10;
            this.$density = f10;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (Math.min(this.$button.getWidth(), this.$button.getHeight()) <= 0) {
                return true;
            }
            ViewTreeObserver viewTreeObserver = this.$button.getViewTreeObserver();
            if (!viewTreeObserver.isAlive()) {
                viewTreeObserver = null;
            }
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
            this.$handle.b(B7.c(this.$button, this.$density));
            return true;
        }
    }

    public static final float c(View view, float f10) {
        Float fValueOf = Float.valueOf(Math.min(view.getWidth(), view.getHeight()) / 2.0f);
        if (fValueOf.floatValue() <= 0.0f) {
            fValueOf = null;
        }
        return fValueOf != null ? fValueOf.floatValue() : f10 * 20.0f;
    }

    public final y7.E b(View button, boolean crossWindow) {
        kotlin.jvm.internal.p.i(button, "button");
        button.setOutlineProvider(new a());
        button.setClipToOutline(true);
        float f10 = button.getResources().getDisplayMetrics().density;
        y7.E eU = y7.H.a(s7.p.f40121a, button).x(crossWindow).w(c(button, f10)).i(y7.o.INSTANCE.l()).u();
        if (Math.min(button.getWidth(), button.getHeight()) <= 0) {
            button.getViewTreeObserver().addOnPreDrawListener(new b(button, eU, f10));
        }
        return eU;
    }

    public final void d(y7.E handle) {
        C2851i7.INSTANCE.h(handle);
    }
}
