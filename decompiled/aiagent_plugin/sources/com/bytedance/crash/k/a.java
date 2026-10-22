package com.bytedance.crash.k;

import android.content.Context;
import com.bytedance.crash.i;
import com.bytedance.crash.monitor.h;
import com.bytedance.crash.npth_repair.NpthRepair;
import com.bytedance.crash.npth_repair.monitor.SignalMonitor;
import com.bytedance.crash.npth_repair.nativeCrash.MTKBufferOpt;
import com.bytedance.crash.npth_repair.nativeCrash.ScudoVmaLeakFixer;
import com.bytedance.crash.o.r;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: RepairAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "NpthRepairAdapter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7551a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f7552b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static com.bytedance.crash.k.b f7553c;
    private static final b j = null;
    private static final b k = null;
    private static final b l = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7555e;
    private ArrayList<b> f;
    private int g;
    private int h;
    private boolean i;

    /* JADX INFO: renamed from: com.bytedance.crash.k.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RepairAdapter.java */
    private static final class C0168a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a f7557a = null;

        static {
            f7557a = new a(null);
        }
    }

    /* JADX INFO: compiled from: RepairAdapter.java */
    interface b {
        int a(int r1);
    }

    private static boolean b(int r1, int r2) {
        if ((r1 & (1 << r2)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    /* synthetic */ a(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ ArrayList a(a r0) {
        return r0.f;
    }

    static /* synthetic */ boolean a(int r0, int r1) {
        return b(r0, r1);
    }

    static /* synthetic */ int b(a r0) {
        return r0.g;
    }

    static /* synthetic */ boolean b() {
        return f7551a;
    }

    static /* synthetic */ boolean c() {
        return f7552b;
    }

    static /* synthetic */ com.bytedance.crash.k.b d() {
        return f7553c;
    }

    static {
        j = new AnonymousClass1();
        k = new AnonymousClass2();
        l = new AnonymousClass3();
    }

    private a() {
        this.f7554d = false;
        this.f7555e = -1;
    }

    private static a e() {
        return C0168a.f7557a;
    }

    private void f() {
        this.g = f7553c.b();
        this.h = f7553c.a();
        this.i = f7553c.c();
        r.b(TAG, "type: " + this.g + " debug: " + this.i + " delayedTime: " + this.h);
        if (g() == false) goto L6;
        DefaultWorkThread.postDelayed(new AnonymousClass4(this), this.h);
        return;
    }

    private boolean g() {
        if (this.f7554d == true) goto L5;
        this.f7554d = true;
        int r0 = b(this.i);
        this.f7555e = r0;
        if (r0 == 0) goto L11;
        return false;
    L11:
        ArrayList<b> r1 = new ArrayList();
        this.f = r1;
        r1.add(j);
        this.f.add(k);
        this.f.add(l);
        return true;
    L5:
        if (this.f7555e == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public int a(int r1, String r2) {
        if (b(this.g, r1) == true) goto L7;
        return -1;
    L7:
        if (r1 == 2) goto L9;
        return -2;
    L9:
        return SignalMonitor.a().a(r2);
    }

    public static synchronized void a(com.bytedance.crash.k.b r1) {
        monitor-enter(a.class);
        if (r1 != null) goto L13;
        monitor-exit(a.class);
        return;
    L13:
        f7553c = r1;     // Catch: Throwable -> L10
        e().f();     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static synchronized int b(int r2, String r3) {
        monitor-enter(a.class);
        int r4 = e().a(r2, r3);     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    private static int b(boolean r3) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return -7;
    L5:
        return NpthRepair.a(r0, r3);
    }

    public static void a(boolean r0) {
        f7551a = r0;
        f7552b = false;
    }

    public static synchronized int a(int r2) {
        monitor-enter(a.class);
        int r1 = b(false);     // Catch: Throwable -> L12
        if (r1 != 0) goto L10;
        int r3 = MTKBufferOpt.a(r2);     // Catch: Throwable -> L12
        monitor-exit(a.class);
        return r3;
    L10:
        monitor-exit(a.class);
        return r1;
    L12:
        th = move-exception;
        throw th;
    }

    public static int a() {
        int r0 = b(false);
        if (r0 != 0) goto L8;
        r0 = ScudoVmaLeakFixer.a();
        com.bytedance.crash.monitor.a r1 = h.a();     // Catch: Throwable -> L9
        if (r1 == null) goto L8;
        r1.a("fix_scudo", String.valueOf(r0));     // Catch: Throwable -> L9
    L8:
        return r0;
    }
}
