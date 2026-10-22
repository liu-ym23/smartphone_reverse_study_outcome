package androidx.lifecycle.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.internal.SynchronizedObject;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ1\u0010\f\u001a\u0002H\r\"\b\b\u0000\u0010\r*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\r0\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/lifecycle/viewmodel/ViewModelProviderImpl;", "", ComplianceConstants.ComplianceRequest.MARKET_STORE, "Landroidx/lifecycle/ViewModelStore;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "defaultExtras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "<init>", "(Landroidx/lifecycle/ViewModelStore;Landroidx/lifecycle/ViewModelProvider$Factory;Landroidx/lifecycle/viewmodel/CreationExtras;)V", "lock", "Landroidx/lifecycle/viewmodel/internal/SynchronizedObject;", "getViewModel", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Lkotlin/reflect/KClass;", "key", "", "getViewModel$lifecycle_viewmodel", "(Lkotlin/reflect/KClass;Ljava/lang/String;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ViewModelProviderImpl {
    private final CreationExtras defaultExtras;
    private final ViewModelProvider.Factory factory;
    private final SynchronizedObject lock;
    private final ViewModelStore store;

    public static final /* synthetic */ CreationExtras access$getDefaultExtras$p(ViewModelProviderImpl r100) {
        return r100.defaultExtras;
    }

    public static final /* synthetic */ ViewModelProvider.Factory access$getFactory$p(ViewModelProviderImpl r100) {
        return r100.factory;
    }

    public static final /* synthetic */ ViewModelStore access$getStore$p(ViewModelProviderImpl r100) {
        return r100.store;
    }

    public final <T extends ViewModel> T getViewModel$lifecycle_viewmodel(KClass<T> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        Intrinsics.checkNotNullParameter(r101, "key");
        SynchronizedObject r102 = this.lock;
        monitor-enter(r102);
        T r103 = (T) access$getStore$p(this).get(r101);
        if (r100.isInstance(r103) == true) goto L7;
        MutableCreationExtras r104 = new MutableCreationExtras(access$getDefaultExtras$p(this));     // Catch: Throwable -> L13
        r104.set(ViewModelProvider.VIEW_MODEL_KEY, r101);     // Catch: Throwable -> L13
        r103 = (T) ViewModelProviderImpl_androidKt.createViewModel(access$getFactory$p(this), r100, r104);
        access$getStore$p(this).put(r101, r103);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r102);
        return r103;
    L7:
        if ((access$getFactory$p(this) instanceof ViewModelProvider.OnRequeryFactory) == false) goto L9;
        ViewModelProvider.OnRequeryFactory r105 = (ViewModelProvider.OnRequeryFactory) access$getFactory$p(this);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L13
        r105.onRequery(r103);     // Catch: Throwable -> L13
    L9:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type T of androidx.lifecycle.viewmodel.ViewModelProviderImpl.getViewModel");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public ViewModelProviderImpl(ViewModelStore r100, ViewModelProvider.Factory r101, CreationExtras r102) {
        Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        Intrinsics.checkNotNullParameter(r101, "factory");
        Intrinsics.checkNotNullParameter(r102, "defaultExtras");
        this.store = r100;
        this.factory = r101;
        this.defaultExtras = r102;
        this.lock = new SynchronizedObject();
    }

    public static /* synthetic */ ViewModel getViewModel$lifecycle_viewmodel$default(ViewModelProviderImpl r100, KClass r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = ViewModelProviders.INSTANCE.getDefaultKey$lifecycle_viewmodel(r101);
    L6:
        return r100.getViewModel$lifecycle_viewmodel(r101, r102);
    }
}
