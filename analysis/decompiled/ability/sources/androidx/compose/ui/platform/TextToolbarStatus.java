package androidx.compose.ui.platform;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/platform/TextToolbarStatus;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "Shown", "Hidden", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextToolbarStatus {
    private static final /* synthetic */ K7.a $ENTRIES;
    private static final /* synthetic */ TextToolbarStatus[] $VALUES;
    public static final TextToolbarStatus Shown = new TextToolbarStatus("Shown", 0);
    public static final TextToolbarStatus Hidden = new TextToolbarStatus("Hidden", 1);

    private static final /* synthetic */ TextToolbarStatus[] $values() {
        return new TextToolbarStatus[]{Shown, Hidden};
    }

    static {
        TextToolbarStatus[] textToolbarStatusArr$values = $values();
        $VALUES = textToolbarStatusArr$values;
        $ENTRIES = kotlin.enums.a.a(textToolbarStatusArr$values);
    }

    private TextToolbarStatus(String str, int i) {
    }

    public static K7.a getEntries() {
        return $ENTRIES;
    }

    public static TextToolbarStatus valueOf(String str) {
        return (TextToolbarStatus) Enum.valueOf(TextToolbarStatus.class, str);
    }

    public static TextToolbarStatus[] values() {
        return (TextToolbarStatus[]) $VALUES.clone();
    }
}
