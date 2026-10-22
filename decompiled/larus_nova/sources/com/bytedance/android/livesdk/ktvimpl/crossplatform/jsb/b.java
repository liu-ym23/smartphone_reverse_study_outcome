package com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb;

import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.VideoChorusPlayerProxy;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import hg6.g;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f143784g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f143785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f143786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Function1<JsonObject, JsonObject>> f143787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Function1<JsonObject, JsonObject>> f143788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c f143789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j1 f143790f;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.android.live.pushstream.d b() {
        j1 r100 = this.f143790f;
        if (r100 == null) goto L11;
        cg6.a r101 = (cg6.a) r100.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r101 == null) goto L11;
        g r102 = r101.getRtcManager();
        if (r102 == null) goto L11;
        ec6.b r103 = r102.R();
        if (r103 == null) goto L11;
        return gc6.b.a(r103);
    L11:
        return null;
    }

    public final com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b c() {
        return this.f143789e.k();
    }

    public final void a() {
        com.bytedance.android.live.pushstream.d r100 = b();
        if (r100 == null) goto L6;
        r100.u();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb.a
    public final JsonObject handleDynamicJsbGetAction(JsonObject r100) {
        if (r100 == null) goto L17;
        JsonElement r101 = r100.get("act_type");
        if (r101 == null) goto L18;
        String r102 = r101.getAsString();
        if (r102 == null) goto L19;
        JsonElement r103 = r100.get("params");
        if ((r103 instanceof JsonObject) == true) goto L11;
        r103 = null;
    L11:
        JsonObject r104 = (JsonObject) r103;
        if (r104 == null) goto L20;
        Function1<JsonObject, JsonObject> r105 = this.f143787c.get(r102);
        if (r105 != null) goto L16;
        return null;
    L16:
        return r105.invoke(r104);
    L20:
        return null;
    L19:
        return null;
    L18:
        return null;
    L17:
        return null;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb.a
    public final JsonObject handleDynamicJsbUpdateAction(JsonObject r100) {
        if (r100 == null) goto L17;
        JsonElement r101 = r100.get("act_type");
        if (r101 == null) goto L18;
        String r102 = r101.getAsString();
        if (r102 == null) goto L19;
        JsonElement r103 = r100.get("params");
        if ((r103 instanceof JsonObject) == true) goto L11;
        r103 = null;
    L11:
        JsonObject r104 = (JsonObject) r103;
        if (r104 == null) goto L20;
        Function1<JsonObject, JsonObject> r105 = this.f143788d.get(r102);
        if (r105 != null) goto L16;
        return null;
    L16:
        return r105.invoke(r104);
    L20:
        return null;
    L19:
        return null;
    L18:
        return null;
    L17:
        return null;
    }

    public b(VideoChorusPlayerProxy r110, j1 r111) {
        Intrinsics.checkNotNullParameter(r110, "ktvPlayerProxy");
        this.f143789e = r110;
        this.f143790f = r111;
        this.f143785a = LazyKt.lazy(KtvJsbHandler$callDurationMax$2.INSTANCE);
        this.f143786b = new CompositeDisposable();
        this.f143787c = MapsKt.mapOf(new Pair[]{TuplesKt.to("isOriginState", new KtvJsbHandler$actionGetHandlers$1(this)), TuplesKt.to("isMusicAvailable", new KtvJsbHandler$actionGetHandlers$2(this)), TuplesKt.to("getOrederedSongList", new KtvJsbHandler$actionGetHandlers$3(this)), TuplesKt.to("getMidiAverageScore", new KtvJsbHandler$actionGetHandlers$4(this)), TuplesKt.to("getMidiScoreInfo", new KtvJsbHandler$actionGetHandlers$5(this)), TuplesKt.to("isSupportEarMonitor", new KtvJsbHandler$actionGetHandlers$6(this)), TuplesKt.to("getPitchShift", new KtvJsbHandler$actionGetHandlers$7(this)), TuplesKt.to("isEnableLoudNorm", new KtvJsbHandler$actionGetHandlers$8(this)), TuplesKt.to("getHeadSetState", new KtvJsbHandler$actionGetHandlers$9(this)), TuplesKt.to("getPlayerVolume", new KtvJsbHandler$actionGetHandlers$10(this))});
        this.f143788d = MapsKt.mapOf(new Pair[]{TuplesKt.to("playMusic", new KtvJsbHandler$actionUpdateHandlers$1(this)), TuplesKt.to("pauseMusic", new KtvJsbHandler$actionUpdateHandlers$2(this)), TuplesKt.to("createMusicPlayer", new KtvJsbHandler$actionUpdateHandlers$3(this)), TuplesKt.to("destroyMusicPlayer", new KtvJsbHandler$actionUpdateHandlers$4(this)), TuplesKt.to("seekMusic", new KtvJsbHandler$actionUpdateHandlers$5(this)), TuplesKt.to("setOriginEnable", new KtvJsbHandler$actionUpdateHandlers$6(this)), TuplesKt.to("setOnlyMixWithRTC", new KtvJsbHandler$actionUpdateHandlers$7(this)), TuplesKt.to("setMixerEnable", new KtvJsbHandler$actionUpdateHandlers$8(this)), TuplesKt.to("downloadMusic", new KtvJsbHandler$actionUpdateHandlers$9(this)), TuplesKt.to("sendSei", new KtvJsbHandler$actionUpdateHandlers$10(this)), TuplesKt.to("setEchoMode", new KtvJsbHandler$actionUpdateHandlers$11(this)), TuplesKt.to("setEarMonitorVolume", new KtvJsbHandler$actionUpdateHandlers$12(this)), TuplesKt.to("setPitchShift", new KtvJsbHandler$actionUpdateHandlers$13(this)), TuplesKt.to("setLoudNormParams", new KtvJsbHandler$actionUpdateHandlers$14(this)), TuplesKt.to("setEnableLoudNorm", new KtvJsbHandler$actionUpdateHandlers$15(this)), TuplesKt.to("setKtvEffect", new KtvJsbHandler$actionUpdateHandlers$16(this)), TuplesKt.to("downloadTuningEffect", new KtvJsbHandler$actionUpdateHandlers$17(this)), TuplesKt.to("setVoiceVolume", new KtvJsbHandler$actionUpdateHandlers$18(this)), TuplesKt.to("setOthersVolume", new KtvJsbHandler$actionUpdateHandlers$19(this)), TuplesKt.to("setPlayerVolume", new KtvJsbHandler$actionUpdateHandlers$20(this)), TuplesKt.to("setBgmPlayerVolume", new KtvJsbHandler$actionUpdateHandlers$21(this)), TuplesKt.to("setBGMPushVolume", new KtvJsbHandler$actionUpdateHandlers$22(this)), TuplesKt.to("notifySingStateChanged", new KtvJsbHandler$actionUpdateHandlers$23(this)), TuplesKt.to("openOrderSongPanel", new KtvJsbHandler$actionUpdateHandlers$24(this))});
    }
}
