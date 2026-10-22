package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic_audience.UnSilenceResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b#\u0010$R*\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R0\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u0004\u0018\u00010\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001e¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/UnSilenceResponse;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/c2;", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "linkedUsers", "Ljava/util/List;", "getLinkedUsers", "()Ljava/util/List;", "setLinkedUsers", "(Ljava/util/List;)V", "", "version", "J", "getVersion", "()J", "setVersion", "(J)V", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/RoomLinkerContent;", "linkerContentMap", "Ljava/util/Map;", "getLinkerContentMap", "()Ljava/util/Map;", "setLinkerContentMap", "(Ljava/util/Map;)V", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "mClientUIInfo", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getMClientUIInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "setMClientUIInfo", "(Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;)V", "getClientUiInfo", "clientUiInfo", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UnSilenceResponse extends FlexModelBase<c2> implements c2, vh7.h {

    @SerializedName("linked_users")
    protected List<? extends com.bytedance.android.livesdk.link.model.bridge.k> linkedUsers;

    @SerializedName("linker_content_map")
    protected Map<Long, ? extends RoomLinkerContent> linkerContentMap;

    @SerializedName("client_ui_info")
    protected ClientUIInfo mClientUIInfo;

    @SerializedName("version")
    protected long version;

    public UnSilenceResponse() {
        super(c2.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.c2
    public ClientUIInfo getClientUiInfo() {
        return this.mClientUIInfo;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.c2
    public List<com.bytedance.android.livesdk.link.model.bridge.k> getLinkedUsers() {
        return this.linkedUsers;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.c2
    public Map<Long, RoomLinkerContent> getLinkerContentMap() {
        return this.linkerContentMap;
    }

    public final ClientUIInfo getMClientUIInfo() {
        return this.mClientUIInfo;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.c2
    public long getVersion() {
        return this.version;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdkapi.depend.message.ClientUIInfo, java.lang.Object] */
    public UnSilenceResponse(am3.g r110) {
        super(c2.class);
        this.linkedUsers = new ArrayList();
        this.linkerContentMap = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L33;
        am3.g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 2) goto L8;
        this.linkedUsers.add(vh7.f.a(r110, com.bytedance.android.livesdk.link.model.bridge.k.class));
        goto L3
    L8:
        if (r101 != 3) goto L10;
        this.version = r110.j();
        goto L3
    L10:
        if (r101 != 4) goto L12;
        long r103 = r110.c();
        Long r104 = null;
        RoomLinkerContent r105 = null;
    L16:
        int r106 = r110.f();
        if (r106 == (-1)) goto L23;
        if (r106 != 1) goto L19;
        r104 = Long.valueOf(r110.j());
        goto L16
    L19:
        if (r106 != 2) goto L20;
        r105 = com.bytedance.android.live.liveinteract.plantform.model.p1.a(r110);
        goto L16
    L20:
        am3.h.e(r110);
        goto L16
    L23:
        r110.d(r103);
        Map<Long, ? extends RoomLinkerContent> r107 = this.linkerContentMap;
        if (r104 == null) goto L30;
        if (r105 == null) goto L28;
        r107.put(r104, r105);
        goto L3
    L28:
        throw new IllegalStateException("Value must not be null");
    L30:
        throw new IllegalStateException("Key must not be null");
    L12:
        if (r101 != 5) goto L13;
        this.mClientUIInfo = vh7.f.a(r110, ClientUIInfo.class);
        goto L3
    L13:
        am3.h.d(r102, r110);
        goto L3
    L33:
        r110.d(r100);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.c2
    public void setLinkedUsers(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r100) {
        this.linkedUsers = r100;
    }

    public void setLinkerContentMap(Map<Long, ? extends RoomLinkerContent> r100) {
        this.linkerContentMap = r100;
    }

    public final void setMClientUIInfo(ClientUIInfo r100) {
        this.mClientUIInfo = r100;
    }

    public void setVersion(long r100) {
        this.version = r100;
    }
}
