package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR0\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/VideoEqualRoomLiveCoreInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/l2;", "", "", "", "liveCoreInfoMap", "Ljava/util/Map;", "getLiveCoreInfoMap", "()Ljava/util/Map;", "setLiveCoreInfoMap", "(Ljava/util/Map;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoEqualRoomLiveCoreInfo extends FlexModelBase<com.bytedance.android.livesdk.link.model.bridge.l2> implements com.bytedance.android.livesdk.link.model.bridge.l2, vh7.h {

    @SerializedName("live_core_info_map")
    protected Map<Long, String> liveCoreInfoMap;

    public VideoEqualRoomLiveCoreInfo() {
        super(com.bytedance.android.livesdk.link.model.bridge.l2.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l2
    public Map<Long, String> getLiveCoreInfoMap() {
        return this.liveCoreInfoMap;
    }

    public VideoEqualRoomLiveCoreInfo(am3.g r110) {
        super(com.bytedance.android.livesdk.link.model.bridge.l2.class);
        this.liveCoreInfoMap = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L25;
        am3.g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 1) goto L7;
        long r103 = r110.c();
        Long r104 = null;
        String r105 = null;
    L9:
        int r106 = r110.f();
        if (r106 == (-1)) goto L17;
        if (r106 != 1) goto L13;
        r104 = Long.valueOf(r110.j());
        goto L9
    L13:
        if (r106 != 2) goto L14;
        r105 = am3.h.c(r110);
        goto L9
    L14:
        am3.h.e(r110);
        goto L9
    L17:
        r110.d(r103);
        Map<Long, String> r107 = this.liveCoreInfoMap;
        if (r104 == null) goto L24;
        if (r105 == null) goto L22;
        r107.put(r104, r105);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.d(r102, r110);
        goto L3
    L25:
        r110.d(r100);
        setThreadSafe(true);
    }

    public void setLiveCoreInfoMap(Map<Long, String> r100) {
        this.liveCoreInfoMap = r100;
    }
}
