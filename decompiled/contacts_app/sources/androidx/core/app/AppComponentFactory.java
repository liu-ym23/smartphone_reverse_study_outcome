package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class AppComponentFactory extends android.app.AppComponentFactory {
    public AppComponentFactory() {
    }

    @Override // android.app.AppComponentFactory
    public final Activity instantiateActivity(ClassLoader r1, String r2, Intent r3) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Activity) CoreComponentFactory.checkCompatWrapper(instantiateActivityCompat(r1, r2, r3));
    }

    @Override // android.app.AppComponentFactory
    public final Application instantiateApplication(ClassLoader r1, String r2) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Application) CoreComponentFactory.checkCompatWrapper(instantiateApplicationCompat(r1, r2));
    }

    @Override // android.app.AppComponentFactory
    public final BroadcastReceiver instantiateReceiver(ClassLoader r1, String r2, Intent r3) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (BroadcastReceiver) CoreComponentFactory.checkCompatWrapper(instantiateReceiverCompat(r1, r2, r3));
    }

    @Override // android.app.AppComponentFactory
    public final ContentProvider instantiateProvider(ClassLoader r1, String r2) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (ContentProvider) CoreComponentFactory.checkCompatWrapper(instantiateProviderCompat(r1, r2));
    }

    @Override // android.app.AppComponentFactory
    public final Service instantiateService(ClassLoader r1, String r2, Intent r3) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Service) CoreComponentFactory.checkCompatWrapper(instantiateServiceCompat(r1, r2, r3));
    }

    public Application instantiateApplicationCompat(ClassLoader r1, String r2) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Application) Class.forName(r2, false, r1).asSubclass(Application.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    public Activity instantiateActivityCompat(ClassLoader r1, String r2, Intent r3) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Activity) Class.forName(r2, false, r1).asSubclass(Activity.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    public BroadcastReceiver instantiateReceiverCompat(ClassLoader r1, String r2, Intent r3) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (BroadcastReceiver) Class.forName(r2, false, r1).asSubclass(BroadcastReceiver.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    public Service instantiateServiceCompat(ClassLoader r1, String r2, Intent r3) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Service) Class.forName(r2, false, r1).asSubclass(Service.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    public ContentProvider instantiateProviderCompat(ClassLoader r1, String r2) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (ContentProvider) Class.forName(r2, false, r1).asSubclass(ContentProvider.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }
}
