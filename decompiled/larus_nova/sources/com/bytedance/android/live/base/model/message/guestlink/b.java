package com.bytedance.android.live.base.model.message.guestlink;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/b;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/guestlink/a;", "getChannelInfo", "()Lcom/bytedance/android/live/base/model/message/guestlink/a;", "setChannelInfo", "(Lcom/bytedance/android/live/base/model/message/guestlink/a;)V", "getChannelInfo$annotations", "()V", "channelInfo", "", "getCurrentTimeMs", "()J", "setCurrentTimeMs", "(J)V", "getCurrentTimeMs$annotations", "currentTimeMs", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b extends vh7.c<b> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "channel_info")
    com.bytedance.android.live.base.model.message.guestlink.a getChannelInfo();

    @FieldName(name = "current_time_ms")
    long getCurrentTimeMs();

    @FieldName(name = "channel_info#setter")
    void setChannelInfo(com.bytedance.android.live.base.model.message.guestlink.a r100);

    @FieldName(name = "current_time_ms#setter")
    void setCurrentTimeMs(long r100);
}
