package ic;

import java.util.concurrent.TimeUnit;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: f, reason: collision with root package name */
    public static final c f5941f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f5942g;

    /* renamed from: h, reason: collision with root package name */
    public static final c f5943h;
    public static final /* synthetic */ c[] i;

    /* renamed from: c, reason: collision with root package name */
    public final TimeUnit f5944c;

    static {
        c cVar = new c("NANOSECONDS", 0, TimeUnit.NANOSECONDS);
        f5941f = cVar;
        c cVar2 = new c("MICROSECONDS", 1, TimeUnit.MICROSECONDS);
        c cVar3 = new c("MILLISECONDS", 2, TimeUnit.MILLISECONDS);
        f5942g = cVar3;
        c cVar4 = new c("SECONDS", 3, TimeUnit.SECONDS);
        f5943h = cVar4;
        c[] cVarArr = {cVar, cVar2, cVar3, cVar4, new c("MINUTES", 4, TimeUnit.MINUTES), new c("HOURS", 5, TimeUnit.HOURS), new c("DAYS", 6, TimeUnit.DAYS)};
        i = cVarArr;
        a.a.p(cVarArr);
    }

    public c(String str, int i3, TimeUnit timeUnit) {
        this.f5944c = timeUnit;
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) i.clone();
    }
}
