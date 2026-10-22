package com.gyf.immersionbar;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Constants.java */
/* JADX INFO: loaded from: classes2.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f13842a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int f13843b = 0;

    static {
        f13842a = ZeusTransformUtils.mapRes(R.id.immersion_status_bar_view, DbHelper.COL_ID, "immersion_status_bar_view");
        f13843b = ZeusTransformUtils.mapRes(R.id.immersion_navigation_bar_view, DbHelper.COL_ID, "immersion_navigation_bar_view");
    }
}
