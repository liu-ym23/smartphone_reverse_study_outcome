package androidx.appcompat.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import androidx.annotation.DoNotInline;

/* JADX INFO: loaded from: classes.dex */
public final class AppLocalesMetadataHolderService extends Service {

    public static class a {
        @DoNotInline
        public static int a() {
            return 512;
        }
    }

    public AppLocalesMetadataHolderService() {
    }

    public static ServiceInfo a(Context r10) {
        int r11 = a.a() | 128;
        return r10.getPackageManager().getServiceInfo(new ComponentName(r10, AppLocalesMetadataHolderService.class), r11);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        throw new UnsupportedOperationException();
    }
}
