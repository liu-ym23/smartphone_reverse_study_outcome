package com.obric.appstore.buss.myapp.myapp;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import bb.d;
import com.bytedanceos.common.f;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.utils.ActivityUtilKt;
import com.obric.appstore.R;
import com.obric.appstore.base.BaseListAdapter;
import com.obric.appstore.base.BaseListFragment;
import com.obric.appstore.base.ILoadViewModel;
import com.obric.appstore.base.k;
import com.obric.appstore.buss.apps.AppCallback;
import com.obric.appstore.buss.apps.AppsManager;
import com.obric.appstore.buss.detail.o;
import com.obric.appstore.common.core.ui.view.ObricAppItemView;
import com.obric.appstore.ui.adapter.ItemAppProvider;
import com.obric.appstore.ui.adapter.ItemTitleProvider;
import com.obric.appstore.ui.adapter.ItemType;
import com.obric.appstore.ui.menu.PopMenu;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.status.OPageStatus;
import com.smt.obric.appstore.domain.app.AppInstallActor;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0005J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\u00020\u00158\u0014X\u0094D¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010 \u001a\u00020\u001b8\u0016X\u0096D¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010,\u001a\u00020'8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001a\u00102\u001a\u00020-8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001a\u00105\u001a\u00020\u001b8\u0014X\u0094D¢\u0006\f\n\u0004\b3\u0010\u001d\u001a\u0004\b4\u0010\u001fR\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R \u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020;0:8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0016\u0010B\u001a\u0004\u0018\u00010?8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006C"}, d2 = {"Lcom/obric/appstore/buss/myapp/myapp/MyAppFragment;", "Lcom/obric/appstore/base/BaseListFragment;", "Lcom/obric/appstore/buss/myapp/myapp/b;", "Lcom/obric/appstore/buss/apps/AppCallback;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroy", "onAppUpdate", "Lcom/obric/oui/status/OPageStatus;", "empty", "Q", "(Lcom/obric/oui/status/OPageStatus;)V", "", "o", "I", "v", "()I", "headerLayoutId", "", "p", "Z", "W", "()Z", "enableNested", "Lcom/obric/appstore/buss/myapp/myapp/MyAppVM;", "q", "Lkotlin/Lazy;", "g0", "()Lcom/obric/appstore/buss/myapp/myapp/MyAppVM;", "myAppVM", "Lcom/obric/appstore/buss/myapp/myapp/MyAppUIAdapter;", "r", "Lcom/obric/appstore/buss/myapp/myapp/MyAppUIAdapter;", "d0", "()Lcom/obric/appstore/buss/myapp/myapp/MyAppUIAdapter;", "adapter", "Lcom/obric/appstore/buss/myapp/myapp/c;", "s", "Lcom/obric/appstore/buss/myapp/myapp/c;", "e0", "()Lcom/obric/appstore/buss/myapp/myapp/c;", "diffCallback", "t", "H", "showLoadingWhenEmpty", "Lcom/obric/appstore/ui/menu/PopMenu;", "u", "Lcom/obric/appstore/ui/menu/PopMenu;", "popMenu", "Lcom/obric/appstore/base/k;", "", "f0", "()Lcom/obric/appstore/base/k;", "listVM", "Lra/c;", "h0", "()Lra/c;", "parent", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMyAppFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyAppFragment.kt\ncom/obric/appstore/buss/myapp/myapp/MyAppFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,200:1\n106#2,15:201\n*S KotlinDebug\n*F\n+ 1 MyAppFragment.kt\ncom/obric/appstore/buss/myapp/myapp/MyAppFragment\n*L\n47#1:201,15\n*E\n"})
public final class MyAppFragment extends BaseListFragment<b> implements AppCallback {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f10699o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f10700p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f10701q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final MyAppUIAdapter f10702r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final c f10703s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f10704t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final PopMenu f10705u;

    public static final class a extends com.obric.appstore.util.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MyAppFragment f10706b;

        public a(MyAppFragment r10) {
            this.f10706b = r10;
        }

        @Override // com.obric.appstore.util.b
        public /* bridge */ /* synthetic */ void a(Object r10) {
            b((Integer) r10);
        }

