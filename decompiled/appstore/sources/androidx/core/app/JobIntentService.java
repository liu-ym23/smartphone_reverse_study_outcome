package androidx.core.app;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class JobIntentService extends Service {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f2434h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final HashMap f2435i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CompatJobEngine f2436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f2437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f2438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2440e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2441f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f2442g;

    public interface CompatJobEngine {
        IBinder compatGetBinder();

        GenericWorkItem dequeueWork();
    }

    public interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    public final class a extends AsyncTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JobIntentService f2443a;

        public a(JobIntentService r10) {
            this.f2443a = r10;
        }

        public Void a(Void... r10) {
        L2:
            GenericWorkItem r11 = this.f2443a.a();
            if (r11 == null) goto L5;
            this.f2443a.d(r11.getIntent());
            r11.complete();
            goto L2
        L5:
            return null;
        }

        public void b(Void r10) {
            this.f2443a.f();
        }

        public void c(Void r10) {
            this.f2443a.f();
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Object doInBackground(Object[] r10) {
            return a((Void[]) r10);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onCancelled(Object r10) {
            b((Void) r10);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(Object r10) {
            c((Void) r10);
        }
    }

    public final class b implements GenericWorkItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f2444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JobIntentService f2446c;

        public b(JobIntentService r10, Intent r11, int r12) {
            this.f2446c = r10;
            this.f2444a = r11;
            this.f2445b = r12;
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public void complete() {
            this.f2446c.stopSelf(this.f2445b);
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public Intent getIntent() {
            return this.f2444a;
        }
    }

    public static final class c extends JobServiceEngine implements CompatJobEngine {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JobIntentService f2447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f2448b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public JobParameters f2449c;

        public final class a implements GenericWorkItem {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final JobWorkItem f2450a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ c f2451b;

            public a(c r10, JobWorkItem r11) {
                this.f2451b = r10;
                this.f2450a = r11;
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public void complete() {
                Object r10 = this.f2451b.f2448b;
                monitor-enter(r10);
                JobParameters r11 = this.f2451b.f2449c;     // Catch: Throwable -> L7
                if (r11 == null) goto L9;
                r11.completeWork(this.f2450a);     // Catch: Throwable -> L7
            L9:
                monitor-exit(r10);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public Intent getIntent() {
                return this.f2450a.getIntent();
            }
        }

        public c(JobIntentService r10) {
            super(r10);
            this.f2448b = new Object();
            this.f2447a = r10;
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public IBinder compatGetBinder() {
            return getBinder();
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public GenericWorkItem dequeueWork() {
            Object r10 = this.f2448b;
            monitor-enter(r10);
            JobParameters r11 = this.f2449c;     // Catch: Throwable -> L8
            if (r11 != null) goto L10;
            monitor-exit(r10);     // Catch: Throwable -> L8
            return null;
        L10:
            JobWorkItem r12 = r11.dequeueWork();     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            if (r12 == null) goto L15;
            r12.getIntent().setExtrasClassLoader(this.f2447a.getClassLoader());
            return new a(this, r12);
        L15:
            return null;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters r10) {
            this.f2449c = r10;
            this.f2447a.c(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters r10) {
            boolean r11 = this.f2447a.b();
            Object r12 = this.f2448b;
            monitor-enter(r12);
            this.f2449c = null;     // Catch: Throwable -> L8
            monitor-exit(r12);     // Catch: Throwable -> L8
            return r11;
        L8:
            th = move-exception;
            throw th;
        }
    }

    public static abstract class d {
        public abstract void a();

        public abstract void b();

        public abstract void c();
    }

    static {
        f2434h = new Object();
        f2435i = new HashMap();
    }

    public JobIntentService() {
        this.f2439d = false;
        this.f2440e = false;
        this.f2441f = false;
        this.f2442g = null;
    }

    public GenericWorkItem a() {
        CompatJobEngine r10 = this.f2436a;
        if (r10 != null) goto L5;
        ArrayList r11 = this.f2442g;
        monitor-enter(r11);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.f2442g.size() <= 0) goto L15;
        GenericWorkItem r12 = (GenericWorkItem) this.f2442g.remove(0);     // Catch: Throwable -> L13
        monitor-exit(r11);     // Catch: Throwable -> L13
        return r12;
    L15:
        monitor-exit(r11);     // Catch: Throwable -> L13
        return null;
    L5:
        return r10.dequeueWork();
    }

    public boolean b() {
        a r10 = this.f2438c;
        if (r10 == null) goto L5;
        r10.cancel(this.f2439d);
    L5:
        this.f2440e = true;
        return e();
    }

    public void c(boolean r10) {
        if (this.f2438c != null) goto L6;
        this.f2438c = new a(this);
        this.f2438c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return;
    }

    public abstract void d(Intent r10);

    public boolean e() {
        return true;
    }

    public void f() {
        ArrayList r10 = this.f2442g;
        if (r10 == null) goto L20;
        monitor-enter(r10);
        this.f2438c = null;     // Catch: Throwable -> L11
        ArrayList r11 = this.f2442g;     // Catch: Throwable -> L11
        if (r11 == null) goto L14;
        if (r11.size() <= 0) goto L14;
        c(false);     // Catch: Throwable -> L11
    L16:
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L14:
        if (this.f2441f == true) goto L16;
        this.f2437b.a();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        CompatJobEngine r11 = this.f2436a;
        if (r11 != null) goto L5;
        return null;
    L5:
        return r11.compatGetBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f2436a = new c(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList r10 = this.f2442g;
        if (r10 == null) goto L12;
        monitor-enter(r10);
        this.f2441f = true;     // Catch: Throwable -> L9
        this.f2437b.a();     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        if (this.f2442g == null) goto L17;
        this.f2437b.c();
        ArrayList r13 = this.f2442g;
        monitor-enter(r13);
        ArrayList r14 = this.f2442g;     // Catch: Throwable -> L14
        if (r10 != null) goto L10;
        r10 = new Intent();     // Catch: Throwable -> L14
    L10:
        r14.add(new b(this, r10, r12));     // Catch: Throwable -> L14
        c(true);     // Catch: Throwable -> L14
        monitor-exit(r13);     // Catch: Throwable -> L14
        return 3;
    L14:
        th = move-exception;
        throw th;
    L17:
        return 2;
    }
}
