package com.bytedance.android.ec.model.live;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/model/live/t;", "", "", "trackName", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setTrackName", "(Ljava/lang/String;)V", "", "trackParams", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "setTrackParams", "(Ljava/util/Map;)V", "bcmTrackParams", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class t {

    @SerializedName("bcm_track_params")
    private final Map<String, String> bcmTrackParams;

    @SerializedName("track_event")
    private String trackName;

    @SerializedName("track_params")
    private Map<String, String> trackParams;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t) == false) goto L12;
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.trackName, r101.trackName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.bcmTrackParams, r101.bcmTrackParams) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
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
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.bcmTrackParams;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TrackInfo(trackName=" + this.trackName + ", trackParams=" + this.trackParams + ", bcmTrackParams=" + this.bcmTrackParams + ")";
    }

    public t() {
        this.trackName = null;
        this.trackParams = null;
        this.bcmTrackParams = null;
    }

    public final Map<String, String> a() {
        return this.bcmTrackParams;
    }

    public final String b() {
        return this.trackName;
    }

    public final Map<String, String> c() {
        return this.trackParams;
    }
}
