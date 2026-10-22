package com.bytedance.android.livesdk.interactivity.zdanmaku.units;

import android.graphics.drawable.Drawable;
import com.facebook.drawee.generic.RootDrawable;
import q72.g;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> extends com.bytedance.live.zdanmaku.render.canvas.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RootDrawable f141810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final T f141811e;

    @Override // com.bytedance.live.artist.render.e
    public final void d() {
        T r100 = this.f141811e;
        if ((r100 instanceof q72.c) == true) goto L5;
        r100 = (T) null;
    L5:
        q72.c r101 = r100;
        if (r101 == null) goto L9;
        r101.f531931d = null;
        return;
    }

    @Override // com.bytedance.live.artist.render.e
    public final void e() {
        T r100 = this.f141811e;
        boolean r101 = r100 instanceof q72.c;
        if (r101 == true) goto L5;
        q72.c r102 = null;
    L6:
        q72.c r103 = r102;
        if (r103 == null) goto L9;
        Drawable r104 = r103.f531931d;
    L11:
        if ((r104 instanceof RootDrawable) == true) goto L13;
        r104 = null;
    L13:
        RootDrawable r105 = (RootDrawable) r104;
        this.f141810d = r105;
        if (r101 == true) goto L16;
        q72.c r106 = null;
    L17:
        q72.c r107 = r106;
        if (r107 == null) goto L22;
        g r108 = r107.f531932e;
        if (r108 == null) goto L22;
        int r109 = r108.f531954a;
    L23:
        if (r101 == true) goto L25;
        r100 = (T) null;
    L25:
        q72.c r110 = r100;
        if (r110 == null) goto L30;
        g r111 = r110.f531932e;
        if (r111 == null) goto L30;
        int r112 = r111.f531955b;
    L31:
        if (r105 == null) goto L33;
        r105.setBounds(0, 0, r109, r112);
    L33:
        com.bytedance.live.artist.render.f r113 = c().f254828c;
        r113.f254852a = r109;
        r113.f254853b = r112;
        return;
    L30:
        r112 = 0;
    L22:
        r109 = 0;
        goto L23
    L16:
        r106 = r100;
        goto L17
    L9:
        r104 = null;
        goto L11
    L5:
        r102 = r100;
        goto L6
    }

    public b(T r100) {
        this.f141811e = r100;
    }
}
