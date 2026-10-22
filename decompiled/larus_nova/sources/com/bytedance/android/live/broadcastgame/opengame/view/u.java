package com.bytedance.android.live.broadcastgame.opengame.view;

import com.bytedance.common.utility.Logger;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes45.dex */
public final class u implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque<m> f61329a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.f
    public final com.bytedance.android.live.broadcastgame.opengame.message.r poll() {
        m r100 = this.f61329a.poll();
    L3:
        if (r100 == null) goto L14;
        if ((System.currentTimeMillis() - r100.f61313a) > 10000) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
    L12:
        if (r101 == true) goto L14;
        r100 = this.f61329a.poll();
        goto L3
    L10:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L12;
        Logger.d("PayFlowView", "PayMsgQueue, msg is invalid and removed, msg=" + r100.f61314b);
        goto L12
    L7:
        r101 = false;
    L14:
        if (r100 != null) goto L20;
        return null;
    L20:
        return r100.f61314b;
    }

    public u() {
        this.f61329a = new ArrayDeque();
    }
}
