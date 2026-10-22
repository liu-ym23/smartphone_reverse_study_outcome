package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R6\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\u0010\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR:\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\n\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010!\u001a\u0004\u0018\u00010\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\n\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/r1;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getLinkedUsers", "()Ljava/util/List;", "setLinkedUsers", "(Ljava/util/List;)V", "getLinkedUsers$annotations", "()V", "linkedUsers", "", "getVersion", "()J", "getVersion$annotations", "version", "", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getLinkerContentMap", "()Ljava/util/Map;", "getLinkerContentMap$annotations", "linkerContentMap", "", "getAckMessage", "()Ljava/lang/String;", "getAckMessage$annotations", "ackMessage", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUiInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUiInfo$annotations", "clientUiInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface r1 extends vh7.c<r1> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "ack_message")
    String getAckMessage();

    @FieldName(name = "client_ui_info")
    ClientUIInfo getClientUiInfo();

    @FieldName(name = "linked_users")
    List<com.bytedance.android.livesdk.link.model.bridge.k> getLinkedUsers();

    @FieldName(name = "linker_content_map")
    Map<Long, com.bytedance.android.livesdk.link.model.bridge.g2> getLinkerContentMap();

    @FieldName(name = "version")
    long getVersion();

    @FieldName(name = "linked_users#setter")
    void setLinkedUsers(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r100);
}
