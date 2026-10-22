package com.bytedanceos.appstore.buss.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.appstore.buss.adapter.BinderAdapter;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.entity.AppSubEntity;
import com.bytedanceos.appstore.buss.entity.AppSubWrap;
import com.bytedanceos.appstore.buss.entity.netwrap.AppGameSubWrap;
import com.bytedanceos.appstore.buss.viewmodels.GameSubscribeViewModel;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.bytedanceos.common.ui.widget.guide.NewbieGuide;
import com.bytedanceos.common.ui.widget.guide.model.GuidePage;
import com.bytedanceos.common.ui.widget.guide.model.HighlightOptions;
import com.bytedanceos.common.ui.widget.guide.model.RelativeGuide;
import com.obric.appstore.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 92\u00020\u00012\u00020\u0002:\u0001:B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\t\u0010\u0004J#\u0010\u000e\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0004R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082D¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00105\u001a\u00020'8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u001c\u00108\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u00107¨\u0006;"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/GameSubscribeFragment;", "Lh7/c;", "Ljava/util/Observer;", "<init>", "()V", "", "E", "initData", "F", "t", "Ljava/util/Observable;", "o", "", "arg", "update", "(Ljava/util/Observable;Ljava/lang/Object;)V", "onResume", "onPause", "onDestroyView", "showGuideView", "", "f", "Lkotlin/Lazy;", "getPageSource", "()Ljava/lang/String;", "pageSource", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "g", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "adapter", "Ld7/m;", "h", "Ld7/m;", "pagerSubVideoBinder", "Lcom/bytedanceos/appstore/buss/viewmodels/GameSubscribeViewModel;", "i", "M", "()Lcom/bytedanceos/appstore/buss/viewmodels/GameSubscribeViewModel;", NetKey.MODEL, "", "j", "I", "MSG_SHOW_GUIDE_VIEW", "Landroid/os/Handler;", "k", "Landroid/os/Handler;", "mHandler", "Lx7/d;", "L", "()Lx7/d;", "commonRecyclerViewBinding", "n", "()I", "layoutId", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "l", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGameSubscribeFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GameSubscribeFragment.kt\ncom/bytedanceos/appstore/buss/fragment/GameSubscribeFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 BaseBinderAdapter.kt\ncom/chad/library/adapter/base/BaseBinderAdapter\n+ 4 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,195:1\n106#2,15:196\n57#3,3:211\n57#3,3:214\n57#3,3:217\n50#4,3:220\n53#4,6:230\n1864#5,3:223\n1864#5,3:226\n1#6:229\n*S KotlinDebug\n*F\n+ 1 GameSubscribeFragment.kt\ncom/bytedanceos/appstore/buss/fragment/GameSubscribeFragment\n*L\n66#1:196,15\n145#1:211,3\n149#1:214,3\n150#1:217,3\n103#1:220,3\n103#1:230,6\n122#1:223,3\n129#1:226,3\n*E\n"})
public final class GameSubscribeFragment extends h7.c implements Observer {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f8567l = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BinderAdapter f8569g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d7.m f8570h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f8571i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f8572j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Handler f8573k;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Fragment a(String r10) {
            GameSubscribeFragment r11 = new GameSubscribeFragment();
            r11.setArguments(androidx.core.os.c.a(new Pair[]{kotlin.d.a(NetKey.PAGE_SOURCE, r10)}));
            return r11;
        }

        public a() {
        }
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GameSubscribeFragment f8574a;

        public b(GameSubscribeFragment r10) {
            this.f8574a = r10;
        }

        public static /* synthetic */ void a(View r10) {
            b(r10);
        }

