package com.bytedance.android.live.liveinteract.revenue.adventure.linkcore;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.player.ILivePlatformPlayerProxy;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes46.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ILivePlayerClient f77949a;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f77950a = null;

        static {
            f77950a = new b();
        }

        public b() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ALogger.i("AdventureMediaManager", "livePlayerClient, update isMute: " + ((Boolean) r100));
        }
    }

    static {
    }

    public h() {
    }

    public static final ILivePlayerClient a(h r100) {
        if (r100.f77949a != null) goto L23;
        ILivePlatformPlayerProxy r101 = hs0.a.f486938b.curRoomPlayer();
        Boolean r102 = null;
        if (r101 == null) goto L7;
        ILivePlayerClient r103 = r101.player();
    L8:
        r100.f77949a = r103;
        StringBuilder r104 = new StringBuilder("getLivePlayerClient, isMute: ");
        ILivePlayerClient r105 = r100.f77949a;
        if (r105 == null) goto L15;
        IRoomEventHub r106 = r105.getEventHub();
        if (r106 == null) goto L15;
        MutableLiveData<Boolean> r107 = r106.getPlayerMute();
        if (r107 == null) goto L15;
        r102 = r107.getValue();
    L15:
        r104.append(r102);
        ALogger.i("AdventureMediaManager", r104.toString());
        ILivePlayerClient r108 = r100.f77949a;
        if (r108 == null) goto L23;
        IRoomEventHub r109 = r108.getEventHub();
        if (r109 == null) goto L23;
        MutableLiveData<Boolean> r110 = r109.getPlayerMute();
        if (r110 == null) goto L23;
        r110.observeForever(b.f77950a);
        goto L23
    L7:
        r103 = null;
    L23:
        return r100.f77949a;
    }
}
