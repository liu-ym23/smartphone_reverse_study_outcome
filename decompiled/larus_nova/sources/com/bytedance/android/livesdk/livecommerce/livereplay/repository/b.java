package com.bytedance.android.livesdk.livecommerce.livereplay.repository;

import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public interface b {
    void onInvalidated();

    void setNetworkState(NetState r100);

    void setPageTimestamp(List<Long> r100);

    void setTotalCount(int r100);
}
