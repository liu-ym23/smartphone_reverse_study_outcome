package com.obric.oui.pullrefresh.header;

import android.view.View;
import com.obric.oui.pullrefresh.OPullRefreshLayout;
import com.obric.oui.pullrefresh.c;

/* JADX INFO: compiled from: ORefreshHeader.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface a {
    View getView();

    void onFinish(OPullRefreshLayout r1, boolean r2);

    void onPulling(OPullRefreshLayout r1, float r2, float r3, float r4);

    void onStateChanged(OPullRefreshLayout r1, c r2, c r3);
}
