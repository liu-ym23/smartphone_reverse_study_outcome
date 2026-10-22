package kotlin.coroutines.intrinsics;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CoroutineSingletons {

    /* renamed from: a, reason: collision with root package name */
    public static final CoroutineSingletons f10059a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ CoroutineSingletons[] f10060b;

    static {
        CoroutineSingletons coroutineSingletons = new CoroutineSingletons("COROUTINE_SUSPENDED", 0);
        f10059a = coroutineSingletons;
        CoroutineSingletons[] coroutineSingletonsArr = {coroutineSingletons, new CoroutineSingletons("UNDECIDED", 1), new CoroutineSingletons("RESUMED", 2)};
        f10060b = coroutineSingletonsArr;
        a.a(coroutineSingletonsArr);
    }

    public CoroutineSingletons() {
        throw null;
    }

    public static CoroutineSingletons valueOf(String str) {
        return (CoroutineSingletons) Enum.valueOf(CoroutineSingletons.class, str);
    }

    public static CoroutineSingletons[] values() {
        return (CoroutineSingletons[]) f10060b.clone();
    }
}
