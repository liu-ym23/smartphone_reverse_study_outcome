package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent;

import am2.x;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.widget.LiveMessageRecyclerView;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.selectedmessage.SelectedMsgABHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.p;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q;
import com.bytedance.android.livesdk.interactivity.common.accessibility.MessageRvAccessibilityDelegate;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.SelectedMsgViewManager;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.SelectedMsgBuffer;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.SelectedMsgListAdapter;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.PSSelectedMessageDialog;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.SelectedMsgLayoutManager;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.PaddingItemDecoration;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.QuickAbilityAdapter;
import com.bytedance.android.livesdk.interactivity.utils.PublicScreenMessageMonitor;
import com.bytedance.android.livesdk.interactivity.utils.t;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.AIPublicScreenContainer;
import com.bytedance.android.livesdkapi.depend.model.live.Ability;
import com.bytedance.android.livesdkapi.depend.model.live.IAbility;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class AiAgentPSSelectedMsgView extends FrameLayout implements com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a.InterfaceC2204a, ha2.a {
    public static final int P = 0;
    public static final int Q = 0;
    public static final int R = 0;
    public static final int S = 0;
    public static final int T = 0;
    public static final int U = 0;
    public static final int V = 0;
    public static final int W = 0;
    public AiAgentViewStateHolder A;
    public List<? extends View> B;
    public List<? extends View> C;
    public List<? extends View> D;
    public List<? extends View> E;
    public List<? extends View> F;
    public List<? extends View> G;
    public List<? extends View> H;
    public List<? extends View> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public List<? extends View> f139465J;
    public ia2.e K;
    public final e52.a L;
    public final DataCenter M;
    public final CompositeDisposable N;
    public final fa2.a O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f139466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f139467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f139468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f139469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f139470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f139471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LiveMessageRecyclerView f139472g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f139473h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f139474i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SelectedMsgLayoutManager f139475j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SpaceItemDecoration f139476k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Handler f139477l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function1<com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Map<String, String>> f139478m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f139479n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final SelectedMsgListAdapter f139480o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final h f139481p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a f139482q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f139483r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public HSImageView f139484s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f139485t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public FrameLayout f139486u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public FrameLayout f139487v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ImageView f139488w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public FrameLayout f139489x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TextView f139490y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ImageView f139491z;

    public static final class UIParams {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy f139492c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Lazy f139493d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f139494e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f139495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f139496b;

        public static final class a {
            public a() {
            }
        }

        static {
            f139494e = new a();
            f139492c = LazyKt.lazy(AiAgentPSSelectedMsgView$UIParams$Companion$paramsMap$2.INSTANCE);
            f139493d = LazyKt.lazy(AiAgentPSSelectedMsgView$UIParams$Companion$aiParamsMap$2.INSTANCE);
        }

        public UIParams(float r100, float r101) {
            this.f139495a = s1.f(r100);
            this.f139496b = s1.f(r101);
        }
    }

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AiAgentPSSelectedMsgView f139497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f139498b;

        public b(AiAgentPSSelectedMsgView r100, String r101) {
            this.f139497a = r100;
            this.f139498b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ia2.e r100 = this.f139497a.K;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.b(String.valueOf(this.f139498b));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
        P = s1.f(54.0f);
        Q = s1.f(78.0f);
        R = s1.f(40.0f);
        S = s1.f(11.0f);
        T = s1.f(10.0f);
        U = s1.f(4.0f);
        V = s1.f(6.0f);
        W = s1.f(10.0f);
    }

    private final ia2.e getQuickAbilityViewManager() {
        ia2.e r100 = this.K;
        if (r100 != null) goto L10;
        r100 = new ia2.e(this.M, this.f139479n, this.N);
        this.K = r100;
        FrameLayout r101 = this.f139487v;
        AiAgentPSSelectedMsgView$getQuickAbilityViewManager$1$1 r102 = new AiAgentPSSelectedMsgView$getQuickAbilityViewManager$1$1(this);
        Intrinsics.checkNotNullParameter(r102, "onRecyclerViewSelfClick");
        if (r101 == null) goto L10;
        Context r103 = r101.getContext();
        if (r103 == null) goto L10;
        r100.f488853a = true;
        ((ArrayList) r100.f488855c).clear();
        RecyclerView r104 = new RecyclerView(r103);
        r104.setHorizontalFadingEdgeEnabled(true);
        r104.setFadingEdgeLength(UtilityKotlinExtentionsKt.i(10));
        r104.setOnTouchListener(new ia2.d(new GestureDetector(r103, new ia2.c(r102))));
        LinearLayoutManager r105 = new LinearLayoutManager(r103);
        r105.setOrientation(0);
        Unit r106 = Unit.INSTANCE;
        r104.setLayoutManager(r105);
        r104.setAdapter(new QuickAbilityAdapter(r100, r100.f488855c));
        r104.addItemDecoration(new PaddingItemDecoration());
        r100.f488854b = r104;
        r101.addView(r104, new ViewGroup.LayoutParams(-1, -2));
    L10:
        return r100;
    }

    public final void i() {
        if (fa2.b.a(this.O) == false) goto L47;
        AIPublicScreenContainer r100 = this.O.getAiPublicScreenContainer();
        List<IAbility> r101 = null;
        if (r100 == null) goto L7;
        py.k r102 = r100.getIcon();
    L8:
        ImageLoader.bindImage(this.f139484s, r102);
        TextView r103 = this.f139485t;
        if (r103 == null) goto L14;
        if (r100 == null) goto L12;
        String r104 = r100.getWelcomeTip();
    L13:
        r103.setText(r104);
        goto L14
    L12:
        r104 = null;
    L14:
        TextView r105 = this.f139490y;
        if (r105 == null) goto L20;
        if (r100 == null) goto L18;
        String r106 = r100.getNickName();
    L19:
        r105.setText(r106);
        goto L20
    L18:
        r106 = null;
    L20:
        ia2.e r107 = getQuickAbilityViewManager();
        AIPublicScreenContainer r108 = this.O.getAiPublicScreenContainer();
        if (r108 == null) goto L23;
        r101 = r108.getAbilities();
    L23:
        ((ArrayList) r107.f488855c).clear();
        if (r101 == null) goto L34;
        List<IAbility> r109 = r101;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator<T> r111 = r109.iterator();
    L27:
        if (r111.hasNext() == false) goto L33;
        IAbility r112 = (IAbility) r111.next();
        if (r112 == null) goto L32;
        r110.add(new ia2.b((Ability) r112, r107.f488853a));
        goto L27
    L32:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.Ability");
    L33:
        ((ArrayList) r107.f488855c).addAll(r110);
    L34:
        RecyclerView r113 = r107.f488854b;
        if (r113 == null) goto L40;
        RecyclerView.Adapter r114 = r113.getAdapter();
        if (r114 == null) goto L40;
        r114.notifyDataSetChanged();
    L40:
        if (((ArrayList) r107.f488855c).size() <= 0) goto L48;
        RecyclerView r115 = r107.f488854b;
        if (r115 == null) goto L49;
        r115.scrollToPosition(0);
        return;
    L49:
        return;
    L48:
        return;
    L7:
        r102 = null;
        goto L8
    }

    public final boolean m() {
        List<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r100 = this.f139480o.f139442b;
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.isEmpty();
    }

    @Override // ha2.a
    public final void onClear() {
        com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a r100 = this.f139482q;
        ((ArrayList) r100.f139428e).clear();
        r100.f139429f.i();
        SelectedMsgBuffer r101 = r100.f139426c;
        ((ArrayDeque) r101.f139438b).clear();
        ((PriorityQueue) r101.f139439c).clear();
        AiAgentViewStateHolder r102 = this.A;
        if (r102 == null) goto L9;
        ga2.d.a("AiAgentViewStateHolder onClear");
        Disposable r103 = r102.f139504c;
        if (r103 == null) goto L7;
        r103.dispose();
    L7:
        r102.f139504c = null;
        return;
    }

    public final void t() {
        AiAgentViewStateHolder r100 = this.A;
        if (r100 == null) goto L5;
        AiAgentViewState r101 = r100.f139502a;
    L6:
        if (r101 == null) goto L41;
        int r102 = com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.b.f139514d[r101.ordinal()];
        if (r102 == 1) goto L30;
        if (r102 != 2) goto L13;
        HSImageView r103 = this.f139484s;
        if (r103 == null) goto L28;
        a1.o(r103, S);
    L28:
        ViewGroup.LayoutParams r104 = getLayoutParams();
        r104.height = Q;
        getLayoutParams().width = -1;
        setLayoutParams(getLayoutParams());
        return;
    L13:
        if (r102 != 3) goto L15;
        HSImageView r105 = this.f139484s;
        if (r105 == null) goto L24;
        a1.o(r105, T);
    L24:
        ViewGroup.LayoutParams r106 = getLayoutParams();
        r106.height = R;
        getLayoutParams().width = -2;
        setLayoutParams(getLayoutParams());
        return;
    L15:
        if (r102 != 4) goto L42;
        int r107 = PublicScreenStyleHelper.a();
        UIParams.f139494e.getClass();
        UIParams r108 = (UIParams) ((Map) UIParams.f139493d.getValue()).get(Integer.valueOf(r107));
        if (r108 != null) goto L20;
        r108 = new UIParams(130.0f, 0.0f);
    L20:
        ViewGroup.LayoutParams r109 = getLayoutParams();
        r109.height = r108.f139495a;
        getLayoutParams().width = -1;
        setLayoutParams(getLayoutParams());
        LiveMessageRecyclerView r110 = this.f139472g;
        int r111 = r108.f139496b;
        r110.setPadding(0, r111, 0, r111);
        return;
    L42:
        return;
    L30:
        if (m() == false) goto L32;
        UtilityKotlinExtentionsKt.t(this.f139472g);
        UtilityKotlinExtentionsKt.w(this.f139474i);
        ViewGroup.LayoutParams r112 = getLayoutParams();
        r112.height = P;
        getLayoutParams().width = -1;
        setLayoutParams(getLayoutParams());
        return;
    L32:
        UtilityKotlinExtentionsKt.w(this.f139472g);
        UtilityKotlinExtentionsKt.t(this.f139474i);
        int r113 = PublicScreenStyleHelper.a();
        UIParams.f139494e.getClass();
        UIParams r114 = (UIParams) ((Map) UIParams.f139492c.getValue()).get(Integer.valueOf(r113));
        if (r114 != null) goto L35;
        r114 = new UIParams(94.0f, 4.0f);
    L35:
        ViewGroup.LayoutParams r115 = getLayoutParams();
        r115.height = r114.f139495a;
        getLayoutParams().width = -1;
        setLayoutParams(getLayoutParams());
        LiveMessageRecyclerView r116 = this.f139472g;
        int r117 = r114.f139496b;
        r116.setPadding(0, r117, 0, r117);
        return;
    L41:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // ha2.a
    public final boolean d() {
        if (getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // ha2.a
    public fa2.c getMessageHandler() {
        return this.f139482q;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L18;
        if (r100.getAction() != 0) goto L18;
        AiAgentViewStateHolder r101 = this.A;
        AiAgentViewState r102 = null;
        if (r101 == null) goto L8;
        AiAgentViewState r103 = r101.f139502a;
    L10:
        if (r103 == AiAgentViewState.AI_AGENT_EMPTY) goto L15;
        if (r101 == null) goto L14;
        r102 = r101.f139502a;
    L14:
        if (r102 != AiAgentViewState.AI_AGENT_MESSAGE) goto L18;
    L15:
        if (r101 == null) goto L18;
        r101.c();
        goto L18
    L8:
        r103 = null;
    L18:
        return super.dispatchTouchEvent(r100);
    }

    public final void k(boolean r100) {
        if (r100 == false) goto L13;
        HSImageView r101 = this.f139484s;
        if (r101 == null) goto L6;
        UtilityKotlinExtentionsKt.t(r101);
    L6:
        TextView r102 = this.f139485t;
        if (r102 == null) goto L9;
        a1.m(r102, W);
    L9:
        TextView r103 = this.f139490y;
        if (r103 == null) goto L37;
        a1.m(r103, W);
        return;
    L37:
        return;
    L13:
        AIPublicScreenContainer r104 = this.O.getAiPublicScreenContainer();
        if (r104 == null) goto L16;
        py.k r105 = r104.getIcon();
    L17:
        if (r105 != null) goto L27;
        HSImageView r106 = this.f139484s;
        if (r106 == null) goto L21;
        UtilityKotlinExtentionsKt.t(r106);
    L21:
        TextView r107 = this.f139485t;
        if (r107 == null) goto L24;
        a1.m(r107, W);
    L24:
        TextView r108 = this.f139490y;
        if (r108 == null) goto L38;
        a1.m(r108, W);
        return;
    L38:
        return;
    L27:
        HSImageView r109 = this.f139484s;
        if (r109 == null) goto L30;
        UtilityKotlinExtentionsKt.w(r109);
    L30:
        TextView r110 = this.f139485t;
        if (r110 == null) goto L33;
        a1.m(r110, V);
    L33:
        TextView r111 = this.f139490y;
        if (r111 == null) goto L40;
        a1.m(r111, V);
        return;
    L40:
        return;
    L16:
        r105 = null;
        goto L17
    }

    public final String l(boolean r100) {
        if (this.O.c() == true) goto L5;
        return "normal";
    L5:
        if (r100 == true) goto L7;
        return "ai";
    L7:
        if (this.O.b() == false) goto L10;
        return "ai_assistant#2";
    L10:
        if (this.O.a() == true) goto L17;
        return "ai";
    L17:
        return "ai_assistant#1";
    }

    public final void n(Map<String, String> r100) {
        AiAgentViewState r101 = null;
        if (this.O.b() == false) goto L28;
        if (PadConfigUtils.c() == true) goto L7;
    L11:
        Context r102 = getContext();
        AIPublicScreenContainer r103 = this.O.getAiPublicScreenContainer();
        if (r103 == null) goto L21;
        String r104 = r103.getAreaSchema();
        if (r104 == null) goto L21;
        if (r104.length() <= 0) goto L18;
        boolean r105 = true;
    L19:
        if (r105 == false) goto L21;
    L22:
        if (r102 == null) goto L32;
        if (r104 == null) goto L32;
        IBaseLiveActionHandler r106 = (IBaseLiveActionHandler) jc1.k.f(IBaseLiveActionHandler.class);
        if (r106 == null) goto L32;
        r106.handle(r102, r104);
    L32:
        LinkedHashMap r107 = new LinkedHashMap();
        AiAgentViewStateHolder r108 = this.A;
        if (r108 == null) goto L35;
        r101 = r108.f139502a;
    L35:
        if (r101 == null) goto L43;
        int r109 = com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.b.f139513c[r101.ordinal()];
        if (r109 != 1) goto L40;
        String r110 = "expand#0";
    L47:
        r107.put("show_type", r110);
        r107.put("msg_show_area", "ai_assistant");
        if (r100 == null) goto L52;
        String r111 = r100.get("msg_id");
        if (r111 == null) goto L52;
        r107.put("msg_id", r111);
    L52:
        if (r100 == null) goto L56;
        String r112 = r100.get(SeiMessageConst.MSG_TYPE);
        if (r112 == null) goto L56;
        r107.put(SeiMessageConst.MSG_TYPE, r112);
    L56:
        Boolean r113 = p.f133647a;
        p.c("action_sheet", r107, this.M);
        return;
    L40:
        if (r109 != 2) goto L42;
        r110 = "expand#1";
        goto L47
    L42:
        if (r109 != 3) goto L43;
        r110 = "collapse";
    L43:
        r110 = "";
        goto L47
    L18:
        r105 = false;
    L21:
        r104 = null;
        goto L22
    L7:
        if (((Boolean) SelectedMsgABHelper.f133532e.getValue()).booleanValue() == false) goto L11;
        Context r114 = getContext();
        if (r114 == null) goto L32;
        o(r114);
        goto L32
    L28:
        if (this.O.a() == false) goto L58;
        Context r115 = getContext();
        if (r115 == null) goto L32;
        o(r115);
        goto L32
    }

    public final void o(Context r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("click_type", "msg_more");
        r101.put("selected_mode_type", l(false));
        j0.l().sendLog("livesdk_selected_message_layer_click", r101, new Object[]{IRoom.class, x.class});
        PSSelectedMessageDialog r102 = new PSSelectedMessageDialog(r100, this.M, this.N, this.O);
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r102);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
    }

    @Override // ha2.a
    public void onEvent(o42.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        t();
        SelectedMsgListAdapter r101 = this.f139480o;
        e52.a r102 = this.L;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "textMessageConfig");
        r101.f139443c = r102;
        int r103 = q.e(true, true);
        this.f139480o.f139444d = q.a(this.L, true, true);
        this.f139476k.f118705a = r103;
        Iterator r104 = ((ArrayList) this.f139482q.f139428e).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.interactivity.api.entity.f) r104.next()).F = null;
        goto L4
    L6:
        this.f139480o.notifyDataSetChanged();
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a.InterfaceC2204a
    public final void pa(int r100) {
        this.f139480o.notifyItemRangeRemoved(0, r100);
        if (this.A == null) goto L6;
        ga2.d.a("AiAgentViewStateHolder messageRemove");
    L6:
        if (m() == false) goto L9;
        t();
        return;
    }

    public final boolean s(boolean r100) {
        if (this.f139466a == false) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L12;
        if (this.f139468c == true) goto L12;
    L17:
        return false;
    L12:
        if (this.f139480o.getItemCount() <= 0) goto L17;
        if (r100 == false) goto L15;
        this.f139468c = true;
        this.f139472g.smoothScrollToPosition(this.f139480o.getItemCount() - 1);
    L16:
        return true;
    L15:
        this.f139472g.scrollToPosition(this.f139480o.getItemCount() - 1);
        goto L16
    L5:
        if (this.f139467b == true) goto L7;
        r101 = true;
        goto L8
    }

    public static final void h(AiAgentPSSelectedMsgView r100, AiAgentViewState r101) {
        r100.getClass();
        int r102 = com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.b.f139511a[r101.ordinal()];
        if (r102 == 1) goto L26;
        if (r102 == 2) goto L20;
        if (r102 == 3) goto L14;
        if (r102 != 4) goto L32;
        List<? extends View> r103 = r100.f139465J;
        if (r103 != null) goto L33;
        List<? extends View> r104 = r100.B;
        List<? extends View> r105 = r100.F;
        if (r104 == null) goto L32;
        if (r105 == null) goto L32;
        r103 = CollectionsKt.minus(r104, r105);
        r100.f139465J = r103;
    L33:
        if (r103 == null) goto L40;
        Iterator<T> r106 = r103.iterator();
    L36:
        if (r106.hasNext() == false) goto L40;
        View r107 = (View) r106.next();
        if (r107 == null) goto L36;
        UtilityKotlinExtentionsKt.t(r107);
    L40:
        int r108 = com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.b.f139512b[r101.ordinal()];
        if (r108 != 1) goto L43;
        List<? extends View> r109 = r100.C;
        if (r109 == null) goto L82;
        Iterator<T> r110 = r109.iterator();
    L78:
        if (r110.hasNext() == false) goto L82;
        View r111 = (View) r110.next();
        if (r111 == null) goto L78;
        UtilityKotlinExtentionsKt.w(r111);
    L82:
        p(r100.f139472g, r100);
        r100.setBackgroundResource(R.drawable.ttlive_bg_selected_message);
        return;
    L43:
        if (r108 == 2) goto L65;
        if (r108 == 3) goto L56;
        if (r108 == 4) goto L47;
        int r112 = ga2.d.f480547a;
        ga2.d.a("changeViewsState, ignored state: " + r101.desc());
        return;
    L47:
        List<? extends View> r113 = r100.F;
        if (r113 == null) goto L55;
        Iterator<T> r114 = r113.iterator();
    L51:
        if (r114.hasNext() == false) goto L55;
        View r115 = (View) r114.next();
        if (r115 == null) goto L51;
        UtilityKotlinExtentionsKt.w(r115);
    L55:
        p(r100.f139472g, r100.f139489x);
        r100.setBackgroundResource(R.drawable.ttlive_bg_selected_message_ai_agent);
        r100.k(false);
        return;
    L56:
        List<? extends View> r116 = r100.E;
        if (r116 == null) goto L64;
        Iterator<T> r117 = r116.iterator();
    L60:
        if (r117.hasNext() == false) goto L64;
        View r118 = (View) r117.next();
        if (r118 == null) goto L60;
        UtilityKotlinExtentionsKt.w(r118);
    L64:
        p(r100.f139472g, r100.f139489x);
        r100.setBackgroundResource(R.drawable.ttlive_bg_selected_message_ai_agent);
        r100.getQuickAbilityViewManager().a(r100.f139486u, false);
        r100.k(true);
        return;
    L65:
        List<? extends View> r119 = r100.D;
        if (r119 == null) goto L73;
        Iterator<T> r120 = r119.iterator();
    L69:
        if (r120.hasNext() == false) goto L73;
        View r121 = (View) r120.next();
        if (r121 == null) goto L69;
        UtilityKotlinExtentionsKt.w(r121);
    L73:
        p(r100.f139472g, r100.f139489x);
        r100.setBackgroundResource(R.drawable.ttlive_bg_selected_message_ai_agent);
        r100.getQuickAbilityViewManager().a(r100.f139487v, true);
        r100.k(false);
        return;
    L32:
        r103 = null;
        goto L33
    L14:
        r103 = r100.I;
        if (r103 != null) goto L33;
        List<? extends View> r122 = r100.B;
        List<? extends View> r123 = r100.E;
        if (r122 == null) goto L32;
        if (r123 == null) goto L32;
        r103 = CollectionsKt.minus(r122, r123);
        r100.I = r103;
        goto L33
    L20:
        r103 = r100.H;
        if (r103 != null) goto L33;
        List<? extends View> r124 = r100.B;
        List<? extends View> r125 = r100.D;
        if (r124 == null) goto L32;
        if (r125 == null) goto L32;
        r103 = CollectionsKt.minus(r124, r125);
        r100.H = r103;
        goto L33
    L26:
        r103 = r100.G;
        if (r103 != null) goto L33;
        List<? extends View> r126 = r100.B;
        List<? extends View> r127 = r100.C;
        if (r126 == null) goto L32;
        if (r127 == null) goto L32;
        r103 = CollectionsKt.minus(r126, r127);
        r100.G = r103;
        goto L33
    }

    public static void p(LiveMessageRecyclerView r100, ViewGroup r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(UtilityKotlinExtentionsKt.p(r100), r101) == false) goto L7;
        return;
    L7:
        UtilityKotlinExtentionsKt.q(r100);
        r101.addView(r100, 0);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a.InterfaceC2204a
    public final void DI(int r100, long r101) {
        this.f139475j.p(r100);
        this.f139475j.f139462b = (int) r101;
    }

    @Override // ha2.a
    public final void f(String r100, boolean r101) {
        if (r101 == false) goto L17;
        i();
        AiAgentViewStateHolder r102 = this.A;
        if (r102 == null) goto L17;
        ga2.d.a("AiAgentViewStateHolder modeChange");
        if (r102.f139506e.a() == false) goto L12;
        r102.d();
        if (r102.f139506e.b() == false) goto L11;
        AiAgentViewState r103 = AiAgentViewState.AI_AGENT_EMPTY;
    L16:
        r102.a(r103, AiAgentViewChangeReason.MODE_CHANGE);
        goto L17
    L11:
        r103 = AiAgentViewState.AI_AGENT_MESSAGE;
        goto L16
    L12:
        Disposable r104 = r102.f139504c;
        if (r104 == null) goto L15;
        r104.dispose();
    L15:
        r102.f139504c = null;
        r103 = AiAgentViewState.NO_OR_OLD_AI;
    L17:
        com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a r105 = this.f139482q;
        int r106 = SelectedMsgABHelper.b().cacheNumAfterSettingChange;
        SelectedMsgBuffer r107 = r105.f139426c;
        if (r101 == false) goto L20;
        ((ArrayDeque) r107.f139438b).clear();
        ((PriorityQueue) r107.f139439c).clear();
        int r108 = ga2.d.f480547a;
        Intrinsics.checkNotNullParameter("ai mode change, clear all message", "msg");
        ALogger.i("PSSelectedMessage", "ai mode change, clear all message");
    L26:
        f2.c(r100, 0);
        ha2.a.C6116a.a(this, true, null, 14);
        return;
    L20:
        int r109 = ((ArrayDeque) r107.f139438b).size() - RangesKt.coerceAtMost(r106, ((ArrayDeque) r107.f139438b).size());
        if (r109 <= 0) goto L25;
        int r110 = 0;
    L23:
        if (r110 >= r109) goto L25;
        ((ArrayDeque) r107.f139438b).poll();
        r110 = r110 + 1;
    L25:
        int r111 = ga2.d.f480547a;
        ALogger.i("PSSelectedMessage", "buffer message batch clear. clear num: " + r109);
        goto L26
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a.InterfaceC2204a
    public final void fc(int r100, int r101) {
        this.f139480o.notifyItemRangeInserted(r100, r101);
        if (r101 <= 0) goto L11;
        s(true);
        AiAgentViewStateHolder r102 = this.A;
        if (r102 == null) goto L11;
        ga2.d.a("AiAgentViewStateHolder messageInsert");
        AiAgentViewState r103 = AiAgentViewState.NO_OR_OLD_AI;
        AiAgentViewState r104 = AiAgentViewState.AI_AGENT_MESSAGE;
        r102.b(new AiAgentViewState[]{r103, AiAgentViewState.AI_AGENT_EMPTY, r104, AiAgentViewState.AI_AGENT_FOLD});
        r102.c();
        AiAgentViewState r105 = r102.f139502a;
        if (r105 == r103) goto L11;
        if (r105 == r104) goto L11;
        r102.a(r104, AiAgentViewChangeReason.MESSAGE_INSERT);
    L11:
        if (r100 != 0) goto L15;
        if (r101 <= 0) goto L16;
        t();
        return;
    L16:
        return;
    }

    @Override // ha2.a
    public final void g(String r100, String r101) {
        Pair[] r102 = new Pair[3];
        r102[0] = TuplesKt.to("selected_mode_type", l(true));
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r102[1] = TuplesKt.to("show_from", r100);
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r102[2] = TuplesKt.to("show_type", r101);
        Map<String, String> r103 = MapsKt.mutableMapOf(r102);
        int r104 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.b.f133631a;
        ia2.e r105 = this.K;
        if (r105 == null) goto L13;
        WeakReference<DataCenter> r106 = r105.getDataCenter();
        if (r106 == null) goto L13;
        DataCenter r107 = r106.get();
    L14:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.b.a(r103, r107);
        j0.l().sendLog("livesdk_selected_message_layer_show", r103, new Object[]{IRoom.class});
        return;
    L13:
        r107 = null;
        goto L14
    }

    @Override // ha2.a
    public final void a(boolean r100, String r101, boolean r102) {
        int r103 = ga2.d.f480547a;
        ga2.d.a("setInSupportedLinkState, inSupportedScene: " + r100 + ", autoOpen: " + r102);
        if (r102 == false) goto L5;
        this.f139471f = true;
        i();
    L5:
        this.f139469d = r100;
        j(r101, "live_type_change", "new_open");
    }

    @Override // ha2.a
    public final void c(boolean r100, String r101, boolean r102) {
        int r103 = ga2.d.f480547a;
        ga2.d.a("setInSupportedAudioScene, inSupportedAudioScene: " + r100 + ", autoOpen: " + r102);
        if (r102 == false) goto L5;
        this.f139471f = true;
        i();
    L5:
        j(r101, "audio_scene_change", "new_open");
    }

    @Override // ha2.a
    public final void e(boolean r100, String r101, boolean r102) {
        int r103 = ga2.d.f480547a;
        ga2.d.a("setInSupportedVideoTalkRoomScene, inSupportedScene: " + r100 + ", autoOpen: " + r102);
        if (r102 == false) goto L5;
        this.f139471f = true;
        i();
    L5:
        this.f139470e = r100;
        j(r101, "live_type_change", "new_open");
    }

    public final boolean j(String r100, String r101, String r102) {
        MiddlewareRoomContext r103 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.M, 0, 2);
        if (r103 == null) goto L7;
        com.bytedance.live.datacontext.i<LiveMode> r104 = r103.getLiveMode();
        if (r104 == null) goto L7;
        LiveMode r105 = r104.getValue();
    L9:
        if (r105 != LiveMode.VIDEO) goto L18;
        if (this.f139471f == true) goto L13;
    L24:
        boolean r106 = false;
    L26:
        if (r106 != d()) goto L28;
        return false;
    L28:
        if (r106 == false) goto L50;
        UtilityKotlinExtentionsKt.w(this);
        this.M.put("cmd_selected_message_change_visible_state", Boolean.TRUE);
        g(r101, r102);
        com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a r107 = this.f139482q;
        r107.f139429f.f();
        r107.f139425b = true;
        SimpleDateFormat r108 = PublicScreenMessageMonitor.f141318a;
        ((t) PublicScreenMessageMonitor.f141339v.getValue()).f141419d = true;
        AiAgentViewStateHolder r109 = this.A;
        if (r109 == null) goto L39;
        ga2.d.a("AiAgentViewStateHolder containerShow");
        if (r109.f139506e.a() == false) goto L37;
        r109.d();
        if (r109.f139506e.b() == false) goto L36;
        AiAgentViewState r110 = AiAgentViewState.AI_AGENT_EMPTY;
    L38:
        r109.a(r110, AiAgentViewChangeReason.CONTAINER_SHOW);
        goto L39
    L36:
        r110 = AiAgentViewState.AI_AGENT_MESSAGE;
        goto L38
    L37:
        r110 = AiAgentViewState.NO_OR_OLD_AI;
    L39:
        ALogger.i("QuickAbilityViewManager", "calculateVisibility，showFrom=" + r101 + ",showType= " + r102);
        if (r102 != null) goto L42;
    L59:
        if (r100 != null) goto L61;
    L64:
        boolean r111 = true;
    L65:
        if (r111 == true) goto L67;
        f2.c(r100, 0);
        ga2.d.a(r100);
    L67:
        return true;
    L61:
        if (StringsKt.isBlank(r100) == true) goto L64;
        r111 = false;
        goto L65
    L42:
        if (Intrinsics.areEqual(r102, "new_open") == false) goto L46;
        if (Intrinsics.areEqual(r101, "screen_assistant_setting") == true) goto L59;
    L46:
        if (Intrinsics.areEqual(r102, "new_open") == true) goto L48;
    L49:
        post(new b(this, r101));
        goto L59
    L48:
        if (Intrinsics.areEqual(r101, "live_take_show") == true) goto L59;
    L50:
        UtilityKotlinExtentionsKt.t(this);
        com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a r112 = this.f139482q;
        r112.f139429f.f133392b.removeCallbacksAndMessages(null);
        r112.f139425b = false;
        SelectedMsgBuffer r113 = r112.f139426c;
        ((ArrayDeque) r113.f139438b).clear();
        ((PriorityQueue) r113.f139439c).clear();
        int r114 = RangesKt.coerceAtLeast(((ArrayList) r112.f139428e).size() - r112.f139427d.listMaxSizeWhenHide, 0);
        ((ArrayList) r112.f139428e).subList(0, r114).clear();
        com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a.InterfaceC2204a r115 = (com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a.InterfaceC2204a) r112.f531633a;
        if (r115 == null) goto L53;
        r115.pa(r114);
    L53:
        ga2.d.b(r114, "visibility change");
        SimpleDateFormat r116 = PublicScreenMessageMonitor.f141318a;
        ((t) PublicScreenMessageMonitor.f141339v.getValue()).f141419d = false;
        AiAgentViewStateHolder r117 = this.A;
        if (r117 == null) goto L59;
        ga2.d.a("AiAgentViewStateHolder containerHide");
        Disposable r118 = r117.f139504c;
        if (r118 == null) goto L58;
        r118.dispose();
    L58:
        r117.f139504c = null;
        goto L59
    L13:
        if (this.f139469d == false) goto L24;
        if (this.f139470e == false) goto L24;
    L23:
        r106 = true;
        goto L26
    L18:
        if (r105 != LiveMode.AUDIO) goto L24;
        if (this.f139471f == false) goto L24;
        if (SelectedMsgABHelper.c(this.M) == false) goto L24;
    L7:
        r105 = null;
        goto L9
    }

    @Override // ha2.a
    public final void b(boolean r100, String r101, String r102, String r103) {
        this.f139471f = r100;
        if (r100 == true) goto L5;
    L7:
        j(r101, r102, r103);
        return;
    L5:
        if (Intrinsics.areEqual(r103, "new_open") == false) goto L7;
        i();
        goto L7
    }

    public AiAgentPSSelectedMsgView(Context r110, e52.a r111, DataCenter r210, CompositeDisposable r211, SelectedMsgViewManager r212) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "publicScreenConfig");
        Intrinsics.checkNotNullParameter(r210, "dataCenter");
        Intrinsics.checkNotNullParameter(r211, "cd");
        Intrinsics.checkNotNullParameter(r212, "selectedDataSource");
        super(r110, null, 0);
        this.L = r111;
        this.M = r210;
        this.N = r211;
        this.O = r212;
        this.f139469d = SelectedMsgABHelper.f(r210, null);
        this.f139470e = SelectedMsgABHelper.g(r210, null);
        SelectedMsgABHelper.e(r210);
        SelectedMsgLayoutManager r100 = new SelectedMsgLayoutManager(r110);
        this.f139475j = r100;
        SpaceItemDecoration r101 = new SpaceItemDecoration(1, q.e(true, true), false);
        this.f139476k = r101;
        Handler r102 = new Handler(Looper.getMainLooper());
        this.f139477l = r102;
        Function1<com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Map<String, String>> r112 = new AiAgentPSSelectedMsgView$envParamsGenerator$1(this);
        this.f139478m = r112;
        g r113 = new g(this);
        c r114 = new c(this);
        this.f139479n = r114;
        SelectedMsgListAdapter r115 = new SelectedMsgListAdapter(r112, r113, r114);
        this.f139480o = r115;
        this.f139481p = new h(this);
        com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a r116 = new com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a(r111, r102, r210, r212);
        this.f139482q = r116;
        FrameLayout.inflate(r110, R.layout.ttlive_layout_selected_message_ai_agent, this);
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-1, -2);
        r103.setMargins(0, U, 0, 0);
        setLayoutParams(r103);
        LiveMessageRecyclerView r104 = (LiveMessageRecyclerView) findViewById(R.id.selected_messages);
        this.f139472g = r104;
        View r105 = findViewById(R.id.more_panel_entry);
        this.f139473h = r105;
        View r106 = findViewById(R.id.empty_hint);
        this.f139474i = r106;
        r105.setOnClickListener(new com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.a(this, r110));
        this.f139483r = findViewById(R.id.ai_agent_root);
        this.f139484s = (HSImageView) findViewById(R.id.ai_agent_icon);
        this.f139485t = (TextView) findViewById(R.id.ai_agent_empty_welcome_tip);
        this.f139486u = (FrameLayout) findViewById(R.id.ai_agent_quick_ability_top_container);
        this.f139487v = (FrameLayout) findViewById(R.id.ai_agent_quick_ability_bottom_container);
        this.f139488w = (ImageView) findViewById(R.id.ai_agent_zoom_out_butoon);
        this.f139489x = (FrameLayout) findViewById(R.id.ai_agent_messages_container);
        this.f139490y = (TextView) findViewById(R.id.ai_agent_zoom_out_name);
        this.f139491z = (ImageView) findViewById(R.id.ai_agent_zoom_in_button);
        View r107 = this.f139483r;
        if (r107 == null) goto L5;
        r107.setOnClickListener(x0.a(new AiAgentPSSelectedMsgView$setAiAgentViewClickListener$1(this)));
    L5:
        ImageView r108 = this.f139488w;
        if (r108 == null) goto L8;
        r108.setOnClickListener(x0.a(new AiAgentPSSelectedMsgView$setAiAgentViewClickListener$2(this)));
    L8:
        ImageView r109 = this.f139491z;
        if (r109 == null) goto L11;
        r109.setOnClickListener(x0.a(new AiAgentPSSelectedMsgView$setAiAgentViewClickListener$3(this)));
    L11:
        this.B = CollectionsKt.listOf(new View[]{r104, r105, r106, this.f139483r, this.f139484s, this.f139485t, this.f139488w, this.f139489x, this.f139487v, this.f139486u, this.f139490y, this.f139491z});
        this.C = CollectionsKt.listOf(new View[]{r104, r105, r106});
        this.D = CollectionsKt.listOf(new View[]{this.f139483r, this.f139484s, this.f139485t, this.f139488w, this.f139487v});
        this.E = CollectionsKt.listOf(new View[]{this.f139483r, this.f139486u, this.f139488w, this.f139489x, r104});
        this.F = CollectionsKt.listOf(new View[]{this.f139483r, this.f139490y, this.f139491z});
        AiAgentViewStateHolder r117 = new AiAgentViewStateHolder(r114);
        f r118 = new f(this);
        Intrinsics.checkNotNullParameter(r118, "listener");
        r117.f139505d = r118;
        Unit r119 = Unit.INSTANCE;
        this.A = r117;
        ga2.d.a("AiAgentViewStateHolder init");
        r117.b(new AiAgentViewState[]{AiAgentViewState.DEFAULT});
        if (r117.f139506e.a() == false) goto L14;
        AiAgentViewState r120 = AiAgentViewState.AI_AGENT_EMPTY;
    L15:
        r117.a(r120, AiAgentViewChangeReason.INIT);
        List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r121 = r116.f139428e;
        Intrinsics.checkNotNullParameter(r121, "messages");
        r115.f139442b = r121;
        r116.f531633a = this;
        r104.setCanScrollUp(true);
        r104.setHasFixedSize(true);
        r104.setLayoutManager(r100);
        r104.addItemDecoration(r101);
        r104.setAccessibilityDelegateCompat(new MessageRvAccessibilityDelegate(r104));
        r104.setAdapter(r115);
        r104.setItemAnimator(null);
        r104.addOnScrollListener(new AiAgentPSSelectedMsgView$initMessageRecycleView$1(this));
        r104.setOnTouchListener(new d(this, new GestureDetector(getContext(), new e(this))));
        Intrinsics.checkNotNullParameter(r111, "textMessageConfig");
        r115.f139443c = r111;
        Intrinsics.checkNotNullParameter(LayoutInflater.from(getContext()), "layoutInflater");
        r115.f139444d = q.a(r111, true, true);
        t();
        j(null, null, null);
        return;
    L14:
        r120 = AiAgentViewState.NO_OR_OLD_AI;
        goto L15
    }
}
