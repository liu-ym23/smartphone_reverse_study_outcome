package j2;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import k2.o;
import l2.InterfaceC4863c;
import n2.InterfaceC4936a;

/* loaded from: classes2.dex */
public final class i implements g2.b<o> {

    /* renamed from: a, reason: collision with root package name */
    public final X8.a<Context> f34511a;

    /* renamed from: b, reason: collision with root package name */
    public final X8.a<InterfaceC4863c> f34512b;

    /* renamed from: c, reason: collision with root package name */
    public final X8.a<SchedulerConfig> f34513c;

    /* renamed from: d, reason: collision with root package name */
    public final X8.a<InterfaceC4936a> f34514d;

    public i(X8.a<Context> aVar, X8.a<InterfaceC4863c> aVar2, X8.a<SchedulerConfig> aVar3, X8.a<InterfaceC4936a> aVar4) {
        this.f34511a = aVar;
        this.f34512b = aVar2;
        this.f34513c = aVar3;
        this.f34514d = aVar4;
    }

    public static i a(X8.a<Context> aVar, X8.a<InterfaceC4863c> aVar2, X8.a<SchedulerConfig> aVar3, X8.a<InterfaceC4936a> aVar4) {
        return new i(aVar, aVar2, aVar3, aVar4);
    }

    public static o c(Context context, InterfaceC4863c interfaceC4863c, SchedulerConfig schedulerConfig, InterfaceC4936a interfaceC4936a) {
        return (o) g2.d.c(h.a(context, interfaceC4863c, schedulerConfig, interfaceC4936a), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // X8.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o get() {
        return c(this.f34511a.get(), this.f34512b.get(), this.f34513c.get(), this.f34514d.get());
    }
}
