package com.bytedance.android.live.platformplayer.effect;

import android.content.Context;
import com.bytedance.android.live.effect.api.IMiddlewareEffectService;
import com.bytedance.android.live.effect.api.r;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.filter.u;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.player.LivePlayerClient;
import com.bytedance.android.livesdk.player.LivePlayerContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.host.ILivePlayerALogger;
import com.bytedance.android.livesdkapi.host.ILivePlayerHostService;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.config.setting.LiveVr6DofEffectConfig;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.PlayerError;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectCallback;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectInitConfigBuilder;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectMessageListener;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectResourceFinder;
import com.bytedance.android.livesdkapi.vr.LiveVrEffectInfo;
import com.bytedance.android.livesdkapi.vr.VrEffectResourceLoadResult;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import jc1.k;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class VrEffectDownloader {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set<String> f85466g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f85467h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f85468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f85469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f85470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f85471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f85472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f85473f;

    public static final class a {
    }

    public static final class b implements VideoEffectCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VrEffectDownloader f85474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WeakReference f85475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ILivePlayerClient f85476c;

        @Override // com.bytedance.android.livesdkapi.roomplayer.VideoEffectCallback
        public final void onResult(PlayerError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            if (r100.getErrorCode() == 0) goto L5;
            com.bytedance.android.live.player.utils.b.e("error=" + r100);
            return;
        L5:
            ILivePlayerClient r101 = (ILivePlayerClient) this.f85475b.get();
            if (r101 == null) goto L20;
            boolean r102 = r101.isVrEffectPlusVersion();
            r101.setVrEffectLiteMode(r101.getVideoEffectSixDofLiteModeParams());
            boolean r103 = true;
            r101.setEnable(true, 2);
            if (r102 == false) goto L15;
            this.f85474a.getClass();
            o r104 = j0.l().c(IRoom.class);
            if (r104 == null) goto L15;
            if ((r104 instanceof u) == false) goto L15;
            ((u) r104).x();
        L15:
            if (this.f85474a.f85473f.length() > 0) goto L18;
            r103 = false;
        L18:
            if (r103 == false) goto L20;
            VrEffectDownloader r105 = this.f85474a;
            VrEffectDownloader.a(r105, r101, r105.f85473f, CollectionsKt.emptyList());
        L20:
            com.bytedance.android.live.player.utils.b.c("LiveVrEffect_VrEffectDownloader", "init success set enable,player=" + this.f85476c);
        }

        public b(VrEffectDownloader r100, WeakReference r101, ILivePlayerClient r102) {
            this.f85474a = r100;
            this.f85475b = r101;
            this.f85476c = r102;
        }
    }

    public static final class c implements VideoEffectMessageListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f85477a;

        public c(WeakReference r100) {
            this.f85477a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.roomplayer.VideoEffectMessageListener
        public final void onMessage(int r100, long r101, long r102, String r110) {
            com.bytedance.android.live.player.utils.b.c("LiveVrEffect_VrEffectDownloader", "onMessage=" + r100 + ',' + r101 + ',' + r102 + '.' + r110);
            if (r100 == 40) goto L5;
            return;
        L5:
            if (r101 == 104) goto L7;
            return;
        L7:
            if (r102 != 1000001) goto L17;
            if (r110 != null) goto L10;
            return;
        L10:
            ILivePlayerClient r103 = (ILivePlayerClient) this.f85477a.get();
            VrEffectResourceLoadResult r104 = (VrEffectResourceLoadResult) GsonProtectorUtils.fromJson(new Gson(), r110, VrEffectResourceLoadResult.class);
            if (r103 == null) goto L13;
            r103.updateVrEffectContextId(r104.getUnicId());
        L13:
            com.bytedance.android.live.player.utils.b.c("LiveVrEffect_VrEffectDownloader", "message to setup layer,unicId=" + r104.getUnicId() + ",player=" + r103);
            return;
        }
    }

    public static final class d implements VideoEffectResourceFinder {
        @Override // com.bytedance.android.livesdkapi.roomplayer.VideoEffectResourceFinder
        public final long createNativeResourceFinder(long r100) {
            return 0;
        }

        @Override // com.bytedance.android.livesdkapi.roomplayer.VideoEffectResourceFinder
        public final void release(long r100) {
        }

        public d() {
        }
    }

    static {
        f85466g = new LinkedHashSet();
        f85467h = "";
    }

    public VrEffectDownloader() {
        this.f85468a = -1;
        this.f85469b = -1;
        this.f85470c = -1;
        this.f85471d = -1;
        this.f85473f = "";
    }

    public final VideoEffectInitConfigBuilder f(ILivePlayerClient r110) {
        Intrinsics.checkNotNullParameter(r110, "player");
        if (LiveVr6DofEffectConfig.INSTANCE.getDisable() == false) goto L5;
        return null;
    L5:
        WeakReference r100 = new WeakReference(r110);
        b r101 = new b(this, r100, r110);
        c r102 = new c(r100);
        int r111 = com.bytedance.android.live.effect.a.f66704a;
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r112 = ILiveWrappedEffectSDKService.a.a();
        if (r112 == null) goto L8;
        r112.providerResourceFinder();
    L8:
        d r113 = new d();
        com.bytedance.android.live.platformplayer.service.a r114 = (com.bytedance.android.live.platformplayer.service.a) k.f(com.bytedance.android.live.platformplayer.service.a.class);
        if (r114 == null) goto L14;
        com.bytedance.android.live.platformplayer.effect.b r103 = r114.c4();
        if (r103 != null) goto L13;
        return null;
    L13:
        return com.bytedance.android.live.platformplayer.effect.b.a.a(r103, null, false, null, null, null, r102, r101, r113, 31);
    L14:
        return null;
    }

    public final void c(ILivePlayerClient r100, LiveVrEffectInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "playerClient");
        if (LiveVr6DofEffectConfig.INSTANCE.getDisable() == false) goto L6;
        return;
    L6:
        if (r101.getVrTransferType() <= 0) goto L8;
        boolean r102 = true;
    L10:
        if (r101.getMaterialId() > 0) goto L13;
        com.bytedance.android.live.player.utils.b.c("LiveVrEffect_VrEffectDownloader", "illegal material id");
        return;
    L13:
        if (r102 == false) goto L16;
        d(r100, String.valueOf(r101.getMaterialId()));
        return;
    L16:
        return;
    L8:
        r102 = false;
        goto L10
    }

    public final void d(final ILivePlayerClient r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "playerClient");
        if (LiveVr6DofEffectConfig.INSTANCE.getDisable() == false) goto L5;
        return;
    L5:
        com.bytedance.android.live.player.utils.b.c("LiveVrEffect_VrEffectDownloader", "effectid=" + r101);
        if (r101 != null) goto L8;
        r101 = f85467h;
    L10:
        if (r101.length() != 0) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == false) goto L15;
        return;
    L15:
        final boolean r103 = r100.isVrEffectPlusVersion();
        if (r103 == false) goto L23;
        o r104 = j0.l().c(IRoom.class);
        if (r104 == null) goto L23;
        if ((r104 instanceof u) == false) goto L23;
        ((u) r104).x();
    L23:
        if (this.f85468a >= 0) goto L25;
        this.f85468a = System.currentTimeMillis();
    L25:
        boolean r105 = tb1.c.f545231c;
        if (r105 == false) goto L28;
    L33:
        Context r106 = null;
        if ((r100 instanceof LivePlayerClient) == true) goto L36;
        ILivePlayerClient r107 = null;
    L37:
        LivePlayerClient r108 = (LivePlayerClient) r107;
        if (r108 == null) goto L42;
        LivePlayerContext r109 = r108.getPlayerContext();
        if (r109 == null) goto L42;
        r106 = r109.getContext();
    L42:
        Function0<Unit> r110 = new VrEffectDownloader$checkAndUpdateVrEffectResource$1(this, r100, r101, r103);
        Intrinsics.checkNotNullParameter(r110, "effectConsummer");
        if (r105 == true) goto L49;
        if (tb1.c.f545233e == true) goto L49;
        if (tb1.c.f545234f == true) goto L49;
        return;
    L49:
        if (((IMiddlewareHostApp) k.n(IMiddlewareHostApp.class)).isToolsPluginReady() == false) goto L51;
        com.bytedance.android.live.player.utils.b.g("LiveVrEffect_VrEffectDownloader", "tools plugin is ready");
        r110.invoke();
        return;
    L51:
        Intrinsics.checkNotNullParameter("LiveVrEffect_VrEffectDownloader", "tag");
        ILivePlayerHostService r111 = is0.c.c().hostService();
        if (r111 == null) goto L56;
        ILivePlayerALogger r112 = r111.alog();
        if (r112 == null) goto L56;
        r112.w("LiveVrEffect_VrEffectDownloader", "tools plugin is not ready try install");
    L57:
        IMiddlewareHostApp r113 = (IMiddlewareHostApp) k.f(IMiddlewareHostApp.class);
        if (r113 == null) goto L64;
        r113.installToolsPlugin(r106, new com.bytedance.android.live.platformplayer.effect.c(r110));
        return;
    L64:
        return;
    L56:
        Intrinsics.checkNotNull("tools plugin is not ready try install");
        goto L57
    L36:
        r107 = r100;
        goto L37
    L28:
        if (tb1.c.f545233e == true) goto L33;
        if (tb1.c.f545234f == true) goto L33;
        e(r100, r101, r103);
        return;
    L12:
        r102 = false;
        goto L13
    L8:
        f85467h = r101;
        goto L10
    }

    public final void e(ILivePlayerClient r100, final String r101, final boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "playerClient");
        Intrinsics.checkNotNullParameter(r101, "effectId");
        IMiddlewareEffectService r103 = (IMiddlewareEffectService) k.f(IMiddlewareEffectService.class);
        if (r103 == null) goto L5;
        r r104 = r103.vrEffectService();
    L6:
        if (r104 != null) goto L8;
        return;
    L8:
        com.bytedance.android.live.player.utils.b.c("LiveVrEffect_VrEffectDownloader", "do download effect");
        r104.a(r101, new VrEffectDownloader$doDownloadEffect$1(this, r100), new VrEffectDownloader$doDownloadEffect$2(this, r101, r102));
        return;
    L5:
        r104 = null;
        goto L6
    }

    public static final void a(VrEffectDownloader r100, ILivePlayerClient r101, String r102, List r103) {
        r100.getClass();
        if (r103 == null) goto L5;
        int r104 = r103.size();
    L7:
        if (r104 > 0) goto L9;
        String[] r105 = {""};
    L16:
        Object[] r106 = CollectionsKt.listOf(r102).toArray(new String[0]);
        if (r106 == null) goto L24;
        String[] r107 = (String[]) r106;
        com.bytedance.android.live.player.utils.b.c("LiveVrEffect_VrEffectDownloader", "setEffectResource,path=" + r102 + ",player=" + r101);
        f85466g.add(r102);
        if (r100.f85470c >= 0) goto L21;
        r100.f85470c = System.currentTimeMillis();
    L21:
        r100.f85473f = r102;
        r101.appendComposerNodes(r107, r105, new com.bytedance.android.live.platformplayer.effect.d(r100, r101, r101.isVrEffectPlusVersion()));
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L9:
        if (r103 == null) goto L15;
        Object[] r108 = r103.toArray(new String[0]);
        if (r108 == null) goto L14;
        r105 = (String[]) r108;
        goto L16
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L15:
        r105 = new String[]{""};
        goto L16
    L5:
        r104 = 0;
        goto L7
    }

    public static final void b(VrEffectDownloader r110, String r111, boolean r112, boolean r113) {
        if (r110.f85472e == true) goto L27;
        r110.f85472e = true;
        long r100 = r110.f85471d;
        long r101 = r100 - r110.f85470c;
        long r102 = r110.f85469b;
        long r103 = r110.f85468a;
        long r104 = r102 - r103;
        long r105 = r100 - r103;
        if (r101 < 0) goto L24;
        long r106 = 10000000;
        if (r101 <= r106) goto L10;
        return;
    L10:
        if (r104 >= 0) goto L12;
        return;
    L12:
        if (r104 > r106) goto L28;
        HashMap r114 = new HashMap();
        if (r113 == false) goto L17;
        String r115 = "6dof";
    L18:
        r114.put("vr_6dof_type", r115);
        r114.put("material_duration_all", String.valueOf(r105));
        r114.put("sever_material_duration", String.valueOf(r104));
        r114.put("client_material_duration", String.valueOf(r101));
        if (r112 == false) goto L21;
        String r116 = "1";
    L22:
        r114.put("material_load_state", r116);
        r114.put("material_id", r111);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_vr_effect_duration", r114, new Object[0]);
        return;
    L21:
        r116 = "0";
        goto L22
    L17:
        r115 = "non_6dof";
        goto L18
    L28:
        return;
    L24:
        return;
    }
}
