package com.stepos.ailauncher.chat.adapter;

import L4.AgentPlace;
import L4.b;
import L4.l;
import Z8.C1173v;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.history.DrawerTitleItem;
import com.stepos.agentsprite.view.AgentView;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.adapter.ChatHistoryAdapter;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.AgentDevicesScrollView;
import com.stepos.ailauncher.chat.view.IndeterminateSpinnerView;
import com.stepos.ailauncher.chat.view.SidebarAgentItem;
import com.stepos.ailauncher.contract.model.search.SessionActivityState;
import com.stepos.ailauncher.contract.model.search.SidebarSession;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u0000 Q2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006RSTUVWB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J#\u0010\u0017\u001a\u00020\b2\u0014\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\u000eJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010$\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001bH\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001bH\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u0002H\u0016¢\u0006\u0004\b)\u0010*R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100RB\u00104\u001a\"\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\b\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R*\u0010;\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R0\u0010B\u001a\u0010\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\b\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010\u0018R*\u0010G\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010<\u001a\u0004\bH\u0010>\"\u0004\bI\u0010@R6\u0010K\u001a\u0016\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\b\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006X"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "", "Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item;", "newItems", "LY8/t;", "m", "(Ljava/util/List;)V", "", "active", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Z)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onDetachedFromRecyclerView", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "isTarget", "n", "(Lp9/l;)V", "expanded", "f", "", "getItemCount", "()I", "position", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "onViewRecycled", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", DidiCardProvider.KEY_ITEMS, "Ljava/util/List;", "recyclerViewRef", "Landroidx/recyclerview/widget/RecyclerView;", "drawerContentActive", "Z", "Lkotlin/Function4;", "Landroid/view/View;", "", "onItemLongClickListener", "Lp9/r;", "getOnItemLongClickListener", "()Lp9/r;", "l", "(Lp9/r;)V", "Lkotlin/Function0;", "onAddAgentClicked", "Lp9/a;", "getOnAddAgentClicked", "()Lp9/a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lp9/a;)V", "Lcom/stepos/ailauncher/chat/view/s8;", "onAgentClicked", "Lp9/l;", "getOnAgentClicked", "()Lp9/l;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "onAgentExpandToggle", "getOnAgentExpandToggle", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Lkotlin/Function2;", "onAgentLongClickBind", "Lp9/p;", "getOnAgentLongClickBind", "()Lp9/p;", "k", "(Lp9/p;)V", "Companion", "Item", "c", "e", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int AGENT_ROW_HEIGHT_DP = 44;
    private static final int AGENT_ROW_MARGIN_TOP_DP = 4;
    public static final int COLLAPSED_AGENT_COUNT = 3;
    public static final int EXPANDED_AGENT_COUNT = 8;
    private static final int TYPE_AGENT_HEADER = 0;
    private static final int TYPE_EMPTY = 4;
    private static final int TYPE_HISTORY_SECTION_HEADER = 1;
    private static final int TYPE_SESSION = 3;
    private static final int TYPE_TIME_HEADER = 2;
    private boolean drawerContentActive;
    private List<? extends Item> items = C1173v.m();
    private InterfaceC5063a<Y8.t> onAddAgentClicked;
    private InterfaceC5074l<? super SidebarAgentItem, Y8.t> onAgentClicked;
    private InterfaceC5063a<Y8.t> onAgentExpandToggle;
    private p9.p<? super View, ? super SidebarAgentItem, Y8.t> onAgentLongClickBind;
    private p9.r<? super View, ? super SidebarSession, ? super Float, ? super Float, Y8.t> onItemLongClickListener;
    private RecyclerView recyclerViewRef;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<Integer> SECTION_VIEW_TYPES = Z8.Y.j(1, 2, 3);

    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005Jg\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012JG\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00152\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019JY\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010*R\u0014\u0010/\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010*R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u00069"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item$AgentHeader;", "item", "Lkotlin/Function0;", "LY8/t;", "onAddAgentClicked", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/chat/view/s8;", "onAgentClicked", "onExpandToggle", "Lkotlin/Function2;", "onAgentLongClickBind", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item$AgentHeader;Lp9/a;Lp9/l;Lp9/a;Lp9/p;)V", "f", "(Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item$AgentHeader;Lp9/l;Lp9/p;)V", "", "r", "(Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item$AgentHeader;)Ljava/util/List;", "l", "(Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item$AgentHeader;)V", "Landroid/view/LayoutInflater;", "inflater", "agent", "m", "(Landroid/view/LayoutInflater;Lcom/stepos/ailauncher/chat/view/s8;Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item$AgentHeader;Lp9/l;Lp9/p;)Landroid/view/View;", "", "rowCount", "o", "(I)V", "q", "(I)I", "", "cap", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Z)V", "scrollView", "Landroid/view/View;", "Landroid/widget/LinearLayout;", "container", "Landroid/widget/LinearLayout;", "btnAgentAdd", "btnAgentExpand", "Landroid/widget/TextView;", "tvAgentToggle", "Landroid/widget/TextView;", "Landroid/widget/ImageView;", "ivAgentToggleArrow", "Landroid/widget/ImageView;", "Ljava/lang/Runnable;", "refineLockHeightRunnable", "Ljava/lang/Runnable;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends RecyclerView.ViewHolder {
        private final View btnAgentAdd;
        private final View btnAgentExpand;
        private final LinearLayout container;
        private final ImageView ivAgentToggleArrow;
        private final Runnable refineLockHeightRunnable;
        private final View scrollView;
        private final TextView tvAgentToggle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            kotlin.jvm.internal.p.i(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(R$id.sv_agent_devices);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            this.scrollView = viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R$id.ll_agent_devices);
            kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
            this.container = (LinearLayout) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R$id.btn_agent_add);
            kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
            this.btnAgentAdd = viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(R$id.btn_agent_expand);
            kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
            this.btnAgentExpand = viewFindViewById4;
            View viewFindViewById5 = itemView.findViewById(R$id.tv_agent_toggle);
            kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
            this.tvAgentToggle = (TextView) viewFindViewById5;
            View viewFindViewById6 = itemView.findViewById(R$id.iv_agent_toggle_arrow);
            kotlin.jvm.internal.p.h(viewFindViewById6, "findViewById(...)");
            this.ivAgentToggleArrow = (ImageView) viewFindViewById6;
            this.refineLockHeightRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.adapter.o
                @Override // java.lang.Runnable
                public final void run() {
                    ChatHistoryAdapter.a.p(this.f24961a);
                }
            };
        }

        public static final void i(InterfaceC5063a interfaceC5063a, View view) {
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
        }

        public static final void j(InterfaceC5063a interfaceC5063a, View view) {
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
        }

        public static final void k(a aVar) {
            aVar.itemView.setMinimumHeight(0);
        }

        public static final void n(InterfaceC5074l interfaceC5074l, SidebarAgentItem sidebarAgentItem, View view) {
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(sidebarAgentItem);
            }
        }

        public static final void p(a aVar) {
            ViewGroup.LayoutParams layoutParams = aVar.scrollView.getLayoutParams();
            int iQ = aVar.q(8);
            if (iQ <= 0 || layoutParams.height == iQ) {
                return;
            }
            layoutParams.height = iQ;
            aVar.scrollView.setLayoutParams(layoutParams);
        }

        public final void f(Item.AgentHeader item, InterfaceC5074l<? super SidebarAgentItem, Y8.t> onAgentClicked, p9.p<? super View, ? super SidebarAgentItem, Y8.t> onAgentLongClickBind) {
            Item.AgentHeader item2 = item;
            kotlin.jvm.internal.p.i(item2, "item");
            List<SidebarAgentItem> agents = item2.getAgents();
            int size = r(item).size();
            int childCount = this.container.getChildCount();
            int i10 = 0;
            boolean z10 = item2.getExpanded() && size > 8;
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.itemView.getContext());
            if (childCount == 0 && size > 0) {
                int iMin = Math.min(size, 8);
                while (i10 < iMin) {
                    LinearLayout linearLayout = this.container;
                    kotlin.jvm.internal.p.f(layoutInflaterFrom);
                    linearLayout.addView(m(layoutInflaterFrom, agents.get(i10), item2, onAgentClicked, onAgentLongClickBind));
                    i10++;
                    item2 = item;
                }
                if (z10) {
                    o(8);
                    while (iMin < size) {
                        LinearLayout linearLayout2 = this.container;
                        kotlin.jvm.internal.p.f(layoutInflaterFrom);
                        linearLayout2.addView(m(layoutInflaterFrom, agents.get(iMin), item, onAgentClicked, onAgentLongClickBind));
                        iMin++;
                    }
                }
            } else if (size > childCount) {
                int iMin2 = Math.min(size, 8);
                for (int i11 = childCount; i11 < iMin2; i11++) {
                    LinearLayout linearLayout3 = this.container;
                    kotlin.jvm.internal.p.f(layoutInflaterFrom);
                    linearLayout3.addView(m(layoutInflaterFrom, agents.get(i11), item, onAgentClicked, onAgentLongClickBind));
                }
                if (z10) {
                    o(8);
                    for (int iMax = Math.max(childCount, iMin2); iMax < size; iMax++) {
                        LinearLayout linearLayout4 = this.container;
                        kotlin.jvm.internal.p.f(layoutInflaterFrom);
                        linearLayout4.addView(m(layoutInflaterFrom, agents.get(iMax), item, onAgentClicked, onAgentLongClickBind));
                    }
                } else {
                    g(false);
                }
            } else if (size < childCount) {
                this.container.removeViews(size, childCount - size);
                g(false);
                View view = this.scrollView;
                AgentDevicesScrollView agentDevicesScrollView = view instanceof AgentDevicesScrollView ? (AgentDevicesScrollView) view : null;
                if (agentDevicesScrollView != null) {
                    agentDevicesScrollView.scrollTo(0, 0);
                }
                this.itemView.requestLayout();
            } else {
                g(z10);
            }
            l(item);
        }

        public final void g(boolean cap) {
            if (cap) {
                o(8);
                return;
            }
            this.scrollView.removeCallbacks(this.refineLockHeightRunnable);
            ViewGroup.LayoutParams layoutParams = this.scrollView.getLayoutParams();
            if (layoutParams.height != -2) {
                layoutParams.height = -2;
                this.scrollView.setLayoutParams(layoutParams);
            }
        }

        public final void h(Item.AgentHeader item, final InterfaceC5063a<Y8.t> onAddAgentClicked, InterfaceC5074l<? super SidebarAgentItem, Y8.t> onAgentClicked, final InterfaceC5063a<Y8.t> onExpandToggle, p9.p<? super View, ? super SidebarAgentItem, Y8.t> onAgentLongClickBind) {
            kotlin.jvm.internal.p.i(item, "item");
            this.btnAgentAdd.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChatHistoryAdapter.a.i(onAddAgentClicked, view);
                }
            });
            this.btnAgentExpand.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChatHistoryAdapter.a.j(onExpandToggle, view);
                }
            });
            List<SidebarAgentItem> listR = r(item);
            int height = this.itemView.getHeight();
            if (height > 0) {
                this.itemView.setMinimumHeight(height);
            }
            this.container.removeAllViews();
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.itemView.getContext());
            boolean z10 = item.getExpanded() && listR.size() > 8;
            int iMin = Math.min(listR.size(), 8);
            for (int i10 = 0; i10 < iMin; i10++) {
                LinearLayout linearLayout = this.container;
                kotlin.jvm.internal.p.f(layoutInflaterFrom);
                linearLayout.addView(m(layoutInflaterFrom, listR.get(i10), item, onAgentClicked, onAgentLongClickBind));
            }
            if (z10) {
                o(8);
                int size = listR.size();
                while (iMin < size) {
                    LinearLayout linearLayout2 = this.container;
                    kotlin.jvm.internal.p.f(layoutInflaterFrom);
                    linearLayout2.addView(m(layoutInflaterFrom, listR.get(iMin), item, onAgentClicked, onAgentLongClickBind));
                    iMin++;
                }
            } else {
                g(false);
            }
            l(item);
            if (height > 0) {
                this.itemView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.adapter.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        ChatHistoryAdapter.a.k(this.f24968a);
                    }
                });
            }
        }

        public final void l(Item.AgentHeader item) {
            this.btnAgentExpand.setVisibility(item.getAgents().size() > 3 ? 0 : 8);
            this.tvAgentToggle.setText(item.getExpanded() ? R$string.sidebar_agent_collapse : R$string.sidebar_agent_expand);
            this.ivAgentToggleArrow.setRotation(item.getExpanded() ? 180.0f : 0.0f);
        }

        public final View m(LayoutInflater inflater, final SidebarAgentItem agent, Item.AgentHeader item, final InterfaceC5074l<? super SidebarAgentItem, Y8.t> onAgentClicked, p9.p<? super View, ? super SidebarAgentItem, Y8.t> onAgentLongClickBind) {
            View viewInflate = inflater.inflate(R$layout.item_chat_history_agent_device, (ViewGroup) this.container, false);
            TextView textView = (TextView) viewInflate.findViewById(R$id.tv_device_name);
            if (textView != null) {
                textView.setText(agent.getDisplayName());
            }
            boolean z10 = !La.H.x0(agent.getAssetId()) && item.getUninstalling().contains(agent.getAssetId());
            IndeterminateSpinnerView indeterminateSpinnerView = (IndeterminateSpinnerView) viewInflate.findViewById(R$id.spinner_agent_uninstalling);
            if (z10) {
                if (indeterminateSpinnerView != null) {
                    indeterminateSpinnerView.setColor(-1711276033);
                    indeterminateSpinnerView.setVisibility(0);
                }
                TextView textView2 = (TextView) viewInflate.findViewById(R$id.tv_last_message_time);
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                View viewFindViewById = viewInflate.findViewById(R$id.divider_agent_offline);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(8);
                }
                TextView textView3 = (TextView) viewInflate.findViewById(R$id.tv_agent_offline);
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                viewInflate.setAlpha(0.4f);
                viewInflate.setClickable(false);
                viewInflate.setSelected(false);
                kotlin.jvm.internal.p.f(viewInflate);
                return viewInflate;
            }
            if (indeterminateSpinnerView != null) {
                indeterminateSpinnerView.setVisibility(8);
            }
            viewInflate.setAlpha(1.0f);
            viewInflate.setClickable(true);
            TextView textView4 = (TextView) viewInflate.findViewById(R$id.tv_last_message_time);
            if (textView4 != null) {
                com.stepos.ailauncher.chat.util.s sVar = com.stepos.ailauncher.chat.util.s.INSTANCE;
                Context context = viewInflate.getContext();
                kotlin.jvm.internal.p.h(context, "getContext(...)");
                textView4.setText(com.stepos.ailauncher.chat.util.s.c(sVar, context, agent.g(), 0L, 4, null));
                textView4.setVisibility(agent.g() > 0 ? 0 : 8);
            }
            boolean z11 = (agent.getIsPrimary() || agent.getOnline()) ? false : true;
            View viewFindViewById2 = viewInflate.findViewById(R$id.divider_agent_offline);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(z11 ? 0 : 8);
            }
            TextView textView5 = (TextView) viewInflate.findViewById(R$id.tv_agent_offline);
            if (textView5 != null) {
                textView5.setVisibility(z11 ? 0 : 8);
            }
            viewInflate.setSelected(kotlin.jvm.internal.p.d(item.getHighlight(), agent));
            viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChatHistoryAdapter.a.n(onAgentClicked, agent, view);
                }
            });
            if (!agent.getIsPrimary() && onAgentLongClickBind != null) {
                kotlin.jvm.internal.p.f(viewInflate);
                onAgentLongClickBind.invoke(viewInflate, agent);
            }
            kotlin.jvm.internal.p.f(viewInflate);
            return viewInflate;
        }

        public final void o(int rowCount) {
            this.scrollView.removeCallbacks(this.refineLockHeightRunnable);
            ViewGroup.LayoutParams layoutParams = this.scrollView.getLayoutParams();
            int iQ = q(rowCount);
            if (iQ > 0 && layoutParams.height != iQ) {
                layoutParams.height = iQ;
                this.scrollView.setLayoutParams(layoutParams);
            }
            View childAt = this.container.getChildAt(rowCount - 1);
            if (childAt == null || childAt.getBottom() <= 0) {
                this.scrollView.post(this.refineLockHeightRunnable);
            }
        }

        public final int q(int rowCount) {
            View childAt = this.container.getChildAt(rowCount - 1);
            if (childAt != null && childAt.getBottom() > 0) {
                return childAt.getBottom() + this.container.getPaddingBottom();
            }
            return this.container.getPaddingTop() + (((int) (48 * this.itemView.getResources().getDisplayMetrics().density)) * rowCount) + this.container.getPaddingBottom();
        }

        public final List<SidebarAgentItem> r(Item.AgentHeader item) {
            List<SidebarAgentItem> agents = item.getAgents();
            return (item.getExpanded() || agents.size() <= 3) ? agents : Z8.F.f1(agents, 3);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$b;", "", "<init>", "()V", "", "", "SECTION_VIEW_TYPES", "Ljava/util/Set;", Const.INTENT_KEY_APIKEY, "()Ljava/util/Set;", "TYPE_AGENT_HEADER", "I", "TYPE_HISTORY_SECTION_HEADER", "TYPE_TIME_HEADER", "TYPE_SESSION", "TYPE_EMPTY", "AGENT_ROW_HEIGHT_DP", "AGENT_ROW_MARGIN_TOP_DP", "COLLAPSED_AGENT_COUNT", "EXPANDED_AGENT_COUNT", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.adapter.ChatHistoryAdapter$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final Set<Integer> a() {
            return ChatHistoryAdapter.SECTION_VIEW_TYPES;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0012R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$c;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item;", "oldList", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "", "getOldListSize", "()I", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "(II)Z", "areContentsTheSame", "Ljava/util/List;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends DiffUtil.Callback {
        private final List<Item> newList;
        private final List<Item> oldList;

        /* JADX WARN: Multi-variable type inference failed */
        public c(List<? extends Item> oldList, List<? extends Item> newList) {
            kotlin.jvm.internal.p.i(oldList, "oldList");
            kotlin.jvm.internal.p.i(newList, "newList");
            this.oldList = oldList;
            this.newList = newList;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return kotlin.jvm.internal.p.d(this.oldList.get(oldItemPosition), this.newList.get(newItemPosition));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            Item item = this.oldList.get(oldItemPosition);
            Item item2 = this.newList.get(newItemPosition);
            if ((item instanceof Item.AgentHeader) && (item2 instanceof Item.AgentHeader)) {
                return true;
            }
            if ((item instanceof Item.HistorySectionHeader) && (item2 instanceof Item.HistorySectionHeader)) {
                return true;
            }
            if ((item instanceof Item.TimeHeader) && (item2 instanceof Item.TimeHeader)) {
                return kotlin.jvm.internal.p.d(((Item.TimeHeader) item).getTitle(), ((Item.TimeHeader) item2).getTitle());
            }
            if (!(item instanceof Item.HistoryRow) || !(item2 instanceof Item.HistoryRow)) {
                return (item instanceof Item.Empty) && (item2 instanceof Item.Empty);
            }
            SidebarSession sidebarSessionB = ((Item.HistoryRow) item).getDrawerItem().b();
            String sessionId = sidebarSessionB != null ? sidebarSessionB.getSessionId() : null;
            if (sessionId != null) {
                SidebarSession sidebarSessionB2 = ((Item.HistoryRow) item2).getDrawerItem().b();
                if (kotlin.jvm.internal.p.d(sessionId, sidebarSessionB2 != null ? sidebarSessionB2.getSessionId() : null)) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.newList.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.oldList.size();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/agentsprite/view/AgentView;", "sprite", "Lcom/stepos/agentsprite/view/AgentView;", "", "bound", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends RecyclerView.ViewHolder {
        private boolean bound;
        private final AgentView sprite;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(View itemView) {
            super(itemView);
            kotlin.jvm.internal.p.i(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(R$id.agent_empty_sprite);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            this.sprite = (AgentView) viewFindViewById;
        }

        public final void a() {
            L4.b bVarC;
            if (this.bound) {
                return;
            }
            Context context = this.itemView.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            LifecycleOwner lifecycleOwnerA = com.stepos.ailauncher.chat.view.A.a(context);
            if (lifecycleOwnerA == null || (bVarC = N4.a.c(lifecycleOwnerA, this.itemView.getContext(), null, null, null, null, null, 62, null)) == null) {
                return;
            }
            b.a.a(bVarC.a(AgentPlace.b.INSTANCE), l.C0072l.INSTANCE, 0L, 0, 6, null);
            AgentView.t(this.sprite, bVarC, null, 2, null);
            this.bound = true;
        }

        public final void b() {
            if (this.bound) {
                this.sprite.c0();
                this.bound = false;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$e;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(View itemView) {
            super(itemView);
            kotlin.jvm.internal.p.i(itemView, "itemView");
        }
    }

    public static final Y8.t e(ChatHistoryAdapter chatHistoryAdapter, View view, SidebarSession sidebarSession, float f10, float f11) {
        p9.r<? super View, ? super SidebarSession, ? super Float, ? super Float, Y8.t> rVar;
        kotlin.jvm.internal.p.i(view, "view");
        if (sidebarSession != null && (rVar = chatHistoryAdapter.onItemLongClickListener) != null) {
            rVar.invoke(view, sidebarSession, Float.valueOf(f10), Float.valueOf(f11));
        }
        return Y8.t.f7040a;
    }

    public final void f(boolean expanded) {
        Iterator<? extends Item> it = this.items.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            } else if (it.next() instanceof Item.AgentHeader) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 < 0) {
            return;
        }
        Item item = this.items.get(i10);
        kotlin.jvm.internal.p.g(item, "null cannot be cast to non-null type com.stepos.ailauncher.chat.adapter.ChatHistoryAdapter.Item.AgentHeader");
        Item.AgentHeader agentHeader = (Item.AgentHeader) item;
        if (agentHeader.getExpanded() == expanded) {
            return;
        }
        Item.AgentHeader agentHeaderCopy$default = Item.AgentHeader.copy$default(agentHeader, null, expanded, null, null, 0L, 29, null);
        List<? extends Item> listP1 = Z8.F.p1(this.items);
        listP1.set(i10, agentHeaderCopy$default);
        this.items = listP1;
        RecyclerView recyclerView = this.recyclerViewRef;
        if (recyclerView == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return;
        }
        recyclerView.stopScroll();
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i10);
        a aVar = viewHolderFindViewHolderForAdapterPosition instanceof a ? (a) viewHolderFindViewHolderForAdapterPosition : null;
        if (aVar == null) {
            linearLayoutManager.scrollToPositionWithOffset(0, 0);
            return;
        }
        recyclerView.suppressLayout(true);
        try {
            aVar.f(agentHeaderCopy$default, this.onAgentClicked, this.onAgentLongClickBind);
            linearLayoutManager.scrollToPositionWithOffset(0, 0);
        } finally {
            recyclerView.suppressLayout(false);
        }
    }

    public final void g(boolean active) {
        if (this.drawerContentActive == active) {
            return;
        }
        this.drawerContentActive = active;
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

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        Item item = this.items.get(position);
        if (item instanceof Item.AgentHeader) {
            return 0;
        }
        if (item instanceof Item.HistorySectionHeader) {
            return 1;
        }
        if (item instanceof Item.TimeHeader) {
            return 2;
        }
        if (item instanceof Item.HistoryRow) {
            return 3;
        }
        if (item instanceof Item.Empty) {
            return 4;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void h(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onAddAgentClicked = interfaceC5063a;
    }

    public final void i(InterfaceC5074l<? super SidebarAgentItem, Y8.t> interfaceC5074l) {
        this.onAgentClicked = interfaceC5074l;
    }

    public final void j(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onAgentExpandToggle = interfaceC5063a;
    }

    public final void k(p9.p<? super View, ? super SidebarAgentItem, Y8.t> pVar) {
        this.onAgentLongClickBind = pVar;
    }

    public final void l(p9.r<? super View, ? super SidebarSession, ? super Float, ? super Float, Y8.t> rVar) {
        this.onItemLongClickListener = rVar;
    }

    public final void m(List<? extends Item> newItems) {
        kotlin.jvm.internal.p.i(newItems, "newItems");
        if (kotlin.jvm.internal.p.d(this.items, newItems)) {
            return;
        }
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new c(this.items, newItems));
        kotlin.jvm.internal.p.h(diffResultCalculateDiff, "calculateDiff(...)");
        this.items = newItems;
        diffResultCalculateDiff.dispatchUpdatesTo(this);
    }

    public final void n(InterfaceC5074l<? super SidebarSession, Boolean> isTarget) {
        kotlin.jvm.internal.p.i(isTarget, "isTarget");
        int i10 = 0;
        for (Object obj : this.items) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            Item item = (Item) obj;
            if (item instanceof Item.HistoryRow) {
                Item.HistoryRow historyRow = (Item.HistoryRow) item;
                boolean zBooleanValue = isTarget.invoke(historyRow.getDrawerItem().b()).booleanValue();
                if (historyRow.getDrawerItem().getIsSelected() != zBooleanValue) {
                    historyRow.getDrawerItem().g(zBooleanValue);
                    notifyItemChanged(i10);
                }
            }
            i10 = i11;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        kotlin.jvm.internal.p.i(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerViewRef = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        Item item = this.items.get(position);
        if (item instanceof Item.AgentHeader) {
            ((a) holder).h((Item.AgentHeader) item, this.onAddAgentClicked, this.onAgentClicked, this.onAgentExpandToggle, this.onAgentLongClickBind);
            return;
        }
        if (item instanceof Item.HistorySectionHeader) {
            return;
        }
        if (item instanceof Item.TimeHeader) {
            ((F) holder).a(((Item.TimeHeader) item).getTitle());
            return;
        }
        if (!(item instanceof Item.HistoryRow)) {
            if (!(item instanceof Item.Empty)) {
                throw new NoWhenBranchMatchedException();
            }
            ((d) holder).a();
        } else {
            E e10 = (E) holder;
            e10.k(this.drawerContentActive);
            Item.HistoryRow historyRow = (Item.HistoryRow) item;
            e10.d(historyRow.getDrawerItem(), historyRow.getActivityState(), historyRow.isLast());
            e10.l(new p9.r() { // from class: com.stepos.ailauncher.chat.adapter.n
                @Override // p9.r
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return ChatHistoryAdapter.e(this.f24958a, (View) obj, (SidebarSession) obj2, ((Float) obj3).floatValue(), ((Float) obj4).floatValue());
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType == 0) {
            View viewInflate = layoutInflaterFrom.inflate(R$layout.item_chat_history_agent_header, parent, false);
            kotlin.jvm.internal.p.h(viewInflate, "inflate(...)");
            return new a(viewInflate);
        }
        if (viewType == 1) {
            View viewInflate2 = layoutInflaterFrom.inflate(R$layout.item_chat_history_section_header, parent, false);
            kotlin.jvm.internal.p.h(viewInflate2, "inflate(...)");
            return new e(viewInflate2);
        }
        if (viewType == 2) {
            View viewInflate3 = layoutInflaterFrom.inflate(R$layout.item_drawer_title_time, parent, false);
            kotlin.jvm.internal.p.h(viewInflate3, "inflate(...)");
            return new F(viewInflate3);
        }
        if (viewType == 3) {
            View viewInflate4 = layoutInflaterFrom.inflate(R$layout.item_drawer_title_normal, parent, false);
            kotlin.jvm.internal.p.h(viewInflate4, "inflate(...)");
            return new E(viewInflate4, false, 2, null);
        }
        if (viewType == 4) {
            View viewInflate5 = layoutInflaterFrom.inflate(R$layout.item_chat_history_empty, parent, false);
            kotlin.jvm.internal.p.h(viewInflate5, "inflate(...)");
            return new d(viewInflate5);
        }
        throw new IllegalArgumentException("Unknown view type: " + viewType);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        kotlin.jvm.internal.p.i(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        int childCount = recyclerView.getChildCount();
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i10));
            E e10 = childViewHolder instanceof E ? (E) childViewHolder : null;
            if (e10 != null) {
                e10.j();
            }
            i10++;
        }
        if (this.recyclerViewRef == recyclerView) {
            this.recyclerViewRef = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        kotlin.jvm.internal.p.i(holder, "holder");
        if (holder instanceof d) {
            ((d) holder).b();
        }
        if (holder instanceof E) {
            ((E) holder).j();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item;", "", "AgentHeader", "HistorySectionHeader", "TimeHeader", "HistoryRow", "Empty", "Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item$AgentHeader;", "Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item$Empty;", "Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item$HistoryRow;", "Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item$HistorySectionHeader;", "Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item$TimeHeader;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Item {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item$Empty;", "Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item;", "<init>", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Empty implements Item {
            public static final Empty INSTANCE = new Empty();

            private Empty() {
            }
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J6\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001e\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b\u0006\u0010\u000eR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b!\u0010\u0010¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item$HistoryRow;", "Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item;", "Lcom/stepos/agentframework/chatui/history/g;", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "drawerItem", "", "isLast", "Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "activityState", "<init>", "(Lcom/stepos/agentframework/chatui/history/g;ZLcom/stepos/ailauncher/contract/model/search/SessionActivityState;)V", "component1", "()Lcom/stepos/agentframework/chatui/history/g;", "component2", "()Z", "component3", "()Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", ChatTracker.CLICK_COPY, "(Lcom/stepos/agentframework/chatui/history/g;ZLcom/stepos/ailauncher/contract/model/search/SessionActivityState;)Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item$HistoryRow;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/agentframework/chatui/history/g;", "getDrawerItem", "Z", "Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "getActivityState", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class HistoryRow implements Item {
            private final SessionActivityState activityState;
            private final DrawerTitleItem<SidebarSession> drawerItem;
            private final boolean isLast;

            public HistoryRow(DrawerTitleItem<SidebarSession> drawerItem, boolean z10, SessionActivityState sessionActivityState) {
                kotlin.jvm.internal.p.i(drawerItem, "drawerItem");
                this.drawerItem = drawerItem;
                this.isLast = z10;
                this.activityState = sessionActivityState;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ HistoryRow copy$default(HistoryRow historyRow, DrawerTitleItem drawerTitleItem, boolean z10, SessionActivityState sessionActivityState, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    drawerTitleItem = historyRow.drawerItem;
                }
                if ((i10 & 2) != 0) {
                    z10 = historyRow.isLast;
                }
                if ((i10 & 4) != 0) {
                    sessionActivityState = historyRow.activityState;
                }
                return historyRow.copy(drawerTitleItem, z10, sessionActivityState);
            }

            public final DrawerTitleItem<SidebarSession> component1() {
                return this.drawerItem;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsLast() {
                return this.isLast;
            }

            /* renamed from: component3, reason: from getter */
            public final SessionActivityState getActivityState() {
                return this.activityState;
            }

            public final HistoryRow copy(DrawerTitleItem<SidebarSession> drawerItem, boolean isLast, SessionActivityState activityState) {
                kotlin.jvm.internal.p.i(drawerItem, "drawerItem");
                return new HistoryRow(drawerItem, isLast, activityState);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HistoryRow)) {
                    return false;
                }
                HistoryRow historyRow = (HistoryRow) other;
                return kotlin.jvm.internal.p.d(this.drawerItem, historyRow.drawerItem) && this.isLast == historyRow.isLast && this.activityState == historyRow.activityState;
            }

            public final SessionActivityState getActivityState() {
                return this.activityState;
            }

            public final DrawerTitleItem<SidebarSession> getDrawerItem() {
                return this.drawerItem;
            }

            public int hashCode() {
                int iHashCode = ((this.drawerItem.hashCode() * 31) + Boolean.hashCode(this.isLast)) * 31;
                SessionActivityState sessionActivityState = this.activityState;
                return iHashCode + (sessionActivityState == null ? 0 : sessionActivityState.hashCode());
            }

            public final boolean isLast() {
                return this.isLast;
            }

            public String toString() {
                return "HistoryRow(drawerItem=" + this.drawerItem + ", isLast=" + this.isLast + ", activityState=" + this.activityState + ")";
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item$HistorySectionHeader;", "Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item;", "<init>", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class HistorySectionHeader implements Item {
            public static final HistorySectionHeader INSTANCE = new HistorySectionHeader();

            private HistorySectionHeader() {
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item$TimeHeader;", "Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item;", "title", "", "<init>", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "component1", ChatTracker.CLICK_COPY, "equals", "", "other", "", "hashCode", "", "toString", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TimeHeader implements Item {
            private final String title;

            public TimeHeader(String title) {
                kotlin.jvm.internal.p.i(title, "title");
                this.title = title;
            }

            public static /* synthetic */ TimeHeader copy$default(TimeHeader timeHeader, String str, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = timeHeader.title;
                }
                return timeHeader.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            public final TimeHeader copy(String title) {
                kotlin.jvm.internal.p.i(title, "title");
                return new TimeHeader(title);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof TimeHeader) && kotlin.jvm.internal.p.d(this.title, ((TimeHeader) other).title);
            }

            public final String getTitle() {
                return this.title;
            }

            public int hashCode() {
                return this.title.hashCode();
            }

            public String toString() {
                return "TimeHeader(title=" + this.title + ")";
            }
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018JP\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010$\u001a\u0004\b%\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010&\u001a\u0004\b'\u0010\u0012R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0007\u0010(\u001a\u0004\b)\u0010\u0014R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010*\u001a\u0004\b+\u0010\u0016R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010,\u001a\u0004\b-\u0010\u0018¨\u0006."}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item$AgentHeader;", "Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item;", "", "Lcom/stepos/ailauncher/chat/view/s8;", "agents", "", "expanded", "highlight", "", "", "uninstalling", "", "timeBucket", "<init>", "(Ljava/util/List;ZLcom/stepos/ailauncher/chat/view/s8;Ljava/util/Set;J)V", "component1", "()Ljava/util/List;", "component2", "()Z", "component3", "()Lcom/stepos/ailauncher/chat/view/s8;", "component4", "()Ljava/util/Set;", "component5", "()J", ChatTracker.CLICK_COPY, "(Ljava/util/List;ZLcom/stepos/ailauncher/chat/view/s8;Ljava/util/Set;J)Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item$AgentHeader;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getAgents", "Z", "getExpanded", "Lcom/stepos/ailauncher/chat/view/s8;", "getHighlight", "Ljava/util/Set;", "getUninstalling", "J", "getTimeBucket", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AgentHeader implements Item {
            private final List<SidebarAgentItem> agents;
            private final boolean expanded;
            private final SidebarAgentItem highlight;
            private final long timeBucket;
            private final Set<String> uninstalling;

            public AgentHeader(List<SidebarAgentItem> agents, boolean z10, SidebarAgentItem sidebarAgentItem, Set<String> uninstalling, long j10) {
                kotlin.jvm.internal.p.i(agents, "agents");
                kotlin.jvm.internal.p.i(uninstalling, "uninstalling");
                this.agents = agents;
                this.expanded = z10;
                this.highlight = sidebarAgentItem;
                this.uninstalling = uninstalling;
                this.timeBucket = j10;
            }

            public static /* synthetic */ AgentHeader copy$default(AgentHeader agentHeader, List list, boolean z10, SidebarAgentItem sidebarAgentItem, Set set, long j10, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    list = agentHeader.agents;
                }
                if ((i10 & 2) != 0) {
                    z10 = agentHeader.expanded;
                }
                if ((i10 & 4) != 0) {
                    sidebarAgentItem = agentHeader.highlight;
                }
                if ((i10 & 8) != 0) {
                    set = agentHeader.uninstalling;
                }
                if ((i10 & 16) != 0) {
                    j10 = agentHeader.timeBucket;
                }
                long j11 = j10;
                return agentHeader.copy(list, z10, sidebarAgentItem, set, j11);
            }

            public final List<SidebarAgentItem> component1() {
                return this.agents;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getExpanded() {
                return this.expanded;
            }

            /* renamed from: component3, reason: from getter */
            public final SidebarAgentItem getHighlight() {
                return this.highlight;
            }

            public final Set<String> component4() {
                return this.uninstalling;
            }

            /* renamed from: component5, reason: from getter */
            public final long getTimeBucket() {
                return this.timeBucket;
            }

            public final AgentHeader copy(List<SidebarAgentItem> agents, boolean expanded, SidebarAgentItem highlight, Set<String> uninstalling, long timeBucket) {
                kotlin.jvm.internal.p.i(agents, "agents");
                kotlin.jvm.internal.p.i(uninstalling, "uninstalling");
                return new AgentHeader(agents, expanded, highlight, uninstalling, timeBucket);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AgentHeader)) {
                    return false;
                }
                AgentHeader agentHeader = (AgentHeader) other;
                return kotlin.jvm.internal.p.d(this.agents, agentHeader.agents) && this.expanded == agentHeader.expanded && kotlin.jvm.internal.p.d(this.highlight, agentHeader.highlight) && kotlin.jvm.internal.p.d(this.uninstalling, agentHeader.uninstalling) && this.timeBucket == agentHeader.timeBucket;
            }

            public final List<SidebarAgentItem> getAgents() {
                return this.agents;
            }

            public final boolean getExpanded() {
                return this.expanded;
            }

            public final SidebarAgentItem getHighlight() {
                return this.highlight;
            }

            public final long getTimeBucket() {
                return this.timeBucket;
            }

            public final Set<String> getUninstalling() {
                return this.uninstalling;
            }

            public int hashCode() {
                int iHashCode = ((this.agents.hashCode() * 31) + Boolean.hashCode(this.expanded)) * 31;
                SidebarAgentItem sidebarAgentItem = this.highlight;
                return ((((iHashCode + (sidebarAgentItem == null ? 0 : sidebarAgentItem.hashCode())) * 31) + this.uninstalling.hashCode()) * 31) + Long.hashCode(this.timeBucket);
            }

            public String toString() {
                return "AgentHeader(agents=" + this.agents + ", expanded=" + this.expanded + ", highlight=" + this.highlight + ", uninstalling=" + this.uninstalling + ", timeBucket=" + this.timeBucket + ")";
            }

            public /* synthetic */ AgentHeader(List list, boolean z10, SidebarAgentItem sidebarAgentItem, Set set, long j10, int i10, kotlin.jvm.internal.i iVar) {
                this(list, z10, sidebarAgentItem, (i10 & 8) != 0 ? Z8.Y.e() : set, j10);
            }
        }
    }
}
