package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.c0;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpecDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5798c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.work.impl.v f5799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.work.impl.n f5800b;

    static {
        f5798c = androidx.work.i.i("EnqueueRunnable");
    }

    public c(androidx.work.impl.v r10) {
        this(r10, new androidx.work.impl.n());
    }

    public static boolean b(androidx.work.impl.v r10) {
        Set r11 = androidx.work.impl.v.l(r10);
        boolean r12 = c(r10.g(), r10.f(), (String[]) r11.toArray(new String[0]), r10.d(), r10.b());
        r10.k();
        return r12;
    }

    public static boolean c(c0 r18, List r19, String[] r20, String r21, ExistingWorkPolicy r22) {
        String[] r10 = r20;
        long r11 = System.currentTimeMillis();
        WorkDatabase r12 = r18.q();
        if (r10 != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        if (r13 == false) goto L26;
        int r14 = r10.length;
        int r15 = 0;
        boolean r16 = false;
        boolean r17 = false;
        boolean r110 = true;
    L10:
        if (r15 >= r14) goto L27;
        String r111 = r10[r15];
        androidx.work.impl.model.o r112 = r12.L().getWorkSpec(r111);
        if (r112 == null) goto L13;
        WorkInfo.State r113 = r112.f5671b;
        if (r113 != WorkInfo.State.SUCCEEDED) goto L18;
        boolean r114 = true;
    L19:
        r110 = r110 & r114;
        if (r113 != WorkInfo.State.FAILED) goto L23;
        r17 = true;
    L25:
        r15 = r15 + 1;
        goto L10
    L23:
        if (r113 != WorkInfo.State.CANCELLED) goto L25;
        r16 = true;
        goto L25
    L18:
        r114 = false;
        goto L19
    L13:
        androidx.work.i.e().c(f5798c, "Prerequisite " + r111 + " doesn't exist; not enqueuing");
        return false;
    L27:
        boolean r23 = TextUtils.isEmpty(r21);
        if (r23 == true) goto L83;
        if (r13 == true) goto L83;
        List<androidx.work.impl.model.o.b> r115 = r12.L().getWorkSpecIdAndStatesForName(r21);
        if (r115.isEmpty() == true) goto L83;
        if (r22 == ExistingWorkPolicy.APPEND) goto L52;
        if (r22 == ExistingWorkPolicy.APPEND_OR_REPLACE) goto L52;
        if (r22 != ExistingWorkPolicy.KEEP) goto L47;
        Iterator<androidx.work.impl.model.o.b> r24 = r115.iterator();
    L41:
        if (r24.hasNext() == false) goto L47;
        WorkInfo.State r116 = r24.next().f5691b;
        if (r116 == WorkInfo.State.ENQUEUED) goto L46;
        if (r116 != WorkInfo.State.RUNNING) goto L41;
    L46:
        return false;
    L47:
        b.c(r21, r18, false).run();
        WorkSpecDao r25 = r12.L();
        Iterator<androidx.work.impl.model.o.b> r117 = r115.iterator();
    L49:
        if (r117.hasNext() == false) goto L51;
        r25.delete(r117.next().f5690a);
        goto L49
    L51:
        boolean r26 = true;
    L85:
        Iterator r27 = r19.iterator();
    L87:
        if (r27.hasNext() == false) goto L109;
        androidx.work.l r28 = (androidx.work.l) r27.next();
        androidx.work.impl.model.o r118 = r28.d();
        if (r13 == false) goto L96;
        if (r110 == true) goto L96;
        if (r17 == false) goto L93;
        r118.f5671b = WorkInfo.State.FAILED;
    L97:
        Iterator r119 = r27;
        if (r118.f5671b != WorkInfo.State.ENQUEUED) goto L100;
        r26 = true;
    L100:
        r12.L().insertWorkSpec(d.a(r18.o(), r118));
        if (r13 == false) goto L105;
        int r29 = r10.length;
        int r120 = 0;
    L103:
        if (r120 >= r29) goto L105;
        String[] r121 = r10;
        r12.G().insertDependency(new androidx.work.impl.model.a(r28.b(), r10[r120]));
        r120 = r120 + 1;
        r29 = r29;
        r10 = r121;
    L105:
        String[] r122 = r10;
        r12.M().insertTags(r28.b(), r28.c());
        if (r23 == true) goto L108;
        r12.J().insert(new androidx.work.impl.model.j(r21, r28.b()));
    L108:
        r27 = r119;
        r10 = r122;
        goto L87
    L93:
        if (r16 == false) goto L95;
        r118.f5671b = WorkInfo.State.CANCELLED;
        goto L97
    L95:
        r118.f5671b = WorkInfo.State.BLOCKED;
    L96:
        r118.f5683n = r11;
        goto L97
    L109:
        return r26;
    L52:
        DependencyDao r30 = r12.G();
        List r123 = new ArrayList();
        Iterator<androidx.work.impl.model.o.b> r124 = r115.iterator();
    L54:
        if (r124.hasNext() == false) goto L71;
        androidx.work.impl.model.o.b r31 = r124.next();
        if (r30.hasDependents(r31.f5690a) == true) goto L69;
        WorkInfo.State r32 = r31.f5691b;
        if (r32 != WorkInfo.State.SUCCEEDED) goto L60;
        boolean r33 = true;
    L61:
        boolean r34 = r33 & r110;
        if (r32 != WorkInfo.State.FAILED) goto L65;
        r17 = true;
    L67:
        r123.add(r31.f5690a);
        r110 = r34;
        goto L69
    L65:
        if (r32 != WorkInfo.State.CANCELLED) goto L67;
        r16 = true;
        goto L67
    L60:
        r33 = false;
    L69:
        r30 = r30;
        goto L54
    L71:
        if (r22 != ExistingWorkPolicy.APPEND_OR_REPLACE) goto L79;
        if (r16 == true) goto L74;
        if (r17 == false) goto L79;
    L74:
        WorkSpecDao r35 = r12.L();
        Iterator<androidx.work.impl.model.o.b> r36 = r35.getWorkSpecIdAndStatesForName(r21).iterator();
    L76:
        if (r36.hasNext() == false) goto L78;
        r35.delete(r36.next().f5690a);
        goto L76
    L78:
        r123 = Collections.emptyList();
        r16 = false;
        r17 = false;
    L79:
        r10 = (String[]) r123.toArray(r10);
        if (r10.length <= 0) goto L82;
        r13 = true;
        goto L83
    L82:
        r13 = false;
    L83:
        r26 = false;
        goto L85
    L26:
        r16 = false;
        r17 = false;
        r110 = true;
        goto L27
    L5:
        if (r10.length <= 0) goto L7;
        r13 = true;
        goto L8
    }

    public static boolean e(androidx.work.impl.v r10) {
        List r11 = r10.e();
        boolean r12 = false;
        if (r11 == null) goto L12;
        Iterator r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L12;
        androidx.work.impl.v r14 = (androidx.work.impl.v) r13.next();
        if (r14.j() == false) goto L9;
        androidx.work.i.e().k(f5798c, "Already enqueued work ids (" + TextUtils.join(", ", r14.c()) + ")");
        goto L6
    L9:
        r12 = r12 | e(r14);
    L12:
        return b(r10) | r12;
    }

    public boolean a() {
        WorkDatabase r10 = this.f5799a.g().q();
        r10.e();
        boolean r11 = e(this.f5799a);     // Catch: Throwable -> L6
        r10.D();     // Catch: Throwable -> L6
        r10.i();
        return r11;
    L6:
        th = move-exception;
        r10.i();
        throw th;
    }

    public Operation d() {
        return this.f5800b;
    }

    public void f() {
        c0 r10 = this.f5799a.g();
        androidx.work.impl.s.b(r10.j(), r10.q(), r10.o());
    }

    @Override // java.lang.Runnable
    public void run() {
    L7:
        th = move-exception;
        this.f5800b.a(new Operation.b.a(th));
        return;
    L3:
        if (this.f5799a.h() == true) goto L11;
        if (a() == false) goto L9;
        l.a(this.f5799a.g().i(), RescheduleReceiver.class, true);     // Catch: Throwable -> L7
        f();     // Catch: Throwable -> L7
    L9:
        this.f5800b.a(Operation.SUCCESS);     // Catch: Throwable -> L7
        return;
    L11:
        throw new IllegalStateException("WorkContinuation has cycles (" + this.f5799a + ")");     // Catch: Throwable -> L7
    }

    public c(androidx.work.impl.v r10, androidx.work.impl.n r11) {
        this.f5799a = r10;
        this.f5800b = r11;
    }
}
