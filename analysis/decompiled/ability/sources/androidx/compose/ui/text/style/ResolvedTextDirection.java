package androidx.compose.ui.text.style;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/text/style/ResolvedTextDirection;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "Ltr", "Rtl", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ResolvedTextDirection {
    private static final /* synthetic */ K7.a $ENTRIES;
    private static final /* synthetic */ ResolvedTextDirection[] $VALUES;
    public static final ResolvedTextDirection Ltr = new ResolvedTextDirection("Ltr", 0);
    public static final ResolvedTextDirection Rtl = new ResolvedTextDirection("Rtl", 1);

    private static final /* synthetic */ ResolvedTextDirection[] $values() {
        return new ResolvedTextDirection[]{Ltr, Rtl};
    }

    static {
        ResolvedTextDirection[] resolvedTextDirectionArr$values = $values();
        $VALUES = resolvedTextDirectionArr$values;
        $ENTRIES = kotlin.enums.a.a(resolvedTextDirectionArr$values);
    }

    private ResolvedTextDirection(String str, int i) {
    }

    public static K7.a getEntries() {
        return $ENTRIES;
    }

    public static ResolvedTextDirection valueOf(String str) {
        return (ResolvedTextDirection) Enum.valueOf(ResolvedTextDirection.class, str);
    }

    public static ResolvedTextDirection[] values() {
        return (ResolvedTextDirection[]) $VALUES.clone();
    }
}
