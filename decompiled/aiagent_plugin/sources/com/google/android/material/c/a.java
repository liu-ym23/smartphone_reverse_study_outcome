package com.google.android.material.c;

import android.content.Context;
import android.graphics.Color;
import androidx.core.graphics.e;
import com.google.android.material.g.b;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ElevationOverlayProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f13280a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f13281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f13282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f13283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f13284e;
    private final float f;

    static {
        f13280a = (int) Math.round(5.1000000000000005d);
    }

    public a(Context r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        this(b.a(r12, ZeusTransformUtils.mapRes(R.attr.elevationOverlayEnabled, "attr", "elevationOverlayEnabled"), false), com.google.android.material.color.b.a(r12, ZeusTransformUtils.mapRes(R.attr.elevationOverlayColor, "attr", "elevationOverlayColor"), 0), com.google.android.material.color.b.a(r12, ZeusTransformUtils.mapRes(R.attr.elevationOverlayAccentColor, "attr", "elevationOverlayAccentColor"), 0), com.google.android.material.color.b.a(r12, ZeusTransformUtils.mapRes(R.attr.colorSurface, "attr", "colorSurface"), 0), ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getDisplayMetrics().density);
    }

    public a(boolean r1, int r2, int r3, int r4, float r5) {
        this.f13281b = r1;
        this.f13282c = r2;
        this.f13283d = r3;
        this.f13284e = r4;
        this.f = r5;
    }

    public int a(float r2) {
        return a(this.f13284e, r2);
    }

    public int a(int r2, float r3) {
        if (this.f13281b == true) goto L5;
    L8:
        return r2;
    L5:
        if (a(r2) == false) goto L8;
        return b(r2, r3);
    }

    public int b(int r3, float r4) {
        float r5 = b(r4);
        int r0 = Color.alpha(r3);
        int r6 = com.google.android.material.color.b.a(e.b(r3, 255), this.f13282c, r5);
        if (r5 <= 0.0f) goto L8;
        int r2 = this.f13283d;
        if (r2 == 0) goto L8;
        r6 = com.google.android.material.color.b.a(r6, e.b(r2, f13280a));
    L8:
        return e.b(r6, r0);
    }

    public float b(float r3) {
        float r2 = this.f;
        if (r2 > 0.0f) goto L5;
    L9:
        return 0.0f;
    L5:
        if (r3 <= 0.0f) goto L9;
        return Math.min(((((float) Math.log1p(r3 / r2)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public boolean a() {
        return this.f13281b;
    }

    private boolean a(int r2) {
        if (e.b(r2, 255) != this.f13284e) goto L5;
        return true;
    L5:
        return false;
    }
}
