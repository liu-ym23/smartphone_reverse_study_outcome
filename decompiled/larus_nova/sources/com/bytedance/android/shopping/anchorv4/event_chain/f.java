package com.bytedance.android.shopping.anchorv4.event_chain;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ecom.arch.slice.action.v;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class f implements v96.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f166741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f166742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<PageFinder> f166743c;

    @Override // v96.e
    public final void openSchema(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Context r101 = this.f166741a;
        if ((r101 instanceof Activity) == true) goto L5;
        r101 = null;
    L5:
        Activity r102 = (Activity) r101;
        if (r102 == null) goto L9;
        this.f166742b.f(r102, new hq.c(r100, 62));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Context r100, v r101, Function0<? extends PageFinder> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r102, "btmPageFinderMethod");
        this.f166741a = r100;
        this.f166742b = r101;
        this.f166743c = r102;
    }

    @Override // v96.e
    public final void a(String r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "btm");
        Intrinsics.checkNotNullParameter(this.f166741a, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "btm");
        PageFinder r103 = this.f166743c.invoke();
        Context r104 = null;
        if (r103 != null) goto L5;
        String r105 = null;
    L6:
        if (r105 != null) goto L8;
    L11:
        boolean r106 = true;
    L12:
        if (r106 == false) goto L14;
        Uri r107 = UriProtector.parse(r100);
    L15:
        Context r108 = this.f166741a;
        if ((r108 instanceof Activity) == false) goto L19;
        r104 = r108;
    L19:
        Activity r109 = (Activity) r104;
        if (r109 == null) goto L23;
        this.f166742b.f(r109, new hq.c(r107.toString(), 62));
        return;
    L23:
        return;
    L14:
        r107 = UriProtector.parse(r100).buildUpon().appendQueryParameter(PhotoEnterModel.SOURCE_BTM_TOKEN, r105).build();
        goto L15
    L8:
        if (r105.length() == 0) goto L11;
        r106 = false;
        goto L12
    L5:
        r105 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r101, r103, new BcmParams().merge(r102));
        goto L6
    }
}
