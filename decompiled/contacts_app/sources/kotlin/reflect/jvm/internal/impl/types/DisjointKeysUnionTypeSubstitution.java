package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: compiled from: DisjointKeysUnionTypeSubstitution.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DisjointKeysUnionTypeSubstitution extends TypeSubstitution {
    public static final Companion Companion = null;
    private final TypeSubstitution first;
    private final TypeSubstitution second;

    /* JADX INFO: compiled from: DisjointKeysUnionTypeSubstitution.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TypeSubstitution create(TypeSubstitution r2, TypeSubstitution r3) {
            Intrinsics.checkNotNullParameter(r2, "first");
            Intrinsics.checkNotNullParameter(r3, "second");
            if (r2.isEmpty() == false) goto L6;
            return r3;
        L6:
            if (r3.isEmpty() == false) goto L9;
            return r2;
        L9:
            return new DisjointKeysUnionTypeSubstitution(r2, r3, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ DisjointKeysUnionTypeSubstitution(TypeSubstitution r1, TypeSubstitution r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @JvmStatic
    public static final TypeSubstitution create(TypeSubstitution r1, TypeSubstitution r2) {
        return Companion.create(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return false;
    }

    private DisjointKeysUnionTypeSubstitution(TypeSubstitution r1, TypeSubstitution r2) {
        this.first = r1;
        this.second = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public TypeProjection mo2088get(KotlinType r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        TypeProjection r0 = this.first.mo2088get(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.second.mo2088get(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public KotlinType prepareTopLevelType(KotlinType r2, Variance r3) {
        Intrinsics.checkNotNullParameter(r2, "topLevelType");
        Intrinsics.checkNotNullParameter(r3, "position");
        return this.second.prepareTopLevelType(this.first.prepareTopLevelType(r2, r3), r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateCapturedTypes() {
        if (this.first.approximateCapturedTypes() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.second.approximateCapturedTypes() == true) goto L8;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateContravariantCapturedTypes() {
        if (this.first.approximateContravariantCapturedTypes() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.second.approximateContravariantCapturedTypes() == true) goto L8;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public Annotations filterAnnotations(Annotations r2) {
        Intrinsics.checkNotNullParameter(r2, "annotations");
        return this.second.filterAnnotations(this.first.filterAnnotations(r2));
    }
}
