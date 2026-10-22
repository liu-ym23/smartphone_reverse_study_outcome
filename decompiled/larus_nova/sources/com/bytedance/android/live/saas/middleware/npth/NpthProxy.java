package com.bytedance.android.live.saas.middleware.npth;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0004J\u001e\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R8\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00020\u0007\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\b0\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/npth/NpthProxy;", "Lcom/bytedance/android/live/saas/middleware/base/IConfiguration;", "", "Lcom/bytedance/android/live/saas/middleware/npth/NpthConfig;", "()V", "mFunctionMap", "", "Lcom/bytedance/android/live/saas/middleware/di/FuncType;", "Lcom/bytedance/android/live/saas/middleware/base/BaseFunction;", "getMFunctionMap", "()Ljava/util/Map;", "setMFunctionMap", "(Ljava/util/Map;)V", "create", "conf", "Companion", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class NpthProxy implements IConfiguration<Object, NpthConfig> {
    public static final Companion Companion = null;
    private static final _BDComponent diComponent = null;

    @Inject
    @Named("npth")
    public Map<FuncType, BaseFunction<Object, NpthConfig>> mFunctionMap;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/npth/NpthProxy$Companion;", "", "()V", "diComponent", "Lcom/bytedance/android/live/saas/middleware/di/_BDComponent;", "getDiComponent", "()Lcom/bytedance/android/live/saas/middleware/di/_BDComponent;", "middleware_release"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final _BDComponent getDiComponent() {
            return NpthProxy.access$getDiComponent$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    public NpthProxy() {
    }

    static {
        Companion = new Companion(null);
        diComponent = Dagger_BDComponent.create();
    }

    public final Map<FuncType, BaseFunction<Object, NpthConfig>> getMFunctionMap() {
        Map<FuncType, BaseFunction<Object, NpthConfig>> r100 = this.mFunctionMap;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFunctionMap");
    L5:
        return r100;
    }

    public static final /* synthetic */ _BDComponent access$getDiComponent$cp() {
        return diComponent;
    }

    /* JADX INFO: renamed from: create, reason: avoid collision after fix types in other method */
    public BaseFunction<Object, NpthConfig> create2(NpthConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "conf");
        diComponent.inject(this);
        if (r100.getStandalone() == true) goto L9;
        if (r100.isToBVersion() == true) goto L9;
        return new AnonymousClass1(this);
    L9:
        if (r100.isToBVersion() == false) goto L14;
        Map<FuncType, BaseFunction<Object, NpthConfig>> r101 = this.mFunctionMap;
        if (r101 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mFunctionMap");
    L13:
        BaseFunction<Object, NpthConfig> r102 = r101.get(FuncType.TYPE_TOB);
        Intrinsics.checkNotNull(r102);
        return r102;
    L14:
        Map<FuncType, BaseFunction<Object, NpthConfig>> r103 = this.mFunctionMap;
        if (r103 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mFunctionMap");
    L17:
        BaseFunction<Object, NpthConfig> r104 = r103.get(FuncType.TYPE_INHOUSE);
        Intrinsics.checkNotNull(r104);
        return r104;
    }

    public final void setMFunctionMap(Map<FuncType, BaseFunction<Object, NpthConfig>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mFunctionMap = r100;
    }

    @Override // com.bytedance.android.live.saas.middleware.base.IConfiguration
    public /* bridge */ /* synthetic */ BaseFunction<Object, NpthConfig> create(NpthConfig r100) {
        return create2(r100);
    }
}
