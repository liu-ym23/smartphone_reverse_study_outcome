package com.obric.appstore.network.entity;

import com.bytedanceos.common.model.AppInfo;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/appstore/network/entity/CommonBodyEntity;", "", "common", "Lcom/obric/appstore/network/entity/CommonParams;", "params", "Lcom/google/gson/JsonElement;", "(Lcom/obric/appstore/network/entity/CommonParams;Lcom/google/gson/JsonElement;)V", "getCommon", "()Lcom/obric/appstore/network/entity/CommonParams;", "getParams", "()Lcom/google/gson/JsonElement;", "setParams", "(Lcom/google/gson/JsonElement;)V", "component1", "component2", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CommonBodyEntity {

    @SerializedName("common")
    @NotNull
    private final CommonParams common;

    @SerializedName("params")
    @Nullable
    private JsonElement params;

    public CommonBodyEntity(@NotNull CommonParams r10, @Nullable JsonElement r11) {
        q.g(r10, "common");
        this.common = r10;
        this.params = r11;
    }

    public static /* synthetic */ CommonBodyEntity copy$default(CommonBodyEntity r10, CommonParams r11, JsonElement r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.common;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.params;
    L9:
        return r10.copy(r11, r12);
    }

    @NotNull
    public final CommonParams component1() {
        return this.common;
    }

    @Nullable
    public final JsonElement component2() {
        return this.params;
    }

    @NotNull
    public final CommonBodyEntity copy(@NotNull CommonParams r10, @Nullable JsonElement r11) {
        q.g(r10, "common");
        return new CommonBodyEntity(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof CommonBodyEntity) == true) goto L8;
        return false;
    L8:
        CommonBodyEntity r11 = (CommonBodyEntity) r10;
        if (q.b(this.common, r11.common) == true) goto L12;
        return false;
    L12:
        if (q.b(this.params, r11.params) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @NotNull
    public final CommonParams getCommon() {
        return this.common;
    }

    @Nullable
    public final JsonElement getParams() {
        return this.params;
    }

    public int hashCode() {
        int r10 = this.common.hashCode() * 31;
        JsonElement r11 = this.params;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public final void setParams(@Nullable JsonElement r10) {
        this.params = r10;
    }

    @NotNull
    public String toString() {
        return "CommonBodyEntity(common=" + this.common + ", params=" + this.params + ')';
    }

    public /* synthetic */ CommonBodyEntity(CommonParams r10, JsonElement r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }
}
