package com.bytedance.android.gamecp.business.comment.adapter;

import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class h extends TrackRegisterStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentReplyListAdapter f51984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f51985b;

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final int getAutoReportStrategy() {
        return 4;
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final Map<String, String> getClickTempExtraAttrs() {
        HashMap r100 = new HashMap();
        ArrayList<com.bytedance.android.gamecp.business.comment.data.k> r101 = this.f51984a.f51892b;
        boolean r102 = false;
        if (r101 == null) goto L5;
        int r103 = r101.size();
    L6:
        int r104 = this.f51985b;
        if (r103 > r104) goto L9;
        return r100;
    L9:
        ArrayList<com.bytedance.android.gamecp.business.comment.data.k> r105 = this.f51984a.f51892b;
        if (r105 == null) goto L20;
        com.bytedance.android.gamecp.business.comment.data.k r106 = (com.bytedance.android.gamecp.business.comment.data.k) ListProtector.get(r105, r104);
        if (r106 == null) goto L20;
        com.bytedance.android.gamecp.business.comment.data.b r107 = r106.f52044b;
        if (r107 == null) goto L20;
        com.bytedance.android.gamecp.business.comment.data.o r108 = r107.evaluationInfo;
        if (r108 == null) goto L20;
        if ((r108.relationTypeFlag & 1) != 1) goto L20;
        r102 = true;
    L20:
        if (r102 == false) goto L22;
        String r109 = "unlike";
    L23:
        r100.put("action", r109);
        return r100;
    L22:
        r109 = IStrategyStateSupplier.KEY_INFO_LIKE;
        goto L23
    L5:
        r103 = 0;
        goto L6
    }

    public h(CommentReplyListAdapter r100, int r101) {
        this.f51984a = r100;
        this.f51985b = r101;
    }
}
