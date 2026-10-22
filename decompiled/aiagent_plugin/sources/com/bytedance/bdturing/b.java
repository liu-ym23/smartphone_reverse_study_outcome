package com.bytedance.bdturing;

import android.app.Activity;
import android.os.Build;
import com.bytedance.bdturing.verify.RiskControlService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: BdTuring.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String TAG = "BdTuring";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BdTuringConfig f6501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RiskControlService f6503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap<String, com.bytedance.bdturing.verify.a> f6504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f6505e;

    /* JADX INFO: renamed from: com.bytedance.bdturing.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: BdTuring.java */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BdTuringConfig f6506a;

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.bdturing.a.a.a(this.f6506a);
        }
    }

    /* JADX INFO: compiled from: BdTuring.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static b f6507a;

        static /* synthetic */ b a() {
            return f6507a;
        }

        static {
            f6507a = new b(null);
        }
    }

    /* synthetic */ b(AnonymousClass1 r1) {
        this();
    }

    private b() {
        this.f6502b = false;
        this.f6503c = null;
        this.f6504d = new HashMap();
        this.f6505e = 0;
    }

    public static b a() {
        return a.a();
    }

    public void a(Activity r3, com.bytedance.bdturing.verify.a.a r4, c r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.aiagent.plugin");
        e.a(r4);
        if (a(r6, r4.getType(), r7) == true) goto L6;
        return;
    L6:
        if (j.a().a(r4.getType()) == false) goto L8;
        return;
    L8:
        b(r6, r4, r7);
    }

    private void b(Activity r4, com.bytedance.bdturing.verify.a.a r5, c r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
        c r8 = (c) ZeusTransformUtils.wrapperContextForParams(r6, c.class, "com.obric.aiagent.plugin");
        g.a(TAG, "BdTuring showVerifyDialog");
        r5.a(r7);
        Iterator<com.bytedance.bdturing.verify.a> r3 = this.f6504d.values().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        com.bytedance.bdturing.verify.a r9 = (com.bytedance.bdturing.verify.a) ZeusTransformUtils.preCheckCast(r3.next(), com.bytedance.bdturing.verify.a.class, "com.obric.aiagent.plugin");
        if (r9.isProcess(r5.getType()) == false) goto L4;
        r9.execute(r5, r8);
        boolean r10 = true;
    L9:
        if (r10 == true) goto L15;
        r8.a(996, null);
        return;
    L15:
        return;
    L8:
        r10 = false;
        goto L9
    }

    public BdTuringConfig b() {
        return this.f6501a;
    }

    private boolean d() {
        if ((System.currentTimeMillis() - this.f6505e) >= 500) goto L5;
        boolean r0 = true;
    L6:
        this.f6505e = System.currentTimeMillis();
        return r0;
    L5:
        r0 = false;
        goto L6
    }

    private boolean a(Activity r3, int r4, c r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.aiagent.plugin");
        if (this.f6502b == false) goto L17;
        if (r7 == null) goto L17;
        if (r6 == null) goto L17;
        if (d() == false) goto L12;
        g.a(TAG, "invoke multi times, u should take a breath");
        r7.a(1000, null);
        return false;
    L12:
        if (Build.VERSION.SDK_INT >= 17) goto L15;
        g.a(TAG, "The Android system version is too low, Please upgrade the system.");
        r7.a(999, null);
        e.d();
        return false;
    L15:
        return true;
    L17:
        r7.a(2, null);
        return false;
    }

    public boolean c() {
        return this.f6502b;
    }
}
