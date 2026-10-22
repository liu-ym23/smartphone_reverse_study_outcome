package com.bytedance.android.live.livepullstream;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.livepullstream.api.IPullStreamService;
import com.bytedance.android.live.livepullstream.service.h;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livehostapi.foundation.depend.PluginType;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.livesdk.config.t9;
import com.bytedance.android.livesdk.player.LiveStatusErrorView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.videoarch.liveplayer.i;
import com.tencent.open.SocialConstants;
import gl0.d;
import gl0.f;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tb1.c;

/* JADX INFO: loaded from: classes46.dex */
public class PullStreamService implements IPullStreamService {
    private static final String REASON_LOAD_SO_EXCEPTION = "load_exception";
    private static final String REASON_LOAD_SO_FAILED = "load_failed";
    private static final String REASON_LOAD_SUCCESS = "load_success";
    private static final String REASON_NULL_CONTEXT = "null_context";
    private static final String REASON_NULL_HOST_PLUGIN = "null_host_plugin";
    private static final String REASON_PULING_INSTALL_FAILED = "plugin_install_failed";
    private static final String REASON_PULING_INSTALL_SUCCESS = "plugin_install_success";
    private static final int SO_LOAD_FAILED = -1;
    private static final int SO_LOAD_SUCCESS = 0;
    private static final String SO_PLUGIN_TAG = "pull-stream-plugin-load";

    public class a implements IHostPlugin.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PullStreamService f82509a;

        public a(PullStreamService r100) {
            this.f82509a = r100;
        }

        @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin.Callback
        public final void onCancel(String r100) {
            PullStreamService.access$000(this.f82509a, r100, PullStreamService.REASON_PULING_INSTALL_FAILED, false);
            ALogger.d(PullStreamService.SO_PLUGIN_TAG, "pull stream so plugin install failed!");
        }

