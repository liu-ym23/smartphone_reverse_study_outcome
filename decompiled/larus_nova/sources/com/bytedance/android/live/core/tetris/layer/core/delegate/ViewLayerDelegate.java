package com.bytedance.android.live.core.tetris.layer.core.delegate;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.ViewLayer;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.layout.LayoutManager;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import h70.b;
import j70.f;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0005:\u0002\b\tB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/delegate/ViewLayerDelegate;", "Lh70/b;", "C", "Lcom/bytedance/android/live/core/tetris/layer/core/delegate/LayerDelegate;", "Lcom/bytedance/android/live/core/tetris/layer/core/ViewLayer;", "Lcom/bytedance/android/live/core/tetris/layer/core/delegate/b;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ViewLayerDelegate<C extends h70.b> extends LayerDelegate<ViewLayer, C> implements com.bytedance.android.live.core.tetris.layer.core.delegate.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f65649l = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LayoutManager f65650g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.android.live.core.tetris.layer.core.delegate.a f65651h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public v70.a f65652i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f65653j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<f, l70.a<C>> f65654k;

    public static final class a {
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f65655a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f f65656b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ElementConstraint f65657c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ViewLayerDelegate f65658d;

        public final void a() {
            if (this.f65655a == true) goto L6;
            ALogger.i("ShadowPlayerPosition", "Runnable[" + hashCode() + "] is expired");
            return;
        L6:
            ALogger.i("ShadowPlayerPosition", "ViewLayerDelegate delay refresh in Runnable[" + hashCode() + ']');
            if (this.f65658d.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L12;
            LayoutManager r100 = this.f65658d.f65650g;
            if (r100 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        L11:
            r100.b(this.f65656b, this.f65657c, this.f65658d.h(), this.f65658d.i());
        L12:
            ViewLayerDelegate r101 = this.f65658d;
            Lazy r102 = ViewLayerDelegate.f65649l;
            r101.r().remove(this.f65656b);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(ViewLayerDelegate r100, f r101, ElementConstraint r102) {
            Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r102, "elementConstraint");
            this.f65658d = r100;
            this.f65656b = r101;
            this.f65657c = r102;
            this.f65655a = true;
        }
    }

    public final HashMap<f, ViewLayerDelegate<C>.b> r() {
        return (HashMap) this.f65653j.getValue();
    }

    public void t() {
    }

    static {
        f65649l = LazyKt.lazy(ViewLayerDelegate$Companion$fixOnMeasureNotInvoke$2.INSTANCE);
    }

    public final v70.a s() {
        v70.a r100 = this.f65652i;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewProxy");
    L5:
        return r100;
    }

    public ViewLayerDelegate() {
        this.f65653j = LazyKt.lazy(ViewLayerDelegate$postRunnableMap$2.INSTANCE);
        this.f65654k = new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate
    public void onDestroy() {
        super.onDestroy();
        r().clear();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate
    public final void b(Element<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        super.b(r100);
        if (this.f65654k.containsKey(r100.f65662d) == false) goto L19;
        l70.a r101 = (l70.a) ((LinkedHashMap) this.f65654k).get(r100.f65662d);
        if (r101 == null) goto L7;
        C r102 = i();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f507762a = r102;
    L7:
        if (r101 == null) goto L9;
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r101.f507765d = this;
    L9:
        if (r101 == null) goto L11;
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r101.f507764c = this;
    L11:
        if (r101 == null) goto L17;
        v70.c r103 = r100.h();
        if (r103 == null) goto L16;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r101.f507763b = r103;
        goto L17
    L16:
        throw new RuntimeException(r100.f65662d + " is invalid.");
    L17:
        if (r101 == null) goto L19;
        r101.c();
    L19:
        LocalTestManager.a(new Class[]{wy.a.class});
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate
    public final void e(Element<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        super.e(r100);
        if (this.f65654k.containsKey(r100.f65662d) == false) goto L8;
        Map<f, l70.a<C>> r101 = this.f65654k;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        l70.a r103 = (l70.a) r102.get(r100.f65662d);
        if (r103 == null) goto L9;
        r103.d();
        return;
    L9:
        return;
    }

    public final void m(l70.a<C> r100) {
        Intrinsics.checkNotNullParameter(r100, "elementDelegate");
        if (this.f65654k.containsKey(r100.f507767f) == true) goto L6;
        this.f65654k.put(r100.f507767f, r100);
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r100.f507766e = this;
        return;
    }

    public final v70.c p(f r100) {
        Intrinsics.checkNotNullParameter(r100, "elementType");
        Element<?> r101 = h().f2(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.h();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.delegate.b
    public final void a(f r100, ElementConstraint r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "elementConstraint");
        o(r100, r101);
    }

    public final void o(f r100, ElementConstraint r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "elementConstraint");
        LocalTestManager.a(new Class[]{wy.a.class});
        if (((Boolean) f65649l.getValue()).booleanValue() == false) goto L17;
        ALogger.i("ShadowPlayerPosition", "fixApplyConstraint " + r100 + " , layer isInLayout: " + h().f65639g);
        if (h().f65639g == true) goto L13;
        ViewLayerDelegate<C>.b r102 = r().get(r100);
        if (r102 == null) goto L9;
        ALogger.i("ShadowPlayerPosition", "ViewLayerDelegate remove delay refresh Runnable[" + r102.hashCode() + ']');
        r102.f65655a = false;
        h().removeCallbacks(r102);
        ViewLayerDelegate<C>.b r103 = r().remove(r100);
    L9:
        LayoutManager r104 = this.f65650g;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
    L12:
        r104.b(r100, r101, h(), i());
        return;
    L13:
        ViewLayerDelegate<C>.b r105 = new b(this, r100, r101);
        ViewLayerDelegate<C>.b r106 = r().get(r100);
        if (r106 == null) goto L16;
        r106.f65655a = false;
        h().removeCallbacks(r106);
    L16:
        r().put(r100, r105);
        h().post(r105);
        return;
    L17:
        LayoutManager r107 = this.f65650g;
        if (r107 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
    L20:
        r107.b(r100, r101, h(), i());
    }
}
