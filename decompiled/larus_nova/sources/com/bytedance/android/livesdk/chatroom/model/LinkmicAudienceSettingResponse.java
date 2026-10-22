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
@ProtoMessage("webcast.api.linkmic_audience.GetAudienceSettingsResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000b\u0010\fR*\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/LinkmicAudienceSettingResponse;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/h1;", "", "Lcom/bytedance/android/livesdk/chatroom/model/LinkmicAudienceSetting;", "settings", "Ljava/util/List;", "getSettings", "()Ljava/util/List;", "setSettings", "(Ljava/util/List;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkmicAudienceSettingResponse extends FlexModelBase<h1> implements h1, vh7.h {

    @SerializedName("settings")
    protected List<LinkmicAudienceSetting> settings;

    public LinkmicAudienceSettingResponse() {
        super(h1.class);
    }

    public LinkmicAudienceSettingResponse(am3.g r100) {
        super(h1.class);
        this.settings = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this.settings.add(new LinkmicAudienceSetting(r100));
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.h1
    public List<LinkmicAudienceSetting> getSettings() {
        return this.settings;
    }

    public void setSettings(List<LinkmicAudienceSetting> r100) {
        this.settings = r100;
    }
}
