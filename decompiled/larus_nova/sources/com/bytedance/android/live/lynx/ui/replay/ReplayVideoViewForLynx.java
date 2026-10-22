package com.bytedance.android.live.lynx.ui.replay;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.chatroom.replay.player.ReplayVideoPlayerHelper;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeVideo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeVideoModelContainer;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayPaidInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;
import com.bytedance.android.livesdkapi.replay.IReplayPlayerHelper;
import com.bytedance.android.livesdkapi.replay.ReplayPlayerConfiger;
import com.bytedance.android.livesdkapi.service.vs.IVSHistoryProgressService;
import com.bytedance.android.livesdkapi.vsplayer.ShareVideoData;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.lynx.react.bridge.JavaOnlyMap;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import nic.l;
import nic.p;
import oic.f;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J0\u0010\u0015\u001a\u00020\u00052&\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0012j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0016JN\u0010&\u001a\u00020\u00052D\u0010%\u001a@\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020#¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001fH\u0016¨\u0006/"}, d2 = {"Lcom/bytedance/android/live/lynx/ui/replay/ReplayVideoViewForLynx;", "Landroid/widget/FrameLayout;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "episode", "", "setEpisode", "", "coverUrl", "setPoster", "", "autoPlay", "setAutoPlay", "enable", "setEnableEnterRoom", "(Ljava/lang/Boolean;)V", "objectFit", "setObjectFit", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "logExtra", "setLogExtra", "muted", "setMuted", "autoShowCover", "setAutoShowCover", SalesInfoStruct.REPEAT, "setRepeat", "", "startPosition", "setStartPosition", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "event", "", "data", "listener", "setEventChangeListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayVideoViewForLynx extends FrameLayout {
    public IReplayPlayerHelper A;
    public boolean B;
    public Disposable C;
    public long D;
    public final b E;
    public final a F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f82768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f82769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f82770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f82771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f82772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f82773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f82774g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f82775h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f82776i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f82777j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f82778k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f82779l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f82780m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Episode f82781n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f82782o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f82783p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f82784q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f82785r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f82786s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f82787t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f82788u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f82789v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f82790w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public HashMap<String, String> f82791x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<String> f82792y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Function2<? super String, ? super Map<String, ? extends Object>, Unit> f82793z;

    public static final class a implements IReplayPlayerHelper.IReplayPlayerWrapperListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayVideoViewForLynx f82794a;

        @Override // com.bytedance.android.livesdkapi.replay.IReplayPlayerHelper.IReplayPlayerWrapperListener
        public final void onVideoPause() {
            IReplayPlayerHelper.IReplayPlayerWrapperListener.DefaultImpls.onVideoPause(this);
        }

        public a(ReplayVideoViewForLynx r100) {
            this.f82794a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.replay.IReplayPlayerHelper.IReplayPlayerWrapperListener
        public final void onPlayStateChanged(int r100) {
            ReplayVideoViewForLynx r101 = this.f82794a;
            String r102 = r101.f82768a;
            if (r100 != 0) goto L5;
            r101.f82789v = false;
            ReplayVideoViewForLynx.f(r101, "stop");
            return;
        L5:
            if (r100 != 1) goto L7;
            r101.f82789v = true;
            return;
        L7:
            if (r100 != 2) goto L15;
            ReplayVideoViewForLynx.f(r101, "pause");
            return;
        }

        @Override // com.bytedance.android.livesdkapi.replay.IReplayPlayerHelper.IReplayPlayerWrapperListener
        public final void onError(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            ReplayVideoViewForLynx r102 = this.f82794a;
            String r103 = r102.f82768a;
            r102.getClass();
            r102.e("error", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("error", r101)}));
        }
    }

    public static final class b extends l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayVideoViewForLynx f82795a;

        public b(ReplayVideoViewForLynx r100) {
            this.f82795a = r100;
        }

        @Override // nic.l.a, nic.h
        public final void B(p r100, tic.a r101) {
            ReplayVideoViewForLynx r102 = this.f82795a;
            String r103 = r102.f82768a;
            r102.B = true;
            ReplayVideoViewForLynx.f(r102, "play");
            if (r102.f82788u == true) goto L6;
            r102.b();
        L6:
            if (r102.f82784q == true) goto L8;
            r102.g();
        L8:
            Disposable r104 = r102.C;
            if (r104 == null) goto L12;
            r104.dispose();
            return;
        }

        @Override // nic.l.a, nic.h
        public final void L(f r100, tic.a r101) {
            ReplayVideoViewForLynx r102 = this.f82795a;
            String r103 = r102.f82768a;
            if (r102.f82788u == true) goto L6;
            r102.b();
        L6:
            if (r102.f82784q == true) goto L9;
            r102.g();
            return;
        }

        @Override // nic.l.a, nic.h
        public final void W(f r100, tic.a r101) {
            ReplayVideoViewForLynx r102 = this.f82795a;
            String r103 = r102.f82768a;
            if (r102.f82786s == false) goto L7;
            r102.f82786s = false;
            IReplayPlayerHelper r104 = r102.A;
            if (r104 == null) goto L7;
            r104.hideCover(true);
        L7:
            ReplayVideoViewForLynx.f(r102, "play");
            if (r102.f82788u == true) goto L11;
            r102.b();
        L11:
            if (r102.f82784q == true) goto L14;
            r102.g();
            return;
        }

        @Override // nic.l.a, nic.h
        public final void b(f r100, tic.a r101) {
            ReplayVideoViewForLynx r102 = this.f82795a;
            String r103 = r102.f82768a;
            r102.f82775h = 0;
            r102.f82776i = false;
            r102.f82788u = false;
            r102.f82777j = false;
            ReplayVideoViewForLynx.f(r102, "ended");
        }

        @Override // nic.l.a, nic.h
        public final void s(f r100, tic.a r101) {
            ReplayVideoViewForLynx r102 = this.f82795a;
            String r103 = r102.f82768a;
            r102.b();
        }

        @Override // nic.l.a, nic.h
        public final void x(f r100, tic.a r101, boolean r102) {
            ReplayVideoViewForLynx r103 = this.f82795a;
            if (r103.f82787t == false) goto L5;
            r103.c();
            return;
        L5:
            r103.b();
        }

        @Override // nic.l.a, nic.h
        public final void m(f r100, tic.a r101, int r102, int r103) {
            ReplayVideoViewForLynx r104 = this.f82795a;
            String r105 = r104.f82768a;
            r104.a();
        }

        @Override // nic.l.a, nic.h
        public final void q(f r100, tic.a r101, int r102, int r103) {
            ReplayVideoViewForLynx r104 = this.f82795a;
            String r105 = r104.f82768a;
            r104.f82775h = r102;
            if (r104.f82786s == false) goto L7;
            r104.f82786s = false;
            IReplayPlayerHelper r106 = r104.A;
            if (r106 == null) goto L7;
            r106.hideCover(true);
        L7:
            r104.e("timeupdate", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("playTime", Integer.valueOf(r102)), TuplesKt.to("totalDuration", Integer.valueOf(r103))}));
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayVideoViewForLynx f82796a;

        public c(ReplayVideoViewForLynx r100) {
            this.f82796a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ReplayVideoViewForLynx r100 = this.f82796a;     // Catch: Throwable -> L12
            if (r100.f82773f == false) goto L15;
            r100.f82773f = false;     // Catch: Throwable -> L12
            long r101 = -1;
            Long r102 = -1L;     // Catch: Throwable -> L12
            if (r102 == null) goto L8;
            r101 = r102.longValue();     // Catch: Throwable -> L12
        L8:
            if (r101 < 0) goto L10;
            r100.f82774g = r102;     // Catch: Throwable -> L12
        L10:
            r100.c();     // Catch: Throwable -> L12
            return;
        L15:
            return;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public ReplayVideoViewForLynx(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ReplayVideoViewForLynx(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        if (this.f82779l == true) goto L5;
        return;
    L5:
        if (this.f82785r == false) goto L24;
        IReplayPlayerHelper r100 = this.A;
        if (r100 == null) goto L11;
        if (r100.isPlaying() != true) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(this.f82783p) == true) goto L16;
        IReplayPlayerHelper r101 = this.A;
        if (r101 == null) goto L15;
        String r102 = this.f82783p;
        Intrinsics.checkNotNull(r102);
        r101.bindCoverUrl(r102, R.drawable.ttlive_bg_audio_live_new_placeholder, ImageView.ScaleType.CENTER_CROP);
    L15:
        this.f82785r = false;
        this.f82786s = true;
        return;
    L16:
        Episode r103 = this.f82781n;
        if (r103 == null) goto L27;
        IReplayPlayerHelper r104 = this.A;
        if (r104 == null) goto L21;
        Intrinsics.checkNotNull(r103);
        r104.bindCover(r103, R.drawable.ttlive_bg_audio_live_new_placeholder, ImageView.ScaleType.CENTER_CROP);
    L21:
        this.f82785r = false;
        return;
    L27:
        return;
    }

    public final void b() {
        f(this, "pause");
        this.f82788u = false;
        IReplayPlayerHelper r100 = this.A;
        if (r100 == null) goto L5;
        r100.pause();
    L5:
        setKeepScreenOn(false);
    }

    public final void c() {
        if (this.f82784q == true) goto L6;
        return;
    L6:
        if (this.f82788u == false) goto L8;
        return;
    L8:
        this.f82788u = true;
        Episode r100 = this.f82781n;
        if (r100 == null) goto L73;
        EpisodeVideo r101 = r100.video;
        if (r101 == null) goto L73;
        IEpisodeVideoModelContainer r102 = r101.getPlayInfo();
        if (r102 == null) goto L73;
        String r103 = r102.getJson();
        if (r103 == null) goto L73;
        IReplayPlayerHelper r104 = this.A;
        if (r104 == null) goto L73;
        if (this.f82776i == true) goto L22;
        r104.resume();
    L22:
        if (r104.isPlaying() == true) goto L24;
    L25:
        r104.setTag(this.f82769b, this.f82770c);
        monitor-enter(this);
        Long r105 = this.f82774g;     // Catch: Throwable -> L70
        if (r105 == null) goto L31;
        this.f82774g = null;     // Catch: Throwable -> L70
        long r106 = r105.longValue();     // Catch: Throwable -> L70
    L34:
        monitor-exit(this);
        this.f82775h = r106;
        Episode r107 = this.f82781n;
        if (r107 == null) goto L38;
        long r108 = r107.roomId;
    L39:
        long r110 = this.f82782o;
        this.D = r110;
        Unit r111 = Unit.INSTANCE;
        if (r107 == null) goto L45;
        IBaseUser r109 = r107.getOwner();
        if (r109 == null) goto L45;
        String r112 = r109.getIdString();
        if (r112 == null) goto L45;
    L46:
        String r113 = r112;
        Episode r114 = this.f82781n;
        if (r114 == null) goto L51;
        IMainEpisode r115 = (IMainEpisode) r114.castToOrNull(IMainEpisode.class);
        if (r115 == null) goto L51;
        ReplayPaidInfo r116 = r115.getReplayPaidInfo();
    L52:
        HashMap<String, String> r117 = this.f82791x;
        if (r117 != null) goto L56;
        r117 = new HashMap();
    L56:
        IReplayPlayerHelper.DefaultImpls.play$default(r104, "lynx_view", r103, r106, r108, r110, r113, null, r116, r117, false, 512, null);
        r104.setMute(this.f82778k);
        r104.setLoop(this.f82780m);
        if (this.B == true) goto L65;
        Disposable r118 = this.C;
        if (r118 == null) goto L63;
        Intrinsics.checkNotNull(r118);
        if (r118.isDisposed() == false) goto L65;
    L63:
        this.C = Flowable.timer(3000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this));
    L65:
        if (this.f82776i == false) goto L68;
        this.f82776i = false;
    L68:
        if (this.f82777j == false) goto L73;
        this.f82777j = false;
    L51:
        r116 = null;
    L45:
        r112 = "0";
        goto L46
    L38:
        r108 = 0;
        goto L39
    L31:
        if (this.f82776i == false) goto L33;
        r106 = ((IVSHistoryProgressService) k.n(IVSHistoryProgressService.class)).getLocalPlayProgress(this.f82782o);     // Catch: Throwable -> L70
        goto L34
    L33:
        r106 = this.f82775h;     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        throw th;
    L24:
        if (this.D == this.f82782o) goto L65;
    L73:
        setKeepScreenOn(true);
    }

    public final void d() {
        if (this.A != null) goto L5;
        return;
    L5:
        Episode r100 = this.f82781n;
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.idStr == null) goto L124;
        Bundle r101 = new Bundle();
        r101.putLong(ILiveRoomPlayFragmentConstant.EXTRA_ITEM_ID, this.f82782o);
        r101.putInt(ILiveRoomPlayFragmentConstant.EXTRA_ITEM_TYPE, 23);
        String r102 = VSConstants.EXTRA_VIDEO_MODEL;
        Episode r103 = this.f82781n;
        qic.d r104 = null;
        if (r103 == null) goto L17;
        EpisodeVideo r105 = r103.video;
        if (r105 == null) goto L17;
        IEpisodeVideoModelContainer r106 = r105.getPlayInfo();
        if (r106 == null) goto L17;
        String r107 = r106.getJson();
    L18:
        r101.putString(r102, r107);
        if (this.f82789v == false) goto L26;
        r101.putBoolean(VSConstants.EXTRA_VS_SHARE_VIEW, true);
        this.f82777j = true;
        this.f82789v = false;
        ShareVideoData r108 = ShareVideoData.INSTANCE;
        IReplayPlayerHelper r109 = this.A;
        if (r109 == null) goto L23;
        r104 = r109.getVideoSnapshotInfo();
    L23:
        r108.setSnapshotInfo(r104);
        IReplayPlayerHelper r110 = this.A;
        if (r110 == null) goto L29;
        r110.setReleaseEnable(false);
    L29:
        r101.putLong(ILiveRoomPlayFragmentConstant.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME, System.currentTimeMillis());
        r101.putString(ILiveRoomPlayFragmentConstant.EXTRA_USER_ACTION_ENTER_ROOM_TYPE, ILiveRoomPlayFragmentConstant.ENTER_ROOM_TYPE_WITH_INNER_START);
        Bundle r111 = new Bundle();
        HashMap<String, String> r112 = this.f82791x;
        if (r112 == null) goto L88;
        Iterator<Map.Entry<String, String>> r113 = r112.entrySet().iterator();
    L33:
        if (r113.hasNext() == false) goto L88;
        Map.Entry<String, String> r114 = r113.next();
        String r115 = r114.getValue();
        if ((r115 instanceof Map) == true) goto L36;
        if ((r115 instanceof Collection) == true) goto L39;
        if ((r115 instanceof Short) == true) goto L42;
        if ((r115 instanceof Integer) == true) goto L49;
        if ((r115 instanceof Long) == true) goto L56;
        if ((r115 instanceof Boolean) == true) goto L63;
        if ((r115 instanceof Float) == true) goto L70;
        if ((r115 instanceof Double) == true) goto L77;
        String r116 = r114.getKey();
        String r117 = r114.getValue();
        if (r117 == null) goto L86;
        String r118 = r117.toString();
        if (r118 == null) goto L86;
    L87:
        r111.putString(r116, r118);
    L86:
        r118 = "";
        goto L87
    L77:
        String r119 = r114.getKey();
        Comparable r120 = r114.getValue();
        if (r120 == null) goto L81;
        r111.putDouble(r119, ((Double) r120).doubleValue());
        goto L33
    L81:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    L70:
        String r121 = r114.getKey();
        Comparable r122 = r114.getValue();
        if (r122 == null) goto L74;
        r111.putFloat(r121, ((Float) r122).floatValue());
        goto L33
    L74:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L63:
        String r123 = r114.getKey();
        Comparable r124 = r114.getValue();
        if (r124 == null) goto L67;
        r111.putBoolean(r123, ((Boolean) r124).booleanValue());
        goto L33
    L67:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L56:
        String r125 = r114.getKey();
        Comparable r126 = r114.getValue();
        if (r126 == null) goto L60;
        r111.putLong(r125, ((Long) r126).longValue());
        goto L33
    L60:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L49:
        String r127 = r114.getKey();
        Comparable r128 = r114.getValue();
        if (r128 == null) goto L53;
        r111.putInt(r127, ((Integer) r128).intValue());
        goto L33
    L53:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L42:
        String r129 = r114.getKey();
        Comparable r130 = r114.getValue();
        if (r130 == null) goto L46;
        r111.putShort(r129, ((Short) r130).shortValue());
        goto L33
    L46:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Short");
    L39:
        r111.putString(r114.getKey(), GsonProtectorUtils.toJson(GsonHelper.get(), r114.getValue()));
        goto L33
    L36:
        r111.putString(r114.getKey(), GsonProtectorUtils.toJson(GsonHelper.get(), r114.getValue()));
    L88:
        r101.putBundle(VSConstants.EXTRA_ENTER_LIVE_EXTRA, r111);
        r101.putAll(r111);
        TTLiveSDK.hostService().action().startLive(getContext(), this.f82782o, r101);
        this.f82776i = true;
        return;
    L26:
        r101.putBoolean(VSConstants.EXTRA_VS_SHARE_VIEW, false);
        this.f82777j = false;
        IReplayPlayerHelper r131 = this.A;
        if (r131 == null) goto L29;
        r131.setReleaseEnable(true);
    L17:
        r107 = null;
        goto L18
    }

    public final void g() {
        if (this.f82776i == true) goto L5;
        b();
    L5:
        IReplayPlayerHelper r100 = this.A;
        if (r100 == null) goto L8;
        r100.release();
    L8:
        this.f82788u = false;
        this.f82785r = true;
        FrameLayout r101 = this.f82771d;
        if (r101 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mVSStreamContainer");
    L11:
        r101.removeAllViews();
        IReplayPlayerHelper r102 = this.A;
        if (r102 == null) goto L14;
        r102.unregisterVideoPlayListener(getContext(), this.E);
    L14:
        IReplayPlayerHelper r103 = this.A;
        if (r103 == null) goto L18;
        r103.removeReplayPlayWrapperListener(getContext(), this.F);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f82784q = true;
        a();
        post(new c(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f82784q = false;
        this.f82786s = true;
    }

    public void setAutoPlay(boolean r100) {
        this.f82773f = r100;
        if (r100 == false) goto L12;
        long r101 = -1;
        Long r102 = -1L;
        if (r102 == null) goto L8;
        r101 = r102.longValue();
    L8:
        if (r101 < 0) goto L10;
        this.f82774g = r102;
    L10:
        c();
        return;
    }

    public void setAutoShowCover(boolean r100) {
        this.f82779l = r100;
    }

    public void setEnableEnterRoom(Boolean r100) {
        this.f82790w = Intrinsics.areEqual(r100, Boolean.TRUE);
    }

    public void setEpisode(Episode r100) {
        Intrinsics.checkNotNullParameter(r100, "episode");
        this.f82781n = r100;
        long r101 = 0;
        if (r100 != null) goto L10;
    L7:
        this.f82782o = r101;
        return;
    L10:
        String r102 = r100.idStr;     // Catch: Exception -> L9
        if (r102 == null) goto L7;
        r101 = CastLongProtector.parseLong(r102);     // Catch: Exception -> L9
        goto L7
    }

    public void setEventChangeListener(Function2<? super String, ? super Map<String, ? extends Object>, Unit> r100) {
        this.f82793z = r100;
    }

    public void setLogExtra(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "logExtra");
        HashMap<String, String> r101 = new HashMap();
        Iterator<Map.Entry<String, Object>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<String, Object> r103 = r102.next();
        if (r103.getValue() == null) goto L4;
        if ((r103.getValue() instanceof JavaOnlyMap) == true) goto L10;
        r101.put(r103.getKey(), String.valueOf(r103.getValue()));
        goto L4
    L10:
        r101.put(r103.getKey(), GsonProtectorUtils.toJson(GsonHelper.get(), r103.getValue()));
        goto L4
    L12:
        this.f82791x = r101;
    }

    public void setMuted(boolean r100) {
        this.f82778k = r100;
        IReplayPlayerHelper r101 = this.A;
        if (r101 == null) goto L6;
        r101.setMute(r100);
        return;
    }

    public void setObjectFit(String r100) {
        Intrinsics.checkNotNullParameter(r100, "objectFit");
        int r101 = 0;
        if (r100.hashCode() == 3143043) goto L6;
    L8:
        boolean r102 = false;
    L9:
        IReplayPlayerHelper r103 = this.A;
        if (r103 == null) goto L17;
        ReplayPlayerConfiger r104 = new ReplayPlayerConfiger();
        if (r102 == false) goto L15;
        r101 = 2;
    L15:
        r104.textureLayout = r101;
        Unit r105 = Unit.INSTANCE;
        r103.setPlayerConfiger(r104);
        return;
    L17:
        return;
    L6:
        if (r100.equals(LynxVideoManagerLite.FILL) == false) goto L8;
        r102 = true;
        goto L9
    }

    public void setPoster(String r100) {
        Intrinsics.checkNotNullParameter(r100, "coverUrl");
        this.f82783p = r100;
    }

    public void setRepeat(boolean r100) {
        this.f82780m = r100;
        IReplayPlayerHelper r101 = this.A;
        if (r101 == null) goto L6;
        r101.setLoop(r100);
        return;
    }

    public void setStartPosition(long r100) {
        this.f82774g = Long.valueOf(r100);
    }

    public static /* synthetic */ void f(ReplayVideoViewForLynx r100, String r101) {
        r100.e(r101, new HashMap());
    }

    public final void e(String r100, Map<String, ? extends Object> r101) {
        if ((!TextUtils.equals(this.f82772e, r100)) == false) goto L5;
    L6:
        Objects.toString(r101);
        this.f82772e = r100;
        Function2<? super String, ? super Map<String, ? extends Object>, Unit> r102 = this.f82793z;
        if (r102 == null) goto L11;
        Unit r103 = r102.invoke(r100, r101);
        return;
    L11:
        return;
    L5:
        if (this.f82792y.contains(r100) == true) goto L6;
    }

    public ReplayVideoViewForLynx(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f82768a = "VPPlayListener";
        this.f82769b = "vs_long_video";
        this.f82770c = "vs_video_center";
        this.f82780m = true;
        this.f82785r = true;
        this.f82786s = true;
        this.f82787t = true;
        this.f82792y = CollectionsKt.listOf("timeupdate");
        b r103 = new b(this);
        this.E = r103;
        a r104 = new a(this);
        this.F = r104;
        FrameLayout r105 = new FrameLayout(getContext());
        this.f82771d = r105;
        r105.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(r105);
        setOnClickListener(new com.bytedance.android.live.lynx.ui.replay.c(this));
        nm1.l r106 = pm1.f.j();
        if (r106 == null) goto L8;
        FrameLayout r107 = this.f82771d;
        if (r107 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mVSStreamContainer");
    L7:
        ReplayVideoPlayerHelper r108 = r106.d(r107);
    L9:
        this.A = r108;
        ReplayPlayerConfiger r109 = new ReplayPlayerConfiger();
        r109.textureLayout = 2;
        r109.useSurfaceView = 2;
        IReplayPlayerHelper r110 = this.A;
        if (r110 == null) goto L12;
        r110.setPlayerConfiger(r109);
    L12:
        this.f82788u = false;
        IReplayPlayerHelper r111 = this.A;
        if (r111 == null) goto L15;
        r111.registerVideoPlayListener(getContext(), r103);
    L15:
        IReplayPlayerHelper r112 = this.A;
        if (r112 == null) goto L18;
        r112.setReplayPlayWrapperListener(getContext(), r104);
    L18:
        IReplayPlayerHelper r113 = this.A;
        if (r113 == null) goto L23;
        MutableLiveData<Integer> r114 = r113.getReplayPaidStatus();
        if (r114 == null) goto L23;
        r114.observeForever(new com.bytedance.android.live.lynx.ui.replay.a(this));
    L23:
        IReplayPlayerHelper r115 = this.A;
        if (r115 == null) goto L29;
        MutableLiveData<Long> r116 = r115.getReplayPaidCountDown();
        if (r116 == null) goto L30;
        r116.observeForever(new com.bytedance.android.live.lynx.ui.replay.b(this));
        return;
    L30:
        return;
    L29:
        return;
    L8:
        r108 = null;
        goto L9
    }

    public /* synthetic */ ReplayVideoViewForLynx(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        a();
    }
}
