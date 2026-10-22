package com.bytedance.ttnet;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ttnet.utils.TTNetProtocolUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class TTWiFiCellSwitcher {
    private static final String ACTION_NAME = "wifi-to-cell";
    private static final String ACTION_PATH_NOTIFY_SWITCH = "/notify-switch";
    private static final String ACTION_PATH_START = "/start";
    private static final String ACTION_PATH_STOP = "/stop";
    private static final String ACTION_PATH_TRIGGER = "/trigger-switch";
    private static final String ACTION_PATH_TRIGGER_THIRD_PARTY = "/trigger-third-party";
    private static final String TAG = "TTWiFiCellSwitchManager";
    private volatile d mCurrentState;
    private final Map<b, Handler> mObservers;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11236a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f11237b = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ a[] f11238d = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f11239c;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f11238d.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("WIFI", 0, 0);
            f11236a = r0;
            a r1 = new a("CELL", 1, 1);
            f11237b = r1;
            f11238d = new a[]{r0, r1};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f11239c = r3;
        }

        public int a() {
            return this.f11239c;
        }
    }

    public interface b {
        void a(d r1, d r2);
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final TTWiFiCellSwitcher f11240a = null;

        static {
            f11240a = new TTWiFiCellSwitcher();
        }
    }

    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f11241a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f11242b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f11243c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f11244d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final d f11245e = null;
        public static final d f = null;
        public static final d g = null;
        public static final d h = null;
        public static final d i = null;
        public static final d j = null;
        public static final d k = null;
        private static final Map<Integer, d> m = null;
        private static final /* synthetic */ d[] n = null;
        final int l;

        public static d valueOf(String r2) {
            return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
        }

        public static d[] values() {
            return (d[]) ZeusTransformUtils.preCheckCast(n.clone(), d[].class, "com.obric.aiagent.plugin");
        }

        static {
            int r2 = 0;
            d r0 = new d("UNKNOWN", 0, Integer.MIN_VALUE);
            f11241a = r0;
            d r1 = new d("STOPPED", 1, -1);
            f11242b = r1;
            d r3 = new d("NO_NETWORK", 2, 0);
            f11243c = r3;
            d r5 = new d("DEFAULT_CELLULAR", 3, 1);
            f11244d = r5;
            d r7 = new d("DEFAULT_WIFI_WITH_CELLULAR_DOWN", 4, 2);
            f11245e = r7;
            d r9 = new d("DEFAULT_WIFI_WITH_CELLULAR_UP", 5, 3);
            f = r9;
            d r11 = new d("WAIT_CELLULAR_ALWAYS_UP", 6, 4);
            g = r11;
            d r13 = new d("WAIT_USER_ALLOW_TO_CELLULAR", 7, 5);
            h = r13;
            d r15 = new d("WIFI_WITH_CELLULAR_TRANS_DATA", 8, 6);
            i = r15;
            d r12 = new d("EVALUATE_CELLULAR", 9, 7);
            j = r12;
            d r14 = new d("WAIT_USER_ALLOW_TO_WIFI", 10, 8);
            k = r14;
            n = new d[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r12, r14};
            m = new HashMap();
            d[] r4 = values();
            int r6 = r4.length;
        L3:
            if (r2 >= r6) goto L5;
            d r8 = r4[r2];
            m.put(Integer.valueOf(r8.l), r8);
            r2 = r2 + 1;
            goto L3
        }

        private d(String r1, int r2, int r3) {
            super(r1, r2);
            this.l = r3;
        }

        public int a() {
            return this.l;
        }

        public static d a(int r2) {
            d r3 = (d) ZeusTransformUtils.preCheckCast(m.get(Integer.valueOf(r2)), d.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L6;
            return r3;
        L6:
            return f11241a;
        }
    }

    public TTWiFiCellSwitcher() {
        this.mCurrentState = d.f11242b;
        this.mObservers = new HashMap();
    }

    public d getCurrentState() {
        return this.mCurrentState;
    }

    public static TTWiFiCellSwitcher inst() {
        return c.f11240a;
    }

    public void registerObserver(b r3, Handler r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r5, "observer == null");
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mObservers.containsKey(r5) == true) goto L9;
        if (r4 != null) goto L8;
        this.mObservers.put(r5, new Handler(Looper.getMainLooper()));     // Catch: Throwable -> L11
        goto L9
    L8:
        this.mObservers.put(r5, r4);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
    }

    public void unregisterObserver(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r4, "observer == null");
        monitor-enter(this);
        this.mObservers.remove(r4);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void start() {
        TTNetProtocolUtil.a(ACTION_NAME, ACTION_PATH_START, null, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void stop() {
        TTNetProtocolUtil.a(ACTION_NAME, ACTION_PATH_STOP, null, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void triggerSwitchingToNetwork(a r3) {
        HashMap r2 = new HashMap();     // Catch: Exception -> L4
        r2.put("network-type", Integer.toString(r3.a()));     // Catch: Exception -> L4
        TTNetProtocolUtil.a(ACTION_NAME, ACTION_PATH_TRIGGER, r2, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Deprecated
    public boolean notifySwitchToMultiNetwork(boolean r3) {
        HashMap r2 = new HashMap();     // Catch: Exception -> L9
        if (r3 == false) goto L5;
        String r4 = "1";
    L6:
        r2.put("enable", r4);     // Catch: Exception -> L9
        TTNetProtocolUtil.a(ACTION_NAME, ACTION_PATH_NOTIFY_SWITCH, r2, null);     // Catch: Exception -> L9
        return true;
    L5:
        r4 = "0";
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Deprecated
    public void triggerSwitchingToCellular() {
        TTNetProtocolUtil.a(ACTION_NAME, ACTION_PATH_TRIGGER_THIRD_PARTY, null, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private static void notifyWiFiToCellState(int r1, int r2) {
        inst().handleWiFiToCellState(r1, r2);
    }

    private void handleWiFiToCellState(final int r6, final int r7) {
        this.mCurrentState = d.a(r7);
        monitor-enter(this);
        Iterator<Map.Entry<b, Handler>> r0 = this.mObservers.entrySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r0.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        final b r2 = (b) ZeusTransformUtils.preCheckCast(r1.getKey(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        Handler r3 = (Handler) ZeusTransformUtils.preCheckCast(r1.getValue(), Handler.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        if (r3 == null) goto L6;
        r3.post(new AnonymousClass1(this, r2, r6, r7));     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
