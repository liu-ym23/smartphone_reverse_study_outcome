package com.bytedance.android.livesdk.chatroom.vs_base.session.video;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.depend.live.vs.IVideoEventHub;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public final class ReplayEventHub implements IVideoEventHub, wr1.a {
    public final MutableLiveData<Pair<Boolean, Long>> A;
    public Function1<? super ReplayVideoMetrics.Behavior, Unit> B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NextLiveData<Boolean> f118047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NextLiveData<Boolean> f118048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReplayEventHub$firstFrameWithTime$1 f118049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NextLiveData<Pair<Integer, Integer>> f118050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final NextLiveData<String> f118051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NextLiveData<Boolean> f118052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<Boolean> f118053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData<Boolean> f118054h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData<Boolean> f118055i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final NextLiveData<Boolean> f118056j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MutableLiveData<Integer> f118057k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MutableLiveData<Map<String, String>> f118058l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MutableLiveData<Boolean> f118059m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final MutableLiveData<Boolean> f118060n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final NextLiveData<Boolean> f118061o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final MutableLiveData<Episode> f118062p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final MutableLiveData<Episode> f118063q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final MutableLiveData<Episode> f118064r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final MutableLiveData<Boolean> f118065s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final MutableLiveData<Boolean> f118066t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final MutableLiveData<Boolean> f118067u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final MutableLiveData<Long> f118068v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final MutableLiveData<String> f118069w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final NextLiveData<Boolean> f118070x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final MutableLiveData<Boolean> f118071y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final NextLiveData<Boolean> f118072z;

    public ReplayEventHub() {
        this.f118047a = new NextLiveData();
        this.f118048b = new NextLiveData();
        this.f118049c = new ReplayEventHub$firstFrameWithTime$1(this);
        this.f118050d = new NextLiveData();
        this.f118051e = new NextLiveData();
        NextLiveData<Boolean> r100 = new NextLiveData();
        Boolean r101 = Boolean.FALSE;
        r100.setValue(r101);
        Unit r102 = Unit.INSTANCE;
        this.f118052f = r100;
        this.f118053g = new MutableLiveData();
        this.f118054h = new MutableLiveData();
        this.f118055i = new MutableLiveData();
        this.f118056j = new NextLiveData();
        MutableLiveData<Integer> r103 = new MutableLiveData();
        r103.setValue(0);
        this.f118057k = r103;
        this.f118058l = new MutableLiveData();
        this.f118059m = new MutableLiveData();
        this.f118060n = new MutableLiveData();
        NextLiveData<Boolean> r104 = new NextLiveData();
        r104.setValue(r101);
        this.f118061o = r104;
        this.f118062p = new MutableLiveData();
        this.f118063q = new MutableLiveData();
        this.f118064r = new MutableLiveData();
        this.f118065s = new MutableLiveData();
        this.f118066t = new MutableLiveData();
        new MutableLiveData();
        this.f118067u = new MutableLiveData();
        this.f118068v = new MutableLiveData();
        this.f118069w = new MutableLiveData();
        new MutableLiveData();
        new MutableLiveData();
        new MutableLiveData();
        this.f118070x = new NextLiveData();
        this.f118071y = new MutableLiveData();
        NextLiveData<Boolean> r105 = new NextLiveData();
        r105.setValue(r101);
        this.f118072z = r105;
        this.A = new MutableLiveData();
    }

    @Override // wr1.a
    public final MutableLiveData<Map<String, String>> a() {
        return this.f118058l;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.vs.IVideoEventHub
    public final MutableLiveData getFirstFrame() {
        return this.f118048b;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.vs.IVideoEventHub
    public final MutableLiveData getPlayPrepared() {
        return this.f118047a;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.vs.IVideoEventHub
    public final MutableLiveData getPlayerMediaError() {
        return this.f118051e;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.vs.IVideoEventHub
    public final MutableLiveData<Boolean> getPlayerMute() {
        return this.f118053g;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.vs.IVideoEventHub
    public final MutableLiveData getPlaying() {
        return this.f118052f;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.vs.IVideoEventHub
    public final MutableLiveData getVideoSizeChanged() {
        return this.f118050d;
    }
}
