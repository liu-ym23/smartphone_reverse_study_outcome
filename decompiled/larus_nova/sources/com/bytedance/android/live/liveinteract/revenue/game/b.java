package com.bytedance.android.live.liveinteract.revenue.game;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.model.q;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.VideoChatDynamic1V7Info;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f78317a;

    public b(a r100) {
        this.f78317a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IRoomLinkMicSyncData r101 = (IRoomLinkMicSyncData) r100;
        q r102 = r101.getLinkerBaseInfo();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.getUiLayout() != 15) goto L27;
        ClientUIInfo r103 = r101.getClientUIInfo();
        Long r104 = null;
        if (r103 == null) goto L9;
        VideoChatDynamic1V7Info r105 = r103.getVideoChatDynamic1V7Info();
    L10:
        if (r105 == null) goto L28;
        Long r106 = this.f78317a.f78314c;
        ClientUIInfo r107 = r101.getClientUIInfo();
        if (r107 == null) goto L16;
        VideoChatDynamic1V7Info r108 = r107.getVideoChatDynamic1V7Info();
        if (r108 == null) goto L16;
        Long r109 = Long.valueOf(r108.getStatus());
    L18:
        if ((!Intrinsics.areEqual(r106, r109)) == false) goto L29;
        a r110 = this.f78317a;
        ClientUIInfo r111 = r101.getClientUIInfo();
        if (r111 == null) goto L24;
        VideoChatDynamic1V7Info r112 = r111.getVideoChatDynamic1V7Info();
        if (r112 == null) goto L24;
        r104 = Long.valueOf(r112.getStatus());
    L24:
        r110.f78314c = r104;
        ALogger.d("DanmuGameController", "startObserveMicSeatStatus, update micSeatStatus: " + this.f78317a.f78314c);
        return;
    L29:
        return;
    L16:
        r109 = null;
        goto L18
    L28:
        return;
    L9:
        r105 = null;
        goto L10
    }
}
