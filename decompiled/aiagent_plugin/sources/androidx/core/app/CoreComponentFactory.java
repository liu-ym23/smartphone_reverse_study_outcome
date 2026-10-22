package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Intent;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class CoreComponentFactory extends android.app.AppComponentFactory {

    public interface a {
        Object a();
    }

    public CoreComponentFactory() {
    }

    @Override // android.app.AppComponentFactory
    public Activity instantiateActivity(ClassLoader r1, String r2, Intent r3) {
        return (Activity) ZeusTransformUtils.preCheckCast(checkCompatWrapper((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(super.instantiateActivity(r1, r2, r3), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin")), Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // android.app.AppComponentFactory
    public Application instantiateApplication(ClassLoader r1, String r2) {
        return (Application) ZeusTransformUtils.preCheckCast(checkCompatWrapper((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(super.instantiateApplication(r1, r2), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")), Application.class, "com.obric.aiagent.plugin");
    }

    @Override // android.app.AppComponentFactory
    public PluginBroadcastReceiver instantiateReceiver(ClassLoader r1, String r2, Intent r3) {
        return (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(checkCompatWrapper(super.instantiateReceiver(r1, r2, r3)), PluginBroadcastReceiver.class, "com.obric.aiagent.plugin");
    }

    @Override // android.app.AppComponentFactory
    public PluginContentProvider instantiateProvider(ClassLoader r1, String r2) {
        return (PluginContentProvider) ZeusTransformUtils.preCheckCast(checkCompatWrapper(super.instantiateProvider(r1, r2)), PluginContentProvider.class, "com.obric.aiagent.plugin");
    }

    @Override // android.app.AppComponentFactory
    public Service instantiateService(ClassLoader r1, String r2, Intent r3) {
        return (Service) ZeusTransformUtils.preCheckCast(checkCompatWrapper((Service) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(super.instantiateService(r1, r2, r3), "com.obric.aiagent.plugin"), Service.class, "com.obric.aiagent.plugin")), Service.class, "com.obric.aiagent.plugin");
    }

    static <T> T checkCompatWrapper(T r2) {
        if (ZeusTransformUtils.instanceOf(r2, a.class) == false) goto L7;
        T r0 = (T) ((a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.aiagent.plugin")).a();
        if (r0 == null) goto L7;
        return r0;
    L7:
        return r2;
    }
}
