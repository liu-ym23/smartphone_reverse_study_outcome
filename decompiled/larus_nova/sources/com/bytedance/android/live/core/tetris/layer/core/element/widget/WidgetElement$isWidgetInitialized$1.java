package com.bytedance.android.live.core.tetris.layer.core.element.widget;

import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class WidgetElement$isWidgetInitialized$1 extends MutablePropertyReference0Impl {
    public WidgetElement$isWidgetInitialized$1(WidgetElement r100) {
        super(r100, WidgetElement.class, "widget", "getWidget$tetris_saasRelease()Lcom/bytedance/ies/sdk/widgets/Widget;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        Widget r100 = ((WidgetElement) this.receiver).f65713m;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        WidgetElement r101 = (WidgetElement) this.receiver;
        Widget r102 = (Widget) r100;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f65713m = r102;
    }
}
