package com.bytedance.android.live.saas.middleware.utils;

import android.util.Pair;
import com.bytedance.common.utility.reflect.JavaCalls;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0006R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/utils/PluginInfoUtils;", "", "()V", "pluginVersion", "Landroid/util/Pair;", "", "", "getPluginVersion", "()Landroid/util/Pair;", "setPluginVersion", "(Landroid/util/Pair;)V", "checkPluginVersion", "", "getPluginVersionCode", "getPluginVersionName", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class PluginInfoUtils {
    public static final PluginInfoUtils INSTANCE = null;
    private static Pair<Long, String> pluginVersion;

    private PluginInfoUtils() {
    }

    static {
        INSTANCE = new PluginInfoUtils();
    }

    private final void checkPluginVersion() {
        if (pluginVersion != null) goto L6;
        pluginVersion = (Pair) JavaCalls.callStaticMethod("com.bytedance.android.openlive.plugin.LivePluginApplication", "getPluginVersion", new Object[0]);
        return;
    }

    public final long getPluginVersionCode() {
        checkPluginVersion();
        Pair<Long, String> r100 = pluginVersion;
        if (r100 == null) goto L8;
        Long r101 = (Long) r100.first;
        if (r101 == null) goto L8;
        return r101.longValue();
    L8:
        return 4210;
    }

    public final String getPluginVersionName() {
        checkPluginVersion();
        Pair<Long, String> r100 = pluginVersion;
        if (r100 == null) goto L6;
        String r101 = (String) r100.second;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "4.2.1.0";
    }

    public final Pair<Long, String> getPluginVersion() {
        return pluginVersion;
    }

    public final void setPluginVersion(Pair<Long, String> r100) {
        pluginVersion = r100;
    }
}
