package com.bytedance.android.live.saas.middleware.network;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.base.IConfiguration;
import com.bytedance.android.live.saas.middleware.base.ISdkInitTask;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0004J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R6\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\b0\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/network/NetworkProxy;", "Lcom/bytedance/android/live/saas/middleware/base/IConfiguration;", "", "Lcom/bytedance/android/live/saas/middleware/network/NetworkConfig;", "()V", "cornetFunction", "", "Lcom/bytedance/android/live/saas/middleware/di/FuncType;", "Lcom/bytedance/android/live/saas/middleware/base/BaseFunction;", "getCornetFunction", "()Ljava/util/Map;", "setCornetFunction", "(Ljava/util/Map;)V", "create", "conf", "Companion", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class NetworkProxy implements IConfiguration<Object, NetworkConfig> {
    public static final Companion Companion = null;
    private static final _BDComponent diComponent = null;

    @Inject
    @Named("cornet")
    public Map<FuncType, BaseFunction<Object, NetworkConfig>> cornetFunction;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/network/NetworkProxy$Companion;", "", "()V", "diComponent", "Lcom/bytedance/android/live/saas/middleware/di/_BDComponent;", "getDiComponent", "()Lcom/bytedance/android/live/saas/middleware/di/_BDComponent;", "middleware_release"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final _BDComponent getDiComponent() {
            return NetworkProxy.access$getDiComponent$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.saas.middleware.network.NetworkProxy$create$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/bytedance/android/live/saas/middleware/network/NetworkProxy$create$2", "Lcom/bytedance/android/live/saas/middleware/base/BaseFunction;", "", "Lcom/bytedance/android/live/saas/middleware/network/NetworkConfig;", "getTask", "Lcom/bytedance/android/live/saas/middleware/base/ISdkInitTask;", "middleware_release"}, k = 1, mv = {1, 4, 3})
    public static final class AnonymousClass2 extends BaseFunction<Object, NetworkConfig> {
        final /* synthetic */ NetworkConfig $conf;
        final /* synthetic */ NetworkInitTask $networkTask;
        final /* synthetic */ NetworkProxy this$0;

        @Override // com.bytedance.android.live.saas.middleware.base.BaseFunction, com.bytedance.android.live.saas.middleware.base.IFunction
        public ISdkInitTask<NetworkConfig> getTask() {
            if (this.$conf.getStandalone() == false) goto L8;
            if (this.$conf.getCornet() == false) goto L8;
            return new NetworkProxy$create$2$getTask$1(this);
        L8:
            if (this.$conf.getStandalone() == true) goto L13;
            return null;
        L13:
            return this.$networkTask;
        }

        public AnonymousClass2(NetworkProxy r100, NetworkConfig r101, NetworkInitTask r102) {
            this.this$0 = r100;
            this.$conf = r101;
            this.$networkTask = r102;
        }
    }

    public NetworkProxy() {
    }

    static {
        Companion = new Companion(null);
        diComponent = Dagger_BDComponent.create();
    }

    public final Map<FuncType, BaseFunction<Object, NetworkConfig>> getCornetFunction() {
        Map<FuncType, BaseFunction<Object, NetworkConfig>> r100 = this.cornetFunction;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cornetFunction");
    L5:
        return r100;
    }

    public static final /* synthetic */ _BDComponent access$getDiComponent$cp() {
        return diComponent;
    }

    /* JADX INFO: renamed from: create, reason: avoid collision after fix types in other method */
    public BaseFunction<Object, NetworkConfig> create2(NetworkConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "conf");
        if (r100.getStandalone() == false) goto L5;
    L8:
        diComponent.inject(this);
        return new AnonymousClass2(this, r100, new NetworkInitTask());
    L5:
        if (r100.getCornet() == true) goto L8;
        return new AnonymousClass1();
    }

    public final void setCornetFunction(Map<FuncType, BaseFunction<Object, NetworkConfig>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cornetFunction = r100;
    }

    @Override // com.bytedance.android.live.saas.middleware.base.IConfiguration
    public /* bridge */ /* synthetic */ BaseFunction<Object, NetworkConfig> create(NetworkConfig r100) {
        return create2(r100);
    }
}
