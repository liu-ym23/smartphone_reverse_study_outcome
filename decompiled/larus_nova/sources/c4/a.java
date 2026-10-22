package c4;

import android.content.Context;
import android.util.Base64;
import com.bytedance.ai.applet.app.foundation.w;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IMessageReceiveListener;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import d3.a0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.chromium.wschannel.WsClient;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f22355d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f22356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f22357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<c, Map<Long, e>> f22358c;

    /* JADX INFO: renamed from: c4.a$a, reason: collision with other inner class name */
    public static final class C0401a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f22359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f22360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f3.a f22361c;

        public b() {
            this(null, null, null, 7);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f22359a, r101.f22359a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f22360b, r101.f22360b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f22361c, r101.f22361c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final String toString() {
            return "ConnectResult(socketTaskId=" + this.f22359a + ", errorMessage=" + this.f22360b + ", errNo=" + this.f22361c + ')';
        }

        public final int hashCode() {
            Long r100 = this.f22359a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f22360b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            f3.a r107 = this.f22361c;
            if (r107 == null) goto L15;
            r101 = r107.f475285a;
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public b(Long r100, String r101, f3.a r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = null;
        L11:
            this.f22359a = r100;
            this.f22360b = r101;
            this.f22361c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f22362c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f22363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f22364b;

        /* JADX INFO: renamed from: c4.a$c$a, reason: collision with other inner class name */
        public static final class C0402a {
            public static c a(e3.d r100) {
                Intrinsics.checkNotNullParameter(r100, "bridgeContext");
                a0 r101 = r100.getContainerContext();
                if (r101 != null) goto L6;
                return null;
            L6:
                Intrinsics.checkNotNullParameter(r101, "containerContext");
                String r102 = r101.getAppletId();
                if (r102 != null) goto L10;
                r102 = "";
            L10:
                return new c(r102, r101.getContainerId());
            }
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f22363a, r101.f22363a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f22364b, r101.f22364b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f22363a.hashCode() * 31) + this.f22364b.hashCode();
        }

        public final String toString() {
            return "OwnerKey(appletId=" + this.f22363a + ", containerId=" + this.f22364b + ')';
        }

        public c(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);
            Intrinsics.checkNotNullParameter(r101, "containerId");
            this.f22363a = r100;
            this.f22364b = r101;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f22365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f3.a f22366b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f22365a, r101.f22365a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f22366b, r101.f22366b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final String toString() {
            return "SocketOperationError(message=" + this.f22365a + ", errNo=" + this.f22366b + ')';
        }

        public final int hashCode() {
            return (this.f22365a.hashCode() * 31) + this.f22366b.f475285a;
        }

        public d(String r100, f3.a r101) {
            Intrinsics.checkNotNullParameter(r100, "message");
            Intrinsics.checkNotNullParameter(r101, "errNo");
            this.f22365a = r100;
            this.f22366b = r101;
        }
    }

    public final class e implements IMessageReceiveListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f22367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f22368b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e3.d f22369c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final WsClient f22370d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile boolean f22371e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ a f22372f;

        @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IMessageReceiveListener
        public final void onFeedBackLog(String r100) {
        }

        public final d a(int r110, String r111) {
            if (this.f22371e == false) goto L5;
            return null;
        L5:
            this.f22371e = true;
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
            this.f22370d.stopConnection();     // Catch: Throwable -> L8
            Object r101 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L10:
            Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
            if (r102 == null) goto L17;
            String r112 = r102.getMessage();
            if (r112 != null) goto L16;
            r112 = "Failed to close WebSocket";
        L16:
            return new d(r112, f3.a.f475284y);
        L17:
            a r103 = this.f22372f;
            e3.d r104 = this.f22369c;
            long r105 = this.f22367a;
            Pair[] r106 = new Pair[3];
            r106[0] = TuplesKt.to("code", Integer.valueOf(r110));
            if (r111 != null) goto L20;
            String r107 = "";
        L21:
            r106[1] = TuplesKt.to("reason", r107);
            if (r111 != null) goto L24;
            r111 = "";
        L24:
            r106[2] = TuplesKt.to("errMsg", r111);
            a.c(r103, r104, r105, PTYSocketStateCallback.CLOSED, MapsKt.mapOf(r106));
            return null;
        L20:
            r107 = r111;
        L8:
            th = move-exception;
            Result.Companion r108 = Result.Companion;
            r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L10
        }

        public final void b(String r100, Map<String, ? extends Object> r101) {
            if (this.f22371e == false) goto L5;
            return;
        L5:
            this.f22371e = true;
            a.c(this.f22372f, this.f22369c, this.f22367a, r100, r101);
            a r102 = this.f22372f;
            long r103 = this.f22367a;
            Object r104 = r102.f22357b;
            monitor-enter(r104);
            r102.i(r103, this.f22368b, this);     // Catch: Throwable -> L10
            monitor-exit(r104);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IMessageReceiveListener
        public final void onMessage(byte[] r110, int r111) {
            if (this.f22371e == true) goto L11;
            if (r110 != null) goto L7;
            return;
        L7:
            if (r111 != 1) goto L9;
            a.b(this.f22372f, this.f22369c, this.f22367a, new String(r110, Charsets.UTF_8), "string");
            return;
        L9:
            a.b(this.f22372f, this.f22369c, this.f22367a, Base64.encodeToString(r110, 2), TTVideoEngineInterface.PLAY_API_KEY_BASE64);
            return;
        }

        public final d c(byte[] r100, int r101, String r102) {
            if (this.f22371e == false) goto L21;
            a r103 = this.f22372f;
            int r104 = a.f22355d;
            r103.getClass();
            return new d("The socketTaskId doesn't exist", f3.a.f475276q);
        L21:
            Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L8
            Object r106 = Result.m9449constructorimpl(Boolean.valueOf(this.f22370d.sendMessage(r100, r101)));     // Catch: Throwable -> L8
        L10:
            Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
            if (r107 == null) goto L13;
            String r108 = r107.getMessage();
            if (r108 != null) goto L20;
            r108 = "Failed to send WebSocket ".concat(r102);
        L20:
            return new d(r108, f3.a.f475284y);
        L13:
            if (((Boolean) r106).booleanValue() == false) goto L24;
            return null;
        L24:
            return new d("Failed to send WebSocket ".concat(r102), f3.a.f475284y);
        L8:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L10
        }

        @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IMessageReceiveListener
        public final void onConnection(int r100, String r101, JSONObject r110) {
            if (this.f22371e == false) goto L5;
            return;
        L5:
            if (r110 == null) goto L7;
            r100 = r110.optInt("state", r100);
        L7:
            if (r110 == null) goto L9;
            String r102 = r110.optString("error");
        L11:
            if (r102 != null) goto L13;
            r102 = "";
        L13:
            boolean r103 = false;
            if (r102.length() <= 0) goto L16;
            boolean r104 = true;
        L18:
            if (r104 == true) goto L26;
            if (r100 == 2) goto L26;
            if (r100 != 3) goto L24;
            b(PTYSocketStateCallback.CLOSED, MapsKt.mapOf(new Pair[]{TuplesKt.to("code", 1000), TuplesKt.to("reason", ""), TuplesKt.to("errMsg", "")}));
            return;
        L24:
            if (r100 != 4) goto L42;
            a.c(this.f22372f, this.f22369c, this.f22367a, PTYSocketStateCallback.CONNECTED, MapsKt.mapOf(TuplesKt.to("header", MapsKt.emptyMap())));
            return;
        L42:
            return;
        L26:
            Pair[] r105 = new Pair[3];
            if (r102.length() != 0) goto L29;
            boolean r111 = true;
        L31:
            if (r111 == false) goto L33;
            String r112 = "WebSocket connection failed";
        L34:
            r105[0] = TuplesKt.to("message", r112);
            if (r102.length() != 0) goto L37;
            r103 = true;
        L37:
            if (r103 == false) goto L39;
            r102 = "WebSocket connection failed";
        L39:
            r105[1] = TuplesKt.to("errMsg", r102);
            r105[2] = TuplesKt.to("code", -1);
            b("failed", MapsKt.mapOf(r105));
            return;
        L33:
            r112 = r102;
            goto L34
        L29:
            r111 = false;
            goto L31
        L16:
            r104 = false;
            goto L18
        L9:
            r102 = null;
            goto L11
        }

        public e(a r100, long r101, c r102, e3.d r103) {
            Intrinsics.checkNotNullParameter(r102, "ownerKey");
            Intrinsics.checkNotNullParameter(r103, "bridgeContext");
            this.f22372f = r100;
            this.f22367a = r101;
            this.f22368b = r102;
            this.f22369c = r103;
            this.f22370d = new WsClient(this);
        }
    }

    static {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void d() {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void onDestroy() {
    }

    public a() {
        this.f22356a = new AtomicLong(0);
        this.f22357b = new Object();
        this.f22358c = new LinkedHashMap();
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public final void f(e3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        int r101 = c.f22362c;
        c r102 = c.C0402a.a(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        Object r103 = this.f22357b;
        monitor-enter(r103);
        Map<Long, e> r104 = this.f22358c.remove(r102);     // Catch: Throwable -> L20
        if (r104 == null) goto L13;
        Collection<e> r105 = r104.values();     // Catch: Throwable -> L20
        if (r105 == null) goto L13;
        List r106 = CollectionsKt.toList(r105);     // Catch: Throwable -> L20
        if (r106 == null) goto L13;
    L14:
        monitor-exit(r103);
        Iterator r107 = r106.iterator();
    L17:
        if (r107.hasNext() == false) goto L19;
        ((e) r107.next()).a(1000, null);
        goto L17
    L19:
        return;
    L13:
        r106 = CollectionsKt.emptyList();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public static Map e(Map r110, List r111) {
        LinkedHashMap r100 = new LinkedHashMap();
        if (r110 != null) goto L5;
        r110 = MapsKt.emptyMap();
    L5:
        Iterator r112 = r110.entrySet().iterator();
    L7:
        if (r112.hasNext() == false) goto L16;
        Map.Entry r101 = (Map.Entry) r112.next();
        String r102 = (String) r101.getKey();
        String r103 = (String) r101.getValue();
        String r104 = StringsKt.trim(r102).toString();
        if ((!StringsKt.isBlank(r104)) == false) goto L7;
        if (StringsKt.equals(r104, AppConstants.BUNDLE_REFERER, true) == true) goto L7;
        if (StringsKt.equals(r104, "Sec-WebSocket-Protocol", true) == true) goto L7;
        if (r103 == null) goto L7;
        r100.put(r104, r103);
        goto L7
    L16:
        if (r111 != null) goto L18;
        r111 = CollectionsKt.emptyList();
    L18:
        List r113 = r111;
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r115 = r113.iterator();
    L20:
        if (r115.hasNext() == false) goto L22;
        r114.add(StringsKt.trim((String) r115.next()).toString());
        goto L20
    L22:
        ArrayList r105 = new ArrayList();
        Iterator r116 = r114.iterator();
    L24:
        if (r116.hasNext() == false) goto L28;
        Object r117 = r116.next();
        if ((!StringsKt.isBlank((String) r117)) == false) goto L24;
        r105.add(r117);
        goto L24
    L28:
        String r118 = CollectionsKt.joinToString$default(r105, ",", null, null, 0, null, null, 62, null);
        if ((!StringsKt.isBlank(r118)) == false) goto L31;
        r100.put("Sec-WebSocket-Protocol", r118);
    L31:
        return r100;
    }

    public final e j(e3.d r100, long r101) {
        int r102 = c.f22362c;
        c r103 = c.C0402a.a(r100);
        e r104 = null;
        if (r103 != null) goto L5;
        return null;
    L5:
        Object r105 = this.f22357b;
        monitor-enter(r105);
        Map r106 = (Map) ((LinkedHashMap) this.f22358c).get(r103);     // Catch: Throwable -> L16
        if (r106 == null) goto L14;
        e r107 = (e) r106.get(Long.valueOf(r101));     // Catch: Throwable -> L16
        if (r107 == null) goto L14;
        Intrinsics.checkNotNullParameter(r103, "ownerKey");     // Catch: Throwable -> L16
        if (Intrinsics.areEqual(r107.f22368b, r103) == false) goto L14;
        r104 = r107;
    L14:
        monitor-exit(r105);
        return r104;
    L16:
        th = move-exception;
        throw th;
    }

    public final e i(long r100, c r101, e r102) {
        Map r103 = (Map) ((LinkedHashMap) this.f22358c).get(r101);
        if (r103 != null) goto L5;
        return null;
    L5:
        e r104 = (e) r103.get(Long.valueOf(r100));
        if (r104 != null) goto L8;
        return null;
    L8:
        Intrinsics.checkNotNullParameter(r101, "ownerKey");
        if (Intrinsics.areEqual(r104.f22368b, r101) == true) goto L11;
        return null;
    L11:
        if (r102 == null) goto L14;
        if (r104 == r102) goto L14;
        return null;
    L14:
        r103.remove(Long.valueOf(r100));
        if (r103.isEmpty() == false) goto L17;
        this.f22358c.remove(r101);
    L17:
        return r104;
    }

    public static final void b(a r100, e3.d r101, long r102, String r103, String r104) {
        r100.getClass();
        Lazy r105 = com.bytedance.ai.applet.base.gson.e.f34515a;
        r101.a("socketDataReceived", com.bytedance.ai.applet.base.gson.e.d(MapsKt.mapOf(new Pair[]{TuplesKt.to("socketTaskId", Long.valueOf(r102)), TuplesKt.to("socketTaskID", String.valueOf(r102)), TuplesKt.to("data", r103), TuplesKt.to("dataType", r104), TuplesKt.to("protocolType", "websocket"), TuplesKt.to("socketType", "tradition")})));
    }

    public static final void c(a r100, e3.d r101, long r102, String r103, Map r104) {
        r100.getClass();
        Lazy r105 = com.bytedance.ai.applet.base.gson.e.f34515a;
        Map r106 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("status", r103), TuplesKt.to("socketTaskId", Long.valueOf(r102)), TuplesKt.to("socketTaskID", String.valueOf(r102)), TuplesKt.to("protocolType", "websocket"), TuplesKt.to("socketType", "tradition")});
        r106.putAll(r104);
        Unit r107 = Unit.INSTANCE;
        r101.a("socketStatusChanged", com.bytedance.ai.applet.base.gson.e.d(r106));
    }
}
