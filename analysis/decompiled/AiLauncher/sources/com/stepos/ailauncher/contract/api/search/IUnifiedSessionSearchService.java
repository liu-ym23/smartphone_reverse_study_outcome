package com.stepos.ailauncher.contract.api.search;

import com.stepos.ailauncher.contract.model.search.SidebarSession;
import com.stepos.ailauncher.contract.model.search.UnifiedSearchResult;
import e9.InterfaceC4014c;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H¦@¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH¦@¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0006H¦@¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/search/IUnifiedSessionSearchService;", "", "", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "getSessionList", "(Le9/c;)Ljava/lang/Object;", "", "query", "", "limitPerGroup", "Lcom/stepos/ailauncher/contract/model/search/UnifiedSearchResult;", "search", "(Ljava/lang/String;ILe9/c;)Ljava/lang/Object;", "taskId", "LY8/t;", "markTaskRead", "(Ljava/lang/String;)V", "sessionId", "markSessionCompletedTasksRead", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IUnifiedSessionSearchService {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object search$default(IUnifiedSessionSearchService iUnifiedSessionSearchService, String str, int i10, InterfaceC4014c interfaceC4014c, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: search");
        }
        if ((i11 & 2) != 0) {
            i10 = 20;
        }
        return iUnifiedSessionSearchService.search(str, i10, interfaceC4014c);
    }

    Object getSessionList(InterfaceC4014c<? super List<SidebarSession>> interfaceC4014c);

    Object markSessionCompletedTasksRead(String str, InterfaceC4014c<? super Integer> interfaceC4014c);

    void markTaskRead(String taskId);

    Object search(String str, int i10, InterfaceC4014c<? super UnifiedSearchResult> interfaceC4014c);
}
