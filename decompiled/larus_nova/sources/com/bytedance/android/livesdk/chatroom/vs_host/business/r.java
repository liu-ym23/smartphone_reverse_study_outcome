package com.bytedance.android.livesdk.chatroom.vs_host.business;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdk.chatroom.ui.UserFeatureLabelListAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class r implements wr1.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UserFeatureLabelListAdapter f118282a;

    public r() {
        this.f118282a = new UserFeatureLabelListAdapter();
    }

    @Override // wr1.f
    public final UserFeatureLabelListAdapter getAdapter() {
        return this.f118282a;
    }

    @Override // wr1.f
    public final void a(bm1.e r100) {
        this.f118282a.f112566b = r100;
    }

    @Override // wr1.f
    public final void setData(List<? extends py.k> r100) {
        Intrinsics.checkNotNullParameter(r100, "imageModels");
        UserFeatureLabelListAdapter r101 = this.f118282a;
        List<? extends py.k> r102 = r100;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add((ImageModel) com.bytedance.android.live.base.model.m.b((py.k) r104.next(), ImageModel.class));
        goto L4
    L6:
        r101.setData(r103);
    }
}
