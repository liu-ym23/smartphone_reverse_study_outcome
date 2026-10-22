package com.stepos.ailauncher.chat.util;

import android.graphics.Rect;
import android.view.View;
import android.widget.ScrollView;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/chat/util/r;", "", "Landroid/widget/ScrollView;", "scrollView", "<init>", "(Landroid/widget/ScrollView;)V", "Landroid/view/View;", "target", "LY8/t;", "e", "(Landroid/view/View;)V", Const.INTENT_KEY_UMID, "()V", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Landroid/widget/ScrollView;", "Landroid/view/View;", "Ljava/lang/Runnable;", "pressOn", "Ljava/lang/Runnable;", "pressOff", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class r {
    private static final long DELAY_MS = 600;
    private static final long PRESS_MS = 300;
    private Runnable pressOff;
    private Runnable pressOn;
    private final ScrollView scrollView;
    private View target;

    public r(ScrollView scrollView) {
        kotlin.jvm.internal.p.i(scrollView, "scrollView");
        this.scrollView = scrollView;
    }

    public static final void f(View view, r rVar) {
        if (view.isAttachedToWindow()) {
            rVar.j(view);
            rVar.g(view);
        }
    }

    public static final void h(final View view, r rVar) {
        if (view.isAttachedToWindow()) {
            view.setPressed(true);
            Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.chat.util.q
                @Override // java.lang.Runnable
                public final void run() {
                    r.i(view);
                }
            };
            rVar.pressOff = runnable;
            rVar.scrollView.postDelayed(runnable, 300L);
        }
    }

    public static final void i(View view) {
        view.setPressed(false);
    }

    public final void d() {
        Runnable runnable = this.pressOn;
        if (runnable != null) {
            this.scrollView.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.pressOff;
        if (runnable2 != null) {
            this.scrollView.removeCallbacks(runnable2);
        }
        this.pressOn = null;
        this.pressOff = null;
        View view = this.target;
        if (view != null) {
            view.setPressed(false);
        }
        this.target = null;
    }

    public final void e(final View target) {
        kotlin.jvm.internal.p.i(target, "target");
        d();
        this.target = target;
        this.scrollView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.util.o
            @Override // java.lang.Runnable
            public final void run() {
                r.f(target, this);
            }
        });
    }

    public final void g(final View target) {
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.chat.util.p
            @Override // java.lang.Runnable
            public final void run() {
                r.h(target, this);
            }
        };
        this.pressOn = runnable;
        this.scrollView.postDelayed(runnable, DELAY_MS);
    }

    public final void j(View target) {
        Rect rect = new Rect(0, 0, target.getWidth(), target.getHeight());
        this.scrollView.offsetDescendantRectToMyCoords(target, rect);
        int scrollY = this.scrollView.getScrollY();
        int height = this.scrollView.getHeight() + scrollY;
        int i10 = rect.top;
        if (i10 < scrollY || rect.bottom > height) {
            int height2 = i10 - ((this.scrollView.getHeight() - target.getHeight()) / 3);
            View childAt = this.scrollView.getChildAt(0);
            this.scrollView.smoothScrollTo(0, C5685n.n(height2, 0, C5685n.f((childAt != null ? childAt.getHeight() : 0) - this.scrollView.getHeight(), 0)));
        }
    }
}
