package com.bytedance.android.livesdk.ktvimpl.mv;

import android.content.Context;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer;
import com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.IPreLoaderItemCallBackListener;
import com.ss.ttvideoengine.PreLoaderItemCallBackInfo;
import com.ss.ttvideoengine.PreloaderVidItem;
import com.ss.ttvideoengine.PreloaderVidItemListener;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.SeekCompletionListener;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.ss.ttvideoengine.VideoInfoListener;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.utils.Error;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes10.dex */
public final class KtvMvPlayer extends com.bytedance.android.livesdk.ktvapi.model.mv.h<KtvMvPlayer> implements com.bytedance.android.live.ktv.common.util.c {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f145955g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f145956h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f145957i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f145958j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function1<? super Integer, Unit> f145959k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function2<? super Boolean, ? super Long, Unit> f145960l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f145961m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Long f145962n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f145963o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function1<? super Integer, Unit> f145964p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList<Function1<Integer, Unit>> f145965q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ArrayList<Function1<com.bytedance.android.livesdk.ktvapi.model.mv.n, Unit>> f145966r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final g f145967s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b f145968t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final CopyOnWriteArrayList<String> f145969u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final d f145970v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final c f145971w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f145972x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Disposable f145973y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f145974z;

    public static final class a {
    }

    public static final class b extends w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMvPlayer f145975a;

