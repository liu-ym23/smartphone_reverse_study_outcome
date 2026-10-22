package androidx.core.view;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewKt$doOnLayout$$inlined$doOnNextLayout$1 implements View.OnLayoutChangeListener {
    final /* synthetic */ d.h.a.b $action$inlined;

    public ViewKt$doOnLayout$$inlined$doOnNextLayout$1(d.h.a.b r3) {
        this.$action$inlined = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(this, View.OnLayoutChangeListener.class, "com.obric.aiagent.plugin"));
        this.$action$inlined.invoke(r1);
    }
}
