package com.bytedance.android.livesdk.business.douplus;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J1\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/business/douplus/ItemCheckApi;", "", "getDouShopEntryUrl", "Lcom/bytedance/android/livesdk/business/douplus/DouShopEntryResponse;", "itemType", "", "screenType", "secAnchorId", "", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ItemCheckApi {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.business.douplus.ItemCheckApi$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Object getDouShopEntryUrl$default(ItemCheckApi r100, int r101, int r102, String r103, Continuation r104, int r105, Object r106) {
            if (r106 != null) goto L15;
            if ((r105 & 1) == 0) goto L7;
            r101 = 2;
        L7:
            if ((r105 & 2) == 0) goto L10;
            r102 = 2;
        L10:
            if ((r105 & 4) == 0) goto L13;
            r103 = "";
        L13:
            return r100.getDouShopEntryUrl(r101, r102, r103, r104);
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDouShopEntryUrl");
        }
    }

    @GET("https://aweme.snssdk.com/aweme/ecp/douplus/item/check/")
    Object getDouShopEntryUrl(@Query(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE) int r100, @Query("screen_type") int r101, @Query("sec_anchor_id") String r102, Continuation<? super DouShopEntryResponse> r103);
}
