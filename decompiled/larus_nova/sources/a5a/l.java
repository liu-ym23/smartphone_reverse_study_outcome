package a5a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.basedevtool.logbox.LogBoxLifeCycleListenerFragment;
import com.lynx.basedevtool.logbox.LogBoxLogLevel;
import com.lynx.basedevtool.logbox.LogBoxProxy;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f1884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<LogBoxLogLevel, a> f1885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f1886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f1887d;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LogBoxLogLevel f1888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<LogBoxProxy> f1889b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1890c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1891d;

        public final LogBoxProxy a() {
            if (this.f1890c >= ((ArrayList) this.f1889b).size()) goto L9;
            int r100 = this.f1890c;
            if (r100 >= 0) goto L8;
            return null;
        L8:
            return (LogBoxProxy) ListProtector.get(this.f1889b, r100);
        L9:
            return null;
        }

        public a(LogBoxLogLevel r100) {
            this.f1888a = r100;
            this.f1889b = new ArrayList();
            this.f1890c = 0;
            this.f1891d = 0;
        }

        public final boolean b(LogBoxProxy r100) {
            int r101 = 0;
            if (((ArrayList) this.f1889b).contains(r100) == true) goto L5;
            return false;
        L5:
            this.f1891d -= r100.getLogCount(this.f1888a);
            ((ArrayList) this.f1889b).remove(r100);
            if (((ArrayList) this.f1889b).isEmpty() == true) goto L9;
            r101 = this.f1890c % ((ArrayList) this.f1889b).size();
        L9:
            this.f1890c = r101;
            return true;
        }
    }

    public final void e() {
        Iterator r100 = ((HashMap) this.f1885b).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L19;
        Map.Entry r101 = (Map.Entry) r100.next();
        a r102 = (a) r101.getValue();
        m r103 = this.f1886c;
        if (r103 == null) goto L4;
        Boolean r104 = (Boolean) ((HashMap) r103.f1895d).get((LogBoxLogLevel) r101.getKey());
        if (r104 != null) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L4;
        if (c(this.f1884a.get()) == false) goto L4;
        if (((ArrayList) r102.f1889b).isEmpty() == false) goto L17;
        String r106 = "";
    L18:
        this.f1886c.c((LogBoxLogLevel) r101.getKey(), b(r106), r102.f1891d);
        goto L4
    L17:
        List<LogBoxProxy> r107 = r102.f1889b;
        r106 = ((LogBoxProxy) ListProtector.get(r107, ((ArrayList) r107).size() - 1)).getLastLog(r102.f1888a);
        goto L18
    L10:
        r105 = r104.booleanValue();
        goto L11
    }

    public l(Context r100) {
        this.f1884a = new WeakReference(r100);
        HashMap r101 = new HashMap();
        this.f1885b = r101;
        LogBoxLogLevel r102 = LogBoxLogLevel.Error;
        r101.put(r102, new a(r102));
        LogBoxLogLevel r103 = LogBoxLogLevel.Warn;
        r101.put(r103, new a(r103));
        this.f1886c = new m(r100, this);
        c(r100);
    }

    public static void a(b r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static String b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L36;
        return "";
    L36:
        Object r101 = new JSONObject(r100).opt("error");     // Catch: JSONException -> L20
        if ((r101 instanceof String) == false) goto L16;
        String r102 = (String) r101;     // Catch: JSONException -> L20
        JSONObject r103 = new JSONObject((String) r101).optJSONObject("rawError");     // Catch: JSONException -> L13
    L35:
    L23:
        if (r103 == null) goto L25;
        r102 = r103.optString("message", null);
    L25:
        if (r102 == null) goto L29;
        r100 = r102;
    L29:
        if (r100.length() <= 50) goto L32;
        r100 = r100.substring(0, 50);
    L32:
        return r100.replace('\n', ' ');
    L13:
        e = e;
    L22:
        e.getMessage();
        r103 = null;
        goto L23
    L16:
        if ((r101 instanceof JSONObject) == false) goto L19;
        r103 = ((JSONObject) r101).optJSONObject("rawError");     // Catch: JSONException -> L20
        r102 = null;
        goto L35
    L19:
        r103 = null;
        r102 = null;
    L20:
        e = e;
        r102 = null;
        goto L22
    }

    public static boolean c(Context r100) {
        if ((r100 instanceof Activity) == false) goto L18;
        Activity r101 = (Activity) r100;
        if (r101.isFinishing() == false) goto L8;
        return false;
    L8:
        if (r101.getFragmentManager().findFragmentByTag("BaseDevToolLogBoxLifeCycleListener") == null) goto L16;
        return true;
    L16:
        r101.getFragmentManager().beginTransaction().add(new LogBoxLifeCycleListenerFragment(), "BaseDevToolLogBoxLifeCycleListener").commit();     // Catch: IllegalStateException -> L12
        return true;
    L12:
        e = move-exception;
        e.getMessage();
        return false;
    L18:
        return false;
    }

    public final void d(int r100, LogBoxLogLevel r101) {
        Objects.toString(r101);
        a r102 = (a) ((HashMap) this.f1885b).get(r101);
        if (r102 != null) goto L6;
        return;
    L6:
        if (r100 == (-1)) goto L12;
        int r103 = r100 - 1;
        if (r103 < 0) goto L12;
        if (r103 >= ((ArrayList) r102.f1889b).size()) goto L12;
        r102.f1890c = r103;
    L12:
        b r104 = this.f1887d;
        if (r104 == null) goto L37;
        int r105 = r102.f1890c + 1;
        int r106 = ((ArrayList) r102.f1889b).size();
        a r107 = (a) ((HashMap) this.f1885b).get(r101);
        String r108 = "";
        if (r107 == null) goto L21;
        LogBoxProxy r109 = r107.a();
        if (r109 == null) goto L21;
        r108 = r109.getEntryUrlForLogSrc();
    L21:
        r104.e(r105, r106, r101, r108);
        b r110 = this.f1887d;
        a r111 = (a) ((HashMap) this.f1885b).get(r101);
        if (r111 == null) goto L26;
        LogBoxProxy r112 = r111.a();
        if (r112 == null) goto L26;
        Map<String, Object> r113 = r112.getLogSources();
    L28:
        r110.f1875b = r113;
        LogBoxProxy r114 = r102.a();
        if (r114 == null) goto L39;
        b r115 = this.f1887d;
        String r116 = r114.getErrorNamespace();
        List<String> r117 = r114.getLogMessages(r101);
        r115.getClass();
        if (r117 == null) goto L40;
        Iterator<String> r118 = r117.iterator();
    L35:
        if (r118.hasNext() == false) goto L41;
        r115.d(r116, r118.next());
        goto L35
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L26:
        r113 = null;
        goto L28
    }
}
