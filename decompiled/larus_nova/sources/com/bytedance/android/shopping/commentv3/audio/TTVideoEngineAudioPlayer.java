package com.bytedance.android.shopping.commentv3.audio;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.bytedance.android.shopping.api.video.AVScene;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineListener;
import com.ss.ttvideoengine.utils.Error;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class TTVideoEngineAudioPlayer implements k, VideoEngineListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f172600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f172601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f172602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f172603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f172604e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TTVideoEngine f172605f;

    public static final class a {
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f172606a;

        public b(Function0 r100) {
            this.f172606a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f172606a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final void onBufferingUpdate(TTVideoEngine r100, int r101) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final /* synthetic */ void onFirstAVSyncFrame(TTVideoEngine r100) {
        VideoEngineListener.CC.$default$onFirstAVSyncFrame(this, r100);
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final void onLoadStateChanged(TTVideoEngine r100, int r101) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final void onPlaybackStateChanged(TTVideoEngine r100, int r101) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final void onPrepare(TTVideoEngine r100) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final /* synthetic */ void onRefreshSurface(TTVideoEngine r100) {
        VideoEngineListener.CC.$default$onRefreshSurface(this, r100);
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final void onRenderStart(TTVideoEngine r100) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final /* synthetic */ int onSetSurface(TTVideoEngine r100, VideoSurface r101, Surface r102) {
        return VideoEngineListener.CC.$default$onSetSurface(this, r100, r101, r102);
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final /* synthetic */ void onSilenceDetected(TTVideoEngine r100) {
        VideoEngineListener.CC.$default$onSilenceDetected(this, r100);
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final void onStreamChanged(TTVideoEngine r100, int r101) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final /* synthetic */ void onVideoSecondFrame(TTVideoEngine r100) {
        VideoEngineListener.CC.$default$onVideoSecondFrame(this, r100);
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final void onVideoSizeChanged(TTVideoEngine r100, int r101, int r102) {
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.k
    public final void release() {
        this.f172604e = true;
        this.f172602c = false;
        this.f172603d = false;
        this.f172600a.removeCallbacksAndMessages(null);
        this.f172605f.release();
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.k
    public final void stop() {
        this.f172603d = false;
        this.f172605f.stop();
    }

    public final void c() {
        if (this.f172604e == false) goto L6;
        return;
    L6:
        if (this.f172602c == false) goto L8;
        this.f172605f.play();
        return;
    L8:
        this.f172603d = true;
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.k
    public final void a(o r100) {
        this.f172601b = r100;
    }

    public final void b(Function0<Unit> r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        this.f172600a.post(new b(r100));
    }

    public final void d(e r100) {
        Intrinsics.checkNotNullParameter(r100, "audioInfo");
        this.f172602c = false;
        this.f172603d = false;
        String r101 = r100.f172617a;
        if (r101 != null) goto L5;
        r101 = TTVideoEngine.computeMD5(r100.f172618b);
    L5:
        this.f172605f.setDirectUrlUseDataLoader(r100.f172618b, r101);
        this.f172605f.prepare();
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final void onCompletion(TTVideoEngine r100) {
        b(new AnonymousClass1(this));
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final void onError(final Error r100) {
        b(new C103261(this, r100));
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final void onPrepared(TTVideoEngine r100) {
        b(new C103271(this));
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final void onVideoStatusException(final int r100) {
        b(new C103281(this, r100));
    }

    public TTVideoEngineAudioPlayer(Context r100, AVScene r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "avScene");
        this.f172600a = new Handler(Looper.getMainLooper());
        TTVideoEngine r102 = new TTVideoEngine(r100.getApplicationContext(), 0);
        r102.setTag(r101.getTag());
        r102.setSubTag(r101.getSubTag());
        r102.setIntOption(160, 1);
        r102.setListener(this);
        Unit r103 = Unit.INSTANCE;
        this.f172605f = r102;
    }
}
