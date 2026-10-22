package com.stepos.ailauncher.foundation.appui.card.provider.didi.api;

import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiOrderResultDto;", "", "ok", "", "result", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiOrderPayloadDto;", "error", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiOrderErrorDto;", "<init>", "(Ljava/lang/Boolean;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiOrderPayloadDto;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiOrderErrorDto;)V", "getOk", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getResult", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiOrderPayloadDto;", "getError", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiOrderErrorDto;", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "(Ljava/lang/Boolean;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiOrderPayloadDto;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiOrderErrorDto;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiOrderResultDto;", "equals", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DidiOrderResultDto {

    @SerializedName("error")
    private final DidiOrderErrorDto error;

    @SerializedName("ok")
    private final Boolean ok;

    @SerializedName("result")
    private final DidiOrderPayloadDto result;

    public DidiOrderResultDto() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ DidiOrderResultDto copy$default(DidiOrderResultDto didiOrderResultDto, Boolean bool, DidiOrderPayloadDto didiOrderPayloadDto, DidiOrderErrorDto didiOrderErrorDto, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = didiOrderResultDto.ok;
        }
        if ((i10 & 2) != 0) {
            didiOrderPayloadDto = didiOrderResultDto.result;
        }
        if ((i10 & 4) != 0) {
            didiOrderErrorDto = didiOrderResultDto.error;
        }
        return didiOrderResultDto.copy(bool, didiOrderPayloadDto, didiOrderErrorDto);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getOk() {
        return this.ok;
    }

    /* renamed from: component2, reason: from getter */
    public final DidiOrderPayloadDto getResult() {
        return this.result;
    }

    /* renamed from: component3, reason: from getter */
    public final DidiOrderErrorDto getError() {
        return this.error;
    }

    public final DidiOrderResultDto copy(Boolean ok, DidiOrderPayloadDto result, DidiOrderErrorDto error) {
        return new DidiOrderResultDto(ok, result, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DidiOrderResultDto)) {
            return false;
        }
        DidiOrderResultDto didiOrderResultDto = (DidiOrderResultDto) other;
        return p.d(this.ok, didiOrderResultDto.ok) && p.d(this.result, didiOrderResultDto.result) && p.d(this.error, didiOrderResultDto.error);
    }

    public final DidiOrderErrorDto getError() {
        return this.error;
    }

    public final Boolean getOk() {
        return this.ok;
    }

    public final DidiOrderPayloadDto getResult() {
        return this.result;
    }

    public int hashCode() {
        Boolean bool = this.ok;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        DidiOrderPayloadDto didiOrderPayloadDto = this.result;
        int iHashCode2 = (iHashCode + (didiOrderPayloadDto == null ? 0 : didiOrderPayloadDto.hashCode())) * 31;
        DidiOrderErrorDto didiOrderErrorDto = this.error;
        return iHashCode2 + (didiOrderErrorDto != null ? didiOrderErrorDto.hashCode() : 0);
    }

    public String toString() {
        return "DidiOrderResultDto(ok=" + this.ok + ", result=" + this.result + ", error=" + this.error + ")";
    }

    public DidiOrderResultDto(Boolean bool, DidiOrderPayloadDto didiOrderPayloadDto, DidiOrderErrorDto didiOrderErrorDto) {
        this.ok = bool;
        this.result = didiOrderPayloadDto;
        this.error = didiOrderErrorDto;
    }

    public /* synthetic */ DidiOrderResultDto(Boolean bool, DidiOrderPayloadDto didiOrderPayloadDto, DidiOrderErrorDto didiOrderErrorDto, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : bool, (i10 & 2) != 0 ? null : didiOrderPayloadDto, (i10 & 4) != 0 ? null : didiOrderErrorDto);
    }
}
