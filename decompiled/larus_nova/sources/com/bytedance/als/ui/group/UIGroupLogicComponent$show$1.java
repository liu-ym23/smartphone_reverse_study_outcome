package com.bytedance.als.ui.group;

import com.bytedance.scene.group.GroupScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
final /* synthetic */ class UIGroupLogicComponent$show$1 extends MutablePropertyReference0Impl {
    public UIGroupLogicComponent$show$1(UIGroupLogicComponent r100) {
        super(r100, UIGroupLogicComponent.class, "childContainerGroupScene", "getChildContainerGroupScene()Lcom/bytedance/scene/group/GroupScene;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        GroupScene r100 = ((UIGroupLogicComponent) this.receiver).f38102c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("childContainerGroupScene");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        UIGroupLogicComponent r101 = (UIGroupLogicComponent) this.receiver;
        GroupScene r102 = (GroupScene) r100;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f38102c = r102;
    }
}
