package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/model/response/s1;", "", "", "trackName", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setTrackName", "(Ljava/lang/String;)V", "", "trackParams", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "setTrackParams", "(Ljava/util/Map;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class s1 {

    @SerializedName("track_event")
    private String trackName;

    @SerializedName("track_params")
    private Map<String, String> trackParams;

    public final String a() {
        return this.trackName;
    }

    public final Map<String, String> b() {
        return this.trackParams;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s1) == false) goto L10;
        s1 r101 = (s1) r100;
        if (Intrinsics.areEqual(this.trackName, r101.trackName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.trackName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.trackParams;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TrackInfo(trackName=" + this.trackName + ", trackParams=" + this.trackParams + ")";
    }

    public s1() {
        this.trackName = null;
        this.trackParams = null;
    }

    public final String c() {
        return this.trackName;
    }

    public final Map<String, String> d() {
        return this.trackParams;
    }
}
