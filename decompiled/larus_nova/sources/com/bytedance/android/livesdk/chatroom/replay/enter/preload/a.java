package com.bytedance.android.livesdk.chatroom.replay.enter.preload;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.replay_api.model.ReplayVideoPositionInfo;
import com.bytedance.android.livesdk.chatroom.replay_api.service.out.listener.IReplayPreLoadExecutor;
import com.bytedance.android.livesdk.chatroom.vs_base.base.api.ReplayVideoInfoApi;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.ReplayABSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.util.u;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeVideo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeVideoModelContainer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.ttvideoengine.PreloaderVideoModelItem;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.model.VideoModel;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a implements IReplayPreLoadExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PthreadHandlerThreadV2 f108587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.replay.enter.preload.b f108588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f108589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f108590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f108591e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<Long, j> f108592f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.replay.enter.preload.c f108593g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicInteger f108594h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<Integer> f108595i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final dl1.f f108596j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h f108597k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f108598l;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.replay.enter.preload.a$a, reason: collision with other inner class name */
    public static final class C1644a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f108599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ lm1.d f108600b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f108601c;

        public b(a r100, lm1.d r101, int r102) {
            this.f108599a = r100;
            this.f108600b = r101;
            this.f108601c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ReplayVideoInfoApi.b r101 = (ReplayVideoInfoApi.b) r100;
            if (r101.b() == null) goto L18;
            List<Episode> r102 = r101.b();
            Intrinsics.checkNotNull(r102);
            if (r102.isEmpty() == true) goto L21;
            com.bytedance.android.livesdk.chatroom.replay.enter.preload.b r103 = this.f108599a.f108588b;
            if (r103 == null) goto L12;
            Message r104 = r103.obtainMessage(1, new Pair(this.f108600b, r101.b()));
            if (r104 == null) goto L12;
            r104.arg1 = this.f108601c;
        L13:
            if (r104 == null) goto L19;
            com.bytedance.android.livesdk.chatroom.replay.enter.preload.b r105 = this.f108599a.f108588b;
            if (r105 == null) goto L20;
            r105.sendMessage(r104);
            return;
        L20:
            return;
        L19:
            return;
        L12:
            r104 = null;
            goto L13
        L21:
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f108602a;

        public c(a r100) {
            this.f108602a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Objects.toString((Throwable) r100);
            this.f108602a.getClass();
        }
    }

    static {
    }

    public abstract boolean a(long r100);

    public final BasePreLoadExecutor$mainHandler$2.a b() {
        return (BasePreLoadExecutor$mainHandler$2.a) this.f108590d.getValue();
    }

    public final void c() {
        Episode r100 = this.f108597k.c();
        if (r100 != null) goto L7;
        toString();
        return;
    L7:
        if (a(r100.getId()) == false) goto L55;
        this.f108597k.b(r100.getId());
        pm1.c r101 = (pm1.c) ((Map) this.f108589c.getValue()).get(Long.valueOf(r100.getId()));
        if (r101 == null) goto L54;
        pm1.d r102 = r101.f529815a;
        if (r102 == null) goto L54;
        if (r102.f529817a != true) goto L54;
        r100.getId();
        m<? extends pm1.c> r103 = this.f108596j.d(r101);
        String r104 = null;
        if (r103 == null) goto L17;
        ReplayVideoPositionInfo r105 = r103.c(r101, r100);
    L18:
        j r106 = new j(r100, this.f108593g, r105);
        ((Map) this.f108589c.getValue()).remove(Long.valueOf(r100.getId()));
        this.f108592f.put(Long.valueOf(r100.getId()), r106);
        EpisodeVideo r107 = r106.f108610b.video;
        if (r107 == null) goto L24;
        IEpisodeVideoModelContainer r108 = r107.getPlayInfo();
        if (r108 == null) goto L24;
        r104 = r108.getJson();
    L24:
        if (TextUtils.isEmpty(r104) == false) goto L26;
        r106.f108610b.getId();
        r106.f108611c.c(r106.f108610b.getId());
        return;
    L26:
        int r109 = r.f118208a;
        VideoModel r110 = r.e(r104);
        if (r110 != null) goto L29;
        r106.f108610b.getId();
        r106.f108611c.c(r106.f108610b.getId());
        return;
    L29:
        r106.f108609a = r110.getVideoRefStr(2);
        long r111 = r106.f108610b.getId();
        int r112 = dl1.h.f469098a;
        ReplayVideoPositionInfo r113 = r106.f108612d;
        if (r113 != null) goto L32;
        ReplayVideoPositionInfo.Companion.getClass();
        r113 = new ReplayVideoPositionInfo(-1000, -1000, false, true);
    L32:
        u r114 = dl1.h.a(r110, r111, r113);
        int r115 = r114.f118217b;
        if (r115 == 0) goto L49;
        if (r115 != 1) goto L36;
    L41:
        long r116 = r114.f118216a;
        if (0 <= r116) goto L45;
    L47:
        long r117 = -1;
    L48:
        long r118 = r117;
    L51:
        if (r118 < 0) goto L53;
        PreloaderVideoModelItem r119 = new PreloaderVideoModelItem(r110, r.a(r110), ReplayABSettingKeys.LIVE_REPLAY_SHOW_PRELOAD_EPISODE_CONFIG.getValue().a(), r118, false);
        r119.setCallBackListener(new k(r106, r111));
        Episode r120 = r106.f108610b;
        String r121 = r120.title;
        r120.getId();
        TTVideoEngine.addTask(r119);
        return;
    L53:
        r106.f108611c.a(r106.f108610b.getId());
        Episode r122 = r106.f108610b;
        String r123 = r122.title;
        r122.getId();
        return;
    L45:
        if (2000 < r116) goto L47;
    L36:
        if (r115 == 4) goto L41;
        r117 = r114.f118216a;
        if (r117 > 0) goto L48;
        r117 = 0;
    L49:
        r118 = 0;
        goto L51
    L17:
        r105 = null;
    L54:
        r100.getId();
        c();
        return;
    L55:
        r100.getId();
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay_api.service.out.listener.IReplayPreLoadExecutor
    public final void release() {
        com.bytedance.android.livesdk.chatroom.replay.enter.preload.b r100 = this.f108588b;
        if (r100 == null) goto L10;
        Message r101 = r100.obtainMessage(5);
        if (r101 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.replay.enter.preload.b r102 = this.f108588b;
        if (r102 == null) goto L12;
        r102.sendMessageAtFrontOfQueue(r101);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay_api.service.out.listener.IReplayPreLoadExecutor
    public final <T extends lm1.d> int preLoad(T r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        if (this.f108591e == false) goto L6;
        toString();
        return -3;
    L6:
        m<? extends pm1.c> r101 = this.f108596j.d(r100);
        if (r101 != null) goto L11;
        return -1;
    L11:
        if (r101.a(r100) == true) goto L14;
        return -2;
    L14:
        Observable<ReplayVideoInfoApi.b> r102 = r101.b(r100);
        if (r102 != null) goto L19;
        return 0;
    L19:
        if (this.f108587a != null) goto L21;
        PthreadHandlerThreadV2 r103 = new PthreadHandlerThreadV2(this.f108598l);
        this.f108587a = r103;
        ThreadMethodProxy.start(r103);
    L21:
        PthreadHandlerThreadV2 r104 = this.f108587a;
        Looper r105 = null;
        if (r104 == null) goto L24;
        Looper r106 = r104.getLooper();
    L25:
        if (r106 != null) goto L28;
    L33:
        int r107 = this.f108594h.incrementAndGet();
        r102.observeOn(Schedulers.io()).subscribeOn(Schedulers.io()).subscribe(new b(this, r100, r107), new c(this));
        return r107;
    L28:
        if (this.f108588b != null) goto L33;
        PthreadHandlerThreadV2 r108 = this.f108587a;
        if (r108 == null) goto L32;
        r105 = r108.getLooper();
    L32:
        Intrinsics.checkNotNull(r105);
        this.f108588b = new com.bytedance.android.livesdk.chatroom.replay.enter.preload.b(this, r105);
        goto L33
    L24:
        r106 = null;
        goto L25
    }

    public a(dl1.f r100, i.a r101) {
        Intrinsics.checkNotNullParameter(r100, "preLoadCallback");
        Intrinsics.checkNotNullParameter(r101, "preLoadDataSource");
        Intrinsics.checkNotNullParameter("SimplePreLoadExecutor", "name");
        this.f108596j = r100;
        this.f108597k = r101;
        this.f108598l = "SimplePreLoadExecutor";
        this.f108589c = LazyKt.lazy(BasePreLoadExecutor$requestMap$2.INSTANCE);
        this.f108590d = LazyKt.lazy(new BasePreLoadExecutor$mainHandler$2(this));
        this.f108592f = new HashMap();
        this.f108593g = new com.bytedance.android.livesdk.chatroom.replay.enter.preload.c(this);
        this.f108594h = new AtomicInteger();
        this.f108595i = new LinkedHashSet();
    }
}
