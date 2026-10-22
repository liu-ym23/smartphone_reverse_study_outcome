package com.bytedance.android.live.liveinteract.chatroom.chatroom.model;

import am3.g;
import com.bytedance.android.livesdk.multilink.base.model.j;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R0\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/model/GetPositionPanelResponse;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/j;", "", "", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/model/PositionItem;", "positionMap", "Ljava/util/Map;", "getPositionMap", "()Ljava/util/Map;", "setPositionMap", "(Ljava/util/Map;)V", "", "userPosition", "I", "getUserPosition", "()I", "setUserPosition", "(I)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GetPositionPanelResponse extends FlexModelBase<j> implements j, h {

    @SerializedName("position_map")
    protected Map<Long, PositionItem> positionMap;

    @SerializedName("user_position")
    protected int userPosition;

    public GetPositionPanelResponse() {
        super(j.class);
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.j
    public Map<Long, PositionItem> getPositionMap() {
        return this.positionMap;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.j
    public int getUserPosition() {
        return this.userPosition;
    }

    public GetPositionPanelResponse(g r110) {
        super(j.class);
        this.positionMap = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L28;
        g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 1) goto L8;
        long r103 = r110.c();
        Long r104 = null;
        PositionItem r105 = null;
    L12:
        int r106 = r110.f();
        if (r106 == (-1)) goto L20;
        if (r106 != 1) goto L16;
        r104 = Long.valueOf(r110.j());
        goto L12
    L16:
        if (r106 != 2) goto L17;
        r105 = new PositionItem(r110);
        goto L12
    L17:
        am3.h.e(r110);
        goto L12
    L20:
        r110.d(r103);
        Map<Long, PositionItem> r107 = this.positionMap;
        if (r104 == null) goto L27;
        if (r105 == null) goto L25;
        r107.put(r104, r105);
        goto L3
    L25:
        throw new IllegalStateException("Value must not be null");
    L27:
        throw new IllegalStateException("Key must not be null");
    L8:
        if (r101 != 4) goto L9;
        this.userPosition = (int) r110.j();
        goto L3
    L9:
        am3.h.d(r102, r110);
        goto L3
    L28:
        r110.d(r100);
        setThreadSafe(true);
    }

    public void setPositionMap(Map<Long, PositionItem> r100) {
        this.positionMap = r100;
    }

    public void setUserPosition(int r100) {
        this.userPosition = r100;
    }
}
