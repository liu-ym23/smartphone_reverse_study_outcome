package com.bytedance.android.live.saas.middleware.alog;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes47.dex */
public class ALogConfig {

    @Nullable
    private ILogProtocol aLogService;
    private boolean isDebug;
    private boolean standalone;

    @Nullable
    public ILogProtocol getALogService() {
        return this.aLogService;
    }

    public boolean getStandalone() {
        return this.standalone;
    }

    public boolean isDebug() {
        return this.isDebug;
    }

    public void setALogService(ILogProtocol r100) {
        this.aLogService = r100;
    }

    public void setDebug(boolean r100) {
        this.isDebug = r100;
    }

    public void setStandalone(boolean r100) {
        this.standalone = r100;
    }

    public ALogConfig(@Nullable ILogProtocol r100, boolean r101) {
        this(r100, r101, false);
    }

    public ALogConfig(@Nullable ILogProtocol r100, boolean r101, boolean r102) {
        this.aLogService = r100;
        this.standalone = r101;
        this.isDebug = r102;
    }
}
