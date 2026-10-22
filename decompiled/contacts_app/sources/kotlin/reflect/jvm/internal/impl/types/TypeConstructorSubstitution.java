package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class TypeConstructorSubstitution extends TypeSubstitution {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: TypeSubstitution.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final TypeConstructorSubstitution createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> r4) {
            Intrinsics.checkNotNullParameter(r4, "map");
            return createByConstructorsMap$default(this, r4, false, 2, null);
        }

        private Companion() {
        }

        public static /* synthetic */ TypeConstructorSubstitution createByConstructorsMap$default(Companion r0, Map r1, boolean r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = false;
        L6:
            return r0.createByConstructorsMap(r1, r2);
        }

        @JvmStatic
        public final TypeConstructorSubstitution createByConstructorsMap(final Map<TypeConstructor, ? extends TypeProjection> r1, final boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "map");
            return new TypeConstructorSubstitution$Companion$createByConstructorsMap$1(r1, r2);
        }

        @JvmStatic
        public final TypeSubstitution create(KotlinType r2) {
            Intrinsics.checkNotNullParameter(r2, "kotlinType");
            return create(r2.getConstructor(), r2.getArguments());
        }

        @JvmStatic
        public final TypeSubstitution create(TypeConstructor r6, List<? extends TypeProjection> r7) {
            Intrinsics.checkNotNullParameter(r6, "typeConstructor");
            Intrinsics.checkNotNullParameter(r7, "arguments");
            List<TypeParameterDescriptor> r0 = r6.getParameters();
            Intrinsics.checkNotNullExpressionValue(r0, "typeConstructor.parameters");
            TypeParameterDescriptor r2 = (TypeParameterDescriptor) CollectionsKt.lastOrNull(r0);
            if (r2 == null) goto L7;
            boolean r4 = true;
            if (r2.isCapturedFromOuterDeclaration() != true) goto L7;
        L8:
            if (r4 == false) goto L16;
            List<TypeParameterDescriptor> r8 = r6.getParameters();
            Intrinsics.checkNotNullExpressionValue(r8, "typeConstructor.parameters");
            List<TypeParameterDescriptor> r9 = r8;
            ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
            Iterator<T> r10 = r9.iterator();
        L11:
            if (r10.hasNext() == false) goto L14;
            r1.add(((TypeParameterDescriptor) r10.next()).getTypeConstructor());
            goto L11
        L14:
            return createByConstructorsMap$default(this, MapsKt.toMap(CollectionsKt.zip(r1, r7)), false, 2, null);
        L16:
            return new IndexedParametersSubstitution(r0, r7);
        L7:
            r4 = false;
            goto L8
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final TypeSubstitution create(TypeConstructor r1, List<? extends TypeProjection> r2) {
        return Companion.create(r1, r2);
    }

    @JvmStatic
    public static final TypeConstructorSubstitution createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> r1) {
        return Companion.createByConstructorsMap(r1);
    }

    public abstract TypeProjection get(TypeConstructor r1);

    public TypeConstructorSubstitution() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public TypeProjection mo2088get(KotlinType r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return get(r2.getConstructor());
    }
}
