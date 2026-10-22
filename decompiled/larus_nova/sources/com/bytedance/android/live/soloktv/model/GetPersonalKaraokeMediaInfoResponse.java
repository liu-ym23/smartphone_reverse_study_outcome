package com.bytedance.android.live.soloktv.model;

import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkmicMediaParam;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/soloktv/model/GetPersonalKaraokeMediaInfoResponse;", "", "linkmicMediaParam", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkmicMediaParam;", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkmicMediaParam;)V", "getLinkmicMediaParam", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkmicMediaParam;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GetPersonalKaraokeMediaInfoResponse implements vh7.h {

    @SerializedName("linkmic_media_param")
    protected LinkmicMediaParam linkmicMediaParam;

    public GetPersonalKaraokeMediaInfoResponse(LinkmicMediaParam r100) {
        this.linkmicMediaParam = r100;
    }

    public static /* synthetic */ GetPersonalKaraokeMediaInfoResponse copy$default(GetPersonalKaraokeMediaInfoResponse r100, LinkmicMediaParam r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.linkmicMediaParam;
    L6:
        return r100.copy(r101);
    }

    public final LinkmicMediaParam component1() {
        return this.linkmicMediaParam;
    }

    public final GetPersonalKaraokeMediaInfoResponse copy(LinkmicMediaParam r100) {
        return new GetPersonalKaraokeMediaInfoResponse(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GetPersonalKaraokeMediaInfoResponse) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.linkmicMediaParam, ((GetPersonalKaraokeMediaInfoResponse) r100).linkmicMediaParam) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        LinkmicMediaParam r100 = this.linkmicMediaParam;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "GetPersonalKaraokeMediaInfoResponse(linkmicMediaParam=" + this.linkmicMediaParam + ")";
    }

    public GetPersonalKaraokeMediaInfoResponse() {
        this.linkmicMediaParam = null;
    }

    public final LinkmicMediaParam getLinkmicMediaParam() {
        return this.linkmicMediaParam;
    }

    public GetPersonalKaraokeMediaInfoResponse(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.linkmicMediaParam = new LinkmicMediaParam(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
        if (this.linkmicMediaParam != null) goto L19;
        this.linkmicMediaParam = null;
        return;
    }

    public /* synthetic */ GetPersonalKaraokeMediaInfoResponse(LinkmicMediaParam r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
