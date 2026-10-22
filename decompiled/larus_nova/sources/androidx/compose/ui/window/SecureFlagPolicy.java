package androidx.compose.ui.window;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/window/SecureFlagPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "Inherit", "SecureOn", "SecureOff", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum SecureFlagPolicy extends Enum<SecureFlagPolicy> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SecureFlagPolicy[] $VALUES = null;
    public static final SecureFlagPolicy Inherit = null;
    public static final SecureFlagPolicy SecureOff = null;
    public static final SecureFlagPolicy SecureOn = null;

    private static final /* synthetic */ SecureFlagPolicy[] $values() {
        return new SecureFlagPolicy[]{Inherit, SecureOn, SecureOff};
    }

    public static EnumEntries<SecureFlagPolicy> getEntries() {
        return $ENTRIES;
    }

    static {
        Inherit = new SecureFlagPolicy("Inherit", 0);
        SecureOn = new SecureFlagPolicy("SecureOn", 1);
        SecureOff = new SecureFlagPolicy("SecureOff", 2);
        SecureFlagPolicy[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static SecureFlagPolicy[] values() {
        return (SecureFlagPolicy[]) $VALUES.clone();
    }

    public static SecureFlagPolicy valueOf(String r100) {
        return (SecureFlagPolicy) r27.a.a(SecureFlagPolicy.class, r100);
    }

    private SecureFlagPolicy(String r100, int r101) {
        super(r100, r101);
    }
}
