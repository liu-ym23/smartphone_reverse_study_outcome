package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0004\u001a\u00020\u0005H\u0000\u001a-\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e\u001a#\u0010\u000f\u001a\u00020\u0007*\u00020\u00072\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e\u001a\u0014\u0010\u0010\u001a\u00020\r*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\"\u0014\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0003¨\u0006\u0014"}, d2 = {"lastIdentifier", "Ljava/util/concurrent/atomic/AtomicInteger;", "Landroidx/compose/ui/platform/AtomicInt;", "Ljava/util/concurrent/atomic/AtomicInteger;", "generateSemanticsId", "", "semantics", "Landroidx/compose/ui/Modifier;", "mergeDescendants", "", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "Lkotlin/ExtensionFunctionType;", "clearAndSetSemantics", "addSemanticsPropertiesFrom", "Landroidx/compose/ui/platform/InspectorInfo;", "semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SemanticsModifierKt {
    private static AtomicInteger lastIdentifier;

    static {
        lastIdentifier = new AtomicInteger(0);
    }

    public static final int generateSemanticsId() {
        return lastIdentifier.addAndGet(1);
    }

    public static final /* synthetic */ void access$addSemanticsPropertiesFrom(InspectorInfo r100, SemanticsConfiguration r101) {
        addSemanticsPropertiesFrom(r100, r101);
    }

    private static final void addSemanticsPropertiesFrom(InspectorInfo r100, SemanticsConfiguration r101) {
        ValueElementSequence r102 = r100.getProperties();
        LinkedHashMap r103 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r101, 10)), 16));
        Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object> r105 = r104.next();
        SemanticsPropertyKey<?> r106 = r105.getKey();
        Object r107 = r105.getValue();
        Pair r108 = TuplesKt.to(r106.getName(), r107);
        r103.put(r108.getFirst(), r108.getSecond());
        goto L4
    L6:
        r102.set("properties", r103);
    }

    public static final Modifier clearAndSetSemantics(Modifier r100, Function1<? super SemanticsPropertyReceiver, Unit> r101) {
        return r100.then(new ClearAndSetSemanticsElement(r101));
    }

    public static final Modifier semantics(Modifier r100, boolean r101, Function1<? super SemanticsPropertyReceiver, Unit> r102) {
        return r100.then(new AppendedSemanticsElement(r101, r102));
    }

    public static /* synthetic */ Modifier semantics$default(Modifier r100, boolean r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        return semantics(r100, r101, r102);
    }
}
