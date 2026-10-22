package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: DeclaredMemberIndex.kt */
/* JADX INFO: loaded from: classes4.dex */
public class ClassDeclaredMemberIndex implements DeclaredMemberIndex {
    private final Map<Name, JavaRecordComponent> components;
    private final Map<Name, JavaField> fields;
    private final JavaClass jClass;
    private final Function1<JavaMember, Boolean> memberFilter;
    private final Function1<JavaMethod, Boolean> methodFilter;
    private final Map<Name, List<JavaMethod>> methods;

    /* JADX WARN: Multi-variable type inference failed */
    public ClassDeclaredMemberIndex(JavaClass r4, Function1<? super JavaMember, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r4, "jClass");
        Intrinsics.checkNotNullParameter(r5, "memberFilter");
        this.jClass = r4;
        this.memberFilter = r5;
        Function1<JavaMethod, Boolean> r6 = new ClassDeclaredMemberIndex$methodFilter$1(this);
        this.methodFilter = r6;
        Sequence r7 = SequencesKt.filter(CollectionsKt.asSequence(r4.getMethods()), r6);
        LinkedHashMap r8 = new LinkedHashMap();
        Iterator r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L9;
        Object r0 = r9.next();
        Name r1 = ((JavaMethod) r0).getName();
        Object r2 = r8.get(r1);
        if (r2 != null) goto L8;
        r2 = (List) new ArrayList();
        r8.put(r1, r2);
    L8:
        ((List) r2).add(r0);
        goto L4
    L9:
        this.methods = r8;
        Sequence r10 = SequencesKt.filter(CollectionsKt.asSequence(this.jClass.getFields()), this.memberFilter);
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator r12 = r10.iterator();
    L11:
        if (r12.hasNext() == false) goto L13;
        Object r3 = r12.next();
        r11.put(((JavaField) r3).getName(), r3);
        goto L11
    L13:
        this.fields = r11;
        Collection<JavaRecordComponent> r13 = this.jClass.getRecordComponents();
        Function1<JavaMember, Boolean> r14 = this.memberFilter;
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r13.iterator();
    L15:
        if (r16.hasNext() == false) goto L19;
        Object r17 = r16.next();
        if (r14.invoke((JavaMember) r17).booleanValue() == false) goto L15;
        r15.add(r17);
        goto L15
    L19:
        ArrayList r18 = r15;
        LinkedHashMap r19 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r18, 10)), 16));
        Iterator r20 = r18.iterator();
    L21:
        if (r20.hasNext() == false) goto L23;
        Object r21 = r20.next();
        r19.put(((JavaRecordComponent) r21).getName(), r21);
        goto L21
    L23:
        this.components = r19;
    }

    public static final /* synthetic */ Function1 access$getMemberFilter$p(ClassDeclaredMemberIndex r0) {
        return r0.memberFilter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Collection<JavaMethod> findMethodsByName(Name r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        List<JavaMethod> r1 = this.methods.get(r2);
        if (r1 != null) goto L7;
        r1 = CollectionsKt.emptyList();
    L7:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Set<Name> getMethodNames() {
        Sequence r2 = SequencesKt.filter(CollectionsKt.asSequence(this.jClass.getMethods()), this.methodFilter);
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        r0.add(((JavaMethod) r3.next()).getName());
        goto L4
    L7:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public JavaField findFieldByName(Name r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return this.fields.get(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Set<Name> getFieldNames() {
        Sequence r2 = SequencesKt.filter(CollectionsKt.asSequence(this.jClass.getFields()), this.memberFilter);
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        r0.add(((JavaField) r3.next()).getName());
        goto L4
    L7:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Set<Name> getRecordComponentNames() {
        return this.components.keySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public JavaRecordComponent findRecordComponentByName(Name r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return this.components.get(r2);
    }
}
