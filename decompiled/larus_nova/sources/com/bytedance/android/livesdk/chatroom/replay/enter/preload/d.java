package com.bytedance.android.livesdk.chatroom.replay.enter.preload;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.vs_base.base.api.ReplayVideoInfoApi;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f108605a;

    public d(List r100) {
        this.f108605a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Response r101 = (Response) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        List<Episode> r102 = ((ReplayVideoInfoApi.b) r101.data).b();
        if (r102 != null) goto L5;
    L10:
        ((ReplayVideoInfoApi.b) r101.data).c(this.f108605a);
        return (ReplayVideoInfoApi.b) r101.data;
    L5:
        if ((!r102.isEmpty()) == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L10;
        this.f108605a.addAll(r102);
        goto L10
    }
}
