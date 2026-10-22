package com.bytedance.android.live.soloktv.karaokestation;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.soloktv.karaokestation.model.AddSongSourceType;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends nb0.a {
    @Override // nb0.b
    public final int g() {
        return 6;
    }

    @Override // nb0.b
    public final String getRequiredSongInfo() {
        return "";
    }

    public a() {
    }

    @Override // nb0.b
    public final void addFavorite(MusicPanel r100, ic0.a r101) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
        Intrinsics.checkNotNullParameter(r101, "favoriteCallback");
        SoloKtvOrderSongDataContext.Companion.getClass();
        com.bytedance.android.live.soloktv.karaokestation.viewmodel.a r102 = SoloKtvOrderSongDataContext.Companion.a();
        if (r102 == null) goto L6;
        r102.addFavorite(r100, r101);
        return;
    }

    @Override // nb0.b
    public final void delFavorite(MusicPanel r100, ic0.a r101) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
        Intrinsics.checkNotNullParameter(r101, "favoriteCallback");
        SoloKtvOrderSongDataContext.Companion.getClass();
        com.bytedance.android.live.soloktv.karaokestation.viewmodel.a r102 = SoloKtvOrderSongDataContext.Companion.a();
        if (r102 == null) goto L6;
        r102.delFavorite(r100, r101);
        return;
    }

    @Override // nb0.b
    public final void addSong(Context r100, MusicPanel r101, RecyclerView.ViewHolder r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "musicPanel");
        Intrinsics.checkNotNullParameter(r102, "viewHolder");
        SoloKtvOrderSongDataContext.Companion.getClass();
        com.bytedance.android.live.soloktv.karaokestation.viewmodel.a r103 = SoloKtvOrderSongDataContext.Companion.a();
        if (r103 == null) goto L6;
        r103.addSong(r100, r101, r102, AddSongSourceType.KARAOKE_STATION);
        return;
    }
}
