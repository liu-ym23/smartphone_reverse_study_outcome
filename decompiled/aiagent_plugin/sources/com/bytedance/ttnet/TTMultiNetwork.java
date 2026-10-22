package com.bytedance.ttnet;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.utils.TTNetProtocolUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class TTMultiNetwork {
    private static final String HEADER_ACTIVE_RESULT = "ActiveResult";
    private static final String HOST_MULTINET = "multinet";
    private static final String PATH_ACTIVATE_CELL = "/activatecell";
    private static final String TAG = "TTMultiNetwork";
    private static volatile a sActiveResult;
    private static volatile c sCurrentState;
    private static Map<b, Handler> sObservers;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11213a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f11214b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f11215c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f11216d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f11217e = null;
        private static final /* synthetic */ a[] g = null;
        private final int f;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(g.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("DEFAULT", 0, 0);
            f11213a = r0;
            a r1 = new a("SUCCESS", 1, 1);
            f11214b = r1;
            a r3 = new a("FAILED", 2, 2);
            f11215c = r3;
            a r5 = new a("DEFERRED_UNSUITABLE_NETWORK", 3, 3);
            f11216d = r5;
            a r7 = new a("ACTIVATION_IN_PROGRESS", 4, 4);
            f11217e = r7;
            g = new a[]{r0, r1, r3, r5, r7};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f = r3;
        }

        int a() {
            return this.f;
        }

        static a a(String r2) {
            int r3 = Integer.parseInt(r2);     // Catch: NumberFormatException -> L4
            return values()[r3 - f11213a.a()];
        L5:
            return f11213a;
        }
    }

    public interface b {
        void a(c r1, c r2, long r3);

        void a(boolean r1, long r2);
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f11218a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f11219b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f11220c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f11221d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f11222e = null;
        public static final c f = null;
        public static final c g = null;
        private static final /* synthetic */ c[] i = null;
        final int h;

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(i.clone(), c[].class, "com.obric.aiagent.plugin");
        }

        static {
            c r0 = new c("STOPPED", 0, -1);
            f11218a = r0;
            c r1 = new c("NO_NETWORK", 1, 0);
            f11219b = r1;
            c r3 = new c("DEFAULT_CELLULAR_WITH_WIFI_DOWN", 2, 1);
            f11220c = r3;
            c r5 = new c("DEFAULT_WIFI_WITH_CELLULAR_DOWN", 3, 2);
            f11221d = r5;
            c r7 = new c("DEFAULT_WIFI_WITH_CELLULAR_UP", 4, 3);
            f11222e = r7;
            c r9 = new c("WAIT_CELLULAR_ALWAYS_UP", 5, 4);
            f = r9;
            c r11 = new c("DEFAULT_VPN", 6, 5);
            g = r11;
            i = new c[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private c(String r1, int r2, int r3) {
            super(r1, r2);
            this.h = r3;
        }

        public int a() {
            return this.h;
        }

        static c a(int r2) {
            return values()[r2 - f11218a.a()];
        }
    }

    public TTMultiNetwork() {
    }

    static /* synthetic */ a access$002(a r0) {
        sActiveResult = r0;
        return r0;
    }

    static /* synthetic */ void access$100(boolean r0) {
        notifyUserSpecifiedNetworkEnabled(r0);
    }

    static {
        sCurrentState = c.f11218a;
        sActiveResult = a.f11213a;
        sObservers = new HashMap();
    }

    public static c getCurrentState() {
        return sCurrentState;
    }

    public static a getActiveResult() {
        return sActiveResult;
    }

    public static void registerMultiNetObserver(b r3, Handler r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r5, "observer == null");
        monitor-enter(TTMultiNetwork.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (sObservers.containsKey(r5) == true) goto L9;
        if (r4 != null) goto L8;
        sObservers.put(r5, new Handler(Looper.getMainLooper()));     // Catch: Throwable -> L11
        goto L9
    L8:
        sObservers.put(r5, r4);     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L11
    }

    public static void unregisterMultiNetObserver(b r2) {
        b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r3, "observer == null");
        monitor-enter(TTMultiNetwork.class);
        sObservers.remove(r3);     // Catch: Throwable -> L7
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void tryActivateAlternativeNet() {
        TTNetProtocolUtil.a(HOST_MULTINET, PATH_ACTIVATE_CELL, null, null, new AnonymousClass1());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Deprecated
    public static void triggerSwitchingToCellular() {
        TTWiFiCellSwitcher.inst().triggerSwitchingToNetwork(TTWiFiCellSwitcher.a.f11237b);
    }

    private static void notifyMultiNetworkState(final int r12, final int r13) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "notifyMultiNetworkState, prev: " + r12 + ", curr: " + r13);
    L5:
        sCurrentState = c.a(r13);
        final long r7 = System.currentTimeMillis();
        monitor-enter(TTMultiNetwork.class);
        Iterator<Map.Entry<b, Handler>> r9 = sObservers.entrySet().iterator();     // Catch: Throwable -> L15
    L9:
        if (r9.hasNext() == false) goto L13;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        final b r2 = (b) ZeusTransformUtils.preCheckCast(r1.getKey(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        Handler r10 = (Handler) ZeusTransformUtils.preCheckCast(r1.getValue(), Handler.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r10 == null) goto L9;
        r10.post(new AnonymousClass2(r2, r12, r13, r7));     // Catch: Throwable -> L15
        goto L9
    L13:
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private static void notifyUserSpecifiedNetworkEnabled(final boolean r8) {
        final long r0 = System.currentTimeMillis();
        monitor-enter(TTMultiNetwork.class);
        Iterator<Map.Entry<b, Handler>> r3 = sObservers.entrySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r3.hasNext() == false) goto L10;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        final b r5 = (b) ZeusTransformUtils.preCheckCast(r4.getKey(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        Handler r6 = (Handler) ZeusTransformUtils.preCheckCast(r4.getValue(), Handler.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        if (r6 == null) goto L6;
        r6.post(new AnonymousClass3(r5, r8, r0));     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
