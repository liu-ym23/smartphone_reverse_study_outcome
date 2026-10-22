package com.zyql.screenperception.sdk;

import android.net.Uri;
import android.util.Log;
import com.zyql.screenperception.api.IImageCaptureCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/zyql/screenperception/sdk/ScreenShotApi$captureFullScreen$callback$1", "Lcom/zyql/screenperception/api/IImageCaptureCallback$Stub;", "Landroid/net/Uri;", "imageUri", "LC7/r;", "onSuccess", "(Landroid/net/Uri;)V", "", "errorCode", "", "errorMsg", "onError", "(ILjava/lang/String;)V", "sdk_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ScreenShotApi$captureFullScreen$callback$1 extends IImageCaptureCallback.Stub {
    @Override // com.zyql.screenperception.api.IImageCaptureCallback
    public void onError(int errorCode, String errorMsg) {
        Log.d("ScreenCapture", androidx.constraintlayout.core.dsl.a.d(errorCode, "截图失败: ", errorMsg, " (错误码: ", ")"));
    }

    @Override // com.zyql.screenperception.api.IImageCaptureCallback
    public void onSuccess(Uri imageUri) {
        if (imageUri == null) {
            Log.d("ScreenCapture", "截图失败：返回URI为空");
            return;
        }
        Log.d("ScreenCapture", "截图成功: " + imageUri);
    }
}
