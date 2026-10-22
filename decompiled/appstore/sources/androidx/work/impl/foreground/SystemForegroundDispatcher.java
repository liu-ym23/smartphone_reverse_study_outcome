package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.d;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.c0;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.b;
import androidx.work.impl.model.i;
import androidx.work.impl.model.o;
import androidx.work.impl.model.q;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class SystemForegroundDispatcher implements WorkConstraintsCallback, ExecutionListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f5594k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c0 f5596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TaskExecutor f5597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f5598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f5599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f5600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f5601g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set f5602h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WorkConstraintsTracker f5603i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Callback f5604j;

    public interface Callback {
        void cancelNotification(int r10);

        void notify(int r10, @NonNull Notification r11);

        void startForeground(int r10, int r11, @NonNull Notification r12);

        void stop();
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f5605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SystemForegroundDispatcher f5606b;

        public a(SystemForegroundDispatcher r10, String r11) {
            this.f5606b = r10;
            this.f5605a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            o r10 = SystemForegroundDispatcher.a(this.f5606b).n().d(this.f5605a);
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.f() == false) goto L17;
            Object r11 = this.f5606b.f5598d;
            monitor-enter(r11);
            this.f5606b.f5601g.put(q.a(r10), r10);     // Catch: Throwable -> L11
            this.f5606b.f5602h.add(r10);     // Catch: Throwable -> L11
            SystemForegroundDispatcher r12 = this.f5606b;     // Catch: Throwable -> L11
            r12.f5603i.replace(r12.f5602h);     // Catch: Throwable -> L11
            monitor-exit(r11);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    static {
        f5594k = androidx.work.i.i("SystemFgDispatcher");
    }

    public SystemForegroundDispatcher(Context r10) {
        this.f5595a = r10;
        this.f5598d = new Object();
        c0 r11 = c0.l(r10);
        this.f5596b = r11;
        this.f5597c = r11.r();
        this.f5599e = null;
        this.f5600f = new LinkedHashMap();
        this.f5602h = new HashSet();
        this.f5601g = new HashMap();
        this.f5603i = new b(this.f5596b.p(), this);
        this.f5596b.n().c(this);
    }

    public static /* synthetic */ c0 a(SystemForegroundDispatcher r10) {
        return r10.f5596b;
    }

    public static Intent b(Context r10, i r11, d r12) {
        Intent r13 = new Intent(r10, SystemForegroundService.class);
        r13.setAction("ACTION_NOTIFY");
        r13.putExtra("KEY_NOTIFICATION_ID", r12.c());
        r13.putExtra("KEY_FOREGROUND_SERVICE_TYPE", r12.a());
        r13.putExtra("KEY_NOTIFICATION", r12.b());
        r13.putExtra("KEY_WORKSPEC_ID", r11.b());
        r13.putExtra("KEY_GENERATION", r11.a());
        return r13;
    }

    public static Intent c(Context r10, i r11, d r12) {
        Intent r13 = new Intent(r10, SystemForegroundService.class);
        r13.setAction("ACTION_START_FOREGROUND");
        r13.putExtra("KEY_WORKSPEC_ID", r11.b());
        r13.putExtra("KEY_GENERATION", r11.a());
        r13.putExtra("KEY_NOTIFICATION_ID", r12.c());
        r13.putExtra("KEY_FOREGROUND_SERVICE_TYPE", r12.a());
        r13.putExtra("KEY_NOTIFICATION", r12.b());
        return r13;
    }

    public static Intent d(Context r10) {
        Intent r11 = new Intent(r10, SystemForegroundService.class);
        r11.setAction("ACTION_STOP_FOREGROUND");
        return r11;
    }

    public final void e(Intent r10) {
        androidx.work.i.e().f(f5594k, "Stopping foreground work for " + r10);
        String r11 = r10.getStringExtra("KEY_WORKSPEC_ID");
        if (r11 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L9;
        this.f5596b.g(UUID.fromString(r11));
        return;
    }

    public final void f(Intent r10) {
        int r11 = 0;
        int r12 = r10.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int r13 = r10.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String r14 = r10.getStringExtra("KEY_WORKSPEC_ID");
        i r15 = new i(r14, r10.getIntExtra("KEY_GENERATION", 0));
        Notification r16 = (Notification) r10.getParcelableExtra("KEY_NOTIFICATION");
        androidx.work.i.e().a(f5594k, "Notifying with (id:" + r12 + ", workSpecId: " + r14 + ", notificationType :" + r13 + ")");
        if (r16 != null) goto L5;
        return;
    L5:
        if (this.f5604j == null) goto L21;
        this.f5600f.put(r15, new d(r12, r16, r13));
        if (this.f5599e != null) goto L9;
        this.f5599e = r15;
        this.f5604j.startForeground(r12, r13, r16);
        return;
    L9:
        this.f5604j.notify(r12, r16);
        if (r13 == 0) goto L23;
        Iterator r17 = this.f5600f.entrySet().iterator();
    L13:
        if (r17.hasNext() == false) goto L15;
        r11 = r11 | ((d) ((Map.Entry) r17.next()).getValue()).a();
        goto L13
    L15:
        d r18 = (d) this.f5600f.get(this.f5599e);
        if (r18 == null) goto L24;
        this.f5604j.startForeground(r18.c(), r11, r18.b());
        return;
    L24:
        return;
    L23:
        return;
    }

    public final void g(Intent r10) {
        androidx.work.i.e().f(f5594k, "Started foreground service " + r10);
        this.f5597c.executeOnTaskThread(new a(this, r10.getStringExtra("KEY_WORKSPEC_ID")));
    }

    public void h(Intent r10) {
        androidx.work.i.e().f(f5594k, "Stopping foreground service");
        Callback r11 = this.f5604j;
        if (r11 == null) goto L6;
        r11.stop();
        return;
    }

    public void i() {
        this.f5604j = null;
        Object r10 = this.f5598d;
        monitor-enter(r10);
        this.f5603i.reset();     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        this.f5596b.n().j(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void j(Intent r10) {
        String r11 = r10.getAction();
        if ("ACTION_START_FOREGROUND".equals(r11) == false) goto L6;
        g(r10);
        f(r10);
        return;
    L6:
        if ("ACTION_NOTIFY".equals(r11) == false) goto L9;
        f(r10);
        return;
    L9:
        if ("ACTION_CANCEL_WORK".equals(r11) == false) goto L12;
        e(r10);
        return;
    L12:
        if ("ACTION_STOP_FOREGROUND".equals(r11) == false) goto L18;
        h(r10);
        return;
    }

    public void k(Callback r10) {
        if (this.f5604j == null) goto L6;
        androidx.work.i.e().c(f5594k, "A callback already exists.");
        return;
    L6:
        this.f5604j = r10;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(List r10) {
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(List r10) {
        if (r10.isEmpty() == true) goto L8;
        Iterator r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        o r12 = (o) r11.next();
        String r13 = r12.f5670a;
        androidx.work.i.e().a(f5594k, "Constraints unmet for WorkSpec " + r13);
        this.f5596b.y(q.a(r12));
        goto L6
    L10:
        return;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(i r10, boolean r11) {
        Object r12 = this.f5598d;
        monitor-enter(r12);
        o r13 = (o) this.f5601g.remove(r10);     // Catch: Throwable -> L7
        if (r13 == null) goto L9;
        boolean r14 = this.f5602h.remove(r13);     // Catch: Throwable -> L7
    L10:
        if (r14 == false) goto L12;
        this.f5603i.replace(this.f5602h);     // Catch: Throwable -> L7
    L12:
        monitor-exit(r12);     // Catch: Throwable -> L7
        d r15 = (d) this.f5600f.remove(r10);
        if (r10.equals(this.f5599e) == true) goto L16;
    L24:
        Callback r16 = this.f5604j;
        if (r15 == null) goto L34;
        if (r16 == null) goto L35;
        androidx.work.i.e().a(f5594k, "Removing Notification (id: " + r15.c() + ", workSpecId: " + r10 + ", notificationType: " + r15.a());
        r16.cancelNotification(r15.c());
        return;
    L35:
        return;
    L34:
        return;
    L16:
        if (this.f5600f.size() <= 0) goto L24;
        Iterator r17 = this.f5600f.entrySet().iterator();
        Object r18 = r17.next();
    L18:
        Map.Entry r19 = (Map.Entry) r18;
        if (r17.hasNext() == false) goto L21;
        r18 = r17.next();
        goto L18
    L21:
        this.f5599e = (i) r19.getKey();
        if (this.f5604j == null) goto L24;
        d r20 = (d) r19.getValue();
        this.f5604j.startForeground(r20.c(), r20.a(), r20.b());
        this.f5604j.cancelNotification(r20.c());
        goto L24
    L9:
        r14 = false;
    L7:
        th = move-exception;
        throw th;
    }
}
