package android.ss.com.vboost.i;

import android.content.Context;
import android.os.Build;
import android.ss.com.vboost.CapabilityType;
import android.ss.com.vboost.CoreCluster;
import android.ss.com.vboost.CustomScene;
import android.ss.com.vboost.FrequencyLevel;
import android.ss.com.vboost.utils.LogUtil;
import com.samsung.sdk.sperf.CustomParams;
import com.samsung.sdk.sperf.PerformanceManager;
import com.samsung.sdk.sperf.SPerf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class l extends android.ss.com.vboost.i.a implements h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f4721e = "l";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f4722f = 6000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PerformanceManager f4723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private android.ss.com.vboost.g.a f4724d;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4725a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f4726b = null;

        static {
            int[] r100 = new int[CustomScene.values().length];
            f4726b = r100;
            r100[CustomScene.COMMON_APP_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L83
        L174:
            f4726b[CustomScene.COMMON_WINDOW_SWITCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L84
        L192:
            f4726b[CustomScene.COMMON_TAB_SWITCH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L85
        L200:
            f4726b[CustomScene.COMMON_CAMERA_START.ordinal()] = 4;     // Catch: NoSuchFieldError -> L86
        L204:
            f4726b[CustomScene.DY_GO_DUET.ordinal()] = 5;     // Catch: NoSuchFieldError -> L87
        L226:
            f4726b[CustomScene.DY_GO_REACTION.ordinal()] = 6;     // Catch: NoSuchFieldError -> L88
        L230:
            f4726b[CustomScene.DY_TAB_LIVING_LOAD.ordinal()] = 7;     // Catch: NoSuchFieldError -> L89
        L248:
            f4726b[CustomScene.DY_TAB_NEARBY_LOAD.ordinal()] = 8;     // Catch: NoSuchFieldError -> L90
        L254:
            f4726b[CustomScene.DY_TAB_FOLLOW_LOAD.ordinal()] = 9;     // Catch: NoSuchFieldError -> L91
        L276:
            f4726b[CustomScene.DY_TAB_SEARCH_LOAD.ordinal()] = 10;     // Catch: NoSuchFieldError -> L92
        L280:
            f4726b[CustomScene.DY_TAB_HOME_LOAD.ordinal()] = 11;     // Catch: NoSuchFieldError -> L93
        L164:
            f4726b[CustomScene.DY_TAB_FAMILIAR_LOAD.ordinal()] = 12;     // Catch: NoSuchFieldError -> L94
        L172:
            f4726b[CustomScene.DY_TAB_PUBLISH_LOAD.ordinal()] = 13;     // Catch: NoSuchFieldError -> L95
        L190:
            f4726b[CustomScene.DY_TAB_NOTIFICATION_LOAD.ordinal()] = 14;     // Catch: NoSuchFieldError -> L96
        L196:
            f4726b[CustomScene.DY_TAB_USER_LOAD.ordinal()] = 15;     // Catch: NoSuchFieldError -> L97
        L214:
            f4726b[CustomScene.DY_CONCURRENT_UPLOAD_COMPILE.ordinal()] = 16;     // Catch: NoSuchFieldError -> L98
        L220:
            f4726b[CustomScene.DY_FEED_SCROLL.ordinal()] = 17;     // Catch: NoSuchFieldError -> L99
        L240:
            f4726b[CustomScene.DY_COMMENT_LOAD.ordinal()] = 18;     // Catch: NoSuchFieldError -> L100
        L244:
            f4726b[CustomScene.DY_TAB_MUSIC.ordinal()] = 19;     // Catch: NoSuchFieldError -> L101
        L266:
            f4726b[CustomScene.DY_15S_CAPTURE_START.ordinal()] = 20;     // Catch: NoSuchFieldError -> L102
        L270:
            f4726b[CustomScene.DY_LIVING_SCROLL.ordinal()] = 21;     // Catch: NoSuchFieldError -> L103
        L154:
            f4726b[CustomScene.DY_LIVING_ENTER_GIFT_PANEL.ordinal()] = 22;     // Catch: NoSuchFieldError -> L104
        L160:
            f4726b[CustomScene.DY_LIVING_ENTER_GOODS_LIST.ordinal()] = 23;     // Catch: NoSuchFieldError -> L105
        L182:
            f4726b[CustomScene.TO_FIRST_FRAME_DRAW.ordinal()] = 24;     // Catch: NoSuchFieldError -> L106
        L184:
            f4726b[CustomScene.TO_TAB_SWITCH.ordinal()] = 25;     // Catch: NoSuchFieldError -> L107
        L206:
            f4726b[CustomScene.TO_CLICK_NEWS.ordinal()] = 26;     // Catch: NoSuchFieldError -> L108
        L210:
            f4726b[CustomScene.TO_SCROLL_NEWS.ordinal()] = 27;     // Catch: NoSuchFieldError -> L109
        L234:
            f4726b[CustomScene.TO_VIDEO_FIRST_FRAME.ordinal()] = 28;     // Catch: NoSuchFieldError -> L110
        L236:
            f4726b[CustomScene.TL_FIRST_FRAME_DRAW.ordinal()] = 29;     // Catch: NoSuchFieldError -> L111
        L256:
            f4726b[CustomScene.TL_TAB_SWITCH.ordinal()] = 30;     // Catch: NoSuchFieldError -> L112
        L260:
            f4726b[CustomScene.TL_CLICK_NEWS.ordinal()] = 31;     // Catch: NoSuchFieldError -> L113
        L282:
            f4726b[CustomScene.TL_SCROLL_NEWS.ordinal()] = 32;     // Catch: NoSuchFieldError -> L114
        L150:
            f4726b[CustomScene.DC_SCROLL_HOME.ordinal()] = 33;     // Catch: NoSuchFieldError -> L115
        L176:
            f4726b[CustomScene.DC_TAB_SWITCH.ordinal()] = 34;     // Catch: NoSuchFieldError -> L116
        L178:
            f4726b[CustomScene.DC_SCROLL_MOMENTS.ordinal()] = 35;     // Catch: NoSuchFieldError -> L117
        L198:
            f4726b[CustomScene.DC_VIDEO_FIRST_DRAW.ordinal()] = 36;     // Catch: NoSuchFieldError -> L118
        L202:
            f4726b[CustomScene.TT_GO_DUET.ordinal()] = 37;     // Catch: NoSuchFieldError -> L119
        L224:
            f4726b[CustomScene.TT_GO_REACTION.ordinal()] = 38;     // Catch: NoSuchFieldError -> L120
        L228:
            f4726b[CustomScene.TT_TAB_LIVING_LOAD.ordinal()] = 39;     // Catch: NoSuchFieldError -> L121
        L246:
            f4726b[CustomScene.TT_TAB_NEARBY_LOAD.ordinal()] = 40;     // Catch: NoSuchFieldError -> L122
        L252:
            f4726b[CustomScene.TT_TAB_FOLLOW_LOAD.ordinal()] = 41;     // Catch: NoSuchFieldError -> L123
        L274:
            f4726b[CustomScene.TT_TAB_SEARCH_LOAD.ordinal()] = 42;     // Catch: NoSuchFieldError -> L124
        L278:
            f4726b[CustomScene.TT_TAB_HOME_LOAD.ordinal()] = 43;     // Catch: NoSuchFieldError -> L125
        L162:
            f4726b[CustomScene.TT_TAB_FAMILIAR_LOAD.ordinal()] = 44;     // Catch: NoSuchFieldError -> L126
        L170:
            f4726b[CustomScene.TT_TAB_PUBLISH_LOAD.ordinal()] = 45;     // Catch: NoSuchFieldError -> L127
        L188:
            f4726b[CustomScene.TT_TAB_NOTIFICATION_LOAD.ordinal()] = 46;     // Catch: NoSuchFieldError -> L128
        L194:
            f4726b[CustomScene.TT_TAB_USER_LOAD.ordinal()] = 47;     // Catch: NoSuchFieldError -> L129
        L212:
            f4726b[CustomScene.TT_CONCURRENT_UPLOAD_COMPILE.ordinal()] = 48;     // Catch: NoSuchFieldError -> L130
        L218:
            f4726b[CustomScene.TT_FEED_SCROLL.ordinal()] = 49;     // Catch: NoSuchFieldError -> L131
        L238:
            f4726b[CustomScene.TT_COMMENT_LOAD.ordinal()] = 50;     // Catch: NoSuchFieldError -> L132
        L242:
            f4726b[CustomScene.TT_TAB_MUSIC.ordinal()] = 51;     // Catch: NoSuchFieldError -> L133
        L264:
            f4726b[CustomScene.TT_15S_CAPTURE_START.ordinal()] = 52;     // Catch: NoSuchFieldError -> L134
        L268:
            f4726b[CustomScene.TT_LIVING_SCROLL.ordinal()] = 53;     // Catch: NoSuchFieldError -> L135
        L152:
            f4726b[CustomScene.TT_LIVING_ENTER_GIFT_PANEL.ordinal()] = 54;     // Catch: NoSuchFieldError -> L136
        L158:
            f4726b[CustomScene.TT_LIVING_ENTER_GOODS_LIST.ordinal()] = 55;     // Catch: NoSuchFieldError -> L137
        L69:
            int[] r110 = new int[CapabilityType.values().length];
            f4725a = r110;
            r110[CapabilityType.CPU_FREQ_MAX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L138
        L186:
            f4725a[CapabilityType.GPU_FREQ_MAX.ordinal()] = 2;     // Catch: NoSuchFieldError -> L139
        L208:
            f4725a[CapabilityType.BUS_FREQ_MAX.ordinal()] = 3;     // Catch: NoSuchFieldError -> L140
        L216:
            f4725a[CapabilityType.CPU_FREQ_MIN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L141
        L222:
            f4725a[CapabilityType.GPU_FREQ_MIN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L142
        L232:
            f4725a[CapabilityType.BUS_FREQ_MIN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L143
        L250:
            f4725a[CapabilityType.CPU_CORE_MAX.ordinal()] = 7;     // Catch: NoSuchFieldError -> L144
        L258:
            f4725a[CapabilityType.CPU_CORE_MIN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L145
        L262:
            f4725a[CapabilityType.TASK_PRIORITY.ordinal()] = 9;     // Catch: NoSuchFieldError -> L146
        L272:
            f4725a[CapabilityType.CPU_AFFINITY.ordinal()] = 10;     // Catch: NoSuchFieldError -> L147
        L156:
            f4725a[CapabilityType.PRESET_SCENE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L148
        L168:
            f4725a[CapabilityType.IDLE_STATE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L149
            return;
        }
    }

    private l(Context r100) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return;
    L5:
        if (SPerf.initialize(r100) == false) goto L11;
        PerformanceManager r101 = PerformanceManager.getInstance();
        this.f4723c = r101;
        if (r101 == null) goto L12;
        b();
        c();
        android.ss.com.vboost.i.a.f4683b = true;
        LogUtil.info(f4721e, "registered.");
        return;
    L12:
        return;
    }

    private int a(int r100, int r101) {
        if (r100 >= 0) goto L5;
    L20:
        LogUtil.error(f4721e, "request capability type err!!!");
        return -1;
    L5:
        if (r100 > 2) goto L20;
        PerformanceManager r102 = this.f4723c;
        if (r102 != null) goto L10;
        return -1;
    L10:
        int r103 = 64;
        if (r100 == 0) goto L19;
        if (r100 == 1) goto L17;
        if (r100 != 2) goto L19;
        r103 = 256;
        goto L19
    L17:
        r103 = 128;
    L19:
        return r102.start(r103, r101);
    }

    public static l a(Context r100) {
        l r101 = new l(r100);
        if (android.ss.com.vboost.i.a.f4683b == true) goto L6;
        return null;
    L6:
        return r101;
    }

    private void b() {
        HashSet r100 = new HashSet();
        r100.add(CapabilityType.PRESET_SCENE);
        r100.add(CapabilityType.CPU_FREQ_MIN);
        r100.add(CapabilityType.CPU_FREQ_MAX);
        r100.add(CapabilityType.CPU_CORE_MIN);
        r100.add(CapabilityType.CPU_CORE_MAX);
        r100.add(CapabilityType.GPU_FREQ_MIN);
        r100.add(CapabilityType.GPU_FREQ_MAX);
        r100.add(CapabilityType.BUS_FREQ_MIN);
        r100.add(CapabilityType.BUS_FREQ_MAX);
        r100.add(CapabilityType.TASK_PRIORITY);
        r100.add(CapabilityType.CPU_AFFINITY);
        r100.add(CapabilityType.IDLE_STATE);
        a(r100);
        android.ss.com.vboost.g.a r101 = android.ss.com.vboost.g.a.b();
        this.f4724d = r101;
        r101.a(r100);
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        CapabilityType r103 = (CapabilityType) r102.next();
        switch(a.f4725a[r103.ordinal()]) {
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L10;
            case 4: goto L10;
            case 5: goto L10;
            case 6: goto L10;
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L4;
            case 12: goto L4;
            default: goto L7;
        };
    L7:
        LogUtil.error(f4721e, "SsCapabilityProvider not support this capability " + r103);
        goto L4
    L8:
        this.f4724d.a(android.ss.com.vboost.g.b.f4612b);
        goto L4
    L9:
        this.f4724d.a(new android.ss.com.vboost.g.d(0, 5, 1));
        goto L4
    L10:
        android.ss.com.vboost.g.c r104 = new android.ss.com.vboost.g.c(true, 0, 5, true, 1000, false, 0);
        ArrayList r105 = new ArrayList();
        r105.add(r104);
        this.f4724d.a(r103, r105);
        goto L4
    }

    private void c() {
        HashMap r100 = new HashMap();
        FrequencyLevel r101 = FrequencyLevel.LEVEL_9;
        g r102 = g.f4706b;
        r100.put(r101, new d(0, Integer.MAX_VALUE, r102, r101));
        FrequencyLevel r103 = FrequencyLevel.LEVEL_8;
        r100.put(r103, new d(0, Integer.MAX_VALUE, r102, r103));
        FrequencyLevel r104 = FrequencyLevel.LEVEL_7;
        g r105 = g.f4705a;
        r100.put(r104, new d(3, 1000, r105, r103));
        FrequencyLevel r106 = FrequencyLevel.LEVEL_6;
        r100.put(r106, new d(3, 1000, r105, r103));
        FrequencyLevel r110 = FrequencyLevel.LEVEL_5;
        r100.put(r110, new d(2, 1000, r105, r110));
        FrequencyLevel r111 = FrequencyLevel.LEVEL_4;
        r100.put(r111, new d(2, 1000, r105, r111));
        FrequencyLevel r112 = FrequencyLevel.LEVEL_3;
        r100.put(r112, new d(1, 1000, r105, r112));
        FrequencyLevel r113 = FrequencyLevel.LEVEL_2;
        r100.put(r113, new d(1, 1000, r105, r113));
        FrequencyLevel r107 = FrequencyLevel.LEVEL_1;
        r100.put(r107, new d(0, 1000, r105, r107));
        FrequencyLevel r114 = FrequencyLevel.LEVEL_0;
        r100.put(r114, new d(0, 1000, r105, r114));
        k.a().a(r105, CapabilityType.CPU_FREQ_MIN, r100);
        k.a().a(r105, CapabilityType.CPU_FREQ_MAX, r100);
        HashMap r108 = new HashMap();
        r108.put(r101, new d(0, Integer.MAX_VALUE, r102, r101));
        r108.put(r103, new d(0, Integer.MAX_VALUE, r102, r103));
        r108.put(r104, new d(3, 1000, r105, r103));
        r108.put(r106, new d(3, 1000, r105, r103));
        r108.put(r110, new d(2, 1000, r105, r110));
        r108.put(r111, new d(2, 1000, r105, r111));
        r108.put(r112, new d(1, 1000, r105, r112));
        r108.put(r113, new d(1, 1000, r105, r113));
        r108.put(r107, new d(0, 1000, r105, r107));
        r108.put(r114, new d(0, 1000, r105, r114));
        k.a().a(r105, CapabilityType.GPU_FREQ_MIN, r108);
        k.a().a(r105, CapabilityType.GPU_FREQ_MAX, r108);
        HashMap r109 = new HashMap();
        r109.put(r101, new d(3, 1000, r105, r101));
        r109.put(r103, new d(3, 1000, r105, r103));
        r109.put(r104, new d(2, 1000, r105, r104));
        r109.put(r106, new d(2, 1000, r105, r106));
        r109.put(r110, new d(2, 1000, r105, r110));
        r109.put(r111, new d(1, 1000, r105, r111));
        r109.put(r112, new d(1, 1000, r105, r112));
        r109.put(r113, new d(1, 1000, r105, r113));
        r109.put(r107, new d(0, 1000, r105, r107));
        r109.put(r114, new d(0, 1000, r105, r114));
        k.a().a(r105, CapabilityType.BUS_FREQ_MIN, r109);
        k.a().a(r105, CapabilityType.BUS_FREQ_MAX, r109);
        HashMap r115 = new HashMap();
        r115.put(r101, new d(4, 99999999, r105, r101));
        r115.put(r103, new d(4, 99999999, r105, r103));
        r115.put(r104, new d(3, 99999999, r105, r104));
        r115.put(r106, new d(3, 99999999, r105, r106));
        r115.put(r110, new d(2, 99999999, r105, r110));
        r115.put(r111, new d(2, 99999999, r105, r111));
        r115.put(r112, new d(1, 99999999, r105, r112));
        r115.put(r113, new d(1, 99999999, r105, r113));
        r115.put(r107, new d(0, 99999999, r105, r107));
        r115.put(r114, new d(0, 99999999, r105, r114));
        k.a().a(r105, CapabilityType.TASK_PRIORITY, r115);
    }

    @Override // android.ss.com.vboost.i.h
    public Object a(i r100) {
        String r101 = f4721e;
        LogUtil.debug(r101, "restore ability " + r100.f4708a.toString());
        if (this.f4723c != null) goto L6;
        return null;
    L6:
        int r102 = a.f4725a[r100.f4708a.ordinal()];
        if (r102 == 10) goto L14;
        switch(r102) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L11;
            case 6: goto L11;
            default: goto L10;
        };
    L11:
        int r103 = this.f4723c.stop();
    L13:
        return Integer.valueOf(r103);
    L10:
        return 0;
    L14:
        LogUtil.debug(r101, "reset tid:" + r100.f4715h + " core bind");
        CustomParams r104 = new CustomParams();
        r104.add(8, 0, 99999999);
        r103 = this.f4723c.start(r104);
        goto L13
    }

    @Override // android.ss.com.vboost.i.h
    public boolean a(CapabilityType r100) {
        android.ss.com.vboost.g.a r101 = this.f4724d;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.a().contains(r100) == false) goto L7;
        return true;
    }

    @Override // android.ss.com.vboost.i.h
    public Object b(i r100) {
        if (this.f4723c != null) goto L7;
        return null;
    L7:
        switch(a.f4725a[r100.f4708a.ordinal()]) {
            case 1: goto L45;
            case 2: goto L43;
            case 3: goto L41;
            case 4: goto L39;
            case 5: goto L37;
            case 6: goto L35;
            case 7: goto L33;
            case 8: goto L31;
            case 9: goto L24;
            case 10: goto L14;
            case 11: goto L12;
            case 12: goto L10;
            default: goto L8;
        };
    L8:
        LogUtil.warn(f4721e, "not implement by ss provider!");
        return 0;
    L10:
        CustomParams r101 = new CustomParams();
        r101.add(10, r100.f4710c, (int) r100.f4713f);
        return Integer.valueOf(this.f4723c.start(r101));
    L12:
        c(r100);
        return 1;
    L14:
        CoreCluster r102 = r100.f4714g;
        if (r102 != CoreCluster.GOLD) goto L17;
    L21:
        LogUtil.debug(f4721e, "bind tid:" + r100.f4715h + " to big core");
        CustomParams r103 = new CustomParams();
        r103.add(8, 1, 99999999);
        return Integer.valueOf(this.f4723c.start(r103));
    L17:
        if (r102 == CoreCluster.SUPER) goto L21;
        LogUtil.debug(f4721e, "bind tid:" + r100.f4715h + " to little core");
        CustomParams r104 = new CustomParams();
        r104.add(8, 2, 99999999);
        return Integer.valueOf(this.f4723c.start(r104));
    L31:
        CustomParams r105 = new CustomParams();
        r105.add(6, r100.f4710c, (int) r100.f4713f);
        return Integer.valueOf(this.f4723c.start(r105));
    L33:
        CustomParams r106 = new CustomParams();
        r106.add(7, r100.f4710c, (int) r100.f4713f);
        return Integer.valueOf(this.f4723c.start(r106));
    L35:
        CustomParams r107 = new CustomParams();
        r107.add(4, r100.f4710c, (int) r100.f4713f);
        return Integer.valueOf(this.f4723c.start(r107));
    L37:
        CustomParams r108 = new CustomParams();
        r108.add(2, r100.f4710c, (int) r100.f4713f);
        return Integer.valueOf(this.f4723c.start(r108));
    L39:
        CustomParams r109 = new CustomParams();
        r109.add(0, r100.f4710c, (int) r100.f4713f);
        return Integer.valueOf(this.f4723c.start(r109));
    L41:
        CustomParams r110 = new CustomParams();
        r110.add(5, r100.f4710c, (int) r100.f4713f);
        return Integer.valueOf(this.f4723c.start(r110));
    L43:
        CustomParams r111 = new CustomParams();
        r111.add(3, r100.f4710c, (int) r100.f4713f);
        return Integer.valueOf(this.f4723c.start(r111));
    L45:
        CustomParams r112 = new CustomParams();
        r112.add(1, r100.f4710c, (int) r100.f4713f);
        return Integer.valueOf(this.f4723c.start(r112));
    L24:
        if (r100.f4710c <= 5) goto L27;
        r100.f4710c = 5;
    L27:
        if (r100.f4710c >= 0) goto L29;
        r100.f4710c = 0;
    L29:
        CustomParams r113 = new CustomParams();
        r113.add(9, r100.f4710c, 99999999);
        return Integer.valueOf(this.f4723c.start(r113));
    }

    public int c(i r100) {
        j r101 = r100.f4711d;
        String r102 = f4721e;
        LogUtil.info(r102, "SamSung provider process scene " + r101.f4716a.getDesc());
        switch(a.f4726b[r101.f4716a.ordinal()]) {
            case 1: goto L6;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L6;
            case 12: goto L6;
            case 13: goto L6;
            case 14: goto L6;
            case 15: goto L6;
            case 16: goto L6;
            case 17: goto L6;
            case 18: goto L6;
            case 19: goto L6;
            case 20: goto L6;
            case 21: goto L6;
            case 22: goto L6;
            case 23: goto L6;
            case 24: goto L6;
            case 25: goto L6;
            case 26: goto L6;
            case 27: goto L6;
            case 28: goto L6;
            case 29: goto L6;
            case 30: goto L6;
            case 31: goto L6;
            case 32: goto L6;
            case 33: goto L6;
            case 34: goto L6;
            case 35: goto L6;
            case 36: goto L6;
            case 37: goto L6;
            case 38: goto L6;
            case 39: goto L6;
            case 40: goto L6;
            case 41: goto L6;
            case 42: goto L6;
            case 43: goto L6;
            case 44: goto L6;
            case 45: goto L6;
            case 46: goto L6;
            case 47: goto L6;
            case 48: goto L6;
            case 49: goto L6;
            case 50: goto L6;
            case 51: goto L6;
            case 52: goto L6;
            case 53: goto L6;
            case 54: goto L6;
            case 55: goto L6;
            default: goto L4;
        };
    L4:
        LogUtil.warn(r102, "this scene is not support!!!");
        return 0;
    L6:
        a(0, f4722f);
        a(1, f4722f);
        return a(2, f4722f);
    }
}
