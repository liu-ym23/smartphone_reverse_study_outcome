package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;

/* JADX INFO: compiled from: JvmFlags.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JvmFlags {
    public static final JvmFlags INSTANCE = null;
    private static final Flags.BooleanFlagField IS_COMPILED_IN_COMPATIBILITY_MODE = null;
    private static final Flags.BooleanFlagField IS_COMPILED_IN_JVM_DEFAULT_MODE = null;
    private static final Flags.BooleanFlagField IS_MOVED_FROM_INTERFACE_COMPANION = null;

    private JvmFlags() {
    }

    static {
        INSTANCE = new JvmFlags();
        IS_MOVED_FROM_INTERFACE_COMPANION = Flags.FlagField.booleanFirst();
        Flags.BooleanFlagField r0 = Flags.FlagField.booleanFirst();
        IS_COMPILED_IN_JVM_DEFAULT_MODE = r0;
        IS_COMPILED_IN_COMPATIBILITY_MODE = Flags.FlagField.booleanAfter(r0);
    }

    public final Flags.BooleanFlagField getIS_MOVED_FROM_INTERFACE_COMPANION() {
        return IS_MOVED_FROM_INTERFACE_COMPANION;
    }
}
