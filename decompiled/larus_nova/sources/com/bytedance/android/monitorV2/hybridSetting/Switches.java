package com.bytedance.android.monitorV2.hybridSetting;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes12.dex */
public final enum Switches extends Enum<Switches> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Switches[] f163055a = null;
    public static final Switches appSettings = null;
    public static final Switches blankBitmap = null;
    public static final Switches checkSelf = null;
    public static final Switches eventStream = null;
    public static final Switches logType = null;
    public static final Switches lynxBlank = null;
    public static final Switches lynxFetch = null;
    public static final Switches lynxJsb = null;
    public static final Switches lynxMonitor = null;
    public static final Switches lynxPerf = null;
    public static final Switches lynxResourceLoader = null;
    public static final Switches monitor = null;
    public static final Switches teaReport = null;
    public static final Switches webAutoReport = null;
    public static final Switches webBlank = null;
    public static final Switches webDomainWhiteList = null;
    public static final Switches webFetch = null;
    public static final Switches webInject = null;
    public static final Switches webJSB = null;
    public static final Switches webMonitor = null;
    public static final Switches webResourceLoader = null;
    public static final Switches webTTWebDelegate = null;
    public static final Switches webUpdatePageData = null;
    private boolean enabled;
    private final int index;
    private ManualState manualSwitchState;

    public static final enum ManualState extends Enum<ManualState> {
        public static final ManualState DEFAULT = null;
        public static final ManualState OFF = null;
        public static final ManualState ON = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ManualState[] f163056a = null;

        static {
            ManualState r100 = new ManualState("DEFAULT", 0);
            DEFAULT = r100;
            ManualState r101 = new ManualState("ON", 1);
            ON = r101;
            ManualState r102 = new ManualState("OFF", 2);
            OFF = r102;
            f163056a = new ManualState[]{r100, r101, r102};
        }

        public static ManualState[] values() {
            return (ManualState[]) f163056a.clone();
        }

        public static ManualState valueOf(String r100) {
            return (ManualState) r27.a.a(ManualState.class, r100);
        }

        public ManualState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Map<Integer, Switches> f163057a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static int f163058b;

        static {
            f163057a = new ConcurrentHashMap();
            f163058b = 0;
        }

        public static String a() {
            StringBuilder r100 = new StringBuilder();
            Iterator r101 = ((ConcurrentHashMap) f163057a).entrySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L7;
            Map.Entry r102 = (Map.Entry) r101.next();
            Integer r103 = (Integer) r102.getKey();
            Switches r104 = (Switches) r102.getValue();
            r100.append(r103.toString());
            r100.append(":");
            r100.append(r104.name());
            r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
            r100.append(Switches.access$200(r104));
            r100.append(' ');
            goto L4
        L7:
            return r100.toString();
        }
    }

    static {
        Switches r100 = new Switches("monitor", 0, true, 0);
        monitor = r100;
        Switches r101 = new Switches("webMonitor", 1, true, 1);
        webMonitor = r101;
        Switches r102 = new Switches("webBlank", 2, true, 2);
        webBlank = r102;
        Switches r103 = new Switches("webFetch", 3, true, 3);
        webFetch = r103;
        Switches r104 = new Switches("webJSB", 4, true, 4);
        webJSB = r104;
        Switches r105 = new Switches("webInject", 5, true, 5);
        webInject = r105;
        Switches r110 = new Switches("lynxMonitor", 6, true, 6);
        lynxMonitor = r110;
        Switches r111 = new Switches("lynxPerf", 7, true, 7);
        lynxPerf = r111;
        Switches r112 = new Switches("lynxBlank", 8, true, 8);
        lynxBlank = r112;
        Switches r113 = new Switches("lynxFetch", 9, true, 9);
        lynxFetch = r113;
        Switches r114 = new Switches("lynxJsb", 10, true, 10);
        lynxJsb = r114;
        Switches r115 = new Switches("webAutoReport", 11, true, 11);
        webAutoReport = r115;
        Switches r106 = new Switches("webUpdatePageData", 12, true, 12);
        webUpdatePageData = r106;
        Switches r107 = new Switches("webTTWebDelegate", 13, true, 24);
        webTTWebDelegate = r107;
        Switches r108 = new Switches("teaReport", 14, true, 25);
        teaReport = r108;
        Switches r109 = new Switches("webResourceLoader", 15, true, 26);
        webResourceLoader = r109;
        Switches r116 = new Switches("lynxResourceLoader", 16, true, 27);
        lynxResourceLoader = r116;
        Switches r117 = new Switches("checkSelf", 17, true, 28);
        checkSelf = r117;
        Switches r118 = new Switches("eventStream", 18, true, 29);
        eventStream = r118;
        Switches r119 = new Switches("blankBitmap", 19, true, 30);
        blankBitmap = r119;
        Switches r120 = new Switches("webDomainWhiteList", 20, false, 31);
        webDomainWhiteList = r120;
        Switches r121 = new Switches("logType", 21, false, 32);
        logType = r121;
        Switches r122 = new Switches("appSettings", 22, false, 35);
        appSettings = r122;
        f163055a = new Switches[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122};
    }

    public static Switches[] values() {
        return (Switches[]) f163055a.clone();
    }

    public boolean isEnabled() {
        boolean r100 = this.enabled;
        ManualState r101 = this.manualSwitchState;
        if (r101 != ManualState.DEFAULT) goto L5;
        return r100;
    L5:
        if (r101 != ManualState.ON) goto L7;
        return true;
    L7:
        return false;
    }

    public boolean not() {
        return !isEnabled();
    }

    public static /* synthetic */ boolean access$200(Switches r100) {
        return r100.enabled;
    }

    public static void resetAll(long r100) {
        int r101 = 0;
    L21:
    L18:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.a("startup_handle", th);
        return;
    L4:
        if (r101 > a.f163058b) goto L16;
        boolean r102 = true;
        if (r101 == 0) goto L8;
        r100 = r100 >> 1;     // Catch: Throwable -> L18
    L8:
        Switches r103 = (Switches) ((ConcurrentHashMap) a.f163057a).get(Integer.valueOf(r101));     // Catch: Throwable -> L18
        if (r103 == null) goto L15;
        if ((r100 % 2) != 0) goto L14;
        r102 = false;
    L14:
        r103.enabled = r102;     // Catch: Throwable -> L18
    L15:
        r101 = r101 + 1;     // Catch: Throwable -> L18
        goto L21
    L16:
        nz2.b.f("Switches", "Switches: " + a.a());     // Catch: Throwable -> L18
    }

    public static Switches valueOf(String r100) {
        return (Switches) r27.a.a(Switches.class, r100);
    }

    public Switches(String r100, int r101, boolean r102, int r103) {
        super(r100, r101);
        this.manualSwitchState = ManualState.DEFAULT;
        this.enabled = r102;
        this.index = r103;
        Map<Integer, Switches> r104 = a.f163057a;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        r105.put(Integer.valueOf(r103), this);
        if (r103 <= a.f163058b) goto L6;
        a.f163058b = r103;
        return;
    }
}
