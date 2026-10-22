package com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab;

import android.view.View;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonSongListItemViewHolder f69718a;

    public b(CommonSongListItemViewHolder r100) {
        this.f69718a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        MusicPanel r101 = this.f69718a.f69672i;
        if (r101 == null) goto L13;
        KtvMusic r102 = r101.f153577a;
        if (r102 == null) goto L13;
        if (r102.isFavorite() != true) goto L13;
        CommonSongListItemViewHolder r103 = this.f69718a;
        MusicPanel r104 = r103.f69672i;
        if (r104 == null) goto L19;
        d r105 = r103.f69674k;
        if (r105 == null) goto L20;
        r105.d(r104, r103.f69673j);
        return;
    L20:
        return;
    L19:
        return;
    L13:
        CommonSongListItemViewHolder r106 = this.f69718a;
        MusicPanel r107 = r106.f69672i;
        if (r107 == null) goto L22;
        d r108 = r106.f69674k;
        if (r108 == null) goto L23;
        r108.f(r107, r106.f69673j);
        return;
    L23:
        return;
    }
}
