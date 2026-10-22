package com.bytedance.android.livesdk.chatroom.vs_base.log;

import am2.a0;
import am2.b0;
import com.bytedance.android.livehostapi.platform.IHostLog;
import com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.l;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import fq1.r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jc1.k;

/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f118008b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Class[] f118009c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class, o> f118010a;

    static {
        f118008b = new d();
        f118009c = new Class[]{a0.class, b0.class};
    }

    public static HashMap b() {
        if (ir1.b.a(l.class) != null) goto L6;
        return null;
    L6:
        l r100 = (l) ir1.b.a(l.class);
        r100.getClass();
        HashMap r101 = new HashMap();
        if (r100.g() == true) goto L10;
    L42:
        return r101;
    L10:
        if (r100.k() == false) goto L13;
        String r102 = "portrait_half";
    L27:
        r101.put("is_full_screen_mode", r102);
        if (r100.c() == false) goto L31;
    L32:
        String r103 = "0";
    L34:
        r101.put("is_hor", r103);
        if (r100.c() == false) goto L38;
    L39:
        String r104 = "portrait";
    L41:
        r101.put("replay_screen_type", r104);
        goto L42
    L38:
        if (r100.j() == true) goto L39;
        r104 = "landscape";
        goto L41
    L31:
        if (r100.j() == true) goto L32;
        r103 = "1";
        goto L34
    L13:
        if (r100.j() == false) goto L16;
        r102 = "portrait_full";
        goto L27
    L16:
        if (r100.d() == true) goto L18;
    L20:
        boolean r105 = false;
    L21:
        if (r105 == false) goto L24;
        r102 = "landscape_half";
        goto L27
    L24:
        if (r100.e() == false) goto L26;
        r102 = "landscape_full";
        goto L27
    L26:
        r102 = "";
        goto L27
    L18:
        if (r100.c() == false) goto L20;
        r105 = true;
        goto L21
    }

    public d() {
        HashMap r100 = new HashMap();
        this.f118010a = r100;
        r100.put(a0.class, new ar1.b());
        r100.put(b0.class, new ar1.c());
    }

    public static d a(DataCenter r100) {
        if (r100 != null) goto L6;
        return f118008b;
    L6:
        if (r100.has("data_center_data_replay_logger_key_map") == true) goto L9;
        r100.put("data_center_data_replay_logger_key_map", new d());
    L9:
        return (d) r100.get("data_center_data_replay_logger_key_map", new d());
    }

    public final o c(Class r100) {
        return (o) ((HashMap) this.f118010a).get(r100);
    }

    public final void d(String r100, Map<String, String> r101, Object... r102) {
        HashMap r103 = new HashMap();
        if (r101 == null) goto L6;
        r103.putAll(r101);
    L6:
        if (r100.startsWith("livesdk_replay_video_") == true) goto L13;
        if (r100.startsWith("replay_video_") == false) goto L11;
        r100 = "livesdk_".concat(r100);
        goto L13
    L11:
        r100 = "livesdk_replay_video_".concat(r100);
    L13:
        if (b() == null) goto L18;
        Iterator r104 = b().entrySet().iterator();
    L16:
        if (r104.hasNext() == false) goto L18;
        Map.Entry r105 = (Map.Entry) r104.next();
        r103.put((String) r105.getKey(), (String) r105.getValue());
    L18:
        e(r100, r103, r102);
    }

    public final void e(String r100, Map<String, String> r101, Object... r110) {
        HashMap r102 = new HashMap();
        Class[] r103 = f118009c;
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        ((o) ((HashMap) this.f118010a).get(r103[r105])).a(r102);
        r105 = r105 + 1;
        goto L3
    L5:
        int r106 = r110.length;
        int r107 = 0;
    L6:
        if (r107 >= r106) goto L21;
        Object r108 = r110[r107];
        if (r108 == null) goto L20;
        if ((r108 instanceof Class) == false) goto L17;
        if (((HashMap) this.f118010a).containsKey(r108) == false) goto L20;
        ((o) ((HashMap) this.f118010a).get(r108)).a(r102);
        goto L20
    L17:
        if (((HashMap) this.f118010a).containsKey(r108.getClass()) == false) goto L20;
        ((o) ((HashMap) this.f118010a).get(r108.getClass())).u(r102, r108);
    L20:
        r107 = r107 + 1;
        goto L6
    L21:
        if (r101 == null) goto L26;
        if (r101.size() <= 0) goto L26;
        r102.putAll(r101);
    L26:
        if (StringUtils.isEmpty(r100) == true) goto L45;
        IHostLog r109 = (IHostLog) k.f(IHostLog.class);
        if (r109 == null) goto L31;
        r109.logV3(r100, r102);
    L31:
        HashMap r111 = new HashMap();
        Iterator r112 = r102.entrySet().iterator();
    L33:
        if (r112.hasNext() == false) goto L35;
        Map.Entry r113 = (Map.Entry) r112.next();
        r111.put((String) r113.getKey(), r113.getValue());
        goto L33
    L35:
        r.a().c("ttlive_eventlog", r111);
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    }
}
