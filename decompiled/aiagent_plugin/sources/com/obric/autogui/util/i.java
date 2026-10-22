package com.obric.autogui.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.WindowManager;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.l.n;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: WhiteScreenUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {
    private static final String TAG = "WhiteScreenUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f31571a = null;

    static {
        f31571a = new i();
    }

    private final int a(int r8) {
        int r7 = (r8 >> 16) & 255;
        int r0 = (r8 >> 8) & 255;
        return (int) (((((double) r7) * 0.299d) + (((double) r0) * 0.587d)) + (((double) (r8 & 255)) * 0.114d));
    }

    private static final String d() {
        return "[checkEdgePurityByStrip] top edge not pure";
    }

    private static final String e() {
        return "[checkEdgePurityByStrip] bottom edge not pure";
    }

    private static final String f() {
        return "[checkEdgePurityByStrip] left edge not pure";
    }

    private static final String g() {
        return "[checkEdgePurityByStrip] right edge not pure";
    }

    private static final String h() {
        return "[checkEdgePurityByStrip] all edge areas are pure";
    }

    public static /* synthetic */ String lambda$5YFQWeH1WBjR6rDMdI32ZKysr5U() {
        return h();
    }

    public static /* synthetic */ String lambda$8kEszssgXUwipmIYbDNMrJPy9bY() {
        return e();
    }

    public static /* synthetic */ String lambda$EfN087q_0DF3Q2LVBoQwvl9VjWw(int r0, int r1, int r2, int r3, Map r4, float r5, float r6) {
        return a(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ String lambda$SGw5oT37ltels2ssDNt448kxfnM() {
        return f();
    }

    public static /* synthetic */ String lambda$pPN6G7rwNbV1JNsBhsFheyVEhj8() {
        return d();
    }

    public static /* synthetic */ String lambda$wSiO86HOhsqPFJ84uOY3aiQ4_uU() {
        return g();
    }

    private i() {
    }

    public final boolean a(Bitmap r5) {
        if (r5 != null) goto L11;
        Loog.INSTANCE.w(TAG, "isWhiteScreen: bitmap is null");
        return false;
    L11:
        return b(r5);
    L8:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "isWhiteScreen failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return false;
    }

    public final boolean b(Bitmap r2) {
        o.e(r2, "bitmap");
        Bitmap r0 = d(r2);
        boolean r1 = c(r0);     // Catch: Throwable -> L9
        if (r0 != r2) goto L6;
    L8:
        return r1;
    L6:
        if (r0.isRecycled() == true) goto L8;
        r0.recycle();
    L9:
        th = move-exception;
        if (r0 != r2) goto L12;
    L14:
        throw th;
    L12:
        if (r0.isRecycled() == true) goto L14;
        r0.recycle();
        goto L14
    }

    private final boolean c(Bitmap r13) {
        if (r13.getWidth() == 128) goto L5;
    L8:
        Bitmap r0 = Bitmap.createScaledBitmap(r13, 128, 128, false);
    L9:
        o.a(r0);
        int[] r11 = new int[16384];
        r0.getPixels(r11, 0, 128, 0, 0, 128, 128);     // Catch: Throwable -> L22
        if (o.a(r0, r13) == false) goto L14;
    L16:
        float r14 = a(r11, 128, 128);
        float r1 = com.obric.autogui.common.a.d.f28974a.O();
        Loog.INSTANCE.i(TAG, "[isWhiteScreen] edgeRatio=" + r14 + ", threshold=" + r1);
        if (r14 <= r1) goto L20;
        Loog.INSTANCE.i(TAG, "[isWhiteScreen] edge ratio too high, not white screen");
        return false;
    L20:
        boolean r12 = a(r11, 128, 128, com.obric.autogui.common.a.d.f28974a.P());
        Loog.INSTANCE.i(TAG, "[isWhiteScreen] isEdgeAreaPure=" + r12);
        return r12;
    L14:
        if (r0.isRecycled() == true) goto L16;
        r0.recycle();
    L22:
        th = move-exception;
        if (o.a(r0, r13) == false) goto L26;
    L28:
        throw th;
    L26:
        if (r0.isRecycled() == true) goto L28;
        r0.recycle();
        goto L28
    L5:
        if (r13.getHeight() != 128) goto L8;
        r0 = r13;
        goto L9
    }

    private final float a(int[] r20, int r21, int r22) {
        int r0 = (r21 - 2) * (r22 - 2);
        int[] r2 = {-1, 0, 1, -2, 0, 2, -1, 0, 1};
        int[] r1 = {-1, -2, -1, 0, 0, 0, 1, 2, 1};
        int r3 = 1;
        int r4 = r22 - 1;
        int r6 = 1;
        int r7 = 0;
    L3:
        if (r6 >= r4) goto L19;
        int r8 = r21 - 1;
        int r9 = r3;
    L5:
        if (r9 >= r8) goto L17;
        int r11 = -1;
        int r12 = 0;
        int r13 = 0;
    L8:
        if (r11 >= 2) goto L14;
        int r15 = -1;
    L10:
        if (r15 >= 2) goto L12;
        int r5 = a(r20[((r6 + r11) * r21) + (r9 + r15)]);
        r15 = r15 + 1;
        int r16 = ((r11 + 1) * 3) + r15;
        r12 = r12 + (r2[r16] * r5);
        r13 = r13 + (r5 * r1[r16]);
        goto L10
    L12:
        r11 = r11 + 1;
        goto L8
    L14:
        if (((r12 * r12) + (r13 * r13)) <= 1600) goto L16;
        r7 = r7 + 1;
    L16:
        r9 = r9 + 1;
        goto L5
    L17:
        r6 = r6 + 1;
        r3 = 1;
        goto L3
    L19:
        return r7 / r0;
    }

    private final boolean a(int[] r13, int r14, int r15, float r16) {
        int r8 = Math.max(r14 / 10, 5);
        int r9 = Math.max(r15 / 10, 5);
        if (a(r13, r14, 0, 0, r14, r9, r16) == true) goto L7;
        Loog.INSTANCE.dp(TAG, $$Lambda$i$pPN6G7rwNbV1JNsBhsFheyVEhj8.INSTANCE);
        return false;
    L7:
        if (a(r13, r14, 0, r15 - r9, r14, r15, r16) == true) goto L11;
        Loog.INSTANCE.dp(TAG, $$Lambda$i$8kEszssgXUwipmIYbDNMrJPy9bY.INSTANCE);
        return false;
    L11:
        if (a(r13, r14, 0, 0, r8, r15, r16) == true) goto L15;
        Loog.INSTANCE.dp(TAG, $$Lambda$i$SGw5oT37ltels2ssDNt448kxfnM.INSTANCE);
        return false;
    L15:
        if (a(r13, r14, r14 - r8, 0, r14, r15, r16) == true) goto L18;
        Loog.INSTANCE.dp(TAG, $$Lambda$i$wSiO86HOhsqPFJ84uOY3aiQ4_uU.INSTANCE);
        return false;
    L18:
        Loog.INSTANCE.dp(TAG, $$Lambda$i$5YFQWeH1WBjR6rDMdI32ZKysr5U.INSTANCE);
        return true;
    }

    private final boolean a(int[] r14, int r15, final int r16, final int r17, final int r18, final int r19, final float r20) {
        final Map r8 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        int r0 = r17;
    L4:
        if (r0 >= r19) goto L14;
        int r3 = r16;
    L6:
        if (r3 >= r18) goto L12;
        int r4 = r14[(r0 * r15) + r3];
        Integer r5 = Integer.valueOf(r4);
        Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(r8.get(Integer.valueOf(r4)), Integer.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L10;
        int r7 = r6.intValue();
    L11:
        r8.put(r5, Integer.valueOf(r7 + 1));
        r3 = r3 + 1;
        goto L6
    L10:
        r7 = 0;
        goto L11
    L12:
        r0 = r0 + 1;
        goto L4
    L14:
        if (r8.isEmpty() == false) goto L16;
        return false;
    L16:
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(p.v((Iterable) ZeusTransformUtils.preCheckCast(r8.values(), Iterable.class, "com.obric.aiagent.plugin")), Integer.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L19;
        int r2 = r1.intValue();
    L20:
        final float r9 = r2 / p.B((Iterable) ZeusTransformUtils.preCheckCast(r8.values(), Iterable.class, "com.obric.aiagent.plugin"));
        Loog.INSTANCE.dp(TAG, new $$Lambda$i$EfN087q_0DF3Q2LVBoQwvl9VjWw(r16, r17, r18, r19, r8, r9, r20));
        if (r9 < r20) goto L24;
        return true;
    L24:
        return false;
    L19:
        r2 = 0;
        goto L20
    }

    private static final String a(int r2, int r3, int r4, int r5, Map r6, float r7, float r8) {
        return "[isAreaPureColor] area: (" + r2 + ", " + r3 + ") to (" + r4 + ", " + r5 + "), colorCount=" + ((Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin")).size() + ", ratio=" + r7 + ", threshold=" + r8;
    }

    private final Bitmap d(Bitmap r12) {
        int r1 = r12.getHeight();     // Catch: Exception -> L15
        int r2 = r12.getWidth();     // Catch: Exception -> L15
        if (r1 <= 0) goto L14;
        if (r2 <= 0) goto L14;
        float r3 = a(a(), 0.05f);     // Catch: Exception -> L15
        float r11 = a(b(), 0.03f);     // Catch: Exception -> L15
        float r4 = r1;
        int r5 = n.c((int) Math.ceil(r3 * r4), 0);     // Catch: Exception -> L15
        int r13 = n.c((int) Math.ceil(r11 * r4), 0);     // Catch: Exception -> L15
        int r6 = (r1 - r5) - r13;
        if (r6 >= (r4 * 0.5f)) goto L12;
        Loog.INSTANCE.i(TAG, "[cropSystemBars] content too small after crop, skip: height=" + r1 + ", topCrop=" + r5 + ", bottomCrop=" + r13);     // Catch: Exception -> L15
        return r12;
    L12:
        Loog.INSTANCE.i(TAG, "[cropSystemBars] crop applied: height=" + r1 + ", topCrop=" + r5 + ", bottomCrop=" + r13 + ", contentHeight=" + r6);     // Catch: Exception -> L15
        Bitmap r14 = Bitmap.createBitmap(r12, 0, r5, r2, r6);     // Catch: Exception -> L15
        o.a(r14);     // Catch: Exception -> L15
        return r14;
    L14:
        return r12;
    L15:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "[cropSystemBars] failed, fallback to origin", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return r12;
    }

    private final float a(int r1, float r2) {
        int r0 = c();
        if (r1 <= 0) goto L7;
        if (r0 <= 0) goto L7;
        r2 = r1 / r0;
    L7:
        return n.a(r2, 0.0f, 0.15f);
    }

    private final int a() {
        return a("status_bar_height");
    }

    private final int b() {
        return a("navigation_bar_height");
    }

    private final int a(String r6) {
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContextOrNull(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        if (r1 == null) goto L7;
        Resources r2 = ZeusTransformUtils.getResources(r1, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        if (r2 == null) goto L7;
    L8:
        int r3 = ZeusTransformUtils.getIdentifier(r2, r6, "dimen", "android", "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        if (r3 <= 0) goto L17;
        return r2.getDimensionPixelSize(r3);
    L17:
        return 0;
    L7:
        r2 = Resources.getSystem();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "[systemDimenPx] read " + r6 + " failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return 0;
    }

    private final int c() {
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContextOrNull(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L14
        if (r1 != null) goto L6;
        return 0;
    L6:
        Object r2 = r1.getSystemService("window");     // Catch: Exception -> L14
        if (ZeusTransformUtils.instanceOf(r2, WindowManager.class) == false) goto L9;
        WindowManager r3 = (WindowManager) ZeusTransformUtils.preCheckCast(r2, WindowManager.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L14
    L10:
        if (r3 != null) goto L12;
        return 0;
    L12:
        return r3.getCurrentWindowMetrics().getBounds().height();
    L9:
        r3 = null;
    L14:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "[realScreenHeightPx] failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return 0;
    }
}
