package k1;

import android.text.TextUtils;
import com.bytedance.apm.MonitorCoreExceptionManager;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.i;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import java.util.Iterator;
import java.util.LinkedList;
import m2.d;
import org.json.JSONObject;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements IConfigListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f21001e = 1000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f21002f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList f21003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f21004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f21005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f21006d;

    /* JADX INFO: renamed from: k1.a$a, reason: collision with other inner class name */
    public class RunnableC0285a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ITypeData f21007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f21008b;

        public RunnableC0285a(a r10, ITypeData r11) {
            this.f21008b = r10;
            this.f21007a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.f21008b, this.f21007a);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f21009a;

        public b(a r10) {
            this.f21009a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            LinkedList r10 = a.b(this.f21009a);
            monitor-enter(r10);
            LinkedList r11 = new LinkedList(a.b(this.f21009a));     // Catch: Throwable -> L11
            a.b(this.f21009a).clear();     // Catch: Throwable -> L11
            monitor-exit(r10);     // Catch: Throwable -> L11
            Iterator r12 = r11.iterator();
        L8:
            if (r12.hasNext() == false) goto L10;
            ITypeData r13 = (ITypeData) r12.next();
            this.f21009a.f(r13);
            goto L8
        L10:
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    public a() {
        this.f21005c = false;
        this.f21006d = false;
        this.f21003a = new LinkedList();
    }

    public static /* synthetic */ void a(a r10, ITypeData r11) {
        r10.h(r11);
    }

    public static /* synthetic */ LinkedList b(a r10) {
        return r10.f21003a;
    }

    public static boolean k() {
        if (ActivityLifeObserver.getInstance() != null) goto L6;
        return true;
    L6:
        return !ActivityLifeObserver.getInstance().isForeground();
    }

    public static void n(int r10) {
        f21001e = r10;
    }

    public static void o(boolean r10) {
        f21002f = r10;
    }

    public final void c(ITypeData r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        LinkedList r11 = this.f21003a;
        monitor-enter(r11);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.f21003a.size() <= f21001e) goto L17;
        ITypeData r12 = (ITypeData) this.f21003a.poll();     // Catch: Throwable -> L14
        if (f21002f == true) goto L11;
    L23:
        s1.a.d("apm_debug", "apm_cache_buffer_full:" + r12.packLog().toString());     // Catch: Throwable -> L14 Exception -> L22
        goto L17
    L11:
        if (this.f21005c == true) goto L23;
        MonitorCoreExceptionManager.e().c("apm_cache_buffer_full");     // Catch: Throwable -> L14
        this.f21005c = true;     // Catch: Throwable -> L14
    L17:
        this.f21003a.add(r10);     // Catch: Throwable -> L14
        monitor-exit(r11);     // Catch: Throwable -> L14
    }

    public boolean d(ITypeData r10) {
        return true;
    }

    public final void e(ITypeData r10) {
        if (AsyncEventManager.e().f() == true) goto L5;
        AsyncEventManager.e().h(new RunnableC0285a(this, r10));
        return;
    L5:
        h(r10);
    }

    public abstract void f(ITypeData r10);

    public final void g() {
        AsyncEventManager.e().h(new b(this));
    }

    public final void h(ITypeData r10) {
        if (d(r10) == true) goto L5;
        return;
    L5:
        i(r10);
        if (this.f21004b == false) goto L8;
        f(r10);
        return;
    L8:
        c(r10);
    }

    public void i(ITypeData r10) {
    }

    public void j() {
        ((IConfigManager) n5.b.a(IConfigManager.class)).registerConfigListener(this);
    }

    public void l(String r10, String r11, JSONObject r12, boolean r13, boolean r14) {
        if (c.B() == false) goto L6;
        s1.c.b("BaseDataPipeline", new String[]{"type:" + r10 + " isSaveUnSampleLog:" + r14 + "isSampled:" + r13 + " log:" + r12});
    L6:
        if (r13 == false) goto L19;
        if (this.f21006d == false) goto L10;
        JSONObject r15 = i.j(r12);
    L12:
        if (TextUtils.equals(r10, "tracing") == false) goto L15;
        m(new j6.c(r15, null, false, r11));
    L28:
        u1.a.b().c(r10, r11, r12);
        if (TextUtils.equals(r10, "ui_action") == false) goto L34;
        n1.a.b().a(r12);
        return;
    L34:
        return;
    L15:
        if (TextUtils.equals(r10, "common_log") == false) goto L17;
        k2.a.monitorLegacyEvent(new m2.c(r11, r15));
        goto L28
    L17:
        k2.a.monitorLegacyEvent(new m2.c(r10, r15));
        goto L28
    L10:
        r15 = i.c(r12);
        goto L12
    L19:
        if (c.B() == false) goto L21;
        o1.a.b(r10, r12, false);
    L21:
        if (r14 == false) goto L28;
        if (s1.a.f() == false) goto L28;
        s1.a.g(r10, r12.toString());     // Catch: Exception -> L26
    L26:
        e = move-exception;
        i6.a.d(e, "apm_unsampled_log_error");
        goto L28
    }

    public final void m(j6.c r10) {
        if ("batch_tracing".equals(r10.getSubTypeLabel()) == false) goto L5;
        k2.a.k(new d(j6.a.a(r10.packLog())));
        return;
    L5:
        k2.a.k(new d(r10.packLog()));
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
        this.f21004b = true;
        g();
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r10, boolean r11) {
    }
}
