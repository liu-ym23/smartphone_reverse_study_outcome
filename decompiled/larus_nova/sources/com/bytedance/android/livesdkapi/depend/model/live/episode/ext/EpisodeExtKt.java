package com.bytedance.android.livesdkapi.depend.model.live.episode.ext;

import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"getOwnerIdString", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "vs-model_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class EpisodeExtKt {
    public static final String getOwnerIdString(Episode r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getOwnerIdString");
        IMainEpisode r101 = (IMainEpisode) r100.castToOrNull(IMainEpisode.class);
        if (r101 == null) goto L5;
        o0.a r102 = o0.f58946a;
        Long r103 = Long.valueOf(r101.get_ownerUserId());
        String r104 = r101.getOwnerOpenId();
        r102.getClass();
        return o0.a.g(r103, r104);
    L5:
        return "0";
    }
}