        @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin.Callback
        public final void onSuccess(String r100) {
            PullStreamService.access$000(this.f82509a, r100, PullStreamService.REASON_PULING_INSTALL_SUCCESS, true);
            ALogger.d(PullStreamService.SO_PLUGIN_TAG, "pull stream so plugin install success!");
        }
    }

    public class b implements IHostPlugin.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PullStreamService f82510a;

        public b(PullStreamService r100) {
            this.f82510a = r100;
        }

        @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin.Callback
        public final void onCancel(String r100) {
            PullStreamService.access$000(this.f82510a, r100, PullStreamService.REASON_PULING_INSTALL_FAILED, false);
            ALogger.d(PullStreamService.SO_PLUGIN_TAG, "bmf so plugin install failed!");
        }

        @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin.Callback
        public final void onSuccess(String r100) {
            PullStreamService.access$000(this.f82510a, r100, PullStreamService.REASON_PULING_INSTALL_SUCCESS, true);
            ALogger.d(PullStreamService.SO_PLUGIN_TAG, "bmf so plugin install success!");
        }
    }

    public PullStreamService() {
        k.l(IPullStreamService.class, this);
        if (c.f545229a == false) goto L10;
        if (c.f545231c == true) goto L10;
        if (LiveInitSettingKeys.get_LIVE_ENABLE_PULL_STREAM_SO_PLUGIN() == false) goto L10;
        ALogger.d(SO_PLUGIN_TAG, "setupLibraryLoader for douyin!");
        i.setupLibraryLoader(new fl0.a(this));
        return;
    L10:
        if (c.f545231c == true) goto L12;
        return;
    L12:
        if (LiveInitSettingKeys.get_LIVE_LITE_ENABLE_PLUGIN_ENV_LOAD() == false) goto L17;
        ALogger.d(SO_PLUGIN_TAG, "setupLibraryLoader for dylite!");
        i.setupLibraryLoader(new fl0.b(this));
        return;
    }

    @Override // com.bytedance.android.live.livepullstream.api.IPullStreamService
    public void tryInstallBMFPlugin() {
        if (LiveInitSettingKeys.get_LIVE_ENABLE_BMF_PLUGIN() == false) goto L5;
    L8:
        PluginType r100 = PluginType.LiveBMFSo;
        if (r100.isInstalled() == false) goto L11;
        return;
    L11:
        ALogger.d(SO_PLUGIN_TAG, "start install bmf so !");
        IHostPlugin r101 = (IHostPlugin) k.f(IHostPlugin.class);
        if (r101 != null) goto L15;
        ALogger.d(SO_PLUGIN_TAG, "null IHostPlugin");
        return;
    L15:
        Application r102 = jc1.a.b();
        if (r102 != null) goto L19;
        ALogger.d(SO_PLUGIN_TAG, "null context");
        return;
    L19:
        r101.check(r102, r100, "", new b(this), false);
        return;
    L5:
        if (t9.f121279a.getValue().enable() == true) goto L8;
        ALogger.d(SO_PLUGIN_TAG, "live_enable_bmf_plugin: false ! tryInstallPullStreamPlugin failed");
    }

    @Override // com.bytedance.android.live.livepullstream.api.IPullStreamService
    public void tryInstallPullStreamPlugin() {
        if (LiveInitSettingKeys.get_LIVE_ENABLE_PULL_STREAM_SO_PLUGIN() == true) goto L6;
        ALogger.d(SO_PLUGIN_TAG, "live_enable_pull_stream_so_plugin: false ! tryInstallPullStreamPlugin failed");
        return;
    L6:
        PluginType r100 = PluginType.PullSo;
        if (r100.isInstalled() == false) goto L9;
        return;
    L9:
        ALogger.d(SO_PLUGIN_TAG, "start install pull stream so !");
        IHostPlugin r101 = (IHostPlugin) k.f(IHostPlugin.class);
        if (r101 != null) goto L13;
        ALogger.d(SO_PLUGIN_TAG, "null IHostPlugin");
        return;
    L13:
        Application r102 = jc1.a.b();
        if (r102 != null) goto L17;
        ALogger.d(SO_PLUGIN_TAG, "null context");
        return;
    L17:
        r101.check(r102, r100, "", new a(this), false);
    }

    @Override // com.bytedance.android.live.livepullstream.api.IPullStreamService
    public gl0.c getLivePlayerOptimizer() {
        return com.bytedance.android.live.livepullstream.service.c.f82515b;
    }

    @Override // com.bytedance.android.live.livepullstream.api.IPullStreamService
    public f getStreamStrategyOptimizer() {
        return h.f82523d;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILibraryService
    public int loadLibrary(String r100) {
        return loadLibrary(0, r100, null);
    }

    @Override // com.bytedance.android.live.livepullstream.api.IPullStreamService
    public ILivePlayerClient getLivePlayerClient(long r100, Bundle r101) {
        Boolean r102 = com.bytedance.android.live.livepullstream.service.c.f82514a;
        return LivePlatformPlayerManager.c(r100, com.bytedance.android.live.livepullstream.service.c.d(r101)).player();
    }

    @Override // com.bytedance.android.live.livepullstream.api.IPullStreamService
    public d getLiveStatusErrorView(Context r100, ILivePlayerScene r101) {
        return new LiveStatusErrorView(r100, r101);
    }

    public boolean loadPluginLibrary(String r110, String r111) {
        ALogger.d(SO_PLUGIN_TAG, "loadPluginLibrary!");
        IHostPlugin r100 = (IHostPlugin) k.f(IHostPlugin.class);
        if (r100 != null) goto L6;
        monitorSoLoad(r110, REASON_NULL_HOST_PLUGIN, false);
        ALogger.d(SO_PLUGIN_TAG, "null IHostPlugin");
        return false;
    L6:
        Application r101 = jc1.a.b();
        if (r101 != null) goto L23;
        monitorSoLoad(r110, REASON_NULL_CONTEXT, false);
        ALogger.d(SO_PLUGIN_TAG, "null context");
        return false;
    L23:
    L17:
        th = move-exception;
        if (v.a() == true) goto L22;
        monitorSoLoad(r110, REASON_LOAD_SO_EXCEPTION, false);
        ALogger.d(SO_PLUGIN_TAG, "load " + r110 + " so failed! " + th.getMessage());
        return false;
    L22:
        throw th;
    L12:
        if (r100.loadLibrary(4, r101, r111, r110, null) == false) goto L15;
        monitorSoLoad(r110, REASON_LOAD_SUCCESS, true);     // Catch: Throwable -> L17
        ALogger.d(SO_PLUGIN_TAG, "load " + r110 + " so success!");     // Catch: Throwable -> L17
        return true;
    L15:
        ALogger.d(SO_PLUGIN_TAG, "load " + r110 + " so failed!");     // Catch: Throwable -> L17
        monitorSoLoad(r110, REASON_LOAD_SO_FAILED, false);     // Catch: Throwable -> L17
        return false;
    }

    @Override // com.bytedance.android.live.livepullstream.api.IPullStreamService
    public boolean prePullStream(long r100, Bundle r101) {
        return com.bytedance.android.live.livepullstream.service.c.f82515b.c(r100, r101);
    }

    private void monitorSoLoad(String r100, String r101, boolean r102) {
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L4
        r103.put("name", r100);     // Catch: JSONException -> L4
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L4
        r104.put("result", r102);     // Catch: JSONException -> L4
        r104.put(SocialConstants.PARAM_APP_DESC, r101);     // Catch: JSONException -> L4
        LiveTracingMonitor.e("ttlive_pull_stream_so_load", LiveTracingMonitor.EventModule.PULL_STREAM, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r103, r104, null);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        ALogger.d(SO_PLUGIN_TAG, "report so load log failed " + e.getMessage());
    }

    @Override // com.bytedance.android.livesdkapi.service.ILibraryService
    public int loadLibrary(int r110, String r111, ClassLoader r112) {
        if (LiveInitSettingKeys.get_LIVE_ENABLE_PULL_STREAM_SO_PLUGIN() == true) goto L6;
        ALogger.i(SO_PLUGIN_TAG, "live_enable_pull_stream_so_plugin: false ! load $soName failed");
        return -1;
    L6:
        ALogger.i(SO_PLUGIN_TAG, "loadLibrary " + r111 + " so");
        IHostPlugin r100 = (IHostPlugin) k.f(IHostPlugin.class);
        if (r100 != null) goto L10;
        monitorSoLoad(r111, REASON_NULL_HOST_PLUGIN, false);
        ALogger.i(SO_PLUGIN_TAG, "null IHostPlugin");
        return -1;
    L10:
        Application r101 = jc1.a.b();
        if (r101 != null) goto L14;
        monitorSoLoad(r111, REASON_NULL_CONTEXT, false);
        ALogger.i(SO_PLUGIN_TAG, "null context");
        return -1;
    L14:
        PluginType r102 = PluginType.PullSo;
        if (r102.isInstalled() == false) goto L26;
        ALogger.i(SO_PLUGIN_TAG, "start load " + r111 + " so , current is full pkg : " + r100.isFull());
    L23:
        th = move-exception;
        monitorSoLoad(r111, REASON_LOAD_SO_EXCEPTION, false);
        ALogger.i(SO_PLUGIN_TAG, "load " + r111 + " so failed! " + th.getMessage());
        return -1;
    L18:
        if (r100.loadLibrary(r110, r101, r102.getPackageName(), r111, r112) == false) goto L21;
        monitorSoLoad(r111, REASON_LOAD_SUCCESS, true);     // Catch: Throwable -> L23
        ALogger.i(SO_PLUGIN_TAG, "load " + r111 + " so success!");     // Catch: Throwable -> L23
        return 0;
    L21:
        ALogger.i(SO_PLUGIN_TAG, "load " + r111 + " so failed!");     // Catch: Throwable -> L23
        monitorSoLoad(r111, REASON_LOAD_SO_FAILED, false);     // Catch: Throwable -> L23
        return -1;
    L26:
        ALogger.i(SO_PLUGIN_TAG, "load " + r111 + " failed! plugin not install");
        return -1;
    }

    @Override // com.bytedance.android.live.livepullstream.api.IPullStreamService
    public boolean preCreateSurface(Context r100, long r101, Bundle r102) {
        return com.bytedance.android.live.livepullstream.service.c.f82515b.b(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.livepullstream.api.IPullStreamService
    public void useSurfaceControl(Context r100, long r101, Bundle r102) {
        Boolean r103 = com.bytedance.android.live.livepullstream.service.c.f82514a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "bundle");
        LivePlatformPlayerManager.c(r101, com.bytedance.android.live.livepullstream.service.c.d(r102)).l(r100, r102);
    }

    public static /* synthetic */ void access$000(PullStreamService r100, String r101, String r102, boolean r103) {
        r100.monitorSoLoad(r101, r102, r103);
    }
}
