package com.bytedance.als.ui.group;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.scene.group.GroupScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/als/ui/group/SceneEnvironmentContainerGroupScene;", "Lcom/bytedance/scene/group/GroupScene;", "<init>", "()V", "als_release"}, k = 1, mv = {1, 4, 1})
public final class SceneEnvironmentContainerGroupScene extends GroupScene {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f38101u;

    public SceneEnvironmentContainerGroupScene() {
        this.f38101u = ViewCompat.generateViewId();
    }

    @Override // com.bytedance.scene.group.GroupScene, com.bytedance.scene.Scene
    public final /* bridge */ /* synthetic */ View Z(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return t0(r100, r101, r102);
    }

    @Override // com.bytedance.scene.group.GroupScene
    public final ViewGroup t0(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        FrameLayout r103 = new FrameLayout(j0());
        r103.setId(this.f38101u);
        return r103;
    }
}
