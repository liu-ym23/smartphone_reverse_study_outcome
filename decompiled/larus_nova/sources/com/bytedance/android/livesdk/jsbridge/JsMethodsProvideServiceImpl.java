package com.bytedance.android.livesdk.jsbridge;

import android.content.Context;
import com.bytedance.android.live.profile.api.IProfileService;
import com.bytedance.android.live.recharge.IRechargeServiceExternal;
import com.bytedance.android.livesdk.interactivity.api.ICommentService;
import com.bytedance.android.livesdkapi.jsb.IJsMethodsProvideService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n56.c;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J0\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/JsMethodsProvideServiceImpl;", "Lcom/bytedance/android/livesdkapi/jsb/IJsMethodsProvideService;", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "ctxRef", "Ln56/a;", "iesJsBridge", "", "", "Ln56/c;", "provideIJavaMethods", "Lcom/bytedance/android/livesdkapi/jsb/IJsMethodsProvideService$IFactory;", "factory", "", "registerFactory", "unregisterFactory", "unregisterAllFactory", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class JsMethodsProvideServiceImpl implements IJsMethodsProvideService {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Set<IJsMethodsProvideService.IFactory> f142022a = null;

        static {
            HashSet r100 = new HashSet();
            f142022a = r100;
            IRechargeServiceExternal r101 = (IRechargeServiceExternal) k.f(IRechargeServiceExternal.class);
            if (r101 == null) goto L7;
            IJsMethodsProvideService.IFactory r102 = r101.getRechargeJsFactory();
            if (r102 == null) goto L7;
            r100.add(r102);
        L7:
            ICommentService r103 = (ICommentService) k.f(ICommentService.class);
            if (r103 == null) goto L12;
            IJsMethodsProvideService.IFactory r104 = r103.getCommentJsFactory();
            if (r104 == null) goto L12;
            r100.add(r104);
        L12:
            r100.add(((IProfileService) k.n(IProfileService.class)).getLiveProfileJsFactory());
        }
    }

    public JsMethodsProvideServiceImpl() {
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IJsMethodsProvideService
    public synchronized void unregisterAllFactory() {
        monitor-enter(this);
        Set<IJsMethodsProvideService.IFactory> r100 = a.f142022a;     // Catch: Throwable -> L6
        ((HashSet) a.f142022a).clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IJsMethodsProvideService
    public synchronized void registerFactory(IJsMethodsProvideService.IFactory r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "factory");     // Catch: Throwable -> L6
        Set<IJsMethodsProvideService.IFactory> r101 = a.f142022a;     // Catch: Throwable -> L6
        ((HashSet) a.f142022a).add(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IJsMethodsProvideService
    public synchronized void unregisterFactory(IJsMethodsProvideService.IFactory r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "factory");     // Catch: Throwable -> L6
        Set<IJsMethodsProvideService.IFactory> r101 = a.f142022a;     // Catch: Throwable -> L6
        ((HashSet) a.f142022a).remove(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IJsMethodsProvideService
    public Map<String, c> provideIJavaMethods(WeakReference<Context> r100, n56.a r101) {
        HashMap r102 = new HashMap();
        Set<IJsMethodsProvideService.IFactory> r103 = a.f142022a;
        Set<IJsMethodsProvideService.IFactory> r104 = a.f142022a;
        if ((!r104.isEmpty()) == true) goto L6;
        r104 = null;
    L6:
        if (r104 == null) goto L13;
        Iterator<T> r105 = r104.iterator();
    L9:
        if (r105.hasNext() == false) goto L13;
        Map<String, c> r106 = ((IJsMethodsProvideService.IFactory) r105.next()).buildMethods(r100, r101);
        if (r106 == null) goto L9;
        r102.putAll(r106);
    L13:
        return r102;
    }
}
