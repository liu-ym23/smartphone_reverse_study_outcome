package androidx.navigation;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\u001a>\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0087\bø\u0001\u0000\u001a<\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f²\u0006\u0016\u0010\r\u001a\u00020\u000e\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u008a\u0084\u0002²\u0006\u0016\u0010\r\u001a\u00020\u000e\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u008a\u0084\u0002"}, d2 = {"navGraphViewModels", "Lkotlin/Lazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "navGraphId", "", "factoryProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "navGraphRoute", "", "navigation-fragment_release", "backStackEntry", "Landroidx/navigation/NavBackStackEntry;"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class NavGraphViewModelLazyKt {

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass1 extends Lambda implements Function0<ViewModelProvider.Factory> {
        final /* synthetic */ Lazy<NavBackStackEntry> $backStackEntry$delegate;
        final /* synthetic */ Function0<ViewModelProvider.Factory> $factoryProducer;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function0<? extends ViewModelProvider.Factory> r100, Lazy<NavBackStackEntry> r101) {
            this.$factoryProducer = r100;
            this.$backStackEntry$delegate = r101;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            Function0<ViewModelProvider.Factory> r100 = this.$factoryProducer;
            if (r100 != null) goto L5;
            ViewModelProvider.Factory r101 = null;
        L6:
            if (r101 == null) goto L8;
            return r101;
        L8:
            return NavGraphViewModelLazyKt.m7814access$navGraphViewModels$lambda0(this.$backStackEntry$delegate).getDefaultViewModelProviderFactory();
        L5:
            r101 = r100.invoke();
            goto L6
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ViewModelProvider.Factory invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass2 extends Lambda implements Function0<ViewModelProvider.Factory> {
        final /* synthetic */ Lazy<NavBackStackEntry> $backStackEntry$delegate;
        final /* synthetic */ Function0<ViewModelProvider.Factory> $factoryProducer;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function0<? extends ViewModelProvider.Factory> r100, Lazy<NavBackStackEntry> r101) {
            this.$factoryProducer = r100;
            this.$backStackEntry$delegate = r101;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            Function0<ViewModelProvider.Factory> r100 = this.$factoryProducer;
            if (r100 != null) goto L5;
            ViewModelProvider.Factory r101 = null;
        L6:
            if (r101 == null) goto L8;
            return r101;
        L8:
            return NavGraphViewModelLazyKt.m7815access$navGraphViewModels$lambda1(this.$backStackEntry$delegate).getDefaultViewModelProviderFactory();
        L5:
            r101 = r100.invoke();
            goto L6
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ViewModelProvider.Factory invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: access$navGraphViewModels$lambda-0, reason: not valid java name */
    public static final /* synthetic */ NavBackStackEntry m7814access$navGraphViewModels$lambda0(Lazy r100) {
        return m7816navGraphViewModels$lambda0(r100);
    }

    /* JADX INFO: renamed from: access$navGraphViewModels$lambda-1, reason: not valid java name */
    public static final /* synthetic */ NavBackStackEntry m7815access$navGraphViewModels$lambda1(Lazy r100) {
        return m7817navGraphViewModels$lambda1(r100);
    }

    /* JADX INFO: renamed from: navGraphViewModels$lambda-0, reason: not valid java name */
    private static final NavBackStackEntry m7816navGraphViewModels$lambda0(Lazy<NavBackStackEntry> r100) {
        return r100.getValue();
    }

    /* JADX INFO: renamed from: navGraphViewModels$lambda-1, reason: not valid java name */
    private static final NavBackStackEntry m7817navGraphViewModels$lambda1(Lazy<NavBackStackEntry> r100) {
        return r100.getValue();
    }

    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> navGraphViewModels(Fragment r100, String r101, Function0<? extends ViewModelProvider.Factory> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "navGraphRoute");
        Lazy r103 = LazyKt.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$4(r100, r101));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2 r104 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2(r103);
        Intrinsics.reifiedOperationMarker(4, "VM");
        return FragmentViewModelLazyKt.createViewModelLazy(r100, Reflection.getOrCreateKotlinClass(ViewModel.class), r104, new AnonymousClass2(r102, r103));
    }

    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> navGraphViewModels(Fragment r100, int r101, Function0<? extends ViewModelProvider.Factory> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Lazy r103 = LazyKt.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$2(r100, r101));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 r104 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(r103);
        Intrinsics.reifiedOperationMarker(4, "VM");
        return FragmentViewModelLazyKt.createViewModelLazy(r100, Reflection.getOrCreateKotlinClass(ViewModel.class), r104, new AnonymousClass1(r102, r103));
    }

    public static /* synthetic */ Lazy navGraphViewModels$default(Fragment r100, String r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "navGraphRoute");
        Lazy r105 = LazyKt.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$4(r100, r101));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2 r106 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2(r105);
        Intrinsics.reifiedOperationMarker(4, "VM");
        return FragmentViewModelLazyKt.createViewModelLazy(r100, Reflection.getOrCreateKotlinClass(ViewModel.class), r106, new AnonymousClass2(r102, r105));
    }

    public static /* synthetic */ Lazy navGraphViewModels$default(Fragment r100, int r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Lazy r105 = LazyKt.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$2(r100, r101));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 r106 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(r105);
        Intrinsics.reifiedOperationMarker(4, "VM");
        return FragmentViewModelLazyKt.createViewModelLazy(r100, Reflection.getOrCreateKotlinClass(ViewModel.class), r106, new AnonymousClass1(r102, r105));
    }
}
