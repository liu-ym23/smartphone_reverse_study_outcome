package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: compiled from: JvmNameResolver.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JvmNameResolver extends JvmNameResolverBase {
    private final JvmProtoBuf.StringTableTypes types;

    public JvmNameResolver(JvmProtoBuf.StringTableTypes r4, String[] r5) {
        Intrinsics.checkNotNullParameter(r4, GloableSearchConfig.KEY_CONFIGS);
        Intrinsics.checkNotNullParameter(r5, "strings");
        List<Integer> r0 = r4.getLocalNameList();
        if (r0.isEmpty() == false) goto L5;
        Set r1 = SetsKt.emptySet();
    L6:
        List<JvmProtoBuf.StringTableTypes.Record> r2 = r4.getRecordList();
        Intrinsics.checkNotNullExpressionValue(r2, "types.recordList");
        super(r5, r1, JvmNameResolverKt.toExpandedRecordsList(r2));
        this.types = r4;
        return;
    L5:
        Intrinsics.checkNotNullExpressionValue(r0, "_init_$lambda$0");
        r1 = CollectionsKt.toSet(r0);
        goto L6
    }
}
