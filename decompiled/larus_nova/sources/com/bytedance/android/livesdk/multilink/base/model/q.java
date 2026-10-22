package com.bytedance.android.livesdk.multilink.base.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/multilink/base/model/q;", "Lvh7/c;", "", "getMessageType", "()I", "getMessageType$annotations", "()V", "messageType", "", "getChannelId", "()J", "getChannelId$annotations", RemoteMessageConst.Notification.CHANNEL_ID, "", "getMockFilterUidList", "()Ljava/util/List;", "getMockFilterUidList$annotations", "mockFilterUidList", "Lcom/bytedance/android/livesdk/multilink/base/model/a0;", "getUpdateLinkStatusContent", "()Lcom/bytedance/android/livesdk/multilink/base/model/a0;", "getUpdateLinkStatusContent$annotations", "updateLinkStatusContent", "Lcom/bytedance/android/livesdk/multilink/base/model/z;", "getKickOutContent", "()Lcom/bytedance/android/livesdk/multilink/base/model/z;", "getKickOutContent$annotations", "kickOutContent", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface q extends vh7.c<q> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "channel_id")
    long getChannelId();

    @FieldName(name = "kick_out_content")
    z getKickOutContent();

    @FieldName(name = "message_type")
    int getMessageType();

    @FieldName(name = "filter_uids")
    List<Long> getMockFilterUidList();

    @FieldName(name = "update_link_status_content")
    a0 getUpdateLinkStatusContent();
}
