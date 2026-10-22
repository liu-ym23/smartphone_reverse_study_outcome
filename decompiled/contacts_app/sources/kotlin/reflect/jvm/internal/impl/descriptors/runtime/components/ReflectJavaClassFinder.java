package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import com.obric.capabilitykit.common.Ext;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: compiled from: ReflectJavaClassFinder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ReflectJavaClassFinder implements JavaClassFinder {
    private final ClassLoader classLoader;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public Set<String> knownClassNamesInPackage(FqName r1) {
        Intrinsics.checkNotNullParameter(r1, "packageFqName");
        return null;
    }

    public ReflectJavaClassFinder(ClassLoader r2) {
        Intrinsics.checkNotNullParameter(r2, "classLoader");
        this.classLoader = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public JavaClass findClass(JavaClassFinder.Request r8) {
        Intrinsics.checkNotNullParameter(r8, Ext.KEY_REQUEST);
        ClassId r9 = r8.getClassId();
        FqName r0 = r9.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r0, "classId.packageFqName");
        String r1 = r9.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(r1, "classId.relativeClassName.asString()");
        String r10 = StringsKt.replace$default(r1, '.', Typography.dollar, false, 4, null);
        if (r0.isRoot() == true) goto L6;
        r10 = r0.asString() + '.' + r10;
    L6:
        Class<?> r7 = ReflectJavaClassFinderKt.tryLoadClass(this.classLoader, r10);
        if (r7 != null) goto L11;
        return null;
    L11:
        return new ReflectJavaClass(r7);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public JavaPackage findPackage(FqName r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "fqName");
        return new ReflectJavaPackage(r1);
    }
}
