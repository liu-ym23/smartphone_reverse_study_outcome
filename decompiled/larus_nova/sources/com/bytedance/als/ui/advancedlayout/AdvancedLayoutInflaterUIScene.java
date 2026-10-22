package com.bytedance.als.ui.advancedlayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.als.ui.UIScene;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/als/ui/advancedlayout/AdvancedLayoutInflaterUIScene;", "", "STATE", "ACTION", "Lcom/bytedance/als/ui/UIScene;", "<init>", "()V", "als_release"}, k = 1, mv = {1, 4, 1})
public abstract class AdvancedLayoutInflaterUIScene<STATE, ACTION> extends UIScene<STATE, ACTION> {
    public abstract int B0();

    @Override // com.bytedance.scene.Scene
    public final void b0() {
        this.f268595m = true;
    }

    @Override // com.bytedance.scene.Scene
    public final void onDestroy() {
        this.f268595m = true;
    }

    @Override // com.bytedance.scene.Scene
    public final void onPause() {
        this.f268595m = true;
    }

    @Override // com.bytedance.scene.Scene
    public final void onStart() {
        this.f268595m = true;
    }

    public AdvancedLayoutInflaterUIScene() {
    }

    @Override // com.bytedance.scene.group.UserVisibleHintGroupScene, com.bytedance.scene.Scene
    public final void a0() {
        super.a0();
    }

    @Override // com.bytedance.als.ui.UIScene, com.bytedance.scene.Scene
    public final void onResume() {
        super.onResume();
    }

    @Override // com.bytedance.scene.Scene
    public final void onStop() {
        super.onStop();
    }

    @Override // com.bytedance.scene.group.UserVisibleHintGroupScene, com.bytedance.scene.Scene
    public final void T(Bundle r100) {
        super.T(r100);
    }

    @Override // com.bytedance.scene.Scene
    public final void g0(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f268595m = true;
    }

    @Override // com.bytedance.scene.group.GroupScene
    public final ViewGroup t0(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        View r103 = r100.inflate(B0(), r101, false);
        if ((r103 instanceof ViewGroup) == true) goto L5;
        r103 = null;
    L5:
        ViewGroup r104 = (ViewGroup) r103;
        if (r104 == null) goto L9;
        return r104;
    L9:
        throw new IllegalArgumentException("AsyncLayoutUIScene getLayoutId() view must be ViewGroup");
    }
}
