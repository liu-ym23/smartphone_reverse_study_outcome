package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: compiled from: TypeAliasExpansion.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeAliasExpansion {
    public static final Companion Companion = null;
    private final List<TypeProjection> arguments;
    private final TypeAliasDescriptor descriptor;
    private final Map<TypeParameterDescriptor, TypeProjection> mapping;
    private final TypeAliasExpansion parent;

    /* JADX INFO: compiled from: TypeAliasExpansion.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final TypeAliasExpansion create(TypeAliasExpansion r7, TypeAliasDescriptor r8, List<? extends TypeProjection> r9) {
            Intrinsics.checkNotNullParameter(r8, "typeAliasDescriptor");
            Intrinsics.checkNotNullParameter(r9, "arguments");
            List<TypeParameterDescriptor> r6 = r8.getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(r6, "typeAliasDescriptor.typeConstructor.parameters");
            List<TypeParameterDescriptor> r10 = r6;
            ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
            Iterator<T> r11 = r10.iterator();
        L4:
            if (r11.hasNext() == false) goto L7;
            r0.add(((TypeParameterDescriptor) r11.next()).getOriginal());
            goto L4
        L7:
            return new TypeAliasExpansion(r7, r8, r9, MapsKt.toMap(CollectionsKt.zip(r0, r9)), null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ TypeAliasExpansion(TypeAliasExpansion r1, TypeAliasDescriptor r2, List r3, Map r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeAliasExpansion(TypeAliasExpansion r1, TypeAliasDescriptor r2, List<? extends TypeProjection> r3, Map<TypeParameterDescriptor, ? extends TypeProjection> r4) {
        this.parent = r1;
        this.descriptor = r2;
        this.arguments = r3;
        this.mapping = r4;
    }

    public final TypeAliasDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final List<TypeProjection> getArguments() {
        return this.arguments;
    }

    public final TypeProjection getReplacement(TypeConstructor r2) {
        Intrinsics.checkNotNullParameter(r2, "constructor");
        ClassifierDescriptor r3 = r2.mo2083getDeclarationDescriptor();
        if ((r3 instanceof TypeParameterDescriptor) == true) goto L7;
        return null;
    L7:
        return this.mapping.get(r3);
    }

    public final boolean isRecursion(TypeAliasDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        if (Intrinsics.areEqual(this.descriptor, r2) == true) goto L9;
        TypeAliasExpansion r1 = this.parent;
        if (r1 == null) goto L7;
        boolean r3 = r1.isRecursion(r2);
    L8:
        if (r3 == true) goto L9;
        return false;
    L7:
        r3 = false;
    L9:
        return true;
    }
}
