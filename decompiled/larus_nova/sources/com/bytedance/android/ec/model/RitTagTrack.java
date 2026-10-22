package com.bytedance.android.ec.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/model/RitTagTrack;", "Ljava/io/Serializable;", "()V", "eventParam", "Lcom/bytedance/android/ec/model/RightTagEventParam;", "getEventParam", "()Lcom/bytedance/android/ec/model/RightTagEventParam;", "tagCode", "", "getTagCode", "()Ljava/lang/String;", "visibile", "", "getVisibile", "()Z", "setVisibile", "(Z)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class RitTagTrack implements Serializable {

    @SerializedName("event_param")
    private final RightTagEventParam eventParam;

    @SerializedName("tag_code")
    private final String tagCode;
    private boolean visibile;

    public RitTagTrack() {
    }

    public final RightTagEventParam getEventParam() {
        return this.eventParam;
    }

    public final String getTagCode() {
        return this.tagCode;
    }

    public final boolean getVisibile() {
        return this.visibile;
    }

    public final void setVisibile(boolean r100) {
        this.visibile = r100;
    }
}
