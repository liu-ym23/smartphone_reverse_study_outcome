package com.bytedance.android.live.core.tetris.layer.core.element.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.tetris.componentx.component.b;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.lark.utils.statistics.PerfLog;
import j70.o;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/element/widget/WidgetElement;", "Lcom/bytedance/android/live/core/tetris/layer/core/element/Element;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WidgetElement extends Element<Widget> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f65712l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Widget f65713m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RecyclableWidgetManager f65714n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final o f65715o;

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final Lifecycle g() {
        return this.f65714n.getLifecycle();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final Widget i() {
        Widget r100 = this.f65713m;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L5:
        return r100;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final o70.a j() {
        Widget r100 = this.f65713m;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L6:
        if ((r100 instanceof o70.a) == false) goto L15;
        LifecycleOwner r101 = this.f65713m;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L10:
        if (r101 == null) goto L14;
        return (o70.a) r101;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.event.ElementEventResolver");
    L15:
        return null;
    }

    public final void l() {
        RecyclableWidgetManager r100 = this.f65714n;
        Widget r101 = this.f65713m;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L5:
        r100.unload(r101);
        b r102 = this.f65661c;
        if (r102 == null) goto L12;
        Widget r103 = this.f65713m;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L10:
        r102.e(this, r103);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final void k() {
        l();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final void onViewCreated(View r100) {
        if ((r100 instanceof ViewGroup) == false) goto L62;
        w70.a<? extends h70.b> r101 = this.f65715o.j();
        Object r102 = null;
        if ((r101 instanceof w70.a) == true) goto L7;
        r101 = null;
    L7:
        if (r101 == null) goto L9;
        Widget r103 = r101.a(this.f65669k);
    L10:
        if (r103 != null) goto L18;
        Class<? extends Widget> r104 = this.f65715o.c();
        if (r104 != null) goto L14;
        r103 = null;
        goto L18
    L14:
        if (LiveRecyclableWidget.class.isAssignableFrom(r104) == false) goto L16;
        r103 = (Widget) this.f65714n.W90(r104);
        goto L18
    L16:
        r103 = r104.newInstance();
    L18:
        if (r103 == null) goto L20;
    L22:
        if (r103 == null) goto L61;
        this.f65713m = r103;
        b r105 = this.f65661c;
        if (r105 == null) goto L26;
        r105.d(this, r103);
    L26:
        b r106 = this.f65661c;
        if (r106 == null) goto L32;
        Widget r107 = this.f65713m;
        if (r107 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L31:
        r106.c(this, r107);
    L32:
        Widget r108 = this.f65713m;
        if (r108 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L35:
        ViewGroup r109 = (ViewGroup) r100;
        if ((r108 instanceof LiveRecyclableWidget) == false) goto L38;
        boolean r110 = this.f65715o.h();
        this.f65715o.f();
        this.f65714n.fa0(r109, (LiveRecyclableWidget) r108, r110, this.f65715o.a());
    L63:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L58
        Widget r112 = this.f65713m;     // Catch: Throwable -> L58
        if (r112 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("widget");     // Catch: Throwable -> L58
    L43:
        if ((r112 instanceof z70.a) == false) goto L56;
        Map<String, String> r113 = this.f65665g;     // Catch: Throwable -> L58
        if (r113 == null) goto L56;
        Widget r114 = this.f65713m;     // Catch: Throwable -> L58
        if (r114 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("widget");     // Catch: Throwable -> L58
    L50:
        if ((r114 instanceof z70.a) == false) goto L53;
        r102 = r114;
    L53:
        z70.a r115 = (z70.a) r102;     // Catch: Throwable -> L58
        if (r115 == null) goto L56;
        r115.setExtraInfo(r113);     // Catch: Throwable -> L58
    L56:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L58
        return;
    L58:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L38:
        this.f65714n.da0(r109, r108, this.f65715o.h(), this.f65715o.f());
        goto L63
    L61:
        throw new NullPointerException("create widget error, element type is " + this.f65662d);
    L20:
        if (((Boolean) this.f65712l.getValue()).booleanValue() == false) goto L22;
        SafetyGuard.a(null, null, "create widget error, element is " + this.f65662d);
        r103 = new EmptyWidget();
        goto L22
    L9:
        r103 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final View c(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ViewGroup r102 = this.f65715o.e(r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        if (r101 == null) goto L9;
        return (View) r101.getClass().getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r100});
    L9:
        return new FrameLayout(r100);
    }

    public WidgetElement(RecyclableWidgetManager r100, o r101, h70.b r102) {
        Intrinsics.checkNotNullParameter(r100, "widgetManager");
        Intrinsics.checkNotNullParameter(r101, "widgetAttribute");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r102);
        this.f65714n = r100;
        this.f65715o = r101;
        this.f65659a = r101.g();
        this.f65712l = LazyKt.lazy(WidgetElement$enableEmptyWidgetOpt$2.INSTANCE);
    }
}
