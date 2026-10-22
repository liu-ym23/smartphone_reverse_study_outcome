package androidx.lifecycle.viewmodel.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00008\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aF\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b¢\u0006\u0002\u0010\u000b\u001aQ\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00010\r2\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000e\u001aK\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0019\b\b\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00010\u0010¢\u0006\u0002\b\u0011H\u0087\b¢\u0006\u0002\u0010\u0012\u001aK\u0010\u0013\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00010\r2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"viewModel", "VM", "Landroidx/lifecycle/ViewModel;", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "key", "", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Landroidx/lifecycle/ViewModelStoreOwner;Ljava/lang/String;Landroidx/lifecycle/ViewModelProvider$Factory;Landroidx/lifecycle/viewmodel/CreationExtras;Landroidx/compose/runtime/Composer;II)Landroidx/lifecycle/ViewModel;", "modelClass", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;Landroidx/lifecycle/ViewModelStoreOwner;Ljava/lang/String;Landroidx/lifecycle/ViewModelProvider$Factory;Landroidx/lifecycle/viewmodel/CreationExtras;Landroidx/compose/runtime/Composer;II)Landroidx/lifecycle/ViewModel;", "initializer", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/lifecycle/ViewModelStoreOwner;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/lifecycle/ViewModel;", MonitorConstants.CONNECT_TYPE_GET, "(Landroidx/lifecycle/ViewModelStoreOwner;Lkotlin/reflect/KClass;Ljava/lang/String;Landroidx/lifecycle/ViewModelProvider$Factory;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel-compose"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "androidx/lifecycle/viewmodel/compose/ViewModelKt")
final /* synthetic */ class ViewModelKt__ViewModelKt {
    public static final <VM extends ViewModel> VM get(ViewModelStoreOwner r100, KClass<VM> r101, String r102, ViewModelProvider.Factory r103, CreationExtras r110) {
        if (r103 == null) goto L5;
        ViewModelProvider r104 = ViewModelProvider.Companion.create(r100.getViewModelStore(), r103, r110);
    L8:
        if (r102 == null) goto L11;
        return (VM) r104.get(r102, r101);
    L11:
        return (VM) r104.get(r101);
    L5:
        if ((r100 instanceof HasDefaultViewModelProviderFactory) == false) goto L7;
        r104 = ViewModelProvider.Companion.create(r100.getViewModelStore(), ((HasDefaultViewModelProviderFactory) r100).getDefaultViewModelProviderFactory(), r110);
        goto L8
    L7:
        r104 = ViewModelProvider.Companion.create$default(ViewModelProvider.Companion, r100, null, null, 6, null);
        goto L8
    }

    public static final /* synthetic */ <VM extends ViewModel> VM viewModel(ViewModelStoreOwner r100, String r101, Function1<? super CreationExtras, ? extends VM> r110, Composer r111, int r112, int r113) {
        if ((r113 & 1) == 0) goto L9;
        r100 = LocalViewModelStoreOwner.INSTANCE.getCurrent(r111, 6);
        if (r100 != null) goto L9;
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    L9:
        ViewModelStoreOwner r102 = r100;
        if ((r113 & 2) == 0) goto L12;
        r101 = null;
    L12:
        String r103 = r101;
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass r104 = Reflection.getOrCreateKotlinClass(ViewModel.class);
        InitializerViewModelFactoryBuilder r114 = new InitializerViewModelFactoryBuilder();
        Intrinsics.reifiedOperationMarker(4, "VM");
        r114.addInitializer(Reflection.getOrCreateKotlinClass(ViewModel.class), r110);
        Unit r105 = Unit.INSTANCE;
        ViewModelProvider.Factory r106 = r114.build();
        if ((r102 instanceof HasDefaultViewModelProviderFactory) == false) goto L15;
        CreationExtras r107 = ((HasDefaultViewModelProviderFactory) r102).getDefaultViewModelCreationExtras();
    L16:
        CreationExtras r108 = r107;
        int r109 = r112 << 3;
        return (VM) ViewModelKt.viewModel(r104, r102, r103, r106, r108, r111, (r109 & 112) | (r109 & MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT), 0);
    L15:
        r107 = CreationExtras.Empty.INSTANCE;
        goto L16
    }

    public static /* synthetic */ ViewModel get$default(ViewModelStoreOwner r100, KClass r101, String r102, ViewModelProvider.Factory r103, CreationExtras r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = null;
    L9:
        if ((r105 & 8) == 0) goto L15;
        if ((r100 instanceof HasDefaultViewModelProviderFactory) == false) goto L13;
        r104 = ((HasDefaultViewModelProviderFactory) r100).getDefaultViewModelCreationExtras();
        goto L15
    L13:
        r104 = CreationExtras.Empty.INSTANCE;
    L15:
        return ViewModelKt.get(r100, r101, r102, r103, r104);
    }

    public static final /* synthetic */ <VM extends ViewModel> VM viewModel(ViewModelStoreOwner r100, String r101, ViewModelProvider.Factory r110, CreationExtras r111, Composer r112, int r113, int r114) {
        if ((r114 & 1) == 0) goto L9;
        r100 = LocalViewModelStoreOwner.INSTANCE.getCurrent(r112, 6);
        if (r100 != null) goto L9;
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    L9:
        ViewModelStoreOwner r102 = r100;
        if ((r114 & 2) == 0) goto L12;
        String r103 = null;
    L14:
        if ((r114 & 4) == 0) goto L16;
        ViewModelProvider.Factory r104 = null;
    L18:
        if ((r114 & 8) != 0) goto L20;
    L24:
        Intrinsics.reifiedOperationMarker(4, "VM");
        int r105 = r113 << 3;
        return (VM) ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(ViewModel.class), r102, r103, r104, r111, r112, (((r105 & 112) | (r105 & MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT)) | (r105 & 7168)) | (r105 & 57344), 0);
    L20:
        if ((r102 instanceof HasDefaultViewModelProviderFactory) == false) goto L22;
        CreationExtras r106 = ((HasDefaultViewModelProviderFactory) r102).getDefaultViewModelCreationExtras();
    L23:
        r111 = r106;
        goto L24
    L22:
        r106 = CreationExtras.Empty.INSTANCE;
        goto L23
    L16:
        r104 = r110;
        goto L18
    L12:
        r103 = r101;
        goto L14
    }

    public static final <VM extends ViewModel> VM viewModel(KClass<VM> r100, ViewModelStoreOwner r101, String r102, ViewModelProvider.Factory r103, CreationExtras r104, Composer r105, int r106, int r107) {
        if ((r107 & 2) == 0) goto L10;
        r101 = LocalViewModelStoreOwner.INSTANCE.getCurrent(r105, 6);
        if (r101 != null) goto L10;
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    L10:
        if ((r107 & 4) == 0) goto L13;
        r102 = null;
    L13:
        if ((r107 & 8) == 0) goto L16;
        r103 = null;
    L16:
        if ((r107 & 16) == 0) goto L22;
        if ((r101 instanceof HasDefaultViewModelProviderFactory) == false) goto L20;
        r104 = ((HasDefaultViewModelProviderFactory) r101).getDefaultViewModelCreationExtras();
        goto L22
    L20:
        r104 = CreationExtras.Empty.INSTANCE;
    L22:
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventStart(1673618944, r106, -1, "androidx.lifecycle.viewmodel.compose.viewModel (ViewModel.kt:105)");
    L24:
        VM r108 = (VM) ViewModelKt.get(r101, r100, r102, r103, r104);
        if (ComposerKt.isTraceInProgress() == false) goto L27;
        ComposerKt.traceEventEnd();
    L27:
        return r108;
    }
}
