package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
public class AppComponentFactory extends android.app.AppComponentFactory {
    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    public AppComponentFactory() {
    }

    @Override // android.app.AppComponentFactory
    public final Application instantiateApplication(ClassLoader r100, String r101) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Application) CoreComponentFactory.checkCompatWrapper(instantiateApplicationCompat(r100, r101));
    }

    public Application instantiateApplicationCompat(ClassLoader r100, String r101) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Application) INVOKESTATIC_androidx_core_app_AppComponentFactory_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101, false, r100).asSubclass(Application.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    @Override // android.app.AppComponentFactory
    public final ContentProvider instantiateProvider(ClassLoader r100, String r101) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (ContentProvider) CoreComponentFactory.checkCompatWrapper(instantiateProviderCompat(r100, r101));
    }

    public ContentProvider instantiateProviderCompat(ClassLoader r100, String r101) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (ContentProvider) INVOKESTATIC_androidx_core_app_AppComponentFactory_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101, false, r100).asSubclass(ContentProvider.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_core_app_AppComponentFactory_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    @Override // android.app.AppComponentFactory
    public final Activity instantiateActivity(ClassLoader r100, String r101, Intent r102) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Activity) CoreComponentFactory.checkCompatWrapper(instantiateActivityCompat(r100, r101, r102));
    }

    public Activity instantiateActivityCompat(ClassLoader r100, String r101, Intent r102) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Activity) INVOKESTATIC_androidx_core_app_AppComponentFactory_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101, false, r100).asSubclass(Activity.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    @Override // android.app.AppComponentFactory
    public final BroadcastReceiver instantiateReceiver(ClassLoader r100, String r101, Intent r102) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (BroadcastReceiver) CoreComponentFactory.checkCompatWrapper(instantiateReceiverCompat(r100, r101, r102));
    }

    public BroadcastReceiver instantiateReceiverCompat(ClassLoader r100, String r101, Intent r102) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (BroadcastReceiver) INVOKESTATIC_androidx_core_app_AppComponentFactory_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101, false, r100).asSubclass(BroadcastReceiver.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    @Override // android.app.AppComponentFactory
    public final Service instantiateService(ClassLoader r100, String r101, Intent r102) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Service) CoreComponentFactory.checkCompatWrapper(instantiateServiceCompat(r100, r101, r102));
    }

    public Service instantiateServiceCompat(ClassLoader r100, String r101, Intent r102) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Service) INVOKESTATIC_androidx_core_app_AppComponentFactory_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101, false, r100).asSubclass(Service.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }
}
