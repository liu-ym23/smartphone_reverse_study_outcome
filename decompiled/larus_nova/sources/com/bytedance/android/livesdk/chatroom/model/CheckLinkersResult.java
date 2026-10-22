package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic_audience.CheckLinkersResponse.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u00060\u0003j\u0002`\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R(\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/CheckLinkersResult;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/u3;", "", "_sleepTime", "J", "get_sleepTime", "()J", "set_sleepTime", "(J)V", "", "", "_linkMicIds", "Ljava/util/List;", "get_linkMicIds", "()Ljava/util/List;", "set_linkMicIds", "(Ljava/util/List;)V", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getSleepTime", "sleepTime", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getLinkMicIds", "linkMicIds", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CheckLinkersResult extends FlexModelBase<com.bytedance.android.livesdk.link.model.u3> implements com.bytedance.android.livesdk.link.model.u3, vh7.h {

    @SerializedName("linkmic_id_str")
    protected List<String> _linkMicIds;

    @SerializedName("sleep_second")
    protected long _sleepTime;

    public CheckLinkersResult() {
        super(com.bytedance.android.livesdk.link.model.u3.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.u3
    public List<String> getLinkMicIds() {
        return this._linkMicIds;
    }

    @Override // com.bytedance.android.livesdk.link.model.u3
    public long getSleepTime() {
        return this._sleepTime;
    }

    public final List<String> get_linkMicIds() {
        return this._linkMicIds;
    }

    public final long get_sleepTime() {
        return this._sleepTime;
    }

    public CheckLinkersResult(am3.g r100) {
        super(com.bytedance.android.livesdk.link.model.u3.class);
        this._linkMicIds = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._linkMicIds.add(am3.h.c(r100));
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._sleepTime = r100.j();
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final void set_linkMicIds(List<String> r100) {
        this._linkMicIds = r100;
    }

    public final void set_sleepTime(long r100) {
        this._sleepTime = r100;
    }
}
