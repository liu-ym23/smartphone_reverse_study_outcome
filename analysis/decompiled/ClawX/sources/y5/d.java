package y5;

import java.util.concurrent.TimeUnit;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public static final d f6340b;

    /* renamed from: c, reason: collision with root package name */
    public static final d f6341c;
    public static final d d;

    /* renamed from: e, reason: collision with root package name */
    public static final d f6342e;

    /* renamed from: f, reason: collision with root package name */
    public static final d f6343f;

    /* renamed from: g, reason: collision with root package name */
    public static final d f6344g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ d[] f6345h;

    /* renamed from: a, reason: collision with root package name */
    public final TimeUnit f6346a;

    static {
        d dVar = new d("NANOSECONDS", 0, TimeUnit.NANOSECONDS);
        f6340b = dVar;
        d dVar2 = new d("MICROSECONDS", 1, TimeUnit.MICROSECONDS);
        d dVar3 = new d("MILLISECONDS", 2, TimeUnit.MILLISECONDS);
        f6341c = dVar3;
        d dVar4 = new d("SECONDS", 3, TimeUnit.SECONDS);
        d = dVar4;
        d dVar5 = new d("MINUTES", 4, TimeUnit.MINUTES);
        f6342e = dVar5;
        d dVar6 = new d("HOURS", 5, TimeUnit.HOURS);
        f6343f = dVar6;
        d dVar7 = new d("DAYS", 6, TimeUnit.DAYS);
        f6344g = dVar7;
        d[] dVarArr = {dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7};
        f6345h = dVarArr;
        a.a.F(dVarArr);
    }

    public d(String str, int i8, TimeUnit timeUnit) {
        this.f6346a = timeUnit;
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f6345h.clone();
    }
}
