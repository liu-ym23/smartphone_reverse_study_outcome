package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class CoreComponentFactory extends android.app.AppComponentFactory {

    public interface CompatWrapped {
        Object getWrapper();
    }

    public CoreComponentFactory() {
    }

    public static <T> T checkCompatWrapper(T r100) {
        if ((r100 instanceof CompatWrapped) == false) goto L7;
        T r101 = (T) ((CompatWrapped) r100).getWrapper();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return r100;
    }

    @Override // android.app.AppComponentFactory
    public Application instantiateApplication(ClassLoader r100, String r101) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Application) checkCompatWrapper(super.instantiateApplication(r100, r101));
    }

    @Override // android.app.AppComponentFactory
    public ContentProvider instantiateProvider(ClassLoader r100, String r101) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (ContentProvider) checkCompatWrapper(super.instantiateProvider(r100, r101));
    }

    @Override // android.app.AppComponentFactory
    public Activity instantiateActivity(ClassLoader r100, String r101, Intent r102) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Activity) checkCompatWrapper(super.instantiateActivity(r100, r101, r102));
    }

    @Override // android.app.AppComponentFactory
    public BroadcastReceiver instantiateReceiver(ClassLoader r100, String r101, Intent r102) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (BroadcastReceiver) checkCompatWrapper(super.instantiateReceiver(r100, r101, r102));
    }

    @Override // android.app.AppComponentFactory
    public Service instantiateService(ClassLoader r100, String r101, Intent r102) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Service) checkCompatWrapper(super.instantiateService(r100, r101, r102));
    }
}
