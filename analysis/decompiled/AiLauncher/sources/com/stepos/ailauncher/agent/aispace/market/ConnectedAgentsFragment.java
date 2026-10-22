package com.stepos.ailauncher.agent.aispace.market;

import Ua.C1060i;
import Z8.C1173v;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.C1398p;
import android.view.LayoutInflater;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.R$layout;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.AgentTabView;
import com.stepos.ailauncher.agent.aispace.market.ConnectedAgentsFragment;
import com.stepos.ailauncher.chat.fragment.V1;
import com.stepos.ailauncher.chat.view.C2765a9;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.chat.view.C2796d7;
import com.stepos.ailauncher.chat.view.PagedListController;
import com.stepos.ailauncher.chat.view.T9;
import com.stepos.ailauncher.contract.model.MarketAgentBrief;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.sheet.R$id;
import h9.InterfaceC4149a;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import y7.G;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 C2\u00020\u0001:\u0003DEFB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0003J#\u0010\u0016\u001a\u00020\b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u000fJ\u0013\u0010!\u001a\u00020 *\u00020\u0018H\u0002¢\u0006\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u0018028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b3\u00104R\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u0018058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00108\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010=\u001a\u00020:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0014\u0010?\u001a\u00020:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010<R\u0014\u0010B\u001a\u00020#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006G"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/ConnectedAgentsFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "onDestroyView", "P", "()Landroid/view/View;", ExifInterface.LONGITUDE_WEST, "O", "", "", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;", "statusMap", "M", "(Ljava/util/Map;)V", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", "item", LinkHeader.Parameters.Anchor, "f0", "(Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;Landroid/view/View;)V", "N", "e0", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;", "h0", "(Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;)Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;", "LY4/s;", "_binding", "LY4/s;", "", "savedContentPadding", "[I", "Lcom/stepos/ailauncher/agent/aispace/market/ConnectedAgentsFragment$PageMode;", "pageMode$delegate", "LY8/h;", "U", "()Lcom/stepos/ailauncher/agent/aispace/market/ConnectedAgentsFragment$PageMode;", "pageMode", "Lcom/stepos/ailauncher/agent/aispace/market/ConnectedAgentsFragment$b;", "myAgentAdapter", "Lcom/stepos/ailauncher/agent/aispace/market/ConnectedAgentsFragment$b;", "Lcom/stepos/ailauncher/chat/view/PagedListController;", "pages", "Lcom/stepos/ailauncher/chat/view/PagedListController;", "", "allMarketItems", "Ljava/util/List;", "marketSection", "Landroid/view/View;", "", "e", "()Z", "extendsContentToBottomEdge", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "showsSheetDragHandle", ExifInterface.GPS_DIRECTION_TRUE, "()LY4/s;", "binding", "Companion", "PageMode", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConnectedAgentsFragment extends com.stepos.ailauncher.sheet.nav.a {
    private static final String ARG_MODE = "mode";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String MODE_EXTERNAL = "external";
    private static final String MODE_MY = "my";
    public static final String TAG = "connected_agents";
    private static final String TAG_EXTERNAL = "external_agents";
    private Y4.s _binding;
    private List<AgentMarketItem> allMarketItems;
    private View marketSection;
    private final b myAgentAdapter;

    /* renamed from: pageMode$delegate, reason: from kotlin metadata */
    private final Y8.h pageMode;
    private PagedListController<AgentMarketItem> pages;
    private int[] savedContentPadding;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/ConnectedAgentsFragment$PageMode;", "", "<init>", "(Ljava/lang/String;I)V", "MY_AGENT", "EXTERNAL_AGENT", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PageMode {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ PageMode[] $VALUES;
        public static final PageMode MY_AGENT = new PageMode("MY_AGENT", 0);
        public static final PageMode EXTERNAL_AGENT = new PageMode("EXTERNAL_AGENT", 1);

        private static final /* synthetic */ PageMode[] $values() {
            return new PageMode[]{MY_AGENT, EXTERNAL_AGENT};
        }

        static {
            PageMode[] pageModeArr$values = $values();
            $VALUES = pageModeArr$values;
            $ENTRIES = kotlin.enums.a.a(pageModeArr$values);
        }

        private PageMode(String str, int i10) {
        }

        public static InterfaceC4149a<PageMode> getEntries() {
            return $ENTRIES;
        }

        public static PageMode valueOf(String str) {
            return (PageMode) Enum.valueOf(PageMode.class, str);
        }

        public static PageMode[] values() {
            return (PageMode[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/ConnectedAgentsFragment$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/agent/aispace/market/ConnectedAgentsFragment;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/agent/aispace/market/ConnectedAgentsFragment;", Const.INTENT_KEY_APIKEY, "", "TAG", "Ljava/lang/String;", "TAG_EXTERNAL", "ARG_MODE", "MODE_MY", "MODE_EXTERNAL", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.ConnectedAgentsFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final ConnectedAgentsFragment a() {
            ConnectedAgentsFragment connectedAgentsFragment = new ConnectedAgentsFragment();
            Bundle bundle = new Bundle();
            bundle.putString(ConnectedAgentsFragment.ARG_MODE, ConnectedAgentsFragment.MODE_EXTERNAL);
            connectedAgentsFragment.setArguments(bundle);
            return connectedAgentsFragment;
        }

        public final ConnectedAgentsFragment b() {
            ConnectedAgentsFragment connectedAgentsFragment = new ConnectedAgentsFragment();
            Bundle bundle = new Bundle();
            bundle.putString(ConnectedAgentsFragment.ARG_MODE, ConnectedAgentsFragment.MODE_MY);
            connectedAgentsFragment.setArguments(bundle);
            return connectedAgentsFragment;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0004\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001!B5\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001a\u001a\u00020\u00052\n\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001cR&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001dR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/ConnectedAgentsFragment$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/agent/aispace/market/ConnectedAgentsFragment$b$a;", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", "LY8/t;", "onMarketClick", "Lkotlin/Function2;", "Landroid/view/View;", "onMarketMore", "<init>", "(Lp9/l;Lp9/p;)V", "", "list", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/List;)V", "", "getItemCount", "()I", "Landroid/view/ViewGroup;", "parent", "viewType", "f", "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/agent/aispace/market/ConnectedAgentsFragment$b$a;", "holder", "position", "e", "(Lcom/stepos/ailauncher/agent/aispace/market/ConnectedAgentsFragment$b$a;I)V", "Lp9/l;", "Lp9/p;", "", DidiCardProvider.KEY_ITEMS, "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends RecyclerView.Adapter<a> {
        private final List<AgentMarketItem> items;
        private final InterfaceC5074l<AgentMarketItem, Y8.t> onMarketClick;
        private final p9.p<AgentMarketItem, View, Y8.t> onMarketMore;

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/ConnectedAgentsFragment$b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "LY4/A;", Const.INTENT_KEY_PKGNAME, "<init>", "(Lcom/stepos/ailauncher/agent/aispace/market/ConnectedAgentsFragment$b;LY4/A;)V", "", AMapLocationStaticsEntity.FIRST_LOCATE, "last", "LY8/t;", "c", "(ZZ)V", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", "item", "e", "(Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;ZZ)V", "LY4/A;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public final class a extends RecyclerView.ViewHolder {
            private final Y4.A b;
            final /* synthetic */ b this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, Y4.A b10) {
                super(b10.b());
                kotlin.jvm.internal.p.i(b10, "b");
                this.this$0 = bVar;
                this.b = b10;
            }

            private final void c(boolean first, boolean last) {
                float f10 = this.b.b().getResources().getDisplayMetrics().density;
                this.b.b().setPaddingRelative(d(f10, 16), first ? d(f10, 16) : d(f10, 12), d(f10, 16), last ? d(f10, 16) : d(f10, 12));
            }

            public static final int d(float f10, int i10) {
                return (int) (i10 * f10);
            }

            public static final void f(b bVar, AgentMarketItem agentMarketItem, View view) {
                bVar.onMarketClick.invoke(agentMarketItem);
            }

            public static final void g(b bVar, AgentMarketItem agentMarketItem, a aVar, View view) {
                p9.p pVar = bVar.onMarketMore;
                ImageButton btnMore = aVar.b.btnMore;
                kotlin.jvm.internal.p.h(btnMore, "btnMore");
                pVar.invoke(agentMarketItem, btnMore);
            }

            public final void e(final AgentMarketItem item, boolean first, boolean last) {
                kotlin.jvm.internal.p.i(item, "item");
                c(first, last);
                this.b.tvAgentIconChar.setText(item.getIconChar());
                ImageView ivAgentIcon = this.b.ivAgentIcon;
                kotlin.jvm.internal.p.h(ivAgentIcon, "ivAgentIcon");
                TextView tvAgentIconChar = this.b.tvAgentIconChar;
                kotlin.jvm.internal.p.h(tvAgentIconChar, "tvAgentIconChar");
                C2765a9.a(ivAgentIcon, tvAgentIconChar, item.getIconUrl());
                this.b.tvTitle.setText(item.getDisplayName());
                this.b.tvDescription.setText(item.getDescription());
                LinearLayout linearLayoutB = this.b.b();
                final b bVar = this.this$0;
                linearLayoutB.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.Q0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ConnectedAgentsFragment.b.a.f(bVar, item, view);
                    }
                });
                this.b.btnMore.setColorFilter(-2130706433, PorterDuff.Mode.SRC_IN);
                ImageButton imageButton = this.b.btnMore;
                final b bVar2 = this.this$0;
                imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.R0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ConnectedAgentsFragment.b.a.g(bVar2, item, this, view);
                    }
                });
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(InterfaceC5074l<? super AgentMarketItem, Y8.t> onMarketClick, p9.p<? super AgentMarketItem, ? super View, Y8.t> onMarketMore) {
            kotlin.jvm.internal.p.i(onMarketClick, "onMarketClick");
            kotlin.jvm.internal.p.i(onMarketMore, "onMarketMore");
            this.onMarketClick = onMarketClick;
            this.onMarketMore = onMarketMore;
            this.items = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a holder, int position) {
            kotlin.jvm.internal.p.i(holder, "holder");
            holder.e(this.items.get(position), position == 0, position == C1173v.o(this.items));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(ViewGroup parent, int viewType) {
            kotlin.jvm.internal.p.i(parent, "parent");
            Y4.A aC = Y4.A.c(LayoutInflater.from(parent.getContext()), parent, false);
            kotlin.jvm.internal.p.h(aC, "inflate(...)");
            return new a(this, aC);
        }

        public final void g(List<AgentMarketItem> list) {
            kotlin.jvm.internal.p.i(list, "list");
            this.items.clear();
            this.items.addAll(list);
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.items.size();
        }
    }

    public ConnectedAgentsFragment() {
        super(R$layout.fragment_connected_agents);
        this.pageMode = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.market.J0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ConnectedAgentsFragment.d0(this.f24151a);
            }
        });
        this.myAgentAdapter = new b(new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.market.K0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ConnectedAgentsFragment.X(this.f24154a, (AgentMarketItem) obj);
            }
        }, new p9.p() { // from class: com.stepos.ailauncher.agent.aispace.market.L0
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ConnectedAgentsFragment.Y(this.f24157a, (AgentMarketItem) obj, (View) obj2);
            }
        });
        this.allMarketItems = C1173v.m();
    }

    public static final void Q(ConnectedAgentsFragment connectedAgentsFragment, View view) {
        com.stepos.ailauncher.sheet.nav.a.z(connectedAgentsFragment, INSTANCE.a(), TAG_EXTERNAL, null, null, null, 28, null);
    }

    public static final String R(AgentMarketItem it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getAssetId();
    }

    public static final Y8.t S(ConnectedAgentsFragment connectedAgentsFragment, C2796d7 state) {
        kotlin.jvm.internal.p.i(state, "state");
        connectedAgentsFragment.allMarketItems = state.f();
        connectedAgentsFragment.M(AgentMarketOperaManager.INSTANCE.w().getValue());
        return Y8.t.f7040a;
    }

    public static final Y8.t X(ConnectedAgentsFragment connectedAgentsFragment, AgentMarketItem it) {
        kotlin.jvm.internal.p.i(it, "it");
        com.stepos.ailauncher.sheet.nav.a.z(connectedAgentsFragment, AgentMarketDetailFragment.INSTANCE.a(connectedAgentsFragment.h0(it)), AgentMarketDetailFragment.TAG, null, null, null, 28, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t Y(ConnectedAgentsFragment connectedAgentsFragment, AgentMarketItem item, View anchor) {
        kotlin.jvm.internal.p.i(item, "item");
        kotlin.jvm.internal.p.i(anchor, "anchor");
        connectedAgentsFragment.f0(item, anchor);
        return Y8.t.f7040a;
    }

    public static final void Z(ConnectedAgentsFragment connectedAgentsFragment, View view) {
        if (connectedAgentsFragment.x()) {
            return;
        }
        connectedAgentsFragment.o();
    }

    public static final void a0(ConnectedAgentsFragment connectedAgentsFragment) {
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        View topChromeBlur = connectedAgentsFragment.T().topChromeBlur;
        kotlin.jvm.internal.p.h(topChromeBlur, "topChromeBlur");
        com.stepos.ailauncher.container.glass.h.v(hVar, topChromeBlur, false, G.a.f43886a.g(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.market.M0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ConnectedAgentsFragment.b0((A7.B) obj);
            }
        }, 2, null);
    }

    public static final Y8.t b0(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    public static final void c0(ConnectedAgentsFragment connectedAgentsFragment, View view) {
        com.stepos.ailauncher.sheet.nav.a.z(connectedAgentsFragment, V1.INSTANCE.a(), V1.TAG, null, null, null, 28, null);
    }

    public static final PageMode d0(ConnectedAgentsFragment connectedAgentsFragment) {
        return kotlin.jvm.internal.p.d(connectedAgentsFragment.requireArguments().getString(ARG_MODE), MODE_EXTERNAL) ? PageMode.EXTERNAL_AGENT : PageMode.MY_AGENT;
    }

    public static final Y8.t g0(AgentMarketItem agentMarketItem) {
        AgentMarketOperaManager.INSTANCE.U(agentMarketItem);
        return Y8.t.f7040a;
    }

    public final void M(Map<String, ? extends AgentMarketStatus> statusMap) {
        List<AgentMarketItem> list = this.allMarketItems;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            AgentMarketItem agentMarketItem = (AgentMarketItem) obj;
            AgentMarketStatus initialStatus = statusMap.get(agentMarketItem.getAssetId());
            if (initialStatus == null) {
                initialStatus = agentMarketItem.getInitialStatus();
            }
            if (initialStatus.isInstalled()) {
                arrayList.add(obj);
            }
        }
        this.myAgentAdapter.g(arrayList);
        View view = this.marketSection;
        if (view != null) {
            view.setVisibility(arrayList.isEmpty() ? 8 : 0);
        }
    }

    public final void N() {
        View viewFindViewById;
        androidx.fragment.app.r activity = getActivity();
        if (activity == null || (viewFindViewById = activity.findViewById(R$id.ail_content_container)) == null) {
            return;
        }
        if (this.savedContentPadding == null) {
            this.savedContentPadding = new int[]{viewFindViewById.getPaddingLeft(), viewFindViewById.getPaddingTop(), viewFindViewById.getPaddingRight(), viewFindViewById.getPaddingBottom()};
        }
        viewFindViewById.setPadding(0, viewFindViewById.getPaddingTop(), 0, viewFindViewById.getPaddingBottom());
    }

    public final void O() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new ConnectedAgentsFragment$collectMarketStatus$1(this, null), 3, null);
    }

    public final View P() {
        Y4.J jC = Y4.J.c(getLayoutInflater(), T().flContainer, false);
        jC.entryRemoteAgent.b().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.N0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConnectedAgentsFragment.Q(this.f24159a, view);
            }
        });
        jC.rvMyAgentMarket.setLayoutManager(new LinearLayoutManager(requireContext()));
        jC.rvMyAgentMarket.setAdapter(this.myAgentAdapter);
        RecyclerView recyclerView = jC.rvMyAgentMarket;
        Context contextRequireContext = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        recyclerView.addItemDecoration(new com.stepos.ailauncher.agent.aispace.E(contextRequireContext, null, 2, null));
        this.marketSection = jC.rvMyAgentMarket;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        RecyclerView rvMyAgentMarket = jC.rvMyAgentMarket;
        kotlin.jvm.internal.p.h(rvMyAgentMarket, "rvMyAgentMarket");
        this.pages = new PagedListController<>(viewLifecycleOwner, rvMyAgentMarket, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.market.O0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ConnectedAgentsFragment.R((AgentMarketItem) obj);
            }
        }, false, false, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.market.P0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ConnectedAgentsFragment.S(this.f24164a, (C2796d7) obj);
            }
        }, 56, null);
        NestedScrollView nestedScrollViewB = jC.b();
        kotlin.jvm.internal.p.h(nestedScrollViewB, "getRoot(...)");
        return nestedScrollViewB;
    }

    public final Y4.s T() {
        Y4.s sVar = this._binding;
        kotlin.jvm.internal.p.f(sVar);
        return sVar;
    }

    public final PageMode U() {
        return (PageMode) this.pageMode.getValue();
    }

    public final View V() {
        androidx.fragment.app.r activity = getActivity();
        if (activity != null) {
            return activity.findViewById(R$id.ail_settle_hint);
        }
        return null;
    }

    public final void W() {
        PagedListController<AgentMarketItem> pagedListController;
        PagedListController<AgentMarketItem> pagedListController2 = this.pages;
        if (pagedListController2 == null) {
            kotlin.jvm.internal.p.A("pages");
            pagedListController = null;
        } else {
            pagedListController = pagedListController2;
        }
        PagedListController.x(pagedListController, 0, null, new ConnectedAgentsFragment$loadInstalledMarketAgents$1(null), 3, null);
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean e() {
        return true;
    }

    public final void e0() {
        View viewFindViewById;
        int[] iArr;
        androidx.fragment.app.r activity = getActivity();
        if (activity == null || (viewFindViewById = activity.findViewById(R$id.ail_content_container)) == null || (iArr = this.savedContentPadding) == null) {
            return;
        }
        viewFindViewById.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
        this.savedContentPadding = null;
    }

    public final void f0(final AgentMarketItem item, View anchor) {
        T9.d(anchor, 0.0f, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.market.G0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ConnectedAgentsFragment.g0(item);
            }
        }, 2, null);
    }

    public final MarketAgentBrief h0(AgentMarketItem agentMarketItem) {
        return new MarketAgentBrief(agentMarketItem.getAssetId(), agentMarketItem.getReversionId(), agentMarketItem.getVersion(), agentMarketItem.getDisplayName(), agentMarketItem.getDescription(), agentMarketItem.getDeveloper(), agentMarketItem.getDownloadCount(), agentMarketItem.getInstallVersion(), agentMarketItem.getNeedUpdate(), true, agentMarketItem.getIconUrl(), false, false, null, 14336, null);
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        e0();
        this.marketSection = null;
        T().flContainer.removeAllViews();
        this._binding = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        e0();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            Result.Companion companion = Result.INSTANCE;
            View viewV = V();
            if (viewV != null) {
                viewV.setVisibility(8);
            }
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        N();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this._binding = Y4.s.a(view);
        FrameLayout frameLayoutB = T().b();
        kotlin.jvm.internal.p.h(frameLayoutB, "getRoot(...)");
        com.stepos.ailauncher.container.glass.k.b(frameLayoutB, 0, 1, null);
        TextView textView = T().tvTitle;
        PageMode pageModeU = U();
        PageMode pageMode = PageMode.EXTERNAL_AGENT;
        textView.setText(pageModeU == pageMode ? R$string.external_agents_title : R$string.connected_agents_title);
        T().btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.F0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConnectedAgentsFragment.Z(this.f24143a, view2);
            }
        });
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C2773b6 c2773b6 = new C2773b6(viewLifecycleOwner, false, 2, null);
        ImageView btnBack = T().btnBack;
        kotlin.jvm.internal.p.h(btnBack, "btnBack");
        C2773b6.p(c2773b6, new View[]{btnBack}, null, false, 6, null);
        T().topChromeBlur.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.market.H0
            @Override // java.lang.Runnable
            public final void run() {
                ConnectedAgentsFragment.a0(this.f24147a);
            }
        });
        T().flContainer.removeAllViews();
        if (U() != pageMode) {
            FrameLayout flContainer = T().flContainer;
            kotlin.jvm.internal.p.h(flContainer, "flContainer");
            flContainer.setPadding(flContainer.getPaddingLeft(), flContainer.getPaddingTop(), flContainer.getPaddingRight(), 0);
            T().flContainer.addView(P());
            W();
            O();
            return;
        }
        FrameLayout frameLayout = T().flContainer;
        Context contextRequireContext = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        AgentTabView agentTabView = new AgentTabView(contextRequireContext, null, 0, 6, null);
        agentTabView.V();
        frameLayout.addView(agentTabView);
        T().btnAddAgent.setVisibility(0);
        T().btnAddAgent.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.I0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConnectedAgentsFragment.c0(this.f24149a, view2);
            }
        });
    }
}
