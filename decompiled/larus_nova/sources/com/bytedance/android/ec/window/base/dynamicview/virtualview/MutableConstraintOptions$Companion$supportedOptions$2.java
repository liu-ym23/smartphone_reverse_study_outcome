package com.bytedance.android.ec.window.base.dynamicview.virtualview;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KMutableProperty1;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class MutableConstraintOptions$Companion$supportedOptions$2 extends MutablePropertyReference1Impl {
    public static final KMutableProperty1 INSTANCE = null;

    static {
        INSTANCE = new MutableConstraintOptions$Companion$supportedOptions$2();
    }

    public MutableConstraintOptions$Companion$supportedOptions$2() {
        super(ConstraintLayout.LayoutParams.class, "horizontalBias", "getHorizontalBias()F", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return Float.valueOf(((ConstraintLayout.LayoutParams) r100).horizontalBias);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
    public void set(Object r100, Object r101) {
        float r102 = ((Number) r101).floatValue();
        ((ConstraintLayout.LayoutParams) r100).horizontalBias = r102;
    }
}
