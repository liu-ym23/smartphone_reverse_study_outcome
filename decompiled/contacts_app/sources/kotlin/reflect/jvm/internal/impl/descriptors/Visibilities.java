package kotlin.reflect.jvm.internal.impl.descriptors;

import androidx.core.os.EnvironmentCompat;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Visibilities.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class Visibilities {
    private static final Public DEFAULT_VISIBILITY = null;
    public static final Visibilities INSTANCE = null;
    private static final Map<Visibility, Integer> ORDERED_VISIBILITIES = null;

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class Inherited extends Visibility {
        public static final Inherited INSTANCE = null;

        static {
            INSTANCE = new Inherited();
        }

        private Inherited() {
            super("inherited", false);
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class Internal extends Visibility {
        public static final Internal INSTANCE = null;

        static {
            INSTANCE = new Internal();
        }

        private Internal() {
            super("internal", false);
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class InvisibleFake extends Visibility {
        public static final InvisibleFake INSTANCE = null;

        static {
            INSTANCE = new InvisibleFake();
        }

        private InvisibleFake() {
            super("invisible_fake", false);
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class Local extends Visibility {
        public static final Local INSTANCE = null;

        static {
            INSTANCE = new Local();
        }

        private Local() {
            super("local", false);
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class Private extends Visibility {
        public static final Private INSTANCE = null;

        static {
            INSTANCE = new Private();
        }

        private Private() {
            super("private", false);
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class PrivateToThis extends Visibility {
        public static final PrivateToThis INSTANCE = null;

        static {
            INSTANCE = new PrivateToThis();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public String getInternalDisplayName() {
            return "private/*private to this*/";
        }

        private PrivateToThis() {
            super("private_to_this", false);
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class Protected extends Visibility {
        public static final Protected INSTANCE = null;

        static {
            INSTANCE = new Protected();
        }

        private Protected() {
            super("protected", true);
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class Public extends Visibility {
        public static final Public INSTANCE = null;

        static {
            INSTANCE = new Public();
        }

        private Public() {
            super("public", true);
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class Unknown extends Visibility {
        public static final Unknown INSTANCE = null;

        static {
            INSTANCE = new Unknown();
        }

        private Unknown() {
            super(EnvironmentCompat.MEDIA_UNKNOWN, false);
        }
    }

    private Visibilities() {
    }

    static {
        INSTANCE = new Visibilities();
        Map r0 = MapsKt.createMapBuilder();
        r0.put(PrivateToThis.INSTANCE, 0);
        r0.put(Private.INSTANCE, 0);
        r0.put(Internal.INSTANCE, 1);
        r0.put(Protected.INSTANCE, 1);
        r0.put(Public.INSTANCE, 2);
        ORDERED_VISIBILITIES = MapsKt.build(r0);
        DEFAULT_VISIBILITY = Public.INSTANCE;
    }

    public final Integer compareLocal$compiler_common(Visibility r1, Visibility r2) {
        Intrinsics.checkNotNullParameter(r1, "first");
        Intrinsics.checkNotNullParameter(r2, "second");
        if (r1 == r2) goto L5;
        Map<Visibility, Integer> r0 = ORDERED_VISIBILITIES;
        Integer r3 = r0.get(r1);
        Integer r4 = r0.get(r2);
        if (r3 == null) goto L13;
        if (r4 == null) goto L13;
        if (Intrinsics.areEqual(r3, r4) == true) goto L13;
        return Integer.valueOf(r3.intValue() - r4.intValue());
    L13:
        Integer r5 = (Integer) null;
        return null;
    L5:
        return 0;
    }

    public final boolean isPrivate(Visibility r1) {
        Intrinsics.checkNotNullParameter(r1, "visibility");
        if (r1 != Private.INSTANCE) goto L5;
    L8:
        return true;
    L5:
        if (r1 == PrivateToThis.INSTANCE) goto L8;
        return false;
    }
}
