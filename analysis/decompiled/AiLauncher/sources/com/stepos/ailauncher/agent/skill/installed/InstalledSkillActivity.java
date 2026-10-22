package com.stepos.ailauncher.agent.skill.installed;

import Ua.C1060i;
import Ua.M;
import Y4.C1122f;
import android.R;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.C1398p;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Lifecycle;
import android.view.MotionEvent;
import android.view.RepeatOnLifecycleKt;
import android.view.U;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuCliRepository;
import com.stepos.ailauncher.agent.analytics.SkillAnalytics;
import com.stepos.ailauncher.agent.skill.InstallKind;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.adapter.DisplayScope;
import com.stepos.ailauncher.agent.skill.installed.adapter.InstalledRow;
import com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView;
import com.zyql.ai.selector.config.PictureConfig;
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
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000e\u0010\u0003J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010\u001dR\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R&\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020402018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109¨\u0006:"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installed/InstalledSkillActivity;", "Lz5/a;", "<init>", "()V", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "item", "LY8/t;", "c0", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;)V", "b0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "N", "Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel$b;", VoiceWakeupReceiver.EXTRA_STATE, "Y", "(Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel$b;)V", "Landroid/widget/TextView;", "pagingFooter", "Landroid/widget/TextView;", "canLoadNextPage", "Z", "LY4/f;", "binding", "LY4/f;", "Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel;", "viewModel", "Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel;", "Lcom/stepos/ailauncher/agent/skill/installed/adapter/b;", "adapter", "Lcom/stepos/ailauncher/agent/skill/installed/adapter/b;", "Ld5/e;", "jumpHelper$delegate", "LY8/h;", "M", "()Ld5/e;", "jumpHelper", "rootRevealed", "", "lastKeystrokeTsMs", "J", "", "Lkotlin/Pair;", "", "Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;", "exposedKeys", "Ljava/util/Set;", "Lcom/stepos/ailauncher/agent/skill/InstallKind;", "lastReportedTab", "Lcom/stepos/ailauncher/agent/skill/InstallKind;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InstalledSkillActivity extends ActivityC6361a {
    private com.stepos.ailauncher.agent.skill.installed.adapter.b adapter;
    private C1122f binding;
    private boolean canLoadNextPage;
    private long lastKeystrokeTsMs;
    private InstallKind lastReportedTab;
    private TextView pagingFooter;
    private boolean rootRevealed;
    private InstalledSkillViewModel viewModel;

    /* renamed from: jumpHelper$delegate, reason: from kotlin metadata */
    private final Y8.h jumpHelper = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.installed.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return InstalledSkillActivity.O();
        }
    });
    private final Set<Pair<String, DisplayScope>> exposedKeys = new LinkedHashSet();

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/ailauncher/agent/skill/installed/InstalledSkillActivity$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "", "dx", "dy", "LY8/t;", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView rv, int dx, int dy) {
            kotlin.jvm.internal.p.i(rv, "rv");
            RecyclerView.LayoutManager layoutManager = rv.getLayoutManager();
            kotlin.jvm.internal.p.g(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int iFindLastCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
            com.stepos.ailauncher.agent.skill.installed.adapter.b bVar = InstalledSkillActivity.this.adapter;
            InstalledSkillViewModel installedSkillViewModel = null;
            if (bVar == null) {
                kotlin.jvm.internal.p.A("adapter");
                bVar = null;
            }
            int itemCount = bVar.getItemCount();
            if (iFindLastCompletelyVisibleItemPosition >= itemCount - 2 && itemCount > 0 && InstalledSkillActivity.this.canLoadNextPage) {
                InstalledSkillViewModel installedSkillViewModel2 = InstalledSkillActivity.this.viewModel;
                if (installedSkillViewModel2 == null) {
                    kotlin.jvm.internal.p.A("viewModel");
                } else {
                    installedSkillViewModel = installedSkillViewModel2;
                }
                installedSkillViewModel.J();
            }
            InstalledSkillActivity.this.b0();
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/stepos/ailauncher/agent/skill/installed/InstalledSkillActivity$b", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "LY8/t;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
            InstalledSkillActivity.this.lastKeystrokeTsMs = System.currentTimeMillis();
            InstalledSkillViewModel installedSkillViewModel = InstalledSkillActivity.this.viewModel;
            C1122f c1122f = null;
            if (installedSkillViewModel == null) {
                kotlin.jvm.internal.p.A("viewModel");
                installedSkillViewModel = null;
            }
            String string = s10 != null ? s10.toString() : null;
            if (string == null) {
                string = "";
            }
            installedSkillViewModel.R(string);
            C1122f c1122f2 = InstalledSkillActivity.this.binding;
            if (c1122f2 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1122f = c1122f2;
            }
            ImageView ivClear = c1122f.ivClear;
            kotlin.jvm.internal.p.h(ivClear, "ivClear");
            ivClear.setVisibility(s10 != null && s10.length() > 0 ? 0 : 8);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.installed.InstalledSkillActivity$onCreate$12", f = "InstalledSkillActivity.kt", l = {158}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.skill.installed.InstalledSkillActivity$onCreate$12, reason: invalid class name */
    public static final class AnonymousClass12 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.installed.InstalledSkillActivity$onCreate$12$1", f = "InstalledSkillActivity.kt", l = {159}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.agent.skill.installed.InstalledSkillActivity$onCreate$12$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
            int label;
            final /* synthetic */ InstalledSkillActivity this$0;

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ailauncher.agent.skill.installed.InstalledSkillActivity$onCreate$12$1$a */
            public static final class a<T> implements Xa.c {
                final /* synthetic */ InstalledSkillActivity this$0;

                public a(InstalledSkillActivity installedSkillActivity) {
                    this.this$0 = installedSkillActivity;
                }

                @Override // Xa.c
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object emit(InstalledSkillViewModel.InstalledSkillUiState installedSkillUiState, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                    this.this$0.Y(installedSkillUiState);
                    return Y8.t.f7040a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(InstalledSkillActivity installedSkillActivity, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.this$0 = installedSkillActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new AnonymousClass1(this.this$0, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objG = C4063a.g();
                int i10 = this.label;
                if (i10 == 0) {
                    C4849c.b(obj);
                    InstalledSkillViewModel installedSkillViewModel = this.this$0.viewModel;
                    if (installedSkillViewModel == null) {
                        kotlin.jvm.internal.p.A("viewModel");
                        installedSkillViewModel = null;
                    }
                    Xa.t<InstalledSkillViewModel.InstalledSkillUiState> tVarI = installedSkillViewModel.I();
                    a aVar = new a(this.this$0);
                    this.label = 1;
                    if (tVarI.collect(aVar, this) == objG) {
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
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return InstalledSkillActivity.this.new AnonymousClass12(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass12) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                InstalledSkillActivity installedSkillActivity = InstalledSkillActivity.this;
                Lifecycle.State state = Lifecycle.State.STARTED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(installedSkillActivity, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.b(installedSkillActivity, state, anonymousClass1, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.installed.InstalledSkillActivity$onCreate$13", f = "InstalledSkillActivity.kt", l = {DidiCardView.FINISHED_SUMMARY_WIDTH_DP}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.skill.installed.InstalledSkillActivity$onCreate$13, reason: invalid class name */
    public static final class AnonymousClass13 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.installed.InstalledSkillActivity$onCreate$13$1", f = "InstalledSkillActivity.kt", l = {PictureConfig.PREVIEW_VIDEO_CODE}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.agent.skill.installed.InstalledSkillActivity$onCreate$13$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
            int label;
            final /* synthetic */ InstalledSkillActivity this$0;

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ailauncher.agent.skill.installed.InstalledSkillActivity$onCreate$13$1$a */
            public static final class a<T> implements Xa.c {
                final /* synthetic */ InstalledSkillActivity this$0;

                public a(InstalledSkillActivity installedSkillActivity) {
                    this.this$0 = installedSkillActivity;
                }

                @Override // Xa.c
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object emit(String str, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                    Toast.makeText(this.this$0, str, 0).show();
                    return Y8.t.f7040a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(InstalledSkillActivity installedSkillActivity, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.this$0 = installedSkillActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new AnonymousClass1(this.this$0, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objG = C4063a.g();
                int i10 = this.label;
                if (i10 == 0) {
                    C4849c.b(obj);
                    InstalledSkillViewModel installedSkillViewModel = this.this$0.viewModel;
                    if (installedSkillViewModel == null) {
                        kotlin.jvm.internal.p.A("viewModel");
                        installedSkillViewModel = null;
                    }
                    Xa.o<String> oVarG = installedSkillViewModel.G();
                    a aVar = new a(this.this$0);
                    this.label = 1;
                    if (oVarG.collect(aVar, this) == objG) {
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

        public AnonymousClass13(InterfaceC4014c<? super AnonymousClass13> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return InstalledSkillActivity.this.new AnonymousClass13(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass13) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                InstalledSkillActivity installedSkillActivity = InstalledSkillActivity.this;
                Lifecycle.State state = Lifecycle.State.STARTED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(installedSkillActivity, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.b(installedSkillActivity, state, anonymousClass1, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    private final d5.e M() {
        return (d5.e) this.jumpHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d5.e O() {
        return new d5.e();
    }

    public static final Y8.t P(InstalledSkillActivity installedSkillActivity, SkillItem item, boolean z10) {
        kotlin.jvm.internal.p.i(item, "item");
        InstalledSkillViewModel installedSkillViewModel = null;
        if (!kotlin.jvm.internal.p.d(item.getIdentifier(), "lark-cli")) {
            SkillAnalytics.INSTANCE.u(item, DisplayScope.INSTALLED);
            InstalledSkillViewModel installedSkillViewModel2 = installedSkillActivity.viewModel;
            if (installedSkillViewModel2 == null) {
                kotlin.jvm.internal.p.A("viewModel");
            } else {
                installedSkillViewModel = installedSkillViewModel2;
            }
            installedSkillViewModel.Q(item, z10);
        } else if (z10) {
            FeishuCliRepository.q(FeishuCliRepository.INSTANCE, null, 1, null);
        } else {
            FeishuCliRepository.o(FeishuCliRepository.INSTANCE, null, 1, null);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t Q(InstalledSkillActivity installedSkillActivity, SkillItem item) {
        kotlin.jvm.internal.p.i(item, "item");
        installedSkillActivity.c0(item);
        return Y8.t.f7040a;
    }

    public static final Y8.t R(InstalledSkillActivity installedSkillActivity, SkillItem item) {
        kotlin.jvm.internal.p.i(item, "item");
        SkillAnalytics skillAnalytics = SkillAnalytics.INSTANCE;
        DisplayScope displayScope = DisplayScope.INSTALLED;
        skillAnalytics.c(item, displayScope, SkillAnalytics.ClickTarget.CARD);
        d5.e.b(installedSkillActivity.M(), installedSkillActivity, item, false, displayScope, 4, null);
        return Y8.t.f7040a;
    }

    public static final void S(InstalledSkillActivity installedSkillActivity, View view) {
        InstalledSkillViewModel installedSkillViewModel = installedSkillActivity.viewModel;
        if (installedSkillViewModel == null) {
            kotlin.jvm.internal.p.A("viewModel");
            installedSkillViewModel = null;
        }
        installedSkillViewModel.J();
    }

    public static final void T(InstalledSkillActivity installedSkillActivity, View view) {
        installedSkillActivity.finish();
    }

    public static final boolean U(InstalledSkillActivity installedSkillActivity, TextView textView, int i10, KeyEvent keyEvent) {
        if (i10 != 3) {
            return false;
        }
        installedSkillActivity.N();
        C1122f c1122f = installedSkillActivity.binding;
        if (c1122f == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f = null;
        }
        c1122f.etSearch.clearFocus();
        return true;
    }

    public static final void V(InstalledSkillActivity installedSkillActivity, View view) {
        C1122f c1122f = installedSkillActivity.binding;
        if (c1122f == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f = null;
        }
        c1122f.etSearch.setText("");
    }

    public static final void W(InstalledSkillActivity installedSkillActivity, View view) {
        InstalledSkillViewModel installedSkillViewModel = installedSkillActivity.viewModel;
        if (installedSkillViewModel == null) {
            kotlin.jvm.internal.p.A("viewModel");
            installedSkillViewModel = null;
        }
        installedSkillViewModel.P(InstallKind.SKILL);
    }

    public static final void X(InstalledSkillActivity installedSkillActivity, View view) {
        InstalledSkillViewModel installedSkillViewModel = installedSkillActivity.viewModel;
        if (installedSkillViewModel == null) {
            kotlin.jvm.internal.p.A("viewModel");
            installedSkillViewModel = null;
        }
        installedSkillViewModel.P(InstallKind.CLI);
    }

    public static final void Z(final InstalledSkillActivity installedSkillActivity, InstalledSkillViewModel.InstalledSkillUiState installedSkillUiState, InstalledSkillViewModel.TabState tabState) {
        C1122f c1122f = null;
        if (installedSkillActivity.lastKeystrokeTsMs > 0) {
            C4148a.u("InstalledSkillAct", "search: adapter committed total_since_keystroke=" + (System.currentTimeMillis() - installedSkillActivity.lastKeystrokeTsMs) + "ms size=" + installedSkillUiState.i().size(), false, 4, null);
        }
        installedSkillActivity.b0();
        if (tabState.getLoadError() || tabState.getIsLoading() || tabState.getIsLoadingMore() || !tabState.getHasMore()) {
            return;
        }
        C1122f c1122f2 = installedSkillActivity.binding;
        if (c1122f2 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1122f = c1122f2;
        }
        c1122f.rvInstalled.post(new Runnable() { // from class: com.stepos.ailauncher.agent.skill.installed.d
            @Override // java.lang.Runnable
            public final void run() {
                InstalledSkillActivity.a0(this.f24445a);
            }
        });
    }

    public static final void a0(InstalledSkillActivity installedSkillActivity) {
        if (installedSkillActivity.isDestroyed() || !installedSkillActivity.canLoadNextPage) {
            return;
        }
        C1122f c1122f = installedSkillActivity.binding;
        InstalledSkillViewModel installedSkillViewModel = null;
        if (c1122f == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f = null;
        }
        if (c1122f.rvInstalled.canScrollVertically(1)) {
            return;
        }
        InstalledSkillViewModel installedSkillViewModel2 = installedSkillActivity.viewModel;
        if (installedSkillViewModel2 == null) {
            kotlin.jvm.internal.p.A("viewModel");
        } else {
            installedSkillViewModel = installedSkillViewModel2;
        }
        installedSkillViewModel.J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0() {
        Object objB;
        com.stepos.ailauncher.agent.skill.installed.adapter.b bVar;
        LinearLayoutManager linearLayoutManager;
        try {
            Result.Companion companion = Result.INSTANCE;
            C1122f c1122f = this.binding;
            bVar = null;
            if (c1122f == null) {
                kotlin.jvm.internal.p.A("binding");
                c1122f = null;
            }
            RecyclerView.LayoutManager layoutManager = c1122f.rvInstalled.getLayoutManager();
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
            com.stepos.ailauncher.agent.skill.installed.adapter.b bVar2 = this.adapter;
            if (bVar2 == null) {
                kotlin.jvm.internal.p.A("adapter");
            } else {
                bVar = bVar2;
            }
            List<InstalledRow> currentList = bVar.getCurrentList();
            kotlin.jvm.internal.p.h(currentList, "getCurrentList(...)");
            if (iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition) {
                while (true) {
                    if (iFindFirstVisibleItemPosition >= 0 && iFindFirstVisibleItemPosition < currentList.size()) {
                        InstalledRow installedRow = currentList.get(iFindFirstVisibleItemPosition);
                        Set<Pair<String, DisplayScope>> set = this.exposedKeys;
                        String identifier = installedRow.getItem().getIdentifier();
                        DisplayScope displayScope = DisplayScope.INSTALLED;
                        if (set.add(Y8.j.a(identifier, displayScope))) {
                            SkillAnalytics.INSTANCE.d(installedRow.getItem(), displayScope);
                        }
                    }
                    if (iFindFirstVisibleItemPosition == iFindLastVisibleItemPosition) {
                        break;
                    } else {
                        iFindFirstVisibleItemPosition++;
                    }
                }
            }
            objB = Result.b(Y8.t.f7040a);
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t("InstalledSkillAct", "reportVisibleExposure failed", thE, false, 8, null);
            }
        }
    }

    private final void c0(final SkillItem item) {
        new c.a(this).p(R$string.installed_skill_uninstall_confirm_title).f(R$string.installed_skill_uninstall_confirm_message).l(R$string.installed_skill_action_uninstall, new DialogInterface.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.installed.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                InstalledSkillActivity.d0(this.f24440a, item, dialogInterface, i10);
            }
        }).i(R.string.cancel, null).s();
    }

    public static final void d0(InstalledSkillActivity installedSkillActivity, SkillItem skillItem, DialogInterface dialogInterface, int i10) {
        InstalledSkillViewModel installedSkillViewModel = installedSkillActivity.viewModel;
        if (installedSkillViewModel == null) {
            kotlin.jvm.internal.p.A("viewModel");
            installedSkillViewModel = null;
        }
        installedSkillViewModel.a0(skillItem);
    }

    public final void N() {
        Object systemService = getSystemService("input_method");
        C1122f c1122f = null;
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            C1122f c1122f2 = this.binding;
            if (c1122f2 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1122f = c1122f2;
            }
            inputMethodManager.hideSoftInputFromWindow(c1122f.etSearch.getWindowToken(), 0);
        }
    }

    public final void Y(final InstalledSkillViewModel.InstalledSkillUiState state) {
        if (this.lastReportedTab != state.getSelectedTab()) {
            this.lastReportedTab = state.getSelectedTab();
            SkillAnalytics.INSTANCE.f(state.getSelectedTab());
        }
        C1122f c1122f = this.binding;
        C1122f c1122f2 = null;
        if (c1122f == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f = null;
        }
        c1122f.tvTabSkills.setText(getString(R$string.installed_skill_tab_skill) + " " + state.h());
        C1122f c1122f3 = this.binding;
        if (c1122f3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f3 = null;
        }
        c1122f3.tvTabCli.setText(getString(R$string.installed_skill_tab_cli) + " " + state.c());
        InstallKind selectedTab = state.getSelectedTab();
        b5.m mVar = b5.m.INSTANCE;
        C1122f c1122f4 = this.binding;
        if (c1122f4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f4 = null;
        }
        TextView tvTabSkills = c1122f4.tvTabSkills;
        kotlin.jvm.internal.p.h(tvTabSkills, "tvTabSkills");
        int iN = mVar.n(tvTabSkills);
        C1122f c1122f5 = this.binding;
        if (c1122f5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f5 = null;
        }
        TextView tvTabSkills2 = c1122f5.tvTabSkills;
        kotlin.jvm.internal.p.h(tvTabSkills2, "tvTabSkills");
        int iP = mVar.p(tvTabSkills2);
        C1122f c1122f6 = this.binding;
        if (c1122f6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f6 = null;
        }
        View view = c1122f6.indicatorSkills;
        InstallKind installKind = InstallKind.SKILL;
        view.setVisibility(selectedTab == installKind ? 0 : 4);
        C1122f c1122f7 = this.binding;
        if (c1122f7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f7 = null;
        }
        View view2 = c1122f7.indicatorCli;
        InstallKind installKind2 = InstallKind.CLI;
        view2.setVisibility(selectedTab == installKind2 ? 0 : 4);
        C1122f c1122f8 = this.binding;
        if (c1122f8 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f8 = null;
        }
        c1122f8.tvTabSkills.setTextColor(selectedTab == installKind ? iN : iP);
        C1122f c1122f9 = this.binding;
        if (c1122f9 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f9 = null;
        }
        TextView textView = c1122f9.tvTabCli;
        if (selectedTab != installKind2) {
            iN = iP;
        }
        textView.setTextColor(iN);
        final InstalledSkillViewModel.TabState skillTab = state.getSelectedTab() == installKind ? state.getSkillTab() : state.getCliTab();
        this.canLoadNextPage = (skillTab.getIsLoading() || skillTab.getIsLoadingMore() || !skillTab.getHasMore() || skillTab.getLoadError()) ? false : true;
        TextView textView2 = this.pagingFooter;
        if (textView2 == null) {
            kotlin.jvm.internal.p.A("pagingFooter");
            textView2 = null;
        }
        textView2.setVisibility(skillTab.getLoadError() ? 0 : 8);
        TextView textView3 = this.pagingFooter;
        if (textView3 == null) {
            kotlin.jvm.internal.p.A("pagingFooter");
            textView3 = null;
        }
        textView3.setEnabled(skillTab.getLoadError() && !skillTab.getIsLoading() && !skillTab.getIsLoadingMore() && skillTab.getHasMore());
        if (skillTab.getLoadError()) {
            TextView textView4 = this.pagingFooter;
            if (textView4 == null) {
                kotlin.jvm.internal.p.A("pagingFooter");
                textView4 = null;
            }
            textView4.setText(com.stepos.ailauncher.chat.R$string.list_page_retry);
        }
        com.stepos.ailauncher.agent.skill.installed.adapter.b bVar = this.adapter;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("adapter");
            bVar = null;
        }
        bVar.submitList(state.i(), new Runnable() { // from class: com.stepos.ailauncher.agent.skill.installed.c
            @Override // java.lang.Runnable
            public final void run() {
                InstalledSkillActivity.Z(this.f24442a, state, skillTab);
            }
        });
        if (skillTab.getIsLoading() || skillTab.getIsLoadingMore() || skillTab.getHasMore() || skillTab.getLoadError()) {
            C1122f c1122f10 = this.binding;
            if (c1122f10 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1122f10 = null;
            }
            c1122f10.emptyView.setVisibility(8);
            C1122f c1122f11 = this.binding;
            if (c1122f11 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1122f2 = c1122f11;
            }
            c1122f2.rvInstalled.setVisibility(0);
            return;
        }
        if (state.getIsEmptyAll()) {
            C1122f c1122f12 = this.binding;
            if (c1122f12 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1122f12 = null;
            }
            c1122f12.emptyView.setVisibility(0);
            C1122f c1122f13 = this.binding;
            if (c1122f13 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1122f13 = null;
            }
            c1122f13.rvInstalled.setVisibility(8);
            C1122f c1122f14 = this.binding;
            if (c1122f14 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1122f14 = null;
            }
            c1122f14.tvEmptyMain.setText(R$string.installed_skill_empty_main);
            C1122f c1122f15 = this.binding;
            if (c1122f15 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1122f2 = c1122f15;
            }
            c1122f2.tvEmptySub.setText(R$string.installed_skill_empty_sub);
            return;
        }
        if (state.getIsEmptySearch()) {
            C1122f c1122f16 = this.binding;
            if (c1122f16 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1122f16 = null;
            }
            c1122f16.emptyView.setVisibility(0);
            C1122f c1122f17 = this.binding;
            if (c1122f17 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1122f17 = null;
            }
            c1122f17.rvInstalled.setVisibility(8);
            C1122f c1122f18 = this.binding;
            if (c1122f18 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1122f18 = null;
            }
            c1122f18.tvEmptyMain.setText(R$string.installed_skill_no_result_main);
            C1122f c1122f19 = this.binding;
            if (c1122f19 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1122f2 = c1122f19;
            }
            c1122f2.tvEmptySub.setText(R$string.installed_skill_no_result_sub);
            return;
        }
        if (!state.getIsEmptyTab()) {
            C1122f c1122f20 = this.binding;
            if (c1122f20 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1122f20 = null;
            }
            c1122f20.emptyView.setVisibility(8);
            C1122f c1122f21 = this.binding;
            if (c1122f21 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1122f2 = c1122f21;
            }
            c1122f2.rvInstalled.setVisibility(0);
            return;
        }
        C1122f c1122f22 = this.binding;
        if (c1122f22 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f22 = null;
        }
        c1122f22.emptyView.setVisibility(0);
        C1122f c1122f23 = this.binding;
        if (c1122f23 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f23 = null;
        }
        c1122f23.rvInstalled.setVisibility(8);
        C1122f c1122f24 = this.binding;
        if (c1122f24 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f24 = null;
        }
        c1122f24.tvEmptyMain.setText(R$string.installed_skill_empty_main);
        C1122f c1122f25 = this.binding;
        if (c1122f25 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1122f2 = c1122f25;
        }
        c1122f2.tvEmptySub.setText(R$string.installed_skill_empty_sub);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.p.i(ev, "ev");
        if (ev.getAction() == 0) {
            C1122f c1122f = this.binding;
            C1122f c1122f2 = null;
            if (c1122f == null) {
                kotlin.jvm.internal.p.A("binding");
                c1122f = null;
            }
            if (c1122f.etSearch.hasFocus()) {
                Rect rect = new Rect();
                C1122f c1122f3 = this.binding;
                if (c1122f3 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    c1122f3 = null;
                }
                c1122f3.etSearch.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                C1122f c1122f4 = this.binding;
                if (c1122f4 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    c1122f4 = null;
                }
                c1122f4.ivClear.getGlobalVisibleRect(rect2);
                int rawX = (int) ev.getRawX();
                int rawY = (int) ev.getRawY();
                if (!rect.contains(rawX, rawY) && !rect2.contains(rawX, rawY)) {
                    N();
                    C1122f c1122f5 = this.binding;
                    if (c1122f5 == null) {
                        kotlin.jvm.internal.p.A("binding");
                    } else {
                        c1122f2 = c1122f5;
                    }
                    c1122f2.etSearch.clearFocus();
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.k();
        }
        C1122f c1122fB = C1122f.b(LayoutInflater.from(this), null, false);
        kotlin.jvm.internal.p.h(c1122fB, "inflate(...)");
        this.binding = c1122fB;
        if (c1122fB == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122fB = null;
        }
        setContentView(c1122fB.root);
        this.viewModel = (InstalledSkillViewModel) new U(this).a(InstalledSkillViewModel.class);
        this.adapter = new com.stepos.ailauncher.agent.skill.installed.adapter.b(new p9.p() { // from class: com.stepos.ailauncher.agent.skill.installed.e
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return InstalledSkillActivity.P(this.f24446a, (SkillItem) obj, ((Boolean) obj2).booleanValue());
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.installed.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return InstalledSkillActivity.Q(this.f24447a, (SkillItem) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.installed.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return InstalledSkillActivity.R(this.f24448a, (SkillItem) obj);
            }
        });
        C1122f c1122f = this.binding;
        if (c1122f == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f = null;
        }
        c1122f.rvInstalled.setLayoutManager(new LinearLayoutManager(this));
        C1122f c1122f2 = this.binding;
        if (c1122f2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f2 = null;
        }
        RecyclerView recyclerView = c1122f2.rvInstalled;
        com.stepos.ailauncher.agent.skill.installed.adapter.b bVar = this.adapter;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("adapter");
            bVar = null;
        }
        recyclerView.setAdapter(bVar);
        C1122f c1122f3 = this.binding;
        if (c1122f3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f3 = null;
        }
        c1122f3.rvInstalled.setItemAnimator(null);
        C1122f c1122f4 = this.binding;
        if (c1122f4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f4 = null;
        }
        c1122f4.rvInstalled.addItemDecoration(new com.stepos.ailauncher.agent.aispace.E(this, null, 2, null));
        TextView textView = new TextView(this);
        textView.setGravity(17);
        textView.setTextColor(-1711276033);
        textView.setTextSize(13.0f);
        textView.setVisibility(8);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.installed.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InstalledSkillActivity.S(this.f24449a, view);
            }
        });
        this.pagingFooter = textView;
        C1122f c1122f5 = this.binding;
        if (c1122f5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f5 = null;
        }
        ViewParent parent = c1122f5.rvInstalled.getParent();
        kotlin.jvm.internal.p.g(parent, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) parent;
        TextView textView2 = this.pagingFooter;
        if (textView2 == null) {
            kotlin.jvm.internal.p.A("pagingFooter");
            textView2 = null;
        }
        frameLayout.addView(textView2, new FrameLayout.LayoutParams(-1, (int) (40 * getResources().getDisplayMetrics().density), 80));
        C1122f c1122f6 = this.binding;
        if (c1122f6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f6 = null;
        }
        c1122f6.rvInstalled.setPadding(0, 0, 0, (int) (48 * getResources().getDisplayMetrics().density));
        C1122f c1122f7 = this.binding;
        if (c1122f7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f7 = null;
        }
        c1122f7.rvInstalled.addOnScrollListener(new a());
        C1122f c1122f8 = this.binding;
        if (c1122f8 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f8 = null;
        }
        c1122f8.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.installed.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InstalledSkillActivity.T(this.f24450a, view);
            }
        });
        C1122f c1122f9 = this.binding;
        if (c1122f9 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f9 = null;
        }
        EditText etSearch = c1122f9.etSearch;
        kotlin.jvm.internal.p.h(etSearch, "etSearch");
        b5.g.b(etSearch);
        C1122f c1122f10 = this.binding;
        if (c1122f10 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f10 = null;
        }
        c1122f10.etSearch.addTextChangedListener(new b());
        C1122f c1122f11 = this.binding;
        if (c1122f11 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f11 = null;
        }
        c1122f11.etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.stepos.ailauncher.agent.skill.installed.j
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView3, int i10, KeyEvent keyEvent) {
                return InstalledSkillActivity.U(this.f24451a, textView3, i10, keyEvent);
            }
        });
        C1122f c1122f12 = this.binding;
        if (c1122f12 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f12 = null;
        }
        c1122f12.ivClear.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.installed.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InstalledSkillActivity.V(this.f24452a, view);
            }
        });
        C1122f c1122f13 = this.binding;
        if (c1122f13 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f13 = null;
        }
        c1122f13.tabSkill.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.installed.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InstalledSkillActivity.W(this.f24453a, view);
            }
        });
        C1122f c1122f14 = this.binding;
        if (c1122f14 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1122f14 = null;
        }
        c1122f14.tabCli.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.installed.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InstalledSkillActivity.X(this.f24454a, view);
            }
        });
        C1060i.d(C1398p.a(this), null, null, new AnonymousClass12(null), 3, null);
        C1060i.d(C1398p.a(this), null, null, new AnonymousClass13(null), 3, null);
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        this.exposedKeys.clear();
        super.onDestroy();
    }
}
