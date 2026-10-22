package com.stepos.ailauncher.contract.api.agent;

import Xa.t;
import Z8.C1173v;
import com.stepos.ailauncher.contract.model.ListPage;
import com.stepos.ailauncher.contract.model.MarketAgentBrief;
import com.stepos.ailauncher.contract.model.MarketAppBrief;
import com.stepos.ailauncher.contract.model.SkillItemBrief;
import com.stepos.ailauncher.contract.model.StoreInstallActivity;
import e9.InterfaceC4014c;
import h9.InterfaceC4149a;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.a;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u00017J4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H¦@¢\u0006\u0004\b\t\u0010\nJ*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\bH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\bH&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\bH&¢\u0006\u0004\b\u0017\u0010\u0016J2\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\u0006\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H¦@¢\u0006\u0004\b\u001a\u0010\u001bJ*\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u001c\u0010\fJN\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0004\b\u001f\u0010 JN\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0004\b!\u0010 J*\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b#\u0010\fJ2\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H¦@¢\u0006\u0004\b%\u0010&Jb\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0)2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020'2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002H¦@¢\u0006\u0004\b*\u0010+Jb\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00190)2\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020'2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002H¦@¢\u0006\u0004\b,\u0010-J4\u0010.\u001a\b\u0012\u0004\u0012\u00020\"0)2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020'H¦@¢\u0006\u0004\b.\u0010/J\u001e\u00100\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b0\u00101R\u001a\u00106\u001a\b\u0012\u0004\u0012\u000203028&X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00068À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/agent/IAgentMarketService;", "", "", "keyword", "", "page", ContentDisposition.Parameters.Size, "", "Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;", "getMarketAgents", "(Ljava/lang/String;IILe9/c;)Ljava/lang/Object;", "getTestingMarketAgents", "(IILe9/c;)Ljava/lang/Object;", "agent", "Lcom/stepos/ailauncher/contract/api/agent/IAgentMarketService$MarketAgentUiStatus;", "getAgentStatus", "(Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;)Lcom/stepos/ailauncher/contract/api/agent/IAgentMarketService$MarketAgentUiStatus;", "assetId", "getInstallProgress", "(Ljava/lang/String;)I", "LY8/t;", "installAgent", "(Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;)V", "uninstallAgent", "necessary", "Lcom/stepos/ailauncher/contract/model/SkillItemBrief;", "getSkillList", "(IIILe9/c;)Ljava/lang/Object;", "getTestingSkillList", "scanSource", "scanType", "getTestingSpaceSkills", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "getTestingSpaceAgents", "Lcom/stepos/ailauncher/contract/model/MarketAppBrief;", "getTestingSpaceApps", "statusIn", "getCliList", "(Ljava/lang/String;Ljava/util/List;Le9/c;)Ljava/lang/Object;", "", "testing", "Lcom/stepos/ailauncher/contract/model/ListPage;", "getAgentPage", "(Ljava/lang/String;IIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "getSkillPage", "(IIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "getAppPage", "(IIZLe9/c;)Ljava/lang/Object;", "searchMarketSkills", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "LXa/t;", "Lcom/stepos/ailauncher/contract/model/StoreInstallActivity;", "getInstallActivity", "()LXa/t;", "installActivity", "MarketAgentUiStatus", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IAgentMarketService {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object getTestingMarketAgents(IAgentMarketService iAgentMarketService, int i10, int i11, InterfaceC4014c<? super List<MarketAgentBrief>> interfaceC4014c) {
            return IAgentMarketService.super.getTestingMarketAgents(i10, i11, interfaceC4014c);
        }

        @Deprecated
        public static Object getTestingSkillList(IAgentMarketService iAgentMarketService, int i10, int i11, InterfaceC4014c<? super List<SkillItemBrief>> interfaceC4014c) {
            return IAgentMarketService.super.getTestingSkillList(i10, i11, interfaceC4014c);
        }

        @Deprecated
        public static Object getTestingSpaceAgents(IAgentMarketService iAgentMarketService, int i10, int i11, String str, String str2, String str3, InterfaceC4014c<? super List<MarketAgentBrief>> interfaceC4014c) {
            return IAgentMarketService.super.getTestingSpaceAgents(i10, i11, str, str2, str3, interfaceC4014c);
        }

        @Deprecated
        public static Object getTestingSpaceApps(IAgentMarketService iAgentMarketService, int i10, int i11, InterfaceC4014c<? super List<MarketAppBrief>> interfaceC4014c) {
            return IAgentMarketService.super.getTestingSpaceApps(i10, i11, interfaceC4014c);
        }

        @Deprecated
        public static Object getTestingSpaceSkills(IAgentMarketService iAgentMarketService, int i10, int i11, String str, String str2, String str3, InterfaceC4014c<? super List<SkillItemBrief>> interfaceC4014c) {
            return IAgentMarketService.super.getTestingSpaceSkills(i10, i11, str, str2, str3, interfaceC4014c);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/contract/api/agent/IAgentMarketService$MarketAgentUiStatus;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_INSTALLED", "INSTALLING", "QUEUED", "INSTALLED", "UNINSTALLING", "INSTALL_FAILED", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class MarketAgentUiStatus {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ MarketAgentUiStatus[] $VALUES;
        public static final MarketAgentUiStatus NOT_INSTALLED = new MarketAgentUiStatus("NOT_INSTALLED", 0);
        public static final MarketAgentUiStatus INSTALLING = new MarketAgentUiStatus("INSTALLING", 1);
        public static final MarketAgentUiStatus QUEUED = new MarketAgentUiStatus("QUEUED", 2);
        public static final MarketAgentUiStatus INSTALLED = new MarketAgentUiStatus("INSTALLED", 3);
        public static final MarketAgentUiStatus UNINSTALLING = new MarketAgentUiStatus("UNINSTALLING", 4);
        public static final MarketAgentUiStatus INSTALL_FAILED = new MarketAgentUiStatus("INSTALL_FAILED", 5);

        private static final /* synthetic */ MarketAgentUiStatus[] $values() {
            return new MarketAgentUiStatus[]{NOT_INSTALLED, INSTALLING, QUEUED, INSTALLED, UNINSTALLING, INSTALL_FAILED};
        }

        static {
            MarketAgentUiStatus[] marketAgentUiStatusArr$values = $values();
            $VALUES = marketAgentUiStatusArr$values;
            $ENTRIES = a.a(marketAgentUiStatusArr$values);
        }

        private MarketAgentUiStatus(String str, int i10) {
        }

        public static InterfaceC4149a<MarketAgentUiStatus> getEntries() {
            return $ENTRIES;
        }

        public static MarketAgentUiStatus valueOf(String str) {
            return (MarketAgentUiStatus) Enum.valueOf(MarketAgentUiStatus.class, str);
        }

        public static MarketAgentUiStatus[] values() {
            return (MarketAgentUiStatus[]) $VALUES.clone();
        }
    }

    static /* synthetic */ Object getAgentPage$default(IAgentMarketService iAgentMarketService, String str, int i10, int i11, boolean z10, String str2, String str3, String str4, InterfaceC4014c interfaceC4014c, int i12, Object obj) {
        String str5;
        InterfaceC4014c interfaceC4014c2;
        String str6;
        String str7;
        int i13;
        boolean z11;
        String str8;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAgentPage");
        }
        if ((i12 & 1) != 0) {
            str = "";
        }
        if ((i12 & 2) != 0) {
            i10 = 1;
        }
        if ((i12 & 4) != 0) {
            i11 = 20;
        }
        if ((i12 & 8) != 0) {
            z10 = false;
        }
        if ((i12 & 16) != 0) {
            str2 = null;
        }
        if ((i12 & 32) != 0) {
            str3 = null;
        }
        if ((i12 & 64) != 0) {
            str5 = null;
            str6 = str2;
            interfaceC4014c2 = interfaceC4014c;
            i13 = i11;
            str7 = str3;
            str8 = str;
            z11 = z10;
        } else {
            str5 = str4;
            interfaceC4014c2 = interfaceC4014c;
            str6 = str2;
            str7 = str3;
            i13 = i11;
            z11 = z10;
            str8 = str;
        }
        return iAgentMarketService.getAgentPage(str8, i10, i13, z11, str6, str7, str5, interfaceC4014c2);
    }

    static /* synthetic */ Object getAppPage$default(IAgentMarketService iAgentMarketService, int i10, int i11, boolean z10, InterfaceC4014c interfaceC4014c, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAppPage");
        }
        if ((i12 & 1) != 0) {
            i10 = 1;
        }
        if ((i12 & 2) != 0) {
            i11 = 50;
        }
        if ((i12 & 4) != 0) {
            z10 = true;
        }
        return iAgentMarketService.getAppPage(i10, i11, z10, interfaceC4014c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object getCliList$default(IAgentMarketService iAgentMarketService, String str, List list, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCliList");
        }
        if ((i10 & 1) != 0) {
            str = "";
        }
        if ((i10 & 2) != 0) {
            list = C1173v.m();
        }
        return iAgentMarketService.getCliList(str, list, interfaceC4014c);
    }

    static /* synthetic */ Object getMarketAgents$default(IAgentMarketService iAgentMarketService, String str, int i10, int i11, InterfaceC4014c interfaceC4014c, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMarketAgents");
        }
        if ((i12 & 1) != 0) {
            str = "";
        }
        if ((i12 & 2) != 0) {
            i10 = 1;
        }
        if ((i12 & 4) != 0) {
            i11 = 20;
        }
        return iAgentMarketService.getMarketAgents(str, i10, i11, interfaceC4014c);
    }

    static /* synthetic */ Object getSkillList$default(IAgentMarketService iAgentMarketService, int i10, int i11, int i12, InterfaceC4014c interfaceC4014c, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSkillList");
        }
        if ((i13 & 2) != 0) {
            i11 = 1;
        }
        if ((i13 & 4) != 0) {
            i12 = 20;
        }
        return iAgentMarketService.getSkillList(i10, i11, i12, interfaceC4014c);
    }

    static /* synthetic */ Object getSkillPage$default(IAgentMarketService iAgentMarketService, int i10, int i11, int i12, boolean z10, String str, String str2, String str3, InterfaceC4014c interfaceC4014c, int i13, Object obj) {
        String str4;
        InterfaceC4014c interfaceC4014c2;
        String str5;
        String str6;
        int i14;
        boolean z11;
        int i15;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSkillPage");
        }
        if ((i13 & 1) != 0) {
            i10 = -1;
        }
        if ((i13 & 2) != 0) {
            i11 = 1;
        }
        if ((i13 & 4) != 0) {
            i12 = 20;
        }
        if ((i13 & 8) != 0) {
            z10 = false;
        }
        if ((i13 & 16) != 0) {
            str = null;
        }
        if ((i13 & 32) != 0) {
            str2 = null;
        }
        if ((i13 & 64) != 0) {
            str4 = null;
            str5 = str;
            interfaceC4014c2 = interfaceC4014c;
            i14 = i12;
            str6 = str2;
            i15 = i10;
            z11 = z10;
        } else {
            str4 = str3;
            interfaceC4014c2 = interfaceC4014c;
            str5 = str;
            str6 = str2;
            i14 = i12;
            z11 = z10;
            i15 = i10;
        }
        return iAgentMarketService.getSkillPage(i15, i11, i14, z11, str5, str6, str4, interfaceC4014c2);
    }

    static /* synthetic */ Object getTestingMarketAgents$default(IAgentMarketService iAgentMarketService, int i10, int i11, InterfaceC4014c interfaceC4014c, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTestingMarketAgents");
        }
        if ((i12 & 1) != 0) {
            i10 = 1;
        }
        if ((i12 & 2) != 0) {
            i11 = 20;
        }
        return iAgentMarketService.getTestingMarketAgents(i10, i11, interfaceC4014c);
    }

    static /* synthetic */ Object getTestingMarketAgents$suspendImpl(IAgentMarketService iAgentMarketService, int i10, int i11, InterfaceC4014c<? super List<MarketAgentBrief>> interfaceC4014c) {
        return C1173v.m();
    }

    static /* synthetic */ Object getTestingSkillList$default(IAgentMarketService iAgentMarketService, int i10, int i11, InterfaceC4014c interfaceC4014c, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTestingSkillList");
        }
        if ((i12 & 1) != 0) {
            i10 = 1;
        }
        if ((i12 & 2) != 0) {
            i11 = 20;
        }
        return iAgentMarketService.getTestingSkillList(i10, i11, interfaceC4014c);
    }

    static /* synthetic */ Object getTestingSkillList$suspendImpl(IAgentMarketService iAgentMarketService, int i10, int i11, InterfaceC4014c<? super List<SkillItemBrief>> interfaceC4014c) {
        return C1173v.m();
    }

    static /* synthetic */ Object getTestingSpaceAgents$default(IAgentMarketService iAgentMarketService, int i10, int i11, String str, String str2, String str3, InterfaceC4014c interfaceC4014c, int i12, Object obj) {
        String str4;
        InterfaceC4014c interfaceC4014c2;
        String str5;
        String str6;
        int i13;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTestingSpaceAgents");
        }
        if ((i12 & 1) != 0) {
            i10 = 1;
        }
        if ((i12 & 2) != 0) {
            i11 = 20;
        }
        if ((i12 & 4) != 0) {
            str = null;
        }
        if ((i12 & 8) != 0) {
            str2 = null;
        }
        if ((i12 & 16) != 0) {
            str4 = null;
            str5 = str;
            interfaceC4014c2 = interfaceC4014c;
            i13 = i10;
            str6 = str2;
        } else {
            str4 = str3;
            interfaceC4014c2 = interfaceC4014c;
            str5 = str;
            str6 = str2;
            i13 = i10;
        }
        return iAgentMarketService.getTestingSpaceAgents(i13, i11, str5, str6, str4, interfaceC4014c2);
    }

    static /* synthetic */ Object getTestingSpaceAgents$suspendImpl(IAgentMarketService iAgentMarketService, int i10, int i11, String str, String str2, String str3, InterfaceC4014c<? super List<MarketAgentBrief>> interfaceC4014c) {
        return C1173v.m();
    }

    static /* synthetic */ Object getTestingSpaceApps$default(IAgentMarketService iAgentMarketService, int i10, int i11, InterfaceC4014c interfaceC4014c, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTestingSpaceApps");
        }
        if ((i12 & 1) != 0) {
            i10 = 1;
        }
        if ((i12 & 2) != 0) {
            i11 = 50;
        }
        return iAgentMarketService.getTestingSpaceApps(i10, i11, interfaceC4014c);
    }

    static /* synthetic */ Object getTestingSpaceApps$suspendImpl(IAgentMarketService iAgentMarketService, int i10, int i11, InterfaceC4014c<? super List<MarketAppBrief>> interfaceC4014c) {
        return C1173v.m();
    }

    static /* synthetic */ Object getTestingSpaceSkills$default(IAgentMarketService iAgentMarketService, int i10, int i11, String str, String str2, String str3, InterfaceC4014c interfaceC4014c, int i12, Object obj) {
        String str4;
        InterfaceC4014c interfaceC4014c2;
        String str5;
        String str6;
        int i13;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTestingSpaceSkills");
        }
        if ((i12 & 1) != 0) {
            i10 = 1;
        }
        if ((i12 & 2) != 0) {
            i11 = 20;
        }
        if ((i12 & 4) != 0) {
            str = null;
        }
        if ((i12 & 8) != 0) {
            str2 = null;
        }
        if ((i12 & 16) != 0) {
            str4 = null;
            str5 = str;
            interfaceC4014c2 = interfaceC4014c;
            i13 = i10;
            str6 = str2;
        } else {
            str4 = str3;
            interfaceC4014c2 = interfaceC4014c;
            str5 = str;
            str6 = str2;
            i13 = i10;
        }
        return iAgentMarketService.getTestingSpaceSkills(i13, i11, str5, str6, str4, interfaceC4014c2);
    }

    static /* synthetic */ Object getTestingSpaceSkills$suspendImpl(IAgentMarketService iAgentMarketService, int i10, int i11, String str, String str2, String str3, InterfaceC4014c<? super List<SkillItemBrief>> interfaceC4014c) {
        return C1173v.m();
    }

    Object getAgentPage(String str, int i10, int i11, boolean z10, String str2, String str3, String str4, InterfaceC4014c<? super ListPage<MarketAgentBrief>> interfaceC4014c);

    MarketAgentUiStatus getAgentStatus(MarketAgentBrief agent);

    Object getAppPage(int i10, int i11, boolean z10, InterfaceC4014c<? super ListPage<MarketAppBrief>> interfaceC4014c);

    Object getCliList(String str, List<String> list, InterfaceC4014c<? super List<SkillItemBrief>> interfaceC4014c);

    t<StoreInstallActivity> getInstallActivity();

    int getInstallProgress(String assetId);

    Object getMarketAgents(String str, int i10, int i11, InterfaceC4014c<? super List<MarketAgentBrief>> interfaceC4014c);

    Object getSkillList(int i10, int i11, int i12, InterfaceC4014c<? super List<SkillItemBrief>> interfaceC4014c);

    Object getSkillPage(int i10, int i11, int i12, boolean z10, String str, String str2, String str3, InterfaceC4014c<? super ListPage<SkillItemBrief>> interfaceC4014c);

    default Object getTestingMarketAgents(int i10, int i11, InterfaceC4014c<? super List<MarketAgentBrief>> interfaceC4014c) {
        return getTestingMarketAgents$suspendImpl(this, i10, i11, interfaceC4014c);
    }

    default Object getTestingSkillList(int i10, int i11, InterfaceC4014c<? super List<SkillItemBrief>> interfaceC4014c) {
        return getTestingSkillList$suspendImpl(this, i10, i11, interfaceC4014c);
    }

    default Object getTestingSpaceAgents(int i10, int i11, String str, String str2, String str3, InterfaceC4014c<? super List<MarketAgentBrief>> interfaceC4014c) {
        return getTestingSpaceAgents$suspendImpl(this, i10, i11, str, str2, str3, interfaceC4014c);
    }

    default Object getTestingSpaceApps(int i10, int i11, InterfaceC4014c<? super List<MarketAppBrief>> interfaceC4014c) {
        return getTestingSpaceApps$suspendImpl(this, i10, i11, interfaceC4014c);
    }

    default Object getTestingSpaceSkills(int i10, int i11, String str, String str2, String str3, InterfaceC4014c<? super List<SkillItemBrief>> interfaceC4014c) {
        return getTestingSpaceSkills$suspendImpl(this, i10, i11, str, str2, str3, interfaceC4014c);
    }

    void installAgent(MarketAgentBrief agent);

    Object searchMarketSkills(String str, InterfaceC4014c<? super List<SkillItemBrief>> interfaceC4014c);

    void uninstallAgent(MarketAgentBrief agent);
}
