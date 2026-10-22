package com.bytedance.android.shopping.commentv3.base;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Transformations;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.core.arch.state.LivedataKt$transformationsDistinctUntilChanged$1;
import com.bytedance.android.ec.core.utils.a0;
import com.bytedance.android.ec.core.utils.b0;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.shopping.commentv3.base.a;
import com.bytedance.android.shopping.commentv3.base.b;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0005:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/base/BaseUI;", "Lcom/bytedance/android/shopping/commentv3/base/b;", "State", "Lcom/bytedance/android/shopping/commentv3/base/a;", "Logic", "Lcom/bytedance/android/shopping/commentv3/base/LifecycleUI;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseUI<State extends b, Logic extends com.bytedance.android.shopping.commentv3.base.a<State>> extends LifecycleUI {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Logic f172668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediatorLiveData<State> f172669b;

    public static final class a {
    }

    static {
    }

    public BaseUI() {
        this.f172669b = new MediatorLiveData();
    }

    @Override // com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public void onCreate() {
        super.onCreate();
        Logic r100 = this.f172668a;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        dm.a.b r101 = dm.a.f469202a;
        dm.a.a(getClass().getSimpleName()).i(WidgetCostModule.TYPE_ON_CREATE);
    }

    @Override // com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public void onDestroy() {
        super.onDestroy();
        dm.a.b r100 = dm.a.f469202a;
        dm.a.a(getClass().getSimpleName()).i(LiveCommonConstants.REASON_ON_DEDTROY);
    }

    @Override // com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public final void onPause() {
        super.onPause();
        Logic r100 = this.f172668a;
        if (r100 == null) goto L5;
        r100.b();
    L5:
        dm.a.b r101 = dm.a.f469202a;
        dm.a.a(getClass().getSimpleName()).i("onPause");
    }

    @Override // com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public final void onResume() {
        super.onResume();
        Logic r100 = this.f172668a;
        if (r100 == null) goto L5;
        r100.c();
    L5:
        dm.a.b r101 = dm.a.f469202a;
        dm.a.a(getClass().getSimpleName()).i("onResume");
    }

    @Override // com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public final void onStart() {
        super.onStart();
        dm.a.b r100 = dm.a.f469202a;
        dm.a.a(getClass().getSimpleName()).i(WidgetCostModule.TYPE_ON_START);
    }

    @Override // com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public final void onStop() {
        super.onStop();
        dm.a.b r100 = dm.a.f469202a;
        dm.a.a(getClass().getSimpleName()).i("onStop");
    }

    public static MediatorLiveData f(MediatorLiveData r100, final KProperty1 r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$childLiveData");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        int r102 = b0.f45552a;
        Function1<Object, Object> r103 = new BaseUI$childLiveData$1(r101);
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r103, "switchMapFunction");
        LiveData r104 = Transformations.map(r100, new a0(r103));
        Intrinsics.checkNotNullParameter(r104, "$this$distinctUntilChanged");
        MediatorLiveData r105 = new MediatorLiveData();
        r105.addSource(r104, new LivedataKt$transformationsDistinctUntilChanged$1(r105));
        return r105;
    }
}
