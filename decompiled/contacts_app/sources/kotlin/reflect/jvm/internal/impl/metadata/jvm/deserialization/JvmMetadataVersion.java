package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;

/* JADX INFO: compiled from: JvmMetadataVersion.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JvmMetadataVersion extends BinaryVersion {
    public static final Companion Companion = null;
    public static final JvmMetadataVersion INSTANCE = null;
    public static final JvmMetadataVersion INVALID_VERSION = null;
    private final boolean isStrictSemantics;

    /* JADX INFO: compiled from: JvmMetadataVersion.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public JvmMetadataVersion(int[] r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "versionArray");
        super(Arrays.copyOf(r2, r2.length));
        this.isStrictSemantics = r3;
    }

    public JvmMetadataVersion(int... r2) {
        Intrinsics.checkNotNullParameter(r2, "numbers");
        this(r2, false);
    }

    public boolean isCompatible() {
        if (getMajor() != 1) goto L7;
        if (getMinor() != 0) goto L7;
        return false;
    L7:
        if (this.isStrictSemantics == false) goto L9;
        boolean r5 = isCompatibleTo(INSTANCE);
    L15:
        if (r5 == true) goto L17;
        return false;
    L17:
        return true;
    L9:
        int r0 = getMajor();
        JvmMetadataVersion r3 = INSTANCE;
        if (r0 == r3.getMajor()) goto L12;
    L14:
        r5 = false;
        goto L15
    L12:
        if (getMinor() > (r3.getMinor() + 1)) goto L14;
        r5 = true;
        goto L15
    }

    static {
        Companion = new Companion(null);
        INSTANCE = new JvmMetadataVersion(new int[]{1, 7, 1});
        INVALID_VERSION = new JvmMetadataVersion(new int[0]);
    }
}
