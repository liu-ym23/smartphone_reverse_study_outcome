package com.bytedance.android.live.saas;

import android.content.Context;
import com.bytedance.android.live.saas.middleware.applog.IAppLog;

/* JADX INFO: loaded from: classes47.dex */
public interface IAppLogExtend extends IAppLog {
    void ObserveOaidChanged(OaidChangedCallback r100);

    String getOaid(Context r100);
}
