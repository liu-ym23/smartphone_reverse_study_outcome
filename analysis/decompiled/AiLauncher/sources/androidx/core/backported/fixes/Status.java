package androidx.core.backported.fixes;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/core/backported/fixes/Status;", "", "<init>", "(Ljava/lang/String;I)V", "Unknown", "Fixed", "NotApplicable", "NotFixed", "core-backported-fixes"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Status {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ Status[] $VALUES;
    public static final Status Unknown = new Status("Unknown", 0);
    public static final Status Fixed = new Status("Fixed", 1);
    public static final Status NotApplicable = new Status("NotApplicable", 2);
    public static final Status NotFixed = new Status("NotFixed", 3);

    private static final /* synthetic */ Status[] $values() {
        return new Status[]{Unknown, Fixed, NotApplicable, NotFixed};
    }

    static {
        Status[] statusArr$values = $values();
        $VALUES = statusArr$values;
        $ENTRIES = a.a(statusArr$values);
    }

    private Status(String str, int i10) {
    }

    public static InterfaceC4149a<Status> getEntries() {
        return $ENTRIES;
    }

    public static Status valueOf(String str) {
        return (Status) Enum.valueOf(Status.class, str);
    }

    public static Status[] values() {
        return (Status[]) $VALUES.clone();
    }
}
