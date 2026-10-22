package a8;

import android.net.Uri;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.bytedance.awemeopen.servicesapi.network.ByteNetEnvHeaderName;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.optimize.statistics.FrescoMonitorConst;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f2135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f2136b = null;

    public static final class a implements Interceptor {
        public a() {
        }

        @Override // com.bytedance.retrofit2.intercept.Interceptor
        public final SsResponse<?> intercept(Interceptor.Chain r210) {
            Intrinsics.checkNotNull(r210);
            Request r100 = r210.request();
            String r101 = b.f2135a;
            List<Header> r102 = r100.headers("x-tt-env");
            if (r102 == null) goto L12;
            Header r103 = (Header) CollectionsKt.getOrNull(r102, 0);
            if (r103 == null) goto L12;
            String r104 = r103.getValue();
            if (r104 == null) goto L12;
            if (StringsKt.isBlank(r104) == false) goto L11;
            r104 = b.f2135a;
        L11:
            if (r104 == null) goto L12;
        L13:
            Intrinsics.checkNotNullParameter(r104, "<set-?>");
            b.f2135a = r104;
            GeckoXAdapter.Companion r105 = GeckoXAdapter.Companion;
            Object r106 = null;
            if (r105.isCDNMultiVersionResource(r100.getUrl()) == false) goto L54;
            Request.Builder r107 = r100.newBuilder();
            Uri r108 = UriProtector.parse(r100.getUrl());
            String r110 = r108.getHost();
            if (r110 == null) goto L54;
            Uri.Builder r109 = r108.buildUpon();
            if (b.f2135a.length() <= 0) goto L21;
            boolean r111 = true;
        L23:
            if (r111 == true) goto L25;
        L41:
            String r112 = r110;
            boolean r113 = false;
        L42:
            Iterator<Map.Entry<String, String>> r114 = r105.getCDNMultiVersionCommonParams().entrySet().iterator();
        L44:
            if (r114.hasNext() == false) goto L48;
            Map.Entry<String, String> r115 = r114.next();
            if (UriProtector.getQueryParameter(r108, r115.getKey()) != null) goto L44;
            r109.appendQueryParameter(r115.getKey(), r115.getValue());
            goto L44
        L48:
            String r116 = StringsKt.replace$default(r109.toString(), r110, r112, false, 4, null);
            if (r113 == true) goto L51;
        L53:
            r107.url(r116);
            r100 = r107.build();
            goto L54
        L51:
            if (StringsKt.startsWith$default(r116, "https", false, 2, null) == false) goto L53;
            r116 = StringsKt.replaceFirst$default(r116, "https", "http", false, 4, null);
            goto L53
        L25:
            if (UriProtector.getQueryParameter(r108, "x-tt-env") != null) goto L28;
            r109.appendQueryParameter("x-tt-env", b.f2135a);
        L28:
            if (StringsKt.startsWith$default(b.f2135a, "ppe_", false, 2, null) == false) goto L33;
            if (UriProtector.getQueryParameter(r108, ByteNetEnvHeaderName.PPE) != null) goto L33;
            r109.appendQueryParameter(ByteNetEnvHeaderName.PPE, "1");
        L33:
            if (StringsKt.startsWith$default(b.f2135a, "boe_", false, 2, null) == false) goto L41;
            if (UriProtector.getQueryParameter(r108, ByteNetEnvHeaderName.BOE) != null) goto L41;
            r109.appendQueryParameter(ByteNetEnvHeaderName.BOE, "1");
            if (StringsKt.contains$default(r110, "boe", false, 2, null) == true) goto L39;
            String r117 = r110.concat(CJPayConstant.BOE_SUFFIX);
        L40:
            r112 = r117;
            r113 = true;
            goto L42
        L39:
            r117 = r110;
            goto L40
        L21:
            r111 = false;
        L54:
            SsResponse<?> r118 = r210.proceed(r100);
            Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L74
            if (r118 == null) goto L72;
            Response r120 = r118.raw();     // Catch: Throwable -> L74
            if (r120 == null) goto L72;
            Header r121 = r120.getFirstHeader("x-tt-env");     // Catch: Throwable -> L74
            if (r121 == null) goto L72;
            String r122 = r121.getValue();     // Catch: Throwable -> L74
            if (r122 == null) goto L72;
            if ((!StringsKt.isBlank(r122)) == false) goto L71;
            Header r123 = r120.getFirstHeader(FrescoMonitorConst.RESPONSE_HEADER_X_RESPONSE_CACHE);     // Catch: Throwable -> L74
            if (r123 == null) goto L69;
            r106 = r123.getValue();     // Catch: Throwable -> L74
        L69:
            if (Intrinsics.areEqual(r106, BaseHttpRequestInfo.KEY_HIT) == true) goto L71;
            String r124 = b.f2135a;     // Catch: Throwable -> L74
            Intrinsics.checkNotNullParameter(r122, "<set-?>");     // Catch: Throwable -> L74
            b.f2135a = r122;     // Catch: Throwable -> L74
        L71:
            r106 = Unit.INSTANCE;     // Catch: Throwable -> L74
        L72:
            Result.m9449constructorimpl(r106);     // Catch: Throwable -> L74
        L76:
            return r118;
        L74:
            th = move-exception;
            Result.Companion r125 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        L12:
            r104 = b.f2135a;
            goto L13
        }
    }

    static {
        f2135a = "";
        f2136b = new a();
    }
}
