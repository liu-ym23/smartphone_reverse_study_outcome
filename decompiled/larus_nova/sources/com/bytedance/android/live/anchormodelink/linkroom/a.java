package com.bytedance.android.live.anchormodelink.linkroom;

import com.bytedance.ies.sdk.widgets.DataCenter;
import iy.g;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static g f58739a;

    static {
    }

    public static g a(DataCenter r100) {
        if (r100 != null) goto L6;
        return f58739a;
    L6:
        return (g) r100.get("data_new_link_dynamic_widget_service");
    }
}
