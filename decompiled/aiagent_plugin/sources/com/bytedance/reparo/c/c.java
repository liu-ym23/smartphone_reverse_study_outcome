package com.bytedance.reparo.c;

import com.bytedance.reparo.model.PatchFetchInfo;
import java.io.File;

/* JADX INFO: compiled from: EventReporter.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f9108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.bytedance.reparo.core.a.a.b f9109b = null;

    static /* synthetic */ d b() {
        return f9108a;
    }

    static {
        f9109b = new AnonymousClass1();
    }

    static void a() {
        d r0 = new d();
        f9108a = r0;
        com.bytedance.reparo.core.i.a(r0);
    }

    private static com.bytedance.reparo.core.a.a.a a(String r1, boolean r2) {
        com.bytedance.reparo.core.a.a.a r3 = new com.bytedance.reparo.core.a.a.a().a(r1).b("sdk_init").a(f9109b);
        if (r2 == false) goto L5;
        r3.a(0).a(true);
    L6:
        return r3;
    L5:
        r3.a(2).a(false);
        goto L6
    }

    private static com.bytedance.reparo.core.a.a.a b(String r1, boolean r2) {
        com.bytedance.reparo.core.a.a.a r3 = new com.bytedance.reparo.core.a.a.a().a(r1).b("query_remote_patch_info").a(f9109b);
        if (r2 == false) goto L5;
        r3.a(0).a(true);
    L6:
        return r3;
    L5:
        r3.a(2).a(false);
        goto L6
    }

    private static com.bytedance.reparo.core.a.a.a a(String r1, PatchFetchInfo r2, boolean r3) {
        com.bytedance.reparo.core.a.a.a r4 = new com.bytedance.reparo.core.a.a.a().a(r1).b("patch_download").a(f9109b);
        if (r3 == false) goto L5;
        r4.a(0).a(true);
    L6:
        r4.b("patch_version", String.valueOf(r2.getVersionCode()));
        r4.b("patch_id", String.valueOf(r2.getPatchId()));
        return r4;
    L5:
        r4.a(2).a(false);
        goto L6
    }

    public static void a(String r2, PatchFetchInfo r3, File r4, long r5) {
        a(r2, r3, true).c(String.format("download %s success.", new Object[]{r3.toString()})).a("patch_size", Long.valueOf(com.bytedance.reparo.core.a.b.b.e(r4))).a(r5).b().d();
    }

    public static void a(String r1, PatchFetchInfo r2, com.bytedance.reparo.core.b.d r3, long r4) {
        a(r1, r2, false).a(r3).a(r4).d();
    }

    public static void a(String r1, String r2, long r3) {
        b(r1, true).c(r2).a(r3).b().d();
    }

    public static void a(String r1, com.bytedance.reparo.core.b.d r2, long r3) {
        b(r1, false).a(r3).a(r2).d();
    }

    public static void a(String r1, long r2) {
        a(r1, true).a(r2).b().d();
    }

    public static void b(String r1, com.bytedance.reparo.core.b.d r2, long r3) {
        a(r1, false).a(r3).a(r2).d();
    }
}
