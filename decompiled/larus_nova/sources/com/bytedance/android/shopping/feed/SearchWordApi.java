package com.bytedance.android.shopping.feed;

import com.byted.cast.common.auth.AuthConstants;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0002H'¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/feed/SearchWordApi;", "", "", "businessId", "pd", "fromGroupId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/shopping/feed/o;", "getSuggestWord", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface SearchWordApi {
    @GET("/api/suggest_words/")
    Observable<o> getSuggestWord(@Query(AuthConstants.PARAM_KEY_LICENSE_BUSINESS_ID) String r100, @Query("pd") String r101, @Query(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID) String r102);
}
