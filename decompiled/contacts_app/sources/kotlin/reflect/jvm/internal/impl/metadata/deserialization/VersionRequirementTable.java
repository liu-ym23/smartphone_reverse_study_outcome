package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* JADX INFO: compiled from: VersionRequirement.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class VersionRequirementTable {
    public static final Companion Companion = null;
    private static final VersionRequirementTable EMPTY = null;
    private final List<ProtoBuf.VersionRequirement> infos;

    /* JADX INFO: compiled from: VersionRequirement.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final VersionRequirementTable getEMPTY() {
            return VersionRequirementTable.access$getEMPTY$cp();
        }

        public final VersionRequirementTable create(ProtoBuf.VersionRequirementTable r2) {
            Intrinsics.checkNotNullParameter(r2, "table");
            if (r2.getRequirementCount() == 0) goto L7;
            List<ProtoBuf.VersionRequirement> r3 = r2.getRequirementList();
            Intrinsics.checkNotNullExpressionValue(r3, "table.requirementList");
            return new VersionRequirementTable(r3, null);
        L7:
            return getEMPTY();
        }
    }

    public /* synthetic */ VersionRequirementTable(List r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    private VersionRequirementTable(List<ProtoBuf.VersionRequirement> r1) {
        this.infos = r1;
    }

    public static final /* synthetic */ VersionRequirementTable access$getEMPTY$cp() {
        return EMPTY;
    }

    static {
        Companion = new Companion(null);
        EMPTY = new VersionRequirementTable(CollectionsKt.emptyList());
    }
}
