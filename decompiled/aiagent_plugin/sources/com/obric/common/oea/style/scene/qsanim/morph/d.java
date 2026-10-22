package com.obric.common.oea.style.scene.qsanim.morph;

import android.view.View;
import d.h.b.h;

/* JADX INFO: compiled from: ViewMorphAnimHelperEx.kt */
/* JADX INFO: loaded from: classes4.dex */
public class d {
    private static final String TAG = "ViewMorphAnimHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32582a = null;
    private static int j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f32583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f32584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f32585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f32586e;
    private b f;
    private float g;
    private float h;
    private final View i;

    /* JADX INFO: compiled from: ViewMorphAnimHelperEx.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }
    }

    static {
        f32582a = new a(null);
    }

    public static final /* synthetic */ b a(d r0) {
        return r0.f;
    }

    public static final /* synthetic */ boolean b(d r0) {
        return r0.b();
    }

    public final View a() {
        return this.i;
    }

    private final boolean b() {
        float r0 = this.i.getWidth();
        float r1 = this.i.getHeight();
        if (r0 != 0.0f) goto L5;
    L8:
        com.obric.common.oea.foundation.b.c.a(com.obric.common.oea.foundation.b.c.f32472a, TAG, "updateViewSize: width or height is zero", null, 4, null);
        return false;
    L5:
        if (r1 == 0.0f) goto L8;
        this.f32583b = r0;
        this.f32584c = r1;
        this.f32585d = this.i.getY();
        this.f32586e = this.i.getX();
        com.obric.common.oea.style.scene.qsanim.common.d.f32567a.a();
        com.obric.common.oea.foundation.b.c.f32472a.c(TAG, "instance: " + j + ", updateViewSize, originalWidth: " + a(this, false, 1, null) + ", originalHeight: " + b(this, false, 1, null) + ", initialViewX: " + this.f32586e + ", initialViewY: " + this.f32585d);
        return true;
    }

    static /* synthetic */ float a(d r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = false;
    L7:
        return r0.a(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOriginalWidth");
    }

    private final float a(boolean r1) {
        if (r1 == false) goto L5;
        return this.f32583b + this.g;
    L5:
        return this.f32583b;
    }

    static /* synthetic */ float b(d r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = false;
    L7:
        return r0.b(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOriginalHeight");
    }

    private final float b(boolean r1) {
        if (r1 == false) goto L5;
        return this.f32584c + this.h;
    L5:
        return this.f32584c;
    }
}
