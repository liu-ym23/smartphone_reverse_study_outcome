package ac4;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONException;
import org.json.JSONObject;
import qb4.n;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f2670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f2671b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WebView f2672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f2673b;

        @Override // java.lang.Runnable
        public final void run() {
            WebView r100 = this.f2672a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.evaluateJavascript("javascript:window.Native2JSBridge._handleMessageFromApp(" + this.f2673b + ")", null);     // Catch: Throwable -> L6
            int r101 = n.f532367a;     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(b r100, String r101) {
            this.f2673b = r101;
            this.f2672a = r100.f2670a;
        }
    }

    /* JADX INFO: renamed from: ac4.b$b, reason: collision with other inner class name */
    public class RunnableC0048b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WebView f2674a;

        public final void a() {
            WebView r100 = this.f2674a;
            if (r100 == null) goto L11;
            r100.stopLoading();
            this.f2674a.loadUrl("about:blank");
            this.f2674a.clearCache(true);
            this.f2674a.clearHistory();
            ViewParent r101 = this.f2674a.getParent();
            if (r101 != null) goto L7;
        L9:
            this.f2674a.destroy();
            return;
        L7:
            if ((r101 instanceof ViewGroup) == false) goto L9;
            ((ViewGroup) r101).removeView(this.f2674a);
            goto L9
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

        public RunnableC0048b(b r100) {
            this.f2674a = r100.f2670a;
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ac4.a f2675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f2676b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f2677a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ c f2678b;

            @Override // java.lang.Runnable
            public final void run() {
                ac4.c r100 = new ac4.c(this.f2678b.f2676b, this.f2677a);     // Catch: Throwable -> L4
                this.f2678b.f2675a.a(r100);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(c r100, String r101) {
                this.f2678b = r100;
                this.f2677a = r101;
            }
        }

        @JavascriptInterface
        public void callMethodParams(String r100) {
            int r101 = n.f532367a;
            Handler r102 = this.f2676b.f2671b;
            if (r102 != null) goto L5;
            return;
        L5:
            r102.post(new a(this, r100));
        }

        @JavascriptInterface
        public void offMethodParams(String r100) {
            int r101 = n.f532367a;
        }

        @JavascriptInterface
        public void onMethodParams(String r100) {
            int r101 = n.f532367a;
            JSONObjectProtectorUtils.getString(new JSONObject(r100), "__callback_id");     // Catch: JSONException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }

        public c(b r100, ac4.a r101) {
            this.f2676b = r100;
            this.f2675a = r101;
        }
    }

    public final void b() {
        if (this.f2670a != null) goto L5;
        return;
    L5:
        this.f2671b.post(new RunnableC0048b(this));
        this.f2671b = null;
        this.f2670a = null;
    }

    public final void a(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f2670a == null) goto L11;
        Handler r101 = this.f2671b;
        if (r101 == null) goto L12;
        r101.post(new a(this, r100));
        int r102 = n.f532367a;
        return;
    L12:
        return;
    }

    public b(ac4.a r100, WebView r101) {
        this.f2671b = null;
        this.f2670a = r101;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.getSettings().setJavaScriptEnabled(true);
        this.f2670a.addJavascriptInterface(new c(this, r100), "androidJsBridge");
        this.f2671b = new Handler(Looper.getMainLooper());
    }
}
