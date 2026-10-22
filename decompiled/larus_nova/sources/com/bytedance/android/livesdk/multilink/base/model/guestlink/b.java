package com.bytedance.android.livesdk.multilink.base.model.guestlink;

import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u00020\r8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/multilink/base/model/guestlink/b;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/guestlink/a;", "getChannelInfo", "()Lcom/bytedance/android/live/base/model/message/guestlink/a;", "getChannelInfo$annotations", "()V", "channelInfo", "", "getStreamData", "()Ljava/lang/String;", "getStreamData$annotations", "streamData", "", "getCurrentTimeMs", "()J", "getCurrentTimeMs$annotations", "currentTimeMs", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b extends vh7.c<b> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "channel_info")
    com.bytedance.android.live.base.model.message.guestlink.a getChannelInfo();

    @FieldName(name = "current_time_ms")
    long getCurrentTimeMs();

    @FieldName(name = MiniAppConstants.KEY_MINI_APP_STREAM_DATA)
    String getStreamData();
}
