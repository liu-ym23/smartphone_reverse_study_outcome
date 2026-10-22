package org.chromium.wschannel;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.frameworks.baselib.network.http.g;
import com.bytedance.frameworks.baselib.network.http.i.l;
import com.bytedance.keva.KevaImpl;
import com.ttnet.org.chromium.net.ae;
import com.ttnet.org.chromium.net.impl.CronetFrontierClient;
import com.ttnet.org.chromium.net.impl.ad;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.CookieHandler;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.chromium.CronetClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CronetFrontierConnection.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {
    private static final String TAG = "CronetFrontierConnection";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CronetFrontierClient.e f40545a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static com.ttnet.org.chromium.net.d f40546c = null;
    private static volatile String f = "";
    private static final String l = null;
    private static boolean n;
    private static volatile AtomicInteger s;
    private static volatile int u;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IWsChannelClient f40547b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f40548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f40549e;
    private final AtomicInteger g;
    private int h;
    private int i;
    private Map<Integer, Boolean> j;
    private CronetFrontierClient k;
    private AtomicBoolean m;
    private volatile int o;
    private volatile boolean p;
    private ae q;
    private e r;
    private boolean t;
    private org.chromium.wschannel.b v;

    /* JADX INFO: renamed from: org.chromium.wschannel.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CronetFrontierConnection.java */
    final class C1096a extends com.bytedance.frameworks.baselib.network.http.i.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f40550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, Object> f40551b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<String> f40552c;

        public C1096a(a r3, long r4, Map<String, Object> r6, List<String> r7) {
            Map<String, Object> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
            List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            this.f40550a = r3;
            super(r4, a.h());
            this.f40551b = r8;
            this.f40552c = r9;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.e(this.f40550a) == false) goto L6;
            a.h(this.f40550a).set(0);
            a.i(this.f40550a).set(false);
            return;
        L6:
            int r0 = a.h(this.f40550a).incrementAndGet();
            if (Logger.debug() == false) goto L9;
            Logger.d(a.TAG, "Fallback to websocket connection, retry attempts:" + r0);
        L9:
            this.f40550a.e();
            a.a(this.f40550a, this.f40551b, this.f40552c);
            JSONObject r1 = new JSONObject();     // Catch: JSONException -> L12
            r1.put("retry_attempts", r0);     // Catch: JSONException -> L12
            r1.put("reason", "connect timeout fallback");     // Catch: JSONException -> L12
            a.a(this.f40550a, r1, 1);     // Catch: JSONException -> L12
            return;
        L12:
            e = move-exception;
            e.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: CronetFrontierConnection.java */
    class b implements CronetFrontierClient.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f40553a;

        b(a r1) {
            this.f40553a = r1;
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.c
        public void a(int r5, String r6) {
            if (Logger.debug() == false) goto L6;
            Logger.d(a.TAG, "onServiceReady ServiceId:" + r5 + " log info:" + r6);
        L6:
            if (a.a(this.f40553a) == true) goto L16;
            a.a(this.f40553a, true);
            if (a.b(this.f40553a) == null) goto L16;
            if (a.c(this.f40553a) == (-1)) goto L16;
            CronetFrontierClient r7 = a.b(this.f40553a);
            if (a.c(this.f40553a) != 1) goto L14;
            boolean r2 = true;
        L15:
            r7.a(r2);
            goto L16
        L14:
            r2 = false;
        L16:
            a.d(this.f40553a).put(Integer.valueOf(r5), true);
            if (this.f40553a.a() == true) goto L19;
        L24:
            a.f(this.f40553a).onServiceConnectEvent(r5, true, "");
            return;
        L19:
            if (a.e(this.f40553a) == false) goto L24;
            JSONObject r8 = new JSONObject();     // Catch: Throwable -> L26
            r8.put("type", 1);     // Catch: Throwable -> L26
            r8.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 1);     // Catch: Throwable -> L26
            r8.put("state", 4);     // Catch: Throwable -> L26
            r8.put("url", a.g());     // Catch: Throwable -> L26
            if (Logger.debug() == false) goto L23;
            Logger.d(a.TAG, "PP onConnectionStateChanged state: 4 url:" + a.g());     // Catch: Throwable -> L26
        L23:
            a.f(this.f40553a).onConnection(r8);     // Catch: Throwable -> L26
            goto L24
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.c
        public void a(int r3, int r4, String r5) {
            if (Logger.debug() == false) goto L5;
            Logger.d(a.TAG, "onError ServiceId:" + r3 + " error code:" + r4 + " info:" + r5);
        L5:
            a.f(this.f40553a).onServiceConnectEvent(r3, false, "");
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.c
        public void a(int r8, Map<String, String> r9, byte[] r10) {
            Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
            if (a.g(this.f40553a).get() == false) goto L10;
            if (Logger.debug() == false) goto L7;
            Logger.d(a.TAG, "proxy onReceivedMessage service id:" + r8 + " data length:" + r10.length);
        L7:
            a.f(this.f40553a).onMessage(r10);
            return;
        L10:
            if (Logger.debug() == false) goto L12;
            Logger.d(a.TAG, "onReceivedMessage service id:" + r8 + " data length:" + r10.length);
        L12:
            WsChannelMsg r0 = new WsChannelMsg();
            r0.setService(r8);
            ArrayList r12 = new ArrayList();
            Iterator r13 = r11.entrySet().iterator();
        L14:
            if (r13.hasNext() == false) goto L39;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2.getKey(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L14;
            if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2.getValue(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L14;
            if (((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin")).equals("method_id") == false) goto L27;
            r0.setMethod(Integer.valueOf((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin")).intValue());     // Catch: NumberFormatException -> L24
        L24:
            e = move-exception;
            Logger.e(a.TAG, "method_id is not valid: " + ((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin")));
            e.printStackTrace();
            goto L14
        L27:
            if (((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin")).equalsIgnoreCase("payload_encoding") == true) goto L28;
            if (((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin")).equalsIgnoreCase("payload_type") == true) goto L31;
            if (((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin")).equalsIgnoreCase("msg_id") == true) goto L34;
            if (((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin")).equalsIgnoreCase("server_timing") == true) goto L37;
            WsChannelMsg.MsgHeader r4 = new WsChannelMsg.MsgHeader();
            r4.setKey((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"));
            r4.setValue((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin"));
            r12.add(r4);
            goto L14
        L37:
            r0.setServerTiming((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin"));
            goto L14
        L34:
            r0.setMsgId((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin"));
            goto L14
        L31:
            r0.setPayloadType((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin"));
            goto L14
        L28:
            r0.setPayloadEncoding((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin"));
            goto L14
        L39:
            r0.setMsgHeaders(r12);
            r0.setPayload(r10);
            if (r0.getPayloadEncoding() != null) goto L43;
            r0.setPayloadEncoding("");
        L43:
            if (r0.getPayloadType() != null) goto L46;
            r0.setPayloadType("");
        L46:
            if (Logger.debug() == false) goto L48;
            Logger.d(a.TAG, "onReceivedMessage:" + r0);
        L48:
            a.f(this.f40553a).onMessage(r0);
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.c
        public void a(int r1, long r2, String r4, Boolean r5) {
            if (Logger.debug() == false) goto L6;
            Logger.d(a.TAG, "onReceivedAck serviceId:" + r1 + " messageId:" + r2 + " logInfo:" + r4);
            return;
        }
    }

    public void a(int r1) {
    }

    public void b(int r1) {
    }

    static /* synthetic */ void a(a r2, Map r3, List r4) {
        r2.b((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ void a(a r0, JSONObject r1, int r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ boolean a(a r0) {
        return r0.p;
    }

    static /* synthetic */ boolean a(a r0, boolean r1) {
        r0.p = r1;
        return r1;
    }

    static /* synthetic */ CronetFrontierClient b(a r0) {
        return r0.k;
    }

    static /* synthetic */ int c(a r0) {
        return r0.o;
    }

    static /* synthetic */ Map d(a r0) {
        return r0.j;
    }

    static /* synthetic */ boolean e(a r0) {
        return r0.k();
    }

    static /* synthetic */ IWsChannelClient f(a r0) {
        return r0.f40547b;
    }

    static /* synthetic */ String g() {
        return f;
    }

    static /* synthetic */ AtomicBoolean g(a r0) {
        return r0.f40549e;
    }

    static /* synthetic */ String h() {
        return l;
    }

    static /* synthetic */ AtomicInteger h(a r0) {
        return r0.g;
    }

    static /* synthetic */ AtomicBoolean i(a r0) {
        return r0.m;
    }

    static {
        l = UUID.randomUUID().toString();
        n = false;
        f40545a = CronetFrontierClient.e.f37948b;
        s = new AtomicInteger(0);
        u = -1;
    }

    public a(IWsChannelClient r3) {
        IWsChannelClient r4 = (IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r3, IWsChannelClient.class, "com.obric.aiagent.plugin");
        this.f40548d = new AtomicBoolean(false);
        this.f40549e = new AtomicBoolean(false);
        this.g = new AtomicInteger(0);
        this.h = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        this.i = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        this.j = new ConcurrentHashMap();
        this.m = new AtomicBoolean(false);
        this.o = -1;
        this.p = false;
        this.t = true;
        this.f40547b = r4;
        this.r = new e(this.f40547b);
        i();     // Catch: Throwable -> L5
    L9:
        f40546c = CronetClient.getCronetEngine();
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "TTNet init failed, cronet engine is null.");
        goto L9
    }

    private static void i() {
        Object r0 = ZeusTransformUtils.forName("com.bytedance.ttnet.TTNetInit", "com.obric.aiagent.plugin").newInstance();
        Reflect.on(r0).call("getInitCompletedLatch");
        Reflect.on(r0).call("preInitCronetKernel");
    }

    private Map<String, String> j() {
        return (Map) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("com.bytedance.ttnet.clientkey.ClientKeyManager", "com.obric.aiagent.plugin").getMethod("getClientKeyHeaders", new Class[0]).invoke(null, new Object[0]), Map.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private void b(Map<String, Object> r12, List<String> r13) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        List<String> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        this.f40548d.set(false);
        this.f40549e.set(false);
        if (s.incrementAndGet() <= 1) goto L5;
        this.t = false;
    L5:
        Object r2 = r14.get(WsConstants.KEY_CHANNEL_ID);
        if (r2 != null) goto L8;
        int r3 = -1;
    L10:
        if (u != (-1)) goto L15;
        if (r3 <= 0) goto L15;
        if (s.get() != 1) goto L15;
        u = r3;
    L15:
        ae.a r6 = f40546c.a(this.r, Executors.newSingleThreadExecutor());
        r6.a(r15);     // Catch: Throwable -> L63
        r6.a(String.valueOf(r14.get(WsConstants.KEY_APP_KEY)));     // Catch: Throwable -> L63
        r6.b(((Integer) ZeusTransformUtils.preCheckCast(r14.get(WsConstants.KEY_FPID), Integer.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Throwable -> L63
        r6.c(((Integer) ZeusTransformUtils.preCheckCast(r14.get(WsConstants.KEY_APP_VERSION), Integer.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Throwable -> L63
        r6.a(((Integer) ZeusTransformUtils.preCheckCast(r14.get(WsConstants.KEY_APP_ID), Integer.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Throwable -> L63
        r6.a(Long.parseLong((String) ZeusTransformUtils.preCheckCast(r14.get("device_id"), String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L63
        r6.b(Long.parseLong((String) ZeusTransformUtils.preCheckCast(r14.get(WsConstants.KEY_INSTALL_ID), String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L63
        if (r3 > 0) goto L19;
    L21:
        r6.a(false);     // Catch: Throwable -> L63
        if (r14.containsKey("sid") == false) goto L24;
        r6.b((String) ZeusTransformUtils.preCheckCast(r14.get("sid"), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L63
    L24:
        String r16 = (String) ZeusTransformUtils.preCheckCast(r14.get("extra"), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L63
        HashMap r1 = new HashMap();     // Catch: Throwable -> L63
        if (TextUtils.isEmpty(r16) == true) goto L68;
        String[] r17 = r16.split("&");     // Catch: Throwable -> L63
        int r4 = r17.length;     // Catch: Throwable -> L63
        int r7 = 0;
    L27:
        if (r7 >= r4) goto L68;
        String r8 = r17[r7];     // Catch: Throwable -> L63
        if (TextUtils.isEmpty(r8) == true) goto L33;
        String[] r9 = r8.split("=");     // Catch: Throwable -> L63
        if (r9.length != 2) goto L33;
        r1.put(r9[0], r9[1]);     // Catch: Throwable -> L63
    L33:
        r7 = r7 + 1;
    L68:
        HashMap r18 = new HashMap();     // Catch: Throwable -> L50
        Map<String, String> r5 = j();     // Catch: Throwable -> L50
        if (Logger.debug() == false) goto L37;
        Logger.d(TAG, "Client key: " + r5);     // Catch: Throwable -> L50
    L37:
        if (r5 != null) goto L39;
    L41:
        Map r19 = (Map) ZeusTransformUtils.preCheckCast(r14.get(WsConstants.KEY_HEADERS), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50
        if (r19 == null) goto L47;
        if (r19.isEmpty() == true) goto L47;
        r18.putAll(r19);     // Catch: Throwable -> L50
    L47:
        if (r18.isEmpty() == true) goto L52;
        r6.b(r18);     // Catch: Throwable -> L50
    L52:
        org.chromium.wschannel.b r110 = this.v;     // Catch: Throwable -> L63
        if (r110 != null) goto L55;
    L60:
        r6.a(r1);     // Catch: Throwable -> L63
        ae r111 = r6.a();
        this.q = r111;
        r111.a();
        return;
    L55:
        if (r110.c() <= 0) goto L60;
        long r112 = this.v.c();     // Catch: Throwable -> L63
        if (Logger.debug() == false) goto L59;
        Logger.d(TAG, "WS destroy timeout:" + r112);     // Catch: Throwable -> L63
    L59:
        r1.put("ttnet_timeout_millis", String.valueOf(r112));     // Catch: Throwable -> L63
        goto L60
    L39:
        if (r5.isEmpty() == true) goto L41;
        r18.putAll(r5);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L63
        goto L52
    L19:
        if (r3 != u) goto L21;
        this.t = true;     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        th.printStackTrace();
        throw new IllegalArgumentException("configMap contain err params !!!");
    L8:
        r3 = ((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.aiagent.plugin")).intValue();
        goto L10
    }

    private void a(String r8, HashMap<String, String> r9) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        String[] r10 = r8.split("&");
        int r0 = r10.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L28;
        String r3 = r10[r2];
        if (TextUtils.isEmpty(r3) == true) goto L27;
        String[] r4 = r3.split("=");
        if (r4.length != 2) goto L27;
        if (TextUtils.isEmpty(r4[0]) == true) goto L27;
        if (TextUtils.isEmpty(r4[1]) == true) goto L27;
        if (r4[0].equals("ttnet_heartbeat_interval") == false) goto L21;
        this.h = Integer.valueOf(r4[1]).intValue() * 1000;     // Catch: NumberFormatException -> L29
        goto L27
    L21:
        if (r4[0].equals("ttnet_timeout_millis") == false) goto L25;
        this.i = Integer.valueOf(r4[1]).intValue();     // Catch: NumberFormatException -> L29
        goto L27
    L25:
        if (this.f40549e.get() == true) goto L27;
        r9.put(r4[0], r4[1]);
    L27:
        r2 = r2 + 1;
        goto L6
    }

    private static void c(Map<String, Object> r3, List<Integer> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        ArrayList r7 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.get(WsConstants.KEY_SERVICE_ID_LIST), ArrayList.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.size() == 0) goto L19;
        Iterator r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L20;
        int r0 = ((Integer) ZeusTransformUtils.preCheckCast(r8.next(), Integer.class, "com.obric.aiagent.plugin")).intValue();
        if (r6.contains(Integer.valueOf(r0)) == true) goto L9;
        r6.add(Integer.valueOf(r0));
        goto L9
    L20:
        return;
    }

    private void a(Map<String, Object> r21, URI r22) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.aiagent.plugin");
        int r0 = r22.getPort();
        String r4 = r22.getPath();
        String r5 = r22.getQuery();
        if (r0 > 0) goto L5;
        r0 = 443;
    L5:
        int r9 = r0;
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "PP connection host:" + r22.getHost() + ":" + r9 + r4 + "?" + r5);
    L8:
        CronetFrontierClient.e r14 = c(((Integer) ZeusTransformUtils.preCheckCast(r3.get(WsConstants.KEY_TRANSPORT_MODE), Integer.class, "com.obric.aiagent.plugin")).intValue());
        f40545a = r14;
        ArrayList r15 = new ArrayList();
        if (this.f40549e.get() == false) goto L11;
        r15.add(1);
    L14:
        HashMap<String, String> r11 = new HashMap();
        String r10 = (String) ZeusTransformUtils.preCheckCast(r3.get("extra"), String.class, "com.obric.aiagent.plugin");
        a(r10, r11);
        Map<String, String> r1 = j();     // Catch: Throwable -> L36
        if (Logger.debug() == false) goto L18;
        Logger.d(TAG, "PP client key: " + r1);     // Catch: Throwable -> L36
    L18:
        if (r1 != null) goto L20;
    L22:
        Map<? extends String, ? extends String> r2 = (Map) ZeusTransformUtils.preCheckCast(r3.get(WsConstants.KEY_HEADERS), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
        if (r2 == null) goto L28;
        if (r2.isEmpty() == true) goto L28;
        r11.putAll(r2);     // Catch: Throwable -> L36
    L28:
        if (c() == false) goto L38;
        String r6 = MySelfChannelImpl.getDefaultUserAgent();     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r6) == true) goto L32;
        r11.put("user-agent", r6);     // Catch: Throwable -> L36
    L32:
        String r7 = a(r22);     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r7) == true) goto L38;
        r11.put("cookie", r7);     // Catch: Throwable -> L36
    L38:
        this.j.clear();
        org.chromium.wschannel.b r8 = this.v;
        if (r8 != null) goto L41;
    L46:
        CronetFrontierClient.a r12 = CronetFrontierClient.a.a(((Integer) ZeusTransformUtils.preCheckCast(r3.get(WsConstants.KEY_APP_ID), Integer.class, "com.obric.aiagent.plugin")).intValue(), ((Integer) ZeusTransformUtils.preCheckCast(r3.get(WsConstants.KEY_FPID), Integer.class, "com.obric.aiagent.plugin")).intValue(), r22.getHost(), r9, Integer.toString(((Integer) ZeusTransformUtils.preCheckCast(r3.get(WsConstants.KEY_APP_VERSION), Integer.class, "com.obric.aiagent.plugin")).intValue()), (String) ZeusTransformUtils.preCheckCast(r3.get("device_id"), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r3.get(WsConstants.KEY_APP_KEY), String.class, "com.obric.aiagent.plugin")).a(this.h).b(this.i).a(r14).a(r11).a(new c(this.f40547b, this));
        if (this.f40549e.get() == false) goto L53;
        r12.a(true);
        String r13 = a(r5, r10, r3.get(WsConstants.KEY_INSTALL_ID));
        if (Logger.debug() == false) goto L51;
        String r16 = TAG;
        Logger.d(r16, "PP connection real query:" + r13 + " path:" + r4);
    L52:
        r12.query(r13);
        r12.a(r4);
    L54:
        r12.a(r15);
        this.k = r12.a();
        if (Logger.debug() == false) goto L57;
        Logger.d(r16, "Register serviceIdList: " + r15 + " mode:" + r14);
    L57:
        Iterator r17 = r15.iterator();
    L59:
        if (r17.hasNext() == false) goto L61;
        Integer r18 = (Integer) ZeusTransformUtils.preCheckCast(r17.next(), Integer.class, "com.obric.aiagent.plugin");
        a(r18.intValue(), null, null);
        this.j.put(r18, false);
        goto L59
    L61:
        return;
    L51:
        r16 = TAG;
        goto L52
    L53:
        r16 = TAG;
        goto L54
    L41:
        if (r8.b() <= 0) goto L46;
        int r19 = (int) this.v.b();
        if (Logger.debug() == false) goto L45;
        Logger.d(TAG, "PP destroy timeout:" + r19);
    L45:
        this.i = r19;
        goto L46
    L20:
        if (r1.isEmpty() == true) goto L22;
        r11.putAll(r1);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        th.printStackTrace();
        goto L38
    L11:
        r15.add(Integer.valueOf(WsConstants.APP_STATE_CHANGE_SERVICE));
        if (g.p() == true) goto L14;
        c(r3, r15);
        goto L14
    }

    private static String a(String r2, String r3, Object r4) {
        StringBuilder r0 = new StringBuilder();
        if (TextUtils.isEmpty(r2) == true) goto L6;
        r0.append(r2);
    L6:
        if (TextUtils.isEmpty(r3) == false) goto L8;
    L18:
        long r5 = Long.parseLong((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L17
        if (r0.length() <= 0) goto L14;
        r0.append("&");     // Catch: Exception -> L17
    L14:
        r0.append("iid=" + r5);     // Catch: Exception -> L17
    L16:
        return r0.toString();
    L8:
        if (r0.length() <= 0) goto L10;
        r0.append("&");
    L10:
        r0.append(r3);
        goto L18
    }

    private static String a(URI r6) {
        HashMap r0 = new HashMap();
        StringBuilder r1 = new StringBuilder();
        Map<String, List<String>> r2 = null;
        CookieHandler r3 = CookieHandler.getDefault();     // Catch: Exception -> L25
        if (r3 == null) goto L6;
        r2 = r3.get(r6, r0);     // Catch: Exception -> L25
    L6:
        if (r2 == null) goto L24;
        if (r2.size() <= 0) goto L24;
        Iterator<Map.Entry<String, List<String>>> r7 = r2.entrySet().iterator();
    L11:
        if (r7.hasNext() == false) goto L24;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if ("cookie".equalsIgnoreCase((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin")) == false) goto L11;
        if (((List) ZeusTransformUtils.preCheckCast(r4.getValue(), List.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L11;
        int r5 = 0;
        Iterator r8 = ((List) ZeusTransformUtils.preCheckCast(r4.getValue(), List.class, "com.obric.aiagent.plugin")).iterator();
    L18:
        if (r8.hasNext() == false) goto L11;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");
        if (r5 <= 0) goto L22;
        r1.append("; ");
    L22:
        r1.append(r9);
        r5 = r5 + 1;
    L24:
        return r1.toString();
    L25:
        return null;
    }

    private CronetFrontierClient.e c(int r4) {
        if (r4 == 3) goto L5;
        if (r4 == 4) goto L5;
    L6:
        if (r4 == 1) goto L13;
        if (r4 == 2) goto L13;
        if (r4 == 4) goto L13;
        return CronetFrontierClient.e.f37948b;
    L13:
        return CronetFrontierClient.e.f37949c;
    L5:
        this.f40549e.set(true);
        goto L6
    }

    public void a(boolean r1) {
        this.p = r1;
    }

    private void a(int r3, ByteBuffer r4, String[] r5) {
        if (this.k == null) goto L6;
        ad r0 = new ad(r3, new b(this));
        this.k.a(r0, r4, r5);
        return;
    }

    private boolean k() {
        if (this.j.isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<Map.Entry<Integer, Boolean>> r4 = this.j.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        if (((Boolean) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L7;
        return false;
    L11:
        return true;
    }

    private URI a(Map<String, Object> r3) {
        String r2 = (String) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin")).get(WsConstants.KEY_PRIVATE_PROTOCOL_URL), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return null;
    L5:
        f = r2;
        if (r2.startsWith("wss:") == false) goto L10;
        r2 = "https:" + r2.substring(4);     // Catch: Throwable -> L14
    L12:
        return l.a(r2);
    L10:
        if (r2.startsWith("ws:") == false) goto L12;
        r2 = "http:" + r2.substring(3);     // Catch: Throwable -> L14
    L17:
        return null;
    }

    private boolean b(Map<String, Object> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (g.n() == false) goto L12;
        if (this.g.get() >= 3) goto L12;
        Object r4 = r6.get(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE);
        if (r4 != null) goto L10;
        return false;
    L10:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d(TAG, "Retry attempts:" + this.g.get() + ",tnc enabled:" + g.n());
    L14:
        return false;
    }

    public void a(Map<String, Object> r10, List<String> r11) {
        Map<String, Object> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L40;
        if (r7.size() <= 0) goto L40;
        boolean r0 = false;
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "openConnection url:" + ((String) ZeusTransformUtils.preCheckCast(r7.get(0), String.class, "com.obric.aiagent.plugin")));
    L9:
        if (r12 == null) goto L38;
        if (r12.isEmpty() == true) goto L38;
        e();
        if (b(r12) == true) goto L16;
        this.v = new org.chromium.wschannel.b(r12, true);
        b(r12, r7);
        return;
    L16:
        URI r13 = a(r12);
        if (r13 != null) goto L20;
        this.v = new org.chromium.wschannel.b(r12, true);
        b(r12, r7);
        return;
    L20:
        this.v = new org.chromium.wschannel.b(r12, false);
        Object r3 = r12.get(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET);
        if (r3 == null) goto L24;
        r0 = ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L24:
        if (Logger.debug() == false) goto L27;
        Logger.d(TAG, "DisableFallbackTask:" + n + " DisableFallbackWS:" + r0);
    L27:
        if (n == true) goto L35;
        if (r0 == true) goto L35;
        if (this.v.a() == false) goto L35;
        long r4 = c(r12);
        if (Logger.debug() == false) goto L34;
        Logger.d(TAG, "Fallback to websocket timeout:" + r4);
    L34:
        com.bytedance.frameworks.baselib.network.http.i.a.a().a(new C1096a(this, r4, r12, r7));
        this.m.set(true);
    L35:
        this.f40548d.set(true);
        a(r12, r13);
        return;
    L38:
        throw new IllegalArgumentException("configMap is empty !!!");
    L40:
        throw new IllegalArgumentException("urls size <= 0 !!!");
    }

    private long c(Map<String, Object> r5) {
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin")).get(WsConstants.KEY_HEADERS), Map.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return 10000;
    L5:
        if (r4.isEmpty() == false) goto L8;
        return 10000;
    L8:
        if (r4.containsKey("fallback_timeout_mills") == true) goto L10;
        return 10000;
    L10:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.get("fallback_timeout_mills"), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r6) == false) goto L18;
        return 10000;
    L18:
        int r7 = Integer.valueOf(r6).intValue();     // Catch: Exception -> L17
        if (r7 > 0) goto L16;
        return 10000;
    L16:
        return r7;
    L23:
        return 10000;
    }

    public boolean a() {
        return this.m.get();
    }

    public boolean b() {
        return this.f40548d.get();
    }

    public boolean c() {
        return this.f40549e.get();
    }

    public void d() {
        l();
    }

    public void e() {
        l();
    }

    private void l() {
        ae r0 = this.q;
        if (r0 == null) goto L5;
        r0.b();
        this.q.d();
    L5:
        CronetFrontierClient r1 = this.k;
        if (r1 == null) goto L9;
        r1.a();
        com.bytedance.frameworks.baselib.network.http.i.a.a().a(l);
        this.m.set(false);
        return;
    }

    public boolean f() {
        if (this.f40548d.get() == false) goto L9;
        CronetFrontierClient r0 = this.k;
        if (r0 == null) goto L9;
        return r0.b();
    L9:
        if (this.f40548d.get() == true) goto L14;
        ae r1 = this.q;
        if (r1 != null) goto L13;
        return false;
    L13:
        return r1.c();
    L14:
        return false;
    }

    public boolean a(byte[] r3) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "WS sendMessage data:" + r3);
    L6:
        if (this.q != null) goto L9;
        return false;
    L9:
        ByteBuffer r0 = ByteBuffer.allocateDirect(r3.length);
        r0.put(r3);
        this.q.a(r0);
        return true;
    }

    private void a(List<WsChannelMsg.MsgHeader> r5) {
        Iterator r6 = ((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L32;
        WsChannelMsg.MsgHeader r0 = (WsChannelMsg.MsgHeader) ZeusTransformUtils.preCheckCast(r6.next(), WsChannelMsg.MsgHeader.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L4;
        if (WsConstants.APP_STATE_BACKGROUND_KEY.equals(r0.getKey()) == false) goto L4;
        String r7 = r0.getValue();
        boolean r1 = false;
        if (r7.equals("1") == false) goto L13;
        this.o = 1;
    L16:
        if (this.p == true) goto L18;
        return;
    L18:
        if (this.o == (-1)) goto L31;
        CronetFrontierClient r8 = this.k;
        if (this.o != 1) goto L22;
        r1 = true;
    L22:
        r8.a(r1);
        return;
    L31:
        return;
    L13:
        if (r7.equals("0") == false) goto L16;
        this.o = 0;
        goto L16
    }

    public boolean b(byte[] r4) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "PP proxy sendMessage data:" + r4.toString());
    L5:
        CronetFrontierClient r0 = this.k;
        if (r0 == null) goto L14;
        if (r4 != null) goto L10;
        return false;
    L10:
        if (r0.a(1) == true) goto L12;
        a(1, null, null);
    L12:
        ByteBuffer r1 = ByteBuffer.allocateDirect(r4.length);
        r1.put(r4);
        this.k.a(1, null, r1);
        return true;
    L14:
        return false;
    }

    public boolean a(WsChannelMsg r6) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "PP sendMessage data:" + r6.toString());
    L6:
        if (this.k == null) goto L19;
        if (r6 == null) goto L21;
        int r0 = r6.getService();
        if (r0 == 9000) goto L12;
    L15:
        String[] r2 = b(r6);
        ByteBuffer r4 = ByteBuffer.allocateDirect(r6.getPayload().length);
        r4.put(r6.getPayload());
        this.k.a(r0, r2, r4);
        if (Logger.debug() == false) goto L18;
        Logger.d(TAG, "PP sendMessage serviceId:" + r0);
    L18:
        return true;
    L12:
        if (r6.getMethod() != 4) goto L15;
        a(r6.getMsgHeaders());
        return true;
    L21:
        return false;
    L19:
        return false;
    }

    private void a(JSONObject r3, int r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        r3.put("report_type", r4);
        r3.put("report_time", System.currentTimeMillis());
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "report log:" + r3.toString());
    L7:
        org.chromium.c.a().a(r3.toString(), "private_protocol");
    }

    private static String[] b(WsChannelMsg r5) {
        ArrayList r0 = new ArrayList();
        r0.add("method_id");
        r0.add(String.valueOf(r5.getMethod()));
        if (TextUtils.isEmpty(r5.getPayloadType()) == true) goto L6;
        r0.add("payload_type");
        r0.add(r5.getPayloadType());
    L6:
        if (TextUtils.isEmpty(r5.getPayloadEncoding()) == true) goto L9;
        r0.add("payload_encoding");
        r0.add(r5.getPayloadEncoding());
    L9:
        if (r5.getMsgHeaders() == null) goto L11;
        Iterator<WsChannelMsg.MsgHeader> r6 = r5.getMsgHeaders().iterator();
    L14:
        if (r6.hasNext() == false) goto L21;
        WsChannelMsg.MsgHeader r1 = (WsChannelMsg.MsgHeader) ZeusTransformUtils.preCheckCast(r6.next(), WsChannelMsg.MsgHeader.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r1.getKey()) == true) goto L14;
        if (TextUtils.isEmpty(r1.getValue()) == true) goto L14;
        r0.add(r1.getKey());
        r0.add(r1.getValue());
        goto L14
    L21:
        return (String[]) ZeusTransformUtils.preCheckCast(r0.toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");
    L11:
        return (String[]) ZeusTransformUtils.preCheckCast(r0.toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");
    }
}
