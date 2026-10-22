package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003R\u0014\u0010\u0007\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\r\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0013\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/oa;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "", "getLotteryId", "()J", "lotteryId", "getLotteryType", "lotteryType", "", "getIcon", "()Ljava/lang/String;", "icon", "getTitle", "title", "getSchema", "schema", "getToast", "toast", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface oa extends vh7.c<oa>, yh6.c {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    String getIcon();

    long getLotteryId();

    long getLotteryType();

    String getSchema();

    String getTitle();

    String getToast();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
