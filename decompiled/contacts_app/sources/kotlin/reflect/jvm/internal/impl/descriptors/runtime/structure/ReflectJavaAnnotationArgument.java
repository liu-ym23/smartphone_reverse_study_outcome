package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ReflectJavaAnnotationArgument implements JavaAnnotationArgument {
    public static final Factory Factory = null;
    private final Name name;

    /* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker r1) {
            this();
        }

        private Factory() {
        }

        public final ReflectJavaAnnotationArgument create(Object r1, Name r2) {
            Intrinsics.checkNotNullParameter(r1, "value");
            if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(r1.getClass()) == false) goto L6;
            return new ReflectJavaEnumValueAnnotationArgument(r2, (Enum) r1);
        L6:
            if ((r1 instanceof Annotation) == false) goto L9;
            return new ReflectJavaAnnotationAsAnnotationArgument(r2, (Annotation) r1);
        L9:
            if ((r1 instanceof Object[]) == false) goto L12;
            return new ReflectJavaArrayAnnotationArgument(r2, (Object[]) r1);
        L12:
            if ((r1 instanceof Class) == false) goto L15;
            return new ReflectJavaClassObjectAnnotationArgument(r2, (Class) r1);
        L15:
            return new ReflectJavaLiteralAnnotationArgument(r2, r1);
        }
    }

    static {
        Factory = new Factory(null);
    }

    public /* synthetic */ ReflectJavaAnnotationArgument(Name r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    private ReflectJavaAnnotationArgument(Name r1) {
        this.name = r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument
    public Name getName() {
        return this.name;
    }
}
