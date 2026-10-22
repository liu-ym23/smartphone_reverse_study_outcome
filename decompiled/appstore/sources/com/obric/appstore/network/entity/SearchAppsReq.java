package com.obric.appstore.network.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/appstore/network/entity/SearchAppsReq;", "Lcom/obric/appstore/network/entity/PageReq;", "kwd", "", "page", "", "size", "(Ljava/lang/String;II)V", "getKwd", "()Ljava/lang/String;", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SearchAppsReq extends PageReq {

    @SerializedName("kwd")
    @NotNull
    private final String kwd;

    public SearchAppsReq() {
        String r10 = null;
        int r11 = 0;
        int r12 = 0;
        this(r10, r11, r12, 7, null);
    }

    @NotNull
    public final String getKwd() {
        return this.kwd;
    }

    public /* synthetic */ SearchAppsReq(String r10, int r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = "";
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = 1;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = 20;
    L11:
        this(r10, r11, r12);
    }

    public SearchAppsReq(@NotNull String r10, int r11, int r12) {
        q.g(r10, "kwd");
        super(r11, r12);
        this.kwd = r10;
    }
}
