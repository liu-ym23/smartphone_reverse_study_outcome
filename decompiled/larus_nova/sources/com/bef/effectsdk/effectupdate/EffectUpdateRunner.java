package com.bef.effectsdk.effectupdate;

import android.content.Context;

/* JADX INFO: loaded from: classes39.dex */
public class EffectUpdateRunner {
    private EffectUpdateRunner() {
    }

    public static void createRootDir(Context r100) {
    }

    public void clearCache(Context r100) {
    }

    public boolean getDebugMode() {
        return true;
    }

    public String getRootDir() {
        return "";
    }

    public String getUpdateDir() {
        return "";
    }

    public String getUpdateSuccessFilePath() {
        return "";
    }

    public boolean isInited() {
        return false;
    }

    public boolean isLastUpdateSuccess() {
        return false;
    }

    public synchronized void update() {
        monitor-enter(this);
        monitor-exit(this);
    }

    public static synchronized EffectUpdateRunner instance() {
        monitor-enter(EffectUpdateRunner.class);
        monitor-exit(EffectUpdateRunner.class);
        return null;
    }

    public synchronized void build(Context r100) {
        monitor-enter(this);
        monitor-exit(this);
    }

    public EffectUpdateRunner setAppID(int r100) {
        return instance();
    }

    public EffectUpdateRunner setAppVersion(String r100) {
        return instance();
    }

    public EffectUpdateRunner setDebugMode(boolean r100) {
        return instance();
    }

    public EffectUpdateRunner setDeviceID(String r100) {
        return instance();
    }
}
