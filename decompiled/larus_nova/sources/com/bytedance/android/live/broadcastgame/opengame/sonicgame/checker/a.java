package com.bytedance.android.live.broadcastgame.opengame.sonicgame.checker;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f61052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f61053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f61054c;

    public final Rect b() {
        int[] r100 = new int[2];
        this.f61052a.getLocationInWindow(r100);
        int r101 = this.f61053b;
        if (r101 < 0) goto L5;
        int r102 = r100[0] + r101;
    L6:
        int r103 = this.f61054c;
        if (r103 < 0) goto L9;
        int r104 = r100[1] + r103;
    L10:
        int r105 = r100[0] + this.f61052a.getWidth();
        int r106 = r100[1] + this.f61052a.getHeight();
        if (r102 >= r105) goto L16;
        if (r104 < r106) goto L15;
        return null;
    L15:
        return new Rect(r102, r104, r105, r106);
    L16:
        return null;
    L9:
        r104 = r100[1];
        goto L10
    L5:
        r102 = r100[0];
        goto L6
    }

    public final Bitmap a() {
        int r100 = (this.f61052a.getWidth() - this.f61053b) / 10;
        int r101 = (this.f61052a.getHeight() - this.f61054c) / 10;
        if (r100 <= 0) goto L8;
        if (r101 > 0) goto L7;
        return null;
    L7:
        return Bitmap.createBitmap(r100, r101, Bitmap.Config.RGB_565);
    L8:
        return null;
    }

    public a(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f61052a = r100;
        this.f61053b = 0;
        this.f61054c = r101;
    }
}
