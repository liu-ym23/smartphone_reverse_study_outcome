package com.bytedance.android.shopping.deepfeed.slice.view.lottie;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\u0005\u001a\u00020\u0004H'¨\u0006\t"}, d2 = {"com/bytedance/android/shopping/deepfeed/slice/view/lottie/DeepFeedLottieFontCache$DeepFeedLottieFontApi", "", "", "url", "", "maxLength", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "getFont", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
interface DeepFeedLottieFontCache$DeepFeedLottieFontApi {
    @GET
    Call<TypedInput> getFont(@Url String r100, @MaxLength int r101);
}
