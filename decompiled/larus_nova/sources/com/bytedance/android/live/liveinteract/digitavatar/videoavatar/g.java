package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.utils.e0;
import com.bytedance.android.livesdk.utils.u1;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements IHostFrescoHelper.GetBitmapCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoDigitAvatarRecognitionDialog f72722a;

    public g(VideoDigitAvatarRecognitionDialog r100) {
        this.f72722a = r100;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void fail(IHostFrescoHelper.BitmapDataSource r100) {
        if (r100 == null) goto L4;
        Throwable r101 = r100.error;
    L5:
        if (r101 == null) goto L8;
        ALogger.e("KtvDigitAvatar", "生成头像高斯模糊失败", r100.error);
        return;
    L8:
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void onNewResultImpl(Bitmap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.bytedance.android.live.pushstream.d r101 = this.f72722a.N;
        if (r101 == null) goto L28;
        d0 r102 = r101.getLiveCore();
        if (r102 == null) goto L29;
        int r103 = u1.f159175a;
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        int r104 = r100.getWidth();
        int r105 = r100.getHeight();
        if (r104 < 100) goto L18;
        if (r105 < 100) goto L18;
        if (r104 < 200) goto L17;
        if (r105 < 200) goto L17;
        float r106 = 0.1f;
    L19:
        int r107 = Math.round(r104 * r106);
        int r108 = Math.round(r105 * r106);
        Bitmap r109 = Bitmap.createScaledBitmap(r100, r107, r108, false);
        float r110 = r107;
        float r111 = r108;
        if (Math.abs((r110 / r111) - 5) <= 0.2f) goto L26;
        int r112 = (int) (r110 / 3.0f);
        if (r112 <= r108) goto L24;
        int r113 = (int) (r111 * 3.0f);
        int r114 = r108;
    L25:
        Bitmap r115 = Bitmap.createBitmap(r109, (r107 - r113) >> 1, (r108 - r114) >> 1, r113, r114);
        r109.recycle();
        r109 = r115;
        r107 = r113;
        r108 = r114;
        goto L26
    L24:
        r114 = r112;
        r113 = r107;
    L26:
        e0.a(r109, Bitmap.createBitmap(r107, r108, Bitmap.Config.ARGB_8888), 5);
        r109.recycle();
        r102.M();
        return;
    L17:
        r106 = 0.3f;
    L18:
        r106 = 0.6f;
        goto L19
    L29:
        return;
    }
}
