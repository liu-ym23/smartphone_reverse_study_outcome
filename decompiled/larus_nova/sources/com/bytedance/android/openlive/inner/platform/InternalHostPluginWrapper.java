package com.bytedance.android.openlive.inner.platform;

import android.content.Context;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livehostapi.foundation.depend.IExoPlayer;
import com.bytedance.android.livehostapi.foundation.depend.IPluginType;
import com.bytedance.android.openlive.inner.host.IOpenHostPlugin;
import com.bytedance.android.openlive.inner.host.IPluginCallback;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J.\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J6\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\u0012\u0010 \u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J%\u0010!\u001a\u0004\u0018\u0001H\"\"\u0004\b\u0000\u0010\"2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u0002H\"\u0018\u00010$H\u0016¢\u0006\u0002\u0010%J\u0012\u0010&\u001a\u00020'2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010(\u001a\u00020\u0013H\u0016J\u0012\u0010)\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010*\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J8\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020'2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010-\u001a\u0004\u0018\u00010\u000f2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016JF\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u0001012\u0006\u0010,\u001a\u00020'2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010-\u001a\u0004\u0018\u00010\u000f2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00102\u001a\u00020\tH\u0002J\u001a\u00103\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u00064"}, d2 = {"Lcom/bytedance/android/openlive/inner/platform/InternalHostPluginWrapper;", "Lcom/bytedance/android/livehostapi/foundation/IHostPlugin;", "openHostPlugin", "Lcom/bytedance/android/openlive/inner/host/IOpenHostPlugin;", "(Lcom/bytedance/android/openlive/inner/host/IOpenHostPlugin;)V", "getOpenHostPlugin", "()Lcom/bytedance/android/openlive/inner/host/IOpenHostPlugin;", "setOpenHostPlugin", "check", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "pluginType", "Lcom/bytedance/android/livehostapi/foundation/depend/IPluginType;", "eventModule", "", "callback", "Lcom/bytedance/android/livehostapi/foundation/IHostPlugin$Callback;", "showDialog", "", "checkPluginInstalled", "packageName", "checkPluginLoaded", "createExoPlayerWrapper", "Lcom/bytedance/android/livehostapi/foundation/depend/IExoPlayer;", "listener", "Lcom/bytedance/android/livehostapi/foundation/depend/IExoPlayer$PlayerListener;", "enableMiraClassLoaderOpt", "exoPlayerPluginReady", "getCameraPluginPackage", "getHostModeFilePath", "getHostPackageName", "getNativeLibraryDir", "getOrNull", ExifInterface.GPS_DIRECTION_TRUE, "clz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "getPluginAttributeMinVersion", "", "isFull", "isPlugin", "load", "loadLibrary", "type", EffectConfiguration.KEY_PROVIDER_NAME, "classLoader", "Ljava/lang/ClassLoader;", "loadLibraryV2", "Landroid/util/Pair;", "notImplemented", "preload", "live-inner-host-integration-default_release"}, k = 1, mv = {1, 4, 3})
public final class InternalHostPluginWrapper implements IHostPlugin {
    private IOpenHostPlugin openHostPlugin;

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public boolean checkPluginLoaded(String r100) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public IExoPlayer createExoPlayerWrapper(Context r100, IExoPlayer.PlayerListener r101) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public boolean exoPlayerPluginReady() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public String getHostModeFilePath() {
        return "";
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public String getNativeLibraryDir(String r100) {
        return "";
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public int getPluginAttributeMinVersion(String r100) {
        return -1;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public boolean isFull() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public boolean isPlugin(String r100) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public boolean load(String r100) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public String getHostPackageName() {
        IOpenHostPlugin r100 = this.openHostPlugin;
        if (r100 == null) goto L6;
        String r101 = r100.getHostPackageName();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "com.ss.android.open.live.resource";
    }

    private final void notImplemented() {
        if ((!v.a()) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Not implemented on saas".toString());
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public boolean enableMiraClassLoaderOpt() {
        notImplemented();
        return false;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public String getCameraPluginPackage() {
        notImplemented();
        return null;
    }

    public final IOpenHostPlugin getOpenHostPlugin() {
        return this.openHostPlugin;
    }

    public InternalHostPluginWrapper(IOpenHostPlugin r100) {
        this.openHostPlugin = r100;
        k.l(IHostPlugin.class, this);
        IOpenHostPlugin r101 = this.openHostPlugin;
        if (r101 == null) goto L6;
        k.l(IOpenHostPlugin.class, r101);
        return;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public boolean checkPluginInstalled(String r100) {
        IOpenHostPlugin r101 = this.openHostPlugin;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.checkPluginInstalled(r100);
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public <T> T getOrNull(Class<T> r100) {
        notImplemented();
        return null;
    }

    public final void setOpenHostPlugin(IOpenHostPlugin r100) {
        this.openHostPlugin = r100;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public void preload(String r100, IHostPlugin.Callback r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        IOpenHostPlugin r102 = this.openHostPlugin;
        if (r102 == null) goto L6;
        r102.preload(r100);
        return;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public void check(Context r100, IPluginType r101, String r102, final IHostPlugin.Callback r103) {
        Intrinsics.checkNotNullParameter(r101, "pluginType");
        IPluginCallback r104 = new InternalHostPluginWrapper$check$pluginCallback$1(r103);
        IOpenHostPlugin r105 = this.openHostPlugin;
        if (r105 == null) goto L6;
        r105.check(r100, r101.getPackageName(), r102, r104);
        return;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public void check(Context r100, IPluginType r101, String r110, final IHostPlugin.Callback r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r101, "pluginType");
        IPluginCallback r102 = new InternalHostPluginWrapper$check$pluginCallback$2(r111);
        IOpenHostPlugin r103 = this.openHostPlugin;
        if (r103 == null) goto L6;
        r103.check(r100, r101.getPackageName(), r110, r102, r112);
        return;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public boolean loadLibrary(int r100, Context r101, String r102, String r110, ClassLoader r111) {
        IOpenHostPlugin r103 = this.openHostPlugin;
        if (r103 != null) goto L7;
        return false;
    L7:
        return r103.loadLibrary(r100, r101, r102, r110, r111);
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public Pair<Boolean, String> loadLibraryV2(int r100, Context r101, String r102, String r103, ClassLoader r104) {
        notImplemented();
        return null;
    }
}
