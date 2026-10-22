package ara;

import com.bytedance.sdk.account.impl.d0;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@XBridgeMethod(name = "account.fetch")
public final class j extends bra.a {

    public static final class a {

        /* JADX INFO: renamed from: ara.j$a$a, reason: collision with other inner class name */
        public interface InterfaceC0214a {
            void a(xa7.c r100);
        }

        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f16052a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f16053b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f16054c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final String f16055d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final String f16056e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final long f16057f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final String f16058g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final HashMap<String, String> f16059h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final HashMap<String, String> f16060i;

            public final boolean equals(Object r100) {
                if (this != r100) goto L5;
            L29:
                return true;
            L5:
                if ((r100 instanceof b) == false) goto L28;
                b r101 = (b) r100;
                if (Intrinsics.areEqual(this.f16052a, r101.f16052a) == false) goto L28;
                if (Intrinsics.areEqual(this.f16053b, r101.f16053b) == false) goto L28;
                if (Intrinsics.areEqual(this.f16054c, r101.f16054c) == false) goto L28;
                if (Intrinsics.areEqual(this.f16055d, r101.f16055d) == false) goto L28;
                if (Intrinsics.areEqual(this.f16056e, r101.f16056e) == false) goto L28;
                if (this.f16057f != r101.f16057f) goto L19;
                boolean r102 = true;
            L20:
                if (r102 == false) goto L28;
                if (Intrinsics.areEqual(this.f16058g, r101.f16058g) == false) goto L28;
                if (Intrinsics.areEqual(this.f16059h, r101.f16059h) == false) goto L28;
                if (Intrinsics.areEqual(this.f16060i, r101.f16060i) == false) goto L28;
            L19:
                r102 = false;
            L28:
                return false;
            }

            public final int hashCode() {
                String r100 = this.f16052a;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                String r104 = this.f16053b;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                String r107 = this.f16054c;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                String r110 = this.f16055d;
                if (r110 == null) goto L17;
                int r111 = r110.hashCode();
            L18:
                int r112 = (r109 + r111) * 31;
                String r113 = this.f16056e;
                if (r113 == null) goto L21;
                int r114 = r113.hashCode();
            L22:
                int r115 = (r112 + r114) * 31;
                long r116 = this.f16057f;
                int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
                String r118 = this.f16058g;
                if (r118 == null) goto L25;
                int r119 = r118.hashCode();
            L26:
                int r120 = (r117 + r119) * 31;
                HashMap<String, String> r121 = this.f16059h;
                if (r121 == null) goto L29;
                int r122 = r121.hashCode();
            L30:
                int r123 = (r120 + r122) * 31;
                HashMap<String, String> r124 = this.f16060i;
                if (r124 == null) goto L34;
                r101 = r124.hashCode();
            L34:
                return r123 + r101;
            L29:
                r122 = 0;
                goto L30
            L25:
                r119 = 0;
                goto L26
            L21:
                r114 = 0;
                goto L22
            L17:
                r111 = 0;
                goto L18
            L13:
                r108 = 0;
                goto L14
            L9:
                r105 = 0;
                goto L10
            L5:
                r102 = 0;
                goto L6
            }

            public final String toString() {
                return "Params(url=" + this.f16052a + ", method=" + this.f16053b + ", callbackSchema=" + this.f16054c + ", path=" + this.f16055d + ", host=" + this.f16056e + ", startTime=" + this.f16057f + ", name=" + this.f16058g + ", headers=" + this.f16059h + ", requestParams=" + this.f16060i + ")";
            }

