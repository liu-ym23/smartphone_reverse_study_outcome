package androidx.core.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 28)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class CoreComponentFactory extends AppComponentFactory {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface CompatWrapped {
        Object getWrapper();
    }

    public CoreComponentFactory() {
    }

    public static Object a(Object r10) {
        if ((r10 instanceof CompatWrapped) == false) goto L7;
        Object r11 = ((CompatWrapped) r10).getWrapper();
        if (r11 == null) goto L7;
        return r11;
    L7:
        return r10;
    }

    @Override // android.app.AppComponentFactory
    public Activity instantiateActivity(ClassLoader r10, String r11, Intent r12) {
        return (Activity) a(super.instantiateActivity(r10, r11, r12));
    }

    @Override // android.app.AppComponentFactory
    public Application instantiateApplication(ClassLoader r10, String r11) {
        return (Application) a(super.instantiateApplication(r10, r11));
    }

    @Override // android.app.AppComponentFactory
    public ContentProvider instantiateProvider(ClassLoader r10, String r11) {
        return (ContentProvider) a(super.instantiateProvider(r10, r11));
    }

    @Override // android.app.AppComponentFactory
    public BroadcastReceiver instantiateReceiver(ClassLoader r10, String r11, Intent r12) {
        return (BroadcastReceiver) a(super.instantiateReceiver(r10, r11, r12));
    }

    @Override // android.app.AppComponentFactory
    public Service instantiateService(ClassLoader r10, String r11, Intent r12) {
        return (Service) a(super.instantiateService(r10, r11, r12));
    }
}
