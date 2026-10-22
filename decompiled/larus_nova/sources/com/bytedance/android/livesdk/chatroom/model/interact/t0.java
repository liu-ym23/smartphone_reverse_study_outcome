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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R*\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000f\u001a\u00020\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00168&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\t\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/t0;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "getLinkUsers", "()Ljava/util/List;", "setLinkUsers", "(Ljava/util/List;)V", "getLinkUsers$annotations", "()V", "linkUsers", "", "getVersion", "()J", "getVersion$annotations", "version", "", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "getLinkerContentMap", "()Ljava/util/Map;", "getLinkerContentMap$annotations", "linkerContentMap", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUiInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUiInfo$annotations", "clientUiInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface t0 extends vh7.c<t0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "client_ui_info")
    ClientUIInfo getClientUiInfo();

    @FieldName(name = "linked_users")
    List<? extends com.bytedance.android.livesdk.link.model.bridge.k> getLinkUsers();

    @FieldName(name = "linker_content_map")
    Map<Long, com.bytedance.android.livesdk.link.model.bridge.g2> getLinkerContentMap();

    @FieldName(name = "version")
    long getVersion();

    @FieldName(name = "linked_users#setter")
    void setLinkUsers(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r100);
}
