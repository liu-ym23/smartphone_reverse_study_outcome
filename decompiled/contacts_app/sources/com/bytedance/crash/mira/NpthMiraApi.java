package com.bytedance.crash.mira;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class NpthMiraApi {
    static MiraCallbackImpl sMiraCallbackImpl = null;
    private static boolean sMiraInited = false;
    private static PluginInfoCallback sPluginInfoCallback;

    interface MiraCallbackImpl {
        void setMiraCallbackImpl(MiraPluginEventListener r1);
    }

    public static class MiraPluginEventListener {
        public void onPluginInstallResult(String r1, boolean r2) {
        }

        public void onPluginLoaded(String r1) {
        }

        public MiraPluginEventListener() {
        }
    }

    public interface PluginInfoCallback {
        JSONArray getPluginInfo();
    }

    static {
    }

    public NpthMiraApi() {
    }

    public static void setPluginInfoCallback(PluginInfoCallback r0) {
        sPluginInfoCallback = r0;
    }

    public static JSONArray getPluginInfo() {
        PluginInfoCallback r1 = sPluginInfoCallback;     // Catch: Throwable -> L8
        if (r1 == null) goto L11;
        return r1.getPluginInfo();
    L11:
        return null;
    L12:
        return null;
    }

    public static boolean miraInited() {
        return sMiraInited;
    }

    public static void setMiraInited() {
        sMiraInited = true;
    }

    public static void registerMiraCallback(MiraPluginEventListener r1) {
        MiraCallbackImpl r0 = sMiraCallbackImpl;
        if (r0 == null) goto L9;
        r0.setMiraCallbackImpl(r1);     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    static void setMiraCallbackImpl(MiraCallbackImpl r0) {
        sMiraCallbackImpl = r0;
    }
}
