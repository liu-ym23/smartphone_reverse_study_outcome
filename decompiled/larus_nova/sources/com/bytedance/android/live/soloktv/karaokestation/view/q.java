package com.bytedance.android.live.soloktv.karaokestation.view;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.ordersong.view.KtvMusicTagsView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SoloKtvSongListItemViewHolder f101351a;

    public q(SoloKtvSongListItemViewHolder r100) {
        this.f101351a = r100;
    }

    public final void a() {
        SoloKtvSongListItemViewHolder r100 = this.f101351a;
        int r101 = SoloKtvSongListItemViewHolder.f101301y;
        ConstraintLayout r102 = (ConstraintLayout) r100.f101312k.getValue();
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.getWidth();
    L6:
        int r105 = r104 - s1.f(16.0f);
        HSImageView r106 = (HSImageView) this.f101351a.f101304c.getValue();
        if (r106 == null) goto L9;
        int r107 = r106.getWidth();
    L10:
        int r108 = r105 - r107;
        if (r108 > 0) goto L13;
        return;
    L13:
        TextView r109 = (TextView) this.f101351a.f101306e.getValue();
        if (r109 == null) goto L26;
        LinearLayout r110 = this.f101351a.V3();
        if (r110 != null) goto L18;
    L24:
        int r111 = r108;
    L25:
        r109.setMaxWidth(r111);
        goto L26
    L18:
        if (r110.getVisibility() != 0) goto L24;
        LinearLayout r112 = this.f101351a.V3();
        if (r112 == null) goto L22;
        int r113 = r112.getWidth();
    L23:
        r111 = r108 - r113;
        goto L25
    L22:
        r113 = 0;
    L26:
        TextView r114 = (TextView) this.f101351a.f101309h.getValue();
        if (r114 == null) goto L38;
        KtvMusicTagsView r115 = this.f101351a.W3();
        if (r115 != null) goto L31;
    L36:
        r114.setMaxWidth(r108);
        return;
    L31:
        if (r115.getVisibility() != 0) goto L36;
        KtvMusicTagsView r116 = this.f101351a.W3();
        if (r116 == null) goto L35;
        r103 = r116.getWidth();
    L35:
        r108 = r108 - r103;
        goto L36
    L38:
        return;
    L9:
        r107 = s1.f(60.0f);
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
