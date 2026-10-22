package com.bytedance.android.livesdk.chatroom.replay.enter.preload;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.ttvideoengine.TTVideoEngine;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f108603a;

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        a r101 = this.f108603a;
        r101.getClass();
        int r102 = r100.what;
        if (r102 != 1) goto L5;
        Object r103 = r100.obj;
        if (r103 == null) goto L63;
        Pair r104 = (Pair) r103;
        int r105 = r100.arg1;
        pm1.c r106 = (pm1.c) r104.getFirst();
        List<? extends Episode> r107 = (List) r104.getSecond();
        r101.b().sendMessage(r101.b().obtainMessage(100, new Pair(r106, r107)));
        if (r101.f108595i.contains(Integer.valueOf(r105)) == true) goto L73;
        r101.f108597k.a(r107);
        Iterator<T> r108 = r107.iterator();
    L59:
        if (r108.hasNext() == false) goto L77;
        ((Map) r101.f108589c.getValue()).put(Long.valueOf(((Episode) r108.next()).getId()), r106);
        r101.c();
        goto L59
    L77:
        return;
    L73:
        return;
    L63:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Pair<com.bytedance.android.livesdk.chatroom.replay_api.utils.ReplayPreLoadRequest, kotlin.collections.List<com.bytedance.android.livesdkapi.depend.model.live.episode.Episode>>");
    L5:
        if (r102 == 2) goto L29;
        if (r102 == 3) goto L29;
        if (r102 == 4) goto L29;
        if (r102 != 5) goto L74;
        r101.toString();
        r101.f108591e = true;
        r101.b().sendMessage(r101.b().obtainMessage(101, r101));
        b r109 = r101.f108588b;
        if (r109 == null) goto L14;
        r109.removeCallbacksAndMessages(null);
    L14:
        Iterator<T> r110 = r101.f108592f.values().iterator();
    L16:
        if (r110.hasNext() == false) goto L20;
        j r111 = (j) r110.next();
        String r112 = r111.f108609a;
        if (r112 == null) goto L16;
        Episode r113 = r111.f108610b;
        String r114 = r113.title;
        r113.getId();
        TTVideoEngine.cancelPreloadTaskByVideoId(r112);
        goto L16
    L20:
        r101.f108592f.clear();
        r101.f108597k.clear();
        PthreadHandlerThreadV2 r115 = r101.f108587a;
        if (r115 == null) goto L23;
        Looper r116 = r115.getLooper();
    L24:
        if (r116 == null) goto L28;
        PthreadHandlerThreadV2 r117 = r101.f108587a;
        if (r117 == null) goto L28;
        r117.quit();
    L28:
        r101.f108588b = null;
        r101.f108587a = null;
        return;
    L23:
        r116 = null;
        goto L24
    L74:
        return;
    L29:
        Object r118 = r100.obj;
        if (r118 == null) goto L51;
        long r119 = ((Long) r118).longValue();
        if (r101.f108591e == true) goto L75;
        if (r102 == 2) goto L47;
        if (r102 == 3) goto L43;
        if (r102 == 4) goto L39;
        return;
    L39:
        if (r101.f108592f.containsKey(Long.valueOf(r119)) == false) goto L41;
        r101.f108592f.remove(Long.valueOf(r119));
    L41:
        r101.c();
        return;
    L43:
        if (r101.f108592f.containsKey(Long.valueOf(r119)) == false) goto L45;
        r101.f108592f.remove(Long.valueOf(r119));
    L45:
        r101.c();
        return;
    L47:
        if (r101.f108592f.containsKey(Long.valueOf(r119)) == false) goto L49;
        r101.f108592f.remove(Long.valueOf(r119));
    L49:
        r101.b().sendMessage(r101.b().obtainMessage(102, Long.valueOf(r119)));
        r101.c();
        return;
    L75:
        return;
    L51:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    }

    public b(a r100, Looper r101) {
        this.f108603a = r100;
        super(r101);
    }
}
