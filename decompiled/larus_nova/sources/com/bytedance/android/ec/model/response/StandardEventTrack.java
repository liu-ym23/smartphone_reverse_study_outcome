package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0017\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\f\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "Ljava/io/Serializable;", "trackParams", "", "", "chainParams", "(Ljava/util/Map;Ljava/util/Map;)V", "getChainParams", "()Ljava/util/Map;", "getTrackParams", "component1", "component2", "copy", "equals", "", "other", "", "getChainParamsMap", "getTrackParamsJSONStr", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class StandardEventTrack implements Serializable {

    @SerializedName("chain_param")
    private final Map<String, String> chainParams;

    @SerializedName("track_param")
    private final Map<String, String> trackParams;

    /* JADX WARN: Multi-variable type inference failed */
    public StandardEventTrack() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StandardEventTrack copy$default(StandardEventTrack r100, Map r101, Map r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.trackParams;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.chainParams;
    L9:
        return r100.copy(r101, r102);
    }

    public final Map<String, String> component1() {
        return this.trackParams;
    }

    public final Map<String, String> component2() {
        return this.chainParams;
    }

    public final StandardEventTrack copy(Map<String, String> r100, Map<String, String> r101) {
        return new StandardEventTrack(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof StandardEventTrack) == false) goto L10;
        StandardEventTrack r101 = (StandardEventTrack) r100;
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.chainParams, r101.chainParams) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Map<String, String> r100 = this.trackParams;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.chainParams;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "StandardEventTrack(trackParams=" + this.trackParams + ", chainParams=" + this.chainParams + ")";
    }

    public final String getTrackParamsJSONStr() {
        Object r100 = null;
        if (this.trackParams != null) goto L15;
        return null;
    L15:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(new JSONObject(this.trackParams).toString());     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r102) == true) goto L14;
        r100 = r102;
    L14:
        return (String) r100;
    L7:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final Map<String, String> getChainParams() {
        return this.chainParams;
    }

    public final Map<String, String> getChainParamsMap() {
        return this.chainParams;
    }

    public final Map<String, String> getTrackParams() {
        return this.trackParams;
    }

    public StandardEventTrack(Map<String, String> r100, Map<String, String> r101) {
        this.trackParams = r100;
        this.chainParams = r101;
    }

    public /* synthetic */ StandardEventTrack(Map r100, Map r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
