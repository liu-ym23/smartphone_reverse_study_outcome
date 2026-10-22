package com.obric.autogui.platforms.tools.internal.b;

import android.graphics.Bitmap;
import com.obric.autogui.common.api.platform.display.capture.HeifScreenshotAttachment;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: DisplayScreenshot.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScreenshotResult.Status f30346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bitmap f30347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f30348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HeifScreenshotAttachment f30349d;

    public static /* synthetic */ a a(a r0, ScreenshotResult.Status r1, Bitmap r2, float r3, HeifScreenshotAttachment r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.f30346a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.f30347b;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.f30348c;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.f30349d;
    L15:
        return r0.a(r1, r2, r3, r4);
    }

    public final a a(ScreenshotResult.Status r1, Bitmap r2, float r3, HeifScreenshotAttachment r4) {
        o.e(r1, "status");
        return new a(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f30346a == r6.f30346a) goto L12;
        return false;
    L12:
        if (o.a(this.f30347b, r6.f30347b) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.f30348c, r6.f30348c) == 0) goto L18;
        return false;
    L18:
        if (o.a(this.f30349d, r6.f30349d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.f30346a.hashCode() * 31;
        Bitmap r1 = this.f30347b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + Float.hashCode(this.f30348c)) * 31;
        HeifScreenshotAttachment r5 = this.f30349d;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "DisplayScreenshot(status=" + this.f30346a + ", pic=" + this.f30347b + ", scale=" + this.f30348c + ", heifAttachment=" + this.f30349d + ')';
    }

    public a(ScreenshotResult.Status r2, Bitmap r3, float r4, HeifScreenshotAttachment r5) {
        o.e(r2, "status");
        this.f30346a = r2;
        this.f30347b = r3;
        this.f30348c = r4;
        this.f30349d = r5;
    }

    public /* synthetic */ a(ScreenshotResult.Status r2, Bitmap r3, float r4, HeifScreenshotAttachment r5, int r6, h r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 1.0f;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        this(r2, r3, r4, r5);
    }

    public final ScreenshotResult.Status a() {
        return this.f30346a;
    }

    public final Bitmap b() {
        return this.f30347b;
    }

    public final float c() {
        return this.f30348c;
    }

    public final HeifScreenshotAttachment d() {
        return this.f30349d;
    }
}
