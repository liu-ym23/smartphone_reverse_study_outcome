package androidx.lifecycle;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/lifecycle/PdpViewModelHelper;", "", "()V", "EmptyViewModel", "androidx/lifecycle/PdpViewModelHelper$EmptyViewModel$1", "Landroidx/lifecycle/PdpViewModelHelper$EmptyViewModel$1;", "cachedPutMethod", "Ljava/lang/reflect/Method;", "canInvokeDirectly", "", "clearViewModelByKey", "", ComplianceConstants.ComplianceRequest.MARKET_STORE, "Landroidx/lifecycle/ViewModelStore;", "key", "", "invokeViewModelStorePut", "viewModelStore", "viewModel", "Landroidx/lifecycle/ViewModel;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PdpViewModelHelper {
    private static final PdpViewModelHelper$EmptyViewModel$1 EmptyViewModel = null;
    public static final PdpViewModelHelper INSTANCE = null;
    private static Method cachedPutMethod;
    private static boolean canInvokeDirectly;

    private PdpViewModelHelper() {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.lifecycle.PdpViewModelHelper$EmptyViewModel$1] */
    static {
        INSTANCE = new PdpViewModelHelper();
        EmptyViewModel = new PdpViewModelHelper$EmptyViewModel$1();
        canInvokeDirectly = true;
    }

    public final void clearViewModelByKey(ViewModelStore r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        Intrinsics.checkNotNullParameter(r101, "key");
        if (canInvokeDirectly == true) goto L9;
    L7:
        invokeViewModelStorePut(r100, r101, EmptyViewModel);
        return;
    L9:
        r100.put(r101, EmptyViewModel);     // Catch: Throwable -> L6
        return;
    L6:
        canInvokeDirectly = false;
        goto L7
    }

    private final void invokeViewModelStorePut(ViewModelStore r110, String r111, ViewModel r112) {
        Class<?> r100 = r110.getClass();     // Catch: Throwable -> L31
        if (cachedPutMethod != null) goto L27;
        Method r101 = null;
        Method r102 = r100.getDeclaredMethod("put", new Class[]{String.class, ViewModel.class});     // Catch: NoSuchMethodException -> L8 Throwable -> L31
    L9:
        if (r102 != null) goto L24;
        Method[] r103 = r100.getDeclaredMethods();     // Catch: Throwable -> L31
        int r104 = r103.length;     // Catch: Throwable -> L31
        int r105 = 0;
    L11:
        if (r105 >= r104) goto L23;
        Method r106 = r103[r105];     // Catch: Throwable -> L31
        if (r106.getParameterTypes().length == 2) goto L15;
    L19:
        boolean r107 = false;
    L20:
        if (r107 == true) goto L21;
        r105 = r105 + 1;     // Catch: Throwable -> L31
        goto L11
    L21:
        r101 = r106;
        goto L23
    L15:
        if (Intrinsics.areEqual(r106.getParameterTypes()[0], String.class) == false) goto L19;
        if (ViewModel.class.isAssignableFrom(r106.getParameterTypes()[1]) == false) goto L19;
        r107 = true;
    L23:
        r102 = r101;
    L24:
        if (r102 == null) goto L26;
        r102.setAccessible(true);     // Catch: Throwable -> L31
    L26:
        cachedPutMethod = r102;     // Catch: Throwable -> L31
    L8:
        r102 = null;
    L27:
        Method r108 = cachedPutMethod;     // Catch: Throwable -> L31
        if (r108 == null) goto L40;
        r108.invoke(r110, new Object[]{r111, r112});     // Catch: Throwable -> L31
        return;
    L40:
        return;
    L31:
        th = move-exception;
        ECExceptionMonitor.e(th);
    }
}
