package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/r;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "", "getFromOpenUserId", "()Ljava/lang/String;", "getFromOpenUserId$annotations", "()V", "fromOpenUserId", "getToOpenUserId", "getToOpenUserId$annotations", "toOpenUserId", "", "getFromUserId", "()J", "getFromUserId$annotations", "fromUserId", "getToUserId", "getToUserId$annotations", "toUserId", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface r extends vh7.c<r>, yh6.c {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @FieldName(name = "from_open_id")
    String getFromOpenUserId();

    @FieldName(name = "from_user_id")
    long getFromUserId();

    @FieldName(name = "to_open_id")
    String getToOpenUserId();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID)
    long getToUserId();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
