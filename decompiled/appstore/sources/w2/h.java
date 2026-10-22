package w2;

import android.os.Looper;
import android.os.Process;
import com.bytedance.apm.constant.PerfTraceConsts;
import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.exception.StateType;
import com.bytedance.apm6.service.perf.ICpuDataService;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.monitor.collector.PerfMonitorManager;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class h extends v2.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f25317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f25318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f25319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public u3.a f25320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public u2.b f25321f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f25322g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f25323h;

    public class a extends u3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ h f25324d;

        public a(h r10, long r11, long r12) {
            this.f25324d = r10;
            super(r11, r12);
        }

        @Override // java.lang.Runnable
        public void run() {
            h.b(this.f25324d);
        }
    }

    public class b implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f25325a;

        public b(h r10) {
            this.f25325a = r10;
        }

        public int a(v2.g r10, v2.g r11) {
            return (int) ((r11.a() * 100.0d) - (r10.a() * 100.0d));
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((v2.g) r10, (v2.g) r11);
        }
    }

    public h(v2.d r10) {
        super(r10);
        this.f25322g = 0;
        this.f25317b = new CopyOnWriteArrayList();
        this.f25319d = new CopyOnWriteArrayList();
        this.f25318c = new CopyOnWriteArrayList();
        this.f25320e = new a(this, 0, 1000);
    }

    public static /* synthetic */ void b(h r10) {
        r10.f();
    }

    public final void c(v2.g r10, Thread r11, StringBuilder r12) {
        StackTraceElement[] r13 = r11.getStackTrace();
        int r14 = r13.length;
        int r15 = 0;
        int r16 = 0;
    L3:
        if (r15 >= r14) goto L8;
        StackTraceElement r17 = r13[r15];
        r16 = r16 + 1;
        r12.append("\tat ");
        r12.append(r17.getClassName());
        r12.append(LibrarianImpl.Constants.DOT);
        r12.append(r17.getMethodName());
        r12.append("(");
        r12.append(r17.getFileName());
        r12.append(":");
        r12.append(r17.getLineNumber());
        r12.append(")\n");
        if (r16 > 40) goto L8;
        r15 = r15 + 1;
    L8:
        r10.l(r12.toString());
        r10.p(String.format("%.2f", new Object[]{Double.valueOf(r10.a() / this.f25321f.e())}));
        this.f25319d.add(r10);
        r12.setLength(0);
    }

    public final void d() {
        if (this.f25318c.isEmpty() == false) goto L6;
        v2.f.c(Process.myPid(), this.f25318c);
        a("over process threshold, first collect thread info, list size: " + this.f25318c.size());
        return;
    L6:
        v2.f.a(Process.myPid(), this.f25318c, this.f25321f.e(), this.f25321f.f());
        a("over process threshold, second collect thread info, list size after filter is: " + this.f25318c.size());
        if (this.f25318c.isEmpty() == false) goto L10;
        return;
    L10:
        if (this.f25318c.size() <= 10) goto L14;
        this.f25318c.clear();
        return;
    L14:
        if (v2.c.c().d() == false) goto L47;
        ThreadGroup r10 = Looper.getMainLooper().getThread().getThreadGroup();
        int r11 = r10.activeCount();
        int r12 = r11 + (r11 / 2);
        Thread[] r13 = new Thread[r12];
        r10.enumerate(r13);
        StringBuilder r14 = new StringBuilder();
        ListIterator r15 = this.f25318c.listIterator();
    L17:
        if (r15.hasNext() == false) goto L58;
        v2.g r16 = (v2.g) r15.next();
        if (r16 == null) goto L17;
        if (r16.f() == Process.myPid()) goto L24;
        int r17 = 0;
    L27:
        if (r17 >= r12) goto L43;
        Thread r18 = r13[r17];
        if (r18 == null) goto L43;
        if (r16.g().equals(r18.getName()) == true) goto L40;
        if (r18.getName().length() <= 15) goto L38;
        if (r16.g().equals(r18.getName().substring(0, 15)) == true) goto L40;
    L38:
        r17 = r17 + 1;
    L40:
        if (r18 == Thread.currentThread()) goto L17;
        c(r16, r18, r14);
    L43:
        if (this.f25321f.k() == false) goto L17;
        String r19 = PerfMonitorManager.o().h(r16.f());
        if (r19 == null) goto L17;
        r16.l(r19);
        r16.p(String.format("%.2f", new Object[]{Double.valueOf(r16.a() / this.f25321f.e())}));
        this.f25319d.add(r16);
        goto L17
    L24:
        if (this.f25321f.j() == false) goto L17;
        c(r16, Looper.getMainLooper().getThread(), r14);
    L58:
        Collections.sort(this.f25318c, new b(this));
        LinkedList r20 = new LinkedList();
        Iterator r21 = this.f25318c.iterator();
    L60:
        if (r21.hasNext() == false) goto L62;
        v2.g r22 = (v2.g) r21.next();
        r20.add(new ICpuDataService.a(r22.g(), r22.a(), r22.f()));
        goto L60
    L62:
        x2.a.a().c(r20);
        this.f25318c.clear();
        return;
    L47:
        ListIterator r23 = this.f25318c.listIterator();
    L49:
        if (r23.hasNext() == false) goto L58;
        v2.g r24 = (v2.g) r23.next();
        if (r24 == null) goto L49;
        if (r24.f() != Process.myPid()) goto L57;
        if (this.f25321f.j() == false) goto L49;
    L57:
        r24.p(String.format("%.2f", new Object[]{Double.valueOf(r24.a() / this.f25321f.e())}));
        this.f25319d.add(r24);
        goto L49
    }

    public final long e() {
        u2.b r10 = this.f25321f;
        if (r10 != null) goto L7;
        return PerfTraceConsts.LAUNCH_TRACE_COLLECT_INFO_TIME_MS;
    L7:
        return ((long) r10.h()) * 1000;
    }

    public final void f() {
        if (v2.b.c() == false) goto L6;
        i();
        this.f25050a.h();
        return;
    L6:
        boolean r10 = g();
        if ((System.currentTimeMillis() - this.f25322g) < e()) goto L10;
        h();
        return;
    L10:
        if (r10 == true) goto L13;
        a("not over process threshold");
        this.f25318c.clear();
        return;
    L13:
        d();
    }

    public final boolean g() {
        double r10 = v2.e.a();
        this.f25317b.add(Double.valueOf(r10));
        return v2.b.e(this.f25321f, r10, this.f25323h);
    }

    public final void h() {
        if (this.f25317b.isEmpty() == false) goto L5;
    L98:
        a("finish collect, but no exception thread is found");
        i();
        this.f25050a.h();
        return;
    L5:
        if (this.f25319d.isEmpty() == true) goto L98;
        Iterator r10 = this.f25317b.iterator();
        double r11 = 0.0d;
        double r12 = 0.0d;
    L9:
        if (r10.hasNext() == false) goto L14;
        double r13 = ((Double) r10.next()).doubleValue();
        if (r12 >= r13) goto L13;
        r12 = r13;
    L13:
        r11 = r11 + r13;
        goto L9
    L14:
        a("report exception data, exception thread size is: " + this.f25319d.size());
        double r14 = r11 / ((double) this.f25317b.size());
        LinkedList r15 = new LinkedList();
        String[] r16 = v2.b.a().split("#");
        String r17 = null;
        if (this.f25323h == false) goto L38;
        if (this.f25321f.a().isEmpty() == true) goto L59;
        int r18 = r16.length;
        int r19 = 0;
        double r110 = 0.0d;
    L19:
        if (r19 >= r18) goto L33;
        String r111 = r16[r19];
        if (this.f25321f.a().containsKey(r111) == false) goto L32;
        double r20 = ((Double) this.f25321f.a().get(r111)).doubleValue();
        if (r20 < 0.0d) goto L32;
        if (r110 >= r20) goto L30;
        r110 = r20;
        r17 = r111;
    L30:
        if (r14 <= r20) goto L32;
        r15.add(r111);
    L32:
        r19 = r19 + 1;
        goto L19
    L33:
        if (r17 == null) goto L59;
        if (r15.contains(r17) == false) goto L59;
        r15.remove(r17);
        r15.add(0, r17);
    L59:
        if (r15.isEmpty() == true) goto L61;
    L68:
        v2.c.c().e(System.currentTimeMillis());
        ApmCpuManager.ICpuExceptionListener r21 = v2.c.c().b();
        if (r21 == null) goto L72;
        r21.onException(r14);
    L72:
        if (r15.isEmpty() == true) goto L74;
        String r22 = ListUtils.a(r15.toArray(), "#");
        if (this.f25323h == false) goto L91;
        if (r14 <= this.f25321f.c()) goto L91;
        r22 = r22 + "#apm_max_background";
    L84:
        String r112 = r22;
    L95:
        l3.a.d(new w2.b(r14, r12, this.f25319d, r112, this.f25323h));
    L96:
        i();
        this.f25050a.e();
        return;
    L91:
        if (this.f25323h == true) goto L84;
        if (r14 <= this.f25321f.d()) goto L84;
        r22 = r22 + "#apm_max_foreground";
        goto L84
    L74:
        if (this.f25323h == false) goto L79;
        if (r14 <= this.f25321f.c()) goto L79;
        r112 = "apm_max_background";
    L79:
        if (this.f25323h == false) goto L81;
    L83:
        r22 = "";
        goto L84
    L81:
        if (r14 <= this.f25321f.d()) goto L83;
        r112 = "apm_max_foreground";
        goto L95
    L61:
        if (this.f25323h == false) goto L65;
        if (r14 > this.f25321f.c()) goto L68;
    L65:
        if (this.f25323h == true) goto L96;
        if (r14 <= this.f25321f.d()) goto L96;
    L38:
        if (this.f25321f.b().isEmpty() == true) goto L59;
        int r23 = r16.length;
        int r24 = 0;
        double r113 = 0.0d;
    L40:
        if (r24 >= r23) goto L54;
        String r25 = r16[r24];
        if (this.f25321f.b().containsKey(r25) == false) goto L53;
        double r114 = ((Double) this.f25321f.b().get(r25)).doubleValue();
        if (r114 < 0.0d) goto L53;
        if (r113 >= r114) goto L51;
        r17 = r25;
        r113 = r114;
    L51:
        if (r14 <= r114) goto L53;
        r15.add(r25);
    L53:
        r24 = r24 + 1;
        goto L40
    L54:
        if (r17 == null) goto L59;
        if (r15.contains(r17) == false) goto L59;
        r15.remove(r17);
        r15.add(0, r17);
        goto L59
    }

    public final void i() {
        this.f25317b.clear();
        this.f25319d.clear();
        this.f25318c.clear();
        this.f25322g = 0;
        u3.b.a(AsyncTaskManagerType.CPU).b(this.f25320e);
    }

    @Override // v2.a, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onEnterThisState(u2.b r10, boolean r11) {
        super.onEnterThisState(r10, r11);
        this.f25321f = r10;
        this.f25322g = System.currentTimeMillis();
        this.f25323h = r11;
        u3.b.a(AsyncTaskManagerType.CPU).c(this.f25320e);
    }

    @Override // v2.a, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean r10) {
        super.onLifeCycleChange(r10);
        i();
        this.f25050a.f();
    }

    @Override // v2.a, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onStopDetect() {
        super.onStopDetect();
        i();
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public StateType provideType() {
        return StateType.THREAD_DETECT;
    }
}
