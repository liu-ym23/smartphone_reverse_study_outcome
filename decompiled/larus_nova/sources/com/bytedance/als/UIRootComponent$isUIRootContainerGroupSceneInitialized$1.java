package com.bytedance.als;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
final /* synthetic */ class UIRootComponent$isUIRootContainerGroupSceneInitialized$1 extends MutablePropertyReference0Impl {
    public UIRootComponent$isUIRootContainerGroupSceneInitialized$1(UIRootComponent r100) {
        super(r100, UIRootComponent.class, "scene", "getScene()Lcom/bytedance/als/UIRootContainerGroupScene;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        UIRootContainerGroupScene r100 = ((UIRootComponent) this.receiver).f38087c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("scene");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        UIRootComponent r101 = (UIRootComponent) this.receiver;
        UIRootContainerGroupScene r102 = (UIRootContainerGroupScene) r100;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f38087c = r102;
    }
}
