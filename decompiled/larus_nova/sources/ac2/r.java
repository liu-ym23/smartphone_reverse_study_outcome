package ac2;

import android.text.TextUtils;
import com.bytedance.android.live.base.UplinkService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.network.PbRequestCallAdapter;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostNetwork;
import com.bytedance.android.livehostapi.foundation.depend.HostBoeParams;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.android.livesdk.config.w81;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Endpoint;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Path;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.ss.ugc.live.sdk.msg.network.HttpMethod;
import io.reactivex.Observable;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class r<T> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Pattern f2608o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CallAdapter<?, ?> f2613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Type f2614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p<?>[] f2615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Endpoint f2616h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public w81 f2617i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f2618j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<String, String> f2619k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map<String, String> f2620l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<Header> f2621m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f2622n;

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Retrofit f2623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f2624b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Annotation[] f2625c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Annotation[][] f2626d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Type[] f2627e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CallAdapter<?, ?> f2628f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Type f2629g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f2630h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f2631i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f2632j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f2633k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f2634l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f2635m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f2636n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f2637o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public p<?>[] f2638p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public long f2639q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f2640r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public List<Header> f2641s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public String f2642t;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v55 */
        /* JADX WARN: Type inference failed for: r4v56 */
        public final r a() {
            Type r100 = this.f2624b.getGenericReturnType();
            p<?> r101 = null;
            int r102 = 1;
            int r103 = 0;
            if (y.f(r100) == true) goto L262;
            if (r100 == Void.TYPE) goto L260;
            if (y.e(r100) != Observable.class) goto L258;
            CallAdapter<?, ?> r104 = this.f2623a.callAdapter(r100, this.f2624b.getAnnotations());     // Catch: RuntimeException -> L254
            this.f2628f = r104;
            this.f2629g = r104.responseType();
            Annotation[] r105 = this.f2625c;
            int r106 = r105.length;
            int r107 = 0;
        L11:
            if (r107 >= r106) goto L49;
            Annotation r108 = r105[r107];
            if ((r108 instanceof GET) == false) goto L16;
            e("GET", ((GET) r108).value(), false);
        L43:
            r107 = r107 + 1;
            goto L11
        L16:
            if ((r108 instanceof POST) == false) goto L19;
            e("POST", ((POST) r108).value(), true);
            goto L43
        L19:
            if ((r108 instanceof FormUrlEncoded) == false) goto L22;
            this.f2636n = true;
            goto L43
        L22:
            if ((r108 instanceof UplinkService) == false) goto L25;
            this.f2639q = ((UplinkService) r108).value();
            this.f2640r = true;
            goto L43
        L25:
            if ((r108 instanceof Headers) == false) goto L47;
            String[] r109 = ((Headers) r108).value();
            if (r109.length == 0) goto L45;
            ArrayList r110 = new ArrayList();
            int r111 = r109.length;
            int r112 = 0;
        L29:
            if (r112 >= r111) goto L42;
            String r113 = r109[r112];
            int r114 = r113.indexOf(58);
            if (r114 == (-1)) goto L41;
            if (r114 == 0) goto L41;
            if (r114 == (r113.length() - 1)) goto L41;
            String r115 = r113.substring(0, r114);
            String r116 = r113.substring(r114 + 1).trim();
            if ("Content-Type".equalsIgnoreCase(r115) == false) goto L38;
            this.f2642t = r116;
        L39:
            r112 = r112 + 1;
            goto L29
        L38:
            r110.add(new Header(r115, r116));
        L41:
            throw b(null, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", new Object[]{r113});
        L42:
            this.f2641s = r110;
            goto L43
        L45:
            throw b(null, "@Headers annotation is empty.", new Object[0]);
        L47:
            throw c(r108.toString(), new Object[0]);
        L49:
            if (this.f2640r == false) goto L253;
            if (this.f2634l == null) goto L251;
            if (this.f2635m == false) goto L55;
        L59:
            int r117 = this.f2626d.length;
            this.f2638p = new p[r117];
            int r118 = 0;
        L60:
            if (r118 >= r117) goto L224;
            Type r119 = this.f2627e[r118];
            if (y.f(r119) == true) goto L221;
            Annotation[] r120 = this.f2626d[r118];
            if (r120 == null) goto L220;
            p<?>[] r121 = this.f2638p;
            int r122 = r120.length;
            p<?> r123 = r101;
            int r124 = 0;
            int r125 = r102;
        L66:
            if (r124 >= r122) goto L215;
            Annotation r126 = r120[r124];
            if ((r126 instanceof Url) == false) goto L94;
            if (this.f2633k == true) goto L92;
            if (this.f2632j == true) goto L90;
            if (this.f2637o != null) goto L87;
            this.f2633k = r125;
            if (r119 != String.class) goto L78;
        L86:
            p<?> r127 = new p.g();
        L195:
            p<?> r128 = r127;
        L199:
            if (r123 != null) goto L202;
            r124 = r124 + 1;
            r123 = r128;
            r125 = 1;
            r103 = 0;
            goto L66
        L202:
            throw d(r118, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
        L78:
            if (r119 == URI.class) goto L86;
            if ((r119 instanceof Class) == false) goto L85;
            if ("android.net.Uri".equals(((Class) r119).getName()) == true) goto L86;
        L85:
            throw d(r118, "@Url must be String, java.net.URI, or android.net.Uri type.", new Object[r103]);
        L87:
            Object[] r129 = new Object[r125];
            r129[r103] = this.f2634l;
            throw d(r118, "@Url cannot be used with @%s URL", r129);
        L90:
            throw d(r118, "A @Url parameter must not come after a @Query", new Object[r103]);
        L92:
            throw d(r118, "Multiple @Url method annotations found.", new Object[r103]);
        L94:
            if ((r126 instanceof Path) == true) goto L213;
            if ((r126 instanceof Query) == false) goto L111;
            Query r130 = (Query) r126;
            String r131 = r130.value();
            boolean r132 = r130.encode();
            Class<?> r133 = y.e(r119);
            this.f2632j = r125;
            if (Iterable.class.isAssignableFrom(r133) == false) goto L105;
            if ((r119 instanceof ParameterizedType) == false) goto L103;
            r127 = new m(new p.e(r131, this.f2623a.stringConverter(y.d(0, (ParameterizedType) r119), r120), r132));
            goto L195
        L103:
            throw d(r118, r133.getSimpleName() + " must include generic type (e.g., " + r133.getSimpleName() + "<String>)", new Object[0]);
        L105:
            if (r133.isArray() == false) goto L108;
            r127 = new n(new p.e(r131, this.f2623a.stringConverter(r.a(r133.getComponentType()), r120), r132));
            goto L195
        L108:
            p<?> r134 = new p.e(r131, this.f2623a.stringConverter(r119, r120), r132);
        L109:
            r127 = r134;
            goto L195
        L111:
            if ((r126 instanceof QueryMap) == false) goto L130;
            Class<?> r135 = y.e(r119);
            if (Map.class.isAssignableFrom(r135) == false) goto L128;
            if (Map.class.isAssignableFrom(r135) == false) goto L126;
            Type r136 = y.g(r119, r135, y.c(r119, r135, Map.class));
            if ((r136 instanceof ParameterizedType) == false) goto L124;
            ParameterizedType r137 = (ParameterizedType) r136;
            Type r138 = y.d(0, r137);
            if (String.class != r138) goto L122;
            r134 = new p.f(this.f2623a.stringConverter(y.d(1, r137), r120), ((QueryMap) r126).encode());
            goto L109
        L122:
            throw d(r118, "@QueryMap keys must be of type String: " + r138, new Object[0]);
        L124:
            throw d(r118, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L126:
            throw new IllegalArgumentException();
        L128:
            throw d(r118, "@QueryMap parameter type must be Map.", new Object[0]);
        L130:
            if ((r126 instanceof com.bytedance.retrofit2.http.Header) == false) goto L143;
            String r139 = ((com.bytedance.retrofit2.http.Header) r126).value();
            Class<?> r140 = y.e(r119);
            if (Iterable.class.isAssignableFrom(r140) == false) goto L139;
            if ((r119 instanceof ParameterizedType) == false) goto L137;
            r127 = new m(new p.d(r139, this.f2623a.stringConverter(y.d(0, (ParameterizedType) r119), r120)));
            goto L195
        L137:
            throw d(r118, r140.getSimpleName() + " must include generic type (e.g., " + r140.getSimpleName() + "<String>)", new Object[0]);
        L139:
            if (r140.isArray() == false) goto L141;
            r127 = new n(new p.d(r139, this.f2623a.stringConverter(r.a(r140.getComponentType()), r120)));
            goto L195
        L141:
            r127 = new p.d(r139, this.f2623a.stringConverter(r119, r120));
            goto L195
        L143:
            if ((r126 instanceof Field) == false) goto L161;
            if (this.f2636n == false) goto L159;
            Field r141 = (Field) r126;
            String r142 = r141.value();
            boolean r143 = r141.encode();
            this.f2630h = true;
            Class<?> r144 = y.e(r119);
            if (Iterable.class.isAssignableFrom(r144) == false) goto L154;
            if ((r119 instanceof ParameterizedType) == false) goto L152;
            p<?> r145 = new m(new p.b(r142, this.f2623a.stringConverter(y.d(0, (ParameterizedType) r119), r120), r143));
        L156:
            r127 = r145;
            goto L195
        L152:
            throw d(r118, r144.getSimpleName() + " must include generic type (e.g., " + r144.getSimpleName() + "<String>)", new Object[0]);
        L154:
            if (r144.isArray() == false) goto L157;
            r145 = new n(new p.b(r142, this.f2623a.stringConverter(r.a(r144.getComponentType()), r120), r143));
            goto L156
        L157:
            r127 = new p.b(r142, this.f2623a.stringConverter(r119, r120), r143);
            goto L195
        L159:
            throw d(r118, "@Field parameters can only be used with form encoding.", new Object[0]);
        L161:
            if ((r126 instanceof FieldMap) == false) goto L184;
            if (this.f2636n == false) goto L182;
            Class<?> r146 = y.e(r119);
            if (Map.class.isAssignableFrom(r146) == false) goto L180;
            if (Map.class.isAssignableFrom(r146) == false) goto L178;
            Type r147 = y.g(r119, r146, y.c(r119, r146, Map.class));
            if ((r147 instanceof ParameterizedType) == false) goto L176;
            ParameterizedType r148 = (ParameterizedType) r147;
            Type r149 = y.d(0, r148);
            if (String.class != r149) goto L174;
            Converter<T, String> r150 = this.f2623a.stringConverter(y.d(1, r148), r120);
            this.f2630h = true;
            r134 = new p.c(r150, ((FieldMap) r126).encode());
            goto L109
        L174:
            throw d(r118, "@FieldMap keys must be of type String: " + r149, new Object[0]);
        L176:
            throw d(r118, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L178:
            throw new IllegalArgumentException();
        L180:
            throw d(r118, "@FieldMap parameter type must be Map.", new Object[0]);
        L182:
            throw d(r118, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
        L184:
            if ((r126 instanceof Body) == false) goto L211;
            if (this.f2636n == true) goto L209;
            if (this.f2631i == true) goto L207;
            if (RequestBody.class.isAssignableFrom(y.e(r119)) == false) goto L192;
            r127 = new p.h();
        L193:
            if (r127 == null) goto L265;
            this.f2631i = true;
            goto L195
        L265:
            Converter<T, TypedOutput> r151 = this.f2623a.requestBodyConverter(r119, r120, this.f2625c);     // Catch: RuntimeException -> L203
            this.f2631i = true;
            r128 = new p.a(r151, r119);
        L203:
            e = move-exception;
            throw b(e, "Unable to create @Body converter for %s (parameter #" + (r118 + 1) + ")", new Object[]{r119});
        L192:
            r127 = null;
            goto L193
        L207:
            throw d(r118, "Multiple @Body method annotations found.", new Object[0]);
        L209:
            throw d(r118, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        L211:
            throw c(r126.toString(), new Object[0]);
        L213:
            throw c("Path", new Object[0]);
        L215:
            if (r123 == null) goto L218;
            r121[r118] = r123;
            r118 = r118 + 1;
            r101 = null;
            r102 = 1;
            r103 = 0;
            goto L60
        L218:
            throw d(r118, "No Retrofit annotation found.", new Object[0]);
        L220:
            throw d(r118, "No Retrofit annotation found.", new Object[0]);
        L221:
            Object[] r152 = new Object[r102];
            r152[0] = r119;
            throw d(r118, "Parameter type must not include a type variable or wildcard: %s", r152);
        L224:
            if (this.f2637o == null) goto L226;
        L232:
            boolean r153 = this.f2636n;
            if (r153 == true) goto L242;
            if (this.f2635m == true) goto L242;
            if (this.f2631i == false) goto L242;
            throw b(null, "Non-body HTTP method cannot contain @Body.", new Object[0]);
        L242:
            if (r153 == false) goto L249;
            if (this.f2630h == true) goto L249;
            throw b(null, "Form-encode method must contain at least one @Field.", new Object[0]);
        L249:
            return new r(this);
        L226:
            if (this.f2633k == true) goto L232;
            if (this.f2639q != 0) goto L232;
            throw b(null, "Missing either @%s URL or @Url parameter.", new Object[]{this.f2634l});
        L55:
            if (this.f2636n == false) goto L59;
            throw b(null, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        L251:
            throw b(null, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        L253:
            throw b(null, "uplink request must need service id, contact wupanjie.flying", new Object[0]);
        L254:
            e = move-exception;
            throw b(e, "Unable to create call adapter for %s", new Object[]{r100});
        L258:
            throw b(null, "Uplink Service only support Observable", new Object[0]);
        L260:
            throw b(null, "Service methods cannot return void.", new Object[0]);
        L262:
            throw b(null, "Method return type must not include a type variable or wildcard: %s", new Object[]{r100});
        }

        public a(Retrofit r100, Method r101) {
            this.f2623a = r100;
            this.f2624b = r101;
            this.f2625c = r101.getAnnotations();
            this.f2627e = r101.getGenericParameterTypes();
            this.f2626d = r101.getParameterAnnotations();
        }

        public final RuntimeException c(String r100, Object... r101) {
            return b(null, "uplink not support annotation: " + r100, r101);
        }

        public final RuntimeException b(Throwable r100, String r101, Object... r102) {
            return new IllegalArgumentException(String.format(r101, r102) + "\n    for method " + this.f2624b.getDeclaringClass().getSimpleName() + "." + this.f2624b.getName(), r100);
        }

        public final RuntimeException d(int r100, String r101, Object... r102) {
            return b(null, r101 + " (parameter #" + (r100 + 1) + ")", r102);
        }

        public final void e(String r100, String r101, boolean r102) {
            String r103 = this.f2634l;
            Matcher r104 = null;
            if (r103 != null) goto L38;
            this.f2634l = r100;
            Matcher r105 = r.f2608o.matcher(r100);     // Catch: Exception -> L7
        L8:
            if (r105 != null) goto L10;
        L12:
            this.f2635m = r102;
            if (r101.isEmpty() == false) goto L15;
            return;
        L15:
            int r106 = r101.indexOf(63);
            if (r106 != (-1)) goto L18;
        L29:
            this.f2637o = r101;
            r104 = r.f2608o.matcher(r101);     // Catch: Exception -> L39
        L31:
            LinkedHashSet r107 = new LinkedHashSet();
        L32:
            if (r104 == null) goto L36;
            if (r104.find() == false) goto L48;
            r107.add(r104.group(1));
            goto L32
        L48:
            return;
        L36:
            return;
        L18:
            if (r106 >= (r101.length() - 1)) goto L29;
            String r108 = r101.substring(r106 + 1);
            Matcher r109 = r.f2608o.matcher(r108);     // Catch: Exception -> L22
        L23:
            if (r109 == null) goto L29;
            if (r109.find() == false) goto L29;
            throw b(null, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", new Object[]{r108});
        L22:
            r109 = null;
            goto L23
        L10:
            if (r105.find() == false) goto L12;
            r105.group(1);
        L7:
            r105 = null;
            goto L8
        L38:
            throw b(null, "Only one HTTP method is allowed. Found: %s and %s.", new Object[]{r103, r100});
        }
    }

    static {
        f2608o = PatternProtector.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
    }

    public static Map b() {
        HashMap r100 = new HashMap(32);
        r100.putAll(((IMiddlewareNetworkService) jc1.k.f(IMiddlewareNetworkService.class)).getCommonParams());
        r100.putAll(((IMiddlewareHostNetwork) jc1.k.f(IMiddlewareHostNetwork.class)).getCommonParams());
        return r100;
    }

    public r(a<T> r100) {
        this.f2617i = null;
        this.f2618j = -1;
        this.f2619k = new HashMap();
        this.f2620l = new HashMap();
        this.f2609a = r100.f2639q;
        this.f2610b = r100.f2634l;
        this.f2611c = r100.f2637o;
        this.f2612d = r100.f2636n;
        this.f2613e = r100.f2628f;
        this.f2614f = r100.f2629g;
        this.f2615g = r100.f2638p;
        this.f2616h = r100.f2623a.server();
        this.f2621m = r100.f2641s;
        this.f2622n = r100.f2642t;
    }

    public static Class<?> a(Class<?> r100) {
        if (Boolean.TYPE != r100) goto L7;
        return Boolean.class;
    L7:
        if (Byte.TYPE != r100) goto L11;
        return Byte.class;
    L11:
        if (Character.TYPE != r100) goto L15;
        return Character.class;
    L15:
        if (Double.TYPE != r100) goto L19;
        return Double.class;
    L19:
        if (Float.TYPE != r100) goto L23;
        return Float.class;
    L23:
        if (Integer.TYPE != r100) goto L27;
        return Integer.class;
    L27:
        if (Long.TYPE != r100) goto L31;
        return Long.class;
    L31:
        if (Short.TYPE != r100) goto L34;
        return Short.class;
    L34:
        return r100;
    }

    public final com.ss.ugc.live.sdk.msg.network.f c(Object... r110) throws IOException {
        p<?>[] r100 = this.f2615g;
        if (r110 == null) goto L5;
        int r101 = r110.length;
    L7:
        if (r101 != r100.length) goto L92;
        w r102 = new w();
        String r103 = this.f2611c;
        if (r103 == null) goto L12;
        r102.f2651a = r103.toString();
    L12:
        if ("GET".equalsIgnoreCase(this.f2610b) == false) goto L15;
        r102.f2652b = HttpMethod.GET;
    L17:
        HashMap r104 = (HashMap) b();
        r104.remove("openudid");
        Iterator r105 = r104.entrySet().iterator();
    L19:
        if (r105.hasNext() == false) goto L21;
        Map.Entry r106 = (Map.Entry) r105.next();
        r102.c((String) r106.getKey(), (String) r106.getValue(), true);
        goto L19
    L21:
        ArrayList r107 = new ArrayList(r101);
        int r108 = 0;
    L22:
        if (r108 >= r101) goto L25;
        r107.add(r110[r108]);
        r100[r108].a(r102, r110[r108]);
        r108 = r108 + 1;
        goto L22
    L25:
        if (this.f2612d == false) goto L27;
        r102.f2653c = "application/x-www-form-urlencoded; charset=UTF-8";
    L27:
        r102.f2658h = new l(this.f2614f);
        CallAdapter<?, ?> r111 = this.f2613e;
        if ((r111 instanceof PbRequestCallAdapter) == false) goto L32;
        PbRequestCallAdapter r112 = (PbRequestCallAdapter) r111;
        r112.getClass();
        PbRequestCallAdapter.f83789f.getClass();
        if (((JSONObject) PbRequestCallAdapter.f83788e.getValue()).optBoolean(r112.f83791b, false) == false) goto L32;
        r102.b("response-format", "protobuf");
    L32:
        IHostWebView r113 = (IHostWebView) jc1.k.f(IHostWebView.class);
        if (r113 == null) goto L41;
        Map<String, String> r114 = r113.getHeaderMap(this.f2616h.getUrl());
        if (r114 == null) goto L41;
        Iterator<String> r109 = r114.keySet().iterator();
    L38:
        if (r109.hasNext() == false) goto L41;
        String r115 = r109.next();
        r102.b(r115, r114.get(r115));
    L41:
        if (this.f2617i != null) goto L43;
        this.f2617i = LiveInfraSettingKeys.LIVE_TRACE_COMMON_PARAMS_OPT_CONFIG.getValue();
    L43:
        boolean r116 = this.f2617i.d();
        if (r116 == true) goto L46;
    L48:
        if (r116 == true) goto L50;
    L51:
        this.f2620l = s.a(r102.d(this.f2616h.getUrl()), this.f2617i.b());
        ALogger.i("TraceClientMonitor", "get Cookie EveryTime");
    L52:
        Map<String, String> r117 = this.f2620l;
        if (r117 != null) goto L55;
    L60:
        if (r116 == true) goto L62;
        this.f2619k = b();
        ALogger.i("TraceClientMonitor", "get CommonParams EveryTime");
    L62:
        Map<String, String> r118 = this.f2619k;
        if (r118 == null) goto L70;
        Iterator r119 = ((HashMap) r118).entrySet().iterator();
    L66:
        if (r119.hasNext() == false) goto L70;
        Map.Entry r120 = (Map.Entry) r119.next();
        if (TextUtils.equals((CharSequence) r120.getKey(), "openudid") == true) goto L66;
        r102.c((String) r120.getKey(), (String) r120.getValue(), true);
    L70:
        r102.b("im_uplink_service_id", String.valueOf(this.f2609a));
        List<Header> r121 = this.f2621m;
        if (r121 == null) goto L77;
        Iterator r122 = ((ArrayList) r121).iterator();
    L74:
        if (r122.hasNext() == false) goto L77;
        Header r123 = (Header) r122.next();
        r102.b(r123.getName(), r123.getValue());
    L77:
        if (TextUtils.isEmpty(this.f2622n) == true) goto L80;
        r102.b("Content-Type", this.f2622n);
    L80:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L89;
        HostBoeParams r124 = ((IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class)).getHostBoeParams();
        if (r124 == null) goto L89;
        if (r124.getBoeEnable() == false) goto L87;
        r102.b("X-TT-ENV", r124.getBoeLane());
        r102.b("X-USE-BOE", "1");
        goto L89
    L87:
        if (r124.getPpeEnable() == false) goto L89;
        r102.b("X-TT-ENV", r124.getPpeLane());
        r102.b("X-USE-PPE", "1");
    L89:
        String r125 = r102.d(this.f2616h.getUrl());
        com.ss.ugc.live.sdk.msg.network.f.a r126 = new com.ss.ugc.live.sdk.msg.network.f.a();
        com.ss.ugc.live.sdk.msg.network.f r127 = r126.f458310a;
        r127.f458299b = r125;
        r127.f458298a = r102.f2652b;
        r127.f458304g = r102.f2653c;
        r127.f458300c = r102.f2654d;
        com.ss.ugc.live.sdk.msg.network.f.a r128 = r126.query(r102.f2655e);
        LinkedHashMap<String, String> r129 = r102.f2656f;
        com.ss.ugc.live.sdk.msg.network.f r130 = r128.f458310a;
        r130.f458305h = r129;
        r130.f458303f = r102.f2657g;
        r130.f458307j = r102.f2658h;
        r130.f458309l = true;
        return r128.a();
    L55:
        if (r117.isEmpty() == true) goto L60;
        Iterator<String> r131 = this.f2620l.keySet().iterator();
    L58:
        if (r131.hasNext() == false) goto L60;
        String r132 = r131.next();
        r102.b(r132, this.f2620l.get(r132));
        goto L58
    L50:
        if (this.f2617i.c() == true) goto L52;
    L46:
        if ((System.currentTimeMillis() - this.f2618j) <= this.f2617i.a()) goto L48;
        this.f2619k = b();
        this.f2620l = s.a(r102.d(this.f2616h.getUrl()), this.f2617i.b());
        this.f2618j = System.currentTimeMillis();
        ALogger.i("TraceClientMonitor", "get CommonParams & Cookie Once");
        goto L48
    L15:
        if ("POST".equalsIgnoreCase(this.f2610b) == false) goto L17;
        r102.f2652b = HttpMethod.POST;
        goto L17
    L92:
        throw new IllegalArgumentException("Argument count (" + r101 + ") doesn't match expected count (" + r100.length + ")");
    L5:
        r101 = 0;
        goto L7
    }
}
