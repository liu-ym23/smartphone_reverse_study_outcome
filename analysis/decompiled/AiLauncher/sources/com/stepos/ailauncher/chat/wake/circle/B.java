package com.stepos.ailauncher.chat.wake.circle;

import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\b\u0004*\u0001\u0011\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/circle/B;", "", "<init>", "()V", "", "Landroid/view/View;", "targets", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;)V", "c", "view", Const.INTENT_KEY_UMID, "(Landroid/view/View;)V", "", "cachedViews", "Ljava/util/Set;", "com/stepos/ailauncher/chat/wake/circle/B$a", "detachListener", "Lcom/stepos/ailauncher/chat/wake/circle/B$a;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class B {
    private final Set<View> cachedViews = new LinkedHashSet();
    private final a detachListener = new a();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/wake/circle/B$a", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            B.this.d(v10);
        }
    }

    public final void b(List<? extends View> targets) {
        kotlin.jvm.internal.p.i(targets, "targets");
        for (View view : targets) {
            if (!this.cachedViews.contains(view) && view.isAttachedToWindow() && view.isHardwareAccelerated() && view.isShown() && view.getWidth() > 0 && view.getHeight() > 0 && view.getLayerType() == 0) {
                this.cachedViews.add(view);
                view.addOnAttachStateChangeListener(this.detachListener);
                view.setLayerType(2, null);
            }
        }
    }

    public final void c() {
        Iterator it = Z8.F.m1(this.cachedViews).iterator();
        while (it.hasNext()) {
            d((View) it.next());
        }
    }

    public final void d(View view) {
        if (this.cachedViews.remove(view)) {
            view.removeOnAttachStateChangeListener(this.detachListener);
            if (view.getLayerType() == 2) {
                view.setLayerType(0, null);
                view.invalidate();
            }
        }
    }
}
