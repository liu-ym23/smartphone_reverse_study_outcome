package android.view;

import C7.c;
import C7.f;
import S7.a;
import android.view.ViewModel;
import android.view.ViewModelStore;
import android.view.viewmodel.CreationExtras;
import androidx.annotation.MainThread;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001aM\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0010\b\n\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00032\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/activity/ComponentActivity;", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factoryProducer", "LC7/f;", "viewModels", "(Landroidx/activity/ComponentActivity;LS7/a;)LC7/f;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "extrasProducer", "(Landroidx/activity/ComponentActivity;LS7/a;LS7/a;)LC7/f;", "activity_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ActivityViewModelLazyKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    /* renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$1, reason: invalid class name */
    public static final class AnonymousClass1 implements a {
        final /* synthetic */ ComponentActivity $this_viewModels;

        public AnonymousClass1(ComponentActivity componentActivity) {
            this.$this_viewModels = componentActivity;
        }

        @Override // S7.a
        public final ViewModelStore invoke() {
            return this.$this_viewModels.getViewModelStore();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    /* renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$2, reason: invalid class name */
    public static final class AnonymousClass2 implements a {
        final /* synthetic */ ComponentActivity $this_viewModels;

        public AnonymousClass2(ComponentActivity componentActivity) {
            this.$this_viewModels = componentActivity;
        }

        @Override // S7.a
        public final CreationExtras invoke() {
            return this.$this_viewModels.getDefaultViewModelCreationExtras();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    /* renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$3, reason: invalid class name */
    public static final class AnonymousClass3 implements a {
        final /* synthetic */ ComponentActivity $this_viewModels;

        public AnonymousClass3(ComponentActivity componentActivity) {
            this.$this_viewModels = componentActivity;
        }

        @Override // S7.a
        public final ViewModelStore invoke() {
            return this.$this_viewModels.getViewModelStore();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    /* renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$4, reason: invalid class name */
    public static final class AnonymousClass4 implements a {
        final /* synthetic */ a $extrasProducer;
        final /* synthetic */ ComponentActivity $this_viewModels;

        public AnonymousClass4(a aVar, ComponentActivity componentActivity) {
            this.$extrasProducer = aVar;
            this.$this_viewModels = componentActivity;
        }

        @Override // S7.a
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            a aVar = this.$extrasProducer;
            return (aVar == null || (creationExtras = (CreationExtras) aVar.invoke()) == null) ? this.$this_viewModels.getDefaultViewModelCreationExtras() : creationExtras;
        }
    }

    @c
    @MainThread
    public static final <VM extends ViewModel> f viewModels(ComponentActivity componentActivity, a aVar) {
        k.f(componentActivity, "<this>");
        if (aVar == null) {
            new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        k.m();
        throw null;
    }

    public static f viewModels$default(ComponentActivity componentActivity, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            aVar = null;
        }
        k.f(componentActivity, "<this>");
        if (aVar == null) {
            new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        k.m();
        throw null;
    }

    @MainThread
    public static final <VM extends ViewModel> f viewModels(ComponentActivity componentActivity, a aVar, a aVar2) {
        k.f(componentActivity, "<this>");
        if (aVar2 == null) {
            new ActivityViewModelLazyKt$viewModels$factoryPromise$2(componentActivity);
        }
        k.m();
        throw null;
    }

    public static f viewModels$default(ComponentActivity componentActivity, a aVar, a aVar2, int i, Object obj) {
        if ((i & 2) != 0) {
            aVar2 = null;
        }
        k.f(componentActivity, "<this>");
        if (aVar2 == null) {
            new ActivityViewModelLazyKt$viewModels$factoryPromise$2(componentActivity);
        }
        k.m();
        throw null;
    }
}
