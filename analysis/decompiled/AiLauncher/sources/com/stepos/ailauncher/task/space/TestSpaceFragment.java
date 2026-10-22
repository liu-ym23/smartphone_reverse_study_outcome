package com.stepos.ailauncher.task.space;

import Ua.C1060i;
import Z8.C1173v;
import Z8.C1174w;
import android.animation.ObjectAnimator;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Property;
import android.view.C1398p;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailFragment;
import com.stepos.ailauncher.chat.adapter.C2495a;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.chat.view.C2796d7;
import com.stepos.ailauncher.chat.view.PagedListController;
import com.stepos.ailauncher.chat.view.Z8;
import com.stepos.ailauncher.contract.api.agent.IAgentMarketService;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentUiService;
import com.stepos.ailauncher.contract.api.skill.ISkillUiService;
import com.stepos.ailauncher.contract.model.MarketAgentBrief;
import com.stepos.ailauncher.contract.model.MarketAppBrief;
import com.stepos.ailauncher.contract.model.SkillItemBrief;
import com.stepos.ailauncher.foundation.appstore.j;
import com.stepos.ailauncher.foundation.appui.card.provider.weather.WeatherCardProvider;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import com.stepos.ailauncher.task.R$string;
import com.stepos.ailauncher.task.space.TestSpaceAppAdapter;
import com.stepos.ailauncher.task.space.TestSpaceAppLinkPolicy;
import h8.C4148a;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Triple;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;
import y7.G;

