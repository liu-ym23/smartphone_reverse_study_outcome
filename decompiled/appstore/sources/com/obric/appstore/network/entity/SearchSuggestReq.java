package com.obric.appstore.network.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/appstore/network/entity/SearchSuggestReq;", "", "kwd", "", "(Ljava/lang/String;)V", "getKwd", "()Ljava/lang/String;", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SearchSuggestReq {

    @SerializedName("kwd")
    @NotNull
    private final String kwd;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchSuggestReq() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    public final String getKwd() {
        return this.kwd;
    }

    public SearchSuggestReq(@NotNull String r10) {
        q.g(r10, "kwd");
        this.kwd = r10;
    }

    public /* synthetic */ SearchSuggestReq(String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = "";
    L5:
        this(r10);
    }
}
