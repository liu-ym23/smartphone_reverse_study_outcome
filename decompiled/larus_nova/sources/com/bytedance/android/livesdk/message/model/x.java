package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/x;", "", "", "gameId", "J", "gameKind", "", "appId", "Ljava/lang/String;", "extra", "", "showInPrimaryEntrance", "Z", "schemaUrl", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x {

    @SerializedName("app_id")
    public String appId;

    @SerializedName("extra")
    public String extra;

    @SerializedName("game_id")
    public long gameId;

    @SerializedName("game_kind")
    public long gameKind;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL)
    public String schemaUrl;

    @SerializedName("display_in_primary_entrance")
    public boolean showInPrimaryEntrance;

    public x() {
        this.appId = "";
        this.schemaUrl = "";
    }
}
