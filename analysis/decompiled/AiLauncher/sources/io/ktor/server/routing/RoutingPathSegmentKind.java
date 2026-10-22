package io.ktor.server.routing;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/server/routing/RoutingPathSegmentKind;", "", "<init>", "(Ljava/lang/String;I)V", "Constant", "Parameter", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RoutingPathSegmentKind {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ RoutingPathSegmentKind[] $VALUES;
    public static final RoutingPathSegmentKind Constant = new RoutingPathSegmentKind("Constant", 0);
    public static final RoutingPathSegmentKind Parameter = new RoutingPathSegmentKind("Parameter", 1);

    private static final /* synthetic */ RoutingPathSegmentKind[] $values() {
        return new RoutingPathSegmentKind[]{Constant, Parameter};
    }

    static {
        RoutingPathSegmentKind[] routingPathSegmentKindArr$values = $values();
        $VALUES = routingPathSegmentKindArr$values;
        $ENTRIES = kotlin.enums.a.a(routingPathSegmentKindArr$values);
    }

    private RoutingPathSegmentKind(String str, int i10) {
    }

    public static InterfaceC4149a<RoutingPathSegmentKind> getEntries() {
        return $ENTRIES;
    }

    public static RoutingPathSegmentKind valueOf(String str) {
        return (RoutingPathSegmentKind) Enum.valueOf(RoutingPathSegmentKind.class, str);
    }

    public static RoutingPathSegmentKind[] values() {
        return (RoutingPathSegmentKind[]) $VALUES.clone();
    }
}
