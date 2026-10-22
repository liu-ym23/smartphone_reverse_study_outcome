package com.obric.autogui.common.api.platform.display.capture;

import android.graphics.Bitmap;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.a.a;
import d.h.b.o;

/* JADX INFO: compiled from: BitmapScreenshot.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BitmapScreenshot implements IScreenshot {
    private final Bitmap bitmap;
    private final float scale;
    private final AOOperatingSpace.SpaceType spaceType;

    public BitmapScreenshot(Bitmap r2, float r3, AOOperatingSpace.SpaceType r4) {
        o.e(r2, "bitmap");
        o.e(r4, "spaceType");
        this.bitmap = r2;
        this.scale = r3;
        this.spaceType = r4;
    }

    @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
    public Bitmap getBitmap() {
        return this.bitmap;
    }

    @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
    public float getScale() {
        return this.scale;
    }

    @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
    public void release() {
        getBitmap().recycle();
    }

    @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
    public boolean isValid() {
        return !getBitmap().isRecycled();
    }

    @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
    public <T> Object withResourcesLocked(a<? extends T> r2, d<? super T> r3) {
        a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        return r1.invoke();
    }

    @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
    public AOOperatingSpace.SpaceType getSpaceType() {
        return this.spaceType;
    }
}
