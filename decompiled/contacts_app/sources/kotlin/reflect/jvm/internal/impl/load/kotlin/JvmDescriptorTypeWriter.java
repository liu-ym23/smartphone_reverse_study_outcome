package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: typeSignatureMapping.kt */
/* JADX INFO: loaded from: classes4.dex */
public class JvmDescriptorTypeWriter<T> {
    private T jvmCurrentType;
    private int jvmCurrentTypeArrayLevel;
    private final JvmTypeFactory<T> jvmTypeFactory;

    public void writeArrayEnd() {
    }

    public void writeArrayType() {
        if (this.jvmCurrentType != null) goto L6;
        this.jvmCurrentTypeArrayLevel++;
        return;
    }

    public void writeClass(T r2) {
        Intrinsics.checkNotNullParameter(r2, "objectType");
        writeJvmTypeAsIs(r2);
    }

    protected final void writeJvmTypeAsIs(T r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        if (this.jvmCurrentType == null) goto L5;
        return;
    L5:
        if (this.jvmCurrentTypeArrayLevel <= 0) goto L7;
        r5 = this.jvmTypeFactory.createFromString(StringsKt.repeat("[", this.jvmCurrentTypeArrayLevel) + this.jvmTypeFactory.toString(r5));
    L7:
        this.jvmCurrentType = r5;
    }

    public void writeTypeVariable(Name r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "type");
        writeJvmTypeAsIs(r3);
    }
}
