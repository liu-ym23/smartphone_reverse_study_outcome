package com.stepos.alphame.utils.net;

import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import com.baidu.mapapi.http.wrapper.HttpManager;
import com.stepos.alphame.utils.net.AbstractHttpRequest;
import h3.C0600i;
import h3.C0611u;
import h3.H;
import h3.I;
import h3.InterfaceC0602k;
import h3.J;
import h3.M;
import h3.U;
import h3.V;
import h3.Z;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;

/* loaded from: classes.dex */
public class HttpRequest extends AbstractHttpRequest {
    public static final String DEL = "DEL";
    public static final String GET = "GET";
    public static final String POST = "POST";
    public static final String PUT = "PUT";
    InterfaceC0602k call;
    V request;

    public static class Builder extends AbstractHttpRequest.AbstractBuilder {
        String method = "GET";
        Z requestBody = null;
        U builder = new U();
        I urlBuilder = new I();

        @Override // com.stepos.alphame.utils.net.AbstractHttpRequest.AbstractBuilder
        public /* bridge */ /* synthetic */ AbstractHttpRequest.AbstractBuilder headers(Map map) {
            return headers((Map<String, String>) map);
        }

        @Override // com.stepos.alphame.utils.net.AbstractHttpRequest.AbstractBuilder
        public Builder url(String str) {
            J jN = null;
            try {
                char[] cArr = J.f12721k;
                Intrinsics.checkNotNullParameter(str, "<this>");
                jN = C0611u.n(str);
            } catch (IllegalArgumentException | StringIndexOutOfBoundsException unused) {
            }
            if (jN != null) {
                this.urlBuilder = jN.f();
            }
            return this;
        }

        @Override // com.stepos.alphame.utils.net.AbstractHttpRequest.AbstractBuilder
        public Builder addHeader(String str, String str2) {
            if (!TextUtils.isEmpty(str) && str2 != null) {
                this.builder.a(str, str2);
            }
            return this;
        }

        @Override // com.stepos.alphame.utils.net.AbstractHttpRequest.AbstractBuilder
        public HttpRequest build() {
            int i4 = 0;
            if (this.requestBody != null) {
                String str = this.method;
                str.getClass();
                switch (str) {
                    case "DEL":
                        this.builder.d(HttpManager.HTTP_DELETE, this.requestBody);
                        break;
                    case "GET":
                    case "POST":
                        U u4 = this.builder;
                        Z body = this.requestBody;
                        u4.getClass();
                        Intrinsics.checkNotNullParameter(body, "body");
                        u4.d("POST", body);
                        break;
                    case "PUT":
                        U u5 = this.builder;
                        Z body2 = this.requestBody;
                        u5.getClass();
                        Intrinsics.checkNotNullParameter(body2, "body");
                        u5.d("PUT", body2);
                        break;
                    default:
                        U u6 = this.builder;
                        Z body3 = this.requestBody;
                        u6.getClass();
                        Intrinsics.checkNotNullParameter(body3, "body");
                        u6.d("POST", body3);
                        break;
                }
            } else {
                String str2 = this.method;
                str2.getClass();
                if (str2.equals(HttpRequest.DEL)) {
                    U u7 = this.builder;
                    u7.getClass();
                    u7.d(HttpManager.HTTP_DELETE, Util.EMPTY_REQUEST);
                } else {
                    this.builder.d("GET", null);
                }
            }
            U u8 = this.builder;
            J url = this.urlBuilder.c();
            u8.getClass();
            Intrinsics.checkNotNullParameter(url, "url");
            u8.f12821a = url;
            return new HttpRequest(u8.b(), i4);
        }

        @Override // com.stepos.alphame.utils.net.AbstractHttpRequest.AbstractBuilder
        public Builder cacheAge(long j4) {
            if (j4 > 0) {
                int i4 = (int) j4;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
                if (i4 < 0) {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("maxAge < 0: ", Integer.valueOf(i4)).toString());
                }
                long seconds = timeUnit.toSeconds(i4);
                C0600i cacheControl = new C0600i(false, false, seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds, -1, false, false, false, -1, -1, false, false, false, null);
                U u4 = this.builder;
                u4.getClass();
                Intrinsics.checkNotNullParameter(cacheControl, "cacheControl");
                String string = cacheControl.toString();
                if (string.length() == 0) {
                    u4.e("Cache-Control");
                } else {
                    u4.c("Cache-Control", string);
                }
            }
            return this;
        }

