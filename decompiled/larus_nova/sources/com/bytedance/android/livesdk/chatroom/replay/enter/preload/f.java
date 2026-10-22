package com.bytedance.android.livesdk.chatroom.replay.enter.preload;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.vs_base.base.api.ReplayVideoInfoApi;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class f<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f108606a = null;

    static {
        f108606a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Response r101 = (Response) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        ReplayVideoInfoApi.b r102 = (ReplayVideoInfoApi.b) r101.data;
        ArrayList r103 = new ArrayList();
        Episode r104 = ((ReplayVideoInfoApi.b) r101.data).a();
        if (r104 == null) goto L5;
        r103.add(r104);
    L5:
        Unit r105 = Unit.INSTANCE;
        r102.c(r103);
        return (ReplayVideoInfoApi.b) r101.data;
    }
}
