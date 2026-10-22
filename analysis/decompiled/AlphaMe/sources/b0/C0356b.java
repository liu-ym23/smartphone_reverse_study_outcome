package b0;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: b0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0356b {

    /* renamed from: c, reason: collision with root package name */
    public static final C0356b f4361c = new C0356b(SetsKt.emptySet(), MapsKt.emptyMap());

    /* renamed from: a, reason: collision with root package name */
    public final Set f4362a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f4363b;

    public C0356b(Set flags, Map allowedViolations) {
        Intrinsics.checkNotNullParameter(flags, "flags");
        Intrinsics.checkNotNullParameter(allowedViolations, "allowedViolations");
        this.f4362a = flags;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : allowedViolations.entrySet()) {
            linkedHashMap.put((String) entry.getKey(), (Set) entry.getValue());
        }
        this.f4363b = linkedHashMap;
    }
}
