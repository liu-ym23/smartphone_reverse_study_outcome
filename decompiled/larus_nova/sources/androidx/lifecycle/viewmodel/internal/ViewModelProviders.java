package androidx.lifecycle.viewmodel.internal;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0000¢\u0006\u0002\b\u000bJ\u0019\u0010\f\u001a\u0002H\r\"\b\b\u0000\u0010\r*\u00020\bH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00112\u0010\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013H\u0000¢\u0006\u0002\b\u0015J+\u0010\u0010\u001a\u00020\u00112\u001a\u0010\u0012\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00140\u0016\"\u0006\u0012\u0002\b\u00030\u0014H\u0000¢\u0006\u0004\b\u0015\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001eJK\u0010\u001f\u001a\u0002H\r\"\b\b\u0000\u0010\r*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\r0\n2\u0006\u0010 \u001a\u00020\u001d2\u001a\u0010\u0012\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00140\u0016\"\u0006\u0012\u0002\b\u00030\u0014H\u0000¢\u0006\u0004\b!\u0010\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/lifecycle/viewmodel/internal/ViewModelProviders;", "", "<init>", "()V", "VIEW_MODEL_PROVIDER_DEFAULT_KEY", "", "getDefaultKey", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Lkotlin/reflect/KClass;", "getDefaultKey$lifecycle_viewmodel", "unsupportedCreateViewModel", "VM", "unsupportedCreateViewModel$lifecycle_viewmodel", "()Landroidx/lifecycle/ViewModel;", "createInitializerFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "initializers", "", "Landroidx/lifecycle/viewmodel/ViewModelInitializer;", "createInitializerFactory$lifecycle_viewmodel", "", "([Landroidx/lifecycle/viewmodel/ViewModelInitializer;)Landroidx/lifecycle/ViewModelProvider$Factory;", "getDefaultFactory", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "getDefaultFactory$lifecycle_viewmodel", "getDefaultCreationExtras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "getDefaultCreationExtras$lifecycle_viewmodel", "createViewModelFromInitializers", "extras", "createViewModelFromInitializers$lifecycle_viewmodel", "(Lkotlin/reflect/KClass;Landroidx/lifecycle/viewmodel/CreationExtras;[Landroidx/lifecycle/viewmodel/ViewModelInitializer;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ViewModelProviders {
    public static final ViewModelProviders INSTANCE = null;
    private static final String VIEW_MODEL_PROVIDER_DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";

    static {
        INSTANCE = new ViewModelProviders();
    }

    private ViewModelProviders() {
    }

    public final <VM extends ViewModel> VM unsupportedCreateViewModel$lifecycle_viewmodel() {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }

    public final ViewModelProvider.Factory createInitializerFactory$lifecycle_viewmodel(Collection<? extends ViewModelInitializer<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "initializers");
        ViewModelInitializer[] r101 = (ViewModelInitializer[]) r100.toArray(new ViewModelInitializer[0]);
        return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(r101, r101.length));
    }

    public final CreationExtras getDefaultCreationExtras$lifecycle_viewmodel(ViewModelStoreOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        if ((r100 instanceof HasDefaultViewModelProviderFactory) == false) goto L6;
        return ((HasDefaultViewModelProviderFactory) r100).getDefaultViewModelCreationExtras();
    L6:
        return CreationExtras.Empty.INSTANCE;
    }

    public final ViewModelProvider.Factory getDefaultFactory$lifecycle_viewmodel(ViewModelStoreOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        if ((r100 instanceof HasDefaultViewModelProviderFactory) == false) goto L6;
        return ((HasDefaultViewModelProviderFactory) r100).getDefaultViewModelProviderFactory();
    L6:
        return DefaultViewModelProviderFactory.INSTANCE;
    }

    public final <T extends ViewModel> String getDefaultKey$lifecycle_viewmodel(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        String r101 = CanonicalName_jvmKt.getCanonicalName(r100);
        if (r101 == null) goto L7;
        return "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(r101);
    L7:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels".toString());
    }

    public final ViewModelProvider.Factory createInitializerFactory$lifecycle_viewmodel(ViewModelInitializer<?>... r100) {
        Intrinsics.checkNotNullParameter(r100, "initializers");
        return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(r100, r100.length));
    }

    public final <VM extends ViewModel> VM createViewModelFromInitializers$lifecycle_viewmodel(KClass<VM> r100, CreationExtras r101, ViewModelInitializer<?>... r102) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        Intrinsics.checkNotNullParameter(r101, "extras");
        Intrinsics.checkNotNullParameter(r102, "initializers");
        int r103 = r102.length;
        int r104 = 0;
    L3:
        VM r105 = null;
        if (r104 >= r103) goto L9;
        ViewModelInitializer<?> r106 = r102[r104];
        if (Intrinsics.areEqual(r106.getClazz$lifecycle_viewmodel(), r100) == true) goto L10;
        r104 = r104 + 1;
    L10:
        if (r106 == null) goto L14;
        Function1<CreationExtras, T> r107 = r106.getInitializer$lifecycle_viewmodel();
        if (r107 == 0) goto L14;
        r105 = (VM) r107.invoke(r101);
    L14:
        if (r105 == null) goto L17;
        return r105;
    L17:
        throw new IllegalArgumentException(("No initializer set for given class " + CanonicalName_jvmKt.getCanonicalName(r100)).toString());
    L9:
        r106 = null;
        goto L10
    }
}
