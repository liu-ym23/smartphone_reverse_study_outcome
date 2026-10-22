package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* JADX INFO: compiled from: ValueClassRepresentation.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ValueClassRepresentation<Type extends SimpleTypeMarker> {
    public /* synthetic */ ValueClassRepresentation(DefaultConstructorMarker r1) {
        this();
    }

    public abstract List<Pair<Name, Type>> getUnderlyingPropertyNamesToTypes();

    private ValueClassRepresentation() {
    }

    public final <Other extends SimpleTypeMarker> ValueClassRepresentation<Other> mapUnderlyingType(Function1<? super Type, ? extends Other> r4) {
        Intrinsics.checkNotNullParameter(r4, "transform");
        if ((this instanceof InlineClassRepresentation) == false) goto L6;
        InlineClassRepresentation r3 = (InlineClassRepresentation) this;
        return new InlineClassRepresentation(r3.getUnderlyingPropertyName(), r4.invoke(r3.getUnderlyingType()));
    L6:
        if ((this instanceof MultiFieldValueClassRepresentation) == false) goto L14;
        List<Pair<Name, Type>> r5 = getUnderlyingPropertyNamesToTypes();
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L12;
        Pair r1 = (Pair) r6.next();
        r0.add(TuplesKt.to((Name) r1.component1(), r4.invoke((SimpleTypeMarker) r1.component2())));
        goto L9
    L12:
        return new MultiFieldValueClassRepresentation(r0);
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
