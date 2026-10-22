package com.obric.aiagent.utils;

import com.bytedance.keva.Keva;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.o;

/* JADX INFO: compiled from: KevaRepos.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22291a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f22292b = null;

    public static /* synthetic */ Keva lambda$5bI7ljOgUMfDhZwJQUapqMkCoiM() {
        return b();
    }

    private a() {
    }

    static {
        f22291a = new a();
        f22292b = g.a($$Lambda$a$5bI7ljOgUMfDhZwJQUapqMkCoiM.INSTANCE);
    }

    public final Keva a() {
        Object r2 = f22292b.b();
        o.c(r2, "getValue(...)");
        return (Keva) ZeusTransformUtils.preCheckCast(r2, Keva.class, "com.obric.aiagent.plugin");
    }

    private static final Keva b() {
        return Keva.getRepo("aiagent_default", 1);
    }
}
