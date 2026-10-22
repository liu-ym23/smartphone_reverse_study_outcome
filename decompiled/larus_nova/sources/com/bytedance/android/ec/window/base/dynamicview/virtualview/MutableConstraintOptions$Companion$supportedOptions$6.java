package com.bytedance.android.ec.window.base.dynamicview.virtualview;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KMutableProperty1;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class MutableConstraintOptions$Companion$supportedOptions$6 extends MutablePropertyReference1Impl {
    public static final KMutableProperty1 INSTANCE = null;

    static {
        INSTANCE = new MutableConstraintOptions$Companion$supportedOptions$6();
    }

    public MutableConstraintOptions$Companion$supportedOptions$6() {
        super(ConstraintLayout.LayoutParams.class, "horizontalChainStyle", "getHorizontalChainStyle()I", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return Integer.valueOf(((ConstraintLayout.LayoutParams) r100).horizontalChainStyle);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
    public void set(Object r100, Object r101) {
        int r102 = ((Number) r101).intValue();
        ((ConstraintLayout.LayoutParams) r100).horizontalChainStyle = r102;
    }
}
