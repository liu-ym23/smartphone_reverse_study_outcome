package com.bytedance.android.livesdk.player;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.livesdk.player.api.ITTLivePlayer;
import com.bytedance.android.livesdk.player.model.LiveStreamData;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.model.DisplayMode;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerSpmLogger;
import com.bytedance.android.livesdkapi.roomplayer.IPlayerLogger;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.android.livesdkapi.roomplayer.WtnPlayCallback;
import com.bytedance.android.livesdkapi.roomplayer.WtnPlayRequest;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.livesdkapi.vr.LiveVrEffectInfo;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\nR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/player/LivePlayerContext;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroid/content/Context;", FaceService.neutralLabel, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "SurfaceControlMapper", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayerContext implements LifecycleOwnerCompat {
    public final defpackage.q0 A;
    public int B;
    public long C;
    public volatile boolean D;
    public String E;
    public PlayerResolution.PickResult F;
    public Pair<WtnPlayRequest, ? extends WtnPlayCallback> G;
    public Context H;
    public LivePlayerBuilder I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public SurfaceTexture f154924J;
    public Surface K;
    public no2.a L;
    public final PlayerEventHub M;
    public final LivePlayerClient N;
    public final boolean O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LiveRequest f154925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<IRenderView> f154926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IRenderView f154927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SurfaceHolder.Callback f154928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ITTLivePlayer f154929e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f154930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f154931g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f154932h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f154933i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f154934j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f154935k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f154936l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f154937m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f154938n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f154939o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public DisplayMode f154940p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public SurfaceHolder f154941q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final SurfaceControlMapper f154942r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public LiveStreamData f154943s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f154944t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f154945u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f154946v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public LifecycleRegistry f154947w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public LiveStreamData f154948x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f154949y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final f f154950z;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/player/LivePlayerContext$SurfaceControlMapper;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/android/livesdk/player/surfacecontrol/v2/a;", "cur", "Lcom/bytedance/android/livesdk/player/LivePlayerContext;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/livesdk/player/LivePlayerContext;", "getContext", "()Lcom/bytedance/android/livesdk/player/LivePlayerContext;", "<init>", "(Lcom/bytedance/android/livesdk/player/LivePlayerContext;)V", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SurfaceControlMapper extends ConcurrentHashMap<Integer, com.bytedance.android.livesdk.player.surfacecontrol.v2.a> {
        private final LivePlayerContext context;

        public final com.bytedance.android.livesdk.player.surfacecontrol.v2.a cur() {
            ITTLivePlayer r100 = this.context.f154929e;
            int r101 = 0;
            if (r100 == null) goto L5;
            boolean r102 = true;
        L7:
            if (r102 == false) goto L9;
            SurfaceControlMapper r103 = this;
        L10:
            if (r103 == null) goto L15;
            if (r100 == null) goto L14;
            r101 = r100.hashCode();
        L14:
            return (com.bytedance.android.livesdk.player.surfacecontrol.v2.a) get(Integer.valueOf(r101));
        L15:
            return null;
        L9:
            r103 = null;
            goto L10
        L5:
            r102 = false;
            goto L7
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<Integer, com.bytedance.android.livesdk.player.surfacecontrol.v2.a>> entrySet() {
            return getEntries();
        }

        public /* bridge */ Set getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set getKeys() {
            return super.keySet();
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection getValues() {
            return super.values();
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Integer> keySet() {
            return getKeys();
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<com.bytedance.android.livesdk.player.surfacecontrol.v2.a> values() {
            return getValues();
        }

        public final LivePlayerContext getContext() {
            return this.context;
        }

        public SurfaceControlMapper(LivePlayerContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.context = r100;
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object r100) {
            if ((r100 instanceof Integer) == true) goto L7;
            return false;
        L7:
            return containsKey((Integer) r100);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object r100) {
            if ((r100 instanceof com.bytedance.android.livesdk.player.surfacecontrol.v2.a) == true) goto L7;
            return false;
        L7:
            return containsValue((com.bytedance.android.livesdk.player.surfacecontrol.v2.a) r100);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object get(Object r100) {
            if ((r100 instanceof Integer) == true) goto L7;
            return null;
        L7:
            return get((Integer) r100);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object remove(Object r100) {
            if ((r100 instanceof Integer) == true) goto L7;
            return null;
        L7:
            return remove((Integer) r100);
        }

        public /* bridge */ boolean containsKey(Integer r100) {
            return super.containsKey(r100);
        }

        public /* bridge */ boolean containsValue(com.bytedance.android.livesdk.player.surfacecontrol.v2.a r100) {
            return super.containsValue(r100);
        }

        public /* bridge */ com.bytedance.android.livesdk.player.surfacecontrol.v2.a get(Integer r100) {
            return (com.bytedance.android.livesdk.player.surfacecontrol.v2.a) super.get(r100);
        }

        public /* bridge */ com.bytedance.android.livesdk.player.surfacecontrol.v2.a remove(Integer r100) {
            return (com.bytedance.android.livesdk.player.surfacecontrol.v2.a) super.remove(r100);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
        public final /* bridge */ Object getOrDefault(Object r100, Object r101) {
            if ((r100 instanceof Integer) == true) goto L6;
            return r101;
        L6:
            return getOrDefault((Integer) r100, (com.bytedance.android.livesdk.player.surfacecontrol.v2.a) r101);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
        public final /* bridge */ boolean remove(Object r100, Object r101) {
            if ((r100 instanceof Integer) == false) goto L11;
            if (r101 == null) goto L6;
            boolean r102 = r101 instanceof com.bytedance.android.livesdk.player.surfacecontrol.v2.a;
        L7:
            if (r102 == true) goto L10;
            return false;
        L10:
            return remove((Integer) r100, (com.bytedance.android.livesdk.player.surfacecontrol.v2.a) r101);
        L6:
            r102 = true;
            goto L7
        L11:
            return false;
        }

        public /* bridge */ com.bytedance.android.livesdk.player.surfacecontrol.v2.a getOrDefault(Integer r100, com.bytedance.android.livesdk.player.surfacecontrol.v2.a r101) {
            return (com.bytedance.android.livesdk.player.surfacecontrol.v2.a) super.getOrDefault(r100, r101);
        }

        public /* bridge */ boolean remove(Integer r100, com.bytedance.android.livesdk.player.surfacecontrol.v2.a r101) {
            return super.remove(r100, r101);
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    public final LiveStreamData a() {
        if (this.f154948x != null) goto L15;
        StringBuilder r100 = new StringBuilder("liveRequestLiveStreamData liveRequest?.streamData:");
        LiveRequest r101 = this.f154925a;
        LiveStreamData r102 = null;
        if (r101 == null) goto L7;
        String r103 = r101.getStreamData();
    L8:
        r100.append(r103);
        com.bytedance.android.live.player.utils.b.c("LivePlayerContext", r100.toString());
        LiveRequest r104 = this.f154925a;
        if (r104 == null) goto L13;
        String r105 = r104.getStreamData();
        if (r105 == null) goto L13;
        r102 = new LiveStreamData(r105, PlayerResolution.SDKKEY.ORIGIN);
    L13:
        this.f154948x = r102;
        goto L15
    L7:
        r103 = null;
    L15:
        return this.f154948x;
    }

    public final IRenderView b() {
        if (this.O == false) goto L9;
        WeakReference<IRenderView> r100 = this.f154926b;
        if (r100 != null) goto L10;
        return null;
    L10:
        return r100.get();
    L9:
        return this.f154927c;
    }

    public final LiveVrEffectInfo c() {
        LiveRequest r100 = this.f154925a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getVrEffectInfo();
    }

    public final void h() {
        ITTLivePlayer r100 = this.f154929e;
        if (r100 == null) goto L11;
        Map<String, String> r101 = r100.getLiveStreamBaseInfo();
        if (r101 == null) goto L12;
        this.f154932h.putAll(r101);
        Map<String, String> r102 = this.f154932h;
        r102.put("resolution", this.N.getCurrentResolution());
        r102.put("stream_format", this.N.getStreamFormat());
        String r103 = this.N.getVideoSize().toString();
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        r102.put("video_size", r103);
        return;
    L12:
        return;
    }

    public final Context getContext() {
        return this.H;
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public final Lifecycle getLifecycleCompat() {
        return this.f154947w;
    }

    public final void f(TTLivePlayer r100) {
        this.f154929e = r100;
        if (r100 == null) goto L10;
        int r101 = this.N.hashCode();
        ITTLivePlayer r102 = this.f154929e;
        if (r102 == null) goto L7;
        int r103 = r102.hashCode();
    L8:
        com.bytedance.android.live.player.utils.b.f85850b.put(Integer.valueOf(r103), Integer.valueOf(r101));
        return;
    L7:
        r103 = 0;
        goto L8
    }

    public final void g(IRenderView r100) {
        if (this.O == false) goto L5;
        this.f154926b = new WeakReference(r100);
        return;
    L5:
        this.f154927c = r100;
    }

    public final void e(String r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        IPlayerLogger r101 = this.N.logger();
        if (r101 == null) goto L6;
        ILivePlayerSpmLogger.DefaultImpls.logPlayerClient$default(r101, r100, null, r110, null, 10, null);
        return;
    }

    public LivePlayerContext(Context r100, PlayerEventHub r101, LivePlayerClient r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "eventHub");
        Intrinsics.checkNotNullParameter(r102, "client");
        this.H = r100;
        this.I = null;
        this.f154924J = null;
        this.K = null;
        this.L = null;
        this.M = r101;
        this.N = r102;
        this.O = r103;
        this.f154931g = true;
        this.f154932h = new LinkedHashMap();
        LiveRequest r104 = this.f154925a;
        if (r104 == null) goto L5;
        boolean r105 = r104.getBlur();
    L6:
        this.f154934j = r105;
        LiveRequest r106 = this.f154925a;
        if (r106 == null) goto L9;
        r106.getAudioAddr();
    L9:
        this.f154935k = "";
        this.f154937m = -1;
        this.f154938n = -2;
        this.f154939o = -1;
        this.f154940p = DisplayMode.INITIAL;
        this.f154942r = new SurfaceControlMapper(this);
        this.f154947w = new LifecycleRegistry(this);
        this.f154949y = "";
        this.f154950z = new f();
        this.A = new defpackage.q0();
        this.C = -1;
        this.E = "-1";
        return;
    L5:
        r105 = false;
        goto L6
    }
}
