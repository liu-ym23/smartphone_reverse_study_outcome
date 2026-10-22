package ar;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<InterfaceC0210a> f15996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f15997e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f15998f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f15999g;

    /* JADX INFO: renamed from: ar.a$a, reason: collision with other inner class name */
    public interface InterfaceC0210a {
        void onTick();
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f16000a;

        public b(a r100) {
            this.f16000a = r100;
        }

        public final void a() {
            long r100 = SystemClock.elapsedRealtime();
            a r101 = this.f16000a;
            ArrayList<InterfaceC0210a> r102 = r101.f15996d;
            r101.f15995c = true;
            Iterator<InterfaceC0210a> r103 = r102.iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            r103.next().onTick();
            goto L4
        L6:
            r101.f15995c = false;
            long r104 = SystemClock.elapsedRealtime() - r100;
            a r105 = this.f16000a;
            long r106 = r105.f15999g;
            if (r104 > r106) goto L11;
            r106 = r106 - r104;
        L11:
            if (r105.f15994b == true) goto L14;
            return;
        L14:
            if (r105.f15996d.isEmpty() == true) goto L20;
            r105.f15997e.removeCallbacks(r105.f15998f);
            r105.f15997e.postDelayed(r105.f15998f, r106);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a() {
        this(1000);
    }

    public a(long r100) {
        this.f15999g = r100;
        this.f15996d = new ArrayList();
        this.f15997e = new Handler(Looper.getMainLooper());
        this.f15998f = new b(this);
    }

    public final void a(InterfaceC0210a r100) {
        if (this.f15993a == false) goto L6;
        return;
    L6:
        if (this.f15995c == false) goto L9;
        this.f15996d = new ArrayList(this.f15996d);
    L9:
        if (this.f15996d.contains(r100) == true) goto L11;
        this.f15996d.add(r100);
    L11:
        boolean r101 = this.f15994b;
        if (r101 == true) goto L20;
        if (r101 == true) goto L21;
        this.f15994b = true;
        long r102 = this.f15999g;
        if (this.f15996d.isEmpty() == true) goto L22;
        this.f15997e.removeCallbacks(this.f15998f);
        this.f15997e.postDelayed(this.f15998f, r102);
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void b(InterfaceC0210a r100) {
        if (this.f15995c == false) goto L5;
        this.f15996d = new ArrayList(this.f15996d);
    L5:
        this.f15996d.remove(r100);
        if (this.f15996d.isEmpty() == false) goto L9;
        this.f15994b = false;
        this.f15997e.removeCallbacks(this.f15998f);
        return;
    }
}
