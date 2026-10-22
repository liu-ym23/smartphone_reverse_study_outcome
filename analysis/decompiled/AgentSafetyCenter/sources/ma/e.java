package ma;

import com.stepos.agentsafetycenter.AgentSafetyApplication;
import java.util.concurrent.ScheduledFuture;
import p5.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public AgentSafetyApplication f8539a;

    /* renamed from: b, reason: collision with root package name */
    public String f8540b;

    /* renamed from: c, reason: collision with root package name */
    public String f8541c;

    /* renamed from: d, reason: collision with root package name */
    public pa.c f8542d;

    /* renamed from: e, reason: collision with root package name */
    public a f8543e;

    /* renamed from: f, reason: collision with root package name */
    public m f8544f;

    /* renamed from: g, reason: collision with root package name */
    public ha.c f8545g;

    /* renamed from: h, reason: collision with root package name */
    public ScheduledFuture f8546h;
    public long i;

    public final qa.c a() {
        pa.c cVar = this.f8542d;
        if (cVar != null) {
            return cVar.f9934b;
        }
        ua.c.b("SDKInstanceImpl", "getSubject fail, tracker is null");
        return null;
    }
}
