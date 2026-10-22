package s9;

import a4.u;
import android.util.Log;
import androidx.lifecycle.p0;
import androidx.lifecycle.r0;
import c7.j;
import com.google.protobuf.a1;
import com.google.protobuf.x0;
import com.stepos.account.oauth.OAuthConstants;
import com.stepos.agentcache.core.ServiceContract;
import com.stepos.agentcache.sdk.api.AgentCacheSdk;
import com.stepos.agentcache.sdk.api.LogLevel;
import com.stepos.agentcache.sdk.api.LogMessage;
import d7.e0;
import g7.k;
import h4.o;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyFactory;
import java.security.Provider;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import z5.e;
import z5.h;

/* loaded from: classes.dex */
public class d implements r0, e, b6.a, f3.e, k, o {

    /* renamed from: g, reason: collision with root package name */
    public static d f9628g;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f9629f;

    public /* synthetic */ d(int i2) {
        this.f9629f = i2;
    }

    public static final float i(float f10, float[] fArr, float[] fArr2) {
        float f11;
        float f12;
        float f13;
        float f14;
        float fAbs = Math.abs(f10);
        float fSignum = Math.signum(f10);
        int iBinarySearch = Arrays.binarySearch(fArr, fAbs);
        if (iBinarySearch >= 0) {
            return fSignum * fArr2[iBinarySearch];
        }
        int i2 = -(iBinarySearch + 1);
        int i10 = i2 - 1;
        if (i10 >= fArr.length - 1) {
            float f15 = fArr[fArr.length - 1];
            float f16 = fArr2[fArr.length - 1];
            if (f15 == 0.0f) {
                return 0.0f;
            }
            return (f16 / f15) * f10;
        }
        if (i10 == -1) {
            float f17 = fArr[0];
            f13 = fArr2[0];
            f14 = f17;
            f12 = 0.0f;
            f11 = 0.0f;
        } else {
            float f18 = fArr[i10];
            float f19 = fArr[i2];
            f11 = fArr2[i10];
            f12 = f18;
            f13 = fArr2[i2];
            f14 = f19;
        }
        return (((f13 - f11) * Math.max(0.0f, Math.min(1.0f, f12 == f14 ? 0.0f : (fAbs - f12) / (f14 - f12)))) + f11) * fSignum;
    }

    public static InputStream j(String str) throws IOException {
        q7.k.e(str, "path");
        ClassLoader classLoader = d.class.getClassLoader();
        if (classLoader == null) {
            return ClassLoader.getSystemResourceAsStream(str);
        }
        URL resource = classLoader.getResource(str);
        if (resource == null) {
            return null;
        }
        URLConnection uRLConnectionOpenConnection = resource.openConnection();
        uRLConnectionOpenConnection.setUseCaches(false);
        return uRLConnectionOpenConnection.getInputStream();
    }

    private final void k() {
    }

