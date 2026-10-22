package androidx.webkit.internal;

import android.content.Context;
import android.webkit.ServiceWorkerClient;
import android.webkit.ServiceWorkerController;
import android.webkit.ServiceWorkerWebSettings;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import androidx.webkit.ServiceWorkerClientCompat;
import java.io.File;

/* JADX INFO: loaded from: classes17.dex */
public class ApiHelperForN {
    public static ServiceWorkerController getServiceWorkerControllerInstance() {
        return ServiceWorkerController.getInstance();
    }

    private ApiHelperForN() {
    }

    public static boolean getAllowContentAccess(ServiceWorkerWebSettings r100) {
        return r100.getAllowContentAccess();
    }

    public static boolean getAllowFileAccess(ServiceWorkerWebSettings r100) {
        return r100.getAllowFileAccess();
    }

    public static boolean getBlockNetworkLoads(ServiceWorkerWebSettings r100) {
        return r100.getBlockNetworkLoads();
    }

    public static int getCacheMode(ServiceWorkerWebSettings r100) {
        return r100.getCacheMode();
    }

    public static File getDataDir(Context r100) {
        return r100.getDataDir();
    }

    public static int getDisabledActionModeMenuItems(WebSettings r100) {
        return r100.getDisabledActionModeMenuItems();
    }

    public static ServiceWorkerWebSettings getServiceWorkerWebSettings(ServiceWorkerController r100) {
        return r100.getServiceWorkerWebSettings();
    }

    public static ServiceWorkerWebSettingsImpl getServiceWorkerWebSettingsImpl(ServiceWorkerController r100) {
        return new ServiceWorkerWebSettingsImpl(getServiceWorkerWebSettings(r100));
    }

    public static boolean isRedirect(WebResourceRequest r100) {
        return r100.isRedirect();
    }

    public static void setAllowContentAccess(ServiceWorkerWebSettings r100, boolean r101) {
        r100.setAllowContentAccess(r101);
    }

    public static void setAllowFileAccess(ServiceWorkerWebSettings r100, boolean r101) {
        r100.setAllowFileAccess(r101);
    }

    public static void setBlockNetworkLoads(ServiceWorkerWebSettings r100, boolean r101) {
        r100.setBlockNetworkLoads(r101);
    }

    public static void setCacheMode(ServiceWorkerWebSettings r100, int r101) {
        r100.setCacheMode(r101);
    }

    public static void setDisabledActionModeMenuItems(WebSettings r100, int r101) {
        r100.setDisabledActionModeMenuItems(r101);
    }

    public static void setServiceWorkerClient(ServiceWorkerController r100, ServiceWorkerClient r101) {
        r100.setServiceWorkerClient(r101);
    }

    public static void setServiceWorkerClientCompat(ServiceWorkerController r100, ServiceWorkerClientCompat r101) {
        r100.setServiceWorkerClient(new FrameworkServiceWorkerClient(r101));
    }
}
