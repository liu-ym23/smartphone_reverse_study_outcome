package com.bytedance.android.livesdk.dislike;

import com.baidu.platform.comapi.map.MapController;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class l extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.base.model.user.f f122119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.dislike.action.l f122120d;

    @Override // com.bytedance.android.livesdk.dislike.n
    public final boolean a(n r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if ((r100 instanceof l) == true) goto L5;
        return false;
    L5:
        com.bytedance.android.live.base.model.user.f r101 = ((l) r100).f122119c;
        if (r101 == null) goto L14;
        this.f122119c.getClass();
        if ((!Intrinsics.areEqual(null, null)) == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L14;
        return false;
    L14:
        return super.a(r100);
    }

    public l(com.bytedance.android.live.base.model.user.f r100, com.bytedance.android.livesdk.dislike.action.l r101, ItemType r102) {
        Intrinsics.checkNotNullParameter(r100, "contact");
        Intrinsics.checkNotNullParameter(r101, "imShareAction");
        Intrinsics.checkNotNullParameter(r102, DownloadHelper.IDENTITY);
        super(r102, r101);
        this.f122119c = r100;
        this.f122120d = r101;
    }
}
