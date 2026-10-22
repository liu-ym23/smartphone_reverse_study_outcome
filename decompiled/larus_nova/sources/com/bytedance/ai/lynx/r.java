package com.bytedance.ai.lynx;

import android.net.Uri;
import com.lynx.tasm.LynxError;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public interface r {
    void onDetachedFromWindow(g r100);

    void onFirstScreen(g r100);

    void onLoadUriSuccess(Uri r100, g r101);

    void onPageStart(g r100, String r101);

    void onPageUpdate(g r100);

    void onReceivedError(g r100, LynxError r101);

    void onRuntimeReady(g r100);

    void onTimingSetup(g r100, Map<String, Object> r101);

    void onTimingUpdate(g r100, Map<String, Object> r101, Map<String, Long> r102, String r103);
}
