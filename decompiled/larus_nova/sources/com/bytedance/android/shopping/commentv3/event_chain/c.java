package com.bytedance.android.shopping.commentv3.event_chain;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements v96.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f172756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<PageFinder> f172757b;

    @Override // v96.e
    public final void openSchema(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        p.f48130a.openSchema(this.f172756a, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Context r100, Function0<? extends PageFinder> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "btmPageFinderMethod");
        this.f172756a = r100;
        this.f172757b = r101;
    }

    @Override // v96.e
    public final void a(String r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "btm");
        Intrinsics.checkNotNullParameter(this.f172756a, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "btm");
        PageFinder r103 = this.f172757b.invoke();
        if (r103 != null) goto L5;
        String r104 = null;
    L6:
        if (r104 != null) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        Uri r106 = UriProtector.parse(r100);
    L15:
        p.f48130a.openSchema(this.f172756a, r106.toString());
        return;
    L14:
        r106 = UriProtector.parse(r100).buildUpon().appendQueryParameter(PhotoEnterModel.SOURCE_BTM_TOKEN, r104).build();
        goto L15
    L8:
        if (r104.length() == 0) goto L11;
        r105 = false;
        goto L12
    L5:
        r104 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r101, r103, new BcmParams().merge(r102));
        goto L6
    }
}
