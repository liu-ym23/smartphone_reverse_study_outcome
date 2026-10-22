package ha;

import java.util.concurrent.TimeUnit;
import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: g, reason: collision with root package name */
    public static final c f4251g;

    /* renamed from: h, reason: collision with root package name */
    public static final c f4252h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ c[] f4253i;

    /* renamed from: f, reason: collision with root package name */
    public final TimeUnit f4254f;

    static {
        c cVar = new c("NANOSECONDS", 0, TimeUnit.NANOSECONDS);
        f4251g = cVar;
        c cVar2 = new c("MICROSECONDS", 1, TimeUnit.MICROSECONDS);
        c cVar3 = new c("MILLISECONDS", 2, TimeUnit.MILLISECONDS);
        f4252h = cVar3;
        c[] cVarArr = {cVar, cVar2, cVar3, new c("SECONDS", 3, TimeUnit.SECONDS), new c("MINUTES", 4, TimeUnit.MINUTES), new c("HOURS", 5, TimeUnit.HOURS), new c("DAYS", 6, TimeUnit.DAYS)};
        f4253i = cVarArr;
        e0.s(cVarArr);
    }

    public c(String str, int i2, TimeUnit timeUnit) {
        this.f4254f = timeUnit;
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f4253i.clone();
    }
}
