package com.bytedance.android.live.base.model.message.guestlink;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017R6\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0012\u001a\u00020\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0016\u001a\u00020\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/f;", "Lvh7/c;", "", "Lcom/bytedance/android/live/base/model/message/guestlink/f$b;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getInviterList", "()Ljava/util/List;", "setInviterList", "(Ljava/util/List;)V", "getInviterList$annotations", "()V", "inviterList", "", "getCallDuration", "()J", "setCallDuration", "(J)V", "getCallDuration$annotations", "callDuration", "getLinkThreshold", "setLinkThreshold", "getLinkThreshold$annotations", "linkThreshold", "b", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface f extends vh7.c<f> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/f$b;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/guestlink/k;", "getInviterInfo", "()Lcom/bytedance/android/live/base/model/message/guestlink/k;", "setInviterInfo", "(Lcom/bytedance/android/live/base/model/message/guestlink/k;)V", "getInviterInfo$annotations", "()V", "inviterInfo", "", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "getSource$annotations", "source", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface b extends vh7.c<b> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        @FieldName(name = "inviter_info")
        k getInviterInfo();

        @FieldName(name = "source")
        String getSource();

        @FieldName(name = "inviter_info#setter")
        void setInviterInfo(k r100);

        @FieldName(name = "source#setter")
        void setSource(String r100);
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "call_duration")
    long getCallDuration();

    @FieldName(name = "inviter_list")
    List<b> getInviterList();

    @FieldName(name = "link_threshold")
    long getLinkThreshold();

    @FieldName(name = "call_duration#setter")
    void setCallDuration(long r100);

    @FieldName(name = "inviter_list#setter")
    void setInviterList(List<? extends b> r100);

    @FieldName(name = "link_threshold#setter")
    void setLinkThreshold(long r100);
}
