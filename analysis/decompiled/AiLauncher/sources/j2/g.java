package j2;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import n2.InterfaceC4936a;

/* loaded from: classes2.dex */
public final class g implements g2.b<SchedulerConfig> {

    /* renamed from: a, reason: collision with root package name */
    public final X8.a<InterfaceC4936a> f34510a;

    public g(X8.a<InterfaceC4936a> aVar) {
        this.f34510a = aVar;
    }

    public static SchedulerConfig a(InterfaceC4936a interfaceC4936a) {
        return (SchedulerConfig) g2.d.c(f.a(interfaceC4936a), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static g b(X8.a<InterfaceC4936a> aVar) {
        return new g(aVar);
    }

    @Override // X8.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public SchedulerConfig get() {
        return a(this.f34510a.get());
    }
}
