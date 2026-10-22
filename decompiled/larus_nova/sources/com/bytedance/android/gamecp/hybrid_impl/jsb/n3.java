package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R*\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/n3;", "", "", "react_id", "Ljava/lang/String;", "getReact_id", "()Ljava/lang/String;", "setReact_id", "(Ljava/lang/String;)V", "", "page", "Ljava/lang/Integer;", "getPage", "()Ljava/lang/Integer;", "setPage", "(Ljava/lang/Integer;)V", "", "has_more", "Ljava/lang/Boolean;", "getHas_more", "()Ljava/lang/Boolean;", "setHas_more", "(Ljava/lang/Boolean;)V", "clearOldData", "getClearOldData", "setClearOldData", "insert_before", "getInsert_before", "setInsert_before", "", "aweme_list", "Ljava/util/List;", "getAweme_list", "()Ljava/util/List;", "setAweme_list", "(Ljava/util/List;)V", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n3 {

    @SerializedName("aweme_list")
    private List<? extends Object> aweme_list;

    @SerializedName("clearOldData")
    private Boolean clearOldData;

    @SerializedName("has_more")
    private Boolean has_more;

    @SerializedName("insert_before")
    private Boolean insert_before;

    @SerializedName("page")
    private Integer page;

    @SerializedName("react_id")
    private String react_id;

    public n3() {
    }
}
