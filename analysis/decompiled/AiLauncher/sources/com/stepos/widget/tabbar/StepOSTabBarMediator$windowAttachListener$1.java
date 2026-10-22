package com.stepos.widget.tabbar;

import Y8.t;
import android.view.View;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/widget/tabbar/StepOSTabBarMediator$windowAttachListener$1", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSTabBarMediator$windowAttachListener$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ StepOSTabBarMediator this$0;

    public StepOSTabBarMediator$windowAttachListener$1(StepOSTabBarMediator stepOSTabBarMediator) {
        this.this$0 = stepOSTabBarMediator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t onViewAttachedToWindow$lambda$0(StepOSTabBarMediator stepOSTabBarMediator) {
        stepOSTabBarMediator.alignTabToPager(stepOSTabBarMediator.viewPager.getCurrentItem(), false, true);
        return t.f7040a;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v10) {
        kotlin.jvm.internal.p.i(v10, "v");
        if (!this.this$0.attached || this.this$0.wired) {
            return;
        }
        this.this$0.wire();
        final StepOSTabBarMediator stepOSTabBarMediator = this.this$0;
        stepOSTabBarMediator.syncOnce(new InterfaceC5063a() { // from class: com.stepos.widget.tabbar.o
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return StepOSTabBarMediator$windowAttachListener$1.onViewAttachedToWindow$lambda$0(stepOSTabBarMediator);
            }
        });
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v10) {
        kotlin.jvm.internal.p.i(v10, "v");
        View view = v10 == this.this$0.tabBar ? this.this$0.viewPager : this.this$0.tabBar;
        if (this.this$0.attached && this.this$0.wired && !view.isAttachedToWindow()) {
            this.this$0.unwire();
        }
    }
}
