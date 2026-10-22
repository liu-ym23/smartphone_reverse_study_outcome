package com.bytedance.android.livesdk.vs;

import am2.f0;
import com.bytedance.android.livehostapi.platform.IHostLog;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.filter.w0;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jc1.k;

/* JADX INFO: loaded from: classes11.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f159373c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Class[] f159374d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class, o> f159375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataCenter f159376b;

    static {
        f159373c = new f();
        f159374d = new Class[]{ju2.b.class, ju2.f.class};
    }

    public f() {
        HashMap r100 = new HashMap();
        this.f159375a = r100;
        this.f159376b = null;
        r100.put(ju2.f.class, new iu2.b());
        r100.put(ju2.b.class, new iu2.a());
        r100.put(f0.class, new w0());
    }

    public static f a(DataCenter r100) {
        if (r100 != null) goto L6;
        return f159373c;
    L6:
        if (r100.has("data_center_data_vs_logger_key_map") == true) goto L9;
        f r101 = new f();
        r101.f159376b = r100;
        r100.put("data_center_data_vs_logger_key_map", r101);
    L9:
        return (f) r100.get("data_center_data_vs_logger_key_map", new f());
    }

    public final o b(Class r100) {
        return (o) ((HashMap) this.f159375a).get(r100);
    }

    public final void c(String r100, Map<String, String> r101, Object... r102) {
        HashMap r103 = new HashMap();
        if (r101 == null) goto L5;
        r103.putAll(r101);
    L5:
        ju2.f r104 = ((iu2.b) ((HashMap) this.f159375a).get(ju2.f.class)).f495771c;
        if (r104 != null) goto L13;
        int r105 = r102.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L13;
        Object r107 = r102[r106];
        if ((r107 instanceof ju2.f) == false) goto L12;
        r104 = (ju2.f) r107;
    L12:
        r106 = r106 + 1;
    L13:
        if (r104 == null) goto L23;
        int r108 = r104.E;
        if (r108 != EpisodeMod.EpisodeStageType.LIVE) goto L17;
    L22:
        String r109 = "livesdk_";
    L25:
        if (r100.startsWith("vs_".concat(r109)) == false) goto L28;
    L31:
        d(r100, r103, r102);
        return;
    L28:
        if (r100.startsWith(r109) == false) goto L30;
        r100 = "vs_".concat(r100);
        goto L31
    L30:
        r100 = "vs_" + r109 + r100;
        goto L31
    L17:
        if (r108 == EpisodeMod.EpisodeStageType.PREMIERE) goto L22;
        if (r108 != EpisodeMod.EpisodeStageType.RECORD) goto L23;
        r109 = "video_";
    L23:
        r109 = "";
        goto L25
    }

    public final void d(String r100, Map<String, String> r101, Object... r110) {
        HashMap r102 = new HashMap();
        if (r110 == null) goto L24;
        Class[] r103 = f159374d;
        int r104 = r103.length;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L7;
        ((o) ((HashMap) this.f159375a).get(r103[r105])).a(r102);
        r105 = r105 + 1;
        goto L5
    L7:
        int r106 = r110.length;
        int r107 = 0;
    L8:
        if (r107 >= r106) goto L24;
        Object r108 = r110[r107];
        if (r108 == null) goto L22;
        if ((r108 instanceof Class) == false) goto L19;
        if (((HashMap) this.f159375a).containsKey(r108) == false) goto L22;
        ((o) ((HashMap) this.f159375a).get(r108)).a(r102);
        goto L22
    L19:
        if (((HashMap) this.f159375a).containsKey(r108.getClass()) == false) goto L22;
        ((o) ((HashMap) this.f159375a).get(r108.getClass())).u(r102, r108);
    L22:
        r107 = r107 + 1;
    L24:
        if (((HashMap) r101).size() <= 0) goto L26;
        r102.putAll(r101);
    L26:
        DataCenter r109 = this.f159376b;
        if (r109 == null) goto L32;
        b r111 = (b) r109.get("video_watch_record_logger_key", null);
        if (r111 == null) goto L32;
        r102.put("vs_trigger_watch_record", String.valueOf(r111.O4()));
    L32:
        if (StringUtils.isEmpty(r100) == true) goto L51;
        IHostLog r112 = (IHostLog) k.f(IHostLog.class);
        if (r112 == null) goto L37;
        r112.logV3(r100, r102);
    L37:
        HashMap r113 = new HashMap();
        Iterator r114 = r102.entrySet().iterator();
    L39:
        if (r114.hasNext() == false) goto L41;
        Map.Entry r115 = (Map.Entry) r114.next();
        r113.put((String) r115.getKey(), r115.getValue());
        goto L39
    L41:
        b0.o().j("ttlive_eventlog", r113);
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    }
}
