package com.bytedance.android.livesdkapi.depend.live.vs;

import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/vs/VSEpisodeStack;", "", "()V", "episodeList", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "addEpisode", "", "episode", "getTopEpisode", "removeEpisode", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSEpisodeStack {
    public static final VSEpisodeStack INSTANCE = null;
    private static final List<Episode> episodeList = null;

    private VSEpisodeStack() {
    }

    static {
        INSTANCE = new VSEpisodeStack();
        episodeList = new ArrayList();
    }

    public final Episode getTopEpisode() {
        List<Episode> r100 = episodeList;
        if (r100.isEmpty() == false) goto L6;
        return null;
    L6:
        return (Episode) ListProtector.get(r100, r100.size() - 1);
    }

    public final void addEpisode(Episode r100) {
        Intrinsics.checkNotNullParameter(r100, "episode");
        episodeList.add(r100);
    }

    public final void removeEpisode(Episode r100) {
        if (r100 == null) goto L5;
        episodeList.remove(r100);
        return;
    }
}
