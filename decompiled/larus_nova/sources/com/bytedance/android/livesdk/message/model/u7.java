package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003R\"\u0010\u000b\u001a\u00020\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0012\u001a\u00020\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0016\u001a\u00020\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bRB\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u0001`\u00188&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001d\u0010\n\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/u7;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "", "getUserId", "()J", "setUserId", "(J)V", "getUserId$annotations", "()V", "userId", "", "getRecipientUserOpenId", "()Ljava/lang/String;", "setRecipientUserOpenId", "(Ljava/lang/String;)V", "getRecipientUserOpenId$annotations", "recipientUserOpenId", "getReason", "setReason", "getReason$annotations", "reason", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "getExtra$annotations", "extra", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface u7 extends vh7.c<u7>, yh6.c {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @FieldName(name = "extra")
    Map<String, String> getExtra();

    @FieldName(name = "change_reason_enum")
    long getReason();

    @FieldName(name = "recipient_user_open_id")
    String getRecipientUserOpenId();

    @FieldName(name = "recipient_user_id")
    long getUserId();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);

    @FieldName(name = "extra#setter")
    void setExtra(Map<String, String> r100);

    @FieldName(name = "change_reason_enum#setter")
    void setReason(long r100);

    @FieldName(name = "recipient_user_open_id#setter")
    void setRecipientUserOpenId(String r100);

    @FieldName(name = "recipient_user_id#setter")
    void setUserId(long r100);
}
