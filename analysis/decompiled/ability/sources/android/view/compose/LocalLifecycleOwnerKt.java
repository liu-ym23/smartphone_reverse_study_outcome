package android.view.compose;

import android.view.LifecycleOwner;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001d\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u000e\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"LocalLifecycleOwner", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/lifecycle/LifecycleOwner;", "getLocalLifecycleOwner$annotations", "()V", "getLocalLifecycleOwner", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "lifecycle-runtime-compose_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalLifecycleOwnerKt {
    private static final ProvidableCompositionLocal<LifecycleOwner> LocalLifecycleOwner;

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
    
        r1 = r1.invoke(null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:
    
        if ((r1 instanceof androidx.compose.runtime.ProvidableCompositionLocal) == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
    
        r1 = (androidx.compose.runtime.ProvidableCompositionLocal) r1;
     */
    static {
        /*
            r0 = 0
            java.lang.Class<androidx.lifecycle.LifecycleOwner> r1 = android.view.LifecycleOwner.class
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch: java.lang.Throwable -> L29
            kotlin.jvm.internal.k.c(r1)     // Catch: java.lang.Throwable -> L29
            java.lang.String r2 = "androidx.compose.ui.platform.AndroidCompositionLocals_androidKt"
            java.lang.String r3 = "getLocalLifecycleOwner"
            java.lang.Class r1 = r1.loadClass(r2)     // Catch: java.lang.Throwable -> L29
            java.lang.reflect.Method r1 = r1.getMethod(r3, r0)     // Catch: java.lang.Throwable -> L29
            java.lang.annotation.Annotation[] r2 = r1.getAnnotations()     // Catch: java.lang.Throwable -> L29
            int r3 = r2.length     // Catch: java.lang.Throwable -> L29
            r4 = 0
        L1c:
            if (r4 >= r3) goto L2b
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L29
            boolean r5 = r5 instanceof C7.c     // Catch: java.lang.Throwable -> L29
            if (r5 == 0) goto L26
        L24:
            r1 = r0
            goto L3a
        L26:
            int r4 = r4 + 1
            goto L1c
        L29:
            r1 = move-exception
            goto L36
        L2b:
            java.lang.Object r1 = r1.invoke(r0, r0)     // Catch: java.lang.Throwable -> L29
            boolean r2 = r1 instanceof androidx.compose.runtime.ProvidableCompositionLocal     // Catch: java.lang.Throwable -> L29
            if (r2 == 0) goto L24
            androidx.compose.runtime.ProvidableCompositionLocal r1 = (androidx.compose.runtime.ProvidableCompositionLocal) r1     // Catch: java.lang.Throwable -> L29
            goto L3a
        L36:
            kotlin.Result$Failure r1 = kotlin.b.a(r1)
        L3a:
            boolean r2 = r1 instanceof kotlin.Result.Failure
            if (r2 == 0) goto L3f
            goto L40
        L3f:
            r0 = r1
        L40:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = (androidx.compose.runtime.ProvidableCompositionLocal) r0
            if (r0 != 0) goto L4f
            P3.d r0 = new P3.d
            r1 = 15
            r0.<init>(r1)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.runtime.CompositionLocalKt.staticCompositionLocalOf(r0)
        L4f:
            android.view.compose.LocalLifecycleOwnerKt.LocalLifecycleOwner = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.compose.LocalLifecycleOwnerKt.<clinit>():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecycleOwner LocalLifecycleOwner$lambda$3$lambda$2() {
        throw new IllegalStateException("CompositionLocal LocalLifecycleOwner not present");
    }

    public static final ProvidableCompositionLocal<LifecycleOwner> getLocalLifecycleOwner() {
        return LocalLifecycleOwner;
    }

    public static /* synthetic */ void getLocalLifecycleOwner$annotations() {
    }
}
