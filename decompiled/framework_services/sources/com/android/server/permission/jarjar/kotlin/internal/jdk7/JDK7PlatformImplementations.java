package com.android.server.permission.jarjar.kotlin.internal.jdk7;

import com.android.server.permission.jarjar.kotlin.internal.PlatformImplementations;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JDK7PlatformImplementations.kt */
/* JADX INFO: loaded from: classes2.dex */
public class JDK7PlatformImplementations extends PlatformImplementations {

    /* JADX INFO: compiled from: JDK7PlatformImplementations.kt */
    private static final class ReflectSdkVersion {
        public static final ReflectSdkVersion INSTANCE = null;
        public static final Integer sdkVersion = null;

        private ReflectSdkVersion() {
        }

        static {
            INSTANCE = new ReflectSdkVersion();
            Integer r0 = null;
            Object r1 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);     // Catch: Throwable -> L7
            if ((r1 instanceof Integer) == false) goto L9;
            Integer r2 = (Integer) r1;     // Catch: Throwable -> L7
        L12:
            if (r2 == null) goto L19;
            int it = r2.intValue();
            if (it <= 0) goto L16;
            boolean r4 = true;
        L17:
            if (r4 == false) goto L19;
            r0 = r2;
            goto L19
        L16:
            r4 = false;
        L19:
            sdkVersion = r0;
            return;
        L9:
            r2 = null;
        L10:
            r2 = null;
            goto L12
        }
    }

    public JDK7PlatformImplementations() {
    }

    private final boolean sdkIsNullOrAtLeast(int version) {
        if (ReflectSdkVersion.sdkVersion != null) goto L5;
    L8:
        return true;
    L5:
        if (ReflectSdkVersion.sdkVersion.intValue() >= version) goto L8;
        return false;
    }

    @Override // com.android.server.permission.jarjar.kotlin.internal.PlatformImplementations
    public void addSuppressed(Throwable cause, Throwable exception) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (sdkIsNullOrAtLeast(19) == false) goto L5;
        cause.addSuppressed(exception);
        return;
    L5:
        super.addSuppressed(cause, exception);
    }
}
