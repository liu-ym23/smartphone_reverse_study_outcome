package com.byted.cast.common.config;

import android.text.TextUtils;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public final class ConfigManager {
    private static final String TAG = null;
    private static volatile ConfigManager sInstance;
    private final ConfigCache mConfigCache;
    private CastLogger mLogger;

    static {
        TAG = com.obric.sva.sdk.config.ConfigManager.TAG;
    }

    public static ConfigManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(ConfigManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new ConfigManager(null);     // Catch: Throwable -> L11
    L9:
        monitor-exit(ConfigManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void destroy() {
        this.mConfigCache.clearInitConfig();
    }

    public Config getInitConfig() {
        return this.mConfigCache.getInitConfig();
    }

    public Map<String, Object> getLocalGrayConfig() {
        ConfigCache r100 = this.mConfigCache;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLocalGrayConfig();
    }

    public Map<String, Object> getRemoteGrayConfig() {
        return this.mConfigCache.getRemoteGrayConfig();
    }

    private ConfigManager(ContextManager.CastContext r100) {
        this.mLogger = ContextManager.getLogger(r100);
        this.mConfigCache = new ConfigCache(r100);
    }

    public static ConfigManager createInstance(ContextManager.CastContext r100) {
        if (r100 != null) goto L6;
        return getInstance();
    L6:
        return new ConfigManager(r100);
    }

    public Object getLocalGrayConfig(String r100) {
        if (this.mConfigCache != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return this.mConfigCache.getLocalGrayConfig(r100);
    }

    public Boolean getOptionByBoolean(int r100) {
        Object r101 = getOption(r100, new Object[0]);
        if ((r101 instanceof Object[]) == false) goto L9;
        Object[] r102 = (Object[]) r101;
        if (r102.length <= 0) goto L9;
        Object r103 = r102[0];
        if ((r103 instanceof Boolean) == false) goto L9;
        return (Boolean) r103;
    L9:
        return null;
    }

    public void init(Config r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mConfigCache.cacheInitConfig(r100);
        if (this.mConfigCache.isLocalGrayConfigAvailable() == true) goto L8;
        this.mConfigCache.initLocalGrayConfig();
        return;
    }

    public void syncGrayConfig(Map<String, Object> r100) {
        this.mConfigCache.cacheRemoteGrayConfig(r100);
    }

    public boolean getLocalGrayConfigByBoolean(String r100, boolean r101) {
        Object r102 = getLocalGrayConfig(r100);
        if ((r102 instanceof String) == true) goto L5;
        return r101;
    L5:
        return Boolean.parseBoolean((String) r102);
    }

    public Object getOption(int r100, Object... r101) {
        return this.mConfigCache.getLocalConfig(r100, r101);
    }

    public boolean getOptionByBoolean(int r100, boolean r101) {
        Boolean r102 = getOptionByBoolean(r100);
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.booleanValue();
    }

    public String getOptionByString(int r100, String r101) {
        Object r102 = getOption(r100, new Object[0]);
        if ((r102 instanceof Object[]) == false) goto L9;
        Object[] r103 = (Object[]) r102;
        if (r103.length <= 0) goto L9;
        Object r104 = r103[0];
        if ((r104 instanceof String) == false) goto L9;
        String r105 = (String) r104;
    L11:
        if (TextUtils.isEmpty(r105) == false) goto L14;
        return r101;
    L14:
        return r105;
    L9:
        r105 = null;
        goto L11
    }

    public void setOption(int r100, Object... r101) {
        this.mConfigCache.setLocalConfig(r100, r101);
    }
}
