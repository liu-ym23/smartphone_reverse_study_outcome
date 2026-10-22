package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ReflectJavaArrayAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaArrayAnnotationArgument {
    private final Object[] values;

    public ReflectJavaArrayAnnotationArgument(Name r2, Object[] r3) {
        Intrinsics.checkNotNullParameter(r3, "values");
        super(r2, null);
        this.values = r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument
    public List<ReflectJavaAnnotationArgument> getElements() {
        Object[] r6 = this.values;
        ArrayList r0 = new ArrayList(r6.length);
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        Object r3 = r6[r2];
        ReflectJavaAnnotationArgument.Factory r4 = ReflectJavaAnnotationArgument.Factory;
        Intrinsics.checkNotNull(r3);
        r0.add(r4.create(r3, null));
        r2 = r2 + 1;
        goto L3
    L6:
        return r0;
    }
}
