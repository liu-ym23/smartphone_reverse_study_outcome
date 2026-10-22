package com.stepos.ailauncher.agent.skill.essential;

import La.H;
import Ua.C1060i;
import Ua.M;
import Y4.C1126j;
import Y8.t;
import android.os.Bundle;
import android.view.C1398p;
import android.view.LayoutInflater;
import android.view.Lifecycle;
import android.view.RepeatOnLifecycleKt;
import android.view.U;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.core.view.A;
import androidx.core.view.N;
import androidx.core.view.Y;
import androidx.core.view.a0;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import c5.SkillCardCallbacks;
import c5.w;
import c5.x;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.aispace.E;
import com.stepos.ailauncher.agent.analytics.SkillAnalytics;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.adapter.DisplayScope;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.chat.wake.circle.F;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0003R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R&\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00100'0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/essential/SkillEssentialActivity;", "Lz5/a;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "Lcom/stepos/ailauncher/agent/skill/essential/k;", VoiceWakeupReceiver.EXTRA_STATE, "Q", "(Lcom/stepos/ailauncher/agent/skill/essential/k;)V", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "item", "Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/stepos/ailauncher/agent/skill/SkillItem;)Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;", ExifInterface.LATITUDE_SOUTH, "LY4/j;", "binding", "LY4/j;", "Lcom/stepos/ailauncher/agent/skill/essential/SkillEssentialViewModel;", "viewModel", "Lcom/stepos/ailauncher/agent/skill/essential/SkillEssentialViewModel;", "Lc5/w;", "adapter", "Lc5/w;", "Ld5/e;", "jumpHelper$delegate", "LY8/h;", "G", "()Ld5/e;", "jumpHelper", "", "isTesting", "Z", "", "Lkotlin/Pair;", "", "exposedKeys", "Ljava/util/Set;", "Companion", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SkillEssentialActivity extends ActivityC6361a {
    public static final String EXTRA_NECESSARY = "extra.necessary";
    public static final String EXTRA_SHOW_CLI = "extra.show_cli";
    public static final String EXTRA_TESTING = "extra.testing";
    public static final String EXTRA_TITLE = "extra.title";
    private w adapter;
    private C1126j binding;
    private boolean isTesting;
    private SkillEssentialViewModel viewModel;

    /* renamed from: jumpHelper$delegate, reason: from kotlin metadata */
    private final Y8.h jumpHelper = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.essential.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return SkillEssentialActivity.H();
        }
    });
    private final Set<Pair<String, DisplayScope>> exposedKeys = new LinkedHashSet();

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/ailauncher/agent/skill/essential/SkillEssentialActivity$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "", "dx", "dy", "LY8/t;", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView rv, int dx, int dy) {
            p.i(rv, "rv");
            super.onScrolled(rv, dx, dy);
            RecyclerView.LayoutManager layoutManager = rv.getLayoutManager();
            p.g(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int iFindLastCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
            w wVar = SkillEssentialActivity.this.adapter;
            SkillEssentialViewModel skillEssentialViewModel = null;
            if (wVar == null) {
                p.A("adapter");
                wVar = null;
            }
            int itemCount = wVar.getItemCount();
            if (iFindLastCompletelyVisibleItemPosition >= itemCount - 2 && itemCount > 0) {
                SkillEssentialViewModel skillEssentialViewModel2 = SkillEssentialActivity.this.viewModel;
                if (skillEssentialViewModel2 == null) {
                    p.A("viewModel");
                } else {
                    skillEssentialViewModel = skillEssentialViewModel2;
                }
                skillEssentialViewModel.K();
            }
            SkillEssentialActivity.this.S();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.essential.SkillEssentialActivity$onCreate$12", f = "SkillEssentialActivity.kt", l = {F.LOOP_END_FRAME}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.skill.essential.SkillEssentialActivity$onCreate$12, reason: invalid class name */
    public static final class AnonymousClass12 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
        int label;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.essential.SkillEssentialActivity$onCreate$12$1", f = "SkillEssentialActivity.kt", l = {161}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.agent.skill.essential.SkillEssentialActivity$onCreate$12$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
            int label;
            final /* synthetic */ SkillEssentialActivity this$0;

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ailauncher.agent.skill.essential.SkillEssentialActivity$onCreate$12$1$a */
            public static final class a<T> implements Xa.c {
                final /* synthetic */ SkillEssentialActivity this$0;

                public a(SkillEssentialActivity skillEssentialActivity) {
                    this.this$0 = skillEssentialActivity;
                }

                @Override // Xa.c
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object emit(SkillEssentialUiState skillEssentialUiState, InterfaceC4014c<? super t> interfaceC4014c) {
                    this.this$0.Q(skillEssentialUiState);
                    return t.f7040a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SkillEssentialActivity skillEssentialActivity, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.this$0 = skillEssentialActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new AnonymousClass1(this.this$0, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
                return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objG = C4063a.g();
                int i10 = this.label;
                if (i10 == 0) {
                    C4849c.b(obj);
                    SkillEssentialViewModel skillEssentialViewModel = this.this$0.viewModel;
                    if (skillEssentialViewModel == null) {
                        p.A("viewModel");
                        skillEssentialViewModel = null;
                    }
                    Xa.t<SkillEssentialUiState> tVarH = skillEssentialViewModel.H();
                    a aVar = new a(this.this$0);
                    this.label = 1;
                    if (tVarH.collect(aVar, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        public AnonymousClass12(InterfaceC4014c<? super AnonymousClass12> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return SkillEssentialActivity.this.new AnonymousClass12(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass12) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                SkillEssentialActivity skillEssentialActivity = SkillEssentialActivity.this;
                Lifecycle.State state = Lifecycle.State.STARTED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(skillEssentialActivity, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.b(skillEssentialActivity, state, anonymousClass1, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return t.f7040a;
        }
    }

    public static final d5.e H() {
        return new d5.e();
    }

    public static final a0 I(SkillEssentialActivity skillEssentialActivity, View view, a0 insets) {
        p.i(view, "<unused var>");
        p.i(insets, "insets");
        t0.e eVarF = insets.f(a0.o.g());
        p.h(eVarF, "getInsets(...)");
        C1126j c1126j = skillEssentialActivity.binding;
        C1126j c1126j2 = null;
        if (c1126j == null) {
            p.A("binding");
            c1126j = null;
        }
        LinearLayout toolbarContainer = c1126j.toolbarContainer;
        p.h(toolbarContainer, "toolbarContainer");
        toolbarContainer.setPadding(toolbarContainer.getPaddingLeft(), eVarF.f41978b, toolbarContainer.getPaddingRight(), toolbarContainer.getPaddingBottom());
        int i10 = (int) (16 * skillEssentialActivity.getResources().getDisplayMetrics().density);
        C1126j c1126j3 = skillEssentialActivity.binding;
        if (c1126j3 == null) {
            p.A("binding");
        } else {
            c1126j2 = c1126j3;
        }
        RecyclerView rvSkills = c1126j2.rvSkills;
        p.h(rvSkills, "rvSkills");
        rvSkills.setPadding(rvSkills.getPaddingLeft(), rvSkills.getPaddingTop(), rvSkills.getPaddingRight(), i10 + eVarF.f41980d);
        return insets;
    }

    public static final t J(SkillEssentialActivity skillEssentialActivity, SkillItem item) {
        p.i(item, "item");
        DisplayScope displayScopeT = skillEssentialActivity.T(item);
        if (displayScopeT == null) {
            displayScopeT = DisplayScope.ESSENTIAL_SUBPAGE;
        }
        SkillAnalytics.INSTANCE.c(item, displayScopeT, SkillAnalytics.ClickTarget.CARD);
        skillEssentialActivity.G().a(skillEssentialActivity, item, skillEssentialActivity.isTesting, displayScopeT);
        return t.f7040a;
    }

    public static final t K(SkillEssentialActivity skillEssentialActivity, SkillItem item) {
        p.i(item, "item");
        DisplayScope displayScopeT = skillEssentialActivity.T(item);
        if (displayScopeT == null) {
            displayScopeT = DisplayScope.ESSENTIAL_SUBPAGE;
        }
        SkillAnalytics skillAnalytics = SkillAnalytics.INSTANCE;
        skillAnalytics.t(item, displayScopeT);
        skillAnalytics.c(item, displayScopeT, SkillAnalytics.ClickTarget.INSTALL_BUTTON);
        SkillEssentialViewModel skillEssentialViewModel = skillEssentialActivity.viewModel;
        if (skillEssentialViewModel == null) {
            p.A("viewModel");
            skillEssentialViewModel = null;
        }
        skillEssentialViewModel.Q(item);
        return t.f7040a;
    }

    public static final t L(SkillEssentialActivity skillEssentialActivity, SkillItem it) {
        p.i(it, "it");
        SkillEssentialViewModel skillEssentialViewModel = skillEssentialActivity.viewModel;
        if (skillEssentialViewModel == null) {
            p.A("viewModel");
            skillEssentialViewModel = null;
        }
        skillEssentialViewModel.P(it);
        return t.f7040a;
    }

    public static final t M(SkillEssentialActivity skillEssentialActivity, SkillItem item) {
        p.i(item, "item");
        DisplayScope displayScopeT = skillEssentialActivity.T(item);
        if (displayScopeT == null) {
            displayScopeT = DisplayScope.ESSENTIAL_SUBPAGE;
        }
        SkillAnalytics skillAnalytics = SkillAnalytics.INSTANCE;
        skillAnalytics.t(item, displayScopeT);
        skillAnalytics.c(item, displayScopeT, SkillAnalytics.ClickTarget.INSTALL_BUTTON);
        SkillEssentialViewModel skillEssentialViewModel = skillEssentialActivity.viewModel;
        if (skillEssentialViewModel == null) {
            p.A("viewModel");
            skillEssentialViewModel = null;
        }
        skillEssentialViewModel.R(item);
        return t.f7040a;
    }

    public static final t N(SkillEssentialActivity skillEssentialActivity, SkillItem item, boolean z10) {
        p.i(item, "item");
        DisplayScope displayScopeT = skillEssentialActivity.T(item);
        if (displayScopeT == null) {
            displayScopeT = DisplayScope.ESSENTIAL_SUBPAGE;
        }
        SkillAnalytics.INSTANCE.u(item, displayScopeT);
        SkillEssentialViewModel skillEssentialViewModel = skillEssentialActivity.viewModel;
        if (skillEssentialViewModel == null) {
            p.A("viewModel");
            skillEssentialViewModel = null;
        }
        skillEssentialViewModel.S(item, z10);
        return t.f7040a;
    }

    public static final void O(SkillEssentialActivity skillEssentialActivity, View view) {
        skillEssentialActivity.finish();
    }

    public static final void P(SkillEssentialActivity skillEssentialActivity) {
        SkillEssentialViewModel skillEssentialViewModel = skillEssentialActivity.viewModel;
        if (skillEssentialViewModel == null) {
            p.A("viewModel");
            skillEssentialViewModel = null;
        }
        skillEssentialViewModel.N();
    }

    public static final void R(SkillEssentialActivity skillEssentialActivity) {
        skillEssentialActivity.S();
    }

    public final d5.e G() {
        return (d5.e) this.jumpHelper.getValue();
    }

    public final void Q(SkillEssentialUiState state) {
        C1126j c1126j = this.binding;
        SkillEssentialViewModel skillEssentialViewModel = null;
        if (c1126j == null) {
            p.A("binding");
            c1126j = null;
        }
        c1126j.swipeRefresh.setRefreshing(state.getIsRefreshing());
        List<x> listT0 = state.getIsLoadingMore() ? Z8.F.T0(state.c(), x.d.INSTANCE) : state.c();
        w wVar = this.adapter;
        if (wVar == null) {
            p.A("adapter");
            wVar = null;
        }
        wVar.submitList(listT0, new Runnable() { // from class: com.stepos.ailauncher.agent.skill.essential.j
            @Override // java.lang.Runnable
            public final void run() {
                SkillEssentialActivity.R(this.f24421a);
            }
        });
        String transientToastMessage = state.getTransientToastMessage();
        if (transientToastMessage != null) {
            Toast.makeText(this, transientToastMessage, 0).show();
            SkillEssentialViewModel skillEssentialViewModel2 = this.viewModel;
            if (skillEssentialViewModel2 == null) {
                p.A("viewModel");
            } else {
                skillEssentialViewModel = skillEssentialViewModel2;
            }
            skillEssentialViewModel.D();
        }
    }

    public final void S() {
        Object objB;
        w wVar;
        LinearLayoutManager linearLayoutManager;
        DisplayScope displayScope;
        try {
            Result.Companion companion = Result.INSTANCE;
            C1126j c1126j = this.binding;
            wVar = null;
            if (c1126j == null) {
                p.A("binding");
                c1126j = null;
            }
            RecyclerView.LayoutManager layoutManager = c1126j.rvSkills.getLayoutManager();
            linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (linearLayoutManager == null) {
            return;
        }
        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (iFindFirstVisibleItemPosition >= 0 && iFindLastVisibleItemPosition >= 0) {
            w wVar2 = this.adapter;
            if (wVar2 == null) {
                p.A("adapter");
            } else {
                wVar = wVar2;
            }
            List<x> currentList = wVar.getCurrentList();
            p.h(currentList, "getCurrentList(...)");
            if (iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition) {
                while (true) {
                    if (iFindFirstVisibleItemPosition >= 0 && iFindFirstVisibleItemPosition < currentList.size()) {
                        x xVar = currentList.get(iFindFirstVisibleItemPosition);
                        if (xVar instanceof x.SkillCard) {
                            DisplayScope displayScope2 = ((x.SkillCard) xVar).getDisplayScope();
                            if (displayScope2 != null && this.exposedKeys.add(Y8.j.a(((x.SkillCard) xVar).getItem().getIdentifier(), displayScope2))) {
                                SkillAnalytics.INSTANCE.d(((x.SkillCard) xVar).getItem(), displayScope2);
                            }
                        } else if ((xVar instanceof x.CliCard) && (displayScope = ((x.CliCard) xVar).getDisplayScope()) != null && this.exposedKeys.add(Y8.j.a(((x.CliCard) xVar).getItem().getIdentifier(), displayScope))) {
                            SkillAnalytics.INSTANCE.d(((x.CliCard) xVar).getItem(), displayScope);
                        }
                    }
                    if (iFindFirstVisibleItemPosition == iFindLastVisibleItemPosition) {
                        break;
                    } else {
                        iFindFirstVisibleItemPosition++;
                    }
                }
            }
            objB = Result.b(t.f7040a);
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t("SkillEssentialAct", "reportVisibleExposure failed", thE, false, 8, null);
            }
        }
    }

    public final DisplayScope T(SkillItem item) {
        w wVar = this.adapter;
        if (wVar == null) {
            p.A("adapter");
            wVar = null;
        }
        List<x> currentList = wVar.getCurrentList();
        p.h(currentList, "getCurrentList(...)");
        for (x xVar : currentList) {
            if (xVar instanceof x.SkillCard) {
                x.SkillCard skillCard = (x.SkillCard) xVar;
                if (p.d(skillCard.getItem().getIdentifier(), item.getIdentifier())) {
                    return skillCard.getDisplayScope();
                }
            } else if (xVar instanceof x.CliCard) {
                x.CliCard cliCard = (x.CliCard) xVar;
                if (p.d(cliCard.getItem().getIdentifier(), item.getIdentifier())) {
                    return cliCard.getDisplayScope();
                }
            } else {
                continue;
            }
        }
        return null;
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C1126j c1126jC = C1126j.c(LayoutInflater.from(this), null, false);
        p.h(c1126jC, "inflate(...)");
        this.binding = c1126jC;
        if (c1126jC == null) {
            p.A("binding");
            c1126jC = null;
        }
        setContentView(c1126jC.b());
        Y.b(getWindow(), false);
        C1126j c1126j = this.binding;
        if (c1126j == null) {
            p.A("binding");
            c1126j = null;
        }
        N.u0(c1126j.b(), new A() { // from class: com.stepos.ailauncher.agent.skill.essential.b
            @Override // androidx.core.view.A
            public final a0 a(View view, a0 a0Var) {
                return SkillEssentialActivity.I(this.f24413a, view, a0Var);
            }
        });
        int intExtra = getIntent().getIntExtra(EXTRA_NECESSARY, 1);
        boolean booleanExtra = getIntent().getBooleanExtra(EXTRA_SHOW_CLI, true);
        this.isTesting = getIntent().getBooleanExtra(EXTRA_TESTING, false);
        String stringExtra = getIntent().getStringExtra(EXTRA_TITLE);
        if (stringExtra != null) {
            if (H.x0(stringExtra)) {
                stringExtra = null;
            }
            if (stringExtra != null) {
                C1126j c1126j2 = this.binding;
                if (c1126j2 == null) {
                    p.A("binding");
                    c1126j2 = null;
                }
                c1126j2.tvTitle.setText(stringExtra);
            }
        }
        if (intExtra == 1 && !this.isTesting) {
            SkillAnalytics.INSTANCE.h();
        }
        SkillEssentialViewModel skillEssentialViewModel = (SkillEssentialViewModel) new U(this).a(SkillEssentialViewModel.class);
        this.viewModel = skillEssentialViewModel;
        if (skillEssentialViewModel == null) {
            p.A("viewModel");
            skillEssentialViewModel = null;
        }
        skillEssentialViewModel.C(intExtra, booleanExtra, this.isTesting);
        this.adapter = new w(new SkillCardCallbacks(new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.essential.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SkillEssentialActivity.J(this.f24414a, (SkillItem) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.essential.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SkillEssentialActivity.K(this.f24415a, (SkillItem) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.essential.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SkillEssentialActivity.L(this.f24416a, (SkillItem) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.essential.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SkillEssentialActivity.M(this.f24417a, (SkillItem) obj);
            }
        }, new p9.p() { // from class: com.stepos.ailauncher.agent.skill.essential.g
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return SkillEssentialActivity.N(this.f24418a, (SkillItem) obj, ((Boolean) obj2).booleanValue());
            }
        }, null, null, 96, null));
        C1126j c1126j3 = this.binding;
        if (c1126j3 == null) {
            p.A("binding");
            c1126j3 = null;
        }
        c1126j3.rvSkills.setLayoutManager(new LinearLayoutManager(this));
        C1126j c1126j4 = this.binding;
        if (c1126j4 == null) {
            p.A("binding");
            c1126j4 = null;
        }
        RecyclerView recyclerView = c1126j4.rvSkills;
        w wVar = this.adapter;
        if (wVar == null) {
            p.A("adapter");
            wVar = null;
        }
        recyclerView.setAdapter(wVar);
        C1126j c1126j5 = this.binding;
        if (c1126j5 == null) {
            p.A("binding");
            c1126j5 = null;
        }
        c1126j5.rvSkills.setItemAnimator(null);
        C1126j c1126j6 = this.binding;
        if (c1126j6 == null) {
            p.A("binding");
            c1126j6 = null;
        }
        c1126j6.rvSkills.addItemDecoration(new E(this, null, 2, null));
        C1126j c1126j7 = this.binding;
        if (c1126j7 == null) {
            p.A("binding");
            c1126j7 = null;
        }
        c1126j7.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.essential.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SkillEssentialActivity.O(this.f24419a, view);
            }
        });
        C1126j c1126j8 = this.binding;
        if (c1126j8 == null) {
            p.A("binding");
            c1126j8 = null;
        }
        SwipeRefreshLayout swipeRefreshLayout = c1126j8.swipeRefresh;
        b5.m mVar = b5.m.INSTANCE;
        C1126j c1126j9 = this.binding;
        if (c1126j9 == null) {
            p.A("binding");
            c1126j9 = null;
        }
        SwipeRefreshLayout swipeRefresh = c1126j9.swipeRefresh;
        p.h(swipeRefresh, "swipeRefresh");
        swipeRefreshLayout.setColorSchemeColors(mVar.h(swipeRefresh));
        C1126j c1126j10 = this.binding;
        if (c1126j10 == null) {
            p.A("binding");
            c1126j10 = null;
        }
        c1126j10.swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.stepos.ailauncher.agent.skill.essential.i
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void a() {
                SkillEssentialActivity.P(this.f24420a);
            }
        });
        C1126j c1126j11 = this.binding;
        if (c1126j11 == null) {
            p.A("binding");
            c1126j11 = null;
        }
        c1126j11.rvSkills.addOnScrollListener(new b());
        SkillEssentialViewModel skillEssentialViewModel2 = this.viewModel;
        if (skillEssentialViewModel2 == null) {
            p.A("viewModel");
            skillEssentialViewModel2 = null;
        }
        skillEssentialViewModel2.I();
        String str = "skillEssential_" + hashCode();
        SkillEssentialViewModel skillEssentialViewModel3 = this.viewModel;
        if (skillEssentialViewModel3 == null) {
            p.A("viewModel");
            skillEssentialViewModel3 = null;
        }
        skillEssentialViewModel3.T(str);
        C1060i.d(C1398p.a(this), null, null, new AnonymousClass12(null), 3, null);
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SkillEssentialViewModel skillEssentialViewModel = this.viewModel;
        C1126j c1126j = null;
        if (skillEssentialViewModel == null) {
            p.A("viewModel");
            skillEssentialViewModel = null;
        }
        skillEssentialViewModel.U("skillEssential_" + hashCode());
        this.exposedKeys.clear();
        C1126j c1126j2 = this.binding;
        if (c1126j2 == null) {
            p.A("binding");
        } else {
            c1126j = c1126j2;
        }
        c1126j.b();
    }
}
