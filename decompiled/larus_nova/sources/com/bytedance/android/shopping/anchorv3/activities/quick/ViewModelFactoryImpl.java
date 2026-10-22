package com.bytedance.android.shopping.anchorv3.activities.quick;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.android.shopping.anchorv3.activities.quick.viewmodel.ActivityGroupViewModel;
import com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.AnchorV4ActivityGroupViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/activities/quick/ViewModelFactoryImpl;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ViewModelFactoryImpl implements ViewModelProvider.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f164395a = 0;

    public static final class a {
        public static ViewModelFactoryImpl a() {
            return new ViewModelFactoryImpl(0);
        }
    }

    static {
    }

    private ViewModelFactoryImpl() {
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(Class r100, CreationExtras r101) {
        return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(KClass r100, CreationExtras r101) {
        return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
    }

    public /* synthetic */ ViewModelFactoryImpl(int r100) {
        this();
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final <T extends ViewModel> T create(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        if (r100.isAssignableFrom(ActivityGroupViewModel.class) == false) goto L6;
        return new ActivityGroupViewModel();
    L6:
        if (r100.isAssignableFrom(AnchorV4ActivityGroupViewModel.class) == false) goto L10;
        return new AnchorV4ActivityGroupViewModel();
    L10:
        throw new IllegalArgumentException("Unknown ViewModel class: ".concat(r100.getName()));
    }
}
