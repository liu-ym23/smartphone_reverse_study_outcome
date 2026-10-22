package com.bytedance.bdtracker;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.util.WebViewJsUtil;
import com.bytedance.bdtracker.s3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class p3 implements Handler.Callback {
    public final Handler c;
    public final b f;
    public Class h;
    public Class i;
    public final d j;
    public final Rect a = new Rect();
    public final Map<Integer, a> b = new HashMap();
    public boolean d = false;
    public int e = 0;
    public boolean g = true;

    public static class a {
        public m3 a;
        public List<s3> b = new ArrayList(2);
    }

    public interface b {
        void onGetCircleInfoFinish(int i, JSONArray jSONArray);

        void onGetCircleInfoFinish(Map<Integer, a> map);
    }

    public p3(d dVar, b bVar, Looper looper) {
        this.j = dVar;
        this.f = bVar;
        this.c = new Handler(looper, this);
        try {
            if (this.h == null) {
                this.h = Class.forName("com.reactnativerangersapplogreactnativeplugin.RangersAppLogPicker");
            }
            if (this.i == null) {
                this.i = Class.forName("com.facebook.react.ReactRootView");
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x009d, code lost:
    
        r0 = r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.view.View r9, com.bytedance.bdtracker.m3 r10, com.bytedance.bdtracker.p3.a r11) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.p3.a(android.view.View, com.bytedance.bdtracker.m3, com.bytedance.bdtracker.p3$a):void");
    }

    public final void b() {
        if (this.d && this.e == 0) {
            b bVar = this.f;
            if (bVar != null) {
                bVar.onGetCircleInfoFinish(this.b);
            }
            this.d = false;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        s3 s3Var;
        this.e--;
        WebView webView = (WebView) message.obj;
        String string = message.getData().getString(WebViewJsUtil.BUNDLE_WEB_INFO);
        t3 t3Var = new t3(this.j, webView, this.g);
        if (TextUtils.isEmpty(string)) {
            s3Var = null;
        } else {
            try {
                if (t3.f == 0) {
                    t3.f = t3Var.a();
                }
                t3Var.b.getLocationInWindow(t3Var.c);
                JSONObject jSONObject = new JSONObject(string.substring(1, string.length() - 1).replace("\\\"", "\"").replace("\\\\", "\\"));
                s3Var = new s3();
                String strOptString = jSONObject.optString("page");
                s3Var.a = strOptString;
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("info");
                ArrayList arrayList = new ArrayList();
                if (t3.g.get(strOptString) != null) {
                    t3Var.a = t3.g.get(strOptString).doubleValue();
                } else {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        double dOptInt = t3.f / jSONArrayOptJSONArray.optJSONObject(i).optJSONObject("frame").optInt("width");
                        if (t3Var.a == 0.0d) {
                            t3Var.a = dOptInt;
                        } else {
                            t3Var.a = Math.min(dOptInt, t3Var.a);
                        }
                    }
                    t3.g.put(strOptString, Double.valueOf(t3Var.a));
                }
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    arrayList.add(t3Var.a(jSONArrayOptJSONArray.optJSONObject(i2)));
                }
                s3Var.b = arrayList;
            } catch (Throwable th) {
                LoggerImpl.global().error(Collections.singletonList("WebInfoParser"), "WebInfoModel parse failed", th, new Object[0]);
            }
        }
        if (s3Var != null) {
            int[] iArr = new int[2];
            webView.getLocationInWindow(iArr);
            s3Var.c = new s3.a(iArr[0], iArr[1], webView.getWidth(), webView.getHeight());
            g4 g4VarA = r.a(webView, !this.g);
            s3Var.d = g4VarA != null ? g4VarA.x : "";
            a aVar = this.b.get(Integer.valueOf(u5.a((View) webView)));
            if (aVar != null) {
                aVar.b.add(s3Var);
            }
        }
        b();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.p3.a():void");
    }
}
