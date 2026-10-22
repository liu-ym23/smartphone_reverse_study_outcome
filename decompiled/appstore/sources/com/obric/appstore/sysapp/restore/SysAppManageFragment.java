package com.obric.appstore.sysapp.restore;

import android.graphics.Insets;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.s;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.m;
import com.bytedanceos.common.toolbox.j;
import com.obric.appstore.R;
import com.obric.appstore.buss.apps.AppsManager;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.smt.obric.appstore.domain.sysapp.LoadSysAppUseCase;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.t;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x7.l;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 32\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0003R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/obric/appstore/sysapp/restore/SysAppManageFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "n", "Lcom/obric/appstore/sysapp/restore/SysAppManageViewModel;", "a", "Lkotlin/Lazy;", "t", "()Lcom/obric/appstore/sysapp/restore/SysAppManageViewModel;", "viewModel", "Lx7/l;", "b", "Lx7/l;", "p", "()Lx7/l;", "v", "(Lx7/l;)V", "binding", "Lcom/obric/appstore/sysapp/restore/SysAppManageAdapter;", "c", "Lcom/obric/appstore/sysapp/restore/SysAppManageAdapter;", "adapter", "", "r", "()Z", "showWifiUpdateSettings", "", "s", "()I", "titlebarTextRes", "Lcom/smt/obric/appstore/domain/sysapp/LoadSysAppUseCase$Filter;", "q", "()Lcom/smt/obric/appstore/domain/sysapp/LoadSysAppUseCase$Filter;", "filter", "d", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSysAppManageFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SysAppManageFragment.kt\ncom/obric/appstore/sysapp/restore/SysAppManageFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,156:1\n106#2,15:157\n162#3,8:172\n*S KotlinDebug\n*F\n+ 1 SysAppManageFragment.kt\ncom/obric/appstore/sysapp/restore/SysAppManageFragment\n*L\n59#1:157,15\n93#1:172,8\n*E\n"})
public final class SysAppManageFragment extends Fragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f10988d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f10989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f10990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SysAppManageAdapter f10991c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final SysAppManageFragment a(boolean r10, int r11, LoadSysAppUseCase.Filter r12) {
            q.g(r12, "filter");
            SysAppManageFragment r13 = new SysAppManageFragment();
            Bundle r14 = new Bundle();
            r14.putBoolean("ARG_SHOW_WIFI_UPDATE_SETTINGS", r10);
            r14.putInt("ARG_TITLEBAR_TEXT_RES", r11);
            r14.putString("ARG_SYS_APP_FILTER", r12.name());
            r13.setArguments(r14);
            return r13;
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.appstore.sysapp.restore.SysAppManageFragment$onViewCreated$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appstore.sysapp.restore.SysAppManageFragment$onViewCreated$2", f = "SysAppManageFragment.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SysAppManageAdapter $adapter;
        int label;
        final /* synthetic */ SysAppManageFragment this$0;

        /* JADX INFO: renamed from: com.obric.appstore.sysapp.restore.SysAppManageFragment$onViewCreated$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.appstore.sysapp.restore.SysAppManageFragment$onViewCreated$2$1", f = "SysAppManageFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ SysAppManageAdapter $adapter;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SysAppManageFragment this$0;

            /* JADX INFO: renamed from: com.obric.appstore.sysapp.restore.SysAppManageFragment$onViewCreated$2$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00072\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u008a@¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "Lcom/obric/appstore/sysapp/restore/e;", "appItems", "", "error", "", "wifiEnabled", "", "<anonymous>", "(Ljava/util/List;Ljava/lang/Throwable;Z)V"}, k = 3, mv = {1, 9, 0})
            @DebugMetadata(c = "com.obric.appstore.sysapp.restore.SysAppManageFragment$onViewCreated$2$1$1", f = "SysAppManageFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class C01731 extends SuspendLambda implements Function4<List<? extends e>, Throwable, Boolean, Continuation<? super Unit>, Object> {
                final /* synthetic */ SysAppManageAdapter $adapter;
                /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                /* synthetic */ Object L$2;
                int label;
                final /* synthetic */ SysAppManageFragment this$0;

