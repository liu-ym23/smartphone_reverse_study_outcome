package com.bytedance.android.livesdk.revenue.service.hybrid;

import android.view.View;
import io.reactivex.disposables.Disposable;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public interface b extends Disposable {
    View c();

    String getContainerId();

    void load(String r100, Map<String, ? extends Object> r101);

    void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.f.b r101);

    void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.g<?, ?> r101);

    void sendJsEvent(String r100, Object r101);

    void updateData(Map<String, ? extends Object> r100);

    void updateGlobalProps(Map<String, ? extends Object> r100);

    void updateScreenMetrics(int r100, int r101);
}
