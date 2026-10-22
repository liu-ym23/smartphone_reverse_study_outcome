package com.obric.appstore.buss.search;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.b0;
import androidx.lifecycle.s;
import bytedanceos.view.animation.TweenInterpolator;
import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.ui.transition.FadeTransition;
import com.bytedanceos.ui.transition.Slide;
import com.obric.appstore.R;
import com.obric.appstore.buss.search.transition.SearchTransition;
import com.obric.appstore.util.m;
import com.obric.common.oea.foundation.animation.token.Token$Delay;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.forms.OEditText;
import com.obric.oui.searchbar.v2.OSearchBar;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sa.r;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 D2\u00020\u0001:\u0001EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u0003J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\fR\u001a\u0010\u001a\u001a\u00020\u00158\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u00158\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010'\u001a\u00020\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0016\u00109\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u0010<\u001a\u00020(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0014\u0010>\u001a\u00020(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010;R$\u0010C\u001a\u00020(2\u0006\u0010?\u001a\u00020(8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b@\u0010;\"\u0004\bA\u0010B¨\u0006F"}, d2 = {"Lcom/obric/appstore/buss/search/SearchContainerFragment;", "Lcom/obric/appstore/base/e;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", ServerElements.CONTENT, "B", "(Landroid/view/View;)V", "onResume", "onPause", "", "trigger", "b0", "(Ljava/lang/String;)V", "e0", "U", "", "h", "I", "w", "()I", "layoutId", "i", "v", "headerLayoutId", "Lcom/obric/oui/searchbar/v2/OSearchBar;", "j", "Lcom/obric/oui/searchbar/v2/OSearchBar;", "searchBar", "Lcom/obric/appstore/buss/search/SearchVM;", "k", "Lkotlin/Lazy;", "T", "()Lcom/obric/appstore/buss/search/SearchVM;", "searchVM", "", "l", "Z", "wasImeVisible", "Lkotlinx/coroutines/Job;", "m", "Lkotlinx/coroutines/Job;", "imeJob", "n", "Landroid/view/View;", "searchBarCancelBtn", "Landroidx/lifecycle/b0;", "S", "()Landroidx/lifecycle/b0;", "savedStateHandle", "P", "()Ljava/lang/String;", "argSearchHint", "R", "()Z", "argTransitionSlide", "Q", "argTransitionScene1", CommonKey.KEY_VALUE, "a0", "d0", "(Z)V", "isTransitionSetup", "o", "a", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSearchContainerFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchContainerFragment.kt\ncom/obric/appstore/buss/search/SearchContainerFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Transition.kt\nandroidx/core/transition/TransitionKt\n+ 5 View.kt\nandroidx/core/view/ViewKt\n+ 6 OUnitExtension.kt\ncom/obric/oui/common/util/OUnitExtensionKt\n*L\n1#1,579:1\n106#2,15:580\n1#3:595\n31#4:596\n69#4,16:597\n39#4:613\n69#4,16:614\n84#5:630\n84#5:631\n329#5,2:632\n331#5,2:642\n181#6,3:634\n180#6,5:637\n*S KotlinDebug\n*F\n+ 1 SearchContainerFragment.kt\ncom/obric/appstore/buss/search/SearchContainerFragment\n*L\n100#1:580,15\n321#1:596\n321#1:597,16\n383#1:613\n383#1:614,16\n495#1:630\n508#1:631\n411#1:632,2\n411#1:642,2\n412#1:634,3\n412#1:637,5\n*E\n"})
public final class SearchContainerFragment extends com.obric.appstore.base.e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f10846o = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f10847h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f10848i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OSearchBar f10849j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f10850k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f10851l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Job f10852m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f10853n;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchContainerFragment f10854a;

        public b(SearchContainerFragment r10) {
            this.f10854a = r10;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
            SearchVM r14 = this.f10854a.T();
            if (r10 == null) goto L5;
            String r15 = r10.toString();
        L6:
            if (r15 != null) goto L8;
            r15 = "";
        L8:
            r14.l(r15);
            return;
        L5:
            r15 = null;
            goto L6
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f10855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OIconButtonFloating f10856b;

        public c(View r10, OIconButtonFloating r11) {
            this.f10855a = r10;
            this.f10856b = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Fade r10 = new Fade();
            r10.addTarget(SearchTransition.TRANSITION_NAME_SEARCH_BAR_CANCEL_BTN);
            r10.setInterpolator(new TweenInterpolator(2));
            r10.setDuration(Token$Duration.OUI_ANIMATION_DURATION_SHORT_4.getDuration());
            r10.setStartDelay(Token$Delay.OUI_ANIMATION_DELAY_SHORT_3.getValue());
            TransitionManager.beginDelayedTransition(this.f10856b, r10);
            this.f10856b.setVisibility(0);
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f10857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SearchContainerFragment f10858b;

        public d(View r10, SearchContainerFragment r11) {
            this.f10857a = r10;
            this.f10858b = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f10858b.startPostponedEnterTransition();
            FragmentActivity r10 = this.f10858b.getActivity();
            if (r10 == null) goto L6;
            r10.startPostponedEnterTransition();
            return;
        }
    }

    public static final class e implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f10859a;

        public e(Function1 r10) {
            q.g(r10, "function");
            this.f10859a = r10;
        }

        public final boolean equals(Object r10) {
            if ((r10 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r10 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return q.b(getFunctionDelegate(), ((FunctionAdapter) r10).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function getFunctionDelegate() {
            return this.f10859a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r10) {
            this.f10859a.invoke(r10);
        }
    }

    public static final class f implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchContainerFragment f10860a;

        public f(SearchContainerFragment r10) {
            this.f10860a = r10;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition r10) {
            q.g(r10, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r10) {
            q.g(r10, "transition");
            OSearchBar r11 = SearchContainerFragment.L(this.f10860a);
            if (r11 == null) goto L5;
            OEditText r12 = r11.getInputView();
        L6:
            if (r12 == null) goto L13;
            Editable r13 = r12.getEditableText();
            if (r13 == null) goto L14;
            q.d(r13);
            if (r13.length() != 0) goto L15;
            r12.requestLayout();
            r12.addOnLayoutChangeListener(new g(this.f10860a));
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        L5:
            r12 = null;
            goto L6
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition r10) {
            q.g(r10, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition r10) {
            q.g(r10, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition r10) {
            q.g(r10, "transition");
        }
    }

    public static final class g implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchContainerFragment f10861a;

        public g(SearchContainerFragment r10) {
            this.f10861a = r10;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18) {
            q.g(r10, "view");
            r10.removeOnLayoutChangeListener(this);
            r10.requestFocus();
            SearchContainerFragment.O(this.f10861a, "sharedElementEnter");
        }
    }

    public static final class h implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchContainerFragment f10862a;

        public h(SearchContainerFragment r10) {
            this.f10862a = r10;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition r10) {
            q.g(r10, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r10) {
            q.g(r10, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition r10) {
            q.g(r10, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition r10) {
            q.g(r10, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition r10) {
            q.g(r10, "transition");
            View r11 = SearchContainerFragment.M(this.f10862a);
            if (r11 == null) goto L6;
            r11.setVisibility(4);
            return;
        }
    }

    /* JADX INFO: renamed from: com.obric.appstore.buss.search.SearchContainerFragment$onResume$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appstore.buss.search.SearchContainerFragment$onResume$1", f = "SearchContainerFragment.kt", i = {}, l = {291}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SearchContainerFragment this$0;

        public AnonymousClass1(SearchContainerFragment r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = kotlin.coroutines.intrinsics.a.d();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            kotlin.c.b(r10);
        L12:
            if (SearchContainerFragment.N(this.this$0) == false) goto L15;
            SearchContainerFragment.O(this.this$0, "onResume_restoreIme");
        L15:
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r10);
            this.label = 1;
            if (DelayKt.b(500, this) != r11) goto L12;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    static {
        f10846o = new a(null);
    }

    public SearchContainerFragment() {
        this.f10847h = R.layout.obric_fragment_search_container;
        this.f10848i = R.layout.search_header_layout;
        final Function0<Fragment> r10 = new SearchContainerFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r11 = kotlin.b.a(LazyThreadSafetyMode.NONE, new SearchContainerFragment$special$$inlined$viewModels$default$2(r10));
        final Function0 r12 = null;
        this.f10850k = FragmentViewModelLazyKt.c(this, u.b(SearchVM.class), new SearchContainerFragment$special$$inlined$viewModels$default$3(r11), new SearchContainerFragment$special$$inlined$viewModels$default$4(r12, r11), new SearchContainerFragment$special$$inlined$viewModels$default$5(this, r11));
    }

    public static /* synthetic */ void F(SearchContainerFragment r10, View r11, boolean r12) {
        W(r10, r11, r12);
    }

    public static /* synthetic */ boolean G(OSearchBar r10, SearchContainerFragment r11, TextView r12, int r13, KeyEvent r14) {
        return X(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ void H(SearchContainerFragment r10, View r11) {
        Z(r10, r11);
    }

    public static /* synthetic */ void I(EditText r10, SearchContainerFragment r11, String r12) {
        c0(r10, r11, r12);
    }

    public static /* synthetic */ void J(View r10, View r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
        V(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static /* synthetic */ CharSequence K(SearchContainerFragment r10, CharSequence r11, int r12, int r13, Spanned r14, int r15, int r16) {
        return Y(r10, r11, r12, r13, r14, r15, r16);
    }

    public static final /* synthetic */ OSearchBar L(SearchContainerFragment r10) {
        return r10.f10849j;
    }

    public static final /* synthetic */ View M(SearchContainerFragment r10) {
        return r10.f10853n;
    }

    public static final /* synthetic */ boolean N(SearchContainerFragment r10) {
        return r10.f10851l;
    }

    public static final /* synthetic */ void O(SearchContainerFragment r10, String r11) {
        r10.b0(r11);
    }

    private final b0 S() {
        return T().h();
    }

    public static final void V(View r10, View r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
        q.g(r10, "$content");
        if (r15 == r19) goto L11;
        View r20 = r10.findViewById(R.id.search_history_container);
        if (r20 == null) goto L12;
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        if (r21 == null) goto L10;
        ViewGroup.MarginLayoutParams r22 = (ViewGroup.MarginLayoutParams) r21;
        r22.topMargin = r15 + yf.b.b(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
        r20.setLayoutParams(r22);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L12:
        return;
    }

    public static final void W(SearchContainerFragment r10, View r11, boolean r12) {
        q.g(r10, "this$0");
        if (r12 == false) goto L12;
        SearchVM r13 = r10.T();
        j r14 = (j) r10.T().j().e();
        if (r14 == null) goto L7;
        String r15 = r14.a();
    L8:
        if (r15 != null) goto L10;
        r15 = "";
    L10:
        r13.l(r15);
        return;
    L7:
        r15 = null;
        goto L8
    }

    public static final boolean X(OSearchBar r10, SearchContainerFragment r11, TextView r12, int r13, KeyEvent r14) {
        q.g(r11, "this$0");
        String r15 = StringsKt__StringsKt.z0(String.valueOf(r10.getInputView().getText())).toString();
        OEditText r16 = null;
        if (r15.length() <= 0) goto L9;
        r11.T().m(r15);
        r11.T().l(r15);
        OSearchBar r17 = r11.f10849j;
        if (r17 == null) goto L7;
        r16 = r17.getInputView();
    L7:
        com.obric.appstore.util.j.e(r11, r16, 0, 2, null);
        return true;
    L9:
        OSearchBar r18 = r11.f10849j;
        if (r18 == null) goto L12;
        r16 = r18.getInputView();
    L12:
        com.obric.appstore.util.j.e(r11, r16, 0, 2, null);
        return true;
    }

    public static final CharSequence Y(SearchContainerFragment r10, CharSequence r11, int r12, int r13, Spanned r14, int r15, int r16) {
        Object r17 = "";
        q.g(r10, "this$0");
        Result.a r18 = Result.Companion;     // Catch: Throwable -> L6
        int r19 = r14.toString().length();     // Catch: Throwable -> L6
        int r20 = r11.toString().length();     // Catch: Throwable -> L6
        int r21 = r16 - r15;     // Catch: Throwable -> L6
        int r22 = ((r19 + r20) - r21) - 26;     // Catch: Throwable -> L6
        if (r22 <= 0) goto L8;
        e0.h(r10.getString(R.string.search_key_over_length), 0);     // Catch: Throwable -> L6
        r11 = r11.subSequence(0, r20 - r22);     // Catch: Throwable -> L6
    L13:
        Object r23 = Result.m35constructorimpl(r11);     // Catch: Throwable -> L6
    L16:
        Throwable r24 = Result.m38exceptionOrNullimpl(r23);
        if (r24 != null) goto L19;
        r17 = r23;
    L21:
        return (CharSequence) r17;
    L19:
        com.bytedanceos.common.toolbox.j.b(r24.toString());
        goto L21
    L8:
        q.d(r11);     // Catch: Throwable -> L6
        if (r11.length() != 0) goto L13;
        if (r21 < 1) goto L13;
        r11 = "";
    L6:
        th = move-exception;
        Result.a r25 = Result.Companion;
        r23 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L16
    }

    public static final void Z(SearchContainerFragment r10, View r11) {
        q.g(r10, "this$0");
        if (r10.getLifecycle().b().isAtLeast(Lifecycle.State.RESUMED) == true) goto L5;
        return;
    L5:
        com.obric.appstore.util.j.c(r10);
        FragmentActivity r12 = r10.getActivity();
        if (r12 == null) goto L9;
        r12.onBackPressed();
        return;
    }

    public static final void c0(EditText r11, SearchContainerFragment r12, String r13) {
        q.g(r11, "$editText");
        q.g(r12, "this$0");
        q.g(r13, "$trigger");
        boolean r10 = r11.isAttachedToWindow();
        if (r11.getWindowToken() == null) goto L5;
        boolean r14 = true;
    L6:
        boolean r15 = r11.isFocused();
        boolean r16 = r11.hasWindowFocus();
        boolean r17 = com.obric.appstore.util.j.g(r12);
        com.bytedanceos.common.toolbox.j.n("SearchContainerFragment requestFocusAndShowImeIfReady[" + r13 + "]: attached=" + r10 + ", windowToken=" + r14 + ", isFocused=" + r15 + ", hasWindowFocus=" + r16 + ", imeVisible=" + r17);
        if (r10 == false) goto L13;
        if (r14 == false) goto L13;
        if (r15 == false) goto L13;
        if (r16 == false) goto L13;
        if (r17 == true) goto L13;
        com.obric.appstore.util.j.h(r12, r11);
        return;
    L13:
        com.bytedanceos.common.toolbox.j.n("SearchContainerFragment skip showIme[" + r13 + "]: attached=" + r10 + ", windowToken=" + r14 + ", isFocused=" + r15 + ", hasWindowFocus=" + r16 + ", imeVisible=" + r17);
        return;
    L5:
        r14 = false;
        goto L6
    }

    @Override // com.obric.appstore.base.e
    public void B(View r10) {
        q.g(r10, ServerElements.CONTENT);
        super.B(r10);
        U(r10);
        m.a("appstore_btn_click", SearchContainerFragment$onCreateContentView$1.INSTANCE);
        postponeEnterTransition();
        final r r11 = r.a(r10);
        FrameLayout r12 = r11.b();
        q.f(r12, "getRoot(...)");
        u8.c.c(r12, SearchContainerFragment$onCreateContentView$2$1.INSTANCE);
        int r13 = 0;
        r11.f24672g.setUserInputEnabled(false);
        r11.f24672g.setAdapter(new i(this));
        T().j().i(getViewLifecycleOwner(), new e(new SearchContainerFragment$onCreateContentView$2$2(r11, this)));
        T().i().i(getViewLifecycleOwner(), new e(new SearchContainerFragment$onCreateContentView$2$3(r11, this)));
        Intent r14 = r();
        if (r14 == null) goto L5;
        r13 = r14.getIntExtra("original_type", 0);
    L5:
        String r15 = null;
        String r16 = "";
        if (r13 != 7) goto L8;
        Intent r17 = r();
        if (r17 == null) goto L22;
        String r18 = r17.getStringExtra("original_extra");
    L23:
        if (r18 != null) goto L25;
        r18 = "";
    L25:
        r16 = StringsKt__StringsKt.z0(r18).toString();
        String r19 = "";
    L26:
        String r20 = P();
        if (r20 == null) goto L36;
        String r21 = StringsKt__StringsKt.z0(r20).toString();
        if (r21 == null) goto L36;
        if (o.r(r21) == true) goto L33;
        r15 = r21;
    L33:
        if (r15 == null) goto L36;
        r16 = r15;
    L36:
        if (r16.length() <= 0) goto L42;
        OSearchBar r22 = this.f10849j;
        if (r22 == null) goto L48;
        OEditText r23 = r22.getInputView();
        if (r23 == null) goto L48;
        r23.setHint(r16);
    L48:
        if (r19.length() <= 0) goto L50;
        T().l(r19);
    L56:
        OSearchBar r24 = this.f10849j;
        if (r24 == null) goto L61;
        OEditText r25 = r24.getInputView();
        if (r25 == null) goto L61;
        ViewCompat.H0(r25, SearchTransition.TRANSITION_NAME_SEARCH_BAR_INPUT_IN_SEARCH);
    L61:
        OSearchBar r26 = this.f10849j;
        if (r26 == null) goto L64;
        ViewCompat.H0(r26, SearchTransition.TRANSITION_NAME_SEARCH_BAR_IN_SEARCH);
    L64:
        OSearchBar r27 = this.f10849j;
        if (r27 == null) goto L70;
        View r28 = com.obric.appstore.common.core.ui.view.a.a(r27);
        if (r28 == null) goto L71;
        ViewCompat.H0(r28, SearchTransition.TRANSITION_NAME_SEARCH_BAR_BG_IN_SEARCH);
        return;
    L71:
        return;
    L70:
        return;
    L50:
        OSearchBar r29 = this.f10849j;
        if (r29 == null) goto L55;
        OEditText r30 = r29.getInputView();
        if (r30 == null) goto L55;
        r30.requestFocus();
    L55:
        b0("onCreate_initial");
        goto L56
    L42:
        OSearchBar r31 = this.f10849j;
        if (r31 == null) goto L48;
        OEditText r32 = r31.getInputView();
        if (r32 == null) goto L48;
        r32.setHint(R.string.search_bar_hint);
        goto L48
    L22:
        r18 = null;
        goto L23
    L8:
        if (r13 != 8) goto L10;
    L12:
        Intent r33 = r();
        if (r33 == null) goto L15;
        String r34 = r33.getStringExtra("original_extra");
    L16:
        if (r34 != null) goto L18;
        r34 = "";
    L18:
        r19 = StringsKt__StringsKt.z0(r34).toString();
        goto L26
    L15:
        r34 = null;
        goto L16
    L10:
        if (r13 == 9) goto L12;
        r19 = "";
        goto L26
    }

    public final String P() {
        Bundle r10 = getArguments();
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.getString("search_hint", null);
    }

    public final boolean Q() {
        Bundle r10 = getArguments();
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.getInt("transition_cancel_btn_scene") == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean R() {
        Bundle r10 = getArguments();
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.getBoolean("transition_slide", false);
    }

    public final SearchVM T() {
        return (SearchVM) this.f10850k.getValue();
    }

    public final void U(final View r10) {
        sa.a r11 = s();
        if (r11 == null) goto L16;
        FrameLayout r12 = r11.f24561c;
        if (r12 == null) goto L17;
        View r13 = r12.findViewById(R.id.search_bar_container);
        if (r13 == null) goto L9;
        q.d(r13);
        u8.c.e(r13, SearchContainerFragment$initTitleBar$1$1$1.INSTANCE);
        r13.addOnLayoutChangeListener(new com.obric.appstore.buss.search.b(r10));
    L9:
        final OSearchBar r14 = (OSearchBar) r12.findViewById(R.id.search_bar);
        OEditText r15 = r14.getInputView();
        r15.setImeOptions(3);
        r15.setOnFocusChangeListener(new com.obric.appstore.buss.search.c(this));
        r15.addTextChangedListener(new b(this));
        r15.setOnEditorActionListener(new com.obric.appstore.buss.search.d(r14, this));
        r15.setFilters(new InputFilter[]{new com.obric.appstore.buss.search.e(this)});
        this.f10849j = r14;
        View r16 = r12.findViewById(R.id.search_bar_cancel_btn);
        OIconButtonFloating r17 = (OIconButtonFloating) r16;
        ViewCompat.H0(r17, SearchTransition.TRANSITION_NAME_SEARCH_BAR_CANCEL_BTN);
        r17.setVisibility(0);
        if (a0() == true) goto L14;
        d0(true);
        if (Q() == false) goto L14;
        r17.setVisibility(4);
        q.d(r17);
        q.f(androidx.core.view.j.a(r17, new c(r17, r17)), "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
    L14:
        q.d(r17);
        q.f(androidx.core.view.j.a(r17, new d(r17, this)), "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
        r17.setOnClickListener(new com.obric.appstore.buss.search.f(this));
        this.f10853n = r16;
        return;
    L17:
        return;
    }

    public final boolean a0() {
        Boolean r10 = (Boolean) S().c("transition_setup");
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.booleanValue();
    }

    public final void b0(final String r10) {
        OSearchBar r11 = this.f10849j;
        final OEditText r12 = null;
        if (r11 == null) goto L5;
        OEditText r13 = r11.getInputView();
    L6:
        if (r13 == null) goto L8;
        r12 = r13;
    L8:
        if (r12 != null) goto L11;
        com.bytedanceos.common.toolbox.j.n("SearchContainerFragment requestFocusAndShowImeIfReady[" + r10 + "]: inputView is null");
        return;
    L11:
        r12.requestFocus();
        r12.post(new com.obric.appstore.buss.search.a(r12, this, r10));
        return;
    L5:
        r13 = null;
        goto L6
    }

    public final void d0(boolean r10) {
        S().g("transition_setup", Boolean.valueOf(r10));
    }

    public final void e0() {
        FragmentActivity r10 = getActivity();
        Window r11 = null;
        if (r10 == null) goto L5;
        Window r12 = r10.getWindow();
    L7:
        if (r12 == null) goto L10;
        TransitionSet r13 = new TransitionSet();
        Transition r14 = TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move);
        SearchTransition.a r15 = SearchTransition.Companion;
        Context r16 = requireContext();
        q.f(r16, "requireContext(...)");
        r14.setInterpolator(r15.c(r16));
        r14.setDuration(r15.b());
        r13.addTransition(r14);
        FadeTransition r17 = new FadeTransition(0.0f, 1.0f, new TweenInterpolator(1));
        r17.setDuration(Token$Duration.OUI_ANIMATION_DURATION_SHORT_2.getDuration());
        r13.addTransition(r17);
        r13.addListener(new f(this));
        r12.setSharedElementEnterTransition(r13);
    L10:
        FragmentActivity r18 = getActivity();
        if (r18 == null) goto L14;
        r11 = r18.getWindow();
    L14:
        if (r11 == null) goto L18;
        TransitionSet r19 = new TransitionSet();
        Transition r20 = TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move);
        SearchTransition.a r21 = SearchTransition.Companion;
        Context r110 = requireContext();
        q.f(r110, "requireContext(...)");
        r20.setInterpolator(r21.c(r110));
        r20.setDuration(r21.a());
        r19.addTransition(r20);
        FadeTransition r22 = new FadeTransition(1.0f, 0.0f, new TweenInterpolator(2));
        r22.setDuration(Token$Duration.OUI_ANIMATION_DURATION_SHORT_2.getDuration());
        r19.addTransition(r22);
        r11.setSharedElementReturnTransition(r19);
    L18:
        if (Q() == false) goto L27;
        Transition r23 = TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move);
        SearchTransition.a r24 = SearchTransition.Companion;
        Context r25 = requireContext();
        q.f(r25, "requireContext(...)");
        r23.setInterpolator(r24.c(r25));
        r23.setDuration(r24.b());
        setSharedElementEnterTransition(r23);
        TransitionSet r26 = new TransitionSet();
        Fade r27 = new Fade();
        r27.excludeTarget(SearchTransition.TRANSITION_NAME_SEARCH_BAR_CANCEL_BTN, true);
        r27.setInterpolator(new TweenInterpolator(1));
        Token$Duration r28 = Token$Duration.OUI_ANIMATION_DURATION_SHORT_2;
        r27.setDuration(r28.getDuration());
        r26.addTransition(r27);
        if (R() == false) goto L22;
        Slide r29 = new Slide(80);
        r29.b(0.065f);
        Context r30 = requireContext();
        q.f(r30, "requireContext(...)");
        r29.setInterpolator(r24.c(r30));
        r29.setDuration(r24.b());
        r26.addTransition(r29);
    L22:
        setEnterTransition(r26);
        TransitionSet r31 = new TransitionSet();
        Fade r32 = new Fade();
        r32.setInterpolator(new TweenInterpolator(2));
        r32.setDuration(r28.getDuration());
        r32.addListener(new h(this));
        r31.addTransition(r32);
        if (R() == false) goto L25;
        Slide r33 = new Slide(80);
        r33.b(0.065f);
        Context r34 = requireContext();
        q.f(r34, "requireContext(...)");
        r33.setInterpolator(r24.c(r34));
        r33.setDuration(r24.a());
        r31.addTransition(r33);
    L25:
        setReturnTransition(r31);
        return;
    L27:
        return;
    L5:
        r12 = null;
        goto L7
    }

    @Override // com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        e0();
        T().k();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Job r10 = this.f10852m;
        if (r10 == null) goto L5;
        Job.a.b(r10, null, 1, null);
    L5:
        View r11 = getView();
        if (r11 == null) goto L10;
        WindowInsets r12 = r11.getRootWindowInsets();
        if (r12 == null) goto L10;
        boolean r13 = r12.isVisible(WindowInsets.Type.ime());
    L11:
        this.f10851l = r13;
        return;
    L10:
        r13 = false;
        goto L11
    }

    @Override // com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Job r10 = this.f10852m;
        if (r10 == null) goto L5;
        Job.a.b(r10, null, 1, null);
    L5:
        LifecycleOwner r11 = getViewLifecycleOwner();
        q.f(r11, "getViewLifecycleOwner(...)");
        this.f10852m = kotlinx.coroutines.h.d(s.a(r11), null, null, new AnonymousClass1(this, null), 3, null);
    }

    @Override // com.obric.appstore.base.e
    public int v() {
        return this.f10848i;
    }

    @Override // com.obric.appstore.base.e
    public int w() {
        return this.f10847h;
    }
}
