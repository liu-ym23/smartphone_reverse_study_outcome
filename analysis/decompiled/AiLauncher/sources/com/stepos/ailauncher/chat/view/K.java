package com.stepos.ailauncher.chat.view;

import android.content.res.Resources;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.sheet.R$interpolator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000bJ!\u0010\u0010\u001a\u00020\b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000e\"\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J3\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J9\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/stepos/ailauncher/chat/view/K;", "", "<init>", "()V", "Landroid/view/View;", "artifacts", "under", "Lkotlin/Function0;", "LY8/t;", "onUnderHidden", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/view/View;Landroid/view/View;Lp9/a;)V", "onArtifactsGone", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "", "views", "l", "([Landroid/view/View;)V", "Lkotlin/Function1;", "", "block", "n", "(Landroid/view/View;Landroid/view/View;Lp9/l;)V", "target", "fromX", "toX", "onEnd", "e", "(Landroid/view/View;FFLp9/a;)V", "sample", "Landroid/view/animation/Interpolator;", "m", "(Landroid/view/View;)Landroid/view/animation/Interpolator;", "", "DURATION_MS", "J", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class K {
    private static final long DURATION_MS = 517;
    public static final K INSTANCE = new K();

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements View.OnLayoutChangeListener {
        final /* synthetic */ View $artifacts$inlined;
        final /* synthetic */ InterfaceC5074l $block$inlined;
        final /* synthetic */ View $under$inlined;

        public a(View view, View view2, InterfaceC5074l interfaceC5074l) {
            this.$artifacts$inlined = view;
            this.$under$inlined = view2;
            this.$block$inlined = interfaceC5074l;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            float fFloatValue;
            view.removeOnLayoutChangeListener(this);
            Float fValueOf = Float.valueOf(this.$artifacts$inlined.getWidth());
            if (fValueOf.floatValue() <= 0.0f) {
                fValueOf = null;
            }
            if (fValueOf != null) {
                fFloatValue = fValueOf.floatValue();
            } else {
                Float fValueOf2 = Float.valueOf(this.$under$inlined.getWidth());
                Float f10 = fValueOf2.floatValue() > 0.0f ? fValueOf2 : null;
                fFloatValue = f10 != null ? f10.floatValue() : this.$artifacts$inlined.getResources().getDisplayMetrics().widthPixels;
            }
            this.$block$inlined.invoke(Float.valueOf(fFloatValue));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(K k10, View view, float f10, float f11, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            interfaceC5063a = null;
        }
        k10.e(view, f10, f11, interfaceC5063a);
    }

    public static final void g(View view, float f10, InterfaceC5063a interfaceC5063a) {
        view.setTranslationX(f10);
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final Y8.t i(View view, View view2, InterfaceC5063a interfaceC5063a, float f10) {
        K k10 = INSTANCE;
        f(k10, view, -f10, 0.0f, null, 8, null);
        k10.e(view2, 0.0f, f10, interfaceC5063a);
        return Y8.t.f7040a;
    }

    public static final Y8.t k(View view, View view2, InterfaceC5063a interfaceC5063a, float f10) {
        K k10 = INSTANCE;
        f(k10, view, f10, 0.0f, null, 8, null);
        k10.e(view2, 0.0f, -f10, interfaceC5063a);
        return Y8.t.f7040a;
    }

    public static final float o(int i10) {
        return i10;
    }

    public final void e(final View target, float fromX, final float toX, final InterfaceC5063a<Y8.t> onEnd) {
        target.animate().cancel();
        target.setTranslationX(fromX);
        target.animate().translationX(toX).setDuration(DURATION_MS).setInterpolator(m(target)).withEndAction(new Runnable() { // from class: com.stepos.ailauncher.chat.view.H
            @Override // java.lang.Runnable
            public final void run() {
                K.g(target, toX, onEnd);
            }
        }).start();
    }

    public final void h(final View artifacts, final View under, final InterfaceC5063a<Y8.t> onArtifactsGone) {
        kotlin.jvm.internal.p.i(artifacts, "artifacts");
        kotlin.jvm.internal.p.i(under, "under");
        n(artifacts, under, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.G
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return K.i(under, artifacts, onArtifactsGone, ((Float) obj).floatValue());
            }
        });
    }

    public final void j(final View artifacts, final View under, final InterfaceC5063a<Y8.t> onUnderHidden) {
        kotlin.jvm.internal.p.i(artifacts, "artifacts");
        kotlin.jvm.internal.p.i(under, "under");
        if (artifacts.getWidth() <= 0) {
            artifacts.setTranslationX(artifacts.getResources().getDisplayMetrics().widthPixels);
        }
        n(artifacts, under, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.J
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return K.k(artifacts, under, onUnderHidden, ((Float) obj).floatValue());
            }
        });
    }

    public final void l(View... views) {
        kotlin.jvm.internal.p.i(views, "views");
        for (View view : views) {
            view.animate().cancel();
            view.setTranslationX(0.0f);
        }
    }

    public final Interpolator m(View sample) throws Resources.NotFoundException {
        Interpolator interpolatorLoadInterpolator = AnimationUtils.loadInterpolator(sample.getContext(), R$interpolator.ail_sheet_slide);
        kotlin.jvm.internal.p.h(interpolatorLoadInterpolator, "loadInterpolator(...)");
        return interpolatorLoadInterpolator;
    }

    public final void n(View artifacts, View under, InterfaceC5074l<? super Float, Y8.t> block) {
        Object next;
        float fFloatValue;
        Iterator it = SequencesKt___SequencesKt.R(Ka.t.w(Integer.valueOf(artifacts.getWidth()), Integer.valueOf(under.getWidth())), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.I
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Float.valueOf(K.o(((Integer) obj).intValue()));
            }
        }).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((Number) next).floatValue() > 0.0f) {
                    break;
                }
            }
        }
        Float f10 = (Float) next;
        if (f10 != null) {
            block.invoke(f10);
            return;
        }
        if (!artifacts.isLaidOut() || artifacts.isLayoutRequested()) {
            artifacts.addOnLayoutChangeListener(new a(artifacts, under, block));
            return;
        }
        Float fValueOf = Float.valueOf(artifacts.getWidth());
        if (fValueOf.floatValue() <= 0.0f) {
            fValueOf = null;
        }
        if (fValueOf != null) {
            fFloatValue = fValueOf.floatValue();
        } else {
            Float fValueOf2 = Float.valueOf(under.getWidth());
            Float f11 = fValueOf2.floatValue() > 0.0f ? fValueOf2 : null;
            fFloatValue = f11 != null ? f11.floatValue() : artifacts.getResources().getDisplayMetrics().widthPixels;
        }
        block.invoke(Float.valueOf(fFloatValue));
    }
}
