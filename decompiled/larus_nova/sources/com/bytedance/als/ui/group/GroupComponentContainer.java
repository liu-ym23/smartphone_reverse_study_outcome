package com.bytedance.als.ui.group;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.scene.Scene;
import com.bytedance.scene.group.GroupScene;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/als/ui/group/GroupComponentContainer;", "Lcom/bytedance/scene/group/GroupScene;", "als_release"}, k = 1, mv = {1, 4, 1})
public final class GroupComponentContainer extends GroupScene {
    @Override // com.bytedance.scene.group.GroupScene, com.bytedance.scene.Scene
    public final void W(Bundle r100) {
        super.W(r100);
        Iterator r101 = CollectionsKt.toList(this.f268655q.g()).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        y0((Scene) r101.next());
        goto L4
    }

    @Override // com.bytedance.scene.group.GroupScene, com.bytedance.scene.Scene
    public final /* bridge */ /* synthetic */ View Z(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return t0(r100, r101, r102);
    }

    @Override // com.bytedance.scene.group.GroupScene
    public final ViewGroup t0(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        View r103 = r100.inflate(0, r101, false);
        if (r103 == null) goto L7;
        return (ViewGroup) r103;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
