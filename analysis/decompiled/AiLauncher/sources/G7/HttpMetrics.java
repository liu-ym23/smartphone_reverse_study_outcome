package G7;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\u001f\u001a\u0004\b\"\u0010\u0018R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\"\u0010(\u001a\u0004\b#\u0010*R\u0017\u0010\n\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b+\u0010(\u001a\u0004\b\u001e\u0010*R\u0017\u0010\u000b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b,\u0010(\u001a\u0004\b-\u0010*R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b.\u0010(\u001a\u0004\b+\u0010*R\u0017\u0010\r\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b/\u0010(\u001a\u0004\b.\u0010*R\u0017\u0010\u000e\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b%\u0010(\u001a\u0004\b,\u0010*R\u0017\u0010\u000f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b/\u0010*R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b)\u00100\u001a\u0004\b!\u00101R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b'\u00104R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u001f\u001a\u0004\b2\u0010\u0018R\u0011\u00106\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b5\u00101¨\u00067"}, d2 = {"LG7/c;", "", "", "url", "method", "", "statusCode", "", "totalDurationMs", "dnsDurationMs", "connectDurationMs", "tlsDurationMs", "requestDurationMs", "responseDurationMs", "requestSize", "responseSize", "", "connectionReused", "", "error", DidiCardProvider.KEY_TRACE_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;JJJJJJJJZLjava/lang/Throwable;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "n", Const.INTENT_KEY_PKGNAME, "e", "c", "Ljava/lang/Integer;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljava/lang/Integer;", Const.INTENT_KEY_UMID, "J", "l", "()J", "f", Const.INTENT_KEY_BACKGROUND_COMMAND, "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Z", "()Z", "m", "Ljava/lang/Throwable;", "()Ljava/lang/Throwable;", "o", "isSuccess", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: G7.c, reason: from toString */
/* loaded from: classes.dex */
public final /* data */ class HttpMetrics {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String method;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final Integer statusCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final long totalDurationMs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final long dnsDurationMs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final long connectDurationMs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final long tlsDurationMs;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final long requestDurationMs;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    public final long responseDurationMs;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    public final long requestSize;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    public final long responseSize;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean connectionReused;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    public final Throwable error;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    public final String traceId;

    public HttpMetrics(String url, String method, Integer num, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, boolean z10, Throwable th, String str) {
        p.i(url, "url");
        p.i(method, "method");
        this.url = url;
        this.method = method;
        this.statusCode = num;
        this.totalDurationMs = j10;
        this.dnsDurationMs = j11;
        this.connectDurationMs = j12;
        this.tlsDurationMs = j13;
        this.requestDurationMs = j14;
        this.responseDurationMs = j15;
        this.requestSize = j16;
        this.responseSize = j17;
        this.connectionReused = z10;
        this.error = th;
        this.traceId = str;
    }

    /* renamed from: a, reason: from getter */
    public final long getConnectDurationMs() {
        return this.connectDurationMs;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getConnectionReused() {
        return this.connectionReused;
    }

    /* renamed from: c, reason: from getter */
    public final long getDnsDurationMs() {
        return this.dnsDurationMs;
    }

    /* renamed from: d, reason: from getter */
    public final Throwable getError() {
        return this.error;
    }

    /* renamed from: e, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HttpMetrics)) {
            return false;
        }
        HttpMetrics httpMetrics = (HttpMetrics) other;
        return p.d(this.url, httpMetrics.url) && p.d(this.method, httpMetrics.method) && p.d(this.statusCode, httpMetrics.statusCode) && this.totalDurationMs == httpMetrics.totalDurationMs && this.dnsDurationMs == httpMetrics.dnsDurationMs && this.connectDurationMs == httpMetrics.connectDurationMs && this.tlsDurationMs == httpMetrics.tlsDurationMs && this.requestDurationMs == httpMetrics.requestDurationMs && this.responseDurationMs == httpMetrics.responseDurationMs && this.requestSize == httpMetrics.requestSize && this.responseSize == httpMetrics.responseSize && this.connectionReused == httpMetrics.connectionReused && p.d(this.error, httpMetrics.error) && p.d(this.traceId, httpMetrics.traceId);
    }

    /* renamed from: f, reason: from getter */
    public final long getRequestDurationMs() {
        return this.requestDurationMs;
    }

    /* renamed from: g, reason: from getter */
    public final long getRequestSize() {
        return this.requestSize;
    }

    /* renamed from: h, reason: from getter */
    public final long getResponseDurationMs() {
        return this.responseDurationMs;
    }

    public int hashCode() {
        int iHashCode = ((this.url.hashCode() * 31) + this.method.hashCode()) * 31;
        Integer num = this.statusCode;
        int iHashCode2 = (((((((((((((((((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Long.hashCode(this.totalDurationMs)) * 31) + Long.hashCode(this.dnsDurationMs)) * 31) + Long.hashCode(this.connectDurationMs)) * 31) + Long.hashCode(this.tlsDurationMs)) * 31) + Long.hashCode(this.requestDurationMs)) * 31) + Long.hashCode(this.responseDurationMs)) * 31) + Long.hashCode(this.requestSize)) * 31) + Long.hashCode(this.responseSize)) * 31) + Boolean.hashCode(this.connectionReused)) * 31;
        Throwable th = this.error;
        int iHashCode3 = (iHashCode2 + (th == null ? 0 : th.hashCode())) * 31;
        String str = this.traceId;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final long getResponseSize() {
        return this.responseSize;
    }

    /* renamed from: j, reason: from getter */
    public final Integer getStatusCode() {
        return this.statusCode;
    }

    /* renamed from: k, reason: from getter */
    public final long getTlsDurationMs() {
        return this.tlsDurationMs;
    }

    /* renamed from: l, reason: from getter */
    public final long getTotalDurationMs() {
        return this.totalDurationMs;
    }

    /* renamed from: m, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: n, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final boolean o() {
        if (this.error == null) {
            Integer num = this.statusCode;
            int iIntValue = num != null ? num.intValue() : 0;
            if (200 <= iIntValue && iIntValue < 300) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "HttpMetrics(url=" + this.url + ", method=" + this.method + ", statusCode=" + this.statusCode + ", totalDurationMs=" + this.totalDurationMs + ", dnsDurationMs=" + this.dnsDurationMs + ", connectDurationMs=" + this.connectDurationMs + ", tlsDurationMs=" + this.tlsDurationMs + ", requestDurationMs=" + this.requestDurationMs + ", responseDurationMs=" + this.responseDurationMs + ", requestSize=" + this.requestSize + ", responseSize=" + this.responseSize + ", connectionReused=" + this.connectionReused + ", error=" + this.error + ", traceId=" + this.traceId + ")";
    }
}
