package com.baidu.location.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import ch.qos.logback.core.spi.AbstractComponentTracker;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.stepos.alphame.suggest.AppSuggestStorable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class o {

    /* renamed from: j, reason: collision with root package name */
    private static long f5372j = 12000;

    /* renamed from: a, reason: collision with root package name */
    public e f5373a;

    /* renamed from: b, reason: collision with root package name */
    private Context f5374b;

    /* renamed from: c, reason: collision with root package name */
    private WebView f5375c;

    /* renamed from: d, reason: collision with root package name */
    private LocationClient f5376d;

    /* renamed from: e, reason: collision with root package name */
    private a f5377e;

    /* renamed from: f, reason: collision with root package name */
    private List<b> f5378f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5379g;

    /* renamed from: h, reason: collision with root package name */
    private long f5380h;

    /* renamed from: i, reason: collision with root package name */
    private BDLocation f5381i;

    /* renamed from: k, reason: collision with root package name */
    private f f5382k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f5383l;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        private String a(BDLocation bDLocation) throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(AppSuggestStorable.COLUMN_LATITUDE, bDLocation.getLatitude());
                jSONObject.put(AppSuggestStorable.COLUMN_LONGITUDE, bDLocation.getLongitude());
                jSONObject.put("radius", bDLocation.getRadius());
                jSONObject.put("errorcode", 1);
                if (bDLocation.hasAltitude()) {
                    jSONObject.put("altitude", bDLocation.getAltitude());
                }
                if (bDLocation.hasSpeed()) {
                    jSONObject.put("speed", bDLocation.getSpeed() / 3.6f);
                }
                if (bDLocation.getLocType() == 61) {
                    jSONObject.put("direction", bDLocation.getDirection());
                }
                if (bDLocation.getBuildingName() != null) {
                    jSONObject.put("buildingname", bDLocation.getBuildingName());
                }
                if (bDLocation.getBuildingID() != null) {
                    jSONObject.put("buildingid", bDLocation.getBuildingID());
                }
                if (bDLocation.getFloor() != null) {
                    jSONObject.put("floor", bDLocation.getFloor());
                }
                return jSONObject.toString();
            } catch (Exception unused) {
                return null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [com.baidu.location.b.o$1] */
        /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.String] */
        @Override // android.os.Handler
        public void handleMessage(Message message) throws JSONException {
            String string = 0;
            string = 0;
            switch (message.what) {
                case 1:
                    b bVar = (b) message.obj;
                    if (o.this.f5378f != null) {
                        o.this.f5378f.add(bVar);
                    }
                    if (o.this.f5376d != null) {
                        if (o.this.f5376d.requestLocation() != 0) {
                            long jCurrentTimeMillis = System.currentTimeMillis() - o.this.f5380h;
                            if (o.this.f5381i != null && jCurrentTimeMillis <= AbstractComponentTracker.LINGERING_TIMEOUT) {
                                Message messageObtainMessage = o.this.f5377e.obtainMessage(2);
                                messageObtainMessage.obj = o.this.f5381i;
                                messageObtainMessage.sendToTarget();
                                return;
                            }
                        }
                        if (o.this.f5383l) {
                            o.this.f5377e.removeCallbacks(o.this.f5382k);
                            o.this.f5383l = false;
                        }
                        if (o.this.f5382k == null) {
                            o oVar = o.this;
                            oVar.f5382k = new f();
                        }
                        o.this.f5377e.postDelayed(o.this.f5382k, o.f5372j);
                        o.this.f5383l = true;
                        return;
                    }
                    return;
                case 2:
                    a(a((BDLocation) message.obj));
                    return;
                case 3:
                    if (o.this.f5378f == null) {
                        o.this.f5378f = new ArrayList();
                    } else {
                        o.this.f5378f.clear();
                    }
                    o.this.f5376d.registerLocationListener(o.this.f5373a);
                    return;
                case 4:
                    if (o.this.f5378f != null) {
                        o.this.f5378f.clear();
                        o.this.f5378f = null;
                    }
                    o.this.f5376d.unRegisterLocationListener(o.this.f5373a);
                    o.this.f5380h = 0L;
                    o.this.f5381i = null;
                    if (o.this.f5382k != null && o.this.f5383l) {
                        o.this.f5377e.removeCallbacks(o.this.f5382k);
                    }
                    o.this.f5383l = false;
                    o.this.f5375c.removeJavascriptInterface("BaiduLocAssistant");
                    return;
                case 5:
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("errorcode", 0);
                        string = jSONObject.toString();
                    } catch (Exception unused) {
                    }
                    if (string == 0) {
                        return;
                    }
                    break;
                case 6:
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("errorcode", 2);
                        string = jSONObject2.toString();
                    } catch (Exception unused2) {
                    }
                    if (string == 0) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            a(string);
        }

        private void a(String str) {
            if (o.this.f5383l) {
                o.this.f5377e.removeCallbacks(o.this.f5382k);
                o.this.f5383l = false;
            }
            if (o.this.f5378f == null || o.this.f5378f.size() <= 0) {
                return;
            }
            Iterator it = o.this.f5378f.iterator();
            while (it.hasNext()) {
                try {
                    b bVar = (b) it.next();
                    if (bVar.b() != null) {
                        o.this.f5375c.loadUrl("javascript:" + bVar.b() + "('" + str + "')");
                    }
                    it.remove();
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    public class b {

        /* renamed from: b, reason: collision with root package name */
        private String f5386b;

        /* renamed from: c, reason: collision with root package name */
        private String f5387c;

        /* renamed from: d, reason: collision with root package name */
        private long f5388d;

        public b(String str) throws JSONException {
            this.f5386b = null;
            this.f5387c = null;
            this.f5388d = 0L;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("action")) {
                    this.f5386b = jSONObject.getString("action");
                }
                if (jSONObject.has("callback")) {
                    this.f5387c = jSONObject.getString("callback");
                }
                if (jSONObject.has("timeout")) {
                    long j4 = jSONObject.getLong("timeout");
                    if (j4 >= 1000) {
                        long unused = o.f5372j = j4;
                    }
                }
                this.f5388d = System.currentTimeMillis();
            } catch (Exception unused2) {
                this.f5386b = null;
                this.f5387c = null;
            }
        }

        public String a() {
            return this.f5386b;
        }

        public String b() {
            return this.f5387c;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private static final o f5389a = new o();
    }

    public class d {
        private d() {
        }

        @JavascriptInterface
        public void sendMessage(String str) {
            if (str == null || !o.this.f5379g) {
                return;
            }
            b bVar = o.this.new b(str);
            if (bVar.a() == null || !bVar.a().equals("requestLoc") || o.this.f5377e == null) {
                return;
            }
            Message messageObtainMessage = o.this.f5377e.obtainMessage(1);
            messageObtainMessage.obj = bVar;
            messageObtainMessage.sendToTarget();
        }

        @JavascriptInterface
        public void showLog(String str) {
        }
    }

    public class e extends BDAbstractLocationListener {
        public e() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Message messageObtainMessage;
            String str;
            if (!o.this.f5379g || bDLocation == null) {
                return;
            }
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            int locType = bDLocation2.getLocType();
            String coorType = bDLocation2.getCoorType();
            if (locType == 61 || locType == 161 || locType == 66) {
                if (coorType != null) {
                    if (coorType.equals("gcj02")) {
                        bDLocation2 = LocationClient.getBDLocationInCoorType(bDLocation2, "gcj2wgs");
                    } else {
                        if (coorType.equals("bd09")) {
                            str = BDLocation.BDLOCATION_BD09_TO_GCJ02;
                        } else if (coorType.equals("bd09ll")) {
                            str = BDLocation.BDLOCATION_BD09LL_TO_GCJ02;
                        }
                        bDLocation2 = LocationClient.getBDLocationInCoorType(LocationClient.getBDLocationInCoorType(bDLocation2, str), "gcj2wgs");
                    }
                }
                o.this.f5380h = System.currentTimeMillis();
                o.this.f5381i = new BDLocation(bDLocation2);
                messageObtainMessage = o.this.f5377e.obtainMessage(2);
                messageObtainMessage.obj = bDLocation2;
            } else {
                messageObtainMessage = o.this.f5377e.obtainMessage(5);
            }
            messageObtainMessage.sendToTarget();
        }
    }

    public class f implements Runnable {
        private f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.f5383l = false;
            o.this.f5377e.obtainMessage(6).sendToTarget();
        }
    }

    private o() {
        this.f5374b = null;
        this.f5376d = null;
        this.f5373a = new e();
        this.f5377e = null;
        this.f5378f = null;
        this.f5379g = false;
        this.f5380h = 0L;
        this.f5381i = null;
        this.f5382k = null;
        this.f5383l = false;
    }

    public void b() {
        if (this.f5379g) {
            this.f5377e.obtainMessage(4).sendToTarget();
            this.f5379g = false;
        }
    }

    public static o a() {
        return c.f5389a;
    }

    public void a(Context context, WebView webView, LocationClient locationClient) {
        if (this.f5379g) {
            return;
        }
        this.f5374b = context;
        this.f5375c = webView;
        this.f5376d = locationClient;
        a aVar = new a(Looper.getMainLooper());
        this.f5377e = aVar;
        aVar.obtainMessage(3).sendToTarget();
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setSavePassword(false);
        this.f5375c.removeJavascriptInterface("searchBoxJavaBridge_");
        this.f5375c.removeJavascriptInterface("accessibility");
        this.f5375c.removeJavascriptInterface("accessibilityTraversal");
        a(this.f5375c);
        this.f5379g = true;
    }

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    private void a(WebView webView) {
        webView.addJavascriptInterface(new d(), "BaiduLocAssistant");
    }
}
