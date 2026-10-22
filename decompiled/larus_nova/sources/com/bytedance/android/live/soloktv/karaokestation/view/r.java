package com.bytedance.android.live.soloktv.karaokestation.view;

import android.view.View;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;

/* JADX INFO: loaded from: classes7.dex */
public final class r implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SoloKtvSongListItemViewHolder f101352a;

    public r(SoloKtvSongListItemViewHolder r100) {
        this.f101352a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        MusicPanel r101 = this.f101352a.f101302a;
        if (r101 == null) goto L11;
        KtvMusic r102 = r101.f153577a;
        if (r102 == null) goto L11;
        if (r102.isFavorite() != true) goto L11;
        SoloKtvSongListItemViewHolder r103 = this.f101352a;
        MusicPanel r104 = r103.f101302a;
        if (r104 == null) goto L15;
        r103.f101325x.f(r104, r103.f101324w);
        return;
    L15:
        return;
    L11:
        SoloKtvSongListItemViewHolder r105 = this.f101352a;
        MusicPanel r106 = r105.f101302a;
        if (r106 == null) goto L17;
        r105.f101325x.e(r106, r105.f101324w);
        return;
    }
}