        @Override // com.stepos.alphame.utils.net.AbstractHttpRequest.AbstractBuilder
        public Builder headers(Map<String, String> map) {
            if (map != null) {
                for (String str : map.keySet()) {
                    String str2 = map.get(str);
                    if (str2 != null) {
                        try {
                            this.builder.a(str, str2);
                        } catch (IllegalArgumentException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            }
            return this;
        }

        @Override // com.stepos.alphame.utils.net.AbstractHttpRequest.AbstractBuilder
        public Builder method(String str) {
            this.method = str;
            return this;
        }

        @Override // com.stepos.alphame.utils.net.AbstractHttpRequest.AbstractBuilder
        public Builder removeHeader(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.builder.e(str);
            }
            return this;
        }

        @Override // com.stepos.alphame.utils.net.AbstractHttpRequest.AbstractBuilder
        public Builder requestBody(HttpRequestBody httpRequestBody) {
            if (httpRequestBody == null) {
                return this;
            }
            int type = httpRequestBody.getType();
            if (type == 1) {
                String str = httpRequestBody.getContents().get("com.stepos.alphame.json");
                if (!TextUtils.isEmpty(str)) {
                    StringBuilder sb = new StringBuilder("application/json; charset=");
                    sb.append(TextUtils.isEmpty(httpRequestBody.getCharset()) ? "utf-8" : httpRequestBody.getCharset());
                    String string = sb.toString();
                    Pattern pattern = M.f12732d;
                    this.requestBody = Z.create(C0611u.t(string), str);
                }
            } else if (type == 2) {
                this.requestBody = RequestBodyUtils.getFormBody(httpRequestBody.getContents());
            }
            return this;
        }

        @Override // com.stepos.alphame.utils.net.AbstractHttpRequest.AbstractBuilder
        public Builder tag(Object obj) {
            this.builder.f(Object.class, obj);
            return this;
        }

        @Override // com.stepos.alphame.utils.net.AbstractHttpRequest.AbstractBuilder
        public Builder path(String str) {
            return path(str, false);
        }

        @Override // com.stepos.alphame.utils.net.AbstractHttpRequest.AbstractBuilder
        public Builder query(String str, String str2) {
            return query(str, str2, true);
        }

        @Override // com.stepos.alphame.utils.net.AbstractHttpRequest.AbstractBuilder
        public Builder path(String pathSegment, boolean z4) {
            if (z4) {
                I i4 = this.urlBuilder;
                i4.getClass();
                Intrinsics.checkNotNullParameter(pathSegment, "encodedPathSegment");
                i4.f(pathSegment, 0, pathSegment.length(), false, true);
            } else {
                I i5 = this.urlBuilder;
                i5.getClass();
                Intrinsics.checkNotNullParameter(pathSegment, "pathSegment");
                i5.f(pathSegment, 0, pathSegment.length(), false, false);
            }
            return this;
        }

        @Override // com.stepos.alphame.utils.net.AbstractHttpRequest.AbstractBuilder
        public Builder query(String str, String str2, boolean z4) {
            if (z4) {
                this.urlBuilder.a(str, str2);
            } else {
                this.urlBuilder.b(str, str2);
            }
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HttpMethod {
    }

    public /* synthetic */ HttpRequest(V v4, int i4) {
        this(v4);
    }

    @Override // com.stepos.alphame.utils.net.AbstractHttpRequest
    public long cacheAge() {
        return this.request.a().f12923c * 1000;
    }

    @Override // com.stepos.alphame.utils.net.AbstractHttpRequest
    public void cancel() {
        InterfaceC0602k interfaceC0602k = this.call;
        if (interfaceC0602k == null || interfaceC0602k.getCanceled()) {
            return;
        }
        this.call.cancel();
    }

    @Override // com.stepos.alphame.utils.net.AbstractHttpRequest
    public String getHeader(String str) {
        H h4;
        return (TextUtils.isEmpty(str) || (h4 = this.request.f12828c) == null) ? "" : h4.a(str);
    }

    @Override // com.stepos.alphame.utils.net.AbstractHttpRequest
    public Map<String, String> headers() {
        ArrayMap arrayMap = new ArrayMap();
        H h4 = this.request.f12828c;
        if (h4 != null) {
            h4.getClass();
            TreeSet treeSet = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
            int size = h4.size();
            for (int i4 = 0; i4 < size; i4++) {
                treeSet.add(h4.c(i4));
            }
            Set<String> setUnmodifiableSet = Collections.unmodifiableSet(treeSet);
            Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(result)");
            if (setUnmodifiableSet != null) {
                for (String str : setUnmodifiableSet) {
                    arrayMap.put(str, this.request.f12828c.a(str));
                }
            }
        }
        return arrayMap;
    }

    @Override // com.stepos.alphame.utils.net.AbstractHttpRequest
    public String method() {
        return this.request.f12827b;
    }

    @Override // com.stepos.alphame.utils.net.AbstractHttpRequest
    public Object tag() {
        return this.request.d(Object.class);
    }

    @Override // com.stepos.alphame.utils.net.AbstractHttpRequest
    public String url() {
        J j4 = this.request.f12826a;
        return j4 != null ? j4.f12730i : "";
    }

    private HttpRequest(@NonNull V v4) {
        this.request = v4;
    }
}
