package com.obric.autogui.agents.vlm.models.omni.intent;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ScreenshotResultUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f28416a = null;

    static {
        f28416a = new h();
    }

    private h() {
    }

    public final Bitmap a(ScreenshotResult r3, Context r4) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "<this>");
        o.e(r2, "context");
        if (r3.getStatus() != ScreenshotResult.Status.ContainsSecure) goto L5;
        BitmapFactory.Options r5 = new BitmapFactory.Options();
        r5.inScaled = false;
        return BitmapFactory.decodeResource(ZeusTransformUtils.getResources(r2, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.raw.vlm_pred_secure_screenshot_placeholder_img_lores, "raw", "vlm_pred_secure_screenshot_placeholder_img_lores"), r5);
    L5:
        IScreenshot r6 = r3.getPic();
        if (r6 != null) goto L11;
        return null;
    L11:
        return r6.getBitmap();
    }
}
