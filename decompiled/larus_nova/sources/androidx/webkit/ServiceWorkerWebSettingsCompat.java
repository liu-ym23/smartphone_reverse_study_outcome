package androidx.webkit;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes17.dex */
public abstract class ServiceWorkerWebSettingsCompat {

    @Retention(RetentionPolicy.SOURCE)
    public @interface CacheMode {
    }

    public ServiceWorkerWebSettingsCompat() {
    }

    public abstract boolean getAllowContentAccess();

    public abstract boolean getAllowFileAccess();

    public abstract boolean getBlockNetworkLoads();

    public abstract int getCacheMode();

    public abstract int getRequestedWithHeaderMode();

    public abstract void setAllowContentAccess(boolean r100);

    public abstract void setAllowFileAccess(boolean r100);

    public abstract void setBlockNetworkLoads(boolean r100);

    public abstract void setCacheMode(int r100);

    public abstract void setRequestedWithHeaderMode(int r100);
}
