package com.bytedance.android.shopping.card_list.eventcenter.event.invalidrecommend;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f171623a = 0;

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

    public static Uri a(Context r100, String r101, String r102, Map r103, PageFinder r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "schema");
        Intrinsics.checkNotNullParameter(r102, "btm");
        if (r104 != null) goto L5;
        String r105 = null;
    L6:
        if (r105 != null) goto L8;
    L11:
        boolean r106 = true;
    L13:
        if (r106 == false) goto L15;
        Intrinsics.checkNotNullParameter(r101, "$this$toUri");
        return UriProtector.parse(r101);
    L15:
        Intrinsics.checkNotNullParameter(r101, "$this$toUri");
        return UriProtector.parse(r101).buildUpon().appendQueryParameter(PhotoEnterModel.SOURCE_BTM_TOKEN, r105).build();
    L8:
        if (r105.length() == 0) goto L11;
        r106 = false;
        goto L13
    L5:
        r105 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r102, r104, new BcmParams().merge(r103));
        goto L6
    }
}
