package com.bytedance.android.livehostapi.platform.depend.im;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/platform/depend/im/ILiveIMDynamicView;", "", "getView", "Landroid/view/View;", "load", "", "url", "", "fallbackUrl", "onPause", "onResume", "release", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveIMDynamicView {
    View getView();

    void load(String r100, String r101);

    void onPause();

    void onResume();

    void release();
}
