package com.android.ttcjpaysdk.base.imageloader;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.network.CJPayNetworkManager;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/imageloader/NetCache;", "", "()V", "getBitmap", "", "url", "", "onNetworkListener", "Lcom/android/ttcjpaysdk/base/imageloader/NetCache$OnNetworkListener;", "OnNetworkListener", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetCache {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/imageloader/NetCache$OnNetworkListener;", "", "onResult", "", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnNetworkListener {
        void onResult(Bitmap r100);
    }

    public NetCache() {
    }

    public final void getBitmap(String r100, final OnNetworkListener r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        CJPayNetworkManager.downloadFile(r100, new AnonymousClass1(r101), true);
    }
}
