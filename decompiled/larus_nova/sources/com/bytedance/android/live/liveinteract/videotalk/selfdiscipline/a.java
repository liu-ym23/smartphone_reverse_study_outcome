package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline;

import am2.x;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f79661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f79662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f79663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f79664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f79665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f79666f;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a$a, reason: collision with other inner class name */
    public static final class C1239a {
    }

    static {
    }

    public static String c() {
        SelfDisciplineContext.Companion.getClass();
        return String.valueOf(SelfDisciplineContext.access$getRoomIntro$cp());
    }

    public a() {
        this.f79661a = DoraObricDeviceHomeViewModel.PARAM_AUTO_START;
        this.f79662b = "null";
    }

    public static String a() {
        o r100 = j0.l().c(x.class);
        if (r100 == null) goto L7;
        Map<String, String> r101 = r100.getMap();
        if (r101 == null) goto L7;
        String r102 = r101.get("enter_from_merge");
    L9:
        return String.valueOf(r102);
    L7:
        r102 = null;
        goto L9
    }

    public static String b() {
        o r100 = j0.l().c(x.class);
        if (r100 == null) goto L7;
        Map<String, String> r101 = r100.getMap();
        if (r101 == null) goto L7;
        String r102 = r101.get("enter_method");
    L9:
        return String.valueOf(r102);
    L7:
        r102 = null;
        goto L9
    }
}
