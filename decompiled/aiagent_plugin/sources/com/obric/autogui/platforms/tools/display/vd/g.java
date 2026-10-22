package com.obric.autogui.platforms.tools.display.vd;

import android.graphics.Bitmap;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.vd.VDSpaceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: VDScreenshot.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements IScreenshot {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap f30208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f30209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.platforms.tools.display.vd.a f30210c;

    /* JADX INFO: compiled from: VDScreenshot.kt */
    @d.c.b.a.f(b = "VDScreenshot.kt", c = {51}, d = "withResourcesLocked", e = "com.obric.autogui.platforms.tools.display.vd.VDScreenshot")
    static final class a<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f30212b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f30213c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f30214d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f30215e;

        a(g r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30214d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30213c = r3;
            this.f30215e |= Integer.MIN_VALUE;
            return this.f30214d.withResourcesLocked(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public g(Bitmap r2, float r3, com.obric.autogui.platforms.tools.display.vd.a r4) {
        o.e(r2, "bitmap");
        o.e(r4, "boundVD");
        this.f30208a = r2;
        this.f30209b = r3;
        this.f30210c = r4;
    }

    @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
    public Bitmap getBitmap() {
        return this.f30208a;
    }

    @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
    public float getScale() {
        return this.f30209b;
    }

    @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
    public void release() {
        getBitmap().recycle();
    }

    @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
    public boolean isValid() {
        if (this.f30210c.isDestroyed() == false) goto L5;
    L7:
        return false;
    L5:
        if (getBitmap().isRecycled() == true) goto L7;
        return true;
    }

    @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
    public <T> Object withResourcesLocked(d.h.a.a<? extends T> r6, d.c.d<? super T> r7) {
        d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
        if ((r0.f30215e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f30215e -= Integer.MIN_VALUE;
    L8:
        Object r5 = r0.f30213c;
        Object r10 = d.c.a.b.a();
        int r2 = r0.f30215e;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        kotlinx.coroutines.f.a r11 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f30212b, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r12 = (d.h.a.a) ZeusTransformUtils.preCheckCast(r0.f30211a, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        kotlinx.coroutines.f.a r13 = r11;
        r8 = r12;
    L23:
        Object r14 = r8.invoke();     // Catch: Throwable -> L20
        r13.b(null);
        return r14;
    L20:
        th = move-exception;
        r13.b(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r5);
        r13 = VDSpaceManager.INSTANCE.getVDLock();
        r0.f30211a = r8;
        r0.f30212b = r13;
        r0.f30215e = 1;
        if (r13.a(null, r0) != r10) goto L23;
        return r10;
    L7:
        r0 = new a(this, r9);
        goto L8
    }

    @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
    public AOOperatingSpace.SpaceType getSpaceType() {
        return AOOperatingSpace.SpaceType.VirtualDisplay;
    }
}
