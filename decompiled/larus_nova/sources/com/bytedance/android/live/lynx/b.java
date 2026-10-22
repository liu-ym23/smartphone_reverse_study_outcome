package com.bytedance.android.live.lynx;

import com.bytedance.android.live.lynx.ui.replay.ReplayVideoLynxView;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.ies.xelement.LynxVideoManager;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.ies.xelement.alphavideo.LynxAlphaVideo;
import com.bytedance.ies.xelement.audiott.LynxAudioTTView;
import com.bytedance.ies.xelement.banner.LynxSwiperView;
import com.bytedance.ies.xelement.bytedlottie.LynxBytedLottieView;
import com.bytedance.ies.xelement.live.LynxLiveView;
import com.bytedance.ies.xelement.picker.LynxPickerView;
import com.bytedance.ies.xelement.video.pro.LynxVideoUI;
import com.larus.nova.R;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.XElementBehavior;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.canvas.LynxHeliumCanvas;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements com.bytedance.android.live.lynx.a {

    public static final class a implements com.bytedance.android.live.lynx.c.a<com.bytedance.android.live.lynx.a> {

        /* JADX INFO: renamed from: com.bytedance.android.live.lynx.b$a$a, reason: collision with other inner class name */
        public static final class C1257a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f82534a = null;

            static {
                f82534a = new b();
            }
        }

        public a() {
        }

        @Override // com.bytedance.android.live.lynx.c.a
        public final void provide() {
            b r100 = C1257a.f82534a;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.lynx.b$b, reason: collision with other inner class name */
    public static final class C1258b extends com.lynx.tasm.behavior.a {
        public C1258b() {
            super("lottie-view");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxBytedLottieView(r100, "");
        }
    }

    public static final class c extends com.lynx.tasm.behavior.a {
        public c() {
            super("x-live");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            return new LynxLiveView(r100);
        }
    }

    public static final class d extends com.lynx.tasm.behavior.a {
        public d() {
            super("x-record-video");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new ReplayVideoLynxView(r100);
        }
    }

    public static final class e extends com.lynx.tasm.behavior.a {
        public e() {
            super("x-audio-tt");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxAudioTTView(r100);
        }
    }

    public static final class f extends com.lynx.tasm.behavior.a {
        public f() {
            super("x-video-pro");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            LynxVideoUI r101 = new LynxVideoUI(r100);
            r101.T(new sic.a());
            return r101;
        }
    }

    public static final class g extends com.lynx.tasm.behavior.a {
        public g() {
            super("canvas");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            ((IHostAction) jc1.k.n(IHostAction.class)).initLynxHelium();
            return new LynxHeliumCanvas(r100);
        }
    }

    public static final class h extends com.lynx.tasm.behavior.a {
        public h() {
            super("swiper", false, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxSwiperView(r100);
        }
    }

    public static final class i extends com.lynx.tasm.behavior.a {
        public i() {
            super("x-video");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxVideoManager(r100);
        }
    }

    public static final class j extends com.lynx.tasm.behavior.a {
        public j() {
            super("x-video-flower");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxVideoManagerLite(r100);
        }
    }

    public static final class k extends com.lynx.tasm.behavior.a {

        public static final class a implements y76.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LynxContext f82535a;

            @Override // y76.a
            public final Map<String, String> a() {
                return MapsKt.mapOf(new Pair[]{TuplesKt.to("confirm", this.f82535a.getResources().getString(R.string.ttlive_x_picker_confirm)), TuplesKt.to("cancel", this.f82535a.getResources().getString(R.string.ttlive_x_picker_cancel))});
            }

            public a(LynxContext r100) {
                this.f82535a = r100;
            }
        }

        public k() {
            super("x-picker");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxPickerView(r100, new a(r100));
        }
    }

    public static final class l extends com.lynx.tasm.behavior.a {
        public l() {
            super("x-alpha-video");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxAlphaVideo(r100);
        }
    }

    public b() {
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [T, kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r9v1, types: [T, kotlin.Unit] */
    @Override // com.bytedance.android.live.lynx.a
    public final List<com.lynx.tasm.behavior.a> c() {
        List<com.lynx.tasm.behavior.a> r100 = new XElementBehavior().create();
        r100.addAll(CollectionsKt.mutableListOf(new com.lynx.tasm.behavior.a[]{new g(), new h(), new i(), new j(), new k(), new l()}));
        kjc.c r101 = new kjc.c();
        if (2 != kjc.a.a()) goto L6;
        r101.f503730a.f503729a = Unit.INSTANCE;
        r101.f503731b = true;
    L6:
        if (r101.f503731b == true) goto L8;
        kjc.b<T> r102 = r101.f503730a;
        r100.addAll(CollectionsKt.mutableListOf(new com.lynx.tasm.behavior.a[]{new C1258b(), new c(), new d(), new e(), new f()}));
        r102.f503729a = Unit.INSTANCE;
    L8:
        T r103 = r101.f503730a.f503729a;
        return r100;
    }

    @Override // com.bytedance.android.live.lynx.a
    public final boolean isEnableDebug() {
        if (LynxEnv.inst().isDevtoolEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (LynxEnv.inst().isLynxDebugEnabled() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.lynx.a
    public final void b(boolean r100) {
        LynxEnv.inst().enableDevtool(r100);
        LynxEnv.inst().enableLynxDebug(r100);
    }

    @Override // com.bytedance.android.live.lynx.a
    public final void d(TemplateData r100) {
        if (r100 == null) goto L5;
        r100.markReadOnly();
        return;
    }

    @Override // com.bytedance.android.live.lynx.a
    public final void a(LynxViewBuilder r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        if (r101 != null) goto L5;
    L9:
        r100.setEnableUserCodeCache(true);
        r100.setCodeCacheSourceUrl(r101);
        return;
    L5:
        if (r101.length() != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 != true) goto L9;
        return;
    L7:
        r102 = false;
        goto L8
    }

    @Override // com.bytedance.android.live.lynx.a
    public final void setEnableJSRuntime(LynxViewBuilder r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        r100.setEnableJSRuntime(r101);
    }

    @Override // com.bytedance.android.live.lynx.a
    public final LynxGroup e(String r100, String[] r101, boolean r110, boolean r111, boolean r112, int r113) {
        if (r113 == 1) goto L5;
        if (r113 != 0) goto L10;
        return LynxGroup.Create(r100, r101, r110, r111, r112, false);
    L10:
        return LynxGroup.Create(r100, r101, r110, r111, r112);
    L5:
        return LynxGroup.Create(r100, r101, r110, r111, r112, true);
    }
}
