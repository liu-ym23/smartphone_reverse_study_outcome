package android.ss.com.vboost.i;

import android.content.Context;
import android.ss.com.vboost.CapabilityType;
import android.ss.com.vboost.CoreCluster;
import android.ss.com.vboost.CustomScene;
import android.ss.com.vboost.FrequencyLevel;
import android.ss.com.vboost.Status;
import android.ss.com.vboost.utils.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class f extends android.ss.com.vboost.i.a implements h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f4700e = "f";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private android.ss.com.vboost.g.a f4701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4702d;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4703a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f4704b = null;

        static {
            int[] r100 = new int[CustomScene.values().length];
            f4704b = r100;
            r100[CustomScene.COMMON_APP_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L73
        L155:
            f4704b[CustomScene.COMMON_WINDOW_SWITCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L74
        L173:
            f4704b[CustomScene.COMMON_TAB_SWITCH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L75
        L181:
            f4704b[CustomScene.COMMON_CAMERA_START.ordinal()] = 4;     // Catch: NoSuchFieldError -> L76
        L185:
            f4704b[CustomScene.DY_GO_DUET.ordinal()] = 5;     // Catch: NoSuchFieldError -> L77
        L207:
            f4704b[CustomScene.DY_GO_REACTION.ordinal()] = 6;     // Catch: NoSuchFieldError -> L78
        L211:
            f4704b[CustomScene.DY_TAB_LIVING_LOAD.ordinal()] = 7;     // Catch: NoSuchFieldError -> L79
        L229:
            f4704b[CustomScene.DY_TAB_NEARBY_LOAD.ordinal()] = 8;     // Catch: NoSuchFieldError -> L80
        L235:
            f4704b[CustomScene.DY_TAB_FOLLOW_LOAD.ordinal()] = 9;     // Catch: NoSuchFieldError -> L81
        L251:
            f4704b[CustomScene.DY_TAB_SEARCH_LOAD.ordinal()] = 10;     // Catch: NoSuchFieldError -> L82
        L255:
            f4704b[CustomScene.DY_TAB_HOME_LOAD.ordinal()] = 11;     // Catch: NoSuchFieldError -> L83
        L147:
            f4704b[CustomScene.DY_TAB_FAMILIAR_LOAD.ordinal()] = 12;     // Catch: NoSuchFieldError -> L84
        L153:
            f4704b[CustomScene.DY_TAB_PUBLISH_LOAD.ordinal()] = 13;     // Catch: NoSuchFieldError -> L85
        L171:
            f4704b[CustomScene.DY_TAB_NOTIFICATION_LOAD.ordinal()] = 14;     // Catch: NoSuchFieldError -> L86
        L177:
            f4704b[CustomScene.DY_TAB_USER_LOAD.ordinal()] = 15;     // Catch: NoSuchFieldError -> L87
        L195:
            f4704b[CustomScene.DY_CONCURRENT_UPLOAD_COMPILE.ordinal()] = 16;     // Catch: NoSuchFieldError -> L88
        L201:
            f4704b[CustomScene.DY_FEED_SCROLL.ordinal()] = 17;     // Catch: NoSuchFieldError -> L89
        L221:
            f4704b[CustomScene.DY_COMMENT_LOAD.ordinal()] = 18;     // Catch: NoSuchFieldError -> L90
        L225:
            f4704b[CustomScene.DY_TAB_MUSIC.ordinal()] = 19;     // Catch: NoSuchFieldError -> L91
        L243:
            f4704b[CustomScene.DY_15S_CAPTURE_START.ordinal()] = 20;     // Catch: NoSuchFieldError -> L92
        L247:
            f4704b[CustomScene.DY_LIVING_SCROLL.ordinal()] = 21;     // Catch: NoSuchFieldError -> L93
        L139:
            f4704b[CustomScene.DY_LIVING_ENTER_GIFT_PANEL.ordinal()] = 22;     // Catch: NoSuchFieldError -> L94
        L143:
            f4704b[CustomScene.DY_LIVING_ENTER_GOODS_LIST.ordinal()] = 23;     // Catch: NoSuchFieldError -> L95
        L163:
            f4704b[CustomScene.TO_FIRST_FRAME_DRAW.ordinal()] = 24;     // Catch: NoSuchFieldError -> L96
        L165:
            f4704b[CustomScene.TO_TAB_SWITCH.ordinal()] = 25;     // Catch: NoSuchFieldError -> L97
        L187:
            f4704b[CustomScene.TO_CLICK_NEWS.ordinal()] = 26;     // Catch: NoSuchFieldError -> L98
        L191:
            f4704b[CustomScene.TO_SCROLL_NEWS.ordinal()] = 27;     // Catch: NoSuchFieldError -> L99
        L215:
            f4704b[CustomScene.TO_VIDEO_FIRST_FRAME.ordinal()] = 28;     // Catch: NoSuchFieldError -> L100
        L217:
            f4704b[CustomScene.TL_FIRST_FRAME_DRAW.ordinal()] = 29;     // Catch: NoSuchFieldError -> L101
        L237:
            f4704b[CustomScene.TL_TAB_SWITCH.ordinal()] = 30;     // Catch: NoSuchFieldError -> L102
        L239:
            f4704b[CustomScene.TL_CLICK_NEWS.ordinal()] = 31;     // Catch: NoSuchFieldError -> L103
        L257:
            f4704b[CustomScene.TL_SCROLL_NEWS.ordinal()] = 32;     // Catch: NoSuchFieldError -> L104
        L135:
            f4704b[CustomScene.DC_SCROLL_HOME.ordinal()] = 33;     // Catch: NoSuchFieldError -> L105
        L157:
            f4704b[CustomScene.DC_TAB_SWITCH.ordinal()] = 34;     // Catch: NoSuchFieldError -> L106
        L159:
            f4704b[CustomScene.DC_SCROLL_MOMENTS.ordinal()] = 35;     // Catch: NoSuchFieldError -> L107
        L179:
            f4704b[CustomScene.DC_VIDEO_FIRST_DRAW.ordinal()] = 36;     // Catch: NoSuchFieldError -> L108
        L183:
            f4704b[CustomScene.TT_GO_DUET.ordinal()] = 37;     // Catch: NoSuchFieldError -> L109
        L205:
            f4704b[CustomScene.TT_GO_REACTION.ordinal()] = 38;     // Catch: NoSuchFieldError -> L110
        L209:
            f4704b[CustomScene.TT_TAB_LIVING_LOAD.ordinal()] = 39;     // Catch: NoSuchFieldError -> L111
        L227:
            f4704b[CustomScene.TT_TAB_NEARBY_LOAD.ordinal()] = 40;     // Catch: NoSuchFieldError -> L112
        L233:
            f4704b[CustomScene.TT_TAB_FOLLOW_LOAD.ordinal()] = 41;     // Catch: NoSuchFieldError -> L113
        L249:
            f4704b[CustomScene.TT_TAB_SEARCH_LOAD.ordinal()] = 42;     // Catch: NoSuchFieldError -> L114
        L253:
            f4704b[CustomScene.TT_TAB_HOME_LOAD.ordinal()] = 43;     // Catch: NoSuchFieldError -> L115
        L145:
            f4704b[CustomScene.TT_TAB_FAMILIAR_LOAD.ordinal()] = 44;     // Catch: NoSuchFieldError -> L116
        L151:
            f4704b[CustomScene.TT_TAB_PUBLISH_LOAD.ordinal()] = 45;     // Catch: NoSuchFieldError -> L117
        L169:
            f4704b[CustomScene.TT_TAB_NOTIFICATION_LOAD.ordinal()] = 46;     // Catch: NoSuchFieldError -> L118
        L175:
            f4704b[CustomScene.TT_TAB_USER_LOAD.ordinal()] = 47;     // Catch: NoSuchFieldError -> L119
        L193:
            f4704b[CustomScene.TT_CONCURRENT_UPLOAD_COMPILE.ordinal()] = 48;     // Catch: NoSuchFieldError -> L120
        L199:
            f4704b[CustomScene.TT_FEED_SCROLL.ordinal()] = 49;     // Catch: NoSuchFieldError -> L121
        L219:
            f4704b[CustomScene.TT_COMMENT_LOAD.ordinal()] = 50;     // Catch: NoSuchFieldError -> L122
        L223:
            f4704b[CustomScene.TT_TAB_MUSIC.ordinal()] = 51;     // Catch: NoSuchFieldError -> L123
        L241:
            f4704b[CustomScene.TT_15S_CAPTURE_START.ordinal()] = 52;     // Catch: NoSuchFieldError -> L124
        L245:
            f4704b[CustomScene.TT_LIVING_SCROLL.ordinal()] = 53;     // Catch: NoSuchFieldError -> L125
        L137:
            f4704b[CustomScene.TT_LIVING_ENTER_GIFT_PANEL.ordinal()] = 54;     // Catch: NoSuchFieldError -> L126
        L141:
            f4704b[CustomScene.TT_LIVING_ENTER_GOODS_LIST.ordinal()] = 55;     // Catch: NoSuchFieldError -> L127
        L64:
            int[] r101 = new int[CapabilityType.values().length];
            f4703a = r101;
            r101[CapabilityType.CPU_FREQ_MIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L128
        L167:
            f4703a[CapabilityType.GPU_FREQ_MIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L129
        L189:
            f4703a[CapabilityType.UFS_FREQ_MIN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L130
        L197:
            f4703a[CapabilityType.TASK_PRIORITY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L131
        L203:
            f4703a[CapabilityType.CPU_AFFINITY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L132
        L213:
            f4703a[CapabilityType.VIBRATE_ENHANCE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L133
        L231:
            f4703a[CapabilityType.PRESET_SCENE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L134
            return;
        }
    }

    public f(Context r100) {
        this.f4702d = false;
        if (android.ss.com.vboost.h.d.a(r100) == false) goto L6;
        this.f4702d = android.ss.com.vboost.h.j.a(r100);
        b();
        c();
        LogUtil.info(f4700e, "registered.");
        return;
    }

    private void b() {
        HashSet r100 = new HashSet();
        if (d() == false) goto L6;
        r100.add(CapabilityType.CPU_FREQ_MIN);
        r100.add(CapabilityType.GPU_FREQ_MIN);
    L6:
        if (e() == false) goto L9;
        r100.add(CapabilityType.UFS_FREQ_MIN);
    L9:
        if (f() == false) goto L11;
        r100.add(CapabilityType.VIBRATE_ENHANCE);
    L11:
        r100.add(CapabilityType.PRESET_SCENE);
        r100.add(CapabilityType.TASK_PRIORITY);
        r100.add(CapabilityType.CPU_AFFINITY);
        a(r100);
        android.ss.com.vboost.g.a r101 = android.ss.com.vboost.g.a.b();
        this.f4701c = r101;
        r101.a(r100);
        Iterator r102 = r100.iterator();
    L13:
        if (r102.hasNext() == false) goto L20;
        CapabilityType r103 = (CapabilityType) r102.next();
        switch(a.f4703a[r103.ordinal()]) {
            case 1: goto L19;
            case 2: goto L19;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L13;
            case 7: goto L13;
            default: goto L16;
        };
    L16:
        LogUtil.error(f4700e, "PlatformProvider not support this capability " + r103);
        goto L13
    L17:
        this.f4701c.a(android.ss.com.vboost.g.b.f4612b);
        goto L13
    L18:
        this.f4701c.a(new android.ss.com.vboost.g.d(-20, 19, 1));
        goto L13
    L19:
        android.ss.com.vboost.g.c r104 = new android.ss.com.vboost.g.c(false, 0, 0, true, Integer.MAX_VALUE, false, 0);
        ArrayList r105 = new ArrayList();
        r105.add(r104);
        this.f4701c.a(r103, r105);
        goto L13
    }

    private void c() {
        HashMap r100 = new HashMap();
        FrequencyLevel r101 = FrequencyLevel.LEVEL_9;
        g r102 = g.f4706b;
        r100.put(r101, new d(0, Integer.MAX_VALUE, r102, r101));
        FrequencyLevel r103 = FrequencyLevel.LEVEL_8;
        r100.put(r103, new d(0, Integer.MAX_VALUE, r102, r103));
        FrequencyLevel r104 = FrequencyLevel.LEVEL_7;
        r100.put(r104, new d(0, Integer.MAX_VALUE, r102, r104));
        FrequencyLevel r105 = FrequencyLevel.LEVEL_6;
        r100.put(r105, new d(0, Integer.MAX_VALUE, r102, r105));
        FrequencyLevel r106 = FrequencyLevel.LEVEL_5;
        r100.put(r106, new d(0, Integer.MAX_VALUE, r102, r106));
        FrequencyLevel r107 = FrequencyLevel.LEVEL_4;
        r100.put(r107, new d(0, Integer.MAX_VALUE, r102, r107));
        FrequencyLevel r110 = FrequencyLevel.LEVEL_3;
        r100.put(r110, new d(0, Integer.MAX_VALUE, r102, r110));
        FrequencyLevel r111 = FrequencyLevel.LEVEL_2;
        r100.put(r111, new d(0, Integer.MAX_VALUE, r102, r111));
        FrequencyLevel r112 = FrequencyLevel.LEVEL_1;
        r100.put(r112, new d(0, Integer.MAX_VALUE, r102, r112));
        FrequencyLevel r113 = FrequencyLevel.LEVEL_0;
        r100.put(r113, new d(0, Integer.MAX_VALUE, r102, r113));
        k.a().a(r102, CapabilityType.CPU_FREQ_MIN, r100);
        HashMap r108 = new HashMap();
        r108.put(r101, new d(0, Integer.MAX_VALUE, r102, r101));
        r108.put(r103, new d(0, Integer.MAX_VALUE, r102, r103));
        r108.put(r104, new d(0, Integer.MAX_VALUE, r102, r104));
        r108.put(r105, new d(0, Integer.MAX_VALUE, r102, r105));
        r108.put(r106, new d(0, Integer.MAX_VALUE, r102, r106));
        r108.put(r107, new d(0, Integer.MAX_VALUE, r102, r107));
        r108.put(r110, new d(0, Integer.MAX_VALUE, r102, r110));
        r108.put(r111, new d(0, Integer.MAX_VALUE, r102, r111));
        r108.put(r112, new d(0, Integer.MAX_VALUE, r102, r112));
        r108.put(r113, new d(0, Integer.MAX_VALUE, r102, r113));
        k.a().a(r102, CapabilityType.GPU_FREQ_MIN, r108);
        HashMap r109 = new HashMap();
        r109.put(r101, new d(0, Integer.MAX_VALUE, r102, r101));
        r109.put(r103, new d(0, Integer.MAX_VALUE, r102, r103));
        r109.put(r104, new d(0, Integer.MAX_VALUE, r102, r104));
        r109.put(r105, new d(0, Integer.MAX_VALUE, r102, r105));
        r109.put(r106, new d(0, Integer.MAX_VALUE, r102, r106));
        r109.put(r107, new d(0, Integer.MAX_VALUE, r102, r107));
        r109.put(r110, new d(0, Integer.MAX_VALUE, r102, r110));
        r109.put(r111, new d(0, Integer.MAX_VALUE, r102, r111));
        r109.put(r112, new d(0, Integer.MAX_VALUE, r102, r112));
        r109.put(r113, new d(0, Integer.MAX_VALUE, r102, r113));
        k.a().a(r102, CapabilityType.UFS_FREQ_MIN, r109);
        HashMap r114 = new HashMap();
        r114.put(r101, new d(-20, Integer.MAX_VALUE, r102, r101));
        r114.put(r103, new d(-16, Integer.MAX_VALUE, r102, r103));
        r114.put(r104, new d(-12, Integer.MAX_VALUE, r102, r104));
        r114.put(r105, new d(-8, Integer.MAX_VALUE, r102, r105));
        r114.put(r106, new d(-4, Integer.MAX_VALUE, r102, r106));
        r114.put(r107, new d(0, Integer.MAX_VALUE, r102, r107));
        r114.put(r110, new d(4, Integer.MAX_VALUE, r102, r110));
        r114.put(r111, new d(8, Integer.MAX_VALUE, r102, r111));
        r114.put(r112, new d(12, Integer.MAX_VALUE, r102, r112));
        r114.put(r113, new d(19, Integer.MAX_VALUE, r102, r113));
        k.a().a(r102, CapabilityType.TASK_PRIORITY, r114);
    }

    private void d(i r100) {
        android.ss.com.vboost.d r101 = r100.f4712e;
        int r102 = r101.f4604a;
        if (r102 == (-1)) goto L16;
        if (r102 != 0) goto L6;
        android.ss.com.vboost.h.j.d();
        return;
    L6:
        if (r102 != 1) goto L8;
        android.ss.com.vboost.h.j.a(r101.f4605b, r101.f4606c);
        return;
    L8:
        if (r102 != 2) goto L10;
        android.ss.com.vboost.h.j.a(r101.f4605b, r101.f4606c, r101.f4607d);
        return;
    L10:
        if (r102 == 3) goto L12;
        LogUtil.error(f4700e, "unsupport vibrator scene !");
        return;
    L12:
        android.ss.com.vboost.h.j.a(r101.f4608e);
        return;
    L16:
        android.ss.com.vboost.h.j.c();
    }

    private boolean d() {
        android.ss.com.vboost.h.e.a r100 = android.ss.com.vboost.h.e.b();
        if (r100 != android.ss.com.vboost.h.e.a.f4638b) goto L5;
    L10:
        return true;
    L5:
        if (r100 == android.ss.com.vboost.h.e.a.f4639c) goto L10;
        if (r100 == android.ss.com.vboost.h.e.a.f4640d) goto L10;
        return false;
    }

    private boolean e() {
        if (android.ss.com.vboost.h.e.b() != android.ss.com.vboost.h.e.a.f4638b) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean f() {
        return this.f4702d;
    }

    @Override // android.ss.com.vboost.i.h
    public Object a(i r100) {
        switch(a.f4703a[r100.f4708a.ordinal()]) {
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L10;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        LogUtil.warn(f4700e, "Not implement this capability type by Platform provider!!!");
    L12:
        return 1;
    L5:
        android.ss.com.vboost.h.d.c();
        LogUtil.info(f4700e, "release boost for " + r100.f4711d.f4716a.getDesc());
        goto L12
    L6:
        android.ss.com.vboost.h.j.d();
        goto L12
    L7:
        String r101 = f4700e;
        StringBuilder r102 = new StringBuilder("reset tid:");
        r102.append(r100.f4715h);
        String r103 = " core bind";
    L9:
        r102.append(r103);
        LogUtil.debug(r101, r102.toString());
        goto L12
    L8:
        r101 = f4700e;
        r102 = new StringBuilder("reset tid:");
        r102.append(r100.f4715h);
        r103 = " priority";
        goto L9
    L10:
        android.ss.com.vboost.h.d.c();
        goto L12
    }

    @Override // android.ss.com.vboost.i.h
    public boolean a(CapabilityType r100) {
        android.ss.com.vboost.g.a r101 = this.f4701c;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.a().contains(r100) == false) goto L7;
        return true;
    }

    @Override // android.ss.com.vboost.i.h
    public Object b(i r100) {
        switch(a.f4703a[r100.f4708a.ordinal()]) {
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L18;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        LogUtil.warn(f4700e, "Not implement this capability type by Platform provider!!!");
    L28:
        return 1;
    L5:
        c(r100);
        goto L28
    L6:
        d(r100);
        goto L28
    L7:
        CoreCluster r101 = r100.f4714g;
        if (r101 != CoreCluster.GOLD) goto L10;
    L15:
        String r102 = f4700e;
        StringBuilder r103 = new StringBuilder("bind tid:");
        r103.append(r100.f4715h);
        String r104 = " to big core";
    L16:
        r103.append(r104);
    L17:
        LogUtil.debug(r102, r103.toString());
        goto L28
    L10:
        if (r101 == CoreCluster.SUPER) goto L15;
        if (r101 != CoreCluster.SILVER) goto L28;
        r102 = f4700e;
        r103 = new StringBuilder("bind tid:");
        r103.append(r100.f4715h);
        r104 = " to little core";
        goto L16
    L18:
        int r105 = r100.f4710c;
        if (r105 <= 19) goto L21;
    L22:
        LogUtil.warn(f4700e, "your request level is out of range:[-19,20]");
    L23:
        r102 = f4700e;
        r103 = new StringBuilder("set tid:");
        r103.append(r100.f4715h);
        r103.append(" to priority ");
        r103.append(r100.f4710c);
        goto L17
    L21:
        if (r105 >= (-20)) goto L23;
    L24:
        android.ss.com.vboost.h.d.c(r100.f4713f);
        goto L28
    L25:
        android.ss.com.vboost.h.d.b(r100.f4713f);
        goto L28
    L26:
        android.ss.com.vboost.h.d.a(r100.f4713f);
        goto L28
    }

    public int c(i r100) {
        j r101 = r100.f4711d;
        String r102 = f4700e;
        LogUtil.info(r102, "Platform provider process scene " + r101.f4716a.getDesc());
        switch(a.f4704b[r101.f4716a.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L7;
            case 9: goto L7;
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L7;
            case 13: goto L7;
            case 14: goto L7;
            case 15: goto L7;
            case 16: goto L7;
            case 17: goto L7;
            case 18: goto L7;
            case 19: goto L7;
            case 20: goto L7;
            case 21: goto L7;
            case 22: goto L7;
            case 23: goto L7;
            case 24: goto L7;
            case 25: goto L7;
            case 26: goto L7;
            case 27: goto L7;
            case 28: goto L7;
            case 29: goto L7;
            case 30: goto L7;
            case 31: goto L7;
            case 32: goto L7;
            case 33: goto L7;
            case 34: goto L7;
            case 35: goto L7;
            case 36: goto L7;
            case 37: goto L7;
            case 38: goto L7;
            case 39: goto L7;
            case 40: goto L7;
            case 41: goto L7;
            case 42: goto L7;
            case 43: goto L7;
            case 44: goto L7;
            case 45: goto L7;
            case 46: goto L7;
            case 47: goto L7;
            case 48: goto L7;
            case 49: goto L7;
            case 50: goto L7;
            case 51: goto L7;
            case 52: goto L7;
            case 53: goto L7;
            case 54: goto L7;
            case 55: goto L7;
            default: goto L4;
        };
    L4:
        LogUtil.warn(r102, "this scene is not support!!!");
        return 0;
    L7:
        if (r101.f4717b != Status.BEGIN) goto L9;
        LogUtil.debug(r102, "begin boost for " + r101.f4716a.getDesc());
        android.ss.com.vboost.h.d.d();
        return 1;
    L9:
        LogUtil.debug(r102, "end boost for " + r101.f4716a.getDesc());
        android.ss.com.vboost.h.d.c();
        return 1;
    }
}
