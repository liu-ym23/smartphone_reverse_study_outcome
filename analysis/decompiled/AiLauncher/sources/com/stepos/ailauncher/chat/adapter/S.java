package com.stepos.ailauncher.chat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.history.DrawerTitleItem;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.adapter.S;
import com.stepos.ailauncher.chat.adapter.f0;
import com.stepos.ailauncher.chat.view.C2887m;
import com.stepos.ailauncher.chat.view.L8;
import com.stepos.ailauncher.chat.view.SidebarAgentItem;
import com.stepos.ailauncher.contract.model.search.SessionActivityState;
import com.stepos.ailauncher.contract.model.search.SidebarSession;
import io.ktor.http.LinkHeader;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v5.C5659a;

@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b*\u0001B\b\u0000\u0018\u0000 J2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0007KLM)NOPB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\nR0\u0010!\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\b\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R0\u0010(\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\b\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&RB\u0010.\u001a\"\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\f\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R*\u00105\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:RB\u0010;\u001a\"\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\b\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010/\u001a\u0004\b<\u00101\"\u0004\b=\u00103R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010>R\u0018\u0010?\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010>R\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR&\u0010G\u001a\u0014\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\b0E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR4\u0010I\u001a\"\u0012\u0004\u0012\u00020,\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\b0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010/¨\u0006Q"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/S;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/stepos/ailauncher/chat/adapter/S$f;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "LY8/t;", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onDetachedFromRecyclerView", "", "active", "n", "(Z)V", "", "position", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "onViewRecycled", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "k", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "onSessionClick", "Lp9/l;", "getOnSessionClick", "()Lp9/l;", "r", "(Lp9/l;)V", "Lcom/stepos/ailauncher/chat/view/s8;", "onAgentClick", Const.INTENT_KEY_BACKGROUND_COMMAND, "o", "Lkotlin/Function4;", "Landroid/view/View;", "", "onAgentLongClick", "Lp9/r;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lp9/r;", "q", "(Lp9/r;)V", "Lkotlin/Function0;", "onAgentExpandToggle", "Lp9/a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lp9/a;", "p", "(Lp9/a;)V", "onSessionLongClick", "getOnSessionLongClick", "s", "Z", "recyclerViewRef", "Landroidx/recyclerview/widget/RecyclerView;", "sessionRowsWarmed", "com/stepos/ailauncher/chat/adapter/S$h", "agentRowCallbacks", "Lcom/stepos/ailauncher/chat/adapter/S$h;", "Lkotlin/Function2;", "", "sessionClickListener", "Lp9/p;", "sessionLongClickListener", "Companion", "f", Const.INTENT_KEY_UMID, "e", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "c", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class S extends ListAdapter<f, RecyclerView.ViewHolder> {

    @Deprecated
    public static final float ARROW_ROTATION_EXPANDED = 180.0f;
    private static final c Companion = new c(null);

    @Deprecated
    public static final int PREWARM_SESSION_ROWS = 8;

    @Deprecated
    public static final int TYPE_AGENT = 1;

    @Deprecated
    public static final int TYPE_AGENT_LIST = 5;

    @Deprecated
    public static final int TYPE_AGENT_TOGGLE = 4;

    @Deprecated
    public static final int TYPE_DIVIDER = 6;

    @Deprecated
    public static final int TYPE_EMPTY = 3;

    @Deprecated
    public static final int TYPE_SECTION = 0;

    @Deprecated
    public static final int TYPE_SESSION = 2;
    private boolean active;
    private final h agentRowCallbacks;
    private InterfaceC5074l<? super SidebarAgentItem, Y8.t> onAgentClick;
    private InterfaceC5063a<Y8.t> onAgentExpandToggle;
    private p9.r<? super View, ? super SidebarAgentItem, ? super Float, ? super Float, Boolean> onAgentLongClick;
    private InterfaceC5074l<? super SidebarSession, Y8.t> onSessionClick;
    private p9.r<? super View, ? super SidebarSession, ? super Float, ? super Float, Y8.t> onSessionLongClick;
    private RecyclerView recyclerViewRef;
    private final p9.p<String, SidebarSession, Y8.t> sessionClickListener;
    private final p9.r<View, SidebarSession, Float, Float, Y8.t> sessionLongClickListener;
    private boolean sessionRowsWarmed;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/S$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/stepos/ailauncher/chat/view/m;", "listView", "<init>", "(Lcom/stepos/ailauncher/chat/adapter/S;Lcom/stepos/ailauncher/chat/view/m;)V", "Lcom/stepos/ailauncher/chat/adapter/S$f$a;", "row", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/chat/adapter/S$f$a;)V", "Lcom/stepos/ailauncher/chat/view/m;", "Lcom/stepos/ailauncher/chat/adapter/a0;", "listAdapter", "Lcom/stepos/ailauncher/chat/adapter/a0;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class a extends RecyclerView.ViewHolder {
        private final a0 listAdapter;
        private final C2887m listView;
        final /* synthetic */ S this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(S s10, C2887m listView) {
            super(listView);
            kotlin.jvm.internal.p.i(listView, "listView");
            this.this$0 = s10;
            this.listView = listView;
            a0 a0Var = new a0(s10.agentRowCallbacks);
            this.listAdapter = a0Var;
            listView.setLayoutManager(new LinearLayoutManager(listView.getContext(), 1, false));
            listView.setAdapter(a0Var);
            listView.setHasFixedSize(true);
        }

        public final void a(f.AgentList row) {
            kotlin.jvm.internal.p.i(row, "row");
            b0 b0Var = b0.INSTANCE;
            Context context = this.listView.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            int iC = b0Var.c(context, row.getVisibleRowCount());
            ViewGroup.LayoutParams layoutParams = this.listView.getLayoutParams();
            if (layoutParams.height != iC) {
                layoutParams.height = iC;
                this.listView.setLayoutParams(layoutParams);
            }
            this.listAdapter.submitList(row.b());
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/S$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/stepos/ailauncher/chat/adapter/S;Landroid/view/View;)V", "", "expanded", "LY8/t;", "c", "(Z)V", "Landroid/widget/TextView;", "label", "Landroid/widget/TextView;", "Landroid/widget/ImageView;", "arrow", "Landroid/widget/ImageView;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class b extends RecyclerView.ViewHolder {
        private final ImageView arrow;
        private final TextView label;
        final /* synthetic */ S this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(final S s10, View itemView) {
            super(itemView);
            kotlin.jvm.internal.p.i(itemView, "itemView");
            this.this$0 = s10;
            View viewFindViewById = itemView.findViewById(R$id.tv_agent_toggle);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            this.label = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R$id.iv_agent_toggle_arrow);
            kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
            this.arrow = (ImageView) viewFindViewById2;
            itemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.T
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    S.b.b(s10, view);
                }
            });
        }

        public static final void b(S s10, View view) {
            InterfaceC5063a<Y8.t> interfaceC5063aH = s10.h();
            if (interfaceC5063aH != null) {
                interfaceC5063aH.invoke();
            }
        }

        public final void c(boolean expanded) {
            this.label.setText(expanded ? R$string.sidebar_agent_collapse : R$string.sidebar_agent_expand);
            this.arrow.setRotation(expanded ? 180.0f : 0.0f);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\u00138\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/S$c;", "", "<init>", "()V", "Landroid/view/ViewGroup;", "parent", "Lcom/stepos/ailauncher/chat/view/m;", Const.INTENT_KEY_APIKEY, "(Landroid/view/ViewGroup;)Lcom/stepos/ailauncher/chat/view/m;", "", "TYPE_SECTION", "I", "TYPE_AGENT", "TYPE_SESSION", "TYPE_EMPTY", "TYPE_AGENT_TOGGLE", "TYPE_AGENT_LIST", "TYPE_DIVIDER", "PREWARM_SESSION_ROWS", "", "ARROW_ROTATION_EXPANDED", "F", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c {
        public /* synthetic */ c(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final C2887m a(ViewGroup parent) {
            kotlin.jvm.internal.p.i(parent, "parent");
            Context context = parent.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            C2887m c2887m = new C2887m(context, null, 0, 6, null);
            C5659a c5659a = C5659a.INSTANCE;
            Context context2 = c2887m.getContext();
            kotlin.jvm.internal.p.h(context2, "getContext(...)");
            int iA = c5659a.a(context2, 16);
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
            layoutParams.setMarginStart(iA);
            layoutParams.setMarginEnd(iA);
            c2887m.setLayoutParams(layoutParams);
            return c2887m;
        }

        public c() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/S$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(View itemView) {
            super(itemView);
            kotlin.jvm.internal.p.i(itemView, "itemView");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/S$e;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(View itemView) {
            super(itemView);
            kotlin.jvm.internal.p.i(itemView, "itemView");
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0007\u0006\u0007\b\u0003\t\n\u000bR\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0007\f\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/S$f;", "", "", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "stableId", "f", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_COMMAND, "e", "Lcom/stepos/ailauncher/chat/adapter/S$f$a;", "Lcom/stepos/ailauncher/chat/adapter/S$f$b;", "Lcom/stepos/ailauncher/chat/adapter/S$f$c;", "Lcom/stepos/ailauncher/chat/adapter/S$f$d;", "Lcom/stepos/ailauncher/chat/adapter/S$f$e;", "Lcom/stepos/ailauncher/chat/adapter/S$f$f;", "Lcom/stepos/ailauncher/chat/adapter/S$f$g;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface f {

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\rR\u0014\u0010\u0019\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/S$f$a;", "Lcom/stepos/ailauncher/chat/adapter/S$f;", "", "Lcom/stepos/ailauncher/chat/adapter/S$f$b;", "rows", "", "visibleRowCount", "<init>", "(Ljava/util/List;I)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "I", "c", Const.INTENT_KEY_APIKEY, "stableId", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.adapter.S$f$a, reason: from toString */
        public static final /* data */ class AgentList implements f {
            private final List<AgentRow> rows;
            private final int visibleRowCount;

            public AgentList(List<AgentRow> rows, int i10) {
                kotlin.jvm.internal.p.i(rows, "rows");
                this.rows = rows;
                this.visibleRowCount = i10;
            }

            @Override // com.stepos.ailauncher.chat.adapter.S.f
            public String a() {
                return "agent_list";
            }

            public final List<AgentRow> b() {
                return this.rows;
            }

            /* renamed from: c, reason: from getter */
            public final int getVisibleRowCount() {
                return this.visibleRowCount;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AgentList)) {
                    return false;
                }
                AgentList agentList = (AgentList) other;
                return kotlin.jvm.internal.p.d(this.rows, agentList.rows) && this.visibleRowCount == agentList.visibleRowCount;
            }

            public int hashCode() {
                return (this.rows.hashCode() * 31) + Integer.hashCode(this.visibleRowCount);
            }

            public String toString() {
                return "AgentList(rows=" + this.rows + ", visibleRowCount=" + this.visibleRowCount + ")";
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/S$f$b;", "Lcom/stepos/ailauncher/chat/adapter/S$f;", "Lcom/stepos/ailauncher/chat/view/s8;", "agent", "", "selected", "uninstalling", "<init>", "(Lcom/stepos/ailauncher/chat/view/s8;ZZ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/chat/view/s8;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/chat/view/s8;", "Z", "c", "()Z", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "stableId", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.adapter.S$f$b, reason: from toString */
        public static final /* data */ class AgentRow implements f {
            private final SidebarAgentItem agent;
            private final boolean selected;
            private final boolean uninstalling;

            public AgentRow(SidebarAgentItem agent, boolean z10, boolean z11) {
                kotlin.jvm.internal.p.i(agent, "agent");
                this.agent = agent;
                this.selected = z10;
                this.uninstalling = z11;
            }

            @Override // com.stepos.ailauncher.chat.adapter.S.f
            public String a() {
                return "agent:" + this.agent.j();
            }

            /* renamed from: b, reason: from getter */
            public final SidebarAgentItem getAgent() {
                return this.agent;
            }

            /* renamed from: c, reason: from getter */
            public final boolean getSelected() {
                return this.selected;
            }

            /* renamed from: d, reason: from getter */
            public final boolean getUninstalling() {
                return this.uninstalling;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AgentRow)) {
                    return false;
                }
                AgentRow agentRow = (AgentRow) other;
                return kotlin.jvm.internal.p.d(this.agent, agentRow.agent) && this.selected == agentRow.selected && this.uninstalling == agentRow.uninstalling;
            }

            public int hashCode() {
                return (((this.agent.hashCode() * 31) + Boolean.hashCode(this.selected)) * 31) + Boolean.hashCode(this.uninstalling);
            }

            public String toString() {
                return "AgentRow(agent=" + this.agent + ", selected=" + this.selected + ", uninstalling=" + this.uninstalling + ")";
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/S$f$c;", "Lcom/stepos/ailauncher/chat/adapter/S$f;", "", "expanded", "<init>", "(Z)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", Const.INTENT_KEY_PKGNAME, "()Z", Const.INTENT_KEY_APIKEY, "stableId", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.adapter.S$f$c, reason: from toString */
        public static final /* data */ class AgentToggle implements f {
            private final boolean expanded;

            public AgentToggle(boolean z10) {
                this.expanded = z10;
            }

            @Override // com.stepos.ailauncher.chat.adapter.S.f
            public String a() {
                return "agent_toggle";
            }

            /* renamed from: b, reason: from getter */
            public final boolean getExpanded() {
                return this.expanded;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof AgentToggle) && this.expanded == ((AgentToggle) other).expanded;
            }

            public int hashCode() {
                return Boolean.hashCode(this.expanded);
            }

            public String toString() {
                return "AgentToggle(expanded=" + this.expanded + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/S$f$d;", "Lcom/stepos/ailauncher/chat/adapter/S$f;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "stableId", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class d implements f {
            public static final d INSTANCE = new d();

            @Override // com.stepos.ailauncher.chat.adapter.S.f
            public String a() {
                return "divider";
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof d);
            }

            public int hashCode() {
                return 1782061371;
            }

            public String toString() {
                return "Divider";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/S$f$e;", "Lcom/stepos/ailauncher/chat/adapter/S$f;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "stableId", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class e implements f {
            public static final e INSTANCE = new e();

            @Override // com.stepos.ailauncher.chat.adapter.S.f
            public String a() {
                return "empty";
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof e);
            }

            public int hashCode() {
                return -966939665;
            }

            public String toString() {
                return "Empty";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0013\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/S$f$f;", "Lcom/stepos/ailauncher/chat/adapter/S$f;", "", "title", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "stableId", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.adapter.S$f$f, reason: collision with other inner class name and from toString */
        public static final /* data */ class SectionLabel implements f {
            private final String title;

            public SectionLabel(String title) {
                kotlin.jvm.internal.p.i(title, "title");
                this.title = title;
            }

            @Override // com.stepos.ailauncher.chat.adapter.S.f
            public String a() {
                return "section:" + this.title;
            }

            /* renamed from: b, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SectionLabel) && kotlin.jvm.internal.p.d(this.title, ((SectionLabel) other).title);
            }

            public int hashCode() {
                return this.title.hashCode();
            }

            public String toString() {
                return "SectionLabel(title=" + this.title + ")";
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/S$f$g;", "Lcom/stepos/ailauncher/chat/adapter/S$f;", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "session", "", "selected", "Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "activityState", "<init>", "(Lcom/stepos/ailauncher/contract/model/search/SidebarSession;ZLcom/stepos/ailauncher/contract/model/search/SessionActivityState;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", Const.INTENT_KEY_UMID, "()Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "Z", "c", "()Z", "Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", Const.INTENT_KEY_APIKEY, "stableId", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.adapter.S$f$g, reason: from toString */
        public static final /* data */ class SessionRow implements f {
            private final SessionActivityState activityState;
            private final boolean selected;
            private final SidebarSession session;

            public SessionRow(SidebarSession session, boolean z10, SessionActivityState sessionActivityState) {
                kotlin.jvm.internal.p.i(session, "session");
                this.session = session;
                this.selected = z10;
                this.activityState = sessionActivityState;
            }

            @Override // com.stepos.ailauncher.chat.adapter.S.f
            public String a() {
                return "session:" + this.session.getSessionId();
            }

            /* renamed from: b, reason: from getter */
            public final SessionActivityState getActivityState() {
                return this.activityState;
            }

            /* renamed from: c, reason: from getter */
            public final boolean getSelected() {
                return this.selected;
            }

            /* renamed from: d, reason: from getter */
            public final SidebarSession getSession() {
                return this.session;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SessionRow)) {
                    return false;
                }
                SessionRow sessionRow = (SessionRow) other;
                return kotlin.jvm.internal.p.d(this.session, sessionRow.session) && this.selected == sessionRow.selected && this.activityState == sessionRow.activityState;
            }

            public int hashCode() {
                int iHashCode = ((this.session.hashCode() * 31) + Boolean.hashCode(this.selected)) * 31;
                SessionActivityState sessionActivityState = this.activityState;
                return iHashCode + (sessionActivityState == null ? 0 : sessionActivityState.hashCode());
            }

            public String toString() {
                return "SessionRow(session=" + this.session + ", selected=" + this.selected + ", activityState=" + this.activityState + ")";
            }
        }

        String a();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/S$g;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "", "text", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g extends RecyclerView.ViewHolder {
        private final TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(View itemView) {
            super(itemView);
            kotlin.jvm.internal.p.i(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(R$id.tv_section_title);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            this.title = (TextView) viewFindViewById;
        }

        public final void a(String text) {
            kotlin.jvm.internal.p.i(text, "text");
            this.title.setText(text);
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/stepos/ailauncher/chat/adapter/S$h", "Lcom/stepos/ailauncher/chat/adapter/f0$a;", "Lcom/stepos/ailauncher/chat/view/s8;", "agent", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/chat/view/s8;)V", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "", "rawX", "rawY", "", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;Lcom/stepos/ailauncher/chat/view/s8;FF)Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class h implements f0.a {
        public h() {
        }

        @Override // com.stepos.ailauncher.chat.adapter.f0.a
        public boolean a(View anchor, SidebarAgentItem agent, float rawX, float rawY) {
            kotlin.jvm.internal.p.i(anchor, "anchor");
            kotlin.jvm.internal.p.i(agent, "agent");
            p9.r<View, SidebarAgentItem, Float, Float, Boolean> rVarI = S.this.i();
            return rVarI != null && rVarI.invoke(anchor, agent, Float.valueOf(rawX), Float.valueOf(rawY)).booleanValue();
        }

        @Override // com.stepos.ailauncher.chat.adapter.f0.a
        public void b(SidebarAgentItem agent) {
            kotlin.jvm.internal.p.i(agent, "agent");
            InterfaceC5074l<SidebarAgentItem, Y8.t> interfaceC5074lG = S.this.g();
            if (interfaceC5074lG != null) {
                interfaceC5074lG.invoke(agent);
            }
        }
    }

    public S() {
        super(new g0());
        this.agentRowCallbacks = new h();
        this.sessionClickListener = new p9.p() { // from class: com.stepos.ailauncher.chat.adapter.P
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return S.l(this.f24921a, (String) obj, (SidebarSession) obj2);
            }
        };
        this.sessionLongClickListener = new p9.r() { // from class: com.stepos.ailauncher.chat.adapter.Q
            @Override // p9.r
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return S.m(this.f24922a, (View) obj, (SidebarSession) obj2, ((Float) obj3).floatValue(), ((Float) obj4).floatValue());
            }
        };
    }

    public static final void j(S s10, RecyclerView recyclerView) {
        s10.k(recyclerView);
    }

    public static final Y8.t l(S s10, String mode, SidebarSession session) {
        InterfaceC5074l<? super SidebarSession, Y8.t> interfaceC5074l;
        kotlin.jvm.internal.p.i(mode, "mode");
        kotlin.jvm.internal.p.i(session, "session");
        if (kotlin.jvm.internal.p.d(mode, "normal") && (interfaceC5074l = s10.onSessionClick) != null) {
            interfaceC5074l.invoke(session);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t m(S s10, View anchor, SidebarSession sidebarSession, float f10, float f11) {
        p9.r<? super View, ? super SidebarSession, ? super Float, ? super Float, Y8.t> rVar;
        kotlin.jvm.internal.p.i(anchor, "anchor");
        if (sidebarSession != null && (rVar = s10.onSessionLongClick) != null) {
            rVar.invoke(anchor, sidebarSession, Float.valueOf(f10), Float.valueOf(f11));
        }
        return Y8.t.f7040a;
    }

    public final InterfaceC5074l<SidebarAgentItem, Y8.t> g() {
        return this.onAgentClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        f item = getItem(position);
        if (item instanceof f.SectionLabel) {
            return 0;
        }
        if (item instanceof f.AgentRow) {
            return 1;
        }
        if (item instanceof f.AgentToggle) {
            return 4;
        }
        if (item instanceof f.AgentList) {
            return 5;
        }
        if (item instanceof f.d) {
            return 6;
        }
        if (item instanceof f.SessionRow) {
            return 2;
        }
        if (item instanceof f.e) {
            return 3;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final InterfaceC5063a<Y8.t> h() {
        return this.onAgentExpandToggle;
    }

    public final p9.r<View, SidebarAgentItem, Float, Float, Boolean> i() {
        return this.onAgentLongClick;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.recyclerview.widget.RecyclerView$ViewHolder] */
    public final void k(RecyclerView recyclerView) {
        if (this.sessionRowsWarmed || recyclerView.getAdapter() != this) {
            return;
        }
        this.sessionRowsWarmed = true;
        RecyclerView.RecycledViewPool recycledViewPool = recyclerView.getRecycledViewPool();
        kotlin.jvm.internal.p.h(recycledViewPool, "getRecycledViewPool(...)");
        recycledViewPool.setMaxRecycledViews(2, 8);
        for (int i10 = 0; i10 < 8; i10++) {
            recycledViewPool.putRecycledView(createViewHolder(recyclerView, 2));
        }
    }

    public final void n(boolean active) {
        if (this.active == active) {
            return;
        }
        this.active = active;
        RecyclerView recyclerView = this.recyclerViewRef;
        if (recyclerView == null) {
            return;
        }
        int childCount = recyclerView.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i10));
            if (childViewHolder instanceof E) {
                ((E) childViewHolder).k(active);
            }
        }
    }

    public final void o(InterfaceC5074l<? super SidebarAgentItem, Y8.t> interfaceC5074l) {
        this.onAgentClick = interfaceC5074l;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        kotlin.jvm.internal.p.i(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerViewRef = recyclerView;
        this.sessionRowsWarmed = false;
        recyclerView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.adapter.O
            @Override // java.lang.Runnable
            public final void run() {
                S.j(this.f24919a, recyclerView);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        f item = getItem(position);
        if (item instanceof f.SectionLabel) {
            ((g) holder).a(((f.SectionLabel) item).getTitle());
            return;
        }
        if (item instanceof f.AgentRow) {
            ((f0) holder).g((f.AgentRow) item);
            return;
        }
        if (item instanceof f.AgentToggle) {
            ((b) holder).c(((f.AgentToggle) item).getExpanded());
            return;
        }
        if (item instanceof f.AgentList) {
            ((a) holder).a((f.AgentList) item);
            return;
        }
        if (item instanceof f.d) {
            return;
        }
        if (!(item instanceof f.SessionRow)) {
            if (!(item instanceof f.e)) {
                throw new NoWhenBranchMatchedException();
            }
            return;
        }
        E e10 = (E) holder;
        e10.k(this.active);
        f.SessionRow sessionRow = (f.SessionRow) item;
        E.e(e10, new DrawerTitleItem(0, sessionRow.getSession().getTitle(), L8.a(sessionRow.getSession().getSessionKind()), sessionRow.getSession(), sessionRow.getSelected(), this.sessionClickListener), sessionRow.getActivityState(), false, 4, null);
        e10.l(this.sessionLongClickListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case 0:
                View viewInflate = layoutInflaterFrom.inflate(R$layout.item_session_center_section, parent, false);
                kotlin.jvm.internal.p.h(viewInflate, "inflate(...)");
                return new g(viewInflate);
            case 1:
                return f0.INSTANCE.a(parent, this.agentRowCallbacks, true);
            case 2:
                View viewInflate2 = layoutInflaterFrom.inflate(R$layout.item_drawer_title_normal, parent, false);
                kotlin.jvm.internal.p.h(viewInflate2, "inflate(...)");
                return new E(viewInflate2, true);
            case 3:
                View viewInflate3 = layoutInflaterFrom.inflate(R$layout.item_session_center_empty, parent, false);
                kotlin.jvm.internal.p.h(viewInflate3, "inflate(...)");
                return new e(viewInflate3);
            case 4:
                View viewInflate4 = layoutInflaterFrom.inflate(R$layout.item_session_center_agent_toggle, parent, false);
                kotlin.jvm.internal.p.h(viewInflate4, "inflate(...)");
                return new b(this, viewInflate4);
            case 5:
                return new a(this, Companion.a(parent));
            case 6:
                View viewInflate5 = layoutInflaterFrom.inflate(R$layout.item_session_center_divider, parent, false);
                kotlin.jvm.internal.p.h(viewInflate5, "inflate(...)");
                return new d(viewInflate5);
            default:
                throw new IllegalArgumentException("Unknown view type: " + viewType);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        kotlin.jvm.internal.p.i(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        if (this.recyclerViewRef == recyclerView) {
            this.recyclerViewRef = null;
        }
        this.sessionRowsWarmed = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        kotlin.jvm.internal.p.i(holder, "holder");
        if (holder instanceof E) {
            ((E) holder).k(false);
        } else if (holder instanceof f0) {
            ((f0) holder).h();
        }
    }

    public final void p(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onAgentExpandToggle = interfaceC5063a;
    }

    public final void q(p9.r<? super View, ? super SidebarAgentItem, ? super Float, ? super Float, Boolean> rVar) {
        this.onAgentLongClick = rVar;
    }

    public final void r(InterfaceC5074l<? super SidebarSession, Y8.t> interfaceC5074l) {
        this.onSessionClick = interfaceC5074l;
    }

    public final void s(p9.r<? super View, ? super SidebarSession, ? super Float, ? super Float, Y8.t> rVar) {
        this.onSessionLongClick = rVar;
    }
}
