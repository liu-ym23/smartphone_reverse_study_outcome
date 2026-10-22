package com.bytedance.android.shopping.deepfeed.slice.action;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {
    public static final a a(String r100, w r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        switch(r100.hashCode()) {
            case -2115133839: goto L48;
            case -2074317298: goto L45;
            case -1968913237: goto L42;
            case -1850654380: goto L39;
            case -1794491833: goto L36;
            case -1681077417: goto L33;
            case -1534621073: goto L30;
            case -1396813790: goto L27;
            case -1343365017: goto L24;
            case -1203445292: goto L21;
            case -758654878: goto L18;
            case -221732173: goto L15;
            case 122108473: goto L12;
            case 1077645248: goto L9;
            case 1689782194: goto L6;
            default: goto L50;
        };
    L50:
        return null;
    L6:
        if (r100.equals("NotifyPosition") == false) goto L50;
        return new o(r101);
    L9:
        if (r100.equals("UpdateModel") == false) goto L50;
        return new s(r101);
    L12:
        if (r100.equals("AutoScrollTop") == false) goto L50;
        return new k(r101);
    L15:
        if (r100.equals("RegisterGestureArea") == false) goto L50;
        return new f(r101);
    L18:
        if (r100.equals("OpenPopup") == false) goto L50;
        return new m(r101);
    L21:
        if (r100.equals("RemoveCard") == false) goto L50;
        return new p(r101);
    L24:
        if (r100.equals("EventChain") == false) goto L50;
        return new e(r101);
    L27:
        if (r100.equals("PageFinish") == false) goto L50;
        return new n(r101);
    L30:
        if (r100.equals("Request") == false) goto L50;
        return new DeepFeedRequestAction(r101);
    L33:
        if (r100.equals("AdReport") == false) goto L50;
        return new i(r101);
    L36:
        if (r100.equals("AiRecRequest") == false) goto L50;
        return new j(r101);
    L39:
        if (r100.equals("Report") == false) goto L50;
        return new q(r101);
    L42:
        if (r100.equals("OpenSchema") == false) goto L50;
        return new DeepFeedSlcOpenAction(r101);
    L45:
        if (r100.equals("IntervalUpdate") == false) goto L50;
        return new DeepFeedSlcIntervalUpdateAction(r101);
    L48:
        if (r100.equals("VideoAction") == false) goto L50;
        return new r(r101);
    }
}
