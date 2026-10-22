package com.bytedance.android.live.liveinteract.voicechat.radio.asr;

import android.os.Handler;
import android.os.Message;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.speech.speechengine.SpeechEngine;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import ec2.a0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class k implements Handler.Callback {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final TokenCert f80508m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final TokenCert f80509n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final TokenCert f80510o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final TokenCert f80511p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.voicechat.radio.asr.b f80512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f80513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PthreadHandlerThreadV2 f80514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f80515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f80516e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f80517f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f80518g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f80519h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f80520i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final m f80521j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final l f80522k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MultiLinkAsrManager.a f80523l;

    public static final class a {
    }

    public interface b {
        void a(e r100);

        void b(String r100);

        void c(String r100);

        void onStart(String r100);

        void onStop(String r100);
    }

    static {
        TokenCert.Companion r100 = TokenCert.Companion;
        f80508m = r100.with("bpea-live_audiocomment_check_permssion_v1");
        f80509n = r100.with("bpea-live_audiocomment_req_permssion");
        f80510o = r100.with("bpea-live_audio_comment_record");
        f80511p = r100.with("bpea-live_audio_comment_record_stop");
        r100.with("bpea-live_audio_comment_record_release");
    }

    public k(MultiLinkAsrManager.a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f80523l = r100;
        this.f80517f = true;
        this.f80519h = "";
        this.f80520i = a0.f472001a.getValue();
        this.f80521j = new m(this);
        this.f80522k = new l(this);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r110) {
        Intrinsics.checkNotNullParameter(r110, "msg");
        int r100 = r110.what;
        if (r100 != 24) goto L5;
        h r101 = this.f80513b;
        if (r101 == null) goto L79;
        r101.e();
        return false;
    L79:
        return false;
    L5:
        if (r100 != 103) goto L7;
        com.bytedance.android.live.liveinteract.voicechat.radio.asr.a r102 = new com.bytedance.android.live.liveinteract.voicechat.radio.asr.a();
        r102.f80488a = "radio_user_asr_audio";
        if (v.a() == false) goto L24;
        r102.f80489b = "radio_user_asr_debug";
    L24:
        h r103 = this.f80513b;
        if (r103 == null) goto L55;
        String r111 = this.f80523l.a();
        if (r111 != null) goto L29;
        r111 = "qhlmASv0ZqsxPE2o";
    L29:
        String r112 = this.f80523l.b();
        if (r112 != null) goto L32;
        r112 = "Wkj5kLd-EPaB6ntGdeZ7Ljgu7ED_NKCj";
    L32:
        String r113 = this.f80523l.c();
        if (r113 != null) goto L35;
        r113 = "volc_input_common";
    L35:
        Intrinsics.checkNotNullParameter(r111, "appId");
        Intrinsics.checkNotNullParameter(r112, "appToken");
        Intrinsics.checkNotNullParameter(r113, "cluster");
        Intrinsics.checkNotNullParameter(r102, "config");
        if (r103.f80500c == true) goto L55;
        long r114 = System.currentTimeMillis();
        SpeechEngine r104 = r103.f80499b;     // Catch: Exception -> L53
        r103.c("start create " + r103.f80502e);     // Catch: Exception -> L53
        r103.f80499b.setContext(jc1.a.b());     // Catch: Exception -> L53
        r104.createEngine();     // Catch: Exception -> L53
        r103.c("create " + r103.f80502e + " done");     // Catch: Exception -> L53
        r104.setOptionString(SpeechEngineDefines.PARAMS_KEY_ENGINE_NAME_STRING, "asr");     // Catch: Exception -> L53
        r104.setOptionString("appid", r111);     // Catch: Exception -> L53
        r104.setOptionString("token", "Bearer;".concat(r112));     // Catch: Exception -> L53
        r104.setOptionString(SpeechEngineDefines.PARAMS_KEY_ASR_ADDRESS_STRING, "wss://speech.bytedance.com");     // Catch: Exception -> L53
        r104.setOptionString(SpeechEngineDefines.PARAMS_KEY_ASR_URI_STRING, "/api/v2/asr");     // Catch: Exception -> L53
        r104.setOptionString(SpeechEngineDefines.PARAMS_KEY_ASR_CLUSTER_STRING, r113);     // Catch: Exception -> L53
        r104.setOptionString("uid", gh0.a.c());     // Catch: Exception -> L53
        String r105 = ((IMiddleWareHostContext) jc1.k.n(IMiddleWareHostContext.class)).getServerDeviceId();     // Catch: Exception -> L53
        if (r105 == null) goto L42;
        r104.setOptionString("device_id", r105);     // Catch: Exception -> L53
    L42:
        r104.setOptionBoolean(SpeechEngineDefines.PARAMS_KEY_ASR_AUTO_STOP_BOOL, false);     // Catch: Exception -> L53
        r104.setOptionBoolean(SpeechEngineDefines.PARAMS_KEY_ASR_SHOW_PUNC_BOOL, true);     // Catch: Exception -> L53
        r104.setOptionBoolean(SpeechEngineDefines.PARAMS_KEY_ASR_ENABLE_ITN_BOOL, true);     // Catch: Exception -> L53
        PolarisFileWrapper r106 = c.a(r102.f80489b);     // Catch: Exception -> L53
        if (r106 == null) goto L45;
        r104.setOptionString("log_level", "TRACE");     // Catch: Exception -> L53
        r104.setOptionString(SpeechEngineDefines.PARAMS_KEY_DEBUG_PATH_STRING, r106.getPath());     // Catch: Exception -> L53
    L45:
        PolarisFileWrapper r107 = c.a(r102.f80488a);     // Catch: Exception -> L53
        if (r107 == null) goto L48;
        r104.setOptionInt(SpeechEngineDefines.PARAMS_KEY_REC_FILE_TYPE_INT, 1);     // Catch: Exception -> L53
        r104.setOptionString(SpeechEngineDefines.PARAMS_KEY_REC_PATH_STRING, r107.getPath());     // Catch: Exception -> L53
        r107.deleteOnExit();     // Catch: Exception -> L53
    L48:
        r104.setOptionString(SpeechEngineDefines.PARAMS_KEY_RECORDER_TYPE_STRING, SpeechEngineDefines.RECORDER_TYPE_STREAM);     // Catch: Exception -> L53
        r104.setOptionBoolean(SpeechEngineDefines.PARAMS_KEY_ENABLE_RESAMPLER_BOOL, true);     // Catch: Exception -> L53
        r104.setOptionInt(SpeechEngineDefines.PARAMS_KEY_CUSTOM_CHANNEL_INT, 2);     // Catch: Exception -> L53
        r104.setOptionInt(SpeechEngineDefines.PARAMS_KEY_CUSTOM_SAMPLE_RATE_INT, 0);     // Catch: Exception -> L53
        r104.setOptionInt("channel", 1);     // Catch: Exception -> L53
        r104.setOptionInt(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT, 16000);     // Catch: Exception -> L53
        r103.c("start init " + r103.f80502e);     // Catch: Exception -> L53
        int r108 = r103.f80499b.initEngine();     // Catch: Exception -> L53
        r103.c("init engine cost " + (System.currentTimeMillis() - r114) + " ms. sampleRate=0");     // Catch: Exception -> L53
        if (r108 != 0) goto L51;
        r103.f80500c = true;     // Catch: Exception -> L53
        r103.f80498a.set(1);     // Catch: Exception -> L53
        r103.f80499b.setListener(new i(r103));     // Catch: Exception -> L53
        goto L55
    L51:
        r103.d("init engine failed. code=" + r108);     // Catch: Exception -> L53
    L53:
        e = move-exception;
        SafetyGuard.a("AnchorAsr create " + r103.f80502e + " error", e, null);
    L55:
        h r109 = this.f80513b;
        if (r109 != null) goto L58;
        return false;
    L58:
        if (r109.f80500c == true) goto L61;
        return false;
    L61:
        if (r109.f80500c == false) goto L64;
        r109.f80499b.sendDirective(2001, "");
    L64:
        r109.f80498a.set(2);
        int r115 = r109.f80499b.sendDirective(1000, "");
        if (r115 != 0) goto L67;
        r109.c("start engine success");
        r109.b();
        return false;
    L67:
        r109.f80498a.set(1);
        r109.d("start engine failed. code=" + r115);
        return false;
    L7:
        if (r100 != 105) goto L80;
        h r116 = this.f80513b;
        if (r116 == null) goto L12;
        r116.f80503f = false;
    L12:
        h r117 = this.f80513b;
        if (r117 == null) goto L15;
        r117.e();
    L15:
        h r118 = this.f80513b;
        if (r118 != null) goto L18;
        return false;
    L18:
        if (r118.f80500c == false) goto L81;
        r118.f80499b.sendDirective(2001, "");
        return false;
    L81:
        return false;
    L80:
        return false;
    }
}
