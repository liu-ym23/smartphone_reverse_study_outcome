package com.stepos.ailauncher.chat.view;

import android.view.View;
import android.view.ViewTreeObserver;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0015R\"\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/chat/view/z6;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "Landroid/view/View;", "target", "Lkotlin/Function0;", "", x5.d.EXTRA_ENABLED, "Lkotlin/Function1;", "", "LY8/t;", "updateRadius", "<init>", "(Landroid/view/View;Lp9/a;Lp9/l;)V", "c", "()Ljava/lang/Float;", Const.INTENT_KEY_PKGNAME, "()V", "onPreDraw", "()Z", Const.INTENT_KEY_APIKEY, "Landroid/view/View;", "Lp9/a;", "Lp9/l;", "Landroid/view/ViewTreeObserver;", "observer", "Landroid/view/ViewTreeObserver;", "lastRadius", "Ljava/lang/Float;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.z6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class ViewTreeObserverOnPreDrawListenerC3033z6 implements ViewTreeObserver.OnPreDrawListener {
    private final InterfaceC5063a<Boolean> enabled;
    private Float lastRadius;
    private ViewTreeObserver observer;
    private final View target;
    private final InterfaceC5074l<Float, Y8.t> updateRadius;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewTreeObserverOnPreDrawListenerC3033z6(View target, InterfaceC5063a<Boolean> enabled, InterfaceC5074l<? super Float, Y8.t> updateRadius) {
        kotlin.jvm.internal.p.i(target, "target");
        kotlin.jvm.internal.p.i(enabled, "enabled");
        kotlin.jvm.internal.p.i(updateRadius, "updateRadius");
        this.target = target;
        this.enabled = enabled;
        this.updateRadius = updateRadius;
    }

    public final void a() {
        ViewTreeObserver viewTreeObserver = this.observer;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                viewTreeObserver = null;
            }
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
        }
        this.observer = null;
    }

    public final void b() {
        this.lastRadius = c();
        if (this.observer == null) {
            ViewTreeObserver viewTreeObserver = this.target.getViewTreeObserver();
            this.observer = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnPreDrawListener(this);
            }
        }
    }

    public final Float c() {
        if (this.enabled.invoke().booleanValue()) {
            return Float.valueOf(A6.INSTANCE.a(this.target.getHeight(), this.target.getResources().getDisplayMetrics().density));
        }
        return null;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        if (this.target.isShown() && this.target.isAttachedToWindow()) {
            Float fC = c();
            if (kotlin.jvm.internal.p.c(fC, this.lastRadius)) {
                return true;
            }
            this.updateRadius.invoke(fC);
        }
        return true;
    }
}
