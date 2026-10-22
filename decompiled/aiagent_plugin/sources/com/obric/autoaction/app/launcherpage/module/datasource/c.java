package com.obric.autoaction.app.launcherpage.module.datasource;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: NewSetupTimerTasks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f24201a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f24202b = null;

    private c() {
    }

    static {
        f24201a = new c();
        f24202b = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
    }

    public final Set<String> a() {
        return f24202b;
    }

    public final List<String> b() {
        Set<String> r2 = f24202b;
        List<String> r0 = p.o((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin"));
        r2.clear();
        return r0;
    }
}
