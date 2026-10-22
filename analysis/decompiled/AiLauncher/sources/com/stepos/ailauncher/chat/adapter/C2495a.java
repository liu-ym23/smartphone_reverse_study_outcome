package com.stepos.ailauncher.chat.adapter;

import Z8.C1173v;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.adapter.C2495a;
import com.stepos.ailauncher.chat.view.C2765a9;
import com.stepos.ailauncher.chat.view.C2787c9;
import com.stepos.ailauncher.chat.view.T9;
import com.stepos.ailauncher.contract.api.agent.IAgentMarketService;
import com.stepos.ailauncher.contract.model.MarketAgentBrief;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0007\u0018\u0000 62\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u000278BM\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u0017\u001a\u00020\u00052\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00150\u0011¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001c\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u0015H\u0016¢\u0006\u0004\b\"\u0010#J#\u0010%\u001a\u00020\u00052\n\u0010$\u001a\u00060\u0002R\u00020\u00002\u0006\u0010 \u001a\u00020\u0015H\u0016¢\u0006\u0004\b%\u0010&J1\u0010*\u001a\u00020\u00052\n\u0010$\u001a\u00060\u0002R\u00020\u00002\u0006\u0010 \u001a\u00020\u00152\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016¢\u0006\u0004\b*\u0010+R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010,R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010,R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010,R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010-R$\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R \u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R \u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0015028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00104¨\u00069"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/chat/adapter/a$b;", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;", "LY8/t;", "onAdd", "onUninstall", "onClick", "", "testingMode", "<init>", "(Lp9/l;Lp9/l;Lp9/l;Z)V", "", "list", "l", "(Ljava/util/List;)V", "", "", "Lcom/stepos/ailauncher/contract/api/agent/IAgentMarketService$MarketAgentUiStatus;", "status", "", "progress", "m", "(Ljava/util/Map;Ljava/util/Map;)V", "Landroid/view/ViewGroup;", "parent", "viewType", "k", "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/chat/adapter/a$b;", "getItemCount", "()I", "position", "", "getItemId", "(I)J", "holder", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/chat/adapter/a$b;I)V", "", "", "payloads", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/chat/adapter/a$b;ILjava/util/List;)V", "Lp9/l;", "Z", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", DidiCardProvider.KEY_ITEMS, "Ljava/util/ArrayList;", "", "statusMap", "Ljava/util/Map;", "progressMap", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.adapter.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2495a extends RecyclerView.Adapter<b> {
    private static final String PAYLOAD_ACTION_STATE = "action_state";
    private final ArrayList<MarketAgentBrief> items;
    private final InterfaceC5074l<MarketAgentBrief, Y8.t> onAdd;
    private final InterfaceC5074l<MarketAgentBrief, Y8.t> onClick;
    private final InterfaceC5074l<MarketAgentBrief, Y8.t> onUninstall;
    private final Map<String, Integer> progressMap;
    private final Map<String, IAgentMarketService.MarketAgentUiStatus> statusMap;
    private final boolean testingMode;

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0013J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001f\u0010\u0013R\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010%R\u0014\u0010(\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010%R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103¨\u00064"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/a$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/stepos/ailauncher/chat/adapter/a;Landroid/view/View;)V", "", "v", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(I)I", "", AMapLocationStaticsEntity.FIRST_LOCATE, "last", "LY8/t;", "e", "(ZZ)V", "Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;", "item", "f", "(Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "n", "resId", "k", "(I)Landroid/view/View;", UxipConstants.f30680s, "indeterminate", "Lcom/google/android/material/progressindicator/CircularProgressIndicator;", "l", "(IZ)Lcom/google/android/material/progressindicator/CircularProgressIndicator;", "q", "Landroid/widget/ImageView;", "icon", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "name", "Landroid/widget/TextView;", Const.JSON_KEY_DESC, "tagState", "tagUpdate", "Landroid/widget/FrameLayout;", "actionArea", "Landroid/widget/FrameLayout;", "", "renderedAssetId", "Ljava/lang/String;", "Lcom/stepos/ailauncher/contract/api/agent/IAgentMarketService$MarketAgentUiStatus;", "renderedStatus", "Lcom/stepos/ailauncher/contract/api/agent/IAgentMarketService$MarketAgentUiStatus;", "progressView", "Lcom/google/android/material/progressindicator/CircularProgressIndicator;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.adapter.a$b */
    public final class b extends RecyclerView.ViewHolder {
        private final FrameLayout actionArea;
        private final TextView desc;
        private final ImageView icon;
        private final TextView name;
        private CircularProgressIndicator progressView;
        private String renderedAssetId;
        private IAgentMarketService.MarketAgentUiStatus renderedStatus;
        private final TextView tagState;
        private final TextView tagUpdate;
        final /* synthetic */ C2495a this$0;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.adapter.a$b$a, reason: collision with other inner class name */
        public static final /* synthetic */ class C0277a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[IAgentMarketService.MarketAgentUiStatus.values().length];
                try {
                    iArr[IAgentMarketService.MarketAgentUiStatus.NOT_INSTALLED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[IAgentMarketService.MarketAgentUiStatus.INSTALL_FAILED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[IAgentMarketService.MarketAgentUiStatus.INSTALLING.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[IAgentMarketService.MarketAgentUiStatus.QUEUED.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[IAgentMarketService.MarketAgentUiStatus.INSTALLED.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[IAgentMarketService.MarketAgentUiStatus.UNINSTALLING.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C2495a c2495a, View itemView) {
            super(itemView);
            kotlin.jvm.internal.p.i(itemView, "itemView");
            this.this$0 = c2495a;
            View viewFindViewById = itemView.findViewById(R$id.ivAgentIcon);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            this.icon = (ImageView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R$id.tvAgentName);
            kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
            this.name = (TextView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R$id.tvAgentDesc);
            kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
            this.desc = (TextView) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(R$id.tvAgentTagState);
            kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
            this.tagState = (TextView) viewFindViewById4;
            View viewFindViewById5 = itemView.findViewById(R$id.tvAgentTagUpdate);
            kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
            this.tagUpdate = (TextView) viewFindViewById5;
            View viewFindViewById6 = itemView.findViewById(R$id.actionArea);
            kotlin.jvm.internal.p.h(viewFindViewById6, "findViewById(...)");
            this.actionArea = (FrameLayout) viewFindViewById6;
        }

        public static final void g(C2495a c2495a, MarketAgentBrief marketAgentBrief, View view) {
            c2495a.onClick.invoke(marketAgentBrief);
        }

        private final int j(int v10) {
            return (int) (v10 * this.itemView.getResources().getDisplayMetrics().density);
        }

        public static /* synthetic */ CircularProgressIndicator m(b bVar, int i10, boolean z10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                z10 = false;
            }
            return bVar.l(i10, z10);
        }

        public static final void o(C2495a c2495a, MarketAgentBrief marketAgentBrief, View view) {
            c2495a.onAdd.invoke(marketAgentBrief);
        }

        public static final void p(b bVar, MarketAgentBrief marketAgentBrief, View view) {
            bVar.q(marketAgentBrief);
        }

        public static final Y8.t r(C2495a c2495a, MarketAgentBrief marketAgentBrief) {
            c2495a.onUninstall.invoke(marketAgentBrief);
            return Y8.t.f7040a;
        }

        public final void e(boolean first, boolean last) {
            this.itemView.setPaddingRelative(j(16), first ? j(16) : j(12), j(16), last ? j(16) : j(12));
        }

        public final void f(final MarketAgentBrief item) {
            kotlin.jvm.internal.p.i(item, "item");
            C2765a9.c(this.icon, item.getIconUrl(), R$drawable.ic_amoo_market_agent, false, 8, null);
            this.name.setText(item.getName());
            if (this.this$0.testingMode) {
                i(item);
            } else {
                this.desc.setText(item.getDescription());
                this.tagState.setVisibility(8);
                this.tagUpdate.setVisibility(8);
                this.itemView.setAlpha(1.0f);
            }
            View view = this.itemView;
            final C2495a c2495a = this.this$0;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    C2495a.b.g(c2495a, item, view2);
                }
            });
            n(item);
        }

        public final void h(MarketAgentBrief item) {
            kotlin.jvm.internal.p.i(item, "item");
            n(item);
        }

        public final void i(MarketAgentBrief item) {
            TextView textView = this.desc;
            String version = item.getVersion();
            if (La.H.x0(version)) {
                version = item.getDescription();
            }
            textView.setText(version);
            C2787c9.INSTANCE.a(this.tagState, item.getEnv());
            if (item.getExpired()) {
                this.desc.setText(R$string.amoo_tag_expired);
                this.itemView.setAlpha(0.4f);
            } else {
                this.itemView.setAlpha(1.0f);
            }
            this.tagState.setVisibility(0);
        }

        public final View k(int resId) {
            ImageView imageView = new ImageView(this.actionArea.getContext());
            imageView.setImageResource(resId);
            imageView.setContentDescription(null);
            imageView.setImageTintList(ColorStateList.valueOf(-2130706433));
            imageView.setLayoutParams(new FrameLayout.LayoutParams(j(20), j(20), 17));
            return imageView;
        }

        public final CircularProgressIndicator l(int value, boolean indeterminate) {
            CircularProgressIndicator circularProgressIndicator = new CircularProgressIndicator(this.actionArea.getContext());
            int iJ = j(20);
            circularProgressIndicator.setLayoutParams(new FrameLayout.LayoutParams(iJ, iJ, 17));
            circularProgressIndicator.setIndicatorSize(iJ);
            circularProgressIndicator.setTrackThickness(j(2));
            circularProgressIndicator.setIndicatorColor(-1);
            circularProgressIndicator.setTrackColor(872415231);
            circularProgressIndicator.setIndeterminate(indeterminate);
            if (!indeterminate) {
                circularProgressIndicator.setMax(100);
                circularProgressIndicator.setProgress(C5685n.n(value, 0, 100));
            }
            return circularProgressIndicator;
        }

        public final void n(final MarketAgentBrief item) {
            IAgentMarketService.MarketAgentUiStatus marketAgentUiStatus = (IAgentMarketService.MarketAgentUiStatus) this.this$0.statusMap.get(item.getAssetId());
            if (marketAgentUiStatus == null) {
                marketAgentUiStatus = item.getInstalled() ? IAgentMarketService.MarketAgentUiStatus.INSTALLED : IAgentMarketService.MarketAgentUiStatus.NOT_INSTALLED;
            }
            if (this.this$0.testingMode) {
                this.tagUpdate.setVisibility((item.getNeedUpdate() && marketAgentUiStatus == IAgentMarketService.MarketAgentUiStatus.INSTALLED && !item.getExpired()) ? 0 : 8);
            }
            if (kotlin.jvm.internal.p.d(this.renderedAssetId, item.getAssetId()) && this.renderedStatus == marketAgentUiStatus) {
                Integer num = (Integer) this.this$0.progressMap.get(item.getAssetId());
                int iIntValue = num != null ? num.intValue() : 0;
                CircularProgressIndicator circularProgressIndicator = this.progressView;
                if (circularProgressIndicator != null) {
                    CircularProgressIndicator circularProgressIndicator2 = circularProgressIndicator.isIndeterminate() ? null : circularProgressIndicator;
                    if (circularProgressIndicator2 != null) {
                        circularProgressIndicator2.p(C5685n.n(iIntValue, 0, 100), true);
                        return;
                    }
                    return;
                }
                return;
            }
            this.renderedAssetId = item.getAssetId();
            this.renderedStatus = marketAgentUiStatus;
            this.progressView = null;
            this.actionArea.removeAllViews();
            this.actionArea.setOnClickListener(null);
            switch (C0277a.$EnumSwitchMapping$0[marketAgentUiStatus.ordinal()]) {
                case 1:
                case 2:
                    this.actionArea.addView(k(R$drawable.ic_amoo_plus));
                    FrameLayout frameLayout = this.actionArea;
                    final C2495a c2495a = this.this$0;
                    frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.c
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            C2495a.b.o(c2495a, item, view);
                        }
                    });
                    return;
                case 3:
                case 4:
                    Integer num2 = (Integer) this.this$0.progressMap.get(item.getAssetId());
                    CircularProgressIndicator circularProgressIndicatorM = m(this, num2 != null ? num2.intValue() : 0, false, 2, null);
                    this.progressView = circularProgressIndicatorM;
                    this.actionArea.addView(circularProgressIndicatorM);
                    return;
                case 5:
                    this.actionArea.addView(k(R$drawable.ic_amoo_ellipsis));
                    this.actionArea.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.d
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            C2495a.b.p(this.f24933a, item, view);
                        }
                    });
                    return;
                case 6:
                    this.actionArea.addView(l(0, true));
                    return;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        public final void q(final MarketAgentBrief item) {
            FrameLayout frameLayout = this.actionArea;
            final C2495a c2495a = this.this$0;
            T9.d(frameLayout, 0.0f, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.adapter.e
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return C2495a.b.r(c2495a, item);
                }
            }, 2, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C2495a(InterfaceC5074l<? super MarketAgentBrief, Y8.t> onAdd, InterfaceC5074l<? super MarketAgentBrief, Y8.t> onUninstall, InterfaceC5074l<? super MarketAgentBrief, Y8.t> onClick, boolean z10) {
        kotlin.jvm.internal.p.i(onAdd, "onAdd");
        kotlin.jvm.internal.p.i(onUninstall, "onUninstall");
        kotlin.jvm.internal.p.i(onClick, "onClick");
        this.onAdd = onAdd;
        this.onUninstall = onUninstall;
        this.onClick = onClick;
        this.testingMode = z10;
        this.items = new ArrayList<>();
        this.statusMap = new LinkedHashMap();
        this.progressMap = new LinkedHashMap();
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.items.get(position).getAssetId().hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        holder.e(position == 0, position == C1173v.o(this.items));
        MarketAgentBrief marketAgentBrief = this.items.get(position);
        kotlin.jvm.internal.p.h(marketAgentBrief, "get(...)");
        holder.f(marketAgentBrief);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position, List<Object> payloads) {
        kotlin.jvm.internal.p.i(holder, "holder");
        kotlin.jvm.internal.p.i(payloads, "payloads");
        if (!payloads.contains(PAYLOAD_ACTION_STATE)) {
            super.onBindViewHolder(holder, position, payloads);
            return;
        }
        MarketAgentBrief marketAgentBrief = this.items.get(position);
        kotlin.jvm.internal.p.h(marketAgentBrief, "get(...)");
        holder.h(marketAgentBrief);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_amoo_agent_market, parent, false);
        kotlin.jvm.internal.p.f(viewInflate);
        return new b(this, viewInflate);
    }

    public final void l(List<MarketAgentBrief> list) {
        kotlin.jvm.internal.p.i(list, "list");
        if (kotlin.jvm.internal.p.d(this.items, list)) {
            return;
        }
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }

    public final void m(Map<String, ? extends IAgentMarketService.MarketAgentUiStatus> status, Map<String, Integer> progress) {
        kotlin.jvm.internal.p.i(status, "status");
        kotlin.jvm.internal.p.i(progress, "progress");
        ArrayList<MarketAgentBrief> arrayList = this.items;
        ArrayList arrayList2 = new ArrayList();
        for (MarketAgentBrief marketAgentBrief : arrayList) {
            String assetId = (this.statusMap.get(marketAgentBrief.getAssetId()) == status.get(marketAgentBrief.getAssetId()) && kotlin.jvm.internal.p.d(this.progressMap.get(marketAgentBrief.getAssetId()), progress.get(marketAgentBrief.getAssetId()))) ? null : marketAgentBrief.getAssetId();
            if (assetId != null) {
                arrayList2.add(assetId);
            }
        }
        Set<String> setR1 = Z8.F.r1(arrayList2);
        this.statusMap.clear();
        this.statusMap.putAll(status);
        this.progressMap.clear();
        this.progressMap.putAll(progress);
        for (String str : setR1) {
            Iterator<MarketAgentBrief> it = this.items.iterator();
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i10 = -1;
                    break;
                } else if (kotlin.jvm.internal.p.d(it.next().getAssetId(), str)) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 >= 0) {
                notifyItemChanged(i10, PAYLOAD_ACTION_STATE);
            }
        }
    }

    public /* synthetic */ C2495a(InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, InterfaceC5074l interfaceC5074l3, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this(interfaceC5074l, interfaceC5074l2, interfaceC5074l3, (i10 & 8) != 0 ? false : z10);
    }
}
