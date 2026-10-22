package com.stepos.ailauncher.agent.aispace.market;

import Z8.C1173v;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.stepos.ailauncher.agent.R$drawable;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import com.stepos.ailauncher.agent.aispace.market.C2260c;
import com.stepos.ailauncher.chat.view.C2765a9;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002:;B]\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0004\b\u0014\u0010\u0011J!\u0010\u0019\u001a\u00020\u00052\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u0013J#\u0010 \u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\"\u0010#J\u001b\u0010%\u001a\u00020\u00052\n\u0010$\u001a\u00060\u0002R\u00020\u0000H\u0016¢\u0006\u0004\b%\u0010&J#\u0010(\u001a\u00020\u00052\n\u0010$\u001a\u00060\u0002R\u00020\u00002\u0006\u0010'\u001a\u00020\u001eH\u0016¢\u0006\u0004\b(\u0010)J1\u0010-\u001a\u00020\u00052\n\u0010$\u001a\u00060\u0002R\u00020\u00002\u0006\u0010'\u001a\u00020\u001e2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*H\u0016¢\u0006\u0004\b-\u0010.R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010/R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010/R&\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u00100R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010/R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u00040*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\"\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R$\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u001605j\b\u0012\u0004\u0012\u00020\u0016`68\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/agent/aispace/market/c$b;", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", "LY8/t;", "onInstall", "onUninstall", "Lkotlin/Function2;", "", "onToggleEnabled", "onClickDetail", "<init>", "(Lp9/l;Lp9/l;Lp9/p;Lp9/l;)V", "", "list", "l", "(Ljava/util/List;)V", "k", "()V", "f", "", "", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;", C3081a.FOCUS_MAP_NAME, "n", "(Ljava/util/Map;)V", "m", "Landroid/view/ViewGroup;", "parent", "", "viewType", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/agent/aispace/market/c$b;", "getItemCount", "()I", "holder", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/agent/aispace/market/c$b;)V", "position", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/ailauncher/agent/aispace/market/c$b;I)V", "", "", "payloads", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/agent/aispace/market/c$b;ILjava/util/List;)V", "Lp9/l;", "Lp9/p;", DidiCardProvider.KEY_ITEMS, "Ljava/util/List;", "statusMap", "Ljava/util/Map;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "exposedIds", "Ljava/util/HashSet;", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2260c extends RecyclerView.Adapter<b> {
    private static final a Companion = new a(null);
    private static final Object PAYLOAD_PROGRESS = new Object();
    private final HashSet<String> exposedIds;
    private final List<AgentMarketItem> items;
    private final InterfaceC5074l<AgentMarketItem, Y8.t> onClickDetail;
    private final InterfaceC5074l<AgentMarketItem, Y8.t> onInstall;
    private final p9.p<AgentMarketItem, Boolean, Y8.t> onToggleEnabled;
    private final InterfaceC5074l<AgentMarketItem, Y8.t> onUninstall;
    private Map<String, ? extends AgentMarketStatus> statusMap;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/c$a;", "", "<init>", "()V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.c$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\fJ-\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ3\u0010\"\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u001e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\n0 H\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010$\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\rH\u0002¢\u0006\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010(R\u0014\u0010-\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010(R\u0014\u0010.\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010(R\u0014\u0010/\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010(R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00063"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/c$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "v", "<init>", "(Lcom/stepos/ailauncher/agent/aispace/market/c;Landroid/view/View;)V", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", "item", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;", "status", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;)V", "", "pct", "t", "(I)V", "n", "Landroid/content/Context;", "ctx", "", "text", "Lkotlin/Function0;", "onClick", "l", "(Landroid/content/Context;Ljava/lang/String;Lp9/a;)Landroid/view/View;", "k", "(Landroid/content/Context;)Landroid/view/View;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/content/Context;I)Landroid/view/View;", "", "checked", "Lkotlin/Function1;", "onChange", "r", "(Landroid/content/Context;ZLp9/l;)Landroid/view/View;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/content/Context;I)I", "Landroid/widget/TextView;", "iconChar", "Landroid/widget/TextView;", "Landroid/widget/ImageView;", "iconImage", "Landroid/widget/ImageView;", "title", "updateBadge", Const.JSON_KEY_DESC, "meta", "Landroid/widget/FrameLayout;", "action", "Landroid/widget/FrameLayout;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.c$b */
    public final class b extends RecyclerView.ViewHolder {
        private final FrameLayout action;
        private final TextView desc;
        private final TextView iconChar;
        private final ImageView iconImage;
        private final TextView meta;
        final /* synthetic */ C2260c this$0;
        private final TextView title;
        private final TextView updateBadge;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.agent.aispace.market.c$b$a */
        public static final /* synthetic */ class a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AgentMarketStatus.values().length];
                try {
                    iArr[AgentMarketStatus.NOT_INSTALLED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AgentMarketStatus.INSTALL_FAILED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AgentMarketStatus.INSTALLING.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AgentMarketStatus.QUEUED.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[AgentMarketStatus.UPDATING.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[AgentMarketStatus.UNINSTALLING.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[AgentMarketStatus.INSTALLED_ENABLED.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[AgentMarketStatus.INSTALLED_DISABLED.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C2260c c2260c, View v10) {
            super(v10);
            kotlin.jvm.internal.p.i(v10, "v");
            this.this$0 = c2260c;
            View viewFindViewById = v10.findViewById(R$id.tv_agent_icon_char);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            this.iconChar = (TextView) viewFindViewById;
            View viewFindViewById2 = v10.findViewById(R$id.iv_agent_icon);
            kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
            this.iconImage = (ImageView) viewFindViewById2;
            View viewFindViewById3 = v10.findViewById(R$id.tv_title);
            kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
            this.title = (TextView) viewFindViewById3;
            View viewFindViewById4 = v10.findViewById(R$id.tv_update_badge);
            kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
            this.updateBadge = (TextView) viewFindViewById4;
            View viewFindViewById5 = v10.findViewById(R$id.tv_description);
            kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
            this.desc = (TextView) viewFindViewById5;
            View viewFindViewById6 = v10.findViewById(R$id.tv_meta);
            kotlin.jvm.internal.p.h(viewFindViewById6, "findViewById(...)");
            this.meta = (TextView) viewFindViewById6;
            View viewFindViewById7 = v10.findViewById(R$id.action_area);
            kotlin.jvm.internal.p.h(viewFindViewById7, "findViewById(...)");
            this.action = (FrameLayout) viewFindViewById7;
        }

        public static final void h(AgentMarketItem agentMarketItem, b bVar, C2260c c2260c, View view) {
            W4.a aVar = W4.a.INSTANCE;
            String assetId = agentMarketItem.getAssetId();
            Integer numValueOf = Integer.valueOf(bVar.getBindingAdapterPosition());
            if (numValueOf.intValue() < 0) {
                numValueOf = null;
            }
            aVar.c(W4.a.ENTRY_AGENT_CARD, assetId, numValueOf);
            c2260c.onClickDetail.invoke(agentMarketItem);
        }

        public static final void m(InterfaceC5063a interfaceC5063a, View view) {
            interfaceC5063a.invoke();
        }

        public static final Y8.t o(C2260c c2260c, AgentMarketItem agentMarketItem) {
            c2260c.onInstall.invoke(agentMarketItem);
            return Y8.t.f7040a;
        }

        public static final Y8.t p(C2260c c2260c, AgentMarketItem agentMarketItem) {
            c2260c.onInstall.invoke(agentMarketItem);
            return Y8.t.f7040a;
        }

        public static final Y8.t q(C2260c c2260c, AgentMarketItem agentMarketItem, boolean z10) {
            c2260c.onToggleEnabled.invoke(agentMarketItem, Boolean.valueOf(z10));
            return Y8.t.f7040a;
        }

        public static final Y8.t s(InterfaceC5074l interfaceC5074l, boolean z10) {
            interfaceC5074l.invoke(Boolean.valueOf(z10));
            return Y8.t.f7040a;
        }

        public final void g(final AgentMarketItem item, AgentMarketStatus status) {
            kotlin.jvm.internal.p.i(item, "item");
            kotlin.jvm.internal.p.i(status, "status");
            this.iconChar.setText(item.getIconChar());
            C2765a9.a(this.iconImage, this.iconChar, item.getIconUrl());
            this.title.setText(item.getDisplayName());
            this.updateBadge.setVisibility((item.getNeedUpdate() && status.isInstalled()) ? 0 : 8);
            this.desc.setText(item.getDescription());
            this.meta.setText(item.getMetaText());
            View view = this.itemView;
            final C2260c c2260c = this.this$0;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    C2260c.b.h(item, this, c2260c, view2);
                }
            });
            n(item, status);
        }

        public final int i(Context ctx, int v10) {
            return (int) (v10 * ctx.getResources().getDisplayMetrics().density);
        }

        public final View j(Context ctx, int pct) {
            CircularProgressIndicator circularProgressIndicator = new CircularProgressIndicator(ctx);
            circularProgressIndicator.setIndeterminate(false);
            circularProgressIndicator.setMax(100);
            circularProgressIndicator.setIndicatorColor(-1480402);
            circularProgressIndicator.setTrackColor(872415231);
            circularProgressIndicator.setIndicatorSize(i(ctx, 24));
            circularProgressIndicator.setTrackThickness(i(ctx, 3));
            circularProgressIndicator.setTrackCornerRadius(i(ctx, 2));
            circularProgressIndicator.p(C5685n.n(pct, 0, 100), false);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 8388629;
            layoutParams.setMarginEnd(i(ctx, 8));
            circularProgressIndicator.setLayoutParams(layoutParams);
            return circularProgressIndicator;
        }

        public final View k(Context ctx) {
            ProgressBar progressBar = new ProgressBar(ctx);
            progressBar.setIndeterminate(true);
            int i10 = i(ctx, 22);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i10, i10);
            layoutParams.gravity = 8388629;
            layoutParams.setMarginEnd(i(ctx, 8));
            progressBar.setLayoutParams(layoutParams);
            return progressBar;
        }

        public final View l(Context ctx, String text, final InterfaceC5063a<Y8.t> onClick) {
            TextView textView = new TextView(ctx);
            textView.setText(text);
            textView.setTextColor(-1);
            textView.setTextSize(14.0f);
            textView.setGravity(17);
            textView.setBackgroundResource(R$drawable.bg_agent_install_pill);
            textView.setMinWidth(i(ctx, 64));
            textView.setPadding(i(ctx, 16), i(ctx, 7), i(ctx, 16), i(ctx, 7));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 8388629;
            textView.setLayoutParams(layoutParams);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C2260c.b.m(onClick, view);
                }
            });
            return textView;
        }

        public final void n(final AgentMarketItem item, AgentMarketStatus status) {
            this.action.removeAllViews();
            Context context = this.action.getContext();
            switch (a.$EnumSwitchMapping$0[status.ordinal()]) {
                case 1:
                    FrameLayout frameLayout = this.action;
                    kotlin.jvm.internal.p.f(context);
                    final C2260c c2260c = this.this$0;
                    frameLayout.addView(l(context, "安装", new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.market.e
                        @Override // p9.InterfaceC5063a
                        public final Object invoke() {
                            return C2260c.b.o(c2260c, item);
                        }
                    }));
                    return;
                case 2:
                    FrameLayout frameLayout2 = this.action;
                    kotlin.jvm.internal.p.f(context);
                    final C2260c c2260c2 = this.this$0;
                    frameLayout2.addView(l(context, "重试", new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.market.f
                        @Override // p9.InterfaceC5063a
                        public final Object invoke() {
                            return C2260c.b.p(c2260c2, item);
                        }
                    }));
                    return;
                case 3:
                case 4:
                case 5:
                    FrameLayout frameLayout3 = this.action;
                    kotlin.jvm.internal.p.f(context);
                    frameLayout3.addView(j(context, AgentMarketOperaManager.INSTANCE.I(item.getAssetId())));
                    return;
                case 6:
                    FrameLayout frameLayout4 = this.action;
                    kotlin.jvm.internal.p.f(context);
                    frameLayout4.addView(k(context));
                    return;
                case 7:
                case 8:
                    FrameLayout frameLayout5 = this.action;
                    kotlin.jvm.internal.p.f(context);
                    boolean z10 = status == AgentMarketStatus.INSTALLED_ENABLED;
                    final C2260c c2260c3 = this.this$0;
                    frameLayout5.addView(r(context, z10, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.market.g
                        @Override // p9.InterfaceC5074l
                        public final Object invoke(Object obj) {
                            return C2260c.b.q(c2260c3, item, ((Boolean) obj).booleanValue());
                        }
                    }));
                    return;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        public final View r(Context ctx, boolean checked, final InterfaceC5074l<? super Boolean, Y8.t> onChange) {
            return C2258b.INSTANCE.b(ctx, checked, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.market.i
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return C2260c.b.s(onChange, ((Boolean) obj).booleanValue());
                }
            });
        }

        public final void t(int pct) {
            View childAt = this.action.getChildAt(0);
            CircularProgressIndicator circularProgressIndicator = childAt instanceof CircularProgressIndicator ? (CircularProgressIndicator) childAt : null;
            if (circularProgressIndicator != null) {
                circularProgressIndicator.p(C5685n.n(pct, 0, 100), true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C2260c(InterfaceC5074l<? super AgentMarketItem, Y8.t> onInstall, InterfaceC5074l<? super AgentMarketItem, Y8.t> onUninstall, p9.p<? super AgentMarketItem, ? super Boolean, Y8.t> onToggleEnabled, InterfaceC5074l<? super AgentMarketItem, Y8.t> onClickDetail) {
        kotlin.jvm.internal.p.i(onInstall, "onInstall");
        kotlin.jvm.internal.p.i(onUninstall, "onUninstall");
        kotlin.jvm.internal.p.i(onToggleEnabled, "onToggleEnabled");
        kotlin.jvm.internal.p.i(onClickDetail, "onClickDetail");
        this.onInstall = onInstall;
        this.onUninstall = onUninstall;
        this.onToggleEnabled = onToggleEnabled;
        this.onClickDetail = onClickDetail;
        this.items = new ArrayList();
        this.statusMap = kotlin.collections.a.i();
        this.exposedIds = new HashSet<>();
    }

    public final void f(List<AgentMarketItem> list) {
        kotlin.jvm.internal.p.i(list, "list");
        if (list.isEmpty()) {
            return;
        }
        int size = this.items.size();
        this.items.addAll(list);
        notifyItemRangeInserted(size, list.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        AgentMarketItem agentMarketItem = this.items.get(position);
        AgentMarketStatus initialStatus = this.statusMap.get(agentMarketItem.getAssetId());
        if (initialStatus == null) {
            initialStatus = agentMarketItem.getInitialStatus();
        }
        holder.g(agentMarketItem, initialStatus);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position, List<Object> payloads) {
        kotlin.jvm.internal.p.i(holder, "holder");
        kotlin.jvm.internal.p.i(payloads, "payloads");
        if (payloads.contains(PAYLOAD_PROGRESS)) {
            holder.t(AgentMarketOperaManager.INSTANCE.I(this.items.get(position).getAssetId()));
        } else {
            super.onBindViewHolder(holder, position, payloads);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_agent_market_card, parent, false);
        kotlin.jvm.internal.p.f(viewInflate);
        return new b(this, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(b holder) {
        kotlin.jvm.internal.p.i(holder, "holder");
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        if (bindingAdapterPosition < 0 || bindingAdapterPosition >= this.items.size() || !this.exposedIds.add(this.items.get(bindingAdapterPosition).getAssetId())) {
            return;
        }
        W4.a.INSTANCE.f(this.items.get(bindingAdapterPosition).getAssetId(), bindingAdapterPosition);
    }

    public final void k() {
        this.exposedIds.clear();
    }

    public final void l(List<AgentMarketItem> list) {
        kotlin.jvm.internal.p.i(list, "list");
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }

    public final void m() {
        int i10 = 0;
        for (Object obj : this.items) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            AgentMarketItem agentMarketItem = (AgentMarketItem) obj;
            AgentMarketStatus initialStatus = this.statusMap.get(agentMarketItem.getAssetId());
            if (initialStatus == null) {
                initialStatus = agentMarketItem.getInitialStatus();
            }
            if (initialStatus == AgentMarketStatus.INSTALLING || initialStatus == AgentMarketStatus.QUEUED || initialStatus == AgentMarketStatus.UPDATING) {
                notifyItemChanged(i10, PAYLOAD_PROGRESS);
            }
            i10 = i11;
        }
    }

    public final void n(Map<String, ? extends AgentMarketStatus> map) {
        kotlin.jvm.internal.p.i(map, "map");
        this.statusMap = map;
        notifyDataSetChanged();
    }
}
