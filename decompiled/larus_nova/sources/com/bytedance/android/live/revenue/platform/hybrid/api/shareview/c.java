package com.bytedance.android.live.revenue.platform.hybrid.api.shareview;

import android.content.Context;
import com.lynx.tasm.LynxView;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public interface c {
    void a(String r100, Map<String, ? extends Object> r101);

    void b();

    Context getContext();

    LynxView getLynxView();

    boolean isValid();

    void release();
}
