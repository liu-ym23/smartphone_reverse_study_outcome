package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* JADX INFO: compiled from: PackagePartScopeCache.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PackagePartScopeCache {
    private final ConcurrentHashMap<ClassId, MemberScope> cache;
    private final ReflectKotlinClassFinder kotlinClassFinder;
    private final DeserializedDescriptorResolver resolver;

    public PackagePartScopeCache(DeserializedDescriptorResolver r2, ReflectKotlinClassFinder r3) {
        Intrinsics.checkNotNullParameter(r2, "resolver");
        Intrinsics.checkNotNullParameter(r3, "kotlinClassFinder");
        this.resolver = r2;
        this.kotlinClassFinder = r3;
        this.cache = new ConcurrentHashMap();
    }

    public final MemberScope getPackagePartScope(ReflectKotlinClass r10) {
        Intrinsics.checkNotNullParameter(r10, "fileClass");
        ConcurrentHashMap<ClassId, MemberScope> r0 = this.cache;
        ClassId r1 = r10.getClassId();
        MemberScope r2 = r0.get(r1);
        if (r2 != null) goto L24;
        FqName r3 = r10.getClassId().getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r3, "fileClass.classId.packageFqName");
        if (r10.getClassHeader().getKind() != KotlinClassHeader.Kind.MULTIFILE_CLASS) goto L13;
        List<String> r4 = r10.getClassHeader().getMultifilePartNames();
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        ClassId r7 = ClassId.topLevel(JvmClassName.byInternalName((String) r6.next()).getFqNameForTopLevelClassMaybeWithDollars());
        Intrinsics.checkNotNullExpressionValue(r7, "topLevel(JvmClassName.by…velClassMaybeWithDollars)");
        KotlinJvmBinaryClass r8 = KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, r7);
        if (r8 == null) goto L8;
        r5.add(r8);
        goto L8
    L12:
        ArrayList r9 = r5;
    L14:
        EmptyPackageFragmentDescriptor r11 = new EmptyPackageFragmentDescriptor(this.resolver.getComponents().getModuleDescriptor(), r3);
        ArrayList r12 = new ArrayList();
        Iterator r13 = r9.iterator();
    L16:
        if (r13.hasNext() == false) goto L20;
        MemberScope r14 = this.resolver.createKotlinPackagePartScope(r11, (KotlinJvmBinaryClass) r13.next());
        if (r14 == null) goto L16;
        r12.add(r14);
        goto L16
    L20:
        MemberScope r15 = ChainedMemberScope.Companion.create("package " + r3 + " (" + r10 + ')', CollectionsKt.toList(r12));
        MemberScope r16 = r0.putIfAbsent(r1, r15);
        if (r16 != null) goto L23;
        r2 = r15;
        goto L24
    L23:
        r2 = r16;
        goto L24
    L13:
        r9 = CollectionsKt.listOf(r10);
    L24:
        Intrinsics.checkNotNullExpressionValue(r2, "cache.getOrPut(fileClass…ileClass)\", scopes)\n    }");
        return r2;
    }
}
