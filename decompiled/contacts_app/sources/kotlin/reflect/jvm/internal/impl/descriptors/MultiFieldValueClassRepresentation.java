package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* JADX INFO: compiled from: MultiFieldValueClassRepresentation.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MultiFieldValueClassRepresentation<Type extends SimpleTypeMarker> extends ValueClassRepresentation<Type> {
    private final Map<Name, Type> map;
    private final List<Pair<Name, Type>> underlyingPropertyNamesToTypes;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation
    public List<Pair<Name, Type>> getUnderlyingPropertyNamesToTypes() {
        return this.underlyingPropertyNamesToTypes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MultiFieldValueClassRepresentation(List<? extends Pair<Name, ? extends Type>> r3) {
        Intrinsics.checkNotNullParameter(r3, "underlyingPropertyNamesToTypes");
        super(null);
        this.underlyingPropertyNamesToTypes = r3;
        Map<Name, Type> r4 = MapsKt.toMap(getUnderlyingPropertyNamesToTypes());
        if (r4.size() != getUnderlyingPropertyNamesToTypes().size()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.map = r4;
        return;
    L10:
        throw new IllegalArgumentException("Some properties have the same names".toString());
    L5:
        r0 = false;
        goto L6
    }
}
