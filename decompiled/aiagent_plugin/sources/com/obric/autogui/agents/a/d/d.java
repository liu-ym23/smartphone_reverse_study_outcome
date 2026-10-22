package com.obric.autogui.agents.a.d;

import android.graphics.Bitmap;
import com.obric.autogui.common.api.AOImageUtil;
import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: ActionEffectImageFingerprint.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f26364a = null;

    static {
        f26364a = new d();
    }

    private d() {
    }

    public final c a(Bitmap r15) {
        if (r15 != null) goto L5;
    L25:
        return null;
    L5:
        if (r15.isRecycled() == true) goto L25;
        if (r15.getWidth() <= 0) goto L25;
        if (r15.getHeight() <= 0) goto L25;
        Long r0 = AOImageUtil.INSTANCE.calculateDHash(r15);
        if (r0 == null) goto L25;
        long r2 = r0.longValue();
        int r14 = Math.min(128, r15.getWidth());
        int r1 = n.a((int) (((((long) r15.getHeight()) * ((long) r14)) + (((long) r15.getWidth()) / 2)) / ((long) r15.getWidth())), 1, 512);
        Bitmap r12 = Bitmap.createScaledBitmap(r15, r14, r1, true);
        o.c(r12, "createScaledBitmap(...)");
        int r3 = r14 * r1;
        int[] r13 = new int[r3];     // Catch: Throwable -> L21
        r12.getPixels(r13, 0, r14, 0, 0, r14, r1);     // Catch: Throwable -> L21
        byte[] r6 = new byte[r3];     // Catch: Throwable -> L21
        int r4 = 0;
        int r5 = 0;
    L15:
        if (r4 >= r3) goto L17;
        int r7 = r13[r4];     // Catch: Throwable -> L21
        r6[r5] = (byte) ((((((r7 >> 16) & 255) * 299) + (((r7 >> 8) & 255) * 587)) + ((r7 & 255) * 114)) / 1000);     // Catch: Throwable -> L21
        r4 = r4 + 1;     // Catch: Throwable -> L21
        r5 = r5 + 1;     // Catch: Throwable -> L21
        goto L15
    L17:
        c r8 = new c(r2, r14, r1, r6);     // Catch: Throwable -> L21
        if (r12 == r15) goto L20;
        r12.recycle();
    L20:
        return r8;
    L21:
        th = move-exception;
        if (r12 == r15) goto L24;
        r12.recycle();
    L24:
        throw th;
    }
}
