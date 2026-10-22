package com.obric.appstore.buss.myapp.sysapp;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import bb.e;
import com.bytedanceos.common.utils.ActivityUtilKt;
import com.obric.appstore.R;
import com.obric.appstore.base.BaseListAdapter;
import com.obric.appstore.base.BaseListFragment;
import com.obric.appstore.base.ILoadViewModel;
import com.obric.appstore.base.k;
import com.obric.appstore.buss.detail.o;
import com.obric.appstore.ui.adapter.ItemAppProvider;
import com.obric.appstore.util.s;
import com.obric.oui.status.OPageStatus;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u0004J!\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\u00198\u0014X\u0094D¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010$\u001a\u00020\u001f8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010*\u001a\u00020%8\u0014X\u0094D¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R \u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020,0+8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/obric/appstore/buss/myapp/sysapp/SysAppFragment;", "Lcom/obric/appstore/base/BaseListFragment;", "Lcom/obric/appstore/buss/myapp/sysapp/a;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/obric/oui/status/OPageStatus;", "empty", "Q", "(Lcom/obric/oui/status/OPageStatus;)V", "Lcom/obric/appstore/buss/myapp/sysapp/SysAppVM;", "o", "Lkotlin/Lazy;", "d0", "()Lcom/obric/appstore/buss/myapp/sysapp/SysAppVM;", "sysAppVM", "", "p", "I", "v", "()I", "headerLayoutId", "Lcom/obric/appstore/buss/myapp/sysapp/SysAppUIAdapter;", "q", "Lcom/obric/appstore/buss/myapp/sysapp/SysAppUIAdapter;", "b0", "()Lcom/obric/appstore/buss/myapp/sysapp/SysAppUIAdapter;", "adapter", "", "r", "Z", "H", "()Z", "showLoadingWhenEmpty", "Lcom/obric/appstore/base/k;", "", "c0", "()Lcom/obric/appstore/base/k;", "listVM", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "V", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSysAppFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SysAppFragment.kt\ncom/obric/appstore/buss/myapp/sysapp/SysAppFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,129:1\n106#2,15:130\n*S KotlinDebug\n*F\n+ 1 SysAppFragment.kt\ncom/obric/appstore/buss/myapp/sysapp/SysAppFragment\n*L\n32#1:130,15\n*E\n"})
public final class SysAppFragment extends BaseListFragment<a> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f10722o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f10723p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final SysAppUIAdapter f10724q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f10725r;

    /* JADX INFO: renamed from: com.obric.appstore.buss.myapp.sysapp.SysAppFragment$onViewCreated$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appstore.buss.myapp.sysapp.SysAppFragment$onViewCreated$2", f = "SysAppFragment.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SysAppFragment this$0;

        /* JADX INFO: renamed from: com.obric.appstore.buss.myapp.sysapp.SysAppFragment$onViewCreated$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.appstore.buss.myapp.sysapp.SysAppFragment$onViewCreated$2$1", f = "SysAppFragment.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SysAppFragment this$0;

            /* JADX INFO: renamed from: com.obric.appstore.buss.myapp.sysapp.SysAppFragment$onViewCreated$2$1$a */
            public static final class a implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ SysAppFragment f10726a;

                public a(SysAppFragment r10) {
                    this.f10726a = r10;
                }

                public final Object a(Map r10, Continuation r11) {
                    ILoadViewModel.s(SysAppFragment.a0(this.f10726a), true, false, 2, null);
                    return Unit.f21064a;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object r10, Continuation r11) {
                    return a((Map) r10, r11);
                }
            }

            public AnonymousClass1(SysAppFragment r10, Continuation<? super AnonymousClass1> r11) {
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
                if (r12 != 1) goto L6;
                c.b(r10);
            L12:
                throw new KotlinNothingValueException();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                c.b(r10);
                StateFlow r13 = le.a.f21945a.b();
                a r14 = new a(this.this$0);
                this.label = 1;
                if (r13.collect(r14, this) != r11) goto L12;
                return r11;
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
                return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
            }
        }

        public AnonymousClass2(SysAppFragment r10, Continuation<? super AnonymousClass2> r11) {
            this.this$0 = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new AnonymousClass2(this.this$0, r11);
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
            c.b(r10);
        L12:
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            c.b(r10);
            LifecycleOwner r13 = this.this$0.getViewLifecycleOwner();
            q.f(r13, "getViewLifecycleOwner(...)");
            Lifecycle.State r14 = Lifecycle.State.STARTED;
            AnonymousClass1 r15 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.b(r13, r14, r15, this) != r11) goto L12;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass2) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public SysAppFragment() {
        final Function0<Fragment> r10 = new SysAppFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r11 = kotlin.b.a(LazyThreadSafetyMode.NONE, new SysAppFragment$special$$inlined$viewModels$default$2(r10));
        final Function0 r12 = null;
        this.f10722o = FragmentViewModelLazyKt.c(this, u.b(SysAppVM.class), new SysAppFragment$special$$inlined$viewModels$default$3(r11), new SysAppFragment$special$$inlined$viewModels$default$4(r12, r11), new SysAppFragment$special$$inlined$viewModels$default$5(this, r11));
        this.f10724q = new SysAppUIAdapter();
    }

    public static final /* synthetic */ SysAppVM a0(SysAppFragment r10) {
        return r10.d0();
    }

    @Override // com.obric.appstore.base.BaseFragment
    public boolean H() {
        return this.f10725r;
    }

    @Override // com.obric.appstore.base.BaseFragment
    public void Q(OPageStatus r10) {
        q.g(r10, "empty");
        getView();
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public /* bridge */ /* synthetic */ BaseListAdapter U() {
        return b0();
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public DiffUtil.ItemCallback V() {
        return new b();
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public /* bridge */ /* synthetic */ ILoadViewModel X() {
        return c0();
    }

    public SysAppUIAdapter b0() {
        return this.f10724q;
    }

    public k c0() {
        return d0();
    }

    public final SysAppVM d0() {
        return (SysAppVM) this.f10722o.getValue();
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onCreate(Bundle r13) {
        super.onCreate(r13);
        SysAppUIAdapter r14 = b0();
        String r10 = getPageSource();
        int r12 = o.a();
        r14.addItemProvider(new ItemAppProvider(r10, false, false, AnonymousClass1.INSTANCE, Integer.valueOf(r12), false, false, 0.0f, 160, null));
    }

    @Override // com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        q.g(r10, "view");
        super.onViewCreated(r10, r11);
        s r12 = J();
        if (r12 == null) goto L9;
        sa.c r13 = r12.k();
        if (r13 == null) goto L9;
        ViewStub r14 = r13.f24568b;
        if (r14 == null) goto L9;
        r14.setLayoutResource(R.layout.common_state_empty_view_medium);
    L9:
        LifecycleOwner r15 = getViewLifecycleOwner();
        q.f(r15, "getViewLifecycleOwner(...)");
        h.d(androidx.lifecycle.s.a(r15), null, null, new AnonymousClass2(this, null), 3, null);
        final RecyclerView r16 = Y();
        if (r16 == null) goto L13;
        ActivityUtilKt.b(r16, new SysAppFragment$onViewCreated$3$1(r16));
        r16.setClipToPadding(false);
        r16.addItemDecoration(new e(o.c(), o.b(), o.c(), false, 0, o.b()));
        return;
    }

    @Override // com.obric.appstore.base.e
    public int v() {
        return this.f10723p;
    }
}
