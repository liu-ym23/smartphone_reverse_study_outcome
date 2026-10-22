package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;

/* JADX INFO: compiled from: ReflectJavaRecordComponent.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ReflectJavaRecordComponent extends ReflectJavaMember implements JavaRecordComponent {
    private final Object recordComponent;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent
    public boolean isVararg() {
        return false;
    }

    public ReflectJavaRecordComponent(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "recordComponent");
        this.recordComponent = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent
    public JavaType getType() {
        Class<?> r1 = Java16RecordComponentsLoader.INSTANCE.loadGetType(this.recordComponent);
        if (r1 == null) goto L7;
        return new ReflectJavaClassifierType(r1);
    L7:
        throw new NoSuchMethodError("Can't find `getType` method");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public Member getMember() {
        Method r1 = Java16RecordComponentsLoader.INSTANCE.loadGetAccessor(this.recordComponent);
        if (r1 == null) goto L7;
        return r1;
    L7:
        throw new NoSuchMethodError("Can't find `getAccessor` method");
    }
}
