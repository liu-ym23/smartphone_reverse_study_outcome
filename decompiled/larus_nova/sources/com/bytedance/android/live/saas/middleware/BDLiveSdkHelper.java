package com.bytedance.android.live.saas.middleware;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.saas.middleware.di.Dagger_BDComponent;
import com.bytedance.android.live.saas.middleware.di._BDComponent;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ3\u0010\r\u001a\u00020\f\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u0002H\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016R)\u0010\u0003\u001a\r\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\u00060\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/BDLiveSdkHelper;", "", "()V", "providers", "", "Lcom/bytedance/android/live/saas/middleware/IBDLiveSdkInit;", "Lkotlin/jvm/JvmSuppressWildcards;", "getProviders", "()Ljava/util/Set;", "setProviders", "(Ljava/util/Set;)V", "doInitTask", "", "initialize", ExifInterface.GPS_DIRECTION_TRUE, PerfLog.PARAM_KEY_CONTEXT_ID, "sdkConfig", "Lcom/bytedance/android/live/saas/middleware/BDLiveSdkConfig;", "appInfo", "Lcom/bytedance/android/live/saas/middleware/IAppInfo;", "async", "", "(Ljava/lang/Object;Lcom/bytedance/android/live/saas/middleware/BDLiveSdkConfig;Lcom/bytedance/android/live/saas/middleware/IAppInfo;Z)V", "Companion", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class BDLiveSdkHelper {
    public static final Companion Companion = null;
    private static final _BDComponent diComponent = null;
    private static final Lazy inst$delegate = null;

    @Inject
    public Set<IBDLiveSdkInit> providers;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R!\u0010\u0007\u001a\u00020\b8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/BDLiveSdkHelper$Companion;", "", "()V", "diComponent", "Lcom/bytedance/android/live/saas/middleware/di/_BDComponent;", "getDiComponent", "()Lcom/bytedance/android/live/saas/middleware/di/_BDComponent;", "inst", "Lcom/bytedance/android/live/saas/middleware/BDLiveSdkHelper;", "getInst$annotations", "getInst", "()Lcom/bytedance/android/live/saas/middleware/BDLiveSdkHelper;", "inst$delegate", "Lkotlin/Lazy;", "middleware_release"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInst$annotations() {
        }

        public final BDLiveSdkHelper getInst() {
            return (BDLiveSdkHelper) BDLiveSdkHelper.access$getInst$cp().getValue();
        }

        public final _BDComponent getDiComponent() {
            return BDLiveSdkHelper.access$getDiComponent$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    public static final BDLiveSdkHelper getInst() {
        return Companion.getInst();
    }

    static {
        Companion = new Companion(null);
        diComponent = Dagger_BDComponent.create();
        inst$delegate = LazyKt.lazy(BDLiveSdkHelper$Companion$inst$2.INSTANCE);
    }

    public final Set<IBDLiveSdkInit> getProviders() {
        Set<IBDLiveSdkInit> r100 = this.providers;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("providers");
    L5:
        return r100;
    }

    private BDLiveSdkHelper() {
        diComponent.inject(this);
    }

    public static final /* synthetic */ _BDComponent access$getDiComponent$cp() {
        return diComponent;
    }

    public static final /* synthetic */ Lazy access$getInst$cp() {
        return inst$delegate;
    }

    public final void doInitTask() {
        BDLiveSdk.doInitTask();
    }

    public /* synthetic */ BDLiveSdkHelper(DefaultConstructorMarker r100) {
        this();
    }

    public final void setProviders(Set<IBDLiveSdkInit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.providers = r100;
    }

    public final <T> void initialize(T r100, BDLiveSdkConfig r101, IAppInfo r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "sdkConfig");
        Intrinsics.checkNotNullParameter(r102, "appInfo");
        Set<IBDLiveSdkInit> r104 = this.providers;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("providers");
    L5:
        IBDLiveSdkInit r105 = (IBDLiveSdkInit) CollectionsKt.firstOrNull(r104);
        if (r105 == null) goto L10;
        r105.initialize(r100, r101, r102, r103);
        return;
    L10:
        throw new IllegalArgumentException("no provider for this brick");
    }

    public static /* synthetic */ void initialize$default(BDLiveSdkHelper r100, Object r101, BDLiveSdkConfig r102, IAppInfo r103, boolean r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r104 = false;
    L5:
        r100.initialize(r101, r102, r103, r104);
    }
}
