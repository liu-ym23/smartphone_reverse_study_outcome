package com.bytedance.als.ui;

import android.os.Bundle;
import com.bytedance.scene.Scene;
import com.bytedance.scene.group.UserVisibleHintGroupScene;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/als/ui/UIScene;", "", "STATE", "ACTION", "Lcom/bytedance/scene/group/UserVisibleHintGroupScene;", "<init>", "()V", "als_release"}, k = 1, mv = {1, 4, 1})
public abstract class UIScene<STATE, ACTION> extends UserVisibleHintGroupScene {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f38097z;

    @Override // com.bytedance.scene.Scene
    public void onResume() {
        super.onResume();
        if (this.f38097z == false) goto L6;
        this.f38097z = false;
        return;
    }

    public UIScene() {
    }

    @Override // com.bytedance.scene.group.UserVisibleHintGroupScene, com.bytedance.scene.group.GroupScene, com.bytedance.scene.Scene
    public final void W(Bundle r100) {
        super.W(r100);
        Iterator r101 = CollectionsKt.toList(this.f268655q.g()).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        y0((Scene) r101.next());
        goto L4
    }
}
