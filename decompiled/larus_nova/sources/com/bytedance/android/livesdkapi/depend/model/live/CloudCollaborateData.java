package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.CloudCollaborateData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/CloudCollaborateData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ICloudCollaborateData;", "()V", "collaborateRoomId", "", "getCollaborateRoomId", "()J", "setCollaborateRoomId", "(J)V", "collaborateRoomIdString", "", "getCollaborateRoomIdString", "()Ljava/lang/String;", "setCollaborateRoomIdString", "(Ljava/lang/String;)V", "jumpCollaborateRoomTime", "getJumpCollaborateRoomTime", "setJumpCollaborateRoomTime", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CloudCollaborateData extends FlexModelBase<ICloudCollaborateData> implements ICloudCollaborateData, h {

    @SerializedName("collaborate_room_id")
    protected long collaborateRoomId;

    @SerializedName("collaborate_room_id_str")
    protected String collaborateRoomIdString;

    @SerializedName("rejoin_time")
    protected long jumpCollaborateRoomTime;

    public CloudCollaborateData() {
        super(ICloudCollaborateData.class);
        this.collaborateRoomIdString = "";
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ICloudCollaborateData
    public long getCollaborateRoomId() {
        return this.collaborateRoomId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ICloudCollaborateData
    public String getCollaborateRoomIdString() {
        return this.collaborateRoomIdString;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ICloudCollaborateData
    public long getJumpCollaborateRoomTime() {
        return this.jumpCollaborateRoomTime;
    }

    public CloudCollaborateData(g r100) {
        super(ICloudCollaborateData.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.collaborateRoomId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.collaborateRoomIdString = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.jumpCollaborateRoomTime = r100.j();
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this.collaborateRoomIdString != null) goto L31;
        this.collaborateRoomIdString = "";
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ICloudCollaborateData
    public void setCollaborateRoomId(long r100) {
        this.collaborateRoomId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ICloudCollaborateData
    public void setCollaborateRoomIdString(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.collaborateRoomIdString = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ICloudCollaborateData
    public void setJumpCollaborateRoomTime(long r100) {
        this.jumpCollaborateRoomTime = r100;
    }
}
