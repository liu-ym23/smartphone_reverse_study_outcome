package com.obric.appstore.network.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/appstore/network/entity/CategoryResp;", "", "id", "", "name", "", "(JLjava/lang/String;)V", "getId", "()J", "getName", "()Ljava/lang/String;", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CategoryResp {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final long f10965id;

    @SerializedName("name")
    @NotNull
    private final String name;

    public CategoryResp() {
        long r10 = 0;
        String r11 = null;
        this(r10, r11, 3, null);
    }

    public final long getId() {
        return this.f10965id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public CategoryResp(long r10, @NotNull String r11) {
        q.g(r11, "name");
        this.f10965id = r10;
        this.name = r11;
    }

    public /* synthetic */ CategoryResp(long r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = "";
    L8:
        this(r10, r11);
    }
}
