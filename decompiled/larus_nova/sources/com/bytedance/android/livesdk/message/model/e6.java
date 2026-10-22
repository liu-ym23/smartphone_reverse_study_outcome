package com.bytedance.android.livesdk.message.model;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003J\b\u0010\u0005\u001a\u00020\u0004H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/e6;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "", ReportConstant.COMMON_ACTION_TYPE, "Lcom/bytedance/android/live/base/model/user/j;", "vipInfo", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface e6 extends vh7.c<e6>, yh6.c {
    int actionType();

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);

    com.bytedance.android.live.base.model.user.j vipInfo();
}
