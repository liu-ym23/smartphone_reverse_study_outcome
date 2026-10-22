package m8;

import com.stepos.core.ota.confirm.InteractiveSessionRegistry;
import com.stepos.core.ota.download.control.HysteresisStrategy;
import h0.e;
import java.util.List;
import kotlin.collections.EmptyList;
import o8.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f10520a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10521b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10522c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10523d;

    /* renamed from: e, reason: collision with root package name */
    public final String f10524e;

    /* renamed from: f, reason: collision with root package name */
    public final String f10525f;

    /* renamed from: g, reason: collision with root package name */
    public final String f10526g;
    public final List<g> h;

    /* renamed from: i, reason: collision with root package name */
    public final int f10527i;

    /* renamed from: j, reason: collision with root package name */
    public final int f10528j;

    /* renamed from: k, reason: collision with root package name */
    public final long f10529k;

    /* renamed from: l, reason: collision with root package name */
    public final long f10530l;

    /* renamed from: m, reason: collision with root package name */
    public final long f10531m;

    /* renamed from: n, reason: collision with root package name */
    public final long f10532n;

    public b(String appId, String appSecret, String defaultBizCode, String gatewayBaseUrl, String defaultSourceType) {
        EmptyList defaultBindings = EmptyList.f10001a;
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(appSecret, "appSecret");
        kotlin.jvm.internal.g.f(defaultBizCode, "defaultBizCode");
        kotlin.jvm.internal.g.f(gatewayBaseUrl, "gatewayBaseUrl");
        kotlin.jvm.internal.g.f(defaultSourceType, "defaultSourceType");
        kotlin.jvm.internal.g.f(defaultBindings, "defaultBindings");
        this.f10520a = appId;
        this.f10521b = appSecret;
        this.f10522c = defaultBizCode;
        this.f10523d = gatewayBaseUrl;
        this.f10524e = "file-storage";
        this.f10525f = "Android";
        this.f10526g = defaultSourceType;
        this.h = defaultBindings;
        this.f10527i = 5;
        this.f10528j = 3;
        this.f10529k = 800L;
        this.f10530l = 15000L;
        this.f10531m = HysteresisStrategy.DEFAULT_DWELL_MS;
        this.f10532n = InteractiveSessionRegistry.DEFAULT_TTL_MS;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return kotlin.jvm.internal.g.b(this.f10520a, bVar.f10520a) && kotlin.jvm.internal.g.b(this.f10521b, bVar.f10521b) && kotlin.jvm.internal.g.b(this.f10522c, bVar.f10522c) && kotlin.jvm.internal.g.b(this.f10523d, bVar.f10523d) && kotlin.jvm.internal.g.b(this.f10524e, bVar.f10524e) && kotlin.jvm.internal.g.b(this.f10525f, bVar.f10525f) && kotlin.jvm.internal.g.b(this.f10526g, bVar.f10526g) && kotlin.jvm.internal.g.b(this.h, bVar.h) && this.f10527i == bVar.f10527i && this.f10528j == bVar.f10528j && this.f10529k == bVar.f10529k && this.f10530l == bVar.f10530l && this.f10531m == bVar.f10531m && this.f10532n == bVar.f10532n;
    }

    public final int hashCode() {
        return Long.hashCode(this.f10532n) + a0.a.c(a0.a.c(a0.a.c(ai.onnxruntime.a.d(this.f10528j, ai.onnxruntime.a.d(this.f10527i, e.b(this.h, d.a(d.a(d.a(d.a(d.a(d.a(this.f10520a.hashCode() * 31, 31, this.f10521b), 31, this.f10522c), 31, this.f10523d), 31, this.f10524e), 31, this.f10525f), 31, this.f10526g), 31), 31), 31), this.f10529k, 31), this.f10530l, 31), this.f10531m, 31);
    }

    public final String toString() {
        StringBuilder sbS = ai.onnxruntime.a.s("FileStorageConfig(appId=", this.f10520a, ", appSecret=", this.f10521b, ", defaultBizCode=");
        ai.onnxruntime.a.z(sbS, this.f10522c, ", gatewayBaseUrl=", this.f10523d, ", serviceName=");
        ai.onnxruntime.a.z(sbS, this.f10524e, ", clientType=", this.f10525f, ", defaultSourceType=");
        sbS.append(this.f10526g);
        sbS.append(", defaultBindings=");
        sbS.append(this.h);
        sbS.append(", concurrency=");
        e.l(sbS, this.f10527i, ", maxRetry=", this.f10528j, ", retryBackoffMs=");
        sbS.append(this.f10529k);
        a0.a.s(this.f10530l, ", connectTimeoutMs=", ", readTimeoutMs=", sbS);
        sbS.append(this.f10531m);
        return a0.a.d(this.f10532n, ", tosPutTimeoutMs=", ")", sbS);
    }
}
