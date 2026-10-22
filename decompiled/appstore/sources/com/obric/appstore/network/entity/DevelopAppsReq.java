package com.obric.appstore.network.entity;

import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/obric/appstore/network/entity/DevelopAppsReq;", "Lcom/obric/appstore/network/entity/PageReq;", "deverId", "", ServerElements.DEVELOPER, "page", "", "size", "(Ljava/lang/String;Ljava/lang/String;II)V", "getDeveloper", "()Ljava/lang/String;", "getDeverId", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DevelopAppsReq extends PageReq {

    @SerializedName(ServerElements.DEVELOPER)
    @NotNull
    private final String developer;

    @SerializedName(ServerElements.DEVER_ID)
    @NotNull
    private final String deverId;

    public DevelopAppsReq() {
        String r10 = null;
        String r11 = null;
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 15, null);
    }

    @NotNull
    public final String getDeveloper() {
        return this.developer;
    }

    @NotNull
    public final String getDeverId() {
        return this.deverId;
    }

    public /* synthetic */ DevelopAppsReq(String r10, String r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = "";
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = "";
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = 1;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = 20;
    L14:
        this(r10, r11, r12, r13);
    }

    public DevelopAppsReq(@NotNull String r10, @NotNull String r11, int r12, int r13) {
        q.g(r10, "deverId");
        q.g(r11, ServerElements.DEVELOPER);
        super(r12, r13);
        this.deverId = r10;
        this.developer = r11;
    }
}
