package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/format/model/UserInteractResponse;", "Ljava/io/Serializable;", "()V", "text", "", "getText", "()Ljava/lang/String;", "vfxId", "getVfxId", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInteractResponse implements Serializable {

    @SerializedName("text")
    private final String text;

    @SerializedName("vfx_id")
    private final String vfxId;

    public UserInteractResponse() {
    }

    public final String getText() {
        return this.text;
    }

    public final String getVfxId() {
        return this.vfxId;
    }
}
