package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.jvm.internal.Intrinsics;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: compiled from: versionSpecificBehavior.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class VersionSpecificBehaviorKt {
    public static final boolean isVersionRequirementTableWrittenCorrectly(BinaryVersion r1) {
        Intrinsics.checkNotNullParameter(r1, GloableSearchConfig.KEY_VERSION);
        return isKotlin1Dot4OrLater(r1);
    }

    public static final boolean isKotlin1Dot4OrLater(BinaryVersion r2) {
        Intrinsics.checkNotNullParameter(r2, GloableSearchConfig.KEY_VERSION);
        if (r2.getMajor() == 1) goto L5;
    L7:
        return false;
    L5:
        if (r2.getMinor() < 4) goto L7;
        return true;
    }
}
