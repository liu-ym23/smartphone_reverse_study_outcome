package com.bytedanceos.appstore.buss.entity.netwrap;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.JsonElement;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/netwrap/NetBodyEntity;", "", ServerElements.HEAD, "Lcom/bytedanceos/appstore/buss/entity/netwrap/NetBodyEntityHead;", ServerElements.BODY, "Lcom/google/gson/JsonElement;", "(Lcom/bytedanceos/appstore/buss/entity/netwrap/NetBodyEntityHead;Lcom/google/gson/JsonElement;)V", "getBody", "()Lcom/google/gson/JsonElement;", "setBody", "(Lcom/google/gson/JsonElement;)V", "getHead", "()Lcom/bytedanceos/appstore/buss/entity/netwrap/NetBodyEntityHead;", "component1", "component2", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NetBodyEntity {

    @Nullable
    private JsonElement body;

    @NotNull
    private final NetBodyEntityHead head;

    public NetBodyEntity(@NotNull NetBodyEntityHead r10, @Nullable JsonElement r11) {
        q.g(r10, ServerElements.HEAD);
        this.head = r10;
        this.body = r11;
    }

    public static /* synthetic */ NetBodyEntity copy$default(NetBodyEntity r10, NetBodyEntityHead r11, JsonElement r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.head;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.body;
    L9:
        return r10.copy(r11, r12);
    }

    @NotNull
    public final NetBodyEntityHead component1() {
        return this.head;
    }

    @Nullable
    public final JsonElement component2() {
        return this.body;
    }

    @NotNull
    public final NetBodyEntity copy(@NotNull NetBodyEntityHead r10, @Nullable JsonElement r11) {
        q.g(r10, ServerElements.HEAD);
        return new NetBodyEntity(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof NetBodyEntity) == true) goto L8;
        return false;
    L8:
        NetBodyEntity r11 = (NetBodyEntity) r10;
        if (q.b(this.head, r11.head) == true) goto L12;
        return false;
    L12:
        if (q.b(this.body, r11.body) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final JsonElement getBody() {
        return this.body;
    }

    @NotNull
    public final NetBodyEntityHead getHead() {
        return this.head;
    }

    public int hashCode() {
        int r10 = this.head.hashCode() * 31;
        JsonElement r11 = this.body;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public final void setBody(@Nullable JsonElement r10) {
        this.body = r10;
    }

    @NotNull
    public String toString() {
        return "NetBodyEntity(head=" + this.head + ", body=" + this.body + ')';
    }

    public /* synthetic */ NetBodyEntity(NetBodyEntityHead r10, JsonElement r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }
}
