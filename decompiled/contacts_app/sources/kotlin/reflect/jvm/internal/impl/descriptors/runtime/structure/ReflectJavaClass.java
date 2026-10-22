package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: ReflectJavaClass.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ReflectJavaClass extends ReflectJavaElement implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaClass {
    private final Class<?> klass;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public LightClassOriginKind getLightClassOriginKind() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean hasDefaultConstructor() {
        return false;
    }

    public static final /* synthetic */ boolean access$isEnumValuesOrValueOf(ReflectJavaClass r0, Method r1) {
        return r0.isEnumValuesOrValueOf(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public ReflectJavaAnnotation findAnnotation(FqName r1) {
        return ReflectJavaAnnotationOwner.DefaultImpls.findAnnotation(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public /* bridge */ /* synthetic */ JavaAnnotation findAnnotation(FqName r1) {
        return findAnnotation(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner.DefaultImpls.getAnnotations(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public /* bridge */ /* synthetic */ Collection getConstructors() {
        return getConstructors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    public /* bridge */ /* synthetic */ AnnotatedElement getElement() {
        return getElement();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public /* bridge */ /* synthetic */ Collection getFields() {
        return getFields();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public /* bridge */ /* synthetic */ Collection getInnerClassNames() {
        return getInnerClassNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public /* bridge */ /* synthetic */ Collection getMethods() {
        return getMethods();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public /* bridge */ /* synthetic */ JavaClass getOuterClass() {
        return getOuterClass();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public Visibility getVisibility() {
        return ReflectJavaModifierListOwner.DefaultImpls.getVisibility(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isAbstract() {
        return ReflectJavaModifierListOwner.DefaultImpls.isAbstract(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.DefaultImpls.isDeprecatedInJavaDoc(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isFinal() {
        return ReflectJavaModifierListOwner.DefaultImpls.isFinal(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isStatic() {
        return ReflectJavaModifierListOwner.DefaultImpls.isStatic(this);
    }

    public ReflectJavaClass(Class<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "klass");
        this.klass = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    public Class<?> getElement() {
        return this.klass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner
    public int getModifiers() {
        return this.klass.getModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public List<Name> getInnerClassNames() {
        Class<?>[] r1 = this.klass.getDeclaredClasses();
        Intrinsics.checkNotNullExpressionValue(r1, "klass.declaredClasses");
        return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.filterNot(ArraysKt.asSequence(r1), ReflectJavaClass$innerClassNames$1.INSTANCE), ReflectJavaClass$innerClassNames$2.INSTANCE));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public FqName getFqName() {
        FqName r1 = ReflectClassUtilKt.getClassId(this.klass).asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(r1, "klass.classId.asSingleFqName()");
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public ReflectJavaClass getOuterClass() {
        Class<?> r1 = this.klass.getDeclaringClass();
        if (r1 != null) goto L7;
        return null;
    L7:
        return new ReflectJavaClass(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public Collection<JavaClassifierType> getSupertypes() {
        if (Intrinsics.areEqual(this.klass, Object.class) == true) goto L5;
        SpreadBuilder r0 = new SpreadBuilder(2);
        Class r1 = this.klass.getGenericSuperclass();
        if (r1 != null) goto L9;
    L9:
        r0.add(r1);
        Type[] r3 = this.klass.getGenericInterfaces();
        Intrinsics.checkNotNullExpressionValue(r3, "klass.genericInterfaces");
        r0.addSpread(r3);
        List r4 = CollectionsKt.listOf(r0.toArray(new Type[r0.size()]));
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L14;
        r2.add(new ReflectJavaClassifierType((Type) r5.next()));
        goto L11
    L14:
        return r2;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public List<ReflectJavaMethod> getMethods() {
        Method[] r0 = this.klass.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(r0, "klass.declaredMethods");
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filter(ArraysKt.asSequence(r0), new ReflectJavaClass$methods$1(this)), ReflectJavaClass$methods$2.INSTANCE));
    }

    private final boolean isEnumValuesOrValueOf(Method r4) {
        String r3 = r4.getName();
        if (Intrinsics.areEqual(r3, "values") == false) goto L8;
        Class<?>[] r5 = r4.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(r5, "method.parameterTypes");
        if (r5.length != 0) goto L11;
        return true;
    L11:
        return false;
    L8:
        if (Intrinsics.areEqual(r3, "valueOf") == false) goto L11;
        return Arrays.equals(r4.getParameterTypes(), new Class[]{String.class});
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public List<ReflectJavaField> getFields() {
        Field[] r1 = this.klass.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(r1, "klass.declaredFields");
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filterNot(ArraysKt.asSequence(r1), ReflectJavaClass$fields$1.INSTANCE), ReflectJavaClass$fields$2.INSTANCE));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public List<ReflectJavaConstructor> getConstructors() {
        Constructor<?>[] r1 = this.klass.getDeclaredConstructors();
        Intrinsics.checkNotNullExpressionValue(r1, "klass.declaredConstructors");
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filterNot(ArraysKt.asSequence(r1), ReflectJavaClass$constructors$1.INSTANCE), ReflectJavaClass$constructors$2.INSTANCE));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    public Name getName() {
        Name r1 = Name.identifier(this.klass.getSimpleName());
        Intrinsics.checkNotNullExpressionValue(r1, "identifier(klass.simpleName)");
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable<Class<?>>[] r5 = this.klass.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r5, "klass.typeParameters");
        TypeVariable<Class<?>>[] r6 = r5;
        ArrayList r0 = new ArrayList(r6.length);
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.add(new ReflectJavaTypeParameter(r6[r2]));
        r2 = r2 + 1;
        goto L3
    L6:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isInterface() {
        return this.klass.isInterface();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isAnnotationType() {
        return this.klass.isAnnotation();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isEnum() {
        return this.klass.isEnum();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isRecord() {
        Boolean r1 = Java16SealedRecordLoader.INSTANCE.loadIsRecord(this.klass);
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public Collection<JavaRecordComponent> getRecordComponents() {
        Object[] r5 = Java16SealedRecordLoader.INSTANCE.loadGetRecordComponents(this.klass);
        int r0 = 0;
        if (r5 != null) goto L5;
        r5 = new Object[0];
    L5:
        ArrayList r1 = new ArrayList(r5.length);
        int r2 = r5.length;
    L6:
        if (r0 >= r2) goto L9;
        r1.add(new ReflectJavaRecordComponent(r5[r0]));
        r0 = r0 + 1;
        goto L6
    L9:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isSealed() {
        Boolean r1 = Java16SealedRecordLoader.INSTANCE.loadIsSealed(this.klass);
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public Collection<JavaClassifierType> getPermittedTypes() {
        Class<?>[] r5 = Java16SealedRecordLoader.INSTANCE.loadGetPermittedSubclasses(this.klass);
        if (r5 == null) goto L9;
        ArrayList r0 = new ArrayList(r5.length);
        int r1 = r5.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L11;
        r0.add(new ReflectJavaClassifierType(r5[r2]));
        r2 = r2 + 1;
        goto L5
    L11:
        return r0;
    L9:
        return CollectionsKt.emptyList();
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof ReflectJavaClass) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.klass, ((ReflectJavaClass) r2).klass) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + this.klass;
    }
}
