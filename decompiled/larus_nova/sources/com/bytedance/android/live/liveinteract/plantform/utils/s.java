package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f77534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f77535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f77536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f77537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f77538e;

    public s() {
    }

    public final void a() {
        if (this.f77537d != 0) goto L5;
        return;
    L5:
        long r100 = System.currentTimeMillis() - this.f77537d;
        if (this.f77534a != 0) goto L8;
        this.f77534a = r100;
    L8:
        this.f77535b += r100;
        this.f77537d = 0;
        this.f77538e = false;
    }

    public final void b() {
        a();
        long r100 = this.f77534a;
        if (r100 <= 0) goto L5;
        TalkRoomBusinessFullLinkMonitor.f71456a.getClass();
        JSONObject r101 = new JSONObject();
        r101.put("duration", r100);
        nd0.c.o(nd0.c.f518746a, LinkMonitorData.ANCHOR_FIRST_ZERO_LINK_DURATION, r101, 0, null, false, 28);
        this.f77534a = 0;
    L5:
        long r102 = this.f77535b;
        if (r102 <= 0) goto L9;
        TalkRoomBusinessFullLinkMonitor r103 = TalkRoomBusinessFullLinkMonitor.f71456a;
        int r104 = this.f77536c;
        r103.getClass();
        JSONObject r105 = new JSONObject();
        r105.put("zero_link_count", r104);
        r105.put("duration", r102);
        nd0.c.o(nd0.c.f518746a, LinkMonitorData.ANCHOR_TOTAL_ZERO_LINK_DURATION, r105, 0, null, false, 28);
        this.f77535b = 0;
        this.f77536c = 0;
        return;
    }

    public final void c() {
        this.f77537d = System.currentTimeMillis();
        this.f77538e = true;
        this.f77536c++;
    }
}
