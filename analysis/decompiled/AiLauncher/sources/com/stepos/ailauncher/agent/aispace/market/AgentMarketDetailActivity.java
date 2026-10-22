package com.stepos.ailauncher.agent.aispace.market;

import Ua.C1060i;
import Y4.C1117a;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.view.C1398p;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.a0;
import com.autonavi.aps.amapapi.config.Const;
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
import com.stepos.ailauncher.chat.wake.ChatEntrySource;
import com.stepos.ailauncher.chat.wake.InstalledAgentRef;
import com.stepos.ailauncher.chat.wake.WakeService;
import com.stepos.ailauncher.container.api.IOverlayPageHost;
import com.stepos.ailauncher.task.space.C3577a2;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;
import y7.G;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 `2\u00020\u0001:\u0002abB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u0012J-\u0010$\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0!H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\tH\u0002¢\u0006\u0004\b*\u0010\u0003J\u000f\u0010+\u001a\u00020\tH\u0002¢\u0006\u0004\b+\u0010\u0003J\u000f\u0010,\u001a\u00020\tH\u0002¢\u0006\u0004\b,\u0010\u0003J\u0019\u0010/\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010-H\u0002¢\u0006\u0004\b/\u00100J\u001d\u00104\u001a\u00020\t2\f\u00103\u001a\b\u0012\u0004\u0012\u00020201H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\t2\u0006\u00106\u001a\u000202H\u0002¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u00020&2\u0006\u00109\u001a\u00020&H\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\t2\u0006\u0010\f\u001a\u00020-H\u0002¢\u0006\u0004\b<\u0010=J\u0019\u0010@\u001a\u00020\t2\b\u0010?\u001a\u0004\u0018\u00010>H\u0014¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\tH\u0014¢\u0006\u0004\bD\u0010\u0003J\u000f\u0010E\u001a\u00020\tH\u0014¢\u0006\u0004\bE\u0010\u0003R\u0016\u0010G\u001a\u00020F8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010J\u001a\u00020I8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010L\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010N\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010P\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010MR\u0016\u0010Q\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010MR\u001b\u0010W\u001a\u00020R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u0018\u0010Y\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010ZR\u0016\u0010\\\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010OR\u0014\u0010^\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_¨\u0006c"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketDetailActivity;", "Lz5/a;", "<init>", "()V", "Landroid/content/Intent;", "intent", "", "w0", "(Landroid/content/Intent;)Z", "LY8/t;", "Q0", "", "text", "j0", "(Ljava/lang/CharSequence;)V", "f1", "expanded", "n0", "(Z)V", "o0", "H0", "b1", "P0", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;", "status", "p0", "(Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;)V", "T0", "show", "U0", "checked", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketDetailActivity$SwitchMode;", "mode", "Lkotlin/Function0;", "onToggle", "Landroid/view/View;", "z0", "(ZLcom/stepos/ailauncher/agent/aispace/market/AgentMarketDetailActivity$SwitchMode;Lp9/a;)Landroid/view/View;", "", "pct", "V0", "(I)V", "x0", "W0", "F0", "", "raw", "C0", "(Ljava/lang/String;)Ljava/lang/String;", "", "Lcom/stepos/ailauncher/agent/aispace/market/data/f;", "skills", "R0", "(Ljava/util/List;)V", C3577a2.TYPE_SKILL, "d1", "(Lcom/stepos/ailauncher/agent/aispace/market/data/f;)V", "v", "B0", "(I)I", "e1", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onNewIntent", "(Landroid/content/Intent;)V", "onDestroy", "onResume", "LY4/a;", "binding", "LY4/a;", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", "item", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", "developer", "Ljava/lang/String;", "needUpdate", "Z", "latestVersion", "latestReversionId", "Lu8/e;", "markwon$delegate", "LY8/h;", "D0", "()Lu8/e;", "markwon", "Ly7/E;", "backGlassHandle", "Ly7/E;", "uninstallGlassHandle", "descriptionExpanded", "Ljava/lang/Runnable;", "hideSuccessBar", "Ljava/lang/Runnable;", "Companion", "SwitchMode", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentMarketDetailActivity extends ActivityC6361a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DESC_MAX_LINES_COLLAPSED = 2;
    private static final String EXTRA_ITEM = "extra_agent_market_item";
    private y7.E backGlassHandle;
    private C1117a binding;
    private boolean descriptionExpanded;
    private AgentMarketItem item;
    private boolean needUpdate;
    private y7.E uninstallGlassHandle;
    private String developer = "";
    private String latestVersion = "";
    private String latestReversionId = "";

    /* renamed from: markwon$delegate, reason: from kotlin metadata */
    private final Y8.h markwon = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.market.F
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return AgentMarketDetailActivity.G0(this.f24142a);
        }
    });
    private final Runnable hideSuccessBar = new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.market.G
        @Override // java.lang.Runnable
        public final void run() {
            AgentMarketDetailActivity.E0(this.f24144a);
        }
    };

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketDetailActivity$SwitchMode;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "GREYED", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketDetailActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", "item", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;)V", "", "EXTRA_ITEM", "Ljava/lang/String;", "", "DESC_MAX_LINES_COLLAPSED", "I", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a(Context context, AgentMarketItem item) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(item, "item");
            Intent intent = new Intent(context, (Class<?>) AgentMarketDetailActivity.class);
            intent.putExtra(AgentMarketDetailActivity.EXTRA_ITEM, item);
            if (context instanceof Activity) {
                intent.addFlags(603979776);
            }
            b5.i.INSTANCE.a(context, intent);
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgentMarketStatus.values().length];
            try {
                iArr[AgentMarketStatus.NOT_INSTALLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AgentMarketStatus.INSTALLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AgentMarketStatus.QUEUED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AgentMarketStatus.UPDATING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AgentMarketStatus.UNINSTALLING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AgentMarketStatus.INSTALLED_DISABLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AgentMarketStatus.INSTALL_FAILED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AgentMarketStatus.INSTALLED_ENABLED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void A0(InterfaceC5063a interfaceC5063a, View view) {
        interfaceC5063a.invoke();
    }

    public static final void E0(AgentMarketDetailActivity agentMarketDetailActivity) {
        C1117a c1117a = agentMarketDetailActivity.binding;
        if (c1117a == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a = null;
        }
        c1117a.barInstallSuccess.setVisibility(8);
    }

    public static final u8.e G0(AgentMarketDetailActivity agentMarketDetailActivity) {
        return SkillMarkwonFactoryKt.b(agentMarketDetailActivity);
    }

    public static final androidx.core.view.a0 I0(View v10, androidx.core.view.a0 insets) {
        kotlin.jvm.internal.p.i(v10, "v");
        kotlin.jvm.internal.p.i(insets, "insets");
        t0.e eVarF = insets.f(a0.o.g());
        kotlin.jvm.internal.p.h(eVarF, "getInsets(...)");
        v10.setPadding(eVarF.f41977a, eVarF.f41978b, eVarF.f41979c, eVarF.f41980d);
        return insets;
    }

    public static final void J0(AgentMarketDetailActivity agentMarketDetailActivity, View view) {
        agentMarketDetailActivity.finish();
    }

    public static final void K0(final AgentMarketDetailActivity agentMarketDetailActivity, View view) {
        C1117a c1117a = agentMarketDetailActivity.binding;
        if (c1117a == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a = null;
        }
        FrameLayout btnTopUninstall = c1117a.btnTopUninstall;
        kotlin.jvm.internal.p.h(btnTopUninstall, "btnTopUninstall");
        T9.c(btnTopUninstall, 8.0f, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.market.q
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentMarketDetailActivity.L0(this.f24209a);
            }
        });
    }

    public static final Y8.t L0(AgentMarketDetailActivity agentMarketDetailActivity) {
        agentMarketDetailActivity.x0();
        return Y8.t.f7040a;
    }

    public static final void M0(AgentMarketDetailActivity agentMarketDetailActivity) {
        C1117a c1117a = agentMarketDetailActivity.binding;
        C1117a c1117a2 = null;
        if (c1117a == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a = null;
        }
        if (c1117a.ivBack.isAttachedToWindow()) {
            com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
            C1117a c1117a3 = agentMarketDetailActivity.binding;
            if (c1117a3 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1117a2 = c1117a3;
            }
            ImageView ivBack = c1117a2.ivBack;
            kotlin.jvm.internal.p.h(ivBack, "ivBack");
            agentMarketDetailActivity.backGlassHandle = com.stepos.ailauncher.container.glass.h.m(hVar, ivBack, false, Float.valueOf(22.0f), y7.o.INSTANCE.i(), false, 16, null);
        }
    }

    public static final void N0(AgentMarketDetailActivity agentMarketDetailActivity) {
        C1117a c1117a = agentMarketDetailActivity.binding;
        C1117a c1117a2 = null;
        if (c1117a == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a = null;
        }
        if (c1117a.vTopMask.isAttachedToWindow()) {
            com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
            C1117a c1117a3 = agentMarketDetailActivity.binding;
            if (c1117a3 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1117a2 = c1117a3;
            }
            View vTopMask = c1117a2.vTopMask;
            kotlin.jvm.internal.p.h(vTopMask, "vTopMask");
            com.stepos.ailauncher.container.glass.h.v(hVar, vTopMask, false, G.a.f43886a.g(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.market.l
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentMarketDetailActivity.O0((A7.B) obj);
                }
            }, 2, null);
        }
    }

    public static final Y8.t O0(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    public static final void S0(AgentMarketDetailActivity agentMarketDetailActivity, AgentSkillDto agentSkillDto, View view) {
        agentMarketDetailActivity.d1(agentSkillDto);
    }

    public static final void X0(AgentMarketDetailActivity agentMarketDetailActivity, View view) {
        C1117a c1117a = agentMarketDetailActivity.binding;
        C1117a c1117a2 = null;
        if (c1117a == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a = null;
        }
        FrameLayout frameLayout = c1117a.flDebugLogContainer;
        C1117a c1117a3 = agentMarketDetailActivity.binding;
        if (c1117a3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1117a2 = c1117a3;
        }
        frameLayout.setVisibility(c1117a2.flDebugLogContainer.getVisibility() == 0 ? 8 : 0);
    }

    public static final void Y0(AgentMarketDetailActivity agentMarketDetailActivity, View view) {
        C1117a c1117a = agentMarketDetailActivity.binding;
        if (c1117a == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a = null;
        }
        c1117a.flDebugLogContainer.setVisibility(8);
    }

    public static final void Z0(View view) {
        C2277j.INSTANCE.c();
    }

    public static final boolean a1(AgentMarketDetailActivity agentMarketDetailActivity, View view) {
        C1117a c1117a = agentMarketDetailActivity.binding;
        if (c1117a == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a = null;
        }
        CharSequence text = c1117a.tvDebugLog.getText();
        String string = text != null ? text.toString() : null;
        if (string == null) {
            string = "";
        }
        if (La.H.x0(string)) {
            return false;
        }
        Object systemService = agentMarketDetailActivity.getSystemService("clipboard");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("agent_market_debug_log", string));
        agentMarketDetailActivity.e1("日志已复制");
        return true;
    }

    public static final void c1(AgentMarketDetailActivity agentMarketDetailActivity, View view) {
        C1117a c1117a = agentMarketDetailActivity.binding;
        C1117a c1117a2 = null;
        if (c1117a == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a = null;
        }
        c1117a.barInstallSuccess.removeCallbacks(agentMarketDetailActivity.hideSuccessBar);
        C1117a c1117a3 = agentMarketDetailActivity.binding;
        if (c1117a3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1117a2 = c1117a3;
        }
        c1117a2.barInstallSuccess.setVisibility(8);
        agentMarketDetailActivity.P0();
    }

    public static final void k0(AgentMarketDetailActivity agentMarketDetailActivity, View view) {
        agentMarketDetailActivity.f1();
    }

    public static final void l0(AgentMarketDetailActivity agentMarketDetailActivity, View view) {
        agentMarketDetailActivity.f1();
    }

    public static final void m0(AgentMarketDetailActivity agentMarketDetailActivity) {
        C1117a c1117a = agentMarketDetailActivity.binding;
        C1117a c1117a2 = null;
        if (c1117a == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a = null;
        }
        Layout layout = c1117a.tvDescription.getLayout();
        if (layout == null) {
            return;
        }
        if (layout.getLineCount() > 2 || (layout.getLineCount() == 2 && layout.getEllipsisCount(1) > 0)) {
            C1117a c1117a3 = agentMarketDetailActivity.binding;
            if (c1117a3 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1117a2 = c1117a3;
            }
            c1117a2.llDescriptionToggle.setVisibility(0);
            agentMarketDetailActivity.n0(false);
            return;
        }
        C1117a c1117a4 = agentMarketDetailActivity.binding;
        if (c1117a4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a4 = null;
        }
        c1117a4.tvDescription.setMaxLines(Integer.MAX_VALUE);
        C1117a c1117a5 = agentMarketDetailActivity.binding;
        if (c1117a5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a5 = null;
        }
        c1117a5.tvDescription.setEllipsize(null);
        C1117a c1117a6 = agentMarketDetailActivity.binding;
        if (c1117a6 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1117a2 = c1117a6;
        }
        c1117a2.llDescriptionToggle.setVisibility(8);
    }

    public static final void q0(AgentMarketDetailActivity agentMarketDetailActivity, View view) {
        AgentMarketItem agentMarketItem;
        W4.a aVar = W4.a.INSTANCE;
        AgentMarketItem agentMarketItem2 = agentMarketDetailActivity.item;
        AgentMarketItem agentMarketItem3 = null;
        if (agentMarketItem2 == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem2 = null;
        }
        aVar.j(agentMarketItem2.getAssetId());
        AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
        AgentMarketItem agentMarketItem4 = agentMarketDetailActivity.item;
        if (agentMarketItem4 == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem = null;
        } else {
            agentMarketItem = agentMarketItem4;
        }
        String reversionId = agentMarketDetailActivity.latestReversionId;
        if (La.H.x0(reversionId)) {
            AgentMarketItem agentMarketItem5 = agentMarketDetailActivity.item;
            if (agentMarketItem5 == null) {
                kotlin.jvm.internal.p.A("item");
                agentMarketItem5 = null;
            }
            reversionId = agentMarketItem5.getReversionId();
        }
        String str = reversionId;
        String version = agentMarketDetailActivity.latestVersion;
        if (La.H.x0(version)) {
            AgentMarketItem agentMarketItem6 = agentMarketDetailActivity.item;
            if (agentMarketItem6 == null) {
                kotlin.jvm.internal.p.A("item");
            } else {
                agentMarketItem3 = agentMarketItem6;
            }
            version = agentMarketItem3.getVersion();
        }
        agentMarketOperaManager.V(agentMarketItem.copy((8185 & 1) != 0 ? agentMarketItem.assetId : null, (8185 & 2) != 0 ? agentMarketItem.reversionId : str, (8185 & 4) != 0 ? agentMarketItem.version : version, (8185 & 8) != 0 ? agentMarketItem.displayName : null, (8185 & 16) != 0 ? agentMarketItem.description : null, (8185 & 32) != 0 ? agentMarketItem.developer : null, (8185 & 64) != 0 ? agentMarketItem.downloadCount : 0L, (8185 & 128) != 0 ? agentMarketItem.installVersion : null, (8185 & 256) != 0 ? agentMarketItem.needUpdate : false, (8185 & 512) != 0 ? agentMarketItem.initialStatus : null, (8185 & 1024) != 0 ? agentMarketItem.iconUrl : null, (8185 & 2048) != 0 ? agentMarketItem.testing : false, (8185 & 4096) != 0 ? agentMarketItem.env : null));
    }

    public static final void r0(AgentMarketDetailActivity agentMarketDetailActivity, View view) {
        AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
        AgentMarketItem agentMarketItem = agentMarketDetailActivity.item;
        if (agentMarketItem == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem = null;
        }
        agentMarketOperaManager.N(agentMarketItem, true);
    }

    public static final void s0(AgentMarketDetailActivity agentMarketDetailActivity, View view) {
        W4.a aVar = W4.a.INSTANCE;
        AgentMarketItem agentMarketItem = agentMarketDetailActivity.item;
        AgentMarketItem agentMarketItem2 = null;
        if (agentMarketItem == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem = null;
        }
        aVar.d(agentMarketItem.getAssetId());
        AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
        AgentMarketItem agentMarketItem3 = agentMarketDetailActivity.item;
        if (agentMarketItem3 == null) {
            kotlin.jvm.internal.p.A("item");
        } else {
            agentMarketItem2 = agentMarketItem3;
        }
        agentMarketOperaManager.y(agentMarketItem2);
    }

    public static final Y8.t t0() {
        return Y8.t.f7040a;
    }

    public static final Y8.t u0(AgentMarketDetailActivity agentMarketDetailActivity) {
        AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
        AgentMarketItem agentMarketItem = agentMarketDetailActivity.item;
        if (agentMarketItem == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem = null;
        }
        agentMarketOperaManager.N(agentMarketItem, false);
        return Y8.t.f7040a;
    }

    public static final Y8.t v0(AgentMarketDetailActivity agentMarketDetailActivity) {
        AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
        AgentMarketItem agentMarketItem = agentMarketDetailActivity.item;
        if (agentMarketItem == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem = null;
        }
        agentMarketOperaManager.N(agentMarketItem, true);
        return Y8.t.f7040a;
    }

    public static final Y8.t y0(AgentMarketDetailActivity agentMarketDetailActivity) {
        AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
        AgentMarketItem agentMarketItem = agentMarketDetailActivity.item;
        if (agentMarketItem == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem = null;
        }
        agentMarketOperaManager.U(agentMarketItem);
        return Y8.t.f7040a;
    }

    public final int B0(int v10) {
        return (int) (v10 * getResources().getDisplayMetrics().density);
    }

    public final String C0(String raw) {
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

    public final u8.e D0() {
        return (u8.e) this.markwon.getValue();
    }

    public final void F0() {
        C1060i.d(C1398p.a(this), null, null, new AgentMarketDetailActivity$loadDetail$1(this, null), 3, null);
    }

    public final void H0() {
        C1060i.d(C1398p.a(this), null, null, new AgentMarketDetailActivity$observeStatus$1(this, null), 3, null);
        C1060i.d(C1398p.a(this), null, null, new AgentMarketDetailActivity$observeStatus$2(this, null), 3, null);
        C1060i.d(C1398p.a(this), null, null, new AgentMarketDetailActivity$observeStatus$3(this, null), 3, null);
    }

    public final void P0() {
        WakeService.Companion companion = WakeService.INSTANCE;
        AgentMarketItem agentMarketItem = this.item;
        AgentMarketItem agentMarketItem2 = null;
        if (agentMarketItem == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem = null;
        }
        String assetId = agentMarketItem.getAssetId();
        AgentMarketItem agentMarketItem3 = this.item;
        if (agentMarketItem3 == null) {
            kotlin.jvm.internal.p.A("item");
        } else {
            agentMarketItem2 = agentMarketItem3;
        }
        companion.r1(new InstalledAgentRef(assetId, agentMarketItem2.getDisplayName(), true, ChatEntrySource.AGENT_MARKET));
        IOverlayPageHost iOverlayPageHost = (IOverlayPageHost) D5.a.INSTANCE.a(IOverlayPageHost.class);
        if (iOverlayPageHost != null) {
            iOverlayPageHost.navigateToPage("home_space");
        }
        finish();
    }

    public final void Q0() {
        C1117a c1117a = this.binding;
        AgentMarketItem agentMarketItem = null;
        if (c1117a == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a = null;
        }
        TextView textView = c1117a.tvSkillIconChar;
        AgentMarketItem agentMarketItem2 = this.item;
        if (agentMarketItem2 == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem2 = null;
        }
        textView.setText(agentMarketItem2.getIconChar());
        C1117a c1117a2 = this.binding;
        if (c1117a2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a2 = null;
        }
        ImageView ivSkillIcon = c1117a2.ivSkillIcon;
        kotlin.jvm.internal.p.h(ivSkillIcon, "ivSkillIcon");
        C1117a c1117a3 = this.binding;
        if (c1117a3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a3 = null;
        }
        TextView tvSkillIconChar = c1117a3.tvSkillIconChar;
        kotlin.jvm.internal.p.h(tvSkillIconChar, "tvSkillIconChar");
        AgentMarketItem agentMarketItem3 = this.item;
        if (agentMarketItem3 == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem3 = null;
        }
        C2765a9.a(ivSkillIcon, tvSkillIconChar, agentMarketItem3.getIconUrl());
        C1117a c1117a4 = this.binding;
        if (c1117a4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a4 = null;
        }
        TextView textView2 = c1117a4.tvTitle;
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
            agentMarketItem = agentMarketItem5;
        }
        j0(agentMarketItem.getDescription());
        o0();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R0(java.util.List<com.stepos.ailauncher.agent.aispace.market.data.AgentSkillDto> r12) {
        /*
            r11 = this;
            Y4.a r0 = r11.binding
            java.lang.String r1 = "binding"
            r2 = 0
            if (r0 != 0) goto Lb
            kotlin.jvm.internal.p.A(r1)
            r0 = r2
        Lb:
            android.widget.LinearLayout r0 = r0.containerSkills
            java.lang.String r3 = "containerSkills"
            kotlin.jvm.internal.p.h(r0, r3)
            r0.removeAllViews()
            boolean r3 = r12.isEmpty()
            r4 = 8
            r5 = 0
            if (r3 == 0) goto L20
            r6 = r4
            goto L21
        L20:
            r6 = r5
        L21:
            r0.setVisibility(r6)
            Y4.a r6 = r11.binding
            if (r6 != 0) goto L2c
            kotlin.jvm.internal.p.A(r1)
            r6 = r2
        L2c:
            android.widget.TextView r1 = r6.tvSkillSectionTitle
            if (r3 == 0) goto L31
            goto L32
        L31:
            r4 = r5
        L32:
            r1.setVisibility(r4)
            r1 = r12
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
            r3 = r5
        L3d:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto Lce
            java.lang.Object r4 = r1.next()
            int r6 = r3 + 1
            if (r3 >= 0) goto L4e
            Z8.C1173v.w()
        L4e:
            com.stepos.ailauncher.agent.aispace.market.data.f r4 = (com.stepos.ailauncher.agent.aispace.market.data.AgentSkillDto) r4
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r11)
            Y4.w r7 = Y4.w.c(r7, r0, r5)
            java.lang.String r8 = "inflate(...)"
            kotlin.jvm.internal.p.h(r7, r8)
            android.widget.TextView r8 = r7.tvSkillName
            java.lang.String r9 = r4.getSkillName()
            if (r9 == 0) goto L70
            boolean r10 = La.H.x0(r9)
            if (r10 != 0) goto L6c
            goto L6d
        L6c:
            r9 = r2
        L6d:
            if (r9 == 0) goto L70
            goto L74
        L70:
            java.lang.String r9 = r4.getSkillId()
        L74:
            r8.setText(r9)
            android.widget.TextView r8 = r7.tvSkillDesc
            java.lang.String r9 = r4.getSkillDescription()
            if (r9 != 0) goto L81
            java.lang.String r9 = ""
        L81:
            r8.setText(r9)
            android.widget.LinearLayout r8 = r7.b()
            com.stepos.ailauncher.agent.aispace.market.r r9 = new com.stepos.ailauncher.agent.aispace.market.r
            r9.<init>()
            r8.setOnClickListener(r9)
            android.widget.LinearLayout r4 = r7.b()
            r0.addView(r4)
            int r4 = Z8.C1173v.o(r12)
            if (r3 == r4) goto Lcb
            android.view.View r3 = new android.view.View
            r3.<init>(r11)
            android.widget.LinearLayout$LayoutParams r4 = new android.widget.LinearLayout$LayoutParams
            r7 = -1
            r8 = 1
            int r8 = r11.B0(r8)
            r4.<init>(r7, r8)
            r7 = 56
            int r7 = r11.B0(r7)
            r4.setMarginStart(r7)
            r7 = 16
            int r7 = r11.B0(r7)
            r4.setMarginEnd(r7)
            r3.setLayoutParams(r4)
            r4 = 452984831(0x1affffff, float:1.0587911E-22)
            r3.setBackgroundColor(r4)
            r0.addView(r3)
        Lcb:
            r3 = r6
            goto L3d
        Lce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailActivity.R0(java.util.List):void");
    }

    public final void T0(AgentMarketStatus status) {
        String string;
        C1117a c1117a = null;
        switch (b.$EnumSwitchMapping$0[status.ordinal()]) {
            case 1:
                string = getString(R$string.agent_detail_badge_not_installed);
                break;
            case 2:
                string = getString(R$string.agent_detail_badge_installing);
                break;
            case 3:
                string = getString(R$string.agent_detail_badge_queued);
                break;
            case 4:
                string = getString(R$string.agent_detail_badge_updating);
                break;
            case 5:
                string = getString(R$string.agent_detail_badge_uninstalling);
                break;
            case 6:
                string = getString(R$string.agent_detail_badge_disabled);
                break;
            case 7:
                string = getString(R$string.agent_detail_badge_install_failed);
                break;
            case 8:
                string = null;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        C1117a c1117a2 = this.binding;
        if (c1117a2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a2 = null;
        }
        c1117a2.tvStatusBadge.setText(string == null ? "" : string);
        C1117a c1117a3 = this.binding;
        if (c1117a3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1117a = c1117a3;
        }
        c1117a.tvStatusBadge.setVisibility(string == null ? 8 : 0);
    }

    public final void U0(boolean show) {
        C1117a c1117a = this.binding;
        AgentMarketItem agentMarketItem = null;
        if (c1117a == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a = null;
        }
        c1117a.llUpdateBanner.setVisibility(show ? 0 : 8);
        if (show) {
            C1117a c1117a2 = this.binding;
            if (c1117a2 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1117a2 = null;
            }
            TextView textView = c1117a2.tvUpdateBannerTitle;
            int i10 = R$string.agent_detail_update_banner_title;
            String version = this.latestVersion;
            if (La.H.x0(version)) {
                AgentMarketItem agentMarketItem2 = this.item;
                if (agentMarketItem2 == null) {
                    kotlin.jvm.internal.p.A("item");
                } else {
                    agentMarketItem = agentMarketItem2;
                }
                version = agentMarketItem.getVersion();
                if (La.H.x0(version)) {
                    version = "1.0.0";
                }
            }
            textView.setText(getString(i10, version));
        }
    }

    public final void V0(int pct) {
        Drawable drawableFindDrawableByLayerId;
        C1117a c1117a = this.binding;
        if (c1117a == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a = null;
        }
        Drawable background = c1117a.btnBottom.getBackground();
        LayerDrawable layerDrawable = background instanceof LayerDrawable ? (LayerDrawable) background : null;
        if (layerDrawable == null || (drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R$id.agent_install_progress_fill)) == null) {
            return;
        }
        drawableFindDrawableByLayerId.setLevel(C5685n.n(pct * 100, 0, 10000));
    }

    public final void W0() {
        C1117a c1117a = this.binding;
        if (c1117a == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a = null;
        }
        c1117a.btnDebugLogToggle.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentMarketDetailActivity.X0(this.f24202a, view);
            }
        });
        C1117a c1117a2 = this.binding;
        if (c1117a2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a2 = null;
        }
        c1117a2.btnDebugLogClose.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentMarketDetailActivity.Y0(this.f24204a, view);
            }
        });
        C1117a c1117a3 = this.binding;
        if (c1117a3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a3 = null;
        }
        c1117a3.btnDebugLogClear.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentMarketDetailActivity.Z0(view);
            }
        });
        C1117a c1117a4 = this.binding;
        if (c1117a4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a4 = null;
        }
        c1117a4.tvDebugLog.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.p
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return AgentMarketDetailActivity.a1(this.f24207a, view);
            }
        });
        C1060i.d(C1398p.a(this), null, null, new AgentMarketDetailActivity$setupDebugLog$5(this, null), 3, null);
    }

    public final void b1() {
        C1117a c1117a = this.binding;
        C1117a c1117a2 = null;
        if (c1117a == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a = null;
        }
        c1117a.barInstallSuccess.setVisibility(0);
        C1117a c1117a3 = this.binding;
        if (c1117a3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a3 = null;
        }
        c1117a3.barInstallSuccess.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.B
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentMarketDetailActivity.c1(this.f24135a, view);
            }
        });
        C1117a c1117a4 = this.binding;
        if (c1117a4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a4 = null;
        }
        c1117a4.barInstallSuccess.removeCallbacks(this.hideSuccessBar);
        C1117a c1117a5 = this.binding;
        if (c1117a5 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1117a2 = c1117a5;
        }
        c1117a2.barInstallSuccess.postDelayed(this.hideSuccessBar, 5000L);
    }

    public final void d1(AgentSkillDto skill) {
        C1060i.d(C1398p.a(this), null, null, new AgentMarketDetailActivity$showSkillMd$1(skill, this, null), 3, null);
    }

    public final void e1(String text) {
        ToastUtils.o().q(-231591374).r(-1).v(text, new Object[0]);
    }

    public final void f1() {
        boolean z10 = !this.descriptionExpanded;
        this.descriptionExpanded = z10;
        n0(z10);
    }

    public final void j0(CharSequence text) {
        this.descriptionExpanded = false;
        C1117a c1117a = this.binding;
        C1117a c1117a2 = null;
        if (c1117a == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a = null;
        }
        c1117a.tvDescription.setText(text);
        C1117a c1117a3 = this.binding;
        if (c1117a3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a3 = null;
        }
        c1117a3.tvDescription.setMaxLines(2);
        C1117a c1117a4 = this.binding;
        if (c1117a4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a4 = null;
        }
        c1117a4.tvDescription.setEllipsize(TextUtils.TruncateAt.END);
        C1117a c1117a5 = this.binding;
        if (c1117a5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a5 = null;
        }
        c1117a5.llDescriptionToggle.setVisibility(8);
        C1117a c1117a6 = this.binding;
        if (c1117a6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a6 = null;
        }
        c1117a6.llDescriptionToggle.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.H
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentMarketDetailActivity.k0(this.f24146a, view);
            }
        });
        C1117a c1117a7 = this.binding;
        if (c1117a7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a7 = null;
        }
        c1117a7.tvDescriptionToggle.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentMarketDetailActivity.l0(this.f24148a, view);
            }
        });
        C1117a c1117a8 = this.binding;
        if (c1117a8 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1117a2 = c1117a8;
        }
        c1117a2.tvDescription.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.market.J
            @Override // java.lang.Runnable
            public final void run() {
                AgentMarketDetailActivity.m0(this.f24150a);
            }
        });
    }

    public final void n0(boolean expanded) {
        C1117a c1117a = null;
        if (expanded) {
            C1117a c1117a2 = this.binding;
            if (c1117a2 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1117a2 = null;
            }
            c1117a2.tvDescription.setMaxLines(Integer.MAX_VALUE);
            C1117a c1117a3 = this.binding;
            if (c1117a3 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1117a3 = null;
            }
            c1117a3.tvDescription.setEllipsize(null);
            C1117a c1117a4 = this.binding;
            if (c1117a4 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1117a4 = null;
            }
            c1117a4.vDescriptionFade.setVisibility(8);
            C1117a c1117a5 = this.binding;
            if (c1117a5 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1117a = c1117a5;
            }
            c1117a.tvDescriptionToggle.setText(R$string.skill_detail_desc_collapse);
            return;
        }
        C1117a c1117a6 = this.binding;
        if (c1117a6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a6 = null;
        }
        c1117a6.tvDescription.setMaxLines(2);
        C1117a c1117a7 = this.binding;
        if (c1117a7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a7 = null;
        }
        c1117a7.tvDescription.setEllipsize(TextUtils.TruncateAt.END);
        C1117a c1117a8 = this.binding;
        if (c1117a8 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a8 = null;
        }
        c1117a8.vDescriptionFade.setVisibility(0);
        C1117a c1117a9 = this.binding;
        if (c1117a9 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1117a = c1117a9;
        }
        c1117a.tvDescriptionToggle.setText(R$string.agent_detail_more);
    }

    public final void o0() {
        ArrayList arrayList = new ArrayList();
        AgentMarketItem agentMarketItem = this.item;
        C1117a c1117a = null;
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
            AgentMarketItem agentMarketItem2 = this.item;
            if (agentMarketItem2 == null) {
                kotlin.jvm.internal.p.A("item");
                agentMarketItem2 = null;
            }
            developer = agentMarketItem2.getDeveloper();
        }
        if (!La.H.x0(developer)) {
            arrayList.add(developer);
        }
        String string = getString(R$string.agent_detail_audited);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        arrayList.add(string);
        C1117a c1117a2 = this.binding;
        if (c1117a2 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1117a = c1117a2;
        }
        c1117a.tvMeta.setText(Z8.F.A0(arrayList, " · ", null, null, 0, null, null, 62, null));
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C1117a c1117aB = C1117a.b(getLayoutInflater());
        kotlin.jvm.internal.p.h(c1117aB, "inflate(...)");
        this.binding = c1117aB;
        C1117a c1117a = null;
        if (c1117aB == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117aB = null;
        }
        setContentView(c1117aB.root);
        C1117a c1117a2 = this.binding;
        if (c1117a2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a2 = null;
        }
        FrameLayout root = c1117a2.root;
        kotlin.jvm.internal.p.h(root, "root");
        com.stepos.ailauncher.container.glass.k.b(root, 0, 1, null);
        androidx.core.view.Y.b(getWindow(), false);
        androidx.core.view.Y.a(getWindow(), getWindow().getDecorView()).e(false);
        C1117a c1117a3 = this.binding;
        if (c1117a3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a3 = null;
        }
        androidx.core.view.N.u0(c1117a3.root, new androidx.core.view.A() { // from class: com.stepos.ailauncher.agent.aispace.market.k
            @Override // androidx.core.view.A
            public final androidx.core.view.a0 a(View view, androidx.core.view.a0 a0Var) {
                return AgentMarketDetailActivity.I0(view, a0Var);
            }
        });
        Intent intent = getIntent();
        kotlin.jvm.internal.p.h(intent, "getIntent(...)");
        if (!w0(intent)) {
            finish();
            return;
        }
        W4.a aVar = W4.a.INSTANCE;
        AgentMarketItem agentMarketItem = this.item;
        if (agentMarketItem == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem = null;
        }
        String assetId = agentMarketItem.getAssetId();
        AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
        AgentMarketItem agentMarketItem2 = this.item;
        if (agentMarketItem2 == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem2 = null;
        }
        String assetId2 = agentMarketItem2.getAssetId();
        AgentMarketItem agentMarketItem3 = this.item;
        if (agentMarketItem3 == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem3 = null;
        }
        String lowerCase = agentMarketOperaManager.Q(assetId2, agentMarketItem3.getInitialStatus()).name().toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        AgentMarketItem agentMarketItem4 = this.item;
        if (agentMarketItem4 == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem4 = null;
        }
        aVar.a(assetId, lowerCase, agentMarketItem4.getVersion());
        C1117a c1117a4 = this.binding;
        if (c1117a4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a4 = null;
        }
        c1117a4.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentMarketDetailActivity.J0(this.f24221a, view);
            }
        });
        C1117a c1117a5 = this.binding;
        if (c1117a5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a5 = null;
        }
        c1117a5.pbBottom.setColor(-12678145);
        C1117a c1117a6 = this.binding;
        if (c1117a6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a6 = null;
        }
        c1117a6.pbTopUninstall.setColor(-1);
        C1117a c1117a7 = this.binding;
        if (c1117a7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a7 = null;
        }
        c1117a7.rowVersion.tvMetaLabel.setText(getString(R$string.agent_detail_meta_version));
        C1117a c1117a8 = this.binding;
        if (c1117a8 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a8 = null;
        }
        c1117a8.rowCategory.tvMetaLabel.setText(getString(R$string.agent_detail_meta_category));
        C1117a c1117a9 = this.binding;
        if (c1117a9 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a9 = null;
        }
        c1117a9.rowCreated.tvMetaLabel.setText(getString(R$string.agent_detail_meta_created));
        C1117a c1117a10 = this.binding;
        if (c1117a10 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a10 = null;
        }
        c1117a10.rowUpdated.tvMetaLabel.setText(getString(R$string.agent_detail_meta_updated));
        C1117a c1117a11 = this.binding;
        if (c1117a11 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a11 = null;
        }
        c1117a11.rowDownload.tvMetaLabel.setText(getString(R$string.agent_detail_meta_download));
        Q0();
        C1117a c1117a12 = this.binding;
        if (c1117a12 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a12 = null;
        }
        c1117a12.btnTopUninstall.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.C
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentMarketDetailActivity.K0(this.f24137a, view);
            }
        });
        W0();
        H0();
        F0();
        C1117a c1117a13 = this.binding;
        if (c1117a13 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a13 = null;
        }
        c1117a13.ivBack.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.market.D
            @Override // java.lang.Runnable
            public final void run() {
                AgentMarketDetailActivity.M0(this.f24139a);
            }
        });
        C1117a c1117a14 = this.binding;
        if (c1117a14 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1117a = c1117a14;
        }
        c1117a.vTopMask.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.market.E
            @Override // java.lang.Runnable
            public final void run() {
                AgentMarketDetailActivity.N0(this.f24140a);
            }
        });
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        hVar.F(this.backGlassHandle);
        this.backGlassHandle = null;
        hVar.F(this.uninstallGlassHandle);
        this.uninstallGlassHandle = null;
        super.onDestroy();
    }

    @Override // b.q, android.app.Activity
    public void onNewIntent(Intent intent) {
        kotlin.jvm.internal.p.i(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        if (!w0(intent)) {
            finish();
            return;
        }
        C1117a c1117a = this.binding;
        AgentMarketItem agentMarketItem = null;
        if (c1117a == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a = null;
        }
        c1117a.barInstallSuccess.removeCallbacks(this.hideSuccessBar);
        C1117a c1117a2 = this.binding;
        if (c1117a2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a2 = null;
        }
        c1117a2.barInstallSuccess.setVisibility(8);
        this.developer = "";
        Q0();
        F0();
        AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
        AgentMarketItem agentMarketItem2 = this.item;
        if (agentMarketItem2 == null) {
            kotlin.jvm.internal.p.A("item");
        } else {
            agentMarketItem = agentMarketItem2;
        }
        agentMarketOperaManager.K(agentMarketItem);
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        super.onResume();
        AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
        AgentMarketItem agentMarketItem = this.item;
        if (agentMarketItem == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem = null;
        }
        agentMarketOperaManager.K(agentMarketItem);
    }

    public final void p0(AgentMarketStatus status) {
        String string;
        C1117a c1117a;
        C1117a c1117a2;
        C1117a c1117a3;
        C1117a c1117a4;
        boolean zIsInstalled = status.isInstalled();
        boolean z10 = status == AgentMarketStatus.INSTALLING || status == AgentMarketStatus.QUEUED;
        boolean z11 = status == AgentMarketStatus.UPDATING;
        boolean z12 = status == AgentMarketStatus.UNINSTALLING;
        boolean z13 = z10 || z11;
        AgentMarketStatus agentMarketStatus = AgentMarketStatus.INSTALLED_DISABLED;
        boolean z14 = status == agentMarketStatus;
        boolean z15 = zIsInstalled && this.needUpdate && !z13 && !z12;
        U0(z15);
        T0(status);
        C1117a c1117a5 = this.binding;
        if (c1117a5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a5 = null;
        }
        c1117a5.footerContainer.setVisibility((!zIsInstalled || z15 || z14) ? 0 : 8);
        C1117a c1117a6 = this.binding;
        if (c1117a6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a6 = null;
        }
        c1117a6.btnBottom.setVisibility(0);
        C1117a c1117a7 = this.binding;
        if (c1117a7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a7 = null;
        }
        c1117a7.pbBottom.setVisibility(8);
        C1117a c1117a8 = this.binding;
        if (c1117a8 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a8 = null;
        }
        c1117a8.btnBottom.setClickable((z13 || z12) ? false : true);
        C1117a c1117a9 = this.binding;
        if (c1117a9 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a9 = null;
        }
        ProgressSplitTextView progressSplitTextView = c1117a9.btnBottom;
        if (z12) {
            string = getString(R$string.agent_detail_uninstalling);
        } else if (z11) {
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
        } else if (z15) {
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
            string = z14 ? getString(R$string.agent_detail_enable) : status == AgentMarketStatus.INSTALL_FAILED ? getString(R$string.agent_detail_retry_install) : getString(R$string.agent_detail_install);
        }
        progressSplitTextView.setText(string);
        C1117a c1117a10 = this.binding;
        if (c1117a10 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a10 = null;
        }
        c1117a10.btnBottom.setOnClickListener((z13 || z12) ? null : z15 ? new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentMarketDetailActivity.q0(this.f24214a, view);
            }
        } : z14 ? new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentMarketDetailActivity.r0(this.f24217a, view);
            }
        } : new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentMarketDetailActivity.s0(this.f24220a, view);
            }
        });
        C1117a c1117a11 = this.binding;
        if (c1117a11 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a11 = null;
        }
        c1117a11.btnBottom.setBackgroundResource((z13 || z12) ? R$drawable.bg_agent_installing_progress : R$drawable.bg_agent_install_btn);
        C1117a c1117a12 = this.binding;
        if (c1117a12 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a12 = null;
        }
        c1117a12.btnBottom.setFilledTextColor(-14935010);
        C1117a c1117a13 = this.binding;
        if (c1117a13 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a13 = null;
        }
        c1117a13.btnBottom.setUnfilledTextColor(-1);
        if (z13) {
            AgentMarketOperaManager agentMarketOperaManager3 = AgentMarketOperaManager.INSTANCE;
            AgentMarketItem agentMarketItem4 = this.item;
            if (agentMarketItem4 == null) {
                kotlin.jvm.internal.p.A("item");
                agentMarketItem4 = null;
            }
            int I10 = agentMarketOperaManager3.I(agentMarketItem4.getAssetId());
            V0(I10);
            C1117a c1117a14 = this.binding;
            if (c1117a14 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1117a14 = null;
            }
            c1117a14.btnBottom.setProgressFraction(I10 / 100.0f);
        } else {
            if (z12) {
                V0(0);
            }
            C1117a c1117a15 = this.binding;
            if (c1117a15 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1117a15 = null;
            }
            c1117a15.btnBottom.setProgressFraction(0.0f);
        }
        C1117a c1117a16 = this.binding;
        if (c1117a16 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a16 = null;
        }
        c1117a16.btnTopUninstall.setVisibility((zIsInstalled || z12) ? 0 : 8);
        C1117a c1117a17 = this.binding;
        if (c1117a17 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a17 = null;
        }
        c1117a17.ivTopUninstall.setVisibility(z12 ? 8 : 0);
        C1117a c1117a18 = this.binding;
        if (c1117a18 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a18 = null;
        }
        c1117a18.pbTopUninstall.setVisibility(z12 ? 0 : 8);
        C1117a c1117a19 = this.binding;
        if (c1117a19 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a19 = null;
        }
        c1117a19.btnTopUninstall.setClickable((z12 || z11) ? false : true);
        if (!zIsInstalled || z12) {
            com.stepos.ailauncher.container.glass.h.INSTANCE.F(this.uninstallGlassHandle);
            c1117a = null;
            this.uninstallGlassHandle = null;
            C1117a c1117a20 = this.binding;
            if (c1117a20 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1117a20 = null;
            }
            c1117a20.btnTopUninstall.setBackground(null);
        } else {
            if (this.uninstallGlassHandle == null) {
                com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
                C1117a c1117a21 = this.binding;
                if (c1117a21 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    c1117a21 = null;
                }
                FrameLayout btnTopUninstall = c1117a21.btnTopUninstall;
                kotlin.jvm.internal.p.h(btnTopUninstall, "btnTopUninstall");
                this.uninstallGlassHandle = com.stepos.ailauncher.container.glass.h.m(hVar, btnTopUninstall, false, Float.valueOf(22.0f), null, false, 24, null);
            }
            c1117a = null;
        }
        C1117a c1117a22 = this.binding;
        if (c1117a22 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a22 = c1117a;
        }
        c1117a22.actionArea.removeAllViews();
        if (z12 || z11) {
            C1117a c1117a23 = this.binding;
            if (c1117a23 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1117a2 = c1117a;
            } else {
                c1117a2 = c1117a23;
            }
            c1117a2.actionArea.addView(z0(status != agentMarketStatus, SwitchMode.GREYED, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.market.w
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AgentMarketDetailActivity.t0();
                }
            }));
            return;
        }
        if (status == AgentMarketStatus.INSTALLED_ENABLED) {
            C1117a c1117a24 = this.binding;
            if (c1117a24 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1117a4 = c1117a;
            } else {
                c1117a4 = c1117a24;
            }
            c1117a4.actionArea.addView(z0(true, SwitchMode.NORMAL, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.market.x
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AgentMarketDetailActivity.u0(this.f24223a);
                }
            }));
            return;
        }
        if (status == agentMarketStatus) {
            C1117a c1117a25 = this.binding;
            if (c1117a25 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1117a3 = c1117a;
            } else {
                c1117a3 = c1117a25;
            }
            c1117a3.actionArea.addView(z0(false, SwitchMode.NORMAL, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.market.y
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AgentMarketDetailActivity.v0(this.f24224a);
                }
            }));
        }
    }

    public final boolean w0(Intent intent) {
        AgentMarketItem agentMarketItem = (AgentMarketItem) intent.getParcelableExtra(EXTRA_ITEM);
        if (agentMarketItem == null) {
            return false;
        }
        this.item = agentMarketItem;
        this.needUpdate = agentMarketItem.getNeedUpdate();
        AgentMarketItem agentMarketItem2 = this.item;
        AgentMarketItem agentMarketItem3 = null;
        if (agentMarketItem2 == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem2 = null;
        }
        this.latestVersion = agentMarketItem2.getVersion();
        AgentMarketItem agentMarketItem4 = this.item;
        if (agentMarketItem4 == null) {
            kotlin.jvm.internal.p.A("item");
        } else {
            agentMarketItem3 = agentMarketItem4;
        }
        this.latestReversionId = agentMarketItem3.getReversionId();
        return true;
    }

    public final void x0() {
        AgentMarketItem agentMarketItem = this.item;
        if (agentMarketItem == null) {
            kotlin.jvm.internal.p.A("item");
            agentMarketItem = null;
        }
        new C0(this, agentMarketItem.getDisplayName(), new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.market.A
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentMarketDetailActivity.y0(this.f24133a);
            }
        }).show();
    }

    public final View z0(boolean checked, SwitchMode mode, final InterfaceC5063a<Y8.t> onToggle) {
        float f10 = getResources().getDisplayMetrics().density;
        int i10 = (int) (40 * f10);
        int i11 = (int) (22 * f10);
        int i12 = (int) (14 * f10);
        int i13 = (int) (4 * f10);
        int iC = androidx.core.content.a.c(this, R$color.skill_switch_track_off_value);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(i10, i11));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(i11 / 2.0f);
        if (checked) {
            iC = -1480402;
        }
        gradientDrawable.setColor(iC);
        frameLayout.setBackground(gradientDrawable);
        View view = new View(this);
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
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AgentMarketDetailActivity.A0(onToggle, view2);
            }
        });
        return frameLayout;
    }
}