@Metadata(d1 = {"\u0000Ï\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0003\u000ekn\u0018\u0000 \u007f2\u00020\u0001:\u0002\u0080\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\fH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b%\u0010$J\u001d\u0010(\u001a\u00020\u00062\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060&H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020 2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\fH\u0002¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b1\u0010$J\u0019\u00103\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020 H\u0002¢\u0006\u0004\b3\u00104J\u0017\u00106\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u000205H\u0002¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0006H\u0002¢\u0006\u0004\b8\u0010\u0003J\u000f\u00109\u001a\u00020\u0006H\u0002¢\u0006\u0004\b9\u0010\u0003J\u000f\u0010:\u001a\u00020\u0006H\u0002¢\u0006\u0004\b:\u0010\u0003J\u0017\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u00020;H\u0002¢\u0006\u0004\b=\u0010>J+\u0010A\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010@2\u0006\u0010?\u001a\u00020\fH\u0002¢\u0006\u0004\bA\u0010BJ!\u0010E\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010D\u001a\u0004\u0018\u00010CH\u0016¢\u0006\u0004\bE\u0010FJ\u0017\u0010H\u001a\u00020\u00062\u0006\u0010G\u001a\u00020 H\u0016¢\u0006\u0004\bH\u00104J\u000f\u0010I\u001a\u00020\u0006H\u0016¢\u0006\u0004\bI\u0010\u0003J\u000f\u0010J\u001a\u00020\u0006H\u0016¢\u0006\u0004\bJ\u0010\u0003J\u000f\u0010K\u001a\u00020\u0006H\u0016¢\u0006\u0004\bK\u0010\u0003R\u001c\u0010M\u001a\b\u0012\u0004\u0012\u0002050L8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bM\u0010NR\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020O0L8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bP\u0010NR\u001c\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00190L8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bQ\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010U\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010W\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010VR\u001c\u0010Y\u001a\b\u0012\u0004\u0012\u0002050X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u001c\u0010[\u001a\b\u0012\u0004\u0012\u00020O0X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010ZR\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00190X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010ZR\u0016\u0010]\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010VR\u0016\u0010`\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010VR\u0016\u0010a\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010VR\u0016\u0010b\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010VR\u0016\u0010c\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010VR\u0016\u0010d\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010VR\u001a\u0010f\u001a\b\u0012\u0004\u0012\u00020\f0e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR \u0010i\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010l\u001a\u00020k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010o\u001a\u00020n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u0014\u0010r\u001a\u00020q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sR\u0014\u0010u\u001a\u00020t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u001a\u0010w\u001a\b\u0012\u0004\u0012\u00020\f0e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010gR\u0014\u0010y\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010{\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010VR\u0014\u0010~\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b|\u0010}¨\u0006\u0081\u0001"}, d2 = {"Lcom/stepos/ailauncher/task/space/TestSpaceFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "Landroid/view/View;", "view", "LY8/t;", "R0", "(Landroid/view/View;)V", "", "p0", "()I", "", WeatherCardProvider.KEY_CARD_TYPE, "com/stepos/ailauncher/task/space/TestSpaceFragment$e", "n0", "(Ljava/lang/String;)Lcom/stepos/ailauncher/task/space/TestSpaceFragment$e;", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "Q0", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/lang/String;)V", "d1", "t0", "r0", "s0", "Lcom/stepos/ailauncher/contract/model/MarketAppBrief;", "item", "Lcom/stepos/ailauncher/task/space/TestSpaceAppAdapter$ActionState;", "k0", "(Lcom/stepos/ailauncher/contract/model/MarketAppBrief;)Lcom/stepos/ailauncher/task/space/TestSpaceAppAdapter$ActionState;", "server", "installed", "", "q0", "(Ljava/lang/String;Ljava/lang/String;)Z", "u0", "(Lcom/stepos/ailauncher/contract/model/MarketAppBrief;)V", "v0", "Lkotlin/Function0;", "onConfirm", "o0", "(Lp9/a;)V", "Landroid/content/Intent;", "intent", SdCardDbCreator.FIELD_LASTLOC_ID, "(Landroid/content/Intent;)Z", "rawUrl", "K0", "(Ljava/lang/String;)V", "J0", "prime", "N0", "(Z)V", "Lcom/stepos/ailauncher/contract/model/SkillItemBrief;", "L0", "(Lcom/stepos/ailauncher/contract/model/SkillItemBrief;)V", "P0", "M0", "Z0", "Landroid/widget/ImageView;", "imageView", "b1", "(Landroid/widget/ImageView;)V", "scanType", "Lkotlin/Triple;", "c1", "(Ljava/lang/String;)Lkotlin/Triple;", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "hidden", "onHiddenChanged", "onResume", "onPause", "onDestroyView", "Lcom/stepos/ailauncher/chat/view/PagedListController;", "skillPages", "Lcom/stepos/ailauncher/chat/view/PagedListController;", "Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;", "agentPages", "appPages", "Lkotlinx/coroutines/g;", "actionStateJob", "Lkotlinx/coroutines/g;", "agentTabLoaded", "Z", "appTabLoaded", "", "skillItems", "Ljava/util/List;", "agentItems", "appItems", "currentTabIndex", "I", "skillEmpty", "agentEmpty", "appEmpty", "skillError", "agentError", "appError", "", "installingAppPkgs", "Ljava/util/Set;", "", "appProgress", "Ljava/util/Map;", "com/stepos/ailauncher/task/space/TestSpaceFragment$c", "appInstallCallback", "Lcom/stepos/ailauncher/task/space/TestSpaceFragment$c;", "com/stepos/ailauncher/task/space/TestSpaceFragment$d", "appUninstallCallback", "Lcom/stepos/ailauncher/task/space/TestSpaceFragment$d;", "Lcom/stepos/ailauncher/chat/adapter/h0;", "skillAdapter", "Lcom/stepos/ailauncher/chat/adapter/h0;", "Lcom/stepos/ailauncher/chat/adapter/a;", "agentAdapter", "Lcom/stepos/ailauncher/chat/adapter/a;", "exposedCardKeys", "Lcom/stepos/ailauncher/task/space/TestSpaceAppAdapter;", "appAdapter", "Lcom/stepos/ailauncher/task/space/TestSpaceAppAdapter;", "scanConsumed", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "showsSheetDragHandle", "Companion", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TestSpaceFragment extends com.stepos.ailauncher.sheet.nav.a {
    private static final String ARG_ASSET_ID = "asset_id";
    private static final String ARG_SCAN_SOURCE = "scan_source";
    private static final String ARG_SCAN_TYPE = "scan_type";
    private static final String ARG_TAB = "tab";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String NAV_TAG = "test_space";
    private static final int TAB_INDEX_AGENT = 1;
    private static final int TAB_INDEX_APP = 2;
    private static final int TAB_INDEX_SKILL = 0;
    private kotlinx.coroutines.g actionStateJob;
    private final C2495a agentAdapter;
    private boolean agentEmpty;
    private boolean agentError;
    private List<MarketAgentBrief> agentItems;
    private PagedListController<MarketAgentBrief> agentPages;
    private boolean agentTabLoaded;
    private final TestSpaceAppAdapter appAdapter;
    private boolean appEmpty;
    private boolean appError;
    private final c appInstallCallback;
    private List<MarketAppBrief> appItems;
    private PagedListController<MarketAppBrief> appPages;
    private final Map<String, Integer> appProgress;
    private boolean appTabLoaded;
    private final d appUninstallCallback;
    private int currentTabIndex;
    private final Set<String> exposedCardKeys;
    private final Set<String> installingAppPkgs;
    private boolean scanConsumed;
    private final com.stepos.ailauncher.chat.adapter.h0 skillAdapter;
    private boolean skillEmpty;
    private boolean skillError;
    private List<SkillItemBrief> skillItems;
    private PagedListController<SkillItemBrief> skillPages;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/task/space/TestSpaceFragment$a;", "", "<init>", "()V", "", TestSpaceFragment.ARG_TAB, "scanSource", "scanType", "assetId", "Lcom/stepos/ailauncher/task/space/TestSpaceFragment;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/task/space/TestSpaceFragment;", "NAV_TAG", "Ljava/lang/String;", "", "TAB_INDEX_SKILL", "I", "TAB_INDEX_AGENT", "TAB_INDEX_APP", "ARG_TAB", "ARG_SCAN_SOURCE", "ARG_SCAN_TYPE", "ARG_ASSET_ID", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.space.TestSpaceFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final TestSpaceFragment a(String tab, String scanSource, String scanType, String assetId) {
            TestSpaceFragment testSpaceFragment = new TestSpaceFragment();
            Bundle bundle = new Bundle();
            bundle.putString(TestSpaceFragment.ARG_TAB, tab);
            bundle.putString(TestSpaceFragment.ARG_SCAN_SOURCE, scanSource);
            bundle.putString(TestSpaceFragment.ARG_SCAN_TYPE, scanType);
            bundle.putString(TestSpaceFragment.ARG_ASSET_ID, assetId);
            testSpaceFragment.setArguments(bundle);
            return testSpaceFragment;
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TestSpaceAppLinkPolicy.Action.values().length];
            try {
                iArr[TestSpaceAppLinkPolicy.Action.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TestSpaceAppLinkPolicy.Action.DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TestSpaceAppLinkPolicy.Action.DOWNLOAD_UNAVAILABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TestSpaceAppLinkPolicy.Action.UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TestSpaceAppLinkPolicy.Action.UPDATE_UNAVAILABLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TestSpaceAppAdapter.ActionState.values().length];
            try {
                iArr2[TestSpaceAppAdapter.ActionState.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[TestSpaceAppAdapter.ActionState.DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[TestSpaceAppAdapter.ActionState.UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"com/stepos/ailauncher/task/space/TestSpaceFragment$c", "Lcom/stepos/ailauncher/foundation/appstore/j$a;", "", "pkg", "", "progress", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;I)V", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", "c", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements j.a {
        public c() {
        }

        @Override // com.stepos.ailauncher.foundation.appstore.j.a
        public void a(String pkg, int progress) {
            kotlin.jvm.internal.p.i(pkg, "pkg");
            TestSpaceFragment.this.appProgress.put(pkg, Integer.valueOf(progress));
            TestSpaceFragment.O0(TestSpaceFragment.this, false, 1, null);
        }

        @Override // com.stepos.ailauncher.foundation.appstore.j.a
        public void b(String pkg) {
            kotlin.jvm.internal.p.i(pkg, "pkg");
            TestSpaceFragment.this.installingAppPkgs.remove(pkg);
            TestSpaceFragment.this.appProgress.remove(pkg);
            TestSpaceFragment.O0(TestSpaceFragment.this, false, 1, null);
        }

        @Override // com.stepos.ailauncher.foundation.appstore.j.a
        public void c(String pkg) {
            kotlin.jvm.internal.p.i(pkg, "pkg");
            TestSpaceFragment.this.installingAppPkgs.remove(pkg);
            TestSpaceFragment.this.appProgress.remove(pkg);
            TestSpaceFragment.O0(TestSpaceFragment.this, false, 1, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/task/space/TestSpaceFragment$d", "Lcom/stepos/ailauncher/foundation/appstore/j$b;", "", "pkg", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements j.b {
        public d() {
        }

        @Override // com.stepos.ailauncher.foundation.appstore.j.b
        public void a(String pkg) {
            kotlin.jvm.internal.p.i(pkg, "pkg");
            com.stepos.ailauncher.foundation.appstore.j.INSTANCE.G(pkg, this);
            TestSpaceFragment.O0(TestSpaceFragment.this, false, 1, null);
        }

        @Override // com.stepos.ailauncher.foundation.appstore.j.b
        public void b(String pkg) {
            kotlin.jvm.internal.p.i(pkg, "pkg");
            com.stepos.ailauncher.foundation.appstore.j.INSTANCE.G(pkg, this);
            TestSpaceFragment.O0(TestSpaceFragment.this, false, 1, null);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/ailauncher/task/space/TestSpaceFragment$e", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "LY8/t;", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e extends RecyclerView.OnScrollListener {
        final /* synthetic */ String $cardType;

        public e(String str) {
            this.$cardType = str;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            kotlin.jvm.internal.p.i(recyclerView, "recyclerView");
            TestSpaceFragment.this.Q0(recyclerView, this.$cardType);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f implements View.OnLayoutChangeListener {
        final /* synthetic */ Ref$ObjectRef $indicatorAnimator$inlined;
        final /* synthetic */ FrameLayout $tabBar$inlined;
        final /* synthetic */ View $tabIndicator$inlined;
        final /* synthetic */ List $tabs$inlined;
        final /* synthetic */ TestSpaceFragment this$0;

        public f(View view, TestSpaceFragment testSpaceFragment, Ref$ObjectRef ref$ObjectRef, FrameLayout frameLayout, List list) {
            this.$tabIndicator$inlined = view;
            this.this$0 = testSpaceFragment;
            this.$indicatorAnimator$inlined = ref$ObjectRef;
            this.$tabBar$inlined = frameLayout;
            this.$tabs$inlined = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            int iT0 = TestSpaceFragment.T0(this.$tabBar$inlined, this.$tabs$inlined);
            if (iT0 > 0) {
                if (this.$tabIndicator$inlined.getLayoutParams().width != iT0) {
                    kotlin.jvm.internal.p.f(this.$tabIndicator$inlined);
                    View view2 = this.$tabIndicator$inlined;
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if (layoutParams == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    }
                    layoutParams.width = iT0;
                    view2.setLayoutParams(layoutParams);
                }
                float f10 = this.this$0.currentTabIndex * iT0;
                if (this.$tabIndicator$inlined.getTranslationX() == f10) {
                    return;
                }
                ObjectAnimator objectAnimator = (ObjectAnimator) this.$indicatorAnimator$inlined.f34820a;
                if (objectAnimator != null) {
                    objectAnimator.cancel();
                }
                this.$tabIndicator$inlined.setTranslationX(f10);
            }
        }
    }

    public TestSpaceFragment() {
        super(R$layout.fragment_test_space);
        this.skillItems = C1173v.m();
        this.agentItems = C1173v.m();
        this.appItems = C1173v.m();
        this.installingAppPkgs = new LinkedHashSet();
        this.appProgress = new LinkedHashMap();
        this.appInstallCallback = new c();
        this.appUninstallCallback = new d();
        this.skillAdapter = new com.stepos.ailauncher.chat.adapter.h0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.z1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TestSpaceFragment.V0(this.f29147a, (SkillItemBrief) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.A1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TestSpaceFragment.W0((SkillItemBrief) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.B1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TestSpaceFragment.X0(this.f28781a, (SkillItemBrief) obj);
            }
        }, true);
        this.agentAdapter = new C2495a(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.C1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TestSpaceFragment.g0((MarketAgentBrief) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.D1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TestSpaceFragment.h0(this.f28789a, (MarketAgentBrief) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.E1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TestSpaceFragment.j0(this.f28794a, (MarketAgentBrief) obj);
            }
        }, true);
        this.exposedCardKeys = new LinkedHashSet();
        this.appAdapter = new TestSpaceAppAdapter(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.F1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TestSpaceFragment.l0(this.f28797a, (MarketAppBrief) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.G1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TestSpaceFragment.m0(this.f28800a, (MarketAppBrief) obj);
            }
        });
    }

    public static final void A0(RecyclerView recyclerView, TestSpaceFragment testSpaceFragment) {
        if (recyclerView.isShown()) {
            testSpaceFragment.Q0(recyclerView, "agent");
        }
    }

    public static final String B0(MarketAppBrief it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getAppId();
    }

    public static final Y8.t C0(TestSpaceFragment testSpaceFragment, RecyclerView recyclerView, r6.i iVar, C2796d7 state) {
        kotlin.jvm.internal.p.i(state, "state");
        testSpaceFragment.appItems = state.f();
        testSpaceFragment.appError = state.getError() != null && testSpaceFragment.appItems.isEmpty();
        testSpaceFragment.appEmpty = state.getCompleted() && state.getError() == null && state.f().isEmpty();
        testSpaceFragment.N0(true);
        testSpaceFragment.appAdapter.l(testSpaceFragment.appItems);
        recyclerView.setVisibility(testSpaceFragment.appItems.isEmpty() ? 8 : 0);
        iVar.loadingApp.setVisibility(8);
        O0(testSpaceFragment, false, 1, null);
        testSpaceFragment.d1();
        return Y8.t.f7040a;
    }

    public static final void D0(TestSpaceFragment testSpaceFragment, View view) {
        C3577a2.INSTANCE.f(C3577a2.TYPE_SKILL);
        com.stepos.ailauncher.sheet.nav.a.z(testSpaceFragment, Z1.INSTANCE.a(true), Z1.NAV_TAG, null, null, null, 28, null);
    }

    public static final void E0(TestSpaceFragment testSpaceFragment, View view) {
        C3577a2.INSTANCE.f("agent");
        com.stepos.ailauncher.sheet.nav.a.z(testSpaceFragment, Z1.INSTANCE.a(false), Z1.NAV_TAG, null, null, null, 28, null);
    }

    public static final String F0(SkillItemBrief it) {
        kotlin.jvm.internal.p.i(it, "it");
        String id = it.getId();
        if (id != null) {
            return id;
        }
        String name = it.getName();
        return name == null ? "" : name;
    }

    public static final Y8.t G0(final TestSpaceFragment testSpaceFragment, final RecyclerView recyclerView, r6.i iVar, C2796d7 state) {
        kotlin.jvm.internal.p.i(state, "state");
        testSpaceFragment.skillItems = state.f();
        testSpaceFragment.skillError = state.getError() != null && testSpaceFragment.skillItems.isEmpty();
        testSpaceFragment.skillEmpty = !state.getLoading() && testSpaceFragment.skillItems.isEmpty() && state.getCompleted() && state.getError() == null;
        testSpaceFragment.skillAdapter.p(testSpaceFragment.skillItems);
        recyclerView.setVisibility(testSpaceFragment.skillItems.isEmpty() ? 8 : 0);
        iVar.loadingSkill.setVisibility(8);
        testSpaceFragment.P0();
        testSpaceFragment.d1();
        recyclerView.post(new Runnable() { // from class: com.stepos.ailauncher.task.space.I1
            @Override // java.lang.Runnable
            public final void run() {
                TestSpaceFragment.H0(recyclerView, testSpaceFragment);
            }
        });
        return Y8.t.f7040a;
    }

    public static final void H0(RecyclerView recyclerView, TestSpaceFragment testSpaceFragment) {
        if (recyclerView.isShown()) {
            testSpaceFragment.Q0(recyclerView, C3577a2.TYPE_SKILL);
        }
    }

    public static final String I0(MarketAgentBrief it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getAssetId();
    }

    private final void L0(SkillItemBrief item) {
        Fragment fragmentCreateSkillDetailFragment;
        ISkillUiService iSkillUiService = (ISkillUiService) D5.a.INSTANCE.a(ISkillUiService.class);
        if (iSkillUiService == null || (fragmentCreateSkillDetailFragment = iSkillUiService.createSkillDetailFragment(item, !kotlin.jvm.internal.p.d(item.getEnv(), "prod"))) == null) {
            return;
        }
        String id = item.getId();
        if (id == null) {
            id = "";
        }
        com.stepos.ailauncher.sheet.nav.a.z(this, fragmentCreateSkillDetailFragment, "skill_detail_" + id, null, null, null, 28, null);
    }

    public static /* synthetic */ void O0(TestSpaceFragment testSpaceFragment, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        testSpaceFragment.N0(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P0() {
        ISkillUiService iSkillUiService = (ISkillUiService) D5.a.INSTANCE.a(ISkillUiService.class);
        if (iSkillUiService == null) {
            return;
        }
        List<SkillItemBrief> list = this.skillItems;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(list, 10)), 16));
        for (SkillItemBrief skillItemBrief : list) {
            Pair pairA = Y8.j.a(W1.b(skillItemBrief), iSkillUiService.getSkillStatus(skillItemBrief));
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        this.skillAdapter.q(linkedHashMap);
    }

    public static final void S0(int i10, TestSpaceFragment testSpaceFragment, List list, Ref$ObjectRef ref$ObjectRef, View view, List list2, View view2, FrameLayout frameLayout, View view3) {
        U0(testSpaceFragment, list, ref$ObjectRef, view, list2, view2, frameLayout, i10);
    }

    public static final int T0(FrameLayout frameLayout, List<? extends TextView> list) {
        return ((frameLayout.getWidth() - frameLayout.getPaddingLeft()) - frameLayout.getPaddingRight()) / list.size();
    }

    /* JADX WARN: Type inference failed for: r7v8, types: [T, android.animation.Animator, android.animation.ObjectAnimator] */
    public static final void U0(TestSpaceFragment testSpaceFragment, List<? extends TextView> list, Ref$ObjectRef<ObjectAnimator> ref$ObjectRef, View view, List<? extends View> list2, View view2, FrameLayout frameLayout, int i10) {
        testSpaceFragment.currentTabIndex = i10;
        Iterator<T> it = list.iterator();
        int i11 = 0;
        while (true) {
            int i12 = 1;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i13 = i11 + 1;
            if (i11 < 0) {
                C1173v.w();
            }
            TextView textView = (TextView) next;
            if (i11 != i10) {
                i12 = 0;
            }
            textView.setTypeface(null, i12);
            i11 = i13;
        }
        int iT0 = T0(frameLayout, list);
        float f10 = i10 * iT0;
        ObjectAnimator objectAnimator = ref$ObjectRef.f34820a;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        if (iT0 <= 0 || !view.isLaidOut()) {
            view.setTranslationX(f10);
        } else {
            ?? OfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_X, f10);
            OfFloat.setDuration(250L);
            OfFloat.setInterpolator(new DecelerateInterpolator());
            OfFloat.start();
            ref$ObjectRef.f34820a = OfFloat;
        }
        int i14 = 0;
        for (Object obj : list2) {
            int i15 = i14 + 1;
            if (i14 < 0) {
                C1173v.w();
            }
            ((View) obj).setVisibility(i14 == i10 ? 0 : 8);
            i14 = i15;
        }
        testSpaceFragment.d1();
        if (i10 == 0) {
            C3577a2.INSTANCE.h(C3577a2.TYPE_SKILL);
        } else if (i10 == 1) {
            C3577a2.INSTANCE.h("agent");
        }
        if (i10 == 1) {
            if (testSpaceFragment.agentTabLoaded) {
                return;
            }
            testSpaceFragment.agentTabLoaded = true;
            View viewFindViewById = view2.findViewById(R$id.ivLoadingAgent);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            testSpaceFragment.b1((ImageView) viewFindViewById);
            testSpaceFragment.r0();
            return;
        }
        if (i10 == 2 && !testSpaceFragment.appTabLoaded) {
            testSpaceFragment.appTabLoaded = true;
            View viewFindViewById2 = view2.findViewById(R$id.ivLoadingApp);
            kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
            testSpaceFragment.b1((ImageView) viewFindViewById2);
            testSpaceFragment.s0();
        }
    }

    public static final Y8.t V0(TestSpaceFragment testSpaceFragment, SkillItemBrief item) {
        kotlin.jvm.internal.p.i(item, "item");
        String id = item.getId();
        if (id != null) {
            if (La.H.x0(id)) {
                id = null;
            }
            String str = id;
            if (str != null) {
                C3577a2 c3577a2 = C3577a2.INSTANCE;
                String name = item.getName();
                String version = item.getVersion();
                boolean needUpdate = item.getNeedUpdate();
                Iterator<SkillItemBrief> it = testSpaceFragment.skillItems.iterator();
                int i10 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i10 = -1;
                        break;
                    }
                    if (kotlin.jvm.internal.p.d(it.next().getId(), item.getId())) {
                        break;
                    }
                    i10++;
                }
                c3577a2.b(C3577a2.TYPE_SKILL, str, name, version, needUpdate, Integer.valueOf(i10));
            }
        }
        testSpaceFragment.L0(item);
        return Y8.t.f7040a;
    }

    public static final Y8.t W0(SkillItemBrief item) {
        kotlin.jvm.internal.p.i(item, "item");
        ISkillUiService iSkillUiService = (ISkillUiService) D5.a.INSTANCE.a(ISkillUiService.class);
        if (iSkillUiService != null) {
            iSkillUiService.installSkill(item);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t X0(TestSpaceFragment testSpaceFragment, final SkillItemBrief item) {
        kotlin.jvm.internal.p.i(item, "item");
        testSpaceFragment.o0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.L1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return TestSpaceFragment.Y0(item);
            }
        });
        return Y8.t.f7040a;
    }

    public static final Y8.t Y0(SkillItemBrief skillItemBrief) {
        ISkillUiService iSkillUiService = (ISkillUiService) D5.a.INSTANCE.a(ISkillUiService.class);
        if (iSkillUiService != null) {
            iSkillUiService.uninstallSkill(skillItemBrief);
        }
        return Y8.t.f7040a;
    }

    private final void Z0() {
        kotlinx.coroutines.g gVar = this.actionStateJob;
        if (gVar == null || !gVar.b()) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            this.actionStateJob = C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new TestSpaceFragment$startActionStateTicker$1(this, null), 3, null);
        }
    }

    public static final Y8.t g0(MarketAgentBrief agent) {
        kotlin.jvm.internal.p.i(agent, "agent");
        IAgentMarketService iAgentMarketService = (IAgentMarketService) D5.a.INSTANCE.a(IAgentMarketService.class);
        if (iAgentMarketService != null) {
            iAgentMarketService.installAgent(agent);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t h0(TestSpaceFragment testSpaceFragment, final MarketAgentBrief agent) {
        kotlin.jvm.internal.p.i(agent, "agent");
        testSpaceFragment.o0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.H1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return TestSpaceFragment.i0(agent);
            }
        });
        return Y8.t.f7040a;
    }

    public static final Y8.t i0(MarketAgentBrief marketAgentBrief) {
        IAgentMarketService iAgentMarketService = (IAgentMarketService) D5.a.INSTANCE.a(IAgentMarketService.class);
        if (iAgentMarketService != null) {
            iAgentMarketService.uninstallAgent(marketAgentBrief);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t j0(TestSpaceFragment testSpaceFragment, MarketAgentBrief agent) {
        Fragment fragmentCreateAgentMarketDetailFragment;
        kotlin.jvm.internal.p.i(agent, "agent");
        C3577a2 c3577a2 = C3577a2.INSTANCE;
        String assetId = agent.getAssetId();
        String name = agent.getName();
        String version = agent.getVersion();
        boolean needUpdate = agent.getNeedUpdate();
        Iterator<MarketAgentBrief> it = testSpaceFragment.agentItems.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            if (kotlin.jvm.internal.p.d(it.next().getAssetId(), agent.getAssetId())) {
                break;
            }
            i10++;
        }
        c3577a2.b("agent", assetId, name, version, needUpdate, Integer.valueOf(i10));
        IExternalAgentUiService iExternalAgentUiService = (IExternalAgentUiService) D5.a.INSTANCE.a(IExternalAgentUiService.class);
        if (iExternalAgentUiService != null && (fragmentCreateAgentMarketDetailFragment = iExternalAgentUiService.createAgentMarketDetailFragment(agent)) != null) {
            com.stepos.ailauncher.sheet.nav.a.z(testSpaceFragment, fragmentCreateAgentMarketDetailFragment, AgentMarketDetailFragment.TAG, null, null, null, 28, null);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t l0(TestSpaceFragment testSpaceFragment, MarketAppBrief item) {
        kotlin.jvm.internal.p.i(item, "item");
        testSpaceFragment.u0(item);
        return Y8.t.f7040a;
    }

    public static final Y8.t m0(TestSpaceFragment testSpaceFragment, MarketAppBrief item) {
        kotlin.jvm.internal.p.i(item, "item");
        testSpaceFragment.v0(item);
        return Y8.t.f7040a;
    }

    private final void t0() {
        PagedListController<SkillItemBrief> pagedListController;
        Triple<String, String, String> tripleC1 = c1("plugin");
        PagedListController<SkillItemBrief> pagedListController2 = this.skillPages;
        if (pagedListController2 == null) {
            kotlin.jvm.internal.p.A("skillPages");
            pagedListController = null;
        } else {
            pagedListController = pagedListController2;
        }
        PagedListController.x(pagedListController, 0, this.skillItems, new TestSpaceFragment$loadSkills$1(tripleC1, null), 1, null);
    }

    public static final Y8.t w0(String str, TestSpaceFragment testSpaceFragment, Context context) {
        com.stepos.ailauncher.foundation.appstore.j jVar = com.stepos.ailauncher.foundation.appstore.j.INSTANCE;
        jVar.o(str, testSpaceFragment.appUninstallCallback);
        jVar.K(context, str);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t x0(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    public static final void y0(TestSpaceFragment testSpaceFragment, View view) {
        if (testSpaceFragment.x()) {
            return;
        }
        testSpaceFragment.o();
    }

    public static final Y8.t z0(final TestSpaceFragment testSpaceFragment, final RecyclerView recyclerView, r6.i iVar, C2796d7 state) {
        kotlin.jvm.internal.p.i(state, "state");
        testSpaceFragment.agentItems = state.f();
        testSpaceFragment.agentError = state.getError() != null && testSpaceFragment.agentItems.isEmpty();
        testSpaceFragment.agentEmpty = state.getCompleted() && state.getError() == null && state.f().isEmpty();
        testSpaceFragment.agentAdapter.l(testSpaceFragment.agentItems);
        recyclerView.setVisibility(testSpaceFragment.agentItems.isEmpty() ? 8 : 0);
        iVar.loadingAgent.setVisibility(8);
        testSpaceFragment.M0();
        testSpaceFragment.d1();
        recyclerView.post(new Runnable() { // from class: com.stepos.ailauncher.task.space.N1
            @Override // java.lang.Runnable
            public final void run() {
                TestSpaceFragment.A0(recyclerView, testSpaceFragment);
            }
        });
        return Y8.t.f7040a;
    }

    public final void J0(MarketAppBrief item) {
        Intent launchIntentForPackage;
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (!La.H.x0(item.getPackageName()) && (launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(item.getPackageName())) != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                startActivity(launchIntentForPackage);
                Result.b(Y8.t.f7040a);
                return;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
                return;
            }
        }
        if (La.H.x0(item.getH5Url())) {
            return;
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(item.getH5Url())));
            Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.b(C4849c.a(th2));
        }
    }

    public final void K0(String rawUrl) {
        Context context;
        String strF = TestSpaceAppLinkPolicy.INSTANCE.f(rawUrl);
        if ((strF == null || !a1(new Intent("android.intent.action.VIEW", Uri.parse(strF)))) && (context = getContext()) != null) {
            Toast.makeText(context, R$string.test_space_app_page_open_failed, 0).show();
        }
    }

    public final void M0() {
        IAgentMarketService iAgentMarketService = (IAgentMarketService) D5.a.INSTANCE.a(IAgentMarketService.class);
        if (iAgentMarketService == null) {
            return;
        }
        C2495a c2495a = this.agentAdapter;
        List<MarketAgentBrief> list = this.agentItems;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(list, 10)), 16));
        for (MarketAgentBrief marketAgentBrief : list) {
            Pair pairA = Y8.j.a(marketAgentBrief.getAssetId(), iAgentMarketService.getAgentStatus(marketAgentBrief));
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        List<MarketAgentBrief> list2 = this.agentItems;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(list2, 10)), 16));
        for (MarketAgentBrief marketAgentBrief2 : list2) {
            Pair pairA2 = Y8.j.a(marketAgentBrief2.getAssetId(), Integer.valueOf(iAgentMarketService.getInstallProgress(marketAgentBrief2.getAssetId())));
            linkedHashMap2.put(pairA2.e(), pairA2.f());
        }
        c2495a.m(linkedHashMap, linkedHashMap2);
    }

    public final void N0(boolean prime) {
        List<MarketAppBrief> list = this.appItems;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(list, 10)), 16));
        for (MarketAppBrief marketAppBrief : list) {
            Pair pairA = Y8.j.a(marketAppBrief.getAppId(), k0(marketAppBrief));
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        List<MarketAppBrief> list2 = this.appItems;
        ArrayList arrayList = new ArrayList();
        for (MarketAppBrief marketAppBrief2 : list2) {
            Integer num = this.appProgress.get(marketAppBrief2.getPackageName());
            Pair pairA2 = num != null ? Y8.j.a(marketAppBrief2.getAppId(), Integer.valueOf(num.intValue())) : null;
            if (pairA2 != null) {
                arrayList.add(pairA2);
            }
        }
        Map<String, Integer> mapY = kotlin.collections.a.y(arrayList);
        if (prime) {
            this.appAdapter.k(linkedHashMap);
        } else {
            this.appAdapter.m(linkedHashMap, mapY);
        }
    }

    public final void Q0(RecyclerView rv, String cardType) {
        MarketAgentBrief marketAgentBrief;
        String id;
        RecyclerView.LayoutManager layoutManager = rv.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return;
        }
        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (iFindFirstVisibleItemPosition < 0 || iFindLastVisibleItemPosition < iFindFirstVisibleItemPosition || iFindFirstVisibleItemPosition > iFindLastVisibleItemPosition) {
            return;
        }
        int i10 = iFindFirstVisibleItemPosition;
        while (true) {
            if (kotlin.jvm.internal.p.d(cardType, C3577a2.TYPE_SKILL)) {
                SkillItemBrief skillItemBrief = (SkillItemBrief) Z8.F.t0(this.skillItems, i10);
                if (skillItemBrief != null && (id = skillItemBrief.getId()) != null) {
                    if (La.H.x0(id)) {
                        id = null;
                    }
                    if (id != null) {
                        if (this.exposedCardKeys.add(cardType + ServerSentEventKt.COLON + id)) {
                            C3577a2.INSTANCE.c(cardType, id, skillItemBrief.getName(), skillItemBrief.getVersion(), skillItemBrief.getNeedUpdate(), Integer.valueOf(i10));
                        }
                    }
                }
            } else if (kotlin.jvm.internal.p.d(cardType, "agent") && (marketAgentBrief = (MarketAgentBrief) Z8.F.t0(this.agentItems, i10)) != null) {
                if (this.exposedCardKeys.add(cardType + ServerSentEventKt.COLON + marketAgentBrief.getAssetId())) {
                    C3577a2.INSTANCE.c(cardType, marketAgentBrief.getAssetId(), marketAgentBrief.getName(), marketAgentBrief.getVersion(), marketAgentBrief.getNeedUpdate(), Integer.valueOf(i10));
                }
            }
            if (i10 == iFindLastVisibleItemPosition) {
                return;
            } else {
                i10++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R0(final android.view.View r16) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.space.TestSpaceFragment.R0(android.view.View):void");
    }

    public final boolean a1(Intent intent) {
        try {
            startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e10) {
            C4148a.t(NAV_TAG, "No activity can open the test app target", e10, false, 8, null);
            return false;
        } catch (SecurityException e11) {
            C4148a.t(NAV_TAG, "Cannot open the test app target", e11, false, 8, null);
            return false;
        }
    }

    public final void b1(ImageView imageView) {
        Object drawable = imageView.getDrawable();
        Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
        if (animatable != null) {
            animatable.start();
        }
    }

    public final Triple<String, String, String> c1(String scanType) {
        Bundle arguments;
        String string;
        String string2;
        if (this.scanConsumed || (arguments = getArguments()) == null) {
            return null;
        }
        C4148a.k(NAV_TAG, "takeScanFor(" + scanType + "): argType=" + arguments.getString(ARG_SCAN_TYPE) + " source=" + arguments.getString(ARG_SCAN_SOURCE) + " asset=" + arguments.getString(ARG_ASSET_ID), false, 4, null);
        if (kotlin.jvm.internal.p.d(arguments.getString(ARG_SCAN_TYPE), scanType) && (string = arguments.getString(ARG_SCAN_SOURCE)) != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null && (string2 = arguments.getString(ARG_ASSET_ID)) != null) {
                if (string2.length() <= 0) {
                    string2 = null;
                }
                if (string2 != null) {
                    this.scanConsumed = true;
                    return new Triple<>(string, scanType, string2);
                }
            }
        }
        return null;
    }

    public final void d1() {
        View viewFindViewById;
        int i10 = this.currentTabIndex;
        boolean z10 = true;
        if (i10 == 1 ? !(this.agentEmpty || this.agentError) : !(i10 == 2 ? this.appEmpty || this.appError : this.skillEmpty || this.skillError)) {
            z10 = false;
        }
        View view = getView();
        if (view == null || (viewFindViewById = view.findViewById(R$id.emptyState)) == null) {
            return;
        }
        viewFindViewById.setVisibility(z10 ? 0 : 8);
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.task.space.TestSpaceAppAdapter.ActionState k0(com.stepos.ailauncher.contract.model.MarketAppBrief r6) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            r5 = this;
            com.stepos.ailauncher.task.space.TestSpaceAppLinkPolicy r0 = com.stepos.ailauncher.task.space.TestSpaceAppLinkPolicy.INSTANCE
            java.lang.String r1 = r6.getAppType()
            boolean r1 = r0.b(r1)
            if (r1 == 0) goto L1c
            java.lang.String r5 = r6.getH5Url()
            java.lang.String r5 = r0.f(r5)
            if (r5 == 0) goto L19
            com.stepos.ailauncher.task.space.TestSpaceAppAdapter$ActionState r5 = com.stepos.ailauncher.task.space.TestSpaceAppAdapter.ActionState.OPEN
            return r5
        L19:
            com.stepos.ailauncher.task.space.TestSpaceAppAdapter$ActionState r5 = com.stepos.ailauncher.task.space.TestSpaceAppAdapter.ActionState.NONE
            return r5
        L1c:
            java.lang.String r1 = r6.getAppType()
            boolean r0 = r0.e(r1)
            if (r0 == 0) goto L90
            android.content.Context r5 = r5.getContext()
            r0 = 0
            r1 = 0
            if (r5 == 0) goto L4e
            java.lang.String r2 = r6.getPackageName()
            java.lang.CharSequence r2 = La.H.D1(r2)
            java.lang.String r2 = r2.toString()
            int r3 = r2.length()
            if (r3 <= 0) goto L41
            goto L42
        L41:
            r2 = r1
        L42:
            if (r2 != 0) goto L45
            goto L4e
        L45:
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4e
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r2, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4e
            goto L4f
        L4e:
            r5 = r1
        L4f:
            com.stepos.ailauncher.task.space.TestSpaceAppLinkPolicy r2 = com.stepos.ailauncher.task.space.TestSpaceAppLinkPolicy.INSTANCE
            r3 = 1
            if (r5 == 0) goto L55
            r0 = r3
        L55:
            java.lang.String r4 = r6.getH5Url()
            java.lang.String r6 = r6.getVersion()
            if (r5 == 0) goto L61
            java.lang.String r1 = r5.versionName
        L61:
            com.stepos.ailauncher.task.space.TestSpaceAppLinkPolicy$Action r5 = r2.a(r0, r4, r6, r1)
            int[] r6 = com.stepos.ailauncher.task.space.TestSpaceFragment.b.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r5 = r6[r5]
            if (r5 == r3) goto L8d
            r6 = 2
            if (r5 == r6) goto L8a
            r6 = 3
            if (r5 == r6) goto L87
            r6 = 4
            if (r5 == r6) goto L84
            r6 = 5
            if (r5 != r6) goto L7e
            com.stepos.ailauncher.task.space.TestSpaceAppAdapter$ActionState r5 = com.stepos.ailauncher.task.space.TestSpaceAppAdapter.ActionState.UPDATE_UNAVAILABLE
            goto L8f
        L7e:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        L84:
            com.stepos.ailauncher.task.space.TestSpaceAppAdapter$ActionState r5 = com.stepos.ailauncher.task.space.TestSpaceAppAdapter.ActionState.UPDATE
            goto L8f
        L87:
            com.stepos.ailauncher.task.space.TestSpaceAppAdapter$ActionState r5 = com.stepos.ailauncher.task.space.TestSpaceAppAdapter.ActionState.DOWNLOAD_UNAVAILABLE
            goto L8f
        L8a:
            com.stepos.ailauncher.task.space.TestSpaceAppAdapter$ActionState r5 = com.stepos.ailauncher.task.space.TestSpaceAppAdapter.ActionState.DOWNLOAD
            goto L8f
        L8d:
            com.stepos.ailauncher.task.space.TestSpaceAppAdapter$ActionState r5 = com.stepos.ailauncher.task.space.TestSpaceAppAdapter.ActionState.OPEN
        L8f:
            return r5
        L90:
            java.lang.String r0 = r6.getPackageName()
            boolean r1 = La.H.x0(r0)
            if (r1 == 0) goto Laa
            java.lang.String r5 = r6.getH5Url()
            boolean r5 = La.H.x0(r5)
            if (r5 == 0) goto La7
            com.stepos.ailauncher.task.space.TestSpaceAppAdapter$ActionState r5 = com.stepos.ailauncher.task.space.TestSpaceAppAdapter.ActionState.NONE
            return r5
        La7:
            com.stepos.ailauncher.task.space.TestSpaceAppAdapter$ActionState r5 = com.stepos.ailauncher.task.space.TestSpaceAppAdapter.ActionState.OPEN
            return r5
        Laa:
            java.util.Set<java.lang.String> r1 = r5.installingAppPkgs
            boolean r1 = r1.contains(r0)
            if (r1 == 0) goto Lb5
            com.stepos.ailauncher.task.space.TestSpaceAppAdapter$ActionState r5 = com.stepos.ailauncher.task.space.TestSpaceAppAdapter.ActionState.DOWNLOADING
            return r5
        Lb5:
            android.content.Context r1 = r5.getContext()
            if (r1 != 0) goto Lbe
            com.stepos.ailauncher.task.space.TestSpaceAppAdapter$ActionState r5 = com.stepos.ailauncher.task.space.TestSpaceAppAdapter.ActionState.DOWNLOAD
            return r5
        Lbe:
            com.stepos.ailauncher.foundation.appstore.j r2 = com.stepos.ailauncher.foundation.appstore.j.INSTANCE
            java.lang.String r0 = r2.u(r1, r0)
            if (r0 != 0) goto Lc9
            com.stepos.ailauncher.task.space.TestSpaceAppAdapter$ActionState r5 = com.stepos.ailauncher.task.space.TestSpaceAppAdapter.ActionState.DOWNLOAD
            return r5
        Lc9:
            java.lang.String r6 = r6.getVersion()
            boolean r5 = r5.q0(r6, r0)
            if (r5 == 0) goto Ld6
            com.stepos.ailauncher.task.space.TestSpaceAppAdapter$ActionState r5 = com.stepos.ailauncher.task.space.TestSpaceAppAdapter.ActionState.UPDATE
            return r5
        Ld6:
            com.stepos.ailauncher.task.space.TestSpaceAppAdapter$ActionState r5 = com.stepos.ailauncher.task.space.TestSpaceAppAdapter.ActionState.OPEN
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.space.TestSpaceFragment.k0(com.stepos.ailauncher.contract.model.MarketAppBrief):com.stepos.ailauncher.task.space.TestSpaceAppAdapter$ActionState");
    }

    public final e n0(String cardType) {
        return new e(cardType);
    }

    public final void o0(InterfaceC5063a<Y8.t> onConfirm) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        new DialogC3618f2(context, onConfirm).show();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        Iterator<T> it = this.installingAppPkgs.iterator();
        while (it.hasNext()) {
            com.stepos.ailauncher.foundation.appstore.j.INSTANCE.F((String) it.next(), this.appInstallCallback);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            return;
        }
        int iP0 = p0();
        if (iP0 == 1) {
            C3577a2.INSTANCE.h("agent");
            r0();
        } else if (iP0 == 2) {
            s0();
        } else {
            C3577a2.INSTANCE.h(C3577a2.TYPE_SKILL);
            t0();
        }
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
        Z0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        com.stepos.ailauncher.container.glass.k.b(view, 0, 1, null);
        View viewFindViewById = view.findViewById(R$id.btnBack);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C2773b6 c2773b6 = new C2773b6(viewLifecycleOwner, false, 2, null);
        View viewFindViewById2 = view.findViewById(R$id.tabBar);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        C2773b6 c2773b6P = C2773b6.p(c2773b6, new View[]{viewFindViewById2}, y7.o.INSTANCE.i(), false, 4, null);
        kotlin.jvm.internal.p.f(viewFindViewById);
        C2773b6 c2773b6P2 = C2773b6.p(c2773b6P, new View[]{viewFindViewById}, null, false, 6, null);
        View viewFindViewById3 = view.findViewById(R$id.topChromeBlur);
        kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
        C2773b6.j(c2773b6P2, new View[]{viewFindViewById3}, G.a.f43886a.g(), null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.y1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TestSpaceFragment.x0((A7.B) obj);
            }
        }, 4, null);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.J1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TestSpaceFragment.y0(this.f28814a, view2);
            }
        });
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.rvSkills);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        recyclerView.setAdapter(this.skillAdapter);
        Context context = recyclerView.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        recyclerView.addItemDecoration(new Z8(context));
        recyclerView.addOnScrollListener(n0(C3577a2.TYPE_SKILL));
        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R$id.rvAgents);
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
        RecyclerView.ItemAnimator itemAnimator2 = recyclerView2.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator2 = itemAnimator2 instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator2 : null;
        if (simpleItemAnimator2 != null) {
            simpleItemAnimator2.setSupportsChangeAnimations(false);
        }
        recyclerView2.setAdapter(this.agentAdapter);
        Context context2 = recyclerView2.getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        recyclerView2.addItemDecoration(new Z8(context2));
        recyclerView2.addOnScrollListener(n0("agent"));
        RecyclerView recyclerView3 = (RecyclerView) view.findViewById(R$id.rvApps);
        recyclerView3.setLayoutManager(new LinearLayoutManager(recyclerView3.getContext()));
        RecyclerView.ItemAnimator itemAnimator3 = recyclerView3.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator3 = itemAnimator3 instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator3 : null;
        if (simpleItemAnimator3 != null) {
            simpleItemAnimator3.setSupportsChangeAnimations(false);
        }
        recyclerView3.setAdapter(this.appAdapter);
        Context context3 = recyclerView3.getContext();
        kotlin.jvm.internal.p.h(context3, "getContext(...)");
        recyclerView3.addItemDecoration(new Z8(context3));
        view.findViewById(R$id.guideCardSkill).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.O1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TestSpaceFragment.D0(this.f28853a, view2);
            }
        });
        view.findViewById(R$id.guideCardAgent).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.P1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TestSpaceFragment.E0(this.f28858a, view2);
            }
        });
        final r6.i iVarA = r6.i.a(view);
        kotlin.jvm.internal.p.h(iVarA, "bind(...)");
        final RecyclerView rvSkills = iVarA.rvSkills;
        kotlin.jvm.internal.p.h(rvSkills, "rvSkills");
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        this.skillPages = new PagedListController<>(viewLifecycleOwner2, rvSkills, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.Q1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TestSpaceFragment.F0((SkillItemBrief) obj);
            }
        }, false, false, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.R1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TestSpaceFragment.G0(this.f28866a, rvSkills, iVarA, (C2796d7) obj);
            }
        }, 8, null);
        final RecyclerView rvAgents = iVarA.rvAgents;
        kotlin.jvm.internal.p.h(rvAgents, "rvAgents");
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        this.agentPages = new PagedListController<>(viewLifecycleOwner3, rvAgents, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.S1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TestSpaceFragment.I0((MarketAgentBrief) obj);
            }
        }, false, false, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.T1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TestSpaceFragment.z0(this.f28877a, rvAgents, iVarA, (C2796d7) obj);
            }
        }, 8, null);
        final RecyclerView rvApps = iVarA.rvApps;
        kotlin.jvm.internal.p.h(rvApps, "rvApps");
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        this.appPages = new PagedListController<>(viewLifecycleOwner4, rvApps, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.U1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TestSpaceFragment.B0((MarketAppBrief) obj);
            }
        }, false, false, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.V1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TestSpaceFragment.C0(this.f28890a, rvApps, iVarA, (C2796d7) obj);
            }
        }, 8, null);
        this.agentTabLoaded = false;
        this.appTabLoaded = false;
        this.skillError = false;
        this.agentError = false;
        this.appError = false;
        R0(view);
        View viewFindViewById4 = view.findViewById(R$id.ivLoadingSkill);
        kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
        b1((ImageView) viewFindViewById4);
        t0();
    }

    public final int p0() {
        View view = getView();
        if (view == null) {
            return 0;
        }
        if (view.findViewById(R$id.appContent).getVisibility() == 0) {
            return 2;
        }
        return view.findViewById(R$id.agentContent).getVisibility() == 0 ? 1 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q0(java.lang.String r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.space.TestSpaceFragment.q0(java.lang.String, java.lang.String):boolean");
    }

    public final void r0() {
        PagedListController<MarketAgentBrief> pagedListController;
        Triple<String, String, String> tripleC1 = c1("agent");
        PagedListController<MarketAgentBrief> pagedListController2 = this.agentPages;
        if (pagedListController2 == null) {
            kotlin.jvm.internal.p.A("agentPages");
            pagedListController = null;
        } else {
            pagedListController = pagedListController2;
        }
        PagedListController.x(pagedListController, 0, this.agentItems, new TestSpaceFragment$loadAgents$1(tripleC1, null), 1, null);
    }

    public final void s0() {
        PagedListController<MarketAppBrief> pagedListController;
        PagedListController<MarketAppBrief> pagedListController2 = this.appPages;
        if (pagedListController2 == null) {
            kotlin.jvm.internal.p.A("appPages");
            pagedListController = null;
        } else {
            pagedListController = pagedListController2;
        }
        PagedListController.x(pagedListController, 0, this.appItems, new TestSpaceFragment$loadApps$1(null), 1, null);
    }

    public final void u0(MarketAppBrief item) {
        Context context;
        PackageManager packageManager;
        TestSpaceAppLinkPolicy testSpaceAppLinkPolicy = TestSpaceAppLinkPolicy.INSTANCE;
        if (testSpaceAppLinkPolicy.b(item.getAppType())) {
            K0(item.getH5Url());
            return;
        }
        Intent launchIntentForPackage = null;
        if (testSpaceAppLinkPolicy.e(item.getAppType())) {
            int i10 = b.$EnumSwitchMapping$1[k0(item).ordinal()];
            if (i10 != 1) {
                if (i10 == 2 || i10 == 3) {
                    K0(item.getH5Url());
                    return;
                }
                return;
            }
            Context context2 = getContext();
            if (context2 != null && (packageManager = context2.getPackageManager()) != null) {
                launchIntentForPackage = packageManager.getLaunchIntentForPackage(La.H.D1(item.getPackageName()).toString());
            }
            if (launchIntentForPackage == null || !a1(launchIntentForPackage)) {
                K0(item.getH5Url());
                return;
            }
            return;
        }
        int i11 = b.$EnumSwitchMapping$1[k0(item).ordinal()];
        if (i11 == 1) {
            J0(item);
            return;
        }
        if ((i11 == 2 || i11 == 3) && (context = getContext()) != null) {
            String packageName = item.getPackageName();
            if (La.H.x0(packageName)) {
                return;
            }
            com.stepos.ailauncher.foundation.appstore.j jVar = com.stepos.ailauncher.foundation.appstore.j.INSTANCE;
            jVar.n(packageName, this.appInstallCallback);
            this.installingAppPkgs.add(packageName);
            O0(this, false, 1, null);
            com.stepos.ailauncher.foundation.appstore.j.I(jVar, context, packageName, 0L, 4, null);
        }
    }

    public final void v0(MarketAppBrief item) {
        final Context context;
        if (TestSpaceAppLinkPolicy.INSTANCE.b(item.getAppType()) || (context = getContext()) == null) {
            return;
        }
        final String string = La.H.D1(item.getPackageName()).toString();
        if (string.length() == 0 || com.stepos.ailauncher.foundation.appstore.j.INSTANCE.u(context, string) == null) {
            return;
        }
        o0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.M1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return TestSpaceFragment.w0(string, this, context);
            }
        });
    }
}
