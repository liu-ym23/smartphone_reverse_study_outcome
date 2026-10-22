package com.obric.autogui.common.api.space.errtrack;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.a.b;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: ReportBlackScreenWorker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReportBlackScreenWorker {
    private static final int BLACK_THRESHOLD = 1;
    public static final Companion Companion = null;
    private static final String TAG = "ReportBlackScreenWorker";
    private final Bitmap scaledBitmap;

    /* JADX INFO: compiled from: ReportBlackScreenWorker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ x lambda$dD0IwxG8mFpqvaSszyLD2fIbxNc(long r0, Bitmap r2) {
        return run$lambda$0(r0, r2);
    }

    public ReportBlackScreenWorker(Bitmap r2) {
        o.e(r2, "scaledBitmap");
        this.scaledBitmap = r2;
    }

    public final Bitmap getScaledBitmap() {
        return this.scaledBitmap;
    }

    public final Object run(d<? super x> r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        final long r0 = System.currentTimeMillis();
        use(this.scaledBitmap, new $$Lambda$ReportBlackScreenWorker$dD0IwxG8mFpqvaSszyLD2fIbxNc(r0));
        return x.f38692a;
    }

    private static final x run$lambda$0(long r11, Bitmap r13) {
        o.e(r13, "scaledBitmap");
        int r0 = r13.getWidth() * r13.getHeight();
        int r1 = r13.getWidth();
        long r3 = 0;
        int r5 = 0;
    L3:
        if (r5 >= r1) goto L8;
        int r6 = r13.getHeight();
        int r7 = 0;
    L5:
        if (r7 >= r6) goto L7;
        int r8 = r13.getPixel(r5, r7);
        r3 = r3 + ((long) ((Color.red(r8) + Color.green(r8)) + Color.blue(r8)));
        r7 = r7 + 1;
        goto L5
    L7:
        r5 = r5 + 1;
        goto L3
    L8:
        float r14 = r3 / r0;
        if (r14 >= 1.0f) goto L11;
        AppErrorTracker.INSTANCE.reportEvent(4);
    L11:
        Loog.INSTANCE.d(TAG, "Average pixel value: " + r14 + ", Processing time: " + (System.currentTimeMillis() - r11) + "ms");
        return x.f38692a;
    }

    private final void use(Bitmap r2, b<? super Bitmap, x> r3) {
        ((b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin")).invoke(r2);     // Catch: Throwable -> L6
        r2.recycle();
        return;
    L6:
        th = move-exception;
        r2.recycle();
        throw th;
    }
}
