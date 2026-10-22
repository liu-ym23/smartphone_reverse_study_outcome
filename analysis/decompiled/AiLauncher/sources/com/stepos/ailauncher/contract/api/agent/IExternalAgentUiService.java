package com.stepos.ailauncher.contract.api.agent;

import Y8.t;
import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.contract.model.MarketAgentBrief;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.g;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001'J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0018\u0010\u0015\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\u00040\u0014H&¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010!\u001a\u0004\u0018\u00010\u001eH&¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u0004\u0018\u00010\u001e2\u0006\u0010$\u001a\u00020#H&¢\u0006\u0004\b%\u0010&¨\u0006(À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentUiService;", "", "Landroid/view/ViewGroup;", "host", "LY8/t;", "showAddAgentSheet", "(Landroid/view/ViewGroup;)V", "", "agentType", "", "isCrossDeviceAuthorized", "(Ljava/lang/String;)Z", "Lkotlin/Function0;", "onAuthorized", "showCrossDeviceAuthDialog", "(Landroid/view/ViewGroup;Ljava/lang/String;Lp9/a;)V", "", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentUiService$RemoteAgentEntry;", "getRemoteAgentEntries", "()Ljava/util/List;", "Lkotlin/Function1;", "onUpdated", "Lkotlinx/coroutines/g;", "refreshRemoteAgentEntries", "(Lp9/l;)Lkotlinx/coroutines/g;", "Landroid/content/Context;", "context", "connectRemoteAgent", "(Landroid/content/Context;Ljava/lang/String;)V", "displayName", "Landroidx/fragment/app/Fragment;", "createConnectFragment", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/fragment/app/Fragment;", "createConnectedAgentsFragment", "()Landroidx/fragment/app/Fragment;", "Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;", "agent", "createAgentMarketDetailFragment", "(Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;)Landroidx/fragment/app/Fragment;", "RemoteAgentEntry", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IExternalAgentUiService {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentUiService$RemoteAgentEntry;", "", "agentType", "", "title", "description", "iconRes", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAgentType", "()Ljava/lang/String;", "getTitle", "getDescription", "getIconRes", "()I", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class RemoteAgentEntry {
        private final String agentType;
        private final String description;
        private final int iconRes;
        private final String title;

        public RemoteAgentEntry(String agentType, String title, String description, int i10) {
            p.i(agentType, "agentType");
            p.i(title, "title");
            p.i(description, "description");
            this.agentType = agentType;
            this.title = title;
            this.description = description;
            this.iconRes = i10;
        }

        public static /* synthetic */ RemoteAgentEntry copy$default(RemoteAgentEntry remoteAgentEntry, String str, String str2, String str3, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = remoteAgentEntry.agentType;
            }
            if ((i11 & 2) != 0) {
                str2 = remoteAgentEntry.title;
            }
            if ((i11 & 4) != 0) {
                str3 = remoteAgentEntry.description;
            }
            if ((i11 & 8) != 0) {
                i10 = remoteAgentEntry.iconRes;
            }
            return remoteAgentEntry.copy(str, str2, str3, i10);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAgentType() {
            return this.agentType;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component3, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: component4, reason: from getter */
        public final int getIconRes() {
            return this.iconRes;
        }

        public final RemoteAgentEntry copy(String agentType, String title, String description, int iconRes) {
            p.i(agentType, "agentType");
            p.i(title, "title");
            p.i(description, "description");
            return new RemoteAgentEntry(agentType, title, description, iconRes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RemoteAgentEntry)) {
                return false;
            }
            RemoteAgentEntry remoteAgentEntry = (RemoteAgentEntry) other;
            return p.d(this.agentType, remoteAgentEntry.agentType) && p.d(this.title, remoteAgentEntry.title) && p.d(this.description, remoteAgentEntry.description) && this.iconRes == remoteAgentEntry.iconRes;
        }

        public final String getAgentType() {
            return this.agentType;
        }

        public final String getDescription() {
            return this.description;
        }

        public final int getIconRes() {
            return this.iconRes;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((((this.agentType.hashCode() * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + Integer.hashCode(this.iconRes);
        }

        public String toString() {
            return "RemoteAgentEntry(agentType=" + this.agentType + ", title=" + this.title + ", description=" + this.description + ", iconRes=" + this.iconRes + ")";
        }
    }

    static /* synthetic */ Fragment createConnectFragment$default(IExternalAgentUiService iExternalAgentUiService, String str, String str2, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createConnectFragment");
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return iExternalAgentUiService.createConnectFragment(str, str2);
    }

    void connectRemoteAgent(Context context, String agentType);

    Fragment createAgentMarketDetailFragment(MarketAgentBrief agent);

    Fragment createConnectFragment(String agentType, String displayName);

    Fragment createConnectedAgentsFragment();

    List<RemoteAgentEntry> getRemoteAgentEntries();

    boolean isCrossDeviceAuthorized(String agentType);

    g refreshRemoteAgentEntries(InterfaceC5074l<? super List<RemoteAgentEntry>, t> onUpdated);

    void showAddAgentSheet(ViewGroup host);

    void showCrossDeviceAuthDialog(ViewGroup host, String agentType, InterfaceC5063a<t> onAuthorized);
}
