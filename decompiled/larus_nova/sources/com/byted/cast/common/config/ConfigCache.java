package com.byted.cast.common.config;

import android.text.TextUtils;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class ConfigCache {
    private static final String TAG = null;
    private ContextManager.CastContext mCastContext;
    private volatile Config mConfig;
    private final Object mConfigLock;
    private CastLogger mLogger;
    private Map<Integer, Object[]> sLocalConfig;
    private Map<String, Object> sLocalGrayConfig;
    private Map<String, Object> sRemoteGrayConfig;

    static {
        TAG = "ConfigCache";
    }

    public void clearInitConfig() {
        this.mLogger.i(TAG, "clearInitConfig");
        Object r100 = this.mConfigLock;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mConfig != null) goto L7;
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.mConfig.isInitialModeBind() == true) goto L9;
        this.mConfig = new Config();     // Catch: Throwable -> L11
        goto L9
    }

    public Config getInitConfig() {
        if (this.mConfig != null) goto L15;
        Object r100 = this.mConfigLock;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mConfig != null) goto L9;
        this.mConfig = new Config();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L15:
        return this.mConfig;
    }

    public Map<String, Object> getLocalGrayConfig() {
        HashMap r100 = new HashMap();
        Map<String, Object> r101 = this.sLocalGrayConfig;
        if (r101 == null) goto L5;
        r100.putAll(r101);
    L5:
        return r100;
    }

    public Map<String, Object> getRemoteGrayConfig() {
        if (this.sRemoteGrayConfig != null) goto L6;
        this.sRemoteGrayConfig = new HashMap();
    L6:
        return this.sRemoteGrayConfig;
    }

    public void initLocalGrayConfig() {
        if (this.sLocalGrayConfig != null) goto L5;
        this.sLocalGrayConfig = new HashMap();
    L5:
        this.sLocalGrayConfig.clear();
        ContextManager.CastContext r100 = this.mCastContext;
        if (r100 != null) goto L8;
    L10:
        this.sLocalGrayConfig.putAll(PresetCastConfig.generateDefaultSinkPresetCastConfig());
    L11:
        this.mLogger.i(TAG, "initLocalGrayConfig: " + this.sLocalGrayConfig);
        return;
    L8:
        if (r100.isRoleSource() == false) goto L10;
        this.sLocalGrayConfig.putAll(PresetCastConfig.generateDefaultSourcePresetCastConfig());
        goto L11
    }

    public boolean isLocalGrayConfigAvailable() {
        Map<String, Object> r100 = this.sLocalGrayConfig;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.size() <= 0) goto L7;
        return true;
    }

    public ConfigCache(ContextManager.CastContext r100) {
        this.mConfigLock = new Object();
        this.mCastContext = r100;
        this.mLogger = ContextManager.getLogger(r100);
    }

    public void cacheInitConfig(Config r100) {
        Object r101 = this.mConfigLock;
        monitor-enter(r101);
        if (r100 != null) goto L7;
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L7:
        this.mConfig = r100;     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void cacheRemoteGrayConfig(Map<String, Object> r100) {
        this.mLogger.i(TAG, "cacheRemoteGrayConfig: remoteGrayConfig: " + r100);
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.size() != 0) goto L8;
        return;
    L8:
        if (this.sRemoteGrayConfig != null) goto L10;
        this.sRemoteGrayConfig = new HashMap();
    L10:
        this.sRemoteGrayConfig.clear();
        this.sRemoteGrayConfig.putAll(r100);
    }

    public Object getLocalGrayConfig(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        Map<String, Object> r101 = this.sLocalGrayConfig;
        if (r101 != null) goto L9;
        return null;
    L9:
        return r101.get(r100);
    }

    public Object getLocalConfig(int r100, Object... r101) {
        if (this.sLocalConfig != null) goto L6;
        this.sLocalConfig = new HashMap();
    L6:
        return this.sLocalConfig.get(Integer.valueOf(r100));
    }

    public void setLocalConfig(int r100, Object... r101) {
        if (r101 == null) goto L4;
        Object r102 = r101[0];
    L5:
        this.mLogger.i(TAG, "setLocalConfig: option: " + r100 + ", objects: " + r101 + ", obj[0]: " + r102);
        if (this.sLocalConfig != null) goto L8;
        this.sLocalConfig = new HashMap();
    L8:
        this.sLocalConfig.put(Integer.valueOf(r100), r101);
        return;
    L4:
        r102 = null;
        goto L5
    }
}
