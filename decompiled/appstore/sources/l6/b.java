package l6;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.ttnet.TTNetInit;
import com.bytedanceos.common.networkv2.params.NetValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f21869a;

    public b() {
    }

    public static b a() {
        if (f21869a != null) goto L16;
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f21869a != null) goto L11;
        f21869a = new b();     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L16:
        return f21869a;
    }

    public void b(ArrayList r24, String r25) {
        String r10 = "x-tt-tnc-abtest";
        String r11 = "x-tt-tnc-config";
        if (r24 != null) goto L5;
        return;
    L5:
        if (r24.isEmpty() == true) goto L105;
        Context r12 = TTNetInit.getTTNetDepend().getContext();
        if (r12 != null) goto L10;
        return;
    L10:
        Logger.d("CronetRetryEventHandler", "start get-domain request.");
        Iterator r13 = r24.iterator();
    L12:
        if (r13.hasNext() == false) goto L106;
        String r14 = (String) r13.next();
        p6.a r15 = new p6.a();     // Catch: Throwable -> L21
        r15.f23338f = true;     // Catch: Throwable -> L21
        r15.f23339g = false;     // Catch: Throwable -> L21
        com.bytedance.frameworks.baselib.network.http.util.h r16 = new com.bytedance.frameworks.baselib.network.http.util.h(r14);     // Catch: Throwable -> L21
        r16.b("tnc_src", NetValue.AppStatusType.DOWNLOAD_FAILURE_NEW);     // Catch: Throwable -> L21
        String r17 = r16.toString();     // Catch: Throwable -> L21
        HashMap r18 = new HashMap();     // Catch: Throwable -> L21
        HashMap r19 = new HashMap();     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r25) == true) goto L24;
        r19.put("x-tt-tnc-summary", r25);     // Catch: Throwable -> L19
    L19:
        th = th;
    L20:
        String r22 = r10;
        String r23 = r11;
    L80:
        th.printStackTrace();
        r11 = r23;
        r10 = r22;
    L24:
        String r20 = p6.c.a(r17, r19, r18, r15);     // Catch: Throwable -> L19
        Logger.d("CronetRetryEventHandler", "response: " + r20);     // Catch: Throwable -> L19
        if (com.bytedance.common.utility.e.b(r20) == true) goto L12;
        if ("success".equals(new JSONObject(r20).getString("message")) == false) goto L12;
        if (r18.get("x-ss-etag") != null) goto L34;
    L38:
        String r21 = "";
    L40:
        if (r18.get("x-ss-canary") != null) goto L42;
    L44:
        String r110 = "";
    L46:
        if (r18.get(r11) != null) goto L48;
    L50:
        String r111 = "";
    L52:
        if (r18.get(r10) != null) goto L94;
        r23 = r11;
    L63:
        String r26 = "";
    L65:
        if (r18.get("x-tt-tnc-control") == null) goto L73;
        r22 = r10;
    L71:
        th = th;
    L88:
        th.printStackTrace();     // Catch: Throwable -> L79
        return;
    L79:
        th = th;
        goto L80
    L69:
        if (TextUtils.isEmpty((CharSequence) ((List) r18.get("x-tt-tnc-control")).get(0)) == true) goto L74;
        String r27 = (String) ((List) r18.get("x-tt-tnc-control")).get(0);     // Catch: Throwable -> L71
    L75:
        Logger.d("CronetRetryEventHandler", "tnc verion: " + r21 + " canary: " + r110 + " configid: " + r111 + " abtest: " + r26);     // Catch: Throwable -> L71
        SsCronetHttpClient.y(r12).D(r21, r110, r111, r26, r27, r20);     // Catch: Throwable -> L71
        return;
    L74:
        r27 = "";
    L58:
        th = th;
    L59:
        r22 = r10;
        goto L88
    L73:
        r22 = r10;
        goto L74
    L94:
        r23 = r11;
        if (TextUtils.isEmpty((CharSequence) ((List) r18.get(r10)).get(0)) == true) goto L63;
        r26 = (String) ((List) r18.get(r10)).get(0);     // Catch: Throwable -> L58
    L60:
        th = th;
        r23 = r11;
        goto L59
    L48:
        if (TextUtils.isEmpty((CharSequence) ((List) r18.get(r11)).get(0)) == true) goto L50;
        r111 = (String) ((List) r18.get(r11)).get(0);     // Catch: Throwable -> L36
        goto L52
    L42:
        if (TextUtils.isEmpty((CharSequence) ((List) r18.get("x-ss-canary")).get(0)) == true) goto L44;
        r110 = (String) ((List) r18.get("x-ss-canary")).get(0);     // Catch: Throwable -> L36
        goto L46
    L34:
        if (TextUtils.isEmpty((CharSequence) ((List) r18.get("x-ss-etag")).get(0)) == true) goto L38;
        r21 = (String) ((List) r18.get("x-ss-etag")).get(0);     // Catch: Throwable -> L36
    L36:
        th = th;
        r22 = r10;
        r23 = r11;
    L21:
        th = th;
        goto L20
    L106:
        return;
    }
}