        public static final void b(View r10) {
            r10.callOnClick();
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            kotlin.jvm.internal.q.g(r10, "msg");
            if (r10.what == GameSubscribeFragment.J(this.f8574a)) goto L5;
            return;
        L5:
            if (this.f8574a.isAdded() == false) goto L14;
            RecyclerView.LayoutManager r11 = GameSubscribeFragment.I(this.f8574a).f25515b.getLayoutManager();
            if (r11 == null) goto L9;
            View r12 = r11.findViewByPosition(0);
        L10:
            if (r12 == null) goto L15;
            HighlightOptions r13 = new HighlightOptions.Builder().setRelativeGuide(new RelativeGuide(R.layout.game_sub_list_guide_horizontal, 80, 0)).setOnClickListener(new l0()).build();
            GuidePage r14 = GuidePage.newInstance().addHighLightWithOptions(r12, r13);
            NewbieGuide.with(this.f8574a.getActivity()).setLabel("relative").addGuidePage(r14).show();
            return;
        L15:
            return;
        L9:
            r12 = null;
            goto L10
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.appstore.buss.fragment.GameSubscribeFragment$update$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedanceos.appstore.buss.fragment.GameSubscribeFragment$update$1", f = "GameSubscribeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GameSubscribeFragment this$0;

        public AnonymousClass1(GameSubscribeFragment r10, Continuation<? super AnonymousClass1> r11) {
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
            kotlin.coroutines.intrinsics.a.d();
            if (this.label != 0) goto L10;
            kotlin.c.b(r10);
            BinderAdapter r11 = GameSubscribeFragment.H(this.this$0);
            if (r11 == null) goto L8;
            r11.notifyDataSetChanged();
        L8:
            return Unit.f21064a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    static {
        f8567l = new a(null);
    }

    public GameSubscribeFragment() {
        this.f8568f = kotlin.b.b(new GameSubscribeFragment$pageSource$2(this));
        Function0 r10 = GameSubscribeFragment$model$2.INSTANCE;
        final Function0<Fragment> r11 = new GameSubscribeFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r12 = kotlin.b.a(LazyThreadSafetyMode.NONE, new GameSubscribeFragment$special$$inlined$viewModels$default$2(r11));
        KClass r13 = kotlin.jvm.internal.u.b(GameSubscribeViewModel.class);
        Function0<ViewModelStore> r14 = new GameSubscribeFragment$special$$inlined$viewModels$default$3(r12);
        final Function0 r15 = null;
        Function0<CreationExtras> r16 = new GameSubscribeFragment$special$$inlined$viewModels$default$4(r15, r12);
        if (r10 != null) goto L5;
        r10 = new GameSubscribeFragment$special$$inlined$viewModels$default$5(this, r12);
    L5:
        this.f8571i = FragmentViewModelLazyKt.c(this, r13, r14, r16, r10);
        this.f8572j = 1;
        this.f8573k = new b(this);
    }

    public static /* synthetic */ void G(GameSubscribeFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        N(r10, r11);
    }

    public static final /* synthetic */ BinderAdapter H(GameSubscribeFragment r10) {
        return r10.f8569g;
    }

    public static final /* synthetic */ x7.d I(GameSubscribeFragment r10) {
        return r10.L();
    }

    public static final /* synthetic */ int J(GameSubscribeFragment r10) {
        return r10.f8572j;
    }

    public static final /* synthetic */ GameSubscribeViewModel K(GameSubscribeFragment r10) {
        return r10.M();
    }

    private final x7.d L() {
        x7.d r10 = x7.d.a(m().findViewById(R.id.recycler_view));
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public static final void N(GameSubscribeFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L6;
        r10.B();
        return;
    L6:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L55;
        AppGameSubWrap r12 = (AppGameSubWrap) ((com.bytedanceos.appstore.buss.network.h.c) r11).a();
        if (r12 != null) goto L10;
        h7.c.A(r10, null, null, 0, 7, null);
        return;
    L10:
        r10.r();
        ArrayList r13 = new ArrayList();
        List<AppSubEntity> r14 = r12.getTop_apps();
        if (r14 == null) goto L13;
        Integer r15 = Integer.valueOf(r14.size());
    L14:
        kotlin.jvm.internal.q.d(r15);
        int r16 = 0;
        int r17 = 1;
        if (r15.intValue() <= 0) goto L21;
        List<AppSubEntity> r18 = r12.getTop_apps();
        if (r18 == null) goto L21;
        AppSubEntity r19 = r18.get(0);
        if (r19 == null) goto L21;
        r13.add(r19);
        r19.setItemPosition("1-0");
        r17 = 2;
    L21:
        AppSubWrap r20 = r12.getGroup_apps();
        if (r20 == null) goto L34;
        r13.add(r20);
        AppSubWrap r21 = r12.getGroup_apps();
        if (r21 == null) goto L34;
        List<AppSubEntity> r22 = r21.getApps();
        if (r22 == null) goto L34;
        Iterator<T> r23 = r22.iterator();
        int r24 = 0;
    L29:
        if (r23.hasNext() == false) goto L34;
        Object r25 = r23.next();
        int r26 = r24 + 1;
        if (r24 >= 0) goto L33;
        kotlin.collections.t.q();
    L33:
        StringBuilder r27 = new StringBuilder();
        r27.append(r17);
        r27.append('-');
        r27.append(r24);
        ((AppSubEntity) r25).setItemPosition(r27.toString());
        r17 = r17 + 1;
        r24 = r26;
    L34:
        AppSubWrap r28 = r12.getOther_apps();
        if (r28 == null) goto L47;
        r13.add(r28);
        AppSubWrap r29 = r12.getOther_apps();
        if (r29 == null) goto L47;
        List<AppSubEntity> r30 = r29.getApps();
        if (r30 == null) goto L47;
        Iterator<T> r31 = r30.iterator();
    L42:
        if (r31.hasNext() == false) goto L47;
        Object r32 = r31.next();
        int r33 = r16 + 1;
        if (r16 >= 0) goto L46;
        kotlin.collections.t.q();
    L46:
        StringBuilder r34 = new StringBuilder();
        r34.append(r17);
        r34.append('-');
        r34.append(r16);
        ((AppSubEntity) r32).setItemPosition(r34.toString());
        r16 = r33;
    L47:
        AppEntityWrap r110 = r12.getHot_games();
        if (r110 == null) goto L50;
        r13.add(r110);
    L50:
        BinderAdapter r111 = r10.f8569g;
        if (r111 == null) goto L53;
        r111.setList(r13);
    L53:
        r10.showGuideView();
        return;
    L13:
        r15 = null;
        goto L14
    L55:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L67;
        com.bytedanceos.appstore.buss.network.h.a r112 = (com.bytedanceos.appstore.buss.network.h.a) r11;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r112.c());
        r10.D(r112);
        return;
    }

    private final String getPageSource() {
        return (String) this.f8568f.getValue();
    }

    @Override // h7.c
    public void E() {
        M().h().i(this, new k0(this));
    }

    @Override // h7.c
    public void F() {
        M().g();
    }

    public final GameSubscribeViewModel M() {
        return (GameSubscribeViewModel) this.f8571i.getValue();
    }

    @Override // h7.c
    public void initData() {
        h7.c.w(this, "游戏预约", false, false, 6, null);
        BaseApplication.c().b().addObserver(this);
        BinderAdapter r10 = new BinderAdapter();
        d7.l r11 = new d7.l();
        r11.b("page_game_subscribe");
        r10.addItemBinder(AppSubWrap.class, r11, null);
        d7.m r12 = new d7.m();
        this.f8570h = r12;
        kotlin.jvm.internal.q.d(r12);
        r10.addItemBinder(AppSubEntity.class, r12, null);
        r10.addItemBinder(AppEntityWrap.class, new d7.k(getPageSource()), null);
        this.f8569g = r10;
        L().f25515b.setLayoutManager(new LinearLayoutManager(l()));
        L().f25515b.setAdapter(this.f8569g);
        L().f25515b.setPageSource("page_game_subscribe");
        Bundle r13 = new Bundle();
        r13.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, getPageSource());
        f9.b.b("exposure_pages_main", r13);
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_game_sub;
    }

    @Override // h7.c
    public Function0 o() {
        return new GameSubscribeFragment$onRetryListener$1(this);
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        BaseApplication.c().b().deleteObserver(this);
        d7.m r10 = this.f8570h;
        if (r10 == null) goto L5;
        r10.b();
    L5:
        this.f8569g = null;
        this.f8573k.removeMessages(this.f8572j);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        d7.m r10 = this.f8570h;
        if (r10 == null) goto L6;
        r10.c();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        d7.m r10 = this.f8570h;
        if (r10 == null) goto L6;
        r10.d();
        return;
    }

    public final void showGuideView() {
        this.f8573k.sendEmptyMessageDelayed(this.f8572j, 300);
    }

    @Override // h7.c
    public void t() {
    }

    @Override // java.util.Observer
    public void update(Observable r10, Object r11) {
        kotlinx.coroutines.h.d(androidx.lifecycle.s.a(this), null, null, new AnonymousClass1(this, null), 3, null);
    }
}
