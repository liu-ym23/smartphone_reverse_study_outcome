package com.bytedance.android.livesdkapi.depend.model.live.episode.main;

import com.bytedance.android.live.base.model.user.o0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"ownerUserIdStr", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/main/IMainEpisode;", "getOwnerUserIdStr", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/main/IMainEpisode;)Ljava/lang/String;", "vs-model_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class IMainEpisodeKt {
    public static final String getOwnerUserIdStr(IMainEpisode r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$ownerUserIdStr");
        o0.a r101 = o0.f58946a;
        Long r102 = Long.valueOf(r100.get_ownerUserId());
        String r103 = r100.getOwnerOpenId();
        r101.getClass();
        return o0.a.g(r102, r103);
    }
}
