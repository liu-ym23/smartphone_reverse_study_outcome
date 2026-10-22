package com.stepos.ailauncher.foundation.appstore.api;

import Ac.f;
import Ac.s;
import Ac.t;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0003\u0010\u0006\u001a\u00020\u0005H§@¢\u0006\u0004\b\t\u0010\nJ \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\b\b\u0001\u0010\f\u001a\u00020\u000bH§@¢\u0006\u0004\b\u000e\u0010\u000fJ>\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00072\b\b\u0001\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u0012\u001a\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u00022\b\b\u0003\u0010\u0006\u001a\u00020\u0005H§@¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionListApi;", "", "", "page", "pageSize", "", "isAiIdea", "Lcom/stepos/ailauncher/foundation/appstore/api/AppStoreResponse;", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionListDto;", "versions", "(IIZLe9/c;)Ljava/lang/Object;", "", "appId", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionDetailDto;", "detail", "(JLe9/c;)Ljava/lang/Object;", "", "query", Parameters.OS, "start", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionSearchDto;", "search", "(Ljava/lang/String;IIZLe9/c;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface AppVersionListApi {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object search$default(AppVersionListApi appVersionListApi, String str, int i10, int i11, boolean z10, InterfaceC4014c interfaceC4014c, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: search");
        }
        if ((i12 & 8) != 0) {
            z10 = true;
        }
        return appVersionListApi.search(str, i10, i11, z10, interfaceC4014c);
    }

    static /* synthetic */ Object versions$default(AppVersionListApi appVersionListApi, int i10, int i11, boolean z10, InterfaceC4014c interfaceC4014c, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: versions");
        }
        if ((i12 & 4) != 0) {
            z10 = true;
        }
        return appVersionListApi.versions(i10, i11, z10, interfaceC4014c);
    }

    @f("apps/public/detail/{id}")
    Object detail(@s("id") long j10, InterfaceC4014c<? super AppStoreResponse<AppVersionDetailDto>> interfaceC4014c);

    @f("apps/public/search")
    Object search(@t("q") String str, @t(Parameters.OS) int i10, @t("start") int i11, @t("isAiIdea") boolean z10, InterfaceC4014c<? super AppStoreResponse<AppVersionSearchDto>> interfaceC4014c);

    @f("apps/public/versions")
    Object versions(@t("page") int i10, @t("pageSize") int i11, @t("isAiIdea") boolean z10, InterfaceC4014c<? super AppStoreResponse<AppVersionListDto>> interfaceC4014c);
}
