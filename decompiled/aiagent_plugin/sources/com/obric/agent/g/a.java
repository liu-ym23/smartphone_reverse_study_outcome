package com.obric.agent.g;

import com.bytedance.keva.Keva;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.o;

/* JADX INFO: compiled from: KevaRepos.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14560a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f14561b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f f14562c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final f f14563d = null;

    public static /* synthetic */ Keva lambda$L9GTMy1SGKYKyHhiaAvXQvvLkKU() {
        return e();
    }

    public static /* synthetic */ Keva lambda$o7r6WzXlt1bw3hIB13_Vdfxa9Yo() {
        return c();
    }

    public static /* synthetic */ Keva lambda$prZMrEJhhdM5bcZ5xQf8lHDfM0g() {
        return d();
    }

    private a() {
    }

    static {
        f14560a = new a();
        f14561b = g.a($$Lambda$a$o7r6WzXlt1bw3hIB13_Vdfxa9Yo.INSTANCE);
        f14562c = g.a($$Lambda$a$prZMrEJhhdM5bcZ5xQf8lHDfM0g.INSTANCE);
        f14563d = g.a($$Lambda$a$L9GTMy1SGKYKyHhiaAvXQvvLkKU.INSTANCE);
    }

    private static final Keva c() {
        return Keva.getRepo(DownloadSettingKeys.BugFix.DEFAULT, 0);
    }

    public final Keva a() {
        Object r2 = f14562c.b();
        o.c(r2, "getValue(...)");
        return (Keva) ZeusTransformUtils.preCheckCast(r2, Keva.class, "com.obric.aiagent.plugin");
    }

    private static final Keva d() {
        return Keva.getRepo("intents", 0);
    }

    private static final Keva e() {
        return Keva.getRepo("debug", 0);
    }

    public final boolean b() {
        return a().getBoolean("is_traffic_downloadable", false);
    }

    public final void a(boolean r2) {
        a().storeBoolean("is_traffic_downloadable", r2);
    }
}
