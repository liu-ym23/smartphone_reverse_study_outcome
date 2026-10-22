package com.bytedance.android.livesdkapi.drawer;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/drawer/UpdateDrawerEntranceEvent;", "", "businessType", "", "extra", "Lorg/json/JSONObject;", "(ILorg/json/JSONObject;)V", "getBusinessType", "()I", "setBusinessType", "(I)V", "getExtra", "()Lorg/json/JSONObject;", "setExtra", "(Lorg/json/JSONObject;)V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UpdateDrawerEntranceEvent {
    private int businessType;
    private JSONObject extra;

    public final int getBusinessType() {
        return this.businessType;
    }

    public final JSONObject getExtra() {
        return this.extra;
    }

    public final void setBusinessType(int r100) {
        this.businessType = r100;
    }

    public final void setExtra(JSONObject r100) {
        this.extra = r100;
    }

    public UpdateDrawerEntranceEvent(int r100, JSONObject r101) {
        this.businessType = r100;
        this.extra = r101;
    }
}
