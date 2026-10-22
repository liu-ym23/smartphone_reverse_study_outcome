package com.bytedance.android.live.browser;

import android.os.Bundle;
import com.bytedance.android.live.browser.jsbridge.newmethods.FetchV3Method;
import com.bytedance.android.live.browser.jsbridge.newmethods.MeasureTextMethod;
import com.bytedance.android.live.browser.jsbridge.newmethods.e4;
import com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment;
import com.bytedance.android.live.browser.webview.fragment.WebDialogFragmentForAnnie;
import com.bytedance.android.livesdk.jsbridge.methods.f5;
import com.bytedance.android.livesdkapi.base.ILiveBrowserFragment;
import com.bytedance.android.livesdkapi.jsb.ExternalJsBridgeMethodInjector;
import com.bytedance.sdk.xbridge.cn.network.XRequestMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001e\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001e\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/browser/H5AssistService;", "Lcom/bytedance/android/live/browser/IH5AssistService;", "Landroid/os/Bundle;", "bundle", "Lcom/bytedance/android/livesdkapi/base/ILiveBrowserFragment;", "createSaaSDeprecatedBrowserFragment", "Lcom/bytedance/android/live/browser/webview/fragment/BaseWebDialogFragment;", "createWebDialogFragment", "Lcom/bytedance/android/annie/xbridge/mix/e;", "getExternalMethodInjector", "", "bid", "", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "providerMethod", "providerPreHandleMethod", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class H5AssistService implements IH5AssistService {

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f62556a = null;

        static {
            f62556a = new a();
        }

        public a() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new FetchV3Method();
        }
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f62557a = null;

        static {
            f62557a = new b();
        }

        public b() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new MeasureTextMethod();
        }
    }

    public static final class c implements com.bytedance.android.annie.xbridge.mix.e {
        public c() {
        }

        @Override // com.bytedance.android.annie.xbridge.mix.e
        public final Map<String, Object> a() {
            LinkedHashMap r100 = new LinkedHashMap();
            Iterator<T> r101 = ExternalJsBridgeMethodInjector.INSTANCE.getLegacyMethodsProviders().iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r100.putAll((Map) ((Function0) r101.next()).invoke());
            goto L4
        L6:
            Iterator<T> r102 = ExternalJsBridgeMethodInjector.INSTANCE.getStatelessMethodsProviders().iterator();
        L8:
            if (r102.hasNext() == false) goto L10;
            r100.putAll((Map) ((Function0) r102.next()).invoke());
            goto L8
        L10:
            Iterator<T> r103 = ExternalJsBridgeMethodInjector.INSTANCE.getStatefulMethodsProviders().iterator();
        L12:
            if (r103.hasNext() == false) goto L14;
            r100.putAll((Map) ((Function0) r103.next()).invoke());
            goto L12
        L14:
            return r100;
        }
    }

    public H5AssistService() {
    }

    @Override // com.bytedance.android.live.browser.IH5AssistService
    public ILiveBrowserFragment createSaaSDeprecatedBrowserFragment(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        return null;
    }

    @Override // com.bytedance.android.live.browser.IH5AssistService
    public BaseWebDialogFragment createWebDialogFragment() {
        return new WebDialogFragmentForAnnie();
    }

    @Override // com.bytedance.android.live.browser.IH5AssistService
    public com.bytedance.android.annie.xbridge.mix.e getExternalMethodInjector() {
        List<String> r100 = com.bytedance.android.annie.xbridge.mix.s.f40190a;
        a r101 = a.f62556a;
        Intrinsics.checkNotNullParameter("fetch", "name");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        ConcurrentHashMap<String, com.bytedance.ies.web.jsbridge2.f.b> r102 = com.bytedance.android.annie.xbridge.mix.m.f40176a;
        r102.put("fetch", r101);
        b r103 = b.f62557a;
        Intrinsics.checkNotNullParameter("measureText", "name");
        Intrinsics.checkNotNullParameter(r103, ShortVideoSegments.KEY_PROP_PROVIDER);
        r102.put("measureText", r103);
        Intrinsics.checkNotNullParameter("__getCurrentState", "name");
        Intrinsics.checkNotNullParameter(e4.class, com.alipay.sdk.m.p.e.f25671s);
        com.bytedance.android.annie.xbridge.mix.m.f40177b.put("__getCurrentState", e4.class);
        return new c();
    }

    @Override // com.bytedance.android.live.browser.IH5AssistService
    public Map<String, IDLXBridgeMethod> providerMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("x.getAppInfo", new vd7.d());
        r101.put("x.getAPIParams", new de7.c());
        r101.put("x.getUserInfo", new jd7.e());
        r101.put("x.getSettings", new vd7.e());
        r101.put("x.setStorageItem", new ve7.h());
        r101.put("x.getStorageItem", new ve7.f());
        r101.put("x.getStorageInfo", new ve7.e());
        r101.put("x.removeStorageItem", new ve7.g());
        r101.put("x.reportAppLog", new wd7.h());
        r101.put("x.reportMonitorLog", new wd7.i());
        r101.put("x.reportALog", new wd7.g());
        r101.put("x.request", new XRequestMethod());
        int r102 = com.bytedance.ies.bullet.base.bridge.i.f246288a;
        r101.put("x.subscribeEvent", com.bytedance.ies.bullet.base.bridge.i.c(new a66.c()));
        r101.put("x.unsubscribeEvent", com.bytedance.ies.bullet.base.bridge.i.c(new a66.d()));
        r101.put("x.publishEvent", com.bytedance.ies.bullet.base.bridge.i.c(new a66.a()));
        FetchV3Method r103 = new FetchV3Method();
        r103.f63243d = true;
        Unit r104 = Unit.INSTANCE;
        r101.put("fetch", com.bytedance.ies.bullet.base.bridge.i.a(com.bytedance.android.annie.xbridge.mix.n.a("fetch", r103, new m16.b())));
        return r101;
    }

    @Override // com.bytedance.android.live.browser.IH5AssistService
    public Map<String, IDLXBridgeMethod> providerPreHandleMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        LinkedHashMap r101 = new LinkedHashMap();
        m16.b r102 = new m16.b();
        int r103 = com.bytedance.ies.bullet.base.bridge.i.f246288a;
        r101.put("appInfo", com.bytedance.ies.bullet.base.bridge.i.a(com.bytedance.android.annie.xbridge.mix.n.a("appInfo", new com.bytedance.android.livesdk.jsbridge.methods.z(r102), r102)));
        r101.put("userInfo", com.bytedance.ies.bullet.base.bridge.i.a(com.bytedance.android.annie.xbridge.mix.n.a("userInfo", new f5(), r102)));
        return r101;
    }
}
