package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: compiled from: KotlinTypeRefiner.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class KotlinTypeRefinerKt {
    private static final ModuleCapability<Ref<TypeRefinementSupport>> REFINER_CAPABILITY = null;

    static {
        REFINER_CAPABILITY = new ModuleCapability("KotlinTypeRefiner");
    }

    public static final ModuleCapability<Ref<TypeRefinementSupport>> getREFINER_CAPABILITY() {
        return REFINER_CAPABILITY;
    }

    public static final List<KotlinType> refineTypes(KotlinTypeRefiner r2, Iterable<? extends KotlinType> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, GloableSearchConfig.KEY_CONFIGS);
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<? extends KotlinType> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        r0.add(r2.refineType(r4.next()));
        goto L4
    L7:
        return r0;
    }
}
