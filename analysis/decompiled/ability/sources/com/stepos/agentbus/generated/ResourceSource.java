package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u000b"}, d2 = {"Lcom/stepos/agentbus/generated/ResourceSource;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "AUTO", "EDGE", "CLOUD", "wire", "", "getWire", "()Ljava/lang/String;", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ResourceSource {
    private static final /* synthetic */ K7.a $ENTRIES;
    private static final /* synthetic */ ResourceSource[] $VALUES;
    public static final ResourceSource AUTO = new ResourceSource("AUTO", 0);
    public static final ResourceSource EDGE = new ResourceSource("EDGE", 1);
    public static final ResourceSource CLOUD = new ResourceSource("CLOUD", 2);

    private static final /* synthetic */ ResourceSource[] $values() {
        return new ResourceSource[]{AUTO, EDGE, CLOUD};
    }

    static {
        ResourceSource[] resourceSourceArr$values = $values();
        $VALUES = resourceSourceArr$values;
        $ENTRIES = kotlin.enums.a.a(resourceSourceArr$values);
    }

    private ResourceSource(String str, int i) {
    }

    public static K7.a getEntries() {
        return $ENTRIES;
    }

    public static ResourceSource valueOf(String str) {
        return (ResourceSource) Enum.valueOf(ResourceSource.class, str);
    }

    public static ResourceSource[] values() {
        return (ResourceSource[]) $VALUES.clone();
    }

    public final String getWire() {
        String lowerCase = name().toLowerCase(Locale.ROOT);
        k.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }
}
