package androidx.core.view;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewKt$doOnAttach$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ d.h.a.b<View, d.x> $action;
    final /* synthetic */ View $this_doOnAttach;

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r1) {
    }

    public ViewKt$doOnAttach$1(View r3, d.h.a.b<? super View, d.x> r4) {
        d.h.a.b<View, d.x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        this.$this_doOnAttach = r3;
        this.$action = r5;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r4) {
        this.$this_doOnAttach.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(this, View.OnAttachStateChangeListener.class, "com.obric.aiagent.plugin"));
        this.$action.invoke(r4);
    }
}
