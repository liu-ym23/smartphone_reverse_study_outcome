package com.stepos.ailauncher.chat.controller;

import Ua.C1060i;
import Z8.C1173v;
import Z8.C1174w;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.AbstractC1393k;
import android.view.C1398p;
import android.view.InterfaceC1387e;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.adapter.X;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import com.stepos.ailauncher.contract.model.search.SessionSearchHit;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0002:=\b\u0000\u0018\u0000 @2\u00020\u0001:\u0003ABCB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\f\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0013H\u0082@¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001b\u001a\u00020\b2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\rJ\u0017\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\"R0\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\b\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010\u0012\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u00101R\u001e\u00102\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006D"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/SessionSearchController;", "Landroidx/lifecycle/e;", "Lcom/stepos/ailauncher/chat/controller/SessionSearchController$b;", "views", "<init>", "(Lcom/stepos/ailauncher/chat/controller/SessionSearchController$b;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "LY8/t;", "m", "(Landroidx/lifecycle/LifecycleOwner;)V", "onDestroy", "q", "()V", "", "raw", "p", "(Ljava/lang/String;)V", "keyword", "", "Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;", "t", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$SidebarAgent;", "y", "(Le9/c;)Ljava/lang/Object;", "hits", "r", "(Ljava/util/List;Ljava/lang/String;)V", "x", "Lcom/stepos/ailauncher/chat/controller/SessionSearchController$EmptyState;", VoiceWakeupReceiver.EXTRA_STATE, "w", "(Lcom/stepos/ailauncher/chat/controller/SessionSearchController$EmptyState;)V", "Lcom/stepos/ailauncher/chat/controller/SessionSearchController$b;", "Lkotlin/Function1;", "onHitClick", "Lp9/l;", "getOnHitClick", "()Lp9/l;", "v", "(Lp9/l;)V", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/stepos/ailauncher/chat/adapter/X;", "adapter", "Lcom/stepos/ailauncher/chat/adapter/X;", "Lkotlinx/coroutines/g;", "searchJob", "Lkotlinx/coroutines/g;", "Ljava/lang/String;", "cachedAgents", "Ljava/util/List;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "searchInputTrackRunnable", "Ljava/lang/Runnable;", "com/stepos/ailauncher/chat/controller/SessionSearchController$c", "textWatcher", "Lcom/stepos/ailauncher/chat/controller/SessionSearchController$c;", "com/stepos/ailauncher/chat/controller/SessionSearchController$d", "touchListener", "Lcom/stepos/ailauncher/chat/controller/SessionSearchController$d;", "Companion", Const.INTENT_KEY_PKGNAME, "EmptyState", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SessionSearchController implements InterfaceC1387e {
    private static final a Companion = new a(null);

    @Deprecated
    public static final long SEARCH_DEBOUNCE_MS = 250;

    @Deprecated
    public static final long SEARCH_INPUT_TRACK_DELAY_MS = 1000;

    @Deprecated
    public static final String TAG = "SessionSearchController";
    private com.stepos.ailauncher.chat.adapter.X adapter;
    private List<IExternalAgentBindService.SidebarAgent> cachedAgents;
    private String keyword;
    private final Handler mainHandler;
    private InterfaceC5074l<? super SessionSearchHit, Y8.t> onHitClick;
    private LifecycleOwner owner;
    private final Runnable searchInputTrackRunnable;
    private kotlinx.coroutines.g searchJob;
    private final c textWatcher;
    private final d touchListener;
    private final b views;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/SessionSearchController$EmptyState;", "", "textRes", "", "iconShown", "", "<init>", "(Ljava/lang/String;IIZ)V", "getTextRes", "()I", "getIconShown", "()Z", "GUIDE", "NO_RESULT", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class EmptyState {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ EmptyState[] $VALUES;
        public static final EmptyState GUIDE = new EmptyState("GUIDE", 0, R$string.session_search_empty, true);
        public static final EmptyState NO_RESULT = new EmptyState("NO_RESULT", 1, R$string.panel_search_empty, false);
        private final boolean iconShown;
        private final int textRes;

        private static final /* synthetic */ EmptyState[] $values() {
            return new EmptyState[]{GUIDE, NO_RESULT};
        }

        static {
            EmptyState[] emptyStateArr$values = $values();
            $VALUES = emptyStateArr$values;
            $ENTRIES = kotlin.enums.a.a(emptyStateArr$values);
        }

        private EmptyState(String str, int i10, int i11, boolean z10) {
            this.textRes = i11;
            this.iconShown = z10;
        }

        public static InterfaceC4149a<EmptyState> getEntries() {
            return $ENTRIES;
        }

        public static EmptyState valueOf(String str) {
            return (EmptyState) Enum.valueOf(EmptyState.class, str);
        }

        public static EmptyState[] values() {
            return (EmptyState[]) $VALUES.clone();
        }

        public final boolean getIconShown() {
            return this.iconShown;
        }

        public final int getTextRes() {
            return this.textRes;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/SessionSearchController$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "", "SEARCH_DEBOUNCE_MS", "J", "SEARCH_INPUT_TRACK_DELAY_MS", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/SessionSearchController$b;", "", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/widget/EditText;", "input", "Landroid/view/View;", "clearButton", "title", "emptyContainer", "emptyIcon", "Landroid/widget/TextView;", "emptyText", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/widget/EditText;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/widget/TextView;)V", "Landroidx/recyclerview/widget/RecyclerView;", "f", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/widget/EditText;", "e", "()Landroid/widget/EditText;", "Landroid/view/View;", Const.INTENT_KEY_APIKEY, "()Landroid/view/View;", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_PKGNAME, "c", "Landroid/widget/TextView;", Const.INTENT_KEY_UMID, "()Landroid/widget/TextView;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b {
        private final View clearButton;
        private final View emptyContainer;
        private final View emptyIcon;
        private final TextView emptyText;
        private final EditText input;
        private final RecyclerView recyclerView;
        private final View title;

        public b(RecyclerView recyclerView, EditText input, View clearButton, View title, View emptyContainer, View emptyIcon, TextView emptyText) {
            kotlin.jvm.internal.p.i(recyclerView, "recyclerView");
            kotlin.jvm.internal.p.i(input, "input");
            kotlin.jvm.internal.p.i(clearButton, "clearButton");
            kotlin.jvm.internal.p.i(title, "title");
            kotlin.jvm.internal.p.i(emptyContainer, "emptyContainer");
            kotlin.jvm.internal.p.i(emptyIcon, "emptyIcon");
            kotlin.jvm.internal.p.i(emptyText, "emptyText");
            this.recyclerView = recyclerView;
            this.input = input;
            this.clearButton = clearButton;
            this.title = title;
            this.emptyContainer = emptyContainer;
            this.emptyIcon = emptyIcon;
            this.emptyText = emptyText;
        }

        /* renamed from: a, reason: from getter */
        public final View getClearButton() {
            return this.clearButton;
        }

        /* renamed from: b, reason: from getter */
        public final View getEmptyContainer() {
            return this.emptyContainer;
        }

        /* renamed from: c, reason: from getter */
        public final View getEmptyIcon() {
            return this.emptyIcon;
        }

        /* renamed from: d, reason: from getter */
        public final TextView getEmptyText() {
            return this.emptyText;
        }

        /* renamed from: e, reason: from getter */
        public final EditText getInput() {
            return this.input;
        }

        /* renamed from: f, reason: from getter */
        public final RecyclerView getRecyclerView() {
            return this.recyclerView;
        }

        /* renamed from: g, reason: from getter */
        public final View getTitle() {
            return this.title;
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/stepos/ailauncher/chat/controller/SessionSearchController$c", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "LY8/t;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            SessionSearchController sessionSearchController = SessionSearchController.this;
            String string = s10 != null ? s10.toString() : null;
            if (string == null) {
                string = "";
            }
            sessionSearchController.p(string);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/stepos/ailauncher/chat/controller/SessionSearchController$d", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "Landroid/view/MotionEvent;", "e", "", "onInterceptTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)Z", "LY8/t;", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V", "disallowIntercept", "onRequestDisallowInterceptTouchEvent", "(Z)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements RecyclerView.OnItemTouchListener {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e10) {
            kotlin.jvm.internal.p.i(rv, "rv");
            kotlin.jvm.internal.p.i(e10, "e");
            if (e10.getActionMasked() != 0) {
                return false;
            }
            com.stepos.ailauncher.chat.util.t.a(SessionSearchController.this.views.getInput());
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView rv, MotionEvent e10) {
            kotlin.jvm.internal.p.i(rv, "rv");
            kotlin.jvm.internal.p.i(e10, "e");
        }
    }

    public SessionSearchController(b views) {
        kotlin.jvm.internal.p.i(views, "views");
        this.views = views;
        this.keyword = "";
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.searchInputTrackRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.controller.Z0
            @Override // java.lang.Runnable
            public final void run() {
                SessionSearchController.u();
            }
        };
        this.textWatcher = new c();
        this.touchListener = new d();
    }

    public static final Y8.t n(SessionSearchController sessionSearchController, SessionSearchHit hit) {
        kotlin.jvm.internal.p.i(hit, "hit");
        InterfaceC5074l<? super SessionSearchHit, Y8.t> interfaceC5074l = sessionSearchController.onHitClick;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(hit);
        }
        return Y8.t.f7040a;
    }

    public static final void o(SessionSearchController sessionSearchController, View view) {
        Editable text = sessionSearchController.views.getInput().getText();
        if (text != null) {
            text.clear();
        }
    }

    public static final void s(SessionSearchController sessionSearchController) {
        sessionSearchController.views.getRecyclerView().scrollToPosition(0);
    }

    public static final void u() {
        com.stepos.ailauncher.chat.trace.f.INSTANCE.j();
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void b(LifecycleOwner lifecycleOwner) {
        super.b(lifecycleOwner);
    }

    public final void m(LifecycleOwner owner) {
        kotlin.jvm.internal.p.i(owner, "owner");
        if (this.owner != null) {
            return;
        }
        this.owner = owner;
        com.stepos.ailauncher.chat.adapter.X x10 = new com.stepos.ailauncher.chat.adapter.X();
        x10.g(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.a1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SessionSearchController.n(this.f25049a, (SessionSearchHit) obj);
            }
        });
        this.views.getRecyclerView().setLayoutManager(new LinearLayoutManager(this.views.getRecyclerView().getContext()));
        this.views.getRecyclerView().setAdapter(x10);
        this.views.getRecyclerView().addOnItemTouchListener(this.touchListener);
        this.adapter = x10;
        this.views.getInput().addTextChangedListener(this.textWatcher);
        this.views.getClearButton().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.controller.b1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SessionSearchController.o(this.f25055a, view);
            }
        });
        w(EmptyState.GUIDE);
        owner.getLifecycle().a(this);
    }

    @Override // android.view.InterfaceC1387e
    public void onDestroy(LifecycleOwner owner) {
        kotlin.jvm.internal.p.i(owner, "owner");
        q();
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void onPause(LifecycleOwner lifecycleOwner) {
        super.onPause(lifecycleOwner);
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void onResume(LifecycleOwner lifecycleOwner) {
        super.onResume(lifecycleOwner);
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void onStart(LifecycleOwner lifecycleOwner) {
        super.onStart(lifecycleOwner);
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void onStop(LifecycleOwner lifecycleOwner) {
        super.onStop(lifecycleOwner);
    }

    public final void p(String raw) {
        AbstractC1393k abstractC1393kA;
        String string = La.H.D1(raw).toString();
        this.views.getClearButton().setVisibility(raw.length() > 0 ? 0 : 8);
        this.mainHandler.removeCallbacks(this.searchInputTrackRunnable);
        kotlinx.coroutines.g gVar = this.searchJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.keyword = string;
        if (string.length() == 0) {
            com.stepos.ailauncher.chat.adapter.X x10 = this.adapter;
            if (x10 != null) {
                x10.submitList(C1173v.m());
            }
            w(EmptyState.GUIDE);
            return;
        }
        this.mainHandler.postDelayed(this.searchInputTrackRunnable, 1000L);
        LifecycleOwner lifecycleOwner = this.owner;
        if (lifecycleOwner == null || (abstractC1393kA = C1398p.a(lifecycleOwner)) == null) {
            return;
        }
        this.searchJob = C1060i.d(abstractC1393kA, null, null, new SessionSearchController$onInputChanged$1(this, string, null), 3, null);
    }

    public final void q() {
        Lifecycle lifecycle;
        kotlinx.coroutines.g gVar = this.searchJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.searchJob = null;
        this.mainHandler.removeCallbacks(this.searchInputTrackRunnable);
        this.views.getInput().removeTextChangedListener(this.textWatcher);
        this.views.getClearButton().setOnClickListener(null);
        this.views.getRecyclerView().removeOnItemTouchListener(this.touchListener);
        this.views.getRecyclerView().setAdapter(null);
        com.stepos.ailauncher.chat.adapter.X x10 = this.adapter;
        if (x10 != null) {
            x10.g(null);
        }
        this.adapter = null;
        this.onHitClick = null;
        this.cachedAgents = null;
        LifecycleOwner lifecycleOwner = this.owner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.d(this);
        }
        this.owner = null;
    }

    public final void r(List<SessionSearchHit> hits, String keyword) {
        List<SessionSearchHit> list = hits;
        if (list == null || list.isEmpty()) {
            com.stepos.ailauncher.chat.adapter.X x10 = this.adapter;
            if (x10 != null) {
                x10.submitList(C1173v.m());
            }
            w(EmptyState.NO_RESULT);
            if (hits != null) {
                com.stepos.ailauncher.chat.trace.f.INSTANCE.k("no_result", 0);
                return;
            }
            return;
        }
        com.stepos.ailauncher.chat.adapter.X x11 = this.adapter;
        if (x11 == null) {
            return;
        }
        List<SessionSearchHit> list2 = hits;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new X.Row((SessionSearchHit) it.next(), keyword));
        }
        x11.submitList(arrayList, new Runnable() { // from class: com.stepos.ailauncher.chat.controller.Y0
            @Override // java.lang.Runnable
            public final void run() {
                SessionSearchController.s(this.f25045a);
            }
        });
        x();
        com.stepos.ailauncher.chat.trace.f.INSTANCE.k("success", 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(java.lang.String r18, e9.InterfaceC4014c<? super java.util.List<com.stepos.ailauncher.contract.model.search.SessionSearchHit>> r19) throws java.lang.Throwable {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            boolean r2 = r0 instanceof com.stepos.ailauncher.chat.controller.SessionSearchController$search$1
            if (r2 == 0) goto L18
            r2 = r0
            com.stepos.ailauncher.chat.controller.SessionSearchController$search$1 r2 = (com.stepos.ailauncher.chat.controller.SessionSearchController$search$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.label = r3
        L16:
            r6 = r2
            goto L1e
        L18:
            com.stepos.ailauncher.chat.controller.SessionSearchController$search$1 r2 = new com.stepos.ailauncher.chat.controller.SessionSearchController$search$1
            r2.<init>(r1, r0)
            goto L16
        L1e:
            java.lang.Object r0 = r6.result
            java.lang.Object r2 = f9.C4063a.g()
            int r3 = r6.label
            r9 = 2
            r4 = 1
            r10 = 0
            if (r3 == 0) goto L53
            if (r3 == r4) goto L48
            if (r3 != r9) goto L40
            java.lang.Object r1 = r6.L$2
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r2 = r6.L$1
            com.stepos.ailauncher.contract.model.search.UnifiedSearchResult r2 = (com.stepos.ailauncher.contract.model.search.UnifiedSearchResult) r2
            java.lang.Object r2 = r6.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.C4849c.b(r0)
            goto Lbe
        L40:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L48:
            java.lang.Object r3 = r6.L$0
            java.lang.String r3 = (java.lang.String) r3
            kotlin.C4849c.b(r0)     // Catch: java.lang.Throwable -> L50 java.util.concurrent.CancellationException -> Lc5
            goto L79
        L50:
            r0 = move-exception
        L51:
            r13 = r0
            goto L83
        L53:
            kotlin.C4849c.b(r0)
            D5.a r0 = D5.a.INSTANCE     // Catch: java.lang.Throwable -> L7c java.util.concurrent.CancellationException -> Lc5
            java.lang.Class<com.stepos.ailauncher.contract.api.search.IUnifiedSessionSearchService> r3 = com.stepos.ailauncher.contract.api.search.IUnifiedSessionSearchService.class
            java.lang.Object r0 = r0.a(r3)     // Catch: java.lang.Throwable -> L7c java.util.concurrent.CancellationException -> Lc5
            r3 = r0
            com.stepos.ailauncher.contract.api.search.IUnifiedSessionSearchService r3 = (com.stepos.ailauncher.contract.api.search.IUnifiedSessionSearchService) r3     // Catch: java.lang.Throwable -> L7c java.util.concurrent.CancellationException -> Lc5
            if (r3 == 0) goto L80
            java.lang.Object r0 = g9.h.a(r18)     // Catch: java.lang.Throwable -> L7c java.util.concurrent.CancellationException -> Lc5
            r6.L$0 = r0     // Catch: java.lang.Throwable -> L7c java.util.concurrent.CancellationException -> Lc5
            r6.label = r4     // Catch: java.lang.Throwable -> L7c java.util.concurrent.CancellationException -> Lc5
            r5 = 0
            r7 = 2
            r8 = 0
            r4 = r18
            java.lang.Object r0 = com.stepos.ailauncher.contract.api.search.IUnifiedSessionSearchService.search$default(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L7c java.util.concurrent.CancellationException -> Lc5
            if (r0 != r2) goto L77
            goto Lbc
        L77:
            r3 = r18
        L79:
            com.stepos.ailauncher.contract.model.search.UnifiedSearchResult r0 = (com.stepos.ailauncher.contract.model.search.UnifiedSearchResult) r0     // Catch: java.lang.Throwable -> L50 java.util.concurrent.CancellationException -> Lc5
            goto L90
        L7c:
            r0 = move-exception
            r3 = r18
            goto L51
        L80:
            r3 = r18
            goto L8f
        L83:
            r15 = 8
            r16 = 0
            java.lang.String r11 = "SessionSearchController"
            java.lang.String r12 = "Unified session search failed"
            r14 = 0
            h8.C4148a.t(r11, r12, r13, r14, r15, r16)
        L8f:
            r0 = r10
        L90:
            if (r0 != 0) goto L93
            return r10
        L93:
            java.util.List r4 = r0.getSessions()
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto La2
            java.util.List r0 = Z8.C1173v.m()
            return r0
        La2:
            java.util.List r4 = r0.getSessions()
            java.lang.Object r3 = g9.h.a(r3)
            r6.L$0 = r3
            java.lang.Object r0 = g9.h.a(r0)
            r6.L$1 = r0
            r6.L$2 = r4
            r6.label = r9
            java.lang.Object r0 = r1.y(r6)
            if (r0 != r2) goto Lbd
        Lbc:
            return r2
        Lbd:
            r1 = r4
        Lbe:
            java.util.List r0 = (java.util.List) r0
            java.util.List r0 = com.stepos.ailauncher.chat.view.H8.I(r1, r0)
            return r0
        Lc5:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.controller.SessionSearchController.t(java.lang.String, e9.c):java.lang.Object");
    }

    public final void v(InterfaceC5074l<? super SessionSearchHit, Y8.t> interfaceC5074l) {
        this.onHitClick = interfaceC5074l;
    }

    public final void w(EmptyState state) {
        this.views.getTitle().setVisibility(8);
        this.views.getEmptyIcon().setVisibility(!state.getIconShown() ? 4 : 0);
        this.views.getEmptyText().setText(state.getTextRes());
        this.views.getEmptyContainer().setVisibility(0);
        this.views.getRecyclerView().setVisibility(8);
    }

    public final void x() {
        this.views.getTitle().setVisibility(0);
        this.views.getEmptyContainer().setVisibility(8);
        this.views.getRecyclerView().setVisibility(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(e9.InterfaceC4014c<? super java.util.List<com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService.SidebarAgent>> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.ailauncher.chat.controller.SessionSearchController$sidebarAgents$1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.ailauncher.chat.controller.SessionSearchController$sidebarAgents$1 r0 = (com.stepos.ailauncher.chat.controller.SessionSearchController$sidebarAgents$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.controller.SessionSearchController$sidebarAgents$1 r0 = new com.stepos.ailauncher.chat.controller.SessionSearchController$sidebarAgents$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L44
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            java.util.List<com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService$SidebarAgent> r5 = r4.cachedAgents
            if (r5 != 0) goto L48
            com.stepos.ailauncher.chat.view.SidebarDataSource r5 = com.stepos.ailauncher.chat.view.SidebarDataSource.INSTANCE
            r0.label = r3
            r2 = 0
            java.lang.Object r5 = com.stepos.ailauncher.chat.view.SidebarDataSource.d(r5, r2, r0, r3, r2)
            if (r5 != r1) goto L44
            return r1
        L44:
            java.util.List r5 = (java.util.List) r5
            r4.cachedAgents = r5
        L48:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.controller.SessionSearchController.y(e9.c):java.lang.Object");
    }
}
