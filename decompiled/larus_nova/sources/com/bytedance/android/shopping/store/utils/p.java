package com.bytedance.android.shopping.store.utils;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f186940a = 0;

    static {
    }

    public static String a(PageFinder r100, String r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "pageFinder");
        Intrinsics.checkNotNullParameter(r101, "btm");
        BtmSDK r103 = BtmSDK.INSTANCE;
        BcmParams r104 = new BcmParams();
        r104.put(com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE, "product");
        Unit r105 = Unit.INSTANCE;
        return r103.createJumpSourceBtmToken(r101, r100, r104.merge(r102));
    }
}
