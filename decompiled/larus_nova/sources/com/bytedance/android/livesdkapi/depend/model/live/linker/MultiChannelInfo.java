package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.bytedance.android.livesdk.link.model.bridge.s1;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.MultiChannelInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bRJ\u0010\u0010\u001a*\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0014\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/MultiChannelInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/s1;", "", "toString", "", "useMultiChannel", "Z", "getUseMultiChannel", "()Z", "setUseMultiChannel", "(Z)V", "", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "channelMap", "Ljava/util/Map;", "getChannelMap", "()Ljava/util/Map;", "setChannelMap", "(Ljava/util/Map;)V", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiChannelInfo extends FlexModelBase<s1> implements s1, h {

    @SerializedName("linkmic_infos")
    protected Map<Long, String> channelMap;

    @SerializedName("use_multi_channel")
    protected boolean useMultiChannel;

    public MultiChannelInfo() {
        super(s1.class);
        this.channelMap = new LinkedHashMap();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("MultiChannelInfo{");
        if (getUseMultiChannel() == false) goto L5;
        String r101 = "";
    L6:
        r100.append(r101);
        r100.append("channels=");
        Map<Long, String> r102 = getChannelMap();
        if (r102 == null) goto L9;
        Set<Long> r103 = r102.keySet();
    L10:
        r100.append(r103);
        r100.append('}');
        return r100.toString();
    L9:
        r103 = null;
        goto L10
    L5:
        r101 = "useMultiChannel=false,";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.s1
    public Map<Long, String> getChannelMap() {
        return this.channelMap;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.s1
    public boolean getUseMultiChannel() {
        return this.useMultiChannel;
    }

    public MultiChannelInfo(g r110) {
        super(s1.class);
        this.channelMap = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L27;
        g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 1) goto L8;
        this.useMultiChannel = am3.h.a(r110);
        goto L3
    L8:
        if (r101 != 2) goto L9;
        long r103 = r110.c();
        Long r104 = null;
        String r105 = null;
    L11:
        int r106 = r110.f();
        if (r106 == (-1)) goto L18;
        if (r106 != 1) goto L14;
        r104 = Long.valueOf(r110.j());
        goto L11
    L14:
        if (r106 != 2) goto L15;
        r105 = am3.h.c(r110);
        goto L11
    L15:
        am3.h.e(r110);
        goto L11
    L18:
        r110.d(r103);
        Map<Long, String> r107 = this.channelMap;
        if (r104 == null) goto L25;
        if (r105 == null) goto L23;
        r107.put(r104, r105);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.d(r102, r110);
        goto L3
    L27:
        r110.d(r100);
        setThreadSafe(true);
        if (this.channelMap != null) goto L51;
        this.channelMap = new LinkedHashMap();
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.s1
    public void setChannelMap(Map<Long, String> r100) {
        this.channelMap = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.s1
    public void setUseMultiChannel(boolean r100) {
        this.useMultiChannel = r100;
    }
}
