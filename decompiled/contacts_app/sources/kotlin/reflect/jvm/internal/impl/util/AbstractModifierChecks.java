package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractModifierChecks {
    public abstract List<Checks> getChecks$descriptors();

    public AbstractModifierChecks() {
    }

    public final CheckResult check(FunctionDescriptor r3) {
        Intrinsics.checkNotNullParameter(r3, "functionDescriptor");
        Iterator<Checks> r2 = getChecks$descriptors().iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        Checks r0 = r2.next();
        if (r0.isApplicable(r3) == false) goto L4;
        return r0.checkAll(r3);
    L10:
        return CheckResult.IllegalFunctionName.INSTANCE;
    }
}
