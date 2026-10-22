package com.bytedance.android.livehostapi.foundation.depend;

import android.content.Context;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FilenameFilter;
import jc1.k;

/* JADX INFO: loaded from: classes7.dex */
public enum PluginType extends Enum<PluginType> implements IPluginType {
    private static final /* synthetic */ PluginType[] $VALUES = null;
    public static final PluginType AsrSo = null;
    public static final PluginType BaseSo = null;
    public static final PluginType Camera = null;
    public static final PluginType IESVideoClipLibPlugin = null;
    public static final PluginType LITE_PLAYER_CONTAINER = null;
    public static final PluginType Live = null;
    public static final PluginType LiveBMFSo = null;
    public static final PluginType LivePcdnDouyin = null;
    public static final PluginType LiveProjectScreenDouyin = null;
    public static final PluginType LiveProjectScreenHotsoon = null;
    public static final PluginType LiveSDK = null;
    public static final PluginType MiniGameEngine = null;
    public static final PluginType Player = null;
    public static final PluginType PullSo = null;
    public static final PluginType SaaSLiveResource = null;
    public static final PluginType Search = null;
    private static final String TAG = "PluginType";
    public static final PluginType XGPlayer = null;
    private final boolean mNeedPreload;
    private final String mPackageName;
    private String[] mPluginSoFiles;
    private final FilenameFilter mSoFileFilter;
    private final String mType;

