package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;

/* JADX INFO: compiled from: KotlinClassHeader.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class KotlinClassHeader {
    private final String[] data;
    private final int extraInt;
    private final String extraString;
    private final String[] incompatibleData;
    private final Kind kind;
    private final JvmMetadataVersion metadataVersion;
    private final String packageName;
    private final byte[] serializedIr;
    private final String[] strings;

    /* JADX INFO: compiled from: KotlinClassHeader.kt */
    public static final enum Kind extends Enum<Kind> {
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind CLASS = null;
        public static final Companion Companion = null;
        public static final Kind FILE_FACADE = null;
        public static final Kind MULTIFILE_CLASS = null;
        public static final Kind MULTIFILE_CLASS_PART = null;
        public static final Kind SYNTHETIC_CLASS = null;
        public static final Kind UNKNOWN = null;
        private static final Map<Integer, Kind> entryById = null;
        private final int id;

        /* JADX INFO: compiled from: KotlinClassHeader.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Kind getById(int r1) {
                Kind r0 = (Kind) Kind.access$getEntryById$cp().get(Integer.valueOf(r1));
                if (r0 == null) goto L5;
                return r0;
            L5:
                return Kind.UNKNOWN;
            }
        }

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{UNKNOWN, CLASS, FILE_FACADE, SYNTHETIC_CLASS, MULTIFILE_CLASS, MULTIFILE_CLASS_PART};
        }

        @JvmStatic
        public static final Kind getById(int r1) {
            return Companion.getById(r1);
        }

        public static Kind valueOf(String r1) {
            return (Kind) Enum.valueOf(Kind.class, r1);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }

        private Kind(String r1, int r2, int r3) {
            super(r1, r2);
            this.id = r3;
        }

        public static final /* synthetic */ Map access$getEntryById$cp() {
            return entryById;
        }

        static {
            int r2 = 0;
            UNKNOWN = new Kind("UNKNOWN", 0, 0);
            CLASS = new Kind("CLASS", 1, 1);
            FILE_FACADE = new Kind("FILE_FACADE", 2, 2);
            SYNTHETIC_CLASS = new Kind("SYNTHETIC_CLASS", 3, 3);
            MULTIFILE_CLASS = new Kind("MULTIFILE_CLASS", 4, 4);
            MULTIFILE_CLASS_PART = new Kind("MULTIFILE_CLASS_PART", 5, 5);
            $VALUES = $values();
            Companion = new Companion(null);
            Kind[] r0 = values();
            LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r0.length), 16));
            int r1 = r0.length;
        L3:
            if (r2 >= r1) goto L5;
            Kind r4 = r0[r2];
            r3.put(Integer.valueOf(r4.id), r4);
            r2 = r2 + 1;
            goto L3
        L5:
            entryById = r3;
        }
    }

    private final boolean has(int r1, int r2) {
        if ((r1 & r2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public KotlinClassHeader(Kind r2, JvmMetadataVersion r3, String[] r4, String[] r5, String[] r6, String r7, int r8, String r9, byte[] r10) {
        Intrinsics.checkNotNullParameter(r2, "kind");
        Intrinsics.checkNotNullParameter(r3, "metadataVersion");
        this.kind = r2;
        this.metadataVersion = r3;
        this.data = r4;
        this.incompatibleData = r5;
        this.strings = r6;
        this.extraString = r7;
        this.extraInt = r8;
        this.packageName = r9;
        this.serializedIr = r10;
    }

    public final Kind getKind() {
        return this.kind;
    }

    public final JvmMetadataVersion getMetadataVersion() {
        return this.metadataVersion;
    }

    public final String[] getData() {
        return this.data;
    }

    public final String[] getIncompatibleData() {
        return this.incompatibleData;
    }

    public final String[] getStrings() {
        return this.strings;
    }

    public final String getMultifileClassName() {
        String r0 = this.extraString;
        if (this.kind != Kind.MULTIFILE_CLASS_PART) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L10;
        return null;
    L10:
        return r0;
    L5:
        r2 = false;
        goto L6
    }

    public final List<String> getMultifilePartNames() {
        String[] r0 = this.data;
        if (this.kind != Kind.MULTIFILE_CLASS) goto L5;
        boolean r2 = true;
    L6:
        List<String> r1 = null;
        if (r2 == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L12;
        r1 = ArraysKt.asList(r0);
    L12:
        if (r1 == null) goto L14;
        return r1;
    L14:
        return CollectionsKt.emptyList();
    L5:
        r2 = false;
        goto L6
    }

    public final boolean isUnstableJvmIrBinary() {
        if (has(this.extraInt, 16) == true) goto L5;
    L7:
        return false;
    L5:
        if (has(this.extraInt, 32) == true) goto L7;
        return true;
    }

    public final boolean isUnstableFirBinary() {
        if (has(this.extraInt, 64) == true) goto L5;
    L7:
        return false;
    L5:
        if (has(this.extraInt, 32) == true) goto L7;
        return true;
    }

    public final boolean isPreRelease() {
        return has(this.extraInt, 2);
    }

    public String toString() {
        return this.kind + " version=" + this.metadataVersion;
    }
}
