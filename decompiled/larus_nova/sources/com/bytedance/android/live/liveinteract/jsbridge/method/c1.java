package com.bytedance.android.live.liveinteract.jsbridge.method;

import android.text.TextUtils;
import com.bytedance.android.live.browser.jsbridge.base.LiveReportAggregateALogResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import w20.bb;
import w20.h3;

/* JADX INFO: loaded from: classes46.dex */
public final class c1 extends h3<bb, LiveReportAggregateALogResultModel> {
    public c1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        bb r102 = (bb) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        List<bb.a> r103 = r102.a();
        if (r103 == null) goto L35;
        Iterator<T> r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L35;
        bb.a r105 = (bb.a) r104.next();
        String r106 = r105.a();
        String r107 = r105.c();
        String r108 = r105.b();
        if (TextUtils.isEmpty(r106) == true) goto L34;
        if (TextUtils.isEmpty(r107) == true) goto L34;
        if (TextUtils.isEmpty(r108) == true) goto L34;
        if (r106 == null) goto L6;
        switch(r106.hashCode()) {
            case 3237038: goto L32;
            case 3641990: goto L29;
            case 95458899: goto L26;
            case 96784904: goto L23;
            case 351107458: goto L20;
            default: goto L6;
        };
    L20:
        if (r106.equals("verbose") == false) goto L6;
        ALogger.v(r107, r108);
        goto L6
    L23:
        if (r106.equals("error") == false) goto L6;
        ALogger.e(r107, r108);
        goto L6
    L26:
        if (r106.equals("debug") == false) goto L6;
        ALogger.d(r107, r108);
        goto L6
    L29:
        if (r106.equals("warn") == false) goto L6;
        ALogger.w(r107, r108);
        goto L6
    L32:
        if (r106.equals("info") == false) goto L6;
        ALogger.i(r107, r108);
    L34:
        finishWithFailure();
        return;
    L35:
        LiveReportAggregateALogResultModel r109 = new LiveReportAggregateALogResultModel();
        r109.a(LiveReportAggregateALogResultModel.Code.Success);
        finishWithResult(r109);
    }
}
