package com.bytedance.android.livesdk.asr;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.utils.w;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.speech.speechengine.SpeechEngine;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.bytedance.speech.speechengine.SpeechEngineGenerator;
import com.bytedance.speech.speechengine.SpeechEngineLoader;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import fr2.f0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: classes7.dex */
public final class GiftSpeechSdkManager implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile SpeechEngine f103945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f103946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f103947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f103948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile a f103949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile int f103950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final GiftSpeechSdkManager$mSdkListener$1 f103951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f103952h;

    public static final class a extends PthreadHandlerThreadV2 {
        public a() {
            super("GiftAsrWorker", -2);
        }
    }

    public final void b() {
        c("destroyEngine", false, true, new GiftSpeechSdkManager$destroyEngine$1(this));
        this.f103948d = null;
        i();
        a r100 = this.f103949e;
        if (r100 == null) goto L5;
        r100.quit();
    L5:
        this.f103949e = null;
    }

    public final void g() {
        k r100 = (k) f.d(j.C0.a(), k.class);
        if (r100 == null) goto L5;
        boolean r101 = r100.isAnchor();
    L6:
        ((com.bytedance.android.livesdk.revenue.service.interact.d) com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class)).Qb(r101, this);
        c("startEngine", true, true, new GiftSpeechSdkManager$startEngine$1(this));
        return;
    L5:
        r101 = true;
        goto L6
    }

    public final void h() {
        c("stopEngine", false, true, new GiftSpeechSdkManager$stopEngine$1(this));
    }

    public final void i() {
        k r100 = (k) f.d(j.C0.a(), k.class);
        if (r100 == null) goto L5;
        boolean r101 = r100.isAnchor();
    L6:
        ((com.bytedance.android.livesdk.revenue.service.interact.d) com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class)).fa(r101, this);
        return;
    L5:
        r101 = true;
        goto L6
    }

    public final void d() {
        i();
        c("finishTalking", false, true, new GiftSpeechSdkManager$finishTalking$1(this));
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.livesdk.asr.GiftSpeechSdkManager$mSdkListener$1] */
    public GiftSpeechSdkManager(b r100) {
        Intrinsics.checkNotNullParameter(r100, "giftASREventTracker");
        this.f103952h = r100;
        this.f103947c = new AtomicInteger(0);
        this.f103950f = 44100;
        this.f103951g = new GiftSpeechSdkManager$mSdkListener$1(this);
    }

    public final PolarisFileWrapper e(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        PolarisFileWrapper r102 = null;
        if (r101 == false) goto L9;
        return null;
    L9:
        File r103 = jc1.a.b().getFilesDir();
        if (r103 != null) goto L12;
        return null;
    L12:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103, r100);
        if (r104.exists() == true) goto L23;
        r104.mkdir();     // Catch: Exception -> L17
        r102 = r104;
    L20:
        return r102;
    L17:
        e = move-exception;
        this.f103952h.c("getDirInFiles", "", e);
        goto L20
    L23:
        return r104;
    L5:
        r101 = false;
        goto L6
    }

    public final ASRResult f(String r100) {
        return (ASRResult) GsonHelper.get().fromJson(r100, ASRResult.class);
    L4:
        th = move-exception;
        this.f103952h.c("parseResult", "failed", th);
        return null;
    }

    public final void j(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "hotWordsList");
        if (this.f103946b == false) goto L6;
        return;
    L6:
        if ((!r100.isEmpty()) == false) goto L14;
        List<String> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        r102.add(new oe1.c((String) r103.next(), oe1.b.a().e()));
        goto L9
    L11:
        final String r104 = GsonProtectorUtils.toJson(GsonHelper.get(), new oe1.d(r102));
        c("setHotWords", false, true, new GiftSpeechSdkManager$updateHotWords$1(this, r104));
        return;
    }

    public static final int a(GiftSpeechSdkManager r100, SpeechEngine r101, int r102) {
        r100.getClass();
        int r103 = r101.sendDirective(r102, "");
        r100.f103952h.d("sendDirective", "(type=" + r102 + ", result=" + r103 + ')');
        return r103;
    }

    public final void c(String r100, boolean r101, boolean r102, Function1<? super SpeechEngine, Unit> r103) {
        String r104 = r100 + '_' + this.f103947c.getAndIncrement();
        if (this.f103946b == false) goto L6;
        this.f103952h.d("enqueue", "engine is destroyed, skip " + r104);
        return;
    L6:
        if (r102 == false) goto L9;
        this.f103952h.d("enqueue", r104);
    L9:
        if (this.f103949e != null) goto L11;
        this.f103949e = new a();
    L11:
        if (r102 == false) goto L14;
        this.f103952h.d("dequeue", r104);
    L14:
        if (this.f103946b == false) goto L16;
        this.f103952h.d("enqueue", "engine is destroyed, skip " + r104);
        return;
    L16:
        SpeechEngine r105 = this.f103945a;
        if (r105 != null) goto L45;
        r105 = null;
        if (r101 == false) goto L45;
        SpeechEngine r106 = SpeechEngineGenerator.getInstance();
        r106.createEngine();
        r106.setContext(jc1.a.b());
        r106.setOptionString(SpeechEngineDefines.PARAMS_KEY_ENGINE_NAME_STRING, "asr");
        r106.setOptionString("appid", oe1.b.a().a());
        r106.setOptionString("token", oe1.b.a().b());
        r106.setOptionString(SpeechEngineDefines.PARAMS_KEY_ASR_ADDRESS_STRING, "wss://speech.bytedance.com");
        r106.setOptionString(SpeechEngineDefines.PARAMS_KEY_ASR_URI_STRING, "/api/v2/asr");
        r106.setOptionString(SpeechEngineDefines.PARAMS_KEY_ASR_CLUSTER_STRING, oe1.b.a().c());
        k r107 = (k) f.d(j.C0.a(), k.class);
        if (r107 == null) goto L27;
        IBaseUser r108 = r107.getUser();
        if (r108 == null) goto L27;
        String r109 = r108.getIdString();
    L28:
        r106.setOptionString("uid", r109);
        r106.setOptionBoolean(SpeechEngineDefines.PARAMS_KEY_ASR_AUTO_STOP_BOOL, false);
        r106.setOptionBoolean(SpeechEngineDefines.PARAMS_KEY_ASR_ENABLE_ITN_BOOL, true);
        int r110 = w.f66424a;
        if (v.a() == false) goto L36;
        PolarisFileWrapper r111 = e("gift_asr_debug");
        if (r111 == null) goto L33;
        r106.setOptionString("log_level", "TRACE");
        r106.setOptionString(SpeechEngineDefines.PARAMS_KEY_DEBUG_PATH_STRING, r111.getPath());
    L33:
        PolarisFileWrapper r112 = e("gift_asr_audio");
        if (r112 == null) goto L36;
        r106.setOptionInt(SpeechEngineDefines.PARAMS_KEY_REC_FILE_TYPE_INT, 1);
        r106.setOptionString(SpeechEngineDefines.PARAMS_KEY_REC_PATH_STRING, r112.getPath());
        r112.deleteOnExit();
    L36:
        r106.setOptionString(SpeechEngineDefines.PARAMS_KEY_RECORDER_TYPE_STRING, SpeechEngineDefines.RECORDER_TYPE_STREAM);
        r106.setOptionBoolean(SpeechEngineDefines.PARAMS_KEY_ENABLE_RESAMPLER_BOOL, true);
        r106.setOptionInt(SpeechEngineDefines.PARAMS_KEY_CUSTOM_CHANNEL_INT, 2);
        r106.setOptionInt(SpeechEngineDefines.PARAMS_KEY_CUSTOM_SAMPLE_RATE_INT, this.f103950f);
        r106.setOptionInt("channel", 1);
        r106.setOptionInt(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT, 16000);
        r106.setOptionBoolean(SpeechEngineDefines.PARAMS_KEY_ENABLE_FILTER_HEAD_SILENCE_BOOL, true);
        int r113 = r106.initEngine();
        this.f103952h.d("createSpeechEngine", "initializeEngine (state=" + SpeechEngineLoader.getInstance().state + ", result=" + r113 + ')');
        c r114 = this.f103948d;
        if (r114 == null) goto L39;
        r114.c(r113);
    L39:
        if (r113 == 0) goto L41;
        r106.destroyEngine();
        r106 = null;
    L42:
        if (r106 == null) goto L45;
        this.f103945a = r106;
        r105 = r106;
        goto L45
    L41:
        r106.setListener(this.f103951g);
    L27:
        r109 = null;
    L45:
        if (r105 != null) goto L47;
        this.f103952h.d("getSpeechEngine", "engine is null, skip " + r104);
        return;
    L47:
        r103.invoke(r105);
    }
}
