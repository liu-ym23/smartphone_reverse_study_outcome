package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/format/model/ImageXTokenResponse;", "Ljava/io/Serializable;", "()V", "accessKeyId", "", "getAccessKeyId", "()Ljava/lang/String;", "currentTime", "getCurrentTime", "expiredTime", "getExpiredTime", "secretAccessKey", "getSecretAccessKey", "sessionToken", "getSessionToken", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageXTokenResponse implements Serializable {

    @SerializedName("access_key_id")
    private final String accessKeyId;

    @SerializedName("current_time")
    private final String currentTime;

    @SerializedName("expired_time")
    private final String expiredTime;

    @SerializedName("secret_access_key")
    private final String secretAccessKey;

    @SerializedName("session_token")
    private final String sessionToken;

    public ImageXTokenResponse() {
    }

    public final String getAccessKeyId() {
        return this.accessKeyId;
    }

    public final String getCurrentTime() {
        return this.currentTime;
    }

    public final String getExpiredTime() {
        return this.expiredTime;
    }

    public final String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    public final String getSessionToken() {
        return this.sessionToken;
    }
}
