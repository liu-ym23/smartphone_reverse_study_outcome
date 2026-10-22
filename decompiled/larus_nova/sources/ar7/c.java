package ar7;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.ies.bullet.service.base.m0;
import com.larus.nova.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f16028f = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f16029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f16030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MessageQueue f16031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, br7.a> f16032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f16033e;

    public class a implements MessageQueue.IdleHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebView f16034a;

        /* JADX INFO: renamed from: ar7.c$a$a, reason: collision with other inner class name */
        public class C0213a extends WebViewClient {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Handler f16035a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Runnable f16036b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ boolean[] f16037c;

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView r100, String r101) {
                super.onPageFinished(r100, r101);
                this.f16035a.removeCallbacks(this.f16036b);
                boolean[] r102 = this.f16037c;
                if (r102[0] == true) goto L6;
                r102[0] = true;
                r100.destroy();
                return;
            }

            public C0213a(Handler r100, ar7.b r101, boolean[] r102) {
                this.f16035a = r100;
                this.f16036b = r101;
                this.f16037c = r102;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [ar7.b, java.lang.Runnable] */
        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            final boolean[] r100 = {false};
            Handler r101 = new Handler(Looper.getMainLooper());
            final WebView r102 = this.f16034a;
            ?? r103 = new ar7.b(r100, r102);
            r101.postDelayed(r103, 5000);
            this.f16034a.setWebViewClient(new C0213a(r101, r103, r100));
            this.f16034a.loadUrl("about:blank");
            return false;
        }

        public a(WebView r100) {
            this.f16034a = r100;
        }
    }

    public class b implements MessageQueue.IdleHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ br7.a f16038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f16039b;

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            Object r100 = this.f16039b.f16029a;
            monitor-enter(r100);
            int r101 = ((ArrayList) this.f16038a.f20136a).size();     // Catch: Throwable -> L20
            br7.a r102 = this.f16038a;     // Catch: Throwable -> L20
            if (r101 >= r102.f20138c) goto L11;
            WebView r103 = r102.f20137b.create(new MutableContextWrapper(this.f16039b.f16030b));     // Catch: Throwable -> L20
            List<SoftReference<WebView>> r104 = this.f16038a.f20136a;     // Catch: Throwable -> L20
            ArrayList r105 = (ArrayList) r104;     // Catch: Throwable -> L20
            r105.add(new SoftReference(r103));     // Catch: Throwable -> L20
            if (r103 == null) goto L11;
            r103.setTag(R.id.webx_precreate_is_precreate, Boolean.TRUE);     // Catch: Throwable -> L20
        L11:
            if (c.f16028f == false) goto L18;
            this.f16039b.getClass();     // Catch: Throwable -> L20
            m0 r106 = (m0) s26.d.f540305c.c(m0.class);     // Catch: Throwable -> L20
            if (r106 != null) goto L15;
            boolean r107 = false;
        L16:
            if (r107 == false) goto L18;
            WebView r108 = this.f16038a.f20137b.create(new MutableContextWrapper(this.f16039b.f16030b));     // Catch: Throwable -> L20
            this.f16039b.a(r108);     // Catch: Throwable -> L20
            c.f16028f = false;     // Catch: Throwable -> L20
            goto L18
        L15:
            com.bytedance.ies.bullet.service.base.d r109 = r106.a0();     // Catch: Throwable -> L20
            Boolean r110 = Boolean.TRUE;     // Catch: Throwable -> L20
            r109.getClass();     // Catch: Throwable -> L20
            r107 = r110.equals(Boolean.FALSE);     // Catch: Throwable -> L20
        L18:
            monitor-exit(r100);     // Catch: Throwable -> L20
            return false;
        L20:
            th = move-exception;
            throw th;
        }

        public b(c r100, br7.a r101) {
            this.f16039b = r100;
            this.f16038a = r101;
        }
    }

    public c(Context r100) {
        this.f16033e = new Object();
        this.f16030b = r100;
        this.f16029a = new Object();
        this.f16032d = new HashMap();
    }

    public final void a(final WebView r100) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L7;
        new Handler(Looper.getMainLooper()).post(new ar7.a(this, r100));
        return;
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        MessageQueue r101 = Looper.getMainLooper().getQueue();
    L10:
        r101.addIdleHandler(new a(r100));
        return;
    L9:
        r101 = Looper.myQueue();
        goto L10
    }

    public final void c(br7.a r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (this.f16031c == null) goto L13;
        Object r102 = this.f16033e;
        monitor-enter(r102);
        monitor-exit(r102);     // Catch: Throwable -> L10
        this.f16031c.addIdleHandler(new b(this, r100));
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        if (r101 < 23) goto L16;
        this.f16031c = Looper.getMainLooper().getQueue();
        c(r100);
        return;
    L16:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L18;
        this.f16031c = Looper.myQueue();
        c(r100);
        return;
    L18:
        new Handler(Looper.getMainLooper()).post(new d(this, r100));
    }

    public final void b(String r100, int r101) {
        Object r102 = this.f16029a;
        monitor-enter(r102);
        br7.a r103 = (br7.a) ((HashMap) this.f16032d).get(r100);     // Catch: Throwable -> L27
        if (r103 != null) goto L8;
        monitor-exit(r102);     // Catch: Throwable -> L27
        return;
    L8:
        int r104 = ((ArrayList) r103.f20136a).size();     // Catch: Throwable -> L27
        r103.f20138c = r101;     // Catch: Throwable -> L27
        int r105 = 0;
        if (r104 >= r101) goto L14;
    L11:
        if (r105 >= (r101 - r104)) goto L25;
        c(r103);     // Catch: Throwable -> L27
        r105 = r105 + 1;     // Catch: Throwable -> L27
    L25:
        monitor-exit(r102);     // Catch: Throwable -> L27
        return;
    L14:
        if (r105 >= (r104 - r101)) goto L25;
        WebView r106 = (WebView) ((SoftReference) ((ArrayList) r103.f20136a).remove((r104 - 1) - r105)).get();     // Catch: Throwable -> L27
        Context r107 = this.f16030b;     // Catch: Throwable -> L27
        if (r106 == null) goto L24;
        r106.stopLoading();     // Catch: Throwable -> L27
        if (r107 == null) goto L23;
        Context r108 = r106.getContext();     // Catch: Throwable -> L27
        if ((r108 instanceof MutableContextWrapper) == false) goto L23;
        ((MutableContextWrapper) r108).setBaseContext(r107);     // Catch: Throwable -> L27
    L23:
        r106.loadUrl("about:blank");     // Catch: Throwable -> L27
        r106.destroy();     // Catch: Throwable -> L27
    L24:
        r105 = r105 + 1;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }
}
