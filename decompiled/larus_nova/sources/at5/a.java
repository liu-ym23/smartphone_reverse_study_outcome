package at5;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.larkwebview.bridge.Message;
import com.bytedance.ee.larkwebview.bridge.Status;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.chameleon.bridge.BridgeReport;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import st5.o;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarkWebView f16231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f16232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Scheduler f16233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList<k> f16234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f16235e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f16236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f16237g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, JSONObject> f16238h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile at5.e f16239i;

    /* JADX INFO: renamed from: at5.a$a, reason: collision with other inner class name */
    public static final class C0223a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f16240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f16241b;

        public b(String r100, a r101) {
            this.f16240a = r100;
            this.f16241b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r110) {
            String r111 = (String) r110;
            Intrinsics.checkNotNullParameter(r111, "it");
            Log.d("JSBridge", "jsapi invokeNative start, jsMessage length: " + this.f16240a.length());
            boolean r100 = true;
            if (r111.length() != 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L8;
            int r112 = h.f16256a;
            h.a(this.f16241b.f16231a, 10002, "message isEmpty");
            zs5.c r113 = zs5.a.f573485a;
            LarkWebView r114 = this.f16241b.f16231a;
        L122:
            return Unit.INSTANCE;
        L8:
            Message r102 = this.f16241b.f16239i.b(this.f16240a);
            if (r111.length() <= 2097152) goto L11;
            int r103 = h.f16256a;
            h.b(this.f16241b.f16231a, 10007, "apiName = " + r102.getApiName() + " and message.length = " + r111.length() + ", is larger than TRANSFER_MAX_SIZE", r102.getApiName());
            zs5.c r115 = zs5.a.f573485a;
            LarkWebView r116 = this.f16241b.f16231a;
            r102.getApiName();
        L11:
            at5.e r117 = this.f16241b.f16239i;
            LarkWebView r104 = this.f16241b.f16231a;
            Intrinsics.checkNotNull(r102);
            r117.getClass();
            Intrinsics.checkNotNullParameter(r104, "webview");
            Intrinsics.checkNotNullParameter(r102, "msg");
            a r118 = this.f16241b;
            r118.getClass();
            String r119 = r102.getApiName();
            Log.d("JSBridge", "dispatchMsgFromJS, handlerName: " + r119);
            if (r119 != null) goto L14;
        L17:
            boolean r105 = true;
        L19:
            if (r105 == false) goto L22;
            int r120 = h.f16256a;
            h.a(r118.f16231a, 10004, "handlerName.isNullOrBlank()");
            goto L122
        L22:
            if (r118.f16236f == false) goto L34;
            int r106 = h.f16256a;
            LarkWebView r107 = r118.f16231a;
            Map<String, Object> r108 = r107.getCommonParams();
            Intrinsics.checkNotNullParameter(r107, "webView");
            OPMonitor r109 = r107.m(BridgeReport.EVENT_BRIDGE_CALL, null).addCategoryValue("api_name", r119);     // Catch: Throwable -> L32
            if (r108 == null) goto L30;
            Iterator<Map.Entry<String, Object>> r121 = r108.entrySet().iterator();     // Catch: Throwable -> L32
        L28:
            if (r121.hasNext() == false) goto L30;
            Map.Entry<String, Object> r122 = r121.next();     // Catch: Throwable -> L32
            r109.addCategoryValue(r122.getKey(), r122.getValue());     // Catch: Throwable -> L32
        L30:
            r109.flush();     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            Log.e("JSBridge", th);
        L34:
            f r123 = (f) ((ConcurrentHashMap) r118.f16232b.f16257a).get(r119);
            String r124 = r102.getCallbackID();
            String r125 = r102.getExtra();
            if (r125 != null) goto L37;
            r125 = "";
        L37:
            at5.d r126 = new at5.d(r124, r118, r119, r125);
            Iterator<k> r127 = r118.f16234d.iterator();
        L39:
            if (r127.hasNext() == false) goto L43;
            k r128 = r127.next();
            if (r128.p(r102, r126) == false) goto L39;
        L44:
            if (r128 == null) goto L46;
            boolean r129 = true;
        L47:
            if (r129 == false) goto L49;
            Log.d("JSBridge", "msg " + r119 + " onInterceptJSMsg");
            goto L122
        L49:
            if (r123 != null) goto L61;
            String r130 = r102.getData();
            if (r130 == null) goto L53;
            JSONObject r131 = new JSONObject(r130);
        L54:
            LarkWebView r132 = r118.f16231a;
            at5.c r133 = new at5.c(r119, r126);
            r132.getClass();
            Intrinsics.checkNotNullParameter(r119, "api");
            Intrinsics.checkNotNullParameter(r131, "params");
            Intrinsics.checkNotNullParameter(r133, "callback");
            com.bytedance.ee.larkwebview.util.e r134 = r132.f242859x;
            Context r135 = r132.getContext();
            r134.getClass();
            LKEvent.b r136 = new LKEvent.b();
            r136.f285504a = r119;
            r136.f285505b = r131;
            r136.f285506c = r135;
            LKEvent r137 = new LKEvent(r136);
            r137.f285494g = r133;
            if (r134.sendEvent(r137).f285520a == false) goto L57;
            Log.d("JSBridge", r119.concat(" handled by plugin"));
            goto L122
        L57:
            r126.a(Status.FAILURE, MapsKt.mapOf(new Pair("errMsg", Bridge.FIND_NO_HANDLER)));
            int r138 = h.f16256a;
            h.b(r118.f16231a, 10004, "handler not found handlerName = ".concat(r119), r119);
            if (r118.f16237g == false) goto L60;
            Log.e("JSBridge", "handler not found: " + r119 + "  web info :" + r118.f16231a.getBizType() + ", scene: " + r118.f16231a.getBizScene$lark_webview_base_chinaRelease());
            goto L122
        L60:
            Log.i("JSBridge", "fg close, not log web info");
            goto L122
        L53:
            r131 = new JSONObject();
            goto L54
        L61:
            int r139 = m.f16262a;
            Type r140 = r123.getClass().getGenericSuperclass();
            if ((r140 instanceof ParameterizedType) == false) goto L72;
            Type[] r141 = ((ParameterizedType) r140).getActualTypeArguments();
            Intrinsics.checkNotNull(r141);
            if (r141.length != 0) goto L66;
            boolean r142 = true;
        L67:
            if (r142 == true) goto L72;
            Type r143 = r141[0];
            if ((r143 instanceof Class) == false) goto L72;
            Class r144 = (Class) r143;
        L73:
            if (r144 != null) goto L102;
            Class<?> r145 = r123.getClass();
        L75:
            if (r145 == null) goto L82;
            if (r145.getGenericInterfaces().length != 0) goto L79;
            boolean r146 = true;
        L80:
            if (r146 == false) goto L82;
            r145 = r145.getSuperclass();
            goto L75
        L79:
            r146 = false;
        L82:
            if (r145 == null) goto L101;
            Type[] r147 = r145.getGenericInterfaces();
            if (r147.length <= 0) goto L90;
            Type r148 = r147[0];
            if ((r148 instanceof ParameterizedType) == false) goto L90;
            Intrinsics.checkNotNull(r148, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
            Type[] r149 = ((ParameterizedType) r148).getActualTypeArguments();
        L91:
            if (r149 == null) goto L101;
            if (r149.length != 0) goto L95;
            boolean r150 = true;
        L96:
            if (r150 == true) goto L101;
            Type r151 = r149[0];
            if ((r151 instanceof Class) == false) goto L101;
            r144 = (Class) r151;
            goto L102
        L95:
            r150 = false;
        L90:
            r149 = null;
        L101:
            r144 = null;
        L102:
            if (r144 == null) goto L116;
            String r152 = r102.getData();
            if (r152 != null) goto L106;
        L109:
            if (r100 == true) goto L116;
            if (Intrinsics.areEqual(r144, String.class) == false) goto L114;
            Object r153 = r102.getData();
        L115:
            Object r154 = r153;
        L118:
            if (r123.shouldRunInUIThread() == false) goto L120;
            Log.d("JSBridge", r119 + " handled on UIThread");
            com.bytedance.ee.larkwebview.util.g.a.f242974a.b(new at5.b(r123, r154, r126, r102, r118));
            goto L122
        L120:
            Log.d("JSBridge", r119 + " not handled on UIThread");
            r123.a(r154, r126, r102.getExtra(), r118.f16231a);
            goto L122
        L114:
            r153 = JSON.parseObject(r102.getData(), r144);
            goto L115
        L106:
            if (StringsKt.isBlank(r152) == true) goto L109;
            r100 = false;
        L116:
            r154 = null;
            goto L118
        L66:
            r142 = false;
        L72:
            r144 = null;
            goto L73
        L46:
            r129 = false;
            goto L47
        L43:
            r128 = null;
            goto L44
        L14:
            if (StringsKt.isBlank(r119) == true) goto L17;
            r105 = false;
            goto L19
        L5:
            r101 = false;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f16242a = null;

        static {
            f16242a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Unit r101 = (Unit) r100;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f16243a;

        public d(a r100) {
            this.f16243a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Log.e("JSBridge", r101, true);
            if (DevEnvUtil.isDebugMode(this.f16243a.f16231a.getContext()) == true) goto L5;
            return;
        L5:
            throw r101;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f16244a;

        public e(a r100, String r101, String r102) {
            this.f16244a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            o r100 = this.f16244a.f16231a.getServiceManager();     // Catch: Throwable -> L8
            if (r100 == null) goto L11;
            ys5.a r101 = (ys5.a) r100.a(ys5.a.class);     // Catch: Throwable -> L8
            if (r101 == null) goto L15;
            r101.b();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    static {
    }

    public final void b() {
        Log.i("JSBridge", MapMonitorConst.EVENT_DESTROY);
        ((ConcurrentHashMap) this.f16232b.f16257a).clear();
        this.f16233c.shutdown();
    }

    public a(LarkWebView r100) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        this.f16231a = r100;
        this.f16232b = new i();
        this.f16233c = Schedulers.from(PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("bridge/Bridge")));
        this.f16234d = new CopyOnWriteArrayList();
        this.f16236f = FeatureGatingModule.getFeatureGatingService().isEnable("larkwebview.jsb.call_report");
        this.f16237g = FeatureGatingModule.getFeatureGatingService().isEnable("openplatform.webview.jsb.find_no_handler_log_web");
        this.f16238h = new ConcurrentHashMap();
        this.f16239i = new at5.e();
        Intrinsics.checkNotNullParameter(Bridge.BRIDGE_NAME, "bridgeName");
        r100.addJavascriptInterface(this, Bridge.BRIDGE_NAME);
        this.f16235e = new g();
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "handlerName");
        Log.i("JSBridge", "unRegisterHandler handlerName = " + r100);
        ((ConcurrentHashMap) this.f16232b.f16257a).remove(r100);
    }

    @JavascriptInterface
    public void invokeNative(String r100) {
        Intrinsics.checkNotNullParameter(r100, "jsMessage");
        Flowable.just(r100).subscribeOn(this.f16233c).map(new b(r100, this)).subscribe(c.f16242a, new d(this));
    }

    public final void c(String r100, f<?, LarkWebView> r101) {
        Intrinsics.checkNotNullParameter(r100, "handlerName");
        Intrinsics.checkNotNullParameter(r101, "handler");
        if (StringsKt.isBlank(r100) == true) goto L7;
        Log.i("JSBridge", "registerHandler handlerName = " + r100);
        ((ConcurrentHashMap) this.f16232b.f16257a).put(r100, r101);
        return;
    L7:
        throw new IllegalArgumentException("handlerName should not blank");
    }

    @JavascriptInterface
    public final void onWebViewTextSelected(String r100, String r101) {
        mz7.b.a(new e(this, r100, r101));
    }

    public final void a(String r100, Serializable r101, ValueCallback<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "apiName");
        int r103 = m.f16262a;
        StringBuilder r104 = new StringBuilder();
        r104.append(r100);
        r104.append('(');
        if (r101 != null) goto L6;
        String r105 = "";
    L19:
        r104.append(r105);
        r104.append(')');
        String r106 = r104.toString();
        String r107 = new Regex("\n").replace(r106, "\\\\n");
        this.f16231a.evaluateJavascript(r107, r102);
        return;
    L6:
        if ((r101 instanceof com.alibaba.fastjson.JSONObject) == false) goto L8;
    L18:
        r105 = r101.toString();
        goto L19
    L8:
        if ((r101 instanceof JSONObject) == true) goto L18;
        boolean r108 = r101 instanceof Map;
        if (r108 == true) goto L13;
        r105 = JSON.toJSONString(r101);
        goto L19
    L13:
        if (r108 == false) goto L15;
        Map r109 = (Map) r101;
    L16:
        r105 = new com.alibaba.fastjson.JSONObject(r109).toString();
        goto L19
    L15:
        r109 = null;
        goto L16
    }
}
