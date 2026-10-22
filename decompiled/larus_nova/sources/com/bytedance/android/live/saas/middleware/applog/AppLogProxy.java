package com.bytedance.android.live.saas.middleware.applog;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.base.IConfiguration;
import com.bytedance.android.live.saas.middleware.di.Dagger_BDComponent;
import com.bytedance.android.live.saas.middleware.di.FuncType;
import com.bytedance.android.live.saas.middleware.di._BDComponent;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0004J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R6\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\b0\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/applog/AppLogProxy;", "Lcom/bytedance/android/live/saas/middleware/base/IConfiguration;", "Lcom/bytedance/android/live/saas/middleware/applog/IAppLog;", "Lcom/bytedance/android/live/saas/middleware/applog/AppLogConfig;", "()V", "mFunctionMap", "", "Lcom/bytedance/android/live/saas/middleware/di/FuncType;", "Lcom/bytedance/android/live/saas/middleware/base/BaseFunction;", "getMFunctionMap", "()Ljava/util/Map;", "setMFunctionMap", "(Ljava/util/Map;)V", "create", "conf", "Companion", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class AppLogProxy implements IConfiguration<IAppLog, AppLogConfig> {
    public static final Companion Companion = null;
    private static final _BDComponent diComponent = null;

    @Inject
    @Named("applog")
    public Map<FuncType, BaseFunction<IAppLog, AppLogConfig>> mFunctionMap;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/applog/AppLogProxy$Companion;", "", "()V", "diComponent", "Lcom/bytedance/android/live/saas/middleware/di/_BDComponent;", "getDiComponent", "()Lcom/bytedance/android/live/saas/middleware/di/_BDComponent;", "middleware_release"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final _BDComponent getDiComponent() {
            return AppLogProxy.access$getDiComponent$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    public AppLogProxy() {
    }

    static {
        Companion = new Companion(null);
        diComponent = Dagger_BDComponent.create();
    }

    public final Map<FuncType, BaseFunction<IAppLog, AppLogConfig>> getMFunctionMap() {
        Map<FuncType, BaseFunction<IAppLog, AppLogConfig>> r100 = this.mFunctionMap;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFunctionMap");
    L5:
        return r100;
    }

    public static final /* synthetic */ _BDComponent access$getDiComponent$cp() {
        return diComponent;
    }

    /* JADX INFO: renamed from: create, reason: avoid collision after fix types in other method */
    public BaseFunction<IAppLog, AppLogConfig> create2(final AppLogConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "conf");
        if (r100.getStandalone() == false) goto L5;
    L11:
        diComponent.inject(this);
        if (r100.isToBVersion() == false) goto L17;
        Map<FuncType, BaseFunction<IAppLog, AppLogConfig>> r101 = this.mFunctionMap;
        if (r101 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mFunctionMap");
    L16:
        BaseFunction<IAppLog, AppLogConfig> r102 = r101.get(FuncType.TYPE_TOB);
        Intrinsics.checkNotNull(r102);
        return r102;
    L17:
        Map<FuncType, BaseFunction<IAppLog, AppLogConfig>> r103 = this.mFunctionMap;
        if (r103 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFunctionMap");
    L20:
        BaseFunction<IAppLog, AppLogConfig> r104 = r103.get(FuncType.TYPE_INHOUSE);
        Intrinsics.checkNotNull(r104);
        return r104;
    L5:
        if (r100.isToBVersion() == true) goto L11;
        IAppLog r105 = r100.getImpl();
        if (r105 == null) goto L10;
        r105.observeIdChanged(new AnonymousClass1());
    L10:
        return new AnonymousClass2(r100);
    }

    public final void setMFunctionMap(Map<FuncType, BaseFunction<IAppLog, AppLogConfig>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mFunctionMap = r100;
    }

    @Override // com.bytedance.android.live.saas.middleware.base.IConfiguration
    public /* bridge */ /* synthetic */ BaseFunction<IAppLog, AppLogConfig> create(AppLogConfig r100) {
        return create2(r100);
    }
}
