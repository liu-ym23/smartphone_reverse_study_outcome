package a5a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.basedevtool.logbox.LogBoxLogLevel;
import com.lynx.basedevtool.logbox.LogBoxProxy;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class b extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LogBoxLogLevel f1857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakReference<l> f1858e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Runnable f1859f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f1860g;

    public class a extends h.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f1861b;

        /* JADX INFO: renamed from: a5a.b$a$a, reason: collision with other inner class name */
        public class RunnableC0017a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f1862a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f1863b;

            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(this.f1863b.f1861b.getContext(), this.f1862a, 0).show();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC0017a(a r100, String r101) {
                this.f1863b = r100;
                this.f1862a = r101;
            }
        }

        /* JADX INFO: renamed from: a5a.b$a$b, reason: collision with other inner class name */
        public class C0018b implements b5a.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f1864a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f1865b;

            @Override // b5a.b
            public final /* synthetic */ void onResponse(int r100, int r101) {
            }

            @Override // b5a.b
            public final void onFailure(String r100) {
                this.f1865b.b(this.f1864a, "");
            }

            @Override // b5a.b
            public final void onData(byte[] r100, int r101) {
                String r102 = new String(r100, Charset.defaultCharset());
                this.f1865b.b(this.f1864a, r102);
            }

            public C0018b(a r100, int r101, String r102) {
                this.f1865b = r100;
                this.f1864a = r101;
            }
        }

        public a(b r100) {
            this.f1861b = r100;
            super(r100);
        }

        @JavascriptInterface
        public void postMessage(String r100) {
            JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L42
            JSONObject r102 = new JSONObject(JSONObjectProtectorUtils.getString(r101, "data"));     // Catch: Exception -> L42
            String r103 = JSONObjectProtectorUtils.getString(r101, "bridgeName");     // Catch: Exception -> L42
            switch(r103.hashCode()) {
                case -2131858827: goto L24;
                case -348084113: goto L21;
                case 110532135: goto L18;
                case 469389831: goto L15;
                case 1355828097: goto L12;
                case 1456732406: goto L9;
                case 1671672458: goto L6;
                default: goto L26;
            };     // Catch: Exception -> L42
        L26:
            byte r104 = -1;
        L28:
            switch(r104) {
                case 0: goto L40;
                case 1: goto L39;
                case 2: goto L38;
                case 3: goto L37;
                case 4: goto L34;
                case 5: goto L33;
                case 6: goto L30;
                default: goto L54;
            };
        L30:
            String r105 = JSONObjectProtectorUtils.getString(r102, "namespace");     // Catch: Exception -> L42
            int r106 = JSONObjectProtectorUtils.getInt(r101, "callbackId");     // Catch: Exception -> L42
            com.lynx.basedevtool.logbox.a r107 = com.lynx.basedevtool.logbox.a.b.f380485a;     // Catch: Exception -> L42
            Context r108 = this.f1861b.getContext();     // Catch: Exception -> L42
            c r109 = new c(this, r106);     // Catch: Exception -> L42
            com.lynx.basedevtool.logbox.a.InterfaceC4542a r110 = (com.lynx.basedevtool.logbox.a.InterfaceC4542a) ((HashMap) r107.f380484a).get(r105);     // Catch: Exception -> L42
            if (r110 == null) goto L46;
            r110.a(r108, r109);     // Catch: Exception -> L42
            return;
        L46:
            return;
        L33:
            String r111 = JSONObjectProtectorUtils.getString(r102, "name");     // Catch: Exception -> L42
            c(JSONObjectProtectorUtils.getInt(r101, "callbackId"), r111);     // Catch: Exception -> L42
            return;
        L34:
            String r112 = JSONObjectProtectorUtils.getString(r102, "message");     // Catch: Exception -> L42
            if (TextUtils.isEmpty(r112) == true) goto L49;
            b5a.c.a(new RunnableC0017a(this, r112));     // Catch: Exception -> L42
            return;
        L49:
            return;
        L37:
            b5a.c.a(new g(this, JSONObjectProtectorUtils.getInt(r102, "viewNumber")));     // Catch: Exception -> L42
            return;
        L38:
            b5a.c.a(new e(this));     // Catch: Exception -> L42
            b5a.c.a(new f(this));     // Catch: Exception -> L42
            return;
        L39:
            b5a.c.a(new d(this));     // Catch: Exception -> L42
            return;
        L40:
            a();     // Catch: Exception -> L42
            b5a.c.a(this.f1861b.f1859f);     // Catch: Exception -> L42
            return;
        L54:
            return;
        L6:
            if (r103.equals("dismiss") == false) goto L26;
            r104 = 1;
            goto L28
        L9:
            if (r103.equals("queryResource") == false) goto L26;
            r104 = 5;
            goto L28
        L12:
            if (r103.equals("loadErrorParser") == false) goto L26;
            r104 = 6;
            goto L28
        L15:
            if (r103.equals("deleteLynxview") == false) goto L26;
            r104 = 2;
            goto L28
        L18:
            if (r103.equals("toast") == false) goto L26;
            r104 = 4;
            goto L28
        L21:
            if (r103.equals("getExceptionStack") == false) goto L26;
            r104 = 0;
            goto L28
        L24:
            if (r103.equals("changeView") == false) goto L26;
            r104 = 3;
        L42:
            e = move-exception;
            e.getMessage();
        }

        public final void c(int r100, String r101) {
            Object r102 = "";
            if (TextUtils.isEmpty(r101) == false) goto L6;
            b(r100, "");
            return;
        L6:
            C0018b r103 = new C0018b(this, r100, r101);
            if (r101.startsWith("http") == true) goto L9;
            l r104 = this.f1861b.f1858e.get();
            if (r104 == null) goto L34;
            LogBoxLogLevel r105 = this.f1861b.f1857d;
            l.a r106 = (l.a) ((HashMap) r104.f1885b).get(r105);
            if (r106 == null) goto L21;
            LogBoxProxy r107 = r106.a();
            if (r107 == null) goto L21;
            String r108 = r107.getLogSourceWithFileName(r101);
        L24:
            if (TextUtils.isEmpty(r108) == true) goto L34;
            if (r108.startsWith("http") == true) goto L28;
            b(r100, r108);
            return;
        L28:
            if (TextUtils.isEmpty(r108) == false) goto L30;
            return;
        L30:
            if (r108.startsWith("http") == false) goto L56;
            new b5a.a(r108, r103);
            return;
        L56:
            return;
        L21:
            r108 = "";
        L34:
            Map<String, Object> r109 = this.f1861b.f1875b;
            if (r109 != null) goto L38;
            b(r100, "");
            return;
        L38:
            Iterator<Map.Entry<String, Object>> r110 = r109.entrySet().iterator();
        L40:
            if (r110.hasNext() == false) goto L44;
            Map.Entry<String, Object> r111 = r110.next();
            if (r111.getKey().contains(r101) == false) goto L40;
            Object r112 = r111.getValue();
        L46:
            if ((r112 instanceof String) == false) goto L48;
            r102 = (String) r112;
        L48:
            b(r100, r102);
            return;
        L44:
            r112 = "";
            goto L46
        L9:
            if (TextUtils.isEmpty(r101) == false) goto L11;
            return;
        L11:
            if (r101.startsWith("http") == false) goto L54;
            new b5a.a(r101, r103);
            return;
        }
    }

    @Override // a5a.h
    public final void b() {
        l r100 = this.f1858e.get();
        if (r100 == null) goto L5;
        r100.e();
    L5:
        a("javascript: window.logbox.sendEvent({event: \"reset\"});");
    }

    @Override // android.app.Dialog
    public final boolean isShowing() {
        if (this.f1860g.booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (super.isShowing() == false) goto L7;
        return true;
    }

    public final void finalize() throws Throwable {
        super.finalize();
        this.f1874a.destroy();
    }

    public final void d(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        r103.put("log", r101);     // Catch: JSONException -> L5
        r103.put("namespace", r100);     // Catch: JSONException -> L5
        r102.put("event", "receiveNewLog");     // Catch: JSONException -> L5
        r102.put("data", r103);     // Catch: JSONException -> L5
        c(r102);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.getMessage();
    }

    public b(Context r100, l r101, k r102) {
        super(r100);
        this.f1860g = Boolean.FALSE;
        this.f1858e = new WeakReference(r101);
        this.f1859f = r102;
        a r103 = new a(this);
        this.f1874a.getSettings().setJavaScriptEnabled(true);
        this.f1874a.getSettings().setUserAgentString(this.f1874a.getSettings().getUserAgentString() + " Lynx LogBox");
        this.f1874a.setWebViewClient(new i(this));
        this.f1874a.setWebChromeClient(new j(this));
        this.f1874a.addJavascriptInterface(r103, "nativeBridge");
        this.f1874a.loadUrl("file:///android_asset/logbox/index.html");
    }

    public final void e(int r100, int r101, LogBoxLogLevel r102, String r103) {
        JSONObject r104 = new JSONObject();
        JSONObject r105 = new JSONObject();
        r104.put("event", "receiveViewInfo");     // Catch: JSONException -> L5
        r105.put("currentView", r100);     // Catch: JSONException -> L5
        r105.put("viewsCount", r101);     // Catch: JSONException -> L5
        r105.put("level", r102.value);     // Catch: JSONException -> L5
        r105.put("templateUrl", r103);     // Catch: JSONException -> L5
        r104.put("data", r105);     // Catch: JSONException -> L5
        c(r104);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.getMessage();
    }
}
