package com.bytedance.android.ec.store.utils;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f48663a = 0;

    static {
    }

    public static String a(String r100, String r101) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if (r101 != null) goto L6;
        return r100;
    L6:
        UrlBuilderV2 r102 = new UrlBuilderV2(r100);
        r102.addOrReplaceParam(PhotoEnterModel.SOURCE_BTM_TOKEN, r101);
        return r102.build();
    }

    public static String b(String r100, String r101, PageFinder r102, BcmParams r103) {
        Intrinsics.checkNotNullParameter(r101, "btm");
        Intrinsics.checkNotNullParameter(r102, "pageFinder");
        if (r100 != null) goto L6;
        return r100;
    L6:
        return a(r100, BtmSDK.INSTANCE.createJumpSourceBtmToken(r101, r102, r103));
    }
}
