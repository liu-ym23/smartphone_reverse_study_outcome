package com.bytedanceos.common.core.ui.presenter;

import android.os.Handler;
import android.os.Message;
import com.bytedanceos.common.network.FetchDataCallBack;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class APresenter implements FetchDataCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Thread f9797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f9798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f9799c;

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Throwable f9800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f9801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f9802c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f9803d;

        public b(Throwable r10, String r11, Object r12, String r13) {
            this.f9800a = r10;
            this.f9801b = r11;
            this.f9802c = r12;
            this.f9803d = r13;
        }
    }

    public final class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ APresenter f9804a;

        public c(APresenter r10) {
            this.f9804a = r10;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            this.f9804a.f(r10);
        }

        public /* synthetic */ c(APresenter r10, a r11) {
            this(r10);
        }
    }

    public APresenter(Thread r10) {
        this.f9798b = new c(this, null);
        this.f9799c = new ArrayList();
        this.f9797a = r10;
    }

    public void a(int r10) {
        this.f9799c.add(Integer.valueOf(r10));
        q8.b.c().a(r10, this);
    }

    public void b(int r10) {
        int r11 = this.f9799c.indexOf(Integer.valueOf(r10));
        if (r11 == (-1)) goto L6;
        this.f9799c.remove(r11);
        q8.b.c().b(r10);
        return;
    }

    public void c() {
        Iterator r10 = this.f9799c.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        int r11 = ((Integer) r10.next()).intValue();
        q8.b.c().b(r11);
        goto L4
    L6:
        Handler r12 = this.f9798b;
        if (r12 == null) goto L11;
        r12.removeCallbacksAndMessages(null);
        return;
    }

    public void d(int r10, int r11, Object r12) {
        Message r13 = Message.obtain();
        r13.what = r10;
        r13.arg1 = r11;
        r13.obj = r12;
        if (Thread.currentThread() == this.f9797a) goto L5;
        this.f9798b.sendMessage(r13);
        return;
    L5:
        f(r13);
    }

    public abstract void e(int r10, Object r11, Object r12);

    public abstract void f(Message r10);

    @Override // com.bytedanceos.common.network.FetchDataCallBack
    public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
        b(r10);
        d(2, r10, new b(r11, r12, r13, null));
    }

    @Override // com.bytedanceos.common.network.FetchDataCallBack
    public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
        b(r10);
        d(1, r10, new b(null, r12, r13, r14));
    }
}
