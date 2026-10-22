package com.stepos.ailauncher.foundation.appui.card.provider.didi.api;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiOrderPayloadDto;", "", "structuredContent", "Lcom/google/gson/JsonObject;", "<init>", "(Lcom/google/gson/JsonObject;)V", "getStructuredContent", "()Lcom/google/gson/JsonObject;", "component1", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DidiOrderPayloadDto {

    @SerializedName("structuredContent")
    private final JsonObject structuredContent;

    /* JADX WARN: Multi-variable type inference failed */
    public DidiOrderPayloadDto() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DidiOrderPayloadDto copy$default(DidiOrderPayloadDto didiOrderPayloadDto, JsonObject jsonObject, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            jsonObject = didiOrderPayloadDto.structuredContent;
        }
        return didiOrderPayloadDto.copy(jsonObject);
    }

    /* renamed from: component1, reason: from getter */
    public final JsonObject getStructuredContent() {
        return this.structuredContent;
    }

    public final DidiOrderPayloadDto copy(JsonObject structuredContent) {
        return new DidiOrderPayloadDto(structuredContent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DidiOrderPayloadDto) && p.d(this.structuredContent, ((DidiOrderPayloadDto) other).structuredContent);
    }

    public final JsonObject getStructuredContent() {
        return this.structuredContent;
    }

    public int hashCode() {
        JsonObject jsonObject = this.structuredContent;
        if (jsonObject == null) {
            return 0;
        }
        return jsonObject.hashCode();
    }

    public String toString() {
        return "DidiOrderPayloadDto(structuredContent=" + this.structuredContent + ")";
    }

    public DidiOrderPayloadDto(JsonObject jsonObject) {
        this.structuredContent = jsonObject;
    }

    public /* synthetic */ DidiOrderPayloadDto(JsonObject jsonObject, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : jsonObject);
    }
}
