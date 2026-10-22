package com.bytedance.android.live.liveinteract.interactivesong.panel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.ktvapi.model.mv.IMvPreviewViewHolder;
import com.bytedance.android.livesdk.ktvapi.model.mv.j;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements j<i> {
    public c() {
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.j
    public final IMvPreviewViewHolder<i> a(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        LayoutInflater r101 = LayoutInflater.from(r100.getContext());
        ViewParent r102 = null;
        if (r101 == null) goto L5;
        View r103 = r101.inflate(R.layout.ttlive_interactive_song_mv_list_preview, r100, false);
    L6:
        if (r103 == null) goto L8;
        ViewParent r104 = r103.getParent();
    L9:
        if (r104 == null) goto L17;
        ViewParent r105 = r103.getParent();
        if ((r105 instanceof ViewGroup) == false) goto L14;
        r102 = r105;
    L14:
        ViewGroup r106 = (ViewGroup) r102;
        if (r106 == null) goto L17;
        r106.removeView(r103);
    L17:
        r100.addView(r103, new FrameLayout.LayoutParams(-1, -1));
        return new InteractiveSongMvPreviewVH(r100);
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }
}