                public C01731(SysAppManageFragment r10, SysAppManageAdapter r11, Continuation<? super C01731> r12) {
                    this.this$0 = r10;
                    this.$adapter = r11;
                    super(4, r12);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Object invoke(List<? extends e> r10, Throwable r11, Boolean r12, Continuation<? super Unit> r13) {
                    return invoke2(r10, r11, r12, r13);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object r10) {
                    kotlin.coroutines.intrinsics.a.d();
                    if (this.label != 0) goto L24;
                    kotlin.c.b(r10);
                    List r11 = (List) this.L$0;
                    Throwable r12 = (Throwable) this.L$1;
                    Boolean r13 = (Boolean) this.L$2;
                    if (SysAppManageFragment.l(this.this$0) == false) goto L17;
                    if (r11 != null) goto L10;
                    if (r12 != null) goto L10;
                    boolean r14 = false;
                L11:
                    if (r13 == null) goto L22;
                    if (r14 == false) goto L22;
                    SysAppManageAdapter r15 = this.$adapter;
                    if (r11 != null) goto L16;
                    r11 = t.i();
                L16:
                    r15.d(r11, r13);
                L22:
                    return Unit.f21064a;
                L10:
                    r14 = true;
                    goto L11
                L17:
                    SysAppManageAdapter r16 = this.$adapter;
                    if (r11 != null) goto L20;
                    r11 = t.i();
                L20:
                    r16.d(r11, null);
                    goto L22
                L24:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(@Nullable List<e> r10, @Nullable Throwable r11, @Nullable Boolean r12, @Nullable Continuation<? super Unit> r13) {
                    C01731 r14 = new C01731(this.this$0, this.$adapter, r13);
                    r14.L$0 = r10;
                    r14.L$1 = r11;
                    r14.L$2 = r12;
                    return r14.invokeSuspend(Unit.f21064a);
                }
            }

            /* JADX INFO: renamed from: com.obric.appstore.sysapp.restore.SysAppManageFragment$onViewCreated$2$1$2, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.obric.appstore.sysapp.restore.SysAppManageFragment$onViewCreated$2$1$2", f = "SysAppManageFragment.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
            public static final class C01742 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ SysAppManageFragment this$0;

                /* JADX INFO: renamed from: com.obric.appstore.sysapp.restore.SysAppManageFragment$onViewCreated$2$1$2$a */
                public static final class a implements FlowCollector {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ SysAppManageFragment f10992a;

                    public a(SysAppManageFragment r10) {
                        this.f10992a = r10;
                    }

                    public final Object a(Map r10, Continuation r11) {
                        SysAppManageFragment.m(this.f10992a).n(true);
                        return Unit.f21064a;
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object r10, Continuation r11) {
                        return a((Map) r10, r11);
                    }
                }

                public C01742(SysAppManageFragment r10, Continuation<? super C01742> r11) {
                    this.this$0 = r10;
                    super(2, r11);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
                    return new C01742(this.this$0, r11);
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
                    kotlin.c.b(r10);
                L12:
                    throw new KotlinNothingValueException();
                L6:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    kotlin.c.b(r10);
                    StateFlow r13 = le.a.f21945a.b();
                    a r14 = new a(this.this$0);
                    this.label = 1;
                    if (r13.collect(r14, this) != r11) goto L12;
                    return r11;
                }

                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
                    return ((C01742) create(r10, r11)).invokeSuspend(Unit.f21064a);
                }
            }

            public AnonymousClass1(SysAppManageFragment r10, SysAppManageAdapter r11, Continuation<? super AnonymousClass1> r12) {
                this.this$0 = r10;
                this.$adapter = r11;
                super(2, r12);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
                AnonymousClass1 r12 = new AnonymousClass1(this.this$0, this.$adapter, r11);
                r12.L$0 = r10;
                return r12;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
                return invoke2(r10, r11);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object r10) {
                kotlin.coroutines.intrinsics.a.d();
                if (this.label != 0) goto L7;
                kotlin.c.b(r10);
                CoroutineScope r11 = (CoroutineScope) this.L$0;
                j.n("SysAppManageFragment onViewCreated, repeatOnLifecycle STARTED");
                kotlinx.coroutines.flow.c.G(kotlinx.coroutines.flow.c.j(SysAppManageFragment.m(this.this$0).l(), SysAppManageFragment.m(this.this$0).k(), SysAppManageFragment.m(this.this$0).m(), new C01731(this.this$0, this.$adapter, null)), r11);
                h.d(r11, null, null, new C01742(this.this$0, null), 3, null);
                return Unit.f21064a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
                return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
            }
        }

        public AnonymousClass2(SysAppManageFragment r10, SysAppManageAdapter r11, Continuation<? super AnonymousClass2> r12) {
            this.this$0 = r10;
            this.$adapter = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new AnonymousClass2(this.this$0, this.$adapter, r11);
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
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r10);
            LifecycleOwner r13 = this.this$0.getViewLifecycleOwner();
            q.f(r13, "getViewLifecycleOwner(...)");
            Lifecycle.State r14 = Lifecycle.State.STARTED;
            AnonymousClass1 r15 = new AnonymousClass1(this.this$0, this.$adapter, null);
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

    static {
        f10988d = new a(null);
    }

    public SysAppManageFragment() {
        Function0<ViewModelProvider.Factory> r10 = new SysAppManageFragment$viewModel$2(this);
        final Function0<Fragment> r11 = new SysAppManageFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r12 = kotlin.b.a(LazyThreadSafetyMode.NONE, new SysAppManageFragment$special$$inlined$viewModels$default$2(r11));
        final Function0 r13 = null;
        this.f10989a = FragmentViewModelLazyKt.c(this, u.b(SysAppManageViewModel.class), new SysAppManageFragment$special$$inlined$viewModels$default$3(r12), new SysAppManageFragment$special$$inlined$viewModels$default$4(r13, r12), r10);
    }

    public static /* synthetic */ WindowInsets i(int r10, int r11, View r12, WindowInsets r13) {
        return o(r10, r11, r12, r13);
    }

    public static /* synthetic */ void j(SysAppManageFragment r10, View r11) {
        u(r10, r11);
    }

    public static final /* synthetic */ LoadSysAppUseCase.Filter k(SysAppManageFragment r10) {
        return r10.q();
    }

    public static final /* synthetic */ boolean l(SysAppManageFragment r10) {
        return r10.r();
    }

    public static final /* synthetic */ SysAppManageViewModel m(SysAppManageFragment r10) {
        return r10.t();
    }

    public static final WindowInsets o(int r10, int r11, View r12, WindowInsets r13) {
        q.g(r12, "v");
        q.g(r13, "insets");
        Insets r14 = r13.getInsets(WindowInsetsCompat.Type.d());
        q.f(r14, "getInsets(...)");
        int r15 = r10 + r14.top;
        int r16 = r11 + r14.bottom;
        r12.setPadding(r12.getPaddingLeft(), r15, r12.getPaddingRight(), r16);
        return r13;
    }

    public static final void u(SysAppManageFragment r10, View r11) {
        q.g(r10, "this$0");
        FragmentActivity r12 = r10.getActivity();
        if (r12 == null) goto L6;
        r12.finish();
        return;
    }

    public final void n() {
        final int r10 = p().f25647b.getPaddingTop();
        final int r11 = p().f25647b.getPaddingBottom();
        p().f25647b.setOnApplyWindowInsetsListener(new c(r10, r11));
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        AppsManager r11 = AppsManager.f10585a;
        FragmentActivity r12 = requireActivity();
        q.f(r12, "requireActivity(...)");
        r11.k(r12);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        q.g(r10, "inflater");
        j.n("SysAppManageFragment onCreateView");
        l r13 = l.c(r10, r11, false);
        q.f(r13, "inflate(...)");
        v(r13);
        p().f25649d.setCenterTitle(s());
        n();
        ConstraintLayout r14 = p().b();
        q.f(r14, "getRoot(...)");
        return r14;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        j.n("SysAppManageFragment onDestroyView");
        p().f25647b.setAdapter(null);
        this.f10991c = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        q.g(r10, "view");
        super.onViewCreated(r10, r11);
        OFloatingTitleBar r12 = p().f25649d;
        q.f(r12, "titlebar");
        OFloatingTitleBar.m(r12, R.drawable.o_ic_titlebar_back, 0, new d(this), 2, null);
        RecyclerView.ItemAnimator r13 = p().f25647b.getItemAnimator();
        if ((r13 instanceof m) == false) goto L5;
        m r14 = (m) r13;
    L7:
        if (r14 == null) goto L10;
        r14.V(false);
    L10:
        FragmentActivity r15 = requireActivity();
        q.f(r15, "requireActivity(...)");
        SysAppManageAdapter r16 = new SysAppManageAdapter(r15, new SysAppManageFragment$onViewCreated$adapter$1(this));
        this.f10991c = r16;
        p().f25647b.setAdapter(r16);
        SysAppManageViewModel.o(t(), false, 1, null);
        LifecycleOwner r17 = getViewLifecycleOwner();
        q.f(r17, "getViewLifecycleOwner(...)");
        h.d(s.a(r17), null, null, new AnonymousClass2(this, r16, null), 3, null);
        return;
    L5:
        r14 = null;
        goto L7
    }

    public final l p() {
        l r10 = this.f10990b;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("binding");
        return null;
    }

    public final LoadSysAppUseCase.Filter q() {
        Result.a r10 = Result.Companion;     // Catch: Throwable -> L5
        String r11 = requireArguments().getString("ARG_SYS_APP_FILTER");     // Catch: Throwable -> L5
        if (r11 != null) goto L7;
        r11 = "";
    L7:
        Object r12 = Result.m35constructorimpl(LoadSysAppUseCase.Filter.valueOf(r11));     // Catch: Throwable -> L5
    L10:
        LoadSysAppUseCase.Filter r13 = LoadSysAppUseCase.Filter.SysAppRecovery;
        if (Result.m41isFailureimpl(r12) == false) goto L14;
        r12 = r13;
    L14:
        return (LoadSysAppUseCase.Filter) r12;
    L5:
        th = move-exception;
        Result.a r14 = Result.Companion;
        r12 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L10
    }

    public final boolean r() {
        return requireArguments().getBoolean("ARG_SHOW_WIFI_UPDATE_SETTINGS");
    }

    public final int s() {
        return requireArguments().getInt("ARG_TITLEBAR_TEXT_RES");
    }

    public final SysAppManageViewModel t() {
        return (SysAppManageViewModel) this.f10989a.getValue();
    }

    public final void v(l r10) {
        q.g(r10, "<set-?>");
        this.f10990b = r10;
    }
}
