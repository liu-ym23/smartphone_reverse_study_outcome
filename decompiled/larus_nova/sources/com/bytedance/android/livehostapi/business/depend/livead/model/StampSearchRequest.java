package com.bytedance.android.livehostapi.business.depend.livead.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSearchRequest;", "", "()V", "keyword", "", "getKeyword", "()Ljava/lang/String;", "setKeyword", "(Ljava/lang/String;)V", "type", "", "getType", "()J", "setType", "(J)V", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StampSearchRequest {

    @SerializedName("keyword")
    private String keyword;

    @SerializedName("type")
    private long type;

    public StampSearchRequest() {
        this.keyword = "";
    }

    public final String getKeyword() {
        return this.keyword;
    }

    public final long getType() {
        return this.type;
    }

    public final void setKeyword(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.keyword = r100;
    }

    public final void setType(long r100) {
        this.type = r100;
    }
}
