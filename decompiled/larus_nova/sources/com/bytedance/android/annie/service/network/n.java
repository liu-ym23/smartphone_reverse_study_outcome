package com.bytedance.android.annie.service.network;

import android.text.TextUtils;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.android.annie.util.ThreadUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.ttnet.http.RequestContext;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f39906a = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f39907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Integer f39908b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Throwable f39909c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f39910d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f39911e;

        public a(j r100, Integer r101, Throwable r102, String r103, int r104) {
            this.f39907a = r100;
            this.f39908b = r101;
            this.f39909c = r102;
            this.f39910d = r103;
            this.f39911e = r104;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j r100 = this.f39907a;     // Catch: Throwable -> L11
            Integer r101 = this.f39908b;     // Catch: Throwable -> L11
            Throwable r102 = this.f39909c;     // Catch: Throwable -> L11
            String r103 = this.f39910d;     // Catch: Throwable -> L11
            int r104 = this.f39911e;     // Catch: Throwable -> L11
            Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L8
            if (r102 != null) goto L6;
            r102 = new Throwable(r103);     // Catch: Throwable -> L8
        L6:
            r100.c(r101, r102, r104);     // Catch: Throwable -> L8
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L19:
            return;
        L8:
            th = move-exception;
            Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L11
            Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        }
    }

    public n() {
    }

    static {
        f39906a = new n();
    }

    public static Map a(Map r100) {
        if (r100 == null) goto L8;
        LinkedHashMap r101 = new LinkedHashMap(MapsKt.mapCapacity(r100.size()));
        Iterator r102 = r100.entrySet().iterator();
    L5:
        if (r102.hasNext() == false) goto L10;
        Map.Entry r103 = (Map.Entry) r102.next();
        Object r104 = r103.getKey();
        f39906a.getClass();
        r101.put(r104, e(r103));
        goto L5
    L10:
        return r101;
    L8:
        return MapsKt.emptyMap();
    }

    public static LinkedHashMap b(Map r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100 == null) goto L13;
        Iterator r102 = r100.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L13;
        Map.Entry r103 = (Map.Entry) r102.next();
        n r104 = f39906a;
        Object r105 = r103.getValue();
        r104.getClass();
        String r106 = e(r105);
        if (r106.length() <= 0) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == false) goto L6;
        r101.put(r103.getKey(), r106);
        goto L6
    L10:
        r107 = false;
    L13:
        return r101;
    }

    public static String e(Object r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if ((r100 instanceof Map) == false) goto L9;
        return new JSONObject((Map) r100).toString();
    L9:
        if ((r100 instanceof List) == false) goto L12;
        return new JSONArray((Collection) r100).toString();
    L12:
        return r100.toString();
    }

    public static boolean c(Integer r100, String r101, Throwable r110, int r111, j r112) {
        boolean r102 = false;
        if (r110 == null) goto L5;
    L8:
        String r103 = null;
        if (r101 != null) goto L11;
    L17:
        if (r110 == null) goto L19;
        r103 = r110.getMessage();
    L19:
        if (r103 != null) goto L22;
        r101 = "";
    L21:
        String r104 = r101;
    L23:
        ThreadUtils.a().post(new a(r112, r100, r110, r104, r111));
        return true;
    L22:
        r104 = r103;
        goto L23
    L11:
        if (r101.length() <= 0) goto L13;
        r102 = true;
    L13:
        if (r102 == true) goto L16;
        r101 = null;
    L16:
        if (r101 != null) goto L21;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v19, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException] */
    /* JADX WARN: Type inference failed for: r0v22, types: [com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException] */
    /* JADX WARN: Type inference failed for: r0v23, types: [com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException] */
    /* JADX WARN: Type inference failed for: r0v24, types: [T, java.io.IOException, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v26, types: [T, com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException, java.io.IOException, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v28, types: [T, com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException, java.io.IOException, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v32, types: [com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException] */
    /* JADX WARN: Type inference failed for: r0v33, types: [com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException] */
    /* JADX WARN: Type inference failed for: r0v34, types: [com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r5v21, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v24, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v29, types: [T, java.lang.String] */
    public static void d(String r210, LinkedHashMap r211, LinkedHashMap r212, Map r213, j r310, e r311, boolean r312) {
        Intrinsics.checkNotNullParameter(r210, "targetUrl");
        Intrinsics.checkNotNullParameter(r211, "headers");
        Intrinsics.checkNotNullParameter(r212, "postFilePart");
        Intrinsics.checkNotNullParameter(r213, "params");
        Intrinsics.checkNotNullParameter(r310, "callback");
        Intrinsics.checkNotNullParameter(r311, "hostNetworkDepend");
        g r110 = new g(r210);
        Intrinsics.checkNotNullParameter(r211, "headers");
        r110.f39898b = r211;
        Intrinsics.checkNotNullParameter(r212, "postFilePart");
        r110.f39901e = r212;
        Intrinsics.checkNotNullParameter(r213, "params");
        r110.f39900d = r213;
        r110.f39899c = r312;
        Intrinsics.checkNotNullParameter(r311, "hostNetworkDepend");
        p r100 = p.f39917a;
        RequestMethod r101 = RequestMethod.POST;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r110, "request");
        Intrinsics.checkNotNullParameter(r311, "hostNetworkDepend");
        LinkedHashMap r102 = new LinkedHashMap();
        Ref.IntRef r103 = new Ref.IntRef();
        r103.element = -1;
        Ref.IntRef r104 = new Ref.IntRef();
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        Ref.ObjectRef r105 = new Ref.ObjectRef();
        r105.element = "";
        Ref.ObjectRef r106 = new Ref.ObjectRef();
        Triple r112 = p.a(r110);     // Catch: Throwable -> L85
        String r113 = (String) r112.getFirst();     // Catch: Throwable -> L85
        String r114 = (String) r112.getSecond();     // Catch: Throwable -> L85
        LinkedHashMap r115 = (LinkedHashMap) r112.getThird();     // Catch: Throwable -> L85
        List<Header> r214 = p.b(r110);     // Catch: Throwable -> L85
        RequestContext r107 = new RequestContext();     // Catch: Throwable -> L85
        r107.timeout_connect = 0;     // Catch: Throwable -> L83
        r107.timeout_read = 0;     // Catch: Throwable -> L83
        r107.timeout_write = 0;     // Catch: Throwable -> L83
        r107.force_handle_response = !r110.f39899c;     // Catch: Throwable -> L83
        IHostNetworkRuntimeApi r108 = (IHostNetworkRuntimeApi) ((e.a) r311.createRetrofit(r113, false)).create(IHostNetworkRuntimeApi.class);     // Catch: Throwable -> L83
        int r116 = p.a.f39918a[r101.ordinal()];     // Catch: Throwable -> L83
        if (r116 != 1) goto L8;
        if (r108 == null) goto L32;
        Call<String> r109 = r108.doGetForString(r110.f39899c, -1, r114, r115, r214, r107);     // Catch: Throwable -> L83
    L122:
        if (r109 != null) goto L124;
        r111 = r111;
    L79:
        r105.element = "call is null, method is " + r101.name();     // Catch: Throwable -> L81
    L88:
        r r117 = new r(r102, r103, r111, r105, r106, r104);
        String r118 = r117.b();
        if (r118 != null) goto L91;
    L96:
        r118 = null;
    L97:
        Integer r119 = r117.a();
        if (r118 != null) goto L110;
        Integer r120 = Integer.valueOf(r103.element);
        String r121 = (String) r105.element;
        Throwable r122 = (Throwable) r106.element;
        if (r119 == null) goto L102;
        int r123 = r119.intValue();
    L104:
        if (c(r120, r121, r122, r123, r310) == true) goto L135;
        Integer r124 = Integer.valueOf(r103.element);
        if (r119 == null) goto L108;
        int r125 = r119.intValue();
    L109:
        ThreadUtils.a().post(new o(r118, r102, r310, r124, r125));
        return;
    L108:
        r125 = 0;
        goto L109
    L135:
        return;
    L102:
        r123 = 0;
        goto L104
    L110:
        Integer r126 = Integer.valueOf(r103.element);
        String r127 = (String) r105.element;
        Throwable r128 = (Throwable) r106.element;
        if (r119 == null) goto L113;
        int r129 = r119.intValue();
    L115:
        if (c(r126, r127, r128, r129, r310) == true) goto L137;
        Integer r130 = Integer.valueOf(r103.element);
        if (r119 == null) goto L119;
        int r131 = r119.intValue();
    L120:
        ThreadUtils.a().post(new o(r118, r102, r310, r130, r131));
        return;
    L119:
        r131 = 0;
        goto L120
    L137:
        return;
    L113:
        r129 = 0;
        goto L115
    L91:
        if (r118.length() <= 0) goto L93;
        boolean r132 = true;
    L94:
        if (r132 == false) goto L96;
    L93:
        r132 = false;
        goto L94
    L124:
        r103.element = 0;     // Catch: Throwable -> L76
        SsResponse<String> r133 = r109.execute();     // Catch: CronetIOException -> L65 NetworkNotAvailabeException -> L68 HttpResponseException -> L71 Throwable -> L76
        if (r133 == null) goto L63;
        r103.element = r133.code();     // Catch: CronetIOException -> L65 NetworkNotAvailabeException -> L68 HttpResponseException -> L71 Throwable -> L76
        String r134 = r133.body();     // Catch: CronetIOException -> L65 NetworkNotAvailabeException -> L68 HttpResponseException -> L71 Throwable -> L76
        T r135 = r134;
        if (r134 != null) goto L45;
        int r136 = l.f39905a;     // Catch: CronetIOException -> L65 NetworkNotAvailabeException -> L68 HttpResponseException -> L71 Throwable -> L76
        TypedInput r137 = r133.errorBody();     // Catch: CronetIOException -> L65 NetworkNotAvailabeException -> L68 HttpResponseException -> L71 Throwable -> L76
        if (r137 != null) goto L44;
        r137 = r133.raw().getBody();     // Catch: CronetIOException -> L65 NetworkNotAvailabeException -> L68 HttpResponseException -> L71 Throwable -> L76
    L44:
        r135 = l.a(r137);     // Catch: CronetIOException -> L65 NetworkNotAvailabeException -> L68 HttpResponseException -> L71 Throwable -> L76
    L45:
        r111 = r111;
        r111.element = r135;     // Catch: CronetIOException -> L57 NetworkNotAvailabeException -> L59 HttpResponseException -> L61 Throwable -> L81
        List<Header> r138 = r133.headers();     // Catch: CronetIOException -> L57 NetworkNotAvailabeException -> L59 HttpResponseException -> L61 Throwable -> L81
        if (r138 == null) goto L64;
        Iterator<Header> r139 = r138.iterator();     // Catch: CronetIOException -> L57 NetworkNotAvailabeException -> L59 HttpResponseException -> L61 Throwable -> L81
    L50:
        if (r139.hasNext() == false) goto L55;
        Header r140 = r139.next();     // Catch: CronetIOException -> L57 NetworkNotAvailabeException -> L59 HttpResponseException -> L61 Throwable -> L81
        String r141 = r140.getName();     // Catch: CronetIOException -> L57 NetworkNotAvailabeException -> L59 HttpResponseException -> L61 Throwable -> L81
        String r142 = r140.getValue();     // Catch: CronetIOException -> L57 NetworkNotAvailabeException -> L59 HttpResponseException -> L61 Throwable -> L81
        if (r142 != null) goto L54;
        r142 = "";
    L54:
        r102.put(r141, r142);     // Catch: CronetIOException -> L57 NetworkNotAvailabeException -> L59 HttpResponseException -> L61 Throwable -> L81
        goto L50
    L55:
        Unit r143 = Unit.INSTANCE;     // Catch: CronetIOException -> L57 NetworkNotAvailabeException -> L59 HttpResponseException -> L61 Throwable -> L81
    L74:
        if (r143 != null) goto L88;
    L64:
        r143 = null;
    L57:
        e = e;
    L67:
        r105.element = e.getClass().toString() + ':' + e.getMessage() + ',' + e.getStatusCode();     // Catch: Throwable -> L81
        p r144 = p.f39917a;     // Catch: Throwable -> L81
        String r145 = e.getMessage();     // Catch: Throwable -> L81
        r144.getClass();     // Catch: Throwable -> L81
        r104.element = p.c(r145);     // Catch: Throwable -> L81
        r103.element = e.getStatusCode();     // Catch: Throwable -> L81
        r106.element = e;     // Catch: Throwable -> L81
        r143 = Unit.INSTANCE;     // Catch: Throwable -> L81
    L61:
        e = e;
    L73:
        r105.element = e.getClass().toString() + ':' + e.getMessage() + ',' + e.getStatusCode();     // Catch: Throwable -> L81
        p r146 = p.f39917a;     // Catch: Throwable -> L81
        String r147 = e.getMessage();     // Catch: Throwable -> L81
        r146.getClass();     // Catch: Throwable -> L81
        r104.element = p.c(r147);     // Catch: Throwable -> L81
        r103.element = e.getStatusCode();     // Catch: Throwable -> L81
        r106.element = e;     // Catch: Throwable -> L81
        r143 = Unit.INSTANCE;     // Catch: Throwable -> L81
    L59:
        e = e;
    L70:
        r105.element = e.getClass().toString() + ':' + e.getMessage() + ",-1001";     // Catch: Throwable -> L81
        r103.element = -1001;     // Catch: Throwable -> L81
        r106.element = e;     // Catch: Throwable -> L81
        r143 = Unit.INSTANCE;     // Catch: Throwable -> L81
        goto L74
    L63:
        r111 = r111;
    L65:
        e = e;
        r111 = r111;
    L71:
        e = e;
        r111 = r111;
    L68:
        e = e;
        r111 = r111;
    L76:
        th = th;
        r111 = r111;
    L87:
        r105.element = "request for string cause exception";
        r106.element = th;
        b8.a r148 = b8.a.f17992a;
        b8.a.a(new b8.b("HostNetworkDependImpl", LogLevel.ERROR, th, (String) r105.element), true);
    L81:
        th = th;
    L32:
        r109 = null;
        goto L122
    L8:
        if (r116 != 2) goto L10;
        TypedOutput r215 = p.d(r110);     // Catch: Throwable -> L83
        if (r215 == null) goto L27;
        if (r108 == null) goto L23;
        Call<String> r149 = r108.doPostForString(r110.f39899c, -1, r114, r115, r214, r215, r107);     // Catch: Throwable -> L83
    L24:
        if (r149 == null) goto L27;
        r109 = r149;
        goto L122
    L23:
        r149 = null;
    L27:
        if (r108 == null) goto L32;
        r109 = r108.doPostForString(r110.f39899c, -1, r114, r115, r214, r110.f39900d, r107);     // Catch: Throwable -> L83
        goto L122
    L10:
        if (r116 != 3) goto L12;
        TypedOutput r216 = p.d(r110);     // Catch: Throwable -> L83
        if (r108 == null) goto L32;
        r109 = r108.doPutForString(r110.f39899c, -1, r114, r214, r216, r107);     // Catch: Throwable -> L83
        goto L122
    L12:
        if (r116 != 4) goto L32;
        if (r108 == null) goto L32;
        r109 = r108.doDeleteForString(r110.f39899c, -1, r114, r214, r107);     // Catch: Throwable -> L83
    L83:
        th = th;
        r111 = r111;
    L85:
        th = th;
        goto L87
    }
}
