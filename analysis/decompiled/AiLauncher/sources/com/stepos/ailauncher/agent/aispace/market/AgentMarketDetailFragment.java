package com.stepos.ailauncher.agent.aispace.market;

import Ua.C1060i;
import Y4.C1117a;
import Z8.C1173v;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.C1398p;
import android.view.LayoutInflater;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.blankj.utilcode.util.ToastUtils;
import com.stepos.ailauncher.agent.R$color;
import com.stepos.ailauncher.agent.R$drawable;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.market.data.AgentSkillDto;
import com.stepos.ailauncher.agent.skill.detail.SkillMarkwonFactoryKt;
import com.stepos.ailauncher.agent.skill.widget.ProgressSplitTextView;
import com.stepos.ailauncher.chat.view.C2765a9;
import com.stepos.ailauncher.chat.view.T9;
import com.stepos.ailauncher.contract.model.MarketAgentBrief;
import com.stepos.ailauncher.task.space.C3577a2;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;
import y7.G;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 z2\u00020\u0001:\u0002{|B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ-\u0010#\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040 H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010\u0003J\u000f\u0010*\u001a\u00020\u0004H\u0002¢\u0006\u0004\b*\u0010\u0003J\u000f\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010\u0003J\u0019\u0010.\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0004\b.\u0010/J\u001d\u00103\u001a\u00020\u00042\f\u00102\u001a\b\u0012\u0004\u0012\u00020100H\u0002¢\u0006\u0004\b3\u00104J\u0017\u00106\u001a\u00020\u00042\u0006\u00105\u001a\u000201H\u0002¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020%2\u0006\u00108\u001a\u00020%H\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020,H\u0002¢\u0006\u0004\b;\u0010<J+\u0010C\u001a\u00020\"2\u0006\u0010>\u001a\u00020=2\b\u0010@\u001a\u0004\u0018\u00010?2\b\u0010B\u001a\u0004\u0018\u00010AH\u0016¢\u0006\u0004\bC\u0010DJ!\u0010F\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\"2\b\u0010B\u001a\u0004\u0018\u00010AH\u0016¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0004H\u0016¢\u0006\u0004\bH\u0010\u0003J\u000f\u0010I\u001a\u00020\u0004H\u0016¢\u0006\u0004\bI\u0010\u0003J\u0017\u0010K\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u0019H\u0016¢\u0006\u0004\bK\u0010\u001cJ\u000f\u0010L\u001a\u00020\u0004H\u0016¢\u0006\u0004\bL\u0010\u0003R\u0018\u0010N\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010U\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010W\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010TR\u001b\u0010]\u001a\u00020X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u0018\u0010_\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010`R\u0016\u0010b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010VR\u0018\u0010c\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010`R\u0018\u0010e\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010h\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010j\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0014\u0010m\u001a\u00020l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010q\u001a\u00020M8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bo\u0010pR\u0014\u0010t\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\br\u0010sR\u0014\u0010w\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bu\u0010vR\u0014\u0010y\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bx\u0010v¨\u0006}"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketDetailFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "LY8/t;", "w0", "U0", "F0", "G0", "r1", "n1", "", "text", "v0", "(Ljava/lang/CharSequence;)V", "x0", "c1", "y1", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;", "status", "y0", "(Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;)V", "R0", "M0", "O0", "", "show", "q1", "(Z)V", "checked", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketDetailFragment$SwitchMode;", "mode", "Lkotlin/Function0;", "onToggle", "Landroid/view/View;", "J0", "(ZLcom/stepos/ailauncher/agent/aispace/market/AgentMarketDetailFragment$SwitchMode;Lp9/a;)Landroid/view/View;", "", "pct", "s1", "(I)V", "H0", "t1", SdCardDbCreator.FIELD_LASTLOC_ID, "", "raw", "V0", "(Ljava/lang/String;)Ljava/lang/String;", "", "Lcom/stepos/ailauncher/agent/aispace/market/data/f;", "skills", "o1", "(Ljava/util/List;)V", C3577a2.TYPE_SKILL, "A1", "(Lcom/stepos/ailauncher/agent/aispace/market/data/f;)V", "v", "L0", "(I)I", "B1", "(Ljava/lang/String;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "hidden", "onHiddenChanged", "onDestroyView", "LY4/a;", "_binding", "LY4/a;", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", "item", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", "developer", "Ljava/lang/String;", "needUpdate", "Z", "latestVersion", "Lu8/e;", "markwon$delegate", "LY8/h;", "X0", "()Lu8/e;", "markwon", "Ly7/E;", "backGlassHandle", "Ly7/E;", "uninstallGlassHandle", "topUninstalling", "bottomAreaBlurHandle", "Landroid/graphics/drawable/Drawable;", "uninstallFallbackBackground", "Landroid/graphics/drawable/Drawable;", "", "savedContentPadding", "[I", "savedPanelPaddingTop", "Ljava/lang/Integer;", "Ljava/lang/Runnable;", "hideSuccessBar", "Ljava/lang/Runnable;", "W0", "()LY4/a;", "binding", "Y0", "()I", "queryTesting", "e", "()Z", "extendsContentToBottomEdge", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "showsSheetDragHandle", "Companion", "SwitchMode", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentMarketDetailFragment extends com.stepos.ailauncher.sheet.nav.a {
    private static final String ARG_ITEM = "arg_agent_market_item";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DESC_MAX_LINES_COLLAPSED = 2;
    private static final int FOOTER_TEXT_ON_FILL = -14935010;
    private static final int FOOTER_TEXT_ON_TRACK = -1;
    public static final String TAG = "agent_market_detail";
    private C1117a _binding;
    private y7.E backGlassHandle;
    private y7.E bottomAreaBlurHandle;
    private AgentMarketItem item;
    private boolean needUpdate;
    private int[] savedContentPadding;
    private Integer savedPanelPaddingTop;
    private boolean topUninstalling;
    private Drawable uninstallFallbackBackground;
    private y7.E uninstallGlassHandle;
    private String developer = "";
    private String latestVersion = "";

    /* renamed from: markwon$delegate, reason: from kotlin metadata */
    private final Y8.h markwon = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.market.q0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return AgentMarketDetailFragment.b1(this.f24210a);
        }
    });
    private final Runnable hideSuccessBar = new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.market.r0
        @Override // java.lang.Runnable
        public final void run() {
            AgentMarketDetailFragment.Z0(this.f24213a);
        }
    };

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketDetailFragment$SwitchMode;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "GREYED", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class SwitchMode {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ SwitchMode[] $VALUES;
        public static final SwitchMode NORMAL = new SwitchMode("NORMAL", 0);
        public static final SwitchMode GREYED = new SwitchMode("GREYED", 1);

        private static final /* synthetic */ SwitchMode[] $values() {
            return new SwitchMode[]{NORMAL, GREYED};
        }

        static {
            SwitchMode[] switchModeArr$values = $values();
            $VALUES = switchModeArr$values;
            $ENTRIES = kotlin.enums.a.a(switchModeArr$values);
        }

        private SwitchMode(String str, int i10) {
        }

        public static InterfaceC4149a<SwitchMode> getEntries() {
            return $ENTRIES;
        }

        public static SwitchMode valueOf(String str) {
            return (SwitchMode) Enum.valueOf(SwitchMode.class, str);
        }

        public static SwitchMode[] values() {
            return (SwitchMode[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketDetailFragment$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;", "item", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketDetailFragment;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;)Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketDetailFragment;", "", "ARG_ITEM", "Ljava/lang/String;", "", "FOOTER_TEXT_ON_FILL", "I", "FOOTER_TEXT_ON_TRACK", "DESC_MAX_LINES_COLLAPSED", "TAG", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final AgentMarketDetailFragment a(MarketAgentBrief item) {
            kotlin.jvm.internal.p.i(item, "item");
            AgentMarketDetailFragment agentMarketDetailFragment = new AgentMarketDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(AgentMarketDetailFragment.ARG_ITEM, item);
            agentMarketDetailFragment.setArguments(bundle);
            return agentMarketDetailFragment;
        }

        public Companion() {
        }
    }

    public static final void A0(AgentMarketDetailFragment agentMarketDetailFragment, View view) {
        AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
        AgentMarketItem agentMarketItem = agentMarketDetailFragment.item;
        if (agentMarketItem == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem = null;
        }
        agentMarketOperaManager.V(agentMarketItem);
    }

    private final void A1(AgentSkillDto skill) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new AgentMarketDetailFragment$showSkillMd$1(skill, this, null), 3, null);
    }

    public static final void B0(AgentMarketDetailFragment agentMarketDetailFragment, View view) {
        AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
        AgentMarketItem agentMarketItem = agentMarketDetailFragment.item;
        if (agentMarketItem == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem = null;
        }
        agentMarketOperaManager.y(agentMarketItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B1(String text) {
        ToastUtils.o().q(-231591374).r(-1).v(text, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t C0() {
        return Y8.t.f7040a;
    }

    public static final Y8.t D0(AgentMarketDetailFragment agentMarketDetailFragment) {
        AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
        AgentMarketItem agentMarketItem = agentMarketDetailFragment.item;
        if (agentMarketItem == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem = null;
        }
        agentMarketOperaManager.N(agentMarketItem, false);
        return Y8.t.f7040a;
    }

    public static final Y8.t E0(AgentMarketDetailFragment agentMarketDetailFragment) {
        AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
        AgentMarketItem agentMarketItem = agentMarketDetailFragment.item;
        if (agentMarketItem == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem = null;
        }
        agentMarketOperaManager.N(agentMarketItem, true);
        return Y8.t.f7040a;
    }

    private final void H0() {
        Context contextRequireContext = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        AgentMarketItem agentMarketItem = this.item;
        if (agentMarketItem == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem = null;
        }
        new C0(contextRequireContext, agentMarketItem.getDisplayName(), new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.market.k0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentMarketDetailFragment.I0(this.f24200a);
            }
        }).show();
    }

    public static final Y8.t I0(AgentMarketDetailFragment agentMarketDetailFragment) {
        AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
        AgentMarketItem agentMarketItem = agentMarketDetailFragment.item;
        if (agentMarketItem == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem = null;
        }
        agentMarketOperaManager.U(agentMarketItem);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(InterfaceC5063a interfaceC5063a, View view) {
        interfaceC5063a.invoke();
    }

    private final int L0(int v10) {
        return (int) (v10 * getResources().getDisplayMetrics().density);
    }

    public static final Y8.t N0(AgentMarketDetailFragment agentMarketDetailFragment, y7.E released) {
        kotlin.jvm.internal.p.i(released, "released");
        if (agentMarketDetailFragment.backGlassHandle == released) {
            agentMarketDetailFragment.backGlassHandle = null;
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t P0(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        attachGradientBlur.n(64.0f);
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    public static final Y8.t Q0(AgentMarketDetailFragment agentMarketDetailFragment, y7.E released) {
        kotlin.jvm.internal.p.i(released, "released");
        if (agentMarketDetailFragment.bottomAreaBlurHandle == released) {
            agentMarketDetailFragment.bottomAreaBlurHandle = null;
        }
        return Y8.t.f7040a;
    }

    public static final void S0(AgentMarketDetailFragment agentMarketDetailFragment, FrameLayout frameLayout) {
        if (agentMarketDetailFragment._binding != null && frameLayout.isAttachedToWindow() && frameLayout.getVisibility() == 0) {
            agentMarketDetailFragment.R0();
        }
    }

    public static final Y8.t T0(AgentMarketDetailFragment agentMarketDetailFragment, FrameLayout frameLayout, y7.E released) {
        kotlin.jvm.internal.p.i(released, "released");
        if (agentMarketDetailFragment.uninstallGlassHandle == released) {
            agentMarketDetailFragment.uninstallGlassHandle = null;
            frameLayout.setBackground(agentMarketDetailFragment.uninstallFallbackBackground);
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String V0(String raw) {
        if (raw == null || La.H.x0(raw)) {
            return "—";
        }
        if (raw.length() < 10 || raw.charAt(4) != '-' || raw.charAt(7) != '-') {
            return raw;
        }
        String strSubstring = raw.substring(0, 10);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final u8.e X0() {
        return (u8.e) this.markwon.getValue();
    }

    public static final void Z0(AgentMarketDetailFragment agentMarketDetailFragment) {
        LinearLayout linearLayout;
        C1117a c1117a = agentMarketDetailFragment._binding;
        if (c1117a == null || (linearLayout = c1117a.barInstallSuccess) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    private final void a1() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new AgentMarketDetailFragment$loadDetail$1(this, null), 3, null);
    }

    public static final u8.e b1(AgentMarketDetailFragment agentMarketDetailFragment) {
        Context contextRequireContext = agentMarketDetailFragment.requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        return SkillMarkwonFactoryKt.b(contextRequireContext);
    }

    private final void c1() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new AgentMarketDetailFragment$observeStatus$1(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner2), null, null, new AgentMarketDetailFragment$observeStatus$2(this, null), 3, null);
    }

    public static final void d1(AgentMarketDetailFragment agentMarketDetailFragment) {
        agentMarketDetailFragment.M0();
    }

    public static final void e1(AgentMarketDetailFragment agentMarketDetailFragment) {
        FrameLayout frameLayout;
        C1117a c1117a = agentMarketDetailFragment._binding;
        if (c1117a == null || (frameLayout = c1117a.btnTopUninstall) == null || frameLayout.getVisibility() != 0) {
            return;
        }
        agentMarketDetailFragment.R0();
    }

    public static final void f1(AgentMarketDetailFragment agentMarketDetailFragment) {
        agentMarketDetailFragment.M0();
    }

    public static final void g1(AgentMarketDetailFragment agentMarketDetailFragment) {
        FrameLayout frameLayout;
        C1117a c1117a = agentMarketDetailFragment._binding;
        if (c1117a == null || (frameLayout = c1117a.btnTopUninstall) == null || frameLayout.getVisibility() != 0) {
            return;
        }
        agentMarketDetailFragment.R0();
    }

    public static final void h1(AgentMarketDetailFragment agentMarketDetailFragment, View view) {
        if (agentMarketDetailFragment.x()) {
            return;
        }
        agentMarketDetailFragment.o();
    }

    public static final void i1(final AgentMarketDetailFragment agentMarketDetailFragment, View view) {
        FrameLayout btnTopUninstall = agentMarketDetailFragment.W0().btnTopUninstall;
        kotlin.jvm.internal.p.h(btnTopUninstall, "btnTopUninstall");
        T9.c(btnTopUninstall, 8.0f, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.market.V
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentMarketDetailFragment.j1(this.f24173a);
            }
        });
    }

    public static final Y8.t j1(AgentMarketDetailFragment agentMarketDetailFragment) {
        agentMarketDetailFragment.H0();
        return Y8.t.f7040a;
    }

    public static final void k1(AgentMarketDetailFragment agentMarketDetailFragment) {
        agentMarketDetailFragment.M0();
    }

    public static final void l1(AgentMarketDetailFragment agentMarketDetailFragment) {
        if (agentMarketDetailFragment._binding != null) {
            com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
            View vTopMask = agentMarketDetailFragment.W0().vTopMask;
            kotlin.jvm.internal.p.h(vTopMask, "vTopMask");
            com.stepos.ailauncher.container.glass.h.v(hVar, vTopMask, false, G.a.f43886a.g(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.market.N
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentMarketDetailFragment.m1((A7.B) obj);
                }
            }, 2, null);
        }
    }

    public static final Y8.t m1(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    private final void n1() {
        TextView textView = W0().tvSkillIconChar;
        AgentMarketItem agentMarketItem = this.item;
        AgentMarketItem agentMarketItem2 = null;
        if (agentMarketItem == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem = null;
        }
        textView.setText(agentMarketItem.getIconChar());
        ImageView ivSkillIcon = W0().ivSkillIcon;
        kotlin.jvm.internal.p.h(ivSkillIcon, "ivSkillIcon");
        TextView tvSkillIconChar = W0().tvSkillIconChar;
        kotlin.jvm.internal.p.h(tvSkillIconChar, "tvSkillIconChar");
        AgentMarketItem agentMarketItem3 = this.item;
        if (agentMarketItem3 == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem3 = null;
        }
        C2765a9.a(ivSkillIcon, tvSkillIconChar, agentMarketItem3.getIconUrl());
        TextView textView2 = W0().tvTitle;
        AgentMarketItem agentMarketItem4 = this.item;
        if (agentMarketItem4 == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem4 = null;
        }
        textView2.setText(agentMarketItem4.getDisplayName());
        AgentMarketItem agentMarketItem5 = this.item;
        if (agentMarketItem5 == null) {
            kotlin.jvm.internal.p.A("item");
        } else {
            agentMarketItem2 = agentMarketItem5;
        }
        v0(agentMarketItem2.getDescription());
        x0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o1(List<AgentSkillDto> skills) {
        LinearLayout containerSkills = W0().containerSkills;
        kotlin.jvm.internal.p.h(containerSkills, "containerSkills");
        containerSkills.removeAllViews();
        boolean zIsEmpty = skills.isEmpty();
        containerSkills.setVisibility(zIsEmpty ? 8 : 0);
        W0().tvSkillSectionTitle.setVisibility(zIsEmpty ? 8 : 0);
        int i10 = 0;
        for (Object obj : skills) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            final AgentSkillDto agentSkillDto = (AgentSkillDto) obj;
            Y4.w wVarC = Y4.w.c(LayoutInflater.from(requireContext()), containerSkills, false);
            kotlin.jvm.internal.p.h(wVarC, "inflate(...)");
            TextView textView = wVarC.tvSkillName;
            String skillName = agentSkillDto.getSkillName();
            if (skillName == null) {
                skillName = agentSkillDto.getSkillId();
            }
            textView.setText(skillName);
            TextView textView2 = wVarC.tvSkillDesc;
            String skillDescription = agentSkillDto.getSkillDescription();
            if (skillDescription == null) {
                skillDescription = "";
            }
            textView2.setText(skillDescription);
            wVarC.b().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.f0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AgentMarketDetailFragment.p1(this.f24191a, agentSkillDto, view);
                }
            });
            containerSkills.addView(wVarC.b());
            if (i10 != C1173v.o(skills)) {
                View view = new View(requireContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, L0(1));
                layoutParams.setMarginStart(L0(56));
                layoutParams.setMarginEnd(L0(16));
                view.setLayoutParams(layoutParams);
                view.setBackgroundColor(452984831);
                containerSkills.addView(view);
            }
            i10 = i11;
        }
    }

    public static final void p1(AgentMarketDetailFragment agentMarketDetailFragment, AgentSkillDto agentSkillDto, View view) {
        agentMarketDetailFragment.A1(agentSkillDto);
    }

    private final void q1(boolean show) {
        W0().llUpdateBanner.setVisibility(show ? 0 : 8);
        if (show) {
            TextView textView = W0().tvUpdateBannerTitle;
            int i10 = R$string.agent_detail_update_banner_title;
            String version = this.latestVersion;
            if (La.H.x0(version)) {
                AgentMarketItem agentMarketItem = this.item;
                if (agentMarketItem == null) {
                    kotlin.jvm.internal.p.A("item");
                    agentMarketItem = null;
                }
                version = agentMarketItem.getVersion();
                if (La.H.x0(version)) {
                    version = "1.0.0";
                }
            }
            textView.setText(getString(i10, version));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s1(int pct) {
        Drawable drawableFindDrawableByLayerId;
        Drawable background = W0().btnBottom.getBackground();
        LayerDrawable layerDrawable = background instanceof LayerDrawable ? (LayerDrawable) background : null;
        if (layerDrawable == null || (drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R$id.agent_install_progress_fill)) == null) {
            return;
        }
        drawableFindDrawableByLayerId.setLevel(C5685n.n(pct * 100, 0, 10000));
    }

    private final void t1() {
        W0().btnDebugLogToggle.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentMarketDetailFragment.u1(this.f24165a, view);
            }
        });
        W0().btnDebugLogClose.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.S
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentMarketDetailFragment.v1(this.f24171a, view);
            }
        });
        W0().btnDebugLogClear.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.T
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentMarketDetailFragment.w1(view);
            }
        });
        W0().tvDebugLog.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.U
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return AgentMarketDetailFragment.x1(this.f24172a, view);
            }
        });
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new AgentMarketDetailFragment$setupDebugLog$5(this, null), 3, null);
    }

    public static final void u1(AgentMarketDetailFragment agentMarketDetailFragment, View view) {
        agentMarketDetailFragment.W0().flDebugLogContainer.setVisibility(agentMarketDetailFragment.W0().flDebugLogContainer.getVisibility() == 0 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(CharSequence text) {
        com.stepos.ailauncher.common.widget.b bVar = com.stepos.ailauncher.common.widget.b.INSTANCE;
        TextView tvDescription = W0().tvDescription;
        kotlin.jvm.internal.p.h(tvDescription, "tvDescription");
        String string = getString(R$string.agent_detail_more);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        String string2 = getString(R$string.skill_detail_desc_collapse);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        com.stepos.ailauncher.common.widget.b.c(bVar, tvDescription, text, 2, string, string2, -1, null, 64, null);
    }

    public static final void v1(AgentMarketDetailFragment agentMarketDetailFragment, View view) {
        agentMarketDetailFragment.W0().flDebugLogContainer.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(View view) {
        C2277j.INSTANCE.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0() {
        ArrayList arrayList = new ArrayList();
        AgentMarketItem agentMarketItem = this.item;
        AgentMarketItem agentMarketItem2 = null;
        if (agentMarketItem == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem = null;
        }
        String version = agentMarketItem.getVersion();
        if (La.H.x0(version)) {
            version = "1.0.0";
        }
        arrayList.add("v" + ((Object) version));
        String developer = this.developer;
        if (La.H.x0(developer)) {
            AgentMarketItem agentMarketItem3 = this.item;
            if (agentMarketItem3 == null) {
                kotlin.jvm.internal.p.A("item");
            } else {
                agentMarketItem2 = agentMarketItem3;
            }
            developer = agentMarketItem2.getDeveloper();
        }
        if (!La.H.x0(developer)) {
            arrayList.add(developer);
        }
        if (Y0() != 1) {
            String string = getString(R$string.agent_detail_audited);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            arrayList.add(string);
        }
        W0().tvMeta.setText(Z8.F.A0(arrayList, " · ", null, null, 0, null, null, 62, null));
    }

    public static final boolean x1(AgentMarketDetailFragment agentMarketDetailFragment, View view) {
        CharSequence text = agentMarketDetailFragment.W0().tvDebugLog.getText();
        String string = text != null ? text.toString() : null;
        if (string == null) {
            string = "";
        }
        if (La.H.x0(string)) {
            return false;
        }
        Object systemService = agentMarketDetailFragment.requireContext().getSystemService("clipboard");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("agent_market_debug_log", string));
        agentMarketDetailFragment.B1("日志已复制");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0(AgentMarketStatus status) {
        String string;
        boolean zIsInstalled = status.isInstalled();
        boolean z10 = status == AgentMarketStatus.INSTALLING || status == AgentMarketStatus.QUEUED;
        boolean z11 = status == AgentMarketStatus.UPDATING;
        boolean z12 = z10 || z11;
        boolean z13 = status == AgentMarketStatus.UNINSTALLING;
        boolean z14 = zIsInstalled && this.needUpdate && !z12 && !z13;
        q1(z14);
        W0().footerContainer.setVisibility((z13 || (zIsInstalled && !z14)) ? 8 : 0);
        W0().vBottomMask.setVisibility(W0().footerContainer.getVisibility() == 0 ? 0 : 8);
        if (W0().vBottomMask.getVisibility() == 0) {
            W0().vBottomMask.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.market.X
                @Override // java.lang.Runnable
                public final void run() {
                    AgentMarketDetailFragment.z0(this.f24175a);
                }
            });
        }
        W0().btnBottom.setVisibility(0);
        W0().pbBottom.setVisibility(8);
        W0().btnBottom.setClickable(!z12);
        ProgressSplitTextView progressSplitTextView = W0().btnBottom;
        if (z11) {
            int i10 = R$string.agent_detail_updating_percent;
            AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
            AgentMarketItem agentMarketItem = this.item;
            if (agentMarketItem == null) {
                kotlin.jvm.internal.p.A("item");
                agentMarketItem = null;
            }
            string = getString(i10, Integer.valueOf(agentMarketOperaManager.I(agentMarketItem.getAssetId())));
        } else if (z10) {
            int i11 = R$string.agent_detail_installing_percent;
            AgentMarketOperaManager agentMarketOperaManager2 = AgentMarketOperaManager.INSTANCE;
            AgentMarketItem agentMarketItem2 = this.item;
            if (agentMarketItem2 == null) {
                kotlin.jvm.internal.p.A("item");
                agentMarketItem2 = null;
            }
            string = getString(i11, Integer.valueOf(agentMarketOperaManager2.I(agentMarketItem2.getAssetId())));
        } else if (z14) {
            int i12 = R$string.agent_detail_update;
            String version = this.latestVersion;
            if (La.H.x0(version)) {
                AgentMarketItem agentMarketItem3 = this.item;
                if (agentMarketItem3 == null) {
                    kotlin.jvm.internal.p.A("item");
                    agentMarketItem3 = null;
                }
                version = agentMarketItem3.getVersion();
                if (La.H.x0(version)) {
                    version = "1.0.0";
                }
            }
            string = getString(i12, version);
        } else {
            string = getString(R$string.agent_detail_install);
        }
        progressSplitTextView.setText(string);
        W0().btnBottom.setOnClickListener(z12 ? null : z14 ? new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.Z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentMarketDetailFragment.A0(this.f24177a, view);
            }
        } : new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentMarketDetailFragment.B0(this.f24180a, view);
            }
        });
        W0().btnBottom.setBackgroundResource(z12 ? R$drawable.bg_agent_installing_progress : R$drawable.bg_skill_detail_footer_button);
        W0().btnBottom.setFilledTextColor(FOOTER_TEXT_ON_FILL);
        W0().btnBottom.setUnfilledTextColor(-1);
        if (z12) {
            AgentMarketOperaManager agentMarketOperaManager3 = AgentMarketOperaManager.INSTANCE;
            AgentMarketItem agentMarketItem4 = this.item;
            if (agentMarketItem4 == null) {
                kotlin.jvm.internal.p.A("item");
                agentMarketItem4 = null;
            }
            int I10 = agentMarketOperaManager3.I(agentMarketItem4.getAssetId());
            s1(I10);
            W0().btnBottom.setProgressFraction(I10 / 100.0f);
        } else {
            W0().btnBottom.setProgressFraction(1.0f);
        }
        this.topUninstalling = z13;
        W0().btnTopUninstall.setVisibility((zIsInstalled || z13) ? 0 : 8);
        W0().ivTopUninstall.setVisibility(z13 ? 8 : 0);
        W0().pbTopUninstall.setVisibility(z13 ? 0 : 8);
        W0().btnTopUninstall.setClickable(!z13);
        if (!zIsInstalled || z13) {
            com.stepos.ailauncher.container.glass.h.INSTANCE.F(this.uninstallGlassHandle);
            this.uninstallGlassHandle = null;
            W0().btnTopUninstall.setBackground(z13 ? null : this.uninstallFallbackBackground);
        } else {
            R0();
        }
        W0().actionArea.removeAllViews();
        if (z13) {
            W0().actionArea.addView(J0(status != AgentMarketStatus.INSTALLED_DISABLED, SwitchMode.GREYED, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.market.b0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AgentMarketDetailFragment.C0();
                }
            }));
        } else if (status == AgentMarketStatus.INSTALLED_ENABLED) {
            W0().actionArea.addView(J0(true, SwitchMode.NORMAL, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.market.c0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AgentMarketDetailFragment.D0(this.f24181a);
                }
            }));
        } else if (status == AgentMarketStatus.INSTALLED_DISABLED) {
            W0().actionArea.addView(J0(false, SwitchMode.NORMAL, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.market.d0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AgentMarketDetailFragment.E0(this.f24185a);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y1() {
        W0().barInstallSuccess.setVisibility(0);
        W0().barInstallSuccess.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentMarketDetailFragment.z1(this.f24188a, view);
            }
        });
        W0().barInstallSuccess.removeCallbacks(this.hideSuccessBar);
        W0().barInstallSuccess.postDelayed(this.hideSuccessBar, 5000L);
    }

    public static final void z0(AgentMarketDetailFragment agentMarketDetailFragment) {
        agentMarketDetailFragment.O0();
    }

    public static final void z1(AgentMarketDetailFragment agentMarketDetailFragment, View view) {
        agentMarketDetailFragment.W0().barInstallSuccess.removeCallbacks(agentMarketDetailFragment.hideSuccessBar);
        agentMarketDetailFragment.W0().barInstallSuccess.setVisibility(8);
    }

    public final void F0() {
        View viewFindViewById;
        androidx.fragment.app.r activity = getActivity();
        View viewFindViewById2 = activity != null ? activity.findViewById(com.stepos.ailauncher.sheet.R$id.ail_sheet_panel) : null;
        if (viewFindViewById2 != null) {
            if (this.savedPanelPaddingTop == null) {
                this.savedPanelPaddingTop = Integer.valueOf(viewFindViewById2.getPaddingTop());
            }
            viewFindViewById2.setPadding(viewFindViewById2.getPaddingLeft(), 0, viewFindViewById2.getPaddingRight(), viewFindViewById2.getPaddingBottom());
        }
        androidx.fragment.app.r activity2 = getActivity();
        if (activity2 == null || (viewFindViewById = activity2.findViewById(com.stepos.ailauncher.sheet.R$id.ail_settle_hint)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    public final void G0() {
        View viewFindViewById;
        androidx.fragment.app.r activity = getActivity();
        if (activity == null || (viewFindViewById = activity.findViewById(com.stepos.ailauncher.sheet.R$id.ail_content_container)) == null) {
            return;
        }
        if (this.savedContentPadding == null) {
            this.savedContentPadding = new int[]{viewFindViewById.getPaddingLeft(), viewFindViewById.getPaddingTop(), viewFindViewById.getPaddingRight(), viewFindViewById.getPaddingBottom()};
        }
        viewFindViewById.setPadding(0, 0, 0, viewFindViewById.getPaddingBottom());
    }

    public final View J0(boolean checked, SwitchMode mode, final InterfaceC5063a<Y8.t> onToggle) {
        float f10 = getResources().getDisplayMetrics().density;
        int i10 = (int) (40 * f10);
        int i11 = (int) (22 * f10);
        int i12 = (int) (14 * f10);
        int i13 = (int) (4 * f10);
        int iC = androidx.core.content.a.c(requireContext(), R$color.sd_link);
        int iC2 = androidx.core.content.a.c(requireContext(), R$color.skill_switch_track_off_value);
        FrameLayout frameLayout = new FrameLayout(requireContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(i10, i11));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(i11 / 2.0f);
        if (!checked) {
            iC = iC2;
        }
        gradientDrawable.setColor(iC);
        frameLayout.setBackground(gradientDrawable);
        View view = new View(requireContext());
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(-1);
        view.setBackground(gradientDrawable2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i12, i12);
        layoutParams.gravity = (checked ? 8388613 : 8388611) | 16;
        layoutParams.setMarginStart(i13);
        layoutParams.setMarginEnd(i13);
        Y8.t tVar = Y8.t.f7040a;
        frameLayout.addView(view, layoutParams);
        if (mode == SwitchMode.GREYED) {
            frameLayout.setAlpha(0.4f);
            frameLayout.setClickable(false);
            return frameLayout;
        }
        frameLayout.setClickable(true);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AgentMarketDetailFragment.K0(onToggle, view2);
            }
        });
        return frameLayout;
    }

    public final void M0() {
        if (this.backGlassHandle != null || this._binding == null || isHidden()) {
            return;
        }
        ImageView ivBack = W0().ivBack;
        kotlin.jvm.internal.p.h(ivBack, "ivBack");
        if (ivBack.isAttachedToWindow()) {
            com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
            y7.E eM = com.stepos.ailauncher.container.glass.h.m(hVar, ivBack, false, Float.valueOf(22.0f), y7.o.INSTANCE.i(), false, 16, null);
            this.backGlassHandle = eM;
            hVar.G(ivBack, eM, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.market.W
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentMarketDetailFragment.N0(this.f24174a, (y7.E) obj);
                }
            });
        }
    }

    public final void O0() {
        com.stepos.ailauncher.container.glass.h hVar;
        y7.E eV;
        if (this.bottomAreaBlurHandle != null || this._binding == null || isHidden()) {
            return;
        }
        View vBottomMask = W0().vBottomMask;
        kotlin.jvm.internal.p.h(vBottomMask, "vBottomMask");
        if (vBottomMask.isAttachedToWindow() && vBottomMask.getVisibility() == 0 && (eV = com.stepos.ailauncher.container.glass.h.v((hVar = com.stepos.ailauncher.container.glass.h.INSTANCE), vBottomMask, false, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.market.g0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentMarketDetailFragment.P0((A7.B) obj);
            }
        }, 4, null)) != null) {
            this.bottomAreaBlurHandle = eV;
            hVar.G(vBottomMask, eV, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.market.h0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentMarketDetailFragment.Q0(this.f24196a, (y7.E) obj);
                }
            });
        }
    }

    public final void R0() {
        if (this.topUninstalling || this.uninstallGlassHandle != null || this._binding == null || isHidden()) {
            return;
        }
        final FrameLayout btnTopUninstall = W0().btnTopUninstall;
        kotlin.jvm.internal.p.h(btnTopUninstall, "btnTopUninstall");
        if (!btnTopUninstall.isAttachedToWindow()) {
            btnTopUninstall.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.market.O
                @Override // java.lang.Runnable
                public final void run() {
                    AgentMarketDetailFragment.S0(this.f24160a, btnTopUninstall);
                }
            });
            return;
        }
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        y7.E eM = com.stepos.ailauncher.container.glass.h.m(hVar, btnTopUninstall, false, Float.valueOf(22.0f), null, false, 24, null);
        this.uninstallGlassHandle = eM;
        if (eM == null) {
            btnTopUninstall.setBackground(this.uninstallFallbackBackground);
        } else {
            btnTopUninstall.setBackground(null);
            hVar.G(btnTopUninstall, eM, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.market.P
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentMarketDetailFragment.T0(this.f24162a, btnTopUninstall, (y7.E) obj);
                }
            });
        }
    }

    public final void U0() {
        F0();
        G0();
    }

    public final C1117a W0() {
        C1117a c1117a = this._binding;
        kotlin.jvm.internal.p.f(c1117a);
        return c1117a;
    }

    public final int Y0() {
        AgentMarketItem agentMarketItem = this.item;
        AgentMarketItem agentMarketItem2 = null;
        if (agentMarketItem == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem = null;
        }
        if (!agentMarketItem.getTesting()) {
            return 0;
        }
        AgentMarketItem agentMarketItem3 = this.item;
        if (agentMarketItem3 == null) {
            kotlin.jvm.internal.p.A("item");
        } else {
            agentMarketItem2 = agentMarketItem3;
        }
        return !kotlin.jvm.internal.p.d(agentMarketItem2.getEnv(), "prod") ? 1 : 0;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean e() {
        return true;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(inflater, "inflater");
        this._binding = C1117a.c(inflater, container, false);
        FrameLayout root = W0().root;
        kotlin.jvm.internal.p.h(root, "root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        r1();
        W0().barInstallSuccess.removeCallbacks(this.hideSuccessBar);
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        hVar.F(this.backGlassHandle);
        this.backGlassHandle = null;
        hVar.F(this.uninstallGlassHandle);
        this.uninstallGlassHandle = null;
        hVar.F(this.bottomAreaBlurHandle);
        this.bottomAreaBlurHandle = null;
        this.uninstallFallbackBackground = null;
        this._binding = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        FrameLayout frameLayout;
        ImageView imageView;
        FrameLayout frameLayout2;
        super.onHiddenChanged(hidden);
        AgentMarketItem agentMarketItem = null;
        if (hidden) {
            com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
            hVar.F(this.backGlassHandle);
            this.backGlassHandle = null;
            hVar.F(this.uninstallGlassHandle);
            this.uninstallGlassHandle = null;
            hVar.F(this.bottomAreaBlurHandle);
            this.bottomAreaBlurHandle = null;
            C1117a c1117a = this._binding;
            if (c1117a == null || (frameLayout2 = c1117a.btnTopUninstall) == null) {
                return;
            }
            frameLayout2.setBackground(this.uninstallFallbackBackground);
            return;
        }
        AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
        AgentMarketItem agentMarketItem2 = this.item;
        if (agentMarketItem2 == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem2 = null;
        }
        String assetId = agentMarketItem2.getAssetId();
        AgentMarketItem agentMarketItem3 = this.item;
        if (agentMarketItem3 == null) {
            kotlin.jvm.internal.p.A("item");
        } else {
            agentMarketItem = agentMarketItem3;
        }
        y0(agentMarketOperaManager.Q(assetId, agentMarketItem.getInitialStatus()));
        C1117a c1117a2 = this._binding;
        if (c1117a2 != null && (imageView = c1117a2.ivBack) != null) {
            imageView.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.market.o0
                @Override // java.lang.Runnable
                public final void run() {
                    AgentMarketDetailFragment.d1(this.f24206a);
                }
            });
        }
        C1117a c1117a3 = this._binding;
        if (c1117a3 == null || (frameLayout = c1117a3.btnTopUninstall) == null) {
            return;
        }
        frameLayout.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.market.p0
            @Override // java.lang.Runnable
            public final void run() {
                AgentMarketDetailFragment.e1(this.f24208a);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        hVar.F(this.backGlassHandle);
        this.backGlassHandle = null;
        hVar.F(this.uninstallGlassHandle);
        this.uninstallGlassHandle = null;
        hVar.F(this.bottomAreaBlurHandle);
        this.bottomAreaBlurHandle = null;
        W0().btnTopUninstall.setBackground(this.uninstallFallbackBackground);
        r1();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        FrameLayout frameLayout;
        ImageView imageView;
        super.onResume();
        U0();
        C1117a c1117a = this._binding;
        if (c1117a != null && (imageView = c1117a.ivBack) != null) {
            imageView.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.market.M
                @Override // java.lang.Runnable
                public final void run() {
                    AgentMarketDetailFragment.f1(this.f24158a);
                }
            });
        }
        C1117a c1117a2 = this._binding;
        if (c1117a2 != null && (frameLayout = c1117a2.btnTopUninstall) != null) {
            frameLayout.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.market.Y
                @Override // java.lang.Runnable
                public final void run() {
                    AgentMarketDetailFragment.g1(this.f24176a);
                }
            });
        }
        AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
        AgentMarketItem agentMarketItem = this.item;
        if (agentMarketItem == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem = null;
        }
        agentMarketOperaManager.K(agentMarketItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        MarketAgentBrief marketAgentBrief;
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FrameLayout root = W0().root;
        kotlin.jvm.internal.p.h(root, "root");
        AgentMarketItem agentMarketItem = null;
        com.stepos.ailauncher.container.glass.k.b(root, 0, 1, null);
        Bundle arguments = getArguments();
        if (arguments == null || (marketAgentBrief = (MarketAgentBrief) arguments.getParcelable(ARG_ITEM)) == null) {
            x();
            return;
        }
        AgentMarketItem agentMarketItemB = C2299u0.b(marketAgentBrief);
        this.item = agentMarketItemB;
        if (agentMarketItemB == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItemB = null;
        }
        this.needUpdate = agentMarketItemB.getNeedUpdate();
        AgentMarketItem agentMarketItem2 = this.item;
        if (agentMarketItem2 == null) {
            kotlin.jvm.internal.p.A("item");
        } else {
            agentMarketItem = agentMarketItem2;
        }
        this.latestVersion = agentMarketItem.getVersion();
        w0();
        W0().ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AgentMarketDetailFragment.h1(this.f24199a, view2);
            }
        });
        W0().pbBottom.setColor(-12678145);
        W0().pbTopUninstall.setColor(-1);
        W0().rowVersion.tvMetaLabel.setText(getString(R$string.agent_detail_meta_version));
        W0().rowCategory.tvMetaLabel.setText(getString(R$string.agent_detail_meta_category));
        W0().rowCreated.tvMetaLabel.setText(getString(R$string.agent_detail_meta_created));
        W0().rowUpdated.tvMetaLabel.setText(getString(R$string.agent_detail_meta_updated));
        W0().rowDownload.tvMetaLabel.setText(getString(R$string.agent_detail_meta_download));
        n1();
        W0().btnTopUninstall.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AgentMarketDetailFragment.i1(this.f24201a, view2);
            }
        });
        this.uninstallFallbackBackground = W0().btnTopUninstall.getBackground();
        t1();
        c1();
        a1();
        W0().ivBack.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.market.m0
            @Override // java.lang.Runnable
            public final void run() {
                AgentMarketDetailFragment.k1(this.f24203a);
            }
        });
        W0().vTopMask.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.market.n0
            @Override // java.lang.Runnable
            public final void run() {
                AgentMarketDetailFragment.l1(this.f24205a);
            }
        });
    }

    public final void r1() {
        View viewFindViewById;
        int[] iArr;
        View viewFindViewById2;
        View viewFindViewById3;
        Integer num;
        androidx.fragment.app.r activity = getActivity();
        if (activity != null && (viewFindViewById3 = activity.findViewById(com.stepos.ailauncher.sheet.R$id.ail_sheet_panel)) != null && (num = this.savedPanelPaddingTop) != null) {
            viewFindViewById3.setPadding(viewFindViewById3.getPaddingLeft(), num.intValue(), viewFindViewById3.getPaddingRight(), viewFindViewById3.getPaddingBottom());
        }
        androidx.fragment.app.r activity2 = getActivity();
        if (activity2 != null && (viewFindViewById2 = activity2.findViewById(com.stepos.ailauncher.sheet.R$id.ail_settle_hint)) != null) {
            viewFindViewById2.setVisibility(8);
        }
        androidx.fragment.app.r activity3 = getActivity();
        if (activity3 != null && (viewFindViewById = activity3.findViewById(com.stepos.ailauncher.sheet.R$id.ail_content_container)) != null && (iArr = this.savedContentPadding) != null) {
            viewFindViewById.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
        }
        this.savedPanelPaddingTop = null;
        this.savedContentPadding = null;
    }

    public final void w0() {
        W0().root.setFitsSystemWindows(false);
        W0().root.setBackgroundColor(-15658735);
        W0().llDescriptionToggle.setVisibility(8);
        W0().vTopMask.setVisibility(0);
        W0().vBottomMask.setVisibility(8);
        View childAt = W0().scrollView.getChildAt(0);
        ViewGroup viewGroup = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
        if (viewGroup != null) {
            viewGroup.setPadding(L0(16), viewGroup.getPaddingTop(), L0(16), L0(156));
        }
        W0().footerContainer.setPadding(L0(16), L0(8), L0(16), 0);
        ViewGroup.LayoutParams layoutParams = W0().footerContainer.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.bottomMargin = L0(46);
            W0().footerContainer.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = W0().barInstallSuccess.getLayoutParams();
        FrameLayout.LayoutParams layoutParams4 = layoutParams3 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams3 : null;
        if (layoutParams4 != null) {
            layoutParams4.leftMargin = L0(16);
            layoutParams4.rightMargin = L0(16);
            layoutParams4.bottomMargin = L0(110);
            W0().barInstallSuccess.setLayoutParams(layoutParams4);
        }
        ViewGroup.LayoutParams layoutParams5 = W0().flDebugLogContainer.getLayoutParams();
        FrameLayout.LayoutParams layoutParams6 = layoutParams5 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams5 : null;
        if (layoutParams6 != null) {
            layoutParams6.leftMargin = L0(16);
            layoutParams6.rightMargin = L0(16);
            layoutParams6.bottomMargin = L0(118);
            layoutParams6.height = L0(300);
            W0().flDebugLogContainer.setLayoutParams(layoutParams6);
        }
        ViewGroup.LayoutParams layoutParams7 = W0().btnDebugLogToggle.getLayoutParams();
        FrameLayout.LayoutParams layoutParams8 = layoutParams7 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams7 : null;
        if (layoutParams8 != null) {
            layoutParams8.leftMargin = L0(16);
            layoutParams8.bottomMargin = L0(98);
            W0().btnDebugLogToggle.setLayoutParams(layoutParams8);
        }
    }
}
