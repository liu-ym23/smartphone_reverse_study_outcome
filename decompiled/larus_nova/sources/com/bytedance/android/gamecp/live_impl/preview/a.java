package com.bytedance.android.gamecp.live_impl.preview;

import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CardAnimationControllerPreView> f57922a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f57923b = null;

    public a() {
    }

    static {
        f57923b = new a();
        f57922a = new ConcurrentHashMap();
    }

    public final synchronized CardAnimationControllerPreView a(String r100, String r101, ILiveRoomControllerProvider.ProviderSource r102) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "roomId");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r102, "source");     // Catch: Throwable -> L12
        String r103 = r100 + '-' + r101 + '-' + r102;     // Catch: Throwable -> L12
        ConcurrentHashMap<String, CardAnimationControllerPreView> r104 = f57922a;     // Catch: Throwable -> L12
        CardAnimationControllerPreView r105 = r104.get(r103);     // Catch: Throwable -> L12
        if (r105 != null) goto L9;
        r105 = new CardAnimationControllerPreView(r100, r101, r102, new f());     // Catch: Throwable -> L12
        CardAnimationControllerPreView r106 = r104.putIfAbsent(r103, r105);     // Catch: Throwable -> L12
        if (r106 == null) goto L9;
        r105 = r106;
    L9:
        CardAnimationControllerPreView r107 = r105;     // Catch: Throwable -> L12
        monitor-exit(this);
        return r107;
    L12:
        th = move-exception;
        throw th;
    }
}
