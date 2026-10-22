package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftPanelAssetDownloadDataStore;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements i, com.bytedance.android.scope.o {
    public g() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.i
    public final List<Long> k7() {
        i12.d r100 = i12.m.f487958e2.a();
        if (r100 == null) goto L5;
        Object r101 = com.bytedance.android.scope.m.f163449e.d(r100, GiftPanelAssetDownloadDataStore.class);
    L6:
        GiftPanelAssetDownloadDataStore r102 = (GiftPanelAssetDownloadDataStore) r101;
        if (r102 == null) goto L11;
        List<Long> r103 = CollectionsKt.toList(r102.f127199a);
        if (r103 == null) goto L11;
        return r103;
    L11:
        return CollectionsKt.emptyList();
    L5:
        r101 = null;
        goto L6
    }
}
