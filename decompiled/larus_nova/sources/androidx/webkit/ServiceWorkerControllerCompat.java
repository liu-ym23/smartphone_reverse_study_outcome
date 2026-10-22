package androidx.webkit;

import androidx.webkit.internal.ServiceWorkerControllerImpl;

/* JADX INFO: loaded from: classes17.dex */
public abstract class ServiceWorkerControllerCompat {

    public static class LAZY_HOLDER {
        static final ServiceWorkerControllerCompat INSTANCE = null;

        private LAZY_HOLDER() {
        }

        static {
            INSTANCE = new ServiceWorkerControllerImpl();
        }
    }

    public ServiceWorkerControllerCompat() {
    }

    public abstract ServiceWorkerWebSettingsCompat getServiceWorkerWebSettings();

    public abstract void setServiceWorkerClient(ServiceWorkerClientCompat r100);

    public static ServiceWorkerControllerCompat getInstance() {
        return LAZY_HOLDER.INSTANCE;
    }
}
