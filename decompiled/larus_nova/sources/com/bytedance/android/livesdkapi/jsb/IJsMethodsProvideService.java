package com.bytedance.android.livesdkapi.jsb;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import n56.a;
import n56.c;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.jsbridge.JsMethodsProvideServiceImpl")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001:\u0001\u0011J0\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH&J\b\u0010\u0010\u001a\u00020\rH&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/jsb/IJsMethodsProvideService;", "Lcom/bytedance/android/live/base/IService;", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "ctxRef", "Ln56/a;", "iesJsBridge", "", "", "Ln56/c;", "provideIJavaMethods", "Lcom/bytedance/android/livesdkapi/jsb/IJsMethodsProvideService$IFactory;", "factory", "", "registerFactory", "unregisterFactory", "unregisterAllFactory", "IFactory", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IJsMethodsProvideService extends IService {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/jsb/IJsMethodsProvideService$IFactory;", "", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "ctxRef", "Ln56/a;", "iesJsBridge", "", "", "Ln56/c;", "buildMethods", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IFactory {
        Map<String, c> buildMethods(WeakReference<Context> r100, a r101);
    }

    Map<String, c> provideIJavaMethods(WeakReference<Context> r100, a r101);

    void registerFactory(IFactory r100);

    void unregisterAllFactory();

    void unregisterFactory(IFactory r100);
}
