package com.bytedance.android.livesdk.room.handler;

import com.bytedance.android.livesdk.room.util.f;
import com.bytedance.android.livesdk.room.util.g;
import com.bytedance.android.livesdkapi.room.handler.IExternalMessageListener;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomMessageHandler;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements ILiveRoomMessageHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<IExternalMessageListener, l> f157668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vlc.d f157669b;

    public d(vlc.d r100) {
        this.f157669b = r100;
        this.f157668a = new HashMap();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.ILiveRoomMessageHandler
    public final void removeListener(IExternalMessageListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        vlc.d r101 = this.f157669b;
        if (r101 == null) goto L5;
        r101.removeMessageListener((l) ((HashMap) this.f157668a).get(r100));
    L5:
        ((HashMap) this.f157668a).remove(r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.ILiveRoomMessageHandler
    public final void addListener(int r100, IExternalMessageListener r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        HashMap r102 = (HashMap) this.f157668a;
        if (r102.get(r101) != null) goto L5;
        int r103 = g.f157834a;
        Intrinsics.checkNotNullParameter(r101, "listener");
        r102.put(r101, new f(r101));
    L5:
        vlc.d r104 = this.f157669b;
        if (r104 == null) goto L9;
        r104.addMessageListener(r100, (l) ((HashMap) this.f157668a).get(r101));
        return;
    }
}
