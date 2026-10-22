package b4;

import android.util.Pair;
import com.bytedance.ai.bridge.method.net.core.IHostNetworkRuntimeApi;
import com.bytedance.ai.bridge.method.net.core.RequestMethod;
import com.bytedance.ai.bridge.service.IAppletRetrofit;
import com.bytedance.ai.bridge.service.IHostNetworkDepend;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.http.RequestContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f17426a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17427a = null;

        static {
            int[] r100 = new int[RequestMethod.values().length];
            r100[RequestMethod.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[RequestMethod.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[RequestMethod.PUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[RequestMethod.DELETE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f17427a = r100;
        }
    }

    static {
        f17426a = new b();
    }

    public b() {
    }

    public static Triple a(f r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Pair<String, String> r102 = UrlUtils.parseUrl(new UrlBuilder(r100.f17443a).build(), r101);
        return new Triple((String) r102.first, (String) r102.second, r101);
    }

    public static List b(f r100) {
        ArrayList r101 = new ArrayList();
        Map<String, String> r102 = r100.f17444b;
        if (r102 == null) goto L8;
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<String, String> r104 = r103.next();
        r101.add(new Header(r104.getKey(), r104.getValue()));
    L8:
        String r105 = r100.f17448f;
        if (r105 == null) goto L11;
        r101.add(new Header("Content-Type", r105));
    L11:
        return r101;
    }

    public static int c(String r110) {
        if (r110 != null) goto L13;
        return 0;
    L13:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L7
        int r101 = StringsKt.lastIndexOf$default(r110, "InternalErrorCode=", 0, false, 6, null);     // Catch: Throwable -> L7
        return CastIntegerProtector.parseInt(r110.substring(r101 + 18, StringsKt.indexOf$default(r110, ',', r101, false, 4, null)));
    L7:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Object r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r111) == false) goto L12;
        r111 = 0;
    L12:
        return ((Number) r111).intValue();
    }

    public static TypedByteArray d(f r100) {
        byte[] r101 = r100.f17447e;
        if (r101 != null) goto L7;
        return null;
    L7:
        return new TypedByteArray(r100.f17448f, r101, new String[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v7, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v8, types: [T, com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException, java.io.IOException, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v9, types: [T, com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException, java.io.IOException, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v13, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v19, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v8, types: [T, java.lang.ref.WeakReference] */
    public static c e(RequestMethod r210, f r211, IHostNetworkDepend r212) {
        Intrinsics.checkNotNullParameter(r210, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r211, "request");
        Intrinsics.checkNotNullParameter(r212, "hostNetworkDepend");
        LinkedHashMap r100 = new LinkedHashMap();
        Ref.IntRef r101 = new Ref.IntRef();
        r101.element = -1;
        Ref.IntRef r110 = new Ref.IntRef();
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        Ref.ObjectRef r103 = new Ref.ObjectRef();
        r103.element = "";
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        Ref.ObjectRef r112 = new Ref.ObjectRef();
        Triple r113 = a(r211);     // Catch: Throwable -> L35
        String r114 = (String) r113.getFirst();     // Catch: Throwable -> L35
        String r115 = (String) r113.getSecond();     // Catch: Throwable -> L35
        Map<String, String> r213 = (Map) r113.getThird();     // Catch: Throwable -> L35
        List<Header> r214 = b(r211);     // Catch: Throwable -> L35
        RequestContext r116 = new RequestContext();     // Catch: Throwable -> L35
        r116.timeout_connect = r211.f17449g;     // Catch: Throwable -> L35
        r116.timeout_read = r211.f17450h;     // Catch: Throwable -> L35
        r116.timeout_write = r211.f17451i;     // Catch: Throwable -> L35
        r116.force_handle_response = !r211.f17445c;     // Catch: Throwable -> L35
        LinkedHashMap r104 = new LinkedHashMap();     // Catch: Throwable -> L35
        r104.put("isCustomizedCookie", Boolean.valueOf(r211.f17452j));     // Catch: Throwable -> L35
        r104.put("needAddCommonParams", Boolean.valueOf(r211.f17445c));     // Catch: Throwable -> L35
        IAppletRetrofit r105 = r212.createRetrofit(r114, false, r104);     // Catch: Throwable -> L35
        T r106 = 0;
        if (r105 == null) goto L6;
        IHostNetworkRuntimeApi r107 = (IHostNetworkRuntimeApi) r105.create(IHostNetworkRuntimeApi.class);     // Catch: Throwable -> L35
    L7:
        int r117 = a.f17427a[r210.ordinal()];     // Catch: Throwable -> L35
        if (r117 != 1) goto L10;
        if (r107 == null) goto L18;
        Call<TypedInput> r108 = r107.streamGet(r211.f17445c, -1, r115, r213, r214, r116);     // Catch: Throwable -> L35
    L19:
        if (r108 == null) goto L39;
        r101.element = 0;     // Catch: Throwable -> L35
        r112.element = new WeakReference(r108);     // Catch: Throwable -> L35
        SsResponse<TypedInput> r109 = r108.execute();     // Catch: CronetIOException -> L33 Throwable -> L35 HttpResponseException -> L37
        r101.element = r109.code();     // Catch: CronetIOException -> L33 Throwable -> L35 HttpResponseException -> L37
        TypedInput r118 = r109.body();     // Catch: CronetIOException -> L33 Throwable -> L35 HttpResponseException -> L37
        if (r118 == null) goto L25;
        r106 = r118.in();     // Catch: CronetIOException -> L33 Throwable -> L35 HttpResponseException -> L37
    L25:
        r102.element = r106;     // Catch: CronetIOException -> L33 Throwable -> L35 HttpResponseException -> L37
        Iterator<Header> r119 = r109.headers().iterator();     // Catch: CronetIOException -> L33 Throwable -> L35 HttpResponseException -> L37
    L26:
        if (r119.hasNext() == false) goto L43;
        Header r120 = r119.next();     // Catch: CronetIOException -> L33 Throwable -> L35 HttpResponseException -> L37
        String r121 = r120.getName();     // Catch: CronetIOException -> L33 Throwable -> L35 HttpResponseException -> L37
        String r122 = r120.getValue();     // Catch: CronetIOException -> L33 Throwable -> L35 HttpResponseException -> L37
        if (r122 != null) goto L31;
        r122 = "";
    L31:
        r100.put(r121, r122);     // Catch: CronetIOException -> L33 Throwable -> L35 HttpResponseException -> L37
    L43:
        return new c(r100, r101, r102, r103, r111, r110, r112);
    L33:
        e = move-exception;
        r103.element = e.getClass() + ':' + e.getMessage() + ",-1";     // Catch: Throwable -> L35
        r101.element = e.getStatusCode();     // Catch: Throwable -> L35
        b r123 = f17426a;     // Catch: Throwable -> L35
        String r124 = e.getMessage();     // Catch: Throwable -> L35
        r123.getClass();     // Catch: Throwable -> L35
        r110.element = c(r124);     // Catch: Throwable -> L35
        r111.element = e;     // Catch: Throwable -> L35
    L37:
        e = move-exception;
        r103.element = e.getClass() + ':' + e.getMessage() + ',' + e.getStatusCode();     // Catch: Throwable -> L35
        r101.element = e.getStatusCode();     // Catch: Throwable -> L35
        b r125 = f17426a;     // Catch: Throwable -> L35
        String r126 = e.getMessage();     // Catch: Throwable -> L35
        r125.getClass();     // Catch: Throwable -> L35
        r110.element = c(r126);     // Catch: Throwable -> L35
        r111.element = e;     // Catch: Throwable -> L35
        goto L43
    L39:
        ?? r127 = "call is null, method is " + r210.name();     // Catch: Throwable -> L35
        r103.element = r127;     // Catch: Throwable -> L35
        Logger.d("HostNetworkDependImpl", r127);     // Catch: Throwable -> L35
    L18:
        r108 = null;
        goto L19
    L10:
        if (r117 != 2) goto L18;
        TypedByteArray r215 = d(r211);     // Catch: Throwable -> L35
        if (r215 == null) goto L18;
        if (r107 == null) goto L18;
        r108 = r107.streamPost(r211.f17445c, -1, r115, r213, r214, r215, r116);     // Catch: Throwable -> L35
        goto L19
    L6:
        r107 = null;
    L35:
        th = move-exception;
        r103.element = "request for string cause exception";
        r111.element = th;
        Logger.e("HostNetworkDependImpl", (String) r103.element, th);
        goto L43
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException, java.io.IOException, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v6, types: [T, com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException, java.io.IOException, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7, types: [T, com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException, java.io.IOException, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v11, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v14, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v19, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v12, types: [T, java.lang.Object] */
    public static d f(RequestMethod r210, f r211, IHostNetworkDepend r212) {
        Intrinsics.checkNotNullParameter(r210, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r211, "request");
        Intrinsics.checkNotNullParameter(r212, "hostNetworkDepend");
        LinkedHashMap r100 = new LinkedHashMap();
        Ref.IntRef r101 = new Ref.IntRef();
        r101.element = -1;
        Ref.IntRef r110 = new Ref.IntRef();
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        Ref.ObjectRef r103 = new Ref.ObjectRef();
        r103.element = "";
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        Triple r112 = a(r211);     // Catch: Throwable -> L60
        String r113 = (String) r112.getFirst();     // Catch: Throwable -> L60
        String r114 = (String) r112.getSecond();     // Catch: Throwable -> L60
        Map<String, String> r115 = (Map) r112.getThird();     // Catch: Throwable -> L60
        List<Header> r213 = b(r211);     // Catch: Throwable -> L60
        RequestContext r116 = new RequestContext();     // Catch: Throwable -> L60
        r116.timeout_connect = r211.f17449g;     // Catch: Throwable -> L60
        r116.timeout_read = r211.f17450h;     // Catch: Throwable -> L60
        r116.timeout_write = r211.f17451i;     // Catch: Throwable -> L60
        r116.force_handle_response = !r211.f17445c;     // Catch: Throwable -> L60
        LinkedHashMap r104 = new LinkedHashMap();     // Catch: Throwable -> L60
        r104.put("isCustomizedCookie", Boolean.valueOf(r211.f17452j));     // Catch: Throwable -> L60
        r104.put("needAddCommonParams", Boolean.valueOf(r211.f17445c));     // Catch: Throwable -> L60
        IAppletRetrofit r105 = r212.createRetrofit(r113, false, r104);     // Catch: Throwable -> L60
        if (r105 == null) goto L6;
        IHostNetworkRuntimeApi r106 = (IHostNetworkRuntimeApi) r105.create(IHostNetworkRuntimeApi.class);     // Catch: Throwable -> L60
    L7:
        int r117 = a.f17427a[r210.ordinal()];     // Catch: Throwable -> L60
        if (r117 == 1) goto L31;
        if (r117 != 2) goto L12;
        TypedByteArray r214 = d(r211);     // Catch: Throwable -> L60
        if (r214 == null) goto L28;
        if (r106 == null) goto L26;
        Call<TypedInput> r107 = r106.post(r211.f17445c, r211.f17453k, r114, r115, r213, r214, r116);     // Catch: Throwable -> L60
    L27:
        if (r107 == null) goto L28;
    L34:
        if (r107 == null) goto L66;
        r101.element = 0;     // Catch: Throwable -> L60
        SsResponse<TypedInput> r108 = r107.execute();     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
        r101.element = r108.code();     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
        r102.element = r108.body();     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
        Iterator<Header> r109 = r108.headers().iterator();     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
    L38:
        if (r109.hasNext() == false) goto L70;
        Header r118 = r109.next();     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
        if (r211.f17452j == false) goto L53;
        if (Intrinsics.areEqual(r118.getName(), "set-cookie") == true) goto L47;
        if (Intrinsics.areEqual(r118.getName(), "Set-Cookie") == false) goto L53;
    L47:
        if (r100.containsKey(r118.getName()) == true) goto L48;
        String r119 = r118.getName();     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
        String r120 = r118.getValue();     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
        if (r120 != null) goto L52;
        r120 = "";
    L52:
        r100.put(r119, r120);     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
        goto L38
    L48:
        String r121 = r118.getName();     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
        r100.put(r121, ((String) r100.get(r121)) + ", " + r118.getValue());     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
    L53:
        String r122 = r118.getName();     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
        String r123 = r118.getValue();     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
        if (r123 != null) goto L56;
        r123 = "";
    L56:
        r100.put(r122, r123);     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
    L70:
        return new d(r100, r101, r102, r103, r111, r110);
    L64:
        e = move-exception;
        r103.element = e.getClass() + ':' + e.getMessage() + ',' + e.getStatusCode();     // Catch: Throwable -> L60
        b r124 = f17426a;     // Catch: Throwable -> L60
        String r125 = e.getMessage();     // Catch: Throwable -> L60
        r124.getClass();     // Catch: Throwable -> L60
        r110.element = c(r125);     // Catch: Throwable -> L60
        r101.element = e.getStatusCode();     // Catch: Throwable -> L60
        r111.element = e;     // Catch: Throwable -> L60
    L58:
        e = move-exception;
        r103.element = e.getClass() + ':' + e.getMessage() + ',' + e.getStatusCode();     // Catch: Throwable -> L60
        b r126 = f17426a;     // Catch: Throwable -> L60
        String r127 = e.getMessage();     // Catch: Throwable -> L60
        r126.getClass();     // Catch: Throwable -> L60
        r110.element = c(r127);     // Catch: Throwable -> L60
        r101.element = e.getStatusCode();     // Catch: Throwable -> L60
        r111.element = e;     // Catch: Throwable -> L60
    L62:
        e = move-exception;
        r103.element = e.getClass() + ':' + e.getMessage() + ",-1001";     // Catch: Throwable -> L60
        r101.element = -1001;     // Catch: Throwable -> L60
        r111.element = e;     // Catch: Throwable -> L60
        goto L70
    L66:
        ?? r128 = "call is null, method is " + r210.name();     // Catch: Throwable -> L60
        r103.element = r128;     // Catch: Throwable -> L60
        Logger.d("HostNetworkDependImpl", r128);     // Catch: Throwable -> L60
        goto L70
    L26:
        r107 = null;
    L28:
        if (r106 == null) goto L33;
        r107 = r106.post(r211.f17445c, r211.f17453k, r114, r115, r213, r211.f17446d, r116);     // Catch: Throwable -> L60
    L33:
        r107 = null;
        goto L34
    L12:
        if (r117 != 3) goto L14;
        TypedByteArray r215 = d(r211);     // Catch: Throwable -> L60
        if (r106 == null) goto L33;
        r107 = r106.put(r211.f17445c, r211.f17453k, r114, r213, r215, r116);     // Catch: Throwable -> L60
        goto L34
    L14:
        if (r117 != 4) goto L18;
        if (r106 == null) goto L33;
        r107 = r106.delete(r211.f17445c, r211.f17453k, r114, r213, r116);     // Catch: Throwable -> L60
        goto L34
    L18:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L60
    L31:
        if (r106 == null) goto L33;
        r107 = r106.get(r211.f17445c, r211.f17453k, r114, r115, r213, r116);     // Catch: Throwable -> L60
        goto L34
    L6:
        r106 = null;
    L60:
        th = move-exception;
        r103.element = "request for string cause exception";
        r111.element = th;
        Logger.e("HostNetworkDependImpl", (String) r103.element, th);
        goto L70
    }
}
