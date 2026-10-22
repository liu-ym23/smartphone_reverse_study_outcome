package com.bytedance.framwork.core.sdklog;

import android.content.Context;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import com.bytedanceos.common.ad.common.AdConstant;
import f5.b;
import f5.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class a extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f7560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f7561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f7562d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f7563e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f7564f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f7565g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f7566h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedList f7567i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f7568j;

    public a(Context r10, b r11, LinkedList r12, AtomicBoolean r13) {
        super("LogSender");
        this.f7560b = new Object();
        this.f7563e = -1;
        this.f7564f = 0;
        this.f7565g = 120000;
        this.f7566h = r11;
        this.f7559a = r10;
        this.f7567i = r12;
        this.f7561c = r13;
        this.f7562d = c.c(r10);
    }

    public void a() {
        Object r10 = this.f7560b;
        monitor-enter(r10);
        this.f7560b.notify();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void b() {
        if (c() == false) goto L5;
        return;
    L5:
        Map r10 = this.f7566h.b();
        if (r10 != null) goto L8;
    L22:
        this.f7562d.a(null, -1, 864000000);
        return;
    L8:
        if (r10.isEmpty() == true) goto L22;
        Iterator r11 = r10.keySet().iterator();
    L11:
        if (r11.hasNext() == false) goto L22;
        String r12 = (String) r11.next();
        if (c() == true) goto L22;
        LogHandler r13 = (LogHandler) r10.get(r12);
        if (r13 == null) goto L11;
        LogHandler.IConfig r14 = r13.c();
        if (r14 == null) goto L11;
        this.f7562d.a(r12, r14.getMaxRetryCount(), r14.getLogExpireTime());
        goto L11
    }

    public final boolean c() {
        return this.f7561c.get();
    }

    public final boolean d() {
        if (c() == false) goto L5;
        return false;
    L5:
        LinkedList r10 = this.f7567i;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (c() == false) goto L14;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return false;
    L14:
        if (this.f7567i.isEmpty() == true) goto L16;
        f5.a r11 = (f5.a) this.f7567i.poll();     // Catch: Throwable -> L11
    L17:
        boolean r12 = !this.f7567i.isEmpty();     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        if (r11 != null) goto L29;
    L25:
        return r12;
    L29:
    L24:
        this.f7562d.h();
        goto L25
    L21:
        if (this.f7562d.e(r11.f19478f, r11.f19474b) < Long.MAX_VALUE) goto L25;
        this.f7562d.h();     // Catch: SQLiteFullException -> L24
        goto L25
    L16:
        r11 = null;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r22v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r26v0, types: [com.bytedance.framwork.core.sdklog.a] */
    /* JADX WARN: Type inference failed for: r2v3, types: [f5.c] */
    /* JADX WARN: Type inference failed for: r3v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [com.bytedance.framwork.core.sdklog.LogHandler] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean e() {
        boolean r10 = false;
        if (c() == false) goto L6;
        return false;
    L6:
        if (this.f7563e >= 0) goto L11;
        if ((System.currentTimeMillis() - this.f7564f) <= AdConstant.SPLASH_AD_INTERVAL) goto L11;
        this.f7563e = 0;
        b();
        this.f7564f = System.currentTimeMillis();
    L11:
        if (LogLib.b(this.f7559a) == true) goto L14;
        this.f7565g = 120000;
        return false;
    L14:
        f5.a r11 = this.f7562d.d(this.f7563e);
        LogHandler.IConfig r12 = null;
        if (r11 == null) goto L17;
        long r13 = this.f7563e;
        long r14 = r11.f19473a;
        if (r13 >= r14) goto L30;
        this.f7563e = r14;
    L31:
        byte[] r15 = r11.f19474b;
        if (r15 != null) goto L34;
    L89:
        ?? r16 = 0;
        ?? r17 = 0;
        r10 = true;
    L91:
        if (c() == false) goto L93;
        return true;
    L93:
        if (r10 == false) goto L96;
        this.f7562d.g(r11.f19473a, true, 0, 0);
    L103:
        return true;
    L96:
        if (this.f7562d.g(r11.f19473a, r17, r12.getLogExpireTime(), r12.getMaxRetryCount()) == false) goto L101;
        long r18 = r12.getRetryInterval() * ((long) (r11.f19476d + 1));
        if (r18 <= 0) goto L100;
        this.f7565g = r18;
    L100:
        this.f7565g = Math.min(120000, this.f7565g);
    L102:
        r16.g(r11.f19474b, r17);
        goto L103
    L101:
        this.f7565g = 120000;
        goto L102
    L34:
        if (r15.length <= 0) goto L89;
        LogHandler r19 = this.f7566h.d(r11.f19478f);
        if (r19 != null) goto L39;
        return true;
    L39:
        LogHandler.IConfig r110 = r19.c();
        LogHandler.IResponseConfig r20 = r19.f();
        long r111 = System.currentTimeMillis();
        long r112 = r110.getRetryInterval();
        if (r20 == null) goto L52;
        if (r20.getRemoveSwitch() == false) goto L45;
        ?? r21 = 1;
    L44:
        r12 = r110;
        r17 = r21;
        r16 = r19;
        goto L91
    L45:
        long r113 = r20.getStopInterval();
        if (r113 > 0) goto L48;
    L50:
        r19.i(System.currentTimeMillis());
        goto L52
    L48:
        if ((r111 - r19.d()) >= r113) goto L50;
        return true;
    L52:
        if (r112 <= 0) goto L58;
        int r22 = r11.f19476d;
        if (r22 <= 0) goto L58;
        if ((r111 - r11.f19477e) >= (r112 * ((long) r22))) goto L58;
        return true;
    L58:
        ?? r23 = r19.e();
        List<String> r24 = r110.getChannels();
        if (r24 != null) goto L107;
        return true;
    L107:
        String r25 = r110.getRedirectUrl();     // Catch: Throwable -> L64
        if (TextUtils.isEmpty(r25) == true) goto L105;
        ?? r26 = f(r19, r25, r11.f19474b);     // Catch: Throwable -> L64
    L87:
        r21 = r26;
        goto L44
    L105:
        if (TextUtils.isEmpty(r23) == true) goto L76;
        r23 = f(r19, r23, r11.f19474b);     // Catch: Throwable -> L64
        if (r23 != 0) goto L74;
        r19.j("");     // Catch: Throwable -> L72
        r23 = r23;
    L104:
    L74:
        r26 = r23;
        goto L87
    L76:
        if (r20.getMoreChannelSwitch() == false) goto L78;
        this.f7568j++;     // Catch: Throwable -> L64
    L78:
        int r27 = r24.size();     // Catch: Throwable -> L64
        int r28 = this.f7568j;     // Catch: Throwable -> L64
        if (r27 <= r28) goto L82;
        if (r28 < 0) goto L82;
        String r29 = r24.get(r28);     // Catch: Throwable -> L64
    L83:
        r23 = f(r19, r29, r11.f19474b);     // Catch: Throwable -> L64
        if (r23 == 0) goto L74;
        r19.j(r29);     // Catch: Throwable -> L72
        r23 = r23;
    L82:
        this.f7568j = 0;     // Catch: Throwable -> L64
        r29 = r24.get(0);     // Catch: Throwable -> L64
    L72:
        th = th;
    L88:
        b.g("LogSender", "send log exception: " + th);
        r21 = r23;
    L64:
        th = th;
        r23 = 0;
        goto L88
    L30:
        this.f7563e = r13 + 1;
        goto L31
    L17:
        if (this.f7563e != 0) goto L23;
        if (this.f7562d.b(null) != 0) goto L23;
        this.f7565g = 0;
        return false;
    L23:
        if (this.f7563e != (-1)) goto L25;
        this.f7565g = 120000;
    L25:
        this.f7563e = -1;
        return false;
    }

    public final boolean f(LogHandler r10, String r11, byte[] r12) {
        if (r12 != null) goto L4;
        return false;
    L4:
        if (r12.length <= 0) goto L13;
        if (r10 != null) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r11) == false) goto L10;
        return false;
    L10:
        return r10.h(r11, r12);
    L13:
        return false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        b.g("LogSender", "LogSender start");
    L4:
        if (c() == true) goto L31;
        boolean r10 = d();
        if (c() == true) goto L31;
        if (e() == true) goto L13;
        if (r10 == true) goto L13;
        boolean r11 = false;
    L15:
        if (c() == true) goto L31;
        if (r11 == true) goto L4;
        Object r12 = this.f7560b;
        monitor-enter(r12);
        long r13 = this.f7565g;     // Catch: Throwable -> L24 InterruptedException -> L33
        if (r13 != 0) goto L26;
        this.f7560b.wait();     // Catch: Throwable -> L24 InterruptedException -> L33
        goto L27
    L26:
        this.f7560b.wait(r13);     // Catch: Throwable -> L24 InterruptedException -> L33
        goto L27
    L24:
        th = move-exception;
        throw th;
    L27:
        monitor-exit(r12);     // Catch: Throwable -> L24
    L13:
        r11 = true;
    L31:
        b.g("LogSender", "LogSender quit");
    }
}
