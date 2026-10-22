package com.bytedance.android.gamecp.base.core.service.depend;

import android.content.Context;
import android.view.View;
import com.lynx.react.bridge.JavaOnlyMap;
import java.util.HashMap;

/* JADX INFO: loaded from: classes44.dex */
public interface g {

    public interface a {
        void a(int r100, JavaOnlyMap r101);
    }

    public interface b {
        void onEvent(HashMap<String, Object> r100);
    }

    void a(HashMap<String, Object> r100, a r101);

    void b(b r100);

    void c(HashMap<String, Object> r100);

    View createView(Context r100, Object r101);

    void d(HashMap<String, Object> r100, a r101);

    void destroy();

    void setDownloadInfo(HashMap<String, Object> r100);

    void setDownloadText(HashMap<String, Object> r100);

    void setDownloadUIStyle(HashMap<String, Object> r100);

    void useCacheData(HashMap<String, Object> r100);
}
