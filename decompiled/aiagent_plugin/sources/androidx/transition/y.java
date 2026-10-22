package androidx.transition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ViewGroupOverlayApi14.java */
/* JADX INFO: loaded from: classes.dex */
class y extends ViewOverlayApi14 implements aa {
    y(Context r3, ViewGroup r4, View r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    static y a(ViewGroup r2) {
        return (y) ZeusTransformUtils.preCheckCast(ViewOverlayApi14.d(r2), y.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.transition.aa
    public void a(View r1) {
        this.f2771a.add(r1);
    }

    @Override // androidx.transition.aa
    public void b(View r1) {
        this.f2771a.remove(r1);
    }
}