        public b(KtvMvPlayer r100) {
            this.f145975a = r100;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final void onError(Error r100) {
            com.bytedance.android.live.ktv.common.util.g.d("onError:" + r100);
            Disposable r101 = this.f145975a.f145973y;
            if (r101 == null) goto L5;
            r101.dispose();
        L5:
            KtvMvPlayer r102 = this.f145975a;
            String r103 = null;
            r102.f145955g = null;
            IMediaPlayer.OnErrorListener<AbsPlayer<T>> r104 = r102.f451187e;
            if (r104 == 0) goto L18;
            int r105 = 0;
            if (r100 == null) goto L10;
            int r106 = r100.code;
        L11:
            if (r100 == null) goto L13;
            r105 = r100.internalCode;
        L13:
            StringBuilder r107 = new StringBuilder("play error:");
            if (r100 == null) goto L16;
            r103 = r100.description;
        L16:
            r107.append(r103);
            r104.a(r102, r106, r105, r107.toString());
            return;
        L10:
            r106 = 0;
            goto L11
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final void onPrepare(TTVideoEngine r100) {
            com.bytedance.android.live.ktv.common.util.g.d("onPrepare");
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final void onPrepared(TTVideoEngine r100) {
            com.bytedance.android.live.ktv.common.util.g.d("onPrepared");
            KtvMvPlayer r101 = this.f145975a;
            IMediaPlayer.OnPreparedListener<AbsPlayer<T>> r102 = r101.f451186d;
            if (r102 == 0) goto L5;
            r102.a(r101);
        L5:
            if (r100 == null) goto L10;
            int r103 = r100.getDuration();
            Iterator<Function1<com.bytedance.android.livesdk.ktvapi.model.mv.n, Unit>> r104 = this.f145975a.f145966r.iterator();
        L8:
            if (r104.hasNext() == false) goto L12;
            r104.next().invoke(new com.bytedance.android.livesdk.ktvapi.model.mv.n(r103));
            goto L8
        L12:
            return;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.mv.w, com.ss.ttvideoengine.VideoEngineCallback
        public final void onRenderStart(TTVideoEngine r100) {
            Long r101 = this.f145975a.f145962n;
            if (r101 == null) goto L5;
            com.bytedance.android.live.ktv.common.util.g.d("render duration:" + (System.currentTimeMillis() - r101.longValue()));
        L5:
            StringBuilder r102 = new StringBuilder("onRenderStart, vid: ");
            if (r100 == null) goto L8;
            String r103 = r100.getVideoID();
        L9:
            r102.append(r103);
            com.bytedance.android.live.ktv.common.util.g.d(r102.toString());
            KtvMvPlayer r104 = this.f145975a;
            IMediaPlayer.OnFirstFrameListener<AbsPlayer<T>> r105 = r104.f451188f;
            if (r105 == 0) goto L12;
            r105.a(r104);
        L12:
            this.f145975a.t();
            return;
        L8:
            r103 = null;
            goto L9
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.bytedance.android.livesdk.ktvimpl.mv.w, com.ss.ttvideoengine.VideoEngineCallback
        public final void onVideoStatusException(int r100) {
            com.bytedance.android.live.ktv.common.util.g.d("onVideoStatusException:" + r100);
            Disposable r101 = this.f145975a.f145973y;
            if (r101 == null) goto L5;
            r101.dispose();
        L5:
            KtvMvPlayer r102 = this.f145975a;
            r102.f145955g = null;
            IMediaPlayer.OnErrorListener<AbsPlayer<T>> r103 = r102.f451187e;
            if (r103 == 0) goto L9;
            r103.a(r102, r100, r100, "onVideoStatusException");
            return;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.mv.w, com.ss.ttvideoengine.VideoEngineCallback
        public final void onBufferingUpdate(TTVideoEngine r100, int r101) {
            if (r101 != 100) goto L6;
            com.bytedance.android.live.ktv.common.util.g.d("onBufferingUpdate" + r101);
            return;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.mv.w, com.ss.ttvideoengine.VideoEngineCallback
        public final void onFrameDraw(int r100, Map<Object, Object> r101) {
            Function2<? super Boolean, ? super Long, Unit> r102 = this.f145975a.f145960l;
            if (r102 == null) goto L8;
            if (r102 == null) goto L6;
            Unit r103 = r102.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
        L6:
            this.f145975a.f145960l = null;
            return;
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final void onPlaybackStateChanged(TTVideoEngine r100, int r101) {
            com.bytedance.android.live.ktv.common.util.g.d("onPlaybackStateChanged:" + r101);
            if (r101 != 0) goto L7;
            KtvMvPlayer r102 = this.f145975a;
            IMediaPlayer.OnCompletionListener<AbsPlayer<T>> r103 = r102.f451185c;
            if (r103 == 0) goto L7;
            r103.a(r102);
        L7:
            Function1<? super Integer, Unit> r104 = this.f145975a.f145959k;
            if (r104 == null) goto L11;
            Unit r105 = r104.invoke(Integer.valueOf(r101));
            return;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.mv.w, com.ss.ttvideoengine.VideoEngineCallback
        public final void onVideoURLRouteFailed(Error r100, String r101) {
            this.f145975a.f145955g = null;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.mv.w, com.ss.ttvideoengine.VideoEngineCallback
        public final void onBufferStart(int r100, int r101, int r102) {
            com.bytedance.android.live.ktv.common.util.g.d("onBufferStart");
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.mv.w, com.ss.ttvideoengine.VideoEngineCallback
        public final void onFrameAboutToBeRendered(TTVideoEngine r100, int r101, long r102, long r103, Map<Integer, String> r104) {
            Function2<? super Boolean, ? super Long, Unit> r105 = this.f145975a.f145960l;
            if (r105 == null) goto L8;
            if (r105 == null) goto L6;
            Unit r106 = r105.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
        L6:
            this.f145975a.f145960l = null;
            return;
        }
    }

    public static final class c implements VideoEngineInfoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f145976a = null;

        static {
            f145976a = new c();
        }

        public c() {
        }

        @Override // com.ss.ttvideoengine.VideoEngineInfoListener
        public final void onVideoEngineInfos(VideoEngineInfos r100) {
            if (r100 == null) goto L4;
            String r101 = r100.getKey();
        L6:
            if (Intrinsics.areEqual(r101, VideoEngineInfos.USING_MDL_HIT_CACHE_SIZE) == false) goto L9;
            com.bytedance.android.live.ktv.common.util.g.d("usingKey: " + r100.getUsingMDLPlayTaskKey() + ",hitCacheSize:" + r100.getUsingMDLHitCacheSize() + ", usingPath:" + r100.getmUsingMDLPlayFilePath());
            return;
        L9:
            return;
        L4:
            r101 = null;
            goto L6
        }
    }

    public static final class d implements VideoInfoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f145977a = null;

        static {
            f145977a = new d();
        }

        public d() {
        }

        @Override // com.ss.ttvideoengine.VideoInfoListener
        public final boolean onFetchedVideoInfo(VideoModel r100) {
            com.bytedance.android.live.ktv.common.util.g.d(r100.toString());
            return false;
        }
    }

    public static final class e implements IPreLoaderItemCallBackListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMvPlayer f145978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u f145979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IPreLoaderItemCallBackListener f145980c;

        public e(KtvMvPlayer r100, u r101, IPreLoaderItemCallBackListener r102) {
            this.f145978a = r100;
            this.f145979b = r101;
            this.f145980c = r102;
        }

        @Override // com.ss.ttvideoengine.IPreLoaderItemCallBackListener
        public final void preloadItemInfo(PreLoaderItemCallBackInfo r100) {
            StringBuilder r101 = new StringBuilder("preload callback key:id:");
            r101.append(this.f145979b.f146203a);
            r101.append(HttpClient.ENDFLAG);
            String r102 = null;
            if (r100 == null) goto L5;
            Integer r103 = Integer.valueOf(r100.getKey());
        L6:
            r101.append(r103);
            com.bytedance.android.live.ktv.common.util.g.d(r101.toString());
            IPreLoaderItemCallBackListener r104 = this.f145980c;
            if (r104 == null) goto L9;
            r104.preloadItemInfo(r100);
        L9:
            if (r100 != null) goto L11;
        L19:
            if (r100 != null) goto L21;
        L26:
            if (r100 != null) goto L28;
            return;
        L28:
            if (r100.getKey() != 3) goto L34;
            com.bytedance.android.live.ktv.common.util.g.d("preload error " + r100.preloadError);
            u r105 = this.f145979b;
            v r106 = r105.f146206d;
            this.f145978a.f145969u.remove(r105.f146203a);
            return;
        L34:
            return;
        L21:
            if (r100.getKey() != 6) goto L26;
            StringBuilder r107 = new StringBuilder("preload info:");
            DataLoaderHelper.DataLoaderTaskProgressInfo r108 = r100.preloadDataInfo;
            if (r108 == null) goto L25;
            r102 = r108.mLocalFilePath;
        L25:
            r107.append(r102);
            com.bytedance.android.live.ktv.common.util.g.d(r107.toString());
            com.bytedance.android.live.ktv.common.util.g.d("preload info,size:" + r100.videoPreloadSize);
            return;
        L11:
            if (r100.getKey() != 2) goto L19;
            String r109 = this.f145979b.f146203a;
            DataLoaderHelper.DataLoaderTaskProgressInfo r110 = r100.preloadDataInfo;
            if (r110 == null) goto L16;
            r102 = r110.mVideoId;
        L16:
            if (Intrinsics.areEqual(r109, r102) == false) goto L18;
            v r111 = this.f145979b.f146206d;
        L18:
            com.bytedance.android.live.ktv.common.util.g.d("preload success:" + this.f145979b.f146206d);
            this.f145978a.f145969u.remove(this.f145979b.f146203a);
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class f implements PreloaderVidItemListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMvPlayer f145981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u f145982b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IPreLoaderItemCallBackListener f145983c;

        @Override // com.ss.ttvideoengine.PreloaderVidItemListener
        public final void onUsingUrlInfos(List<VideoInfo> r100) {
            if (r100 != null) goto L4;
        L7:
            com.bytedance.android.live.ktv.common.util.g.e("onUsingUrlInfos url is null");
            return;
        L4:
            if (r100.isEmpty() != true) goto L7;
        }

        @Override // com.ss.ttvideoengine.PreloaderVidItemListener
        public final String authString(String r100, int r101) {
            String r102 = this.f145982b.f146204b;
            if (r102 != null) goto L6;
            return "";
        L6:
            return r102;
        }

        public f(KtvMvPlayer r100, u r101, IPreLoaderItemCallBackListener r102) {
            this.f145981a = r100;
            this.f145982b = r101;
            this.f145983c = r102;
        }

        @Override // com.ss.ttvideoengine.PreloaderVidItemListener
        public final String apiString(Map<String, String> r100, String r101, int r102) {
            KtvMvPlayer r103 = this.f145981a;
            String r104 = this.f145982b.f146204b;
            r103.getClass();
            return String.format("https://open.bytedanceapi.com/?%s", new Object[]{r104});
        }
    }

    public static final class g implements SeekCompletionListener {
        public g() {
        }

        @Override // com.ss.ttvideoengine.SeekCompletionListener
        public final void onCompletion(boolean r100) {
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMvPlayer f145984a;

        public h(KtvMvPlayer r100) {
            this.f145984a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            KtvMvPlayer r102 = this.f145984a;
            Function1<? super Integer, Unit> r103 = r102.f145964p;
            if (r103 == null) goto L6;
            Unit r104 = r103.invoke(Integer.valueOf(r102.o().getCurrentPlaybackTime()));
            return;
        }
    }

    static {
    }

    public final TTVideoEngine o() {
        return (TTVideoEngine) this.f145972x.getValue();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void release() {
        Disposable r100 = this.f145973y;
        if (r100 == null) goto L6;
        r100.dispose();
    L6:
        if (KtvSettingHelper.r().booleanValue() == false) goto L8;
        o().setSurfaceHolder(null);
    L8:
        o().setVideoEngineCallback(null);
        o().setDataSource(new k());
        o().release();
        this.f145965q.clear();
        this.f145966r.clear();
        if (this.f145958j == false) goto L14;
        ArrayList r101 = new ArrayList(this.f145969u);
        this.f145969u.clear();
        Iterator r102 = r101.iterator();
    L12:
        if (r102.hasNext() == false) goto L16;
        TTVideoEngine.cancelPreloadTaskByVideoId((String) r102.next());
        goto L12
    L16:
        return;
    }

    public final void t() {
        Disposable r100 = this.f145973y;
        if (r100 == null) goto L6;
        r100.dispose();
    L6:
        if (KtvSettingHelper.z() == true) goto L8;
    L10:
        this.f145973y = du2.a.b(0, 500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this));
        return;
    L8:
        if (this.f145965q.isEmpty() == false) goto L10;
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.h
    public final int h() {
        return o().getDuration();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final boolean isPlaying() {
        if (o().getPlaybackState() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final String n() {
        return o().getVideoID();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void pause() {
        o().pause();
        Disposable r100 = this.f145973y;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public final void r() {
        if (n() == null) goto L10;
        if (n().length() <= 0) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == false) goto L10;
    L11:
        o().play();
        t();
        return;
    L7:
        r100 = false;
    L10:
        if (o().isPrepared() == true) goto L11;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void start() {
        o().play();
        t();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void stop() {
        o().stop();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void b() {
        o();
    }

    @Override // com.bytedance.android.live.ktv.common.util.c
    public final Function2<Boolean, Long, Unit> getOneDrawCallback() {
        return this.f145960l;
    }

    @Override // com.bytedance.android.live.ktv.common.util.b
    public final String getTypeName() {
        return this.f145961m;
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.h
    public final void j() {
        r();
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.h
    public final void i(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        this.f145965q.remove(r100);
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.h
    public final void k(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        this.f145965q.add(r100);
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.h
    public final void l(Function1<? super com.bytedance.android.livesdk.ktvapi.model.mv.n, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        this.f145966r.add(r100);
    }

    public final void m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "vId");
        if (this.f145969u.contains(r100) == true) goto L5;
        return;
    L5:
        if (this.f145958j == false) goto L9;
        com.bytedance.android.live.ktv.common.util.g.d("cancelPreload");
        TTVideoEngine.cancelPreloadTaskByVideoId(r100);
        this.f145969u.remove(r100);
        return;
    }

    public final void q(t r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        com.bytedance.android.live.ktv.common.util.g.d("requestPlay：" + r100);
        String r101 = r100.f146202c;
        if (TextUtils.isEmpty(r101) == false) goto L5;
        o().setDirectURL(r100.f146200a);
    L11:
        this.f145955g = r100.f146200a;
        this.f145962n = Long.valueOf(System.currentTimeMillis());
        o().play();
        return;
    L5:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        if (r102.exists() == false) goto L13;
    L10:
        o().setDirectUrlUseDataLoader(r100.f146200a, r100.f146201b);
        goto L11
    L13:
        r102.mkdirs();     // Catch: Exception -> L9
    L9:
        com.bytedance.android.live.ktv.common.util.g.e("mkdirs mv file fail");
        goto L10
    }

    public final void s(SurfaceHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        o().setSurfaceHolder(r100);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void seekTo(int r100) {
        o().seekTo(r100, this.f145967s);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void setDataSource(String r100) {
        o().setDirectURL(r100);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void setLooping(boolean r100) {
        o().setLooping(r100);
    }

    @Override // com.bytedance.android.live.ktv.common.util.c
    public final void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r100) {
        this.f145960l = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void setSurface(Surface r100) {
        o().setSurface(r100);
    }

    public final void u(int r100) {
        com.bytedance.android.live.ktv.common.util.g.d("updateScaleType:" + r100 + HttpClient.ENDFLAG + this.f145956h);
        if (this.f145956h == r100) goto L6;
        this.f145956h = r100;
        o().setIntOption(4, r100);
        return;
    }

    public KtvMvPlayer(final Context r100, final HashMap<Integer, Integer> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f145956h = 2;
        ReadOnlyProperty r102 = vm2.h.f556261w2;
        KProperty<?>[] r103 = vm2.h.f556082a;
        this.f145957i = ((Number) r102.getValue(null, r103[177(0xb1, float:2.48E-43)])).intValue();
        this.f145958j = ((Boolean) vm2.h.f556159j4.getValue(null, r103[268(0x10c, float:3.76E-43)])).booleanValue();
        this.f145961m = KtvSubElement.MV;
        this.f145963o = ((Boolean) vm2.h.f556167k4.getValue(null, r103[269(0x10d, float:3.77E-43)])).booleanValue();
        this.f145964p = new KtvMvPlayer$progressCallback$1(this);
        this.f145965q = new ArrayList();
        this.f145966r = new ArrayList();
        this.f145967s = new g();
        this.f145968t = new b(this);
        this.f145969u = new CopyOnWriteArrayList();
        this.f145970v = d.f145977a;
        this.f145971w = c.f145976a;
        this.f145972x = LazyKt.lazy(new KtvMvPlayer$videoEngine$2(this, r100, r101));
        this.f145974z = ((Boolean) vm2.h.Y1.getValue(null, r103[153(0x99, float:2.14E-43)])).booleanValue();
    }

    public final PreloaderVidItem p(u r100, Long r110, IPreLoaderItemCallBackListener r111) {
        Intrinsics.checkNotNullParameter(r100, "request");
        if (TTVideoEngine.dataLoaderIsRunning() == false) goto L16;
    L7:
        String r101 = r100.f146203a;
        Resolution r102 = Resolution.High;
        if (r110 == null) goto L10;
        long r103 = r110.longValue();
    L11:
        PreloaderVidItem r104 = new PreloaderVidItem(r101, r102, r103, false);
        r104.mApiVersion = 2;
        r104.setCallBackListener(new e(this, r100, r111));
        r104.mListener = new f(this, r100, r111);
        if (r100.f146206d != null) goto L14;
        r100.f146206d = new v(r100.f146203a);
    L14:
        this.f145969u.add(r100.f146203a);
        TTVideoEngine.addTask(r104);
        return r104;
    L10:
        r103 = ((long) this.f145957i) * 1024;
        goto L11
    L16:
        TTVideoEngine.startDataLoader(this.f451184b.getApplicationContext());     // Catch: Exception -> L6
    L6:
        com.bytedance.android.live.ktv.common.util.g.e("checkMDLLaunch fail");
        goto L7
    }
}
