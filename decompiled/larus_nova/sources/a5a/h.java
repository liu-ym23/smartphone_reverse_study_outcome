package a5a;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public abstract class h extends Dialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f1873c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebView f1874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, Object> f1875b;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f1876a;

        public a(h r100) {
            this.f1876a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f1876a.b();
            h r101 = this.f1876a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f1878b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f1878b.f1874a.evaluateJavascript(this.f1877a, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(h r100, String r101) {
            this.f1878b = r100;
            this.f1877a = r101;
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f1879a;

        public final void a() {
            InputStream r100 = this.f1879a.getContext().getAssets().open("logbox/mappings.wasm");     // Catch: JSONException -> L9 Throwable -> L11
            ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: JSONException -> L9 Throwable -> L11
            byte[] r102 = new byte[8192];     // Catch: JSONException -> L9 Throwable -> L11
        L4:
            int r103 = r100.read(r102);     // Catch: JSONException -> L9 Throwable -> L11
            if (r103 == (-1)) goto L6;
            r101.write(r102, 0, r103);     // Catch: JSONException -> L9 Throwable -> L11
            goto L4
        L6:
            r100.close();     // Catch: JSONException -> L9 Throwable -> L11
            String r104 = Base64.encodeToString(r101.toByteArray(), 0);     // Catch: JSONException -> L9 Throwable -> L11
            JSONObject r105 = new JSONObject();     // Catch: JSONException -> L9 Throwable -> L11
            r105.put("event", "loadFile");     // Catch: JSONException -> L9 Throwable -> L11
            JSONObject r106 = new JSONObject();     // Catch: JSONException -> L9 Throwable -> L11
            r106.putOpt("type", "mappings.wasm");     // Catch: JSONException -> L9 Throwable -> L11
            r106.putOpt("data", r104);     // Catch: JSONException -> L9 Throwable -> L11
            r105.putOpt("data", r106);     // Catch: JSONException -> L9 Throwable -> L11
            this.f1879a.c(r105);     // Catch: JSONException -> L9 Throwable -> L11
            return;
        L11:
            e = move-exception;
            e.getMessage();
        }

        public c(h r100) {
            this.f1879a = r100;
        }

        public final void b(int r100, Object r101) {
            if (r101 != null) goto L4;
            return;
        L4:
            JSONObject r102 = new JSONObject();
            r102.put("callbackId", r100);     // Catch: JSONException -> L8
            r102.put("data", r101);     // Catch: JSONException -> L8
            this.f1879a.a("javascript: window.logbox.sendResult(" + r102.toString() + ");");
            return;
        L8:
            e = move-exception;
            e.getMessage();
        }

        @JavascriptInterface
        public void on(String r100, Object r101) {
        }
    }

    public abstract void b();

    static {
    }

    public h(Context r100) {
        super(r100);
        requestWindowFeature(1);
        LinearLayout r101 = new LinearLayout(r100);
        r101.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        r101.setBackgroundColor(Color.alpha(80));
        r101.setOrientation(1);
        setContentView(r101);
        r101.setOnClickListener(new a(this));
        WebView r102 = new WebView(r100);
        this.f1874a = r102;
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-1, -1);
        Resources r104 = r100.getResources();
        r103.setMargins(0, Math.round(WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).heightPixels * 0.39999998f), 0, 0);
        r101.addView(r102, r103);
        if (getWindow() == null) goto L6;
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().setLayout(-1, -1);
        return;
    }

    public final void a(String r100) {
        b r101 = new b(this, r100);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        r101.run();
        return;
    L8:
        b5a.c.a(r101);
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void c(JSONObject r100) {
        a("javascript: window.logbox.sendEvent(" + r100.toString() + ");");
    }
}
