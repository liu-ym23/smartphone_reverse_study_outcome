package com.obric.oui.common.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: SmoothCornerH.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class l {
    private static final String TAG = "SmoothCornerH";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f34562a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f34563b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.obric.common.oea.foundation.a.a.a f34564c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final com.obric.common.oea.foundation.a.a.a f34565d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final com.obric.common.oea.foundation.a.a.a f34566e = null;
    private static final com.obric.common.oea.foundation.a.a.a f = null;
    private static boolean g;

    private l() {
    }

    static {
        f34562a = new l();
        f34564c = new com.obric.common.oea.foundation.a.a.a();
        com.obric.common.oea.foundation.a.a.a r0 = new com.obric.common.oea.foundation.a.a.a();
        r0.a(com.obric.common.oea.foundation.a.a.a.C0878a.EnumC0879a.f32260d);
        f34565d = r0;
        com.obric.common.oea.foundation.a.a.a r1 = new com.obric.common.oea.foundation.a.a.a();
        r1.a(com.obric.common.oea.foundation.a.a.a.C0878a.EnumC0879a.f32258b);
        f34566e = r1;
        com.obric.common.oea.foundation.a.a.a r2 = new com.obric.common.oea.foundation.a.a.a();
        r2.a(com.obric.common.oea.foundation.a.a.a.C0878a.EnumC0879a.f32261e);
        f = r2;
        f34563b = !TextUtils.equals((CharSequence) ZeusTransformUtils.preCheckCast("HUAWEI", CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(Build.BRAND, CharSequence.class, "com.obric.aiagent.plugin"));
        g = true;
    }

    public static final void a(Canvas r2, RectF r3, float r4, Paint r5) {
        o.e(r2, "canvas");
        o.e(r3, "rectF");
        o.e(r5, "paint");
        l r0 = f34562a;
        float r6 = r0.a(r4, r3);
        r0.a(r6, r0.a(r3)).a(r2, r3, r6, r5);
    }

    public static final void a(Canvas r9, float r10, float r11, float r12, float r13, float r14, Paint r15) {
        o.e(r9, "canvas");
        o.e(r15, "paint");
        l r0 = f34562a;
        float r8 = r0.b(r14, r10, r11, r12, r13);
        r0.a(r8, r0.a(r10, r11, r12, r13)).a(r9, r15, r10, r11, r12, r13, r8);
    }

    public final void a(Path r2, RectF r3, float[] r4, Path.Direction r5) {
        o.e(r2, DownloadConstants.PATH_KEY);
        o.e(r3, "rect");
        o.e(r4, "radii");
        o.e(r5, "dir");
        if (m.a(r4) == false) goto L5;
        r2.addPath(a(r3, r4[0]));
        return;
    L5:
        r2.addRoundRect(r3, r4, r5);
    }

    public final void a(Path r2, RectF r3, float r4) {
        o.e(r2, DownloadConstants.PATH_KEY);
        o.e(r3, "rect");
        r2.addPath(a(r3, r4));
    }

    public final Path a(float r8, float r9, float r10, float r11, float r12) {
        float r6 = b(r12, r8, r9, r10, r11);
        return a(r6, a(r8, r9, r10, r11)).a(r8, r9, r10, r11, r6);
    }

    public final Path a(RectF r2, float r3) {
        o.e(r2, "rect");
        float r4 = a(r3, r2);
        com.obric.common.oea.foundation.a.a.a r1 = a(r4, a(r2));
        Rect r0 = new Rect();
        r2.roundOut(r0);
        return r1.a(r0, r4);
    }

    private final float a(float r3, RectF r4) {
        if (r4.isEmpty() == false) goto L7;
        com.obric.oui.d.a.b.e(TAG, "decideValidCornerRadius: rectF is empty");
        return 0.0f;
    L7:
        return n.a(Math.min(r3, a(r4) / 2.0f), 0.0f);
    }

    private final float b(float r1, float r2, float r3, float r4, float r5) {
        return n.a(Math.min(r1, a(r2, r3, r4, r5) / 2.0f), 0.0f);
    }

    private final com.obric.common.oea.foundation.a.a.a a(float r2, float r3) {
        if (g == true) goto L5;
        com.obric.common.oea.foundation.a.a.a r1 = f34564c;
        if (r1.a(r2, r3) == true) goto L14;
        com.obric.common.oea.foundation.a.a.a r4 = f34566e;
        if (r4.a(r2, r3) == false) goto L13;
        return r4;
    L13:
        return f;
    L14:
        return r1;
    L5:
        return f34565d;
    }

    private final float a(float r1, float r2, float r3, float r4) {
        return Math.min(Math.abs(r3 - r1), Math.abs(r4 - r2));
    }

    private final float a(RectF r1) {
        return Math.min(r1.width(), r1.height());
    }
}
