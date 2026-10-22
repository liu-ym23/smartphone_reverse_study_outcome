package com.stepos.ailauncher.chat.view;

import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.container.glass.SheetGlassStyle;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5074l;
import y7.G;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ=\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u001b2\u0006\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010!\u001a\u00020 2\b\u0010\u001e\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b!\u0010\"J9\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020 \u0018\u00010#¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020 2\b\u0010\u001e\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b(\u0010)J\u001d\u0010*\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b*\u0010+J\u001d\u0010,\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b,\u0010+JI\u00101\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-2\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020 \u0018\u00010#¢\u0006\u0004\b1\u00102¨\u00063"}, d2 = {"Lcom/stepos/ailauncher/chat/view/i7;", "", "<init>", "()V", "Landroid/view/View;", "target", "", "crossWindow", "", "cornerRadiusDp", "Ly7/o;", "effect", "Ly7/E;", "c", "(Landroid/view/View;ZLjava/lang/Float;Ly7/o;)Ly7/E;", "", "tint", "blurRadius", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/view/View;IFZLjava/lang/Float;)Ly7/E;", "Lcom/stepos/ailauncher/container/glass/SheetGlassStyle;", "style", "l", "(Lcom/stepos/ailauncher/container/glass/SheetGlassStyle;)I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/container/glass/SheetGlassStyle;)F", "fraction", "Lkotlin/Pair;", "k", "(F)Lkotlin/Pair;", "handle", "targetView", "LY8/t;", "m", "(Ly7/E;FLandroid/view/View;)V", "Lkotlin/Function1;", "onReleased", "Landroid/view/View$OnAttachStateChangeListener;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/view/View;Ly7/E;Lp9/l;)Landroid/view/View$OnAttachStateChangeListener;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ly7/E;)V", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;F)V", Const.INTENT_KEY_APIKEY, "Ly7/C;", "LA7/B;", ChatTracker.SEND_PRESET, "configure", "e", "(Landroid/view/View;ZLy7/C;Lp9/l;)Ly7/E;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.i7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2851i7 {
    public static final C2851i7 INSTANCE = new C2851i7();

    public static /* synthetic */ y7.E d(C2851i7 c2851i7, View view, boolean z10, Float f10, y7.o oVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        if ((i10 & 4) != 0) {
            f10 = null;
        }
        if ((i10 & 8) != 0) {
            oVar = y7.o.INSTANCE.l();
        }
        return c2851i7.c(view, z10, f10, oVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ y7.E f(C2851i7 c2851i7, View view, boolean z10, y7.C c10, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            c10 = G.a.f43886a.f();
        }
        if ((i10 & 8) != 0) {
            interfaceC5074l = null;
        }
        return c2851i7.e(view, z10, c10, interfaceC5074l);
    }

    public final void a(View target, float cornerRadiusDp) {
        kotlin.jvm.internal.p.i(target, "target");
        com.stepos.ailauncher.container.glass.h.INSTANCE.j(target, cornerRadiusDp);
    }

    public final void b(View target, float cornerRadiusDp) {
        kotlin.jvm.internal.p.i(target, "target");
        com.stepos.ailauncher.container.glass.h.INSTANCE.k(target, cornerRadiusDp);
    }

    public final y7.E c(View target, boolean crossWindow, Float cornerRadiusDp, y7.o effect) {
        kotlin.jvm.internal.p.i(target, "target");
        kotlin.jvm.internal.p.i(effect, "effect");
        return com.stepos.ailauncher.container.glass.h.m(com.stepos.ailauncher.container.glass.h.INSTANCE, target, crossWindow, cornerRadiusDp, effect, false, 16, null);
    }

    public final y7.E e(View target, boolean crossWindow, y7.C<A7.B> preset, InterfaceC5074l<? super A7.B, Y8.t> configure) {
        kotlin.jvm.internal.p.i(target, "target");
        kotlin.jvm.internal.p.i(preset, "preset");
        return com.stepos.ailauncher.container.glass.h.INSTANCE.u(target, crossWindow, preset, configure);
    }

    public final y7.E g(View target, int tint, float blurRadius, boolean crossWindow, Float cornerRadiusDp) {
        kotlin.jvm.internal.p.i(target, "target");
        return com.stepos.ailauncher.container.glass.h.INSTANCE.x(target, tint, blurRadius, crossWindow, cornerRadiusDp);
    }

    public final void h(y7.E handle) {
        com.stepos.ailauncher.container.glass.h.INSTANCE.F(handle);
    }

    public final View.OnAttachStateChangeListener i(View target, y7.E handle, InterfaceC5074l<? super y7.E, Y8.t> onReleased) {
        kotlin.jvm.internal.p.i(target, "target");
        return com.stepos.ailauncher.container.glass.h.INSTANCE.G(target, handle, onReleased);
    }

    public final float j(SheetGlassStyle style) {
        kotlin.jvm.internal.p.i(style, "style");
        return com.stepos.ailauncher.container.glass.h.INSTANCE.I(style);
    }

    public final Pair<Integer, Float> k(float fraction) {
        return com.stepos.ailauncher.container.glass.h.INSTANCE.J(fraction);
    }

    public final int l(SheetGlassStyle style) {
        kotlin.jvm.internal.p.i(style, "style");
        return com.stepos.ailauncher.container.glass.h.INSTANCE.K(style);
    }

    public final void m(y7.E handle, float cornerRadiusDp, View targetView) {
        kotlin.jvm.internal.p.i(targetView, "targetView");
        com.stepos.ailauncher.container.glass.h.INSTANCE.M(handle, cornerRadiusDp, targetView);
    }
}
