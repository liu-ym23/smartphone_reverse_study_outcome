package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.i;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.o;
import androidx.work.impl.t;
import androidx.work.impl.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b implements ExecutionListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5463e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f5465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u f5467d;

    static {
        f5463e = i.i("CommandHandler");
    }

    public b(Context r10, u r11) {
        this.f5464a = r10;
        this.f5467d = r11;
        this.f5465b = new HashMap();
        this.f5466c = new Object();
    }

    public static Intent a(Context r10) {
        Intent r11 = new Intent(r10, SystemAlarmService.class);
        r11.setAction("ACTION_CONSTRAINTS_CHANGED");
        return r11;
    }

    public static Intent b(Context r10, androidx.work.impl.model.i r11) {
        Intent r12 = new Intent(r10, SystemAlarmService.class);
        r12.setAction("ACTION_DELAY_MET");
        return p(r12, r11);
    }

    public static Intent c(Context r10, androidx.work.impl.model.i r11, boolean r12) {
        Intent r13 = new Intent(r10, SystemAlarmService.class);
        r13.setAction("ACTION_EXECUTION_COMPLETED");
        r13.putExtra("KEY_NEEDS_RESCHEDULE", r12);
        return p(r13, r11);
    }

    public static Intent d(Context r10, androidx.work.impl.model.i r11) {
        Intent r12 = new Intent(r10, SystemAlarmService.class);
        r12.setAction("ACTION_SCHEDULE_WORK");
        return p(r12, r11);
    }

    public static Intent e(Context r10, androidx.work.impl.model.i r11) {
        Intent r12 = new Intent(r10, SystemAlarmService.class);
        r12.setAction("ACTION_STOP_WORK");
        return p(r12, r11);
    }

    public static boolean l(Bundle r10, String... r11) {
        if (r10 != null) goto L5;
    L15:
        return false;
    L5:
        if (r10.isEmpty() == true) goto L15;
        int r12 = r11.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L13;
        if (r10.get(r11[r13]) == null) goto L11;
        r13 = r13 + 1;
        goto L8
    L11:
        return false;
    L13:
        return true;
    }

    public static androidx.work.impl.model.i o(Intent r10) {
        return new androidx.work.impl.model.i(r10.getStringExtra("KEY_WORKSPEC_ID"), r10.getIntExtra("KEY_WORKSPEC_GENERATION", 0));
    }

    public static Intent p(Intent r10, androidx.work.impl.model.i r11) {
        r10.putExtra("KEY_WORKSPEC_ID", r11.b());
        r10.putExtra("KEY_WORKSPEC_GENERATION", r11.a());
        return r10;
    }

    public final void f(Intent r10, int r11, SystemAlarmDispatcher r12) {
        i.e().a(f5463e, "Handling constraints changed " + r10);
        new c(this.f5464a, r11, r12).a();
    }

    public final void g(Intent r10, int r11, SystemAlarmDispatcher r12) {
        Object r13 = this.f5466c;
        monitor-enter(r13);
        androidx.work.impl.model.i r14 = o(r10);     // Catch: Throwable -> L7
        i r15 = i.e();     // Catch: Throwable -> L7
        String r16 = f5463e;     // Catch: Throwable -> L7
        r15.a(r16, "Handing delay met for " + r14);     // Catch: Throwable -> L7
        if (this.f5465b.containsKey(r14) == true) goto L9;
        f r17 = new f(this.f5464a, r11, r12, this.f5467d.d(r14));     // Catch: Throwable -> L7
        this.f5465b.put(r14, r17);     // Catch: Throwable -> L7
        r17.d();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r13);     // Catch: Throwable -> L7
        return;
    L9:
        i.e().a(r16, "WorkSpec " + r14 + " is is already being handled for ACTION_DELAY_MET");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public final void h(Intent r10, int r11) {
        androidx.work.impl.model.i r12 = o(r10);
        boolean r13 = r10.getExtras().getBoolean("KEY_NEEDS_RESCHEDULE");
        i.e().a(f5463e, "Handling onExecutionCompleted " + r10 + ", " + r11);
        onExecuted(r12, r13);
    }

    public final void i(Intent r10, int r11, SystemAlarmDispatcher r12) {
        i.e().a(f5463e, "Handling reschedule " + r10 + ", " + r11);
        r12.f().u();
    }

    public final void j(Intent r10, int r11, SystemAlarmDispatcher r12) {
        androidx.work.impl.model.i r13 = o(r10);
        i r14 = i.e();
        String r15 = f5463e;
        r14.a(r15, "Handling schedule work for " + r13);
        WorkDatabase r16 = r12.f().q();
        r16.e();
        o r17 = r16.L().getWorkSpec(r13.b());     // Catch: Throwable -> L9
        if (r17 != null) goto L12;
        i.e().k(r15, "Skipping scheduling " + r13 + " because it's no longer in the DB");     // Catch: Throwable -> L9
        r16.i();
        return;
    L12:
        if (r17.f5671b.isFinished() == false) goto L16;
        i.e().k(r15, "Skipping scheduling " + r13 + "because it is finished.");     // Catch: Throwable -> L9
        r16.i();
        return;
    L16:
        long r18 = r17.c();     // Catch: Throwable -> L9
        if (r17.f() == true) goto L20;
        i.e().a(r15, "Setting up Alarms for " + r13 + "at " + r18);     // Catch: Throwable -> L9
        a.c(this.f5464a, r16, r13, r18);     // Catch: Throwable -> L9
    L21:
        r16.D();     // Catch: Throwable -> L9
        r16.i();
        return;
    L20:
        i.e().a(r15, "Opportunistically setting an alarm for " + r13 + "at " + r18);     // Catch: Throwable -> L9
        a.c(this.f5464a, r16, r13, r18);     // Catch: Throwable -> L9
        r12.e().getMainThreadExecutor().execute(new SystemAlarmDispatcher.b(r12, a(this.f5464a), r11));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r16.i();
        throw th;
    }

    public final void k(Intent r10, SystemAlarmDispatcher r11) {
        Bundle r12 = r10.getExtras();
        String r13 = r12.getString("KEY_WORKSPEC_ID");
        if (r12.containsKey("KEY_WORKSPEC_GENERATION") == false) goto L7;
        int r14 = r12.getInt("KEY_WORKSPEC_GENERATION");
        List r15 = new ArrayList(1);
        t r16 = this.f5467d.b(new androidx.work.impl.model.i(r13, r14));
        if (r16 == null) goto L8;
        r15.add(r16);
    L8:
        Iterator r17 = r15.iterator();
    L10:
        if (r17.hasNext() == false) goto L12;
        t r18 = (t) r17.next();
        i.e().a(f5463e, "Handing stopWork work for " + r13);
        r11.f().z(r18);
        a.a(this.f5464a, r11.f().q(), r18.a());
        r11.onExecuted(r18.a(), false);
        goto L10
    L12:
        return;
    L7:
        r15 = this.f5467d.c(r13);
        goto L8
    }

    public boolean m() {
        Object r10 = this.f5466c;
        monitor-enter(r10);
        boolean r11 = !this.f5465b.isEmpty();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public void n(Intent r10, int r11, SystemAlarmDispatcher r12) {
        String r13 = r10.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(r13) == false) goto L6;
        f(r10, r11, r12);
        return;
    L6:
        if ("ACTION_RESCHEDULE".equals(r13) == false) goto L9;
        i(r10, r11, r12);
        return;
    L9:
        if (l(r10.getExtras(), new String[]{"KEY_WORKSPEC_ID"}) == true) goto L12;
        i.e().c(f5463e, "Invalid request for " + r13 + " , requires KEY_WORKSPEC_ID .");
        return;
    L12:
        if ("ACTION_SCHEDULE_WORK".equals(r13) == false) goto L15;
        j(r10, r11, r12);
        return;
    L15:
        if ("ACTION_DELAY_MET".equals(r13) == false) goto L18;
        g(r10, r11, r12);
        return;
    L18:
        if ("ACTION_STOP_WORK".equals(r13) == false) goto L21;
        k(r10, r12);
        return;
    L21:
        if ("ACTION_EXECUTION_COMPLETED".equals(r13) == false) goto L23;
        h(r10, r11);
        return;
    L23:
        i.e().k(f5463e, "Ignoring intent " + r10);
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(androidx.work.impl.model.i r10, boolean r11) {
        Object r12 = this.f5466c;
        monitor-enter(r12);
        f r13 = (f) this.f5465b.remove(r10);     // Catch: Throwable -> L7
        this.f5467d.b(r10);     // Catch: Throwable -> L7
        if (r13 == null) goto L9;
        r13.e(r11);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
