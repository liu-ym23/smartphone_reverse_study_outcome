package com.bytedance.android.shopping.anchorv3.compat;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.core.jedi.ReflectViewModelFactory;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.jedi.arch.Async;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.jedi.arch.IdentitySubscriber;
import com.bytedance.jedi.arch.JediView;
import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.LifecycleOwnerHolder;
import com.bytedance.jedi.arch.Middleware;
import com.bytedance.jedi.arch.ReceiverHolder;
import com.bytedance.jedi.arch.State;
import com.bytedance.jedi.arch.SubscriptionConfig;
import com.bytedance.jedi.arch.Tuple1;
import com.bytedance.jedi.arch.Tuple2;
import com.bytedance.jedi.arch.Tuple3;
import com.bytedance.jedi.arch.Tuple4;
import com.bytedance.jedi.arch.Tuple5;
import com.bytedance.jedi.arch.ViewModelFactoryOwner;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u00052\u00020\u0006:\u0002\t\nB\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/compat/ToggleBottomSheetFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/bytedance/jedi/arch/JediView;", "Lcom/bytedance/jedi/arch/ViewModelFactoryOwner;", "Lcom/bytedance/android/ec/core/jedi/ReflectViewModelFactory;", "Landroid/content/DialogInterface$OnShowListener;", "Lcom/bytedance/android/shopping/anchorv3/compat/g;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ToggleBottomSheetFragment extends BottomSheetDialogFragment implements JediView, ViewModelFactoryOwner<ReflectViewModelFactory>, DialogInterface.OnShowListener, g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReflectViewModelFactory f164775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f164776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BottomSheetBehavior<View> f164777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f164778g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<Boolean> f164779h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedList<b> f164780i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f164781j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f164782k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f164783l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f164784m;

    public static final class a {
    }

    public interface b {
        void a();
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToggleBottomSheetFragment f164785a;

        public c(ToggleBottomSheetFragment r100) {
            this.f164785a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Dialog r100 = this.f164785a.getDialog();     // Catch: Throwable -> L8
            if (r100 == null) goto L11;
            Window r101 = r100.getWindow();     // Catch: Throwable -> L8
            if (r101 == null) goto L15;
            r101.setWindowAnimations(R.style.commerce_dialog_dim_non_enter_animation);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class d extends BottomSheetBehavior.BottomSheetCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToggleBottomSheetFragment f164786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DialogInterface f164787b;

        public d(ToggleBottomSheetFragment r100, DialogInterface r101) {
            this.f164786a = r100;
            this.f164787b = r101;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onSlide(View r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f164786a.W90(r101);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onStateChanged(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f164786a.getClass();
            if (r101 != 5) goto L6;
            this.f164787b.dismiss();
        L6:
            if (r101 != 3) goto L12;
            this.f164786a.V90(true);
            Iterator<T> r102 = this.f164786a.f164780i.iterator();
        L9:
            if (r102.hasNext() == false) goto L12;
            ((b) r102.next()).a();
        L12:
            if (r101 != 4) goto L17;
            this.f164786a.V90(false);
            Iterator<T> r103 = this.f164786a.f164780i.iterator();
        L15:
            if (r103.hasNext() == false) goto L20;
            ((b) r103.next()).a();
            goto L15
        L20:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.anchorv3.compat.g
    public void D30(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    public abstract int S90();

    public int T90() {
        return -1;
    }

    public void V90(boolean r100) {
    }

    public void W90(float r100) {
    }

    public abstract int getLayoutId();

    public abstract String getTAG();

    public int U90() {
        n1.f45660i.getClass();
        return n1.a.b();
    }

    public ToggleBottomSheetFragment() {
        this.f164775d = new ReflectViewModelFactory();
        this.f164778g = LazyKt.lazy(new ToggleBottomSheetFragment$designBottomSheet$2(this));
        this.f164780i = new LinkedList();
        this.f164781j = 4;
        this.f164782k = true;
        this.f164783l = true;
        this.f164784m = true;
    }

    @Override // com.bytedance.jedi.arch.IdentitySubscriber, com.bytedance.jedi.arch.LifecycleOwnerHolder
    public final LifecycleOwner getLifecycleOwner() {
        return JediView.DefaultImpls.getLifecycleOwner(this);
    }

    @Override // com.bytedance.jedi.arch.IdentitySubscriber, com.bytedance.jedi.arch.ISubscriber
    public final LifecycleOwnerHolder getLifecycleOwnerHolder() {
        return JediView.DefaultImpls.getLifecycleOwnerHolder(this);
    }

    @Override // com.bytedance.jedi.arch.ReceiverHolder
    public final /* bridge */ /* synthetic */ IReceiver getReceiver() {
        return getReceiver();
    }

    @Override // com.bytedance.jedi.arch.IdentitySubscriber, com.bytedance.jedi.arch.ISubscriber
    public final ReceiverHolder<IdentitySubscriber> getReceiverHolder() {
        return JediView.DefaultImpls.getReceiverHolder(this);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final boolean getUniqueOnlyGlobal() {
        return JediView.DefaultImpls.getUniqueOnlyGlobal(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View r100 = getView();     // Catch: Exception -> L7
        if (r100 == null) goto L12;
        r100.postDelayed(new c(this), 300);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    @Override // com.bytedance.jedi.arch.ViewModelFactoryOwner
    public final ViewModelProvider.Factory getViewModelFactory() {
        return this.f164775d;
    }

    @Override // com.bytedance.jedi.arch.IdentitySubscriber, com.bytedance.jedi.arch.ReceiverHolder
    public final IdentitySubscriber getReceiver() {
        return JediView.DefaultImpls.getReceiver(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L7;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L7;
        r102.setBackgroundDrawableResource(R.color.commerce_color_00000000);
    L7:
        Dialog r103 = getDialog();
        if (r103 == null) goto L10;
        r103.setOnDismissListener(this);
    L10:
        Dialog r104 = getDialog();
        if (r104 == null) goto L13;
        r104.setOnShowListener(this);
    L13:
        Dialog r105 = getDialog();
        if (r105 == null) goto L17;
        r105.setOnKeyListener(new h(this));
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        Dialog r101 = getDialog();
        if (r101 == null) goto L5;
        r101.requestWindowFeature(1);
    L5:
        super.onCreate(r100);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r100) {
        return new ToggleBottomSheetDialog(requireActivity(), S90(), this, AnonymousClass1.INSTANCE);
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(final DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        View r101 = (View) this.f164778g.getValue();
        if (r101 == null) goto L33;
        this.f164776e = r101;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        r102.width = -1;
        if (this.f164783l == false) goto L7;
        int r103 = T90();
    L8:
        r102.height = r103;
        BottomSheetBehavior<View> r104 = BottomSheetBehavior.from(r101);
        this.f164777f = r104;
        if (r104 == null) goto L11;
        r104.setBottomSheetCallback(new d(this, r100));
    L11:
        BottomSheetBehavior<View> r105 = this.f164777f;
        if (r105 == null) goto L14;
        r105.setSkipCollapsed(!this.f164784m);
    L14:
        BottomSheetBehavior<View> r106 = this.f164777f;
        if (r106 == null) goto L17;
        r106.setState(this.f164781j);
    L17:
        BottomSheetBehavior<View> r107 = this.f164777f;
        if (r107 == null) goto L20;
        r107.setHideable(this.f164782k);
    L20:
        BottomSheetBehavior<View> r108 = this.f164777f;
        if (r108 == null) goto L24;
        r108.setPeekHeight(U90());
    L24:
        if ((r101 instanceof CompatFrameLayout) == true) goto L26;
        r101 = null;
    L26:
        CompatFrameLayout r109 = (CompatFrameLayout) r101;
        if (r109 == null) goto L29;
        Function0<Unit> r110 = new ToggleBottomSheetFragment$onShow$$inlined$let$lambda$2(this, r100);
        Intrinsics.checkNotNullParameter(r110, "dcb");
        r109.f164761b = r110;
    L29:
        View r111 = getView();
        if (r111 == null) goto L34;
        r111.getHeight();
        return;
    L34:
        return;
    L7:
        r103 = U90();
        goto L8
    }

    public final void X90(Activity r100, FragmentManager r101) {
        if (r101 == null) goto L21;
        r101.beginTransaction().remove(this).commitAllowingStateLoss();     // Catch: Exception -> L13
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isFinishing() == true) goto L23;
        String r102 = getTAG();     // Catch: Exception -> L13
        LandscapeRestrictionOperation r103 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L13
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r102, r103);     // Catch: Exception -> L13
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, this, r103) == true) goto L24;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L11:
        super.show(r101, r102);     // Catch: Exception -> L13
        return;
    L24:
        return;
    L23:
        return;
    L13:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <VM1 extends JediViewModel<S1>, S1 extends State, R> R withState(VM1 r100, Function1<? super S1, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r100, "viewModel1");
        Intrinsics.checkNotNullParameter(r101, "block");
        return (R) JediView.DefaultImpls.withState(this, r100, r101);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, R> R withSubstate(Middleware<S1, PROP1> r100, Function1<? super PROP1, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r100, "middleware1");
        Intrinsics.checkNotNullParameter(r101, "block");
        return (R) JediView.DefaultImpls.withSubstate(this, r100, r101);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Context r103 = getContext();
        if (r103 != null) goto L7;
        return null;
    L7:
        return th.a.c(r103, getLayoutId(), r101, false);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <S extends State> Disposable subscribe(JediViewModel<S> r100, SubscriptionConfig<S> r101, Function2<? super IdentitySubscriber, ? super S, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$subscribe");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "subscriber");
        return JediView.DefaultImpls.subscribe(this, r100, r101, r102);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <VM1 extends JediViewModel<S1>, S1 extends State, VM2 extends JediViewModel<S2>, S2 extends State, R> R withState(VM1 r100, VM2 r101, Function2<? super S1, ? super S2, ? extends R> r102) {
        Intrinsics.checkNotNullParameter(r100, "viewModel1");
        Intrinsics.checkNotNullParameter(r101, "viewModel2");
        Intrinsics.checkNotNullParameter(r102, "block");
        return (R) JediView.DefaultImpls.withState(this, r100, r101, r102);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, M2 extends Middleware<S2, PROP2>, PROP2 extends State, S2 extends State, R> R withSubstate(Middleware<S1, PROP1> r100, Middleware<S2, PROP2> r101, Function2<? super PROP1, ? super PROP2, ? extends R> r102) {
        Intrinsics.checkNotNullParameter(r100, "middleware1");
        Intrinsics.checkNotNullParameter(r101, "middleware2");
        Intrinsics.checkNotNullParameter(r102, "block");
        return (R) JediView.DefaultImpls.withSubstate(this, r100, r101, r102);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <S extends State, A> Disposable selectSubscribe(JediViewModel<S> r100, KProperty1<S, ? extends A> r101, SubscriptionConfig<Tuple1<A>> r102, Function2<? super IdentitySubscriber, ? super A, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$selectSubscribe");
        Intrinsics.checkNotNullParameter(r101, "prop1");
        Intrinsics.checkNotNullParameter(r102, "config");
        Intrinsics.checkNotNullParameter(r103, "subscriber");
        return JediView.DefaultImpls.selectSubscribe(this, r100, r101, r102, r103);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <VM1 extends JediViewModel<S1>, S1 extends State, VM2 extends JediViewModel<S2>, S2 extends State, VM3 extends JediViewModel<S3>, S3 extends State, R> R withState(VM1 r100, VM2 r101, VM3 r102, Function3<? super S1, ? super S2, ? super S3, ? extends R> r103) {
        Intrinsics.checkNotNullParameter(r100, "viewModel1");
        Intrinsics.checkNotNullParameter(r101, "viewModel2");
        Intrinsics.checkNotNullParameter(r102, "viewModel3");
        Intrinsics.checkNotNullParameter(r103, "block");
        return (R) JediView.DefaultImpls.withState(this, r100, r101, r102, r103);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, M2 extends Middleware<S2, PROP2>, PROP2 extends State, S2 extends State, M3 extends Middleware<S3, PROP3>, PROP3 extends State, S3 extends State, R> R withSubstate(Middleware<S1, PROP1> r100, Middleware<S2, PROP2> r101, Middleware<S3, PROP3> r102, Function3<? super PROP1, ? super PROP2, ? super PROP3, ? extends R> r103) {
        Intrinsics.checkNotNullParameter(r100, "middleware1");
        Intrinsics.checkNotNullParameter(r101, "middleware2");
        Intrinsics.checkNotNullParameter(r102, "middleware3");
        Intrinsics.checkNotNullParameter(r103, "block");
        return (R) JediView.DefaultImpls.withSubstate(this, r100, r101, r102, r103);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <S extends State, A, B> Disposable selectSubscribe(JediViewModel<S> r100, KProperty1<S, ? extends A> r101, KProperty1<S, ? extends B> r102, SubscriptionConfig<Tuple2<A, B>> r103, Function3<? super IdentitySubscriber, ? super A, ? super B, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "$this$selectSubscribe");
        Intrinsics.checkNotNullParameter(r101, "prop1");
        Intrinsics.checkNotNullParameter(r102, "prop2");
        Intrinsics.checkNotNullParameter(r103, "config");
        Intrinsics.checkNotNullParameter(r104, "subscriber");
        return JediView.DefaultImpls.selectSubscribe(this, r100, r101, r102, r103, r104);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <VM1 extends JediViewModel<S1>, S1 extends State, VM2 extends JediViewModel<S2>, S2 extends State, VM3 extends JediViewModel<S3>, S3 extends State, VM4 extends JediViewModel<S4>, S4 extends State, R> R withState(VM1 r100, VM2 r101, VM3 r102, VM4 r103, Function4<? super S1, ? super S2, ? super S3, ? super S4, ? extends R> r104) {
        Intrinsics.checkNotNullParameter(r100, "viewModel1");
        Intrinsics.checkNotNullParameter(r101, "viewModel2");
        Intrinsics.checkNotNullParameter(r102, "viewModel3");
        Intrinsics.checkNotNullParameter(r103, "viewModel4");
        Intrinsics.checkNotNullParameter(r104, "block");
        return (R) JediView.DefaultImpls.withState(this, r100, r101, r102, r103, r104);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, M2 extends Middleware<S2, PROP2>, PROP2 extends State, S2 extends State, M3 extends Middleware<S3, PROP3>, PROP3 extends State, S3 extends State, M4 extends Middleware<S4, PROP4>, PROP4 extends State, S4 extends State, R> R withSubstate(Middleware<S1, PROP1> r100, Middleware<S2, PROP2> r101, Middleware<S3, PROP3> r102, Middleware<S4, PROP4> r103, Function4<? super PROP1, ? super PROP2, ? super PROP3, ? super PROP4, ? extends R> r104) {
        Intrinsics.checkNotNullParameter(r100, "middleware1");
        Intrinsics.checkNotNullParameter(r101, "middleware2");
        Intrinsics.checkNotNullParameter(r102, "middleware3");
        Intrinsics.checkNotNullParameter(r103, "middleware4");
        Intrinsics.checkNotNullParameter(r104, "block");
        return (R) JediView.DefaultImpls.withSubstate(this, r100, r101, r102, r103, r104);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <S extends State, T> Disposable asyncSubscribe(JediViewModel<S> r100, KProperty1<S, ? extends Async<? extends T>> r101, SubscriptionConfig<Tuple1<Async<T>>> r102, Function2<? super IdentitySubscriber, ? super Throwable, Unit> r103, Function1<? super IdentitySubscriber, Unit> r104, Function2<? super IdentitySubscriber, ? super T, Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, "$this$asyncSubscribe");
        Intrinsics.checkNotNullParameter(r101, "prop");
        Intrinsics.checkNotNullParameter(r102, "config");
        return JediView.DefaultImpls.asyncSubscribe(this, r100, r101, r102, r103, r104, r105);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <S extends State, A, B, C> Disposable selectSubscribe(JediViewModel<S> r100, KProperty1<S, ? extends A> r101, KProperty1<S, ? extends B> r102, KProperty1<S, ? extends C> r103, SubscriptionConfig<Tuple3<A, B, C>> r104, Function4<? super IdentitySubscriber, ? super A, ? super B, ? super C, Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, "$this$selectSubscribe");
        Intrinsics.checkNotNullParameter(r101, "prop1");
        Intrinsics.checkNotNullParameter(r102, "prop2");
        Intrinsics.checkNotNullParameter(r103, "prop3");
        Intrinsics.checkNotNullParameter(r104, "config");
        Intrinsics.checkNotNullParameter(r105, "subscriber");
        return JediView.DefaultImpls.selectSubscribe(this, r100, r101, r102, r103, r104, r105);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <VM1 extends JediViewModel<S1>, S1 extends State, VM2 extends JediViewModel<S2>, S2 extends State, VM3 extends JediViewModel<S3>, S3 extends State, VM4 extends JediViewModel<S4>, S4 extends State, VM5 extends JediViewModel<S5>, S5 extends State, R> R withState(VM1 r100, VM2 r101, VM3 r102, VM4 r103, VM5 r104, Function5<? super S1, ? super S2, ? super S3, ? super S4, ? super S5, ? extends R> r105) {
        Intrinsics.checkNotNullParameter(r100, "viewModel1");
        Intrinsics.checkNotNullParameter(r101, "viewModel2");
        Intrinsics.checkNotNullParameter(r102, "viewModel3");
        Intrinsics.checkNotNullParameter(r103, "viewModel4");
        Intrinsics.checkNotNullParameter(r104, "viewModel5");
        Intrinsics.checkNotNullParameter(r105, "block");
        return (R) JediView.DefaultImpls.withState(this, r100, r101, r102, r103, r104, r105);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, M2 extends Middleware<S2, PROP2>, PROP2 extends State, S2 extends State, M3 extends Middleware<S3, PROP3>, PROP3 extends State, S3 extends State, M4 extends Middleware<S4, PROP4>, PROP4 extends State, S4 extends State, M5 extends Middleware<S5, PROP5>, PROP5 extends State, S5 extends State, R> R withSubstate(Middleware<S1, PROP1> r100, Middleware<S2, PROP2> r101, Middleware<S3, PROP3> r102, Middleware<S4, PROP4> r103, Middleware<S5, PROP5> r104, Function5<? super PROP1, ? super PROP2, ? super PROP3, ? super PROP4, ? super PROP5, ? extends R> r105) {
        Intrinsics.checkNotNullParameter(r100, "middleware1");
        Intrinsics.checkNotNullParameter(r101, "middleware2");
        Intrinsics.checkNotNullParameter(r102, "middleware3");
        Intrinsics.checkNotNullParameter(r103, "middleware4");
        Intrinsics.checkNotNullParameter(r104, "middleware5");
        Intrinsics.checkNotNullParameter(r105, "block");
        return (R) JediView.DefaultImpls.withSubstate(this, r100, r101, r102, r103, r104, r105);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <S extends State, A, B, C, D> Disposable selectSubscribe(JediViewModel<S> r100, KProperty1<S, ? extends A> r101, KProperty1<S, ? extends B> r102, KProperty1<S, ? extends C> r103, KProperty1<S, ? extends D> r104, SubscriptionConfig<Tuple4<A, B, C, D>> r105, Function5<? super IdentitySubscriber, ? super A, ? super B, ? super C, ? super D, Unit> r106) {
        Intrinsics.checkNotNullParameter(r100, "$this$selectSubscribe");
        Intrinsics.checkNotNullParameter(r101, "prop1");
        Intrinsics.checkNotNullParameter(r102, "prop2");
        Intrinsics.checkNotNullParameter(r103, "prop3");
        Intrinsics.checkNotNullParameter(r104, "prop4");
        Intrinsics.checkNotNullParameter(r105, "config");
        Intrinsics.checkNotNullParameter(r106, "subscriber");
        return JediView.DefaultImpls.selectSubscribe(this, r100, r101, r102, r103, r104, r105, r106);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <S extends State, A, B, C, D, E> Disposable selectSubscribe(JediViewModel<S> r100, KProperty1<S, ? extends A> r101, KProperty1<S, ? extends B> r102, KProperty1<S, ? extends C> r103, KProperty1<S, ? extends D> r104, KProperty1<S, ? extends E> r105, SubscriptionConfig<Tuple5<A, B, C, D, E>> r106, Function6<? super IdentitySubscriber, ? super A, ? super B, ? super C, ? super D, ? super E, Unit> r107) {
        Intrinsics.checkNotNullParameter(r100, "$this$selectSubscribe");
        Intrinsics.checkNotNullParameter(r101, "prop1");
        Intrinsics.checkNotNullParameter(r102, "prop2");
        Intrinsics.checkNotNullParameter(r103, "prop3");
        Intrinsics.checkNotNullParameter(r104, "prop4");
        Intrinsics.checkNotNullParameter(r105, "prop5");
        Intrinsics.checkNotNullParameter(r106, "config");
        Intrinsics.checkNotNullParameter(r107, "subscriber");
        return JediView.DefaultImpls.selectSubscribe(this, r100, r101, r102, r103, r104, r105, r106, r107);
    }
}
