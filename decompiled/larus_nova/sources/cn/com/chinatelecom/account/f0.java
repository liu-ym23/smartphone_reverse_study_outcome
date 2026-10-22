package cn.com.chinatelecom.account;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f0 implements Runnable {
    private static Handler handler;
    private boolean isCompleted;
    private a timeOutTask;
    private long timeout;

    /* JADX INFO: loaded from: classes28.dex */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private f0 f24396a;

        public a(f0 r100) {
            this.f24396a = r100;
        }

        public void cn_com_chinatelecom_account_f0$a__run$___twin___() {
            f0 r100 = this.f24396a;
            if (r100 == null) goto L6;
            r100.timeout();
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            cn_com_chinatelecom_account_f0$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void cn_com_chinatelecom_account_f0$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.cn_com_chinatelecom_account_f0$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        handler = new Handler(Looper.getMainLooper());
    }

    public f0() {
        this.isCompleted = false;
    }

    public f0(long r100) {
        this.isCompleted = false;
        this.timeout = r100;
    }

    private void checkTimeOut() {
        a r100 = new a(this);
        this.timeOutTask = r100;
        handler.postDelayed(r100, this.timeout);
    }

    public void cn_com_chinatelecom_account_f0__run$___twin___() {
        if (this.timeout <= 0) goto L5;
        checkTimeOut();
    L5:
        runTask();
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public void removeTimeoutTask() {
        a r100 = this.timeOutTask;     // Catch: Throwable -> L6
        if (r100 == null) goto L11;
        handler.removeCallbacks(r100);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // java.lang.Runnable
    public void run() {
        cn_com_chinatelecom_account_f0_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public abstract void runTask();

    public void setCompleted(boolean r100) {
        this.isCompleted = r100;
    }

    public void timeout() {
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void cn_com_chinatelecom_account_f0_com_larus_apm_impl_protector_RunnableLancet_run(f0 r100) {
        r100.cn_com_chinatelecom_account_f0__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
