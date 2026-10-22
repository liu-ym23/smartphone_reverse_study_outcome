package com.bytedance.applet.aibridge.baidunavi.tts;

import com.larus.audio.IFlowTtsClientService;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.MediaScene;
import com.larus.media.o0;
import com.larus.media.v;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import lk9.g;

/* JADX INFO: loaded from: classes14.dex */
public final class BaiduNaviTtsPlayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f190975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f190976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f190977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larus.media.model.a f190978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BaiduNaviTtsPlayer$mAudioPlayerListener$1 f190979e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f190980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f190981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f190982c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, String> f190983d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f190980a, r101.f190980a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f190981b, r101.f190981b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f190982c, r101.f190982c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f190983d, r101.f190983d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f190980a.hashCode() * 31) + this.f190981b.hashCode()) * 31;
            String r101 = this.f190982c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Map<String, String> r105 = this.f190983d;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "BaiduNaviTtsInfo(text=" + this.f190980a + ", speakerStyleId=" + this.f190981b + ", conversationId=" + this.f190982c + ", payloadExtParams=" + this.f190983d + ')';
        }

        public a(String r100, String r101, String r102, Map<String, String> r103) {
            Intrinsics.checkNotNullParameter(r100, "text");
            Intrinsics.checkNotNullParameter(r101, "speakerStyleId");
            this.f190980a = r100;
            this.f190981b = r101;
            this.f190982c = r102;
            this.f190983d = r103;
        }
    }

    public static final class b {
    }

    public static final class c implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaiduNaviTtsPlayer f190984a;

        public c(BaiduNaviTtsPlayer r100) {
            this.f190984a = r100;
        }

        @Override // com.larus.media.v
        public final boolean b(g r100) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            Map<String, o0.a> r101 = o0.f359131a;
            return o0.a(MediaScene.NAVIGATION, r100.getScene());
        }

        @Override // com.larus.media.v
        public final void e(g r100) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            v.a.d(r100);
            this.f190984a.a().f("onMediaInterrupted by BaiduNaviTtsPlayer");
            FLogger.f375446a.i("BaiduNaviTtsPlayer", "audio focus gainOccupiedStrategy and interrupt. applicant:" + r100 + ", current: NAVIGATION.");
        }

        @Override // com.larus.media.v
        public final void f(MediaResourceManager.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // com.larus.media.v
        public final void a(g r100, float r101) {
            v.a.f(r100, r101);
        }

        @Override // com.larus.media.v
        public final void d(g r100, g r101) {
            v.a.c(r100, r101);
        }

        @Override // com.larus.media.v
        public final void g(g r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            v.a.g(r100, r101);
            this.f190984a.a().setVolume(r101);
            FLogger.f375446a.i("BaiduNaviTtsPlayer", "audio focus onMediaVolumeChange. applicant:" + r100 + ", volumeFactor: " + r101 + '.');
        }

        @Override // com.larus.media.v
        public final void i(g r100, g r101) {
            v.a.e(r100, r101);
        }

        @Override // com.larus.media.v
        public final MediaOccupyStrategy c(g r100, g r101, int r102) {
            return v.a.a(this, r100, r101, r102);
        }

        @Override // com.larus.media.v
        public final MediaOccupyStrategy h(g r100, g r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
            return MediaOccupyStrategy.INTERRUPT;
        }
    }

    static {
    }

    public final IFlowTtsClientService a() {
        return (IFlowTtsClientService) this.f190975a.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.applet.aibridge.baidunavi.tts.BaiduNaviTtsPlayer$mAudioPlayerListener$1] */
    public BaiduNaviTtsPlayer() {
        this.f190975a = LazyKt.lazy(new com.bytedance.applet.aibridge.baidunavi.tts.c());
        this.f190978d = new com.larus.media.model.a(null, MediaScene.NAVIGATION, false, 1, 2, false, 0, false, false, 0, false, new c(this), 2021);
        this.f190979e = new BaiduNaviTtsPlayer$mAudioPlayerListener$1(this);
    }

    public final void b(final a r100, boolean r101) {
        monitor-enter(this);
        if (r101 == true) goto L12;
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f190976b == null) goto L12;
        this.f190977c = r100;     // Catch: Throwable -> L9
        FLogger.f375446a.i("BaiduNaviTtsPlayer", "tts waiting for play");     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L12:
        this.f190977c = null;     // Catch: Throwable -> L9
        this.f190976b = r100;     // Catch: Throwable -> L9
        FLogger.f375446a.i("BaiduNaviTtsPlayer", "tts ready for play");     // Catch: Throwable -> L9
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(this);
        a().f("startTts by BaiduNaviTtsPlayer");
        final Ref.BooleanRef r103 = new Ref.BooleanRef();
        Lazy r104 = MediaResourceManager.f358950a;
        MediaResourceManager.m(this.f190978d, new com.bytedance.applet.aibridge.baidunavi.tts.a(r103, this, r100), new com.bytedance.applet.aibridge.baidunavi.tts.b(this), 0, 8);
    }
}
