package com.stepos.ailauncher.agent.aispace;

import La.H;
import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Y4.G;
import Z8.C1173v;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.blankj.utilcode.util.ToastUtils;
import com.stepos.agentframework.adapter.agentbus.bff.ExternalAgent;
import com.stepos.ailauncher.agent.R$drawable;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.AgentTabView;
import com.stepos.ailauncher.agent.aispace.connect.AddAgentBottomSheet;
import com.stepos.ailauncher.agent.aispace.connect.C2216l0;
import com.stepos.ailauncher.agent.aispace.connect.C2236w;
import com.stepos.ailauncher.agent.aispace.connect.ConnectStepAgentActivity;
import com.stepos.ailauncher.agent.aispace.connect.Q0;
import com.stepos.ailauncher.agent.aispace.connect.SelectExternalAgentActivity;
import com.stepos.ailauncher.agent.aispace.connect.SelectExternalAgentFragment;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceCache;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceGroup;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceResponseData;
import com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailActivity;
import com.stepos.ailauncher.agent.aispace.market.AgentMarketItem;
import com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager;
import com.stepos.ailauncher.agent.aispace.market.C2260c;
import com.stepos.ailauncher.agent.aispace.market.ConnectedAgentsActivity;
import com.stepos.ailauncher.chat.sheet.C2739j;
import com.stepos.ailauncher.chat.sheet.DesktopChatResidentController;
import com.stepos.ailauncher.common.utils.I;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentUiService;
import com.stepos.ailauncher.contract.api.aispace.IAiSpaceTabView;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import com.stepos.ailauncher.sheet.S;
import com.stepos.ailauncher.sheet.SheetHeightMode;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import m4.AbstractC4898a;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0003ijkB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0011J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001a\u0010\u0011J\u0017\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001f\u0010\u0011J\u000f\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\b \u0010\u0011J\u000f\u0010!\u001a\u00020\rH\u0002¢\u0006\u0004\b!\u0010\u0011J\u000f\u0010\"\u001a\u00020\rH\u0002¢\u0006\u0004\b\"\u0010\u0011J\u000f\u0010#\u001a\u00020\rH\u0002¢\u0006\u0004\b#\u0010\u0011J\u000f\u0010$\u001a\u00020\rH\u0002¢\u0006\u0004\b$\u0010\u0011J\u0017\u0010'\u001a\u00020\r2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010-\u001a\u00020,2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020%H\u0002¢\u0006\u0004\b-\u0010.J\u0015\u00100\u001a\u0004\u0018\u00010/*\u00020\u0003H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\rH\u0002¢\u0006\u0004\b2\u0010\u0011J\u001f\u00107\u001a\u00020\r2\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u000205H\u0002¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020,H\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\r2\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020\r2\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b=\u0010<J\u0017\u0010>\u001a\u00020\r2\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b>\u0010<J\u0017\u0010?\u001a\u00020\r2\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b?\u0010<J\u0017\u0010@\u001a\u00020,2\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\r2\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\bB\u0010<J\u0017\u0010D\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0007H\u0002¢\u0006\u0004\bD\u0010EJ\u0017\u0010H\u001a\u00020\r2\u0006\u0010G\u001a\u00020FH\u0002¢\u0006\u0004\bH\u0010IJ\u0017\u0010K\u001a\u00020\r2\u0006\u0010J\u001a\u00020\u0007H\u0002¢\u0006\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010Q\u001a\u00060PR\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020W0V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010Z\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010[R\u0016\u0010]\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010!R\u0016\u0010^\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010`\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010!R\u0016\u0010a\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010!R\u0016\u0010b\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010d\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010!R\u001e\u0010f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010g¨\u0006l"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/AgentTabView;", "Landroid/widget/FrameLayout;", "Lcom/stepos/ailauncher/contract/api/aispace/IAiSpaceTabView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/stepos/ailauncher/agent/aispace/AgentTabView$PageMode;", "mode", "LY8/t;", ExifInterface.LONGITUDE_WEST, "(Lcom/stepos/ailauncher/agent/aispace/AgentTabView$PageMode;)V", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()V", "onAttachedToWindow", "onDetachedFromWindow", "onTabSelected", "onTabUnselected", "LUa/M;", "e0", "()LUa/M;", "q0", "D0", "Lcom/stepos/ailauncher/agent/aispace/connect/data/j;", "data", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/stepos/ailauncher/agent/aispace/connect/data/j;)V", "n0", "p0", "Z", "o0", "U", "k0", "", "entrySource", "j0", "(Ljava/lang/String;)V", "Landroidx/fragment/app/Fragment;", "fragment", "tag", "", "l0", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)Z", "Landroid/app/Activity;", "Y", "(Landroid/content/Context;)Landroid/app/Activity;", "r0", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;", Parameters.DEVICE, "Landroid/view/View;", LinkHeader.Parameters.Anchor, "x0", "(Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;Landroid/view/View;)V", "f0", "()Z", "m0", "(Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;)V", "B0", "g0", "h0", "i0", "(Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;)Z", "u0", UxipConstants.f30680s, "X", "(I)I", "", "text", "F0", "(Ljava/lang/CharSequence;)V", "resId", "E0", "(I)V", "LY4/G;", "binding", "LY4/G;", "Lcom/stepos/ailauncher/agent/aispace/AgentTabView$b;", "devicesAdapter", "Lcom/stepos/ailauncher/agent/aispace/AgentTabView$b;", "Lcom/stepos/ailauncher/agent/aispace/market/c;", "marketAdapter", "Lcom/stepos/ailauncher/agent/aispace/market/c;", "", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", "marketItems", "Ljava/util/List;", "marketPage", "I", "marketTotal", "marketLoading", "pageMode", "Lcom/stepos/ailauncher/agent/aispace/AgentTabView$PageMode;", "liteSheetDeviceListChrome", "pageShowReported", "viewScope", "LUa/M;", "collectorsStarted", "Lkotlin/Function0;", "dismissActiveOverlay", "Lp9/a;", "Companion", "PageMode", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentTabView extends FrameLayout implements IAiSpaceTabView {
    private static final int MARKET_LOAD_MORE_THRESHOLD_PX = 300;
    private static final int MARKET_PAGE_SIZE = 20;
    private final G binding;
    private boolean collectorsStarted;
    private final b devicesAdapter;
    private InterfaceC5063a<Y8.t> dismissActiveOverlay;
    private boolean liteSheetDeviceListChrome;
    private final C2260c marketAdapter;
    private List<AgentMarketItem> marketItems;
    private boolean marketLoading;
    private int marketPage;
    private int marketTotal;
    private PageMode pageMode;
    private boolean pageShowReported;
    private M viewScope;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/AgentTabView$PageMode;", "", "<init>", "(Ljava/lang/String;I)V", "HOME", "DEVICE_LIST", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PageMode {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ PageMode[] $VALUES;
        public static final PageMode HOME = new PageMode("HOME", 0);
        public static final PageMode DEVICE_LIST = new PageMode("DEVICE_LIST", 1);

        private static final /* synthetic */ PageMode[] $values() {
            return new PageMode[]{HOME, DEVICE_LIST};
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

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0017\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001d\u001a\u00020\t2\u000e\u0010\u001b\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/AgentTabView$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/agent/aispace/AgentTabView$b$a;", "Lcom/stepos/ailauncher/agent/aispace/AgentTabView;", "<init>", "(Lcom/stepos/ailauncher/agent/aispace/AgentTabView;)V", "", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;", "list", "LY8/t;", "f", "(Ljava/util/List;)V", "", "deviceId", "agent", "", com.stepos.ailauncher.sla.G.NETWORK_ONLINE, "e", "(Ljava/lang/String;Ljava/lang/String;Z)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", Const.INTENT_KEY_UMID, "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/agent/aispace/AgentTabView$b$a;", "getItemCount", "()I", "holder", "position", "c", "(Lcom/stepos/ailauncher/agent/aispace/AgentTabView$b$a;I)V", "", DidiCardProvider.KEY_ITEMS, "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class b extends RecyclerView.Adapter<a> {
        private final List<IExternalAgentBindService.ConnectedDevice> items = new ArrayList();

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/AgentTabView$b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "LY4/v;", Const.INTENT_KEY_PKGNAME, "<init>", "(Lcom/stepos/ailauncher/agent/aispace/AgentTabView$b;LY4/v;)V", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;", Parameters.DEVICE, "", "isFirst", "LY8/t;", "c", "(Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;Z)V", "LY4/v;", "getB", "()LY4/v;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public final class a extends RecyclerView.ViewHolder {
            private final Y4.v b;
            final /* synthetic */ b this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, Y4.v b10) {
                super(b10.b());
                kotlin.jvm.internal.p.i(b10, "b");
                this.this$0 = bVar;
                this.b = b10;
            }

            public static final void d(AgentTabView agentTabView, IExternalAgentBindService.ConnectedDevice connectedDevice, a aVar, View view) {
                ImageButton btnMore = aVar.b.btnMore;
                kotlin.jvm.internal.p.h(btnMore, "btnMore");
                agentTabView.x0(connectedDevice, btnMore);
            }

            public static final void e(AgentTabView agentTabView, IExternalAgentBindService.ConnectedDevice connectedDevice, View view) {
                agentTabView.g0(connectedDevice);
            }

            public final void c(final IExternalAgentBindService.ConnectedDevice device, boolean isFirst) {
                int iX;
                kotlin.jvm.internal.p.i(device, "device");
                this.b.tvDeviceName.setText(device.getDeviceName());
                TextView textView = this.b.tvDeviceDir;
                x xVar = x.INSTANCE;
                textView.setText(xVar.a(device.getAgentType()));
                this.b.dotStatus.setBackgroundResource(device.getOnline() ? R$drawable.dot_status_online : R$drawable.dot_status_offline);
                this.b.ivAgentIcon.setImageResource(xVar.b(device.getAgentType()));
                ViewGroup.LayoutParams layoutParams = this.b.b().getLayoutParams();
                kotlin.jvm.internal.p.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                AgentTabView agentTabView = AgentTabView.this;
                if (isFirst) {
                    iX = 0;
                } else {
                    iX = agentTabView.X(agentTabView.liteSheetDeviceListChrome ? 16 : 10);
                }
                marginLayoutParams.topMargin = iX;
                this.b.b().setLayoutParams(marginLayoutParams);
                ImageButton imageButton = this.b.btnMore;
                final AgentTabView agentTabView2 = AgentTabView.this;
                imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.t
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AgentTabView.b.a.d(agentTabView2, device, this, view);
                    }
                });
                LinearLayout linearLayoutB = this.b.b();
                final AgentTabView agentTabView3 = AgentTabView.this;
                linearLayoutB.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.u
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AgentTabView.b.a.e(agentTabView3, device, view);
                    }
                });
            }
        }

        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a holder, int position) {
            kotlin.jvm.internal.p.i(holder, "holder");
            holder.c(this.items.get(position), position == 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(ViewGroup parent, int viewType) {
            kotlin.jvm.internal.p.i(parent, "parent");
            Y4.v vVarC = Y4.v.c(LayoutInflater.from(parent.getContext()), parent, false);
            kotlin.jvm.internal.p.h(vVarC, "inflate(...)");
            if (AgentTabView.this.liteSheetDeviceListChrome) {
                vVarC.b().setBackgroundResource(com.stepos.ailauncher.chat.R$drawable.bg_amoo_entry_card);
            }
            return new a(this, vVarC);
        }

        public final void e(String deviceId, String agent, boolean online) {
            kotlin.jvm.internal.p.i(deviceId, "deviceId");
            kotlin.jvm.internal.p.i(agent, "agent");
            Iterator<IExternalAgentBindService.ConnectedDevice> it = this.items.iterator();
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i10 = -1;
                    break;
                }
                IExternalAgentBindService.ConnectedDevice next = it.next();
                if (kotlin.jvm.internal.p.d(next.getDeviceId(), deviceId) && kotlin.jvm.internal.p.d(next.getAgentType(), agent)) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 >= 0 && this.items.get(i10).getOnline() != online) {
                List<IExternalAgentBindService.ConnectedDevice> list = this.items;
                list.set(i10, IExternalAgentBindService.ConnectedDevice.copy$default(list.get(i10), null, null, null, online, 7, null));
                notifyItemChanged(i10);
            }
        }

        public final void f(List<IExternalAgentBindService.ConnectedDevice> list) {
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

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class c {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PageMode.values().length];
            try {
                iArr[PageMode.HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PageMode.DEVICE_LIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentTabView(final Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        G gB = G.b(LayoutInflater.from(context), this, true);
        kotlin.jvm.internal.p.h(gB, "inflate(...)");
        this.binding = gB;
        b bVar = new b();
        this.devicesAdapter = bVar;
        C2260c c2260c = new C2260c(new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentTabView.a0((AgentMarketItem) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.l
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentTabView.b0((AgentMarketItem) obj);
            }
        }, new p9.p() { // from class: com.stepos.ailauncher.agent.aispace.m
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return AgentTabView.c0((AgentMarketItem) obj, ((Boolean) obj2).booleanValue());
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.n
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentTabView.d0(context, (AgentMarketItem) obj);
            }
        });
        this.marketAdapter = c2260c;
        this.marketItems = C1173v.m();
        this.marketPage = 1;
        this.pageMode = PageMode.HOME;
        this.viewScope = e0();
        gB.stateEmpty.cardStepAgent.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentTabView.t(this.f24228a, view);
            }
        });
        gB.stateEmpty.cardOtherAgent.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentTabView.u(this.f24229a, view);
            }
        });
        gB.stateConnected.rvConnectedDevices.setLayoutManager(new LinearLayoutManager(context));
        gB.stateConnected.rvConnectedDevices.setAdapter(bVar);
        gB.stateConnected.rvConnectedDevices.addItemDecoration(new E(context, null, 2, null));
        gB.stateConnected.cardAddAgent.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentTabView.v(this.f24230a, view);
            }
        });
        gB.stateConnected.rvMarket.setLayoutManager(new LinearLayoutManager(context));
        gB.stateConnected.rvMarket.setAdapter(c2260c);
        gB.stateConnected.rvMarket.addItemDecoration(new E(context, null, 2, null));
        gB.stateConnected.svAgentContent.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.stepos.ailauncher.agent.aispace.r
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i11, int i12, int i13, int i14) {
                AgentTabView.w(this.f24231a, view, i11, i12, i13, i14);
            }
        });
        SwipeRefreshLayout swipeRefreshAgent = gB.stateConnected.swipeRefreshAgent;
        b5.m mVar = b5.m.INSTANCE;
        kotlin.jvm.internal.p.h(swipeRefreshAgent, "swipeRefreshAgent");
        swipeRefreshAgent.setColorSchemeColors(mVar.h(swipeRefreshAgent));
        gB.stateConnected.swipeRefreshAgent.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.stepos.ailauncher.agent.aispace.s
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void a() {
                AgentTabView.x(this.f24232a);
            }
        });
        gB.stateConnected.cardEntryStep.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentTabView.y(context, view);
            }
        });
        gB.stateConnected.cardEntryRemote.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentTabView.z(context, view);
            }
        });
        ViewGroup.LayoutParams layoutParams = gB.stateConnected.cardAddAgent.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.bottomMargin = X(44);
            gB.stateConnected.cardAddAgent.setLayoutParams(layoutParams2);
        }
        gB.stateConnected.svAgentContent.setPadding(0, X(4), 0, X(104));
        gB.stateEmpty.b().setVisibility(8);
        gB.stateConnected.b().setVisibility(8);
        AgentEntranceResponseData agentEntranceResponseDataA = AgentEntranceCache.INSTANCE.a();
        if (agentEntranceResponseDataA != null) {
            T(agentEntranceResponseDataA);
        }
        n0();
    }

    public static final Y8.t A0(IExternalAgentBindService.ConnectedDevice connectedDevice, AgentTabView agentTabView) {
        W4.c cVar = W4.c.INSTANCE;
        cVar.k("disconnect", cVar.s(connectedDevice.getAgentType()));
        agentTabView.u0(connectedDevice);
        return Y8.t.f7040a;
    }

    public static final Y8.t C0(AgentTabView agentTabView, IExternalAgentBindService.ConnectedDevice connectedDevice, String newName) {
        kotlin.jvm.internal.p.i(newName, "newName");
        C1060i.d(agentTabView.q0(), null, null, new AgentTabView$showRenameDialog$1$1(agentTabView, newName, connectedDevice, null), 3, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t a0(AgentMarketItem it) {
        kotlin.jvm.internal.p.i(it, "it");
        AgentMarketOperaManager.INSTANCE.y(it);
        return Y8.t.f7040a;
    }

    public static final Y8.t b0(AgentMarketItem it) {
        kotlin.jvm.internal.p.i(it, "it");
        AgentMarketOperaManager.INSTANCE.U(it);
        return Y8.t.f7040a;
    }

    public static final Y8.t c0(AgentMarketItem item, boolean z10) {
        kotlin.jvm.internal.p.i(item, "item");
        AgentMarketOperaManager.INSTANCE.N(item, z10);
        return Y8.t.f7040a;
    }

    public static final Y8.t d0(Context context, AgentMarketItem it) {
        kotlin.jvm.internal.p.i(it, "it");
        AgentMarketDetailActivity.INSTANCE.a(context, it);
        return Y8.t.f7040a;
    }

    public static final Y8.t s0(AgentTabView agentTabView) {
        agentTabView.k0();
        return Y8.t.f7040a;
    }

    public static final void t(AgentTabView agentTabView, View view) {
        agentTabView.k0();
    }

    public static final Y8.t t0(AgentTabView agentTabView) {
        agentTabView.j0(W4.c.SOURCE_ADD_AGENT);
        return Y8.t.f7040a;
    }

    public static final void u(AgentTabView agentTabView, View view) {
        agentTabView.j0(W4.c.SOURCE_UNCONNECTED);
    }

    public static final void v(AgentTabView agentTabView, View view) {
        agentTabView.r0();
    }

    public static final Y8.t v0(IExternalAgentBindService.ConnectedDevice connectedDevice, AgentTabView agentTabView) {
        W4.c cVar = W4.c.INSTANCE;
        cVar.j("confirm", cVar.s(connectedDevice.getAgentType()));
        C1060i.d(agentTabView.q0(), null, null, new AgentTabView$showDisconnectDialog$1$1(agentTabView, connectedDevice, null), 3, null);
        return Y8.t.f7040a;
    }

    public static final void w(AgentTabView agentTabView, View view, int i10, int i11, int i12, int i13) {
        kotlin.jvm.internal.p.g(view, "null cannot be cast to non-null type androidx.core.widget.NestedScrollView");
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        View childAt = nestedScrollView.getChildAt(0);
        if (childAt == null) {
            return;
        }
        boolean z10 = i11 >= (childAt.getMeasuredHeight() - nestedScrollView.getHeight()) + AbstractC4898a.ERROR_AGENT_INTERNAL_ERROR;
        if (agentTabView.pageMode != PageMode.HOME || !z10 || agentTabView.marketLoading || agentTabView.marketAdapter.getItemCount() >= agentTabView.marketTotal) {
            return;
        }
        agentTabView.Z();
    }

    public static final Y8.t w0(IExternalAgentBindService.ConnectedDevice connectedDevice) {
        W4.c cVar = W4.c.INSTANCE;
        cVar.j("cancel", cVar.s(connectedDevice.getAgentType()));
        return Y8.t.f7040a;
    }

    public static final void x(AgentTabView agentTabView) {
        agentTabView.n0();
    }

    public static final void y(Context context, View view) {
        ConnectedAgentsActivity.Companion.a(context, ConnectedAgentsActivity.FILTER_STEPAI);
    }

    public static final Y8.t y0(IExternalAgentBindService.ConnectedDevice connectedDevice, AgentTabView agentTabView) {
        W4.c cVar = W4.c.INSTANCE;
        cVar.k(W4.c.MANAGE_RENAME, cVar.s(connectedDevice.getAgentType()));
        agentTabView.B0(connectedDevice);
        return Y8.t.f7040a;
    }

    public static final void z(Context context, View view) {
        ConnectedAgentsActivity.Companion.a(context, "remote");
    }

    public static final Y8.t z0(IExternalAgentBindService.ConnectedDevice connectedDevice, AgentTabView agentTabView) {
        W4.c cVar = W4.c.INSTANCE;
        cVar.k("reconnect", cVar.s(connectedDevice.getAgentType()));
        agentTabView.m0(connectedDevice);
        return Y8.t.f7040a;
    }

    public final void B0(final IExternalAgentBindService.ConnectedDevice device) {
        this.dismissActiveOverlay = Q0.INSTANCE.m(this, device.getDeviceName(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentTabView.C0(this.f24127a, device, (String) obj);
            }
        });
    }

    public final void D0() {
        if (this.collectorsStarted) {
            return;
        }
        this.collectorsStarted = true;
        M mQ0 = q0();
        C1060i.d(mQ0, null, null, new AgentTabView$startCollectors$1(this, null), 3, null);
        C1060i.d(mQ0, null, null, new AgentTabView$startCollectors$2(this, null), 3, null);
        C1060i.d(mQ0, null, null, new AgentTabView$startCollectors$3(this, null), 3, null);
        C1060i.d(mQ0, null, null, new AgentTabView$startCollectors$4(this, null), 3, null);
        C1060i.d(mQ0, null, null, new AgentTabView$startCollectors$5(null), 3, null);
        C1060i.d(mQ0, null, null, new AgentTabView$startCollectors$6(this, null), 3, null);
    }

    public final void E0(int resId) {
        String string = getContext().getString(resId);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        F0(string);
    }

    public final void F0(CharSequence text) {
        ToastUtils.o().q(-231591374).r(-1).t(text);
    }

    public final void T(AgentEntranceResponseData data) {
        AgentEntranceGroup stepai = data.getStepai();
        if (stepai != null) {
            if (!H.x0(stepai.getTitle())) {
                this.binding.stateEmpty.tvStepTitle.setText(stepai.getTitle());
            }
            if (!H.x0(stepai.getDescription())) {
                this.binding.stateEmpty.tvStepDesc.setText(stepai.getDescription());
            }
        }
        AgentEntranceGroup otherAgents = data.getOtherAgents();
        if (otherAgents != null) {
            if (!H.x0(otherAgents.getTitle())) {
                this.binding.stateEmpty.tvOtherTitle.setText(otherAgents.getTitle());
            }
            if (H.x0(otherAgents.getDescription())) {
                return;
            }
            this.binding.stateEmpty.tvOtherDesc.setText(otherAgents.getDescription());
        }
    }

    public final void U() {
        this.binding.stateEmpty.b().setPadding(X(16), this.binding.stateEmpty.b().getPaddingTop(), X(16), this.binding.stateEmpty.b().getPaddingBottom());
        this.binding.stateEmpty.cardStepAgent.setPadding(X(16), this.binding.stateEmpty.cardStepAgent.getPaddingTop(), X(16), this.binding.stateEmpty.cardStepAgent.getPaddingBottom());
        this.binding.stateEmpty.cardOtherAgent.setPadding(X(16), this.binding.stateEmpty.cardOtherAgent.getPaddingTop(), X(16), this.binding.stateEmpty.cardOtherAgent.getPaddingBottom());
        this.binding.stateConnected.cardAddAgent.setVisibility(8);
        this.binding.stateConnected.svAgentContent.setPadding(0, X(4), 0, X(24));
        RecyclerView rvConnectedDevices = this.binding.stateConnected.rvConnectedDevices;
        kotlin.jvm.internal.p.h(rvConnectedDevices, "rvConnectedDevices");
        while (rvConnectedDevices.getItemDecorationCount() > 0) {
            rvConnectedDevices.removeItemDecorationAt(0);
        }
    }

    public final void V() {
        this.liteSheetDeviceListChrome = true;
        U();
        W(PageMode.DEVICE_LIST);
    }

    public final void W(PageMode mode) {
        kotlin.jvm.internal.p.i(mode, "mode");
        if (this.pageMode == mode) {
            return;
        }
        this.pageMode = mode;
        if (mode != PageMode.HOME) {
            this.pageShowReported = false;
            this.marketAdapter.k();
        }
        n0();
    }

    public final int X(int value) {
        return (int) (value * getResources().getDisplayMetrics().density);
    }

    public final Activity Y(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public final void Z() {
        this.marketLoading = true;
        C1060i.d(q0(), null, null, new AgentTabView$loadMoreMarket$1(this, this.marketPage + 1, null), 3, null);
    }

    public final M e0() {
        return kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.c().getImmediate()));
    }

    public final boolean f0() {
        I i10 = I.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        if (i10.b(context)) {
            return false;
        }
        E0(R$string.agent_market_toast_network_unavailable);
        return true;
    }

    public final void g0(IExternalAgentBindService.ConnectedDevice device) {
        if (device.getOnline()) {
            C1060i.d(q0(), null, null, new AgentTabView$onDeviceCellClicked$1(device, this, null), 3, null);
        } else {
            E0(R$string.connected_devices_offline_toast);
        }
    }

    public final void h0(IExternalAgentBindService.ConnectedDevice device) {
        C1060i.d(q0(), Y.b(), null, new AgentTabView$openExternalChat$1(device, null), 2, null);
        if (i0(device)) {
            return;
        }
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        C2739j.z(context, null, SheetHeightMode.FULL_9, null, device.getAgentType(), device.getDeviceId(), device.getDeviceName(), 10, null);
    }

    public final boolean i0(IExternalAgentBindService.ConnectedDevice device) throws Resources.NotFoundException {
        if (!this.liteSheetDeviceListChrome) {
            return false;
        }
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        Activity activityY = Y(context);
        S s10 = activityY instanceof S ? (S) activityY : null;
        if (s10 == null || !DesktopChatResidentController.M0(device.getAgentType(), device.getDeviceId(), device.getDeviceName())) {
            return false;
        }
        s10.g1();
        return true;
    }

    public final void j0(String entrySource) {
        if (l0(SelectExternalAgentFragment.INSTANCE.a(), SelectExternalAgentFragment.TAG)) {
            return;
        }
        SelectExternalAgentActivity.Companion companion = SelectExternalAgentActivity.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        companion.a(context, entrySource);
    }

    public final void k0() {
        IExternalAgentUiService iExternalAgentUiService = (IExternalAgentUiService) D5.a.INSTANCE.a(IExternalAgentUiService.class);
        Fragment fragmentCreateConnectFragment$default = iExternalAgentUiService != null ? IExternalAgentUiService.createConnectFragment$default(iExternalAgentUiService, ExternalAgent.STEPAI.getId(), null, 2, null) : null;
        if (fragmentCreateConnectFragment$default == null || !l0(fragmentCreateConnectFragment$default, ExternalAgent.STEPAI.getId())) {
            getContext().startActivity(new Intent(getContext(), (Class<?>) ConnectStepAgentActivity.class));
        }
    }

    public final boolean l0(Fragment fragment, String tag) {
        if (!this.liteSheetDeviceListChrome) {
            return false;
        }
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        Activity activityY = Y(context);
        S s10 = activityY instanceof S ? (S) activityY : null;
        if (s10 == null) {
            return false;
        }
        com.stepos.ailauncher.sheet.nav.h.G(s10.t4(), fragment, tag, null, null, null, 28, null);
        return true;
    }

    public final void m0(IExternalAgentBindService.ConnectedDevice device) {
        C1060i.d(q0(), null, null, new AgentTabView$refreshDeviceLink$1(this, device, null), 3, null);
    }

    public final void n0() {
        int i10 = c.$EnumSwitchMapping$0[this.pageMode.ordinal()];
        if (i10 == 1) {
            p0();
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            o0();
        }
    }

    public final void o0() {
        this.binding.stateConnected.llEntryCards.setVisibility(8);
        this.binding.stateConnected.tvMarketTitle.setVisibility(8);
        this.binding.stateConnected.containerMarket.setVisibility(8);
        C1060i.d(q0(), null, null, new AgentTabView$renderDeviceList$1(this, null), 3, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        D0();
    }

    @Override // com.stepos.ailauncher.contract.api.aispace.IAiSpaceTabView
    public /* bridge */ boolean onBackPressed() {
        return super.onBackPressed();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InterfaceC5063a<Y8.t> interfaceC5063a = this.dismissActiveOverlay;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        this.dismissActiveOverlay = null;
        this.collectorsStarted = false;
        this.pageShowReported = false;
        this.marketAdapter.k();
        kotlinx.coroutines.d.e(this.viewScope, null, 1, null);
    }

    @Override // com.stepos.ailauncher.contract.api.aispace.IAiSpaceTabView
    public /* bridge */ void onTabCreate() {
        super.onTabCreate();
    }

    @Override // com.stepos.ailauncher.contract.api.aispace.IAiSpaceTabView
    public /* bridge */ void onTabDestroy() {
        super.onTabDestroy();
    }

    @Override // com.stepos.ailauncher.contract.api.aispace.IAiSpaceTabView
    public void onTabSelected() {
        n0();
        U5.b.INSTANCE.r(SpriteEventAction.SPACE_AGENT_TEAM_SWITCH);
    }

    @Override // com.stepos.ailauncher.contract.api.aispace.IAiSpaceTabView
    public void onTabUnselected() {
        InterfaceC5063a<Y8.t> interfaceC5063a = this.dismissActiveOverlay;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        this.dismissActiveOverlay = null;
        this.pageShowReported = false;
        this.marketAdapter.k();
    }

    public final void p0() {
        if (!this.pageShowReported) {
            this.pageShowReported = true;
            W4.a.INSTANCE.g();
        }
        this.binding.stateEmpty.b().setVisibility(8);
        this.binding.stateConnected.b().setVisibility(0);
        this.binding.stateConnected.llEntryCards.setVisibility(0);
        this.binding.stateConnected.rvConnectedDevices.setVisibility(8);
        this.binding.stateConnected.cardAddAgent.setVisibility(8);
        this.marketPage = 1;
        this.marketLoading = true;
        C1060i.d(q0(), null, null, new AgentTabView$renderHome$1(this, null), 3, null);
    }

    public final M q0() {
        if (!kotlinx.coroutines.d.h(this.viewScope)) {
            this.viewScope = e0();
        }
        return this.viewScope;
    }

    public final void r0() {
        W4.c.b(W4.c.INSTANCE, null, 1, null);
        AddAgentBottomSheet.INSTANCE.f(this, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentTabView.s0(this.f24125a);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentTabView.t0(this.f24126a);
            }
        });
    }

    public final void u0(final IExternalAgentBindService.ConnectedDevice device) {
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        Activity activityY = Y(context);
        if (activityY == null) {
            return;
        }
        C2216l0.INSTANCE.a(activityY, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.i
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentTabView.v0(device, this);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentTabView.w0(device);
            }
        });
    }

    public final void x0(final IExternalAgentBindService.ConnectedDevice device, View anchor) {
        this.dismissActiveOverlay = C2236w.INSTANCE.j(this, anchor, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentTabView.y0(device, this);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentTabView.z0(device, this);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentTabView.A0(device, this);
            }
        });
    }

    public /* synthetic */ AgentTabView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
