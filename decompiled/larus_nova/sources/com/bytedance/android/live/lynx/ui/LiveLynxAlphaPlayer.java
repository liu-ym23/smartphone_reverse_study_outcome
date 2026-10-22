package com.bytedance.android.live.lynx.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.gson.JsonSyntaxException;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.event.EventsListener;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.ugc.aweme.live.alphaplayer.Configuration;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import d76.y;
import java.io.BufferedReader;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0007J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000bH\u0007J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u001a\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007J\u001a\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/lynx/ui/LiveLynxAlphaPlayer;", "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Lcom/bytedance/android/live/lynx/ui/LynxAlphaVideoViewCompat;", "", "src", "", "setSrc", "poster", "setPoster", "lastFrame", "setLastFrame", "", "enable", "setAutoPlay", "setKeepLastFrame", "loop", "setLoop", "Lcom/lynx/react/bridge/ReadableMap;", "params", "Lcom/lynx/react/bridge/Callback;", "callback", "play", "pause", "stop", "getDuration", "isPlaying", "release", "resume", "subscribeUpdateEvent", "unsubscribeUpdateEvent", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLynxAlphaPlayer extends UISimpleView<LynxAlphaVideoViewCompat> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f82670h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IPlayerController f82671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Set<String> f82672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DataSource f82673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f82674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f82675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bitmap f82676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f82677g;

    public interface a {
        void onFailed();

        void onSuccess(Bitmap r100);
    }

    public static final class b {
    }

    public static final class c extends AbsDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLynxAlphaPlayer f82678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f82679b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Uri f82680c;

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onSuccessed(DownloadInfo r100) {
            LLog.i("x-alpha-video", "download resource success, and directUrl is " + this.f82679b);
            LiveLynxAlphaPlayer.N(this.f82678a, this.f82678a.getLynxContext().getApplicationContext().getCacheDir().getAbsolutePath() + '/' + this.f82680c.getLastPathSegment(), this.f82679b);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onFailed(DownloadInfo r100, BaseException r101) {
            String r102 = "download resource failed and resource is " + this.f82679b + ", error msg is " + r101;
            LiveLynxAlphaPlayer r103 = this.f82678a;
            r103.Q(r102, r103.f82677g, -12);
            throw null;
        }

        public c(LiveLynxAlphaPlayer r100, String r101, Uri r102) {
            this.f82678a = r100;
            this.f82679b = r101;
            this.f82680c = r102;
        }
    }

    public static final class d extends BaseBitmapDataSubscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f82681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f82682b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.facebook.datasource.DataSource f82683c;

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onFailureImpl(com.facebook.datasource.DataSource<CloseableReference<CloseableImage>> r100) {
            this.f82681a.onFailed();
            if (r100 == null) goto L5;
            r100.close();
        L5:
            this.f82682b.countDown();
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public final void onNewResultImpl(Bitmap r100) {
            if (this.f82683c.isFinished() == false) goto L9;
            if (r100 == null) goto L9;
            Bitmap.Config r101 = r100.getConfig();
            if (r101 == null) goto L8;
            this.f82681a.onSuccess(r100.copy(r101, true));
        L8:
            this.f82683c.close();
        L9:
            this.f82682b.countDown();
        }

        public d(a r100, CountDownLatch r101, com.facebook.datasource.DataSource r102) {
            this.f82681a = r100;
            this.f82682b = r101;
            this.f82683c = r102;
        }
    }

    public static final class e extends com.lynx.tasm.event.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f82684b;

        @Override // com.lynx.tasm.event.a
        public final Map<String, Object> b() {
            return this.f82684b;
        }

        public e(Map r100, int r101, String r102) {
            this.f82684b = r100;
            super(r101, r102);
        }
    }

    public static final class f<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLynxAlphaPlayer f82685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f82686b;

        public static final class a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f82687a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef f82688b;

            @Override // com.bytedance.android.live.lynx.ui.LiveLynxAlphaPlayer.a
            public final void onFailed() {
                LiveLynxAlphaPlayer r100 = this.f82687a.f82685a;
                DataSource r101 = r100.f82673c;
                if (r101 == null) goto L5;
                r101.f451130g = true;
            L5:
                r100.Q("set video lastFrame failed, lastFrame is " + this.f82687a.f82686b, this.f82687a.f82685a.f82677g, -16);
                throw null;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.android.live.lynx.ui.LiveLynxAlphaPlayer.a
            public final void onSuccess(Bitmap r100) {
                if (r100 == 0) goto L5;
                this.f82688b.element = r100;
                return;
            }

            public a(f r100, Ref.ObjectRef r101) {
                this.f82687a = r100;
                this.f82688b = r101;
            }
        }

        public f(LiveLynxAlphaPlayer r100, String r101) {
            this.f82685a = r100;
            this.f82686b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.Callable
        public final e76.c<Bitmap> call() {
            Ref.ObjectRef r100 = new Ref.ObjectRef();
            r100.element = null;
            this.f82685a.S(this.f82686b, new a(this, r100));
            return new e76.c((Bitmap) r100.element);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class g<T> implements e76.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLynxAlphaPlayer f82689a;

        public g(LiveLynxAlphaPlayer r100) {
            this.f82689a = r100;
        }

        @Override // e76.b
        public final void onResult(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            LiveLynxAlphaPlayer r102 = this.f82689a;
            if (r101 == null) goto L9;
            DataSource r103 = r102.f82673c;
            if (r103 == null) goto L7;
            r103.f451130g = true;
        L7:
            r102.f82676f = r101;
            LiveLynxAlphaPlayer.M(r102).setMLastFrame(r102.f82676f);
            LiveLynxAlphaPlayer.M(r102).setMIsShowLastFrame(true);
            return;
        }
    }

    public static final class h<T> implements e76.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLynxAlphaPlayer f82690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f82691b;

        public h(LiveLynxAlphaPlayer r100, String r101) {
            this.f82690a = r100;
            this.f82691b = r101;
        }

        @Override // e76.b
        public final void onResult(Object r100) {
            Throwable r101 = (Throwable) r100;
            LiveLynxAlphaPlayer r102 = this.f82690a;
            DataSource r103 = r102.f82673c;
            if (r103 == null) goto L5;
            r103.f451130g = true;
        L5:
            r102.Q("set video lastFrame failed, lastFrame is " + this.f82691b + ", error msg is " + r101, this.f82690a.f82677g, -16);
            throw null;
        }
    }

    public static final class i<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLynxAlphaPlayer f82692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f82693b;

        public static final class a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i f82694a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef f82695b;

            @Override // com.bytedance.android.live.lynx.ui.LiveLynxAlphaPlayer.a
            public final void onFailed() {
                this.f82694a.f82692a.Q("set video poster failed, poster is " + this.f82694a.f82693b, this.f82694a.f82692a.f82677g, -15);
                throw null;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.android.live.lynx.ui.LiveLynxAlphaPlayer.a
            public final void onSuccess(Bitmap r100) {
                if (r100 == 0) goto L5;
                this.f82695b.element = r100;
                return;
            }

            public a(i r100, Ref.ObjectRef r101) {
                this.f82694a = r100;
                this.f82695b = r101;
            }
        }

        public i(LiveLynxAlphaPlayer r100, String r101) {
            this.f82692a = r100;
            this.f82693b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.Callable
        public final e76.c<Bitmap> call() {
            Ref.ObjectRef r100 = new Ref.ObjectRef();
            r100.element = null;
            this.f82692a.S(this.f82693b, new a(this, r100));
            return new e76.c((Bitmap) r100.element);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class j<T> implements e76.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLynxAlphaPlayer f82696a;

        public j(LiveLynxAlphaPlayer r100) {
            this.f82696a = r100;
        }

        @Override // e76.b
        public final void onResult(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            LiveLynxAlphaPlayer r102 = this.f82696a;
            if (r101 == null) goto L6;
            LiveLynxAlphaPlayer.M(r102).setMPoster(r101);
            LiveLynxAlphaPlayer.M(r102).setMIsShowPoster(true);
            LiveLynxAlphaPlayer.M(r102).invalidate();
            return;
        }
    }

    public static final class k<T> implements e76.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLynxAlphaPlayer f82697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f82698b;

        public k(LiveLynxAlphaPlayer r100, String r101) {
            this.f82697a = r100;
            this.f82698b = r101;
        }

        @Override // e76.b
        public final void onResult(Object r100) {
            this.f82697a.Q("set video poster failed, poster is " + this.f82698b + ", error msg is " + ((Throwable) r100), this.f82697a.f82677g, -15);
            throw null;
        }
    }

    static {
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        IPlayerController r100 = this.f82671a;
        if (r100 == null) goto L5;
        r100.detachAlphaView((ViewGroup) this.mView);
    L5:
        IPlayerController r101 = this.f82671a;
        if (r101 == null) goto L8;
        r101.g(null);
    L8:
        IPlayerController r102 = this.f82671a;
        if (r102 == null) goto L11;
        r102.c(null);
    L11:
        this.f82671a = null;
        ((LynxAlphaVideoViewCompat) this.mView).setMPoster(null);
        ((LynxAlphaVideoViewCompat) this.mView).setMLastFrame(null);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onAttach() {
        super.onAttach();
        IPlayerController r100 = this.f82671a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f82674d == false) goto L10;
        if (r100 == null) goto L11;
        r100.attachAlphaView((ViewGroup) this.mView);
        return;
    L11:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onDetach() {
        super.onDetach();
        IPlayerController r100 = this.f82671a;
        if (r100 == null) goto L7;
        if (r100 == null) goto L8;
        r100.detachAlphaView((ViewGroup) this.mView);
        return;
    L8:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        IPlayerController r100 = this.f82671a;
        if (r100 == null) goto L8;
        View r101 = r100.getView();
        if (r101 == null) goto L9;
        r101.layout(0, 0, getWidth(), getHeight());
        return;
    L9:
        return;
    }

    public static final /* synthetic */ LynxAlphaVideoViewCompat M(LiveLynxAlphaPlayer r100) {
        return (LynxAlphaVideoViewCompat) r100.mView;
    }

    public final DataSource O(String r100) {
        StringBuilder r101 = new StringBuilder();
        BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper(r100 + ComposerHelper.CONFIG_FILE_NAME));
    L35:
        String r103 = r102.readLine();     // Catch: Throwable -> L28
        if (r103 == null) goto L6;
        r101.append(r103);     // Catch: Throwable -> L28
        r101.append("\n");     // Catch: Throwable -> L28
        goto L35
    L6:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L28
        CloseableKt.closeFinally(r102, null);
        y r105 = (y) GsonProtectorUtils.fromJson(e76.a.f471183a, r101.toString(), y.class);     // Catch: JsonSyntaxException -> L25
        if (r105 == null) goto L23;
        DataSource r106 = new DataSource();
        if (r105.portrait == null) goto L14;
        DataSource.DataInfo r107 = new DataSource.DataInfo(r100 + r105.portrait.path);
        r107.d(r105.portrait.align);
        y.a r108 = r105.portrait;
        r107.f451144j = r108.version;
        r107.f451137c = r108.totalFrame;
        r107.f451140f = r108.videoWidth;
        r107.f451141g = r108.videoHeight;
        r107.f451142h = r108.actualWidth;
        r107.f451143i = r108.actualHeight;
        r107.b(r108.alphaFrame);
        r107.c(r105.portrait.rgbFrame);
        r107.f451145k = r105.portrait.masks;
        r106.c(r107);
    L14:
        if (r105.landscape == null) goto L16;
        DataSource.DataInfo r109 = new DataSource.DataInfo(r100 + r105.landscape.path);
        r109.d(r105.landscape.align);
        y.a r110 = r105.landscape;
        r109.f451144j = r110.version;
        r109.f451137c = r110.totalFrame;
        r109.f451140f = r110.videoWidth;
        r109.f451141g = r110.videoHeight;
        r109.f451142h = r110.actualWidth;
        r109.f451143i = r110.actualHeight;
        r109.b(r110.alphaFrame);
        r109.c(r105.landscape.rgbFrame);
        r109.f451145k = r105.landscape.masks;
        r106.b(r109);
    L16:
        Object r111 = getProps().get("keep-last-frame");
        Boolean r112 = Boolean.TRUE;
        if (Intrinsics.areEqual(r111, r112) == false) goto L20;
        r106.f451130g = false;
    L20:
        if (Intrinsics.areEqual(getProps().get("loop"), r112) == false) goto L22;
        r106.f451127d = true;
    L22:
        return r106;
    L23:
        Q("fileModel is null", this.f82677g, -14);
        throw null;
    L25:
        e = move-exception;
        Q("parse config.json failed, error msg is " + e, this.f82677g, -3);
        throw null;
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    }

    public final void R(String r100) {
        LLog.i("x-alpha-video", "legacySetSrc, directUrl is " + r100);     // Catch: Exception -> L42
        if (r100 == null) goto L52;
        Uri r101 = UriProtector.parse(r100);     // Catch: Exception -> L42
        this.f82673c = null;     // Catch: Exception -> L42
        String r102 = r101.getScheme();     // Catch: Exception -> L42
        if (r102 == null) goto L41;
        int r103 = r102.hashCode();     // Catch: Exception -> L42
        if (r103 == 3143036) goto L26;
        if (r103 == 3213448) goto L19;
        if (r103 == 99617003) goto L16;
        return;
    L16:
        if (r102.equals("https") == true) goto L21;
        return;
    L21:
        if (StringsKt.endsWith$default(r100, ".zip", false, 2, null) == false) goto L23;
        Downloader.with(getLynxContext()).url(r100).name(r101.getLastPathSegment()).savePath(getLynxContext().getApplicationContext().getCacheDir().getAbsolutePath()).monitorScene("live_gift_lynx_alpha_player").mainThreadListener(new c(this, r100, r101)).download();     // Catch: Exception -> L42
        return;
    L23:
        Q("resource type is not support", this.f82677g, -13);     // Catch: Exception -> L42
        throw null;     // Catch: Exception -> L42
    L19:
        if (r102.equals("http") == true) goto L21;
        return;
    L26:
        if (r102.equals("file") == false) goto L51;
        this.f82673c = O(r101.getPath() + '/');     // Catch: Exception -> L38
        sendEvent("ready", P(1, "load resource success", null));     // Catch: Exception -> L38
        if (this.f82673c != null) goto L30;
        return;
    L30:
        if (this.f82674d == false) goto L55;
        IPlayerController r104 = this.f82671a;     // Catch: Exception -> L38
        if (r104 == null) goto L34;
        r104.attachAlphaView((ViewGroup) this.mView);     // Catch: Exception -> L38
    L34:
        IPlayerController r105 = this.f82671a;     // Catch: Exception -> L38
        if (r105 == null) goto L56;
        r105.d(this.f82673c);     // Catch: Exception -> L38
    L57:
        return;
    L56:
        return;
    L55:
        return;
    L38:
        e = move-exception;
        Q("parse config.json failed, resource is " + r100 + ", error msg is " + e, this.f82677g, -3);     // Catch: Exception -> L42
        throw null;     // Catch: Exception -> L42
    L51:
        return;
    L41:
        return;
    L52:
        return;
    L42:
        e = move-exception;
        LLog.e("x-alpha-video", e.toString());
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        LynxAlphaVideoViewCompat r101 = new LynxAlphaVideoViewCompat(r100);
        Configuration r102 = new Configuration();
        r102.f451007a = r100;
        r102.f451008b = r101;
        r102.f451009c = 1;
        com.bytedance.android.live.lynx.ui.d r103 = new com.bytedance.android.live.lynx.ui.d(this);
        com.bytedance.android.live.lynx.ui.e r104 = new com.bytedance.android.live.lynx.ui.e(this);
        IPlayerController r105 = ((IGiftServiceExternal) jc1.k.n(IGiftServiceExternal.class)).getCommonPlayerControllerManager().a(r100);     // Catch: Exception -> L14
        this.f82671a = r105;
        if (r105 == null) goto L7;
        r105.g(r103);
    L7:
        IPlayerController r106 = this.f82671a;
        if (r106 == null) goto L10;
        r106.c(r104);
    L10:
        IPlayerController r107 = this.f82671a;
        if (r107 == null) goto L13;
        r107.b(new com.bytedance.android.live.lynx.ui.c(this), 5);
    L13:
        return r101;
    L14:
        e = move-exception;
        Q("init CustomPlayerImpl failed and try to use DefaultSystemPlayer, the exception is " + e, this.f82677g, -10);
        throw null;
    }

    @LynxProp(defaultBoolean = true, name = "autoplay")
    public final void setAutoPlay(boolean r100) {
        this.f82674d = r100;
        T r101 = this.mView;
        if (r101 == 0) goto L7;
        ((LynxAlphaVideoViewCompat) r101).setMAutoPlay(r100);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.lynx.ui.LynxAlphaVideoViewCompat");
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r100) {
        super.setEvents(r100);
        if (r100 == null) goto L5;
        Set<String> r101 = r100.keySet();
    L6:
        this.f82672b = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    @LynxProp(defaultBoolean = false, name = "keep-last-frame")
    public final void setKeepLastFrame(boolean r100) {
        if (this.f82675e == r100) goto L9;
        DataSource r101 = this.f82673c;
        if (r101 == null) goto L7;
        r101.f451130g = !r100;
    L7:
        this.f82675e = r100;
        return;
    }

    @LynxProp(name = "last-frame")
    public final void setLastFrame(String r100) {
        Intrinsics.checkNotNullParameter(r100, "lastFrame");
        e76.e r101 = new e76.e(new f(this, r100));
        r101.c(new g(this));
        r101.b(new h(this, r100));
    }

    @LynxProp(defaultBoolean = false, name = "loop")
    public final void setLoop(boolean r100) {
        DataSource r101 = this.f82673c;
        if (r101 == null) goto L6;
        r101.f451127d = r100;
        return;
    }

    @LynxProp(name = "poster")
    public final void setPoster(String r100) {
        Intrinsics.checkNotNullParameter(r100, "poster");
        e76.e r101 = new e76.e(new i(this, r100));
        r101.c(new j(this));
        r101.b(new k(this, r100));
    }

    @LynxProp(name = "src")
    public final void setSrc(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        IPlayerController r101 = this.f82671a;
        if (r101 == null) goto L8;
        r101.detachAlphaView((ViewGroup) this.mView);
    L8:
        this.f82673c = null;
        this.f82677g = "";
        String r102 = URLDecoder.decode(d7a.a.b(getLynxContext(), r100, false), "UTF-8");
        this.f82677g = r102;
        R(r102);
    }

    public final void S(String r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "callback");
        ImageRequest r102 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(d7a.a.b(getLynxContext(), r100, false))).build();
        com.facebook.datasource.DataSource<CloseableReference<CloseableImage>> r103 = Fresco.getImagePipeline().fetchDecodedImage(r102, "x-alpha-video");
        if (r103 != null) goto L6;
        r101.onFailed();
        return;
    L6:
        CountDownLatch r104 = new CountDownLatch(1);
        d r105 = new d(r101, r104, r103);
        r103.subscribe(r105, CallerThreadExecutor.getInstance());
    L11:
        r105.onFailure(r103);
        return;
    L8:
        if (r104.await(3, TimeUnit.SECONDS) == true) goto L15;
        r105.onFailure(r103);     // Catch: InterruptedException -> L11
        return;
    }

    @LynxUIMethod
    public final void getDuration(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        JavaOnlyMap r102 = new JavaOnlyMap();
        if (this.mView != 0) goto L5;
    L14:
        r102.putString("message", "view is not exist");
        r101.invoke(new Object[]{1, r102});
        return;
    L5:
        if (this.f82671a == null) goto L14;
        r102.putBoolean("success", true);     // Catch: Exception -> L12
        IPlayerController r103 = this.f82671a;     // Catch: Exception -> L12
        if (r103 == null) goto L9;
        int r104 = r103.getDuration();     // Catch: Exception -> L12
    L10:
        JavaOnlyMap r105 = new JavaOnlyMap();     // Catch: Exception -> L12
        r105.putInt("duration", r104);     // Catch: Exception -> L12
        r102.putMap("data", r105);     // Catch: Exception -> L12
        r101.invoke(new Object[]{0, r102});     // Catch: Exception -> L12
        return;
    L9:
        r104 = 0;
    L12:
        e = move-exception;
        r102.putString("message:", e.getMessage());
        r101.invoke(new Object[]{1, r102});
    }

    @LynxUIMethod
    public final void isPlaying(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        JavaOnlyMap r102 = new JavaOnlyMap();
        if (this.mView != 0) goto L5;
    L16:
        r102.putString("message", "view is not exist");
        r101.invoke(new Object[]{1, r102});
        return;
    L5:
        if (this.f82671a == null) goto L16;
        r102.putBoolean("success", true);     // Catch: Exception -> L14
        IPlayerController r103 = this.f82671a;     // Catch: Exception -> L14
        if (r103 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        JavaOnlyMap r105 = new JavaOnlyMap();     // Catch: Exception -> L14
        r105.putBoolean("isPlaying", r104);     // Catch: Exception -> L14
        r102.putMap("data", r105);     // Catch: Exception -> L14
        r101.invoke(new Object[]{0, r102});     // Catch: Exception -> L14
        return;
    L9:
        if (r103.isPlaying() != true) goto L11;
        r104 = true;
    L14:
        e = move-exception;
        r102.putString("message:", e.getMessage());
        r101.invoke(new Object[]{1, r102});
    }

    @LynxUIMethod
    public final void pause(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        JavaOnlyMap r102 = new JavaOnlyMap();
        if (this.mView == 0) goto L13;
        IPlayerController r103 = this.f82671a;
        if (r103 == null) goto L13;
        if (r103 != null) goto L15;
    L10:
        r101.invoke(new Object[]{0, r102});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        r102.putString("message:", e.getMessage());
        r101.invoke(new Object[]{1, r102});
        return;
    L15:
        r103.pause();     // Catch: Exception -> L8
    L13:
        r102.putString("message", "view is not exist");
        r101.invoke(new Object[]{1, r102});
    }

    @LynxUIMethod
    public final void play(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        JavaOnlyMap r102 = new JavaOnlyMap();
        if (this.mView == 0) goto L23;
        IPlayerController r103 = this.f82671a;
        if (r103 == null) goto L23;
        if (r103 != null) goto L25;
    L20:
        r101.invoke(new Object[]{1, r102});     // Catch: Exception -> L18
        return;
    L25:
    L18:
        e = move-exception;
        r102.putString("message:", e.getMessage());
        r101.invoke(new Object[]{1, r102});
        return;
    L8:
        if (r103.isPlaying() == true) goto L20;
        if (this.f82673c == null) goto L20;
        IPlayerController r104 = this.f82671a;     // Catch: Exception -> L18
        if (r104 == null) goto L14;
        r104.attachAlphaView((ViewGroup) this.mView);     // Catch: Exception -> L18
    L14:
        IPlayerController r105 = this.f82671a;     // Catch: Exception -> L18
        if (r105 == null) goto L17;
        r105.d(this.f82673c);     // Catch: Exception -> L18
    L17:
        r101.invoke(new Object[]{0, r102});     // Catch: Exception -> L18
        return;
    L23:
        r102.putString("message", "view is not exist");
        r101.invoke(new Object[]{1, r102});
    }

    @LynxUIMethod
    public final void release(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        JavaOnlyMap r102 = new JavaOnlyMap();
        r102.putBoolean("success", true);
        r102.putMap("data", new JavaOnlyMap());
        if (this.mView != 0) goto L5;
    L10:
        r102.putString("message", "view is not exist");
        r101.invoke(new Object[]{1, r102});
        return;
    L5:
        if (this.f82671a == null) goto L10;
        r101.invoke(new Object[]{0, r102});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        r102.putString("message:", e.getMessage());
        r101.invoke(new Object[]{1, r102});
    }

    @LynxUIMethod
    public final void resume(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        JavaOnlyMap r102 = new JavaOnlyMap();
        r102.putBoolean("success", true);
        r102.putMap("data", new JavaOnlyMap());
        if (this.mView == 0) goto L18;
        IPlayerController r103 = this.f82671a;
        if (r103 == null) goto L18;
        if (r103.isPlaying() == true) goto L18;
        IPlayerController r104 = this.f82671a;     // Catch: Exception -> L16
        if (r104 == null) goto L11;
        r104.attachAlphaView((ViewGroup) this.mView);     // Catch: Exception -> L16
    L11:
        IPlayerController r105 = this.f82671a;     // Catch: Exception -> L16
        if (r105 == null) goto L14;
        r105.resume();     // Catch: Exception -> L16
    L14:
        r101.invoke(new Object[]{0, r102});     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        r102.putString("message:", e.getMessage());
        r101.invoke(new Object[]{1, r102});
        return;
    L18:
        r102.putString("message", "view is not exist");
        r101.invoke(new Object[]{1, r102});
    }

    public final void sendEvent(String r100, Map<String, Object> r101) {
        Set<String> r102 = this.f82672b;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.contains(r100) != true) goto L16;
        LynxContext r103 = getLynxContext();
        if (r103 == null) goto L14;
        EventEmitter r104 = r103.getEventEmitter();
        if (r104 == null) goto L15;
        r104.sendCustomEvent(new e(r101, getSign(), r100));
        return;
    L15:
        return;
    L14:
        return;
    }

    @LynxUIMethod
    public final void stop(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        JavaOnlyMap r102 = new JavaOnlyMap();
        if (this.mView == 0) goto L13;
        IPlayerController r103 = this.f82671a;
        if (r103 == null) goto L13;
        if (r103 != null) goto L15;
    L10:
        r101.invoke(new Object[]{0, r102});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        r102.putString("message:", e.getMessage());
        r101.invoke(new Object[]{1, r102});
        return;
    L15:
        r103.stop();     // Catch: Exception -> L8
    L13:
        r102.putString("message", "view is not exist");
        r101.invoke(new Object[]{1, r102});
    }

    @LynxUIMethod
    public final void subscribeUpdateEvent(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        LLog.i("x-alpha-video", "subscribeUpdateEvent: " + r100.getInt("ms"));
        throw null;
    }

    @LynxUIMethod
    public final void unsubscribeUpdateEvent(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        r100.getInt("ms");
        throw null;
    }

    public static final void N(LiveLynxAlphaPlayer r100, String r101, String r102) {
        r100.getClass();
        e76.e r103 = new e76.e(new com.bytedance.android.live.lynx.ui.f(r100, r101, r102));
        r103.c(new com.bytedance.android.live.lynx.ui.g(r100));
        r103.b(new com.bytedance.android.live.lynx.ui.h(r100));
    }

    public final Map<String, Object> P(int r100, String r101, JavaOnlyMap r102) {
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("code", Integer.valueOf(r100));
        r103.put("msg", r101);
        return r103;
    }

    public final void Q(String r100, String r101, int r102) {
        sendEvent("error", P(r102, r100, null));
        throw null;
    }
}
