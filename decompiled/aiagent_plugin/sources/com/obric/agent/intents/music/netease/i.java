package com.obric.agent.intents.music.netease;

import com.bytedance.crash.general.RomInfo;
import com.bytedance.crypto.platform.PlatformConst;
import d.h.b.o;
import org.json.JSONObject;

/* JADX INFO: compiled from: CloudMusicConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f14834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f14835e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;

    public i(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12) {
        o.e(r2, "channel");
        o.e(r3, "deviceId");
        o.e(r4, "deviceType");
        o.e(r5, "appVer");
        o.e(r6, RomInfo.KEY_OS_TYPE);
        o.e(r7, "osVer");
        o.e(r8, PlatformConst.BUNDLE_KEY_BRAND);
        o.e(r9, "model");
        o.e(r10, "clientIp");
        o.e(r11, "netStatus");
        this.f14831a = r2;
        this.f14832b = r3;
        this.f14833c = r4;
        this.f14834d = r5;
        this.f14835e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        if (r12 != null) goto L5;
        r12 = "init";
    L5:
        this.k = r12;
    }

    public final JSONObject a() {
        JSONObject r0 = new JSONObject();
        r0.put("channel", this.f14831a);
        r0.put("deviceId", this.f14832b);
        r0.put("deviceType", this.f14833c);
        r0.put("appVer", this.f14834d);
        r0.put(RomInfo.KEY_OS_TYPE, this.f14835e);
        r0.put("osVer", this.f);
        r0.put(PlatformConst.BUNDLE_KEY_BRAND, this.g);
        r0.put("model", this.h);
        r0.put("clientIp", this.i);
        r0.put("netStatus", this.j);
        r0.put("flowFlag", this.k);
        return r0;
    }
}
