package androidx.room;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SQLiteCopyOpenHelperFactory.java */
/* JADX INFO: loaded from: classes.dex */
class u implements androidx.sqlite.db.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f2702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Callable<InputStream> f2703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final androidx.sqlite.db.d.c f2704d;

    u(String r3, File r4, Callable<InputStream> r5, androidx.sqlite.db.d.c r6) {
        Callable<InputStream> r7 = (Callable) ZeusTransformUtils.wrapperContextForParams(r5, Callable.class, "com.obric.aiagent.plugin");
        androidx.sqlite.db.d.c r8 = (androidx.sqlite.db.d.c) ZeusTransformUtils.wrapperContextForParams(r6, androidx.sqlite.db.d.c.class, "com.obric.aiagent.plugin");
        this.f2701a = r3;
        this.f2702b = r4;
        this.f2703c = r7;
        this.f2704d = r8;
    }

    @Override // androidx.sqlite.db.d.c
    public androidx.sqlite.db.d b(androidx.sqlite.db.d.b r9) {
        return new t(r9.f2733a, this.f2701a, this.f2702b, this.f2703c, r9.f2735c.f2732b, this.f2704d.b(r9));
    }
}
