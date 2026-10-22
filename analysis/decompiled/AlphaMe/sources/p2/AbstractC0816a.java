package p2;

import android.app.ActivityThread;
import android.net.Uri;
import android.os.Bundle;
import com.stepos.activeview.utils.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: p2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0816a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f13930a = 0;

    static {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        Intrinsics.checkNotNullExpressionValue(Executors.newSingleThreadScheduledExecutor(), "newSingleThreadScheduledExecutor(...)");
    }

    public static Bundle a(String methodName, Bundle paramsBundle) {
        Intrinsics.checkNotNullParameter("com.stepos.appplatform", "authority");
        Intrinsics.checkNotNullParameter("com.stepos.appplatform.alphame.AlphaMeSettingsSystem", Constants.JSON_KEY_SERVICE_NAME);
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(paramsBundle, "paramsBundle");
        Uri uri = Uri.parse("content://com.stepos.appplatform.PERF_BINDER_IPC_CALL");
        Bundle bundle = new Bundle();
        bundle.putString(Constants.JSON_KEY_SERVICE_NAME, "com.stepos.appplatform.alphame.AlphaMeSettingsSystem");
        bundle.putString("methodName", methodName);
        bundle.putBundle("params", paramsBundle);
        Bundle bundleCall = ActivityThread.currentApplication().getContentResolver().call(uri, "perfbinder", "", bundle);
        Intrinsics.checkNotNull(bundleCall);
        return bundleCall;
    }
}
