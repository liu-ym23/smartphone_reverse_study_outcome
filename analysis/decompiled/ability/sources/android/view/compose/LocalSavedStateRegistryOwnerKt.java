package android.view.compose;

import android.view.SavedStateRegistryOwner;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"LocalSavedStateRegistryOwner", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/savedstate/SavedStateRegistryOwner;", "getLocalSavedStateRegistryOwner", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "savedstate-compose_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalSavedStateRegistryOwnerKt {
    private static final ProvidableCompositionLocal<SavedStateRegistryOwner> LocalSavedStateRegistryOwner;

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
    
        r1 = r1.invoke(null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0036, code lost:
    
        if ((r1 instanceof androidx.compose.runtime.ProvidableCompositionLocal) == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
    
        r1 = (androidx.compose.runtime.ProvidableCompositionLocal) r1;
     */
    static {
        /*
            r0 = 0
            java.lang.Class<androidx.savedstate.SavedStateRegistryOwner> r1 = android.view.SavedStateRegistryOwner.class
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch: java.lang.Throwable -> L2e
            kotlin.jvm.internal.k.c(r1)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r2 = "androidx.compose.ui.platform.AndroidCompositionLocals_androidKt"
            java.lang.String r3 = "getLocalSavedStateRegistryOwner"
            java.lang.Class r1 = r1.loadClass(r2)     // Catch: java.lang.Throwable -> L2e
            java.lang.reflect.Method r1 = r1.getMethod(r3, r0)     // Catch: java.lang.Throwable -> L2e
            java.lang.annotation.Annotation[] r2 = r1.getAnnotations()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r3 = "getAnnotations(...)"
            kotlin.jvm.internal.k.e(r2, r3)     // Catch: java.lang.Throwable -> L2e
            int r3 = r2.length     // Catch: java.lang.Throwable -> L2e
            r4 = 0
        L21:
            if (r4 >= r3) goto L30
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L2e
            boolean r5 = r5 instanceof C7.c     // Catch: java.lang.Throwable -> L2e
            if (r5 == 0) goto L2b
        L29:
            r1 = r0
            goto L3f
        L2b:
            int r4 = r4 + 1
            goto L21
        L2e:
            r1 = move-exception
            goto L3b
        L30:
            java.lang.Object r1 = r1.invoke(r0, r0)     // Catch: java.lang.Throwable -> L2e
            boolean r2 = r1 instanceof androidx.compose.runtime.ProvidableCompositionLocal     // Catch: java.lang.Throwable -> L2e
            if (r2 == 0) goto L29
            androidx.compose.runtime.ProvidableCompositionLocal r1 = (androidx.compose.runtime.ProvidableCompositionLocal) r1     // Catch: java.lang.Throwable -> L2e
            goto L3f
        L3b:
            kotlin.Result$Failure r1 = kotlin.b.a(r1)
        L3f:
            boolean r2 = r1 instanceof kotlin.Result.Failure
            if (r2 == 0) goto L44
            goto L45
        L44:
            r0 = r1
        L45:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = (androidx.compose.runtime.ProvidableCompositionLocal) r0
            if (r0 != 0) goto L54
            com.uxsense.parse.a r0 = new com.uxsense.parse.a
            r1 = 27
            r0.<init>(r1)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.runtime.CompositionLocalKt.staticCompositionLocalOf(r0)
        L54:
            android.view.compose.LocalSavedStateRegistryOwnerKt.LocalSavedStateRegistryOwner = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.compose.LocalSavedStateRegistryOwnerKt.<clinit>():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SavedStateRegistryOwner LocalSavedStateRegistryOwner$lambda$3$lambda$2() {
        throw new IllegalStateException("CompositionLocal LocalSavedStateRegistryOwner not present");
    }

    public static final ProvidableCompositionLocal<SavedStateRegistryOwner> getLocalSavedStateRegistryOwner() {
        return LocalSavedStateRegistryOwner;
    }
}
