package com.bytedance.reparo.core;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: PatchEventReporter.java */
/* JADX INFO: loaded from: classes.dex */
public class i {
    private static final String TAG = "PatchEventReporter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.bytedance.reparo.core.a.a.b f9269a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f9270b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f9271c;

    /* JADX INFO: compiled from: PatchEventReporter.java */
    public interface a {
        void a(com.bytedance.reparo.core.a.a.a r1);
    }

    static /* synthetic */ void a(com.bytedance.reparo.core.a.a.a r0) {
        b(r0);
    }

    static {
        f9269a = new AnonymousClass1();
        a r0 = new AnonymousClass2();
        f9270b = r0;
        f9271c = r0;
    }

    private static void b(com.bytedance.reparo.core.a.a.a r1) {
        f9271c.a(r1);
    }

    public static com.bytedance.reparo.core.a.a.a a(String r2, com.bytedance.reparo.core.g.h r3, int r4) {
        com.bytedance.reparo.core.a.a.a r5 = new com.bytedance.reparo.core.a.a.a().a(r2).b("patch_install").a(f9269a);
        if (r4 != 0) goto L5;
        r5.a(2).a(false);
    L6:
        r5.b("patch_version", com.bytedance.reparo.core.a.b.e.a(r3.m()));
        r5.b("patch_id", com.bytedance.reparo.core.a.b.e.a(r3.n()));
        r5.b(MonitorConstants.APP_INSTALL_STATUS, Integer.valueOf(r4));
        return r5;
    L5:
        r5.a(0).a(true);
        goto L6
    }

    public static com.bytedance.reparo.core.a.a.a b(String r2, com.bytedance.reparo.core.g.h r3, int r4) {
        com.bytedance.reparo.core.a.a.a r5 = new com.bytedance.reparo.core.a.a.a().a(r2).b("patch_update").a(f9269a);
        if (r4 != 2) goto L5;
        r5.a(0).a(true);
    L6:
        r5.b("patch_version", com.bytedance.reparo.core.a.b.e.a(r3.m()));
        r5.b("patch_id", com.bytedance.reparo.core.a.b.e.a(r3.n()));
        r5.b("update_status", Integer.valueOf(r4));
        return r5;
    L5:
        r5.a(2).a(false);
        goto L6
    }

    public static com.bytedance.reparo.core.a.a.a a(String r1, com.bytedance.reparo.core.g.h r2, boolean r3) {
        com.bytedance.reparo.core.a.a.a r4 = new com.bytedance.reparo.core.a.a.a().a(r1).b("patch_load").a(f9269a);
        if (r3 == false) goto L5;
        r4.a(0).a(true);
    L6:
        r4.b("patch_version", com.bytedance.reparo.core.a.b.e.a(r2.m()));
        r4.b("patch_id", com.bytedance.reparo.core.a.b.e.a(r2.n()));
        r4.b("is_async", com.bytedance.reparo.core.a.b.e.a(Boolean.valueOf(r2.r())));
        return r4;
    L5:
        r4.a(2).a(false);
        goto L6
    }

    public static com.bytedance.reparo.core.a.a.a b(String r1, com.bytedance.reparo.core.g.h r2, boolean r3) {
        com.bytedance.reparo.core.a.a.a r4 = new com.bytedance.reparo.core.a.a.a().a(r1).b("patch_load_duration").a(f9269a);
        if (r3 == false) goto L5;
        r4.a(0).a(true);
    L6:
        r4.b("patch_id", com.bytedance.reparo.core.a.b.e.a(r2.n()));
        r4.b("is_async", com.bytedance.reparo.core.a.b.e.a(Boolean.valueOf(r2.r())));
        return r4;
    L5:
        r4.a(2).a(false);
        goto L6
    }

    public static com.bytedance.reparo.core.a.a.a a(String r2, boolean r3, List<com.bytedance.reparo.core.g.k.a> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        com.bytedance.reparo.core.a.a.a r6 = new com.bytedance.reparo.core.a.a.a().a(r2).b("so_md5_check").a(f9269a);
        int r0 = 0;
        if (r3 == false) goto L5;
        r6.a(0).a(true);
    L6:
        if (r5 == null) goto L9;
        r0 = r5.size();
    L9:
        r6.a("so_list_size", Integer.valueOf(r0));
        return r6;
    L5:
        r6.a(2).a(false);
        goto L6
    }

    public static void a(a r2) {
        f9271c = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
    }

    static void a(com.bytedance.reparo.core.h.d r2, long r3) {
        a(TAG, r2.g(), 1).a(r3).b().d();
    }

    static void a(com.bytedance.reparo.core.g.h r2, com.bytedance.reparo.core.b.e r3, long r4) {
        a(TAG, r2, 0).a(r4).a(r3).d();
    }

    static void a(com.bytedance.reparo.core.g.h r2, long r3) {
        b(TAG, r2, 2).a(r3).b().d();
    }

    static void a(com.bytedance.reparo.core.g.h r1, com.bytedance.reparo.core.b.d r2, int r3, long r4) {
        b(TAG, r1, r3).a(r4).a(r2).d();
    }

    static void a(com.bytedance.reparo.core.g.h r3, long r4, com.bytedance.reparo.core.h.b r6) {
        a(TAG, r3, true).a(r4).b().d();
        r6.a(b(TAG, r3, true)).d();
    }

    static void a(com.bytedance.reparo.core.g.h r2, com.bytedance.reparo.core.b.d r3, long r4) {
        a(TAG, r2, false).a(r4).a(r3).d();
    }
}
