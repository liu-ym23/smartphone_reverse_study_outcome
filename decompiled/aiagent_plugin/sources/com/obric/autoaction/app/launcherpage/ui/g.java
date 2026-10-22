package com.obric.autoaction.app.launcherpage.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: PowerAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.f f24444a;

    /* JADX INFO: renamed from: lambda$DyPzNXGGaGWEQcIOVIZ-Ob0x8_g, reason: not valid java name */
    public static /* synthetic */ Map m562lambda$DyPzNXGGaGWEQcIOVIZOb0x8_g() {
        return b();
    }

    public g() {
        this.f24444a = d.g.a($$Lambda$g$DyPzNXGGaGWEQcIOVIZOb0x8_g.INSTANCE);
    }

    public final Map<Class<? extends c>, c> a() {
        return (Map) ZeusTransformUtils.preCheckCast(this.f24444a.b(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final Map b() {
        return (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }
}
