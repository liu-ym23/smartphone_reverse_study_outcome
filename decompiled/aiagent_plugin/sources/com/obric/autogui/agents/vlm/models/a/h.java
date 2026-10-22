package com.obric.autogui.agents.vlm.models.a;

import android.graphics.Bitmap;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SoftwareScreenshot.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements IScreenshot {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap f27274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f27275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AOOperatingSpace.SpaceType f27276c;

    @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
    public boolean isValid() {
        return true;
    }

    public h(IScreenshot r3, boolean r4) {
        IScreenshot r5 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r3, IScreenshot.class, "com.obric.aiagent.plugin");
        o.e(r5, "another");
        if (r4 == false) goto L5;
        Bitmap r6 = r5.getBitmap().copy(Bitmap.Config.ARGB_8888, true);
        o.a(r6);
    L6:
        this.f27274a = r6;
        this.f27275b = r5.getScale();
        this.f27276c = r5.getSpaceType();
        return;
    L5:
        r6 = r5.getBitmap();
        goto L6
    }

    public /* synthetic */ h(IScreenshot r2, boolean r3, int r4, d.h.b.h r5) {
        IScreenshot r6 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r2, IScreenshot.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = true;
    L5:
        this(r6, r3);
    }

    @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
    public Bitmap getBitmap() {
        return this.f27274a;
    }

    @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
    public float getScale() {
        return this.f27275b;
    }

    @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
    public void release() {
        getBitmap().recycle();
    }

    @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
    public <T> Object withResourcesLocked(d.h.a.a<? extends T> r2, d.c.d<? super T> r3) {
        d.h.a.a r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return r1.invoke();
    }

    @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
    public AOOperatingSpace.SpaceType getSpaceType() {
        return this.f27276c;
    }
}
