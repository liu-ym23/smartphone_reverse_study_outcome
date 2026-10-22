package com.bytedance.android.live.ktv.common.karaokestation.viewmodel;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.karaokestation.model.d;
import com.bytedance.android.live.ktv.common.karaokestation.model.x;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.model.api.o0;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements nb0.b {
    public a() {
    }

    @Override // nb0.b
    public final void addFavorite(MusicPanel r100, ic0.a r101) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
        Intrinsics.checkNotNullParameter(r101, "favoriteCallback");
    }

    @Override // nb0.b
    public final void addSong(Context r100, MusicPanel r101, RecyclerView.ViewHolder r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "musicPanel");
        Intrinsics.checkNotNullParameter(r102, "viewHolder");
    }

    @Override // nb0.b
    public final String c() {
        return null;
    }

    @Override // nb0.b
    public final void delFavorite(MusicPanel r100, ic0.a r101) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
        Intrinsics.checkNotNullParameter(r101, "favoriteCallback");
    }

    @Override // nb0.b
    public final t61 e() {
        return null;
    }

    @Override // nb0.b
    public final int g() {
        return -1;
    }

    @Override // nb0.b
    public final String getRequiredSongInfo() {
        return "";
    }

    @Override // nb0.b
    public final String h() {
        return null;
    }

    @Override // nb0.b
    public final x getRoomInfo() {
        return new x(0);
    }

    @Override // nb0.b
    public final Map<String, y> f(d r100) {
        Intrinsics.checkNotNullParameter(r100, "firstLevelTabData");
        Intrinsics.checkNotNullParameter(r100, "firstLevelTabData");
        return null;
    }

    @Override // nb0.b
    public final void postSyncSongListData(y r100) {
        Intrinsics.checkNotNullParameter(r100, "secondLevelTabData");
        Intrinsics.checkNotNullParameter(r100, "secondLevelTabData");
    }

    @Override // nb0.b
    public final void postSyncTabListData(d r100) {
        Intrinsics.checkNotNullParameter(r100, "firstLevelTabData");
        Intrinsics.checkNotNullParameter(r100, "firstLevelTabData");
    }

    @Override // nb0.b
    public final void updateMusicPanelState(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
    }

    @Override // nb0.b
    public final void a(d r100, List<o0> r101) {
        Intrinsics.checkNotNullParameter(r100, "firstLevelTabData");
        Intrinsics.checkNotNullParameter(r100, "firstLevelTabData");
    }

    @Override // nb0.b
    public final void b(boolean r100, Throwable r101, y r102, long r103) {
        Intrinsics.checkNotNullParameter(r102, "secondLevelTabData");
        Intrinsics.checkNotNullParameter(r102, "secondLevelTabData");
    }

    @Override // nb0.b
    public final void d(boolean r100, Throwable r101, d r102, long r103) {
        Intrinsics.checkNotNullParameter(r102, "firstLevelTabData");
        Intrinsics.checkNotNullParameter(r102, "firstLevelTabData");
    }
}
