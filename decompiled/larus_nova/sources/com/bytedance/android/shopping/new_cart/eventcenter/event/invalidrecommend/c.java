package com.bytedance.android.shopping.new_cart.eventcenter.event.invalidrecommend;

import android.net.Uri;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f179070a = 0;

    static {
    }

    public static Uri b(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "map");
        Intrinsics.checkNotNullParameter(r100, "$this$toUri");
        Uri.Builder r102 = UriProtector.parse(r100).buildUpon();
        Iterator r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.appendQueryParameter((String) r104.getKey(), (String) r104.getValue());
        goto L4
    L7:
        return r102.build();
    }

    public static Uri a(String r100, String r101, Map r102, PageFinder r103) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "btm");
        if (r103 != null) goto L5;
        String r104 = null;
    L6:
        if (r104 != null) goto L8;
    L11:
        boolean r105 = true;
    L13:
        if (r105 == false) goto L15;
        Intrinsics.checkNotNullParameter(r100, "$this$toUri");
        return UriProtector.parse(r100);
    L15:
        Intrinsics.checkNotNullParameter(r100, "$this$toUri");
        return UriProtector.parse(r100).buildUpon().appendQueryParameter(PhotoEnterModel.SOURCE_BTM_TOKEN, r104).build();
    L8:
        if (r104.length() == 0) goto L11;
        r105 = false;
        goto L13
    L5:
        r104 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r101, r103, new BcmParams().merge(r102));
        goto L6
    }
}
