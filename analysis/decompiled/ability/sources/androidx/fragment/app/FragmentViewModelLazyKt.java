package androidx.fragment.app;

import android.view.HasDefaultViewModelProviderFactory;
import android.view.ViewModel;
import android.view.ViewModelLazy;
import android.view.ViewModelProvider;
import android.view.ViewModelStore;
import android.view.ViewModelStoreOwner;
import android.view.viewmodel.CreationExtras;
import androidx.annotation.MainThread;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aK\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u000e\b\n\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a]\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u000e\b\n\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\n\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00032\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\r\u001a;\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001aM\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0010\b\n\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00032\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\n\u001aQ\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001aa\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0014\u0010\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018²\u0006\u0018\u0010\u0017\u001a\u00020\u0004\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00008\nX\u008a\u0084\u0002²\u0006\u0018\u0010\u0017\u001a\u00020\u0004\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00008\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/fragment/app/Fragment;", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStoreOwner;", "ownerProducer", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factoryProducer", "LC7/f;", "viewModels", "(Landroidx/fragment/app/Fragment;LS7/a;LS7/a;)LC7/f;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "extrasProducer", "(Landroidx/fragment/app/Fragment;LS7/a;LS7/a;LS7/a;)LC7/f;", "activityViewModels", "(Landroidx/fragment/app/Fragment;LS7/a;)LC7/f;", "LZ7/d;", "viewModelClass", "Landroidx/lifecycle/ViewModelStore;", "storeProducer", "createViewModelLazy", "(Landroidx/fragment/app/Fragment;LZ7/d;LS7/a;LS7/a;)LC7/f;", "(Landroidx/fragment/app/Fragment;LZ7/d;LS7/a;LS7/a;LS7/a;)LC7/f;", "owner", "fragment-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FragmentViewModelLazyKt {

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    /* renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements S7.a {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        @Override // S7.a
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.$this_activityViewModels.requireActivity().getViewModelStore();
            k.e(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    /* renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements S7.a {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        @Override // S7.a
        public final CreationExtras invoke() {
            CreationExtras defaultViewModelCreationExtras = this.$this_activityViewModels.requireActivity().getDefaultViewModelCreationExtras();
            k.e(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
            return defaultViewModelCreationExtras;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    /* renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements S7.a {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        @Override // S7.a
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory = this.$this_activityViewModels.requireActivity().getDefaultViewModelProviderFactory();
            k.e(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    /* renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements S7.a {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        @Override // S7.a
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.$this_activityViewModels.requireActivity().getViewModelStore();
            k.e(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    /* renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements S7.a {
        final /* synthetic */ S7.a $extrasProducer;
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(S7.a aVar, Fragment fragment) {
            super(0);
            this.$extrasProducer = aVar;
            this.$this_activityViewModels = fragment;
        }

        @Override // S7.a
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            S7.a aVar = this.$extrasProducer;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            CreationExtras defaultViewModelCreationExtras = this.$this_activityViewModels.requireActivity().getDefaultViewModelCreationExtras();
            k.e(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
            return defaultViewModelCreationExtras;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    /* renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$6, reason: invalid class name */
    public static final class AnonymousClass6 extends Lambda implements S7.a {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        @Override // S7.a
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory = this.$this_activityViewModels.requireActivity().getDefaultViewModelProviderFactory();
            k.e(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    /* renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$2, reason: invalid class name and case insensitive filesystem */
    public static final class C07532 extends Lambda implements S7.a {
        final /* synthetic */ C7.f $owner$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07532(C7.f fVar) {
            super(0);
            this.$owner$delegate = fVar;
        }

        @Override // S7.a
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.m7123viewModels$lambda0(this.$owner$delegate).getViewModelStore();
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    /* renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$3, reason: invalid class name and case insensitive filesystem */
    public static final class C07543 extends Lambda implements S7.a {
        final /* synthetic */ C7.f $owner$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07543(C7.f fVar) {
            super(0);
            this.$owner$delegate = fVar;
        }

        @Override // S7.a
        public final CreationExtras invoke() {
            CreationExtras defaultViewModelCreationExtras;
            ViewModelStoreOwner viewModelStoreOwnerM7123viewModels$lambda0 = FragmentViewModelLazyKt.m7123viewModels$lambda0(this.$owner$delegate);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM7123viewModels$lambda0 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM7123viewModels$lambda0 : null;
            return (hasDefaultViewModelProviderFactory == null || (defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras()) == null) ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    /* renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$4, reason: invalid class name and case insensitive filesystem */
    public static final class C07554 extends Lambda implements S7.a {
        final /* synthetic */ C7.f $owner$delegate;
        final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07554(Fragment fragment, C7.f fVar) {
            super(0);
            this.$this_viewModels = fragment;
            this.$owner$delegate = fVar;
        }

        @Override // S7.a
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            ViewModelStoreOwner viewModelStoreOwnerM7123viewModels$lambda0 = FragmentViewModelLazyKt.m7123viewModels$lambda0(this.$owner$delegate);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM7123viewModels$lambda0 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM7123viewModels$lambda0 : null;
            if (hasDefaultViewModelProviderFactory != null && (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) != null) {
                return defaultViewModelProviderFactory;
            }
            ViewModelProvider.Factory defaultViewModelProviderFactory2 = this.$this_viewModels.getDefaultViewModelProviderFactory();
            k.e(defaultViewModelProviderFactory2, "defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory2;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    /* renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$6, reason: invalid class name and case insensitive filesystem */
    public static final class C07576 extends Lambda implements S7.a {
        final /* synthetic */ C7.f $owner$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07576(C7.f fVar) {
            super(0);
            this.$owner$delegate = fVar;
        }

        @Override // S7.a
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.m7124viewModels$lambda1(this.$owner$delegate).getViewModelStore();
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    /* renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$7, reason: invalid class name */
    public static final class AnonymousClass7 extends Lambda implements S7.a {
        final /* synthetic */ S7.a $extrasProducer;
        final /* synthetic */ C7.f $owner$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass7(S7.a aVar, C7.f fVar) {
            super(0);
            this.$extrasProducer = aVar;
            this.$owner$delegate = fVar;
        }

        @Override // S7.a
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            S7.a aVar = this.$extrasProducer;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            ViewModelStoreOwner viewModelStoreOwnerM7124viewModels$lambda1 = FragmentViewModelLazyKt.m7124viewModels$lambda1(this.$owner$delegate);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM7124viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM7124viewModels$lambda1 : null;
            return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    /* renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$8, reason: invalid class name */
    public static final class AnonymousClass8 extends Lambda implements S7.a {
        final /* synthetic */ C7.f $owner$delegate;
        final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(Fragment fragment, C7.f fVar) {
            super(0);
            this.$this_viewModels = fragment;
            this.$owner$delegate = fVar;
        }

        @Override // S7.a
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            ViewModelStoreOwner viewModelStoreOwnerM7124viewModels$lambda1 = FragmentViewModelLazyKt.m7124viewModels$lambda1(this.$owner$delegate);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM7124viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM7124viewModels$lambda1 : null;
            if (hasDefaultViewModelProviderFactory != null && (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) != null) {
                return defaultViewModelProviderFactory;
            }
            ViewModelProvider.Factory defaultViewModelProviderFactory2 = this.$this_viewModels.getDefaultViewModelProviderFactory();
            k.e(defaultViewModelProviderFactory2, "defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory2;
        }
    }

    @C7.c
    @MainThread
    public static final <VM extends ViewModel> C7.f activityViewModels(Fragment fragment, S7.a aVar) {
        k.f(fragment, "<this>");
        k.m();
        throw null;
    }

    public static C7.f activityViewModels$default(Fragment fragment, S7.a aVar, int i, Object obj) {
        k.f(fragment, "<this>");
        k.m();
        throw null;
    }

    @C7.c
    @MainThread
    public static final /* synthetic */ C7.f createViewModelLazy(final Fragment fragment, Z7.d viewModelClass, S7.a storeProducer, S7.a aVar) {
        k.f(fragment, "<this>");
        k.f(viewModelClass, "viewModelClass");
        k.f(storeProducer, "storeProducer");
        return createViewModelLazy(fragment, viewModelClass, storeProducer, new S7.a() { // from class: androidx.fragment.app.FragmentViewModelLazyKt.createViewModelLazy.1
            {
                super(0);
            }

            @Override // S7.a
            public final CreationExtras invoke() {
                CreationExtras defaultViewModelCreationExtras = fragment.getDefaultViewModelCreationExtras();
                k.e(defaultViewModelCreationExtras, "defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, aVar);
    }

    public static /* synthetic */ C7.f createViewModelLazy$default(Fragment fragment, Z7.d dVar, S7.a aVar, S7.a aVar2, int i, Object obj) {
        if ((i & 4) != 0) {
            aVar2 = null;
        }
        return createViewModelLazy(fragment, dVar, aVar, aVar2);
    }

    @C7.c
    @MainThread
    public static final <VM extends ViewModel> C7.f viewModels(Fragment fragment, S7.a ownerProducer, S7.a aVar) {
        k.f(fragment, "<this>");
        k.f(ownerProducer, "ownerProducer");
        kotlin.a.b(LazyThreadSafetyMode.c, new FragmentViewModelLazyKt$viewModels$owner$2(ownerProducer));
        k.m();
        throw null;
    }

    public static C7.f viewModels$default(final Fragment fragment, S7.a ownerProducer, S7.a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            ownerProducer = new S7.a() { // from class: androidx.fragment.app.FragmentViewModelLazyKt.viewModels.1
                {
                    super(0);
                }

                @Override // S7.a
                public final Fragment invoke() {
                    return fragment;
                }
            };
        }
        k.f(fragment, "<this>");
        k.f(ownerProducer, "ownerProducer");
        kotlin.a.b(LazyThreadSafetyMode.c, new FragmentViewModelLazyKt$viewModels$owner$2(ownerProducer));
        k.m();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: viewModels$lambda-0, reason: not valid java name */
    public static final ViewModelStoreOwner m7123viewModels$lambda0(C7.f fVar) {
        return (ViewModelStoreOwner) fVar.getF4884a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: viewModels$lambda-1, reason: not valid java name */
    public static final ViewModelStoreOwner m7124viewModels$lambda1(C7.f fVar) {
        return (ViewModelStoreOwner) fVar.getF4884a();
    }

    @MainThread
    public static final <VM extends ViewModel> C7.f activityViewModels(Fragment fragment, S7.a aVar, S7.a aVar2) {
        k.f(fragment, "<this>");
        k.m();
        throw null;
    }

    @MainThread
    public static final <VM extends ViewModel> C7.f createViewModelLazy(final Fragment fragment, Z7.d viewModelClass, S7.a storeProducer, S7.a extrasProducer, S7.a aVar) {
        k.f(fragment, "<this>");
        k.f(viewModelClass, "viewModelClass");
        k.f(storeProducer, "storeProducer");
        k.f(extrasProducer, "extrasProducer");
        if (aVar == null) {
            aVar = new S7.a() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1
                {
                    super(0);
                }

                @Override // S7.a
                public final ViewModelProvider.Factory invoke() {
                    ViewModelProvider.Factory defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
                    k.e(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                    return defaultViewModelProviderFactory;
                }
            };
        }
        return new ViewModelLazy(viewModelClass, storeProducer, aVar, extrasProducer);
    }

    public static /* synthetic */ C7.f createViewModelLazy$default(final Fragment fragment, Z7.d dVar, S7.a aVar, S7.a aVar2, S7.a aVar3, int i, Object obj) {
        if ((i & 4) != 0) {
            aVar2 = new S7.a() { // from class: androidx.fragment.app.FragmentViewModelLazyKt.createViewModelLazy.2
                {
                    super(0);
                }

                @Override // S7.a
                public final CreationExtras invoke() {
                    CreationExtras defaultViewModelCreationExtras = fragment.getDefaultViewModelCreationExtras();
                    k.e(defaultViewModelCreationExtras, "defaultViewModelCreationExtras");
                    return defaultViewModelCreationExtras;
                }
            };
        }
        if ((i & 8) != 0) {
            aVar3 = null;
        }
        return createViewModelLazy(fragment, dVar, aVar, aVar2, aVar3);
    }

    public static C7.f activityViewModels$default(Fragment fragment, S7.a aVar, S7.a aVar2, int i, Object obj) {
        k.f(fragment, "<this>");
        k.m();
        throw null;
    }

    @MainThread
    public static final <VM extends ViewModel> C7.f viewModels(Fragment fragment, S7.a ownerProducer, S7.a aVar, S7.a aVar2) {
        k.f(fragment, "<this>");
        k.f(ownerProducer, "ownerProducer");
        kotlin.a.b(LazyThreadSafetyMode.c, new FragmentViewModelLazyKt$viewModels$owner$4(ownerProducer));
        k.m();
        throw null;
    }

    public static C7.f viewModels$default(final Fragment fragment, S7.a ownerProducer, S7.a aVar, S7.a aVar2, int i, Object obj) {
        if ((i & 1) != 0) {
            ownerProducer = new S7.a() { // from class: androidx.fragment.app.FragmentViewModelLazyKt.viewModels.5
                {
                    super(0);
                }

                @Override // S7.a
                public final Fragment invoke() {
                    return fragment;
                }
            };
        }
        k.f(fragment, "<this>");
        k.f(ownerProducer, "ownerProducer");
        kotlin.a.b(LazyThreadSafetyMode.c, new FragmentViewModelLazyKt$viewModels$owner$4(ownerProducer));
        k.m();
        throw null;
    }
}
