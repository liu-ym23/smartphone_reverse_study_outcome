package com.bytedance.android.marketing.sdk.impl.api;

import androidx.core.app.NotificationCompat;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements Callback<MarketingResourceResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f162700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f162701b;

    public a(Function2 r100, Function1 r101) {
        this.f162700a = r100;
        this.f162701b = r101;
    }

    @Override // com.bytedance.retrofit2.Callback
    public final void onFailure(Call<MarketingResourceResponse> r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r101, "t");
        Function1 r102 = this.f162701b;
        String r103 = r101.getMessage();
        if (r103 != null) goto L5;
        r103 = "fetch error";
    L5:
        r102.invoke(r103);
    }

    @Override // com.bytedance.retrofit2.Callback
    public final void onResponse(Call<MarketingResourceResponse> r100, SsResponse<MarketingResourceResponse> r101) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r101, "response");
        Iterator<T> r102 = r101.headers().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((Header) r103).getName(), NetResponse.HEADER_KEY_LOG_ID) == false) goto L4;
    L9:
        Header r104 = (Header) r103;
        if (r104 == null) goto L13;
        String r105 = r104.getValue();
        if (r105 == null) goto L13;
    L14:
        this.f162700a.invoke(r101.body(), r105);
        return;
    L13:
        r105 = "";
        goto L14
    L8:
        r103 = null;
        goto L9
    }
}
