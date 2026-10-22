package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;

/* JADX INFO: compiled from: ClassicTypeCheckerState.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ClassicTypeCheckerStateKt {
    public static /* synthetic */ TypeCheckerState createClassicTypeCheckerState$default(boolean r0, boolean r1, SimpleClassicTypeSystemContext r2, KotlinTypePreparator.Default r3, KotlinTypeRefiner.Default r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r1 = true;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r2 = SimpleClassicTypeSystemContext.INSTANCE;
    L9:
        if ((r5 & 8) == 0) goto L12;
        r3 = KotlinTypePreparator.Default.INSTANCE;
    L12:
        if ((r5 & 16) == 0) goto L15;
        r4 = KotlinTypeRefiner.Default.INSTANCE;
    L15:
        return createClassicTypeCheckerState(r0, r1, r2, r3, r4);
    }

    public static final TypeCheckerState createClassicTypeCheckerState(boolean r8, boolean r9, ClassicTypeSystemContext r10, KotlinTypePreparator r11, KotlinTypeRefiner r12) {
        Intrinsics.checkNotNullParameter(r10, "typeSystemContext");
        Intrinsics.checkNotNullParameter(r11, "kotlinTypePreparator");
        Intrinsics.checkNotNullParameter(r12, "kotlinTypeRefiner");
        return new TypeCheckerState(r8, r9, true, r10, r11, r12);
    }
}
