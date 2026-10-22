package com.bytedance.apm.npth;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class NpthUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static INpthCallback f6520a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static IMonitorListener f6521b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f6522c = false;

    public interface IGetUserData {
        Map<String, String> getUserData();
    }

    public interface IMonitorListener {
        void startMonitor();
    }

    public interface INpthCallback {
        void addAttachUserData(IGetUserData r10);

        void addTags(Map<String, String> r10);
    }

    static {
    }

    public static void a(Map r10) {
        INpthCallback r11 = f6520a;
        if (r11 == null) goto L6;
        r11.addTags(r10);
        return;
    }

    public static void b(IGetUserData r10) {
        INpthCallback r11 = f6520a;
        if (r11 == null) goto L6;
        r11.addAttachUserData(r10);
        return;
    }

    public static void c() {
        if (f6522c == false) goto L5;
        return;
    L5:
        IMonitorListener r10 = f6521b;
        if (r10 == null) goto L9;
        r10.startMonitor();
        f6522c = true;
        return;
    }
}
