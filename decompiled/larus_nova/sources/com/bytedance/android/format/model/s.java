package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/format/model/s;", "", "", "dimensionId", "Ljava/lang/Integer;", "getDimensionId", "()Ljava/lang/Integer;", "", "preText", "Ljava/lang/String;", "getPreText", "()Ljava/lang/String;", com.bytedance.android.livesdk.gift.model.n.KEY_SUB_TEXT, "getSubText", "serverExtra", "getServerExtra", "enName", "getEnName", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("dimension_id")
    private final Integer dimensionId;

    @SerializedName("en_name")
    private final String enName;

    @SerializedName("pre_text")
    private final String preText;

    @SerializedName("server_extra")
    private final String serverExtra;

    @SerializedName("sub_text")
    private final String subText;

    public s() {
    }
}
