package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FontsContractCompat.FontRequestCallback f2585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f2586b;

    /* JADX INFO: renamed from: androidx.core.provider.a$a, reason: collision with other inner class name */
    public class RunnableC0017a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FontsContractCompat.FontRequestCallback f2587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Typeface f2588b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f2589c;

        public RunnableC0017a(a r10, FontsContractCompat.FontRequestCallback r11, Typeface r12) {
            this.f2589c = r10;
            this.f2587a = r11;
            this.f2588b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2587a.b(this.f2588b);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FontsContractCompat.FontRequestCallback f2590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f2591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f2592c;

        public b(a r10, FontsContractCompat.FontRequestCallback r11, int r12) {
            this.f2592c = r10;
            this.f2590a = r11;
            this.f2591b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2590a.a(this.f2591b);
        }
    }

    public a(FontsContractCompat.FontRequestCallback r10, Handler r11) {
        this.f2585a = r10;
        this.f2586b = r11;
    }

    public final void a(int r10) {
        FontsContractCompat.FontRequestCallback r11 = this.f2585a;
        this.f2586b.post(new b(this, r11, r10));
    }

    public void b(c.e r10) {
        if (r10.a() == false) goto L5;
        c(r10.f2608a);
        return;
    L5:
        a(r10.f2609b);
    }

    public final void c(Typeface r10) {
        FontsContractCompat.FontRequestCallback r11 = this.f2585a;
        this.f2586b.post(new RunnableC0017a(this, r11, r10));
    }
}
