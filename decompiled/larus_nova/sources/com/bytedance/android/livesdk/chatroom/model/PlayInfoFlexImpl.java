package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.ChorusCDNInfo.PlayInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/PlayInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/s2;", "", "<set-?>", "streamData$delegate", "Ljava/lang/Object;", "getStreamData", "()Ljava/lang/String;", "setStreamData", "(Ljava/lang/String;)V", "streamData", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PlayInfoFlexImpl extends FlexModelBase<s2> implements s2, vh7.h {

    @SerializedName(MiniAppConstants.KEY_MINI_APP_STREAM_DATA)
    protected String _$$streamData;

    public PlayInfoFlexImpl() {
        super(s2.class);
    }

    public PlayInfoFlexImpl(am3.g r100) {
        super(s2.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this._$$streamData = am3.h.c(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.s2
    public final String getStreamData() {
        return this._$$streamData;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.s2
    public final void setStreamData(String r100) {
        this._$$streamData = r100;
    }
}