    public static /* synthetic */ boolean a(File r100, String r101) {
        return lambda$new$0(r100, r101);
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public void load(Context r100, boolean r101) {
    }

    static {
        PluginType r100 = new PluginType("BaseSo", 0, "base_so", true, "com.ss.android.live.baseso");
        BaseSo = r100;
        final String r101 = "Camera";
        final int r102 = 1;
        final String r110 = "camera";
        final boolean r111 = true;
        final String r112 = "com.ss.android.ugc.live.liveshortvideo_so";
        PluginType r103 = new AnonymousClass1(r101, r102, r110, r111, r112);
        Camera = r103;
        PluginType r104 = new PluginType("LiveSDK", 2, "live_sdk", true, "com.ss.android.ies.live.sdk");
        LiveSDK = r104;
        PluginType r105 = new PluginType("Player", 3, "player", false, "com.ss.android.ugc.live.player");
        Player = r105;
        PluginType r106 = new PluginType("XGPlayer", 4, "player", false, "com.ss.ttm");
        XGPlayer = r106;
        PluginType r107 = new PluginType("LITE_PLAYER_CONTAINER", 5, "player", false, "com.bytedance.article.lite.plugin.ttplayer");
        LITE_PLAYER_CONTAINER = r107;
        PluginType r108 = new PluginType("Live", 6, "liveplugin", false, "com.bytedance.android.liveplugin");
        Live = r108;
        final String r109 = "MiniGameEngine";
        final int r113 = 7;
        final String r114 = "minigamelite";
        final boolean r115 = true;
        final String r116 = "com.ss.android.ugc.aweme.minigamelite";
        PluginType r117 = new AnonymousClass2(r109, r113, r114, r115, r116);
        MiniGameEngine = r117;
        final boolean r118 = false;
        PluginType r119 = new PluginType("LiveProjectScreenDouyin", 8, "liveprojectcreenplugin", false, "com.ss.android.ugc.aweme.projectscreen_plugin");
        LiveProjectScreenDouyin = r119;
        final boolean r210 = false;
        PluginType r120 = new PluginType("LiveProjectScreenHotsoon", 9, "liveprojectcreenplugin", false, "com.ss.android.ugc.live.liveprojectscreenplugin");
        LiveProjectScreenHotsoon = r120;
        PluginType r121 = new PluginType("PullSo", 10, "pull_so", false, "com.ss.android.live.pullstreamso");
        PullSo = r121;
        PluginType r122 = new PluginType("LiveBMFSo", 11, "bmf_so", false, "com.ss.android.ugc.aweme.pgo");
        LiveBMFSo = r122;
        final String r123 = "LivePcdnDouyin";
        final int r124 = 12;
        final String r125 = "livepcdn";
        final String r126 = "com.ss.android.ugc.aweme.pcdn";
        PluginType r127 = new AnonymousClass3(r123, r124, r125, r118, r126);
        LivePcdnDouyin = r127;
        final String r211 = "AsrSo";
        final int r212 = 13;
        final String r213 = "asr_so";
        final String r214 = "com.ss.android.ugc.aweme.asrso";
        PluginType r128 = new AnonymousClass4(r211, r212, r213, r210, r214);
        AsrSo = r128;
        PluginType r215 = new PluginType("Search", 14, "search_plugin", false, "com.ss.android.ugc.aweme.search_lite_plugin");
        Search = r215;
        final String r216 = "IESVideoClipLibPlugin";
        final int r217 = 15;
        final String r218 = "iesvideocliplib_plugin";
        final boolean r219 = true;
        final String r220 = "com.ss.android.ugc.aweme.iesvideoclip";
        PluginType r129 = new AnonymousClass5(r216, r217, r218, r219, r220);
        IESVideoClipLibPlugin = r129;
        final String r221 = "SaaSLiveResource";
        final int r222 = 16;
        final String r310 = "live_engine";
        final boolean r311 = true;
        final String r312 = "com.ss.android.live.broadcast";
        PluginType r130 = new AnonymousClass6(r221, r222, r310, r311, r312);
        SaaSLiveResource = r130;
        $VALUES = new PluginType[]{r100, r103, r104, r105, r106, r107, r108, r117, r119, r120, r121, r122, r127, r128, r215, r129, r130};
    }

    public static PluginType[] values() {
        return (PluginType[]) $VALUES.clone();
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public boolean checkLoaded() {
        return ((IHostPlugin) k.f(IHostPlugin.class)).checkPluginLoaded(this.mPackageName);
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public boolean isInstalled() {
        IHostPlugin r100 = (IHostPlugin) k.f(IHostPlugin.class);
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = r100.isFull();
        boolean r102 = r100.checkPluginInstalled(getPackageName());
        if (r101 == true) goto L8;
        if (r102 == true) goto L8;
        return false;
    L8:
        return true;
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public boolean isPlugin() {
        IHostPlugin r100 = (IHostPlugin) k.f(IHostPlugin.class);
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isPlugin(getPackageName());
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public boolean load() {
        return ((IHostPlugin) k.f(IHostPlugin.class)).load(this.mPackageName);
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public void preload() {
        IHostPlugin r100 = (IHostPlugin) k.f(IHostPlugin.class);
        if (r100 == null) goto L6;
        r100.preload(getPackageName(), null);
        return;
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public String[] getPluginSoFiles() {
        long r100 = System.currentTimeMillis();
        String r101 = getPackageName();
        if (this.mPluginSoFiles != null) goto L11;
        String r102 = ((IHostPlugin) k.f(IHostPlugin.class)).getNativeLibraryDir(r101);
        if (r102 != null) goto L8;
        return null;
    L8:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102);
        if (r103.isDirectory() == false) goto L11;
        this.mPluginSoFiles = r103.list(this.mSoFileFilter);
    L11:
        String.format("%s getPluginSoFiles cost: %s ms", new Object[]{this.mPackageName, Long.valueOf(System.currentTimeMillis() - r100)});
        return this.mPluginSoFiles;
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public String getPackageName() {
        return this.mPackageName;
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public String getType() {
        return this.mType;
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public boolean isNeedPreload() {
        return this.mNeedPreload;
    }

    public static PluginType valueOf(String r100) {
        return (PluginType) r27.a.a(PluginType.class, r100);
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public void preload(IHostPlugin.Callback r100) {
        IHostPlugin r101 = (IHostPlugin) k.f(IHostPlugin.class);
        if (r101 == null) goto L6;
        r101.preload(getPackageName(), r100);
        return;
    }

    private static /* synthetic */ boolean lambda$new$0(File r100, String r101) {
        if (r101.startsWith("lib") == true) goto L5;
    L7:
        return false;
    L5:
        if (r101.endsWith(".so") == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public void checkInstall(Context r100, IHostPlugin.Callback r101) {
        checkInstall(r100, "", r101);
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public void checkInstall(Context r100, String r101, IHostPlugin.Callback r102) {
        if (isInstalled() == false) goto L7;
        if (r102 == null) goto L9;
        r102.onSuccess(getPackageName());
        return;
    L9:
        return;
    L7:
        ((IHostPlugin) k.f(IHostPlugin.class)).check(r100, this, r101, r102);
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public void checkInstall(Context r100, String r101, IHostPlugin.Callback r110, boolean r111) {
        if (isInstalled() == false) goto L7;
        if (r110 == null) goto L9;
        r110.onSuccess(getPackageName());
        return;
    L9:
        return;
    L7:
        ((IHostPlugin) k.f(IHostPlugin.class)).check(r100, this, r101, r110, r111);
    }

    private PluginType(String r100, int r101, String r102, boolean r103, String r104) {
        super(r100, r101);
        this.mSoFileFilter = new c();
        this.mType = r102;
        this.mNeedPreload = r103;
        this.mPackageName = r104;
    }

    public /* synthetic */ PluginType(String r100, int r101, String r102, boolean r103, String r104, AnonymousClass1 r105) {
        this(r100, r101, r102, r103, r104);
    }
}
