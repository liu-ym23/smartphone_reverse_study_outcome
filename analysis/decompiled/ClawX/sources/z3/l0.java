package z3;

import java.io.IOException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l0 extends IOException implements a6.x {

    /* renamed from: a, reason: collision with root package name */
    public final String f6474a;

    /* renamed from: b, reason: collision with root package name */
    public final Long f6475b;

    public l0(String url, Long l3, Throwable th) {
        kotlin.jvm.internal.p.e(url, "url");
        StringBuilder sb = new StringBuilder("Request timeout has expired [url=");
        sb.append(url);
        sb.append(", request_timeout=");
        sb.append(l3 == null ? "unknown" : l3);
        sb.append(" ms]");
        super(sb.toString(), th);
        this.f6474a = url;
        this.f6475b = l3;
    }

    @Override // a6.x
    public final Throwable a() {
        return new l0(this.f6474a, this.f6475b, getCause());
    }
}
