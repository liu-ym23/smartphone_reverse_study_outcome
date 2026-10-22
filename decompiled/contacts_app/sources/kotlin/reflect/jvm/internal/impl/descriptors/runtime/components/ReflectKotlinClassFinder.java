package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsResourceLoader;

/* JADX INFO: compiled from: ReflectKotlinClassFinder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ReflectKotlinClassFinder implements KotlinClassFinder {
    private final BuiltInsResourceLoader builtInsResourceLoader;
    private final ClassLoader classLoader;

    public ReflectKotlinClassFinder(ClassLoader r2) {
        Intrinsics.checkNotNullParameter(r2, "classLoader");
        this.classLoader = r2;
        this.builtInsResourceLoader = new BuiltInsResourceLoader();
    }

    private final KotlinClassFinder.Result findKotlinClass(String r3) {
        Class<?> r2 = ReflectJavaClassFinderKt.tryLoadClass(this.classLoader, r3);
        KotlinClassFinder.Result.KotlinClass r4 = null;
        if (r2 == null) goto L8;
        ReflectKotlinClass r5 = ReflectKotlinClass.Factory.create(r2);
        if (r5 == null) goto L8;
        r4 = new KotlinClassFinder.Result.KotlinClass(r5, null, 2, null);
    L8:
        return r4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    public KotlinClassFinder.Result findKotlinClassOrContent(ClassId r2) {
        Intrinsics.checkNotNullParameter(r2, "classId");
        return findKotlinClass(ReflectKotlinClassFinderKt.access$toRuntimeFqName(r2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    public KotlinClassFinder.Result findKotlinClassOrContent(JavaClass r2) {
        Intrinsics.checkNotNullParameter(r2, "javaClass");
        FqName r3 = r2.getFqName();
        if (r3 == null) goto L9;
        String r4 = r3.asString();
        if (r4 != null) goto L8;
        return null;
    L8:
        return findKotlinClass(r4);
    L9:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder
    public InputStream findBuiltInsData(FqName r2) {
        Intrinsics.checkNotNullParameter(r2, "packageFqName");
        if (r2.startsWith(StandardNames.BUILT_INS_PACKAGE_NAME) == true) goto L7;
        return null;
    L7:
        return this.builtInsResourceLoader.loadResource(BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath(r2));
    }
}
