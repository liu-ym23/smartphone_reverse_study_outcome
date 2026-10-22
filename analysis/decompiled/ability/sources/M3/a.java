package M3;

import android.app.appfunctions.AppFunctionException;
import android.app.appfunctions.AppFunctionManager;
import android.app.appfunctions.ExecuteAppFunctionRequest;
import android.app.appfunctions.ExecuteAppFunctionResponse;
import android.app.appsearch.GenericDocument;
import android.os.Bundle;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ void C() {
    }

    public static /* synthetic */ void D() {
    }

    public static /* synthetic */ AppFunctionException b(int i, String str, Bundle bundle) {
        return new AppFunctionException(i, str, bundle);
    }

    public static /* bridge */ /* synthetic */ AppFunctionException c(Throwable th) {
        return (AppFunctionException) th;
    }

    public static /* bridge */ /* synthetic */ AppFunctionManager d(Object obj) {
        return (AppFunctionManager) obj;
    }

    public static /* synthetic */ ExecuteAppFunctionRequest.Builder g(String str, String str2) {
        return new ExecuteAppFunctionRequest.Builder(str, str2);
    }

    public static /* synthetic */ ExecuteAppFunctionResponse i(GenericDocument genericDocument, Bundle bundle) {
        return new ExecuteAppFunctionResponse(genericDocument, bundle);
    }

    public static /* bridge */ /* synthetic */ ExecuteAppFunctionResponse j(Object obj) {
        return (ExecuteAppFunctionResponse) obj;
    }

    public static /* bridge */ /* synthetic */ Class p() {
        return AppFunctionManager.class;
    }

    public static /* synthetic */ void t() {
    }

    public static /* bridge */ /* synthetic */ boolean y(Throwable th) {
        return th instanceof AppFunctionException;
    }
}
