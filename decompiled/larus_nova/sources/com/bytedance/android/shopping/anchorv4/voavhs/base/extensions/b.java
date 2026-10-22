package com.bytedance.android.shopping.anchorv4.voavhs.base.extensions;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Radius f167885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f167886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f167887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f167888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f167889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f167890f;

    public final class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Radius f167891a;

        public a(Radius r100) {
            Intrinsics.checkNotNullParameter(r100, "radius");
            this.f167891a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "outline");
            r101.setRoundRect(new Rect(0, 0, r100.getWidth(), r100.getHeight()), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(this.f167891a.getTopLeft())));
        }
    }

    public b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f167890f = r100;
        this.f167886b = new Path();
        this.f167887c = new RectF();
        this.f167888d = new float[8];
    }

    public static boolean a(Radius r100) {
        if (r100.getTopLeft() != r100.getTopRight()) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L13;
        return false;
    L13:
        if (r100.getTopLeft() != r100.getBottomRight()) goto L17;
        return true;
    L17:
        return false;
    L8:
        if (r100.getTopLeft() != r100.getBottomLeft()) goto L10;
        r102 = true;
        goto L11
    L5:
        r101 = false;
        goto L6
    }

    public static boolean b(Radius r100) {
        if (r100.getTopLeft() <= 0) goto L5;
    L12:
        return true;
    L5:
        if (r100.getTopRight() > 0) goto L12;
        if (r100.getBottomLeft() > 0) goto L12;
        if (r100.getBottomRight() > 0) goto L12;
        return false;
    }

    public final void d(Canvas r100) {
        if (this.f167889e == false) goto L8;
        if (r100 == null) goto L6;
        r100.restore();
    L6:
        this.f167889e = false;
        return;
    }

    public final void e(Canvas r100) {
        Radius r101 = this.f167885a;
        if (r101 != null) goto L5;
        return;
    L5:
        if ((!a(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 != null) goto L10;
        return;
    L10:
        if (b(r101) == false) goto L19;
        if (r100 == null) goto L13;
        r100.save();
    L13:
        this.f167889e = true;
        if (r100 == null) goto L20;
        r100.clipPath(this.f167886b);
        return;
    L20:
        return;
    }

    public final void f(Radius r100) {
        this.f167885a = r100;
        if (r100 != null) goto L5;
    L15:
        this.f167890f.setClipToOutline(false);
    L16:
        this.f167890f.invalidate();
        return;
    L5:
        if (b(r100) == true) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == true) goto L13;
        r100 = null;
    L13:
        if (r100 == null) goto L15;
        this.f167890f.setClipToOutline(true);
        this.f167890f.setOutlineProvider(new a(r100));
        goto L16
    L7:
        if (a(r100) == false) goto L9;
        r101 = true;
        goto L10
    }

    public final void c(int r100, int r101) {
        Radius r102 = this.f167885a;
        if (r102 == null) goto L8;
        this.f167886b.reset();
        if (b(r102) == false) goto L9;
        this.f167887c.set(0.0f, 0.0f, r100, r101);
        this.f167888d[0] = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r102.getTopLeft()));
        this.f167888d[1] = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r102.getTopLeft()));
        this.f167888d[2] = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r102.getTopRight()));
        this.f167888d[3] = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r102.getTopRight()));
        this.f167888d[4] = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r102.getBottomRight()));
        this.f167888d[5] = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r102.getBottomRight()));
        this.f167888d[6] = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r102.getBottomLeft()));
        this.f167888d[7] = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r102.getBottomLeft()));
        this.f167886b.addRoundRect(this.f167887c, this.f167888d, Path.Direction.CW);
        return;
    L9:
        return;
    }
}
