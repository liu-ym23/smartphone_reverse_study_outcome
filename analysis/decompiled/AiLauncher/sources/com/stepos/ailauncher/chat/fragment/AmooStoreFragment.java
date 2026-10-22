package com.stepos.ailauncher.chat.fragment;

import Ua.C1060i;
import Z8.C1173v;
import Z8.C1174w;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.C1398p;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailFragment;
import com.stepos.ailauncher.agent.aispace.market.ConnectedAgentsFragment;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.adapter.C2495a;
import com.stepos.ailauncher.chat.adapter.C2503i;
import com.stepos.ailauncher.chat.fragment.AmooSkillListFragment;
import com.stepos.ailauncher.chat.manager.AmooStoreBadgeState;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.chat.view.C2796d7;
import com.stepos.ailauncher.chat.view.K7;
import com.stepos.ailauncher.chat.view.PagedListController;
import com.stepos.ailauncher.chat.view.Z8;
import com.stepos.ailauncher.contract.api.agent.IAgentMarketService;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentUiService;
import com.stepos.ailauncher.contract.api.skill.ISkillUiService;
import com.stepos.ailauncher.contract.model.MarketAgentBrief;
import com.stepos.ailauncher.contract.model.SkillItemBrief;
import com.stepos.ailauncher.foundation.appstore.api.AppVersionItem;
import com.stepos.ailauncher.sheet.R$anim;
import com.stepos.ailauncher.sheet.R$id;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Ref$IntRef;
import p9.InterfaceC5074l;
import v9.C5685n;
import y7.G;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ^2\u00020\u0001:\u0001_B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001cH\u0002¢\u0006\u0004\b \u0010\u001eJ\u000f\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010\u0003J\u0011\u0010'\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010\u0003J\u000f\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010\u0003J\u000f\u0010+\u001a\u00020\u0006H\u0002¢\u0006\u0004\b+\u0010\u0003J!\u0010.\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0006H\u0016¢\u0006\u0004\b0\u0010\u0003J\u000f\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0004\b1\u0010\u0003J\r\u00102\u001a\u00020\u0006¢\u0006\u0004\b2\u0010\u0003J\r\u00103\u001a\u00020\u0006¢\u0006\u0004\b3\u0010\u0003J\r\u00104\u001a\u00020\u0006¢\u0006\u0004\b4\u0010\u0003R\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u0011058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\u001c058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00107R\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u001c058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00107R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001c058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00107R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001c058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00107R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00110<8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b=\u0010>R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001c0<8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b?\u0010>R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020\u0018058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u00107R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00180<8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bA\u0010>R\u0016\u0010B\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010CR\u0016\u0010E\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010CR\u0016\u0010F\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010CR$\u0010J\u001a\u0012\u0012\u0004\u0012\u00020H0Gj\b\u0012\u0004\u0012\u00020H`I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010L\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010CR\u0018\u0010N\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010Q\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010U\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010TR\u0014\u0010V\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010TR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010[\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010\u0010R\u0014\u0010]\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010\u0010¨\u0006`"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/AmooStoreFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "Landroid/view/View;", "view", "LY8/t;", "n0", "(Landroid/view/View;)V", "z0", "A0", "t1", "y0", "q1", "", "l1", "()Z", "Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;", "agent", "f1", "(Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;)V", "w0", "r1", "k1", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionItem;", "item", "g1", "(Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionItem;)V", "Lcom/stepos/ailauncher/contract/model/SkillItemBrief;", "h1", "(Lcom/stepos/ailauncher/contract/model/SkillItemBrief;)V", "x0", "s1", "Lcom/stepos/ailauncher/chat/adapter/h0;", "o0", "()Lcom/stepos/ailauncher/chat/adapter/h0;", "i1", "j1", "p1", "v0", "()Landroid/view/View;", "o1", "n1", "m1", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "u0", "t0", "s0", "", "marketItems", "Ljava/util/List;", "cliItems", "mustHaveItems", "communityItems", "otherItems", "Lcom/stepos/ailauncher/chat/view/PagedListController;", "marketPages", "Lcom/stepos/ailauncher/chat/view/PagedListController;", "otherPages", "aiAppItems", "appPages", "aiAppLoadError", "Z", "agentLoadError", "skillLoadError", "aiAppLoadedOnce", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "aiAppExposedIds", "Ljava/util/HashSet;", "aiAppModulesExposed", "Lkotlinx/coroutines/g;", "actionStateJob", "Lkotlinx/coroutines/g;", "Lcom/stepos/ailauncher/chat/adapter/a;", "marketAdapter", "Lcom/stepos/ailauncher/chat/adapter/a;", "mustHavesAdapter", "Lcom/stepos/ailauncher/chat/adapter/h0;", "communityWorksAdapter", "otherSkillsAdapter", "Lcom/stepos/ailauncher/chat/adapter/i;", "aiAppsAdapter", "Lcom/stepos/ailauncher/chat/adapter/i;", "e", "extendsContentToBottomEdge", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "showsSheetDragHandle", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AmooStoreFragment extends com.stepos.ailauncher.sheet.nav.a {
    private static final int APP_PAGE_SIZE = 15;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int LOAD_MORE_THRESHOLD_PX = 300;
    private static final int MARKET_PAGE_SIZE = 20;
    private static final int SECTION_PREVIEW_COUNT = 3;
    private static final int SKILL_PAGE_SIZE = 20;
    private static final int TAB_AGENT = 1;
    private static final int TAB_APP = 2;
    private static final int TAB_SKILL = 0;
    public static final String TAG = "amoo_store";
    private static final String TAG_AGENT_SEARCH_OVERLAY = "amoo_store_agent_search_overlay";
    private static final String TAG_APP_SEARCH_OVERLAY = "amoo_store_app_search_overlay";
    private static final String TAG_SEARCH_OVERLAY = "amoo_store_search_overlay";
    private kotlinx.coroutines.g actionStateJob;
    private boolean agentLoadError;
    private final HashSet<Long> aiAppExposedIds;
    private List<AppVersionItem> aiAppItems;
    private boolean aiAppLoadError;
    private boolean aiAppLoadedOnce;
    private boolean aiAppModulesExposed;
    private final C2503i aiAppsAdapter;
    private PagedListController<AppVersionItem> appPages;
    private List<SkillItemBrief> cliItems;
    private List<SkillItemBrief> communityItems;
    private final com.stepos.ailauncher.chat.adapter.h0 communityWorksAdapter;
    private final C2495a marketAdapter;
    private List<MarketAgentBrief> marketItems;
    private PagedListController<MarketAgentBrief> marketPages;
    private List<SkillItemBrief> mustHaveItems;
    private final com.stepos.ailauncher.chat.adapter.h0 mustHavesAdapter;
    private List<SkillItemBrief> otherItems;
    private PagedListController<SkillItemBrief> otherPages;
    private final com.stepos.ailauncher.chat.adapter.h0 otherSkillsAdapter;
    private boolean skillLoadError;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0014\u0010\u0014\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\tR\u0014\u0010\u0015\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\tR\u0014\u0010\u0016\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/AmooStoreFragment$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/fragment/AmooStoreFragment;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/chat/fragment/AmooStoreFragment;", "", "TAG", "Ljava/lang/String;", "", "SECTION_PREVIEW_COUNT", "I", "SKILL_PAGE_SIZE", "MARKET_PAGE_SIZE", "APP_PAGE_SIZE", "LOAD_MORE_THRESHOLD_PX", "TAB_SKILL", "TAB_AGENT", "TAB_APP", "TAG_SEARCH_OVERLAY", "TAG_APP_SEARCH_OVERLAY", "TAG_AGENT_SEARCH_OVERLAY", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.fragment.AmooStoreFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final AmooStoreFragment a() {
            return new AmooStoreFragment();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/stepos/ailauncher/chat/fragment/AmooStoreFragment$b", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements View.OnLayoutChangeListener {
        public b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            AmooStoreFragment.this.k1();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.fragment.AmooStoreFragment$onViewCreated$20, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass20 extends FunctionReferenceImpl implements p9.q<View, Boolean, Float, y7.E> {
        public AnonymousClass20(Object obj) {
            super(3, obj, K7.class, "attach", "attach(Landroid/view/View;ZLjava/lang/Float;)Lcom/stepos/motionkit/fx/material/MaterialHandle;", 0);
        }

        @Override // p9.q
        public /* bridge */ /* synthetic */ y7.E invoke(View view, Boolean bool, Float f10) {
            return l(view, bool.booleanValue(), f10);
        }

        public final y7.E l(View p02, boolean z10, Float f10) {
            kotlin.jvm.internal.p.i(p02, "p0");
            return ((K7) this.receiver).f(p02, z10, f10);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.fragment.AmooStoreFragment$onViewCreated$21, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass21 extends FunctionReferenceImpl implements p9.q<View, Boolean, Float, y7.E> {
        public AnonymousClass21(Object obj) {
            super(3, obj, K7.class, "attach", "attach(Landroid/view/View;ZLjava/lang/Float;)Lcom/stepos/motionkit/fx/material/MaterialHandle;", 0);
        }

        @Override // p9.q
        public /* bridge */ /* synthetic */ y7.E invoke(View view, Boolean bool, Float f10) {
            return l(view, bool.booleanValue(), f10);
        }

        public final y7.E l(View p02, boolean z10, Float f10) {
            kotlin.jvm.internal.p.i(p02, "p0");
            return ((K7) this.receiver).f(p02, z10, f10);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.fragment.AmooStoreFragment$onViewCreated$22, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass22 extends FunctionReferenceImpl implements p9.q<View, Boolean, Float, y7.E> {
        public AnonymousClass22(Object obj) {
            super(3, obj, K7.class, "attach", "attach(Landroid/view/View;ZLjava/lang/Float;)Lcom/stepos/motionkit/fx/material/MaterialHandle;", 0);
        }

        @Override // p9.q
        public /* bridge */ /* synthetic */ y7.E invoke(View view, Boolean bool, Float f10) {
            return l(view, bool.booleanValue(), f10);
        }

        public final y7.E l(View p02, boolean z10, Float f10) {
            kotlin.jvm.internal.p.i(p02, "p0");
            return ((K7) this.receiver).f(p02, z10, f10);
        }
    }

    public AmooStoreFragment() {
        super(R$layout.fragment_amoo_store);
        this.marketItems = C1173v.m();
        this.cliItems = C1173v.m();
        this.mustHaveItems = C1173v.m();
        this.communityItems = C1173v.m();
        this.otherItems = C1173v.m();
        this.aiAppItems = C1173v.m();
        this.aiAppExposedIds = new HashSet<>();
        this.marketAdapter = new C2495a(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.Y
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooStoreFragment.B0(this.f25228a, (MarketAgentBrief) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.j0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooStoreFragment.C0(this.f25296a, (MarketAgentBrief) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.u0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooStoreFragment.D0(this.f25340a, (MarketAgentBrief) obj);
            }
        }, false, 8, null);
        this.mustHavesAdapter = o0();
        this.communityWorksAdapter = o0();
        this.otherSkillsAdapter = o0();
        this.aiAppsAdapter = new C2503i(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.x0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooStoreFragment.m0(this.f25353a, (AppVersionItem) obj);
            }
        }, null, 2, null);
    }

    public static final Y8.t B0(AmooStoreFragment amooStoreFragment, MarketAgentBrief agent) {
        kotlin.jvm.internal.p.i(agent, "agent");
        amooStoreFragment.w0(agent);
        return Y8.t.f7040a;
    }

    public static final Y8.t C0(AmooStoreFragment amooStoreFragment, MarketAgentBrief agent) {
        kotlin.jvm.internal.p.i(agent, "agent");
        amooStoreFragment.r1(agent);
        return Y8.t.f7040a;
    }

    public static final Y8.t D0(AmooStoreFragment amooStoreFragment, MarketAgentBrief agent) {
        kotlin.jvm.internal.p.i(agent, "agent");
        amooStoreFragment.f1(agent);
        return Y8.t.f7040a;
    }

    public static final void E0(List list, Ref$IntRef ref$IntRef, View view, l5.h hVar, View view2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        c1(list, ref$IntRef, view, hVar, false);
    }

    public static final void F0(AmooStoreFragment amooStoreFragment, NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
        kotlin.jvm.internal.p.i(nestedScrollView, "<unused var>");
        amooStoreFragment.k1();
    }

    public static final String G0(MarketAgentBrief it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getAssetId();
    }

    public static final Y8.t H0(AmooStoreFragment amooStoreFragment, l5.h hVar, C2796d7 state) {
        kotlin.jvm.internal.p.i(state, "state");
        amooStoreFragment.marketItems = state.f();
        amooStoreFragment.agentLoadError = state.getError() != null && amooStoreFragment.marketItems.isEmpty();
        amooStoreFragment.marketAdapter.l(amooStoreFragment.marketItems);
        hVar.cardMarket.setVisibility(amooStoreFragment.agentLoadError ? 8 : 0);
        amooStoreFragment.t1();
        amooStoreFragment.i1();
        return Y8.t.f7040a;
    }

    public static final String I0(SkillItemBrief it) {
        kotlin.jvm.internal.p.i(it, "it");
        String id = it.getId();
        if (id != null) {
            return id;
        }
        String name = it.getName();
        return name == null ? "" : name;
    }

    public static final Y8.t J0(AmooStoreFragment amooStoreFragment, C2796d7 state) {
        kotlin.jvm.internal.p.i(state, "state");
        amooStoreFragment.otherItems = state.f();
        amooStoreFragment.q1();
        amooStoreFragment.t1();
        return Y8.t.f7040a;
    }

    public static final String K0(AppVersionItem it) {
        kotlin.jvm.internal.p.i(it, "it");
        String packageName = it.getPackageName();
        if (packageName != null) {
            if (La.H.x0(packageName)) {
                packageName = null;
            }
            if (packageName != null) {
                return packageName;
            }
        }
        return String.valueOf(it.getId());
    }

    public static final Y8.t L0(final AmooStoreFragment amooStoreFragment, l5.h hVar, View view, C2796d7 state) {
        kotlin.jvm.internal.p.i(state, "state");
        amooStoreFragment.aiAppItems = state.f();
        amooStoreFragment.aiAppLoadError = state.getError() != null && amooStoreFragment.aiAppItems.isEmpty();
        amooStoreFragment.aiAppsAdapter.g(amooStoreFragment.aiAppItems);
        hVar.cardAiApps.setVisibility(amooStoreFragment.aiAppLoadError ? 8 : 0);
        amooStoreFragment.t1();
        view.post(new Runnable() { // from class: com.stepos.ailauncher.chat.fragment.w0
            @Override // java.lang.Runnable
            public final void run() {
                AmooStoreFragment.M0(this.f25350a);
            }
        });
        return Y8.t.f7040a;
    }

    public static final void M0(AmooStoreFragment amooStoreFragment) {
        amooStoreFragment.k1();
    }

    public static final void N0(AmooStoreFragment amooStoreFragment, View view) {
        if (amooStoreFragment.l1()) {
            com.stepos.ailauncher.sheet.nav.a.z(amooStoreFragment, V1.INSTANCE.a(), V1.TAG, null, null, null, 28, null);
        }
    }

    public static final void O0(AmooStoreFragment amooStoreFragment, View view) {
        if (amooStoreFragment.l1()) {
            AmooSkillListFragment.Companion companion = AmooSkillListFragment.INSTANCE;
            String string = amooStoreFragment.getString(R$string.amoo_store_skill_must_haves);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            com.stepos.ailauncher.sheet.nav.a.z(amooStoreFragment, AmooSkillListFragment.Companion.b(companion, string, 1, true, false, Z8.F.S0(amooStoreFragment.cliItems, amooStoreFragment.mustHaveItems), 8, null), "skill_list_must_haves", null, null, null, 28, null);
        }
    }

    public static final void P0(AmooStoreFragment amooStoreFragment, View view) {
        if (amooStoreFragment.l1()) {
            AmooSkillListFragment.Companion companion = AmooSkillListFragment.INSTANCE;
            String string = amooStoreFragment.getString(R$string.amoo_store_skill_community_works);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            com.stepos.ailauncher.sheet.nav.a.z(amooStoreFragment, AmooSkillListFragment.Companion.b(companion, string, 2, false, false, amooStoreFragment.communityItems, 8, null), "skill_list_community", null, null, null, 28, null);
        }
    }

    public static final Y8.t Q0(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    public static final Y8.t R0(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    public static final void S0(AmooStoreFragment amooStoreFragment, View view) {
        amooStoreFragment.o();
    }

    public static final void T0(AmooStoreFragment amooStoreFragment, View view) {
        if (amooStoreFragment.l1()) {
            amooStoreFragment.o1();
        }
    }

    public static final void U0(AmooStoreFragment amooStoreFragment, View view) {
        if (amooStoreFragment.l1()) {
            com.stepos.ailauncher.chat.trace.a.INSTANCE.d("search");
            amooStoreFragment.n1();
        }
    }

    public static final void V0(AmooStoreFragment amooStoreFragment, View view) {
        if (amooStoreFragment.l1()) {
            com.stepos.ailauncher.chat.trace.a.INSTANCE.d("installed");
            com.stepos.ailauncher.sheet.nav.a.z(amooStoreFragment, AmooInstalledAppsFragment.INSTANCE.a(), "installed_apps", null, null, null, 28, null);
        }
    }

    public static final void W0(AmooStoreFragment amooStoreFragment, View view) {
        if (amooStoreFragment.l1()) {
            amooStoreFragment.m1();
        }
    }

    public static final void X0(AmooStoreFragment amooStoreFragment, View view) {
        IExternalAgentUiService iExternalAgentUiService;
        Fragment fragmentCreateConnectedAgentsFragment;
        if (!amooStoreFragment.l1() || (iExternalAgentUiService = (IExternalAgentUiService) D5.a.INSTANCE.a(IExternalAgentUiService.class)) == null || (fragmentCreateConnectedAgentsFragment = iExternalAgentUiService.createConnectedAgentsFragment()) == null) {
            return;
        }
        com.stepos.ailauncher.sheet.nav.a.z(amooStoreFragment, fragmentCreateConnectedAgentsFragment, ConnectedAgentsFragment.TAG, null, null, null, 28, null);
    }

    public static final void Y0(AmooStoreFragment amooStoreFragment, View view) {
        Fragment fragmentCreateInstalledSkillsFragment;
        if (amooStoreFragment.l1()) {
            AmooStoreBadgeState.INSTANCE.f();
            ISkillUiService iSkillUiService = (ISkillUiService) D5.a.INSTANCE.a(ISkillUiService.class);
            if (iSkillUiService != null && (fragmentCreateInstalledSkillsFragment = iSkillUiService.createInstalledSkillsFragment()) != null) {
                com.stepos.ailauncher.sheet.nav.a.z(amooStoreFragment, fragmentCreateInstalledSkillsFragment, "installed_skills", null, null, null, 28, null);
            } else {
                if (iSkillUiService == null) {
                    Toast.makeText(amooStoreFragment.requireContext(), R$string.amoo_store_installed_skills, 0).show();
                    return;
                }
                Context contextRequireContext = amooStoreFragment.requireContext();
                kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
                iSkillUiService.openInstalledSkills(contextRequireContext);
            }
        }
    }

    public static final void Z0(AmooStoreFragment amooStoreFragment, Ref$IntRef ref$IntRef, List list, NestedScrollView nestedScrollView, NestedScrollView nestedScrollView2, NestedScrollView nestedScrollView3, View view, View view2, View view3, View view4, View view5, View view6, l5.h hVar, View view7) {
        if (amooStoreFragment.l1()) {
            d1(ref$IntRef, list, nestedScrollView, nestedScrollView2, nestedScrollView3, amooStoreFragment, view, view2, view3, view4, view5, view6, hVar, 0);
        }
    }

    public static final void a1(AmooStoreFragment amooStoreFragment, Ref$IntRef ref$IntRef, List list, NestedScrollView nestedScrollView, NestedScrollView nestedScrollView2, NestedScrollView nestedScrollView3, View view, View view2, View view3, View view4, View view5, View view6, l5.h hVar, View view7) {
        if (amooStoreFragment.l1()) {
            d1(ref$IntRef, list, nestedScrollView, nestedScrollView2, nestedScrollView3, amooStoreFragment, view, view2, view3, view4, view5, view6, hVar, 1);
        }
    }

    public static final void b1(AmooStoreFragment amooStoreFragment, Ref$IntRef ref$IntRef, List list, NestedScrollView nestedScrollView, NestedScrollView nestedScrollView2, NestedScrollView nestedScrollView3, View view, View view2, View view3, View view4, View view5, View view6, l5.h hVar, View view7) {
        if (amooStoreFragment.l1()) {
            d1(ref$IntRef, list, nestedScrollView, nestedScrollView2, nestedScrollView3, amooStoreFragment, view, view2, view3, view4, view5, view6, hVar, 2);
        }
    }

    public static final void c1(List<? extends TextView> list, Ref$IntRef ref$IntRef, View view, l5.h hVar, boolean z10) {
        TextView textView = list.get(ref$IntRef.f34818a);
        if (textView.getWidth() == 0) {
            return;
        }
        if (view.getLayoutParams().width != textView.getWidth()) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = textView.getWidth();
            view.setLayoutParams(layoutParams);
        }
        float right = hVar.tabBar.getLayoutDirection() == 1 ? textView.getRight() - hVar.tabOptions.getWidth() : textView.getLeft();
        view.animate().cancel();
        if (z10 && view.isLaidOut()) {
            view.animate().translationX(right).setDuration(250L).setInterpolator(new DecelerateInterpolator()).start();
        } else {
            view.setTranslationX(right);
        }
    }

    public static final void d1(Ref$IntRef ref$IntRef, List<? extends TextView> list, NestedScrollView nestedScrollView, NestedScrollView nestedScrollView2, NestedScrollView nestedScrollView3, final AmooStoreFragment amooStoreFragment, View view, View view2, View view3, View view4, View view5, View view6, l5.h hVar, int i10) {
        ref$IntRef.f34818a = i10;
        Iterator<T> it = list.iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i12 = i11 + 1;
            if (i11 < 0) {
                C1173v.w();
            }
            TextView textView = (TextView) next;
            textView.setSelected(i11 == i10);
            textView.setTypeface(Typeface.create(textView.getTypeface(), i11 == i10 ? 580 : 260, false));
            i11 = i12;
        }
        c1(list, ref$IntRef, view6, hVar, true);
        nestedScrollView.setVisibility(i10 == 0 ? 0 : 8);
        nestedScrollView2.setVisibility(i10 == 1 ? 0 : 8);
        nestedScrollView3.setVisibility(i10 == 2 ? 0 : 8);
        amooStoreFragment.t1();
        view.setVisibility(i10 == 0 ? 0 : 8);
        view2.setVisibility(i10 == 2 ? 0 : 8);
        view3.setVisibility(i10 == 1 ? 0 : 8);
        view4.setVisibility(0);
        if (i10 == 2) {
            if (!amooStoreFragment.aiAppModulesExposed) {
                amooStoreFragment.aiAppModulesExposed = true;
                com.stepos.ailauncher.chat.trace.a aVar = com.stepos.ailauncher.chat.trace.a.INSTANCE;
                com.stepos.ailauncher.chat.trace.a.g(aVar, "search", null, null, 6, null);
                com.stepos.ailauncher.chat.trace.a.g(aVar, "installed", null, null, 6, null);
            }
            view5.post(new Runnable() { // from class: com.stepos.ailauncher.chat.fragment.r0
                @Override // java.lang.Runnable
                public final void run() {
                    AmooStoreFragment.e1(this.f25332a);
                }
            });
            if (amooStoreFragment.aiAppLoadedOnce) {
                return;
            }
            amooStoreFragment.aiAppLoadedOnce = true;
            amooStoreFragment.y0();
        }
    }

    public static final void e1(AmooStoreFragment amooStoreFragment) {
        amooStoreFragment.k1();
    }

    private final void f1(MarketAgentBrief agent) {
        IExternalAgentUiService iExternalAgentUiService;
        Fragment fragmentCreateAgentMarketDetailFragment;
        if (!l1() || (iExternalAgentUiService = (IExternalAgentUiService) D5.a.INSTANCE.a(IExternalAgentUiService.class)) == null || (fragmentCreateAgentMarketDetailFragment = iExternalAgentUiService.createAgentMarketDetailFragment(agent)) == null) {
            return;
        }
        com.stepos.ailauncher.sheet.nav.a.z(this, fragmentCreateAgentMarketDetailFragment, AgentMarketDetailFragment.TAG, null, null, null, 28, null);
    }

    private final void h1(SkillItemBrief item) {
        Fragment fragmentCreateSkillDetailFragment$default;
        if (l1()) {
            CliKind cliKindA = Q1.a(item);
            if (cliKindA != null) {
                Fragment fragmentC = Q1.c(cliKindA, item, requireContext());
                if (fragmentC != null) {
                    com.stepos.ailauncher.sheet.nav.a.z(this, fragmentC, cliKindA == CliKind.FEISHU ? "feishu_connect" : "wecom_connect", null, null, null, 28, null);
                    return;
                }
                return;
            }
            ISkillUiService iSkillUiService = (ISkillUiService) D5.a.INSTANCE.a(ISkillUiService.class);
            if (iSkillUiService == null || (fragmentCreateSkillDetailFragment$default = ISkillUiService.createSkillDetailFragment$default(iSkillUiService, item, false, 2, null)) == null) {
                Context contextRequireContext = requireContext();
                String name = item.getName();
                Toast.makeText(contextRequireContext, name != null ? name : "", 0).show();
            } else {
                String id = item.getId();
                com.stepos.ailauncher.sheet.nav.a.z(this, fragmentCreateSkillDetailFragment$default, "skill_detail_" + (id != null ? id : ""), null, null, null, 28, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i1() {
        IAgentMarketService iAgentMarketService = (IAgentMarketService) D5.a.INSTANCE.a(IAgentMarketService.class);
        if (iAgentMarketService == null) {
            return;
        }
        List<MarketAgentBrief> list = this.marketItems;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(list, 10)), 16));
        for (MarketAgentBrief marketAgentBrief : list) {
            Pair pairA = Y8.j.a(marketAgentBrief.getAssetId(), iAgentMarketService.getAgentStatus(marketAgentBrief));
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        List<MarketAgentBrief> list2 = this.marketItems;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(list2, 10)), 16));
        for (MarketAgentBrief marketAgentBrief2 : list2) {
            Pair pairA2 = Y8.j.a(marketAgentBrief2.getAssetId(), Integer.valueOf(iAgentMarketService.getInstallProgress(marketAgentBrief2.getAssetId())));
            linkedHashMap2.put(pairA2.e(), pairA2.f());
        }
        this.marketAdapter.m(linkedHashMap, linkedHashMap2);
        j1();
    }

    private final void j1() {
        ISkillUiService.SkillUiStatus skillStatus;
        ISkillUiService iSkillUiService = (ISkillUiService) D5.a.INSTANCE.a(ISkillUiService.class);
        if (iSkillUiService == null) {
            return;
        }
        for (com.stepos.ailauncher.chat.adapter.h0 h0Var : C1173v.p(this.mustHavesAdapter, this.communityWorksAdapter, this.otherSkillsAdapter)) {
            List<SkillItemBrief> listI = h0Var.i();
            LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(listI, 10)), 16));
            for (SkillItemBrief skillItemBrief : listI) {
                String strB = E0.b(skillItemBrief);
                CliKind cliKindA = Q1.a(skillItemBrief);
                if (cliKindA == null || (skillStatus = Q1.e(cliKindA, skillItemBrief)) == null) {
                    skillStatus = iSkillUiService.getSkillStatus(skillItemBrief);
                }
                Pair pairA = Y8.j.a(strB, skillStatus);
                linkedHashMap.put(pairA.e(), pairA.f());
            }
            h0Var.q(linkedHashMap);
        }
    }

    private final boolean l1() {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        return AuthManager.O(AuthManager.INSTANCE, context, false, false, 6, null);
    }

    public static final Y8.t m0(AmooStoreFragment amooStoreFragment, AppVersionItem item) {
        kotlin.jvm.internal.p.i(item, "item");
        amooStoreFragment.g1(item);
        return Y8.t.f7040a;
    }

    public static final Y8.t p0(AmooStoreFragment amooStoreFragment, SkillItemBrief item) {
        kotlin.jvm.internal.p.i(item, "item");
        amooStoreFragment.h1(item);
        return Y8.t.f7040a;
    }

    private final void p1() {
        kotlinx.coroutines.g gVar = this.actionStateJob;
        if (gVar == null || !gVar.b()) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            this.actionStateJob = C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new AmooStoreFragment$startActionStateTicker$1(this, null), 3, null);
        }
    }

    public static final Y8.t q0(AmooStoreFragment amooStoreFragment, SkillItemBrief item) {
        kotlin.jvm.internal.p.i(item, "item");
        amooStoreFragment.x0(item);
        return Y8.t.f7040a;
    }

    public static final Y8.t r0(AmooStoreFragment amooStoreFragment, SkillItemBrief item) {
        kotlin.jvm.internal.p.i(item, "item");
        amooStoreFragment.s1(item);
        return Y8.t.f7040a;
    }

    private final void r1(MarketAgentBrief agent) {
        IAgentMarketService iAgentMarketService;
        if (l1() && (iAgentMarketService = (IAgentMarketService) D5.a.INSTANCE.a(IAgentMarketService.class)) != null) {
            iAgentMarketService.uninstallAgent(agent);
        }
    }

    private final void s1(SkillItemBrief item) {
        if (l1()) {
            CliKind cliKindA = Q1.a(item);
            if (cliKindA != null) {
                androidx.fragment.app.r rVarRequireActivity = requireActivity();
                kotlin.jvm.internal.p.h(rVarRequireActivity, "requireActivity(...)");
                Q1.b(cliKindA, rVarRequireActivity);
            } else {
                ISkillUiService iSkillUiService = (ISkillUiService) D5.a.INSTANCE.a(ISkillUiService.class);
                if (iSkillUiService != null) {
                    iSkillUiService.uninstallSkill(item);
                }
            }
        }
    }

    private final View v0() {
        androidx.fragment.app.r activity = getActivity();
        if (activity != null) {
            return activity.findViewById(R$id.ail_settle_hint);
        }
        return null;
    }

    private final void w0(MarketAgentBrief agent) {
        IAgentMarketService iAgentMarketService;
        if (l1() && (iAgentMarketService = (IAgentMarketService) D5.a.INSTANCE.a(IAgentMarketService.class)) != null) {
            iAgentMarketService.installAgent(agent);
        }
    }

    private final void x0(SkillItemBrief item) {
        if (l1()) {
            if (Q1.a(item) != null) {
                h1(item);
                return;
            }
            ISkillUiService iSkillUiService = (ISkillUiService) D5.a.INSTANCE.a(ISkillUiService.class);
            if (iSkillUiService != null) {
                iSkillUiService.installSkill(item);
            }
        }
    }

    public final void A0() {
        PagedListController<SkillItemBrief> pagedListController;
        PagedListController<SkillItemBrief> pagedListController2 = this.otherPages;
        if (pagedListController2 == null) {
            kotlin.jvm.internal.p.A("otherPages");
            pagedListController = null;
        } else {
            pagedListController = pagedListController2;
        }
        PagedListController.x(pagedListController, 0, this.otherItems, new AmooStoreFragment$loadSkill$1(null), 1, null);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new AmooStoreFragment$loadSkill$2(this, null), 3, null);
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean e() {
        return true;
    }

    public final void g1(AppVersionItem item) {
        if (l1()) {
            com.stepos.ailauncher.chat.trace.a aVar = com.stepos.ailauncher.chat.trace.a.INSTANCE;
            Long lValueOf = Long.valueOf(item.getId());
            String name = item.getName();
            Iterator<AppVersionItem> it = this.aiAppItems.iterator();
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i10 = -1;
                    break;
                } else if (it.next().getId() == item.getId()) {
                    break;
                } else {
                    i10++;
                }
            }
            Integer numValueOf = Integer.valueOf(i10);
            if (numValueOf.intValue() < 0) {
                numValueOf = null;
            }
            aVar.b(lValueOf, name, numValueOf);
            com.stepos.ailauncher.sheet.nav.a.z(this, AmooAppDetailFragment.INSTANCE.a(item.getId(), item.getPackageName(), item.getName(), item.getIconUrl()), "ai_app_detail_" + item.getId(), null, null, null, 28, null);
        }
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    public final void k1() {
        RecyclerView recyclerView;
        AppVersionItem appVersionItem;
        View view = getView();
        if (view == null || (recyclerView = (RecyclerView) view.findViewById(com.stepos.ailauncher.chat.R$id.rvAiApps)) == null || !recyclerView.isShown()) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return;
        }
        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (iFindFirstVisibleItemPosition < 0 || iFindLastVisibleItemPosition < iFindFirstVisibleItemPosition) {
            if (this.aiAppItems.isEmpty()) {
                return;
            }
            recyclerView.addOnLayoutChangeListener(new b());
            return;
        }
        Rect rect = new Rect();
        if (iFindFirstVisibleItemPosition > iFindLastVisibleItemPosition) {
            return;
        }
        while (true) {
            View viewFindViewByPosition = linearLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition);
            if (viewFindViewByPosition != null && viewFindViewByPosition.getGlobalVisibleRect(rect) && !rect.isEmpty() && (appVersionItem = (AppVersionItem) Z8.F.t0(this.aiAppItems, iFindFirstVisibleItemPosition)) != null && this.aiAppExposedIds.add(Long.valueOf(appVersionItem.getId()))) {
                com.stepos.ailauncher.chat.trace.a.INSTANCE.f("card", Long.valueOf(appVersionItem.getId()), appVersionItem.getName());
            }
            if (iFindFirstVisibleItemPosition == iFindLastVisibleItemPosition) {
                return;
            } else {
                iFindFirstVisibleItemPosition++;
            }
        }
    }

    public final void m1() {
        if (getChildFragmentManager().l0(TAG_AGENT_SEARCH_OVERLAY) != null) {
            return;
        }
        u0();
        t0();
        FragmentManager childFragmentManager = getChildFragmentManager();
        kotlin.jvm.internal.p.h(childFragmentManager, "getChildFragmentManager(...)");
        androidx.fragment.app.K kQ = childFragmentManager.q();
        kQ.s(R$anim.ail_sheet_fragment_vertical_enter, 0);
        kQ.b(com.stepos.ailauncher.chat.R$id.fl_store_search_host, AmooAgentSearchFragment.INSTANCE.a(), TAG_AGENT_SEARCH_OVERLAY);
        kQ.g();
    }

    public final void n0(View view) {
        View viewFindViewById = view.findViewById(com.stepos.ailauncher.chat.R$id.dotInstalledSkillsUnread);
        AmooStoreBadgeState.INSTANCE.d();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new AmooStoreFragment$bindUnreadDots$1(viewFindViewById, null), 3, null);
    }

    public final void n1() {
        if (getChildFragmentManager().l0(TAG_APP_SEARCH_OVERLAY) != null) {
            return;
        }
        u0();
        s0();
        FragmentManager childFragmentManager = getChildFragmentManager();
        kotlin.jvm.internal.p.h(childFragmentManager, "getChildFragmentManager(...)");
        androidx.fragment.app.K kQ = childFragmentManager.q();
        kQ.s(R$anim.ail_sheet_fragment_vertical_enter, 0);
        kQ.b(com.stepos.ailauncher.chat.R$id.fl_store_search_host, AmooAppSearchFragment.INSTANCE.a(), TAG_APP_SEARCH_OVERLAY);
        kQ.g();
    }

    public final com.stepos.ailauncher.chat.adapter.h0 o0() {
        return new com.stepos.ailauncher.chat.adapter.h0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.s0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooStoreFragment.p0(this.f25334a, (SkillItemBrief) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.t0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooStoreFragment.q0(this.f25337a, (SkillItemBrief) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.v0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooStoreFragment.r0(this.f25345a, (SkillItemBrief) obj);
            }
        }, false, 8, null);
    }

    public final void o1() {
        if (getChildFragmentManager().l0(TAG_SEARCH_OVERLAY) != null) {
            return;
        }
        t0();
        s0();
        FragmentManager childFragmentManager = getChildFragmentManager();
        kotlin.jvm.internal.p.h(childFragmentManager, "getChildFragmentManager(...)");
        androidx.fragment.app.K kQ = childFragmentManager.q();
        kQ.s(R$anim.ail_sheet_fragment_vertical_enter, 0);
        kQ.b(com.stepos.ailauncher.chat.R$id.fl_store_search_host, AmooSkillSearchFragment.INSTANCE.a(), TAG_SEARCH_OVERLAY);
        kQ.g();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        kotlinx.coroutines.g gVar = this.actionStateJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.actionStateJob = null;
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            Result.Companion companion = Result.INSTANCE;
            View viewV0 = v0();
            if (viewV0 != null) {
                viewV0.setVisibility(8);
            }
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        p1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final l5.h hVarA = l5.h.a(view);
        kotlin.jvm.internal.p.h(hVarA, "bind(...)");
        TextView tabSkill = hVarA.tabSkill;
        kotlin.jvm.internal.p.h(tabSkill, "tabSkill");
        TextView tabAgent = hVarA.tabAgent;
        kotlin.jvm.internal.p.h(tabAgent, "tabAgent");
        TextView tabApp = hVarA.tabApp;
        kotlin.jvm.internal.p.h(tabApp, "tabApp");
        final List listP = C1173v.p(tabSkill, tabAgent, tabApp);
        final View tabIndicator = hVarA.tabIndicator;
        kotlin.jvm.internal.p.h(tabIndicator, "tabIndicator");
        final NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(com.stepos.ailauncher.chat.R$id.agentContent);
        final NestedScrollView nestedScrollView2 = (NestedScrollView) view.findViewById(com.stepos.ailauncher.chat.R$id.skillContent);
        final NestedScrollView nestedScrollView3 = (NestedScrollView) view.findViewById(com.stepos.ailauncher.chat.R$id.appContent);
        final View viewFindViewById = view.findViewById(com.stepos.ailauncher.chat.R$id.skillBottomBar);
        final View viewFindViewById2 = view.findViewById(com.stepos.ailauncher.chat.R$id.appBottomBar);
        final View viewFindViewById3 = view.findViewById(com.stepos.ailauncher.chat.R$id.agentBottomBar);
        final View viewFindViewById4 = view.findViewById(com.stepos.ailauncher.chat.R$id.storeBottomBlur);
        View viewFindViewById5 = view.findViewById(com.stepos.ailauncher.chat.R$id.btnInstalledSkills);
        com.stepos.ailauncher.sheet.S sT = t();
        if (sT != null) {
            sT.setSheetDragGestureHandleView(view.findViewById(com.stepos.ailauncher.chat.R$id.storeTopBar));
        }
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        hVarA.tabOptions.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.chat.fragment.y0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                AmooStoreFragment.E0(listP, ref$IntRef, tabIndicator, hVarA, view2, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        });
        View viewFindViewById6 = view.findViewById(com.stepos.ailauncher.chat.R$id.storeRoot);
        kotlin.jvm.internal.p.h(viewFindViewById6, "findViewById(...)");
        com.stepos.ailauncher.container.glass.k.b(viewFindViewById6, 0, 1, null);
        d1(ref$IntRef, listP, nestedScrollView2, nestedScrollView, nestedScrollView3, this, viewFindViewById, viewFindViewById2, viewFindViewById3, viewFindViewById4, view, tabIndicator, hVarA, 0);
        tabSkill.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AmooStoreFragment.Z0(this.f25254a, ref$IntRef, listP, nestedScrollView2, nestedScrollView, nestedScrollView3, viewFindViewById, viewFindViewById2, viewFindViewById3, viewFindViewById4, view, tabIndicator, hVarA, view2);
            }
        });
        tabAgent.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AmooStoreFragment.a1(this.f25281a, ref$IntRef, listP, nestedScrollView2, nestedScrollView, nestedScrollView3, viewFindViewById, viewFindViewById2, viewFindViewById3, viewFindViewById4, view, tabIndicator, hVarA, view2);
            }
        });
        tabApp.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AmooStoreFragment.b1(this.f25299a, ref$IntRef, listP, nestedScrollView2, nestedScrollView, nestedScrollView3, viewFindViewById, viewFindViewById2, viewFindViewById3, viewFindViewById4, view, tabIndicator, hVarA, view2);
            }
        });
        RecyclerView recyclerView = (RecyclerView) view.findViewById(com.stepos.ailauncher.chat.R$id.rvMarket);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        boolean z10 = false;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        recyclerView.setAdapter(this.marketAdapter);
        Context context = recyclerView.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        recyclerView.addItemDecoration(new Z8(context));
        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(com.stepos.ailauncher.chat.R$id.rv_must_haves);
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
        RecyclerView.ItemAnimator itemAnimator2 = recyclerView2.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator2 = itemAnimator2 instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator2 : null;
        if (simpleItemAnimator2 != null) {
            simpleItemAnimator2.setSupportsChangeAnimations(false);
        }
        recyclerView2.setAdapter(this.mustHavesAdapter);
        Context context2 = recyclerView2.getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        recyclerView2.addItemDecoration(new Z8(context2));
        RecyclerView recyclerView3 = (RecyclerView) view.findViewById(com.stepos.ailauncher.chat.R$id.rv_community_works);
        recyclerView3.setLayoutManager(new LinearLayoutManager(recyclerView3.getContext()));
        RecyclerView.ItemAnimator itemAnimator3 = recyclerView3.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator3 = itemAnimator3 instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator3 : null;
        if (simpleItemAnimator3 != null) {
            simpleItemAnimator3.setSupportsChangeAnimations(false);
        }
        recyclerView3.setAdapter(this.communityWorksAdapter);
        Context context3 = recyclerView3.getContext();
        kotlin.jvm.internal.p.h(context3, "getContext(...)");
        recyclerView3.addItemDecoration(new Z8(context3));
        nestedScrollView3.setOnScrollChangeListener(new NestedScrollView.e() { // from class: com.stepos.ailauncher.chat.fragment.l0
            @Override // androidx.core.widget.NestedScrollView.e
            public final void a(NestedScrollView nestedScrollView4, int i10, int i11, int i12, int i13) {
                AmooStoreFragment.F0(this.f25314a, nestedScrollView4, i10, i11, i12, i13);
            }
        });
        RecyclerView recyclerView4 = (RecyclerView) view.findViewById(com.stepos.ailauncher.chat.R$id.rvAiApps);
        recyclerView4.setLayoutManager(new LinearLayoutManager(recyclerView4.getContext()));
        RecyclerView.ItemAnimator itemAnimator4 = recyclerView4.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator4 = itemAnimator4 instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator4 : null;
        if (simpleItemAnimator4 != null) {
            simpleItemAnimator4.setSupportsChangeAnimations(false);
        }
        recyclerView4.setAdapter(this.aiAppsAdapter);
        Context context4 = recyclerView4.getContext();
        kotlin.jvm.internal.p.h(context4, "getContext(...)");
        recyclerView4.addItemDecoration(new Z8(context4));
        RecyclerView recyclerView5 = (RecyclerView) view.findViewById(com.stepos.ailauncher.chat.R$id.rv_other_skills);
        recyclerView5.setLayoutManager(new LinearLayoutManager(recyclerView5.getContext()));
        RecyclerView.ItemAnimator itemAnimator5 = recyclerView5.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator5 = itemAnimator5 instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator5 : null;
        if (simpleItemAnimator5 != null) {
            simpleItemAnimator5.setSupportsChangeAnimations(false);
        }
        recyclerView5.setAdapter(this.otherSkillsAdapter);
        Context context5 = recyclerView5.getContext();
        kotlin.jvm.internal.p.h(context5, "getContext(...)");
        recyclerView5.addItemDecoration(new Z8(context5));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        RecyclerView rvMarket = hVarA.rvMarket;
        kotlin.jvm.internal.p.h(rvMarket, "rvMarket");
        this.marketPages = new PagedListController<>(viewLifecycleOwner, rvMarket, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.m0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooStoreFragment.G0((MarketAgentBrief) obj);
            }
        }, false, false, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.n0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooStoreFragment.H0(this.f25318a, hVarA, (C2796d7) obj);
            }
        }, 56, null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        RecyclerView rvOtherSkills = hVarA.rvOtherSkills;
        kotlin.jvm.internal.p.h(rvOtherSkills, "rvOtherSkills");
        this.otherPages = new PagedListController<>(viewLifecycleOwner2, rvOtherSkills, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.o0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooStoreFragment.I0((SkillItemBrief) obj);
            }
        }, false, false, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.p0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooStoreFragment.J0(this.f25326a, (C2796d7) obj);
            }
        }, 56, null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        RecyclerView rvAiApps = hVarA.rvAiApps;
        kotlin.jvm.internal.p.h(rvAiApps, "rvAiApps");
        this.appPages = new PagedListController<>(viewLifecycleOwner3, rvAiApps, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.q0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooStoreFragment.K0((AppVersionItem) obj);
            }
        }, false, false, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.z0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooStoreFragment.L0(this.f25364a, hVarA, view, (C2796d7) obj);
            }
        }, 24, null);
        this.aiAppLoadedOnce = false;
        view.findViewById(com.stepos.ailauncher.chat.R$id.cellConnect).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.A0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AmooStoreFragment.N0(this.f25158a, view2);
            }
        });
        view.findViewById(com.stepos.ailauncher.chat.R$id.headerMustHaves).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.B0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AmooStoreFragment.O0(this.f25161a, view2);
            }
        });
        view.findViewById(com.stepos.ailauncher.chat.R$id.headerCommunityWorks).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.C0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AmooStoreFragment.P0(this.f25165a, view2);
            }
        });
        View viewFindViewById7 = view.findViewById(com.stepos.ailauncher.chat.R$id.btnStoreClose);
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        C2773b6 c2773b6 = new C2773b6(viewLifecycleOwner4, z10, 2, null);
        View viewFindViewById8 = view.findViewById(com.stepos.ailauncher.chat.R$id.tabBar);
        kotlin.jvm.internal.p.h(viewFindViewById8, "findViewById(...)");
        kotlin.jvm.internal.p.f(viewFindViewById7);
        kotlin.jvm.internal.p.f(viewFindViewById5);
        int i10 = com.stepos.ailauncher.chat.R$id.btnInstalledApps;
        View viewFindViewById9 = view.findViewById(i10);
        kotlin.jvm.internal.p.h(viewFindViewById9, "findViewById(...)");
        int i11 = com.stepos.ailauncher.chat.R$id.btnInstalledAgents;
        View viewFindViewById10 = view.findViewById(i11);
        kotlin.jvm.internal.p.h(viewFindViewById10, "findViewById(...)");
        C2773b6 c2773b6P = C2773b6.p(c2773b6, new View[]{viewFindViewById8, viewFindViewById7, viewFindViewById5, viewFindViewById9, viewFindViewById10}, y7.o.INSTANCE.i(), false, 4, null);
        int i12 = com.stepos.ailauncher.chat.R$id.skillSearchContainer;
        View viewFindViewById11 = view.findViewById(i12);
        kotlin.jvm.internal.p.h(viewFindViewById11, "findViewById(...)");
        K7 k72 = K7.INSTANCE;
        C2773b6 c2773b6N = c2773b6P.n(new View[]{viewFindViewById11}, new AnonymousClass20(k72));
        int i13 = com.stepos.ailauncher.chat.R$id.appSearchContainer;
        View viewFindViewById12 = view.findViewById(i13);
        kotlin.jvm.internal.p.h(viewFindViewById12, "findViewById(...)");
        C2773b6 c2773b6N2 = c2773b6N.n(new View[]{viewFindViewById12}, new AnonymousClass21(k72));
        int i14 = com.stepos.ailauncher.chat.R$id.agentSearchContainer;
        View viewFindViewById13 = view.findViewById(i14);
        kotlin.jvm.internal.p.h(viewFindViewById13, "findViewById(...)");
        C2773b6 c2773b6N3 = c2773b6N2.n(new View[]{viewFindViewById13}, new AnonymousClass22(k72));
        View viewFindViewById14 = view.findViewById(com.stepos.ailauncher.chat.R$id.storeTopBlur);
        kotlin.jvm.internal.p.h(viewFindViewById14, "findViewById(...)");
        C2773b6.j(c2773b6N3, new View[]{viewFindViewById14}, G.a.f43886a.g(), null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.D0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooStoreFragment.Q0((A7.B) obj);
            }
        }, 4, null);
        kotlin.jvm.internal.p.f(viewFindViewById4);
        C2773b6.j(c2773b6N3, new View[]{viewFindViewById4}, null, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.Z
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooStoreFragment.R0((A7.B) obj);
            }
        }, 6, null);
        viewFindViewById7.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AmooStoreFragment.S0(this.f25234a, view2);
            }
        });
        view.findViewById(i12).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AmooStoreFragment.T0(this.f25238a, view2);
            }
        });
        view.findViewById(i13).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AmooStoreFragment.U0(this.f25245a, view2);
            }
        });
        view.findViewById(i10).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AmooStoreFragment.V0(this.f25251a, view2);
            }
        });
        view.findViewById(i14).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AmooStoreFragment.W0(this.f25269a, view2);
            }
        });
        view.findViewById(i11).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AmooStoreFragment.X0(this.f25273a, view2);
            }
        });
        viewFindViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AmooStoreFragment.Y0(this.f25277a, view2);
            }
        });
        n0(view);
        z0();
        A0();
    }

    public final void q1() {
        View viewFindViewById;
        View viewFindViewById2;
        View viewFindViewById3;
        View viewFindViewById4;
        View viewFindViewById5;
        View viewFindViewById6;
        PagedListController<SkillItemBrief> pagedListController = this.otherPages;
        if (pagedListController == null) {
            kotlin.jvm.internal.p.A("otherPages");
            pagedListController = null;
        }
        this.skillLoadError = pagedListController.p().getError() != null && this.cliItems.isEmpty() && this.mustHaveItems.isEmpty() && this.communityItems.isEmpty() && this.otherItems.isEmpty();
        List<SkillItemBrief> listF1 = Z8.F.f1(Z8.F.S0(this.cliItems, this.mustHaveItems), 3);
        List<SkillItemBrief> listF12 = Z8.F.f1(this.communityItems, 3);
        this.mustHavesAdapter.p(listF1);
        this.communityWorksAdapter.p(listF12);
        this.otherSkillsAdapter.p(this.otherItems);
        View view = getView();
        if (view != null && (viewFindViewById6 = view.findViewById(com.stepos.ailauncher.chat.R$id.headerMustHaves)) != null) {
            viewFindViewById6.setVisibility(!listF1.isEmpty() ? 0 : 8);
        }
        View view2 = getView();
        if (view2 != null && (viewFindViewById5 = view2.findViewById(com.stepos.ailauncher.chat.R$id.cardMustHaves)) != null) {
            viewFindViewById5.setVisibility(!listF1.isEmpty() ? 0 : 8);
        }
        View view3 = getView();
        if (view3 != null && (viewFindViewById4 = view3.findViewById(com.stepos.ailauncher.chat.R$id.headerCommunityWorks)) != null) {
            viewFindViewById4.setVisibility(!listF12.isEmpty() ? 0 : 8);
        }
        View view4 = getView();
        if (view4 != null && (viewFindViewById3 = view4.findViewById(com.stepos.ailauncher.chat.R$id.cardCommunityWorks)) != null) {
            viewFindViewById3.setVisibility(!listF12.isEmpty() ? 0 : 8);
        }
        View view5 = getView();
        if (view5 != null && (viewFindViewById2 = view5.findViewById(com.stepos.ailauncher.chat.R$id.headerOtherSkills)) != null) {
            viewFindViewById2.setVisibility(!this.otherItems.isEmpty() ? 0 : 8);
        }
        View view6 = getView();
        if (view6 != null && (viewFindViewById = view6.findViewById(com.stepos.ailauncher.chat.R$id.cardOtherSkills)) != null) {
            viewFindViewById.setVisibility(this.skillLoadError ? 8 : 0);
        }
        j1();
    }

    public final void s0() {
        Fragment fragmentL0 = getChildFragmentManager().l0(TAG_AGENT_SEARCH_OVERLAY);
        if (fragmentL0 == null) {
            return;
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        kotlin.jvm.internal.p.h(childFragmentManager, "getChildFragmentManager(...)");
        androidx.fragment.app.K kQ = childFragmentManager.q();
        kQ.s(0, R$anim.ail_sheet_fragment_vertical_pop_exit);
        kQ.o(fragmentL0);
        kQ.g();
    }

    public final void t0() {
        Fragment fragmentL0 = getChildFragmentManager().l0(TAG_APP_SEARCH_OVERLAY);
        if (fragmentL0 == null) {
            return;
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        kotlin.jvm.internal.p.h(childFragmentManager, "getChildFragmentManager(...)");
        androidx.fragment.app.K kQ = childFragmentManager.q();
        kQ.s(0, R$anim.ail_sheet_fragment_vertical_pop_exit);
        kQ.o(fragmentL0);
        kQ.g();
    }

    public final void t1() {
        View view = getView();
        if (view == null) {
            return;
        }
        view.findViewById(com.stepos.ailauncher.chat.R$id.emptyStateStore).setVisibility(view.findViewById(com.stepos.ailauncher.chat.R$id.appContent).getVisibility() == 0 ? this.aiAppLoadError : view.findViewById(com.stepos.ailauncher.chat.R$id.agentContent).getVisibility() == 0 ? this.agentLoadError : this.skillLoadError ? 0 : 8);
    }

    public final void u0() {
        Fragment fragmentL0 = getChildFragmentManager().l0(TAG_SEARCH_OVERLAY);
        if (fragmentL0 == null) {
            return;
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        kotlin.jvm.internal.p.h(childFragmentManager, "getChildFragmentManager(...)");
        androidx.fragment.app.K kQ = childFragmentManager.q();
        kQ.s(0, R$anim.ail_sheet_fragment_vertical_pop_exit);
        kQ.o(fragmentL0);
        kQ.g();
    }

    public final void y0() {
        PagedListController<AppVersionItem> pagedListController;
        PagedListController<AppVersionItem> pagedListController2 = this.appPages;
        if (pagedListController2 == null) {
            kotlin.jvm.internal.p.A("appPages");
            pagedListController = null;
        } else {
            pagedListController = pagedListController2;
        }
        PagedListController.x(pagedListController, 0, this.aiAppItems, new AmooStoreFragment$loadAiApps$1(null), 1, null);
    }

    public final void z0() {
        PagedListController<MarketAgentBrief> pagedListController;
        PagedListController<MarketAgentBrief> pagedListController2 = this.marketPages;
        if (pagedListController2 == null) {
            kotlin.jvm.internal.p.A("marketPages");
            pagedListController = null;
        } else {
            pagedListController = pagedListController2;
        }
        PagedListController.x(pagedListController, 0, this.marketItems, new AmooStoreFragment$loadMarket$1(null), 1, null);
    }
}
