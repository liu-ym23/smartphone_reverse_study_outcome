package com.bytedance.android.live.revlink.impl.pk.service;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u000b2\u00020\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\t\u0010\nR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/service/TopBannerDetailsDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/live/revlink/impl/pk/service/TopBannerDetailsDataContext$b;", "updateGiftInfoService$delegate", "Lcom/bytedance/live/datacontext/p;", "getUpdateGiftInfoService", "()Lcom/bytedance/live/datacontext/n;", "updateGiftInfoService", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TopBannerDetailsDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "TopBannerDetailsDataContext";
    private final p updateGiftInfoService$delegate;

    public static final class a {
        public a() {
        }
    }

    public interface b {
        void a();

        void dismissDialog();
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(TopBannerDetailsDataContext.class, "updateGiftInfoService", "getUpdateGiftInfoService()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new a();
    }

    public final n<b> getUpdateGiftInfoService() {
        return (n) this.updateGiftInfoService$delegate.a(this, $$delegatedProperties[0]);
    }

    public TopBannerDetailsDataContext() {
        this.updateGiftInfoService$delegate = q.c(this);
    }
}
