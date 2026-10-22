package com.obric.autogui.net.wschannel.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: WsConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f29250a = null;

    static {
        f29250a = new b();
    }

    private final String l() {
        return "wss://frontier.snssdk.com/ws/v2";
    }

    public final String a() {
        return "85a1a0281093a7363ef785deb74f57f3";
    }

    public final int b() {
        return 3;
    }

    public final int c() {
        return 1319;
    }

    public final int d() {
        return 1;
    }

    public final int f() {
        return 50000;
    }

    public final int g() {
        return 30;
    }

    public final int h() {
        return 33554847;
    }

    public final int i() {
        return 1;
    }

    private b() {
    }

    public final List<String> e() {
        return p.c(new String[]{l()});
    }

    public final long j() {
        return System.currentTimeMillis();
    }

    public final Map<String, String> k() {
        return (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }
}
