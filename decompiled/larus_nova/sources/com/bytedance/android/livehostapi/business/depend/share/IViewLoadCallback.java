package com.bytedance.android.livehostapi.business.depend.share;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/share/IViewLoadCallback;", "", "onLoadFail", "", "onLoadSuccess", "onOriginalPicLoadSuccess", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IViewLoadCallback {
    void onLoadFail();

    void onLoadSuccess();

    void onOriginalPicLoadSuccess(Bitmap r100);
}
