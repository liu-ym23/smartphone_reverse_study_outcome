package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface Check {

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class DefaultImpls {
        public static String invoke(Check r1, FunctionDescriptor r2) {
            Intrinsics.checkNotNullParameter(r2, "functionDescriptor");
            if (r1.check(r2) == false) goto L7;
            return null;
        L7:
            return r1.getDescription();
        }
    }

    boolean check(FunctionDescriptor r1);

    String getDescription();

    String invoke(FunctionDescriptor r1);
}
