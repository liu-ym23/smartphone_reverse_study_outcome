package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class TypeSubstitution {
    public static final Companion Companion = null;
    public static final TypeSubstitution EMPTY = null;

    /* JADX INFO: compiled from: TypeSubstitution.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public boolean approximateCapturedTypes() {
        return false;
    }

    public boolean approximateContravariantCapturedTypes() {
        return false;
    }

    public Annotations filterAnnotations(Annotations r1) {
        Intrinsics.checkNotNullParameter(r1, "annotations");
        return r1;
    }

    /* JADX INFO: renamed from: get */
    public abstract TypeProjection mo2088get(KotlinType r1);

    public boolean isEmpty() {
        return false;
    }

    public KotlinType prepareTopLevelType(KotlinType r1, Variance r2) {
        Intrinsics.checkNotNullParameter(r1, "topLevelType");
        Intrinsics.checkNotNullParameter(r2, "position");
        return r1;
    }

    public TypeSubstitution() {
    }

    static {
        Companion = new Companion(null);
        EMPTY = new TypeSubstitution$Companion$EMPTY$1();
    }

    public final TypeSubstitutor buildSubstitutor() {
        TypeSubstitutor r1 = TypeSubstitutor.create(this);
        Intrinsics.checkNotNullExpressionValue(r1, "create(this)");
        return r1;
    }

    public final TypeSubstitution replaceWithNonApproximating() {
        return new AnonymousClass1(this);
    }
}
