package com.bytedance.android.shopping.store.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.store.search.repository.dto.LogPbDTO;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import sj3.i;
import sj3.p;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/store/repository/dto/StoreSearchSugResponseDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Ljava/io/Serializable;", "", "Lsj3/i;", "sugList", "Ljava/util/List;", "getSugList", "()Ljava/util/List;", "Lsj3/p;", "wordsQueryRecord", "Lsj3/p;", "getWordsQueryRecord", "()Lsj3/p;", "Lcom/bytedance/android/ec/store/search/repository/dto/LogPbDTO;", "logPb", "Lcom/bytedance/android/ec/store/search/repository/dto/LogPbDTO;", "getLogPb", "()Lcom/bytedance/android/ec/store/search/repository/dto/LogPbDTO;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreSearchSugResponseDTO extends CommerceBaseResponse {

    @SerializedName("log_pb")
    private final LogPbDTO logPb;

    @SerializedName("sug_list")
    private final List<i> sugList;

    @SerializedName("words_query_record")
    private final p wordsQueryRecord;

    public StoreSearchSugResponseDTO() {
    }

    public final LogPbDTO getLogPb() {
        return this.logPb;
    }

    public final List<i> getSugList() {
        return this.sugList;
    }

    public final p getWordsQueryRecord() {
        return this.wordsQueryRecord;
    }
}
