package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DurationUnit {

    /* renamed from: b, reason: collision with root package name */
    public static final DurationUnit f10099b;

    /* renamed from: c, reason: collision with root package name */
    public static final DurationUnit f10100c;

    /* renamed from: d, reason: collision with root package name */
    public static final DurationUnit f10101d;

    /* renamed from: e, reason: collision with root package name */
    public static final DurationUnit f10102e;
    public static final DurationUnit h;

    /* renamed from: j, reason: collision with root package name */
    public static final DurationUnit f10103j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ DurationUnit[] f10104k;

    /* renamed from: a, reason: collision with root package name */
    public final TimeUnit f10105a;

    static {
        DurationUnit durationUnit = new DurationUnit("NANOSECONDS", 0, TimeUnit.NANOSECONDS);
        f10099b = durationUnit;
        DurationUnit durationUnit2 = new DurationUnit("MICROSECONDS", 1, TimeUnit.MICROSECONDS);
        DurationUnit durationUnit3 = new DurationUnit("MILLISECONDS", 2, TimeUnit.MILLISECONDS);
        f10100c = durationUnit3;
        DurationUnit durationUnit4 = new DurationUnit("SECONDS", 3, TimeUnit.SECONDS);
        f10101d = durationUnit4;
        DurationUnit durationUnit5 = new DurationUnit("MINUTES", 4, TimeUnit.MINUTES);
        f10102e = durationUnit5;
        DurationUnit durationUnit6 = new DurationUnit("HOURS", 5, TimeUnit.HOURS);
        h = durationUnit6;
        DurationUnit durationUnit7 = new DurationUnit("DAYS", 6, TimeUnit.DAYS);
        f10103j = durationUnit7;
        DurationUnit[] durationUnitArr = {durationUnit, durationUnit2, durationUnit3, durationUnit4, durationUnit5, durationUnit6, durationUnit7};
        f10104k = durationUnitArr;
        a.a(durationUnitArr);
    }

    public DurationUnit(String str, int i10, TimeUnit timeUnit) {
        this.f10105a = timeUnit;
    }

    public static DurationUnit valueOf(String str) {
        return (DurationUnit) Enum.valueOf(DurationUnit.class, str);
    }

    public static DurationUnit[] values() {
        return (DurationUnit[]) f10104k.clone();
    }
}
