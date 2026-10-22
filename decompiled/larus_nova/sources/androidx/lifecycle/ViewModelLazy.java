package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BC\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0014\u0010\u0011\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Landroidx/lifecycle/ViewModelLazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Lkotlin/Lazy;", "viewModelClass", "Lkotlin/reflect/KClass;", "storeProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStore;", "factoryProducer", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extrasProducer", "Landroidx/lifecycle/viewmodel/CreationExtras;", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "cached", "Landroidx/lifecycle/ViewModel;", "value", "getValue", "()Landroidx/lifecycle/ViewModel;", "isInitialized", "", "lifecycle-viewmodel"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ViewModelLazy<VM extends ViewModel> implements Lazy<VM> {
    private VM cached;
    private final Function0<CreationExtras> extrasProducer;
    private final Function0<ViewModelProvider.Factory> factoryProducer;
    private final Function0<ViewModelStore> storeProducer;
    private final KClass<VM> viewModelClass;

    public ViewModelLazy(KClass<VM> r100, Function0<? extends ViewModelStore> r110, Function0<? extends ViewModelProvider.Factory> r111) {
        Intrinsics.checkNotNullParameter(r100, "viewModelClass");
        Intrinsics.checkNotNullParameter(r110, "storeProducer");
        Intrinsics.checkNotNullParameter(r111, "factoryProducer");
        this(r100, r110, r111, null, 8, null);
    }

    public static /* synthetic */ CreationExtras.Empty a() {
        return _init_$lambda$0();
    }

    @Override // kotlin.Lazy
    public VM getValue() {
        VM r100 = this.cached;
        if (r100 != null) goto L6;
        ViewModelStore r101 = this.storeProducer.invoke();
        ViewModelProvider.Factory r102 = this.factoryProducer.invoke();
        CreationExtras r103 = this.extrasProducer.invoke();
        VM r104 = (VM) ViewModelProvider.Companion.create(r101, r102, r103).get(this.viewModelClass);
        this.cached = r104;
        return r104;
    L6:
        return r100;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        if (this.cached == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static final CreationExtras.Empty _init_$lambda$0() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // kotlin.Lazy
    public /* bridge */ /* synthetic */ Object getValue() {
        return getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelLazy(KClass<VM> r100, Function0<? extends ViewModelStore> r101, Function0<? extends ViewModelProvider.Factory> r102, Function0<? extends CreationExtras> r103) {
        Intrinsics.checkNotNullParameter(r100, "viewModelClass");
        Intrinsics.checkNotNullParameter(r101, "storeProducer");
        Intrinsics.checkNotNullParameter(r102, "factoryProducer");
        Intrinsics.checkNotNullParameter(r103, "extrasProducer");
        this.viewModelClass = r100;
        this.storeProducer = r101;
        this.factoryProducer = r102;
        this.extrasProducer = r103;
    }

    public /* synthetic */ ViewModelLazy(KClass r100, Function0 r101, Function0 r102, Function0 r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = new s();
    L5:
        this(r100, r101, r102, r103);
    }
}
