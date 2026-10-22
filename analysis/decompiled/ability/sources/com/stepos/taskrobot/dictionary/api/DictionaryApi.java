package com.stepos.taskrobot.dictionary.api;

import H7.c;
import com.stepos.agentframework.adapter.agentspace.AgentSpaceCoreAgentClient;
import com.stepos.taskrobot.dictionary.ApiResponse;
import com.stepos.taskrobot.dictionary.model.DictionaryItem;
import com.stepos.taskrobot.dictionary.model.GetKeyRequest;
import com.stepos.taskrobot.dictionary.model.LegacyDictionaryItem;
import com.stepos.taskrobot.dictionary.model.LegacyDictionaryRequest;
import com.stepos.taskrobot.dictionary.model.PagedResult;
import com.stepos.taskrobot.dictionary.model.PullKeysRequest;
import java.util.List;
import kotlin.Metadata;
import sa.InterfaceC1926a;
import sa.o;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J&\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\tH§@¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\rH§@¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/stepos/taskrobot/dictionary/api/DictionaryApi;", "", "Lcom/stepos/taskrobot/dictionary/model/LegacyDictionaryRequest;", "request", "Lcom/stepos/taskrobot/dictionary/ApiResponse;", "", "Lcom/stepos/taskrobot/dictionary/model/LegacyDictionaryItem;", "queryLegacy", "(Lcom/stepos/taskrobot/dictionary/model/LegacyDictionaryRequest;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/taskrobot/dictionary/model/GetKeyRequest;", "Lcom/stepos/taskrobot/dictionary/model/DictionaryItem;", "getKey", "(Lcom/stepos/taskrobot/dictionary/model/GetKeyRequest;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/taskrobot/dictionary/model/PullKeysRequest;", "Lcom/stepos/taskrobot/dictionary/model/PagedResult;", "pullKeys", "(Lcom/stepos/taskrobot/dictionary/model/PullKeysRequest;LH7/c;)Ljava/lang/Object;", "dictionary_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface DictionaryApi {
    @o("api/v1/get/key")
    Object getKey(@InterfaceC1926a GetKeyRequest getKeyRequest, c<? super ApiResponse<DictionaryItem>> cVar);

    @o("api/v1/pull/keys")
    Object pullKeys(@InterfaceC1926a PullKeysRequest pullKeysRequest, c<? super ApiResponse<PagedResult<DictionaryItem>>> cVar);

    @o(AgentSpaceCoreAgentClient.CONFIG_QUERY_PATH)
    Object queryLegacy(@InterfaceC1926a LegacyDictionaryRequest legacyDictionaryRequest, c<? super ApiResponse<List<LegacyDictionaryItem>>> cVar);
}