    private final void l(int i2, Object obj) {
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static d8.d m(java.lang.String r7, e9.c r8) {
        /*
            java.lang.String r0 = "packageFqName"
            q7.k.e(r8, r0)
            d8.e[] r0 = d8.e.values()
            int r1 = r0.length
            r2 = 0
            r3 = r2
        Lc:
            r4 = 0
            if (r3 >= r1) goto L25
            r5 = r0[r3]
            e9.c r6 = r5.f2999f
            boolean r6 = q7.k.a(r6, r8)
            if (r6 == 0) goto L22
            java.lang.String r6 = r5.f3000g
            boolean r6 = ga.r.g0(r7, r6, r2)
            if (r6 == 0) goto L22
            goto L26
        L22:
            int r3 = r3 + 1
            goto Lc
        L25:
            r5 = r4
        L26:
            if (r5 != 0) goto L29
            goto L69
        L29:
            java.lang.String r8 = r5.f3000g
            int r8 = r8.length()
            java.lang.String r7 = r7.substring(r8)
            java.lang.String r8 = "this as java.lang.String).substring(startIndex)"
            q7.k.d(r7, r8)
            int r8 = r7.length()
            if (r8 != 0) goto L40
        L3e:
            r7 = r4
            goto L5d
        L40:
            int r8 = r7.length()
            r0 = r2
        L45:
            if (r2 >= r8) goto L59
            char r1 = r7.charAt(r2)
            int r1 = r1 + (-48)
            if (r1 < 0) goto L3e
            r3 = 10
            if (r1 >= r3) goto L3e
            int r0 = r0 * 10
            int r0 = r0 + r1
            int r2 = r2 + 1
            goto L45
        L59:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
        L5d:
            if (r7 == 0) goto L69
            int r7 = r7.intValue()
            d8.d r8 = new d8.d
            r8.<init>(r5, r7)
            return r8
        L69:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.d.m(java.lang.String, e9.c):d8.d");
    }

    public static c5.b n(String str, String str2, String str3, boolean z4, Long l6, Map map, int i2) {
        if ((i2 & 8) != 0) {
            z4 = false;
        }
        if ((i2 & 16) != 0) {
            l6 = null;
        }
        if ((i2 & 32) != 0) {
            map = null;
        }
        q7.k.e(str, "id");
        q7.k.e(str2, "code");
        q7.k.e(str3, OAuthConstants.FACTOR_RESULT_MESSAGE);
        LinkedHashMap linkedHashMapV = e0.V(new j("code", str2), new j(OAuthConstants.FACTOR_RESULT_MESSAGE, str3), new j("retryable", Boolean.valueOf(z4)));
        if (l6 != null) {
            linkedHashMapV.put("retryAfterMs", l6);
        }
        if (map != null) {
            linkedHashMapV.put("details", map);
        }
        return new c5.b("res", e0.U(new j("type", "res"), new j("id", str), new j("ok", Boolean.FALSE), new j("error", linkedHashMapV)));
    }

    public static c5.b o(String str, Map map) {
        q7.k.e(str, "id");
        return new c5.b("res", e0.U(new j("type", "res"), new j("id", str), new j("ok", Boolean.TRUE), new j("payload", map)));
    }

    public static c5.b p(String str, Map map) {
        q7.k.e(str, "eventName");
        q7.k.e(map, "payload");
        String strH = a1.a.h("evt-", System.nanoTime());
        Map mapU = e0.U(new j("event", str), new j("payload", map));
        q7.k.e(strH, "id");
        return new c5.b("req", e0.U(new j("type", "req"), new j("id", strH), new j("method", "node.event"), new j("params", mapU)));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static c5.e q(c5.b bVar) {
        String str = bVar.f1896a;
        switch (str.hashCode()) {
            case -2145216179:
                if (str.equals("hello-error")) {
                    return null;
                }
                break;
            case -792718153:
                if (str.equals("hello-ok")) {
                    return null;
                }
                break;
            case 112798:
                if (str.equals("req")) {
                    String strB = bVar.b();
                    if (strB == null || ga.k.t0(strB)) {
                        return new c5.e("req missing id");
                    }
                    String strD = bVar.d();
                    if (strD == null || ga.k.t0(strD)) {
                        return new c5.e("req missing method");
                    }
                    return null;
                }
                break;
            case 112800:
                if (str.equals("res")) {
                    String strB2 = bVar.b();
                    if (strB2 == null || ga.k.t0(strB2)) {
                        return new c5.e("res missing id");
                    }
                    if (bVar.f() == null) {
                        return new c5.e("res missing ok");
                    }
                    return null;
                }
                break;
            case 3559837:
                if (str.equals("tick")) {
                    return null;
                }
                break;
            case 96891546:
                if (str.equals("event")) {
                    String strA = bVar.a();
                    if (strA == null || ga.k.t0(strA)) {
                        return new c5.e("event missing event name");
                    }
                    return null;
                }
                break;
            case 530405532:
                if (str.equals("disconnect")) {
                    return null;
                }
                break;
        }
        return new c5.e("unknown frame type: ".concat(str));
    }

    @Override // b6.a
    public void a() {
    }

    @Override // androidx.lifecycle.r0
    public p0 b(Class cls) {
        return w7.e0.p(cls);
    }

    @Override // h4.o
    public Object c(String str, Provider provider) {
        switch (this.f9629f) {
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                return provider == null ? Cipher.getInstance(str) : Cipher.getInstance(str, provider);
            case 28:
                return provider == null ? KeyAgreement.getInstance(str) : KeyAgreement.getInstance(str, provider);
            default:
                return provider == null ? KeyFactory.getInstance(str) : KeyFactory.getInstance(str, provider);
        }
    }

    @Override // f3.e
    public void d() {
        switch (this.f9629f) {
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                break;
            default:
                Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
                break;
        }
    }

    @Override // z5.e
    public void e(String str, String str2, h hVar, String str3, String str4, String str5, int i2) {
        LogLevel logLevel;
        q7.k.e(str, ServiceContract.RequiredKeys.TRACE_ID);
        q7.k.e(str2, ServiceContract.RequiredKeys.NODE_NAME);
        q7.k.e(hVar, "level");
        q7.k.e(str3, "event");
        q7.k.e(str4, "log");
        AgentCacheSdk agentCacheSdk = AgentCacheSdk.INSTANCE;
        if (agentCacheSdk.isInitialized()) {
            int i10 = b5.a.$EnumSwitchMapping$0[hVar.ordinal()];
            if (i10 == 1) {
                logLevel = LogLevel.INFO;
            } else if (i10 == 2) {
                logLevel = LogLevel.WARN;
            } else {
                if (i10 != 3) {
                    throw new u();
                }
                logLevel = LogLevel.ERROR;
            }
            agentCacheSdk.reportLog(str, str2, new LogMessage(logLevel, str3, str4, str5), i2);
        }
    }

    @Override // b6.a
    public Object f(c5.b bVar, g7.d dVar) {
        String strB = bVar.b();
        if (strB == null) {
            strB = "";
        }
        return n(strB, "STEPCLAW_UNSUPPORTED_OPERATION", "task not supported on current backend", false, null, null, 56);
    }

    @Override // f3.e
    public void g(int i2, Object obj) {
        String str;
        switch (this.f9629f) {
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                break;
            default:
                switch (i2) {
                    case 1:
                        str = "RESULT_INSTALL_SUCCESS";
                        break;
                    case 2:
                        str = "RESULT_ALREADY_INSTALLED";
                        break;
                    case 3:
                        str = "RESULT_UNSUPPORTED_ART_VERSION";
                        break;
                    case 4:
                        str = "RESULT_NOT_WRITABLE";
                        break;
                    case 5:
                        str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                        break;
                    case 6:
                        str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                        break;
                    case 7:
                        str = "RESULT_IO_EXCEPTION";
                        break;
                    case 8:
                        str = "RESULT_PARSE_EXCEPTION";
                        break;
                    case 9:
                    default:
                        str = "";
                        break;
                    case 10:
                        str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                        break;
                    case 11:
                        str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                        break;
                }
                if (i2 != 6 && i2 != 7 && i2 != 8) {
                    Log.d("ProfileInstaller", str);
                    break;
                } else {
                    Log.e("ProfileInstaller", str, (Throwable) obj);
                    break;
                }
                break;
        }
    }

    @Override // z5.e
    public void h(String str, String str2, Map map, Map map2, String str3, String str4, int i2) {
        q7.k.e(str, ServiceContract.RequiredKeys.TRACE_ID);
        q7.k.e(str2, ServiceContract.RequiredKeys.NODE_NAME);
        q7.k.e(map, "commonFields");
        q7.k.e(map2, "bizData");
        q7.k.e(str3, "inputText");
        q7.k.e(str4, "outputText");
        AgentCacheSdk agentCacheSdk = AgentCacheSdk.INSTANCE;
        if (agentCacheSdk.isInitialized()) {
            agentCacheSdk.reportEvent(str, str2, map, map2, str3, str4, i2);
        }
    }

    @Override // b6.a
    public void start() {
    }
}
