package com.obric.oui.window.listener;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class a extends MutableLiveData {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Handler f17646n = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f17647l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map f17648m;

    /* JADX INFO: renamed from: com.obric.oui.window.listener.a$a, reason: collision with other inner class name */
    public class RunnableC0210a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f17649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f17650b;

        public RunnableC0210a(a r10, Object r11) {
            this.f17650b = r10;
            this.f17649a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17650b.p(this.f17649a);
        }
    }

    public class b implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Observer f17652b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f17653c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f17654d;

        public b(a r10, int r11, Observer r12, boolean r13) {
            this.f17654d = r10;
            this.f17651a = r11;
            this.f17652b = r12;
            this.f17653c = r13;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(Object r10) {
            if (this.f17653c == false) goto L5;
        L7:
            this.f17652b.onChanged(r10);
            return;
        L5:
            if (this.f17651a < a.q(this.f17654d)) goto L7;
        }
    }

    static {
        f17646n = new Handler(Looper.getMainLooper());
    }

    public a() {
        this.f17647l = -1;
        this.f17648m = new HashMap();
    }

    public static /* synthetic */ int q(a r10) {
        return r10.f17647l;
    }

    @Override // androidx.lifecycle.LiveData
    public void i(LifecycleOwner r10, Observer r11) {
        r(r10, r11, false);
    }

    @Override // androidx.lifecycle.LiveData
    public void j(Observer r10) {
        s(r10, false);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void m(Object r10) {
        f17646n.post(new RunnableC0210a(this, r10));
    }

    @Override // androidx.lifecycle.LiveData
    public void n(Observer r10) {
        b r11 = (b) this.f17648m.remove(r10);
        if (r11 == null) goto L7;
        super.n(r11);
        return;
    L7:
        if ((r10 instanceof b) == false) goto L21;
        Iterator r12 = this.f17648m.entrySet().iterator();
    L10:
        if (r12.hasNext() == false) goto L14;
        Map.Entry r13 = (Map.Entry) r12.next();
        if (r10.equals(r13.getValue()) == false) goto L10;
        Observer r14 = (Observer) r13.getKey();
        super.n(r10);
    L15:
        if (r14 == null) goto L22;
        this.f17648m.remove(r14);
        return;
    L22:
        return;
    L14:
        r14 = null;
        goto L15
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void p(Object r10) {
        this.f17647l++;
        super.p(r10);
    }

    public void r(LifecycleOwner r10, Observer r11, boolean r12) {
        if (this.f17648m.containsKey(r11) == false) goto L5;
        return;
    L5:
        b r13 = new b(this, this.f17647l, r11, r12);
        this.f17648m.put(r11, r13);
        super.i(r10, r13);
    }

    public void s(Observer r10, boolean r11) {
        if (this.f17648m.containsKey(r10) == false) goto L5;
        return;
    L5:
        b r12 = new b(this, this.f17647l, r10, r11);
        this.f17648m.put(r10, r12);
        super.j(r12);
    }
}
