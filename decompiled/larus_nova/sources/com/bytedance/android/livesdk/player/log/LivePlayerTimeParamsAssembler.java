package com.bytedance.android.livesdk.player.log;

import android.os.SystemClock;
import com.bytedance.android.livesdk.player.LivePlayerClient;
import com.bytedance.android.livesdkapi.model.DisplayMode;
import com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class LivePlayerTimeParamsAssembler extends LivePlayerEventListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f155580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f155581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f155582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f155583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f155584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f155585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f155586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f155587h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f155588i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f155589j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f155590k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f155591l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f155592m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LivePlayerTimeParamsAssembler$bindRenderViewObserver$1 f155593n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LivePlayerTimeParamsAssembler$surfaceReadyObserver$1 f155594o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LivePlayerTimeParamsAssembler$prepareObserver$1 f155595p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LivePlayerTimeParamsAssembler$firstFrameObserver$1 f155596q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LivePlayerTimeParamsAssembler$playingObserver$1 f155597r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final LivePlayerTimeParamsAssembler$stopObserver$1 f155598s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final LivePlayerTimeParamsAssembler$releaseObserver$1 f155599t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final LivePlayerTimeParamsAssembler$startPullObserver$1 f155600u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List<Pair<DisplayMode, Long>> f155601v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Map<DisplayMode, Long> f155602w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final LivePlayerClient f155603x;

    public static long a(long r100) {
        if (r100 >= 0) goto L5;
        return 0;
    L5:
        return r100;
    }

    public final void b() {
        long r100 = 0;
        this.f155580a = 0;
        this.f155587h = SystemClock.elapsedRealtime();
        if (((ArrayList) this.f155601v).isEmpty() == false) goto L6;
    L19:
        ((ArrayList) this.f155601v).clear();
        return;
    L6:
        if (this.f155587h > 0) goto L8;
        this.f155587h = SystemClock.elapsedRealtime();
    L8:
        LinkedHashMap r101 = new LinkedHashMap();
        int r102 = ((ArrayList) this.f155601v).size() - 1;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L15;
        Object r104 = ((Pair) ListProtector.get(this.f155601v, r103)).getFirst();
        Long r105 = (Long) r101.get(((Pair) ListProtector.get(this.f155601v, r103)).getFirst());
        if (r105 == null) goto L13;
        long r106 = r105.longValue();
    L14:
        int r107 = r103 + 1;
        r101.put(r104, Long.valueOf(r106 + (((Number) ((Pair) ListProtector.get(this.f155601v, r107)).getSecond()).longValue() - ((Number) ((Pair) ListProtector.get(this.f155601v, r103)).getSecond()).longValue())));
        r103 = r107;
        goto L9
    L13:
        r106 = 0;
        goto L14
    L15:
        Object r108 = ((Pair) CollectionsKt.last(this.f155601v)).getFirst();
        Long r109 = (Long) r101.get(((Pair) CollectionsKt.last(this.f155601v)).getFirst());
        if (r109 == null) goto L18;
        r100 = r109.longValue();
    L18:
        r101.put(r108, Long.valueOf(r100 + (this.f155587h - ((Number) ((Pair) CollectionsKt.last(this.f155601v)).getSecond()).longValue())));
        r101.toString();
        this.f155602w = r101;
        goto L19
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onFirstFrame() {
        this.f155596q.a(Boolean.TRUE);
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onPlaying() {
        LivePlayerTimeParamsAssembler$playingObserver$1 r100 = this.f155597r;
        Boolean r101 = Boolean.TRUE;
        r100.getClass();
        if (r101 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r101, Boolean.FALSE) == true) goto L10;
        LivePlayerTimeParamsAssembler r102 = r100.f155606a;
        r102.f155586g = SystemClock.elapsedRealtime();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onPrepare() {
        LivePlayerTimeParamsAssembler$prepareObserver$1 r100 = this.f155595p;
        Boolean r101 = Boolean.TRUE;
        r100.getClass();
        if (r101 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r101, Boolean.FALSE) == true) goto L10;
        LivePlayerTimeParamsAssembler r102 = r100.f155607a;
        r102.f155584e = SystemClock.elapsedRealtime();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onRelease() {
        LivePlayerTimeParamsAssembler$releaseObserver$1 r100 = this.f155599t;
        Boolean r101 = Boolean.TRUE;
        r100.getClass();
        if (Intrinsics.areEqual(r101, r101) == false) goto L6;
        r100.f155608a.b();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onStartPul() {
        this.f155600u.a(Boolean.TRUE);
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onStop() {
        LivePlayerTimeParamsAssembler$stopObserver$1 r100 = this.f155598s;
        Boolean r101 = Boolean.TRUE;
        r100.getClass();
        if (Intrinsics.areEqual(r101, r101) == false) goto L6;
        r100.f155610a.b();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onSurfaceReady() {
        this.f155594o.a(Boolean.TRUE);
    }

    public LivePlayerTimeParamsAssembler(LivePlayerClient r100) {
        Intrinsics.checkNotNullParameter(r100, "client");
        this.f155603x = r100;
        this.f155593n = new LivePlayerTimeParamsAssembler$bindRenderViewObserver$1(this);
        this.f155594o = new LivePlayerTimeParamsAssembler$surfaceReadyObserver$1(this);
        this.f155595p = new LivePlayerTimeParamsAssembler$prepareObserver$1(this);
        this.f155596q = new LivePlayerTimeParamsAssembler$firstFrameObserver$1(this);
        this.f155597r = new LivePlayerTimeParamsAssembler$playingObserver$1(this);
        this.f155598s = new LivePlayerTimeParamsAssembler$stopObserver$1(this);
        this.f155599t = new LivePlayerTimeParamsAssembler$releaseObserver$1(this);
        this.f155600u = new LivePlayerTimeParamsAssembler$startPullObserver$1(this);
        this.f155601v = new ArrayList();
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onBindRenderView(IRenderView r100) {
        LivePlayerTimeParamsAssembler$bindRenderViewObserver$1 r101 = this.f155593n;
        if (r100 != null) goto L5;
        r101.getClass();
        return;
    L5:
        LivePlayerTimeParamsAssembler r102 = r101.f155604a;
        r102.f155582c = SystemClock.elapsedRealtime();
    }
}
