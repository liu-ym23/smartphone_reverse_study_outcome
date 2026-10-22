package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.annie.api.bridge.RegisterPolicy;
import com.bytedance.android.live.browser.ISaaSBrowserService;
import com.bytedance.android.live.browser.jsbridge.newmethods.h7;
import com.bytedance.android.live.browser.jsbridge.newmethods.ob;
import com.bytedance.android.live.browser.jsbridge.newmethods.s3;
import com.bytedance.android.live.browser.jsbridge.newmethods.t8;
import com.bytedance.android.live.browser.jsbridge.newmethods.t9;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/SaaSBrowserService;", "Lcom/bytedance/android/live/browser/ISaaSBrowserService;", "Lcom/bytedance/ies/web/jsbridge2/d0;", "jsBridge2", "Lcom/bytedance/android/annie/api/bridge/RegisterPolicy;", "registerPolicy", "", "", "Lcom/bytedance/ies/web/jsbridge2/f$b;", "provideDefaultStatefulMethods", "Lcom/bytedance/android/livesdkapi/hybridapi/BaseJsBridgeMethodFactory;", "getExternalMethodFactory", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public class SaaSBrowserService implements ISaaSBrowserService {

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f62911a = null;

        static {
            f62911a = new a();
        }

        public a() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new ob();
        }
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f62912a = null;

        static {
            f62912a = new b();
        }

        public b() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new t9();
        }
    }

    public static final class c implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f62913a = null;

        static {
            f62913a = new c();
        }

        public c() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new s3();
        }
    }

    public static final class d implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f62914a = null;

        static {
            f62914a = new d();
        }

        public d() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new h7();
        }
    }

    public static final class e implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f62915a = null;

        static {
            f62915a = new e();
        }

        public e() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new t8();
        }
    }

    public SaaSBrowserService() {
    }

    @Override // com.bytedance.android.live.browser.ISaaSBrowserService
    public BaseJsBridgeMethodFactory getExternalMethodFactory() {
        return t.f63973a;
    }

    @Override // com.bytedance.android.live.browser.ISaaSBrowserService
    public Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideDefaultStatefulMethods(com.bytedance.ies.web.jsbridge2.d0 r100, RegisterPolicy r101) {
        Intrinsics.checkNotNullParameter(r101, "registerPolicy");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("scanCode", a.f62911a), TuplesKt.to("popTuringVerifyView", b.f62912a), TuplesKt.to("getActivitySettings", c.f62913a), TuplesKt.to("liveTaskOperation", d.f62914a), TuplesKt.to("openGallery", e.f62915a)});
    }
}
