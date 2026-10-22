package com.bytedance.android.livesdk.interactivity.comment.audio;

import am2.x;
import android.media.AudioRecord;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.interactivity.api.IAudioController;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.ILiveWrappedAudio;
import com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.LiveWrappedSAMICoreDataType;
import com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.LiveWrappedSAMICoreIdentify;
import com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.LiveWrappedSAMICorePropertyId;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.texturerender.TextureRenderKeys;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mf2.f;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements IAudioController, Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.comment.audio.b f134815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<mf2.a> f134816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<mf2.a> f134817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PthreadHandlerThreadV2 f134818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f134819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f134820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f134821g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f134822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile String f134823i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile String f134824j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f134825k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f134826l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f134827m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicInteger f134828n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public b f134829o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final d f134830p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final DataCenter f134831q;

    public static final class a {
    }

    public interface b {
        void b(String r100);

        void c(byte[] r100);

        void f(String r100, long r101);
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.audio.c$c, reason: collision with other inner class name */
    public static final class C2126c {
        public C2126c() {
        }
    }

    public static final class d implements com.bytedance.android.livesdk.interactivity.comment.audio.b.InterfaceC2125b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f134832a;

        public d(c r100) {
            this.f134832a = r100;
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.audio.b.InterfaceC2125b
        public final void a(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, "pcmData");
            AndroidSchedulers.mainThread().scheduleDirect(new com.bytedance.android.livesdk.interactivity.comment.audio.d(this, r100));
            c r101 = this.f134832a;
            if (r101.f134820f != null) goto L6;
            r101.f134820f = new float[r100.length / 2];
            Unit r102 = Unit.INSTANCE;
        L6:
            if (r101.f134827m == true) goto L51;
            f r103 = null;
            if (this.f134832a.f134826l == false) goto L31;
            mf2.a r104 = this.f134832a.f134817c.get();
            if (r104 == null) goto L12;
            long r105 = r104.e();
        L14:
            if (r105 == 0) goto L31;
            ILiveWrappedAudio.Companion.getClass();
            ILiveWrappedAudio r106 = ILiveWrappedAudio.a.a();
            if (r106 == null) goto L18;
            r103 = r106.newSAMICoreBlock();
        L18:
            if (r103 == null) goto L20;
            LiveWrappedSAMICoreDataType r107 = LiveWrappedSAMICoreDataType.SAMICoreDataType_Float;
            r103.a();
        L20:
            if (r103 == null) goto L25;
            ILiveWrappedAudio r108 = ILiveWrappedAudio.a.a();
            if (r108 == null) goto L24;
            r108.newSAMICoreAudioBin();
        L24:
            r103.b();
        L25:
            if (r103 == null) goto L27;
            r103.c();
        L27:
            Handler r109 = this.f134832a.f134819e;
            if (r109 == null) goto L52;
            r109.sendMessage(r109.obtainMessage(104, r103));
            return;
        L52:
            return;
        L12:
            r105 = 0;
        L31:
            if (this.f134832a.f134826l == true) goto L54;
            mf2.a r110 = this.f134832a.f134816b.get();
            if (r110 == null) goto L35;
            long r111 = r110.e();
        L37:
            if (r111 == 0) goto L55;
            ILiveWrappedAudio.Companion.getClass();
            ILiveWrappedAudio r112 = ILiveWrappedAudio.a.a();
            if (r112 == null) goto L41;
            r103 = r112.newSAMICoreBlock();
        L41:
            if (r103 == null) goto L43;
            LiveWrappedSAMICoreDataType r113 = LiveWrappedSAMICoreDataType.SAMICoreDataType_Float;
            r103.a();
        L43:
            if (r103 == null) goto L45;
            float[] r114 = this.f134832a.f134820f;
            ILiveWrappedAudio.a.a().newSAMICoreAudioBuffer();
            r103.b();
        L45:
            if (r103 == null) goto L47;
            r103.c();
        L47:
            Handler r115 = this.f134832a.f134819e;
            if (r115 == null) goto L56;
            r115.sendMessage(r115.obtainMessage(101, r103));
            return;
        L56:
            return;
        L55:
            return;
        L35:
            r111 = 0;
            goto L37
        L54:
            return;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f134833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f134834b;

        public e(c r100, long r101) {
            this.f134833a = r100;
            this.f134834b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c r100 = this.f134833a;     // Catch: Throwable -> L6
            b r101 = r100.f134829o;     // Catch: Throwable -> L6
            if (r101 == null) goto L9;
            r101.f(r100.f134822h, this.f134834b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAudioController
    public final void clear() {
        this.f134826l = false;
        PthreadHandlerThreadV2 r100 = this.f134818d;
        if (r100 == null) goto L5;
        r100.quit();
    L5:
        this.f134818d = null;
        this.f134819e = null;
        com.bytedance.android.livesdk.interactivity.comment.audio.b r101 = this.f134815a;
        if (r101 == null) goto L16;
        r101.f134810d = null;
        TokenCert r102 = b72.a.f17904e;
        Intrinsics.checkNotNullParameter(r102, TextureRenderKeys.KEY_IS_CERT);
        AudioRecord r103 = r101.f134809c;     // Catch: BPEAException -> L12 IllegalStateException -> L14
        if (r103 == null) goto L16;
        g80.a.c(r103, r102);     // Catch: BPEAException -> L12 IllegalStateException -> L14
    L12:
        e = move-exception;
        f72.a.b("Release Record BPEAException: " + e.getMessage());
    L14:
        e = move-exception;
        f72.a.b("Release Record Exception: " + e.getMessage());
    L16:
        this.f134815a = null;
        mf2.a r104 = this.f134816b.getAndSet(null);
        if (r104 == null) goto L19;
        b(r104);
    L19:
        mf2.a r105 = this.f134817c.getAndSet(null);
        if (r105 == null) goto L25;
        r105.b();
        b(r105);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAudioController
    public final boolean startAsrAudio() {
        this.f134826l = true;
        this.f134827m = false;
        a();
        this.f134823i = "";
        this.f134824j = "";
        com.bytedance.android.livesdk.interactivity.comment.audio.b r100 = this.f134815a;
        if (r100 == null) goto L5;
        r100.a(b72.a.f17902c);
    L5:
        IInteractivityInjectService r101 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r101 == null) goto L8;
        r101.muteLivePlayerClient();
    L8:
        xs2.b.a().post(new u22.e());
        DataCenter r102 = this.f134831q;
        if (r102 == null) goto L11;
        r102.put("data_room_comment_is_audio_recording", Boolean.TRUE);
    L11:
        Handler r103 = this.f134819e;
        if (r103 == null) goto L14;
        r103.sendMessage(r103.obtainMessage(103));
    L14:
        HashMap r104 = new HashMap();
        r104.put(SoloKtvContext.SOLO_PAGE_ENTRANCE, "asr_pannel");
        IInteractivityInjectService r105 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r105 == null) goto L17;
        r105.buildVsRoomLog(this.f134831q, r104);
    L17:
        j0.l().sendLog("livesdk_voice_comment_click", r104, new Object[]{IRoom.class, x.class});
        f72.a.b("startAsrAudio");
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAudioController
    public final boolean startRecordAudio() {
        this.f134826l = false;
        this.f134827m = false;
        a();
        this.f134821g = jc1.a.b().getFilesDir().getAbsolutePath() + "/audio/";
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.f134821g);
        Integer r101 = null;
        if ((!r100.exists()) == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L8;
        r100.mkdir();
    L8:
        this.f134822h = this.f134821g + DigestUtils.md5Hex(String.valueOf(System.currentTimeMillis())) + ".aac";
        ILiveWrappedAudio.Companion.getClass();
        ILiveWrappedAudio r102 = ILiveWrappedAudio.a.a();
        if (r102 == null) goto L11;
        r102.newSAMICoreAudioEncodeContextParameter();
    L11:
        mf2.a r103 = this.f134816b.get();
        if (r103 == null) goto L14;
        LiveWrappedSAMICoreIdentify r104 = LiveWrappedSAMICoreIdentify.SAMICoreIdentify_EngineExecutor_KWS;
        r101 = Integer.valueOf(r103.d());
    L14:
        this.f134825k = SystemClock.elapsedRealtime();
        if (r101 != null) goto L18;
    L19:
        f72.a.b("create encoder handle failed, ret " + r101);
        if (r101 == null) goto L22;
        int r105 = r101.intValue();
    L23:
        f72.a.a(1, r105);
    L24:
        com.bytedance.android.livesdk.interactivity.comment.audio.b r106 = this.f134815a;
        if (r106 == null) goto L27;
        r106.a(b72.a.f17902c);
    L27:
        IInteractivityInjectService r107 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r107 == null) goto L30;
        r107.muteLivePlayerClient();
    L30:
        xs2.b.a().post(new u22.e());
        DataCenter r108 = this.f134831q;
        if (r108 == null) goto L33;
        r108.put("data_room_comment_is_audio_recording", Boolean.TRUE);
    L33:
        HashMap r109 = new HashMap();
        r109.put(SoloKtvContext.SOLO_PAGE_ENTRANCE, "voice_pannel");
        IInteractivityInjectService r110 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r110 == null) goto L36;
        r110.buildVsRoomLog(this.f134831q, r109);
    L36:
        j0.l().sendLog("livesdk_voice_comment_click", r109, new Object[]{IRoom.class, x.class});
        f72.a.b("startRecordAudio");
        return true;
    L22:
        r105 = -10086;
        goto L23
    L18:
        if (r101.intValue() == 0) goto L24;
        goto L19
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAudioController
    public final boolean stopAsrAudio() {
        this.f134827m = true;
        DataCenter r100 = this.f134831q;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L12;
        IInteractivityInjectService r103 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r103 == null) goto L12;
        r103.unmuteLivePlayerClient();
    L12:
        com.bytedance.android.livesdk.interactivity.comment.audio.b r104 = this.f134815a;
        if (r104 == null) goto L15;
        r104.b(b72.a.f17903d);
    L15:
        DataCenter r105 = this.f134831q;
        if (r105 == null) goto L18;
        r105.put("data_room_comment_is_audio_recording", Boolean.FALSE);
    L18:
        String r106 = this.f134823i + this.f134824j;
        b r107 = this.f134829o;
        if (r107 == null) goto L22;
        r107.b(r106);
    L22:
        if (r106.length() != 0) goto L24;
        r101 = true;
    L24:
        if (r101 == false) goto L30;
        InteractivityMonitor.Event r108 = InteractivityMonitor.Event.AudioTransferError;
        DataCenter r109 = this.f134831q;
        if (r109 == null) goto L28;
        IRoom r110 = a0.n(r109);
    L29:
        InteractivityMonitor.c(r108, r110, 1, null, 24);
        goto L30
    L28:
        r110 = null;
    L30:
        Handler r111 = this.f134819e;
        if (r111 == null) goto L33;
        r111.sendMessage(r111.obtainMessage(105));
    L33:
        f72.a.b("stopAsrAudio");
        return true;
    L5:
        if (((Boolean) r100.get("data_game_screen_cast_tv", Boolean.FALSE)).booleanValue() == false) goto L7;
        r102 = true;
        goto L8
    }

    public final void a() {
        if (this.f134818d != null) goto L6;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("Audio_Process");
        ThreadMethodProxy.start(r100);
        this.f134819e = new Handler(r100.getLooper(), this);
        Unit r101 = Unit.INSTANCE;
        this.f134818d = r100;
    L6:
        if (this.f134815a != null) goto L8;
        com.bytedance.android.livesdk.interactivity.comment.audio.b r102 = new com.bytedance.android.livesdk.interactivity.comment.audio.b();
        r102.f134810d = this.f134830p;
        Unit r103 = Unit.INSTANCE;
        this.f134815a = r102;
    L8:
        f72.a.b("createRecorderAndSamiCore: " + this.f134817c.get());
        AtomicReference<mf2.a> r104 = this.f134816b;
        ILiveWrappedAudio.Companion.getClass();
        ILiveWrappedAudio r105 = ILiveWrappedAudio.a.a();
        if (r105 == null) goto L11;
        mf2.a r106 = r105.newSAMICore();
    L13:
        if (r104.compareAndSet(null, r106) == true) goto L17;
        if (r104.get() == null) goto L13;
    L17:
        AtomicReference<mf2.a> r107 = this.f134817c;
        ILiveWrappedAudio.Companion.getClass();
        ILiveWrappedAudio r108 = ILiveWrappedAudio.a.a();
        if (r108 == null) goto L22;
        mf2.a r109 = r108.newSAMICore();
        if (r109 == null) goto L22;
        r109.b();
        Unit r110 = Unit.INSTANCE;
    L24:
        if (r107.compareAndSet(null, r109) == true) goto L28;
        if (r107.get() == null) goto L24;
        return;
    L28:
        return;
    L22:
        r109 = null;
        goto L24
    L11:
        r106 = null;
        goto L13
    }

    public final void c() {
        if (this.f134818d != null) goto L5;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("Audio_Process");
        ThreadMethodProxy.start(r100);
        this.f134819e = new Handler(r100.getLooper(), this);
        Unit r101 = Unit.INSTANCE;
        this.f134818d = r100;
    L5:
        AtomicReference<mf2.a> r102 = this.f134817c;
        ILiveWrappedAudio.Companion.getClass();
        ILiveWrappedAudio r103 = ILiveWrappedAudio.a.a();
        if (r103 == null) goto L10;
        mf2.a r104 = r103.newSAMICore();
        if (r104 == null) goto L10;
        r104.b();
        Unit r105 = Unit.INSTANCE;
    L12:
        if (r102.compareAndSet(null, r104) == true) goto L16;
        if (r102.get() == null) goto L12;
    L16:
        Handler r106 = this.f134819e;
        if (r106 == null) goto L24;
        r106.sendMessage(r106.obtainMessage(103));
        return;
    L24:
        return;
    L10:
        r104 = null;
        goto L12
    }

    public c(DataCenter r100) {
        this.f134831q = r100;
        this.f134816b = new AtomicReference();
        this.f134817c = new AtomicReference();
        this.f134823i = "";
        this.f134824j = "";
        this.f134827m = true;
        this.f134828n = new AtomicInteger(0);
        this.f134830p = new d(this);
        new C2126c();
    }

    public static void b(mf2.a r100) {
        if (r100.e() == 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        r100 = null;
    L9:
        if (r100 == null) goto L12;
        r100.a();
        return;
    L12:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        boolean r101 = true;
        Object r102 = null;
        mf2.a r103 = null;
        Object r104 = null;
        mf2.a r105 = null;
        switch(r100.what) {
            case 101: goto L51;
            case 102: goto L42;
            case 103: goto L24;
            case 104: goto L15;
            case 105: goto L5;
            default: goto L60;
        };
    L5:
        mf2.a r106 = this.f134817c.get();
        if (r106 == null) goto L60;
        LiveWrappedSAMICorePropertyId r107 = LiveWrappedSAMICorePropertyId.SAMICorePropertyID_Base_NAME;
        if (r106.e() != 0) goto L11;
        r101 = false;
    L11:
        if (r101 == false) goto L13;
        r103 = r106;
    L13:
        if (r103 == null) goto L60;
        r103.c();
        goto L60
    L15:
        Object r108 = r100.obj;
        if ((r108 instanceof f) == false) goto L20;
        r104 = r108;
    L20:
        if (((f) r104) == null) goto L60;
        mf2.a r109 = this.f134817c.get();
        if (r109 == null) goto L60;
        r109.f();
        goto L60
    L24:
        f72.a.b("initOnlineAsrSamiCore connectState: " + this.f134828n.get());
        if (this.f134828n.compareAndSet(0, 1) == false) goto L60;
        mf2.a r110 = this.f134817c.get();
        if (r110 == null) goto L60;
        if (r110.e() == 0) goto L33;
        r101 = false;
    L33:
        if (r101 == false) goto L35;
        r105 = r110;
    L35:
        if (r105 == null) goto L60;
        ((IInteractivityInjectService) k.n(IInteractivityInjectService.class)).createSamiTokenParams();
        ((IMiddleWareHostContext) k.n(IMiddleWareHostContext.class)).isBoe();
        ILiveWrappedAudio.Companion.getClass();
        ILiveWrappedAudio r111 = ILiveWrappedAudio.a.a();
        if (r111 == null) goto L39;
        r111.newSAMICoreAsrContextCreateParameter();
    L39:
        LiveWrappedSAMICoreIdentify r112 = LiveWrappedSAMICoreIdentify.SAMICoreIdentify_EngineExecutor_KWS;
        int r113 = r105.d();
        if (r113 == 0) goto L60;
        f72.a.b("create asr handle failed, ret " + r113);
        f72.a.a(2, r113);
        goto L60
    L42:
        Handler r114 = this.f134819e;
        if (r114 == null) goto L45;
        r114.removeMessages(101);
    L45:
        mf2.a r115 = this.f134816b.getAndSet(null);
        if (r115 == null) goto L49;
        b(r115);
    L49:
        if (r100.arg1 != 1001) goto L60;
        AndroidSchedulers.mainThread().scheduleDirect(new e(this, r100.arg2));
        goto L60
    L51:
        Object r116 = r100.obj;
        if ((r116 instanceof f) == false) goto L56;
        r102 = r116;
    L56:
        if (((f) r102) == null) goto L60;
        mf2.a r117 = this.f134816b.get();
        if (r117 == null) goto L60;
        r117.f();
    L60:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAudioController
    public final boolean stopRecordAudio(boolean r100, boolean r101) {
        this.f134827m = true;
        DataCenter r102 = this.f134831q;
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L12;
        IInteractivityInjectService r104 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r104 == null) goto L12;
        r104.unmuteLivePlayerClient();
    L12:
        com.bytedance.android.livesdk.interactivity.comment.audio.b r105 = this.f134815a;
        if (r105 == null) goto L15;
        r105.b(b72.a.f17903d);
    L15:
        DataCenter r106 = this.f134831q;
        if (r106 == null) goto L19;
        r106.put("data_room_comment_is_audio_recording", Boolean.FALSE);
    L19:
        if (r101 == false) goto L24;
        Handler r107 = this.f134819e;
        if (r107 == null) goto L23;
        r107.sendEmptyMessage(102);
    L23:
        return true;
    L24:
        if (r100 == false) goto L28;
        Handler r108 = this.f134819e;
        if (r108 == null) goto L28;
        r108.sendMessage(r108.obtainMessage(102, 1001, (int) (SystemClock.elapsedRealtime() - this.f134825k)));
    L28:
        f72.a.b("stopRecordAudio");
        return true;
    L5:
        if (((Boolean) r102.get("data_game_screen_cast_tv", Boolean.FALSE)).booleanValue() == false) goto L7;
        r103 = true;
        goto L8
    }
}
