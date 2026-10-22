package com.bytedance.android.live.saas.middleware.applog;

import javax.annotation.Nullable;
import ry.e;

/* JADX INFO: loaded from: classes47.dex */
public class AppLogConfig {

    @Nullable
    private String appLogId;

    @Nullable
    private e hostPermission;

    @Nullable
    private IAppLog impl;
    private boolean isToBVersion;
    private boolean standalone;

    public AppLogConfig() {
        this.impl = null;
        this.standalone = false;
        this.isToBVersion = false;
        this.appLogId = null;
        this.hostPermission = null;
    }

    @Nullable
    public String getAppLogId() {
        return this.appLogId;
    }

    @Nullable
    public e getHostPermission() {
        return this.hostPermission;
    }

    @Nullable
    public IAppLog getImpl() {
        return this.impl;
    }

    public boolean getStandalone() {
        return this.standalone;
    }

    public boolean isToBVersion() {
        return this.isToBVersion;
    }

    public void setAppLogId(@Nullable String r100) {
        this.appLogId = r100;
    }

    public void setHostPermission(@Nullable e r100) {
        this.hostPermission = r100;
    }

    public void setImpl(@Nullable IAppLog r100) {
        this.impl = r100;
    }

    public void setStandalone(boolean r100) {
        this.standalone = r100;
    }

    public void setToBVersion(boolean r100) {
        this.isToBVersion = r100;
    }

    public AppLogConfig(IAppLog r100, boolean r101) {
        this(r100, r101, false);
    }

    public AppLogConfig(IAppLog r100, boolean r101, boolean r102) {
        this(r100, r101, r102, null);
    }

    public AppLogConfig(IAppLog r100, boolean r101, boolean r102, @Nullable String r110) {
        this(r100, r101, r102, r110, null);
    }

    public AppLogConfig(IAppLog r100, boolean r101, boolean r102, @Nullable String r103, @Nullable e r104) {
        this.impl = r100;
        this.standalone = r101;
        this.isToBVersion = r102;
        this.appLogId = r103;
        this.hostPermission = r104;
    }
}