            public b(String r100, String r101, String r102, String r103, String r104, long r105, String r106, HashMap<String, String> r107, HashMap<String, String> r110) {
                this.f16052a = r100;
                this.f16053b = r101;
                this.f16054c = r102;
                this.f16055d = r103;
                this.f16056e = r104;
                this.f16057f = r105;
                this.f16058g = r106;
                this.f16059h = r107;
                this.f16060i = r110;
            }
        }
    }

    static {
    }

    public j() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r210, XBaseParamModel r211, CompletionBlock r212) {
        bra.a.InterfaceC0348a r100 = (bra.a.InterfaceC0348a) r211;
        long r101 = System.currentTimeMillis();
        String r102 = r100.getHost();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        String r104 = ta7.d.a(r100.getPath());
    L12:
        String r110 = r104;
        HashMap r111 = new HashMap();
        Map<String, Object> r105 = r100.getHeaders();
        if (r105 == null) goto L25;
        Iterator<Map.Entry<String, Object>> r106 = r105.entrySet().iterator();
    L16:
        if (r106.hasNext() == false) goto L25;
        Map.Entry<String, Object> r107 = r106.next();
        if (r107.getKey().length() <= 0) goto L20;
        boolean r108 = true;
    L21:
        if (r108 == false) goto L16;
        if (r107.getValue() == null) goto L16;
        r111.put(r107.getKey(), r107.getValue().toString());
        goto L16
    L20:
        r108 = false;
    L25:
        com.ss.android.account.k.b r109 = com.ss.android.account.k.f406317a;
        tb7.a.e("UcSdkFetchMethod", "jsbSafeHeaderHandler or safeHeader is null");
        String r112 = r100.getMethod();
        if (r112 == null) goto L30;
        String r113 = r112.toUpperCase(Locale.ROOT);
        if (r113 == null) goto L30;
        String r114 = r113;
    L31:
        int r115 = r114.hashCode();
        if (r115 == 70454) goto L51;
        if (r115 == 2461856) goto L36;
    L65:
        HashMap r116 = new HashMap();
    L66:
        HashMap r117 = r116;
        String r118 = r100.getCallbackSchema();
        if (r118 == null) goto L69;
        String r119 = r118;
    L70:
        String r120 = r114;
        k r121 = new k(new a.b(r110, r114, r119, r100.getPath(), r100.getHost(), r101, this.f20160a, r111, r117), new l(r212));
        int r122 = r120.hashCode();
        if (r122 == 70454) goto L79;
        if (r122 == 2461856) goto L76;
    L81:
        xa7.c r123 = new xa7.c(false);
        r123.f549255i = "error:unsupported method type";
        r123.f549256j = "error:unsupported method type";
        r121.a(r123);
        return;
    L76:
        if (r120.equals("POST") == false) goto L81;
        new rb7.c(((d0) d0.c()).f268981a, rb7.c.p(r110, r111, r117, false), r121).m();
        return;
    L79:
        if (r120.equals("GET") == false) goto L81;
        new rb7.c(((d0) d0.c()).f268981a, rb7.c.p(r110, r111, r117, true), r121).m();
        return;
    L69:
        r119 = "";
        goto L70
    L36:
        if (r114.equals("POST") == false) goto L65;
        r116 = new HashMap();
        Map<String, Object> r124 = r100.getData();
        if (r124 == null) goto L66;
        Iterator<Map.Entry<String, Object>> r125 = r124.entrySet().iterator();
    L41:
        if (r125.hasNext() == false) goto L66;
        Map.Entry<String, Object> r126 = r125.next();
        if (r126.getKey().length() <= 0) goto L45;
        boolean r127 = true;
    L46:
        if (r127 == false) goto L41;
        if (r126.getValue() == null) goto L41;
        r116.put(r126.getKey(), r126.getValue().toString());
        goto L41
    L45:
        r127 = false;
        goto L46
    L51:
        if (r114.equals("GET") == false) goto L65;
        r116 = new HashMap();
        Map<String, Object> r128 = r100.getParams();
        if (r128 == null) goto L66;
        Iterator<Map.Entry<String, Object>> r129 = r128.entrySet().iterator();
    L56:
        if (r129.hasNext() == false) goto L66;
        Map.Entry<String, Object> r130 = r129.next();
        if (r130.getKey().length() <= 0) goto L60;
        boolean r131 = true;
    L61:
        if (r131 == false) goto L56;
        if (r130.getValue() == null) goto L56;
        r116.put(r130.getKey(), r130.getValue().toString());
        goto L56
    L60:
        r131 = false;
    L30:
        r114 = "";
        goto L31
    L11:
        r104 = "https://" + r100.getHost() + r100.getPath();
        goto L12
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
