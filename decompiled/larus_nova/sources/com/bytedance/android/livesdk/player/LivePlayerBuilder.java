package com.bytedance.android.livesdk.player;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.SparseIntArray;
import com.bytedance.android.livesdk.player.model.LiveStreamData;
import com.bytedance.android.livesdk.player.utils.PlayerNetworkUtils;
import com.bytedance.android.livesdkapi.host.ILivePlayerHostService;
import com.bytedance.android.livesdkapi.model.PlayerConfig;
import com.bytedance.android.livesdkapi.model.PlayerDnsOptimizeConfig;
import com.bytedance.android.livesdkapi.model.PlayerLivePlayerConfig;
import com.bytedance.android.livesdkapi.model.SettingsExtraInfo;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.videoarch.liveplayer.VideoLiveManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class LivePlayerBuilder {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f154893i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f154894j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f154895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.videoarch.liveplayer.e f154896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.ss.videoarch.liveplayer.g0 f154897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f154898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LivePlayerBuilder$eventNotifier$1 f154899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Context f154900f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LivePlayerContext f154901g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ILivePlayerClient f154902h;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.ss.videoarch.liveplayer.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LivePlayerBuilder f154903a;

        public b(LivePlayerBuilder r100) {
            this.f154903a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.ss.videoarch.liveplayer.g
        public final <T> T getSettingsValueForKey(String r100, T r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "defaultValue");
            String r102 = null;
            Object r103 = null;
            Object r104 = null;
            if (Intrinsics.areEqual(r100, "time_diff_server_and_client") == false) goto L13;
            Object r105 = Long.valueOf(com.bytedance.android.livesdk.utils.ntp.a.f159087a);
            if ((r105 instanceof Object) == false) goto L8;
            r103 = r105;
        L8:
            if (r103 != null) goto L11;
            return r101;
        L11:
            return (T) r103;
        L13:
            if (Intrinsics.areEqual(r100, "network_type") == false) goto L25;
            Context r106 = this.f154903a.getContext();
            if (r106 == null) goto L25;
            Object r107 = PlayerNetworkUtils.b(r106);
            if ((r107 instanceof Object) == false) goto L20;
            r104 = r107;
        L20:
            if (r104 != null) goto L23;
            return r101;
        L23:
            return (T) r104;
        L25:
            if (((Boolean) LivePlayerBuilder.f154893i.getValue()).booleanValue() == true) goto L27;
        L31:
            LivePlayerService r108 = LivePlayerService.INSTANCE;
            ILivePlayerHostService r109 = r108.hostService();
            if (r109 == null) goto L45;
            LiveRequest r110 = this.f154903a.f154901g.f154925a;
            if (r110 == null) goto L36;
            r102 = r110.getEnterLiveSource();
        L36:
            if (r102 != null) goto L38;
            r102 = "";
        L38:
            T r111 = (T) r109.getSettingsValueForKey(r100, r101, new SettingsExtraInfo(r102, r108.clientIsPreviewUse(this.f154903a.f154901g.N)));
            if (r111 != null) goto L42;
            return r101;
        L42:
            return r111;
        L45:
            return r101;
        L27:
            if (Intrinsics.areEqual(r100, "live_sdk_texture_render_enable") == false) goto L31;
            T r112 = (T) LivePlayerBuilder.a(this.f154903a);
            if (r112 == null) goto L31;
            return r112;
        }
    }

    public static final class c implements com.ss.videoarch.liveplayer.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LivePlayerBuilder f154904a;

        public c(LivePlayerBuilder r100) {
            this.f154904a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.ss.videoarch.liveplayer.g
        public final <T> T getSettingsValueForKey(String r100, T r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "defaultValue");
            String r102 = null;
            Object r103 = null;
            Object r104 = null;
            if (Intrinsics.areEqual(r100, "time_diff_server_and_client") == false) goto L13;
            Object r105 = Long.valueOf(com.bytedance.android.livesdk.utils.ntp.a.f159087a);
            if ((r105 instanceof Object) == false) goto L8;
            r103 = r105;
        L8:
            if (r103 != null) goto L11;
            return r101;
        L11:
            return (T) r103;
        L13:
            if (Intrinsics.areEqual(r100, "network_type") == false) goto L25;
            Context r106 = this.f154904a.getContext();
            if (r106 == null) goto L25;
            Object r107 = PlayerNetworkUtils.b(r106);
            if ((r107 instanceof Object) == false) goto L20;
            r104 = r107;
        L20:
            if (r104 != null) goto L23;
            return r101;
        L23:
            return (T) r104;
        L25:
            if (((Boolean) LivePlayerBuilder.f154893i.getValue()).booleanValue() == true) goto L27;
        L31:
            LivePlayerService r108 = LivePlayerService.INSTANCE;
            ILivePlayerHostService r109 = r108.hostService();
            if (r109 == null) goto L45;
            LiveRequest r110 = this.f154904a.f154901g.f154925a;
            if (r110 == null) goto L36;
            r102 = r110.getEnterLiveSource();
        L36:
            if (r102 != null) goto L38;
            r102 = "";
        L38:
            T r111 = (T) r109.getSettingsValueForKey(r100, r101, new SettingsExtraInfo(r102, r108.clientIsPreviewUse(this.f154904a.f154901g.N)));
            if (r111 != null) goto L42;
            return r101;
        L42:
            return r111;
        L45:
            return r101;
        L27:
            if (Intrinsics.areEqual(r100, "live_sdk_texture_render_enable") == false) goto L31;
            T r112 = (T) LivePlayerBuilder.a(this.f154904a);
            if (r112 == null) goto L31;
            return r112;
        }
    }

    static {
        new a();
        f154893i = LazyKt.lazy(LivePlayerBuilder$Companion$sInterceptTextureRender$2.INSTANCE);
        f154894j = LazyKt.lazy(LivePlayerBuilder$Companion$sUseNewPullStreamSDK$2.INSTANCE);
    }

    public final TTLivePlayer b() {
        return new TTLivePlayer(this, this.f154899e, this.f154901g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.ss.videoarch.liveplayer.VideoLiveManager] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28 */
    public final VideoLiveManager c() {
        Context r100 = null;
        if (((Boolean) f154894j.getValue()).booleanValue() == false) goto L8;
        Context r101 = this.f154901g.getContext();
        if (r101 == null) goto L7;
        r100 = r101.getApplicationContext();
    L7:
        VideoLiveManager r102 = new VideoLiveManager(r100);
        r102.setNetworkClient(new s0());
        r102.setLiveEnsuer(new i());
        r102.setObserver(this.f154897c);
        com.ss.videoarch.liveplayer.w r103 = new com.ss.videoarch.liveplayer.w();
        r103.f459666i = this.f154898d;
        r103.f459662e = 50;
        r103.f459658a = true;
        r103.f459663f = true;
        r103.f459665h = "douyin_saas_game_live";
        Unit r104 = Unit.INSTANCE;
        r102.setConfig(r103);
        r102.setSettingsBundle(new b(this));
        Lazy r105 = LivePlayerAdapter.f154873a;
        LivePlayerClient r106 = this.f154901g.N;
        Intrinsics.checkNotNullParameter(r106, "client");
        r102.setIAppInfoFetcher(new l(r106));
        ?? r107 = r102;
    L16:
        LivePlayerService r108 = LivePlayerService.INSTANCE;
        if (((PlayerLivePlayerConfig) r108.getConfig(PlayerLivePlayerConfig.class)).getEnableUploadTimeLine() == false) goto L19;
        r107.enableUploadSessionSeries();
    L19:
        ILivePlayerHostService r109 = r108.hostService();
        if (r109 == null) goto L22;
        ?? r110 = r109.isFreeFlow();
    L23:
        PlayerDnsOptimizeConfig r111 = (PlayerDnsOptimizeConfig) r108.getConfig(PlayerDnsOptimizeConfig.class);
        if (r111.getEnable() == false) goto L40;
        if (r110 != 0) goto L27;
    L39:
        r107.setDns(LivePlayerService.INSTANCE.dnsOptimizer().c());
        goto L40
    L27:
        if (r111.getFreeFlowEnable() == true) goto L39;
        Context r112 = this.f154901g.getContext();
        String r113 = PlayerNetworkUtils.f156204a;
        NetworkInfo r114 = ((ConnectivityManager) r112.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L53
        if (r114 == null) goto L37;
        if (r114.isAvailable() == false) goto L37;
        if (1 != r114.getType()) goto L37;
        boolean r115 = true;
    L38:
        if (r115 == false) goto L40;
    L37:
        r115 = false;
    L40:
        LivePlayerService r116 = LivePlayerService.INSTANCE;
        if (((PlayerLivePlayerConfig) r116.getConfig(PlayerLivePlayerConfig.class)).getEnableHttpkDegrade() == false) goto L44;
        r107.setIntOption(39, 1);
    L44:
        if (((PlayerLivePlayerConfig) r116.getConfig(PlayerLivePlayerConfig.class)).getEnableBlurEffect() == false) goto L47;
        Bundle r117 = new Bundle();
        r117.putInt("action", 21);
        r117.putInt("effect_type", 10);
        r117.putInt(TextureRenderKeys.KEY_IS_USE_EFFECT, 0);
        r117.putFloat(TextureRenderKeys.KEY_IS_STRENGTH_FLOAT, this.f154895a);
        r107.setTextureRenderEffect(r117);
    L47:
        if (((PlayerConfig) r116.getConfig(PlayerConfig.class)).getExtraSurface() == false) goto L49;
        Bundle r118 = new Bundle();
        r118.putInt("action", 21);
        r118.putInt(TextureRenderKeys.KEY_IS_USE_EFFECT, 1);
        r118.putInt("effect_type", 11);
        r118.putFloat("x", 0.0f);
        r118.putFloat("y", 0.0f);
        r118.putFloat("width", 1.0f);
        r118.putFloat("height", 1.0f);
        r107.setTextureRenderEffect(r118);
    L49:
        r107.setIntOption(85, r110);
        ILivePlayerHostService r119 = r116.hostService();
        if (r119 == null) goto L52;
        r119.getColorWeakModelEffectInfo();
    L52:
        return r107;
    L22:
        r110 = 0;
        goto L23
    L8:
        Context r120 = this.f154901g.getContext();
        if (r120 == null) goto L11;
        r100 = r120.getApplicationContext();
    L11:
        VideoLiveManager.d0 r121 = VideoLiveManager.newBuilder(r100).setRetryTimeout(this.f154898d).setNetworkClient(new s0()).setForceHttpDns(false).setForceTTNetHttpDns(false).setPlayerType(1).setListener(this.f154896b).setSettingsBundle(new c(this));
        Lazy r122 = LivePlayerAdapter.f154873a;
        LivePlayerClient r123 = this.f154901g.N;
        Intrinsics.checkNotNullParameter(r123, "client");
        if (r121 == null) goto L15;
        r121.setAppInfoFecther(new k(r123));
    L15:
        r107 = r121.build();
        goto L16
    }

    public final Context getContext() {
        return this.f154900f;
    }

    public static final Integer a(LivePlayerBuilder r100) {
        LiveStreamData r101 = r100.f154901g.f154943s;
        if (r101 != null) goto L5;
    L7:
        LiveRequest r102 = r100.f154901g.f154925a;
        if (r102 == null) goto L14;
        int r103 = r102.getTextureRenderMode();
        if (r103 == 2) goto L17;
        if (r103 != 1) goto L14;
        return 1;
    L17:
        return 0;
    L14:
        return null;
    L5:
        if (r101.c() != true) goto L7;
        return 1;
    }

    public LivePlayerBuilder(Context r100, LivePlayerContext r101, ILivePlayerClient r102) {
        Intrinsics.checkNotNullParameter(r101, "playerContext");
        Intrinsics.checkNotNullParameter(r102, "client");
        this.f154900f = r100;
        this.f154901g = r101;
        this.f154902h = r102;
        this.f154895a = 20.0f;
        new SparseIntArray();
        this.f154898d = 300000;
        this.f154899e = new LivePlayerBuilder$eventNotifier$1(this);
    }
}