        public void b(Integer r10) {
            ra.c r11 = MyAppFragment.b0(this.f10706b);
            if (r11 != null) goto L5;
        L7:
            RecyclerView r12 = this.f10706b.Y();
            if (r12 == null) goto L11;
            r12.scrollToPosition(0);
            return;
        L11:
            return;
        L5:
            if (r11.H() != f.f9823a.a()) goto L7;
        }
    }

    /* JADX INFO: renamed from: com.obric.appstore.buss.myapp.myapp.MyAppFragment$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "position", "Landroid/view/View;", "view", "Lcom/obric/appstore/buss/myapp/myapp/b;", "appInfo", "", "invoke", "(ILandroid/view/View;Lcom/obric/appstore/buss/myapp/myapp/b;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @SourceDebugExtension({"SMAP\nMyAppFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyAppFragment.kt\ncom/obric/appstore/buss/myapp/myapp/MyAppFragment$onCreate$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,200:1\n1#2:201\n*E\n"})
    public static final class AnonymousClass1 extends Lambda implements Function3<Integer, View, b, Unit> {
        final /* synthetic */ MyAppFragment this$0;

        public AnonymousClass1(MyAppFragment r10) {
            this.this$0 = r10;
            super(3);
        }

        public static /* synthetic */ boolean a(MyAppFragment r10, b r11, View r12, View r13) {
            return invoke$lambda$2(r10, r11, r12, r13);
        }

        private static final boolean invoke$lambda$2(final MyAppFragment r10, final b r11, View r12, View r13) {
            q.g(r10, "this$0");
            q.g(r11, "$appInfo");
            q.g(r12, "$view");
            int r14 = R.drawable.oui_icon_cancel_dl;
            String r15 = r10.getString(R.string.menu_action_title_cancel_download);
            q.f(r15, "getString(...)");
            List r16 = s.e(new com.obric.appstore.ui.menu.b(0, r14, r15));
            MyAppFragment.c0(r10).f(r11.getAppInfo(), r12, null, r16, new MyAppFragment$onCreate$1$2$1(r10, r11));
            return true;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Integer r10, View r11, b r12) {
            invoke(r10.intValue(), r11, r12);
            return Unit.f21064a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void invoke(int r10, @NotNull final View r11, @NotNull final b r12) {
            q.g(r11, "view");
            q.g(r12, "appInfo");
            if ((r11 instanceof IOUIAlpha) == false) goto L5;
            IOUIAlpha r13 = (IOUIAlpha) r11;
        L7:
            if (r13 == null) goto L9;
            r13.setChangeAlphaWhenSelected(true);
        L9:
            int r14 = r10 + 1;
            bg.c r15 = new bg.c(r14, this.this$0.d0().getData().size() - 1);
            MyAppFragment r16 = this.this$0;
            Iterator r17 = r15.iterator();
        L11:
            if (r17.hasNext() == false) goto L15;
            Object r18 = r17.next();
            if (r16.d0().getItemViewType(((Number) r18).intValue()) != ItemType.APP.ordinal()) goto L11;
        L17:
            if (r18 != null) goto L19;
            boolean r19 = true;
        L21:
            if (r14 >= (this.this$0.d0().getData().size() - 1)) goto L28;
            if (r19 == false) goto L24;
        L27:
            r19 = true;
            goto L28
        L24:
            if (this.this$0.d0().getItemViewType(r14) == ItemType.TITLE.ordinal()) goto L27;
            r19 = false;
        L28:
            if (r19 == false) goto L30;
            ((ObricAppItemView) r11).showLine(false);
        L30:
            r11.setSelected(false);
            if (r12.a() != 1) goto L34;
            r11.setOnLongClickListener(null);
            return;
        L34:
            final MyAppFragment r20 = this.this$0;
            r11.setOnLongClickListener(new com.obric.appstore.buss.myapp.myapp.a(r20, r12, r11));
            return;
        L19:
            r19 = false;
            goto L21
        L15:
            r18 = null;
            goto L17
        L5:
            r13 = null;
            goto L7
        }
    }

    /* JADX INFO: renamed from: com.obric.appstore.buss.myapp.myapp.MyAppFragment$onViewCreated$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appstore.buss.myapp.myapp.MyAppFragment$onViewCreated$3", f = "MyAppFragment.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nMyAppFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyAppFragment.kt\ncom/obric/appstore/buss/myapp/myapp/MyAppFragment$onViewCreated$3\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,200:1\n53#2:201\n55#2:205\n50#3:202\n55#3:204\n106#4:203\n*S KotlinDebug\n*F\n+ 1 MyAppFragment.kt\ncom/obric/appstore/buss/myapp/myapp/MyAppFragment$onViewCreated$3\n*L\n140#1:201\n140#1:205\n140#1:202\n140#1:204\n140#1:203\n*E\n"})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MyAppFragment this$0;

        /* JADX INFO: renamed from: com.obric.appstore.buss.myapp.myapp.MyAppFragment$onViewCreated$3$a */
        public static final class a implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MyAppFragment f10707a;

            public a(MyAppFragment r10) {
                this.f10707a = r10;
            }

            public final Object a(SortedSet r10, Continuation r11) {
                this.f10707a.onAppUpdate();
                return Unit.f21064a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object r10, Continuation r11) {
                return a((SortedSet) r10, r11);
            }
        }

        public AnonymousClass3(MyAppFragment r10, Continuation<? super AnonymousClass3> r11) {
            this.this$0 = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new AnonymousClass3(this.this$0, r11);
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
            final StateFlow r13 = AppInstallActor.f17891n.b().S();
            Flow r14 = kotlinx.coroutines.flow.c.D(kotlinx.coroutines.flow.c.o(new MyAppFragment$onViewCreated$3$invokeSuspend$$inlined$map$1(r13), AnonymousClass2.INSTANCE), l0.b());
            a r15 = new a(this.this$0);
            this.label = 1;
            if (r14.collect(r15, this) != r11) goto L12;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass3) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public MyAppFragment() {
        this.f10700p = true;
        final Function0<Fragment> r10 = new MyAppFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r11 = kotlin.b.a(LazyThreadSafetyMode.NONE, new MyAppFragment$special$$inlined$viewModels$default$2(r10));
        final Function0 r12 = null;
        this.f10701q = FragmentViewModelLazyKt.c(this, u.b(MyAppVM.class), new MyAppFragment$special$$inlined$viewModels$default$3(r11), new MyAppFragment$special$$inlined$viewModels$default$4(r12, r11), new MyAppFragment$special$$inlined$viewModels$default$5(this, r11));
        this.f10702r = new MyAppUIAdapter();
        this.f10703s = new c();
        this.f10705u = new PopMenu();
    }

    public static final /* synthetic */ MyAppVM a0(MyAppFragment r10) {
        return r10.g0();
    }

    public static final /* synthetic */ ra.c b0(MyAppFragment r10) {
        return r10.h0();
    }

    public static final /* synthetic */ PopMenu c0(MyAppFragment r10) {
        return r10.f10705u;
    }

    @Override // com.obric.appstore.base.BaseFragment
    public boolean H() {
        return this.f10704t;
    }

    @Override // com.obric.appstore.base.BaseFragment
    public void Q(OPageStatus r10) {
        q.g(r10, "empty");
        if (getView() == null) goto L6;
        r10.setTitle(getString(R.string.obric_empty_apps));
        return;
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public /* bridge */ /* synthetic */ BaseListAdapter U() {
        return d0();
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public /* bridge */ /* synthetic */ DiffUtil.ItemCallback V() {
        return e0();
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public boolean W() {
        return this.f10700p;
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public /* bridge */ /* synthetic */ ILoadViewModel X() {
        return f0();
    }

    public MyAppUIAdapter d0() {
        return this.f10702r;
    }

    public c e0() {
        return this.f10703s;
    }

    public k f0() {
        return g0();
    }

    public final MyAppVM g0() {
        return (MyAppVM) this.f10701q.getValue();
    }

    public final ra.c h0() {
        Fragment r10 = getParentFragment();
        if ((r10 instanceof ra.c) == true) goto L7;
        return null;
    L7:
        return (ra.c) r10;
    }

    @Override // com.obric.appstore.buss.apps.AppCallback
    public void onAppUpdate() {
        if (this.f10705u.d() == false) goto L15;
        AppInfo r10 = (AppInfo) this.f10705u.c();
        AppsManager r11 = AppsManager.f10585a;
        if (r10 == null) goto L7;
        String r12 = r10.appPackageName;
    L8:
        if (r12 != null) goto L10;
        r12 = "";
    L10:
        AppInfo r13 = r11.d(r12);
        if (r13 == null) goto L15;
        if (r13.downloadStatus != 8) goto L15;
        this.f10705u.b();
        goto L15
    L7:
        r12 = null;
    L15:
        ILoadViewModel.s(g0(), true, false, 2, null);
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onCreate(Bundle r13) {
        super.onCreate(r13);
        MyAppUIAdapter r14 = d0();
        String r10 = getPageSource();
        int r11 = o.a();
        r14.addItemProvider(new ItemAppProvider(r10, false, false, new AnonymousClass1(this), Integer.valueOf(r11), false, false, 0.0f, 160, null));
        d0().addItemProvider(new ItemTitleProvider());
        ILoadViewModel.s(g0(), true, false, 2, null);
        AppsManager.f10585a.j(this);
    }

    @Override // com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AppsManager.f10585a.l(this);
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        q.g(r10, "view");
        super.onViewCreated(r10, r11);
        com.obric.appstore.util.s r12 = J();
        if (r12 == null) goto L9;
        sa.c r13 = r12.k();
        if (r13 == null) goto L9;
        ViewStub r14 = r13.f24568b;
        if (r14 == null) goto L9;
        r14.setLayoutResource(R.layout.common_state_empty_view_medium);
    L9:
        g0().z().i(getViewLifecycleOwner(), new a(this));
        LifecycleOwner r15 = getViewLifecycleOwner();
        q.f(r15, "getViewLifecycleOwner(...)");
        h.d(androidx.lifecycle.s.a(r15), null, null, new AnonymousClass3(this, null), 3, null);
        final RecyclerView r16 = Y();
        if (r16 == null) goto L13;
        ActivityUtilKt.b(r16, new MyAppFragment$onViewCreated$4$1(r16));
        r16.setClipToPadding(false);
        r16.addItemDecoration(new d(o.c(), o.b(), o.c(), false, 0, o.b()));
        return;
    }

    @Override // com.obric.appstore.base.e
    public int v() {
        return this.f10699o;
    }
}
