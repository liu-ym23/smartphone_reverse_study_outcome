package com.bytedance.als.ui_root;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.scene.group.GroupScene;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Deprecated(message = "don't use")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/als/ui_root/UIRootContainerGroupScene;", "Lcom/bytedance/scene/group/GroupScene;", "<init>", "()V", "als_release"}, k = 1, mv = {1, 4, 1})
public final class UIRootContainerGroupScene extends GroupScene {
    public UIRootContainerGroupScene() {
    }

    @Override // com.bytedance.scene.Scene
    public final void T(Bundle r100) {
        super.T(r100);
    }

    @Override // com.bytedance.scene.group.GroupScene, com.bytedance.scene.Scene
    public final /* bridge */ /* synthetic */ View Z(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return t0(r100, r101, r102);
    }

    @Override // com.bytedance.scene.group.GroupScene
    public final ViewGroup t0(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        View r103 = r100.inflate(i0().getInt("layoutId"), r101, false);
        if (r103 == null) goto L7;
        return (ViewGroup) r103;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
