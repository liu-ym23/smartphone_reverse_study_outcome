package com.obric.appstore.network.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/appstore/network/entity/LocalAppsOnlineReq;", "", "packages", "", "", "(Ljava/util/List;)V", "getPackages", "()Ljava/util/List;", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LocalAppsOnlineReq {

    @SerializedName("packages")
    @NotNull
    private final List<String> packages;

    /* JADX WARN: Multi-variable type inference failed */
    public LocalAppsOnlineReq() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    public final List<String> getPackages() {
        return this.packages;
    }

    public LocalAppsOnlineReq(@NotNull List<String> r10) {
        q.g(r10, "packages");
        this.packages = r10;
    }

    public /* synthetic */ LocalAppsOnlineReq(List r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = t.i();
    L5:
        this(r10);
    }
}
