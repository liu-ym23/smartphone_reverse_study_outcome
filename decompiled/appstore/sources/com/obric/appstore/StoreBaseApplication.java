package com.obric.appstore;

import android.app.Activity;
import android.content.Context;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.ObricAbsInterceptor;
import com.bytedanceos.common.e;
import com.bytedanceos.common.toolbox.i;
import com.obric.appstore.buss.apps.AppsManager;
import com.obric.appstore.buss.detail.AppDetailActivity;
import com.obric.appstore.util.n;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/obric/appstore/StoreBaseApplication;", "Lcom/bytedanceos/common/BaseApplication;", "()V", "attachBaseContext", "", TraceStatsConsts.STATS_BASE_MODULE, "Landroid/content/Context;", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class StoreBaseApplication extends BaseApplication {

    public static final class a implements ObricAbsInterceptor {
        public a() {
        }

        @Override // com.bytedanceos.common.ObricAbsInterceptor
        public Class getAppDetailActivityClass() {
            return AppDetailActivity.class;
        }

        @Override // com.bytedanceos.common.ObricAbsInterceptor
        public void onInitCacheFinish() {
            AppsManager.f10585a.g();
        }

        @Override // com.bytedanceos.common.ObricAbsInterceptor
        public void onInitCacheStart() {
            AppsManager.f10585a.f();
        }

        @Override // com.bytedanceos.common.ObricAbsInterceptor
        public void openAppManager(Context r10, int r11) {
            q.g(r10, "context");
            n.f11086a.d(r10, r11);
        }

        @Override // com.bytedanceos.common.ObricAbsInterceptor
        public void openDebug(Activity r10) {
        }
    }

    public StoreBaseApplication() {
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context r10) {
        i.e("StoreBaseApplication", "attachBaseContext 1.0.3 (100003070, release, 2026-08-27 00:04:46)");
        pa.a.f23414a.b(this);
        e.f9820a.a(new a());
        super.attachBaseContext(r10);
    }
}
