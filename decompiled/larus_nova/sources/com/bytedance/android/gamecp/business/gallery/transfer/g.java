package com.bytedance.android.gamecp.business.gallery.transfer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.gamecp.business.gallery.view.image.TransferImage;
import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes44.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f53286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f53287b;

    public g(e r100) {
        this.f53286a = r100;
        this.f53287b = r100.getContext();
    }

    public final TransferImage a(ImageView r100) {
        TransferImage r101 = new TransferImage(this.f53287b);
        d r102 = this.f53286a.getTransConfig();
        if (r102 != null) goto L5;
        return r101;
    L5:
        int[] r103 = {0, 0};
        if (r102.f53258n == true) goto L9;
        if (r100 == null) goto L9;
        r103 = new int[2];
        r100.getLocationInWindow(r103);
    L9:
        r101.setScaleType(ImageView.ScaleType.FIT_CENTER);
        int r104 = 0;
        if (r102.f53258n == false) goto L16;
        int r105 = r103[0];
        int r106 = r103[1];
        int r107 = y0.h();     // Catch: Exception -> L14
    L15:
        r101.P0 = r105;
        r101.V0 = r106 - r107;
        r101.H0 = 0;
        r101.L0 = 0;
    L25:
        r101.setDuration(r102.f53248d);
        r101.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r101.setOnTransferListener(this.f53286a.getTransListener());
        return r101;
    L14:
        r107 = 0;
        goto L15
    L16:
        if (r100 == null) goto L20;
        int r108 = r103[0];
        int r109 = r103[1];
        r104 = y0.h();     // Catch: Exception -> L27
    L19:
        int r110 = r109 - r104;
        int r111 = r100.getWidth();
        int r112 = r100.getHeight();
        r101.P0 = r108;
        r101.V0 = r110;
        r101.H0 = r111;
        r101.L0 = r112;
        goto L25
    L20:
        int r113 = r103[0];
        int r114 = r103[1];
        int r115 = y0.h();     // Catch: Exception -> L23
    L24:
        r101.P0 = r113;
        r101.V0 = r114 - r115;
        r101.H0 = 0;
        r101.L0 = 0;
    L23:
        r115 = 0;
        goto L24
    }

    public final void b(String r100, TransferImage r101, boolean r102) {
        e r103 = this.f53286a;
        if (r103 == null) goto L7;
        d r104 = r103.getTransConfig();
        if (r104 == null) goto L7;
        vs.e r105 = r104.a();
    L8:
        if (r105 != null) goto L11;
        return;
    L11:
        if (((vs.d) r105).b(r100) == false) goto L22;
        d r106 = this.f53286a.getTransConfig();
        if (r106 == null) goto L30;
        Drawable r107 = ((vs.d) r106.a()).c(r100);
        if (r107 != null) goto L18;
        r101.setImageDrawable(r106.b());
    L19:
        if (r102 == false) goto L21;
        r101.f53345k0 = 100;
        r101.W = 1;
        r101.f53343g1 = true;
        r101.invalidate();
        return;
    L21:
        r101.f53345k0 = 100;
        r101.W = 2;
        r101.f53343g1 = true;
        r101.invalidate();
        return;
    L18:
        r101.setImageDrawable(r107);
        goto L19
    L30:
        return;
    L22:
        r101.setImageDrawable(y0.e(R.drawable.shape_bg_57000000_corner_2));
        if (r102 == false) goto L25;
        r101.f53345k0 = 100;
        r101.W = 1;
        r101.f53343g1 = true;
        r101.invalidate();
        return;
    L25:
        r101.f53345k0 = 100;
        r101.W = 2;
        r101.f53343g1 = true;
        r101.invalidate();
        return;
    L7:
        r105 = null;
        goto L8
    }
}
