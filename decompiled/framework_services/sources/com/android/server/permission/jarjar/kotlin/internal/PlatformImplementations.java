package com.android.server.permission.jarjar.kotlin.internal;

import com.android.server.permission.jarjar.kotlin.collections.ArraysKt;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: PlatformImplementations.kt */
/* JADX INFO: loaded from: classes2.dex */
public class PlatformImplementations {

    /* JADX INFO: compiled from: PlatformImplementations.kt */
    private static final class ReflectThrowable {
        public static final ReflectThrowable INSTANCE = null;
        public static final Method addSuppressed = null;
        public static final Method getSuppressed = null;

        private ReflectThrowable() {
        }

        static {
            INSTANCE = new ReflectThrowable();
            Method[] throwableMethods = Throwable.class.getMethods();
            Intrinsics.checkNotNull(throwableMethods);
            int r2 = throwableMethods.length;
            int r3 = 0;
            int r4 = 0;
        L3:
            Method r5 = null;
            if (r4 >= r2) goto L14;
            Method it = throwableMethods[r4];
            if (Intrinsics.areEqual(it.getName(), "addSuppressed") == false) goto L10;
            Class<?>[] r9 = it.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(r9, "getParameterTypes(...)");
            if (Intrinsics.areEqual(ArraysKt.singleOrNull(r9), Throwable.class) == false) goto L10;
            boolean r10 = true;
        L11:
            if (r10 == true) goto L15;
            r4 = r4 + 1;
        L15:
            addSuppressed = it;
            int r6 = throwableMethods.length;
        L17:
            if (r3 >= r6) goto L22;
            Method it2 = throwableMethods[r3];
            if (Intrinsics.areEqual(it2.getName(), "getSuppressed") == true) goto L20;
            r3 = r3 + 1;
            goto L17
        L20:
            r5 = it2;
        L22:
            getSuppressed = r5;
            return;
        L10:
            r10 = false;
            goto L11
        L14:
            it = null;
            goto L15
        }
    }

    public PlatformImplementations() {
    }

    public void addSuppressed(Throwable cause, Throwable exception) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Method r0 = ReflectThrowable.addSuppressed;
        if (r0 == null) goto L6;
        r0.invoke(cause, new Object[]{exception});
        return;
    }
}
