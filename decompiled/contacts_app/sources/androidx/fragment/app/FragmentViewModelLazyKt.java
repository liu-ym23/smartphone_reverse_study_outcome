package androidx.fragment.app;

import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: FragmentViewModelLazy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\bø\u0001\u0000\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0010\b\n\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\bø\u0001\u0000\u001aJ\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007\u001aZ\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007\u001aD\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u000e\b\n\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\bø\u0001\u0000\u001aV\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u000e\b\n\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0010\b\n\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012²\u0006\u0016\u0010\u0013\u001a\u00020\u0011\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u008a\u0084\u0002²\u0006\u0016\u0010\u0013\u001a\u00020\u0011\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u008a\u0084\u0002"}, d2 = {"activityViewModels", "Lkotlin/Lazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "factoryProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extrasProducer", "Landroidx/lifecycle/viewmodel/CreationExtras;", "createViewModelLazy", "viewModelClass", "Lkotlin/reflect/KClass;", "storeProducer", "Landroidx/lifecycle/ViewModelStore;", "viewModels", "ownerProducer", "Landroidx/lifecycle/ViewModelStoreOwner;", "fragment-ktx_release", "owner"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FragmentViewModelLazyKt {

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$1, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass1 extends Lambda implements Function0<ViewModelStore> {
        final /* synthetic */ Fragment $this_activityViewModels;

        public AnonymousClass1(Fragment r1) {
            this.$this_activityViewModels = r1;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ViewModelStore invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            ViewModelStore r1 = this.$this_activityViewModels.requireActivity().getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(r1, "requireActivity().viewModelStore");
            return r1;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$2, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass2 extends Lambda implements Function0<CreationExtras> {
        final /* synthetic */ Fragment $this_activityViewModels;

        public AnonymousClass2(Fragment r1) {
            this.$this_activityViewModels = r1;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ CreationExtras invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CreationExtras invoke() {
            CreationExtras r1 = this.$this_activityViewModels.requireActivity().getDefaultViewModelCreationExtras();
            Intrinsics.checkNotNullExpressionValue(r1, "requireActivity().defaultViewModelCreationExtras");
            return r1;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$3, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass3 extends Lambda implements Function0<ViewModelProvider.Factory> {
        final /* synthetic */ Fragment $this_activityViewModels;

        public AnonymousClass3(Fragment r1) {
            this.$this_activityViewModels = r1;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ViewModelProvider.Factory invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory r1 = this.$this_activityViewModels.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.checkNotNullExpressionValue(r1, "requireActivity().defaultViewModelProviderFactory");
            return r1;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$4, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass4 extends Lambda implements Function0<ViewModelStore> {
        final /* synthetic */ Fragment $this_activityViewModels;

        public AnonymousClass4(Fragment r1) {
            this.$this_activityViewModels = r1;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ViewModelStore invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            ViewModelStore r1 = this.$this_activityViewModels.requireActivity().getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(r1, "requireActivity().viewModelStore");
            return r1;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$5, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass5 extends Lambda implements Function0<CreationExtras> {
        final /* synthetic */ Function0<CreationExtras> $extrasProducer;
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass5(Function0<? extends CreationExtras> r1, Fragment r2) {
            this.$extrasProducer = r1;
            this.$this_activityViewModels = r2;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ CreationExtras invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CreationExtras invoke() {
            Function0<CreationExtras> r0 = this.$extrasProducer;
            if (r0 == null) goto L6;
            CreationExtras r1 = r0.invoke();
            if (r1 == null) goto L6;
            return r1;
        L6:
            CreationExtras r2 = this.$this_activityViewModels.requireActivity().getDefaultViewModelCreationExtras();
            Intrinsics.checkNotNullExpressionValue(r2, "requireActivity().defaultViewModelCreationExtras");
            return r2;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$6, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass6 extends Lambda implements Function0<ViewModelProvider.Factory> {
        final /* synthetic */ Fragment $this_activityViewModels;

        public AnonymousClass6(Fragment r1) {
            this.$this_activityViewModels = r1;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ViewModelProvider.Factory invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory r1 = this.$this_activityViewModels.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.checkNotNullExpressionValue(r1, "requireActivity().defaultViewModelProviderFactory");
            return r1;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class C01262 extends Lambda implements Function0<ViewModelStore> {
        final /* synthetic */ Lazy<ViewModelStoreOwner> $owner$delegate;

        /* JADX WARN: Multi-variable type inference failed */
        public C01262(Lazy<? extends ViewModelStoreOwner> r1) {
            this.$owner$delegate = r1;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ViewModelStore invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.m57access$viewModels$lambda0(this.$owner$delegate).getViewModelStore();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class C01273 extends Lambda implements Function0<CreationExtras> {
        final /* synthetic */ Lazy<ViewModelStoreOwner> $owner$delegate;

        /* JADX WARN: Multi-variable type inference failed */
        public C01273(Lazy<? extends ViewModelStoreOwner> r1) {
            this.$owner$delegate = r1;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ CreationExtras invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CreationExtras invoke() {
            ViewModelStoreOwner r1 = FragmentViewModelLazyKt.m57access$viewModels$lambda0(this.$owner$delegate);
            if ((r1 instanceof HasDefaultViewModelProviderFactory) == false) goto L5;
            HasDefaultViewModelProviderFactory r2 = (HasDefaultViewModelProviderFactory) r1;
        L6:
            if (r2 == null) goto L10;
            CreationExtras r3 = r2.getDefaultViewModelCreationExtras();
            if (r3 == null) goto L10;
            return r3;
        L10:
            return CreationExtras.Empty.INSTANCE;
        L5:
            r2 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class C01284 extends Lambda implements Function0<ViewModelProvider.Factory> {
        final /* synthetic */ Lazy<ViewModelStoreOwner> $owner$delegate;
        final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: Multi-variable type inference failed */
        public C01284(Fragment r1, Lazy<? extends ViewModelStoreOwner> r2) {
            this.$this_viewModels = r1;
            this.$owner$delegate = r2;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ViewModelProvider.Factory invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            ViewModelStoreOwner r0 = FragmentViewModelLazyKt.m57access$viewModels$lambda0(this.$owner$delegate);
            if ((r0 instanceof HasDefaultViewModelProviderFactory) == false) goto L5;
            HasDefaultViewModelProviderFactory r1 = (HasDefaultViewModelProviderFactory) r0;
        L6:
            if (r1 == null) goto L9;
            ViewModelProvider.Factory r2 = r1.getDefaultViewModelProviderFactory();
            if (r2 == null) goto L9;
            return r2;
        L9:
            ViewModelProvider.Factory r3 = this.$this_viewModels.getDefaultViewModelProviderFactory();
            Intrinsics.checkNotNullExpressionValue(r3, "defaultViewModelProviderFactory");
            return r3;
        L5:
            r1 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$6, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class C01306 extends Lambda implements Function0<ViewModelStore> {
        final /* synthetic */ Lazy<ViewModelStoreOwner> $owner$delegate;

        /* JADX WARN: Multi-variable type inference failed */
        public C01306(Lazy<? extends ViewModelStoreOwner> r1) {
            this.$owner$delegate = r1;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ViewModelStore invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.m58access$viewModels$lambda1(this.$owner$delegate).getViewModelStore();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$7, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass7 extends Lambda implements Function0<CreationExtras> {
        final /* synthetic */ Function0<CreationExtras> $extrasProducer;
        final /* synthetic */ Lazy<ViewModelStoreOwner> $owner$delegate;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass7(Function0<? extends CreationExtras> r1, Lazy<? extends ViewModelStoreOwner> r2) {
            this.$extrasProducer = r1;
            this.$owner$delegate = r2;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ CreationExtras invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CreationExtras invoke() {
            Function0<CreationExtras> r0 = this.$extrasProducer;
            if (r0 == null) goto L6;
            CreationExtras r1 = r0.invoke();
            if (r1 == null) goto L6;
            return r1;
        L6:
            ViewModelStoreOwner r2 = FragmentViewModelLazyKt.m58access$viewModels$lambda1(this.$owner$delegate);
            if ((r2 instanceof HasDefaultViewModelProviderFactory) == false) goto L9;
            HasDefaultViewModelProviderFactory r3 = (HasDefaultViewModelProviderFactory) r2;
        L10:
            if (r3 == null) goto L13;
            return r3.getDefaultViewModelCreationExtras();
        L13:
            return CreationExtras.Empty.INSTANCE;
        L9:
            r3 = null;
            goto L10
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$8, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass8 extends Lambda implements Function0<ViewModelProvider.Factory> {
        final /* synthetic */ Lazy<ViewModelStoreOwner> $owner$delegate;
        final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass8(Fragment r1, Lazy<? extends ViewModelStoreOwner> r2) {
            this.$this_viewModels = r1;
            this.$owner$delegate = r2;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ViewModelProvider.Factory invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            ViewModelStoreOwner r0 = FragmentViewModelLazyKt.m58access$viewModels$lambda1(this.$owner$delegate);
            if ((r0 instanceof HasDefaultViewModelProviderFactory) == false) goto L5;
            HasDefaultViewModelProviderFactory r1 = (HasDefaultViewModelProviderFactory) r0;
        L6:
            if (r1 == null) goto L9;
            ViewModelProvider.Factory r2 = r1.getDefaultViewModelProviderFactory();
            if (r2 == null) goto L9;
            return r2;
        L9:
            ViewModelProvider.Factory r3 = this.$this_viewModels.getDefaultViewModelProviderFactory();
            Intrinsics.checkNotNullExpressionValue(r3, "defaultViewModelProviderFactory");
            return r3;
        L5:
            r1 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: access$viewModels$lambda-0, reason: not valid java name */
    public static final /* synthetic */ ViewModelStoreOwner m57access$viewModels$lambda0(Lazy r0) {
        return m59viewModels$lambda0(r0);
    }

    /* JADX INFO: renamed from: access$viewModels$lambda-1, reason: not valid java name */
    public static final /* synthetic */ ViewModelStoreOwner m58access$viewModels$lambda1(Lazy r0) {
        return m60viewModels$lambda1(r0);
    }

    public static /* synthetic */ Lazy viewModels$default(final Fragment r1, Function0 r2, C01284 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = new C01251(r1);
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "ownerProducer");
        Lazy r6 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new FragmentViewModelLazyKt$viewModels$owner$2(r2));
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass r7 = Reflection.getOrCreateKotlinClass(ViewModel.class);
        C01262 r8 = new C01262(r6);
        C01273 r0 = new C01273(r6);
        if (r3 != null) goto L12;
        r3 = new C01284(r1, r6);
    L12:
        return createViewModelLazy(r1, r7, r8, r0, r3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by viewModels that takes a CreationExtras producer")
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(Fragment r3, Function0<? extends ViewModelStoreOwner> r4, C01284 r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "ownerProducer");
        Lazy r6 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new FragmentViewModelLazyKt$viewModels$owner$2(r4));
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass r0 = Reflection.getOrCreateKotlinClass(ViewModel.class);
        C01262 r1 = new C01262(r6);
        C01273 r2 = new C01273(r6);
        if (r5 != null) goto L6;
        r5 = new C01284(r3, r6);
    L6:
        return createViewModelLazy(r3, r0, r1, r2, r5);
    }

    /* JADX INFO: renamed from: viewModels$lambda-0, reason: not valid java name */
    private static final ViewModelStoreOwner m59viewModels$lambda0(Lazy<? extends ViewModelStoreOwner> r0) {
        return r0.getValue();
    }

    public static /* synthetic */ Lazy viewModels$default(final Fragment r1, Function0 r2, Function0 r3, AnonymousClass8 r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = new C01295(r1);
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "ownerProducer");
        Lazy r7 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new FragmentViewModelLazyKt$viewModels$owner$4(r2));
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass r8 = Reflection.getOrCreateKotlinClass(ViewModel.class);
        C01306 r9 = new C01306(r7);
        AnonymousClass7 r0 = new AnonymousClass7(r3, r7);
        if (r4 != null) goto L15;
        r4 = new AnonymousClass8(r1, r7);
    L15:
        return createViewModelLazy(r1, r8, r9, r0, r4);
    }

    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(Fragment r3, Function0<? extends ViewModelStoreOwner> r4, Function0<? extends CreationExtras> r5, AnonymousClass8 r6) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "ownerProducer");
        Lazy r7 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new FragmentViewModelLazyKt$viewModels$owner$4(r4));
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass r0 = Reflection.getOrCreateKotlinClass(ViewModel.class);
        C01306 r1 = new C01306(r7);
        AnonymousClass7 r2 = new AnonymousClass7(r5, r7);
        if (r6 != null) goto L6;
        r6 = new AnonymousClass8(r3, r7);
    L6:
        return createViewModelLazy(r3, r0, r1, r2, r6);
    }

    /* JADX INFO: renamed from: viewModels$lambda-1, reason: not valid java name */
    private static final ViewModelStoreOwner m60viewModels$lambda1(Lazy<? extends ViewModelStoreOwner> r0) {
        return r0.getValue();
    }

    public static /* synthetic */ Lazy activityViewModels$default(Fragment r1, AnonymousClass3 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass r5 = Reflection.getOrCreateKotlinClass(ViewModel.class);
        AnonymousClass1 r6 = new AnonymousClass1(r1);
        AnonymousClass2 r0 = new AnonymousClass2(r1);
        if (r2 != null) goto L9;
        r2 = new AnonymousClass3(r1);
    L9:
        return createViewModelLazy(r1, r5, r6, r0, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by activityViewModels that takes a CreationExtras producer")
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> activityViewModels(Fragment r3, AnonymousClass3 r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass r0 = Reflection.getOrCreateKotlinClass(ViewModel.class);
        AnonymousClass1 r1 = new AnonymousClass1(r3);
        AnonymousClass2 r2 = new AnonymousClass2(r3);
        if (r4 != null) goto L6;
        r4 = new AnonymousClass3(r3);
    L6:
        return createViewModelLazy(r3, r0, r1, r2, r4);
    }

    public static /* synthetic */ Lazy activityViewModels$default(Fragment r1, Function0 r2, AnonymousClass6 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass r6 = Reflection.getOrCreateKotlinClass(ViewModel.class);
        AnonymousClass4 r7 = new AnonymousClass4(r1);
        AnonymousClass5 r0 = new AnonymousClass5(r2, r1);
        if (r3 != null) goto L12;
        r3 = new AnonymousClass6(r1);
    L12:
        return createViewModelLazy(r1, r6, r7, r0, r3);
    }

    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> activityViewModels(Fragment r3, Function0<? extends CreationExtras> r4, AnonymousClass6 r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass r0 = Reflection.getOrCreateKotlinClass(ViewModel.class);
        AnonymousClass4 r1 = new AnonymousClass4(r3);
        AnonymousClass5 r2 = new AnonymousClass5(r4, r3);
        if (r5 != null) goto L6;
        r5 = new AnonymousClass6(r3);
    L6:
        return createViewModelLazy(r3, r0, r1, r2, r5);
    }

    public static /* synthetic */ Lazy createViewModelLazy$default(Fragment r0, KClass r1, Function0 r2, Function0 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return createViewModelLazy(r0, r1, r2, r3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by createViewModelLazy that takes a CreationExtras producer")
    public static final /* synthetic */ Lazy createViewModelLazy(final Fragment r1, KClass r2, Function0 r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "viewModelClass");
        Intrinsics.checkNotNullParameter(r3, "storeProducer");
        return createViewModelLazy(r1, r2, r3, new C01231(r1), r4);
    }

    public static /* synthetic */ Lazy createViewModelLazy$default(final Fragment r0, KClass r1, Function0 r2, Function0 r3, Function0 r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = new C01242(r0);
    L6:
        if ((r5 & 8) == 0) goto L9;
        r4 = null;
    L9:
        return createViewModelLazy(r0, r1, r2, r3, r4);
    }

    public static final <VM extends ViewModel> Lazy<VM> createViewModelLazy(final Fragment r1, KClass<VM> r2, Function0<? extends ViewModelStore> r3, Function0<? extends CreationExtras> r4, Function0<? extends ViewModelProvider.Factory> r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "viewModelClass");
        Intrinsics.checkNotNullParameter(r3, "storeProducer");
        Intrinsics.checkNotNullParameter(r4, "extrasProducer");
        if (r5 != null) goto L6;
        r5 = new FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(r1);
    L6:
        return new ViewModelLazy(r2, r3, r5, r4);
    }
}
