package com.stepos.ailauncher.agent.aispace.market;

import com.stepos.ailauncher.agent.aispace.market.data.AgentSkillBean;
import com.stepos.ailauncher.agent.aispace.market.data.AppItemDto;
import com.stepos.ailauncher.contract.api.agent.IAgentMarketService;
import com.stepos.ailauncher.contract.model.MarketAgentBrief;
import com.stepos.ailauncher.contract.model.MarketAppBrief;
import com.stepos.ailauncher.contract.model.SkillItemBrief;
import com.stepos.ailauncher.contract.model.StoreInstallActivity;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u0018J.\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\t2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u001c\u0010\u001dJ&\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u001e\u0010\u000eJD\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0096@¢\u0006\u0004\b!\u0010\"JD\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0096@¢\u0006\u0004\b#\u0010\"JT\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0&2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0096@¢\u0006\u0004\b'\u0010(JT\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001b0&2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0096@¢\u0006\u0004\b)\u0010*J\u001e\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001b0\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b+\u0010,J.\u0010.\u001a\b\u0012\u0004\u0012\u00020-0&2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$H\u0096@¢\u0006\u0004\b.\u0010/J&\u00100\u001a\b\u0012\u0004\u0012\u00020-0\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b0\u0010\u000eJ.\u00102\u001a\b\u0012\u0004\u0012\u00020\u001b0\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0096@¢\u0006\u0004\b2\u00103JZ\u00104\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0082@¢\u0006\u0004\b4\u00105R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u000207068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006;"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketServiceImpl;", "Lcom/stepos/ailauncher/contract/api/agent/IAgentMarketService;", "<init>", "()V", "", "keyword", "", "page", ContentDisposition.Parameters.Size, "", "Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;", "getMarketAgents", "(Ljava/lang/String;IILe9/c;)Ljava/lang/Object;", "getTestingMarketAgents", "(IILe9/c;)Ljava/lang/Object;", "agent", "Lcom/stepos/ailauncher/contract/api/agent/IAgentMarketService$MarketAgentUiStatus;", "getAgentStatus", "(Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;)Lcom/stepos/ailauncher/contract/api/agent/IAgentMarketService$MarketAgentUiStatus;", "assetId", "getInstallProgress", "(Ljava/lang/String;)I", "LY8/t;", "installAgent", "(Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;)V", "uninstallAgent", "necessary", "Lcom/stepos/ailauncher/contract/model/SkillItemBrief;", "getSkillList", "(IIILe9/c;)Ljava/lang/Object;", "getTestingSkillList", "scanSource", "scanType", "getTestingSpaceSkills", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "getTestingSpaceAgents", "", "testing", "Lcom/stepos/ailauncher/contract/model/ListPage;", "getAgentPage", "(Ljava/lang/String;IIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "getSkillPage", "(IIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "searchMarketSkills", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/contract/model/MarketAppBrief;", "getAppPage", "(IIZLe9/c;)Ljava/lang/Object;", "getTestingSpaceApps", "statusIn", "getCliList", "(Ljava/lang/String;Ljava/util/List;Le9/c;)Ljava/lang/Object;", "e", "(Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "LXa/t;", "Lcom/stepos/ailauncher/contract/model/StoreInstallActivity;", "getInstallActivity", "()LXa/t;", "installActivity", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentMarketServiceImpl implements IAgentMarketService {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
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
                iArr[AgentMarketStatus.UPDATING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AgentMarketStatus.QUEUED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AgentMarketStatus.INSTALLED_ENABLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AgentMarketStatus.INSTALLED_DISABLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AgentMarketStatus.UNINSTALLING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AgentMarketStatus.INSTALL_FAILED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl", f = "AgentMarketServiceImpl.kt", l = {143}, m = "getAgentPage", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getAgentPage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgentMarketServiceImpl.this.getAgentPage(null, 0, 0, false, null, null, null, this);
        }
    }

    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl", f = "AgentMarketServiceImpl.kt", l = {161}, m = "getAppPage", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getAppPage$1, reason: invalid class name and case insensitive filesystem */
    public static final class C22471 extends ContinuationImpl {
        int I$0;
        int I$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C22471(InterfaceC4014c<? super C22471> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgentMarketServiceImpl.this.getAppPage(0, 0, false, this);
        }
    }

    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl", f = "AgentMarketServiceImpl.kt", l = {181, 181}, m = "getCliList", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getCliList$1, reason: invalid class name and case insensitive filesystem */
    public static final class C22481 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C22481(InterfaceC4014c<? super C22481> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgentMarketServiceImpl.this.getCliList(null, null, this);
        }
    }

    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl", f = "AgentMarketServiceImpl.kt", l = {103}, m = "getSkillList", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getSkillList$1, reason: invalid class name and case insensitive filesystem */
    public static final class C22491 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int label;
        /* synthetic */ Object result;

        public C22491(InterfaceC4014c<? super C22491> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgentMarketServiceImpl.this.getSkillList(0, 0, 0, this);
        }
    }

    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl", f = "AgentMarketServiceImpl.kt", l = {154}, m = "getSkillPage", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getSkillPage$1, reason: invalid class name and case insensitive filesystem */
    public static final class C22501 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C22501(InterfaceC4014c<? super C22501> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgentMarketServiceImpl.this.getSkillPage(0, 0, 0, false, null, null, null, this);
        }
    }

    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl", f = "AgentMarketServiceImpl.kt", l = {112}, m = "getTestingSkillList", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getTestingSkillList$1, reason: invalid class name and case insensitive filesystem */
    public static final class C22511 extends ContinuationImpl {
        int I$0;
        int I$1;
        int label;
        /* synthetic */ Object result;

        public C22511(InterfaceC4014c<? super C22511> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgentMarketServiceImpl.this.getTestingSkillList(0, 0, this);
        }
    }

    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl", f = "AgentMarketServiceImpl.kt", l = {133}, m = "getTestingSpaceAgents", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getTestingSpaceAgents$1, reason: invalid class name and case insensitive filesystem */
    public static final class C22521 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C22521(InterfaceC4014c<? super C22521> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgentMarketServiceImpl.this.getTestingSpaceAgents(0, 0, null, null, null, this);
        }
    }

    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl", f = "AgentMarketServiceImpl.kt", l = {DidiCardView.FINISHED_SUMMARY_WIDTH_DP}, m = "getTestingSpaceApps", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getTestingSpaceApps$1, reason: invalid class name and case insensitive filesystem */
    public static final class C22531 extends ContinuationImpl {
        int I$0;
        int I$1;
        int label;
        /* synthetic */ Object result;

        public C22531(InterfaceC4014c<? super C22531> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgentMarketServiceImpl.this.getTestingSpaceApps(0, 0, this);
        }
    }

    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl", f = "AgentMarketServiceImpl.kt", l = {121}, m = "getTestingSpaceSkills", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getTestingSpaceSkills$1, reason: invalid class name and case insensitive filesystem */
    public static final class C22541 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C22541(InterfaceC4014c<? super C22541> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgentMarketServiceImpl.this.getTestingSpaceSkills(0, 0, null, null, null, this);
        }
    }

    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl", f = "AgentMarketServiceImpl.kt", l = {158}, m = "searchMarketSkills", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$searchMarketSkills$1, reason: invalid class name and case insensitive filesystem */
    public static final class C22551 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C22551(InterfaceC4014c<? super C22551> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgentMarketServiceImpl.this.searchMarketSkills(null, this);
        }
    }

    public static /* synthetic */ Object f(AgentMarketServiceImpl agentMarketServiceImpl, String str, int i10, int i11, int i12, String str2, String str3, String str4, InterfaceC4014c interfaceC4014c, int i13, Object obj) {
        if ((i13 & 16) != 0) {
            str2 = null;
        }
        if ((i13 & 32) != 0) {
            str3 = null;
        }
        if ((i13 & 64) != 0) {
            str4 = null;
        }
        return agentMarketServiceImpl.e(str, i10, i11, i12, str2, str3, str4, interfaceC4014c);
    }

    public static final MarketAgentBrief g(boolean z10, AgentMarketItem item) {
        kotlin.jvm.internal.p.i(item, "item");
        return new MarketAgentBrief(item.getAssetId(), item.getReversionId(), item.getVersion(), item.getDisplayName(), item.getDescription(), item.getDeveloper(), item.getDownloadCount(), item.getInstallVersion(), item.getNeedUpdate(), item.getInitialStatus().isInstalled(), item.getIconUrl(), z10, false, item.getEnv(), 4096, null);
    }

    public static final MarketAppBrief h(AppItemDto it) {
        kotlin.jvm.internal.p.i(it, "it");
        return z0.i(it);
    }

    public static final SkillItemBrief i(boolean z10, AgentSkillBean it) {
        kotlin.jvm.internal.p.i(it, "it");
        return z0.g(it, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.lang.String r34, int r35, int r36, int r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, e9.InterfaceC4014c<? super java.util.List<com.stepos.ailauncher.contract.model.MarketAgentBrief>> r41) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.e(java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.stepos.ailauncher.contract.api.agent.IAgentMarketService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getAgentPage(java.lang.String r5, int r6, int r7, final boolean r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, e9.InterfaceC4014c<? super com.stepos.ailauncher.contract.model.ListPage<com.stepos.ailauncher.contract.model.MarketAgentBrief>> r12) throws java.lang.Exception {
        /*
            r4 = this;
            boolean r0 = r12 instanceof com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r12
            com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getAgentPage$1 r0 = (com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r12 = r0
            goto L1a
        L14:
            com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getAgentPage$1 r0 = new com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getAgentPage$1
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r4 = r12.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r12.label
            r2 = 1
            if (r1 == 0) goto L45
            if (r1 != r2) goto L3d
            boolean r8 = r12.Z$0
            java.lang.Object r5 = r12.L$3
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r12.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r12.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r12.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r4)
            goto L71
        L3d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L45:
            kotlin.C4849c.b(r4)
            com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository r4 = com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.INSTANCE
            java.lang.Object r1 = g9.h.a(r5)
            r12.L$0 = r1
            java.lang.Object r1 = g9.h.a(r9)
            r12.L$1 = r1
            java.lang.Object r1 = g9.h.a(r10)
            r12.L$2 = r1
            java.lang.Object r1 = g9.h.a(r11)
            r12.L$3 = r1
            r12.I$0 = r6
            r12.I$1 = r7
            r12.Z$0 = r8
            r12.label = r2
            java.lang.Object r4 = r4.e(r5, r6, r7, r8, r9, r10, r11, r12)
            if (r4 != r0) goto L71
            return r0
        L71:
            com.stepos.ailauncher.contract.model.ListPage r4 = (com.stepos.ailauncher.contract.model.ListPage) r4
            com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager r5 = com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager.INSTANCE
            java.util.List r6 = r4.getItems()
            r5.L(r6)
            com.stepos.ailauncher.agent.aispace.market.w0 r5 = new com.stepos.ailauncher.agent.aispace.market.w0
            r5.<init>()
            com.stepos.ailauncher.contract.model.ListPage r4 = r4.map(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.getAgentPage(java.lang.String, int, int, boolean, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IAgentMarketService
    public IAgentMarketService.MarketAgentUiStatus getAgentStatus(MarketAgentBrief agent) {
        kotlin.jvm.internal.p.i(agent, "agent");
        switch (a.$EnumSwitchMapping$0[AgentMarketOperaManager.INSTANCE.Q(agent.getAssetId(), z0.h(agent).getInitialStatus()).ordinal()]) {
            case 1:
                return IAgentMarketService.MarketAgentUiStatus.NOT_INSTALLED;
            case 2:
            case 3:
                return IAgentMarketService.MarketAgentUiStatus.INSTALLING;
            case 4:
                return IAgentMarketService.MarketAgentUiStatus.QUEUED;
            case 5:
            case 6:
                return IAgentMarketService.MarketAgentUiStatus.INSTALLED;
            case 7:
                return IAgentMarketService.MarketAgentUiStatus.UNINSTALLING;
            case 8:
                return IAgentMarketService.MarketAgentUiStatus.INSTALL_FAILED;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.contract.api.agent.IAgentMarketService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getAppPage(int r5, int r6, boolean r7, e9.InterfaceC4014c<? super com.stepos.ailauncher.contract.model.ListPage<com.stepos.ailauncher.contract.model.MarketAppBrief>> r8) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.C22471
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getAppPage$1 r0 = (com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.C22471) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getAppPage$1 r0 = new com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getAppPage$1
            r0.<init>(r8)
        L18:
            java.lang.Object r4 = r0.result
            java.lang.Object r8 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            kotlin.C4849c.b(r4)
            goto L45
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r4)
            com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository r4 = com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.INSTANCE
            r0.I$0 = r5
            r0.I$1 = r6
            r0.Z$0 = r7
            r0.label = r2
            java.lang.Object r4 = r4.g(r5, r6, r7, r0)
            if (r4 != r8) goto L45
            return r8
        L45:
            com.stepos.ailauncher.contract.model.ListPage r4 = (com.stepos.ailauncher.contract.model.ListPage) r4
            com.stepos.ailauncher.agent.aispace.market.x0 r5 = new com.stepos.ailauncher.agent.aispace.market.x0
            r5.<init>()
            com.stepos.ailauncher.contract.model.ListPage r4 = r4.map(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.getAppPage(int, int, boolean, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c5, code lost:
    
        if (r0 == r1) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    @Override // com.stepos.ailauncher.contract.api.agent.IAgentMarketService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getCliList(java.lang.String r26, java.util.List<java.lang.String> r27, e9.InterfaceC4014c<? super java.util.List<com.stepos.ailauncher.contract.model.SkillItemBrief>> r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.getCliList(java.lang.String, java.util.List, e9.c):java.lang.Object");
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IAgentMarketService
    public Xa.t<StoreInstallActivity> getInstallActivity() {
        return StoreInstallActivityTracker.INSTANCE.j();
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IAgentMarketService
    public int getInstallProgress(String assetId) {
        kotlin.jvm.internal.p.i(assetId, "assetId");
        return AgentMarketOperaManager.INSTANCE.I(assetId);
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IAgentMarketService
    public Object getMarketAgents(String str, int i10, int i11, InterfaceC4014c<? super List<MarketAgentBrief>> interfaceC4014c) {
        return f(this, str, i10, i11, 0, null, null, null, interfaceC4014c, 112, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    @Override // com.stepos.ailauncher.contract.api.agent.IAgentMarketService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getSkillList(int r14, int r15, int r16, e9.InterfaceC4014c<? super java.util.List<com.stepos.ailauncher.contract.model.SkillItemBrief>> r17) throws java.lang.Throwable {
        /*
            r13 = this;
            r0 = r17
            boolean r1 = r0 instanceof com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.C22491
            if (r1 == 0) goto L16
            r1 = r0
            com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getSkillList$1 r1 = (com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.C22491) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.label = r2
        L14:
            r10 = r1
            goto L1c
        L16:
            com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getSkillList$1 r1 = new com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getSkillList$1
            r1.<init>(r0)
            goto L14
        L1c:
            java.lang.Object r13 = r10.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r10.label
            r2 = 1
            if (r1 == 0) goto L3b
            if (r1 != r2) goto L33
            kotlin.C4849c.b(r13)
            kotlin.Result r13 = (kotlin.Result) r13
            java.lang.Object r13 = r13.getValue()
            goto L5b
        L33:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L3b:
            kotlin.C4849c.b(r13)
            com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository r13 = com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.INSTANCE
            r10.I$0 = r14
            r10.I$1 = r15
            r5 = r16
            r10.I$2 = r5
            r10.label = r2
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 120(0x78, float:1.68E-43)
            r12 = 0
            r2 = r13
            r3 = r14
            r4 = r15
            java.lang.Object r13 = com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.x(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            if (r13 != r0) goto L5b
            return r0
        L5b:
            java.lang.Throwable r14 = kotlin.Result.e(r13)
            if (r14 != 0) goto L62
            goto L66
        L62:
            java.util.List r13 = Z8.C1173v.m()
        L66:
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.ArrayList r14 = new java.util.ArrayList
            r15 = 10
            int r15 = Z8.C1174w.x(r13, r15)
            r14.<init>(r15)
            java.util.Iterator r13 = r13.iterator()
        L77:
            boolean r15 = r13.hasNext()
            if (r15 == 0) goto L8c
            java.lang.Object r15 = r13.next()
            com.stepos.ailauncher.agent.aispace.market.data.e r15 = (com.stepos.ailauncher.agent.aispace.market.data.AgentSkillBean) r15
            r0 = 0
            com.stepos.ailauncher.contract.model.SkillItemBrief r15 = com.stepos.ailauncher.agent.aispace.market.z0.b(r15, r0)
            r14.add(r15)
            goto L77
        L8c:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.getSkillList(int, int, int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.stepos.ailauncher.contract.api.agent.IAgentMarketService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getSkillPage(int r5, int r6, int r7, final boolean r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, e9.InterfaceC4014c<? super com.stepos.ailauncher.contract.model.ListPage<com.stepos.ailauncher.contract.model.SkillItemBrief>> r12) throws java.lang.Exception {
        /*
            r4 = this;
            boolean r0 = r12 instanceof com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.C22501
            if (r0 == 0) goto L14
            r0 = r12
            com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getSkillPage$1 r0 = (com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.C22501) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r12 = r0
            goto L1a
        L14:
            com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getSkillPage$1 r0 = new com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getSkillPage$1
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r4 = r12.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r12.label
            r2 = 1
            if (r1 == 0) goto L41
            if (r1 != r2) goto L39
            boolean r8 = r12.Z$0
            java.lang.Object r5 = r12.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r12.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r12.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r4)
            goto L69
        L39:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L41:
            kotlin.C4849c.b(r4)
            com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository r4 = com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.INSTANCE
            java.lang.Object r1 = g9.h.a(r9)
            r12.L$0 = r1
            java.lang.Object r1 = g9.h.a(r10)
            r12.L$1 = r1
            java.lang.Object r1 = g9.h.a(r11)
            r12.L$2 = r1
            r12.I$0 = r5
            r12.I$1 = r6
            r12.I$2 = r7
            r12.Z$0 = r8
            r12.label = r2
            java.lang.Object r4 = r4.D(r5, r6, r7, r8, r9, r10, r11, r12)
            if (r4 != r0) goto L69
            return r0
        L69:
            com.stepos.ailauncher.contract.model.ListPage r4 = (com.stepos.ailauncher.contract.model.ListPage) r4
            com.stepos.ailauncher.agent.aispace.market.y0 r5 = new com.stepos.ailauncher.agent.aispace.market.y0
            r5.<init>()
            com.stepos.ailauncher.contract.model.ListPage r4 = r4.map(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.getSkillPage(int, int, int, boolean, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IAgentMarketService
    public Object getTestingMarketAgents(int i10, int i11, InterfaceC4014c<? super List<MarketAgentBrief>> interfaceC4014c) {
        return f(this, "", i10, i11, 1, null, null, null, interfaceC4014c, 112, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    @Override // com.stepos.ailauncher.contract.api.agent.IAgentMarketService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getTestingSkillList(int r15, int r16, e9.InterfaceC4014c<? super java.util.List<com.stepos.ailauncher.contract.model.SkillItemBrief>> r17) throws java.lang.Throwable {
        /*
            r14 = this;
            r0 = r17
            boolean r1 = r0 instanceof com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.C22511
            if (r1 == 0) goto L16
            r1 = r0
            com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getTestingSkillList$1 r1 = (com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.C22511) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.label = r2
        L14:
            r10 = r1
            goto L1c
        L16:
            com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getTestingSkillList$1 r1 = new com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getTestingSkillList$1
            r1.<init>(r0)
            goto L14
        L1c:
            java.lang.Object r14 = r10.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r10.label
            r13 = 1
            if (r1 == 0) goto L3b
            if (r1 != r13) goto L33
            kotlin.C4849c.b(r14)
            kotlin.Result r14 = (kotlin.Result) r14
            java.lang.Object r14 = r14.getValue()
            goto L58
        L33:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L3b:
            kotlin.C4849c.b(r14)
            com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository r2 = com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.INSTANCE
            r10.I$0 = r15
            r5 = r16
            r10.I$1 = r5
            r10.label = r13
            r3 = -1
            r6 = 1
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 112(0x70, float:1.57E-43)
            r12 = 0
            r4 = r15
            java.lang.Object r14 = com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.x(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            if (r14 != r0) goto L58
            return r0
        L58:
            java.lang.Throwable r15 = kotlin.Result.e(r14)
            if (r15 != 0) goto L5f
            goto L63
        L5f:
            java.util.List r14 = Z8.C1173v.m()
        L63:
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.ArrayList r15 = new java.util.ArrayList
            r0 = 10
            int r0 = Z8.C1174w.x(r14, r0)
            r15.<init>(r0)
            java.util.Iterator r14 = r14.iterator()
        L74:
            boolean r0 = r14.hasNext()
            if (r0 == 0) goto L88
            java.lang.Object r0 = r14.next()
            com.stepos.ailauncher.agent.aispace.market.data.e r0 = (com.stepos.ailauncher.agent.aispace.market.data.AgentSkillBean) r0
            com.stepos.ailauncher.contract.model.SkillItemBrief r0 = com.stepos.ailauncher.agent.aispace.market.z0.b(r0, r13)
            r15.add(r0)
            goto L74
        L88:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.getTestingSkillList(int, int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r0v9, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v0, types: [T, java.lang.Integer] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00da -> B:44:0x00e3). Please report as a decompilation issue!!! */
    @Override // com.stepos.ailauncher.contract.api.agent.IAgentMarketService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getTestingSpaceAgents(int r20, int r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, e9.InterfaceC4014c<? super java.util.List<com.stepos.ailauncher.contract.model.MarketAgentBrief>> r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.getTestingSpaceAgents(int, int, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.stepos.ailauncher.contract.api.agent.IAgentMarketService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getTestingSpaceApps(int r11, int r12, e9.InterfaceC4014c<? super java.util.List<com.stepos.ailauncher.contract.model.MarketAppBrief>> r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.C22531
            if (r0 == 0) goto L14
            r0 = r13
            com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getTestingSpaceApps$1 r0 = (com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.C22531) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getTestingSpaceApps$1 r0 = new com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$getTestingSpaceApps$1
            r0.<init>(r13)
            goto L12
        L1a:
            java.lang.Object r10 = r7.result
            java.lang.Object r13 = f9.C4063a.g()
            int r0 = r7.label
            r1 = 1
            if (r0 == 0) goto L39
            if (r0 != r1) goto L31
            kotlin.C4849c.b(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            java.lang.Object r10 = r10.getValue()
            goto L54
        L31:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L39:
            kotlin.C4849c.b(r10)
            r10 = r1
            com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository r1 = com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.INSTANCE
            r7.I$0 = r11
            r7.I$1 = r12
            r7.label = r10
            r2 = 1
            r5 = 0
            r6 = 0
            r8 = 24
            r9 = 0
            r3 = r11
            r4 = r12
            java.lang.Object r10 = com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.r(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            if (r10 != r13) goto L54
            return r13
        L54:
            java.lang.Throwable r11 = kotlin.Result.e(r10)
            if (r11 != 0) goto L5b
            goto L5f
        L5b:
            java.util.List r10 = Z8.C1173v.m()
        L5f:
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r11 = new java.util.ArrayList
            r12 = 10
            int r12 = Z8.C1174w.x(r10, r12)
            r11.<init>(r12)
            java.util.Iterator r10 = r10.iterator()
        L70:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto L84
            java.lang.Object r12 = r10.next()
            com.stepos.ailauncher.agent.aispace.market.data.g r12 = (com.stepos.ailauncher.agent.aispace.market.data.AppItemDto) r12
            com.stepos.ailauncher.contract.model.MarketAppBrief r12 = com.stepos.ailauncher.agent.aispace.market.z0.d(r12)
            r11.add(r12)
            goto L70
        L84:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.getTestingSpaceApps(int, int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r0v9, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v0, types: [T, java.lang.Integer] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00da -> B:44:0x00e3). Please report as a decompilation issue!!! */
    @Override // com.stepos.ailauncher.contract.api.agent.IAgentMarketService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getTestingSpaceSkills(int r20, int r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, e9.InterfaceC4014c<? super java.util.List<com.stepos.ailauncher.contract.model.SkillItemBrief>> r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.getTestingSpaceSkills(int, int, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IAgentMarketService
    public void installAgent(MarketAgentBrief agent) {
        kotlin.jvm.internal.p.i(agent, "agent");
        AgentMarketOperaManager.INSTANCE.y(z0.h(agent));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.contract.api.agent.IAgentMarketService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object searchMarketSkills(java.lang.String r5, e9.InterfaceC4014c<? super java.util.List<com.stepos.ailauncher.contract.model.SkillItemBrief>> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.C22551
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$searchMarketSkills$1 r0 = (com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.C22551) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$searchMarketSkills$1 r0 = new com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl$searchMarketSkills$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.result
            java.lang.Object r6 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r4)
            goto L49
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r4)
            com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository r4 = com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.INSTANCE
            java.lang.Object r1 = g9.h.a(r5)
            r0.L$0 = r1
            r0.label = r2
            java.lang.Object r4 = r4.B(r5, r0)
            if (r4 != r6) goto L49
            return r6
        L49:
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r6 = 10
            int r6 = Z8.C1174w.x(r4, r6)
            r5.<init>(r6)
            java.util.Iterator r4 = r4.iterator()
        L5a:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L6f
            java.lang.Object r6 = r4.next()
            com.stepos.ailauncher.agent.aispace.market.data.e r6 = (com.stepos.ailauncher.agent.aispace.market.data.AgentSkillBean) r6
            r0 = 0
            com.stepos.ailauncher.contract.model.SkillItemBrief r6 = com.stepos.ailauncher.agent.aispace.market.z0.b(r6, r0)
            r5.add(r6)
            goto L5a
        L6f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl.searchMarketSkills(java.lang.String, e9.c):java.lang.Object");
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IAgentMarketService
    public void uninstallAgent(MarketAgentBrief agent) {
        kotlin.jvm.internal.p.i(agent, "agent");
        AgentMarketOperaManager.INSTANCE.U(z0.h(agent));
    }
}
