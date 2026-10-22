package com.stepos.ailauncher.foundation.credential.api;

import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/foundation/credential/api/ProblemDetailDto;", "", "type", "", "title", "status", "", "detail", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getTitle", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDetail", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/credential/api/ProblemDetailDto;", "equals", "", "other", "hashCode", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ProblemDetailDto {

    @SerializedName("detail")
    private final String detail;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("title")
    private final String title;

    @SerializedName("type")
    private final String type;

    public ProblemDetailDto() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ProblemDetailDto copy$default(ProblemDetailDto problemDetailDto, String str, String str2, Integer num, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = problemDetailDto.type;
        }
        if ((i10 & 2) != 0) {
            str2 = problemDetailDto.title;
        }
        if ((i10 & 4) != 0) {
            num = problemDetailDto.status;
        }
        if ((i10 & 8) != 0) {
            str3 = problemDetailDto.detail;
        }
        return problemDetailDto.copy(str, str2, num, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getStatus() {
        return this.status;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDetail() {
        return this.detail;
    }

    public final ProblemDetailDto copy(String type, String title, Integer status, String detail) {
        return new ProblemDetailDto(type, title, status, detail);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProblemDetailDto)) {
            return false;
        }
        ProblemDetailDto problemDetailDto = (ProblemDetailDto) other;
        return p.d(this.type, problemDetailDto.type) && p.d(this.title, problemDetailDto.title) && p.d(this.status, problemDetailDto.status) && p.d(this.detail, problemDetailDto.detail);
    }

    public final String getDetail() {
        return this.detail;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.status;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.detail;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ProblemDetailDto(type=" + this.type + ", title=" + this.title + ", status=" + this.status + ", detail=" + this.detail + ")";
    }

    public ProblemDetailDto(String str, String str2, Integer num, String str3) {
        this.type = str;
        this.title = str2;
        this.status = num;
        this.detail = str3;
    }

    public /* synthetic */ ProblemDetailDto(String str, String str2, Integer num, String str3, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : num, (i10 & 8) != 0 ? null : str3);
    }
}
